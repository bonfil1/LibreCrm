
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import beans.*;

import javax.sql.*;    // para DataSource
import javax.naming.*; // para Context

public class SvLibros extends HttpServlet {

    private DataSource servicioConexiones;
    private static String nombre, nick;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            // Recuperar el contexto inicial
            Context ctx = new InitialContext();
            // Referencia al servicio de conexiones
            servicioConexiones =
                    (DataSource) ctx.lookup("java:comp/env/jdbc/bd_libros");
        } catch (Exception e) {
            throw new ServletException(
                    "Imposible recuperar java:comp/env/jdbc/bd_libros", e);
        }
    }
    
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {        
        //Enviamos a la pagina de bienvenida
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/Bienvenida.jsp");       
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    // Este es el metodo que se encarga de procesar las peticiones del
    // cliente enviadas a traves de los formularios que se presentan en las
    // paginas HTML generadas a partir de las paginas JSP
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        // Obtenemos la sesion con que este trabajando el cliente en esta
        // peticion HTTP
        HttpSession sesion = request.getSession(true);
        
        BeanCarro carro = null;
        BeanBDLibros bBDLib = null;
        String operFallida = new String("SI");
        HashMap respuesta = null;
        String precioTotal = null;
        RequestDispatcher dispatcher = null;

        try {
            // Realizar una conexion con la BD
            bBDLib = new BeanBDLibros(servicioConexiones);

            // Creamos un nuevo carro, o actualizamos el carro actual, en funcion
            // de que la sesion ya disponga de un objeto de tipo BeanCarro o no
            carro = (BeanCarro) sesion.getAttribute("carro");
            String boton = request.getParameter("boton");

            if (carro == null) {
                // Si estamos ante un nuevo cliente, creamos un carro para el y lo
                // guandamos como atributo de la sesion que ha establecido el
                // cliente con el servidor Web
                carro = new BeanCarro();
                sesion.setAttribute("carro", carro);
            } else if (carro != null && (boton.equals("Buscar") || boton.equals("Comprar") || boton.equals("Ver Carrito"))) {
                // Si el cliente es antiguo, simplemente guardamos el contenido del
                // carro con lo que haya seleccionado anteriormente
                if (!carro.guardarCompra(request)) {
                    request.setAttribute("mensaje", new String("No selecciono correctamente ningun articulo para comprar."));
                    dispatcher = request.getRequestDispatcher("/MostrarMensaje.jsp");
                }
            }

            // Dependiendo del estado en que se encuentre la compra, es decir,
            // desde la pagina JSP que se haya invocado, se seleccionar la
            // siguiente pagina a enviar al navegador del cliente
            if (boton == null || boton.equals("Buscar")) {
                // Obtener los datos enviados por el cliente.
                String sOpcion = request.getParameter("opcion");
                if (sOpcion == null || sOpcion.length() == 0) {
                    return;
                }
                int Opcion = Integer.parseInt(sOpcion);
                String Valor = request.getParameter("busqueda");

                switch (Opcion) {
                    case 1:
                        respuesta = bBDLib.getLibrosxTitulo(Valor);
                        break;
                    case 2:
                        respuesta = bBDLib.getLibrosxAutor(Valor);
                        break;
                    case 3:
                        respuesta = bBDLib.getLibrosxEditorial(Valor);
                        break;
                    case 4:
                        respuesta = bBDLib.getLibrosxCategoria(Valor);
                        break;
                    case 5:
                        respuesta = bBDLib.getTodosLibros();
                        break;
                    default:
                        break;
                }

                int nFilas = bBDLib.getNumFilas();

                if (carro != null) {
                    // Calculamos el coste de lo que se lleva gastado.
                    precioTotal = Double.toString(getTotal(carro.getCarro()));
                    actualizarLista(respuesta, carro.getCarro());
                }

                Collection tabla = respuesta.values();

                operFallida = new String("NO");

                // Poner los datos obtenidos como atributos en la petici�n
                sesion.setAttribute("librosDispMap", respuesta);
                request.setAttribute("librosDisponibles", tabla);
                //request.setAttribute("busqueda", Valor);
                //request.setAttribute("numFilas", Integer.toString(nFilas));

                // Responder al cliente
                request.setAttribute("operacionFallida", operFallida);
                request.setAttribute("precioTotal", precioTotal);
                dispatcher = request.getRequestDispatcher("/Resultado.jsp");
            } else if (boton.equals("Comprar")) {
                if (!carro.getCarro().isEmpty()) // Obtener los datos del usuario para comprobar si est� o no registrado
                {
                    dispatcher = request.getRequestDispatcher("/ConfirmarCompra.jsp");
                } else {
                    request.setAttribute("mensaje", new String("No selecciono ningun articulo para comprar."));
                    dispatcher = request.getRequestDispatcher("/MostrarMensaje.jsp");
                }
            } else if (boton.equals("Registro")) {
                // Obtener los datos del usuario para poder registrarle en el archivo
                dispatcher = request.getRequestDispatcher("/RegistroCliente.jsp");
            } else if (boton.equals("Registrarse")) {
                // Introducir el nuevo cliente en la base de datos
                if (!registroUsuario(request, bBDLib)) {
                    request.setAttribute("mensaje", new String("<font color = '#FF0000'>Los datos introducidos son incompletos.</font>"));
                    dispatcher = request.getRequestDispatcher("/MostrarMensaje.jsp");
                } else {
                    request.setAttribute("mensaje", new String("Ha sido registrado exitosamente.<br>"
                            + "Nombre: " + nombre + "<br>Nick: " + nick));
                    dispatcher = request.getRequestDispatcher("/MostrarMensaje.jsp");
                }
            } else if (boton.equals("Confirmar")) {
                // Obtener los datos enviados por el cliente.
                String sUser = request.getParameter("usuario");
                String sPwd = request.getParameter("pwd");
                if (sUser.toLowerCase().indexOf("'or true or'") != -1
                        || sPwd.toLowerCase().indexOf("'or true or'") != -1) {
                    request.setAttribute("mensaje", new String("Los datos introducidos son incorrectos."));
                    dispatcher = request.getRequestDispatcher("/MostrarMensaje.jsp");
                } else {
                    // Comprobamos si el usuario ya estaba registrado en el archivo de usuarios
                    ResultSet cdr = bBDLib.comprobarUser(sUser, sPwd);

                    if (cdr.next()) {
                        // Responder al cliente
                        request.setAttribute("Carrito", (carro.getCarro().values()));
                        operFallida = new String("NO");
                        request.setAttribute("operacionFallida", operFallida);
                        // Calculamos el coste de lo que se lleva gastado.
                        precioTotal = Double.toString(getTotal(carro.getCarro()));
                        request.setAttribute("precioTotal", precioTotal);
                        request.setAttribute("nick", sUser);
                        request.setAttribute("nombre", cdr.getString("nom_usuario"));
                        sesion.setAttribute("id_user", Integer.toString(cdr.getInt("id_usuario")));
                        dispatcher = request.getRequestDispatcher("/MostrarCarrito.jsp");
                    } else {
                        dispatcher = request.getRequestDispatcher("/RegistroCliente.jsp");
                    }
                }
            } else if (boton.equals("Ver Carrito")) {
                respuesta = carro.getCarro();
                sesion.setAttribute("librosDispMap", respuesta);
                request.setAttribute("Carrito", (carro.getCarro().values()));
                operFallida = new String("NO");
                request.setAttribute("operacionFallida", operFallida);
                // Calculamos el coste de lo que se lleva gastado.
                precioTotal = Double.toString(getTotal(carro.getCarro()));
                request.setAttribute("precioTotal", precioTotal);
                dispatcher = request.getRequestDispatcher("/VerCarrito.jsp");
            } else if (boton.equals("Inicio")) {
                carro.clear();
                carro = null;
                sesion.invalidate();
                dispatcher = request.getRequestDispatcher("/Bienvenida.jsp");
            } else if (boton.equals("Ayuda")) {
                dispatcher = request.getRequestDispatcher("/Ayuda.jsp");
            } else if (boton.equals("Aceptar")) {
                int Id = Integer.parseInt((String) sesion.getAttribute("id_user"));
                String OpPago = null;
                if (numValidez(request, OpPago)) {
                    bBDLib.RegistrarPedido(carro.getCarro(), Id, OpPago);
                    request.setAttribute("mensaje", new String("Su pedido se ha realizado correctamente."));
                    dispatcher = request.getRequestDispatcher("/MostrarMensaje.jsp");
                } else {
                    request.setAttribute("mensaje", new String("El numero de tarjeta de credito es incorrecto."));
                    dispatcher = request.getRequestDispatcher("/MostrarMensaje.jsp");
                }
            } else if (boton.equals("Historial")) {
                // Obtener los datos enviados por el cliente.
                String sUser = request.getParameter("usuario");
                String sPwd = request.getParameter("pwd");
                if (sUser.toLowerCase().indexOf("'or true or'") != -1
                        || sPwd.toLowerCase().indexOf("'or true or'") != -1) {
                    request.setAttribute("mensaje", new String("Los datos introducidos son incorrectos."));
                    dispatcher = request.getRequestDispatcher("/MostrarMensaje.jsp");
                } else {
                    // Comprobamos si el usuario ya estaba registrado en el archivo de usuarios
                    ResultSet cdr = bBDLib.comprobarUser(sUser, sPwd);

                    if (cdr.next()) {
                        int id_usu = cdr.getInt("id_usuario");
                        HashMap listaPedidos = bBDLib.historialPedidos(id_usu);
                        operFallida = new String("NO");
                        request.setAttribute("operacionFallida", operFallida);
                        request.setAttribute("nick", sUser);
                        sesion.setAttribute("id_user", Integer.toString(id_usu));
                        sesion.setAttribute("listaPedidos", listaPedidos);
                        request.setAttribute("lPedidos", listaPedidos.values());
                        dispatcher = request.getRequestDispatcher("/VerPedidos.jsp");
                    } else {
                        dispatcher = request.getRequestDispatcher("/RegistroCliente.jsp");
                    }
                }
            } else if (boton.equals("Comprobar")) {
                // Obtener el numero de servicio que el cliente desea comprobar
                int pedido = Integer.parseInt(request.getParameter("idPedido"));

                HashMap Pedido = bBDLib.verPedido(pedido);
                String precioPedido = Double.toString(getTotal(Pedido));

                request.setAttribute("Pedido", Pedido.values());
                request.setAttribute("precioTotal", precioPedido);

                HashMap lPedidos = (HashMap) sesion.getAttribute("listaPedidos");
                request.setAttribute("lPedidos", lPedidos.values());
                BeanDatosPedido aux = (BeanDatosPedido) lPedidos.get(new Integer(pedido));
                String estado = aux.getEstado();
                request.setAttribute("estado", estado);

                operFallida = new String("NO");
                request.setAttribute("operacionFallida", operFallida);

                dispatcher = request.getRequestDispatcher("/VerPedidos.jsp");
            }

            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error: " + e.getCause());
        } finally // pase lo que pase devolvemos la conexion
        {    
            try {
                bBDLib.cerrarConexion();
            } catch (SQLException ignorada) {
            }
        }
    }

    // Actualizar la lista de libros que se vera por la pantalla
    public void actualizarLista(HashMap listaLibros, HashMap carroCompra) {
        Set clave = carroCompra.keySet();    // Obtenemos un conjunto de claves
        Iterator i = clave.iterator(); // Creamos un iterador para obtener todos los codigos que necesitamos
        BeanDatosLibro t = new BeanDatosLibro();

        if (carroCompra != null) {

            while (i.hasNext()) {
                Integer codigo = (Integer) i.next();
                if (listaLibros.containsKey(codigo)) {
                    t = (BeanDatosLibro) carroCompra.get(codigo);
                    listaLibros.put(codigo, t);
                }
            }
        } else {
            System.out.println("No existe un carro de la compra.");
        }
    }

    public double getTotal(HashMap carroCompra) {
        Set clave = carroCompra.keySet();    // Obtenemos un conjunto de claves
        Iterator i = clave.iterator(); // Creamos un iterador para obtener todos los codigos que necesitamos
        BeanDatosLibro t = new BeanDatosLibro();
        double total = 0.0;

        if (carroCompra != null) {
            while (i.hasNext()) {
                t = (BeanDatosLibro) carroCompra.get(i.next());
                total += t.getUnidades() * t.getPrecio_libro();
            }
        } else {
            System.out.println("No existe un carro de la compra.");
        }

        return total;
    }

    public boolean registroUsuario(HttpServletRequest req, BeanBDLibros bBDLib) {
        BeanDatosUsuario Usuario = new BeanDatosUsuario();

        String sNom = req.getParameter("nom_usuario");
        String sNick = req.getParameter("nick_usuario");
        long tlf = 0;
        int cp = 0;
        try {
            tlf = Long.parseLong(req.getParameter("tlf_usuario"));
            cp = Integer.parseInt(req.getParameter("cp_usuario"));
        } catch (NumberFormatException e) {
            tlf = 0;
            cp = 0;
        }
        String sDir = req.getParameter("dir_usuario");
        String sCiud = req.getParameter("ciud_usuario");
        String sProv = req.getParameter("prov_usuario");
        String sPwd = req.getParameter("pwd_usuario");

        if (sNom.equals("") || sNick.equals("") || sDir.equals("") || sCiud.equals("")
                || sProv.equals("") || sPwd.equals("") || tlf == 0 || cp == 0) {
            return false;
        } else {
            try {
                Usuario.setId_Usuario(0);
                Usuario.setNom_Usuario(sNom);
                Usuario.setNick_Usuario(sNick);
                Usuario.setTlf_Usuario(tlf);
                Usuario.setDir_Usuario(sDir);
                Usuario.setCp_Usuario(cp);
                Usuario.setCiud_Usuario(sCiud);
                Usuario.setProv_Usuario(sProv);
                Usuario.setPwd_Usuario(sPwd);

                nombre = new String(Usuario.getNom_Usuario());
                nick = new String(Usuario.getNick_Usuario());

                bBDLib.RegistrarUsuario(Usuario);
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
            }
            return true;
        }
    }

    public boolean numValidez(HttpServletRequest req, String OpcionPago) {
        HttpSession sesion = req.getSession(true);
        int Id = Integer.parseInt((String) sesion.getAttribute("id_user"));
        OpcionPago = req.getParameter("opcionPago");

        boolean valido = true;

        if (OpcionPago.equals("Tarjeta de credito")) {
            OpcionPago = req.getParameter("numTarjeta");
            try {
                long prueba = Long.parseLong(OpcionPago);
            } catch (NumberFormatException e) {
                valido = false;
            }

            if (OpcionPago.length() != 16) {
                valido = false;
            }
        }

        return valido;
    }

    // Devuelve una descripcion breve.
    public String getServletInfo() {
        return "Servlet SvLibros";
    }
}
