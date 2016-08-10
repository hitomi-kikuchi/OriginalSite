package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.*;

public final class choice_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    TCWHelper tcwh = TCWHelper.getInstance();
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("userdata");
    ProposalDataBeans pdb = (ProposalDataBeans)hs.getAttribute("season");

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
      out.write("/css/choice.css\">\n");
      out.write("        <!--jQuery-->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/choice.js\"></script>\n");
      out.write("        \n");
      out.write("        <title>条件選択Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <section data-role=\"page\">\n");
      out.write("\t<!-- ヘッダの左側にボタンを表示 -->\n");
      out.write("\t<header data-role=\"header\">\n");
      out.write("\t\t<h1>ヘッダ</h1>\n");
      out.write("\t\t<a href=\"#\">左</a>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t<!-- ヘッダの両端にボタンを表示 -->\n");
      out.write("\t<header data-role=\"header\">\n");
      out.write("\t\t<h1>ヘッダ</h1>\n");
      out.write("\t\t<a href=\"#\">左</a>\n");
      out.write("\t\t<a href=\"#\">右</a>\n");
      out.write("\t</header>\n");
      out.write("\n");
      out.write("\t<!-- ヘッダの右側にボタンを表示 -->\n");
      out.write("\t<header data-role=\"header\">\n");
      out.write("\t\t<h1>ヘッダ</h1>\n");
      out.write("\t\t<a href=\"#\" class=\"ui-btn-right\">右</a>\n");
      out.write("\t</header>\n");
      out.write("\t<!-- フッタにボタンを表示 -->\n");
      out.write("\t<footer data-role=\"footer\" class=\"ui-bar\">\n");
      out.write("\t\t<a href=\"#\">ボタン１</a>\n");
      out.write("\t\t<a href=\"#\">ボタン２</a>\n");
      out.write("\t</footer>\n");
      out.write("\t\n");
      out.write("</section>\n");
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
