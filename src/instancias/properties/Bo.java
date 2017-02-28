/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;
import recursos.Constantes;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class Bo implements Serializable {

    private int estilo;
    private int value;

    public static final int BO_TIPO_UN_ARMA = 0;
    public static final int BO_TIPO_DOS_ARMAS = 1;
    public static final int BO_TIPO_DOS_MANOS = 2;
    public static final int BO_TIPO_MANOS_DESNUDAS = 3;

    public Bo() {
    }

    public Bo(int tipo, int value) {
        this.estilo = tipo;
        this.value = value;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
    
    
    public int atacarCon(int bo) {

        int bd = 0;
        switch (estilo) {
            case BO_TIPO_UN_ARMA: {
                bd = value - bo;
                break;
            }
            case BO_TIPO_DOS_ARMAS: {
                bd = (value - bo) / 2;
                break;
            }
            case BO_TIPO_DOS_MANOS: {
                break;
            }
            case BO_TIPO_MANOS_DESNUDAS: {
                break;
            }
            default: {

            }
        }
        return bd;
    }

    private String tipoBOStr(){
        if (estilo == Constantes.ESTILO_FILO) {
            return "Filo";
        } else if (estilo == Constantes.ESTILO_CONTUNDENTE) {
            return "Contundente";
        } else if (estilo == Constantes.ESTILO_DOS_MANOS) {
            return "Dos manos";
        } else if (estilo == Constantes.ESTILO_ARROJADIZA) {
            return "Arrojadiza";
        } else if (estilo == Constantes.ESTILO_PROYECTILES) {
            return "Proyectiles";
        } else if (estilo == Constantes.ESTILO_ASTA) {
            return "Asta";
        } else if (estilo == Constantes.ESTILO_PELEA) {
            return "Pelea";
        } else if (estilo == Constantes.ESTILO_BARRIDO_ARTE_MARCIAL) {
            return "Barrido de Arte Marical";
        } else if (estilo == Constantes.ESTILO_GOLPE_ARTE_MARCIAL) {
            return "Golpe Arte Marcial";
        } else if (estilo == Constantes.ESTILO_COMBO_ASTA_FILO) {
            return "Combo Asta Filo";
        } else if (estilo == Constantes.ESTILO_COMBO_FILO_FILO) {
            return "Combo Filo Filo";
        } else return "BO";        
        
    }
    
    
    @Override
    public String toString() {
        return tipoBOStr() + ", Bono=" + value ;
    }
    
    
}
