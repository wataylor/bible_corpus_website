/* @name ConvUtils.java

    Copyright (c) 2009 by Advanced Systems and Software Technologies.
    All Rights Reserved

    Under revision by: $Locker$
    Change Log:
    $Log: $
*/

package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Material Gain
 * @since 2008 01
 */

public class ConvUtils {

  static final long serialVersionUID = 1;

  /** Obligatory constructor.*/
  public ConvUtils() { /* */ }

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

  /**
   * Read a file and return its entire contents in a mutable string
   * @param fileName name of the file
   * @param sb StringBuilder to use if convenient, otherwise the
   * method creates a new string builder
   * @return contents of the file or an error message if the file
   * cannot be read
   * @throws Exception when things go wrong
   */
  public static StringBuilder slurpFile(String fileName, StringBuilder sb)
    throws Exception {
    File file = new File(fileName);
    String aLine;
    BufferedReader br;
    if (sb == null) {
      sb = new StringBuilder((int)file.length());
    } else {
      sb.setLength(0);
    }

    br = new BufferedReader(new FileReader(file));
    while ( (aLine = br.readLine() ) != null) {
      sb.append(aLine + "\n");
    }
    br.close();
    return sb;
  }
}
