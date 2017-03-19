/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties.alteracion;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlType;
import recursos.Critico;

/**
 *
 * @author Juan
 */
@XmlType
public class Alteracion {

   
    private boolean activo = true;

    private String descripcion = "";

    private ArrayList<Efecto> efectos = new ArrayList<Efecto>();

    public Alteracion() {
    }
   
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Efecto> getEfectos() {
        return efectos;
    }

    public void setEfectos(ArrayList<Efecto> efectos) {
        this.efectos = efectos;
    }

    public void agregarEfecto(Efecto e){
        this.efectos.add(e);
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        String txt = (descripcion.length() > 0)? descripcion + "- " : "";
        for (Efecto e : efectos) {
            if (e.isActivo()) {                
                txt+= " / " +e.toString();
            }
        }
        return  txt;
    }
    
    
    
}
