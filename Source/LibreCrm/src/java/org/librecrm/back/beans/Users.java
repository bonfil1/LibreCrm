/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.librecrm.back.beans;

import java.io.Serializable;
import java.util.*;
import javax.sql.DataSource;
import java.sql.*;
import org.librecrm.beans.BDLibreCrm;

/**
 *
 * @author Pepe
 */

public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String reportTo;
    private Boolean isAdmin;
    private String description;
    private String dateEntered;
    private String dateModified;
    private String modifiedUserId;
    private String createdBy;
    private String lastLogin;
    private String categoryId;
    private String phoneHome;
    private String phoneMobile;
    private String phoneWork;
    private String phoneOther;
    private String phoneFax;
    private String adressStreet;
    private String adressCityId;
    private String adressStateId;
    private String adressCountryId;
    private String emailId;
    private BDLibreCrm bd;

    public Users() {
    }

    public Users(DataSource servCon)
        throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new BDLibreCrm(servCon);
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String userName, String password, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getReportTo() {
        return reportTo;
    }

    public void setReportTo(String reportTo) {
        this.reportTo = reportTo;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

    public String getModifiedUserId() {
        return modifiedUserId;
    }

    public void setModifiedUserId(String modifiedUserId) {
        this.modifiedUserId = modifiedUserId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getPhoneHome() {
        return phoneHome;
    }

    public void setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }

    public String getPhoneMobile() {
        return phoneMobile;
    }

    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    public String getPhoneWork() {
        return phoneWork;
    }

    public void setPhoneWork(String phoneWork) {
        this.phoneWork = phoneWork;
    }

    public String getPhoneOther() {
        return phoneOther;
    }

    public void setPhoneOther(String phoneOther) {
        this.phoneOther = phoneOther;
    }

    public String getPhoneFax() {
        return phoneFax;
    }

    public void setPhoneFax(String phoneFax) {
        this.phoneFax = phoneFax;
    }

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    public String getAdressCityId() {
        return adressCityId;
    }

    public void setAdressCityId(String adressCityId) {
        this.adressCityId = adressCityId;
    }

    public String getAdressStateId() {
        return adressStateId;
    }

    public void setAdressStateId(String adressStateId) {
        this.adressStateId = adressStateId;
    }

    public String getAdressCountryId() {
        return adressCountryId;
    }

    public void setAdressCountryId(String adressCountryId) {
        this.adressCountryId = adressCountryId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public Collection getUsuarios() throws SQLException {
        ResultSet cdr = bd.getDatosTabla("users");
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
            System.out.println("Error al obtener Usuarios: " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }

    public Collection getDatosUsuarios() throws SQLException {
        ResultSet cdr = bd.getUsuarioSimple("users");
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
            System.out.println("Error al obtener Usuarios: " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }

    public void cerrarConexion()
            throws java.sql.SQLException {
        bd.cerrarConexion();
        System.out.println("Users Cerrado");
    }

    @Override
    public String toString() {
        return "org.librecrm.back.beans.Users[id=" + id + "]";
    }

}
