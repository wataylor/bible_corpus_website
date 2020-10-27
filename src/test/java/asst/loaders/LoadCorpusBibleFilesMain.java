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
			"outdir=F:\\MySQLData", "-verbose", "-doIt",
			"limit=3", "lang=placeholder",
	};
	/* Global variables are a sleazy way to avoid passing
	 * lots of method arguments.*/
	static Vbls vbls;
	static int nameCount = 0;
	static PrintStream updates;

	/** Read a list of files and generate insert statements
	 * for each file found.
	 * @param args see DEFAULT_ARGS
	 */
	public static void main(String[] args) {
		CommandArgs cargs = new CommandArgs(DEFAULT_ARGS);
		Consumer<? super Path> csp = a -> handleAFile(a);
		vbls = new Vbls(cargs, args);
		File inputDir = new File(vbls.path);
		if (!inputDir.isDirectory()) {
			System.out.println("path= must specify a directory of corpus input files and outdir= must specify where output files are to be written.");
			System.exit(-1);
		}
		try {
			updates = new PrintStream(new File(vbls.outdir + File.separator + "updates.sql"), "UTF8");
			Files.newDirectoryStream(Paths.get(vbls.path), path -> path.toString().endsWith(".xml")).forEach(csp);
			System.out.println(vbls.bip.howLongSince(false, true));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			updates.close();
		}
	}

	private static void handleAFile(Path file) {
		String tbl;
		String tblNo = null;
		String where;
		String upd;
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

			if (nameCount < 30) {
				tbl = "text0";
				tblNo = "0";
			} else if (nameCount < 60) {
				tbl = "text1";
				tblNo = "1";
			} else {
				tbl = "text2";
				tblNo = "2";
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
								where = "Code=\"" + s[1] + "\" and Chapter = " + s[2] + " and Verse = " + s[3];
							} else if (s.length == 3) {
								where = "Code=\"" + s[0] + "\" and Chapter = " + s[1] + " and Verse = " + s[2];
							} else {
								System.out.println("ERR " + colName + " bad id >" + id + "<");
								continue;
							}
							upd = "update " + tbl + " set " + colName
									+ "=" + Quotable.constructSQLCharacterValue(nNode.getTextContent().trim())
									+ " where " + where + ";";
							updates.println(upd);
						} else {
							System.out.println("ERR " + colName + " missing id or type");
							continue;
						}
					}
				} else {
					System.out.println("ERR " + colName + " not element");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
		System.out.println("Tblno " + tblNo + " col " + colName + " " + vbls.ip.howLongSince(false, true));
		nameCount++;
	}
}
