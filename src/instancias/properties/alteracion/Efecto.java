/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties.alteracion;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author TiranoJuan
 */
public class Efecto {

    static final public int TIPO_SANGRADO = 1;
    static final public int TIPO_OBLIGADO_A_PARAR = 2;
    static final public int TIPO_ATURDIDO = 3;
    static final public int TIPO_ATURDIDO_SIN_PARAR = 4;
    static final public int TIPO_RESTAR_PV_TOTAL = 5;
    static final public int TIPO_DIVIDIR_PV_TOTAL = 6;
    static final public int TIPO_DORMIDO = 7;
    static final public int TIPO_DIVIDE_LA_ACTIVIDAD = 8;

    static final public int TIPO_CIERRA_SANGRADO = 10;
    static final public int TIPO_DESATURDIR = 11;
    static final public int TIPO_SUMAR_PV = 12;
    static final public int TIPO_MULTIPLICAR_PV = 13;
    static final public int TIPO_SUMAR_PP = 14;
    static final public int TIPO_MULTIPLICAR_PP = 15;
    static final public int TIPO_MULTIPLICAR_PV_DAÑO = 16;
    static final public int TIPO_DIVIDIR_PV_DAÑO = 17;

    static final public int TIPOS_UNO_A_UNO = 19;

    static final public int TIPO_AUMENTA_ACTIVIDAD = 21;
    static final public int TIPO_AUMENTO_DE_MM = 22;
    static final public int TIPO_AUMENTO_DE_TR = 23;
    static final public int TIPO_AUMENTO_DE_BO = 24;
    static final public int TIPO_AUMENTO_DE_BO_FILO = 25;
    static final public int TIPO_AUMENTO_DE_BO_CONTUNDENTE = 26;
    static final public int TIPO_AUMENTO_DE_BO_DOS_MANOS = 27;
    static final public int TIPO_AUMENTO_DE_BO_PROYECTILES = 28;
    static final public int TIPO_AUMENTO_DE_BO_ASTA = 29;
    static final public int TIPO_AUMENTO_DE_BD = 30;

    static final public int TIPO_RESTA_DE_ACTIVIDAD = 33;
    static final public int TIPO_RESTA_DE_MM = 34;
    static final public int TIPO_RESTA_DE_BO = 35;
    static final public int TIPO_RESTA_DE_BD = 36;
    static final public int TIPO_RESTA_DE_TR = 37;

    static final public int TIPOS_CINCO_A_CINCO = 39;

    static final public int TIPO_LEVANTARSE = 41;
    static final public int TIPO_POSTRADO = 42;

    static final public int TIPOS_SOLO_UNO = 44;

    static final public int TIPO_DESACTIVAR_EXTREMIDAD = 46;
    static final public int TIPO_ACTIVAR_EXTREMIDAD = 47;
    static final public int TIPO_ACEL_CURA_EXTREMIDAD = 48;

    static final public int TIPOS_EXTREMIDAD = 50;

    static final public int TIPO_CAMBIO_ARMADURA = 56;

    public static HashMap<Integer, String> txt_heridas() {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(TIPO_SANGRADO, "Sangrado");

        hm.put(TIPO_SANGRADO, "Sangrado");
        hm.put(TIPO_OBLIGADO_A_PARAR, "Obligado a parar");
        hm.put(TIPO_ATURDIDO, "Aturdido");
        hm.put(TIPO_ATURDIDO_SIN_PARAR, "Aturdido sin poder parar");
        hm.put(TIPO_RESTA_DE_ACTIVIDAD, "Resta Actividad");
        hm.put(TIPO_RESTA_DE_MM, "Resta Mov. y Man.");
        hm.put(TIPO_RESTA_DE_BO, "Resta de BO");
        hm.put(TIPO_RESTA_DE_BD, "Resta de BD");
        hm.put(TIPO_RESTA_DE_TR, "Resta de TR");
        hm.put(TIPO_DESACTIVAR_EXTREMIDAD, "Inhabilitar Extremidad");
        hm.put(TIPO_RESTAR_PV_TOTAL, "Resta de Pv total");
        hm.put(TIPO_DIVIDIR_PV_TOTAL, "Divide los Pv Total");
        hm.put(TIPO_DORMIDO, "Dormido");
        hm.put(TIPO_DIVIDE_LA_ACTIVIDAD, "Dividir Actividad");
        hm.put(TIPO_POSTRADO, "Dejar Postrado");

        return hm;
    }

