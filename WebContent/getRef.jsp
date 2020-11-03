<%@page import="java.util.List, java.util.ArrayList,
asst.dbcommon.PUTs, asst.dbase.DBProp, asst.dbase.DataBase,
asst.dbase.SQLU,
asst.corpus.utils.BookChapVerse, asst.corpus.utils.BookNameAbbrevMap,
asst.corpus.utils.FormatResponseText
" errorPage="runError.jsp" %><%
response.setCharacterEncoding("UTF8");
List<String> languages = new ArrayList<String>();
StringBuilder sb = new StringBuilder();
BookChapVerse bcv;
String query;
String name = request.getParameter("passage");
String lang = request.getParameter("lang");
    DBProp.PropertyConnection("Perennity");
    try {
  PUTs.anyStatement("SET CHARACTER SET 'utf8'", DataBase.connDB);
 } catch (Exception e) {
  throw new ServletException(e.getMessage());
 }
%> <%
 	// sb.append("Wanted " + name + " " + lang + " " + "<br>\n");
 if (PUTs.isStringMTP(name)) {
 	sb.append("<p>The request must include a scripture reference.</p>");
 } else if (PUTs.isStringMTP(lang)) {
 	sb.append("<p>The request must include at least one translation.</p>");
 } else
 	try {
 		bcv = BookChapVerse.makeQuery(name, lang);
 		List<String> rows = SQLU.vectorizeQuery(bcv.query);
 		if (rows.size() <= 0) {
 	sb.append(
 			"<p>The request did not return any verses.  Do the chapter and verse exist in the specified book?</p>");
 		} else {
 			FormatResponseText.generateText(sb, rows, bcv);
 			System.out.println(sb.toString());
 		}
 	} catch (Exception e) {
 		sb.append(e.getMessage());
 	}
 %>
<%= sb.toString() %>
