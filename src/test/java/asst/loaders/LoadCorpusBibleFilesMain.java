package asst.loaders;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import asst.common.CommandArgs;
import asst.corpus.utils.BookNameAbbrevMap;
import asst.dbase.Quotable;
import asst.dbcommon.PUTs;
import utils.ConvUtils;
import utils.Vbls;

/** Read all the .xml files in a directory and create insert statements
 * to load book names and verses into the correct database
 * tables.
 * @author Material Gain
 * @since 2020 10
 *
 */
public class LoadCorpusBibleFilesMain {
	static final String[] DEFAULT_ARGS = {
			"path=F:\\git\\bible-corpus\\bibles",
			"outdir=F:\\MySQLData", "-verbose", "+doIt",
			"limit=3", "lang=placeholder",
			"driver=com.mysql.jdbc.Driver",
			"url=jdbc:mysql://localhost/biblecorpus?user=root&useUnicode=yes&characterEncoding=UTF-8",
			"user=NONE", "pass=NONE"
	};
	/* Global variables are a sleazy way to avoid passing
	 * lots of method arguments.*/
	static Vbls vbls;
	static int nameCount = 0;
	static String priorTable = "";
	static int currentTable;
	static PrintStream updates = null;
	static PrintStream insertStats = null;
	static PrintStream objections = null;
	static String msg = null;

	/** Read a list of files and generate insert statements
	 * for each file found.
	 * @param args see DEFAULT_ARGS
	 */
	public static void main(String[] args) {
		CommandArgs cargs = new CommandArgs(DEFAULT_ARGS);
		Consumer<? super Path> csp = a -> handleAFile(a);
		vbls = new Vbls(cargs, args);
		if (vbls.doIt) {
			vbls.openDB();
		}
		File inputDir = new File(vbls.path);
		if (!inputDir.isDirectory()) {
			System.out.println("path= must specify a directory of corpus input files and outdir= must specify where output files are to be written.");
			System.exit(-1);
		}
		try {
			insertStats = new PrintStream(new File(vbls.outdir + File.separator + "insertStats.txt"), "UTF8");
			Files.newDirectoryStream(Paths.get(vbls.path), path -> path.toString().endsWith(".xml")).forEach(csp);
			msg = "Total time " + vbls.bip.howLongSince(false, true);
			insertStats.println(msg);
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			updates.close();
			insertStats.close();
			if (vbls.doIt) {
				vbls.closeDB();
			}
		}
	}

	private static void handleAFile(Path file) {
		String tbl = null;
		String tblNo = null;
		String where;
		String upd = null;
		String orig;
		String verse;
		int offset;
		Integer bookNo;
		java.sql.ResultSet res;
		int insCount = 0;
		StringBuilder sb = new StringBuilder(file.getFileName().toString());
		sb = ConvUtils.replaceAll(sb, ".xml", "");
		// String pureName = sb.toString();
		sb = ConvUtils.replaceAll(sb, "'", "_");
		sb = ConvUtils.replaceAll(sb, "-", "_");
		String colName = sb.toString();

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file.toFile());
			doc.getDocumentElement().normalize();

			/* This table numbering logic must be precisely duplicated
			 * in the program BuildColumnsAndRadiosMain.*/
			tblNo = String.valueOf((5 * (nameCount / 5)) / 5);
			tbl = "text" + tblNo;

			if (!tblNo.equals(priorTable)) {
				if (updates != null) {
					updates.close();
				}
				updates = new PrintStream(new File(vbls.outdir + File.separator + "updates" + tblNo + ".sql"), "UTF8");
				priorTable = tblNo;
			}

			/* Walk all the corpus seg list for each verse*/
			NodeList nList = doc.getElementsByTagName("seg");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (vbls.verbose) {
					System.out.println("Node :"
							+ nNode.getNodeName() + " "
							+ nNode.getNodeType() + " "
							+ nNode.getTextContent().trim());
				}
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					String type;
					String id;
					if (nNode.hasAttributes()) {
						type = id = null;
						// get attributes names and values
						NamedNodeMap nodeMap = nNode.getAttributes();
						for (int i = 0; i < nodeMap.getLength(); i++) {
							Node node = nodeMap.item(i);
							if ("type".equals(node.getNodeName())) {
								type = node.getNodeValue();
							} else if ("id".equals(node.getNodeName())) {
								id = node.getNodeValue();
							} else {
								System.out.println("ERR Unknown attr name : "
										+ node.getNodeName() + " >"
										+ node.getNodeValue() + "<");
							}
						}
						if (!PUTs.isStringMTP(type) && !PUTs.isStringMTP(id)) {
							String [] s = id.split("\\.");
							if (s.length == 4) {
								offset = 1;
							} else if (s.length == 3) {
								offset = 0;
							} else {
								msg = "ERR " + colName + " bad id >" + id + "<";
								insertStats.println(msg);
								System.out.println(msg);
								object(colName, msg);
								continue;
							}
							bookNo = BookNameAbbrevMap.bookCodes.get(s[offset]);
							if (bookNo == null) {
								msg = "ERR " + colName + " bad book code >" + s[offset] + "< " + id;
								insertStats.println(msg);
								object(colName, msg);
								continue;
							}
							where = "Book = " + bookNo + " and Chapter = " + s[offset + 1] + " and Verse = " + s[offset + 2];
							verse = nNode.getTextContent().trim();
							res = vbls.stmt.executeQuery("select " + colName + " from " + tbl + " where " + where);
							if (!res.next()) {
								msg = "Nothing " + colName + " from " + tbl + " where " + where + " " + id;
								object(colName, msg);
							} else {
								orig = res.getString(1);
								if (orig == null) {
/*
									msg = "ERR Not Written " + colName + " from " + tbl + " where " + where;
									insertStats.println(msg);
*/
								} else if (!verse.contentEquals(orig)) {
									msg = "Not Same " + colName + " from " + tbl + " where " + where + " " + id;
									object(colName, msg);
								}
							}
							res.close();
							upd = "update " + tbl + " set " + colName
									+ "=" + Quotable.constructSQLCharacterValue(verse)
									+ " where " + where;
							updates.println(upd + ";");
							if (vbls.doIt) {
								PUTs.anyStatement(upd, vbls.stmt);
							}
							insCount++;
						} else {
							System.out.println("ERR " + colName + " missing id or type");
							continue;
						}
					}
				} else {
					msg = "ERR " + colName + " not element";
					System.out.println(msg);
					insertStats.println(msg);
					object(colName, msg);
				}
			}
		} catch (Exception e) {
			insertStats.println("ERR " + upd + " " + e.getMessage());
		}
		msg = "select count(*) from " + tbl + " where "
				+ colName + " is not null;"
				+ " inserts " + insCount + " "
				+ vbls.ip.howLongSince(false, true);
		insertStats.println(msg);
		System.out.println(msg);
		nameCount++;
		if (objections != null) {
			objections.close();
			objections = null;
		}
	}

	/** Generate a file-specific error message
	 * @param table column name
	 * @param whine text
	 * @throws Exception if the stream doesn't open
	 */
	public static void object(String table, String whine) throws Exception {
		if (objections == null) {
			objections = new PrintStream(new File(vbls.outdir + File.separator + table + ".txt"), "UTF8");
		}
		objections.println(whine);
	}
}