    public static ArrayList<Efecto> todosLosEfectos() {

        ArrayList<Efecto> efs = new ArrayList<Efecto>();

        efs.add(new Efecto(TIPO_SANGRADO));
        efs.add(new Efecto(TIPO_OBLIGADO_A_PARAR));
        efs.add(new Efecto(TIPO_ATURDIDO));
        efs.add(new Efecto(TIPO_ATURDIDO_SIN_PARAR));
        efs.add(new Efecto(TIPO_RESTAR_PV_TOTAL));
        efs.add(new Efecto(TIPO_DIVIDIR_PV_TOTAL));
        efs.add(new Efecto(TIPO_DORMIDO));
        efs.add(new Efecto(TIPO_DIVIDE_LA_ACTIVIDAD));

        efs.add(new Efecto(TIPO_CIERRA_SANGRADO));
        efs.add(new Efecto(TIPO_DESATURDIR));
        efs.add(new Efecto(TIPO_SUMAR_PV));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PV));
        efs.add(new Efecto(TIPO_SUMAR_PP));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PP));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PV_DAÑO));
        efs.add(new Efecto(TIPO_DIVIDIR_PV_DAÑO));

        efs.add(new Efecto(TIPO_AUMENTA_ACTIVIDAD));
        efs.add(new Efecto(TIPO_AUMENTO_DE_MM));
        efs.add(new Efecto(TIPO_AUMENTO_DE_TR));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_FILO));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_CONTUNDENTE));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_DOS_MANOS));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_PROYECTILES));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_ASTA));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BD));

        efs.add(new Efecto(TIPO_RESTA_DE_ACTIVIDAD));
        efs.add(new Efecto(TIPO_RESTA_DE_MM));
        efs.add(new Efecto(TIPO_RESTA_DE_BO));
        efs.add(new Efecto(TIPO_RESTA_DE_BD));
        efs.add(new Efecto(TIPO_RESTA_DE_TR));

        efs.add(new Efecto(TIPO_LEVANTARSE));
        efs.add(new Efecto(TIPO_POSTRADO));

        efs.add(new Efecto(TIPO_DESACTIVAR_EXTREMIDAD));
        efs.add(new Efecto(TIPO_ACTIVAR_EXTREMIDAD));
        efs.add(new Efecto(TIPO_ACEL_CURA_EXTREMIDAD));

        return efs;
    }

    public static ArrayList<Efecto> todosLosEfectosCurativos() {

        ArrayList<Efecto> efs = new ArrayList<Efecto>();

        efs.add(new Efecto(TIPO_CIERRA_SANGRADO));
        efs.add(new Efecto(TIPO_DESATURDIR));
        efs.add(new Efecto(TIPO_SUMAR_PV));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PV));
        efs.add(new Efecto(TIPO_SUMAR_PP));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PP));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PV_DAÑO));
        efs.add(new Efecto(TIPO_DIVIDIR_PV_DAÑO));

        efs.add(new Efecto(TIPO_AUMENTA_ACTIVIDAD));
        efs.add(new Efecto(TIPO_AUMENTO_DE_MM));
        efs.add(new Efecto(TIPO_AUMENTO_DE_TR));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_FILO));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_CONTUNDENTE));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_DOS_MANOS));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_PROYECTILES));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_ASTA));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BD));

        efs.add(new Efecto(TIPO_LEVANTARSE));

        efs.add(new Efecto(TIPO_ACTIVAR_EXTREMIDAD));
        efs.add(new Efecto(TIPO_ACEL_CURA_EXTREMIDAD));

        return efs;
    }

    public static ArrayList<Efecto> todosLosEfectosDeHeridas() {

        ArrayList<Efecto> efs = new ArrayList<Efecto>();

        efs.add(new Efecto(TIPO_SANGRADO));
        efs.add(new Efecto(TIPO_OBLIGADO_A_PARAR));
        efs.add(new Efecto(TIPO_ATURDIDO));
        efs.add(new Efecto(TIPO_ATURDIDO_SIN_PARAR));
        efs.add(new Efecto(TIPO_RESTAR_PV_TOTAL));
        efs.add(new Efecto(TIPO_DIVIDIR_PV_TOTAL));
        efs.add(new Efecto(TIPO_DORMIDO));
        efs.add(new Efecto(TIPO_DIVIDE_LA_ACTIVIDAD));

        efs.add(new Efecto(TIPO_RESTA_DE_ACTIVIDAD));
        efs.add(new Efecto(TIPO_RESTA_DE_MM));
        efs.add(new Efecto(TIPO_RESTA_DE_BO));
        efs.add(new Efecto(TIPO_RESTA_DE_BD));
        efs.add(new Efecto(TIPO_RESTA_DE_TR));

        efs.add(new Efecto(TIPO_POSTRADO));

        efs.add(new Efecto(TIPO_DESACTIVAR_EXTREMIDAD));

        return efs;
    }

    public Efecto() {
        activo = true;
    }

    private int tipo;
    private int duracion;
    private int value;
    private boolean activo = true;

    private boolean regeneracion_progresiva = false;
    private int transcurso = -1;

    private Efecto(int tipo) {
        this.tipo = tipo;
    }

    public void avanzarAsalto(int asa) {
        transcurso += asa;
        if (transcurso >= duracion) {
            transcurso = duracion;
            activo = false;
        }

    }

    public int getCuantoMasDura() {
        int res = duracion - transcurso;
        return (res < 0) ? 0 : res;
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
        if (regeneracion_progresiva) {
            return value - (value / duracion) * transcurso;
        } else {
            return value;
        }
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

    @Override
    public String toString() {
        return Efecto.txt_heridas().get(this.tipo);
    }

}
