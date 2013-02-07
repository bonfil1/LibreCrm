/* App: BDLibreCrm.java
 * Tipo: Bean
 * Descripcion: Bean que hace de interfaz con la base de datos por medio de
 * un pool de conexiones
 */
package org.librecrm.beans;

import java.sql.*;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import org.librecrm.back.beans.Accounts;
import org.librecrm.back.beans.Users;

/**
 * @author Jose Angel Bonfil Evia
 * @version 1.0a
 */
public class BDLibreCrm {

    private Connection conexion;
    private Statement query;
    private ResultSet cdr;

    /***************************************
     * Constructor por default de la clase *
     **************************************/
    public BDLibreCrm() {
    }

    /**
     * @param servCon Objeto mediante el cual se crea el pool
     * @throws java.sql.SQLException En caso haber una excepcion con la bd
     * @throws javax.servlet.ServletException En caso de haber error en el servlet
     */
    public BDLibreCrm(DataSource servCon)
            throws SQLException, javax.servlet.ServletException {

        //Creamos el metodo sincronizado para obtener los datos
        synchronized (servCon) {
            conexion = servCon.getConnection();
        }

        //Si hubo algun problema con el servidor
        if (conexion == null) {
            throw new ServletException("Problemas con la conexion");
        }

        //Creamos la sentencia sql
        query = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        System.out.println("\nConexion realizada con Exito.\n");
    }

    /**
     * Cierra la conexion a la base de datos
     * @throws java.sql.SQLException si ocurre un error con la bd
     */
    public void cerrarConexion() throws java.sql.SQLException {
        if (cdr != null) {
            cdr.close();
        }
        if (query != null) {
            query.close();
        }
        if (conexion != null) {
            conexion.close();
        }
        System.out.println("\nConexion cerrada con Exito.\n");
    }

    /***************************************
     *      Metodos para obtener datos     *
     **************************************/
    /**
     * confirmarUsuario nos permite autenticar un usuario
     * @return java.sql.ResultSet
     * @param nick es el nickname del usuario
     * @param pwd es el password del usuario
     * @throws java.sql.SQLException 
     */
    public ResultSet confirmarUsuario(String nick, String pwd)
            throws SQLException {
        cdr = query.executeQuery(
                "SELECT "
                + "u.id         AS id_usuario,"
                + "u.user_name	AS nick,"
                + "u.is_admin	AS isadmin,"
                + "u.first_name AS nombre,"
                + "u.last_name	AS apellidos,"
                + "u.last_login	AS fecha "
                + "FROM users AS u "
                + "WHERE u.user_name = " + "'" + nick + "' "
                + "AND u.password = " + "sha1('" + pwd + "')");
        return cdr;

    }

    /***************************************
     *         Seccion de Resumen          *
     **************************************/
    /**
     * getUltimasAcciones obtiene las ultimas inserciones en la bd creadas
     * por un determinado usuario
     * @return java.sql.ResultSet con la consulta hecha
     * @param usuarioId String es el id del usuario a consultar
     * @param pwd es el password del usuario
     * @throws java.sql.SQLException
     */
    public ResultSet getUltimasAcciones(String usuarioId, String tabla,
            int limiteInicio, int limiteFin)
            throws SQLException {
        cdr = query.executeQuery("SELECT * FROM " + tabla + " WHERE created_by = \'" + usuarioId + "\'"
                + " ORDER BY \'date_entered\' ASC"
                + " LIMIT " + limiteInicio + "," + limiteFin);
        return cdr;
    }

    public ResultSet getCuentasPorUsuario()
            throws SQLException {
        cdr = query.executeQuery("SELECT asigned_user_id FROM accounts");
        return cdr;
    }

    /***************************************
     *        Seccion de Comentarios       *
     **************************************/
    public ResultSet getComentarios()
            throws SQLException {
        cdr = query.executeQuery("SELECT users.user_name, users.first_name, users.last_name,"
                + "users.is_admin, feed.id, feed.title, feed.comments,"
                + "feed.date_entered, feed.date_modified, feed.created_by "
                + " FROM  users, feed"
                + " WHERE feed.created_by = users.id"
                + " ORDER BY feed.date_entered DESC"
                + " LIMIT 0,5");
        return cdr;
    }

