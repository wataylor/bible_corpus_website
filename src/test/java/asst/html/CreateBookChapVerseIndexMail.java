package asst.html;

import java.io.File;
import java.io.PrintStream;

import asst.common.CommandArgs;
import utils.Vbls;

/** Query the database to find out how many chapters there in each book and how
 * many verses in each chapter.  This information is stored in
 * FormatResonseText to tell how many chapters and verses in each
 * book.
 * @author Material Gain
 * @since 2011 11
 */
public class CreateBookChapVerseIndexMail {

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
	 * @param args see DEFAULT_ARGS
	 */
	public static void main(String[] args) {
		CommandArgs cargs = new CommandArgs(DEFAULT_ARGS);
		vbls = new Vbls(cargs, args);
		PrintStream bindex = null;
		StringBuilder sb = new StringBuilder();
		String query = "";
		try {
			vbls.openDB();
			bindex = new PrintStream(new File(vbls.outdir + File.separator + "bookVerseIndex.txt"), "UTF8");
			for (vbls.bookNo = 1; vbls.bookNo <= 66; vbls.bookNo++ ) {
				sb.setLength(0);
				query = "select count(*) as 'Verses', Chapter, Code from text0 where book = "
						+ vbls.bookNo
						+ " group by Chapter order by Chapter";
				vbls.results = vbls.stmt.executeQuery(query);
				if (vbls.results.next()) {
					sb.append("[" + vbls.results.getString(1));
					if (vbls.results.next()) {
						do {
							sb.append("," + vbls.results.getString(1));
						} while (vbls.results.next());
					}
					vbls.results.close();
					sb.append("]");
					bindex.println(sb.toString());
				} else {
					System.out.println("ERR book # " + vbls.bookNo + " had no verses.");
				}
			}
		} catch (Exception e) {
			System.out.println(query);
			e.printStackTrace();
		} finally {
			bindex.close();
			vbls.closeDB();
		}
	}

}
