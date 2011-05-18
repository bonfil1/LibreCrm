package beans;

/* App: BeanDatosUSuario.java
 * Tipo: Bean
 * Descripcion: Bean para conectarse a los metodos para obtener diversos
 * datos de la sesion del usuario como sus entradas y otras cosas
 */
import java.sql.ResultSet;
import java.util.*;
import javax.sql.*;
import javax.servlet.ServletException;

public class BeanDatosUSuario {

    private BDTimeSheet bd;

    public BeanDatosUSuario(DataSource servCon)
            throws java.sql.SQLException, ServletException {
        bd = new BDTimeSheet(servCon);
    }

    //Metodo creada para obtener los datos de las entradas del usuario
    //Acorde a su id de usuario
    public HashMap entradasUsuario(int id_u)
            throws java.sql.SQLException {

        //Creamos el objeto que dara orden a los datos de las entradas
        BeanDatosEntrada t  =   new BeanDatosEntrada();
        HashMap          m  =   new HashMap();
        ResultSet      cdr  =   bd.consultaEntrdas( id_u );
        int             id  =   0;

        if( cdr == null ){
            return null;
        }
        else {
            while( cdr.next() ){
                id  =   cdr.getInt("id_pedido");
                t   =   new BeanDatosEntrada(cdr.getInt("id_usuario"), id);
                m.put(id, t);
            }
            return m;
        }
    }
}
