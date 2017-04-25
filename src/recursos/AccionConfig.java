/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import instancias.Token;
import instancias.properties.Arma;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class AccionConfig {
    
    
    // dispara proy
    Token blanco;
    Arma proySeleccionado;
    int DistanciaAtaque;
    
    // mov y maniobra
    int dificultadManiobra;
    int bonoExtra;
    
    // ataque cac        
    int boConf = -1;
    boolean bdEnUso;
    boolean biEnUso;
    
    //desplazamiento
    int ritmo;
    int distancia;
    
    String desc;

    public AccionConfig() {
    }

    public Token getBlanco() {
        return blanco;
    }

    public void setBlanco(Token blanco) {
        this.blanco = blanco;
    }

    public Arma getProySeleccionado() {
        return proySeleccionado;
    }

    public void setProySeleccionado(Arma proySeleccionado) {
        this.proySeleccionado = proySeleccionado;
    }

    public int getDistanciaAtaque() {
        return DistanciaAtaque;
    }

    public void setDistanciaAtaque(int DistanciaAtaque) {
        this.DistanciaAtaque = DistanciaAtaque;
    }

    public int getDificultadManiobra() {
        return dificultadManiobra;
    }

    public void setDificultadManiobra(int dificultadManiobra) {
        this.dificultadManiobra = dificultadManiobra;
    }

    public int getBonoExtra() {
        return bonoExtra;
    }

    public void setBonoExtra(int bonoExtra) {
        this.bonoExtra = bonoExtra;
    }

    public int getBoConf() {
        return boConf;
    }

    public void setBoConf(int boConf) {
        this.boConf = boConf;
    }

    public boolean isBdEnUso() {
        return bdEnUso;
    }

    public void setBdEnUso(boolean bdEnUso) {
        this.bdEnUso = bdEnUso;
    }

    public boolean isBiEnUso() {
        return biEnUso;
    }

    public void setBiEnUso(boolean biEnUso) {
        this.biEnUso = biEnUso;
    }

    public int getRitmo() {
        return ritmo;
    }

    public void setRitmo(int ritmo) {
        this.ritmo = ritmo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }
    
    
    
    
    
    
}
