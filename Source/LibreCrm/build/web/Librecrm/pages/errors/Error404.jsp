<%-- 
    Document   : Error
    Created on : 8/05/2011, 10:46:39 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="autor"        Content="Jose Angel Bonfil">
        <meta name="copyright"    Content="(c) 2011">
        <title>Error ${requestScope.error}    |   LibreCrm</title>

        <!--Styles-->
        <style type="text/css">
            body{ margin:0; padding:0; background:#efefef; font-family:Georgia, Times, Verdana, Geneva, Arial, Helvetica, sans-serif; }
            div#mother{ margin:0 auto; width:943px; height:572px; position:relative; }
            div#errorBox{ background: url(../Librecrm/img/pckImgs/bg404.png) no-repeat top left; width:943px; height:572px; margin:auto; }
            div#errorText{ color:#39351e; padding:146px 0 0 446px }
            div#errorText p{ width:303px; font-size:14px; line-height:26px; }
            div.link{ /*background:#f90;*/ height:50px; width:145px; float:left; }
            div#home{ margin:20px 0 0 444px;}
            div#contact{ margin:20px 0 0 25px;}
            h1{ font-size:40px; margin-bottom:35px; }
        </style>

        <!--jQuery-->
        <script type="text/javascript" src="../Librecrm/js/jquery-1.5.1.js"></script>
        <script type="text/javascript">
            $(document).ready( function(){
                var bodyHeight 		= $(window).height();
                var contentHeight	= $("#mother").height();
                var newHeight;

                if ( bodyHeight < contentHeight ){
                    var newHeight = contentHeight - bodyHeight;

                } else {
                    var newHeight = bodyHeight - contentHeight;

                }
                newHeight = newHeight / 2;
                $("body").css({marginTop:newHeight});
            });
        </script>
    </head>
    <body >
        <div id="mother">
            <div id="errorBox">
                <div id="errorText">
                    <h1>Error 404</h1>
                    <p>404 el link seleccionado no ha sido encontrado! <br />- Posiblemente debas volver al inicio. </p>
                    <p>Intenta con uno de estos botones</p>
                </div>
                <a href="/LibreCrm/SvLibreCrm" title="Inicio">
                    <div class="link" id="home"></div>
                </a>
                <a href="/LibreCrm/SvLibreCrm?link=contacto" title="Contacto...">
                    <div class="link" id="contact"></div>
                </a>
            </div>
        </div>
    </body>
</html>
