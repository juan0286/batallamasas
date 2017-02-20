/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import instancias.Sortilegio;
import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Juan
 */
@XmlType
public class Caracteristicas implements Serializable{
    
    private int bo_pri;
    private int bo_sec;
    private int bo_pri_tipo;
    private int bo_sec_tipo;
    private int bd;
    private int armadura;
    private int puntosVida;
    private int agi;
    private ArrayList<Integer> sortilegios = new ArrayList<Integer>();

    public Caracteristicas() {
    }

    public ArrayList<Integer> getSortilegios() {
        return sortilegios;
    }

    public void setSortilegios(ArrayList<Integer> sortilegios) {
        this.sortilegios = sortilegios;
    }

    
     
    
    public int getBo_pri() {
        return bo_pri;
    }

    public void setBo_pri(int bo_pri) {
        this.bo_pri = bo_pri;
    }

    public int getBo_sec() {
        return bo_sec;
    }

    public void setBo_sec(int bo_sec) {
        this.bo_sec = bo_sec;
    }

    public int getBo_pri_tipo() {
        return bo_pri_tipo;
    }

    public void setBo_pri_tipo(int bo_pri_tipo) {
        this.bo_pri_tipo = bo_pri_tipo;
    }

    public int getBo_sec_tipo() {
        return bo_sec_tipo;
    }

    public void setBo_sec_tipo(int bo_sec_tipo) {
        this.bo_sec_tipo = bo_sec_tipo;
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

    public int getAgi() {
        return agi;
    }

    public void setAgi(int agi) {
        this.agi = agi;
    }
    
    public void aprenderSortilegio(int s){
            sortilegios.add(s);
            
    }
    
    public boolean conoceSortilegio(int id){
        return sortilegios.contains(id);
    }
    
}
