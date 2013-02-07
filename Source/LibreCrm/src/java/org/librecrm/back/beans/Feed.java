package org.librecrm.back.beans;

import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.sql.DataSource;
import org.librecrm.beans.BDLibreCrm;

public class Feed {

    private BDLibreCrm bd;

    public Feed() {
    }

    public Feed(DataSource servCon)
            throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new BDLibreCrm(servCon);
    }

    public Collection getComentarios()
            throws SQLException {
        ResultSet cdr = bd.getComentarios();
        ResultSetMetaData meta = cdr.getMetaData();
        int columnas = meta.getColumnCount();
        ArrayList list = new ArrayList();
        try {
            while (cdr.next()) {
                HashMap row = new LinkedHashMap(columnas, .75f);
                for (int i = 1; i <= columnas; i++) {
                    row.put(meta.getColumnName(i), cdr.getString(i));
                }
                list.add(row);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener Comentarios : " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }

    public void setComentario(String titulo, String comentario,
                              char admin, String date_ent,
                              String date_mod, String id_user)
                              throws SQLException {
        try {
            bd.setComentarios(titulo, comentario, admin, date_ent, date_mod, id_user);
        } catch (Exception e) {
            System.out.print("Error al establecer comentario: " + e.getMessage());
        }
    }

    public void cerrarConexion()
            throws java.sql.SQLException {
        bd.cerrarConexion();
        System.out.println("Feed Cerrado");
    }
    
}
