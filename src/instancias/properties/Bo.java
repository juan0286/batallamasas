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
public class Bo implements Serializable,Comparable {

    private int estilo;
    private int value;

    public static final int BO_TIPO_UN_ARMA = 0;
    public static final int BO_TIPO_DOS_ARMAS = 1;
    public static final int BO_TIPO_DOS_MANOS = 2;
    public static final int BO_TIPO_MANOS_DESNUDAS = 3;

    public Bo() {
    }

    public Bo(int estilo, int value) {
        this.estilo = estilo;
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
                bd = value - bo;
                break;
            }
            case BO_TIPO_MANOS_DESNUDAS: {
                bd = value - bo;
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
      public int compareTo(Bo otherBo) {
       // return this.id - otherStudent.id ; //result of this operation can overflow
       return (this.value < otherBo.value ) ? -1: (this.value > otherBo.value) ? 1:0 ;

    }

    @Override
    public String toString() {
        return tipoBOStr() + ", Bono=" + value ;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bo other = (Bo) obj;
        if (this.estilo != other.estilo) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public int compareTo(Object otherBo) {
        Bo oBo = (Bo) otherBo;
        return (this.value < oBo.value ) ? -1: (this.value > oBo.value) ? 1:0 ;
    }
    
    
}
