function tableGrid(nombre){
    //Crea el Estilo para la tabla
    $('.flexme').flexigrid({
        url: '/LibreCrm/SvLibreCrm?tabla=hola',
        dataType: 'xml',
        colModel : [ {
            display : 'Nombre',
            name : 'nombre',
            width : 250,
            sortable : true,
            align : 'center'
        }, {
            display : 'Fecha de Creacion',
            name : 'fecha',
            width : 250,
            sortable : true,
            align : 'center'
        }, {
            display : 'Descripcion',
            name : 'descripcion',
            width : 350,
            sortable : true,
            align : 'center'
        }],
        buttons : [ {
            name : 'Agregar',
            bclass : 'add',
            onpress : acciones
        }, {
            name : 'Borrar',
            bclass : 'delete',
            onpress : acciones
        }, {
            separator : true
        } ],
        searchitems : [ {
            display : 'Nombre',
            name : 'nombre',
            isdefault : true
        },{
            display : 'Fecha de Creacion',
            name : 'fecha'
        }],
        title : nombre,
        width : 1000,
        height : 200,
        useRp : true,
        rp : 5,
        showTableToggleBtn : true,
        usepager : true,        
        sortname: "nombre",
        sortorder: 'asc',
        striped : false
    });
}

function acciones(com, grid) {
    if (com == 'Borrar') {
        confirm('Borrar ' + $('.trSelected', grid).length + ' articulo?');
        doSomeRequest('/LibreCrm/SvLibreCrm', '');
    } else if (com == 'Agregar') {
        alert('Add New Item');
    }
}

function doSomeRequest(servletName, servletArguments){
    var servlet = servletName;                //the name (URI) of your servlet
    var arg = servletArguments                //any attributes you want to send
    var req = servlet + "?" + arg;            //compiling the request

    enviarPeticiones(req);    
}

// objeto XMLHttpRequest
var PeticionHTTP; 

function enviarPeticiones(URL)
{
    try {
        // Otros como IE 7, Mozilla Firefox
        PeticionHTTP = new XMLHttpRequest();
    } catch (exception) {
        try {
            // Versiones de Internet Explorer inferiores a IE7
            PeticionHTTP = new ActiveXObject("Microsoft.XMLHTTP");
        } catch (exception) {
             alert("XMLHttpRequest error: " + e);
        }

    }    
    if (PeticionHTTP != null)
    {
        //PeticionHTTP.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
        //PeticionHTTP.send(URL); //Peticion HTTP POST
        PeticionHTTP.open("GET", URL, true); // llamada asíncrona        
        PeticionHTTP.send(null);
        alert("Enviando " + URL);
        
    }
}

