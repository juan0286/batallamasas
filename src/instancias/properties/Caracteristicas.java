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
import recursos.Constantes;

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
    
   
    
    private int puntosVida;
    
    private int pp;
    private ArrayList<Integer> al_sortilegios = new ArrayList<Integer>();
    
    // Listas de Sortilegios: key -> Id de la Lista  Value - > Lv maximo que puede usar.
    private HashMap<Integer,Integer> hm_listasDeSortilegios = new HashMap<>();
    
    private HashMap<Integer, Bo> hm_bos = new HashMap<Integer, Bo>();
    
    private int bo_pri;
    
    private HashMap<Integer, Integer> hm_habilidades = new HashMap<Integer, Integer>();
    
    public Caracteristicas() {
        
        hm_habilidades.put(Constantes.HABILIDAD_CAR_FUE,0);
        hm_habilidades.put(Constantes.HABILIDAD_CAR_AGI,0);
        hm_habilidades.put(Constantes.HABILIDAD_CAR_CON,0);
        hm_habilidades.put(Constantes.HABILIDAD_CAR_INT,0);
        hm_habilidades.put(Constantes.HABILIDAD_MM_CORAZA,0);
        
        hm_habilidades.put(Constantes.HABILIDAD_MM_SINARMADURA,0);
        hm_habilidades.put(Constantes.HABILIDAD_MM_CUERO,0);
        hm_habilidades.put(Constantes.HABILIDAD_MM_CUERO_ENDURECIDO,0);
        hm_habilidades.put(Constantes.HABILIDAD_MM_COTA_DE_MALLA,0);
        hm_habilidades.put(Constantes.HABILIDAD_MM_CORAZA,0);
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
        int da = (hm_habilidades.containsKey(Constantes.HABILIDAD_BD_DEFENSA_ADRENAL)) ? hm_habilidades.get(Constantes.HABILIDAD_BD_DEFENSA_ADRENAL) : 0;
        return hm_habilidades.get(Constantes.HABILIDAD_CAR_AGI) + da;
        
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
         return hm_habilidades.get(Constantes.HABILIDAD_CAR_AGI);
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

    public HashMap<Integer, Integer> getHm_habilidades() {
        return hm_habilidades;
    }

    public void setHm_habilidades(HashMap<Integer, Integer> hm_habilidades) {
        this.hm_habilidades = hm_habilidades;
    }

    public int getCaracteristica(int t){
        return hm_habilidades.get(t);
    }
    
}