    public void setComentarios(String titulo, String comentario,
            int admin, String date_ent,
            String date_mod, String id_user)
            throws SQLException {
        query.executeUpdate("INSERT INTO feed"
                + "(title,comments,"
                + "is_admin,date_entered,"
                + "date_modified,created_by)"
                + "VALUES"
                + "(' " + titulo + "','" + comentario + "','"
                + admin + "','" + date_ent + "','"
                + date_mod + "','" + id_user + "')");
    }

    public ResultSet getDatosTabla(String tabla) throws SQLException {
        cdr = query.executeQuery("SELECT * FROM " + tabla);
        if (cdr != null) {
            return cdr;
        } else {
            return null;
        }
    }

    public ResultSet getDatosUsuario(String id) throws SQLException {
        cdr = query.executeQuery(""
                + "SELECT user_name, first_name, last_name, is_admin "
                + "FROM users"
                + "WHERE users.id = '" + id + "'");
        if (cdr != null) {
            return cdr;
        } else {
            return null;
        }
    }

    /***************************************
     *         Seccion de Cuentas          *
     **************************************/
    public ResultSet getListaTablas(String tabla) throws SQLException {
        cdr = query.executeQuery("SELECT users.user_name, users.first_name, users.last_name,"
                + " " + tabla + ".*"
                + " FROM  " + tabla + ", users"
                + " WHERE " + tabla + ".asigned_user_id = users.id");
        if (cdr != null) {
            return cdr;
        } else {
            return null;
        }
    }

    public ResultSet getCamposAssoc(String tabla) throws SQLException {
        cdr = query.executeQuery("SELECT id, name"
                + " FROM  " + tabla);
        if (cdr != null) {
            return cdr;
        } else {
            return null;
        }
    }

    /***************************************
     *         Seccion de Cuentas          *
     **************************************/
    public void setCuenta(Accounts account) throws SQLException {
        query.executeUpdate("INSERT INTO librecrm.accounts "
                + "(name, rfc, date_entered, date_modified,"
                + " modified_user_id, created_by, description,"
                + " asigned_user_id, account_type, industry,"
                + " phone, phone_fax, billing_address_street,"
                + " billing_address_city, billing_address_state,"
                + " billing_address_postalcode, billing_address_country,"
                + " website, shipping_address_street, shipping_address_city,"
                + " shipping_address_state, shipping_address_postalcode,"
                + " shipping_address_country, status)"
                + " VALUES ("
                + "'" + account.getName() + "', '" + account.getRfc() + "',"
                + "'" + account.getDateEntered() + "', '" + account.getDateModified() + "', "
                + "'" + account.getModifiedUserId() + "', '" + account.getCreatedBy() + "', "
                + "'" + account.getDescription() + "', '" + account.getAsignedUserId() + "', "
                + "'" + account.getAccountType() + "', '" + account.getIndustry() + "', "
                + "'" + account.getPhone() + "', '" + account.getPhoneFax() + "', "
                + "'" + account.getBillingAddressStreet() + "', '" + account.getBillingAddressCity() + "', "
                + "'" + account.getBillingAddressState() + "', '" + account.getBillingAddressPostalcode() + "', '" + account.getBillingAddressCountry() + "', "
                + "'" + account.getWebsite() + "', '" + account.getShippingAddressStreet() + "', '" + account.getShippingAddressCity() + "', "
                + "'" + account.getShippingAddressState() + "', '" + account.getShippingAddressPostalcode() + "', "
                + "'" + account.getShippingAddressCountry() + "', '" + account.getStatus() + "')");
    }

    public ResultSet getCuentasPorId(String id) throws SQLException {
        cdr = query.executeQuery("SELECT * FROM accounts WHERE id = '" + id + "'");
        if (cdr != null) {
            return cdr;
        } else {
            return null;
        }
    }

    public void deleteAccounts(String id) {
        try {
            query.executeUpdate("DELETE FROM `accounts` WHERE `id`=" + id + " LIMIT 1;");
        } catch (Exception e) {
        }
    }

