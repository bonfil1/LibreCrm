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
      out.write("        <title>JSP Page</title>\n");
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
      out.write("        <script language=\"javascript\" src=\"js/hello.js\"></script>\n");
      out.write("        <!-- /ExtJs Resources -->\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hola Mundo</h1>\n");
      out.write("        <p>Esta es un simple prueba de ExtJs para crear AutoTabs con un MarkUp Simple</p>\n");
      out.write("        <input type=\"button\" id=\"show-btn\" value=\"Hola Mundo\" /><br /><br />\n");
      out.write("\n");
      out.write("        <div id=\"hello-win\" class=\"x-hidden\">\n");
      out.write("            <div class=\"x-window-header\">Hola Dialogo</div>\n");
      out.write("            <div id=\"hello-tabs\">\n");
      out.write("                <!-- Auto create tab 1 -->\n");
      out.write("                <div class=\"x-tab\" title=\"Hola Mundo 1\">\n");
      out.write("                    <p>Hello...</p>\n");
      out.write("                </div>\n");
      out.write("                <!-- Auto create tab 2 -->\n");
      out.write("                <div class=\"x-tab\" title=\"Hola Mundo 2\">\n");
      out.write("\n");
      out.write("                    <p>... World!</p>\n");
      out.write("                </div>\n");
      out.write("                <!-- Auto create tab 3 -->\n");
      out.write("                <div class=\"x-tab\" title=\"Hola Mundo 3\">\n");
      out.write("\n");
      out.write("                    <p>... World!</p>\n");
      out.write("                </div>\n");
      out.write("                <!-- Auto create tab 4 -->\n");
      out.write("                <div class=\"x-tab\" title=\"Hola Mundo 4\">\n");
      out.write("\n");
      out.write("                    <p>... World! 2</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
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
