/* 
 * Creada para uso de LibreCrm
 */

function widtget(){
    Ext.BLANK_IMAGE_URL =
        'http://localhost/extjs/resources/images/default/s.gif';
    Ext.Msg.show({
        title: 'Jose',
        msg: 'Nuevo WidGet de Pepe funciona?',
        buttons: {
            yes:    'Quiza',
            no:     true,
            cancel: true
        },
        icon: 'icono',
        fn: function( btn ){
            //Creamos un switch para decidir como responder al usuario
            //Dependiendo de su respuesta
            switch( btn ){
                case 'yes':
                    Ext.Msg.prompt( 'Y que tal te parece ', 'Increible? ', function(btn,txt){
                        if( txt.toLowerCase() == 'asombroso' ){
                            Ext.get('my_id').dom.innerHTML = 'Un increible WidGet';
                        }
                        else{
                            Ext.get('my_id').dom.innerHTML = txt;
                        }
                        Ext.DomHelper.applyStyles('my_id',{
                            'background': 'transparent url(rsc/dullwork.jpg) 50% 50% no-repeat'
                        });
                    } );
                    break;
                case 'no':
                    Ext.Msg.alert( 'Y que tal te parece ', 'Apesta? ', function(){
                        Ext.DomHelper.applyStyles('my_id', {
                            'background': 'transparent url(rsc/fire.jpg) 0 100% repeat-x'
                        })
                    });
                    break;
                case 'cancel':
                    Ext.Msg.wait( 'Guardando tu info... ', 'Guardando... ' );
                    break;
            }
        }
    });
}

function comprobar(btn, txt){
    
    if( txt.toLowerCase() == 'asombroso' ){
        Ext.get('my_id').dom.innerHTML = 'Un increible WidGet';
    }
    else{
        Ext.get('my_id').dom.innerHTML = txt;
    }
    Ext.DomHelper.applyStyles('my_id',{
        background: 'transparent url(rsc/dullwork.jpg) 50% 50% no-repeat'
    });
}
