/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties.alteracion;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlType;
import recursos.Critico;

/**
 *
 * @author Juan
 */
@XmlType
public class Alteracion {

   
    private boolean activo = true;

    private String descripcion = "";

    private ArrayList<Efecto> efectos = new ArrayList<Efecto>();

    public Alteracion() {
    }
   
    /*
   
    public int getTrMod() {        
        if (isCuracionProgresiva())             
            return trMod * porcentajeActivo / 100;            
        else return trMod;
    }

    public void setTrMod(int trMod) {
        this.trMod = trMod;
    }

    public int getMmMod() {
        if (isCuracionProgresiva())             
            return mmMod * porcentajeActivo / 100;            
        else return mmMod;
    }

    public void setMmMod(int mmMod) {
        this.mmMod = mmMod;
    }

    public int getBoMod() {
        if (isCuracionProgresiva())             
            return boMod * porcentajeActivo / 100;            
        else return boMod;
    }

    public void setBoMod(int boMod) {
        this.boMod = boMod;
    }

    public int getBdMod() {
        if (isCuracionProgresiva())             
            return bdMod * porcentajeActivo / 100;            
        else return bdMod;
    }

    public void setBdMod(int bdMod) {
        this.bdMod = bdMod;
    }

    public int getActividad() {
        if (isCuracionProgresiva())             
            return actividad * porcentajeActivo / 100;            
        else return actividad;
    }

    public void setActividad(int actividad) {
        this.actividad = actividad;
    }

    public boolean isBrazoIzqInUtil() {
        if (isCuracionProgresiva() && porcentajeActivo < 25)            
            return true;            
        else return brazoIzqInUtil;
    }

    public void setBrazoIzqInUtil(boolean brazoIzqInUtil) {
        this.brazoIzqInUtil = brazoIzqInUtil;
    }

    public boolean isBrazoDerInUtil() {
        if (isCuracionProgresiva() && porcentajeActivo < 25)            
            return true;            
        else
            return brazoDerInUtil;
    }

    public void setBrazoDerInUtil(boolean brazoDerInUtil) {
        this.brazoDerInUtil = brazoDerInUtil;
    }

    public boolean isPiernaIzqInUtil() {
        if (isCuracionProgresiva() && porcentajeActivo < 25)            
            return true;            
        else
            return piernaIzqInUtil;
    }

    public void setPiernaIzqInUtil(boolean piernaIzqInUtil) {
        this.piernaIzqInUtil = piernaIzqInUtil;
    }

    public boolean isPiernaDerInUtil() {
        if (isCuracionProgresiva() && porcentajeActivo < 25)            
            return true;            
        else return piernaDerInUtil;
    }

    public void setPiernaDerInUtil(boolean piernaDerInUtil) {
        this.piernaDerInUtil = piernaDerInUtil;
    }

    public int getCuerpoEstado() {
        return cuerpoEstado;
    }

    public void setCuerpoEstado(int cuerpoEstado) {
        this.cuerpoEstado = cuerpoEstado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isCuracionProgresiva() {
        return curacionProgresiva;
    }

    public void setCuracionProgresiva(boolean curacionProgresiva) {
        this.curacionProgresiva = curacionProgresiva;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private void avanzarAsalto() {

        if (transcurso > 0) {
            transcurso -= 1;
        }
        if (transcurso < 1) 
            activo = false;
        if (curacionProgresiva)
            porcentajeActivo =  porcentajeActivo - (100 / duracion );

    }
     */

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Efecto> getEfectos() {
        return efectos;
    }

    public void setEfectos(ArrayList<Efecto> efectos) {
        this.efectos = efectos;
    }

    public void agregarEfecto(Efecto e){
        this.efectos.add(e);
    }
    
    public boolean isActivo() {
        return activo;
    }
}
