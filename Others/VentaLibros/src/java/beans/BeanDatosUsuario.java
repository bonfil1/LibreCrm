package beans;

/*
 * Cada vez que queramos introducir un usuario en el registro meteremos dicho usuario en un
 * objeto de esta clase por un motivo meramente de enfoque.  Nos ayuda a adquirir una
 * dimensi�n m�s profunda del ejercicio y nos daria mayor facilidad a la hora de manipular
 * el objeto para futuros usos.
 */
public class BeanDatosUsuario
{
      private int id_usuario;
      private String nom_usuario;
      private String nick_usuario;
      private long tlf_usuario;
      private String dir_usuario;
      private int cp_usuario;
      private String ciud_usuario;
      private String prov_usuario;
      private String pwd_usuario;
    
      // Constructores de la clase.
      public BeanDatosUsuario() {}
      public BeanDatosUsuario(int id, String nom, String nick, long tlf, String dir, int cp, String ciud, String prov, String pwd)
      {
          id_usuario = id;
          nom_usuario = new String(nom);
          nick_usuario = new String(nick);
          tlf_usuario = tlf;
	  dir_usuario = new String(dir);
          cp_usuario = cp;
          ciud_usuario = new String(ciud);
          prov_usuario = new String(prov);
          pwd_usuario = new String(pwd);
      }
      
      // M�todos para poder obtener cualquier miembro de un objeto de esta clase desde el exterior.
      // M�todos para poder dar valor a cualquier miembro de un objeto de esta clase desde el
      // exterior.
      public int getId_Usuario()
      {
          return id_usuario;
      }

      public void setId_Usuario(int id)
      {
          id_usuario = id;
      }      
      
      public String getNom_Usuario()
      {
          return nom_usuario;
      }

      public void setNom_Usuario(String nom)
      {
          nom_usuario = new String(nom);
      }      
      
      public String getNick_Usuario()
      {
          return nick_usuario;
      }

      public void setNick_Usuario(String nick)
      {
          nick_usuario = new String(nick);
      }      
      
      public long getTlf_Usuario()
      {
          return tlf_usuario;
      }
 
      public void setTlf_Usuario(long tlf)
      {
          tlf_usuario = tlf;
      }
      
      public String getDir_Usuario()
      {
          return dir_usuario;
      }      
 
      public void setDir_Usuario(String dir)
      {
          dir_usuario = new String(dir);
      }      
      
      public int getCp_Usuario()
      {
          return cp_usuario;
      }      

      public void setCp_Usuario(int cp)
      {
          cp_usuario = cp;
      }       
      
      public String getCiud_Usuario()
      {
          return ciud_usuario;
      } 

      public void setCiud_Usuario(String ciud)
      {
          ciud_usuario = new String(ciud);
      }       
      
      public String getProv_Usuario()
      {
          return prov_usuario;
      } 

      public void setProv_Usuario(String prov)
      {
          prov_usuario = new String(prov);
      }       
      
      public String getPwd_Usuario()
      {
          return pwd_usuario;
      }

      public void setPwd_Usuario(String pwd)
      {
          pwd_usuario = new String(pwd);
      }       
}
