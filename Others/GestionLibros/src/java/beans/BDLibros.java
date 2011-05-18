package beans;

import java.sql.*;
import javax.servlet.*;
import javax.sql.*;    // para DataSource

/*
 * La clase BDLibros nos permite interactuar con la base de datos.  Nos permite conectarnos y
 * desconectarnos de ella.  Nos permite obtener e introducir datos en la base de datos a trav�s
 * de los distintos m�todos que se pueden ver en la clase.
 */
public class BDLibros {

    private Connection conexion;
    private Statement sentenciaSQL;
    private ResultSet cdr; // conjunto de resultados

    /* Crea una nueva instancia de BDLibros */
    public BDLibros(DataSource servCon)
            throws java.sql.SQLException, javax.servlet.ServletException {
        synchronized (servCon) {
            conexion = servCon.getConnection(); // recuperar la conexi�n
        }
        if (conexion == null) {
            throw new ServletException("Problemas con la conexion");
        }

        // Crear una sentencia SQL
        sentenciaSQL = conexion.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        System.out.println("\nConexion realizada con Exito.\n");
    }

    // Cerramos la conexi�n de la Base de Datos
    public void cerrarConexion() throws java.sql.SQLException {
        if (cdr != null) {
            cdr.close();
        }
        if (sentenciaSQL != null) {
            sentenciaSQL.close();
        }
        if (conexion != null) {
            conexion.close();
        }
        System.out.println("\nConexion cerrada con Exito.\n");
    }

    // Buscamos un libro por su titulo
    public ResultSet busquedaTitulo(String titulo_libro)
            throws SQLException {
        String tit_libro = new String("'%" + titulo_libro + "%'");
        cdr = sentenciaSQL.executeQuery(
                "SELECT libro.id_libro, libro.titulo_libro, autor.nom_autor, editorial.nom_editorial, "
                + "libro.ed_libro, libro.anyo_libro, libro.precio_libro "
                + "FROM libro, autor, editorial, libro_autor, libro_editorial, categoria, libro_categoria "
                + "WHERE libro.titulo_libro LIKE " + tit_libro
                + "AND libro.stock_libro <> 0 "
                + "AND libro.id_libro=libro_autor.id_libro "
                + "AND libro_categoria.id_libro=libro.id_libro "
                + "AND libro_categoria.id_categoria=categoria.id_categoria "
                + "AND libro_autor.id_autor=autor.id_autor "
                + "AND libro.id_libro=libro_editorial.id_libro "
                + "AND libro_editorial.id_editorial=editorial.id_editorial ");
        return cdr;
    }

    // Buscamos el/los libro/libros que haya escrito un autor determinado
    public ResultSet busquedaAutor(String autor)
            throws SQLException {
        String autor_libro = new String("'%" + autor + "%'");
        cdr = sentenciaSQL.executeQuery(
                "SELECT libro.id_libro, libro.titulo_libro, autor.nom_autor, editorial.nom_editorial, "
                + "libro.ed_libro, libro.anyo_libro, libro.precio_libro "
                + "FROM libro, autor, editorial, libro_autor, libro_editorial, categoria, libro_categoria "
                + "WHERE autor.nom_autor LIKE " + autor_libro
                + "AND autor.id_autor=libro_autor.id_autor "
                + "AND libro_autor.id_libro=libro.id_libro "
                + "AND libro_categoria.id_libro=libro.id_libro "
                + "AND libro_categoria.id_categoria=categoria.id_categoria "
                + "AND libro.id_libro=libro_editorial.id_libro "
                + "AND libro_editorial.id_editorial=editorial.id_editorial ");
        return cdr;
    }

