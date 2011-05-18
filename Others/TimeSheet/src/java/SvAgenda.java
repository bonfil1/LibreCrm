
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import beans.*;

import javax.sql.*;    // para DataSource
import javax.naming.*; // para Context

public class SvAgenda extends HttpServlet {

    private DataSource servicioConexiones;
    private static String user, pass, sesionUsuario, boton;
    private boolean usuarioLogeado;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            // Recuperar el contexto inicial
            Context ctx = new InitialContext();
            // Referencia al servicio de conexiones
            servicioConexiones =
                    (DataSource) ctx.lookup("java:comp/env/jdbc/timesheet");
        } catch (Exception e) {
            throw new ServletException(
                    "Imposible recuperar java:comp/env/jdbc/timesheet", e);
        }
    }

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        //Miembro de datos donde almacenamos los parametros
        String valorParametro = null;

        //Creamos la navegacion por la aplicacion
        try {
            //Enviamos a la pagina de bienvenida
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/index.jsp");

            valorParametro = request.getParameter("link");
            sesionUsuario = request.getParameter("sesion");
            //usuarioLogeado  =   false;

            if (valorParametro != null) {
                if ((valorParametro.equals("inicio")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if ((valorParametro.equals("inicio")) && (usuarioLogeado == true)) {
                    dispatcher = request.getRequestDispatcher("/rsc/ControlPanel.jsp");
                }
                else if (valorParametro.equals("nueva")) {
                    dispatcher = request.getRequestDispatcher("/rsc/CrearEntrada.jsp");
                }
                else if (valorParametro.equals("registro")) {
                    dispatcher = request.getRequestDispatcher("/rsc/Registro.jsp");
                }
                else if (valorParametro.equals("cancelar")) {
                    dispatcher = request.getRequestDispatcher("/rsc/ControlPanel.jsp");
                }
                else if (valorParametro.equals("salir") && sesionUsuario.equals("cerrar")) {
                    dispatcher = request.getRequestDispatcher("/rsc/Confirmar.jsp");
                }
            }

            //Si todos los archivos fueron encontrados procede
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
        }



    }

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException{

        // Obtenemos la sesion con que este trabajando el cliente en esta
        // peticion HTTP
        HttpSession sesion = request.getSession(true);
        BeanSesionUsuario bSesion = null;

        //El manejador del direccionamiento
        RequestDispatcher dispatcher = null;
        String  tipoerror   =   null;

        try {
            //Inciamos los datos de la sesion en nuestro bean
            bSesion = new BeanSesionUsuario(servicioConexiones);

            boton = request.getParameter("boton");
            //Datos del usuario
            user = request.getParameter("usuario");
            pass = request.getParameter("password");

            if (boton.equals("Iniciar")) {

                //Comprobamos que los campos no esten vacios
                if (user.toLowerCase().indexOf("'or true or'") != -1
                        || pass.toLowerCase().indexOf("'or true or'") != -1) {
                    request.setAttribute("mensaje", new String("Los datos introducidos son incorrectos."));
                    dispatcher = request.getRequestDispatcher("/Mensaje.jsp");
                }
                else {
                    ResultSet cdr = bSesion.comprobarUsuario( user, pass );

                    if (cdr.next()) {
                        //Escribir valores en el atributo de sesion sesion
                        sesion.setAttribute("nick", user);
                        //Cambiamos el estado de la sesion de usuario
                        usuarioLogeado = true;

                        //Cargamos los datos que hay en sus entradas para
                        //ser mostrados en pantalla
                        

                        dispatcher = request.getRequestDispatcher("/rsc/ControlPanel.jsp");
                    }
                    else {
                        //Escribir valores en el atributo de sesion sesion
                        sesion.setAttribute("nick", "inivitado");
                        //Cambiamos el estado de la sesion de usuario
                        usuarioLogeado = false;
                        tipoerror   =   "Usuario no registrado";
                        dispatcher = request.getRequestDispatcher("/index.jsp");
                    }
                }
            }
            else if ((boton.equals("Incio")) && (usuarioLogeado == false)) {
                dispatcher = request.getRequestDispatcher("/index.jsp");
            }
            else if ((boton.equals("Incio")) && (usuarioLogeado == true)) {
                dispatcher = request.getRequestDispatcher("/rsc/ControlPanel.jsp");
            }
            else if (boton.equals("Cerrar")) {
                sesion.setAttribute("nick", "invitado");
                usuarioLogeado = false;
                bSesion.cerrarConexion();
                dispatcher = request.getRequestDispatcher("/index.jsp");
            }            

            //Si todos los archivos fueron encontrados procede
            if (dispatcher != null) dispatcher.forward(request, response);

        } catch (Exception e) {
            sesion.setAttribute("error", tipoerror);
        } finally{
            try {
                bSesion.cerrarConexion();
            } catch (Exception e) {}            
        }


    }

    @Override
    public String getServletInfo() {
        return "Servlet para control de agenda";
    }
}
