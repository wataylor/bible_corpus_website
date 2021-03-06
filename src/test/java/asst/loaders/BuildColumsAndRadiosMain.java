package asst.loaders;

import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

import asst.common.CommandArgs;
import utils.ConvUtils;
import utils.Vbls;

/** Create column creation statements, radio buttons, and 
 * checkboxes for each Bible version found in the corpus
 * folder defined by path.  Files are written to outdir.
 * @author Material Gain
 * @since 2020 10
 *
 */
public class BuildColumsAndRadiosMain {
	static final String[] DEFAULT_ARGS = {
		"path=F:\\git\\bible-corpus\\bibles",
		"outdir=F:\\MySQLData", "+verbose", "-doIt",
		"limit=3", "lang=placeholder",
	};
	/* Global variables are a sleazy way to avoid passing
	 * lots of method arguments.*/
	static Vbls vbls;
	static PrintStream alterTable = null;
	static PrintStream radios = null;
	static PrintStream checkboxes= null;
	static PrintStream nameTables = null;
	static int nameCount = 0;
	static String RADIO_FOR_ENGLISH = "<label><input type=\"radio\" name=\"lang\" value=\"0.KJVEnglish\"/ checked>KJV English</label>";
	static String BOX_FOR_ENGLISH = "<label><input type=\"checkbox\" name=\"0.KJVEnglish\" title=\"KJV English in parallel\">KJV English</label>";
	static String MAP_FOR_ENGLISH = "LANG_2_TABLE.put(\"KJV English\", \"0.KJVEnglish\");";

	/** Read a list of files and generate alter table commands,
	 * radio buttons, and checkboxes for each file found.
	 * @param args see DEFAULT_ARGS
	 */
	public static void main(String[] args) {
		CommandArgs cargs = new CommandArgs(DEFAULT_ARGS);
		Consumer<? super Path> csp = a -> handleAFile(a);
		vbls = new Vbls(cargs, args);
		File inputDir = new File(vbls.path);
		File outputDir = new File(vbls.outdir);
		if (!inputDir.isDirectory() || !outputDir.isDirectory()) {
			System.out.println("path= must specify a directory of corpus input files and outdir= must specify where output files are to be written.");
			System.exit(-1);
		}
		try {
			alterTable = new PrintStream(new File(vbls.outdir + File.separator + "alterTables.sql"), "UTF8");
			/* html does not have an include capability so these files
			 * will be pasted into indx.html.  */
			radios = new PrintStream(new File(vbls.outdir + File.separator + "radios.txt"), "UTF8");
			radios.println(RADIO_FOR_ENGLISH);
			checkboxes = new PrintStream(new File(vbls.outdir + File.separator + "checkboxes.txt"), "UTF8");
			checkboxes.println(BOX_FOR_ENGLISH);
			nameTables = new PrintStream(new File(vbls.outdir + File.separator + "nameMapper.txt"), "UTF8");
			nameTables.println(MAP_FOR_ENGLISH);
			Files.newDirectoryStream(Paths.get(vbls.path), path -> path.toString().endsWith(".xml")).forEach(csp);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (alterTable != null) { alterTable.close(); }
			if (radios != null) { radios.close(); }
			if (checkboxes != null) { checkboxes.close(); }
		}
	}

	/* Handle one file.  */
	static void handleAFile(Path file) {
		StringBuilder sb = new StringBuilder(file.getFileName().toString());
		sb = ConvUtils.replaceAll(sb, ".xml", "");
		String pureName = sb.toString();
		sb = ConvUtils.replaceAll(sb, "'", "_");
		sb = ConvUtils.replaceAll(sb, "-", "_");
		String fName = sb.toString();
		//System.out.println(fName);
		String alt = "alter table names add column " + fName + " varchar(20) DEFAULT NULL;";
		// System.out.println(alt);
		alterTable.println(alt);

		/* This table numbering logic must be precisely duplicated
		 * in the program LoadCorpusBibleFilesMain.*/
		String tblNo = String.valueOf((5 * (nameCount / 5)) / 5);
		String tbl = "text" + tblNo;
		alt = "alter table " + tbl + " add column " + fName + " mediumtext CHARACTER SET utf8;";
		System.out.println(alt);
		alterTable.println(alt);

		alt = "<label><input type=\"radio\" name=\"lang\" value=\"" + tblNo + "." + fName + "\"/>" + pureName + "</label>";
		radios.println(alt);
		alt = "<label><input type=\"checkbox\" name=\"" + tblNo + "." + fName + "\" title=\"" + pureName + " in parallel\">" + pureName + "</label>";
		checkboxes.println(alt);
		alt = "LANG_2_TABLE.put(\"" + pureName + "\", \"" + tblNo + "." + fName + "\");";
		nameTables.println(alt);
		nameCount++;
	}
}
