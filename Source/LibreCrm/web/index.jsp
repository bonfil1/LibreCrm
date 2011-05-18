<%-- 
    Document   : index
    Created on : 21/03/2011, 08:25:25 AM
    Author     : Jose Angel Bonfil Evia
    Description: LibreCrm index
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <center>
            <font color="RED" face="sans-serif">
                <h2>Por el momento LibreCrm esta ofline! <br> intenta mas tarde</h2> 
                <img src="Librecrm/img/pckImgs/error2.png" />
                <input type="image" src="Librecrm/img/pckImgs/reload.png" onclick="document.location.reload();">
            </font>
        </center>
        <jsp:forward page="Librecrm/Login.jsp"></jsp:forward>
    </body>
</html>
