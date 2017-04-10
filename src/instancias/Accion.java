/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.io.Serializable;
import java.util.Map;
import javax.xml.bind.annotation.XmlType;
import recursos.Constantes;
import superrolbattle.Principal;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class Accion implements Serializable {

    private int tipo;
    private int orden;
    private int nro_Asalto;
    private boolean done = false;
    private boolean accionDeOportunidad = false;
    private boolean cambioDeAccion = false;
    //private Sortilegio sortilegio;
    private int id_sortilegio_a_realizar; 
    private String Dificultad;
    private int id_sort_intencion;
    private String Descp;
    private String fullDescp;

    private int marcha;
    
    
    
    public Accion(int tipo, int nro_Asalto, int orden) {
        this.tipo = tipo;
        this.nro_Asalto = nro_Asalto;
        this.orden = orden;
        this.Descp = "";
    }

    public Accion() {
        this.Descp = "";
    }

    public int getId_sortilegio_a_realizar() {
        return id_sortilegio_a_realizar;
    }
    
    public Sortilegio get_sortilegio_a_realizar() {
        return Principal.getSortilegioById(id_sortilegio_a_realizar);
    }

    public void setId_sortilegio_a_realizar(int id_sortilegio_a_realizar) {
        this.id_sortilegio_a_realizar = id_sortilegio_a_realizar;
    }

    
    
    public String getDificultad() {
        return Dificultad;
    }

    public void setDificultad(String Dificultad) {
        this.Dificultad = Dificultad;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getNro_Asalto() {
        return nro_Asalto;
    }

    public void setNro_Asalto(int nro_Asalto) {
        this.nro_Asalto = nro_Asalto;
    }

    public void hecho(int tipo) {
        if (!done) {
            this.done = true;
            this.accionDeOportunidad = false;
            this.setTipo(tipo);
        }
    }

    public void desHecho() {
        this.done = false;
    }

    public void cambioDeAccion(int tipo) {
        cambioDeAccion = true;
        this.tipo = tipo;
    }

    public void esperarOportunidad() {
        if (!done) {
            this.accionDeOportunidad = true;
        }
    }

    public boolean isDone() {
        return done;
    }

    public boolean isAccionDeOportunidad() {
        return accionDeOportunidad;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getId_sort_intencion() {
        return id_sort_intencion;
    }
    public Sortilegio get_sort_intencion() {
        return Principal.getSortilegioById(id_sort_intencion);
    }
    
    

    public void setId_sort_intencion(int id_sort_intencion) {
        this.id_sort_intencion = id_sort_intencion;
    }

    public boolean isCambioDeAccion() {
        return cambioDeAccion;
    }

    public void setCambioDeAccion(boolean cambioDeAccion) {
        this.cambioDeAccion = cambioDeAccion;
    }

    public String getDescp() {
        return Descp;
    }

    public void setDescp(String Descp) {
        this.Descp = Descp;
    }

    public String getFullDescp() {
        return fullDescp;
    }

    public void setFullDescp(String fullDescp) {
        this.fullDescp = fullDescp;
    }

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public static boolean isRealizableAturdido(int tipo) {

        if (tipo == Constantes.TIPO_ACCION_SIN_ACCION) {
            return true;
        }
        if (tipo == Constantes.TIPO_ACCION_REALIZA_SORTILEGIO) {
            recursos.Recursos.informar("El sortilegio del Pj Atudido debe ayudarlo a salir del estado");
            return true;
        }
        if (tipo == Constantes.TIPO_ACCION_PARAR_PROYECTIL) {
            return true;
        }
        if (tipo == Constantes.TIPO_ACCION_DESPLAZAMIENTO) {
            return true;
        }
        if (tipo == Constantes.TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO) {
            return true;
        }
        if (tipo == Constantes.TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA) {
            return true;
        } else {
            return false;
        }

    }

}
