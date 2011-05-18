package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class MostrarCarrito_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"autor\"        Content=\"Jose Angel Bonfil\">\n");
      out.write("        <meta name=\"copyright\"    Content=\"(c) 2010\">\n");
      out.write("        <title>Libreria.com |   Carrito</title>\n");
      out.write("\n");
      out.write("        <!--Styles-->\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\" type=\"text/css\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/slide-style.css\" type=\"text/css\" media=\"screen\" />\n");
      out.write("\n");
      out.write("        <!--Scripts-->\n");
      out.write("        <script type=\"text/javascript\">var _siteRoot='Bienvenida.jsp',_root='Bienvenida.jsp';</script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"js/scripts.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"/VentaLibros/SvLibros\" method=post>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\">\n");
      out.write("                            <table bgColor=\"#ccffcf\" border=\"0\" cellPadding=\"0\" cellspacing=4 width=355 nowrap>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>ID:</td>\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.id_user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>                                    \n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Nombre:</td>\n");
      out.write("                                    <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Seleccione su forma de pago</td>\n");
      out.write("                                    <td>\n");
      out.write("                                        <select size=\"1\" name='opcionPago'>\n");
      out.write("                                            <option>Tarjeta de crédito</option>\n");
      out.write("                                            <option>Contrareembolso</option>\n");
      out.write("                                        </select>\n");
      out.write("                                    </td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>Numero de Tarjeta</td>\n");
      out.write("                                    <td><input type=\"text\" name='numTarjeta' size='16' value='0'></td>\n");
      out.write("                                </tr>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td align=\"right\"><input type=\"submit\" name=\"boton\" value=\"Aceptar\"></td>\n");
      out.write("                                </tr>\n");
      out.write("                            </table>\n");
      out.write("                        </font>\n");
      out.write("                        <br>\n");
      out.write("                        <br>\n");
      out.write("                    </div>\n");
      out.write("                </div><!--/wrapper-->\n");
      out.write("                <div id=\"bot\"></div>\n");
      out.write("            </div><!--/main-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        </form>\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.operacionFallida == 'NO'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\n");
        out.write("                <div id=\"main\">\n");
        out.write("                    <div id=\"top\"></div>\n");
        out.write("                    <!-- header begins -->\n");
        out.write("                    <div id=\"header\">\n");
        out.write("                        <div id=\"buttons\">\n");
        out.write("                            ");
        out.write("\n");
        out.write("\n");
        out.write("                            <table border=\"0\">\n");
        out.write("                                <tr>\n");
        out.write("                                    <td><font face=\"Verdana,Helvetica\" size=\"2\"><b>Busqueda por:</b></font>&nbsp;</td>\n");
        out.write("                                    ");
        out.write("\n");
        out.write("                                    <td><select size=\"1\" name='opcion'>\n");
        out.write("                                            <option value=\"1\">Título del libro</option>\n");
        out.write("                                            <option value=\"2\">Autor del libro</option>\n");
        out.write("                                            <option value=\"3\">Editorial del libro</option>\n");
        out.write("                                            <option value=\"4\">Categoría del libro</option>\n");
        out.write("                                            <option selected value=\"5\">Todos los libros disponibles </option>\n");
        out.write("                                        </select>&nbsp;</td>\n");
        out.write("                                    <td><font face=\"Verdana,Helvetica\" size=\"2\"><b>Buscar:</b></font>&nbsp;&nbsp;&nbsp;</td>\n");
        out.write("                                    <td><input type='text' name='busqueda' size='50' style=\"height: 22px; font-size: 14pt;\">&nbsp;</td>\n");
        out.write("                                    <td><input type = \"image\" src = \"images/icons/buscar1.png\" width = \"25px\" height = \"25px\" name=\"boton\" value='Buscar'></td>\n");
        out.write("                                    <td><input type = \"image\" src = \"images/icons/help1.png\" width = \"25px\" height = \"25px\" name=\"boton\" value=\"Ayuda\"></td>\n");
        out.write("                                    <td><input type = \"reset\" class=\"boton-res\" value=\"&nbsp;&nbsp;&nbsp;\"></td>\n");
        out.write("                                    <td><input type = \"image\" src = \"images/icons/home1.png\" width = \"25px\" height = \"25px\" name=\"boton\" value=\"Inicio\"></td>\n");
        out.write("                                    <!--<input type=\"submit\" name='boton' value='Buscar'>&nbsp;&nbsp;\n");
        out.write("                                    <input type=\"reset\">\n");
        out.write("                                    <input type=\"submit\" name='boton' value='Ayuda'>-->\n");
        out.write("                                </tr>\n");
        out.write("                            </table>\n");
        out.write("\n");
        out.write("                        </div>\n");
        out.write("                    </div>\n");
        out.write("                    <!-- header ends -->\n");
        out.write("\n");
        out.write("                    <!--/Slide-presentation-->\n");
        out.write("                    <div id=\"header\"><div class=\"wrap\">\n");
        out.write("                            <div id=\"slide-holder\">\n");
        out.write("                                <div id=\"slide-runner\">\n");
        out.write("                                    <a href=\"#\"><img id=\"slide-img-1\" src=\"images/1.png\" class=\"slide\" alt=\"\" /></a>\n");
        out.write("                                    <a href=\"#\"><img id=\"slide-img-2\" src=\"images/2.png\" class=\"slide\" alt=\"\" /></a>\n");
        out.write("                                    <a href=\"#\"><img id=\"slide-img-3\" src=\"images/3.png\" class=\"slide\" alt=\"\" /></a>\n");
        out.write("                                    <a href=\"#\"><img id=\"slide-img-4\" src=\"images/4.png\" class=\"slide\" alt=\"\" /></a>\n");
        out.write("                                    <a href=\"#\"><img id=\"slide-img-5\" src=\"images/5.png\" class=\"slide\" alt=\"\" /></a>\n");
        out.write("                                    <a href=\"#\"><img id=\"slide-img-6\" src=\"images/6.png\" class=\"slide\" alt=\"\" /></a>\n");
        out.write("                                    <a href=\"#\"><img id=\"slide-img-7\" src=\"images/7.png\" class=\"slide\" alt=\"\" /></a>\n");
        out.write("                                    <div id=\"slide-controls\">\n");
        out.write("                                        <p id=\"slide-client\" class=\"text\"><strong>post: </strong><span></span></p>\n");
        out.write("                                        <p id=\"slide-desc\" class=\"text\"></p>\n");
        out.write("                                        <p id=\"slide-nav\"></p>\n");
        out.write("                                    </div>\n");
        out.write("                                </div>\n");
        out.write("\n");
        out.write("                                <!--content featured gallery here -->\n");
        out.write("                            </div>\n");
        out.write("                            <script type=\"text/javascript\">\n");
        out.write("                                if(!window.slider) var slider={};slider.data=[{\"id\":\"slide-img-1\",\"client\":\"Programacion\",\"desc\":\"Spring\"},{\"id\":\"slide-img-2\",\"client\":\"Programacion\",\"desc\":\"Deitel & Deitel C++ como programar\"},{\"id\":\"slide-img-3\",\"client\":\"Programacion\",\"desc\":\"Java Como programar\"},{\"id\":\"slide-img-4\",\"client\":\"Programacion\",\"desc\":\"PHP y MySql\"},{\"id\":\"slide-img-5\",\"client\":\"Programacion\",\"desc\":\"Oracle 11g\"},{\"id\":\"slide-img-6\",\"client\":\"Prgramacion\",\"desc\":\"Java - Glassfish\"},{\"id\":\"slide-img-7\",\"client\":\"Servidores\",\"desc\":\"CentOS\"}];\n");
        out.write("                            </script>\n");
        out.write("                        </div></div><!--/header-->\n");
        out.write("\n");
        out.write("                    <!--wrapper-->\n");
        out.write("                    <div id=\"wrapper2\">\n");
        out.write("\n");
        out.write("                        <!--div Carrito-->\n");
        out.write("                        <div class=\"panel_busqueda\">\n");
        out.write("                            <br><h1>Carrito de Compra</h1>\n");
        out.write("                            <br>\n");
        out.write("                            ");
        out.write("\n");
        out.write("                            <table width=100% cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n");
        out.write("                                <tr bgcolor=\"#FFFFFF\">\n");
        out.write("                                    <td align=left colspan=100%><font face=\"Verdana,Helvetica\" size=\"2\"\n");
        out.write("                                                                      color=\"#000000\">\n");
        out.write("                                            <b><p>Bienvenido ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.nick}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p></b>\n");
        out.write("                                        </font></td>\n");
        out.write("                                </tr>\n");
        out.write("                                <tr bgcolor=\"#000000\">\n");
        out.write("                                    <td align=right colspan=100%><font face=\"Verdana,Helvetica\" size=\"2\"\n");
        out.write("                                                                       color=\"#FFFFFF\"><b>\n");
        out.write("                                                Total:&nbsp;&nbsp;&nbsp;\n");
        out.write("                                                &#36; ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.precioTotal}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</b>\n");
        out.write("                                        </font></td>\n");
        out.write("                                </tr>\n");
        out.write("                            </table>\n");
        out.write("                            <table width=100% cellspacing=\"0\" cellpadding=\"0\" border=\"0\">\n");
        out.write("                                ");
        out.write("\n");
        out.write("\n");
        out.write("                                ");
        out.write("\n");
        out.write("                                <tr bgcolor=\"#ccffcf\">\n");
        out.write("                                    <td colspan=100% height=\"20\"><font face=\"Verdana,Helvetica\" size=\"2\"\n");
        out.write("                                                                       color=\"#000000\"><b>Libros</b>\n");
        out.write("                                        </font></td>\n");
        out.write("                                </tr>\n");
        out.write("                                <tr bgcolor=\"#ccffcf\">\n");
        out.write("                                    <td width=\"5%\">\n");
        out.write("                                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\"><b>Id_libro</b></font></td>\n");
        out.write("                                    <td width=\"35%\" align=\"center\">\n");
        out.write("                                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\"><b>Título</b></font></td>\n");
        out.write("                                    <td width=\"24%\" align=\"center\">\n");
        out.write("                                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\"><b>Autor</b></font></td>\n");
        out.write("                                    <td width=\"12%\">\n");
        out.write("                                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\"><b>Editorial</b></font></td>\n");
        out.write("                                    <td width=\"5%\">\n");
        out.write("                                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\"><b>Ed.</b></font></td>\n");
        out.write("                                    <td width=\"7%\">\n");
        out.write("                                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\"><b>Año</b></font></td>\n");
        out.write("                                    <td width=\"8%\">\n");
        out.write("                                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\"><b>Unid.</b></font></td>\n");
        out.write("                                    <td width=\"4%\">\n");
        out.write("                                        <font face=\"Verdana,Helvetica\" size=\"2\" color=\"#000000\">$&nbsp;<b>Precio</b></font></td>\n");
        out.write("                                </tr>\n");
        out.write("\n");
        out.write("                                ");
        out.write("\n");
        out.write("                                ");
        out.write("\n");
        out.write("\n");
        out.write("                                ");
        if (_jspx_meth_c_forEach_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("\n");
        out.write("                            </table>\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_forEach_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_forEach_0.setVar("fila");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.Carrito}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                    <tr>\n");
          out.write("                                        <td width=\"5%\"><font face=\"Verdana,Helvetica\" size=\"2\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fila.id_libro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</font></td>\n");
          out.write("                                        <td width=\"33%\"><font face=\"Verdana,Helvetica\" size=\"2\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fila.titulo_libro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</font></td>\n");
          out.write("                                        <td width=\"30%\"><font face=\"Verdana,Helvetica\" size=\"2\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fila.nom_autor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</font></td>\n");
          out.write("                                        <td width=\"12%\"><font face=\"Verdana,Helvetica\" size=\"2\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fila.nom_editorial}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</font></td>\n");
          out.write("                                        <td width=\"2%\"><font face=\"Verdana,Helvetica\" size=\"2\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fila.ed_libro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</font></td>\n");
          out.write("                                        <td width=\"4%\"><font face=\"Verdana,Helvetica\" size=\"2\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fila.anyo_libro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</font></td>\n");
          out.write("                                        <td width=\"10%\"> <font face=\"Verdana,Helvetica,\" size=\"2\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fila.unidades}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</font></td>\n");
          out.write("                                        <td aligh=\"right\" width=\"4%\"><font face=\"Verdana,Helvetica\" size=\"2\">\n");
          out.write("                                                ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${fila.precio_libro}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</font></td>\n");
          out.write("                                    </tr>\n");
          out.write("                                ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.operacionFallida == 'SI'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            <h3>Error: imposible realizar la operación</h3>\n");
        out.write("                            <input type=\"submit\" name=\"boton\" value=\"Inicio\">\n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }
}