    // Podemos buscar cualquier libro almacenado en la base de datos perteneciente a una editorial
    public ResultSet busquedaEditorial(String editorial)
            throws SQLException {
        String editorial_libro = new String("'%" + editorial + "%'");
        cdr = sentenciaSQL.executeQuery(
                "SELECT libro.id_libro, libro.titulo_libro, autor.nom_autor, editorial.nom_editorial, "
                + "libro.ed_libro, libro.anyo_libro, libro.precio_libro "
                + "FROM libro, autor, libro_autor, editorial, libro_editorial, categoria, libro_categoria "
                + "WHERE editorial.nom_editorial LIKE " + editorial_libro
                + "AND editorial.id_editorial=libro_editorial.id_editorial "
                + "AND libro_editorial.id_libro=libro.id_libro "
                + "AND libro_categoria.id_libro=libro.id_libro "
                + "AND libro_categoria.id_categoria=categoria.id_categoria "
                + "AND libro.id_libro=libro_autor.id_libro "
                + "AND libro_autor.id_autor=autor.id_autor ");
        return cdr;
    }

    // Todos los libros pertenecen a una o mas categorias
    public ResultSet busquedaCategoria(String categoria)
            throws SQLException {
        String cat_libro = new String("'%" + categoria + "%'");
        cdr = sentenciaSQL.executeQuery(
                "SELECT libro.id_libro, libro.titulo_libro, autor.nom_autor, editorial.nom_editorial, "
                + "libro.ed_libro, libro.anyo_libro, libro.precio_libro "
                + "FROM libro, autor, libro_autor, editorial, libro_editorial, categoria, libro_categoria "
                + "WHERE categoria.nom_categoria LIKE " + cat_libro
                + "AND categoria.id_categoria=libro_categoria.id_categoria "
                + "AND libro_categoria.id_libro=libro.id_libro "
                + "AND libro_editorial.id_libro=libro.id_libro "
                + "AND editorial.id_editorial=libro_editorial.id_editorial "
                + "AND libro.id_libro=libro_autor.id_libro "
                + "AND libro_autor.id_autor=autor.id_autor ");
        return cdr;
    }

