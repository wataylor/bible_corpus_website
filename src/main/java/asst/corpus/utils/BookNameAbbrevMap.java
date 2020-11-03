package asst.corpus.utils;
import java.util.HashMap;
import java.util.Map;

/** Maintain mappings between Bible book names, book codes, and the
 * book number in the Bible
 * Copyright (c) 2020 by Advanced Systems and Software Technologies
 * All Rights Reserved

 * @author Material Gain
 * @since 2020 10
 */
public class BookNameAbbrevMap {

	/** Map book names and abbreviations to the sequential book number.
	 * This is used for book names entered via the UI. */
	public static Map<String, Integer> bookNumbers = new HashMap<String, Integer>();
	static {
		bookNumbers.put("Genesis", 1);            bookNumbers.put("Ge.", 1);
		bookNumbers.put("Exodus", 2);             bookNumbers.put("Ex.", 2);
		bookNumbers.put("Leviticus", 3);          bookNumbers.put("Le.", 3);
		bookNumbers.put("Lev.", 3);               bookNumbers.put("Le.", 3);
		bookNumbers.put("Numbers", 4);            bookNumbers.put("Nu.", 4);
		bookNumbers.put("Num.", 4);               bookNumbers.put("Nu.", 4);
		bookNumbers.put("Deuteronomy", 5);        bookNumbers.put("De.", 5);
		bookNumbers.put("Deut.", 5);              bookNumbers.put("De.", 5);
		bookNumbers.put("Joshua", 6);             bookNumbers.put("Jos.", 6);
		bookNumbers.put("Judges", 7);             bookNumbers.put("Jud.", 7);
		bookNumbers.put("Ruth", 8);               bookNumbers.put("Ru.", 8);
		bookNumbers.put("I Samuel", 9);           bookNumbers.put("1 S", 9);
		bookNumbers.put("1 Samuel", 9);           bookNumbers.put("I S", 9);
		bookNumbers.put("I Sam.", 9);             bookNumbers.put("1 S", 9);
		bookNumbers.put("II Samuel", 10);         bookNumbers.put("2 S", 10);
		bookNumbers.put("2 Samuel", 10);          bookNumbers.put("II S", 10);
		bookNumbers.put("I Kings", 11);           bookNumbers.put("1 K", 11);
		bookNumbers.put("1 Kings", 11);           bookNumbers.put("I K", 11);
		bookNumbers.put("II Kings", 12);          bookNumbers.put("2 K", 12);
		bookNumbers.put("2 Kings", 12);           bookNumbers.put("II K", 12);
		bookNumbers.put("I Chronicles", 13);      bookNumbers.put("1 Chr.", 13);
		bookNumbers.put("1 Chronicles", 13);      bookNumbers.put("I Chr.", 13);
		bookNumbers.put("I Chron.", 13);          bookNumbers.put("1 Chron.", 13);
		bookNumbers.put("II Chronicles", 14);     bookNumbers.put("2 Chr.", 14);
		bookNumbers.put("2 Chronicles", 14);      bookNumbers.put("II Chr.", 14);
		bookNumbers.put("II Chron.", 14);         bookNumbers.put("2 Chron.", 14);
		bookNumbers.put("Ezra", 15);              bookNumbers.put("Ezr.", 15);
		bookNumbers.put("Nehemiah", 16);          bookNumbers.put("Ne.", 16);
		bookNumbers.put("Neh.", 16);              bookNumbers.put("Ne.", 16);
		bookNumbers.put("Esther", 17);            bookNumbers.put("Est.", 17);
		bookNumbers.put("Job", 18);               bookNumbers.put("Jb.", 18);
		bookNumbers.put("Psalm", 19);             bookNumbers.put("Ps.", 19);
		bookNumbers.put("Proverbs", 20);          bookNumbers.put("Pr.", 20);
		bookNumbers.put("Prov.", 20);             bookNumbers.put("Pr.", 20);
		bookNumbers.put("Ecclesiastes", 21);      bookNumbers.put("Ec.", 21);
		bookNumbers.put("Ecc.", 21);              bookNumbers.put("Ec.", 21);
		bookNumbers.put("Song of Solomon", 22);   bookNumbers.put("Song", 22);
		bookNumbers.put("Isaiah", 23);            bookNumbers.put("Is.", 23);
		bookNumbers.put("Isa.", 23);              bookNumbers.put("Is.", 23);
		bookNumbers.put("Jeremiah", 24);          bookNumbers.put("Je.", 24);
		bookNumbers.put("Jeremiah", 24);          bookNumbers.put("Jer.", 24);
		bookNumbers.put("Lamentations", 25);      bookNumbers.put("Lam.", 25);
		bookNumbers.put("Ezekiel", 26);           bookNumbers.put("Eze.", 26);
		bookNumbers.put("Ezek.", 26);             bookNumbers.put("Eze.", 26);
		bookNumbers.put("Daniel", 27);            bookNumbers.put("Dan.", 27);
		bookNumbers.put("Hosea", 28);             bookNumbers.put("Ho.", 28);
		bookNumbers.put("Hos.", 28);              bookNumbers.put("Ho.", 28);
		bookNumbers.put("Joel", 29);              bookNumbers.put("Jl.", 29);
		bookNumbers.put("Amos", 30);              bookNumbers.put("Am.", 30);
		bookNumbers.put("Obadiah", 31);           bookNumbers.put("Obad.", 31);
		bookNumbers.put("Jonah", 32);             bookNumbers.put("Jona.", 32);
		bookNumbers.put("Micah", 33);             bookNumbers.put("Mi.", 33);
		bookNumbers.put("Nahum", 34);             bookNumbers.put("Na.", 34);
		bookNumbers.put("Habbakuk", 35);          bookNumbers.put("Hab.", 35);
		bookNumbers.put("Zephaniah", 36);         bookNumbers.put("Zep.", 36);
		bookNumbers.put("Haggai", 37);            bookNumbers.put("Hag.", 37);
		bookNumbers.put("Zechariah", 38);         bookNumbers.put("Zec.", 38);
		bookNumbers.put("Zech.", 38);             bookNumbers.put("Zec.", 38);
		bookNumbers.put("Malachi", 39);           bookNumbers.put("Mal.", 39);
		bookNumbers.put("Matthew", 40);           bookNumbers.put("Mt.", 40);
		bookNumbers.put("Matt.", 40);             bookNumbers.put("Mt.", 40);
		bookNumbers.put("Mark", 41);              bookNumbers.put("Mk.", 41);
		bookNumbers.put("Luke", 42);              bookNumbers.put("Lu.", 42);
		bookNumbers.put("John", 43);              bookNumbers.put("Jn.", 43);
		bookNumbers.put("Acts", 44);              bookNumbers.put("Ac.", 44);
		bookNumbers.put("Romans", 45);            bookNumbers.put("Ro.", 45);
		bookNumbers.put("Rom.", 45);              bookNumbers.put("Ro.", 45);
		bookNumbers.put("I Corinthians", 46);     bookNumbers.put("1 Co.", 46);
		bookNumbers.put("1 Corinthians", 46);     bookNumbers.put("I Co.", 46);
		bookNumbers.put("I Cor.", 46);            bookNumbers.put("1 Co.", 46);
		bookNumbers.put("II Corinthians", 47);    bookNumbers.put("2 Co.", 47);
		bookNumbers.put("2 Corinthians", 47);     bookNumbers.put("II Co.", 47);
		bookNumbers.put("II Cor.", 47);           bookNumbers.put("2 Co.", 47);
		bookNumbers.put("Galatians", 48);         bookNumbers.put("Ga.", 48);
		bookNumbers.put("Gal.", 48);              bookNumbers.put("Ga.", 48);
		bookNumbers.put("Ephesians", 49);         bookNumbers.put("Ep.", 49);
		bookNumbers.put("Eph.", 49);              bookNumbers.put("Ep.", 49);
		bookNumbers.put("Eph.", 49);              bookNumbers.put("Ep.", 49);
		bookNumbers.put("Philippians", 50);       bookNumbers.put("Ph.", 50);
		bookNumbers.put("Phil.", 50);             bookNumbers.put("Ph.", 50);
		bookNumbers.put("Colossians", 51);        bookNumbers.put("Col.", 51);
		bookNumbers.put("I Thessalonians", 52);   bookNumbers.put("1 Th.", 52);
		bookNumbers.put("1 Thessalonians", 52);   bookNumbers.put("I Th.", 52);
		bookNumbers.put("I Thes.", 52);           bookNumbers.put("1 Th.", 52);
		bookNumbers.put("II Thessalonians", 53);  bookNumbers.put("2 Th.", 53);
		bookNumbers.put("2 Thessalonians", 53);   bookNumbers.put("II Th.", 53);
		bookNumbers.put("II Thes.", 53);          bookNumbers.put("2 Th.", 53);
		bookNumbers.put("I Timothy", 54);         bookNumbers.put("1 Ti.", 54);
		bookNumbers.put("1 Timothy", 54);         bookNumbers.put("I Ti.", 54);
		bookNumbers.put("II Timothy", 55);        bookNumbers.put("2 Ti.", 55);
		bookNumbers.put("2 Timothy", 55);         bookNumbers.put("II Ti.", 55);
		bookNumbers.put("Titus", 56);             bookNumbers.put("Tit.", 56);
		bookNumbers.put("Philemon", 57);          bookNumbers.put("Phm.", 57);
		bookNumbers.put("Hebrews", 58);           bookNumbers.put("He.", 58);
		bookNumbers.put("Heb.", 58);              bookNumbers.put("He.", 58);
		bookNumbers.put("James", 59);             bookNumbers.put("Ja.", 59);
		bookNumbers.put("I Peter", 60);           bookNumbers.put("1 Pe.", 60);
		bookNumbers.put("1 Peter", 60);           bookNumbers.put("I Pe.", 60);
		bookNumbers.put("I Pet.", 60);            bookNumbers.put("1 Pe.", 60);
		bookNumbers.put("II Peter", 61);          bookNumbers.put("2 Pe.", 61);
		bookNumbers.put("2 Peter", 61);           bookNumbers.put("II Pe.", 61);
		bookNumbers.put("II Pet.", 61);           bookNumbers.put("2 Pe.", 61);
		bookNumbers.put("I John", 62);            bookNumbers.put("1 Jn.", 62);
		bookNumbers.put("1 John", 62);            bookNumbers.put("I Jn.", 62);
		bookNumbers.put("II John", 63);           bookNumbers.put("2 Jn.", 63);
		bookNumbers.put("2 John", 63);            bookNumbers.put("II Jn.", 63);
		bookNumbers.put("III John", 64);          bookNumbers.put("3 Jn.", 64);
		bookNumbers.put("3 John", 64);            bookNumbers.put("III Jn.", 64);
		bookNumbers.put("Jude", 65);              bookNumbers.put("Jude", 65);
		bookNumbers.put("Revelation", 66);        bookNumbers.put("Rev.", 66);
		bookNumbers.put("Revelation", 66);        bookNumbers.put("Re.", 66);
	}

