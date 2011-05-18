package org.prueba.mail.Obj;

import java.util.Properties;
import javax.mail.*;
import javax.mail.event.ConnectionEvent;
import javax.mail.event.ConnectionListener;
import javax.mail.event.TransportEvent;
import javax.mail.event.TransportListener;
import javax.mail.internet.*;

/**
 *
 * @author Jose Angel
 */
public class EmailEnvio {

    private Properties props;
    private String protocol;
    private String port;
    private String host;
    private String user;
    private String pass;
    private String dest;
    private String cod;
    private String sub;
    private String mnsj;

    public EmailEnvio() {
        //Godady.com
        //Smtp: smtpout.secureserver.net
        //Host: pop.secureserver.net
        //Hotmail.com
        //Smtp: smtp.live.com
        //Pop:  pop3.live.com
        //Gmail
        //Smtp: smtp.gmail.com Port: 587
        //Pop3: pop.gmail.com Port: 995
        //Enviamos el email
        //datosCorreo("smtp","25", "smtp.live.com", "bonfil_joseangel@hotmail.com", "master12", "text/plain", "");
    }

    public EmailEnvio(String protocolo, String puerto, String h,
            String u, String p, String titulo,
            String codificacion, String text, String destino) {
        //Enviamos el correo
        sendCorreo(protocolo, puerto, h, u, p, titulo, codificacion, text, destino);
    }

    public final void sendCorreo(String protocolo, String puerto,
            String h, String u, String p,
            String subject, String codificacion,
            String mensaje, String destinatario) {
        protocol = protocolo;
        port = puerto;
        host = h;
        user = u;
        pass = p;
        sub = subject;
        cod = codificacion;
        mnsj = mensaje;
        dest = destinatario;

        try {
            //Inciamos las operaciones de correo
            props = new Properties();
            props.setProperty("mail.transport.protocol", protocol);
            props.setProperty("mail.host", host);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.socketFactory.port", port);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.quitwait", "false");
            //props.setProperty("mail.user", user);
            //props.setProperty("mail.password", pass);

            Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                //Autenticacion para los usuario

                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, pass);
                }
            });
            Transport transport = mailSession.getTransport("smtp");

            MimeMessage message = new MimeMessage(mailSession);
            message.setSubject(sub);
            //El segundo parametro indica el tipo de datos enviado
            //text/plain = texto plano
            //text/html; charset=utf-8 = texto con formato html
            message.setContent(mnsj, cod);
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(dest));

            transport.connect();
            //Probamos si existe una conexion al servidor
            if (transport.isConnected()) {
                System.out.println("Se establecio conexion con el host: " + host);
            } else {
                System.out.println("No se establecion conexion a : " + host);
            }

            transport.send(message,
                    message.getRecipients(Message.RecipientType.TO));
            transport.addConnectionListener(new ConnectionListener() {

                public void opened(ConnectionEvent ce) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Conexion Abierta :) \n" + ce.toString());
                }

                public void disconnected(ConnectionEvent ce) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Desconectado :) \n" + ce.toString());
                }

                public void closed(ConnectionEvent ce) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Se conecto exitosamente y se ha cerrado la conexion \n" + ce.toString());
                }
            });
            transport.addTransportListener(new TransportListener() {

                public void messageDelivered(TransportEvent te) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Mensaje enviado :)\n" + te.toString());
                }

                public void messageNotDelivered(TransportEvent te) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Mensaje NO enviado :(\n" + te.toString());
                }

                public void messagePartiallyDelivered(TransportEvent te) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Mensaje PARCIALMENTE enviado :O\n" + te.toString());
                }
            });
            transport.close();

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error en el email: \n" + e.getLocalizedMessage());
            System.out.println("Error en el email: " + e.getLocalizedMessage());
        }

    }
}
