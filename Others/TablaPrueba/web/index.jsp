<%-- 
    Document   : index
    Created on : 13/05/2011, 11:02:04 PM
    Author     : Pepe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prubea de Tabla</title>
        <!--Styles-->
        <link rel="stylesheet" href="src/flexigrid.pack.css" type="text/css" />
        <link rel="stylesheet" href="src/flexigrid.css" type="text/css" />
        <!--Js-->
        <script src="http://code.jquery.com/jquery-1.5.2.min.js" type="text/javascript"></script>
        <script src="src/flexigrid.pack.js" type="text/javascript"></script>
        <script src="src/flexigrid.js" type="text/javascript"></script>
    </head>
    <body>
        <table class="flexme2">
            <thead>
                <tr>
                    <th width="100">Actividad de</th>
                    <th width="100">Nombre Actividad</th>
                    <th width="300">Fecha</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Cuentas</td>
                    <td>Jose Angel Bonfil</td>
                    <td>2011/11/01</td>
                </tr>
                <tr>
                    <td>Cuentas de pepe</td>
                    <td>Pepez</td>
                    <td>2011/11/01</td>
                </tr>
            </tbody>
        </table>
        <script type="text/javascript">
            $('.flexme').flexigrid();
            $('.flexme2').flexigrid({
                title : 'Tabla Prueba',
                width : 'auto',
                height : 'auto',
                showTableToggleBtn : true,
                usepager : true,
                searchitems : [ {
                        display : 'Actividad de',
                        name : 'Actividad de'
                    }, {
                        display : 'Nombre Actividad',
                        name : 'Nombre Actividad',
                        isdefault : true
                    } ],
                striped : false
            });
            $(".flexme3").flexigrid({               
                buttons : [ {
                        name : 'Add',
                        bclass : 'add',
                        onpress : test
                    }, {
                        name : 'Delete',
                        bclass : 'delete',
                        onpress : test
                    }, { separator : true } ],
                sortorder : "asc",
                usepager : true,
                title : 'Prueba de FlexGrid',
                useRp : true,
                rp : 15,
                showTableToggleBtn : true,
                width : 700,
                height : 200
            });
        </script>
    </body>
</html>
