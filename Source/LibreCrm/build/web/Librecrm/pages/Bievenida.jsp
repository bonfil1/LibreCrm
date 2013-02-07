<%-- 
    Document   : Bievenida
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
        <title>LibreCrm | Bienvenido</title>

        <!--Styles-->
        <link rel="stylesheet" href="Librecrm/css/libre-style.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/nyroModal.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/StyleFeed.css" type="text/css" />
        <link rel="stylesheet" href="Librecrm/css/SlideStyle.css" type="text/css" />
        <!--Styles MarkItUP-->
        <link rel="stylesheet" href="Librecrm/plugins/markitup/skins/markitup/style.css" type="text/css" media="screen"/>
        <link rel="stylesheet" href="Librecrm/plugins/markitup/sets/html/style.css" type="text/css" media="screen" />


        <!--JavaScript-->
        <script type="text/javascript" src="Librecrm/js/jquery-1.5.1.js"></script>
        <!--JavaScript MarkitUP-->
        <script type="text/javascript" src="Librecrm/plugins/markitup/jquery.markitup.js"></script>
        <script type="text/javascript" src="Librecrm/plugins/markitup/sets/html/set.js"></script>
        <!--NyroModal-->
        <script type="text/javascript" src="Librecrm/js/jquery.nyroModal.custom.min.js"></script>
        <!--SliderComponentes-->
        <script type="text/javascript" src="Librecrm/plugins/Slider/src/jquery.collapse.js"></script>
        <script type="text/javascript" src="Librecrm/plugins/Slider/src/jquery.cookie.js"></script>
        <script type="text/javascript">document.documentElement.className = "js";</script>
        <!--Text Slide For the LibreCrm Feed-->
        <script type="text/javascript" src="Librecrm/js/jquery.wslide.js"></script>
        <script type="text/javascript" charset="utf-8">
            $(document).ready(function(){
                $("#slide").wslide({
                    width: 950,
                    height: 250,
                    col: 4,
                    duration: 500,
                    effect: 'easeOutExpo'
                });
            });
        </script>
    </head>
    <body>        
        <form action="/LibreCrm/SvLibreCrm" method="POST">
            <div id="wrapper">
                <div id="titulo2">LAT CRM</div>
                <div id="cabezera">
                    <div id="header2">Bienvenido</div>
                    <div id="opciones">
                        <div id="mail_check">1</div>
                        &nbsp;Bienvenido(a): &nbsp;
                        <a href="/LibreCrm/SvLibreCrm?link=detalles">${sessionScope.nickname}</a> |
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
                                        Bievenido a LATCRM
                                    </div>
                                    <div id="grupo_fila1">
                                        <div id="slider_wrapper">
                                            <!-- .slider -->
                                            <ul id="slide">
                                                <c:forEach var="feed" items="${sessionScope.comentarios}">
                                                    <li>                                                        
                                                        <h2>${feed.title}</h2>
                                                        <p>${feed.comments}</p>
                                                        <div class="fecha"> Agregado por <c:if test="${feed.is_admin == 1}">Administrador</c:if>&nbsp; ${feed.first_name} ${feed.last_name} el ${feed.date_entered}</div>
                                                    </li>
                                                </c:forEach>
                                            </ul><!-- .slider -->
                                        </div>
                                    </div>
                                    <div id="grupo_fila2">
                                        <div class="slide">
                                            <h3>Comentar</h3>
                                            <div id="formulario">
                                                <label for="titulo_cmt">Titulo</label>
                                                <input type="text" name="titulo" size="60">
                                                <br/>
                                                <textarea id="comentario" name="comentario" cols="80" rows="20">
                                                </textarea>
                                                <br/>                                                
                                                <input type="submit" value="Comentar" name="boton" >
                                            </div>
                                        </div>
                                        <script type="text/javascript" charset="utf-8">
                                            $(".slide").collapse({show: function(){
                                                    this.animate({
                                                        opacity: 'toggle',
                                                        height: 'toggle'
                                                    }, 300);
                                                },
                                                hide : function() {
                                                    this.animate({
                                                        opacity: 'toggle',
                                                        height: 'toggle'
                                                    }, 300);
                                                }
                                            });
                                            $('#comentario').markItUp(mySettings);
                                        </script>
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
