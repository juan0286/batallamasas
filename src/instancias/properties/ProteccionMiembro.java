/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */

@XmlType
public class ProteccionMiembro {
    
    private int tipo_proteccion;
    private int resistencia;

    public ProteccionMiembro(int tipo_proteccion, int resistencia) {
        this.tipo_proteccion = tipo_proteccion;
        this.resistencia = resistencia;
    }

    public ProteccionMiembro() {
    }

    public int getTipo_proteccion() {
        return tipo_proteccion;
    }

    public void setTipo_proteccion(int tipo_proteccion) {
        this.tipo_proteccion = tipo_proteccion;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
    
    
}
