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
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <title>Librería Virtual</title>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; utf-8\">\r\n");
      out.write("        <meta name=\"autor\"        Content=\"Jose Angel Bonfil\">\r\n");
      out.write("        <meta name=\"copyright\"    Content=\"(c) 2010\">\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body bgcolor=\"#FFFFFF\">\r\n");
      out.write("        <center>\r\n");
      out.write("            <h1><font face=\"Verdana,Helvetica\"><b>BUSQUEDA DE LIBROS</b></font></h1>\r\n");
      out.write("\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("            <form action=\"/GestionLibros/SvLibros\" method=post>\r\n");
      out.write("                <font face=\"Verdana,Helvetica\" size=\"2\"><b>Busqueda por:</b></font>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                ");
      out.write("\r\n");
      out.write("                <select size=\"1\" name='opcion'>\r\n");
      out.write("                    <option value=\"1\">Título del libro</option>\r\n");
      out.write("                    <option value=\"2\">Autor del libro</option>\r\n");
      out.write("                    <option value=\"3\">Editorial del libro</option>\r\n");
      out.write("                    <option value=\"4\">Categoría del libro</option>\r\n");
      out.write("                    <option selected value=\"5\">Todos los libros disponibles</option>\r\n");
      out.write("                </select><br><br><br>\r\n");
      out.write("                <font face=\"Verdana,Helvetica\" size=\"2\"><b>Buscar:</b></font>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                <input type='text' name='busqueda' size='60'>\r\n");
      out.write("\r\n");
      out.write("                <br><br><input type=\"submit\" name='boton' value='Buscar'>&nbsp;&nbsp;\r\n");
      out.write("                <input type=\"reset\">&nbsp;&nbsp;\r\n");
      out.write("                <input type=\"submit\" name='boton' value='Ayuda'>\r\n");
      out.write("                <br>\r\n");
      out.write("                <br>\r\n");
      out.write("                <table bgColor=\"#6A63F3\" border=0 cellPadding=0 cellspacing=4 width=425 nowrap>\r\n");
      out.write("                    <tbody><tr><td noWrap width=250>\r\n");
      out.write("                                <table width=425 nowrap>\r\n");
      out.write("                                    <tbody><tr><td><br></td></tr>\r\n");
      out.write("                                        <tr><td>\r\n");
      out.write("                                                <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#FFFFFF\">\r\n");
      out.write("                                                    <b>Si aún no eres cliente nuestro, REGÍSTRATE:</b>&nbsp;&nbsp;&nbsp;&nbsp;</font>\r\n");
      out.write("                                            </td><td><input align=right type='submit' name='boton' value='Registro'></td></tr>\r\n");
      out.write("                                        <tr><td><br>\r\n");
      out.write("                                                <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#FFFFFF\">\r\n");
      out.write("                                                    <b>Historial de Pedidos (*):</b>\r\n");
      out.write("                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>\r\n");
      out.write("                                            </td><td><input align=right type='submit' name='boton' value='Historial'></td></tr>\r\n");
      out.write("                                    <table cellspacing=0 cellpadding=0 border=0 align=right>\r\n");
      out.write("                                        <tr><td>\r\n");
      out.write("                                                <font face=\"Verdana,Helvetica\" size=\"1\" color=\"#FFFFFF\">\r\n");
      out.write("                                                    <b>Usuario&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></b>\r\n");
      out.write("                                                <input type=\"text\" name=\"usuario\" size=\"10\">\r\n");
      out.write("                                            </td></tr>\r\n");
      out.write("                                        <tr><td>\r\n");
      out.write("                                                <font face=\"Verdana,Helvetica\" size=\"1\" color=\"#FFFFFF\">\r\n");
      out.write("                                                    <b>Contraseña&nbsp;</font></b>\r\n");
      out.write("                                                <input type=\"password\" name=\"pwd\" size=\"10\">\r\n");
      out.write("                                            </td></tr>\r\n");
      out.write("                                    </table>\r\n");
      out.write("                                    <tr><td><br><font face=\"Verdana,Helvetica\" size=\"1\" color=\"#FFFFFF\">\r\n");
      out.write("                                                <b>(*)</b> Debes estar dado de alta en el registro de clientes</font><br>\r\n");
      out.write("                                        </td></tr>\r\n");
      out.write("                    </tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("                </td></tr></tbody>\r\n");
      out.write("                </table>\r\n");
      out.write("            </form>\r\n");
      out.write("\r\n");
      out.write("        </center>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
