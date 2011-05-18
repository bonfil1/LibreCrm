<%-- 
    Document   : Menu
    Created on : 8/02/2011, 09:43:48 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2011">
        <title>Menu    |   Hoja de apuntes</title>

        <!--Styles-->
        <link rel="stylesheet" href="../css/style.css" type="text/css" />
        <link rel="stylesheet" href="../css/wmd.css"   type="text/css" />
        <!-- JS -->
        <script type="text/javascript" src="js/showdown.js"></script>
        <script src="../js/jquery.js" type="text/javascript"></script>
        <script>
            $(document).ready(function(){
                $("#enlaceAjax").click(function(evento){
                    evento.preventDefault();
                    $("#Contenido").load("ControlPanelBeta.jsp");
                });
                $("#nuevaEntrada").click(function(evento){
                    evento.preventDefault();
                    $("#Contenido").load("CrearEntrada.jsp");
                });
                $("#salir").click(function(evento){
                    evento.preventDefault();
                    $("#Contenido").load("Confirmar.jsp");
                });
            })
        </script>


    </head>
    <body>
        <form action="#" method="POST">
            <h1>${sessionScope.nick}</h1>
            <hr>
            <center> <!--Menu-->
                <br>
                <table width="100%" border="0">
                    <tr>
                        <td width="70%"></td>
                        <td width="10%" align="right"><a href="#" id="enlaceAjax">Inicio</a></td>
                        <td width="10%" align="center">| &nbsp <a href="#" id="nuevaEntrada">Nueva nota</a> &nbsp |</td>
                        <td width="10%" align="left"><a href="#" id="salir">Salir</a></td>
                    </tr>
                </table>

                <br>

                <!-- Div de prueba para nuevos componentes-->
                <div id="Contenido">

                </div>
                <!-- Script para la creacion de la textarea-->
                <script type="text/javascript" src="js/wmd.js"></script>

                <br>
            </center><!--//Menu-->
        </form>
    </body>
</html>
