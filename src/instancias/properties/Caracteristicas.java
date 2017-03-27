/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import instancias.Sortilegio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Juan
 */
@XmlType
public class Caracteristicas implements Serializable {

    /*
    private int bo_pri;
    private int bo_sec;
    private int bo_pri_tipo;
    private int bo_sec_tipo;
    */
    
    private int bd;
    private int armadura;
    private int puntosVida;
    private int agi;
    private int pp;
    private ArrayList<Integer> al_sortilegios = new ArrayList<Integer>();
    
    // Listas de Sortilegios: key -> Id de la Lista  Value - > Lv maximo que puede usar.
    private HashMap<Integer,Integer> hm_listasDeSortilegios = new HashMap<>();
    
    private HashMap<Integer, Bo> hm_bos = new HashMap<Integer, Bo>();
    private int bo_pri;
    
    public Caracteristicas() {
        
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }    
    
    public ArrayList<Integer> getAl_sortilegios() {
        return al_sortilegios;
    }

    public void setAl_sortilegios(ArrayList<Integer> al_sortilegios) {
        this.al_sortilegios = al_sortilegios;
    }

    public Bo getBodeEstilo(int estilo) {
        if (hm_bos.containsKey(estilo)) 
            return hm_bos.get(estilo);
         else 
            return new Bo(estilo, -25);   
        
    }

    public void setHm_bos(HashMap<Integer, Bo> hm_bos) {
        this.hm_bos = hm_bos;
    }

    public HashMap<Integer, Bo> getHm_bos() {
        return hm_bos;
    }
    public Bo[] getBosArray() {
        Collection<Bo> bosc = hm_bos.values();
        return (Bo[]) bosc.toArray();
    }
    
    
    
    public int getBo_pri() {
        return bo_pri;
    }

    public void setBo_pri(int bo_pri) {
        this.bo_pri = bo_pri;
    }

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

    public void aprenderSortilegio(int s) {
        al_sortilegios.add(s);

    }
    
    public void aprenderListaDeSortilegio(int lista,int maxl) {
        hm_listasDeSortilegios.put(lista, maxl);

    }

    public boolean conoceSortilegio(int id) {
        return al_sortilegios.contains(id);
    }

    public HashMap<Integer, Integer> getHm_listasDeSortilegios() {
        return hm_listasDeSortilegios;
    }

    public void setHm_listasDeSortilegios(HashMap<Integer, Integer> hm_listasDeSortilegios) {
        this.hm_listasDeSortilegios = hm_listasDeSortilegios;
    }

}
