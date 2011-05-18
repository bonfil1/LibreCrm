<%-- 
    Document   : CrearEntradaBeta
    Created on : 7/02/2011, 04:22:41 PM
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
        <title>Cree su nueva entrada    |   Hoja de apuntes</title>

        <!--Styles-->
        <link rel="stylesheet" href="css/style.css" type="text/css" />
        <link rel="stylesheet" href="css/wmd.css"   type="text/css" />
        <!-- JS -->
        <script type="text/javascript" src="js/showdown.js"></script>

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
                        <td width="10%" align="right"><a href="/TimeSheet/SvAgenda?link=inicio">Inicio</a></td>
                        <td width="10%" align="center">| &nbsp <a href="/TimeSheet/SvAgenda?link=cancelar">Cancelar</a> &nbsp |</td>
                        <td width="10%" align="left"><a href="/TimeSheet/SvAgenda?link=salir&sesion=cerrar">Salir</a></td>
                    </tr>
                </table>

                <br>

                <!-- Div de prueba para nuevos componentes-->
                <div id="Content">
                    <div id="guardar">
                        <input type = "image" src = "img/guardar.png"
                               width = "40px" height = "40px" name="boton"
                               value="Guardar">
                    </div>
                    <table border="0" width="100%">
                        <tr>
                            <td align="right" width="20%">Titulo</td>
                            <td align="left"><input type="text" name='titulo' size='55' maxlength="55" style="height: 20px; font-size: 13pt;"></td>
                        </tr>
                    </table>
                    <br>

                    <div id="wmd-button-bar" class="wmd-panel"></div>
                    <br/>
                    <div id="des">Descripcion</div>
                    <textarea id="wmd-input" class="resizable" name="texto"></textarea>
                    <br/>
                    <div id="wmd-preview" class="wmd-panel"></div>
                    <br/>
                    <div id="fecha">
                        Fecha &nbsp&nbsp
                        <select size="1" name='dia'>
                            <option>01</option>
                        </select>
                        <select size="1" name='mes'>
                            <option>01</option>
                        </select>
                        <select size="1" name='año'>
                            <option>2011</option>
                        </select></div>
                    <div id="hora">
                        Hora Inicio &nbsp
                        <select size="1" name='hr_ini'>
                            <option>09:00</option>
                        </select>&nbsp
                         Hora Fin &nbsp
                        <select size="1" name='hr_ini'>
                            <option>09:00</option>
                        </select>
                    </div>

                </div>
                <!-- Script para la creacion de la textarea-->
                <script type="text/javascript" src="js/wmd.js"></script>

                <br>                
            </center><!--//Menu-->
        </form>
    </body>
</html>
