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

        <!--JavaScript-->
        <script type="text/javascript" src="Librecrm/js/jquery-1.5.1.js"></script>
        <!--FrameWork para la creacion dinamica de charts-->
        <script type="text/javascript" src="Librecrm/js/jquery.sparkline.js"></script>
        <script type="text/javascript">
            $(function() {
                /** This code runs when everything has been loaded on the page */
                /* Inline sparklines take their values from the contents of the tag */
                $('.inlinesparkline').sparkline();

                /* Sparklines can also take their values from the first argument
                passed to the sparkline() function */
                var myvalues = [10,8,5,7,4,4,1];
                $('.dynamicsparkline').sparkline(myvalues);

                /* The second argument gives options such as chart type */
                $('.dynamicbar').sparkline(myvalues, {type: 'bar', barColor: 'green'} );

                /* Use 'html' instead of an array of values to pass options
                to a sparkline with data in the tag */
                $('.piechart').sparkline('html', {type: 'pie', barColor: 'red', width: '200', height: '200'} );
                $('.sparklines').sparkline('html', { enableTagOptions: true, width: '200', height: '200' });
            });
        </script>
        <script type="text/javascript" src="Librecrm/js/jquery.nyroModal.custom.min.js"></script>
        
    </head>
    <body>
        <form action="Librecrm/pages/Bievenida.jsp" method="POST">
            <div id="wrapper">
                <div id="titulo2">LAT CRM</div>
                <div id="cabezera">
                    <div id="header2">Resumen de actividades</div>
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
                                        Resumen de actividades personal de usuario
                                    </div>
                                    <div id="grupo_fila1">
                                        <div id="activdades">
                                            Actividades
                                            <table border="0" width="100%">
                                                <tr>
                                                    <th class="cabezera">Nombre Actividad</th>
                                                    <th class="cabezera">Fecha</th>
                                                </tr>
                                                <tr>
                                                    <td>Actividad 1</td>
                                                    <td>01/01/2011</td>
                                                </tr>
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
                                    <div id="grupo_fila2">
                                        <div id="graficas">
                                            Graficas Oportunidades<br>
                                            <span class="piechart">10,1,1,2,2,1</span>
                                            <!--<span class="sparklines" sparkType="bar" sparkBarColor="green">10,2,3,4,3,2,1</span>-->
                                        </div>
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
