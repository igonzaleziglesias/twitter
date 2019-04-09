/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotwitter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import twitter4j.TwitterException;

/**
 *
 * @author igonzaleziglesias
 */
public class Ejemplotwitter {

    public static void main(String[] args) {
        int confirmar, menu = 0;
        metodos obx = new metodos();

        try {
            Autorizacion au = new Autorizacion();
        } catch (IOException ex) {
            Logger.getLogger(Ejemplotwitter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TwitterException ex) {
            Logger.getLogger(Ejemplotwitter.class.getName()).log(Level.SEVERE, null, ex);
        }

        do {
            menu = Integer.parseInt(JOptionPane.showInputDialog(null, "******MENU******\n\n Seleccione que desea realizar:\n1-ver linea de tiempo de sus twitter\n2-Escribir un twitter\n3-Buscar por una palabra o #\n4-Salir"));
            switch (menu) {
                case 1: {
                    try {
                        obx.traerLineaTiempo();
                    } catch (TwitterException ex) {
                        Logger.getLogger(Ejemplotwitter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 2: {
                    try {
                        obx.tuit();
                    } catch (TwitterException ex) {
                        Logger.getLogger(Ejemplotwitter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 3: {
                    try {
                        obx.filtrado();
                    } catch (TwitterException ex) {
                        Logger.getLogger(Ejemplotwitter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case 4:
                    confirmar = Integer.parseInt(JOptionPane.showInputDialog(null, "Seguro que desea salir?\n1-Si\n2-No"));
                    if (confirmar == 1) {
                        System.exit(0);
                    } else {
                        break;
                    }
            }
        } while (menu != 1000000);

    }

}
