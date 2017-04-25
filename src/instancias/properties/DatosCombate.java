/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import instancias.properties.Arma;
import instancias.properties.Bo;
import javax.xml.bind.annotation.XmlType;
import superrolbattle.ventanas.JPanelFormToken_Accion;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class DatosCombate {
    
    
    
    Bo bo;
    int bo_Disponible;
    int bd_Disponible;
    boolean puedeUsarEscudo = false;
    private Arma armaUsada;
    private Arma escudo;
    int cantidadCambios = 0;
    
    public DatosCombate() {
    }

    public Arma getArmaUsada() {
        return armaUsada;
    }

    public void setArmaUsada(Arma armaUsada) {
        this.armaUsada = armaUsada;
    }

    public Arma getEscudo() {
        return escudo;
    }

    public void setEscudo(Arma escudo) {
        this.escudo = escudo;
    }

    public int getCantidadCambios() {
        return cantidadCambios;
    }

    public void setCantidadCambios(int cantidadCambios) {
        this.cantidadCambios = cantidadCambios;
    }

       
   

    public Bo getBo() {
        return bo;
    }

    public void setBo(Bo bo) {
        this.bo = bo;
    }

    public int getBo_Disponible() {
        return bo_Disponible;
    }

    public void setBo_Disponible(int bo_Disponible) {
        this.bo_Disponible = bo_Disponible;
    }

    public int getBd_Disponible() {
        return bd_Disponible;
    }

    public void setBd_Disponible(int bd_Disponible) {
        this.bd_Disponible = bd_Disponible;
    }

    public boolean isPuedeUsarEscudo() {
        return puedeUsarEscudo;
    }

    public void setPuedeUsarEscudo(boolean puedeUsarEscudo) {
        this.puedeUsarEscudo = puedeUsarEscudo;
    }
    

    
}
