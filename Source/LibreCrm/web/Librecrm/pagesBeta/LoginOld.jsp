<%-- 
    Document   : index
    Created on : 21/03/2011, 08:30:26 AM
    Author     : Jose Angel Bonfil Evia
    Description: LibreCrm index
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Inicio de sesion</title>

        <!--Styles-->
        <link rel="stylesheet" href="Librecrm/css/style.css" type="text/css" />
    </head>
    <body>
        <form action="/LibreCrm/SvLibreCrm" method="POST">
            <div id="wrapper">
                <div id="titulo">LAT CRM</div>
                <div id="header">Inicio de sesion</div>
                <div id="panel">
                    <table width="25%" border="0" class="login">
                        <tr>
                            <th colspan="2" class="cabezera">Inicie Sesion</th>
                        </tr>
                        <tr>
                            <td align="right">Usuario:&nbsp</td>
                            <td><input type="text" name='usuario' size='30' maxlength="30" style="height: 20px; font-size: 13pt;"></td>
                        </tr>
                        <tr>
                            <td align="right">Contraseña:&nbsp</td>
                            <td><input type="password" name='password' size='30' maxlength="30" style="height: 20px; font-size: 13pt;"></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right"><input type= "reset" value="Borrar">&nbsp<input type="submit" name="boton" value='Iniciar'></td>
                        </tr>
                    </table>
                    <br><br>
                    <c:if test="${sessionScope.loginError != null}">
                        <div id="errorDiag">                            
                            Error! Duranre el inicio de sesion: <br/>
                            ${sessionScope.loginError}<br/>
                            <img alt="Error"  src="Librecrm/img/pckImgs/error2.png">
                        </div>
                    </c:if>
                </div>
                <div id="footer">Basado en LibreCrm, creado por jose angel bonfil evia</div>
            </div>
        </form>
    </body>
</html>
