/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class CampoDeBatalla {

    public static ArrayList<Asalto> asaltos = new ArrayList<Asalto>();

    public static int nAsalto= 0;
    
    public static void resolverAsalto() {
         
        Asalto as = asaltos.get(nAsalto);
         as.resolver();
    }

    public static void iniciarCampoDeBatalla() {
       
        Asalto asa = new Asalto();
        asaltos.add(asa);
    }
    
    public static void agregarAccion(Accion acc) {
        Asalto asa = asaltos.get(asaltos.size()-1);
        asa.agregarAccion(acc);
        
    }

    public static Asalto asaltoNow() {
        if (asaltos.size() > 0) {
            return asaltos.get(asaltos.size()-1);
        } else {
            return null;
        }
    }

    public static Accion getAccionesDeToken(Token tok) {

        if (asaltoNow() == null) {
            return null;
        }
        for (Accion accion : asaltoNow().getAcciones()) {
            if (accion.getEmisor().equals(tok)) {
                return accion;
            }
        }
        return null;

    }

    public static ArrayList<Token> getAtacantesDeToken(Token tok) {
        if (asaltoNow() == null) {
            return null;
        }
        ArrayList<Token> enemigos = new ArrayList<Token>();
        for (Accion accion : asaltoNow().getAcciones()) {
            if (accion.getDestino().equals(tok)
                    && (accion.getTipo() == accion.TIPO_COMBATE_1_ARMA
                    || accion.getTipo() == accion.TIPO_COMBATE_2_ARMAS
                    || accion.getTipo() == accion.TIPO_COMBATE_ARCO
                    || accion.getTipo() == accion.TIPO_COMBATE_PUÑO)) {
                enemigos.add(accion.getEmisor());
            }
        }
        return enemigos;

    }

   
}
