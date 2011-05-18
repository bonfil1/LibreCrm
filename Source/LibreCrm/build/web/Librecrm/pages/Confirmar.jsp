<%-- 
    Document   : Confirmar
    Created on : 5/05/2011, 02:18:31 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerrar Sesion | LibreCrm</title>
        <style type="text/css">
            #logo h1 {color:#666; letter-spacing:-1px; font-weight:normal;}
            #logo .title {color:#999; font-size:12px;}
        </style>
    </head>
    <body>
        <form action="/LibreCrm/SvLibreCrm" method="POST">
            <center>
                <div id="logo">
                    <h1>Desea cerrar su sesion realmente?</h1>
                    <span class='title'>De hacerlo su sesion sera cerrada completamente.</span>
                    <br><br>
                    <input type="submit" name="boton" value="Incio" >
                    <input type="submit" name="boton" value="Cerrar" >
                </div>
            </center>
        </form>
    </body>
</html>
