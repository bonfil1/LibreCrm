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
        <title>LibreCrm | Crear Nuevo Comentario</title>
        <!--Styles MarkItUP-->
        <link rel="stylesheet" href="Librecrm/plugins/markitup/skins/markitup/style.css" type="text/css" media="screen"/>
        <link rel="stylesheet" href="Librecrm/plugins/markitup/sets/html/style.css" type="text/css" media="screen" />
        <style type="text/css">
            label{ font-family: Helvetica, Arial; }
        </style>

        <!--JavaScript MarkitUP-->
        <script type="text/javascript" src="Librecrm/js/jquery-1.5.1.js"></script>
        <script type="text/javascript" src="Librecrm/plugins/markitup/jquery.markitup.js"></script>
        <script type="text/javascript" src="Librecrm/plugins/markitup/sets/html/set.js"></script>
    </head>
    <body>
        <!-- Markitup-->
        <script type="text/javascript"  language="javascript">
            $(function(){
                $('#editor').markItUp(mySettings);
            });
        </script>
        <!-- /Markitup-->
        <center>
            <form action="#" method="POST">
                <label for="tit_text">Titulo</label>
                <input type="text" name="titulo" value="" id="tit_text" size="60">
                <br/><br/>
                <textarea id="editor" cols="80" rows="20">                    
                </textarea>
                <br/>
                <input type="reset" value="Limpiar">
                <input type="submit" value="Aceptar" name="boton" >            
            </form>
        </center>
    </body>
</html>
