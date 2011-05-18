
<%-- 
    Document   : ControlPanelBeta
    Created on : 8/02/2011, 09:04:45 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2011">
        <title>Control Panel (Beta)   |   Hoja de apuntes</title>

        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
    </head>
    <body>
        <form action="/TimeSheet/SvAgenda" method="POST">
            <h1>${sessionScope.nick}</h1>
            <div id="cargando" style="display:none; color: green;">Cargando...</div>
            <hr>
            <center> <!--Menu-->
                <br>
                <table width="100%" border="0">
                    <tr>
                        <td width="70%"></td>
                        <td width="10%" align="right"><a href="/TimeSheet/SvAgenda?link=inicio" id="enlaceAjax">Inicio</a></td>
                        <td width="10%" align="center">| <a href="/TimeSheet/SvAgenda?link=nueva">Nueva nota</a> |</td>
                        <td width="10%" align="left"><a href="/TimeSheet/SvAgenda?link=salir&sesion=cerrar">Salir</a></td>
                    </tr>
                </table>

                <div id="ControlPanel">
                    <h2>Tus notas</h2>

                    <table width="100%" border="0"><!--Entradas-->
                        <tr>
                            <th width="70%">Titulo</th>
                            <th width="30%">Fecha</th>
                        </tr>
                        <tr>
                            <td>Entrada del primer dia de actividades</td>
                            <td align="center">31/01/2011</td>
                        </tr>
                    </table><!--//Entradas-->
                </div>
            </center><!--//Menu-->
        </form>
    </body>
</html>

