package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
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
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Prueba Login</title>\n");
      out.write("\n");
      out.write("        <!-- ExtJs Resources -->\n");
      out.write("\n");
      out.write("        <!-- CSS -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/ext-all.css\" />\n");
      out.write("        <!-- Common Styles for the examples -->\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"shared/examples.css\" />\n");
      out.write("        <style type=\"text/css\">\n");
      out.write("            .x-panel-body p {\n");
      out.write("                margin:10px;\n");
      out.write("                font-size:12px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- GC -->\n");
      out.write("        <!-- LIBS -->\n");
      out.write("        <script type=\"text/javascript\" src=\"adapter/ext/ext-base.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- ENDLIBS -->\n");
      out.write("        <script type=\"text/javascript\" src=\"js/ext-all.js\"></script>\n");
      out.write("        <script language=\"javascript\" src=\"js/register.js\"></script>\n");
      out.write("        <!-- /ExtJs Resources -->\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World, ExtJs! </h1>\n");
      out.write("        <table width=\"100%\" align=\"center\">\n");
      out.write("            <tr>\n");
      out.write("                <td width=\"100%\" align=\"center\" style=\"padding-top:100px;\">\n");
      out.write("                    <div id=\"mydiv\"></div>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
