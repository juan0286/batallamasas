/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.subprocess;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import superrolbattle.ventanas.JPanelFormToken_Accion;

/**
 *
 * @author TiranoJuan
 */
public class UpdaterProgresBar extends Thread {

    JProgressBar jp;
    int destino;

    public UpdaterProgresBar(JProgressBar jp, int destino) {
        this.jp = jp;
        this.destino = destino;
    }

    public void run() {
        moverBarraDeVida();
    }

    private void moverBarraDeVida() {
        int paso = (destino > 0) ? -1 : 1;
        int act = jp.getValue();
        int maximo = jp.getMaximum();
        while (destino != 0) {
            esperarPor(100);
            destino += paso;
            act += paso;
            jp.setValue(act);
            jp.setStringPainted(true);
            jp.repaint();
            if (act > (maximo * 1.5)) {
                jp.setForeground(Color.BLACK);
            } else if (act >= maximo) {
                jp.setForeground(Color.RED);                
            } else if (act >= (maximo - 10)) {
                jp.setForeground(Color.ORANGE);
            } else if (act > (maximo / 2)) {
                jp.setForeground(Color.YELLOW);
            } else if (act < (maximo / 2)) {
                jp.setForeground(Color.GREEN);
            }
        }
    }

    public static void esperarPor(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(JPanelFormToken_Accion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
