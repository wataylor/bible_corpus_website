package asst.corpus.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import asst.dbcommon.PUTs;

/** Either generate .html and send it or send previously-
 * generated .html
 * @author Material Gain
 * @since 2011 11
 *
 */
public class GetBookHTML {

	static String INITIAL_FILE = null;
	static String FINAL_FILE = null;

	static String getInitialFile() throws Exception {
		if (INITIAL_FILE == null) {
			InputStream is = GetBookHTML.class.getResourceAsStream("/asst/corpus/utils/start.html");
			INITIAL_FILE = FormatResponseText.slurpStream(is);
		}
		return INITIAL_FILE;
	}

	static String getFinalFile() throws Exception {
		if (FINAL_FILE == null) {
			InputStream is = GetBookHTML.class.getResourceAsStream("/asst/corpus/utils/end.html");
			FINAL_FILE = FormatResponseText.slurpStream(is);
		}
		return FINAL_FILE;
	}

	/** Either create or dump a .html file which will contain the entire Bible
	 * "Camsa-NT", "3.Camsa_NT" is shorter than many
	 * @param lang the human language
	 * @param tbl the table identifier and column name for the Bible
	 * @param path where .html files are stored
	 * @param conn Database connection in case reading is needed
	 * @return Input stream to the .html file
	 * @throws Exception 
	 */
	public static InputStream getBibleHtml(String lang, String tbl, String path,
			Connection conn) throws Exception {
		String [] s = tbl.split("\\.");
		File file = new File(path + File.separator + s[1] + ".html");
		if (!file.canRead()) { // Write the .html file
			PrintStream ps = new PrintStream(file, "UTF8");
			StringBuilder sb = new StringBuilder(getInitialFile());
			sb = FormatResponseText.replaceAll(sb, "__TITLE__", lang);
			ps.println(sb.toString());

			int oldBook = 0;
			int oldChapter = 0;
			String bookName = "";;
			Statement stmt = conn.createStatement();
			ResultSet res = null;
			String voise;
			String msg;
			String query = "select Book,Chapter,Verse," + s[1] + " from text" + s[0] + " where ID >=";
			sb.setLength(0);
			
			for (int start = 0; start < 40000; start += 2000) {
				msg = query + start + " and ID <(" + start + " + 2000) order by ID";
				System.out.println(msg);
				res = stmt.executeQuery(msg);
				if (res.next()) {
					do {
						voise = res.getString(4);
						if (!PUTs.isStringMTP(voise)) {
							int book = res.getInt(1);
							int chap = res.getInt(2);
							if (oldBook != book) {
								bookName = BookNameAbbrevMap.FormalBookNames[book];
								if (sb.length() > 0) { sb.append(",\n"); }
								sb.append("\"" + BookNameAbbrevMap.FormalBookNames[book] + "\" : "
										+ BookNameAbbrevMap.BookChaptersAndVerses[book]);
								oldBook = book;
								oldChapter = chap;
								ps.println("<tr><th><a href=\"#book\">&#10224;</a></th><th id=\"" + bookName + "\">" + bookName + " Chapter " + res.getString(2) + "</th></tr>");
							} else if (oldChapter != chap) {
								oldChapter = chap;
								ps.println("<tr><th><a href=\"#book\">&#10224;</a></th><th id=\"" + bookName + "_" + res.getString(2) + "\">" + bookName + " Chapter " + res.getString(2) + "</th></tr>");
							}
							msg = "<tr><td class=\"vn\" id=\"" + bookName + "_" + chap + "_" + res.getInt(3) + "\">" + res.getInt(3) + "</td><td class=\"vp\">" + voise + "</td></tr>";
							System.out.println(msg);
							ps.println(msg);
						}
					} while (res.next());
				} else {
					break;
				}
			}
			ps.println("</table>");
			ps.println("<script>");
			ps.println("var babel = {");
			ps.println(sb.toString() + "\n};");
			ps.println(getFinalFile());
			ps.close();
			res.close();
			stmt.close();
		}
		return new FileInputStream(file);
	}

	
}
