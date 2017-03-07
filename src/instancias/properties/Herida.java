/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class Herida  extends Alteracion{

    private int pv = 0;

    private int aturdido = 0;
    private int obligadoparar = 0;
    private int sinpoderparar = 0;

    // curable
    private int asaltosparamorir = 0;
    private int sangre = 0;
    private int cuerpoEstado = -1;
    
    //progresivo
    private int trMod = 0;
    private int mmMod = 0;
    private int boMod = 0;
    private int bdMod = 0;
    private int actividad = 0;
   

    private boolean brazoIzqInUtil = false;
    private boolean brazoDerInUtil = false;
    private boolean piernaIzqInUtil = false;
    private boolean piernaDerInUtil = false;

    private boolean activo = true;
    private boolean curacionProgresiva = false;
    private String descripcion = "";
    private int duracion = -1;
    private int transcurso = -1;
    
    private int porcentajeActivo = 100;    

    public int getTranscurso() {
        return transcurso;
    }

    public void setTranscurso(int transcurso) {
        this.transcurso = transcurso;
    }
    
    public int getPorcentajeActivo() {
        return porcentajeActivo;
    }

    public void setPorcentajeActivo(int porcentajeActivo) {
        this.porcentajeActivo = porcentajeActivo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
        this.transcurso = duracion;
        
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getAturdido() {
        return aturdido;
    }

    public void setAturdido(int aturdido) {
        this.aturdido = aturdido;
    }

    public int getObligadoparar() {
        return obligadoparar;
    }

    public void setObligadoparar(int obligadoparar) {
        this.obligadoparar = obligadoparar;
    }

    public int getSinpoderparar() {
        return sinpoderparar;
    }

    public void setSinpoderparar(int sinpoderparar) {
        this.sinpoderparar = sinpoderparar;
    }

    public int getAsaltosparamorir() {
        return asaltosparamorir;
    }

    public void setAsaltosparamorir(int asaltosparamorir) {
        this.asaltosparamorir = asaltosparamorir;
    }

    public int getSangre() {
        return sangre;
    }

    public void setSangre(int sangre) {
        this.sangre = sangre;
    }

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

}

    
}
