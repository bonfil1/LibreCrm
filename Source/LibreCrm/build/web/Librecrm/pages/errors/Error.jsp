<%-- 
    Document   : Error
    Created on : 9/05/2011, 11:53:56 AM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="true" %>
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
        <style type="text/css">
            .systemException {
                border: 1px outset lightgrey;
                padding: 3px;
                background-color: lightgrey;
                text-align: left;
                overflow: auto;
                font-family: Verdana, Helvetica, sans-serif;
                font-size: .8em;
            }
            .systemException div {
                border: 1px inset lightgrey;
                padding: 4px;
            }
            .systemException h1 {
                background-color: #154268;
                padding: 4px;
                color: #fff;
                margin: 0 0 3px 0;
                font-size: 1.15em;
            }
            .systemException h2 {
                font-size: 1.1em;
                margin-bottom: 0;
                text-align: center;
            }
            .systemException pre, .systemException p {
                margin: 0;
            }
            .systemException pre {
                font-size: .85em;
                font-family: "Courier New";
            }
        </style>        
    </head>
    <body >
        <div class="systemException">
            <h1>Fatal error: ${requestScope.error}<br /></h1>
            <div>
                <b>Error:</b><pre>${requestScope.error}</pre>
                <b>Detailed error:</b><pre>${requestScope.errorDetail}</pre>
                <br />
                <p>Sucedio un error durante la navegacion </p>
                <p>Intenta con uno de estos botones</p>
            </div>
            <a href="/LibreCrm/SvLibreCrm?link=inicio" title="Inicio">
                <h2>Inicio</h2>
            </a>
            <a href="/LibreCrm/SvLibreCrm?link=contacto" title="Contacto...">
                <h2>Contacto con el staff de librecrm</h2>
            </a>
        </div>
    </body>
</html>
