<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- página JSP RegistroCliente.jsp --%>
<%@page contentType="text/html" isErrorPage="false" errorPage="error.jsp"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Registro del Cliente</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2010">
    </head>

    <body bgcolor="#FFFFFF">

        <center>
            <font face="Verdana,Helvetica" size="4"><b>Registro de un Cliente</b></font>

            <%--
                 Creamos un formulario, para solicitar los datos del usuario, a fin
                 de proceder en un futuro al envío de aquellos productos pedidos por un cliente
            --%>
            <br><br><br><br><br>
            <form action="/GestionLibros/SvLibros" method=post>
                <table bgColor="#6A63F3" border=2 cellPadding=0 cellSpacing=0 width=400 nowrap>
                    <tbody><tr><td noWrap width=300>
                                <table width=285 nowrap><tbody>
                                        <tr>
                                            <td align=center colspan="5" height="20"><font face="Verdana,Helvetica" size="4"
                                                                                           color="#FFFFFF"><b>Datos del cliente</b></font></td></tr>
                                        <tr>
                                            <td width="11%">
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Nombre:</b></font></td>
                                            <td width="6%">&nbsp;</td>
                                            <td width="83%"><font face="Verdana,Helvetica" size="2">
                                                    <input type=text size=60 name="nom_usuario"></font></td></tr>
                                        <tr>
                                            <td width="11%">
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Nick:</b></font></td>
                                            <td width="6%">&nbsp;</td>
                                            <td width="83%"><font face="Verdana,Helvetica" size="2">
                                                    <input type=text size=60 name="nick_usuario"></font></td></tr>
                                        <tr>
                                            <td width="11%">
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Tel&eacute;fono:</b></font></td>
                                            <td width="6%">&nbsp;</td>
                                            <TD><font face="Verdana,Helvetica" size="2">
                                                    <input type=text size=60 name="tlf_usuario" value='0'></font></td></tr>
                                        <tr>
                                            <td width="11%">
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Direcci&oacute;n:</b></font></td>
                                            <td width="6%">&nbsp;</td>
                                            <td><font face="Verdana,Helvetica" size="2">
                                                    <input type=text size=60 name="dir_usuario"></font></td></tr>
                                        <tr>
                                            <td width="11%">
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>C.Postal:</b></font></td>
                                            <td width="6%">&nbsp;</td>
                                            <td><font face="Verdana,Helvetica" size="2">
                                                    <input type=text size=60 name="cp_usuario" value='0'></font></td></tr>
                                        <tr>
                                            <td width="11%">
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Ciudad:</b></font></td>
                                            <td width="6%">&nbsp;</td>
                                            <td><font face="Verdana,Helvetica" size="2">
                                                    <input type=text size=60 name="ciud_usuario"></font></td></tr>
                                        <tr>
                                            <td width="11%">
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Provincia:</b></font></td>
                                            <td width="6%">&nbsp;</td>
                                            <td><font face="Verdana,Helvetica" size="2">
                                                    <input type=text size=60 name="prov_usuario"></font></td></tr>
                                        <tr>
                                            <td width="11%">
                                                <font face="Verdana,Helvetica" size="2" color="#FFFFFF"><b>Contraseña:</b></font></td>
                                            <td width="6%">&nbsp;</td>
                                            <td width="83%"><font face="Verdana,Helvetica" size="2">
                                                    <input type=password size=62 name="pwd_usuario"></font></td></tr>
                                        <tr><td><br></td></tr>
                                </table>
                            </td></tr></tbody>
                </table>
                <%--
                     Creamos los botones que corresponden al formulario, que van a permitir
                     reiniciar el sistema, limpiar la pantalla o registrarse como nuevo cliente.
                --%>
                <br>
                <table width=450 cellspacing=0 cellpadding=0 border=0>
                    <tr>
                        <td align="center">
                            <input type="submit" name="boton"
                                   value="Inicio"></td>
                        <td align="center">
                            <input type="reset"></td>
                        <td align="center">
                            <input type="submit" name="boton"
                                   value="Registrarse"></td>
                        <td align="center">
                            <input type="submit" name="boton"
                                   value="Ayuda"></td>
                    </tr>
                </table>
            </form>
        </center>
    </body>
</html>
