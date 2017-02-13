/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import instancias.properties.Arma;
import java.util.HashSet;

/**
 *
 * @author Juan
 */
public class Asalto {

    public static HashSet<Accion> Acciones = new HashSet<Accion>();

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