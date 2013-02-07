<%-- 
    Document   : CuentaNueva
    Created on : 28/03/2011, 06:36:24 PM
    Author     : Jose Angel Bonfil Evia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Contacto Nuevo</title>

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
                                            <input type="submit" name="boton" value="Nuevo Contacto +">
                                            <input type="submit" name="boton" value="Lista Contactos >">
                                        </div>
                                    </div>
                                    <div id="cuentas">
                                        <div id="cuentas_layout">
                                            <div class="rowElem">
                                                <h3>Datos personales</h3>
                                                <label for="saludo">Saludo</label>
                                                <select name="saludo" class="select">
                                                    <option selected value = "0"> Seleccione...
                                                    <option value = "Sr."> Sr.
                                                    <option value = "Srta."> Srta.
                                                    <option value = "Sra."> Sra.
                                                </select>                                                                                                
                                            </div>
                                            <div id="rowElem">
                                                <label for="nombre">Nombres</label>
                                                <input type="text" name="nombre" size="40"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="apellidos">Apellidos</label>
                                                <input type="text" name="apellidos" size="60"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="titulo">Titulo</label>
                                                <input type="text" name="titulo" size="40"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="cuenta">Contacto de</label>                                                
                                                <select name="cuenta">
                                                    <option selected value="0"> Seleccione...
                                                        <c:forEach var="fila" items="${requestScope.listaCuentasSimple}">
                                                            <option value="${fila.id}">${fila.name}
                                                        </c:forEach>
                                                </select>
                                                <input type="submit" name="boton" value="Nueva Cuenta +">
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
                                            <div id="rowElem">
                                                <label for="status">Estatus Contacto</label>
                                                <select name="status" class="select">
                                                    <option selected value = "0"> Seleccione...
                                                    <option value = "Activo"> Activo
                                                    <option value = "Inactivo"> Inactivo
                                                    <option value = "No definido"> No definido
                                                </select>
                                            </div>
                                            <div class="rowElem">
                                                <label for="departamento">Departamento</label>
                                                <input type="text" name="departamento" size="40"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="telf_hogar">Telefono Hogar</label>
                                                <input type="text" name="telf_hogar" size="15"/>

                                                <label for="telf_movil">Telefono Movil</label>
                                                <input type="text" name="telf_movil" size="15"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="telf_trabajo">Telefono Trabajo</label>
                                                <input type="text" name="telf_trabajo" size="15"/>

                                                <label for="telf_otro">Telefono Otro</label>
                                                <input type="text" name="telf_otro" size="15"/>

                                                <label for="telf_fax">Telefono Fax</label>
                                                <input type="text" name="telf_fax" size="15"/>
                                            </div>
                                            <div class="rowElem">
                                                <textarea id="comentario" rows="10" cols="60" name="descripcion"></textarea>
                                                <script type="text/javascript" charset="utf-8">
                                                    $('#comentario').markItUp(mySettings);
                                                </script>
                                            </div>
                                            <div class="rowElem">
                                                <h3>Domicilio</h3>
                                                <label for="dir_calle">Calle</label>
                                                <input type="text" name="dir_calle" size="25"/>

                                                <label for="dir_ciudad">Ciudad</label>
                                                <input type="text" name="dir_ciudad" size="25"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="dir_estado">Estado</label>
                                                <input type="text" name="dir_estado" size="25"/>

                                                <label for="dir_cp">Codigo Postal</label>
                                                <input type="text" name="dir_cp" size="25"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="dir_pais">Pais</label>
                                                <input type="text" name="dir_pais" size="40"/>
                                            </div>
                                            <div class="rowElem">
                                                <label for="asistente">Asistente</label>
                                                <input type="text" name="asistente" size="20"/>

                                                <label for="tel_asist">Telfono Asist.</label>
                                                <input type="text" name="tel_asist" size="15"/>
                                            </div>                                            
                                            <div class="subElem">
                                                <input type="reset" value="Reiniciar">
                                                <input type="submit" name="boton" value="Guardar Contacto">
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