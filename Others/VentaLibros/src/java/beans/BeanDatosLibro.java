package beans;

import java.util.*;

/*
 * Esta clase representa al libro propiamente dicho.  Tiene como miembros privados todas
 * aquellas caracter�sticas que nos interesan guardar de un libro y que nos servir�n para
 * formar pedidos, para introducirlos en una base de datos o para listarlos.
 */
public class BeanDatosLibro implements Comparator {

    private int id_libro;
    private String titulo_libro;
    private String nom_autor;
    private String nom_editorial;
    private int ed_libro;
    private int anyo_libro;
    private int precio_libro;
    private int unidades = 0;

    // Constructores de la clase
    public BeanDatosLibro() {
    }

    public BeanDatosLibro(int id_l, String titulo_l, String nom_a, String nom_e, int ed_l, int anyo_l, int precio_l) {
        id_libro        = id_l;
        titulo_libro    = titulo_l;
        nom_autor       = nom_a;
        nom_editorial   = nom_e;
        ed_libro        = ed_l;
        anyo_libro      = anyo_l;
        precio_libro    = precio_l;
    }

    // M�todo utilizado para comparar libros de manera que se introduzcan ordenadamente
    public int compare(Object o1, Object o2) {
        if (((BeanDatosLibro) o1).id_libro < ((BeanDatosLibro) o2).id_libro) {
            return -1;
        } else if (((BeanDatosLibro) o1).id_libro == ((BeanDatosLibro) o2).id_libro) {
            return 1;
        } else {
            return 1;
        }
    }

    // En caso de que dos libros sean iguales, este m�todo devolver� true.
    public boolean equals(Object obj) {
        return id_libro == ((BeanDatosLibro) obj).id_libro;
    }

    // M�todo que nos permite obtener el n�mero identificativo de un libro.
    public int getId_libro() {
        return id_libro;
    }

    // M�todo que nos permite obtener el t�tulo de un libro.
    public String getTitulo_libro() {
        return titulo_libro;
    }

    // M�todo que nos permite obtener el nombre del autor de un libro.
    public String getNom_autor() {
        return nom_autor;
    }

    // M�todo que nos permite obtener el nombre de la editorial de un libro.
    public String getNom_editorial() {
        return nom_editorial;
    }

    // M�todo que nos permite obtener la edici�n de un libro.
    public int getEd_libro() {
        return ed_libro;
    }

    // M�todo que nos permite obtener el a�o de publicaci�n de un libro.
    public int getAnyo_libro() {
        return anyo_libro;
    }

    // M�todo que nos permite obtener el precio en euros de un libro.
    public int getPrecio_libro() {
        return precio_libro;
    }

    // M�todo que nos permite conocer el n�mero de unidades de un libro.
    public int getUnidades() {
        return (unidades);
    }

    // M�todo que nos permite establecer el n�mero de unidades de un libro.
    public void setUnidades(int _unidades) {
        unidades = _unidades;
    }
}
