package beans;

import java.util.*;

/*
 * Cada cliente tiene derecho a ver a trav�s de la pantalla cual es el historial de sus pedidos
 * realizados y el estado y contenido de cada uno, adem�s de su precio.
 * De cada pedido no nos interesa guardar los detalles de cada uno porque podemos obtener datos
 * a partir de otras tablas. Como miembros de la clase, nos quedaremos con los considerados
 * esenciales.
 */
public class BeanDatosPedido implements Comparator
{
      private int id_pedido;
      private int id_libro;
      private int id_usuario;
      private String estado = new String("En Espera");
      private int unidades;
  
      // Constructores de la clase.
      public BeanDatosPedido() {}
      public BeanDatosPedido(int id_p, int id_l, int id_u, int und)
      {
          id_pedido = id_p;
          id_libro = id_l;
          id_usuario = id_u;
          unidades = und;
      }
      
      // M�todos para obtener el valor de los miembros de un objeto de esta clase.
      public int getId_pedido()
      {
          return id_pedido;
      }
      
      public int getId_libro()
      {
          return id_libro;
      }
            
      public int getId_usuario()
      {
          return id_usuario;
      }
     
      public int getUnidades()
      {
          return unidades;
      }
      
      public String getEstado()
      {
          return estado;
      }
      
      // M�todos que ordenan los elementos dentro de una tabla de pedidos.
      public int compare(Object o1, Object o2)
      {
        if (((BeanDatosPedido)o1).id_pedido < ((BeanDatosPedido)o2).id_pedido)
          return -1;
        else if (((BeanDatosPedido)o1).id_pedido == ((BeanDatosPedido)o2).id_pedido)
          return 0;
        else
          return 1;
      }

      public boolean equals(Object obj)
      {
        return id_pedido == ((BeanDatosPedido)obj).id_pedido;
      }
}
