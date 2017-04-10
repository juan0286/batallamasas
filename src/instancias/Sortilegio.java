/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import instancias.Sortilegios.*;
import instancias.properties.alteracion.Alteracion;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;
import recursos.Constantes;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class Sortilegio implements Serializable {

    public static final int CLASE_ELEMENTAL = 0;
    public static final int CLASE_ELEMENTAL_BOLA = 1;
    public static final int CLASE_ELEMENTAL_DIRIGIDO = 2;
    public static final int CLASE_FUERZA = 3;
    public static final int CLASE_PASIVO = 4;
    public static final int CLASE_UTILIDAD = 5;
    public static final int CLASE_INFORMACION = 6;

    private int id;
    private int lv;
    private String nombre;
    private int dominio;
    private String Descp;
    private int duracoinAs;
    private String profesion;
    private int lista;
    private boolean consumePP;
    private boolean regeneraPorDia;
    private int vecesRegeneraPorDia;

    private int clase;
    private Alteracion efectoMagico;
    private DuracionSortilegio duracion;
    private AlcanceSortilegio alcance;
    private AreaDeEfectoSortilegio areaDeEfecto;

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

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return nombre + " (lv " + lv + ")";
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

    public int getVecesRegeneraPorDia() {
        return vecesRegeneraPorDia;
    }

    public void setVecesRegeneraPorDia(int vecesRegeneraPorDia) {
        this.vecesRegeneraPorDia = vecesRegeneraPorDia;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public Alteracion getEfectoMagico() {
        return efectoMagico;
    }

    public void setEfectoMagico(Alteracion efectoMagico) {
        this.efectoMagico = efectoMagico;
    }

    public DuracionSortilegio getDuracion() {
        return duracion;
    }

    public void setDuracion(DuracionSortilegio duracion) {
        this.duracion = duracion;
    }

    public AlcanceSortilegio getAlcance() {
        return alcance;
    }

    public void setAlcance(AlcanceSortilegio alcance) {
        this.alcance = alcance;
    }

    public AreaDeEfectoSortilegio getAreaDeEfecto() {
        return areaDeEfecto;
    }

    public void setAreaDeEfecto(AreaDeEfectoSortilegio areaDeEfecto) {
        this.areaDeEfecto = areaDeEfecto;
    }

    public String getDominioStr() {
        if (dominio == Constantes.DOMINIO_CANALIZACION) {
            return "Canalizacion";
        }
        if (dominio == Constantes.DOMINIO_ESCENCIA) {
            return "Escencia";
        } else if (dominio == Constantes.DOMINIO_MENTALISMO) {
            return "Mentalismo";
        } else {
            return "Arcano";
        }
    }

    public String getClaseStr() {
        if (clase == CLASE_ELEMENTAL) {
            return "Elmental";
        }
        if (clase == CLASE_ELEMENTAL_BOLA) {
            return "Elmental Bola";
        }
        if (clase == CLASE_ELEMENTAL_DIRIGIDO) {
            return "Elmental Dirigido";
        }
        if (clase == CLASE_FUERZA) {
            return "Fuerza";
        }
        if (clase == CLASE_INFORMACION) {
            return "Informacion";
        }
        if (clase == CLASE_PASIVO) {
            return "Pasivo";
        }
        if (clase == CLASE_UTILIDAD) {
            return "Utilidad";
        } else {
            return "";
        }
    }

}
