package org.librecrm.back.beans;

import java.util.Comparator;

public class BeanContacts implements Comparator {

    private int              id;
    private java.util.Date   dateEntered, dateModified;
    private String           createdBy, modifiedUserId, asignedUserId;

    private String name, rfc, description, accountType;
    private String phone, phoneFax;
    private String bAddStreet, bAddCity,
            bAddState, bAddPostalCode,
            bAddCountry;
    private String sAddStreet, sAddCity,
            sAddState, sAddPostalCode,
            sAddCountry;
    private String website, status;
    
    

    public BeanContacts() {
    }

    public BeanContacts(int id){
        this.id =   id;
    }

    public int compare(Object o1, Object o2) {
        if (((BeanContacts) o1).id < ((BeanContacts) o2).id) {
            return -1;
        } else if (((BeanContacts) o1).id == ((BeanContacts) o2).id) {
            return 1;
        } else {
            return 1;
        }
    }

    // En caso de que dos cuentas sean iguales, este m�todo devolver� true.
    @Override
    public boolean equals(Object obj) {
        return id == ((BeanContacts) obj).id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRfc() {
        return this.rfc;
    }

    public String getDescription() {
        return this.description;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPhoneFax() {
        return this.phoneFax;
    }

    public String getBAddStreet() {
        return this.bAddStreet;
    }

    public String getBAddCity() {
        return this.bAddCity;
    }

    public String getBAddState() {
        return this.bAddState;
    }

    public String getBAddPostalCode() {
        return this.bAddPostalCode;
    }

    public String getBAddCountry() {
        return this.bAddCountry;
    }

    public String getSAddStreet() {
        return this.sAddStreet;
    }

    public String getSAddCity() {
        return this.sAddCity;
    }

    public String getSAddState() {
        return this.sAddState;
    }

    public String getSAddPostalCode() {
        return this.sAddPostalCode;
    }

    public String getSAddCountry() {
        return this.sAddCountry;
    }

    public String getWebSite() {
        return this.website;
    }

    public String getStatus() {
        return this.status;
    }

    public java.util.Date getDateEntered() {
        return this.dateEntered;
    }

    public java.util.Date getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(java.util.Date dateModified) {
        this.dateModified = dateModified;
    }

    public String getCreateBy() {
        return this.createdBy;
    }

    public String getModifiedUserId() {
        return this.modifiedUserId;
    }
}
