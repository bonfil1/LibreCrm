<%-- 
    Document   : LoginBeta.jsp
    Created on : 5/05/2011, 12:03:02 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Inicio de sesion</title>
        <%-- ExtJs CSS--%>
        <link rel="stylesheet" type="text/css"
              href="http://localhost/extjs/resources/css/ext-all.css" />
        <link rel="stylesheet" type="text/css" href="http://localhost/extjs/resources/css/xtheme-gray.css" />
        <%-- LibreCrm CSS--%>
        <link rel="stylesheet" href="Librecrm/css/login_style.css" type="text/css" />
        <link rel="icon" type="image/x-icon" href="Librecrm/img/pckImgs/favicon.ico" />
        <link rel="shortcut icon" type="image/x-icon" href="Librecrm/img/pckImgs/favicon.ico" />

        <%-- ExtJs JS--%>
        <script src="http://localhost/extjs/adapter/ext/ext-base.js"></script>
        <script src="http://localhost/extjs/ext-all-debug.js"></script>
        <%-- ExtJs Strings en Español--%>
        <script src="http://localhost/extjs/src/locale/ext-lang-es.js"></script>


        <%-- Contiene la funcion widget Creada para LibreCrm--%>
        <script src="Librecrm/js/LoginWidget.js"></script>
        <script>
            Ext.onReady(function(){
                loginPanel();
            });
        </script>
    </head>
    <body>
        <div id="wrapper">
            <div id="titulo">LAT CRM</div>
            <div id="header">Inicio de sesion</div>
        </div>
        <br><br>
        <c:if test="${sessionScope.loginError != null}">
            <div id="errorDiag">
                Error! Duranre el inicio de sesion: <br/>
                ${sessionScope.loginError}<br/>
                <img alt="Error"  src="Librecrm/img/pckImgs/error2.png">
            </div>
        </c:if>
        <div id="footer">
            <p>&copy; 2011. All Rights Reserved. Design by Jose A. Bonfil Evia, Downloads & documentantion can be found at  <a href="https://github.com/bonfil1/LibreCRm">My personal GitHub</a>.</p>
        </div>
    </body>
</html>
