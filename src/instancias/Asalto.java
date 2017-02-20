/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.io.Serializable;
import java.util.HashSet;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Juan
 */
@XmlType
public class Asalto  implements Serializable{

    public static HashSet<Accion> Acciones = new HashSet<Accion>();

    public Asalto() {
    }

    
    
    void agregarAccion(Accion acc) {

        Acciones.add(acc);
    }

    public static HashSet<Accion> getAcciones() {
        return Acciones;
    }

    public void resolver() {

        for (Accion play : Acciones) {
            //play.resolverAtaque();
        }

    }
     
}