package org.librecrm.beans;

public class BeanUsuario {

    private String genPass;

    public BeanUsuario(){
        genPass =   java.util.UUID.randomUUID().toString();
    }
    
    public String generarPassword(){
        return genPass;
    }
}
