<%-- 
    Document   : DetallesCuenta
    Created on : 29/03/2011, 03:32:14 PM
    Author     : Jose Angel Bonfil Evia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Detalles de la Cuenta, ${param.cuenta}</title>

        <!--Styles-->
        <link rel="stylesheet" href="../css/libre-style.css" type="text/css" />
    </head>
    <body>
        <form action="Librecrm/pages/Bievenida.jsp" method="POST">
            <div id="wrapper">
                <div id="titulo2">LAT CRM</div>
                <div id="cabezera">
                    <div id="header2">Detalles Cuenta</div>
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
                                    Detalles de la Cuenta, ${param.cuenta}
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
                                    <div id="formulario_cuenta">
                                        <table width="80%" border="0">
                                            <tr>
                                                <td align="right">Nombre de la cuenta</td>
                                                <td>Pemex, Exploracion y produccion</td>
                                            </tr>
                                            <tr>
                                                <td align="right">Asignado a</td>
                                                <td>Jose Angel Bonfil Evia</td>
                                            </tr>
                                            <tr>
                                                <td align="right">Tipo de Cuenta</td>
                                                <td>Prospectando</td>
                                            </tr>
                                            <tr>
                                                <td align="right">Industria</td>
                                                <td>Petrolera</td>
                                            </tr>
                                            <tr>
                                                <td align="right">Telefono</td>
                                                <td>9999999999</td>
                                            </tr>
                                            <tr>
                                                <td align="right">Fax</td>
                                                <td>9999999999</td>
                                            </tr>
                                            <!-- Creacion de Tablas para las direcciones -->
                                            <tr>

                                                <td width="50%"><!-- Tabla 1 Billing Address -->
                                                    <table border="0" width="100%" class="direccion">
                                                        <tr>
                                                            <th colspan="2" class="cabezera">Direccion de Facturacion</th>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Calle</td>
                                                            <td>Av.- 27 de febrero</td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Ciudad</td>
                                                            <td>Villahermosa</td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Estado</td>
                                                            <td>Tabasco</td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Codigo Postal</td>
                                                            <td>86090</td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Pais</td>
                                                            <td>Mexico</td>
                                                        </tr>
                                                    </table>
                                                </td><!-- /Tabla 1 Billing Address -->

                                                <td width="50%"><!-- Tabla 2 Shipping Address -->
                                                    <table border="0" width="100%" class="direccion">
                                                        <tr>
                                                            <th colspan="2" class="cabezera">Direccion de Entrega</th>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Calle</td>
                                                            <td>Av.- 27 de febrero</td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Ciudad</td>
                                                            <td>Villahermosa</td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Estado</td>
                                                            <td>Tabasco</td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Codigo Postal</td>
                                                            <td>86090</td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Pais</td>
                                                            <td>Mexico</td>
                                                        </tr>
                                                    </table>
                                                </td><!-- /Tabla 2 Shipping Address -->
                                            </tr>
                                            <!-- /Creacion de Tablas para las direcciones -->
                                            <tr>
                                                <td align="right">Descripcion</td>
                                                <td>Division de exploracion y produccion de pemex</td>
                                            </tr>
                                            <tr>
                                                <td align="right">Sitio Web</td>
                                                <td>www.pemex-exploracion-produccion.com</td>
                                            </tr>
                                            <tr>
                                                <td colspan="2" align="right">
                                                    <input type="image" src="../img/icons/salir.png" name="boton" value="Salir">
                                                    <input type="image" src="../img/icons/encuesta.png" name="boton" value="Editar">
                                                </td>
                                            </tr>
                                        </table><br>
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