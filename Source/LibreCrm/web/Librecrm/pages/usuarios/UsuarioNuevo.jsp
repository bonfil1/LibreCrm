<%-- 
    Document   : UsuarioNuevo
    Created on : 20/06/2011, 04:54:38 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Usuario Nueva</title>

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
                    <div id="header2">Creacion de Usuario</div>
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
                    <div id="content">
                        <div id="grupo_header">
                            Usuarios
                        </div>
                        <div id="cuentas_toolbar">
                            <div id="cToolbar">
                                <input type="submit" name="boton" value="Nuevo Usuario +">
                                <input type="submit" name="boton" value="Lista Usuarios >">
                            </div>
                        </div>
                        <div id="cuentas">
                            <div id="cuentas_layout">
                                <div class="rowElem">
                                    <h3>Datos del nuevo usuario.</h3>
                                    <label for="nickname">Nickname</label>
                                    <input type="text" name="nickname" size="40"/>
                                </div>
                                <div class="rowElem">
                                    <label for="contraseña">Contraseña</label>
                                    <input type="password" name="contraseña" size="40"/>
                                </div>
                                <div class="rowElem">
                                    <label for="nombres">Nombres</label>
                                    <input type="text" name="nombres" size="40"/>
                                </div>
                                <div class="rowElem">
                                    <label for="apellidos">Apellidos</label>
                                    <input type="text" name="apellidos" size="40"/>
                                </div>
                                <div class="rowElem">
                                    <label for="reporta_a">Reporta a</label>
                                    <select name="reporta_a">
                                        <option selected value="0"> Seleccione...
                                            <c:forEach var="fila" items="${requestScope.listaUsuariosSimple}">
                                            <option value="${fila.id}">${fila.first_name} ${fila.last_name}
                                            </c:forEach>
                                    </select>
                                </div>
                                <div class="rowElem">
                                    <label for="es_admin">Tipo de usuario</label>
                                    <select name="es_admin">
                                        <option selected value="2"> Seleccione...
                                        <option value = "1"> Administrador
                                        <option value = "0"> Usuario
                                    </select>
                                </div>
                                <div class="rowElem">
                                    <label for="categoria">Categoria</label>
                                    <input type="text" name="categoria" size="40"/>
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
                                    <label for="email">E-mail</label>
                                    <input type="text" name="email" size="40"/>
                                </div>
                                <div class="rowElem">
                                    <textarea id="comentario" rows="4" cols="60" name="descripcion"></textarea>
                                    <script type="text/javascript" charset="utf-8">
                                        $('#comentario').markItUp(mySettings);
                                    </script>
                                </div>                                 
                                <div class="rowElem">
                                    <h3>Domicilio.</h3>
                                    <label for="dirCalleFact">Calle</label>
                                    <input type="text" name="dirCalleFact" size="25"/>

                                    <label for="dirCiudadFact">Ciudad</label>
                                    <input type="text" name="dirCiudadFact" size="25"/>
                                </div>
                                <div class="rowElem">
                                    <label for="dirEstadoFact">Estado</label>
                                    <input type="text" name="dirEstadoFact" size="25"/>                                   
                                </div>
                                <div class="rowElem">
                                    <label for="dirPaisFact">Pais</label>
                                    <input type="text" name="dirPaisFact" size="40"/>
                                </div>                                
                                <div class="subElem">
                                    <input type="reset" value="Reiniciar">
                                    <input type="submit" name="boton" value="Guardar Cuenta">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>
