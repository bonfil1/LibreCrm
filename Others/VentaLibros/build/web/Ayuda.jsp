<%-- 
    Document   : Ayuda
    Created on : 5/12/2010, 04:30:59 PM
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
        <title>Libros.com   |   Ayuda</title>

        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <link rel="stylesheet" href="css/slide-style.css" type="text/css" media="screen" />        

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

                <!--wrapper-->
                <div id="wrapper">

                    <div id="right">
                        <img src="images/icons/logo.jpg" width="100%" height="100%" class="img" alt="Libreri.com">

                    </div>

                    <!--div left-->
                    <div id="left">
                        <div class="panel_log">
                            <br><h1>Ayuda al usuario</h1>
                            <br>
                            <br>
                            <center>
                                <%-- Mostrar información sobre la aplicación --%>
                                <p>En la seccion de busqueda usted podra seleccion las categorias de su busqueda,<br>
                                    ya sea por Titulo que le devolvera un resultado de busqueda de libros por titulo,<br>
                                    Autor del libro que le devolvera un resultado de busqueda por autor<br>
                            </center>
                        </div>
                    </div><!--/div left-->

                </div><!--/wrapper-->

                <div id="bot"></div>
            </div><!--/main-->
        </form>
    </body>
</html>