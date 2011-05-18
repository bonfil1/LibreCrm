package com.lat.marketing.dao;

/**
 *  @author Jose Angel Bonfil Evia
 */
public class BeanAcciones implements java.awt.event.ActionListener{

    public void actionPerformed(java.awt.event.ActionEvent e) {
        if(e.getActionCommand().equals("Cuestionario")){
            java.awt.Toolkit.getDefaultToolkit().beep();
        }        
        else if(e.getActionCommand().equals("Salir")){
            java.awt.Toolkit.getDefaultToolkit().beep();
            System.exit(0);
        }

    }

}
