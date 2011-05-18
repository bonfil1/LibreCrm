<%-- 
    Document   : Confirmar
    Created on : 3/02/2011, 08:13:17 PM
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
        <title>Confirme    |   Hoja de apuntes</title>

        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
    </head>
    <body>
        <form action="/TimeSheet/SvAgenda" method="POST">
            <center>
                <h1>Desea cerrar su sesion realmente?</h1>
                <input type="submit" name="boton" value="Incio" >
                <input type="submit" name="boton" value="Cerrar" >
            </center>
        </form>
        
    </body>
</html>

