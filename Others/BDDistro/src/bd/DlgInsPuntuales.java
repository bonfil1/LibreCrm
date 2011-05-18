package bd;

public class DlgInsPuntuales extends javax.swing.JDialog{

    private javax.swing.JLabel      l1,l2,l3,l4,l5,l6;
    private javax.swing.JTextField  tNombre,tApellido,tSaldo,tEdad,tTelefono;
    private javax.swing.JPanel      p1,p2;
    private javax.swing.JButton     b1,b2;
    private String                  ip1,ip2,ip3;
    private String                  d1,d2,d3;
    private String                  user,pass;

    public DlgInsPuntuales( java.awt.Frame p,boolean modal ){
        super( p , modal );
        setTitle("Inserte cliente puntual");
        setSize(400,450);
        setResizable(false);
        setLocationRelativeTo(null);
        gui();

        //inicializamos las ip de las BD
        ip1 =   "127.0.0.1";
        ip2 =   "127.0.0.1";
        ip3 =   "127.0.0.1";
        d1  =   "com.mysql.jdbc.Driver";
        d2  =   "com.mysql.jdbc.Driver";
        d3  =   "com.mysql.jdbc.Driver";
        user    =   "root";
        pass    =   "master12";

    }

    public void gui(){
        getContentPane().setLayout(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e){
                salir(e);
            }
        });

        java.awt.event.FocusAdapter fa =  new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent e){
                focoGanado(e);
            }
        };

        l1  =   new javax.swing.JLabel("Inserte el cliente puntual nuevo");
        l1.setFont(new java.awt.Font("Courier new", 1, 12));
        l1.setBounds(5, 0, 300, 100);
        getContentPane().add(l1);

        p1  =   new javax.swing.JPanel();
        p1.setBounds(5, 70, 380, 250);
        p1.setLayout(null);
        p1.setBorder(new javax.swing.border.TitledBorder("Datos"));

        l2  =   new javax.swing.JLabel("Nombre ");
        l2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l2.setFont(new java.awt.Font("Courier new", 1, 13));
        l2.setBounds(25, 10, 90, 50);
        p1.add(l2);

        tNombre =   new javax.swing.JTextField();
        tNombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tNombre.setBounds(100, 25, 250, 20);
        tNombre.addFocusListener(fa);
        p1.add(tNombre);

        l3  =   new javax.swing.JLabel("Apellido ");
        l3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l3.setFont(new java.awt.Font("Courier new", 1, 13));
        l3.setBounds(25, 50, 90, 50);
        p1.add(l3);

        tApellido =   new javax.swing.JTextField();
        tApellido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tApellido.setBounds(100, 65, 250, 20);
        tApellido.addFocusListener(fa);
        p1.add(tApellido);

        l4  =   new javax.swing.JLabel("Saldo ");
        l4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l4.setFont(new java.awt.Font("Courier new", 1, 13));
        l4.setBounds(25, 100, 90, 50);
        p1.add(l4);

        tSaldo =   new JTextFieldDouble();
        tSaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tSaldo.setBounds(100, 115, 250, 20);
        tSaldo.addFocusListener(fa);
        p1.add(tSaldo);
       

        l5  =   new javax.swing.JLabel("Edad ");
        l5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l5.setFont(new java.awt.Font("Courier new", 1, 13));
        l5.setBounds(25, 150, 90, 50);
        p1.add(l5);

        tEdad =   new JTextFieldDouble();
        tEdad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tEdad.setBounds(100, 165, 250, 20);
        tEdad.addFocusListener(fa);
        p1.add(tEdad);

        l6  =   new javax.swing.JLabel("Telfono ");
        l6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        l6.setFont(new java.awt.Font("Courier new", 1, 13));
        l6.setBounds(25, 200, 90, 50);
        p1.add(l6);

        tTelefono =   new JTextFieldDouble();
        tTelefono.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tTelefono.setBounds(100, 215, 250, 20);
        tTelefono.addFocusListener(fa);
        p1.add(tTelefono);

        getContentPane().add(p1);

        p2  =   new javax.swing.JPanel();
        p2.setBounds(5, 320, 380, 80);
        p2.setLayout(null);
        p2.setBorder(new javax.swing.border.TitledBorder("Acciones"));

        b1  =   new javax.swing.JButton("Guardar");
        b1.setToolTipText("Insertar Cliente Puntual");
        b1.setFocusPainted(false);
        b1.setBounds(75, 25, 80, 40);
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                try {
                    guardarCliente(e);
                } catch (Exception e2) {
                    System.out.println("Error: " + e2.getMessage() );
                }
            }
        });
        b1.setMnemonic('G');
        getRootPane().setDefaultButton(b1);
        p2.add(b1);

        b2  =   new javax.swing.JButton("Borrar");
        b2.setToolTipText("Reinicia todos lo campos");
        b2.setMnemonic('B');
        b2.setFocusPainted(false);
        b2.setBounds(185, 25, 80, 40);
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                borrar(e);
            }
        });
        p2.add(b2);
        getContentPane().add(p2);
    }

    public void borrar(java.awt.event.ActionEvent e){
        tNombre.setText("");
        tApellido.setText("");
        tSaldo.setText("");
        tEdad.setText("");
        tTelefono.setText("");
    }

    public void guardarCliente(java.awt.event.ActionEvent e)
                               throws ClassNotFoundException, java.sql.SQLException,
                               InstantiationException,IllegalAccessException{
        String nom  =   tNombre.getText();
        String ape  =   tApellido.getText();
        double sald =   Double.parseDouble(tSaldo.getText());
        String edad =   tEdad.getText();
        String telf =   tTelefono.getText();
        int    nFilasBd1   =   0;
        int    nFilasBd2   =   0;
        int    nFilasBd3   =   0;

        /* Tipos de controladores para las bd
           "com.mysql.jdbc.Driver" local
	   "org.gjt.mm.mysql.Driver" Remoto */

        //Intentamos guardar en la primer bd alojada localmente
        try {
            conectarBD(d1, "jdbc:mysql://"+ ip1 +":3306/banquito",
                       user, pass, "puntuales", "nombre", nom);
            
            nFilasBd1  =   consultarFilasBD(d1,
                    "jdbc:mysql://"+ ip1 +":3306/banquito", user, pass, "puntuales");
        } catch (Exception ex) {
            System.out.println("Error al guardar en la primer BD: " + ex.getMessage());
        }
        
        //Intetamos guardar en la segunda bd
        try {
           conectarBD2(d2, "jdbc:mysql://"+ ip2 +":3306/banquito2",
                       user, pass, "puntuales",
                       "id_usuario","apellido", "saldo", 
                       Integer.toString(nFilasBd1) , ape, Double.toString(sald));          
        } catch (Exception ex) {
            System.out.println("Error al guardar en la segunda BD: " + ex.getMessage());
        }
        
        //Intetamos guardar en la tercer bd
        try {
            conectarBD2(d3, "jdbc:mysql://"+ ip3 +":3306/banquito3",
                        user, pass, "puntuales",
                        "id_usuario","edad", "telefono", 
                        Integer.toString(nFilasBd1),edad, telf);            
        } catch (Exception ex) {
            System.out.println("Error al guardar en la tercer BD: " + ex.getMessage());
        } 
        javax.swing.JOptionPane.showMessageDialog(null, "Nombre: " + nom +
                                                        "\nApellido: " + ape+
                                                        "\nSaldo: " + sald+
                                                        "\nEdad: " + edad+
                                                        "\nTelefono: " + telf);
    }

    public void conectarBD( String controlador, String url,
                            String usuario, String pass,
                            String tabla, String campo, String dato)
                            throws ClassNotFoundException, java.sql.SQLException,
                            InstantiationException,IllegalAccessException{

        //Iniciamos la coneccion al servidor sea local o externo
        CBaseDatos  bd  =   new CBaseDatos(controlador, url, usuario, pass);
        bd.insertarCampo( tabla , campo , dato );
    }

    public void conectarBD2( String controlador, String url,
                            String usuario, String pass,
                            String tabla,String campo , String campo1 ,String campo2,
                            String dato, String dato1, String dato2)
                            throws ClassNotFoundException, java.sql.SQLException,
                            InstantiationException,IllegalAccessException{

        //Iniciamos la coneccion al servidor sea local o externo
        CBaseDatos  bd  =   new CBaseDatos(controlador, url, usuario, pass);
        bd.insertarCampo2( tabla, campo , campo1, campo2, dato, dato1, dato2 );
    }

     public int consultarFilasBD(String controlador, String url,
                           String usuario, String pass,
                           String tabla)
                           throws ClassNotFoundException, java.sql.SQLException,
                           InstantiationException,IllegalAccessException{

        int numFilas    =   0;

        //Instanciamos un nuevo objeto que nos cree una coneccion
        CBaseDatos bd  =   new CBaseDatos(controlador, url, usuario, pass);
        bd.mostrarFilaActual(tabla);
        numFilas    =   bd.obtFilas();
        return numFilas;
    }

    //Seleccionar textfields en foco
    public void focoGanado(java.awt.event.FocusEvent e){
        javax.swing.text.JTextComponent tc  =   
                (javax.swing.text.JTextComponent) e.getSource();
        tc.selectAll();
    }

    public void salir(java.awt.event.WindowEvent e){
        setVisible(false);
        dispose();
    }
}
