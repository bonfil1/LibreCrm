function flexGrid(nombre){
    //Crea el Estilo para la tabla
    $('.flexme').flexigrid({
        title : nombre,
        width : '100%',
        height : 200,
        useRp : true,
        rp : 5,
        showTableToggleBtn : true,
        singleSelect: true,
        usepager : true,
        sortname: "nombre",
        sortorder: 'asc',
        striped : false
    });
}

