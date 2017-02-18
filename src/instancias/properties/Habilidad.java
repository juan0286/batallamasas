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
public class Habilidad implements Serializable{
    
    private int bo;
    private int bd;
    private int armadura;
    private int puntosVida;

    /**
     * @return the bo
     */
    public int getBo() {
        return bo;
    }

    /**
     * @param bo the bo to set
     */
    public void setBo(int bo) {
        this.bo = bo;
    }

    /**
     * @return the bd
     */
    public int getBd() {
        return bd;
    }

    /**
     * @param bd the bd to set
     */
    public void setBd(int bd) {
        this.bd = bd;
    }

    /**
     * @return the armadura
     */
    public int getArmadura() {
        return armadura;
    }

    /**
     * @param armadura the armadura to set
     */
    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    /**
     * @return the puntosVida
     */
    public int getPuntosVida() {
        return puntosVida;
    }

    /**
     * @param puntosVida the puntosVida to set
     */
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }
    
    
}
