package org.librecrm.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.sql.DataSource;

/**
 * @author Jose Angel Bonfil Evia
 */
public class BeanGraficaUsuario {

    private BDLibreCrm bd;

    public BeanGraficaUsuario(){}
    public BeanGraficaUsuario(DataSource servCon)
            throws SQLException, ServletException{
        bd  =   new BDLibreCrm(servCon);
    }

    public List<Object> getCuentas()
            throws SQLException{
        List<Object>    t   =   new ArrayList<Object>();
        ResultSet       cdr =   bd.getCuentasPorUsuario();
        while(cdr.next()){
            t.add(cdr.getInt("asigned_user_id"));
        }
        return t;
    }

}
