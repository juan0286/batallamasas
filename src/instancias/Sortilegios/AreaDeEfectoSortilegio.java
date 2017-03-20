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
public class AreaDeEfectoSortilegio {

    
    public static final int TIPO_MULTIPLICADOR_FIJO = 0;
    public static final int TIPO_MULTIPLICADOR_NIVEL = 1;
    
    private String descp;
    private int multiplicador;
    private int unidad;

    public AreaDeEfectoSortilegio() {
    }

    public AreaDeEfectoSortilegio(String descp, int multiplicador, int value) {
        this.descp = descp;
        this.multiplicador = multiplicador;
        this.unidad = value;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
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
