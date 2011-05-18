package com.lat.marketing.gui;

import java.awt.event.ComponentEvent;
import com.lat.marketing.dao.BeanAcciones;

/**
 * @author Jose Angel
 */

public class GuiCuentas extends javax.swing.JInternalFrame{

    private javax.swing.JButton b1,b2;
    private javax.swing.JLabel  l1,l2;


    public GuiCuentas(){
        super("Cuentas",true,true,true,true);        
        setSize(780, 400);
        setLocation(0, 85);
        initGUI();
    }

    public final void initGUI(){
        getContentPane().setLayout(null);
        getContentPane().addComponentListener(new java.awt.event.ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                System.out.println("Componente redimencionada");
            }            
        });

        l1  =   new javax.swing.JLabel("Etiqueta de prueba");
        l1.setBounds(0, 20, 200, 80);
        getContentPane().add(l1);


        b1  =   new javax.swing.JButton("Boton de prueba");
        b1.setBounds(100, 100, 70, 30);
        b1.addActionListener(new BeanAcciones());
        b1.setActionCommand("Prueba");
        getContentPane().add(b1);
        getRootPane().setDefaultButton(b1);        
    }

}
