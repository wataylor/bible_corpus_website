package asst.html;

import java.io.File;
import java.io.InputStream;

import asst.common.CommandArgs;
import asst.corpus.utils.GetBookHTML;
import asst.dbase.DataBase;
import utils.Vbls;

/** Test the program which creates a .html file from a Bible
 * translation.
 * @author Material Gain
 * @since 2011 11
 */
public class CreateHtmlMain {
	static final String[] DEFAULT_ARGS = {
			"path=F:\\MySQLData",
			"outdir=F:\\MySQLData", "-verbose", "+doIt",
			"limit=3", "lang=Camsa-NT", "tbl=3.Camsa_NT",
			"driver=com.mysql.jdbc.Driver",
			"url=jdbc:mysql://localhost/biblecorpus?user=root&useUnicode=yes&characterEncoding=UTF-8",
			"user=NONE", "pass=NONE"
	};

	static Vbls vbls;

	/**
	 * @param args see DEFAULT_ARGS
	 */
	public static void main(String[] args) {
		try {
			CommandArgs cargs = new CommandArgs(DEFAULT_ARGS);
			vbls = new Vbls(cargs, args);
			if (vbls.doIt) {
				vbls.openDB();
			}
			String[] s = ((String)cargs.get("tbl")).split("\\.");
			/* Delete the file in case it is there*/
			File file = new File(vbls.outdir + File.separator + s[1] + ".html");
			if (file.canRead()) {
				file.delete();
			}
			InputStream is = GetBookHTML.getBibleHtml(vbls.lang, (String)cargs.get("tbl"), vbls.outdir, DataBase.connDB);
			is.close();
			DataBase.connDB.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
