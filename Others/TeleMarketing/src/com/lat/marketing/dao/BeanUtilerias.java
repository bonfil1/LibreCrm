package com.lat.marketing.dao;

/**
 * @author Jose Angel Bonfil Evia
 */
public class BeanUtilerias {

    public BeanUtilerias() {
        System.out.println("Metodos inicializados...");
    }

    //Metodo para cargar Imagenes
    public javax.swing.ImageIcon img(String dir) {
        try {
            java.net.URL url = getClass().getResource( dir );
            javax.swing.ImageIcon imgLoad = new javax.swing.ImageIcon(url);
            return imgLoad;
        } catch (Exception e) {
            System.out.println("No se pudo cargar la imagen " + dir + " Error " + e);
        }
        return null;
    }
}
