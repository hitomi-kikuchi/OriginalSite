package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import Model.*;

public final class proposal_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    ArrayList<ProposalDataBeans> wearList = (ArrayList)hs.getAttribute("weardata");
    ProposalDataBeans hair = (ProposalDataBeans)hs.getAttribute("hairdata");
    HistoryDataBeans hdb = (HistoryDataBeans)hs.getAttribute("weatherdata");

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
      out.write("/css/proposal.css\">\n");
      out.write("        <link href=\"./css/lightbox.css\" rel=\"stylesheet\" media=\"all\" type=\"text/css\" >\n");
      out.write("        <!--jQuery-->\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js\"></script>\n");
      out.write("        <script src=\"js/proposal.js\" type=\"text/javascript\"></script>\n");
      out.write("        \n");
      out.write("        <title>提案 Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrap\">\n");
      out.write("        <header>\n");
      out.write("            <ul class=\"header-left\">\n");
      out.write("                <li>");
      out.print( tcwh.top() );
      out.write("</li>\n");
      out.write("                <li>\n");
      out.write("                    <a href=\"choice.jsp\">\n");
      out.write("                        <img src=\"http://test-aflat.com/buttonmaker/images-user/118.240.137.253.gif?1470197688\">\n");
      out.write("                    </a>\n");
      out.write("                </li>\n");
      out.write("                <li>");
      out.print( tcwh.history() );
      out.write("</li>\n");
      out.write("                <li>");
      out.print( tcwh.logout() );
      out.write("</li>\n");
      out.write("            </ul>\n");
      out.write("            <span class=\"header-right\">\n");
      out.write("                ようこそ <a href=\"Mydata\">");
      out.print( udb.getName() );
      out.write("</a> さん\n");
      out.write("            </span>\n");
      out.write("        </header>\n");
      out.write("            <div id=\"contents\">\n");
      out.write("                <center>\n");
      out.write("                    <h1>— Proposal —</h1>      \n");
      out.write("                    <table class=\"weather\">\n");
      out.write("                        <tbody>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Choice</th>\n");
      out.write("                                <th>Temp</th>\n");
      out.write("                                <th>icon</th>\n");
      out.write("                                <th></th>\n");
      out.write("                            </tr>\n");
      out.write("                            <tr>\n");
      out.write("                                <td>\n");
      out.write("                                    <span class=\"location\">");
      out.print( hdb.getLocation() );
      out.write("</span>の天候情報<br>\n");
      out.write("                                    ");
      out.print( tcwh.exItemnum(wearList.get(0).getItem()) );
      out.write("<br>\n");
      out.write("                                    ");
      out.print( tcwh.exTastenum(wearList.get(0).getTaste()) );
      out.write("\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <span class=\"temp_max\">");
      out.print( hdb.getTemp_max() );
      out.write("</span>℃/\n");
      out.write("                                    <span class=\"temp_min\">");
      out.print( hdb.getTemp_min() );
      out.write("</span>℃<br>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    <img src=\"http://openweathermap.org/img/w/");
      out.print( hdb.getIcon() );
      out.write(".png\"><br>\n");
      out.write("                                </td>\n");
      out.write("                                <td>\n");
      out.write("                                    湿度：");
      out.print( hdb.getHumidity() );
      out.write("％<br>\n");
      out.write("                                    風速：");
      out.print( hdb.getSpeed() );
      out.write("m/s\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                                <br><br>\n");
      out.write("                                ");
 for(int i = 0; i < 3; i++) { 
      out.write("\n");
      out.write("                                <a href=\"");
      out.print( wearList.get(i).getWearImg() );
      out.write("\" rel=\"lightbox\">\n");
      out.write("                                    <img class=\"popup\" src=\"");
      out.print( wearList.get(i).getWearImg() );
      out.write("\">\n");
      out.write("                                </a>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                                <a href=\"");
      out.print( hair.getUrl() );
      out.write("\" rel=\"lightbox\">\n");
      out.write("                                    <img src=\"./hair-img/");
      out.print( hair.getHairImg() );
      out.write("\" height=\"350px\">\n");
      out.write("                                </a>\n");
      out.write("                                <br><br>       \n");
      out.write("                </center>\n");
      out.write("            <!--/#contents--></div>\n");
      out.write("            <footer></footer>\n");
      out.write("        <!--/#wrap--></div>\n");
      out.write("                                <script src=\"js/lightbox.js\" type=\"text/javascript\"></script>\n");
      out.write("                                <script>\n");
      out.write("                                    lightbox.option({\n");
      out.write("                                    'fitImagesInViewport' : true,\n");
      out.write("                                    'wrapAround': true\n");
      out.write("                                    });\n");
      out.write("                                </script>\n");
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
