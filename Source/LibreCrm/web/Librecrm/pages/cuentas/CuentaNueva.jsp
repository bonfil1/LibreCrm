<%-- 
    Document   : CuentaNueva
    Created on : 28/03/2011, 06:36:24 PM
    Author     : Jose Angel Bonfil Evia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Cuenta Nueva</title>

        <!--Styles-->
        <link rel="stylesheet" href="Librecrm/css/libre-style.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/librecrmforms.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/nyroModal.css" type="text/css" />
        <!--Styles MarkItUP-->
        <link rel="stylesheet" href="Librecrm/plugins/markitup/skins/markitup/style.css" type="text/css" media="screen"/>
        <link rel="stylesheet" href="Librecrm/plugins/markitup/sets/html/style.css" type="text/css" media="screen" />

        <!--JavaScript-->
        <script type="text/javascript" src="Librecrm/js/jquery-1.5.1.js"></script>
        <!--NyroModal-->
        <script type="text/javascript" src="Librecrm/js/jquery.nyroModal.custom.min.js"></script>
        <!--JavaScript MarkitUP-->
        <script type="text/javascript" src="Librecrm/plugins/markitup/jquery.markitup.js"></script>
        <script type="text/javascript" src="Librecrm/plugins/markitup/sets/html/set.js"></script>

    </head>
    <body>
        <script type="text/javascript">
            $(document).ready(function() {
                var max = 0;
                $("label").each(function(){
                    if ($(this).width() > max)
                        max = $(this).width();
                });
                $("label").width(max);
            });
            function disableDir(){
                document.form.dirCalleEntrega.disabled=true;
            }
            function enableDir(){
                document.form.dirCalleEntrega.disabled=false;
            }
        </script>
        <form action="/LibreCrm/SvLibreCrm" method="POST">
            <div id="wrapper">
                <div id="titulo2">LAT CRM</div>
                <div id="cabezera">
                    <div id="header2">Creacion de Contacto</div>
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
                                <div id="content">
                                    <div id="grupo_header">
                                        Contactos
                                    </div>
                                    <div id="cuentas_toolbar">
                                        <div id="cToolbar">
                                            <input type="submit" name="boton" value="Nueva Cuenta +">
                                            <input type="submit" name="boton" value="Lista Cuentas >">
                                        </div>
                                    </div>
                                    <div id="cuentas">
                                        <div id="cuentas_layout">
                                            <div class="rowElem">
                                                <h3>Datos de la cuenta.</h3>
                                                <label for="cuenta">Nombre de la cuenta</label>
                                                <input type="text" name="cuenta" size="40"/>                                                
                                            </div>
                                            <div class="rowElem">
                                                <label for="rfc">R.F.C.</label>
                                                <input type="text" name="rfc" size="40"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="usr_asignado">Asigando a</label>
                                                <select name="usr_asignado">
                                                    <option selected value="0"> Seleccione...
                                                        <c:forEach var="fila" items="${requestScope.listaUsuariosSimple}">
                                                            <option value="${fila.id}">${fila.first_name} ${fila.last_name}
                                                        </c:forEach>
                                                </select>
                                            </div>
                                            <div class="rowElem">
                                                <label for="tipo_cuenta">Tipo de Cuenta</label>
                                                <select name="tipo_cuenta">
                                                    <option selected value="0"> Seleccione...
                                                    <option value = "1"> Evuluando
                                                    <option value = "2"> Prospectando
                                                    <option value = "3"> Entrevistando
                                                </select>
                                            </div>
                                            <div class="rowElem">
                                                <label for="status">Estado</label>
                                                <select name="status">
                                                    <option selected value="0">Seleccione...</option>
                                                    <option value="Activa">Activa</option>
                                                    <option value="Inactiva">Inactiva</option>
                                                    <option value="No asignado">No asignado</option>
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
                                                <label for="website">URL: </label>
                                                <input type="text" name="website" size="40"/>
                                            </div>
                                            <div class="rowElem">
                                                <textarea id="comentario" rows="4" cols="60" name="descripcion"></textarea>
                                                <script type="text/javascript" charset="utf-8">
                                                    $('#comentario').markItUp(mySettings);
                                                </script>
                                            </div>
                                            <div class="rowElem">
                                                <h3>Domicilio de Facturacion.</h3>
                                                <label for="dirCalleFact">Calle</label>
                                                <input type="text" name="dirCalleFact" size="25"/>

                                                <label for="dirCiudadFact">Ciudad</label>
                                                <input type="text" name="dirCiudadFact" size="25"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="dirEstadoFact">Estado</label>
                                                <input type="text" name="dirEstadoFact" size="25"/>

                                                <label for="dirCpFact">Codigo Postal</label>
                                                <input type="text" name="dirCpFact" size="25"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="dirPaisFact">Pais</label>
                                                <input type="text" name="dirPaisFact" size="40"/>
                                            </div>
                                            <div class="rowElem">
                                                <h3>Domicilio de Entrega.</h3>                                               
                                                <!--<a href="javascript:disableDir()">Misma que faturacion?</a><br>
                                                <a href="javascript:enableDir()">Diferente a faturacion?</a><br>-->
                                                Misma que facturacion?
                                                <input type = "checkbox" name = "copiardir" value = "1" checked><br>

                                                <label for="dirCalleEntrega">Calle</label>
                                                <input type="text" name="dirCalleEntrega" id="dirCalleEntrega" size="25"/>

                                                <label for="dirCiudadEntrega">Ciudad</label>
                                                <input type="text" name="dirCiudadEntrega" size="25"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="dirEstadoEntrega">Estado</label>
                                                <input type="text" name="dirEstadoEntrega" size="25"/>

                                                <label for="dirCpEntrega">Codigo Postal</label>
                                                <input type="text" name="dirCpEntrega" size="25"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="dirPaisEntrega">Pais</label>
                                                <input type="text" name="dirPaisEntrega" size="40"/>
                                            </div>
                                            <div class="subElem">
                                                <input type="reset" value="Reiniciar">
                                                <input type="submit" name="boton" value="Guardar Cuenta">
                                            </div>
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