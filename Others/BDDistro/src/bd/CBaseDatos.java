package bd;

public class CBaseDatos {

    private java.sql.Connection conexion;
    private java.sql.Statement query;
    private java.sql.ResultSet cdr;
    private int                nFilas;
    private int                id;

    public CBaseDatos(String controlador, String url,
            String usuario, String pass)
            throws ClassNotFoundException, java.sql.SQLException,
            InstantiationException, IllegalAccessException {

        //Creamos el driver con el parametro
        Class.forName(controlador).newInstance();
        conectar(url, usuario, pass);
    }

    public void conectar(String url, String user, String pass)
                                throws java.sql.SQLException {
        conexion = java.sql.DriverManager.getConnection(url, user, pass);
        query = conexion.createStatement(java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE,
                java.sql.ResultSet.CONCUR_UPDATABLE);
        System.out.println("Coneccion realizada a: " + url);
    }

    public void insertarCampo(String tabla, String campo, String dato)
                                        throws java.sql.SQLException {
        query.executeUpdate("INSERT INTO " + tabla + "(" + campo + ")"
                + "VALUES('" + dato + "')");
    }

    public void insertarCampo2(String tabla, String campo, String campo1, String campo2,
                               String dato, String dato1, String dato2)
                                         throws java.sql.SQLException {
        query.executeUpdate("INSERT INTO " + tabla + "("+ campo +"," + campo1 + "," + campo2 +")"
                + "VALUES('" + dato + "','" + dato1 + "','"+ dato2 +"')");
       
    }
    
    public void insertaMoroso( String nombre, String apellido, String saldo,
                               String edad, String telefono )
                                       throws java.sql.SQLException {
        query.executeUpdate("INSERT INTO morosos( nombre, apellidos,"
                + "saldo, edad, telefono)"
                + "VALUES('" + nombre + "','" + apellido + "'," + saldo + ",'"
                + edad + "','" + telefono + "')");
    }

    public void insertaMoroso2( String id_usuario, String nombre, String apellido, String saldo,
                                String edad, String telefono )
                                       throws java.sql.SQLException {
        query.executeUpdate("INSERT INTO morosos( id_usuario, nombre, apellidos,"
                + "saldo, edad, telefono)"
                + "VALUES('" + id_usuario + "','" + nombre + "','" + apellido + "'," + saldo + ",'"
                + edad + "','" + telefono + "')");
    }


    public void mostrarFilaActual( String tabla )throws java.sql.SQLException{
        //Realizamos una consulta hacia una tabla
        cdr =   query.executeQuery("SELECT * FROM "+ tabla);
        int     filas           =       0;

        cdr.beforeFirst();
        while(cdr.next()){
            filas++;
        }
        nFilas  =   filas + 1;
        System.out.println("Numero de filas: " + nFilas);
	System.out.println();       
    }

    public void IdUsuario( String tabla )throws java.sql.SQLException{
        //Realizamos una consulta hacia una tabla
        cdr =   query.executeQuery("SELECT * FROM "+ tabla);
        int     idFila           =       0;

        cdr.last();
        idFila  =   Integer.parseInt(cdr.getString("id_usuario"));
        id  =   idFila;
    }

    public int obtenerIdUsuario(){
        return  id;
    }

    public int obtFilas(){
        return nFilas;
    }

    //metodos para realizar consultas a la Base de datos
    public java.sql.ResultSet obtenerTabla1()
            throws java.sql.SQLException{

        

        return null;
    }


    public java.sql.ResultSet obtenerTabla(String tabla)
            throws java.sql.SQLException {
        cdr = query.executeQuery("SELECT * FROM " + tabla);
        return cdr;
    }

    public void cerrarConexion() throws java.sql.SQLException {
        if (cdr != null) {
            cdr.close();
        }
        if (query != null) {
            query.close();
        }
        if (conexion != null) {
            conexion.close();
        }
    }
    
}
