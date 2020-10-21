package asst.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import asst.dbase.BinaryQuote;

public class BinaryQuoteTest {

	@Test
	public void test() {
		String quoted = BinaryQuote.binaryQuote(BinaryQuote.QUOTED_CHARS);
		String standard = String.join("",  BinaryQuote.QUOTATIONS);
		assertEquals(standard, quoted);
	}

}
