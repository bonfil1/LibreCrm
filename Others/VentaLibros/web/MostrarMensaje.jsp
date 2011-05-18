<%-- 
    Document   : MostrarMensaje
    Created on : 5/12/2010, 06:10:54 PM
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
        <title>Libros.com   |   Mensaje</title>

         <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
    </head>
    <body>
        <center>
            <h1><font face="Verdana,Helvetica"><b>MENSAJE INFORMATIVO</b></font></h1>
            <br><br>

            <%-- Mostrar el mensaje correspondiente --%>
            <font face="Verdana,Helvetica" size="2" color="#000000">
                <b>${requestScope.mensaje}</b></font>

            <br><br><br>

            <%-- Volver a la pantalla inicial de la aplicación --%>
            <form action="/VentaLibros/SvLibros" method=post>
                <input type="submit" name="boton"
                       value="Inicio">&nbsp;&nbsp;&nbsp;&nbsp;
            </form>
        </center>
    </body>
</html>
