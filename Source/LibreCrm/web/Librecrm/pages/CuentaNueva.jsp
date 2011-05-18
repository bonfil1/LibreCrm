<%-- 
    Document   : CuentaNueva
    Created on : 28/03/2011, 06:36:24 PM
    Author     : Jose Angel Bonfil Evia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Cuenta Nueva</title>

        <!--Styles-->
        <link rel="stylesheet" href="../css/libre-style.css" type="text/css" />
    </head>
    <body>
        <form action="#" method="POST">
            <div id="wrapper">
                <div id="titulo2">LAT CRM</div>
                <div id="cabezera">
                    <div id="header2">Creacion de Cuenta</div>
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
                                    <div id="formulario_cuenta">
                                        <table width="80%" border="0">
                                            <tr>
                                                <td align="right">Nombre de la cuenta</td>
                                                <td><input type="text" name='cuenta' size='30' maxlength="30" class="textfields"></td>
                                            </tr>                                            
                                            <tr>
                                                <td align="right">Asignado a</td>
                                                <td>
                                                    <select name="asigando_a">
                                                        <option value = "1"> Jose Bonfil
                                                        <option selected value = "2"> Pepe Evia
                                                        <option value = "3"> Angel Bonfil
                                                    </select>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td align="right">Tipo de Cuenta</td>
                                                <td>
                                                    <select name="tipo_cuenta">
                                                        <option value = "1"> Evuluando
                                                        <option selected value = "2"> Prospectando
                                                        <option value = "3"> Entrevistando
                                                    </select>
                                                </td>                                                
                                            </tr>
                                            <tr>
                                                <td align="right">Industria</td>                                                
                                                <td><input type="text" name='indsutria' size='30' maxlength="30" class="textfields"></td>
                                            </tr>
                                            <tr>
                                                <td align="right">Telefono</td>
                                                <td><input type="text" name='telefono' size='30' maxlength="30" class="textfields"></td>
                                            </tr>
                                            <tr>
                                                <td align="right">Fax</td>
                                                <td><input type="text" name='fax' size='30' maxlength="30" class="textfields"></td>
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
                                                            <td><input type="text" name='calle_factura' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Ciudad</td>
                                                            <td><input type="text" name='ciudad_factura' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Estado</td>
                                                            <td><input type="text" name='estado_factura' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Codigo Postal</td>
                                                            <td><input type="text" name='codigo_postal' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Pais</td>
                                                            <td><input type="text" name='pais' size='30' maxlength="30" class="textfields"></td>
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
                                                            <td><input type="text" name='calle_entrega' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Ciudad</td>
                                                            <td><input type="text" name='ciudad_entrega' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Estado</td>
                                                            <td><input type="text" name='estado_entrega' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Codigo Postal</td>
                                                            <td><input type="text" name='codigo_postal_entrega' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                        <tr>
                                                            <td align="right">Pais</td>
                                                            <td><input type="text" name='pais_entrega' size='30' maxlength="30" class="textfields"></td>
                                                        </tr>
                                                    </table>
                                                </td><!-- /Tabla 2 Shipping Address -->
                                            </tr>
                                            <!-- /Creacion de Tablas para las direcciones -->
                                            <tr>
                                                <td align="right">Descripcion</td>
                                                <td><textarea name = "Descripcion" rows = "3" cols = "30" wrap tabindex = "3"></textarea></td>
                                            </tr>
                                            <tr>
                                                <td align="right">Sitio Web</td>
                                                <td><input type="text" name='website' size='30' maxlength="30" class="textfields"></td>
                                            </tr>
                                            <tr>
                                                <td></td>
                                                <td>                                                    
                                                    <input type="reset" value="Reiniciar">
                                                    <input type="submit" name="boton" value="GuardarCuenta">
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