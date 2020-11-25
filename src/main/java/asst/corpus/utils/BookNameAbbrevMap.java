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

	/** Map 3-letter book name codes to sequential book numbers */
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

	/** List the formal book names based on the book number */
	public static final String[] FormalBookNames = {
			"unknown", // book number 0
			"Genesis",
			"Exodus",
			"Leviticus",
			"Numbers",
			"Deuteronomy",
			"Joshua",
			"Judges",
			"Ruth",
			"I Samuel",
			"II Samuel",
			"I Kings",
			"II Kings",
			"I Chronicles",
			"II Chronicles",
			"Ezra",
			"Nehemiah",
			"Esther",
			"Job",
			"Psalms",
			"Proverbs",
			"Ecclesiastes",
			"SongofSolomon",
			"Isaiah",
			"Jeremiah",
			"Lamentations",
			"Ezekiel",
			"Daniel",
			"Hosea",
			"Joel",
			"Amos",
			"Obadiah",
			"Jonah",
			"Micah",
			"Nahum",
			"Habbakuk",
			"Zephaniah",
			"Haggai",
			"Zechariah",
			"Malachi",
			"Matthew",
			"Mark",
			"Luke",
			"John",
			"Acts",
			"Romans",
			"I Corinthians",
			"II Corinthians",
			"Galatians",
			"Ephesians",
			"Philippians",
			"Colossians",
			"I Thessalonians",
			"II Thessalonians",
			"I Timothy",
			"II Timothy",
			"Titus",
			"Philemon",
			"Hebrews",
			"James",
			"I Peter",
			"II Peter",
			"I John",
			"II John",
			"III John",
			"Jude",
			"Revelation"
	};

	/** Each element of one of these JavaScript arrays is the
	 * number of verses in each chapter starting with Chapter 1.
	 * The number of numbers in each array gives the number of
	 * chapters.  */
	public static final String[] BookChaptersAndVerses = {
			"unknown",
			"[31,25,24,26,32,22,24,22,29,32,32,20,18,24,21,16,27,33,38,18,34,24,20,67,34,35,46,22,35,43,55,32,20,31,29,43,36,30,23,23,57,38,34,34,28,34,31,22,33,26]",
			"[22,25,22,31,23,30,25,32,35,29,10,51,22,31,27,36,16,27,25,26,36,31,33,18,40,37,21,43,46,38,18,35,23,35,35,38,29,31,43,38]",
			"[17,16,17,35,19,30,38,36,24,20,47,8,59,57,33,34,16,30,37,27,24,33,44,23,55,46,34]",
			"[54,34,51,49,31,27,89,26,23,36,35,16,33,45,41,50,13,32,22,29,35,41,30,25,18,65,23,31,40,16,54,42,56,29,34,13]",
			"[46,37,29,49,33,25,26,20,29,22,32,32,18,29,23,22,20,22,21,20,23,30,25,22,19,19,26,68,29,20,30,52,29,12]",
			"[18,24,17,24,15,27,26,35,27,43,23,24,33,15,63,10,18,28,51,9,45,34,16,33]",
			"[36,23,31,24,31,40,25,35,57,18,40,15,25,20,20,31,13,31,30,48,25]",
			"[22,23,18,22]",
			"[28,36,21,22,12,21,17,22,27,27,15,25,23,52,35,23,58,30,24,42,15,23,29,22,44,25,12,25,11,31,13]",
			"[27,32,39,12,25,23,29,18,13,19,27,31,39,33,37,23,29,33,43,26,22,51,39,25]",
			"[53,46,28,34,18,38,51,66,28,29,43,33,34,31,34,34,24,46,21,43,29,53]",
			"[18,25,27,44,27,33,20,29,37,36,21,21,25,29,38,20,41,37,37,21,26,20,37,20,30]",
			"[54,55,24,43,26,81,40,40,44,14,47,40,14,17,29,43,27,17,19,8,30,19,32,31,31,32,34,21,30]",
			"[17,18,17,22,14,42,22,18,31,19,23,16,22,15,19,14,19,34,11,37,20,12,21,27,28,23,9,27,36,27,21,33,25,33,27,23]",
			"[11,70,13,24,17,22,28,36,15,44]",
			"[11,20,32,23,19,19,73,18,38,39,36,47,31]",
			"[22,23,15,17,14,14,10,17,32,3]",
			"[22,13,26,21,27,30,21,22,35,22,20,25,28,22,35,22,16,21,29,29,34,30,17,25,6,14,23,28,25,31,40,22,33,37,16,33,24,41,30,24,34,17]",
			"[6,12,8,8,12,10,17,9,20,18,7,8,6,7,5,11,15,50,14,9,13,31,6,10,22,12,14,9,11,12,24,11,22,22,28,12,40,22,13,17,13,11,5,26,17,11,9,14,20,23,19,9,6,7,23,13,11,11,17,12,8,12,11,10,13,20,7,35,36,5,24,20,28,23,10,12,20,72,13,19,16,8,18,12,13,17,7,18,52,17,16,15,5,23,11,13,12,9,9,5,8,28,22,35,45,48,43,13,31,7,10,10,9,8,18,19,2,29,176,7,8,9,4,8,5,6,5,6,8,8,3,18,3,3,21,26,9,8,24,13,10,7,12,15,21,10,20,14,9,6]",
			"[33,22,35,27,23,35,27,36,18,32,31,28,25,35,33,33,28,24,29,30,31,29,35,34,28,28,27,28,27,33,31]",
			"[18,26,22,16,20,12,29,17,18,20,10,14]",
			"[17,17,11,16,16,13,13,14]",
			"[31,22,26,6,30,13,25,22,21,34,16,6,22,32,9,14,14,7,25,6,17,25,18,23,12,21,13,29,24,33,9,20,24,17,10,22,38,22,8,31,29,25,28,28,25,13,15,22,26,11,23,15,12,17,13,12,21,14,21,22,11,12,19,12,25,24]",
			"[19,37,25,31,31,30,34,22,26,25,23,17,27,22,21,21,27,23,15,18,14,30,40,10,38,24,22,17,32,24,40,44,26,22,19,32,21,28,18,16,18,22,13,30,5,28,7,47,39,46,64,34]",
			"[22,22,66,22,22]",
			"[28,10,27,17,17,14,27,18,11,22,25,28,23,23,8,63,24,32,14,49,32,31,49,27,17,21,36,26,21,26,18,32,33,31,15,38,28,23,29,49,26,20,27,31,25,24,23,35]",
			"[21,49,30,37,31,28,28,27,27,21,45,13]",
			"[11,23,5,19,15,11,16,14,17,15,12,14,16,9]",
			"[20,32,21]",
			"[15,16,15,13,27,14,17,14,15]",
			"[21]",
			"[17,10,10,11]",
			"[16,13,12,13,15,16,20]",
			"[15,13,19]",
			"[17,20,19]",
			"[18,15,20]",
			"[15,23]",
			"[21,13,10,14,11,15,14,23,17,12,17,14,9,21]",
			"[14,17,18,6]",
			"[25,23,17,25,48,34,29,34,38,42,30,50,58,36,39,28,27,35,30,34,46,46,39,51,46,75,66,20]",
			"[45,28,35,41,43,56,37,38,50,52,33,44,37,72,47,20]",
			"[80,52,38,44,39,49,50,56,62,42,54,59,35,35,32,31,37,43,48,47,38,71,56,53]",
			"[51,25,36,54,47,71,53,59,41,42,57,50,38,31,27,33,26,40,42,31,25]",
			"[26,47,26,37,42,15,60,40,43,48,30,25,52,28,41,40,34,28,41,38,40,30,35,27,27,32,44,31]",
			"[32,29,31,25,21,23,25,39,33,21,36,21,14,23,33,27]",
			"[31,16,23,21,13,20,40,13,27,33,34,31,13,40,58,24]",
			"[24,17,18,18,21,18,16,24,15,18,33,21,14]",
			"[24,21,29,31,26,18]",
			"[23,22,21,32,33,24]",
			"[30,30,21,23]",
			"[29,23,25,18]",
			"[10,20,13,18,28]",
			"[12,17,18]",
			"[20,15,16,16,25,21]",
			"[18,26,17,22]",
			"[16,15,15]",
			"[25]",
			"[14,18,19,16,14,20,28,13,28,39,40,29,25]",
			"[27,26,18,17,20]",
			"[25,25,22,19,14]",
			"[21,22,18]",
			"[10,29,24,21,21]",
			"[13]",
			"[14]",
			"[25]",
			"[20,29,22,11,14,17,17,13,21,11,19,17,18,20,8,21,18,24,21,15,27,21]",
	};

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
			bcv.formalReference = FormalBookNames[bcv.bookNumber] + " "
					+ reference.substring(i+1).trim();

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
