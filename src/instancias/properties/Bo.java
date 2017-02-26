/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class Bo implements Serializable {

    private int tipo;
    private int value;

    public static final int BO_TIPO_UN_ARMA = 0;
    public static final int BO_TIPO_DOS_ARMAS = 1;
    public static final int BO_TIPO_DOS_MANOS = 2;
    public static final int BO_TIPO_MANOS_DESNUDAS = 3;

    public Bo() {
    }

    public int atacarCon(int bo) {

        int bd = 0;
        switch (tipo) {
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
}