    // Podemos obtener un listado de todos los libros contenidos en la base de datos
    public ResultSet busquedaTotal()
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT libro.id_libro, libro.titulo_libro, autor.nom_autor, editorial.nom_editorial, "
                + "libro.ed_libro, libro.anyo_libro, libro.precio_libro "
                + "FROM libro, autor, libro_autor, editorial, libro_editorial "
                + "WHERE libro.id_libro=libro_autor.id_libro "
                + "AND libro_autor.id_autor=autor.id_autor "
                + "AND libro.id_libro=libro_editorial.id_libro "
                + "AND libro_editorial.id_editorial=editorial.id_editorial ");
        return cdr;
    }

    /*
     * Metodos no usados hasta ahora, nos permitirian insertar datos en la base de datos.
     * Necesitatamos algun metodo mas para poder tener todas las tablas completadas
     * correctamente ya que con solo estos metodos no seriamos capaces de visualizar las
     * inserciones realizadas completamente.
     * Se deja esta labor para futuras expansiones de la aplicacion.
     */
    public void insertarEnLibro(int id_libro, String titulo_libro, int anyo_libro, int stock_libro,
            String resumen_libro, int ed_libro, int precio_libro)
            throws SQLException {
        sentenciaSQL.executeUpdate("INSERT INTO libro"
                + " VALUES ('" + id_libro + "', '" + titulo_libro + "', '" + anyo_libro + "', '"
                + stock_libro + "', '" + resumen_libro + "', '" + ed_libro + "', '" + precio_libro + "')");
    }

    public void insertarEnAutor(int id_autor, String nom_autor)
            throws SQLException {
        sentenciaSQL.executeUpdate("INSERT INTO autor"
                + " VALUES ('" + id_autor + "', '" + nom_autor + "')");
    }

    public void insertarEnCategoria(int id_categoria, String nom_categoria, String descr_categoria)
            throws SQLException {
        sentenciaSQL.executeUpdate("INSERT INTO categoria"
                + " VALUES ('" + id_categoria + "', '" + nom_categoria + "', '" + descr_categoria + "')");
    }

    public void insertarEnEditorial(int id_editorial, String nom_editorial, String dir_editorial,
            String email_editorial, int tlf_editorial)
            throws SQLException {
        sentenciaSQL.executeUpdate("INSERT INTO editorial"
                + " VALUES ('" + id_editorial + "', '" + nom_editorial + "', '" + dir_editorial + "', '"
                + email_editorial + "', '" + tlf_editorial + "')");
    }

    /*
     * M�todos para modificar datos existentes en la base de datos.
     * Estos m�todos podr�an usarse tal cuales est�n porque no afectan a ninguna de las tablas
     * asociativas existentes en la base de datos.
     * Est�n en desuso en estos momentos pero podr�an ser necesitados en futuras expansiones
     * de la aplicaci�n.
     */
    public void modificarEnLibro(int id_libro, String titulo_libro, int anyo_libro, int stock_libro,
            String resumen_libro, int ed_libro, int precio_libro)
            throws SQLException {
        sentenciaSQL.executeUpdate("UPDATE libro"
                + "SET libro.titulo_libro=" + "'" + titulo_libro + "',"
                + "libro.anyo_libro=" + "'" + anyo_libro + "',"
                + "libro.stock_libro=" + "'" + stock_libro + "',"
                + "libro.resumen_libro=" + "'" + resumen_libro + "',"
                + "libro.ed_libro=" + "'" + ed_libro + "',"
                + "libro.precio_libro=" + "'" + precio_libro + "')");
    }

    public void modificarEnAutor(int id_autor, String nom_autor)
            throws SQLException {
        sentenciaSQL.executeUpdate("UPDATE autor"
                + "SET autor.nom_autor=" + "'" + nom_autor + "')");

    }

    public void modificarEnEditorial(int id_editorial, String nom_editorial, String dir_editorial,
            String email_editorial, int tlf_editorial)
            throws SQLException {
        sentenciaSQL.executeUpdate("UPDATE editorial"
                + "SET editorial.nom_editorial=" + "'" + nom_editorial + "',"
                + "editorial.dir_editorial=" + "'" + dir_editorial + "',"
                + "editorial.email_editorial=" + "'" + email_editorial + "',"
                + "editorial.tlf_editorial=" + "'" + tlf_editorial + "')");
    }

    /*
     * Podemos obtener la identificaci�n de un libro a partir de su nombre completo, al igual
     * que podemos obtener el n�mero de identificaci�n de cualquier autor existente en la base
     * de datos, de cualquier categor�a o de cualquier editorial.
     */
    public int obtenerIdLibro(String nom_libro) throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM libro"
                + "WHERE libro.titulo_libro = " + "'" + nom_libro + "'");

        if (cdr.isBeforeFirst()) {
            cdr.first();
            return cdr.getInt("id_libro");
        } else {
            return -1;
        }
    }

    public int obtenerIdAutor(String nom_autor) throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM autor"
                + " WHERE autor.nom_autor = " + "'" + nom_autor + "'");

        if (cdr.isBeforeFirst()) {
            cdr.first();
            return cdr.getInt("id_autor");
        } else {
            return -1;
        }
    }

    public int obtenerIdEditorial(String nom_editorial) throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM editorial"
                + " WHERE editorial.nom_editorial = " + "'" + nom_editorial + "'");

        if (cdr.isBeforeFirst()) {
            cdr.first();
            return cdr.getInt("id_editorial");
        } else {
            return -1;
        }
    }

    public int obtenerIdCategoria(String nom_categoria) throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM categoria"
                + " WHERE categoria.nom_categoria = " + "'" + nom_categoria + "'");

        if (cdr.isBeforeFirst()) {
            cdr.first();
            return cdr.getInt("id_categoria");
        } else {
            return -1;
        }
    }

    // M�todos que acceden a la tabla Usuarios
    /*
     * M�todo que nos permite buscar un usuario en la base de datos para saber si est�
     * o no registrado.
     */
    public ResultSet confirmarUsuario(String nick, String pwd)
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT usuarios.id_usuario, usuarios.nom_usuario, usuarios.nick_usuario, "
                + "usuarios.tlf_usuario, usuarios.dir_usuario, usuarios.cp_usuario, "
                + "usuarios.ciud_usuario, usuarios.prov_usuario, usuarios.pwd_usuario "
                + "FROM usuarios "
                + "WHERE usuarios.nick_usuario=" + "'" + nick + "'"
                + "AND usuarios.pwd_usuario=" + "'" + pwd + "'");

        return cdr;
    }

    /*
     * Cuando un usuario nuevo quiere registrarse en el sistema, se le piden una serie de datos
     * y se usa este metodo para insertarlo en la base de datos.
     */
    public void insertarEnUsuarios(BeanDatosUsuario Usuario)
            throws SQLException {       
        sentenciaSQL.executeUpdate("INSERT INTO usuario"
                + " VALUES (" + Usuario.getId_Usuario() + ", '" + Usuario.getNom_Usuario() + "', '"
                + Usuario.getNick_Usuario() + "', '" + Usuario.getTlf_Usuario() + "', '"
                + Usuario.getDir_Usuario() + "'," + Usuario.getCp_Usuario() + ", '"
                + Usuario.getCiud_Usuario() + "', '" + Usuario.getProv_Usuario() + "', '"
                + Usuario.getPwd_Usuario() + "')");                
    }

    
    /*
     * Con este m�todo podemos obtener todos los usuarios existentes en la base de datos.
     */
    public ResultSet obtenerUsuarios()
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM usuarios");

        return cdr;
    }

    // M�todo que modifica la tabla listaPedidos de la base de datos
    /*
     * Cuando un usuario registrado quiere realizar un pedido, �ste tiene que ser introducido
     * en la base de datos para que los administradores del sistema puedan atenderlo.
     */
    public void insertarPedido(int id_p, int id_l, int id_u, String fPago, String estado, int unidades)
            throws SQLException {
        sentenciaSQL.executeUpdate("INSERT INTO listapedidos"
                + " VALUES (" + id_p + ", '" + id_l + "', '" + id_u + "', '" + fPago + "', '" + estado + "','" + unidades + "')");
    }

    // M�todos que obtienen informaci�n de la tabla listaPedidos de la base de datos
    /*
     * M�todo que nos permite obtener un listado de todos los pedidos existentes en la base de datos.
     */
    public ResultSet obtenerPedidos()
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM listapedidos");

        return cdr;
    }

    /*
     * M�todo que nos permite obtener un pedido concreto.
     */
    public ResultSet obtenerPedido(int id_p)
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT libro.id_libro, libro.titulo_libro, autor.nom_autor, editorial.nom_editorial, "
                + "libro.ed_libro, libro.anyo_libro, libro.precio_libro "
                + "FROM libro, autor, libro_autor, editorial, libro_editorial, categoria, libro_categoria, listapedidos "
                + "WHERE listapedidos.id_pedido=" + "'" + id_p + "'"
                + "AND listapedidos.id_libro = libro.id_libro "
                + "AND libro.id_libro=libro_autor.id_libro "
                + "AND libro_categoria.id_libro=libro.id_libro "
                + "AND libro_categoria.id_categoria=categoria.id_categoria "
                + "AND libro_autor.id_autor=autor.id_autor "
                + "AND libro.id_libro=libro_editorial.id_libro "
                + "AND libro_editorial.id_editorial=editorial.id_editorial ");

        return cdr;
    }

    /*
     * M�todo que permite obtener un listado de todos los pedidos realizados por un determinado
     * cliente.
     */
    public ResultSet pedidosCliente(int id_u)
            throws SQLException {
        cdr = sentenciaSQL.executeQuery(
                "SELECT * FROM listapedidos WHERE id_usuario = " + "'" + id_u + "'");

        return cdr;
    }
}

