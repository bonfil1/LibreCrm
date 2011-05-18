package com.prueba.sesion;

import javax.ejb.Stateless;


@Stateless
public class BeanSesion {
    public String getHola(){
        return "Hola Mundo";
    }
}
