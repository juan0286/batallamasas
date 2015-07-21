/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import instancias.properties.Brazo;
import instancias.properties.Habilidad;
import instancias.properties.Status;
import java.util.ArrayList;

/**
 *
 * @author Juan
 */
public class Enemigo extends Token{

    public Enemigo(String nombre, int nivel, String grupo, int puntosVida, Brazo manoIZQ, Brazo manoDER, Habilidad habilidades, ArrayList daños, Status estado, int estilo) {
        super(nombre, nivel, grupo, puntosVida, manoIZQ, manoDER, habilidades, daños, estado, estilo);
    }
    
    private int porcDefensa;

    public int getPorcDefensa() {
        return porcDefensa;
    }

    public void setPorcDefensa(int porcDefensa) {
        this.porcDefensa = porcDefensa;
    }

//     public int deDefiendeCon(Token atacante){
////        int bdReturn = 0;
////        for (Enemigo atacante1 : getAtacantes()) {
////            if ( atacante.equals(atacante1)) {bdReturn = atacante1.getPorcDefensa();}
////        }
//        return bdReturn;
//    }
    
   
    
    
}
