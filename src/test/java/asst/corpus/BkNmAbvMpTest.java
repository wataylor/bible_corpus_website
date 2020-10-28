package asst.corpus;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import asst.corpus.utils.BookChapVerse;
import asst.corpus.utils.BookNameAbbrevMap;

/** Test the methods that use the book code, name, and
 * abbreviation maps to create verse references.

 * Copyright (c) 2020 by Advanced Systems and Software Technologies
 * All Rights Reserved

 * @author Material gain
 * @since 2020 10
 *
 */
public class BkNmAbvMpTest {

	/** Define the expected exceptions form bad references. */
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void testReferenceToChapVerse() {
		String where;
		BookChapVerse bcv = BookNameAbbrevMap.referenceToChapVerse("Ge. 1:1-5");
		assertEquals("Ge.", bcv.bookNameFmUser);
		assertEquals(1, bcv.bookNumber);
		assertEquals(1, bcv.chapterNumber);
		assertEquals(1, bcv.verseNumber);
		assertEquals(5, bcv.verseTo);
		assertEquals(0, bcv.verseAnd);
		assertFalse(bcv.noverse);
		where = bcv.makeWhere("0.KJVEnglish");
		assertEquals("text0.Book=1 and text0.Chapter =1 and (text0.Verse >=1 and text0.Verse <=5) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;0.Afrikaans");
		assertEquals("text0.Book=1 and text0.Chapter =1 and (text0.Verse >=1 and text0.Verse <=5) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;1.Arabic");
		assertEquals("text0.Book=1 and text0.Chapter =1 and (text0.Verse >=1 and text0.Verse <=5) AND text0.ID = text1.ID order by text0.Verse", where);

		bcv = BookNameAbbrevMap.referenceToChapVerse("2 S 1:1,5");
		assertEquals("2 S", bcv.bookNameFmUser);
		assertEquals(10, bcv.bookNumber);
		assertEquals(1, bcv.chapterNumber);
		assertEquals(1, bcv.verseNumber);
		assertEquals(0, bcv.verseTo);
		assertEquals(5, bcv.verseAnd);
		assertFalse(bcv.noverse);
		where = bcv.makeWhere("0.KJVEnglish");
		assertEquals("text0.Book=10 and text0.Chapter =1 and (text0.Verse =1 or text0.Verse =5) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;0.Afrikaans");
		assertEquals("text0.Book=10 and text0.Chapter =1 and (text0.Verse =1 or text0.Verse =5) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;1.Arabic");
		assertEquals("text0.Book=10 and text0.Chapter =1 and (text0.Verse =1 or text0.Verse =5) AND text0.ID = text1.ID order by text0.Verse", where);

		bcv = BookNameAbbrevMap.referenceToChapVerse("Philemon 1:1,5");
		assertEquals("Philemon", bcv.bookNameFmUser);
		assertEquals(57, bcv.bookNumber);
		assertEquals(1, bcv.chapterNumber);
		assertEquals(1, bcv.verseNumber);
		assertEquals(0, bcv.verseTo);
		assertEquals(5, bcv.verseAnd);
		assertFalse(bcv.noverse);
		where = bcv.makeWhere("0.KJVEnglish");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =1 or text0.Verse =5) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;0.Afrikaans");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =1 or text0.Verse =5) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;1.Arabic");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =1 or text0.Verse =5) AND text0.ID = text1.ID order by text0.Verse", where);

		bcv = BookNameAbbrevMap.referenceToChapVerse("Philemon 5");
		assertEquals("Philemon", bcv.bookNameFmUser);
		assertEquals(57, bcv.bookNumber);
		assertEquals(1, bcv.chapterNumber);
		assertEquals(5, bcv.verseNumber);
		assertEquals(0, bcv.verseTo);
		assertEquals(0, bcv.verseAnd);
		assertTrue(bcv.noverse);
		where = bcv.makeWhere("0.KJVEnglish");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =5) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;0.Afrikaans");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =5) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;1.Arabic");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =5) AND text0.ID = text1.ID order by text0.Verse", where);

		bcv = BookNameAbbrevMap.referenceToChapVerse("Philemon 5,7");
		assertEquals("Philemon", bcv.bookNameFmUser);
		assertEquals(57, bcv.bookNumber);
		assertEquals(1, bcv.chapterNumber);
		assertEquals(5, bcv.verseNumber);
		assertEquals(0, bcv.verseTo);
		assertEquals(7, bcv.verseAnd);
		assertTrue(bcv.noverse);
		where = bcv.makeWhere("0.KJVEnglish");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =5 or text0.Verse =7) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;0.Afrikaans");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =5 or text0.Verse =7) order by text0.Verse", where);
		where = bcv.makeWhere("0.KJVEnglish;1.Arabic");
		assertEquals("text0.Book=57 and text0.Chapter =1 and (text0.Verse =5 or text0.Verse =7) AND text0.ID = text1.ID order by text0.Verse", where);
}

	/** Make sure that the exception thrown by the book lookup routine
	 * causes a runtime exception in the calling program. 
	 */
	@Test
	public void testReferenceToChapVerseEx() {
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage("Unknown book identifier Unk");
		BookNameAbbrevMap.referenceToChapVerse("Unk 5,7");
	}

	@Test
	public void testFindBookNumber() {
		assertEquals(9, BookNameAbbrevMap.findBookNumber("I Samuel").intValue());
		assertEquals(9, BookNameAbbrevMap.findBookNumber("1 S").intValue());
		assertEquals(10, BookNameAbbrevMap.findBookNumber("II Samuel").intValue());
	}

	@Test
	public void testFindBookNumberEx() {
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage("Unknown book identifier Unk");
		BookNameAbbrevMap.findBookNumber("Unk");
	}

	@Test
	public void testCodeToBookNoEx() {
		exceptionRule.expect(Exception.class);
		exceptionRule.expectMessage("Unknown book code Unk");
		BookNameAbbrevMap.codeToBookNo("Unk");
	}

	@Test
	public void testCodeToBookNo() {
		assertEquals(1, BookNameAbbrevMap.codeToBookNo("GEN").intValue());
		assertEquals(66, BookNameAbbrevMap.codeToBookNo("REV").intValue());
	}

}
