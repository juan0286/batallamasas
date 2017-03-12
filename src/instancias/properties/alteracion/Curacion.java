/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties.alteracion;

import instancias.properties.alteracion.Alteracion;

/**
 *
 * @author TiranoJuan
 */
public class Curacion extends Alteracion {

    int pvRecuperados;
    private int cuerpoEstado = -1;

    public Curacion() {
    }

    public int getPvRecuperados() {
        return pvRecuperados;
    }

    public void setPvRecuperados(int pvRecuperados) {
        this.pvRecuperados = pvRecuperados;
    }

    public int getCuerpoEstado() {
        return cuerpoEstado;
    }

    public void setCuerpoEstado(int cuerpoEstado) {
        this.cuerpoEstado = cuerpoEstado;
    }

}
