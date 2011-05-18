<%-- 
    Document   : Error
    Created on : 8/05/2011, 10:46:39 PM
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
        <title>Error ${requestScope.error}    |   LibreCrm</title>

        <!--Styles-->
        <style>
            body {background: #f9fee8;margin: 0; padding: 20px; text-align:center; font-family:Arial, Helvetica, sans-serif; font-size:14px; color:#666666;}
            .error_page {width: 600px; padding: 50px; margin: auto;}
            .error_page h1 {margin: 20px 0 0;}
            .error_page p {margin: 10px 0; padding: 0;}
            a {color: #9caa6d; text-decoration:none;}
            a:hover {color: #9caa6d; text-decoration:underline;}
        </style>
    </head>
    <body >
        <div class="error_page">
            <h1>404 el link seleccionado no ha sido encontrado!</h1><br/>
            <img src="../Librecrm/img/pckImgs/Failure.png" alt="404">
            <h1>${sessionScope.mensaje}</h1>
            <p><a href="/LibreCrm/SvLibreCrm">Regresar al Inicio</a></p>
        </div>
    </body>
</html>
