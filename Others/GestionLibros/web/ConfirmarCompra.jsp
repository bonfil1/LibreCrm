<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- página JSP ConfirmarCompra.jsp --%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<html>
    <head>
        <title>Autenticaci&oacute;n del Cliente</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2010">
    </head>

    <body bgcolor="#FFFFFF">
        <%--
             Presentamos la cabecera específica de esta página, en la que se indica
             que se trata de la página en la que se realizan las compras
        --%>
        <center>
            <font face="Verdana,Helvetica" size="4"><b>Registro de un Cliente</b></font>

            <%--
                 Creamos un formulario, para solicitar los datos del usuario, a fin
                 de proceder en un futuro al envío de los productos adquiridos
            --%>
            <br><br><br><br><br><br><br>
            <form action="/GestionLibros/SvLibros" method=post>
                <table bgColor="#6A63F3" border=2 cellPadding=0 cellSpacing=0 width=300 nowrap>
                    <tbody><tr><td noWrap width=200>
                                <table width=200 nowrap>
                                    <tbody><tr>
                                            <td><br>
                                                <font size="3" face="Verdana, Helvetica">
                                                    <b>Usuario</font></b></td>
                                            <td><br>
                                                <input type="text" name="usuario" size="38">
                                            </td></tr><tr>
                                            <td>
                                                <font size="3" face="Verdana, Helvetica">
                                                    <b>Contraseña</font></b></td>
                                            <td>
                                                <input type="password" name="pwd" size="40">
                                            </td><br></tr>
                                    <tr><td><br></td></tr>

                                    <table cellspacing=4 cellpadding=0 border=0>
                                        <tr>
                                            <td><input type=submit name="boton" value="Inicio">&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                            <td><input type=reset></td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                            <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                            <td><input type=submit name="boton" value="Confirmar"></td>
                                        </tr>
                                    </table>
                    </tbody>
                </table>
                </td></tr></tbody>
                </table>
            </form>
        </center>
    </body>
</html>
