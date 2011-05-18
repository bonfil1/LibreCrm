/*
 * App: LoginWidget.js
 * Permite Crear el formulario de login
 */
function loginPanel(){
    //Punto del cual se apoya ExtJs para crear un punto de inicio para el form
    Ext.BLANK_IMAGE_URL =
    'http://localhost/extjs/resources/images/default/s.gif';
    Ext.QuickTips.init();

    //Function msg nos permite crear un mensaje tipo alert
    var msg = function(title, msg) {
        Ext.Msg.show({
            title: title,
            msg: msg,
            minWidth: 200,
            modal: true,
            icon: Ext.Msg.INFO,
            buttons: Ext.Msg.OK
        });
    };

    //Miembro de datos loginForm nos permite crear el formulario
    var loginForm = new Ext.form.FormPanel({
        standardSubmit: true,
        frame:true,
        width:260,
        labelWidth:60,
        defaults: {
            width: 200
        },
        defaultType: 'textfield',
        items: [{
            fieldLabel: 'Usuario',
            name: 'usuario',
            id: 'usuario',
            allowBlank:false,
            blankText:"Ingrese su nombre de usuario"
        },
        {
            fieldLabel: 'Contraseña',
            name: 'password',
            id:  'password',
            inputType:'password',
            allowBlank:false,
            blankText:"Ingrese su contraseña"
        },
        {
            inputType: 'hidden',
            id: 'submitbutton',
            name: 'boton',
            value: 'Iniciar'
        }
        ],
        buttons: [{
            id:    "boton",
            name:  "boton",
            value: "Iniciar",
            text:  "Iniciar",
            handler: function(){
                if(loginForm.getForm().isValid()){
                    loginForm.getForm().getEl().dom.action = 'SvLibreCrm';
                    loginForm.getForm().getEl().dom.method = 'POST';
                    loginForm.getForm().submit();
                }
            }
        }]
    });
    //loginWindow invoca al miembro de datos loginForm
    var loginWindow = new Ext.Window({
        title: 'Inicie sesion',
        layout: 'fit',
        height: 160,
        width: 320,
        closable: false,
        resizable: false,
        draggable: true,
        items: [loginForm]
    });

    loginWindow.show();
}

