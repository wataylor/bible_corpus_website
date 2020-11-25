package asst.corpus;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		System.out.println("\n" + getClass().getSimpleName() + " Init called. Default path " + file.getAbsolutePath() + " context root " + fileRoot);

		en = configuration.getInitParameterNames();
		while (en.hasMoreElements()) {
			nam = en.nextElement();
			System.out.println(nam + " " + configuration.getInitParameter(nam));
		}
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
		String tbl = request.getParameter("tbl");
		if (PUTs.isStringMTP(lang) || PUTs.isStringMTP(tbl)) {
			response.getWriter().append("Request must have both a lang and a tbl parameter");
			return;
		}
		System.out.println("lang " + lang + " tbl " + tbl);
		try {
			InputStream in = GetBookHTML.getBibleHtml(lang, tbl, "f:/MySQLData", DataBase.connDB);
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
