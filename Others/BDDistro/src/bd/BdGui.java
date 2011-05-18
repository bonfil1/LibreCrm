package bd;


public class BdGui extends javax.swing.JFrame{

    private javax.swing.JMenuBar    mB;
    private javax.swing.JMenu       arch,clientes,consultar;
    private javax.swing.JMenuItem   salir,puntual,moroso,cPuntual,cMoroso;
    private javax.swing.JButton     bPuntual,bMoroso,bConsulta,bConfig;
    private javax.swing.JLabel      l1,l2,l3;
    private javax.swing.JPanel      p1;
    private String                  ip1,ip2,ip3;
   
    public BdGui(){
        setTitle("Banquito");
        setSize(550,450);
        setResizable(false);
        setLocationRelativeTo(null);
        gui();
    }

    public void gui(){
        getContentPane().setLayout(null);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e){
                salir(e);
            }
        });

        l1  =   new javax.swing.JLabel("Seleccion la tarea que desee");
        l1.setFont(new java.awt.Font("Arial", 2, 14));
        l1.setBounds(170, 0, 250, 60);
        getContentPane().add(l1);

        p1  =   new javax.swing.JPanel();
        p1.setLayout(null);
        p1.setBounds(5, 35, 520, 270);
        p1.setBorder(new javax.swing.border.TitledBorder("Tareas"));

        bPuntual    =   new javax.swing.JButton("Puntuales");
        bPuntual.setIcon(img("puntual.png"));
        bPuntual.setToolTipText("Insertar Cliente Puntual");
        bPuntual.setFocusPainted(false);
        bPuntual.setMargin(new java.awt.Insets(0, 0, 0, 0));
        bPuntual.setBounds(45, 65, 120, 140);
        bPuntual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dlInsertarPuntual(e);
            }
        });
        getRootPane().setDefaultButton(bPuntual);
        p1.add(bPuntual);

        bMoroso    =   new javax.swing.JButton("Morosos");
        bMoroso.setIcon(img("morosos.png"));
        bMoroso.setToolTipText("Insertar Cliente Moroso");
        bMoroso.setFocusPainted(false);
        bMoroso.setMargin(new java.awt.Insets(0, 0, 0, 0));
        bMoroso.setBounds(205, 65, 120, 140);
        bMoroso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dlInsertarMoroso(e);
            }
        });        
        p1.add(bMoroso);
        
        bConsulta    =   new javax.swing.JButton("Consultas");
        bConsulta.setIcon(img("consulta.png"));
        bConsulta.setToolTipText("Realizar una consulta");
        bConsulta.setFocusPainted(false);
        bConsulta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        bConsulta.setBounds(365, 65, 120, 140);
        bConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dlgConsultas(e);
            }
        });        
        p1.add(bConsulta);
        getContentPane().add(p1);
        setJMenuBar(tBar());
    }

    //Metodo que construye la barra de herramientas
    public javax.swing.JMenuBar tBar(){
        
        mB      =   new javax.swing.JMenuBar();

        //Menus en la barra de herramientas
        arch    =   new javax.swing.JMenu("Archivo");
        arch.setMnemonic('A');
        mB.add(arch);

        clientes    =   new javax.swing.JMenu("Clientes");
        clientes.setMnemonic('C');
        mB.add(clientes);

        //Items de los menus
        salir   =   new javax.swing.JMenuItem("Salir");
        salir.setMnemonic('S');
        salir.setToolTipText("Pulse para salir");
        salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S,
                                                                java.awt.event.InputEvent.CTRL_MASK));
        salir.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                String res	=	Integer.toString(javax.swing.JOptionPane.showConfirmDialog(null, "Desea salir?"));
		System.out.println(res);
		if(res.compareTo("0")==0){
                    System.exit(0);
		}
            }
        });
        arch.add(salir);

        puntual =   new javax.swing.JMenuItem("Puntuales");
        puntual.setMnemonic('P');
        puntual.setToolTipText("Insertar un cliente puntual");
        puntual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P,
                                                                  java.awt.event.InputEvent.CTRL_MASK));
        puntual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dlInsertarPuntual(e);
            }
        });
        clientes.add(puntual);

        moroso =   new javax.swing.JMenuItem("Morosos");
        moroso.setMnemonic('M');
        moroso.setToolTipText("Insertar un cliente Moroso");
        moroso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M,
                                                                  java.awt.event.InputEvent.CTRL_MASK));
        moroso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                dlInsertarMoroso(e);
            }
        });
        clientes.add(moroso);
        clientes.add(new javax.swing.JSeparator());

        consultar =   new javax.swing.JMenu("Consultar");
        consultar.setMnemonic('C');
        consultar.setToolTipText("Lea los clientes Puntuales o Morosos");               
        clientes.add(consultar);

        //Itemes del submenu consulta
        cPuntual =   new javax.swing.JMenuItem("Puntuales");
        cPuntual.setMnemonic('U');
        cPuntual.setToolTipText("Consultar un cliente puntual");
        cPuntual.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U,
                                                                  java.awt.event.InputEvent.CTRL_MASK));
        cPuntual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                javax.swing.JOptionPane.showMessageDialog(null, "No implementado a un 'Consulta Puntuales'");
            }
        });
        consultar.add(cPuntual);

        cMoroso =   new javax.swing.JMenuItem("Morosos");
        cMoroso.setMnemonic('O');
        cMoroso.setToolTipText("Consultar un cliente moroso");
        cMoroso.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O,
                                                                  java.awt.event.InputEvent.CTRL_MASK));
        cMoroso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                javax.swing.JOptionPane.showMessageDialog(null, "No implementado a un 'Consulta Morosos'");
            }
        });
        consultar.add(cMoroso);

        return mB;
    }

    //Metodo para cargar imagenes
    public javax.swing.ImageIcon img(String dir){
	try {
            java.net.URL    url	=	getClass().getResource("/img/"+dir);
            javax.swing.ImageIcon   imgLoad =	new javax.swing.ImageIcon(url);
            return	imgLoad;
	} catch (Exception e) {
            System.out.println("No se pudo cargar la imagen "+dir+" Error "+e);
	}
	return null;
    }

    //Abrir los cuadros de dialogo de clientes y consultas
    public void dlInsertarPuntual(java.awt.event.ActionEvent e){
        new DlgInsPuntuales(this, false).setVisible(true);        
    }

    public void dlInsertarMoroso(java.awt.event.ActionEvent e){
        new DlgInsMorosos(this, false).setVisible(true);
    }

    public void dlgConsultas(java.awt.event.ActionEvent e){
        new DlgConsultas(this, false).setVisible(true);
    }

    public void salir(java.awt.event.WindowEvent e){
        System.exit(0);
    }

    public static void main(String[] arg){
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error al cargar la interfas: " + e.getMessage());
        }
        new BdGui().setVisible(true);
    }
}
