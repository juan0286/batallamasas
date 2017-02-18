/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import java.io.Serializable;

/**
 *
 * @author Juan
 */
public class Brazo implements Serializable{
    
    boolean habilitado = true;
    Arma armaEquipada;

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public Brazo(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }
    public Brazo() {
       
    }


}
