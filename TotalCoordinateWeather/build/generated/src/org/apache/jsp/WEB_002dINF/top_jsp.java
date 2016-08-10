package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.TCWHelper;
import Model.UserDataBeans;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    TCWHelper tcwh = TCWHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("userdata");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!--link rel=\"styalesheet\" href=\"style.css\"-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/main.css\">\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("        <!--\n");
      out.write("        header {\n");
      out.write("            background-image: url(http://foollovers.com/mat/stripe/ma02.gif);\n");
      out.write("            height:120px;\n");
      out.write("            width: 100%;\n");
      out.write("            background-repeat: repeat;\n");
      out.write("            top: 0;\n");
      out.write("            \n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        body {\n");
      out.write("            font-family:'メイリオ',Meiryo;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        h1 {\n");
      out.write("            color: #FF7F50;\n");
      out.write("            font-family: Impact,Charcoal;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        #main {\n");
      out.write("            border: solid 2px #808080;\n");
      out.write("            height: 150px;\n");
      out.write("            width: 350px;\n");
      out.write("            padding-top:25px;\n");
      out.write("            border-radius: 25px 25px 25px 25px / 25px 25px 25px 25px;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        footer {\n");
      out.write("            background-image: url(http://foollovers.com/mat/stripe/ma02.gif);\n");
      out.write("            height:120px;\n");
      out.write("            width: 100%;\n");
      out.write("            background-repeat: repeat;\n");
      out.write("            position: absolute;\n");
      out.write("            bottom: 0;\n");
      out.write("        }\n");
      out.write("        -->\n");
      out.write("        </style>\n");
      out.write("        <title>TCW TopPage</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("        </header>\n");
      out.write("    <center>\n");
      out.write("        <h1>Total Coordinate due to Weather</h1>\n");
      out.write("        <br>\n");
      out.write("        <div id=\"main\">\n");
      out.write("        ");
 if(hs.getAttribute("userdata") == null) { 
      out.write("\n");
      out.write("        <form action=\"Choice\" method=\"POST\">\n");
      out.write("            NAME: <input type=\"text\" name=\"name\" ><br>\n");
      out.write("            PASS: <input type=\"password\" name=\"pass\" placeholder=\"4文字の英数字\"><br><br>\n");
      out.write("            <input type=\"submit\" name=\"login\" value=\"LOGIN\">   \n");
      out.write("            <a href=\"Registration\">新規登録</a><br>         \n");
      out.write("        </form>\n");
      out.write("        ");
 }else { 
      out.write("\n");
      out.write("            <a href=\"choice.jsp\">Choice</a><br>\n");
      out.write("            ");
      out.print( tcwh.history() );
      out.write("<br>\n");
      out.write("            ");
      out.print( tcwh.logout() );
      out.write("<br><br>\n");
      out.write("            ようこそ<a href=\"Mydata\">");
      out.print( udb.getName() );
      out.write("</a>さん<br>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        <!-- #main --></div>\n");
      out.write("        <footer></footer>\n");
      out.write("    </center>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
