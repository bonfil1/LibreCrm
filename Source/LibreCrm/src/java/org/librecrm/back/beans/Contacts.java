/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.librecrm.back.beans;

import java.sql.*;
import java.util.*;
import javax.sql.DataSource;
import org.librecrm.beans.BDLibreCrm;

public class Contacts {
    private BDLibreCrm bd;
    private String     date_entered,date_modified;
    private String     modified_user_id, created_by;
    private String     description,asigned_user_id;
    private String     salutation, first_name, last_name,
                       title, department,account_id,status;
    private String     p_home, p_mobile,p_work, p_other,p_fax;
    private String     a_street, a_city, a_state, a_zip, a_country;
    private String     asistant, asistant_phone;

    public Contacts(){}
    public Contacts(DataSource servCon)
                throws java.sql.SQLException, javax.servlet.ServletException {
        bd  =   new BDLibreCrm(servCon);
    }

    //Campos de escritura para los campos en la bd
    public void setDateEntered(String date_entered){ this.date_entered = date_entered; }
    public String getDateEntered(){ return date_entered; }

    public void setDateModified(String date_modified){ this.date_modified = date_modified; }
    public String getDateModified(){  return date_modified; }

    public void setModUserId(String modified_user_id){ this.modified_user_id = modified_user_id; }
    public String getModUserId(){ return modified_user_id; }

    public void setCreatedBy(String created_by){ this.created_by = created_by; }
    public String getCreatedBy(){ return created_by; }

    public void setDescription(String description){ this.description = description; }
    public String getDescription(){ return description; }

    public void setAsignedUserId(String asigned_user_id){ this.asigned_user_id = asigned_user_id; }
    public String getAsignedUserId(){ return asigned_user_id; }

    public void setSalutation(String salutation){ this.salutation = salutation; }
    public String getSalutation(){ return salutation; }

    public void setFirstName(String first_name){ this.first_name = first_name; }
    public String getFirstName(){ return first_name; }

    public void setLastName(String last_name){ this.last_name = last_name; }
    public String getLastName(){ return last_name; }

    public void setTitle(String title){ this.title = title; }
    public String getTitle(){ return title; }

    public void setDepartmet(String department){ this.department = department; }
    public String getDepartmet(){ return department; }

    public void setAccountId(String account_id){ this.account_id = account_id; }
    public String getAccountId(){ return account_id; }

    public void setStatus(String status){ this.status = status; }
    public String getStatus(){ return status; }

    public void setPHome(String p_home){ this.p_home = p_home; }
    public String getPHome(){ return p_home; }

    public void setPMobile(String p_mobile){ this.p_mobile = p_mobile; }
    public String getPMobile(){ return p_mobile; }

    public void setPWork(String p_work){ this.p_work = p_work; }
    public String getPWork(){ return p_work; }

    public void setPOther(String p_other){ this.p_other = p_other; }
    public String getPOther(){ return p_other; }

    public void setPFax(String p_fax){ this.p_fax = p_fax; }
    public String getPFax(){ return p_fax ; }

    public void setAStreet(String a_street){ this.a_street = a_street; }
    public String getAStreet(){ return a_street; }

    public void setACity(String a_city){ this.a_city = a_city; }
    public String getACity(){ return a_city; }

    public void setAState(String a_state){ this.a_state = a_state; }
    public String getAState(){ return a_state; }

    public void setAZip(String a_zip){ this.a_zip = a_zip; }
    public String getAZip(){ return a_zip; }

    public void setACountry(String a_country){ this.a_country = a_country; }
    public String getACountry(){ return a_country; }

    public void setAsistant(String asistant){ this.asistant = asistant; }
    public String getAsistant(){ return asistant; }

    public void setAsistantPhone(String asistant_phone){ this.asistant_phone = asistant_phone; }
    public String getAsistantPhone(){ return asistant_phone; }


    public Collection getContactos() throws SQLException {
        ResultSet cdr = bd.getListaTablas("contacts");
        ResultSetMetaData meta =  cdr.getMetaData();
        int columnas = meta.getColumnCount();
        ArrayList list = new ArrayList();
        try {
            while (cdr.next()) {
                HashMap row = new LinkedHashMap(columnas, .75f);
                for (int i = 1; i <= columnas; i++) {
                    row.put(meta.getColumnName(i), cdr.getString(i));
                }
                list.add(row);
            }            
        } catch (Exception e) {
            System.out.println("Error al obtener Contactos : " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }

    public Collection getContactosPorId(String id) throws SQLException {
        ResultSet cdr = bd.getContactoPorId(id);
        ResultSetMetaData meta =  cdr.getMetaData();
        int columnas = meta.getColumnCount();
        ArrayList list = new ArrayList();
        try {
            while (cdr.next()) {
                HashMap row = new LinkedHashMap(columnas, .75f);
                for (int i = 1; i <= columnas; i++) {
                    row.put(meta.getColumnName(i), cdr.getString(i));
                }
                list.add(row);
            }
        } catch (Exception e) {
            System.out.println("El contacto no existe: " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }

    public void cerrarConexion()
            throws java.sql.SQLException {
        bd.cerrarConexion();
        System.out.println("Contacts Cerrado");
    }
}
