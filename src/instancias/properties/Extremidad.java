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
public class Extremidad {
    
    public static final int MIEMBRO_SUPERIOR_DERECHO = 1;
    public static final int MIEMBRO_SUPERIOR_IZQUIERDO = 2;
    public static final int MIEMBRO_INFERIOR_DERECHO = 3;
    public static final int MIEMBRO_INFERIOR_IZQUIERDO = 4;
    public static final int MIEMBRO_COLA = 5;
    
    
    private boolean util;
    private boolean puedePortarArma;
    private boolean miembroHabil;    
    private int tipo_miembro;
    private Arma armaEquipada = null;
    private ProteccionMiembro prot;

    public Extremidad() {
    }

    public Extremidad(boolean util, boolean puedePortarArma, boolean miembroHabil, int tipo_miembro, ProteccionMiembro prot) {
        this.util = util;
        this.puedePortarArma = puedePortarArma;
        this.miembroHabil = miembroHabil;
        this.tipo_miembro = tipo_miembro;
        this.prot = prot;
    }

    public boolean isUtil() {
        return util;
    }

    public void setUtil(boolean util) {
        this.util = util;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }
    
    public boolean tieneArmaEquipada(){
        return armaEquipada != null;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public boolean isPuedePortarArma() {
        return puedePortarArma;
    }

    public void setPuedePortarArma(boolean puedePortarArma) {
        this.puedePortarArma = puedePortarArma;
    }

    public boolean isMiembroHabil() {
        return miembroHabil;
    }

    public void setMiembroHabil(boolean miembroHabil) {
        this.miembroHabil = miembroHabil;
    }

    public int getTipo_miembro() {
        return tipo_miembro;
    }

    public void setTipo_miembro(int tipo_miembro) {
        this.tipo_miembro = tipo_miembro;
    }

    public ProteccionMiembro getProt() {
        return prot;
    }

    public void setProt(ProteccionMiembro prot) {
        this.prot = prot;
    }
    
    public static String tipoDeMiembroTxt(int tipo_ext) {
        String resp = "";
        
            if (tipo_ext == MIEMBRO_SUPERIOR_DERECHO) {
                resp = "Superior Derecho";
            } else if (tipo_ext == MIEMBRO_INFERIOR_DERECHO) {
                resp = "Inferior Derecho";
            } else if (tipo_ext == MIEMBRO_SUPERIOR_IZQUIERDO) {
                resp = "Superior Izquierdo";
            } else if (tipo_ext == MIEMBRO_INFERIOR_IZQUIERDO) {
                resp = "Inferior Izquierdo";
            }
        
        return resp;
    }
    

    @Override
    public String toString() {
        return Extremidad.tipoDeMiembroTxt(this.tipo_miembro);
    }
    
    
}
