package asst.html;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import asst.common.CommandArgs;
import asst.corpus.utils.BookNameAbbrevMap;
import utils.Vbls;

/** Write a JavaScript hash table of information about all books
 * of the Bible.  The  keys are the formal book
 * names and the values are an array of integers which give the
 * number of verses in each chapter of that book.  The number of
 * integers indicates the number of chapters in the book, and the 
 * number gives the number of verses in the chapter.
 * @author Material Gain
 * @since 20120 11
 */
public class CreateAllBookJSMain {

	static final String[] DEFAULT_ARGS = {
			"path=F:\\",
			"outdir=F:\\MySQLData", "-verbose", "+doIt",
			"limit=3", "lang=placeholder",
			"driver=com.mysql.jdbc.Driver",
			"url=jdbc:mysql://localhost/biblecorpus?user=root&useUnicode=yes&characterEncoding=UTF-8",
			"user=NONE", "pass=NONE"
	};

	static Vbls vbls;

	/**
	 * @param args none except for the output directory
	 */
	public static void main(String[] args) {
		CommandArgs cargs = new CommandArgs(DEFAULT_ARGS);
		vbls = new Vbls(cargs, args);
		PrintStream jsv = null;
		try {
			jsv = new PrintStream(new File(vbls.outdir + File.separator + "bookVerseJSV.txt"), "UTF8");
			bookChapterVerseToStream(jsv);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jsv.close();
		}
	}

	private static void bookChapterVerseToStream(PrintStream jsv) {
		jsv.println("var babel = {");
		for (int i = 1; i<=66; i++) {
			if ((i > 1) && (i <= 66)) {
				jsv.println(",");
			}
			jsv.print("\"" + BookNameAbbrevMap.FormalBookNames[i] + "\" : "
			+ BookNameAbbrevMap.BookChaptersAndVerses[i]);
		}
		jsv.println("\n};");
	}

}
