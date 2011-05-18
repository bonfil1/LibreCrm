package org.prueba.mail.Main;

import org.prueba.mail.GUI.*;

/**
 * @author Jose Angel Bonfil Evia
 */
public class EmailMain {

    public static void main(String[] arg) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            new EmailGui().setVisible(true);
        } catch (Exception e) {
        }
    }
}
