/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.Sortilegios;

/**
 *
 * @author TiranoJuan
 */
public class AlcanceSortilegio {

    public static final int TIPO_ALCANCE_UNO_MISMO = 0;
    public static final int TIPO_ALCANCE_CONTACTO = 1;
    public static final int TIPO_ALCANCE_CENTIMETROS = 2;
    public static final int TIPO_ALCANCE_METROS = 3;
    public static final int TIPO_ALCANCE_VARIA = 4;

    public static final int TIPO_MULTIPLICADOR_FIJO = 0;
    public static final int TIPO_MULTIPLICADOR_NIVEL = 1;

     public static String txtTipo(int tipo) {

        switch (tipo) {
            case TIPO_ALCANCE_UNO_MISMO: {
                return "C";
            }
            case TIPO_ALCANCE_CONTACTO: {
                return "As";
            }
            case TIPO_ALCANCE_CENTIMETROS: {
                return "Min.";
            }
            case TIPO_ALCANCE_METROS: {
                return "Hs.";
            }
            case TIPO_ALCANCE_VARIA: {
                return "Hs.";
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
            default: {
                return "";
            }
        }

    }

    
    
    
    
    
    private int tipo_duracion;
    private int multiplicador;
    private int unidad;

    public AlcanceSortilegio() {
    }

    public AlcanceSortilegio(int tipo_duracion, int multiplicador, int value) {
        this.tipo_duracion = tipo_duracion;
        this.multiplicador = multiplicador;
        this.unidad = value;
    }
    
    
    public int alcanceFinal(int v) {        
        int d = (multiplicador == TIPO_MULTIPLICADOR_NIVEL)? unidad * v : unidad;
        return d;
    }
    

    public int getTipo_duracion() {
        return tipo_duracion;
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
