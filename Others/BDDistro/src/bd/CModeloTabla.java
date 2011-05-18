package bd;

import java.util.Iterator;

@SuppressWarnings("serial")
public class CModeloTabla extends javax.swing.table.DefaultTableModel {

    private static CBaseDatos bd;
    private java.sql.ResultSet cdr; //Conjunto de datos
    private java.sql.ResultSetMetaData info; //Informacion sobre cdr

    public CModeloTabla() {
    }

    public void iniciar(String controlador, String controlador2, String controlador3,
            String url, String url2, String url3,
            String tabla, String usuario, String pass)
            throws ClassNotFoundException, java.sql.SQLException,
            InstantiationException, IllegalAccessException {

        //Abrir la coneccion
        //bd = new CBaseDatos(controlador, url, usuario, pass);
        //Actualizar el modelo de datos con los obtenidos de la bd
        //cargarDatos(tabla);


        cargarDatos(controlador, controlador2, controlador3, url, url2, url3, tabla, usuario, pass);
    }

    private void cargarDatos(String controlador, String controlador2, String controlador3,
            String url, String url2, String url3,
            String tabla, String usuario, String pass)
            throws ClassNotFoundException, java.sql.SQLException,
            InstantiationException, IllegalAccessException {

        CBaseDatos  bd1 =   new CBaseDatos(controlador, url, usuario, pass);
        java.sql.ResultSet cdr1 =   bd1.obtenerTabla(tabla);

        CBaseDatos  bd2 =   new CBaseDatos(controlador, url, usuario, pass);
        java.sql.ResultSet cdr2 =   bd2.obtenerTabla(tabla);

        CBaseDatos  bd3 =   new CBaseDatos(controlador, url, usuario, pass);
        java.sql.ResultSet cdr3 =   bd3.obtenerTabla(tabla);


        if(cdr != null) cdr.close();
        cdr = bd.obtenerTabla(tabla);
        cdr.beforeFirst();
        while(cdr.next()){
            cdr =   cdr1;
        }
        Object[][] datos = new Object[][]{
            {cdr1.getString("id_usuario"),cdr1.getString("nombre"),
             cdr2.getString("apellido"),cdr2.getString("saldo"),
             cdr3.getString("edad"),cdr3.getString("telefono")}
        };
        
        
        info = cdr.getMetaData();
        fireTableStructureChanged(); //Actualizar el objeto jtable
        System.out.println("Datos Cargados.\n");
    }

    public void cerrar() {
        try {
            if (cdr != null) {
                cdr.close();
            }
            if (bd != null) {
                bd.cerrarConexion();
            }
            System.out.println("Conexion cerrada con exito.\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Retornar el nombre de la columna especificada
    public String getColumnName(int c) {
        try {
            if (cdr != null) {
                return info.getColumnName(c + 1);
            }
            return "";
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    //Retornar el numero de columnas de la tabla
    public int getColumnCount() {
        try {
            if (info != null) {
                return info.getColumnCount();
            }
            return 0;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //Retornar el numero de filas de la tabla
    public int getRowCount() {
        try {
            if (cdr != null) {
                cdr.last(); //Poner el puntero en la ultima fila
                return cdr.getRow(); //Devolvemos el numero de la ultima fila
            }
            return 0;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    //Datos de la celda especificada
    public Object getValueAt(int fila, int col) {
        try {
            if (cdr != null) {
                cdr.absolute(fila + 1);
                return cdr.getObject(col + 1);
            }
            return "";
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
