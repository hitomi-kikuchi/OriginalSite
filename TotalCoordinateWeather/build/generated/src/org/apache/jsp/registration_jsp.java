package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registration_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    HttpSession hs = request.getSession();
    

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>TCW 新規会員登録page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>User Registration</h1>\n");
      out.write("        <form action=\"Registration\" method=\"POST\">\n");
      out.write("            NAME: <input type=\"text\" name=\"name\">\n");
      out.write("            <br><br>\n");
      out.write("            PASS: <input type=\"password\" name=\"pass\" placeholder=\"4文字以上の英数字\">\n");
      out.write("            <br><br>\n");
      out.write("            AGE: \n");
      out.write("            <select name=\"age\">\n");
      out.write("                <option value=\"\">年代を選択</option>\n");
      out.write("                ");
 for(int i = 1; i < 6; i++) { 
      out.write("\n");
      out.write("                <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <br><br>\n");
      out.write("            PLACE:\n");
      out.write("            <select name=\"place\">\n");
      out.write("                <option value=\"\">よく使う場所を選択</option>\n");
      out.write("                ");
 for(int i = 0; i < 47; i++) { 
      out.write("\n");
      out.write("                <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <br><br>\n");
      out.write("            HAIR LENGTH: \n");
      out.write("            <select name=\"legth\">\n");
      out.write("                <option value=\"\">髪の長さを選択</option>\n");
      out.write("                ");
 for(int i = 0; i < 4; i++) { 
      out.write("\n");
      out.write("                <option value=\"");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</option>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" name=\"register\" value=\"ENTRY\">\n");
      out.write("            ");
      out.write("\n");
      out.write("            <input type=\"hidden\" name=\"ac\" value=\"");
      out.print( hs.getAttribute("ac") );
      out.write("\">\n");
      out.write("        </form>\n");
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
