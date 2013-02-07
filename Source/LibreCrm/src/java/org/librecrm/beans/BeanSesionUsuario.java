/* App: BeanSesionUsuario.java
 * Tipo: Bean
 * Descripcion: Bean que trabaja en conjunto con BDLibreCrm
 * para identificar un usuario
 */
package org.librecrm.beans;

import java.sql.ResultSet;
import javax.sql.DataSource;

/**
 * @author Jose Angel Bonfil Evia
 * @version 1.0a
 */
public class BeanSesionUsuario {

    protected BDLibreCrm bd;
    private static String name;

    public BeanSesionUsuario() {
    }

    /**
     * Constructor de la clase para crear la conexion via un pool
     * @param servCon Objeto mediante el cual se crea el pool
     * @throws java.sql.SQLException se tira de haber una excepcion con la bd
     * @throws javax.servlet.ServletException en caso de haber error en el servlet
     */
    public BeanSesionUsuario(DataSource servCon)
            throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new BDLibreCrm(servCon);
    }

    //Metodo para iniciar sesion
    public ResultSet comprobarUsuario(String nick, String pass)
            throws java.sql.SQLException {

        //Mediante el metodo confirmarUsuario checamos si el usuario existe
        //en nuestra base de datos
        ResultSet cdr = bd.confirmarUsuario(nick, pass);
        //Si el usuario no existe retornar null
        if (cdr == null) return null;
        //De ser lo contrario retorna los resultados
        else {
            return cdr;
        }

    }

    public void setUsuario(String name){
        this.name = name;
    }

    public String getUsuario(){
        return this.name;
    }

    public void cerrarConexion()
            throws java.sql.SQLException {
        bd.cerrarConexion();
        System.out.println("BeanSesionUsuario Cerrado");
    }
}