	/** May 3-letter book name codes to sequential book numbers */
	public static Map<String, Integer> bookCodes = new HashMap<String, Integer>();
	static {
		bookCodes.put("GEN", 1);
		bookCodes.put("EXO", 2);
		bookCodes.put("LEV", 3);
		bookCodes.put("NUM", 4);
		bookCodes.put("DEU", 5);
		bookCodes.put("JOS", 6);
		bookCodes.put("JDG", 7);

		bookCodes.put("RTH", 8);
		bookCodes.put("RUT", 8);

		bookCodes.put("SA1", 9);
		bookCodes.put("SA2", 10);
		bookCodes.put("KI1", 11);
		bookCodes.put("KI2", 12);
		bookCodes.put("CH1", 13);
		bookCodes.put("CH2", 14);

		bookCodes.put("1SA", 9);
		bookCodes.put("2SA", 10);
		bookCodes.put("1KI", 11);
		bookCodes.put("2KI", 12);
		bookCodes.put("1CH", 13);
		bookCodes.put("2CH", 14);

		bookCodes.put("EZR", 15);
		bookCodes.put("NEH", 16);
		bookCodes.put("EST", 17);
		bookCodes.put("JOB", 18);
		bookCodes.put("PSA", 19);
		bookCodes.put("PRO", 20);
		bookCodes.put("ECC", 21);
		bookCodes.put("SON", 22);
		bookCodes.put("ISA", 23);
		bookCodes.put("JER", 24);
		bookCodes.put("LAM", 25);
		bookCodes.put("EZE", 26);
		bookCodes.put("DAN", 27);
		bookCodes.put("HOS", 28);
		bookCodes.put("JOE", 29);
		bookCodes.put("AMO", 30);
		bookCodes.put("OBA", 31);
		bookCodes.put("JON", 32);
		bookCodes.put("MIC", 33);
		bookCodes.put("NAH", 34);
		bookCodes.put("HAB", 35);
		bookCodes.put("ZEP", 36);
		bookCodes.put("HAG", 37);
		bookCodes.put("ZEC", 38);
		bookCodes.put("MAL", 39);
		bookCodes.put("MAT", 40);
		bookCodes.put("MAR", 41);
		bookCodes.put("LUK", 42);
		bookCodes.put("JOH", 43);
		bookCodes.put("ACT", 44);
		bookCodes.put("ROM", 45);

		bookCodes.put("CO1", 46);
		bookCodes.put("CO2", 47);
		bookCodes.put("1CO", 46);
		bookCodes.put("2CO", 47);

		bookCodes.put("GAL", 48);
		bookCodes.put("EPH", 49);
		bookCodes.put("PHI", 50);
		bookCodes.put("COL", 51);

		bookCodes.put("TH1", 52);
		bookCodes.put("TH2", 53);
		bookCodes.put("TI1", 54);
		bookCodes.put("TI2", 55);
		bookCodes.put("1TH", 52);
		bookCodes.put("2TH", 53);
		bookCodes.put("1TI", 54);
		bookCodes.put("2TI", 55);

		bookCodes.put("TIT", 56);
		bookCodes.put("PHM", 57);
		bookCodes.put("HEB", 58);
		bookCodes.put("JAM", 59);

		bookCodes.put("PE1", 60);
		bookCodes.put("PE2", 61);
		bookCodes.put("JO1", 62);
		bookCodes.put("JO2", 63);
		bookCodes.put("JO3", 64);
		bookCodes.put("1PE", 60);
		bookCodes.put("2PE", 61);
		bookCodes.put("1JO", 62);
		bookCodes.put("2JO", 63);
		bookCodes.put("3JO", 64);

		bookCodes.put("JUD", 65);
		bookCodes.put("REV", 66);
	}

