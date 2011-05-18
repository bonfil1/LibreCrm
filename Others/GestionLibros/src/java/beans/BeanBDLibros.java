package beans;

import java.util.*;
import javax.sql.*;    // para DataSource
import java.sql.*;

/*
 * Podemos entender esta clase como el medio de conexion entre el servlet controlador y la clase
 * BDLibros.  Hay que tener presente que algunos de los metodos existentes en BDLibros devuelven
 * tablas de datos del tipo ResultSet.  Esta interfaz no nos permite manipular los datos existentes
 * en ella y solo nos serviria para listarlos asi que esta clase se encarga, entre otras cosas, de
 * transformar el contenedor de datos obtenido en BDLibros para alcanzar una mayor eficiencia y una
 * posible manipulacion y obtencion de ciertos datos, por medio de tablas HashMap.
 */
public class BeanBDLibros
{
    private BDLibros bd;
    private int numFilas = 0;
    public  static  String estadoBd;
    // Constructor de la clase
    public BeanBDLibros(DataSource servCon)
    throws java.sql.SQLException, javax.servlet.ServletException
    {
        bd = new BDLibros(servCon);
    }
  
    // Podemos obtener cualquier libro por su t�tulo.
    public HashMap getLibrosxTitulo(String titulo_libro) throws java.sql.SQLException
    {
        BeanDatosLibro t = new BeanDatosLibro();
        HashMap m = new HashMap();
        ResultSet cdr = bd.busquedaTitulo(titulo_libro);  // Obtenemos los datos de BDLibros
        int id = 0;
    
        while (cdr.next())                  // Mientras la tabla cdr no est� vac�a...
        {
            id = cdr.getInt("id_libro");
            t = new BeanDatosLibro(
            id,                             // Nos servir� como identificador en la tabla HashMap
            cdr.getString("titulo_libro"),
            cdr.getString("nom_autor"),
            cdr.getString("nom_editorial"),
            cdr.getInt("ed_libro"),
            cdr.getInt("anyo_libro"),
            cdr.getInt("precio_libro") );
            m.put(new Integer(id), t);      // Almacenamos en la tabla HashMap
        }
    
        numFilas = m.size();                // Siempre podremos saber la dimensi�n de la tabla
    
        return m;
    }

    // Podemos obtener cualquier libro escrito por un determinado autor.
    public HashMap getLibrosxAutor(String nom_autor) throws java.sql.SQLException
    {
        BeanDatosLibro t = new BeanDatosLibro();
        HashMap m = new HashMap();
        ResultSet cdr = bd.busquedaAutor(nom_autor);
        int id = 0;
    
        while (cdr.next())
        {
            id = cdr.getInt("id_libro");
            t = new BeanDatosLibro(
            id,
            cdr.getString("titulo_libro"),
            cdr.getString("nom_autor"),
            cdr.getString("nom_editorial"),
            cdr.getInt("ed_libro"),
            cdr.getInt("anyo_libro"),
            cdr.getInt("precio_libro") );
            m.put(new Integer(id), t);
        } 
    
        numFilas = m.size();
        
        return m;
    }    

    // Este m�todo nos permite obtener cualquier libro registrado de una determinada editorial
    // si �sta est� tambi�n registrada.
    public HashMap getLibrosxEditorial(String nom_editorial) throws java.sql.SQLException
    {
        BeanDatosLibro t = new BeanDatosLibro();
        HashMap m = new HashMap();
        ResultSet cdr = bd.busquedaEditorial(nom_editorial);
        int id = 0;
    
        while (cdr.next())
        {
            id = cdr.getInt("id_libro");
            t = new BeanDatosLibro(
            id,
            cdr.getString("titulo_libro"),
            cdr.getString("nom_autor"),
            cdr.getString("nom_editorial"),
            cdr.getInt("ed_libro"),
            cdr.getInt("anyo_libro"),
            cdr.getInt("precio_libro") );
            m.put(new Integer(id), t);
        }
    
        numFilas = m.size();
    
        return m;
    }    

    // Tenemos los libros clasificados por categor�as
    public HashMap getLibrosxCategoria(String nom_cat) throws java.sql.SQLException
    {
        BeanDatosLibro t = new BeanDatosLibro();
        HashMap m = new HashMap();
        ResultSet cdr = bd.busquedaCategoria(nom_cat);
        int id = 0;
    
        while (cdr.next())
        {
            id = cdr.getInt("id_libro");
            t = new BeanDatosLibro(
            id,
            cdr.getString("titulo_libro"),
            cdr.getString("nom_autor"),
            cdr.getString("nom_editorial"),
            cdr.getInt("ed_libro"),
            cdr.getInt("anyo_libro"),
            cdr.getInt("precio_libro") );
            m.put(new Integer(id), t);
        }
    
        numFilas = m.size();
    
        return m;
    }    
    
