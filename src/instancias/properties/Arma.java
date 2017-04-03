/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Juan
 */
@XmlType
public class Arma implements Serializable{
 
    
    public Arma() {
    }

   

    public Arma(String Nombre, int clase, int bono,int tipo, boolean manos) {
        this.Nombre = Nombre;
        this.factura = tipo;
        this.bono = bono;
        this.clase = clase;
        this.dosManos = manos;
    }

    public Arma(String Nombre, int tipo, int bono, int clase, boolean dosManos, int Estilo) {
        this.Nombre = Nombre;
        this.factura = tipo;
        this.bono = bono;
        this.clase = clase;
        this.dosManos = dosManos;
        this.estilo = Estilo;
       
    }


    /**
     * @return the tipo
     */
    public int getFactura() {
        return factura;
    }

    /**
     * @param factura the tipo to set
     */
    public void setFactura(int factura) {
        this.factura = factura;
    }

    /**
     * @return the bono
     */
    public int getBono() {
        return bono;
    }

    /**
     * @param bono the bono to set
     */
    public void setBono(int bono) {
        this.bono = bono;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return  Nombre ;
    }

    public boolean isdosManos() {
        return dosManos;
    }

    public void setManos(boolean manos) {
        this.dosManos = manos;
    }

    public void setDosManos(boolean dosManos) {
        this.dosManos = dosManos;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }
    
    
    private String Nombre;
    private int factura; // material, si e snormal, magica, mithril, o sagrada
    private int bono;  // bono al ataque
    private int clase;  // // tabla que usa para definir el resultado del ataque
    private int estilo;    // que tipo de Bo utiliza
    private boolean dosManos;

    private int pifia;
    
}
