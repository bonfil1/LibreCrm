<%-- 
    Document   : index
    Created on : 12/03/2011, 08:35:25 AM
    Author     : Pepe
    Descript   : App for test in ExtJs framework
    Purpose    : Create a proffesional view of myCustom CRM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <!-- ExtJs Resources -->

        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="resources/css/ext-all.css" />
        <!-- Common Styles for the examples -->
        <link rel="stylesheet" type="text/css" href="shared/examples.css" />
        <style type="text/css">
            .x-panel-body p {
                margin:10px;
                font-size:12px;
            }
        </style>


        <!-- GC -->
        <!-- LIBS -->
        <script type="text/javascript" src="adapter/ext/ext-base.js"></script>

        <!-- ENDLIBS -->
        <script type="text/javascript" src="js/ext-all.js"></script>
        <script language="javascript" src="js/hello.js"></script>
        <!-- /ExtJs Resources -->

    </head>
    <body>
        <h1>Hola Mundo</h1>
        <p>Esta es un simple prueba de ExtJs para crear AutoTabs con un MarkUp Simple</p>
        <input type="button" id="show-btn" value="Hola Mundo" /><br /><br />

        <div id="hello-win" class="x-hidden">
            <div class="x-window-header">Hola Dialogo</div>
            <div id="hello-tabs">
                <!-- Auto create tab 1 -->
                <div class="x-tab" title="Hola Mundo 1">
                    <p>Hello...</p>
                </div>
                <!-- Auto create tab 2 -->
                <div class="x-tab" title="Hola Mundo 2">

                    <p>... World!</p>
                </div>
                <!-- Auto create tab 3 -->
                <div class="x-tab" title="Hola Mundo 3">

                    <p>... World!</p>
                </div>
                <!-- Auto create tab 4 -->
                <div class="x-tab" title="Hola Mundo 4">

                    <p>... World! 2</p>
                </div>
            </div>
        </div>

    </body>
</html>