    // Este m�todo nos permite obtener un listado de todos los libros existentes en la base de datos.
    public HashMap getTodosLibros() throws java.sql.SQLException
    {
        BeanDatosLibro t = new BeanDatosLibro();
        HashMap m = new HashMap();
        ResultSet cdr = bd.busquedaTotal();
        int id = 0;
    
        while (cdr.next())
        {
            id = cdr.getInt("id_libro");
            t = new BeanDatosLibro(
            id,
            cdr.getString("titulo_libro"),
            cdr.getString("nom_autor"),
            cdr.getString("nom_editorial"),
            cdr.getInt("ed_libro"),
            cdr.getInt("anyo_libro"),
            cdr.getInt("precio_libro") );
            m.put(new Integer(id), t);
        } 
    
        numFilas = m.size();
    
        return m;        
    }
    
    // Si nos hace falta saber la profundidad de una tabla...
    public int getNumFilas()
    {
        return numFilas;
    }
  
    // Podr�amos insertar un libro en la base de datos.  Aunque este m�todo no est� en uso para
    // la versi�n actual de la aplicaci�n.
    public void insertarEnLibro(int id_libro,String titulo_libro,int anyo_libro, int stock_libro,
    String resumen_libro,int ed_libro,int precio_libro)
    throws SQLException
    {
        bd.insertarEnLibro(id_libro,titulo_libro,anyo_libro,stock_libro,
        resumen_libro,ed_libro, precio_libro);
    }

    // Tenemos dos m�todos que acceden a la tabla Usuarios
    
    /*
     * Para dar permiso de compra a un usuario del sistema, primero se tendr� que saber si 
     * el usuario est� o no registrado.
     */
    public ResultSet comprobarUser(String nick, String pwd)
    throws java.sql.SQLException
    {
        ResultSet cdr = bd.confirmarUsuario(nick, pwd);  // Obtendremos el resultado de BDLibros
        
        if(cdr == null)
            return null;
        else
            return cdr;
    }
    
    /*
     * Todo usuario no registrado podra registrarse gratuitamente y los datos seran introducidos
     * a traves de este metodo.
     */
    public void RegistrarUsuario(BeanDatosUsuario Usuario)
    throws SQLException
    {
        int id_u = 0;
        ResultSet cdr = bd.obtenerUsuarios();  // listado de todos los usuarios registrados.
        
        // Buscamos el numero de identificacion del ultimo usuario registrado
        // para insertar el nuevo a continuacion.
        while(cdr.next())
        {
            id_u = cdr.getInt("id_usuario");
        }
        
        id_u++;  // El numero de identificacion del ultimo + 1
        
        Usuario.setId_Usuario(id_u);        
        // Metodo de la clase BDLibros que inserta de manera directa en la base de datos
        bd.insertarEnUsuarios(Usuario);        
    }
    
    // M�todos referentes a los pedidos que puede realizar un usuario o que quiere consultar
    /*
     * Para poder registrar un pedido tendremos que saber qui�n es el que lo ha realizado, c�mo
     * lo va a abonar y el n�mero de unidades que quiere de cada libro pedido
     */
    public void RegistrarPedido(HashMap carrito, int id_u, String FormaPago)
    throws SQLException
    {
        int id_p = 0, id_l = 0, unidades = 0;
        Set claves = carrito.keySet();    // Obtenemos un conjunto de claves
        Iterator i = claves.iterator();   // Creamos un iterador para obtener todos los c�digos que necesitamos
        BeanDatosLibro t = new BeanDatosLibro();
        ResultSet cdr = bd.obtenerPedidos();
        
        // Buscamos el n�mero de identificaci�n del �ltimo pedido registrado
        // para insertar uno nuevo a continuaci�n.
        while(cdr.next())
        {
            id_p = cdr.getInt("id_pedido");
        }        
        id_p++;
        
        // Guardamos en la base de datos el pedido registrado en el carrito de
        // la compra del usuario.
        if(carrito != null)
        {
            while(i.hasNext())
            {
                t = (BeanDatosLibro)carrito.get(i.next());
                id_l = t.getId_libro();
                unidades = t.getUnidades();  // Obtenemos las unidades de cada libro pedido
                
                // Cada pedido tiene un estado inicial "En Espera" que el Administrador ir�
                // cambiando a medida que los servicios se puedan ir satisfaciendo.
                String estado = null;
                estado = new String("En Espera");
                
                bd.insertarPedido(id_p, id_l, id_u, FormaPago, estado, unidades);
            }
        }
        else
            System.out.println("carrito es null");
    }   
    
