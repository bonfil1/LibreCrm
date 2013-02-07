package org.librecrm.beans;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.sql.DataSource;

/**
 * @author Jose Angel Bonfil Evia
 */
public class BeanActividadesRec {

    private String id_usuario;
    private static String tablaXML;
    private int nColumnas, totalFilas;
    private BDLibreCrm bd;

    public BeanActividadesRec() {
    }

    public BeanActividadesRec(DataSource servCon)
            throws java.sql.SQLException, javax.servlet.ServletException {
        bd = new BDLibreCrm(servCon);
        id_usuario = "0";
    }

    public void setIdUsuario(String id) {
        this.id_usuario = id;
    }

    public String getIdUsuario() {
        return id_usuario;
    }

    public int getNumColumnas() {
        return nColumnas;
    }

    public Collection getActivdadesRecientes(String tabla) throws java.sql.SQLException {
        //Brinda informacion de la talba solicitada de forma generica
        ResultSet cdr =
                bd.getUltimasAcciones(id_usuario, tabla, 0, 10);
        ResultSetMetaData meta = cdr.getMetaData();
        nColumnas = meta.getColumnCount();
        //Creamos el HashMap, De la medida del numeros de columnas
        ArrayList list = new ArrayList();

        try {
            while (cdr.next()) {
                HashMap row = new LinkedHashMap(nColumnas, .75f);
                for (int i = 1; i < nColumnas; i++) {
                    //Formateamos el valor en xml por iteracion
                    row.put(meta.getColumnName(i), cdr.getObject(i));                    
                }
                list.add(row);
            }            
        } catch (Exception e) {
            System.out.println("Error al obtener actividades : " + e.getMessage());
        } finally {
            cdr.close();
        }
        return ((Collection) list);
    }

    public String getCeldasXml(String tabla) throws java.sql.SQLException {
        //Brinda informacion de la talba solicitada de forma generica
        ResultSet cdr =
                bd.getUltimasAcciones(id_usuario, tabla, 0, 10);
        ResultSetMetaData meta = cdr.getMetaData();
        nColumnas = meta.getColumnCount();
        totalFilas = 1;
        ArrayList list = new ArrayList();

        while (cdr.next()) {
            list.add("<row id='" + (totalFilas++) + "'>\r\n");
            for (int i = 1; i <= nColumnas; i++) {
                //Formateamos el valor en xml por iteracion
                list.add("<cell><![CDATA[" + cdr.getObject(i) + "]]></cell>\r\n");
            }
            list.add("</row>\r\n");
        }
        //Creamos la cabezera
        String respuestaXML = "<?xml version='1.0' encoding='utf-8'?>" + "\r\n" + "<rows>" + "\r\n";
        respuestaXML += "<page>1</page>\r\n";
        respuestaXML += "<total>" + (totalFilas - 1) + "</total>\r\n";
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            respuestaXML += itr.next();
        }
        respuestaXML += "\n</rows>";
        cdr.close();
        return respuestaXML;
    }
    
    public void cerrarConexion()
            throws java.sql.SQLException {
        bd.cerrarConexion();
        System.out.println("BeanActividadesRec Cerrado");
    }
}
