package beans;

/* App: BTimeSheet.java
 * Tipo: Bean
 * Descripcion: Bean para conectarse a la BD mediante el pool de conexiones
 * Datasource y a la vez implemanta metodos necesarios para los beans
 */


import java.sql.*;
import javax.servlet.*;
import javax.sql.*;    // para DataSource


public class BDTimeSheet {

    private Connection  conexion;
    private Statement   query;
    private ResultSet   cdr;

    public BDTimeSheet( DataSource servCon )
            throws java.sql.SQLException, javax.servlet.ServletException{

        //Creamos el metodo sincronizado para obtener los datos
        synchronized( servCon ){
            conexion    =   servCon.getConnection();
        }
        //Si hubo algun problema con el servidor
        if (conexion == null) {
            throw new ServletException("Problemas con la conexion");
        }
        //Creamos la sentencia sql
        query   =   conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                             ResultSet.CONCUR_UPDATABLE);

        System.out.println("\nConexion realizada con Exito.\n");
    }

    //Cerrar nuestra conexion
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
        System.out.println("\nConexion cerrada con Exito.\n");
    }


    //Inicio de sesion
    public ResultSet confirmarUsuario(String nick, String pwd)
            throws SQLException {
        cdr = query.executeQuery(
                "SELECT users.user_name "
                + "FROM users e"
                + "WHERE usuarios.nickname =" + "'" + nick + "' "
                + "AND usuarios.password =" + "'" + pwd + "'");
        return cdr;
    }

    public ResultSet consultaEntrdas( int id_usuario )
            throws SQLException{

        cdr =   query.executeQuery(
                "SELECT * FROM entradas WHERE id_usuario = '" + id_usuario +"'");
        return cdr;
    }
}