    // Este m�todo permite obtener un listado de todos los pedidos realizados por un
    // usuario determinado.
    public HashMap historialPedidos(int id_u)
    throws java.sql.SQLException
    {
        BeanDatosPedido t = new BeanDatosPedido();
        HashMap m = new HashMap();
        ResultSet cdr = bd.pedidosCliente(id_u);
        int id = 0;
        
        if(cdr == null)
            return null;
        else
        {
            while(cdr.next())
            {
                id = cdr.getInt("id_pedido");
                t = new BeanDatosPedido(
                    id,
                    cdr.getInt("id_libro"),          // S�lo obtenemos el n�mero de identificaci�n
                    cdr.getInt("id_usuario"),        // del pedido y del usuario...
                    cdr.getInt("unidades") );        // Y las unidades de cada libro pedido
                    m.put(new Integer(id), t);
            }
            
            return m;
        }
    }

    // Cuando el usuario ya sabe el pedido que quiere consultar, este m�todo permite obtener
    // un resumen detallado del pedido.  
    public HashMap verPedido(int id_p)
    throws java.sql.SQLException
    {
        BeanDatosLibro t = new BeanDatosLibro();
        BeanDatosPedido p = new BeanDatosPedido();
        TreeSet lista = obtenerLista(id_p);
        Iterator i = null;
        HashMap m = new HashMap();
        ResultSet cdr = bd.obtenerPedido(id_p);
        int id = 0, und = 0, id_ped = 0;
        
        if(cdr == null)
            return null;
        else
        {
            while(cdr.next())
            {
                i = lista.iterator();
                
                id = cdr.getInt("id_libro");
                t = new BeanDatosLibro(
                id,
                cdr.getString("titulo_libro"),
                cdr.getString("nom_autor"),
                cdr.getString("nom_editorial"),
                cdr.getInt("ed_libro"),
                cdr.getInt("anyo_libro"),
                cdr.getInt("precio_libro") );
                
                while(i.hasNext())
                {
                    p = (BeanDatosPedido)i.next();

                    int id_libro = p.getId_libro();
                    if(id == id_libro)
                    {
                        // Como las unidades de un libro son inicialmente 0, tendremos
                        // que ser capaces de actualizar ese valor obteni�ndolo de la lista
                        // de pedidos, para que el usuario pueda ver por pantalla las unidades
                        // del libro que pidi�.
                        t.setUnidades(p.getUnidades());
                    }
                }
                
                i = null;
                
                m.put(new Integer(id), t);
            }
            
            return m;
        }        
    }
    
    /*
     * La raz�n de usar una lista de tipo TreeSet en este caso se debe a que la clave de la
     * tabla listapedidos es compuesta y mientras HashMap no nos permite obtener la clave de un
     * dato de la tabla en concreto, TreeSet s� nos lo permite con lo que nos es sencillo sacar
     * todos los datos de tabla listapedidos.
     */
    public TreeSet obtenerLista(int id_p)
    throws java.sql.SQLException
    {
        BeanDatosPedido t = new BeanDatosPedido();
        TreeSet m = new TreeSet(t);
        ResultSet cdr = bd.obtenerPedidos();
        int id = 0;
        
        if(cdr == null)
            return null;
        else
        {
            while(cdr.next())
            {
                if(id_p == cdr.getInt("id_pedido"))
                {
                    t = new BeanDatosPedido(
                        id,                               // Como la tabla es compuesta
                        cdr.getInt("id_libro"),           // no tenemos m�s remedio que
                        cdr.getInt("id_usuario"),         // alterar internamente la clave
                        cdr.getInt("unidades") );         // compuesta y pasarla a simple
                        m.add(t);                         // de forma transparente para el usuario.
                        id++;
                }
            }
            
            return m;
        }
    }
    
    // M�todo que sirve para cerrar la conexi�n con la base de datos cada vez que se
    // abandona el servlet
    
    public void cerrarConexion() throws java.sql.SQLException
    {
        bd.cerrarConexion();
    }
}
