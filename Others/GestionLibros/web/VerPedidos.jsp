<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- página JSP VerPedidos.jsp --%>
<%@page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Historial del usuario</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2010">
    </head>

    <body bgcolor="#ffffff">
        <center>
            <form action="/GestionLibros/SvLibros" method=post>
                <%-- Responder al cliente --%>
                <c:if test="${requestScope.operacionFallida == 'NO'}">
                    <h3><b>Resultado de la búsqueda</b><br></h3>
                    <font face="Verdana,Helvetica" size="1"><b>Id del Pedido:</b></font>&nbsp;&nbsp;&nbsp;&nbsp;
                    <%-- Lista desplegable --%>
                    <select name='idPedido'>
                        <c:forEach var="fila" items="${requestScope.lPedidos}">
                            <option>${fila.id_pedido}</option>
                        </c:forEach>
                    </select><br><br>

                    <%--
                         Creamos la línea en donde se indica el total de la compra que se va
                         seleccionando además del precio total de la compra realizada.
                    --%>

                    <table width=100% cellspacing="0" cellpadding="0" border="0">
                        <tr bgcolor="#FFFFFF">
                            <td align=left colspan=100%><font face="Verdana,Helvetica" size="2"
                                                              color="#000000">
                                    <b><p>Estado: ${requestScope.estado}</p></b>
                                </font></td>
                        </tr>
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
                            <td colspan=100% height="20"><font face="Verdana,Helvetica" size="3"
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
                             Aquí tenemos el encabezado de la página que sirve a modo de título
                             para cada columna
                        --%>

                        <c:forEach var="fila" items="${requestScope.Pedido}">
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
                                        ${fila.unidades}</font></td>
                                <td aligh="right" width="4%"><font face="Verdana,Helvetica" size="2">
                                        ${fila.precio_libro}</font></td>
                            </tr>
                        </c:forEach>

                    </table>
                </c:if>

                <c:if test="${requestScope.operacionFallida == 'SI'}">
                    <h3>Error: imposible realizar la operación</h3>
                </c:if>

                <%--
                     Creamos los botones que corresponden al formulario, que van a permitir
                     actualizar la compra, aceptarla, reiniciar el sistema o limpiar la pantalla.
                --%>
                <br>
                <br>
                <input type="submit" name="boton"
                       value="Inicio">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" name="boton"
                       value="Comprobar">&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="submit" name="boton"
                       value="Ayuda">
            </form>
        </center>
    </body>
</html>
