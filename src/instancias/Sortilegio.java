/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class Sortilegio implements Serializable {

    public static final int DOMINIO_CANALIZACION = 0;
    public static final int DOMINIO_ESCENCIA = 1;
    public static final int DOMINIO_MENTALISMO = 2;

    private int id;
    private int lv;
    private String nombre;
    private int dominio;
    private String Descp;
    private String alcance;
    private String duracion;
    private int duracoinAs;
    private String profesion;
    private String lista;
    private boolean consumePP;
    private boolean regeneraPorDia;
    private int veces;

    public Sortilegio(int lv, String nombre) {
        this.lv = lv;
        this.nombre = nombre;
    }

    public Sortilegio() {
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDominio() {
        return dominio;
    }

    public void setDominio(int dominio) {
        this.dominio = dominio;
    }

    public String getDescp() {
        return Descp;
    }

    public void setDescp(String Descp) {
        this.Descp = Descp;
    }

    public String getAlcance() {
        return alcance;
    }

    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getDuracoinAs() {
        return duracoinAs;
    }

    public void setDuracoinAs(int duracoinAs) {
        this.duracoinAs = duracoinAs;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return nombre + "(lv " + lv + ")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isConsumePP() {
        return consumePP;
    }

    public void setConsumePP(boolean consumePP) {
        this.consumePP = consumePP;
    }

    public boolean isRegeneraPorDia() {
        return regeneraPorDia;
    }

    public void setRegeneraPorDia(boolean regeneraPorDia) {
        this.regeneraPorDia = regeneraPorDia;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }

    public String getDominioStr() {
        if (dominio == DOMINIO_CANALIZACION) {
            return "Canalizacion";
        }
        if (dominio == DOMINIO_ESCENCIA) {
            return "Escencia";
        } else {
            return "Mentalismo";
        }
    }

}
