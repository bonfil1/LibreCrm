<%-- 
    Document   : Registro
    Created on : 1/02/2011, 08:09:32 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2011">
        <title>Registro    |   Hoja de apuntes</title>

        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
    </head>
    <body>
        <form action="/TimeSheet/SvAgenda" method="POST">
            <h1>Registrese</h1>
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
            </center>
        </form>
    </body>
</html>
