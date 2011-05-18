package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Ayuda_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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
      out.write("<head>\r\n");
      out.write("<title>Ayuda al usuario</title>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\r\n");
      out.write("<meta name=\"autor\"        Content=\"Francisco Ceballos\">\r\n");
      out.write("<meta name=\"copyright\"    Content=\"(c) 2004\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body bgcolor=\"#FFFFFF\">\r\n");
      out.write("  <center>\r\n");
      out.write("  <h1><font face=\"Verdana,Helvetica\"><b>DOCUMENTO DE AYUDA</b></font></h1>\r\n");
      out.write("  <br><br>\r\n");
      out.write("  </center>\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  <OL>\r\n");
      out.write("    <LI> <b>B&uacute;squeda de libros:</b>\r\n");
      out.write("        <UL>\r\n");
      out.write("            <LI> La b&uacute;squeda de libros se puede realizar de distintas maneras:\r\n");
      out.write("                <OL Type=\"a\">\r\n");
      out.write("                    <LI> B&uacute;squeda por t&iacute;tulo:\r\n");
      out.write("                        <UL>\r\n");
      out.write("                            <LI> Se rellena la caja de texto con el t&iacute;tulo parcial o total del libro que desee buscar.\r\n");
      out.write("                        </UL>\r\n");
      out.write("                    <LI> B&uacute;squeda por autor:\r\n");
      out.write("                        <UL>\r\n");
      out.write("                            <LI> Se rellena la caja de texto con el nombre parcial o total del autor del libro que desee buscar.\r\n");
      out.write("                        </UL>                    \r\n");
      out.write("                    <LI> B&uacute;squeda por editorial:\r\n");
      out.write("                        <UL>\r\n");
      out.write("                            <LI> Se rellena la caja de texto con el nombre parcial o total de la editorial del libro que desee buscar.\r\n");
      out.write("                        </UL>                    \r\n");
      out.write("                    <LI> B&uacute;squeda por categor&iacute;a:\r\n");
      out.write("                        <UL>\r\n");
      out.write("                            <LI> Categorías en que se dividen los libros actualmente:\r\n");
      out.write("                                <UL>\r\n");
      out.write("                                    <LI> Ensayo\r\n");
      out.write("                                    <LI> F&iacute;sica\r\n");
      out.write("                                    <LI> Inform&aacute;tica\r\n");
      out.write("                                    <LI> Matem&aacute;ticas\r\n");
      out.write("                                    <LI> Novela\r\n");
      out.write("                                </UL>                        \r\n");
      out.write("                        </UL>\r\n");
      out.write("                    <LI> Lista que contiene todos los libros:\r\n");
      out.write("                        <UL>\r\n");
      out.write("                            <LI> Esta opción no requiere rellenar la caja de texto.\r\n");
      out.write("                        </UL>\r\n");
      out.write("                </OL>\r\n");
      out.write("            <LI> Para que una b&uacute;squeda se pueda realizar, se pulsar&aacute;\r\n");
      out.write("                 el bot&oacute;n \"buscar\".                \r\n");
      out.write("        </UL>\r\n");
      out.write("        <br><br>\r\n");
      out.write("    <LI> <b>Reestablecer:</b>\r\n");
      out.write("        <UL>\r\n");
      out.write("            <LI> Cada vez que pulsemos este bot&oacute;n todo lo escrito\r\n");
      out.write("                 por el usuario en esa misma pantalla ser&aacute; reestablecido a su valor incial.\r\n");
      out.write("        </UL>\r\n");
      out.write("        <br><br>        \r\n");
      out.write("    <LI> <b>Registro de un usuario:</b>\r\n");
      out.write("        <UL>\r\n");
      out.write("            <LI> Cuando un nuevo usuario quiere darse de alta en el sistema, debe pulsar este\r\n");
      out.write("                 bot&oacute;n que le llevará a una ventana donde deber&aacute; rellenar todos\r\n");
      out.write("                 los campos correctamente para que pueda ser admitido.\r\n");
      out.write("        </UL>\r\n");
      out.write("        <br><br>        \r\n");
      out.write("    <LI> <b>Historial de un usuario del sistema:</b>\r\n");
      out.write("        <UL>\r\n");
      out.write("            <LI> Para que un usuario ya registrado en el sistema pueda ver el historial de los\r\n");
      out.write("                 pedidos que ha realizado a esta librería, deberá rellenar previamente\r\n");
      out.write("                 los campos \"Usuario\" y \"Contraseña\" que se muestran en pantalla.\r\n");
      out.write("                 <OL type=\"a\">\r\n");
      out.write("                    <LI> Usuario: nombre de usuario y no el nombre real del cliente.\r\n");
      out.write("                    <LI> Contraseña: clave secreta del usuario.\r\n");
      out.write("                 </OL>\r\n");
      out.write("            <LI> A continuación, se pulsa el bot&oacute;n \"Historial\" para que el sistema\r\n");
      out.write("                 compruebe la autenticidad de los datos y le permita o no acceder.\r\n");
      out.write("        </UL>\r\n");
      out.write("        <br><br>\r\n");
      out.write("     <LI> <b>Ver pedido/s del cliente:</b>\r\n");
      out.write("        <UL>\r\n");
      out.write("            <LI> Para que un usuario pueda ver un pedido, tiene que elegir el n&uacute;mero de\r\n");
      out.write("                 identificaci&oacute;n del pedido y hacer clic sobre el bot&oacute;n \"Comprobar\".\r\n");
      out.write("                 Se le mostrarán los detalles del pedido que realiz&oacute en su d&iacute;a.\r\n");
      out.write("        </UL>          \r\n");
      out.write("        <br><br>        \r\n");
      out.write("    <LI> <b>Comprar libro/s:</b>\r\n");
      out.write("        <UL>\r\n");
      out.write("            <LI> Para que un usuario pueda realizar una compra debe estar previamente registrado en el\r\n");
      out.write("                 sistema.\r\n");
      out.write("            <LI> El mecanismo de compra es el del carrito de la compra. Primero se elige todo lo que\r\n");
      out.write("                 se quiere comprar y luego se hace clic en el bot&oacute;n \"Comprar\". El sistema realizará\r\n");
      out.write("                 un albar&aacute;n que guardar&aacute; en su base de datos.\r\n");
      out.write("            <LI> Todo pedido tiene que llevar una forma de pago consigo: contrareembolso o tarjeta de crédito.<br>\r\n");
      out.write("                 En el caso de pagar con tarjeta de crédito, hay que introducir 16 d&iacute;gitos\r\n");
      out.write("                 correctamente para que el sistema pueda tramitar el pedido.\r\n");
      out.write("        </UL>   \r\n");
      out.write("     <LI> <b>Ver carrito de la compra:</b>\r\n");
      out.write("        <UL>\r\n");
      out.write("            <LI> Para que un usuario pueda ver su carrito de la compra actual.\r\n");
      out.write("        </UL>          \r\n");
      out.write("        <br><br>        \r\n");
      out.write("  </OL>\r\n");
      out.write("  \r\n");
      out.write("  <br><br><br>\r\n");
      out.write("  <center>\r\n");
      out.write("  ");
      out.write("\r\n");
      out.write("  <form action=\"/GestionLibros/SvLibros\" method=post>\r\n");
      out.write("    <input type=\"submit\" name=\"boton\" \r\n");
      out.write("         value=\"Inicio\">&nbsp;&nbsp;&nbsp;&nbsp;  \r\n");
      out.write("  </form>\r\n");
      out.write("  </center>\r\n");
      out.write("</body>\r\n");
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
