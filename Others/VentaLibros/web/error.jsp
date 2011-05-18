<%-- 
    Document   : error
    Created on : 27/06/2010, 10:55:22 AM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h3>Ocurrio un error al procesar su tutoria</h3>
        <br>Informacion del error proporcionada por el sistema:<br>
        <font color="#FF0000">
            Excepcion: ${pageContext.errorData.throwable}<br>
            Peticion que fallo: ${pageContext.errorData.requestURI}<br>
            Codigo de error: ${pageContext.errorData.statusCode}<br>
            Servlet: ${pageContext.errorData.servletName}
        </font>
    </body>
</html>
