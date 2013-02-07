<%-- 
    Document   : Bievenida
    Created on : 21/03/2011, 08:34:46 AM
    Author     : Jose Angel Bonfil Evia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Bienvenido</title>

        <!--Styles-->
        <link rel="stylesheet" href="Librecrm/css/libre-style.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/nyroModal.css" type="text/css" />

        <!--JavaScript-->
        <script type="text/javascript" src="Librecrm/js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="Librecrm/js/jquery.nyroModal.custom.min.js"></script>
    </head>
    <body>
        <form action="/LibreCrm/SvLibreCrm" method="POST">
            <div id="wrapper">
                <div id="titulo2">LAT CRM</div>
                <div id="cabezera">
                    <div id="header2">Bienvenido</div>
                    <div id="opciones">
                        <div id="mail_check">1</div>
                        &nbsp;Bienvenido(a): &nbsp;<a href="/LibreCrm/SvLibreCrm?link=detalles">${sessionScope.nickname}</a> | 
                        <a href="/LibreCrm/SvLibreCrm?link=salir&sesion=cerrar" class="nyroModal">Salir</a>
                        <script type="text/javascript">
                            $(function() {
                                $('.nyroModal').nyroModal();
                            });
                        </script>
                    </div>
                </div>
                <div id="innerbody">
                    <table border="0" width="100%">
                        <tr>
                            <td width="20%">
                                <div id="contentMenu">
                                    <table border="0" width="100%">
                                        <tr>
                                            <td class="menuItem"><a href="/LibreCrm/SvLibreCrm?link=inicio">Inicio</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="/LibreCrm/SvLibreCrm?link=resumen">Resumen</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="#">Cuentas</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="#">Contactos</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="#">Oportunidades</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="#">Emails</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="#">Campañas</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="#">Reportes</a></td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                            <td width="80%">
                                <div id="content">
                                    <div id="grupo_header">
                                        Bievenido a LATCRM
                                    </div>
                                    <div id="activdades">
                                        Actividades
                                        <table border="0" width="100%" id="actividad">
                                            <thead>
                                                <tr>
                                                    <th class="cabezera">Actividad de</th>
                                                    <th class="cabezera">Nombre Actividad</th>
                                                    <th class="cabezera">Fecha</th>
                                                </tr>
                                            </thead>
                                            <%-- Filas --%>
                                            <%--
                                                Recogemos los valores de cada pedido
                                            --%>
                                            <tbody>
                                                <c:choose>
                                                    <c:when test="${not empty sessionScope.hayActividades}">
                                                        <c:forEach var="fila" items="${sessionScope.actividadCuenta}">
                                                            <tr class="fila1">
                                                                <td>Cuentas</td>
                                                                <td>${fila.name}</td>
                                                                <td>${fila.date_entered}</td>
                                                            </tr>                                                            
                                                        </c:forEach>
                                                        <c:forEach var="fila_camp" items="${sessionScope.actividadCampanias}">
                                                            <tr class="fila2">
                                                                <td>Campañas</td>
                                                                <td>${fila_camp.name}</td>
                                                                <td>${fila_camp.date_entered}</td>
                                                            </tr>
                                                        </c:forEach>
                                                        <c:forEach var="fila_cntct" items="${sessionScope.actividadContacts}">
                                                            <tr class="fila1">
                                                                <td>Contactos</td>
                                                                <td>${fila_cntct.first_name} ${fila_cntct.last_name}</td>
                                                                <td>${fila_cntct.date_entered}</td>
                                                            </tr>
                                                        </c:forEach>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <tr>
                                                            <td>No hay </td>
                                                            <td>Actividad reciente</td>
                                                        </tr>
                                                    </c:otherwise>
                                                </c:choose>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div id="reportes">
                                        Reportes
                                        <table border="0" width="100%">
                                            <tr>
                                                <th class="cabezera">Reporte</th>
                                                <th class="cabezera">Fecha</th>
                                            </tr>
                                            <tr>
                                                <td>Reporte 1</td>
                                                <td>01/01/2011</td>
                                            </tr>
                                        </table>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>
