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
        <link rel="stylesheet" href="../plugins/jQtransform/jqtransform.css" type="text/css" />

        <!--JavaScript-->
        <script type="text/javascript" src="../js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="../plugins/jQtransform/jquery.jqtransform.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            $(function() {
                //find all form with class jqtransform and apply the plugin
                $("form.jqtransform").jqTransform();
            });
        </script>
        <form action="#" method="POST" class="jqtransform">
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
                                            <td class="menuItem"><a href="/LibreCrm/SvLibreCrm?link=oportunidades">Oportunidades</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="/LibreCrm/SvLibreCrm?link=emails">Emails</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="/LibreCrm/SvLibreCrm?link=campañas">Campañas</a></td>
                                        </tr>
                                        <tr>
                                            <td class="menuItem"><a href="/LibreCrm/SvLibreCrm?link=reportes">Reportes</a></td>
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
                                        <div class="rowElem">
                                            <label for="cuenta">Nombre de la cuenta</label>
                                            <input type="text" name="cuenta" size="40"/>
                                        </div>
                                        <div class="rowElem">
                                            <label for="asignado">Asignado a</label>
                                            <select name="asigando">
                                                <option value = "1"> Jose Bonfil
                                                <option selected value = "2"> Pepe Evia
                                                <option value = "3"> Angel Bonfil
                                            </select>
                                        </div>
                                        <div class="rowElem">
                                            <label for="tipo_cuenta">Tipo de Cuenta</label>
                                            <select name="tipo_cuenta">
                                                <option value = "1"> Evuluando
                                                <option selected value = "2"> Prospectando
                                                <option value = "3"> Entrevistando
                                            </select>
                                        </div>
                                        <div class="rowElem">
                                            <label for="indsutria">Industria</label>
                                            <input type="text" name="indsutria" size="40"/>
                                        </div>
                                        <div class="rowElem">
                                            <label for="telefono">Telefono</label>
                                            <input type="text" name="telefono" size="40"/>
                                        </div>
                                        <div class="rowElem">
                                            <label for="fax">Fax</label>
                                            <input type="text" name="fax" size="40"/>
                                        </div>
                                        <div class="rowElem">
                                            <input type="submit" value="send"/>
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