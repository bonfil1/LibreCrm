package org.librecrm.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.Collection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import org.librecrm.beans.BeanActividadesRec;
import org.librecrm.beans.BeanGraficaUsuario;
import org.librecrm.beans.BeanSesionUsuario;
import org.librecrm.beans.BeanUsuario;

/**
 *  @author Jose Angel Bonfil Evia
 *  Created on:  21/03/2011, 08:34:46 AM
 *  Document:    SvLibreCrm
 *  Descriptioon: Controller for librecrm logic
 */
public class SvLibreCrm extends HttpServlet {

    private DataSource servicioConexiones;
    private static String usuario, password, sesionUsuario, boton;
    private static String usuarioId;
    private static boolean usuarioLogeado = false;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            // Recuperar el contexto inicial
            Context ctx = new InitialContext();
            // Referencia al servicio de conexiones
            servicioConexiones =
                    (DataSource) ctx.lookup("java:comp/env/jdbc/librecrm");
        } catch (Exception e) {
            throw new ServletException(
                    "Imposible recuperar java:comp/env/jdbc/librecrm", e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Miembro de datos donde almacenamos los parametros
        String valorParametro = null;
        String errorParametro = null;
        BeanUsuario usuarioSesion = new BeanUsuario();
        BeanGraficaUsuario  graficaUsuario  = null;
        //Obtenemos la sesion de haberla
        //Manejador de sesion de no haber sesion no crea ninguna
        HttpSession sesion =
                request.getSession();

        //Inciamos la aplicacion
        try {
            valorParametro  = request.getParameter("link");
            errorParametro  = request.getParameter("error");
            sesionUsuario   = request.getParameter("sesion");            
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/index.jsp");

            if (valorParametro != null) {
                if ((valorParametro.equals("inicio")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if ((valorParametro.equals("inicio")) && (usuarioLogeado == true)) {
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/Bievenida.jsp");
                }
                else if ((valorParametro.equals("resumen")) && (usuarioLogeado == true)) {
                    try {
                        graficaUsuario  =   new BeanGraficaUsuario(servicioConexiones);                        
                    } catch (Exception e) {}
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/Resumen.jsp");
                }
                else if ((valorParametro.equals("resumen")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if (valorParametro.equals("salir") && sesionUsuario.equals("cerrar")
                        && usuarioLogeado == true) {
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/Confirmar.jsp");
                }
                else if (valorParametro.equals("detalles") && (usuarioLogeado == true)) {
                    String passwordGen = "Tu password autogenerado por el sistema es: "
                            + usuarioSesion.generarPassword();
                    request.setAttribute("mensaje", passwordGen);
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/Mensaje.jsp");
                }
                else if (errorParametro.equals("sqlerror") && usuarioLogeado == true) {
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/Bievenida.jsp");
                }
                else if (errorParametro.equals("sqlerror") && usuarioLogeado == false) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else {
                    sesion.setAttribute("error", "El link que has proporcionado no es correcto!");
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/errors/Error.jsp");
                }
            }

            //Cada que se avanza se revisa si los archivos son validos
            //Luego procede
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            throw new FileNotFoundException("El Archivo no fue encontrado");
        }

    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Creacion de objetos para la navegacion
        HttpSession sesion =
                request.getSession(true);       //Manejador de sesion en caso de haber una crearla
        RequestDispatcher dispatcher = null;    //Direccionador
        String tipoError = null;
        BeanSesionUsuario bSesion = null;
        BeanActividadesRec  activdades  =   null;


        //logica de negocios
        try {
            //Inciamos los datos de la sesion en nuestro bean
            bSesion     = new BeanSesionUsuario(servicioConexiones);
            activdades  = new BeanActividadesRec(servicioConexiones);
            //Inicializamos el Id de un usuario en 0 el cual no existira en la bd
            usuarioId       = "0";

            //Se inicializa la logica mediante el requerimiento
            //Del valor del boton
            boton = request.getParameter("boton");


            //Inicio de sesion de usuario
            if (boton.equals("Iniciar")) {
                usuario = request.getParameter("usuario");
                password = request.getParameter("password");

                //Comprobamos que los campos no esten vacios
                if (usuario.toLowerCase().indexOf("'or true or'") != -1
                        || password.toLowerCase().indexOf("'or true or'") != -1) {

                    request.setAttribute("mensaje",
                            "Los datos introducidos son incorrectos.");
                    dispatcher =
                            request.getRequestDispatcher("/index.jsp");

                }
                else {

                    //Se comprueba si el usuario existe en la base de datos
                    ResultSet cdr = bSesion.comprobarUsuario(usuario, password);

                    if (cdr.next()) {                        
                        //Fijamos el atributo nickname en contexto de sesion
                        sesion.setAttribute("nickname", usuario);
                        //Cambiamos el estado de la sesion de usuario
                        usuarioLogeado = true;
                        usuarioId   =   cdr.getString("id_usuario");
                        
                        activdades.setIdUsuario(usuarioId);
                        Collection tAccounts    =   activdades.getActivdadesRecientes("accounts").values();
                        sesion.setAttribute("actividadCuenta", tAccounts);

                        for(Object o: tAccounts){
                            System.out.print("Valor tAccounts " + o.toString());
                            System.out.println();
                        }

                        //Collection tCampaigns   =   activdades.getActivdadesRecientes("campaigns").values();
                        //sesion.setAttribute("actividadCampañas", tCampaigns);

                        if(tAccounts.isEmpty()){
                            sesion.setAttribute("hayActividades", null);
                        }
                        else
                            sesion.setAttribute("hayActividades", "hayActividad");
                        dispatcher =
                                request.getRequestDispatcher("/Librecrm/pages/Bievenida.jsp");
                    }
                    else {
                        //Escribir valores en el atributo de sesion sesion
                        sesion.setAttribute("nick", "inivitado");
                        //Cambiamos el estado de la sesion de usuario
                        usuarioLogeado = false;
                        tipoError = "Usuario no registrado";
                        //Escribir valores en el atributo de sesion sesion
                        sesion.setAttribute("loginError", tipoError);
                        dispatcher = request.getRequestDispatcher("/index.jsp");
                    }
                }

            }
            else if (boton.equals("Incio") && usuarioLogeado == true) {
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/Bievenida.jsp");
            }
            else if (boton.equals("Cerrar")) {
                sesion.setAttribute("nick", "invitado");
                //Flusheamos el atributo loginError cada que inicie sesion
                sesion.removeAttribute("loginError");
                usuarioLogeado = false;
                bSesion.cerrarConexion();
                dispatcher = request.getRequestDispatcher("/index.jsp");
            }

            //Cada que se avanza se revisa si los archivos son validos
            //Luego procede
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            goPage(dispatcher, request, response, "/Librecrm/pages/errors/Error.jsp");
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                //Flusheamos el atributo loginError cada que inicie sesion
                sesion.setAttribute("loginError", null);
                bSesion.cerrarConexion();
            } catch (Exception e) {
                System.out.println("Error al cerrar la conexion: " + e.getMessage());
            }
        }
    }

    /**
     * Handles the navegation if a exception occur.
     * @param dispatcher manager for navegation in the controller
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void goPage(RequestDispatcher dispatcher,
                        HttpServletRequest request, HttpServletResponse response,
                        String url) throws ServletException, IOException{
        dispatcher = request.getRequestDispatcher(url);
        if (dispatcher != null) dispatcher.forward(request, response);
    }


    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controlador para LibreCrm";
    }// </editor-fold>
}
