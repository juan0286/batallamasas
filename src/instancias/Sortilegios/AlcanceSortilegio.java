/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.Sortilegios;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */
@XmlType
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
                return "Uno Mismo";
            }
            case TIPO_ALCANCE_CONTACTO: {
                return "Contacto";
            }
            case TIPO_ALCANCE_CENTIMETROS: {
                return "Cm..";
            }
            case TIPO_ALCANCE_METROS: {
                return "Mts.";
            }
            case TIPO_ALCANCE_VARIA: {
                return "Varia";
            }
            default: {
                return "";
            }
        }

    }

    public static String txtTipoMultiplicador(int multi) {

        switch (multi) {
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
    
    
    
    private int tipo_alcance;
    private int multiplicador;
    private int unidad;

    public AlcanceSortilegio() {
    }

    public AlcanceSortilegio(int tipo_duracion, int multiplicador, int value) {
        this.tipo_alcance = tipo_duracion;
        this.multiplicador = multiplicador;
        this.unidad = value;
    }
    
    
    public int alcanceFinal(int v) {        
        int d = (multiplicador == TIPO_MULTIPLICADOR_NIVEL)? unidad * v : unidad;
        return d;
    }
    

    public int getTipo_alcance() {
        return tipo_alcance;
    }

    public void setTipo_alcance(int tipo_alcance) {
        this.tipo_alcance = tipo_alcance;
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

    @Override
    public String toString() {
        String r = "";
        if (tipo_alcance == TIPO_ALCANCE_CONTACTO || 
                tipo_alcance == TIPO_ALCANCE_UNO_MISMO || 
                tipo_alcance == TIPO_ALCANCE_VARIA){
            r=txtTipo(tipo_alcance);
        } else {
            r = unidad + txtTipo(tipo_alcance) + ((multiplicador != TIPO_MULTIPLICADOR_FIJO)? "/" + txtTipoMultiplicador(multiplicador) :"");
        }
        return r;
    }
    
    
    
}
