<%-- 
    Document   : Cuentas
    Created on : 28/03/2011, 05:50:53 PM
    Author     : Jose Angel Bonfil Evia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Cuentas</title>

        <!--Styles-->
        <link rel="stylesheet" href="../css/libre-style.css" type="text/css" />
    </head>
    <body>
        <form action="Librecrm/pages/Bievenida.jsp" method="POST">
            <div id="wrapper">
                <div id="titulo2">LAT CRM</div>
                <div id="cabezera">
                    <div id="header2">Cuentas</div>
                    <div id="opciones">
                        <div id="mail_check">2</div>
                        &nbsp;Bienvenido(a): &nbsp;<a href="#">Usuario</a> | <a href="#">Salir</a>
                    </div>
                </div>
                <div id="innerbody">
                    <table border="0" width="100%">
                        <tr>
                            <td width="20%">
                                <div id="contentMenu">
                                    <table border="0" width="100%">
                                        <tr>
                                            <td class="menuItem"><a href="#">Inicio</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="#">Resumen</a></td>
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
                                <div id="content2">
                                    Cuentas actuales
                                    <table width="100%" border="0">
                                        <tr>
                                            <td width="90%" colspan="2" class="menus"></td>
                                            <td width="5%" class="menus">
                                                <input type="image" src="../img/icons/cuentas.png" name="boton" value="VerNueva">
                                            </td>
                                            <td width="5%" class="menus">
                                                <input type="image" src="../img/icons/cuenta_nueva.png" name="boton" value="CuentaNueva">
                                            </td>
                                        </tr>
                                    </table>
                                    <table width="100%" border="0">
                                        <tr>
                                            <th class="cabezera">Cuenta</th>
                                            <th class="cabezera">Relacionado con</th>
                                            <th class="cabezera">Asignado a </th>
                                            <th class="cabezera">Fecha Creada</th>
                                            <th class="cabezera">Descripcion</th>
                                            <th class="cabezera">Tipo de cuenta</th>                                            
                                        </tr>
                                        <tr>
                                            <td>Pemex, exploracion y produccion</td>
                                            <td>Pemex</td>
                                            <td>Jose Angel Bonfil Evia</td>
                                            <td>01/01/2011</td>
                                            <td>Compañia petrolera nacional</td>
                                            <td>Prospectando</td>
                                        </tr>
                                    </table>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>