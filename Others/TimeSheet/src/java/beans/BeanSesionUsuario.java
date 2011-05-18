package beans;

import javax.sql.*;    // para DataSource
import java.sql.*;

public class BeanSesionUsuario {

   BDTimeSheet  bd;

   public BeanSesionUsuario(DataSource sevCon)
           throws java.sql.SQLException, javax.servlet.ServletException{

       //Iniciamos los datos
       bd   =   new BDTimeSheet(sevCon);
   }

   //Metodo para iniciar sesion
   public ResultSet comprobarUsuario( String nick , String pass )
                                    throws java.sql.SQLException{

       //Mediante el metodo confirmarUsuario checamos si el usuario existe
       //en nuestra base de datos
       ResultSet    cdr =   bd.confirmarUsuario(nick, pass);
       //Si el usuario no existe retornar null
       if( cdr == null) return null;
       //De ser lo contrario retorna los resultados
       else return cdr;
       
   }

   public void cerrarConexion()
   throws java.sql.SQLException{
        bd.cerrarConexion();
   }

}
