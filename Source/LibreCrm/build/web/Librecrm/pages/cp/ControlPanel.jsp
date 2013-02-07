<%-- 
    Document   : ControlPanel
    Created on : 20/06/2011, 01:44:55 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Control Panel</title>

        <!--Styles-->
        <link rel="stylesheet" href="Librecrm/css/libre-style.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/cp-style.css" type="text/css" />

    </head>
    <body>
        <form action="/LibreCrm/SvLibreCrm" method="POST">            
            <div id="contentCP">
                <div id="cabezera">Panel de control</div>
                <div id="fila1">
                    <div id="inicio"><a href="/LibreCrm/SvLibreCrm?link=inicio"><img src="Librecrm/img/menu/inicio.png" alt="Inicio"> <br>Inicio</a></div>
                    <div id="usuarios"><a href="/LibreCrm/SvLibreCrm?link=usuarios"><img src="Librecrm/img/menu/Usuarios.png" alt="Usuarios"> <br>Usuarios</a></div>
                </div>
                <div id="fila2">
                    <div id="comentarios"><a href="#"><img src="Librecrm/img/menu/coments.png" alt="Comentarios"> <br>Comentarios</a></div>
                    <div id="config"><a href="#"><img src="Librecrm/img/menu/opciones.png" alt="Configuracion"> <br>Configuracion</a></div>
                </div>
            </div>
        </form>
    </body>
</html>