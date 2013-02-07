<%--
    Document   : Resumen
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
        <title>LibreCrm | Resumen</title>

        <!--Styles-->
        <link rel="stylesheet" href="Librecrm/css/libre-style.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/nyroModal.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/plugins/Flexigrid/css/flexigrid.css" type="text/css" />

        <!--JavaScript-->
        <script type="text/javascript" src="Librecrm/js/jquery-1.5.1.js"></script>
        <!--FrameWork para la creacion dinamica de charts-->
        <script type="text/javascript" src="Librecrm/js/jquery.sparkline.js"></script>
        <script type="text/javascript">
            $(function() {                
                /* Use 'html' instead of an array of values to pass options
                to a sparkline with data in the tag */
                $('.piechart').sparkline('html', {type: 'pie', barColor: 'red', width: '200', height: '200'} );
                $('.sparklines').sparkline('html', { enableTagOptions: true, width: '200', height: '200' });
            });
        </script>
        <script type="text/javascript" src="Librecrm/js/jquery.nyroModal.custom.min.js"></script>
        <script type="text/javascript" src="Librecrm/plugins/Flexigrid/js/flexigrid.js"></script>
        <script type="text/javascript" src="Librecrm/js/TablaGrid.js"></script>
    </head>
    <body>
        <form action="/LibreCrm/SvLibreCrm" method="POST">
            <div id="wrapper">
                <div id="titulo2">LAT CRM</div>
                <div id="cabezera">
                    <div id="header2">Resumen de actividades</div>
                    <div id="opciones">
                        <div id="mail_check">1</div>
                        &nbsp;Bienvenido(a): &nbsp;<a href="/LibreCrm/SvLibreCrm?link=detalles">${sessionScope.nickname}</a> |
                        <c:if test="${sessionScope.isadmin == 1}">
                            <a href="/LibreCrm/SvLibreCrm?link=administrar" class="nyroModal">CP</a> |
                        </c:if>
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
                                            <td class="menuItem"><a href="/LibreCrm/SvLibreCrm?link=cuentas">Cuentas</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="/LibreCrm/SvLibreCrm?link=contactos">Contactos</a></td>
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
                                        Resumen de actividades personal de usuario
                                    </div>
                                    <div id="grupo_fila1">
                                        <div id="activdades">
                                            <label for="lista">Seleccione una Categoria</label>
                                            <select size="1" name='opcion'>
                                                <option selected value="1">Cuentas</option>
                                                <option value="2">Campañas</option>
                                                <option value="3">Contactos</option>
                                                <option value="4">Oportunidades</option>
                                                <option value="5">Pvd</option>
                                                <option value="6">Rad</option>
                                            </select>
                                            <input type="submit" name="boton" value="Consultar">
                                            <br /><br />
                                            <table border="0" width="100%" class="flexme">
                                                <thead>
                                                    <tr>
                                                        <th width="200">Nombre</th>
                                                        <th width="200">Fecha Creada</th>
                                                        <th width="300">Descripcion</th>
                                                        <th width="100">Editar</th>
                                                        <th width="100">Eliminar</th>
                                                    </tr>
                                                </thead>
                                                <%-- Filas --%>
                                                <%--
                                                    Recogemos los valores de cada pedido
                                                --%>
                                                <tbody>
                                                    <c:forEach var="fila" items="${sessionScope.actividad}">                                                        
                                                        <tr>
                                                            <td>${fila.name} ${fila.cont_first_name} ${fila.cont_last_name}</td>
                                                            <td>${fila.date_entered}</td>
                                                            <td>${fila.description}</td>
                                                            <td><a href="/LibreCrm/SvLibreCrm?link=${requestScope.opcionEdit}&id=${fila.id}">Editar</a> </td>
                                                            <td><a href="/LibreCrm/SvLibreCrm?link=${requestScope.opcionElim}&id=${fila.id}">Eliminar</a> </td>
                                                        </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                            <script type="text/javascript">
                                                flexGrid("Lista de actividades");
                                            </script>
                                        </div>

                                    </div>
                                    <div id="grupo_fila2">

                                        <div id="graficas2">
                                            Graficas Oportunidades<br>
                                            <span class="sparklines" sparkType="line" sparkBarColor="#00f">5,2,3,4,3,2,1,3,2,3,4,3,2,1</span>
                                        </div>
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
