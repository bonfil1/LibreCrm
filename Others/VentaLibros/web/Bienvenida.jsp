<%-- 
    Document   : Bienvenida
    Created on : 28/11/2010, 07:18:35 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-18">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2010">
        <title>Libros.com   |   Bienvenido</title>

        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <link rel="stylesheet" href="css/slide-style.css" type="text/css" media="screen" />
       

        <!--Scripts-->
        <script type="text/javascript">var _siteRoot='Bienvenida.jsp',_root='Bienvenida.jsp';</script>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        
</head>
<body>
    <form action="/VentaLibros/SvLibros" method=post>
        <div id="main">
            <div id="top"></div>
            <!-- header begins -->
            <div id="header">
                <div id="buttons">
                    <%-- Mostrar el formulario --%>

                    <table border="0">
                        <tr>
                            <td><font face="Verdana,Helvetica" size="2"><b>Busqueda por:</b></font>&nbsp;</td>
                            <%-- Lista desplegable --%>
                            <td><select size="1" name='opcion'>
                                    <option value="1">Título del libro</option>
                                    <option value="2">Autor del libro</option>
                                    <option value="3">Editorial del libro</option>
                                    <option value="4">Categoría del libro</option>
                                    <option selected value="5">Todos los libros disponibles </option>
                                </select>&nbsp;</td>
                            <td><font face="Verdana,Helvetica" size="2"><b>Buscar:</b></font>&nbsp;&nbsp;&nbsp;</td>
                            <td><input type='text' name='busqueda' size='50' style="height: 22px; font-size: 14pt;">&nbsp;</td>
                            <td><input type = "image" src = "images/icons/buscar1.png" width = "25px" height = "25px" name="boton" value='Buscar'></td>
                            <td><input type = "image" src = "images/icons/help1.png" width = "25px" height = "25px" name="boton" value="Ayuda"></td>
                            <td><input type = "reset" class="boton-res" value="&nbsp;&nbsp;&nbsp;"></td>
                            <td><input type = "image" src = "images/icons/home1.png" width = "25px" height = "25px" name="boton" value="Inicio"></td>
                            <!--<input type="submit" name='boton' value='Buscar'>&nbsp;&nbsp;
                            <input type="reset">
                            <input type="submit" name='boton' value='Ayuda'>-->
                        </tr>
                    </table>

                </div>
            </div>
            <!-- header ends -->

            <!--/Slide-presentation-->
            <div id="header"><div class="wrap">
                    <div id="slide-holder">
                        <div id="slide-runner">
                            <a href=""><img id="slide-img-1" src="images/1.png" class="slide" alt="" /></a>
                            <a href=""><img id="slide-img-2" src="images/2.png" class="slide" alt="" /></a>
                            <a href=""><img id="slide-img-3" src="images/3.png" class="slide" alt="" /></a>
                            <a href=""><img id="slide-img-4" src="images/4.png" class="slide" alt="" /></a>
                            <a href=""><img id="slide-img-5" src="images/5.png" class="slide" alt="" /></a>
                            <a href=""><img id="slide-img-6" src="images/6.png" class="slide" alt="" /></a>
                            <a href=""><img id="slide-img-7" src="images/7.png" class="slide" alt="" /></a>
                            <div id="slide-controls">
                                <p id="slide-client" class="text"><strong>post: </strong><span></span></p>
                                <p id="slide-desc" class="text"></p>
                                <p id="slide-nav"></p>
                            </div>
                        </div>

                        <!--content featured gallery here -->
                    </div>
                    <script type="text/javascript">
                        if(!window.slider) var slider={};slider.data=[{"id":"slide-img-1","client":"Programacion","desc":"Spring"},{"id":"slide-img-2","client":"Programacion","desc":"Deitel & Deitel C++ como programar"},{"id":"slide-img-3","client":"Programacion","desc":"Java Como programar"},{"id":"slide-img-4","client":"Programacion","desc":"PHP y MySql"},{"id":"slide-img-5","client":"Programacion","desc":"Oracle 11g"},{"id":"slide-img-6","client":"Prgramacion","desc":"Java - Glassfish"},{"id":"slide-img-7","client":"Servidores","desc":"CentOS"}];
                    </script>
                </div></div><!--/header-->

            <!--wrapper-->
            <div id="wrapper">

                <div id="right">
                    <img src="images/icons/logo.jpg" width="100%" height="100%" class="img" alt="Libreria.com">

                </div>

                <!--div left-->
                <div id="left">
                    <div class="panel_log">
                        <br><h1>Panel de Control</h1>
                        <br>
                        <br>
                        <center>
                            <table border="0">
                                <font face="bold" size="12">
                                    <tr>
                                        <td align="right">Usuario&nbsp;&nbsp;&nbsp;</td>
                                        <td><input type='text' name='usuario' size='20' style="height: 22px; font-size: 14pt;" /></td>
                                    </tr>
                                    <tr>
                                        <td align="right">Contraseña&nbsp;&nbsp;&nbsp;</td>
                                        <td><input type='password' name='pwd' size='20' style="height: 22px; font-size: 14pt;" /></td>
                                    </tr>
                                    <tr>
                                        <td><br></td>
                                        <td><br></td>
                                    </tr>
                                    <tr>
                                        <td><br></td>
                                        <td><br></td>
                                    </tr>
                                    <tr>
                                        <td align="left">Si no esta usted registrado, puede registrarse dando click aqui *</td>
                                        <td align="left"><input align='center' type='submit' name='boton' value='Registrarse'></td>
                                    </tr>
                                    <tr>
                                        <td align="left">Consulte el historial de pedidos de su usuario</td>
                                        <td align="left"><input align=right type='submit' name='boton' value='Historial'></td>
                                    </tr>
                                </font>
                            </table>
                        </center>
                    </div>
                </div><!--/div left-->

            </div><!--/wrapper-->

            <div id="bot"></div>
        </div><!--/main-->
    </form>
</body>
</html>
