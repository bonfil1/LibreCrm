<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- página JSP VerCarrito.jsp --%>
<%@page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Carrito de la Compra</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2010">
    </head>

    <body bgcolor="#FFFFFF">
        <center>
            <form action="/GestionLibros/SvLibros" method=post>
                <%-- Responder al cliente --%>
                <c:if test="${requestScope.operacionFallida == 'NO'}">
                    <h3>Carrito de la Compra<br></h3>

                    <%-- Mostrar el formulario de búsqueda de información--%>
                    <font face="Verdana,Helvetica" size="2"><b>Búsqueda por:</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
                    <%-- Lista desplegable --%>
                    <select size="1" name='opcion'>
                        <option value="1">Título del libro</option>
                        <option value="2">Autor del libro</option>
                        <option value="3">Editorial del libro</option>
                        <option value="4">Categoría del libro</option>
                        <option selected value="5">Todos los libros disponibles</option>
                    </select><br><br>
                    <font face="Verdana,Helvetica" size="2"><b>Buscar:</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type='text' name='busqueda' size='60'><br><br>

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
                        <tr bgcolor="#6A63F3">
                            <td colspan=100% height="20"><font face="Verdana,Helvetica" size="2"
                                                               color="#000000"><b>Libros</b>
                                </font></td>
                        </tr>
                        <tr bgcolor="#6A63F3">
                            <td width="5%">
                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Id_libro</b></font></td>
                            <td width="35%" align="center">
                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Título</b></font></td>
                            <td width="24%" align="center">
                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Autor</b></font></td>
                            <td width="12%">
                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Editorial</b></font></td>
                            <td width="5%">
                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Ed.</b></font></td>
                            <td width="7%">
                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Año</b></font></td>
                            <td width="8%">
                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Unid.</b></font></td>
                            <td width="4%">
                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Precio</b>(&euro;)</font></td>
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
                </c:if>

                <c:if test="${requestScope.operacionFallida == 'SI'}">
                    <h3>Error: imposible realizar la operación</h3>
                </c:if>

                <br>
                <br>

                <%--
                     Creamos los botones que corresponden al formulario, que van a permitir
                     actualizar la compra, aceptarla, reiniciar el sistema o limpiar la pantalla.
                --%>

                <br>
                <br>
                <input type="submit" name="boton"
                       value="Inicio">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" name="boton"
                       value="Buscar">&nbsp;&nbsp;&nbsp;&nbsp;

                <%--
                      Cada vez que pulsamos el botón "limpiar" borramos todos los datos
                      introducidos por nosotros en esa página sin haberla actualizado.
                --%>
                <input type="reset">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" name="boton"
                       value="Comprar">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" name="boton"
                       value="Ayuda">

            </form>
        </center>
    </body>
</html>

