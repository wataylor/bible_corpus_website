package asst.corpus.utils;

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
}
