/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.io.Serializable;

/**
 *
 * @author TiranoJuan
 */
public class Bo implements Serializable {

    private int tipo;
    private int value;

    public int atacarCon(int bo) {

        int bd = 0;
        switch (tipo) {
            case 0: {
                bd = value - bo;
                break;
            }
            case 1: {
                bd = (value - bo)/2;
                break;
            }
            case 2: {
                break;
            }
            default: {

            }
        }    
        return bd;
    }
}
