package org.librecrm.beans;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import javax.sql.DataSource;
import org.librecrm.back.beans.BeanActividades;

/**
 * @author Jose Angel Bonfil Evia
 */
public class BeanActividadesRec {

    private String id_usuario;
    private int nFilas;
    private BDLibreCrm bd;

    public BeanActividadesRec() {
    }

    public BeanActividadesRec(DataSource servCon)
            throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new BDLibreCrm(servCon);
        id_usuario = "0";
        nFilas = 0;
    }

    public void setIdUsuario(String id) {
        this.id_usuario = id;
    }

    public String getIdUsuario() {
        return id_usuario;
    }

    public int getNumFilas() {
        return nFilas;
    }

    public HashMap getActivdadesRecientes(String tabla) throws java.sql.SQLException {
        BeanActividades t   =   new BeanActividades();
        HashMap m = new HashMap();
        int id = 0;
        ResultSet cdr =
                bd.getUltimasAcciones(getIdUsuario(), tabla, 0, 5);
        nFilas = cdr.getMetaData().getColumnCount();
        SimpleDateFormat formato =   new SimpleDateFormat("yyyy-mmm-dd");
        java.util.Date   fDAte;
        try {
            while (cdr.next()) {
                fDAte   =   cdr.getDate("date_entered");
                id  =   cdr.getInt("id");
                t   =   new BeanActividades(
                        id,
                        cdr.getString("name"),
                        cdr.getString("rfc"),
                        cdr.getString("description"),
                        cdr.getString("account_type"),
                        cdr.getString("phone"), 
                        cdr.getString("phone_fax"), 
                        formato.parse(fDAte.toString()),
                        cdr.getDate("date_modified"),
                        cdr.getString("created_by"),
                        cdr.getString("asigned_user_id"));
                m.put(new Integer(id), t);
            }
            nFilas = m.size();                     
        } catch (Exception e) {
            System.out.println("Error al obtener actividades : " + e.getMessage());
        } finally {
            cdr.close();
        }
        return m;
    }
}
