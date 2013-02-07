<%-- 
    Document   : ConfirmarBorrar
    Created on : 13/06/2011, 08:12:29 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Borrar | LibreCrm</title>
        <style type="text/css">
            #logo h1 {color:#666; letter-spacing:-1px; font-weight:normal;}
            #logo h2 {color:#333; letter-spacing:-1px; font-weight:normal;}
            #logo .title {color:#999; font-size:12px;}
        </style>
    </head>
    <body>
        <form action="/LibreCrm/SvLibreCrm" method="POST">
            <center>
                <div id="logo">
                    <h1>Desea eliminar esta Cuenta realmente?</h1>
                    <c:forEach var="fila" items="${requestScope.borrar}">
                        <input type="hidden" name="id" value="${fila.id}">
                        <h2>Nombre: ${fila.name}</h2>
                        <h2>RFC: ${fila.rfc}</h2>
                        <h2>Creado el ${fila.date_entered}</h2>
                        <h2>Descripcion: ${fila.description}</h2>
                    </c:forEach>
                    <br><br>
                    <input type="submit" name="boton" value="Incio" >
                    <input type="submit" name="boton" value="Borrar Cuenta" >
                </div>
            </center>
        </form>
    </body>
</html>