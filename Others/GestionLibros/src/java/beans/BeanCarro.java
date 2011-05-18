package beans;

import javax.servlet.http.*;
import java.util.*;

/*
 * La figura del carrito de la compra es parte esencial de este ejercicio.
 * Esta clase sirve para guardar aquellos libros y el n�mero de ellos que se quieran
 * comprar para que �stos formen un pedido que se pueda almacenar en una base de datos.
 * El carrito propiamente dicho no es m�s que una tabla HashMap donde est�n guardados
 * aquellos libros que forman un pedido.
 */
public class BeanCarro
{
    private HashMap librosComprados = new HashMap();    
    
    // Constructor de la clase
    public BeanCarro(){}
    
    // Almacena en el carrito de la compra los libros que se hayan elegido
    // en el formulario de la p�gina JSP.
    public boolean guardarCompra(HttpServletRequest req)
    {
      HttpSession sesion = req.getSession(true);
      HashMap tabla = (HashMap)sesion.getAttribute("librosDispMap");
      Set clave = tabla.keySet();    // Obtenemos un conjunto de claves
      Iterator i = clave.iterator(); // Creamos un iterador para obtener todos los c�digos que necesitamos
      int cont = 0;
      BeanDatosLibro t = new BeanDatosLibro();
      
      boolean valido = true;
      
      // Guardamos en un array las unidades de cada libro que apareci� en la lista.
      String tablaUnd[] = req.getParameterValues("unidades"); // Para obtener todas las unidades
      Integer Cod = null;                                     // Para guardar los c�digos
      if(tabla != null)
      {
          while(i.hasNext())
          {
              t = (BeanDatosLibro)tabla.get(i.next());
              Cod = new Integer(t.getId_libro());
              try
              {
                  t.setUnidades(Integer.parseInt(tablaUnd[cont]));
                  if(t.getUnidades() > 0)
                      librosComprados.put(Cod,t);
                  else if(librosComprados.containsKey(Cod))
                      librosComprados.remove(Cod);
                      
                  cont++;
              }
              catch(NumberFormatException e)
              {
                  valido = false;
              }
          }
      }
      else
      {
          System.out.println("tabla es null");
          valido = false;
      }
      
      return valido;
    }
    
    // Obtener el carrito de la compra
    public HashMap getCarro()
    {
        return(librosComprados);
    }
    
    // M�todo para dejar vac�a la cesta de la compra
    public void clear()
    {
        librosComprados.clear();
    }
}
