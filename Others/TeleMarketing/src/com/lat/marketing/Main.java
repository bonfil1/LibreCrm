package com.lat.marketing;

import com.lat.marketing.gui.TeleMarketingGui;

/**
 *  @author     Jose Angel Bonfil Evia
 *  Application Main.java
 *  Description Clase cliente de la aplicacion TeleMarketing
 */

public class Main {
    public static void main(String[] telemarketing){
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            new TeleMarketingGui().setVisible(true);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e.getMessage());
        }
    }
}
