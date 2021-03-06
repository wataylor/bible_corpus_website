package asst.corpus.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import asst.dbcommon.PUTs;

/** Format a list of rows returned from a database query
 * into a .html response string.
 * @author Material gain
 * @since 2020 11
 *
 */
public class FormatResponseText {

	private static final String NOTFOUND = "Verse missing.";

	/** Format the text to be returned in response to the SQL query
	 * generated based on the Bible reference and list of languages(s).
	 * @param sb accumulates the text
	 * @param rows list of pipe-separated rows from the query.
	 * The first column is the verse number for the row.
	 * @param bcv information about the book, chapter, and verse requested.
	 */
	public static void generateText(StringBuilder sb, List<String> rows,
			BookChapVerse bcv) {
		boolean multi = (bcv.languageCount > 1);
		if (multi) {
			sb.append("<table border=\"1\" cellpadding=\"2\" cellspacing=\"2\">\n");
			sb.append("<th style=\"text-align:center;\" colspan=\""
					+ (bcv.languageCount) + "\">"
					+ bcv.formalReference + "</th></tr>");
		} else {
			sb.append("<p>");
		}
		for (String el : rows) {
			formatOneRow(sb, el);
		}
		if (multi) {
			sb.append("</table>\n");
		} else {
			StringBuilder sb2 = new StringBuilder(bcv.formalReference);
			replaceAll(sb2, " ", "&nbsp;");
			sb.append("&nbsp; <b>" + sb2.toString() + "</b>");
			sb.append("</p>");
		}
	}

	/** Format one row returned from the database into .html for display in
	 * the page.
	 * @param sb the return page is accumulating here
	 * @param element one row of pipe-separated tokens.  The
	 * verse number is the first token followed by one or more verse
	 * text strings.
	 */
	public static void formatOneRow(StringBuilder sb, String element) {
		String[]vs = element.split("\\|");
		if (vs.length < 2) {
			throw new RuntimeException("Malformed result row " + element);
		}
		String sup = " <sup>" + vs[0] + "</sup>";
		if (vs.length == 2) { // Only one verse in the row
			sb.append(sup + versifyString(vs[1]));
		} else {
			sb.append("<tr>");
			for (int i = 1; i<vs.length; i++) {
				sb.append("<td style=\"vertical-align:top\">" + sup
						+ versifyString(vs[i]) + "</td>\n");
			}
			sb.append("</tr>\n");
		}
	}

	/** Make a string suitable for use in a table of verses.  this is needed
	 * because many Bibles omit certain verses.  In that case, the database
	 * table may be either empty or SQL NULL.
	 * @param str verse text which may be empty or have leading or
	 * trailing spaces.
	 * @return the text or an indication that the verse was not in that
	 * corpus member.
	 */
	public static String versifyString(String str) {
		if (PUTs.isStringMTP(str)) { return NOTFOUND; }
		String trim = str.trim();
		if ("NULL".equalsIgnoreCase(trim)) { return NOTFOUND; }
		return trim;
	}
	  /**
	   * Replace all occurrences of s1 in the string with s2
	   * @param sb string to be modified
	   * @param s1 string to be replaced
	   * @param s2 replacement string.  If null, changed to the empty string
	   * @return modified string
	   */
	  public static StringBuilder replaceAll(StringBuilder sb,
						 String s1, String s2) {
	    int ix  = 0;
	    int len = s1.length();
	    if (s2 == null) { s2 = ""; }

	    while ( (ix = sb.indexOf(s1, ix)) >-1) {
	      sb = sb.replace(ix, ix+len, s2);
	      ix += s2.length(); // do not search replacement string
	    }
	    return sb;
	  }

	  /** Read an entire UTF-8 input stream and return its
	   * contents as a string
	   * @param is input stream
	   * @return results of reading the stream
	   * @throws IOException if things go wrong.
	   */
	  public static String slurpStream(InputStream is) throws IOException {
		  StringBuilder sb = new StringBuilder();
		  String aLine;
		  BufferedReader br = new BufferedReader(new InputStreamReader
				  (is, Charset.forName(StandardCharsets.UTF_8.name())));
		  while ( (aLine = br.readLine() ) != null) {
			  sb.append(aLine + "\n");
		  }
		  br.close();
		  return sb.toString();
	  }

}
