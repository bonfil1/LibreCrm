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

public class Opportunities implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String contactId;
    private String opportunity;
    private String dateEntered;
    private String dateModified;
    private String modifiedUserId;
    private String createdBy;
    private String description;
    private String asignedUserId;
    private String accountId;
    private String opportunityType;
    private String campaignId;
    private String leadSource;
    private Double amount;
    private Double amountUsdollar;
    private String currencyId;
    private String dateClosed;
    private String nextStep;
    private String salesStage;
    private Double probability;
    private BDLibreCrm bd;

    public Opportunities() {
    }

    public Opportunities(DataSource servCon)
        throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new BDLibreCrm(servCon);
    }

    public Opportunities(Integer id) {
        this.id = id;
    }

    public Opportunities(Integer id, String opportunity) {
        this.id = id;
        this.opportunity = opportunity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getOpportunity() {
        return opportunity;
    }

    public void setOpportunity(String opportunity) {
        this.opportunity = opportunity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAsignedUserId() {
        return asignedUserId;
    }

    public void setAsignedUserId(String asignedUserId) {
        this.asignedUserId = asignedUserId;
    }

    public void setAccountId(String accountId){ this.accountId = accountId; }
    public String getAccountId(){ return accountId; }

    public String getOpportunityType() {
        return opportunityType;
    }

    public void setOpportunityType(String opportunityType) {
        this.opportunityType = opportunityType;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmountUsdollar() {
        return amountUsdollar;
    }

    public void setAmountUsdollar(Double amountUsdollar) {
        this.amountUsdollar = amountUsdollar;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getNextStep() {
        return nextStep;
    }

    public void setNextStep(String nextStep) {
        this.nextStep = nextStep;
    }

    public String getSalesStage() {
        return salesStage;
    }

    public void setSalesStage(String salesStage) {
        this.salesStage = salesStage;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
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
        if (!(object instanceof Opportunities)) {
            return false;
        }
        Opportunities other = (Opportunities) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.librecrm.back.beans.Opportunities[id=" + id + "]";
    }

    public Collection getOportunidades() throws SQLException {
        ResultSet cdr = bd.getListaTablas("opportunities");
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
            System.out.println("Error al obtener Oportunidades : " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }

    public void cerrarConexion()
            throws java.sql.SQLException {
        bd.cerrarConexion();
    }
}
