package com.lat.marketing.gui;

import com.lat.marketing.dao.BeanAcciones;
import com.lat.marketing.dao.BeanUtilerias;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;

/**
 * @author Jose Angel Bonfil Evia
 */
public class TeleMarketingGui extends javax.swing.JFrame {

    /* Componentes de barras para el menu */
    private javax.swing.JMenuBar        jmBarra;
    private javax.swing.JMenu           jmArchivo, jmCuentas,
                                        jmContactos, jmAgenda;
    private javax.swing.JMenuItem       jmiSalir, jmiNvCuenta, jmiVrCuenta,
                                        jmiNvContacto, jmiVrContacto,
                                        jmiVrAgenda, jmiCrearNota;
    private javax.swing.JToolBar        hBarr;
    /* /Componentes de barras para el menu */

    /* Componentes para los menus de las barras */
    private javax.swing.JButton         bCuestionario, bCuenta,
                                        bContacto, bAgenda, bReportes;
    private javax.swing.JPanel          p1, p2, p3;
    private javax.swing.JLabel          lRecordatorio, lFecha, lGrafico;
    private static javax.swing.JDesktopPane desk;
    /* /Componentes para los menus de las barras */

    private java.awt.Dimension          d;

    //Constructor de la aplicacion con medidas por default
    public TeleMarketingGui() {
        d = java.awt.Toolkit.
                getDefaultToolkit().getScreenSize();
        
        setTitle("LAT TeleMarketing");
        setSize(d.width - 150, d.height - 100);
        setLocationRelativeTo(null);
        setResizable(true);
        //Incializamos la gui
        initGUI();
    }

    //Constructor de la aplicacion
    public TeleMarketingGui(int ancho, int alto) {
        setTitle("LAT TeleMarketing");
        setSize(ancho, alto);
        setLocationRelativeTo(null);
        setResizable(false);
        //Incializamos la gui
        initGUI();
    }

    public final void initGUI() {
        getContentPane().setLayout(null);
        addWindowListener(new java.awt.event.WindowAdapter() {

            public void windowClosing(java.awt.event.WindowEvent e) {
                salir(e);
            }
        });

        //Fijamos el componente JDesktoopPane como componente unico del frame
        desk = new javax.swing.JDesktopPane();
        desk.setBackground(new java.awt.Color(228, 227, 227));
        desk.setDragMode(javax.swing.JDesktopPane.OUTLINE_DRAG_MODE);
        desk.add(toolBar());
        setContentPane(desk);
        setJMenuBar(mBarr());
    }

    private javax.swing.JToolBar toolBar() {
        
        try {            
            hBarr = new javax.swing.JToolBar("Barra de herramientas");
            hBarr.setLayout(null);
            hBarr.setFloatable(false);
            hBarr.setRollover(true);
            hBarr.addComponentListener(new java.awt.event.ComponentAdapter(){
                public void componentResized(ComponentEvent e) {
                    hBarr.setBounds(0, 0, d.width, 80);
                }
            });
            hBarr.setBounds(0, 0, d.width, 80);
            getContentPane().add(hBarr);

            //Botones del menu
            bCuestionario = new javax.swing.JButton("Marketing");
            bCuestionario.setIcon(new BeanUtilerias().img("/com/lat/marketing/rsc/Marketing Solutions.gif"));
            bCuestionario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            bCuestionario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            bCuestionario.setToolTipText("Marketing");
            bCuestionario.setMnemonic('M');
            bCuestionario.setFocusPainted(false);
            bCuestionario.setMargin(new java.awt.Insets(0, 0, 0, 0));
            bCuestionario.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    
                }
            });
            bCuestionario.setBounds(20, 5, 60, 70);
            hBarr.add(bCuestionario);

            //Botones del menu
            bCuenta = new javax.swing.JButton("Cuentas");
            bCuenta.setIcon(new BeanUtilerias().img("/com/lat/marketing/rsc/Child Care Management.gif"));
            bCuenta.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            bCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            bCuenta.setToolTipText("Cuentas");
            bCuenta.setMnemonic('C');
            bCuenta.setFocusPainted(false);
            bCuenta.setMargin(new java.awt.Insets(0, 0, 0, 0));
            bCuenta.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    abrirGuiCuentas(e);
                }
            });
            bCuenta.setBounds(90, 5, 60, 70);
            hBarr.add(bCuenta);

            return hBarr;
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Error en los componentes: " + e.getMessage());
            return null;
        }
    }

    private javax.swing.JMenuBar mBarr() {
        jmBarra = new javax.swing.JMenuBar();
        try {
            jmArchivo = new javax.swing.JMenu("Archivo");
            jmArchivo.setMnemonic('A');
            jmBarra.add(jmArchivo);

            //Botones de jmArchivo
            jmiSalir = new javax.swing.JMenuItem("Salir");
            jmiSalir.setMnemonic('S');
            jmiSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
                    java.awt.event.InputEvent.CTRL_MASK));
            jmiSalir.addActionListener(new BeanAcciones());
            jmiSalir.setActionCommand("Salir");
            jmArchivo.add(jmiSalir);
            //Botones de jmArchivo

            return jmBarra;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void salir(java.awt.event.WindowEvent e) {
        System.exit(0);
    }

    public void abrirGuiCuentas(java.awt.event.ActionEvent e) {
        GuiCuentas cuentas = new GuiCuentas();
        cuentas.setVisible(true);
        desk.add(cuentas);
    }

    public String obtenerInformacion() {
        return "Software: TeleMarketing© \n"
                + "Autor: Jose Angel Bonfil Evia"
                + "Descripcion: Creado para motivos de TeleMarketing de la empresa LAT \n";
    }
}
