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
      out.write("        <title>Prubea de Tabla</title>\n");
      out.write("        <!--Styles-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/flexigrid.pack.css\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"src/flexigrid.css\" type=\"text/css\" />\n");
      out.write("        <!--Js-->\n");
      out.write("        <script src=\"http://code.jquery.com/jquery-1.5.2.min.js\"></script>\n");
      out.write("        <script src=\"src/flexigrid.pack.js\"></script>\n");
      out.write("        <script src=\"src/flexigrid.js\"></script>        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table class=\"flexme2\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th width=\"100\">Actividad de</th>\n");
      out.write("                    <th width=\"100\">Nombre Actividad</th>\n");
      out.write("                    <th width=\"300\">Fecha</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Cuentas</td>\n");
      out.write("                    <td>Jose Angel Bonfil</td>\n");
      out.write("                    <td>2011/11/01</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Cuentas de pepe</td>\n");
      out.write("                    <td>Pepez</td>\n");
      out.write("                    <td>2011/11/01</td>\n");
      out.write("                </tr>\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $('.flexme').flexigrid();\n");
      out.write("            $('.flexme2').flexigrid({\n");
      out.write("                title : 'Tabla Prueba',\n");
      out.write("                width : 'auto',\n");
      out.write("                height : 'auto',\n");
      out.write("                showTableToggleBtn : true,\n");
      out.write("                usepager : true,\n");
      out.write("                searchitems : [ {\n");
      out.write("                        display : 'Actividad de',\n");
      out.write("                        name : 'Actividad de'\n");
      out.write("                    }, {\n");
      out.write("                        display : 'Nombre Actividad',\n");
      out.write("                        name : 'Nombre Actividad',\n");
      out.write("                        isdefault : true\n");
      out.write("                    } ],\n");
      out.write("                striped : false\n");
      out.write("            });\n");
      out.write("            $(\".flexme3\").flexigrid({               \n");
      out.write("                buttons : [ {\n");
      out.write("                        name : 'Add',\n");
      out.write("                        bclass : 'add',\n");
      out.write("                        onpress : test\n");
      out.write("                    }, {\n");
      out.write("                        name : 'Delete',\n");
      out.write("                        bclass : 'delete',\n");
      out.write("                        onpress : test\n");
      out.write("                    }, { separator : true } ],\n");
      out.write("                sortorder : \"asc\",\n");
      out.write("                usepager : true,\n");
      out.write("                title : 'Prueba de FlexGrid',\n");
      out.write("                useRp : true,\n");
      out.write("                rp : 15,\n");
      out.write("                showTableToggleBtn : true,\n");
      out.write("                width : 700,\n");
      out.write("                height : 200\n");
      out.write("            });\n");
      out.write("        </script>\n");
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
