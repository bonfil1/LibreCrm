<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%-- página JSP MostrarMensaje.jsp --%>
<%@page contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Mensaje Informativo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2010">
    </head>

    <body bgcolor="#FFFFFF">
        <center>
            <h1><font face="Verdana,Helvetica"><b>MENSAJE INFORMATIVO</b></font></h1>
            <br><br>

            <%-- Mostrar el mensaje correspondiente --%>
            <font face="Verdana,Helvetica" size="2" color="#000000">
                <b>${requestScope.mensaje}</b></font>

            <br><br><br>

            <%-- Volver a la pantalla inicial de la aplicación --%>
            <form action="/GestionLibros/SvLibros" method=post>
                <input type="submit" name="boton"
                       value="Inicio">&nbsp;&nbsp;&nbsp;&nbsp;
            </form>
        </center>
    </body>
</html>

