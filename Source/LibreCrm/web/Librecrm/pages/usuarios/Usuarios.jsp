<%-- 
    Document   : Usuarios
    Created on : 20/06/2011, 04:06:34 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LibreCrm | Usuarios</title>

        <!--Styles-->
        <link rel="stylesheet" href="Librecrm/css/libre-style.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/nyroModal.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/plugins/Flexigrid/css/flexigrid.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/plugins/jQtransform/jqtransform.css" type="text/css" />

        <!--JavaScript-->
        <script type="text/javascript" src="Librecrm/js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="Librecrm/js/jquery.nyroModal.custom.min.js"></script>
        <script type="text/javascript" src="Librecrm/plugins/Flexigrid/js/flexigrid.js"></script>
        <script type="text/javascript" src="Librecrm/plugins/jQtransform/jquery.jqtransform.js"></script>
        <script type="text/javascript" src="Librecrm/js/TablaGrid.js"></script>
    </head>
    <body>
        <script type="text/javascript">
            $(function() {
                //find all form with class jqtransform and apply the plugin
                $("form.jqtransform").jqTransform();
                $('.nyroModal').nyroModal();
                flexGrid("Usuarios");
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
                                <table border="0" width="100%" class="flexme">
                                    <thead>
                                        <tr>
                                            <th width="100">Nombre de Usuario</th>
                                            <th width="180">Nombre</th>
                                            <th width="50">Es admin</th>
                                            <th width="250">Descripcion</th>
                                            <th width="150">Fecha Creacion</th>
                                            <th width="100">Editar</th>
                                            <th width="100">Eliminar</th>
                                        </tr>
                                    </thead>
                                    <%-- Filas --%>
                                    <%--
                                        Recogemos los valores de cada pedido
                                    --%>
                                    <tbody>
                                        <c:forEach var="fila" items="${requestScope.listaUsuarios}">
                                            <c:set var="admin" scope="session" value="Usuario" />
                                            <c:if test="${fila.is_admin == 1}">
                                                <c:set var="admin" scope="session" value="Administrador" />
                                            </c:if>
                                            <tr>
                                                <td>${fila.user_name}</td>
                                                <td>${fila.first_name} ${fila.last_name}</td>
                                                <td>${admin}</td>
                                                <td>${fila.description}</td>
                                                <td>${fila.date_entered}</td>
                                                <td><a href="/LibreCrm/SvLibreCrm?link=usuariosEdit&id=${fila.id}">Editar</a> </td>
                                                <td><a href="/LibreCrm/SvLibreCrm?link=usuariosElim&id=${fila.id}">Eliminar</a> </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </body>
</html>