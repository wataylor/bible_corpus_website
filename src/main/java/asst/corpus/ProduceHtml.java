package asst.corpus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import asst.MapLanguagesToTables;
import asst.corpus.utils.GetBookHTML;
import asst.dbase.DBProp;
import asst.dbase.DataBase;
import asst.dbcommon.PUTs;

/**
 * Servlet implementation class ProduceHtml
 */
@WebServlet(description = "Generate a .html file containing one translation", urlPatterns = { "/ProduceHtml" })
public class ProduceHtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/** Tells where to write generated .html. It defaults to the
	 * directory on the perennity server.   */
	private static String htmlPath = "/home/perennity/generatedHtml";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduceHtml() {
		super();
	}

	public void init(ServletConfig configuration) {
		ServletContext context;
		String nam;
		Enumeration<String> en;
		File file = new File("./");

		context = configuration.getServletContext();
		String fileRoot = context.getRealPath("/");

		System.out.println(getClass().getSimpleName() + " Init.  Default path "
				+ file.getAbsolutePath() + " context root " + fileRoot);

		en = configuration.getInitParameterNames();
		while (en.hasMoreElements()) {
			nam = en.nextElement();
			System.out.println(nam + " " + configuration.getInitParameter(nam));
		}
	    try {
			ResourceBundle bundle = ResourceBundle.getBundle("Perennity");
			String fileOrg = bundle.getString("file");
			System.out.println("Bundle from " + fileOrg);
			htmlPath = bundle.getString("path");
			System.out.println("Files will be written to " + htmlPath);
	    } catch (Exception e) {
	    	String msg = "Error with resource file Perennity.properties "
	    			+ e.toString();
	    	System.out.println(msg);
	    }
	    System.out.println("Writing to " + htmlPath);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF8");
		response.setContentType("text/html");
		DBProp.PropertyConnection("Perennity");
		try {
			PUTs.anyStatement("SET CHARACTER SET 'utf8'", DataBase.connDB);
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
		String lang = request.getParameter("lang");
		if (PUTs.isStringMTP(lang)) {
			response.getWriter().append("Request must have a lang= parameter to select a translation.");
			return;
		}
		String tbl = MapLanguagesToTables.LANG_2_TABLE.get(lang);
		if (PUTs.isStringMTP(tbl)) {
			response.getWriter().append("Unknown language parameter " + lang + ".");
			return;
		}
		System.out.println("lang " + lang + " tbl " + tbl);
		try {
			InputStream in = GetBookHTML.getBibleHtml(lang, tbl, htmlPath, DataBase.connDB);
			ServletOutputStream  out = response.getOutputStream();
			int length;
			byte[] bytes = new byte[1024];
			while ((length = in.read(bytes)) != -1) {
				out.write(bytes, 0, length);
			}
			in.close();
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
