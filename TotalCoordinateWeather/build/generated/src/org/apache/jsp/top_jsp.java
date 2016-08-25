package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.*;

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

      out.write('\n');
      out.write('\n');

    HttpSession hs = request.getSession();
    
    UserDataBeans udb = null;
    boolean login = false;
    if(hs.getAttribute("userdata") != null) {
        login = true;
        udb  = (UserDataBeans)hs.getAttribute("userdata");
    }   

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        \n");
      out.write("        <!--css-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/tcw.css\">\n");
      out.write("\n");
      out.write("        <title>TCW TopPage</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrap\">\n");
      out.write("            <header>\n");
      out.write("                <div class=\"header-menu\">\n");
      out.write("                    ");
 if(login){ 
      out.write("\n");
      out.write("                    ");
      out.print( TCWHelper.getInstance().logout() );
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </header>\n");
      out.write("            <div id=\"contents\">\n");
      out.write("                <center>\n");
      out.write("                <h1>— Total Coordinate due to Weather —</h1>\n");
      out.write("                <div class=\"frame top in\">\n");
      out.write("                    ");
 if(login) { 
      out.write("\n");
      out.write("                    <div class=\"loginver\">\n");
      out.write("                        ようこそ <a href=\"Mydata\">");
      out.print( udb.getName() );
      out.write("</a> さん\n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"choice.jsp\">\n");
      out.write("                        <input class=\"submit-button\" type=\"submit\" value=\"Choice\">\n");
      out.write("                    </form>\n");
      out.write("                    <form action=\"History\">\n");
      out.write("                        <input class=\"submit-button\" type=\"submit\" value=\"History\">\n");
      out.write("                    </form>\n");
      out.write("                    ");
 }else { 
      out.write("\n");
      out.write("                    <form action=\"Choice\" method=\"POST\">\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"name\">NAME:</label>\n");
      out.write("                            <input type=\"text\" name=\"name\">\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <label for=\"pass\">PASS:</label>\n");
      out.write("                            <input type=\"password\" name=\"pass\" placeholder=\" 4文字の英数字\">\n");
      out.write("                        </div>\n");
      out.write("                        <input class=\"submit-button\" type=\"submit\" name=\"login\" value=\"LOGIN\">　\n");
      out.write("                        <a href=\"Registration\">新規登録</a> \n");
      out.write("                    </form>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("                <!-- /#main --></div>\n");
      out.write("                </center>\n");
      out.write("            <!--/#contens--></div>\n");
      out.write("            <footer></footer>\n");
      out.write("        <!--/#wrap--></div>\n");
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
