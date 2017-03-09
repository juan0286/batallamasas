/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties.alteracion;

/**
 *
 * @author TiranoJuan
 */
public class Efecto {

    static final public int TIPO_SANGRADO = 1;
    static final public int TIPO_OBLIGADO_A_PARAR = 2;
    static final public int TIPO_ATURDIDO = 3;
    static final public int TIPO_ATURDIDO_SIN_PARAR = 4;
    static final public int TIPO_RESTA_DE_ACTIVIDAD = 5;
    static final public int TIPO_RESTA_DE_MM = 6;
    static final public int TIPO_RESTA_DE_BO = 7;
    static final public int TIPO_RESTA_DE_BD = 8;
    static final public int TIPO_RESTA_DE_TR = 9;
    static final public int TIPO_DESACTIVAR_EXTREMIDAD = 10;
    static final public int TIPO_RESTAR_PV_TOTAL = 11;
    static final public int TIPO_DIVIDIR_PV_TOTAL = 12;
    static final public int TIPO_DORMIDO = 13;
    static final public int TIPO_DIVIDE_LA_ACTIVIDAD = 14;    
    static final public int TIPO_POSTRADO = 15;    
    
    
    static final public int TIPO_CIERRA_SANGRADO = 20;
    static final public int TIPO_DESATURDIR = 21;
    static final public int TIPO_AUMENTA_ACTIVIDAD = 22;
    static final public int TIPO_AUMENTO_DE_MM = 23;
    static final public int TIPO_AUMENTO_DE_TR = 24;
    static final public int TIPO_AUMENTO_DE_BO = 25;
    static final public int TIPO_AUMENTO_DE_BO_FILO = 26;
    static final public int TIPO_AUMENTO_DE_BO_CONTUNDENTE = 27;
    static final public int TIPO_AUMENTO_DE_BO_DOS_MANOS = 28;
    static final public int TIPO_AUMENTO_DE_BO_PROYECTILES = 29;
    static final public int TIPO_AUMENTO_DE_BO_ASTA = 30;
    static final public int TIPO_AUMENTO_DE_BD = 31;
    static final public int TIPO_SUMAR_PV = 32;
    static final public int TIPO_MULTIPLICAR_PV = 33;
    static final public int TIPO_SUMAR_PP = 34;
    static final public int TIPO_MULTIPLICAR_PP = 35;
    static final public int TIPO_MULTIPLICAR_PV_DAÑO = 36;
    static final public int TIPO_DIVIDIR_PV_DAÑO = 37;
    static final public int TIPO_ACTIVAR_EXTREMIDAD = 38;
    static final public int TIPO_ACEL_CURA_EXTREMIDAD = 39;
    static final public int TIPO_LEVANTARSE = 40;
    
    
    static final public int TIPO_CAMBIO_ARMADURA = 50;

    
    
    public Efecto() {
        activo = true;
    }

    private int tipo;
    private int duracion;
    private int value;
    private boolean activo = true;

    private boolean regeneracion_progresiva = false;
    private int transcurso = -1;    

    public void avanzarAsalto(int asa){
        transcurso+= asa;
        if (transcurso >= duracion){
            transcurso = duracion;
            activo = false;
        }
            
    }
    
    public int getCuantoMasDura(){
        int res = duracion - transcurso;
        return (res <0)? 0 : res;
    }
    
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getValue() {
        return value;
    }
    
    public int getValueActual() {
        if (regeneracion_progresiva)             
            return value - (value / duracion)*transcurso;
        else return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRegeneracion_progresiva() {
        return regeneracion_progresiva;
    }

    public void setRegeneracion_progresiva(boolean regeneracion_progresiva) {
        this.regeneracion_progresiva = regeneracion_progresiva;
    }

    public int getTranscurso() {
        return transcurso;
    }

    public void setTranscurso(int transcurso) {
        this.transcurso = transcurso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    
    
}
