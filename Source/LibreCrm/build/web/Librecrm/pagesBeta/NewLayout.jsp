<%-- 
    Document   : NewLayout
    Created on : 5/06/2011, 03:04:25 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Nuevo Layout</title>

        <!--Styles-->
        <link rel="stylesheet" href="../css/style-beta.css" type="text/css" />
        <link rel="stylesheet" href="../css/UserMenu.css" type="text/css" />
        <link rel="stylesheet" href="../css/Menu.css" type="text/css" />
        <link rel="stylesheet" href="../css/nyroModal.css" type="text/css" />
        <link rel="stylesheet" href="../plugins/Flexigrid/css/flexigrid.css" type="text/css" />

        <!--JavaScript-->
        <script type="text/javascript" src="../js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="../js/Menu.js"></script>
        <!--FrameWork para la creacion dinamica de charts-->
        <script type="text/javascript" src="../js/jquery.sparkline.js"></script>
        <script type="text/javascript" src="../js/jquery.nyroModal.custom.min.js"></script>
        <script type="text/javascript" src="../plugins/Flexigrid/js/flexigrid.js"></script>
        <script type="text/javascript" src="../js/TablaGrid.js"></script>
        <script type="text/javascript" src="../js/UserMenu.js"></script>
        <script type="text/javascript">
            $(function() {
                /* Use 'html' instead of an array of values to pass options
                to a sparkline with data in the tag */
                $('.piechart').sparkline('html', {type: 'pie', barColor: 'red', width: '200', height: '200'} );
                $('.sparklines').sparkline('html', { enableTagOptions: true, width: '200', height: '200' });
            });
        </script>
        <script type="text/javascript">
            $(document).ready(function() {
                UserMenu();
                initMenu();
            });
        </script>
    </head>
    <body>        
        <form action="#" method="POST">
            <script type="text/javascript">
                $(function() {
                    $('.nyroModal').nyroModal();
                });
            </script>
            <table width="100%" border="0">
                <tr>
                    <td width="100%" height="100px" colspan="2" class="tWrapper">LAT CRM</td>
                </tr>
                <tr>
                    <td width="100%" height="30px" class="tMenu">
                        <div class="encabezado">Layout de prueba</div>
                    </td>
                    <td width="40%" height="30px">
                        <!-- Menu de contenido de usuario-->
                        <ul class="topnav">
                            <li>
                                <a href="#">
                                    Correo <img src="../img/email.png" alt="Email Nuevo">
                                </a>
                            </li>
                            <li>
                                <a href="#">Usuario</a>
                                <ul class="subnav">
                                    <li><a href="#">Cuenta</a></li>
                                    <li><a href="#">Opciones</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Administrar</a>
                                <ul class="subnav">
                                    <li><a href="#">Control Panel</a></li>
                                    <li><a href="#">Opciones</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#" class="nyroModal">Salir</a>
                            </li>
                        </ul>  
                        <!-- /Menu de contenido de usuario-->
                    </td>
                </tr>
                <tr>
                <table width="100%" border="0">
                    <tr>
                        <td width="10%" height="800px" class="tColLeft">
                            <div id="tColMenu">
                                <ul id="menu">
                                    <li>
                                        <a href="#">Inicio</a>
                                    </li>
                                    <li>
                                        <a href="#">Resumen</a>
                                    </li>
                                    <li>
                                        <a href="#">Cuentas</a>
                                        <ul>
                                            <li><a href="#">Lista Cuentas</a></li>
                                            <li><a href="#">Crear Cuentas</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">Contactos</a>
                                        <ul>
                                            <li><a href="#">Lista Contactos</a></li>
                                            <li><a href="#">Crear Contactos</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">Oportunidades</a>
                                        <ul>
                                            <li><a href="#">Lista Oportunidades</a></li>
                                            <li><a href="#">Crear Oportunidades</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">Emails</a>
                                        <ul>
                                            <li><a href="#">Inbox</a></li>
                                            <li><a href="#">Redactar Nuevo</a></li>
                                            <li><a href="#">Plantillas</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">Campañas</a>
                                        <ul>
                                            <li><a href="#">Lista Campañas</a></li>
                                            <li><a href="#">Crear Campañas</a></li>
                                        </ul>
                                    </li>
                                    <li>
                                        <a href="#">Reportes</a>
                                        <ul>
                                            <li><a href="#">PVD</a></li>
                                            <li><a href="#">RAD</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </td>
                        <td width="90%" height="800px" class="tColRigth">
                            <div id="grupo_header">
                                Layout de Prueba
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
                                    <table  width="100%" class="flexme">
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
                                                <td><a href="/LibreCrm/SvLibreCrm?tipo=${param.opcion}&id=${fila.id}&accion=editar">Editar</a> </td>
                                                <td><a href="/LibreCrm/SvLibreCrm?tipo=${param.opcion}&id=${fila.id}&accion=eliminar">Eliminar</a> </td>
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
                        </td>
                    </tr>
                </table>
                </tr>
            </table>
        </form>
    </body>
</html>
