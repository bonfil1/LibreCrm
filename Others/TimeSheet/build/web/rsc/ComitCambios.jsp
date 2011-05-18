<%-- 
    Document   : ComitCambios
    Created on : 7/02/2011, 07:54:15 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2011">
        <title>Cambios en los datos    |   Hoja de apuntes</title>

        <!--Styles-->
        <link rel="stylesheet" href="../css/style.css" type="text/css" />
    </head>
    <body>
        <form action="/TimeSheet/SvAgenda" method="POST">
            <h1>${sessionScope.nick}</h1>
            <hr>
            <center> <!--Menu-->
                <br>
                <table width="100%" border="0">
                    <tr>
                        <td width="70%"></td>
                        <td width="10%" align="right"><a href="/TimeSheet/SvAgenda?link=inicio">Inicio</a></td>
                        <td width="10%" align="center">| <a href="/TimeSheet/SvAgenda?link=nueva">Nueva nota</a> |</td>
                        <td width="10%" align="left"><a href="/TimeSheet/SvAgenda?link=salir&sesion=cerrar">Salir</a></td>
                    </tr>
                </table>

                <div id="cambios">
                    Tus cambios son
                </div>
            </center><!--//Menu-->
        </form>
    </body>
</html>

