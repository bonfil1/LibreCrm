<%-- 
    Document   : VerCarrito
    Created on : 5/12/2010, 06:37:30 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2010">
        <title>Libros.com | Consultar Sus Compras</title>
        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <link rel="stylesheet" href="css/slide-style.css" type="text/css" media="screen" />

        <!--Scripts-->
        <script type="text/javascript">var _siteRoot='Bienvenida.jsp',_root='Bienvenida.jsp';</script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
    </head>
    <body>
        <center>
            <form action="/VentaLibros/SvLibros" method=post>
                <%-- Responder al cliente --%>
                <div id="main">
                    <div id="top"></div>
                    <!-- header begins -->
                    <div id="header">
                        <div id="buttons">
                            <%-- Mostrar el formulario --%>

                            <table border="0">
                                <tr>
                                    <td><font face="Verdana,Helvetica" size="2"><b>Busqueda por:</b></font>&nbsp;</td>
                                    <%-- Lista desplegable --%>
                                    <td><select size="1" name='opcion'>
                                            <option value="1">Título del libro</option>
                                            <option value="2">Autor del libro</option>
                                            <option value="3">Editorial del libro</option>
                                            <option value="4">Categoría del libro</option>
                                            <option selected value="5">Todos los libros disponibles </option>
                                        </select>&nbsp;</td>
                                    <td><font face="Verdana,Helvetica" size="2"><b>Buscar:</b></font>&nbsp;&nbsp;&nbsp;</td>
                                    <td><input type='text' name='busqueda' size='50' style="height: 22px; font-size: 14pt;">&nbsp;</td>
                                    <td><input type = "image" src = "images/icons/buscar1.png" width = "25px" height = "25px" name="boton" value='Buscar'></td>
                                    <td><input type = "image" src = "images/icons/help1.png" width = "25px" height = "25px" name="boton" value="Ayuda"></td>
                                    <td><input type = "reset" class="boton-res" value="&nbsp;&nbsp;&nbsp;"></td>
                                    <td><input type = "image" src = "images/icons/home1.png" width = "25px" height = "25px" name="boton" value="Inicio"></td>
                                    <!--<input type="submit" name='boton' value='Buscar'>&nbsp;&nbsp;
                                    <input type="reset">
                                    <input type="submit" name='boton' value='Ayuda'>-->
                                </tr>
                            </table>

                        </div>
                    </div>
                    <!-- header ends -->

                    <!--/Slide-presentation-->
                    <div id="header"><div class="wrap">
                            <div id="slide-holder">
                                <div id="slide-runner">
                                    <a href="#"><img id="slide-img-1" src="images/1.png" class="slide" alt="" /></a>
                                    <a href="#"><img id="slide-img-2" src="images/2.png" class="slide" alt="" /></a>
                                    <a href="#"><img id="slide-img-3" src="images/3.png" class="slide" alt="" /></a>
                                    <a href="#"><img id="slide-img-4" src="images/4.png" class="slide" alt="" /></a>
                                    <a href="#"><img id="slide-img-5" src="images/5.png" class="slide" alt="" /></a>
                                    <a href="#"><img id="slide-img-6" src="images/6.png" class="slide" alt="" /></a>
                                    <a href="#"><img id="slide-img-7" src="images/7.png" class="slide" alt="" /></a>
                                    <div id="slide-controls">
                                        <p id="slide-client" class="text"><strong>post: </strong><span></span></p>
                                        <p id="slide-desc" class="text"></p>
                                        <p id="slide-nav"></p>
                                    </div>
                                </div>

                                <!--content featured gallery here -->
                            </div>
                            <script type="text/javascript">
                                if(!window.slider) var slider={};slider.data=[{"id":"slide-img-1","client":"Programacion","desc":"Spring"},{"id":"slide-img-2","client":"Programacion","desc":"Deitel & Deitel C++ como programar"},{"id":"slide-img-3","client":"Programacion","desc":"Java Como programar"},{"id":"slide-img-4","client":"Programacion","desc":"PHP y MySql"},{"id":"slide-img-5","client":"Programacion","desc":"Oracle 11g"},{"id":"slide-img-6","client":"Prgramacion","desc":"Java - Glassfish"},{"id":"slide-img-7","client":"Servidores","desc":"CentOS"}];
                            </script>
                        </div></div><!--/header-->
                    <!--wrapper-->
                    <div id="wrapper2">

                        <!--div left-->
                        <div class="panel_busqueda">
                            <c:if test="${requestScope.operacionFallida == 'NO'}">
                                <br><h1>Carrito de compra de ${requestScope.nombre}</h1>
                                <br>

                                <%--
                                    Creamos la línea en donde se indica el total de la compra que se va
                                    seleccionando
                                --%>
                                <table width=100% cellspacing="0" cellpadding="0" border="0">
                                    <tr bgcolor="#000000">
                                        <td align=right colspan=100%><font face="Verdana,Helvetica" size="2"
                                                                           color="#FFFFFF"><b>
                                                    Total:&nbsp;&nbsp;&nbsp;
                                                    ${requestScope.precioTotal}&euro;</b>
                                            </font></td>
                                    </tr>
                                </table>

                                <table width=100% cellspacing="0" cellpadding="0" border="0">
                                    <%--
                                        Definimos la apariencia de la zona en donde se presentarán los datos
                                        de cada uno de los productos. Primero se crea la cabecera de la lista,
                                        para luego rellenar la lista de productos mediante un bean
                                    --%>

                                    <%-- Cabeceras --%>
                                    <tr bgcolor="#ccffcf">
                                        <td colspan=100% height="20"><font face="Verdana,Helvetica" size="2"
                                                                           color="#000000"><b>Libros</b>
                                            </font></td>
                                    </tr>
                                    <tr bgcolor="#ccffcf">
                                        <td width="5%">
                                            <font face="Verdana,Helvetica" size="2" color="#000000"><b>Id_libro</b></font></td>
                                        <td width="35%" align="center">
                                            <font face="Verdana,Helvetica" size="2" color="#000000"><b>Título</b></font></td>
                                        <td width="24%" align="center">
                                            <font face="Verdana,Helvetica" size="2" color="#000000"><b>Autor</b></font></td>
                                        <td width="12%">
                                            <font face="Verdana,Helvetica" size="2" color="#000000"><b>Editorial</b></font></td>
                                        <td width="5%">
                                            <font face="Verdana,Helvetica" size="2" color="#000000"><b>Ed.</b></font></td>
                                        <td width="7%">
                                            <font face="Verdana,Helvetica" size="2" color="#000000"><b>Año</b></font></td>
                                        <td width="8%">
                                            <font face="Verdana,Helvetica" size="2" color="#000000"><b>Unid.</b></font></td>
                                        <td width="4%">
                                            <font face="Verdana,Helvetica" size="2" color="#000000"><b>Precio</b>(&#36;)</font></td>
                                    </tr>

                                    <%-- Filas --%>
                                    <%--
                                        Recogemos los valores de cada pedido
                                    --%>

                                    <c:forEach var="fila" items="${requestScope.Carrito}">
                                        <tr>
                                            <td width="5%"><font face="Verdana,Helvetica" size="2">
                                                    ${fila.id_libro}</font></td>
                                            <td width="33%"><font face="Verdana,Helvetica" size="2">
                                                    ${fila.titulo_libro}</font></td>
                                            <td width="30%"><font face="Verdana,Helvetica" size="2">
                                                    ${fila.nom_autor}</font></td>
                                            <td width="12%"><font face="Verdana,Helvetica" size="2">
                                                    ${fila.nom_editorial}</font></td>
                                            <td width="2%"><font face="Verdana,Helvetica" size="2">
                                                    ${fila.ed_libro}</font></td>
                                            <td width="4%"><font face="Verdana,Helvetica" size="2">
                                                    ${fila.anyo_libro}</font></td>
                                            <td width="10%"> <font face="Verdana,Helvetica," size="2">
                                                    <input type="text" size="4" maxlength="4" name='unidades'
                                                           value=${fila.unidades}></font></td>
                                            <td aligh="right" width="4%"><font face="Verdana,Helvetica" size="2">
                                                    ${fila.precio_libro}</font></td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </c:if> <%--Fin de si la operacion no fue fallida--%>

                            <%-- Ahora si la operacion fallo--%>
                            <c:if test="${requestScope.operacionFallida == 'SI'}">
                                <font color="#FF0000">
                                <h3>Error: imposible realizar la operación</h3>
                                </font>
                            </c:if>
                        </div>
                    </div><!--/wrapper-->

                    <div id="bot"></div>
                </div><!--/main-->
            </form>
        </center>
    </body>
</html>
