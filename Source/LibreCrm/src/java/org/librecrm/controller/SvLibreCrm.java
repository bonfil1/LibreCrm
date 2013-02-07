package org.librecrm.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.DataSource;
import org.librecrm.back.beans.*;
import org.librecrm.beans.*;

/**
 *  @author Jose Angel Bonfil Evia
 *  Created on:  21/03/2011, 08:34:46 AM
 *  Document:    SvLibreCrm
 *  Descriptioon: Controller for librecrm logic
 */
public class SvLibreCrm extends HttpServlet {

    private DataSource servicioConexiones;
    private static String usuario, password, sesionUsuario;
    private static String usuarioId;
    private String boton, modoAgregar, modoLista, modoEditar;
    private static char isAdmin;
    private static boolean usuarioLogeado = false;
    private Accounts cuentas = null;
    private Contacts contactos = null;
    private Opportunities oportunidades = null;
    private Users usuarios = null;

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
        String accion = null;
        Collection comentFeed = null;

        Feed feed = null;
        BeanUsuario usuarioSesion = new BeanUsuario();
        BeanGraficaUsuario graficaUsuario = null;

        response.setContentType("text/html;charset=UTF-8");
        java.io.PrintWriter out = response.getWriter();
        //Obtenemos la sesion de haberla
        //Manejador de sesion de no haber sesion no crea ninguna
        HttpSession sesion =
                request.getSession();

