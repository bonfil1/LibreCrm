<%-- 
    Document   : index
    Created on : 31/01/2011, 08:04:27 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2011">
        <title>Login    |   Hoja de apuntes</title>

        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
    </head>
    <body>
        <form action="/TimeSheet/SvAgenda" method="POST">
            <c:if test="${sessionScope.nick != null}">
                <h1>Hoja de notas de ${sessionScope.nick} ,&nbsp link: ${param.link}</h1>
            </c:if>
            <c:if test="${sessionScope.nick == null}">
                <h1>Hoja de notas de invitado ,&nbsp link: ${param.link}</h1>
            </c:if>
            <hr>
            <center>
                <br>
                <table width="100%" border="0">
                    <tr>
                        <td width="70%"></td>
                        <td width="10%" align="right"><a href="/TimeSheet/SvAgenda?link=inicio">Inicio</a></td>
                        <td width="10%" align="center">| <a href="/TimeSheet/SvAgenda?link=registro">Registrarse</a> |</td>
                        <td width="10%" align="left"><a href="/TimeSheet/SvAgenda?link=salir&sesion=cerrar">Salir</a></td>
                    </tr>
                </table>
                
                <br>
                <br>
                <br>
                <table width="25%" border="0" bgcolor="#ccccff">
                    <tr>
                        <th colspan="2">Inicie Sesion</th>
                    </tr>
                    <tr>
                        <td align="right">Usuario:&nbsp</td>
                        <td><input type="text" name='usuario' size='30' maxlength="30" style="height: 20px; font-size: 13pt;"></td>
                    </tr>
                    <tr>
                        <td align="right">Contraseña:&nbsp</td>
                        <td><input type="password" name='password' size='30' maxlength="30" style="height: 20px; font-size: 13pt;"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right"><input type= "reset" value="Borrar">&nbsp<input type="submit" name="boton" value='Iniciar'></td>
                    </tr>
                </table>

            </center>
        </form>
            <c:if test="${sessionScope.error != null}">
                <br><br>
                <center>
                <font color="#ff0000" face="Arial">
                    Un eror a ocurrido duranre el inicion de sesion<br>
                    ${sessionScope.error}
                </font>
                </center>
            </c:if>
    </body>
</html>
