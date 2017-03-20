/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.Sortilegios;

import recursos.Constantes;

/**
 *
 * @author TiranoJuan
 */
public class DuracionSortilegio {

    public static final int TIPO_DURACION_INSTANTE = 0;
    public static final int TIPO_DURACION_CONCENTRACION = 1;
    public static final int TIPO_DURACION_ASALTOS = 2;
    public static final int TIPO_DURACION_MINUTOS = 3;
    public static final int TIPO_DURACION_HORAS = 4;
    public static final int TIPO_DURACION_DIAS = 5;
    public static final int TIPO_DURACION_SEMANAS = 6;
    public static final int TIPO_DURACION_PERMANENTE = 7;
    public static final int TIPO_DURACION_VARIA = 8;

    public static final int TIPO_MULTIPLICADOR_FIJO = 0;
    public static final int TIPO_MULTIPLICADOR_NIVEL = 1;
    public static final int TIPO_MULTIPLICADOR_5FALLO = 2;
    public static final int TIPO_MULTIPLICADOR_10FALLO = 3;

    public static String txtTipo(int tipo) {

        switch (tipo) {
            case TIPO_DURACION_CONCENTRACION: {
                return "C";
            }
            case TIPO_DURACION_ASALTOS: {
                return "As";
            }
            case TIPO_DURACION_MINUTOS: {
                return "Min.";
            }
            case TIPO_DURACION_HORAS: {
                return "Hs.";
            }
            case TIPO_DURACION_DIAS: {
                return "Dias";
            }
            case TIPO_DURACION_SEMANAS: {
                return "Sem.";
            }
            case TIPO_DURACION_PERMANENTE: {
                return "P";
            }
            case TIPO_DURACION_VARIA: {
                return "Varia";
            }
            default: {
                return "";
            }
        }

    }

    public static String txtTipoMultiplicador(int tipo) {

        switch (tipo) {
            case TIPO_MULTIPLICADOR_FIJO: {
                return "Fijo";
            }
            case TIPO_MULTIPLICADOR_NIVEL: {
                return "Nv";
            }
            case TIPO_MULTIPLICADOR_5FALLO: {
                return "5Fallo";
            }
            case TIPO_MULTIPLICADOR_10FALLO: {
                return "10Fallo.";
            }
            default: {
                return "";
            }
        }

    }

    private int tipo_duracion;
    private int multiplicador;
    private int unidad;

    public DuracionSortilegio() {
    }

    public DuracionSortilegio(int tipo_duracion, int multiplicador, int value) {
        this.tipo_duracion = tipo_duracion;
        this.multiplicador = multiplicador;
        this.unidad = value;
    }

    public int getTipo_duracion() {
        return tipo_duracion;
    }

    public int duracionFinal(int v) {
        int d = unidad * v;
        if (tipo_duracion > TIPO_DURACION_CONCENTRACION && tipo_duracion < TIPO_DURACION_PERMANENTE) {
            return 1;
        } else {
            if (tipo_duracion == TIPO_DURACION_ASALTOS) {
                return d;
            }
            if (tipo_duracion == TIPO_DURACION_MINUTOS) {
                return recursos.Recursos.tiempoEnAsaltosParse(d, Constantes.TIEMPO_MINUTOS);
            }
            if (tipo_duracion == TIPO_DURACION_HORAS) {
                return recursos.Recursos.tiempoEnAsaltosParse(d, Constantes.TIEMPO_HORAS);
            }
            if (tipo_duracion == TIPO_DURACION_DIAS) {
                return recursos.Recursos.tiempoEnAsaltosParse(d, Constantes.TIEMPO_DIAS);
            }
            if (tipo_duracion == TIPO_DURACION_SEMANAS) {
                return recursos.Recursos.tiempoEnAsaltosParse(d, Constantes.TIEMPO_SEMANAS);
            } else {
                return d;
            }
        }
    }

    public void setTipo_duracion(int tipo_duracion) {
        this.tipo_duracion = tipo_duracion;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

}
