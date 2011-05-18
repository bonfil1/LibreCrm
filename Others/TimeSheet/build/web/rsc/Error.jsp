<%-- 
    Document   : Error
    Created on : 31/01/2011, 09:43:58 PM
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
        <title>Error ${sessionScope.errorUsuario}    |   Hoja de apuntes</title>

        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
    </head>
    <body>
        <h2>Ocurrio un error!</h2>
        <h3><font color="#cc0000">Error: ${sessionScope.errorUsuario}</font></h3>
    </body>
</html>
