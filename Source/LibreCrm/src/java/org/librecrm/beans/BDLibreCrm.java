/* App: BDLibreCrm.java
 * Tipo: Bean
 * Descripcion: Bean que hace de interfaz con la base de datos por medio de
 * un pool de conexiones
 */
package org.librecrm.beans;

import java.sql.*;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 * @author Jose Angel Bonfil Evia
 * @version 1.0a
 */
public class BDLibreCrm {

    private Connection conexion;
    private Statement query;
    private ResultSet cdr;

    /**
     * Constructor por default de la clase
     */
    public BDLibreCrm() {
    }

    /**
     * @param servCon Objeto mediante el cual se crea el pool
     * @throws java.sql.SQLException En caso haber una excepcion con la bd
     * @throws javax.servlet.ServletException En caso de haber error en el servlet
     */
    public BDLibreCrm(DataSource servCon)
            throws SQLException, javax.servlet.ServletException {

        //Creamos el metodo sincronizado para obtener los datos
        synchronized (servCon) {
            conexion = servCon.getConnection();
        }

        //Si hubo algun problema con el servidor
        if (conexion == null) {
            throw new ServletException("Problemas con la conexion");
        }

        //Creamos la sentencia sql
        query = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        System.out.println("\nConexion realizada con Exito.\n");
    }

    /**
     * Cierra la conexion a la base de datos
     * @throws java.sql.SQLException si ocurre un error con la bd
     */
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

    /**
     * confirmarUsuario nos permite autenticar un usuario
     * @return java.sql.ResultSet
     * @param nick es el nickname del usuario
     * @param pwd es el password del usuario
     * @throws java.sql.SQLException 
     */
    public ResultSet confirmarUsuario(String nick, String pwd)
            throws SQLException {
        cdr = query.executeQuery(
                "SELECT "
                + "u.id         AS id_usuario,"
                + "u.user_name	AS nick,"
                + "u.is_admin	AS isadmin,"
                + "u.name       AS nombre,"
                + "u.last_name	AS apellidos,"
                + "u.last_login	AS fecha "
                + "FROM users AS u "
                + "WHERE u.user_name = " + "'" + nick + "' "
                + "AND u.password = " + "'" + pwd + "'");
        return cdr;

    }

    /**
     * getUltimasAcciones obtiene las ultimas inserciones en la bd creadas
     * por un determinado usuario
     * @return java.sql.ResultSet con la consulta hecha
     * @param usuarioId String es el id del usuario a consultar
     * @param pwd es el password del usuario
     * @throws java.sql.SQLException
     */
    public ResultSet getUltimasAcciones(String usuarioId, String tabla,
            int limiteInicio, int limiteFin)
            throws SQLException {
        cdr = query.executeQuery("SELECT * FROM " + tabla + " WHERE created_by = \'" + usuarioId + "\'"
                + " ORDER BY \'date_entered\' ASC"
                + " LIMIT " + limiteInicio + "," + limiteFin);        
        return cdr;
    }

    public ResultSet getCuentasPorUsuario()
                throws SQLException{
        cdr =   query.executeQuery("SELECT asigned_user_id FROM accounts");
        return cdr;
    }
}
