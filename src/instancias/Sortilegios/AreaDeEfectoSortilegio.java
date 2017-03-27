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
public class AreaDeEfectoSortilegio {

    
    public static final int TIPO_MULTIPLICADOR_FIJO = 0;
    public static final int TIPO_MULTIPLICADOR_NIVEL = 1;
    
    private String descp;
    private int multiplicador;
    private float unidad;

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

    public float getUnidad() {
        return unidad;
    }

    public void setUnidad(float unidad) {
        this.unidad = unidad;
    }
    
    @Override
    public String toString() {
        String r = "";
        if (unidad == 0){
            r= descp;
        } else if (multiplicador == TIPO_MULTIPLICADOR_FIJO){
            r= unidad + descp;
        } else {
            r = unidad + descp + "/lv";
        }
        return r;
    }
}
