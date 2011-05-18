package bd;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class DlgConsultas extends JDialog{

    private JTable  jt;
    private JPanel  jp,jp1;
    private JButton b1,b2;
    private JTabbedPane 	jtPanel;
    private CModeloTabla	ModeloTabla;
    
    public DlgConsultas(java.awt.Frame p, boolean modal){
        super(p,modal);
        setTitle("consulta de Clientes");
        setSize(700,350);
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
       
        try {
            //Panel raiz
            jp	=	(JPanel)this.getContentPane();
            jp.setLayout(new java.awt.BorderLayout());

            //TabbedPane
            jtPanel	=	new javax.swing.JTabbedPane();
            jp.add(jtPanel, java.awt.BorderLayout.CENTER);

             
            JPanel  pMenu   =   new JPanel();
            pMenu.setLayout(null);
            
            b1  =   new JButton("Consultar Puntuales");
            b1.setBounds(140, 85, 150, 80);
            getRootPane().setDefaultButton(b1);
            b1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbConexion(e);
                }
            });
            pMenu.add(b1);

            b2  =   new JButton("Consultar Morosos");
            b2.setBounds(320, 85, 150, 80);
            b2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    jbConexion(e);
                }
            });
            pMenu.add(b2);
            
            jtPanel.add("Menu",pMenu);

            ModeloTabla	=	new CModeloTabla();
            jp1         =	crearPAnelConsulta(ModeloTabla);
            jtPanel.add("Consulta",jp1);
        } catch (Exception e) {
        }
    }

    public void jbConexion(java.awt.event.ActionEvent e){
                String d1   =   "com.mysql.jdbc.Driver";
		String url1 =	"jdbc:mysql://127.0.0.1:3306/banquito";
                String d2   =   "com.mysql.jdbc.Driver";
                String url2 =   "jdbc:mysql://127.0.0.1:3306/banquito2";
                String d3   =   "com.mysql.jdbc.Driver";
                String url3 =   "jdbc:mysql://127.0.0.1:3306/banquito3";
		try {
			ModeloTabla.iniciar(d1 , d2 , d3 , url1 , url2 ,url3 , "puntuales", "root", "master12");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
                jtPanel.setSelectedComponent(jp1);
    }

    private JPanel	crearPAnelConsulta(CModeloTabla ModeloTab){
	JPanel	jpConsulta	=	new JPanel();
	jpConsulta.setLayout(new java.awt.BorderLayout());

	jt	=	new JTable(ModeloTab);
	JScrollPane	js	=	new JScrollPane(jt);

	jpConsulta.add(js,java.awt.BorderLayout.CENTER);
	return jpConsulta;
    }

    public void salir(java.awt.event.WindowEvent e){
        setVisible(false);
        dispose();
    }
}
