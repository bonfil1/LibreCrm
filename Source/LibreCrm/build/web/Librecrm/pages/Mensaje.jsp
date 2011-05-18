<%-- 
    Document   : Mensaje
    Created on : 3/02/2011, 07:50:09 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2011">
        <title>Mensaje    |   LibreCrm</title>

        <!--Styles-->
        <link rel="stylesheet" href="Librecrm/css/libre-style.css" type="text/css" />
    </head>
    <body>
        <div id="mensaje">
            <h1>${requestScope.mensaje}</h1><br/>
            <h1>${sessionScope.mensaje}</h1>
        </div>
    </body>
</html>
