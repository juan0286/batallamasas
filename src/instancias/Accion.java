/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author TiranoJuan
 */
public class Accion implements Serializable{
    
    public static int TIPO_SIN_ACCION = 0;
    public static int TIPO_CARGA_SORTILEGIO = 1;
    public static int TIPO_REALIZA_SORTILEGIO = 2;
    public static int TIPO_DISPARA_PROYECTIL = 3;
    public static int TIPO_CARGA_PROYECTIL = 4;
    public static int TIPO_PARAR_PROYECTIL = 5;
    public static int TIPO_MOVIMIENTO_Y_MANIOBRA = 6;
    public static int TIPO_ATAQUE_CUERPO_A_CUERPO = 7;
    public static int TIPO_DESPLAZAMIENTO = 8;
    public static int TIPO_MOVIMIENTO_ESTATICO = 9;
    
  private int tipo;
  private final int orden;
  private int nro_Asalto;
  private boolean done = false;
  private boolean accionDeOportunidad = false;
  

    public Accion(int tipo, int nro_Asalto, int orden) {
        this.tipo = tipo;
        this.nro_Asalto = nro_Asalto;
        this.orden = orden;
    }

    public static int getTIPO_SIN_ACCION() {
        return TIPO_SIN_ACCION;
    }

    public static void setTIPO_SIN_ACCION(int TIPO_SIN_ACCION) {
        Accion.TIPO_SIN_ACCION = TIPO_SIN_ACCION;
    }

    public static int getTIPO_CARGA_SORTILEGIO() {
        return TIPO_CARGA_SORTILEGIO;
    }

    public static void setTIPO_CARGA_SORTILEGIO(int TIPO_CARGA_SORTILEGIO) {
        Accion.TIPO_CARGA_SORTILEGIO = TIPO_CARGA_SORTILEGIO;
    }

    public static int getTIPO_REALIZA_SORTILEGIO() {
        return TIPO_REALIZA_SORTILEGIO;
    }

    public static void setTIPO_REALIZA_SORTILEGIO(int TIPO_REALIZA_SORTILEGIO) {
        Accion.TIPO_REALIZA_SORTILEGIO = TIPO_REALIZA_SORTILEGIO;
    }

    public static int getTIPO_DISPARA_PROYECTIL() {
        return TIPO_DISPARA_PROYECTIL;
    }

    public static void setTIPO_DISPARA_PROYECTIL(int TIPO_DISPARA_PROYECTIL) {
        Accion.TIPO_DISPARA_PROYECTIL = TIPO_DISPARA_PROYECTIL;
    }

    public static int getTIPO_CARGA_PROYECTIL() {
        return TIPO_CARGA_PROYECTIL;
    }

    public static void setTIPO_CARGA_PROYECTIL(int TIPO_CARGA_PROYECTIL) {
        Accion.TIPO_CARGA_PROYECTIL = TIPO_CARGA_PROYECTIL;
    }

    public static int getTIPO_PARAR_PROYECTIL() {
        return TIPO_PARAR_PROYECTIL;
    }

    public static void setTIPO_PARAR_PROYECTIL(int TIPO_PARAR_PROYECTIL) {
        Accion.TIPO_PARAR_PROYECTIL = TIPO_PARAR_PROYECTIL;
    }

    public static int getTIPO_MOVIMIENTO_Y_MANIOBRA() {
        return TIPO_MOVIMIENTO_Y_MANIOBRA;
    }

    public static void setTIPO_MOVIMIENTO_Y_MANIOBRA(int TIPO_MOVIMIENTO_Y_MANIOBRA) {
        Accion.TIPO_MOVIMIENTO_Y_MANIOBRA = TIPO_MOVIMIENTO_Y_MANIOBRA;
    }

    public static int getTIPO_ATAQUE_CUERPO_A_CUERPO() {
        return TIPO_ATAQUE_CUERPO_A_CUERPO;
    }

    public static void setTIPO_ATAQUE_CUERPO_A_CUERPO(int TIPO_ATAQUE_CUERPO_A_CUERPO) {
        Accion.TIPO_ATAQUE_CUERPO_A_CUERPO = TIPO_ATAQUE_CUERPO_A_CUERPO;
    }

    public static int getTIPO_DESPLAZAMIENTO() {
        return TIPO_DESPLAZAMIENTO;
    }

    public static void setTIPO_DESPLAZAMIENTO(int TIPO_DESPLAZAMIENTO) {
        Accion.TIPO_DESPLAZAMIENTO = TIPO_DESPLAZAMIENTO;
    }

    public static int getTIPO_MOVIMIENTO_ESTATICO() {
        return TIPO_MOVIMIENTO_ESTATICO;
    }

    public static void setTIPO_MOVIMIENTO_ESTATICO(int TIPO_MOVIMIENTO_ESTATICO) {
        Accion.TIPO_MOVIMIENTO_ESTATICO = TIPO_MOVIMIENTO_ESTATICO;
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