	/** Convert a reference string to a BookChapVerse object or
	 * throw a runtime exception.
	 * @param reference Reference string in various formats
	 * @return BookChapVerse object or throw runtime exception.
	 */
	public static BookChapVerse referenceToChapVerse(String reference) {
		BookChapVerse bcv = new BookChapVerse();
		int i;
		int ix;
		int addendum = 0;
		char ch;

		try {
			ix = reference.indexOf(":");
			if (ix < 0) {
				ix = reference.lastIndexOf(".");
			}
			if ( ix < 0) {
				ix = reference.length();
				bcv.noverse = true;
			} else {
				bcv.noverse = false;
			}

			i = ix-1;			// Before the colon if there is one
			while (Character.isDigit(reference.charAt(i))) { i--; }
			bcv.chapterNumber = Integer.parseInt(reference.substring(i+1, ix));

			if (bcv.noverse && (!Character.isSpaceChar(reference.charAt(i)))) {
				ch = reference.charAt(i);
				if (ch == '-') { bcv.verseTo  = bcv.chapterNumber; }
				if (ch == ',') { bcv.verseAnd = bcv.chapterNumber; }
				while (!Character.isDigit(reference.charAt(i))) { i--; }
				ix = i+1;
				while (Character.isDigit(reference.charAt(i))) { i--; }
				bcv.chapterNumber = Integer.parseInt(reference.substring(i+1, ix));
			}

			while (Character.isSpaceChar(reference.charAt(i))) { i--; }
			bcv.bookNameFmUser = reference.substring(0, i+1);
			bcv.bookNumber = findBookNumber(bcv.bookNameFmUser);

			if (bcv.noverse) {
				bcv.verseNumber   = bcv.chapterNumber;
				bcv.chapterNumber = 1;
			} else {
				i = ix + 1;		// After the colon

				while ((i < reference.length()) &&
						Character.isDigit(reference.charAt(i))) { i++; }
				bcv.verseNumber = Integer.parseInt(reference.substring(ix+1, i));

				if (i < reference.length()) {
					ch = reference.charAt(i);
					i++;
					while ((i < reference.length()) &&
							!Character.isDigit(reference.charAt(i))) { i++; }
					if (i < reference.length()) {
						addendum = Integer.parseInt(reference.substring(i));
					}
					if (ch == '-') { bcv.verseTo  = addendum; }
					if (ch == ',') { bcv.verseAnd = addendum; }
				}
			}
		} catch (Exception e) {	// Most likely number format exception
			//System.out.println(e.toString());
			//e.printStackTrace();
			throw new RuntimeException(e.getMessage());		// Something went wrong, no verse
		}
		return bcv;
	}

	/**
	 * @param bookIdentifier string which must match one of the keys
	 * in bookNumbers;
	 * @return Bible book number 1-66 or throw an exception.
	 */
	public static Integer findBookNumber(String bookIdentifier) {
		Integer ret = bookNumbers.get(bookIdentifier);
		if (ret == null) {
			throw new RuntimeException("Unknown book identifier " + bookIdentifier);
		}
		return ret;
	}

	/** Convert a 3-character book code to the book number
	 * @param code Book code - GEN through REV
	 * @return book number in the Bible or throw a runtime exception
	 */
	public static Integer codeToBookNo(String code) {
		Integer bookNo = bookCodes.get(code);
		if (bookNo != null) {return bookNo; }
		throw new RuntimeException("Unknown book code " + code);		
	}
}
