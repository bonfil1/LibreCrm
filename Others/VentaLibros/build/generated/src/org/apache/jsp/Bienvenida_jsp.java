package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Bienvenida_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-18\">\n");
      out.write("        <meta name=\"autor\"        Content=\"Jose Angel Bonfil\">\n");
      out.write("        <meta name=\"copyright\"    Content=\"(c) 2010\">\n");
      out.write("        <title>Libros.com   |   Bienvenido</title>\n");
      out.write("\n");
      out.write("        <!--Styles-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/slide-style.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("       \n");
      out.write("\n");
      out.write("        <!--Scripts-->\n");
      out.write("        <script type=\"text/javascript\">var _siteRoot='Bienvenida.jsp',_root='Bienvenida.jsp';</script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/scripts.js\"></script>\n");
      out.write("        \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <form action=\"/VentaLibros/SvLibros\" method=post>\n");
      out.write("        <div id=\"main\">\n");
      out.write("            <div id=\"top\"></div>\n");
      out.write("            <!-- header begins -->\n");
      out.write("            <div id=\"header\">\n");
      out.write("                <div id=\"buttons\">\n");
      out.write("                    ");
      out.write("\n");
      out.write("\n");
      out.write("                    <table border=\"0\">\n");
      out.write("                        <tr>\n");
      out.write("                            <td><font face=\"Verdana,Helvetica\" size=\"2\"><b>Busqueda por:</b></font>&nbsp;</td>\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            <td><select size=\"1\" name='opcion'>\n");
      out.write("                                    <option value=\"1\">Título del libro</option>\n");
      out.write("                                    <option value=\"2\">Autor del libro</option>\n");
      out.write("                                    <option value=\"3\">Editorial del libro</option>\n");
      out.write("                                    <option value=\"4\">Categoría del libro</option>\n");
      out.write("                                    <option selected value=\"5\">Todos los libros disponibles </option>\n");
      out.write("                                </select>&nbsp;</td>\n");
      out.write("                            <td><font face=\"Verdana,Helvetica\" size=\"2\"><b>Buscar:</b></font>&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                            <td><input type='text' name='busqueda' size='50' style=\"height: 22px; font-size: 14pt;\">&nbsp;</td>\n");
      out.write("                            <td><input type = \"image\" src = \"images/icons/buscar1.png\" width = \"25px\" height = \"25px\" name=\"boton\" value='Buscar'></td>\n");
      out.write("                            <td><input type = \"image\" src = \"images/icons/help1.png\" width = \"25px\" height = \"25px\" name=\"boton\" value=\"Ayuda\"></td>\n");
      out.write("                            <td><input type = \"reset\" class=\"boton-res\" value=\"&nbsp;&nbsp;&nbsp;\"></td>\n");
      out.write("                            <td><input type = \"image\" src = \"images/icons/home1.png\" width = \"25px\" height = \"25px\" name=\"boton\" value=\"Inicio\"></td>\n");
      out.write("                            <!--<input type=\"submit\" name='boton' value='Buscar'>&nbsp;&nbsp;\n");
      out.write("                            <input type=\"reset\">\n");
      out.write("                            <input type=\"submit\" name='boton' value='Ayuda'>-->\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- header ends -->\n");
      out.write("\n");
      out.write("            <!--/Slide-presentation-->\n");
      out.write("            <div id=\"header\"><div class=\"wrap\">\n");
      out.write("                    <div id=\"slide-holder\">\n");
      out.write("                        <div id=\"slide-runner\">\n");
      out.write("                            <a href=\"\"><img id=\"slide-img-1\" src=\"images/1.png\" class=\"slide\" alt=\"\" /></a>\n");
      out.write("                            <a href=\"\"><img id=\"slide-img-2\" src=\"images/2.png\" class=\"slide\" alt=\"\" /></a>\n");
      out.write("                            <a href=\"\"><img id=\"slide-img-3\" src=\"images/3.png\" class=\"slide\" alt=\"\" /></a>\n");
      out.write("                            <a href=\"\"><img id=\"slide-img-4\" src=\"images/4.png\" class=\"slide\" alt=\"\" /></a>\n");
      out.write("                            <a href=\"\"><img id=\"slide-img-5\" src=\"images/5.png\" class=\"slide\" alt=\"\" /></a>\n");
      out.write("                            <a href=\"\"><img id=\"slide-img-6\" src=\"images/6.png\" class=\"slide\" alt=\"\" /></a>\n");
      out.write("                            <a href=\"\"><img id=\"slide-img-7\" src=\"images/7.png\" class=\"slide\" alt=\"\" /></a>\n");
      out.write("                            <div id=\"slide-controls\">\n");
      out.write("                                <p id=\"slide-client\" class=\"text\"><strong>post: </strong><span></span></p>\n");
      out.write("                                <p id=\"slide-desc\" class=\"text\"></p>\n");
      out.write("                                <p id=\"slide-nav\"></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!--content featured gallery here -->\n");
      out.write("                    </div>\n");
      out.write("                    <script type=\"text/javascript\">\n");
      out.write("                        if(!window.slider) var slider={};slider.data=[{\"id\":\"slide-img-1\",\"client\":\"Programacion\",\"desc\":\"Spring\"},{\"id\":\"slide-img-2\",\"client\":\"Programacion\",\"desc\":\"Deitel & Deitel C++ como programar\"},{\"id\":\"slide-img-3\",\"client\":\"Programacion\",\"desc\":\"Java Como programar\"},{\"id\":\"slide-img-4\",\"client\":\"Programacion\",\"desc\":\"PHP y MySql\"},{\"id\":\"slide-img-5\",\"client\":\"Programacion\",\"desc\":\"Oracle 11g\"},{\"id\":\"slide-img-6\",\"client\":\"Prgramacion\",\"desc\":\"Java - Glassfish\"},{\"id\":\"slide-img-7\",\"client\":\"Servidores\",\"desc\":\"CentOS\"}];\n");
      out.write("                    </script>\n");
      out.write("                </div></div><!--/header-->\n");
      out.write("\n");
      out.write("            <!--wrapper-->\n");
      out.write("            <div id=\"wrapper\">\n");
      out.write("\n");
      out.write("                <div id=\"right\">\n");
      out.write("                    <img src=\"images/icons/logo.jpg\" width=\"100%\" height=\"100%\" class=\"img\" alt=\"Libreria.com\">\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <!--div left-->\n");
      out.write("                <div id=\"left\">\n");
      out.write("                    <div class=\"panel_log\">\n");
      out.write("                        <br><h1>Panel de Control</h1>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <center>\n");
      out.write("                            <table border=\"0\">\n");
      out.write("                                <font face=\"bold\" size=\"12\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Usuario&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                                        <td><input type='text' name='usuario' size='20' style=\"height: 22px; font-size: 14pt;\" /></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"right\">Contraseña&nbsp;&nbsp;&nbsp;</td>\n");
      out.write("                                        <td><input type='password' name='pwd' size='20' style=\"height: 22px; font-size: 14pt;\" /></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><br></td>\n");
      out.write("                                        <td><br></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><br></td>\n");
      out.write("                                        <td><br></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"left\">Si no esta usted registrado, puede registrarse dando click aqui *</td>\n");
      out.write("                                        <td align=\"left\"><input align='center' type='submit' name='boton' value='Registrarse'></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td align=\"left\">Consulte el historial de pedidos de su usuario</td>\n");
      out.write("                                        <td align=\"left\"><input align=right type='submit' name='boton' value='Historial'></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </font>\n");
      out.write("                            </table>\n");
      out.write("                        </center>\n");
      out.write("                    </div>\n");
      out.write("                </div><!--/div left-->\n");
      out.write("\n");
      out.write("            </div><!--/wrapper-->\n");
      out.write("\n");
      out.write("            <div id=\"bot\"></div>\n");
      out.write("        </div><!--/main-->\n");
      out.write("    </form>\n");
      out.write("</body>\n");
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
