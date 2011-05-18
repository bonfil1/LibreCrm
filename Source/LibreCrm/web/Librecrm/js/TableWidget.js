/*
 * App: TableWidget.js
 * Permite Crear el formulario de login
 */
function tableWidget(){
    // create the grid
    var grid = new Ext.ux.grid.TableGrid("actividad", {
        stripeRows: true // stripe alternate rows
    });
    grid.render();
}