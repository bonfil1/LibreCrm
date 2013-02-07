package org.librecrm.beans;

import javax.sql.DataSource;
import org.librecrm.back.beans.*;

/**
 *
 * @author Pepe
 */
public class BeanPersistirDatos {

    private BDLibreCrm bd;

    public BeanPersistirDatos(){}
    public BeanPersistirDatos(DataSource servCon)
                throws java.sql.SQLException, javax.servlet.ServletException {
        bd  =   new BDLibreCrm(servCon);
    }

    /***************************************
     *         Seccion de Cuentas          *
     **************************************/
    public void persistirCuenta(Accounts cuenta){
        try {
            bd.setCuenta(cuenta);
        } catch (Exception e) {
            System.out.println("Error al persistir cuenta. \n" + e);
        }
    }

    public void borrarCuenta(String id){
        try {
            bd.deleteAccounts(id);
        } catch (Exception e) { System.out.println("Error al borrar cuenta. \n" + e); }
    }


    /***************************************
     *         Seccion de Contactos        *
     **************************************/
    public void persistirContacto(Contacts contacto){
        try {
            bd.setContacto(contacto.getDateEntered(), contacto.getDateModified(), 
                           contacto.getModUserId(), contacto.getCreatedBy(),
                           contacto.getDescription(), contacto.getAsignedUserId(),
                           contacto.getSalutation(), contacto.getFirstName(),
                           contacto.getLastName(), contacto.getTitle(),
                           contacto.getDepartmet(), contacto.getAccountId(),
                           contacto.getPHome(), contacto.getPMobile(),
                           contacto.getPWork(), contacto.getPOther(),
                           contacto.getPFax(), contacto.getAStreet(),
                           contacto.getACity(), contacto.getAState(),
                           contacto.getAZip(), contacto.getACountry(),
                           contacto.getAsistant(), contacto.getAsistantPhone(),
                           contacto.getStatus());
        } catch (Exception e) {
            System.out.println("Error al persistir contacto. \n" + e);
        }
    }

    public void borrarContacto(String id){
        try {
            bd.deleteContact(id);
        } catch (Exception e) { System.out.println("Error al borrar contacto. \n" + e);  }
    }


    
    public void cerrarConexion()
            throws java.sql.SQLException {
        bd.cerrarConexion();
        System.out.println("Persistencia Cerrado");
    }
}
