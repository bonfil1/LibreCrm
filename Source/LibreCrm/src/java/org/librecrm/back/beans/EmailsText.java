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


public class EmailsText implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer emailId;
    private String codification;
    private String fromAddr;
    private String toAddrs;
    private String subject;
    private String ccAddrs;
    private String bccAddrs;
    private String message;
    private BDLibreCrm bd;

    public EmailsText() {
    }

    public EmailsText(DataSource servCon)
        throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new BDLibreCrm(servCon);
    }

    public EmailsText(Integer emailId) {
        this.emailId = emailId;
    }

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getCodification() {
        return codification;
    }

    public void setCodification(String codification) {
        this.codification = codification;
    }

    public String getFromAddr() {
        return fromAddr;
    }

    public void setFromAddr(String fromAddr) {
        this.fromAddr = fromAddr;
    }

    public String getToAddrs() {
        return toAddrs;
    }

    public void setToAddrs(String toAddrs) {
        this.toAddrs = toAddrs;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCcAddrs() {
        return ccAddrs;
    }

    public void setCcAddrs(String ccAddrs) {
        this.ccAddrs = ccAddrs;
    }

    public String getBccAddrs() {
        return bccAddrs;
    }

    public void setBccAddrs(String bccAddrs) {
        this.bccAddrs = bccAddrs;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailId != null ? emailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmailsText)) {
            return false;
        }
        EmailsText other = (EmailsText) object;
        if ((this.emailId == null && other.emailId != null) || (this.emailId != null && !this.emailId.equals(other.emailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.librecrm.back.beans.EmailsText[emailId=" + emailId + "]";
    }

    public Collection getEmailsTextBd() throws SQLException {
        ResultSet cdr = bd.getListaTablas("emails_text");
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
            System.out.println("Error al obtener Emails Text : " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }

}
