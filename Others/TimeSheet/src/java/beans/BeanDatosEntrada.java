package beans;

/* App: BeanDatosEntrada.java
 * Tipo: Bean
 * Descripcion: Bean para ordenar los datos de las entradas del usuario
 * implementa la interfaz Comparator para poder ordenar las entradas
 * por el id_entrada en la bd
 */

import java.util.Comparator;

public class BeanDatosEntrada implements Comparator {

    private int id_usuario;
    private int id_entrada;

    public BeanDatosEntrada() {}

    public BeanDatosEntrada( int id_user , int id_ent) {
        id_usuario = id_user;
        id_entrada = id_ent;
    }

    public int getIdEntrada() {
        return id_entrada;
    }

    public int getIdUsuario() {
        return id_usuario;
    }

    public int compare(Object o1, Object o2) {
        if (((BeanDatosEntrada) o1).id_entrada < ((BeanDatosEntrada) o2).id_entrada) {
            return -1;
        } else if (((BeanDatosEntrada) o1).id_entrada == ((BeanDatosEntrada) o2).id_entrada) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean equals(Object obj) {
        return id_entrada == ((BeanDatosEntrada) obj).id_entrada;
    }
}
