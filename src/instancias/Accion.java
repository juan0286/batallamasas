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
    
    final public static int TIPO_SIN_ACCION = 0;
    final public static int TIPO_CARGA_SORTILEGIO = 1;
    final public static int TIPO_REALIZA_SORTILEGIO = 2;
    final public static int TIPO_DISPARA_PROYECTIL = 3;
    final public static int TIPO_CARGA_PROYECTIL = 4;
    final public static int TIPO_PARAR_PROYECTIL = 5;
    final public static int TIPO_MOVIMIENTO_Y_MANIOBRA = 6;
    final public static int TIPO_ATAQUE_CUERPO_A_CUERPO = 7;
    final public static int TIPO_DESPLAZAMIENTO = 8;
    final public static int TIPO_MOVIMIENTO_ESTATICO = 9;
    
  private int tipo;
  private int orden;
  private int nro_Asalto;
  private boolean done = false;
  private boolean accionDeOportunidad = false;
  private Sortilegio sortilegio;
  private String Dificultad ;
          

    public Accion(int tipo, int nro_Asalto, int orden) {
        this.tipo = tipo;
        this.nro_Asalto = nro_Asalto;
        this.orden = orden;
    }

    public Accion() {
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

    
  
}
