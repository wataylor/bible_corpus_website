package asst.corpus.utils;

import java.util.HashSet;
import java.util.Set;

/** Information about a Bible book, chapter, initial verse, and
 * final verse

 * Copyright (c) 2020 by Advanced Systems and Software Technologies
 * All Rights Reserved

 * @author Material Gain
 * @since 2020 10
 *
 */
public class BookChapVerse {
	/** The book name as entered by the user.  Book names can be
	 * expressed in many ways. I Samuel, Is, 1 S and so on. 
	 */
	public String bookNameFmUser;
	/** Book number 1-66 */
	public int bookNumber;
	/** Chapter number 1 through however many the book has */
	public int chapterNumber;
	/** First verse in the reference */
	public int verseNumber;
	/** Last verse in the reference */
	public int verseTo;
	/** Verse if we want only two verses as in 1:1,3
	 * meaning verses 1 and 3 of chapter 1*/
	public int verseAnd;
	/** Indicate when there is no verse specified as in a verse in
	 * Jude or Philemon which have only one chapter*/
	public boolean noverse;
	
	/** Make a where clause to retrieve all the verses in the reference.
	 * @param colTableList a semicolon-separated list of
	 * table number dot column name for
	 * verses to be retrieved from a mixture of database tables.
	 * @return where string
	 */
	public String makeWhere(String colTableList) {
		StringBuilder sb = new StringBuilder();
		String[] s = colTableList.split(";");
		String[] t = s[0].split("\\.");
		String table = "text" + t[0];
		sb.append(table + ".Book=" + bookNumber + " and " + table + ".Chapter =" + chapterNumber);
		if (verseTo > 0) {
			sb.append(" and (" + table + ".Verse >=" + verseNumber + " and " + table + ".Verse <=" + verseTo + ")");
		} else if (verseAnd > 0) {
			sb.append(" and (" + table + ".Verse =" + verseNumber + " or " + table + ".Verse =" + verseAnd + ")");
		} else {
			sb.append(" and (" + table + ".Verse =" + verseNumber + ")");
		}
		if (s.length > 1) {
			/* A set can have only one instance of a given string. */
			Set<String> tables = new HashSet<String>();
			for (String tb : s) {
				t = tb.split("\\.");
				tables.add("text" + t[0]);
			}
			tables.remove(table);
			for (String tb : tables) {
				sb.append(" AND " + table + ".ID = " + tb + ".ID");
			}
		}
		sb.append(" order by " + table + ".Verse");
		return sb.toString();
	}
}
