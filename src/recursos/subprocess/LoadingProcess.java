/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.subprocess;

import instancias.Token;
import java.awt.Color;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import superrolbattle.Principal;
import superrolbattle.ventanas.JPanelFormToken;
import superrolbattle.ventanas.JPanelFormToken_Accion;

/**
 *
 * @author TiranoJuan
 */
public class LoadingProcess extends Thread {

    Principal p;    

    public LoadingProcess(Principal p) {
        this.p = p;        
    }

    public void run() {
        cargarLosTokens();
    }

    private void cargarLosTokens() {        
        p.showLoading(true);
        for (Iterator iterator = p.campo.getTokens().iterator(); iterator.hasNext();) {
            esperarPor(5);
            Token next = (Token) iterator.next();
            JPanelFormToken_Accion jpa = new JPanelFormToken_Accion(next, p);
            p.aws.add(jpa);
            p.moverAccion(jpa, jpa.getAccion().getTipo());
            JPanelFormToken jpft = new JPanelFormToken(jpa.getToken(), p,jpa);
            if (next.isVisible()) {
                p.jPanel_Pjs.add(jpft);
            } else {
                p.jPanel_Pnj.add(jpft);
            }
        }
        p.showLoading(false);
    }

    public static void esperarPor(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ex) {
            Logger.getLogger(JPanelFormToken_Accion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
