/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import javax.xml.bind.annotation.XmlType;
import recursos.Critico;

/**
 *
 * @author Juan
 */
@XmlType
public class Alteracion {
    
    private int duracion;
    
    private int pv = 0;
    private int sangre = 0;
    
    private int actividad = 0;
    
    private int aturdido = 0;
    private int obligadoparar = 0;
    private int sinpoderparar = 0;
    
    private int asaltosparamorir = 0;
    
    private int trMod = 0;
    private int mmMod = 0;
    private int boMod = 0;
    private int bdMod = 0;
    
    
    
    private String descripcion;
  
    
    public Alteracion(int duracion, int pv) {
        this.duracion = duracion;
        this.pv = pv;
    }

    public Alteracion() {
    }
    
    
    
}
