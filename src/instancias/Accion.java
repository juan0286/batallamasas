/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.awt.Color;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class Accion implements Serializable{
    

    
  private int tipo;
  private int orden;
  private int nro_Asalto;
  private boolean done = false;
  private boolean accionDeOportunidad = false;
  private boolean cambioDeAccion = false;
  private Sortilegio sortilegio;
  private String Dificultad ;
  private Sortilegio sort_intencion;
  private String Descp;
  private String fullDescp;
  

    public Accion(int tipo, int nro_Asalto, int orden) {
        this.tipo = tipo;
        this.nro_Asalto = nro_Asalto;
        this.orden = orden;
        this.Descp = "";
    }

    public Accion() {
         this.Descp = "";
    }

    
    public Sortilegio getSortilegio() {
        return sortilegio;
    }

    public void setSortilegio(Sortilegio sortilegio) {
        this.sortilegio = sortilegio;
    }

    public String getDificultad() {
        return Dificultad;
    }

    public void setDificultad(String Dificultad) {
        this.Dificultad = Dificultad;
    }
    
    
    

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNro_Asalto() {
        return nro_Asalto;
    }

    public void setNro_Asalto(int nro_Asalto) {
        this.nro_Asalto = nro_Asalto;
    }

  
    public void hecho(int tipo) {
        if (!done) {
            this.done = true; 
            this.accionDeOportunidad = false;
            this.setTipo(tipo);
        }
    }

    public void desHecho() {
        this.done = false;        
    }
    
    public void cambioDeAccion(int tipo){
        cambioDeAccion =true;
        this.tipo = tipo;
    }
    

    public void esperarOportunidad() {
        if (!done) {            
            this.accionDeOportunidad = true;            
        }
    }

    public boolean isDone() {
        return done;
    }

    public boolean isAccionDeOportunidad() {
        return accionDeOportunidad;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Sortilegio getSort_intencion() {
        return sort_intencion;
    }

    public void setSort_intencion(Sortilegio sort_intencion) {
        this.sort_intencion = sort_intencion;
    }

    public boolean isCambioDeAccion() {
        return cambioDeAccion;
    }

    public void setCambioDeAccion(boolean cambioDeAccion) {
        this.cambioDeAccion = cambioDeAccion;
    }

    public String getDescp() {
        return Descp;
    }

    public void setDescp(String Descp) {
        this.Descp = Descp;
    }

    public String getFullDescp() {
        return fullDescp;
    }

    public void setFullDescp(String fullDescp) {
        this.fullDescp = fullDescp;
    }

   
  
}