        //Inciamos la aplicacion
        try {
            valorParametro = request.getParameter("link");
            errorParametro = request.getParameter("error");
            accion = request.getParameter("accion");            
            sesionUsuario = request.getParameter("sesion");
            feed        = new Feed(servicioConexiones);
            cuentas     = new Accounts(servicioConexiones);
            contactos   = new Contacts(servicioConexiones);
            oportunidades = new Opportunities(servicioConexiones);
            usuarios    = new Users(servicioConexiones);
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("/index.jsp");

            if (valorParametro != null) {
                if ((valorParametro.equals("inicio")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if ((valorParametro.equals("inicio")) && (usuarioLogeado == true)) {
                    //Refrescamos el atributo con los comentarios
                    comentFeed = feed.getComentarios();
                    sesion.setAttribute("comentarios", comentFeed);
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/Bievenida.jsp");
                }
                else if ((valorParametro.equals("resumen")) && (usuarioLogeado == true)) {
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/Resumen.jsp");
                }
                else if ((valorParametro.equals("resumen")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if ((valorParametro.equals("comentar")) && (usuarioLogeado == true)) {
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/Comentarios.jsp");
                }
                else if ((valorParametro.equals("comentar")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if ((valorParametro.equals("cuentas")) && (usuarioLogeado == true)) {
                    Collection tCuentas = cuentas.getCuentas();
                    request.setAttribute("listaCuentas", tCuentas);
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/cuentas/Cuentas.jsp");
                }
                else if((valorParametro.equals("cuentasElim") && usuarioLogeado == true)){
                    String idCuenta = request.getParameter("id");
                    Collection tCuentasId   =   cuentas.getCuentasPorId(idCuenta);
                    request.setAttribute("borrar", tCuentasId);
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/cuentas/ConfirmarBorrar.jsp");
                }
                else if ((valorParametro.equals("cuentas")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if ((valorParametro.equals("contactos")) && (usuarioLogeado == true)) {
                    Collection tContactos = contactos.getContactos();
                    request.setAttribute("listaContactos", tContactos);
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/contactos/Contactos.jsp");
                }
                else if (valorParametro.equals("contactosElim") && usuarioLogeado == true) {
                    String idContacto = request.getParameter("id");
                    Collection tContactosId = contactos.getContactosPorId(idContacto);
                    request.setAttribute("borrar", tContactosId);
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/contactos/ConfirmarBorrar.jsp");
                }
                else if ((valorParametro.equals("contactos")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if ((valorParametro.equals("oportunidades")) && (usuarioLogeado == true)) {
                    Collection tOportunidades = oportunidades.getOportunidades();
                    request.setAttribute("listaOportunidades", tOportunidades);
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/oportunidades/Oportunidades.jsp");
                }
                else if ((valorParametro.equals("oportunidades")) && (usuarioLogeado == false)) {
                    dispatcher = request.getRequestDispatcher("/index.jsp");
                }
                else if (valorParametro.equals("administrar") && usuarioLogeado == true) {
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/cp/ControlPanel.jsp");
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
                else if(valorParametro.equals("usuarios") && usuarioLogeado == true){
                    Collection tUsuarios = usuarios.getUsuarios();
                    request.setAttribute("listaUsuarios", tUsuarios);
                    Iterator itr = tUsuarios.iterator(); while( itr.hasNext() ) System.out.println(itr.next());
                    dispatcher = request.getRequestDispatcher("/Librecrm/pages/usuarios/Usuarios.jsp");
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
        } finally {
            try {
                feed.cerrarConexion();
                cuentas.cerrarConexion();
                contactos.cerrarConexion();
                oportunidades.cerrarConexion();
                usuarios.cerrarConexion();
                out.close();
            } catch (Exception e) {
            }
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
        BeanPersistirDatos persistir    = null;
        BeanSesionUsuario bSesion       = null;
        BeanActividadesRec activdades   = null;
        Feed feed = null;
        Collection tColeccion = null;
        Collection comentFeed = null;

        //Se inicializa la logica mediante el requerimiento
        //Del valor del boton
        boton = request.getParameter("boton");
        modoAgregar = request.getParameter("guardar");
        modoLista = request.getParameter("lista");

        //logica de negocios
        try {
            //Inciamos los datos de la sesion en nuestro bean
            bSesion     = new BeanSesionUsuario(servicioConexiones);
            activdades  = new BeanActividadesRec(servicioConexiones);
            feed        = new Feed(servicioConexiones);
            cuentas     = new Accounts(servicioConexiones);
            contactos   = new Contacts(servicioConexiones);
            usuarios    = new Users(servicioConexiones);
            persistir   = new BeanPersistirDatos(servicioConexiones);

            //Inicio de sesion de usuario
            if (boton == null || boton.equals("Iniciar")) {
                usuario = request.getParameter("usuario");
                password = request.getParameter("password");

                //Comprobamos que los campos no esten vacios
                if (usuario.toLowerCase().indexOf("'or true or'") != -1
                        || password.toLowerCase().indexOf("'or true or'") != -1) {

                    request.setAttribute("mensaje",
                            "Los datos introducidos son incorrectos.");
                    dispatcher =
                            request.getRequestDispatcher("/index.jsp");

                } else {
                    //Se comprueba si el usuario existe en la base de datos
                    ResultSet cdr = bSesion.comprobarUsuario(usuario, password);

                    if (cdr.next()) {
                        //Fijamos el atributo nickname en contexto de sesion
                        sesion.setAttribute("nickname", usuario);
                        //Cambiamos el estado de la sesion de usuario
                        usuarioLogeado = true;
                        usuarioId = cdr.getString("id_usuario");
                        isAdmin = cdr.getString("isadmin").charAt(0);
                        sesion.setAttribute("isadmin", Character.toString(isAdmin));
                        //Comentarios
                        comentFeed = feed.getComentarios();
                        sesion.setAttribute("comentarios", comentFeed);
                        dispatcher =
                                request.getRequestDispatcher("/Librecrm/pages/Bievenida.jsp");
                    } else {
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

            } else if (boton.equals("Consultar") && usuarioLogeado == true) {
                //Acciones en la seccion de resumen
                activdades.setIdUsuario(usuarioId);
                System.out.println("Usuario: " + usuarioId);
                String sOpcion = request.getParameter("opcion");
                if (sOpcion == null || sOpcion.length() == 0) {
                    return;
                }
                int Opcion = Integer.parseInt(sOpcion);
                switch (Opcion) {
                    case 1:
                        tColeccion = activdades.getActivdadesRecientes("accounts");
                        request.setAttribute("opcionEdit", "cuentasEdit");
                        request.setAttribute("opcionElim", "cuentasElim");
                        break;
                    case 2:
                        tColeccion = activdades.getActivdadesRecientes("campaigns");
                        request.setAttribute("opcionEdit", "camapañasEdit");
                        request.setAttribute("opcionElim", "campañasElim");
                        break;
                    case 3:
                        tColeccion = activdades.getActivdadesRecientes("contacts");
                        request.setAttribute("opcionEdit", "contactosEdit");
                        request.setAttribute("opcionElim", "contactosElim");
                        break;
                    case 4:
                        tColeccion = activdades.getActivdadesRecientes("opportunities");
                        request.setAttribute("opcionEdit", "optEdit");
                        request.setAttribute("opcionElim", "optElim");
                        break;
                    case 5:
                        tColeccion = activdades.getActivdadesRecientes("pvd");
                        request.setAttribute("opcionEdit", "pvdEdit");
                        request.setAttribute("opcionElim", "pvdElim");
                        break;
                    case 6:
                        tColeccion = activdades.getActivdadesRecientes("rad");
                        request.setAttribute("opcionEdit", "radEdit");
                        request.setAttribute("opcionElim", "radElim");
                        break;
                    default:
                        break;
                }

                sesion.setAttribute("actividad", tColeccion);
                dispatcher =
                        request.getRequestDispatcher("/Librecrm/pages/Resumen.jsp");

            } else if (boton.equals("Incio") && usuarioLogeado == true) {
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/Bievenida.jsp");
            } else if (boton.equals("Comentar") && usuarioLogeado == true) {

                String titulo = request.getParameter("titulo");
                String comentario = request.getParameter("comentario");
                String fecha = getFecha();
                feed.setComentario(titulo, comentario, isAdmin, fecha, fecha, usuarioId);
                //Refrescamos el atributo con los comentarios
                comentFeed = feed.getComentarios();
                sesion.setAttribute("comentarios", comentFeed);
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/Bievenida.jsp");
            } else if(boton.equals("Nueva Cuenta +") && usuarioLogeado == true){
                Collection tUsuarios = usuarios.getDatosUsuarios();
                request.setAttribute("listaUsuariosSimple", tUsuarios);
                dispatcher  =   request.getRequestDispatcher("/Librecrm/pages/cuentas/CuentaNueva.jsp");
            } else if(boton.equals("Lista Cuentas >") && usuarioLogeado == true){
                Collection tCuentas = cuentas.getCuentas();
                request.setAttribute("listaCuentas", tCuentas);
                dispatcher  =   request.getRequestDispatcher("/Librecrm/pages/cuentas/Cuentas.jsp");
            } else if(boton.equals("Guardar Cuenta") && usuarioLogeado == true){
                //Se inicia en memoria un objeto de tipo accounts para bufferizar datos
                cuentas =   new Accounts();
                cuentas.setName(request.getParameter("cuenta"));
                cuentas.setRfc(request.getParameter("rfc"));
                cuentas.setDateEntered(getFecha());
                cuentas.setDateModified(getFecha());
                cuentas.setModifiedUserId(usuarioId);
                cuentas.setCreatedBy(usuarioId);
                cuentas.setDescription(request.getParameter("descripcion"));
                cuentas.setAsignedUserId(request.getParameter("usr_asignado"));
                cuentas.setAccountType(request.getParameter("tipo_cuenta"));
                cuentas.setIndustry(request.getParameter("indsutria"));
                cuentas.setPhone(request.getParameter("telefono"));
                cuentas.setPhoneFax(request.getParameter("fax"));
                cuentas.setBillingAddressStreet(request.getParameter("dirCalleFact"));
                cuentas.setBillingAddressCity(request.getParameter("dirCiudadFact"));
                cuentas.setBillingAddressState(request.getParameter("dirEstadoFact"));
                cuentas.setBillingAddressPostalcode(request.getParameter("dirCpFact"));
                cuentas.setBillingAddressCountry(request.getParameter("dirPaisFact"));
                cuentas.setWebsite(request.getParameter("website"));
                cuentas.setShippingAddressStreet(request.getParameter("dirCalleEntrega"));
                cuentas.setShippingAddressCity(request.getParameter("dirCiudadEntrega"));
                cuentas.setShippingAddressState(request.getParameter("dirEstadoEntrega"));
                cuentas.setShippingAddressPostalcode(request.getParameter("dirCpEntrega"));
                cuentas.setShippingAddressCountry(request.getParameter("dirPaisEntrega"));

                //Persistimos el contacto
                persistir.persistirCuenta(cuentas);
                cuentas =   new Accounts(servicioConexiones);
                Collection tCuentas = cuentas.getCuentas();
                request.setAttribute("listaCuentas", tCuentas);
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/cuentas/Cuentas.jsp");
            } else if (boton.equals("Nuevo Contacto +") && usuarioLogeado == true) {
                Collection tCuentas = cuentas.getListaSimple();
                Collection tUsuarios = usuarios.getDatosUsuarios();
                request.setAttribute("listaCuentasSimple", tCuentas);
                request.setAttribute("listaUsuariosSimple", tUsuarios);
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/contactos/ContactoNuevo.jsp");
            } else if(boton.equals("Lista Contactos >") && usuarioLogeado == true){
                Collection tContactos = contactos.getContactos();
                request.setAttribute("listaContactos", tContactos);
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/contactos/Contactos.jsp");
            } else if (boton.equals("Guardar Contacto") && usuarioLogeado == true) {
                //Inicializamos en memoria la lista que obtendra los contactos
                contactos = new Contacts();
                contactos.setDateEntered(getFecha());
                contactos.setDateModified(getFecha());
                contactos.setModUserId(usuarioId);
                contactos.setCreatedBy(usuarioId);
                contactos.setDescription(request.getParameter("descripcion"));
                contactos.setAsignedUserId(request.getParameter("usr_asignado"));
                contactos.setSalutation(request.getParameter("saludo"));
                contactos.setFirstName(request.getParameter("nombre"));
                contactos.setLastName(request.getParameter("apellidos"));
                contactos.setTitle(request.getParameter("titulo"));
                contactos.setDepartmet(request.getParameter("departamento"));
                contactos.setAccountId(request.getParameter("cuenta"));
                contactos.setPHome(request.getParameter("telf_hogar"));
                contactos.setPMobile(request.getParameter("telf_movil"));
                contactos.setPWork(request.getParameter("telf_trabajo"));
                contactos.setPOther(request.getParameter("telf_otro"));
                contactos.setPFax(request.getParameter("telf_fax"));
                contactos.setAStreet(request.getParameter("dir_calle"));
                contactos.setACity(request.getParameter("dir_ciudad"));
                contactos.setAState(request.getParameter("dir_estado"));
                contactos.setAZip(request.getParameter("dir_cp"));
                contactos.setACountry(request.getParameter("dir_pais"));
                contactos.setAsistant(request.getParameter("asistente"));
                contactos.setAsistantPhone(request.getParameter("tel_asist"));
                contactos.setStatus(request.getParameter("status"));

                //Guardamos el valos que esta en memoria ram en la bd
                persistir.persistirContacto(contactos);
                contactos   =   new Contacts(servicioConexiones);
                Collection tContactos = contactos.getContactos();
                request.setAttribute("listaContactos", tContactos);
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/contactos/Contactos.jsp");
            } else if(boton.equals("Nuevo Usuario +") && usuarioLogeado == true){
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/usuarios/UsuarioNuevo.jsp");
            } else if (boton.equals("Borrar Cuenta") && usuarioLogeado == true) {
                String idObjeto = request.getParameter("id");
                persistir.borrarCuenta(idObjeto);
                Collection tCuentas = cuentas.getCuentas();
                request.setAttribute("listaCuentas", tCuentas);
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/cuentas/Cuentas.jsp");
            }else if (boton.equals("Borrar Contacto") && usuarioLogeado == true) {
                String idObjeto = request.getParameter("id");
                persistir.borrarContacto(idObjeto);
                Collection tContactos = contactos.getContactos();
                request.setAttribute("listaContactos", tContactos);
                dispatcher = request.getRequestDispatcher("/Librecrm/pages/contactos/Contactos.jsp");
            } else if (boton.equals("Cerrar")) {
                sesion.setAttribute("nick", "invitado");
                //Flusheamos el atributo loginError cada que inicie sesion
                sesion.removeAttribute("loginError");
                usuarioLogeado = false;
                dispatcher = request.getRequestDispatcher("/index.jsp");
            } else {
                dispatcher = request.getRequestDispatcher("/index.jsp");
            }

            //Cada que se avanza se revisa si los archivos son validos
            //Luego procede
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("error", e);
            request.setAttribute("errorDetail", e.getLocalizedMessage());
            goPage(dispatcher, request, response, "/Librecrm/pages/errors/Error.jsp");
            System.out.println("Error en Post: " + e.getMessage());
            log("Ocurrio una excepcion ", e);
        } finally {
            try {
                //Flusheamos el atributo loginError cada que inicie sesion
                sesion.setAttribute("loginError", null);
                bSesion.cerrarConexion();
                activdades.cerrarConexion();
                feed.cerrarConexion();
                cuentas.cerrarConexion();
                contactos.cerrarConexion();
                usuarios.cerrarConexion();
                persistir.cerrarConexion();
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
            String url) throws ServletException, IOException {
        dispatcher = request.getRequestDispatcher(url);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }

    /**
     * When a part of the code needs the date this method
     * can return it in String form.
     * @throws Exception
     */
    public String getFecha() {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            return dateFormat.format(date);
        } catch (Exception e) {
            System.out.println("Error al obtener la fecha del sistema " + e);
            return null;
        }
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
