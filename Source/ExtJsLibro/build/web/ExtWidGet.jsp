<%-- 
    Document   : ExtWidGet
    Created on : 20/03/2011, 03:36:11 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ExtJs WidGet</title>
        <%-- ExtJs CSS--%>
        <link rel="stylesheet" type="text/css"
              href="http://localhost/extjs/resources/css/ext-all.css" />
        <link rel="stylesheet" type="text/css"
              href="css/style.css" />

        <%-- ExtJs JS--%>
        <script src="http://localhost/extjs/adapter/ext/ext-base.js"></script>
        <script src="http://localhost/extjs/ext-all-debug.js"></script>
        <%-- ExtJs Strings en Español--%>
        <script src="http://localhost/extjs/src/locale/ext-lang-es.js"></script>
        
        <%-- Contiene la funcion widget --%>
        <script src="js/widget.js"></script>
        <script>
            Ext.onReady(function(){               
                widtget();
            });            
        </script>
    </head>
    <body>
        <h1>Hello World ExtJs WidGet!</h1>
    </body>
</html>
