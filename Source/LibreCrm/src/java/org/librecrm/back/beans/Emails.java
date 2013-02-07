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


public class Emails implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String dateEntered;
    private String dateModified;
    private String assignedUserId;
    private String modifiedUserId;
    private String createdBy;
    private String dateSent;
    private String messageId;
    private String name;
    private String type;
    private String protrocol;
    private String port;
    private String host;
    private String user;
    private String password;
    private BDLibreCrm bd;

    public Emails() {
    }

    public Emails(DataSource servCon)
        throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new BDLibreCrm(servCon);
    }

    public Emails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(String assignedUserId) {
        this.assignedUserId = assignedUserId;
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

    public String getDateSent() {
        return dateSent;
    }

    public void setDateSent(String dateSent) {
        this.dateSent = dateSent;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProtrocol() {
        return protrocol;
    }

    public void setProtrocol(String protrocol) {
        this.protrocol = protrocol;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Emails)) {
            return false;
        }
        Emails other = (Emails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.librecrm.back.beans.Emails[id=" + id + "]";
    }


    public Collection getEmailsBd() throws SQLException {
        ResultSet cdr = bd.getListaTablas("emails");
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
            System.out.println("Error al obtener Emails : " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }
}
