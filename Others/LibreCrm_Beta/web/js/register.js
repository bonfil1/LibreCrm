Ext.onReady(function(){
 
    var simple = new Ext.form.FormPanel({
        standardSubmit: true,
        frame:true,
        decorated: false,
        title: 'Login',
 
        width: 350,
        defaults: {
            width: 230
        },
        defaultType: 'textfield',
        items: [{
            fieldLabel: 'Usuario',
            name: 'usuario',
            id: 'usuario',
            allowBlank:false
        },
        {
            fieldLabel: 'Contraseña',
            name: 'contraseña',
            inputType:'password',
            allowBlank:false
        },                  
        ],
        buttons: [{
            text: 'Submit',
            handler: function() {
                simple.getForm().getEl().dom.action = 'Bienvenido.jsp';
                simple.getForm().getEl().dom.method = 'POST';
                simple.getForm().submit();
            }
        }]  

    });
    simple.render('mydiv');
});