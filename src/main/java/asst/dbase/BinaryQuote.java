/* @name BinaryQuote.java

Quote a potentially binary string for SQL and file use

    Copyright (c) 2003 by Advanced Systems and Software Technologies.
    All Rights Reserved
*/

package asst.dbase;

/**
 * Quote a string which might have binary data in it so that the
 * string can be either written to a file or used in an SQL command.
 * JDBC supports octal character encoding for nulls.

 * @author money
 * @since 2003 07
 */

public class BinaryQuote {

  /** Obligatory constructor.*/
  public BinaryQuote() {
  }

  /** List of characters which must be quoted in MySQL.*/
  public static final String QUOTED_CHARS =
  " '\r\\\n\"(){}[]!@#$%^&*_-+=|:;<>,.?/";

  /** List of quotations for characters in the QUOTED_CHARS list.*/
  public static final String[] QUOTATIONS = {
    " ","\\'","\\r", "\\\\", "\\n", "\\\"", "(", ")", "{", "}", "[", "]",
    "!", "@", "#", "$", "%", "^", "&", "*", "_", "-", "+", "=", "|", ":", ";",
    "<", ">", ",", ".", "?", "/",
  };

  /** Quote special characters including both line ending characters
   * as needed so that the resulting text string can be treated as one
   * line.  MySQL does not permit the TAB character (Octal 11, decimal
   * 9) to be quoted so it is passed along. 
   * @param in Input string which may have quotable characters
   * @return String with all required characters quoted*/
  public static String binaryQuote(String in) {
    StringBuffer sb;
    char ch;
    int i;
    int ix;
    int len;
    /**/
    if (in == null) { return ""; }
    len = in.length();
    sb = new StringBuffer(len);

    for (i=0; i<len; i++) {
      ch = in.charAt(i);
      //if (i < 20) { System.out.println(Integer.toHexString(ch)); }
      if (Character.isLetterOrDigit(ch)) {
	sb.append(ch);
	continue;
      }
      if ( (ix = QUOTED_CHARS.indexOf(ch)) > -1) {
 	sb.append(QUOTATIONS[ix]);
	continue;
      }
      if (ch == 0) {
	sb.append("\\0");	// Quote for null characters
      } else {
	sb.append(ch);
      }

// 	{
// 	octet = Integer.toOctalString(((int)ch) & 0xff);
// 	while (octet.length() < 3) { octet = "0" + octet; }
//  	sb.append("\\" + octet);
//       }
    }
    return sb.toString();
  }

  /** Quote all the quotable characters 
   * @param args ignored*/
  public static void main (String[] args) {
    System.out.println(QUOTED_CHARS);
    System.out.println(BinaryQuote.binaryQuote(QUOTED_CHARS));
  }
}
