package com.lat.marketing.gui;

/**
 * @author Jose Angel Bonfil Evia
 */


public class TeleMarketingGui extends javax.swing.JFrame{

    private javax.swing.JMenuBar    jmBarra;
    private javax.swing.JMenu       jmArchivo,jmCuentas,jmContactos,jmAgenda;
    private javax.swing.JMenuItem   jmiSalir,jmiNvCuenta,jmiVrCuenta,
                                    jmiNvContacto,jmiVrContacto,
                                    jmiVrAgenda,jmiCrearNota;
    private javax.swing.JButton     bCuestionario,bCuenta,bContacto,bAgenda,
                                    bReportes;
    private javax.swing.JPanel      p1,p2,p3;
    private javax.swing.JLabel      lRecordatorio,lFecha,lGrafico;

    
    //Constructor de la aplicacion con medidas por default
    public TeleMarketingGui(){
        setTitle("LAT TeleMarketing");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        //Incializamos la gui
        initGUI();
    }

    //Constructor de la aplicacion
    public TeleMarketingGui(int ancho, int alto){
        setTitle("LAT TeleMarketing");
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setResizable(false);
        //Incializamos la gui
        initGUI();
    }

    public void initGUI(){
        getContentPane().setLayout(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windoClosing(java.awt.event.WindowEvent e){
                salir(e);
            }
        });

        
    }

    public void salir(java.awt.event.WindowEvent e){
        System.exit(0);
    }

    public String obtenerInformacion(){
        return "Software: TeleMarketing© \n" +
               "Autor: Jose Angel Bonfil Evia"+
               "Descripcion: Creado para motivos de TeleMarketing de la empresa LAT";
    }
}
