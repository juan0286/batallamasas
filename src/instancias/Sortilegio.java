/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.io.Serializable;

/**
 *
 * @author TiranoJuan
 */
public class Sortilegio implements Serializable{
    
    
    private int lv;
    private String nombre;
    private String dominio;
    private String Descp;
    private String alcance;
    private String duracion;
    private int duracoinAs;
    private String profesion;
    private String lista;

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

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
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
        return nombre + "(lv "+lv+")";
    }
    
    
    
}
