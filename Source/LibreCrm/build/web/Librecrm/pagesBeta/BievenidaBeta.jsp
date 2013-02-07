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
        <link rel="stylesheet" href="../css/libre-style.css" type="text/css" />
        <link rel="stylesheet" href="../css/nyroModal.css" type="text/css" />
        <link rel="stylesheet" href="../css/coda-slider-2.0.css" type="text/css" media="screen" />

        <!--JavaScript-->
        <script type="text/javascript" src="../js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="../js/jquery.nyroModal.custom.min.js"></script>
        <script type="text/javascript" src="../js/jquery.coda-slider-2.0.js"></script>
        <script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>

        <script type="text/javascript"  language="javascript">
            $(document).ready(function(){
                $('#slider').codaSlider({
                    autoSlide: true,
                    autoSlideInterval: 3000,
                    autoSlideStopWhenClicked: true
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
                        &nbsp;Bienvenido(a): &nbsp;<a href="/LibreCrm/SvLibreCrm?link=detalles">${sessionScope.nickname}</a> | 
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
                                <div id="content">
                                    <div id="grupo_header">
                                        Bievenido a LATCRM
                                    </div>
                                    <div id="grupo_fila1">
                                        <div id="slider_wrapper">
                                            <!-- .slider -->
                                            <div class="coda-slider preload" id="slider">
                                                <div class="panel">
                                                    <div class="panel-wrapper">
                                                        <h2 class="title">Comentario 1</h2>
                                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas metus nulla, commodo a sodales sed, dignissim pretium nunc. Nam et lacus neque. Sed volutpat ante id mauris laoreet vestibulum. Nam blandit felis non neque cursus aliquet. Morbi vel enim dignissim massa dignissim commodo vitae quis tellus. Nunc non mollis nulla. Sed consectetur elit id mi consectetur bibendum. Ut enim massa, sodales tempor convallis et, iaculis ac massa. Etiam suscipit nisl eget lorem pellentesque quis iaculis mi mattis. Aliquam sit amet purus lectus. Maecenas tempor ornare sollicitudin.</p>
                                                    </div>
                                                </div>
                                                <div class="panel">
                                                    <div class="panel-wrapper">
                                                        <h2 class="title">Comentario 2</h2>
                                                        <p>Proin nec turpis eget dolor dictum lacinia. Nullam nunc magna, tincidunt eu porta in, faucibus sed magna. Suspendisse laoreet ornare ullamcorper. Nulla in tortor nibh. Pellentesque sed est vitae odio vestibulum aliquet in nec leo.</p>
                                                    </div>
                                                </div>
                                                <div class="panel">
                                                    <div class="panel-wrapper">
                                                        <h2 class="title">Comentario 3</h2>
                                                        <p>Cras luctus fringilla odio vel hendrerit. Cras pulvinar auctor sollicitudin. Sed lacus quam, sodales sit amet feugiat sit amet, viverra nec augue. Sed enim ipsum, malesuada quis blandit vel, posuere eget erat. Sed a arcu justo. Integer ultricies, nunc at lobortis facilisis, ligula lacus vestibulum quam, id tincidunt sapien arcu in velit. Vestibulum consequat augue et turpis condimentum mollis sed vitae metus. Morbi leo libero, tincidunt lobortis fermentum eget, rhoncus vel sem. Morbi varius viverra velit vel tempus. Morbi enim turpis, facilisis vel volutpat at, condimentum quis erat. Morbi auctor rutrum libero sed placerat. Etiam ipsum velit, eleifend in vehicula eu, tristique a ipsum. Donec vitae quam vel diam iaculis bibendum eget ut diam. Fusce quis interdum diam. Ut urna justo, dapibus a tempus sit amet, bibendum at lectus. Sed venenatis molestie commodo.</p>
                                                    </div>
                                                </div>
                                                <div class="panel">
                                                    <div class="panel-wrapper">
                                                        <h2 class="title">Comentario 4</h2>
                                                        <p>Nulla ultricies ornare erat, a rutrum lacus varius nec. Pellentesque vehicula lobortis dignissim. Ut scelerisque auctor eros sed porttitor. Nullam pulvinar ultrices malesuada. Quisque lobortis bibendum nisi et condimentum. Mauris quis erat vel dui lobortis dignissim.</p>
                                                    </div>
                                                </div>
                                            </div><!-- .slider -->
                                        </div>
                                    </div>
                                    <div id="grupo_fila2">
                                        <div id="addcomment">
                                            <input type="image" src="../img/pckImgs/button.png" align="Comentar" name="boton" value="Comentar">
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