    /***************************************
     *         Seccion de Contactos        *
     **************************************/
    public void setContacto(String dateEntered, String dateModified,
            String modifiedUserId, String createdBy,
            String desc, String asignedUserId, String salutation,
            String contName, String contLastName, String title,
            String department, String accountId,
            String phoneHome, String phoneMobile, String phoneWork,
            String phoneOther, String phoneFax,
            String aStreet, String aCity, String aState,
            String aPostalCode, String aCountry,
            String assistant, String assistantPhone,
            String status) throws SQLException {
        query.executeUpdate("INSERT INTO librecrm.contacts "
                + " (date_entered, date_modified, "
                + " modified_user_id, created_by, "
                + " description, asigned_user_id, "
                + " salutation, cont_first_name, "
                + " cont_last_name, title, department, "
                + " account_id, phone_home, phone_mobile, "
                + " phone_work, phone_other, phone_fax, primary_address_street, "
                + " primary_address_city, primary_address_state, primary_address_postalcode, "
                + " primary_address_country, assistant, assistant_phone, status)"
                + " VALUES ("
                + "'" + dateEntered + "', '" + dateModified + "', "
                + "'" + modifiedUserId + "', '" + createdBy + "', '" + desc + "', "
                + "'" + asignedUserId + "', '" + salutation + "', '" + contName + "', "
                + "'" + contLastName + "', '" + title + "', '" + department + "', "
                + "'" + accountId + "',"
                + "'" + phoneHome + "', '" + phoneMobile + "', '" + phoneWork + "', "
                + "'" + phoneOther + "', '" + phoneFax + "', "
                + "'" + aStreet + "', '" + aCity + "', '" + aState + "', '" + aPostalCode + "', '" + aCountry + "', "
                + "'" + assistant + "', '" + assistantPhone + "', '" + status + "')");
    }

    public ResultSet getContactoPorId(String id) throws SQLException {
        cdr = query.executeQuery("SELECT * FROM contacts WHERE id = '" + id + "'");
        if (cdr != null) {
            return cdr;
        } else {
            return null;
        }
    }

    public void deleteContact(String id) {
        try {
            query.executeUpdate("DELETE FROM `contacts` WHERE `id`=" + id + " LIMIT 1;");
        } catch (Exception e) {
        }
    }

    /***************************************
     *         Seccion de Usuario          *
     **************************************/
    public void createUsuario(Users user) throws SQLException {
        query.executeUpdate("INSERT INTO librecrm.users ("
                + "user_name, password, first_name,"
                + "last_name, report_to, is_admin, description,"
                + "date_entered, date_modified, modified_user_id,"
                + "created_by, last_login, category_id, phone_home,"
                + "phone_mobile, phone_work, phone_other, phone_fax,"
                + "adress_street, adress_city_id, adress_state_id, adress_country_id, email_id)"
                + "VALUES ("
                + "'"+ user.getUserName() +"', sha1('"+ user.getPassword() +"'), "
                + "'"+ user.getFirstName() +"', '"+ user.getLastName() +"', "
                + "'"+ user.getReportTo() +"', '"+ user.getIsAdmin() +"', "
                + "'"+ user.getDescription() +"', '"+ user.getDateEntered() +"', "
                + "'"+ user.getDateModified() +"', '"+ user.getModifiedUserId() +"', "
                + "'"+ user.getCreatedBy() +"', '"+ user.getLastLogin() +"', "
                + "'"+ user.getCategoryId() +"', '"+ user.getPhoneHome() +"', "
                + "'"+ user.getPhoneMobile() +"', '"+ user.getPhoneWork() +"', "
                + "'"+ user.getPhoneOther() +"', '"+ user.getPhoneFax() +"', "
                + "'"+ user.getAdressStreet() +"', '"+ user.getAdressCityId() +"', "
                + "'"+ user.getAdressStateId() +"', '"+ user.getAdressCountryId() +"', "
                + "'"+ user.getEmailId() +"')");
    }

    public ResultSet getUsuarioSimple(String tabla) throws SQLException {
        cdr = query.executeQuery("SELECT id, first_name, last_name"
                + " FROM  " + tabla);
        if (cdr != null) {
            return cdr;
        } else {
            return null;
        }
    }
}
