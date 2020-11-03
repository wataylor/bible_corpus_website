package asst.corpus.utils;

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
		}
		for (String el : rows) {
			formatOneRow(sb, el);
		}
		if (multi) {
			sb.append("</table>\n");
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

}
