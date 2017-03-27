/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlType;
import recursos.Constantes;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class ListaDeSortilegios {

    public static final int TIPO_LISTA_ABIERTA = 0;
    public static final int TIPO_LISTA_CERRADA = 1;
    public static final int TIPO_LISTA_BASICA_PROFESION = 2;

    private int id;
    private String nombre;
    private int dominio;
    private int tipo_lista;
    private String profesion;
    private HashMap<Integer, Sortilegio> lista;

    public ListaDeSortilegios() {
        lista = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTipo_lista() {
        return tipo_lista;
    }

    public void setTipo_lista(int tipo_lista) {
        this.tipo_lista = tipo_lista;
    }

    public HashMap<Integer, Sortilegio> getLista() {
        return lista;
    }

    public void setLista(HashMap<Integer, Sortilegio> lista) {
        this.lista = lista;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public boolean contineSortilegiodeLv(int lv) {
        return lista.containsKey(lv);
    }

    public void agregarSortilegio(Sortilegio s) {

        lista.put(s.getLv(), s);

    }

    public Sortilegio getSortilegio(int lv) {
        return lista.get(lv);
    }

    public int maxLvSortilegio() {
        SortedSet<Integer> aux = new TreeSet<>(lista.keySet());
        if (aux.size() > 0) {
            return (Integer) aux.last();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        if (tipo_lista != TIPO_LISTA_BASICA_PROFESION) {
            return nombre + " (" + TipoListaString() + " " + getDominioStr(dominio) + ')';
        } else {
            return nombre + " (" + ((profesion != null) ? profesion : "Propias") + ')';
        }
    }

    public String TipoListaString() {

        switch (tipo_lista) {
            case TIPO_LISTA_ABIERTA: {
                return "Abierta";
            }
            case TIPO_LISTA_CERRADA: {
                return "Cerrada";
            }
            case TIPO_LISTA_BASICA_PROFESION: {
                return "Basica de " + profesion;
            }
            default: {
                return "";
            }
        }

    }

    public static String getDominioStr(int dom) {
        if (dom == Constantes.DOMINIO_CANALIZACION) {
            return "Canalizacion";
        }
        if (dom == Constantes.DOMINIO_ESCENCIA) {
            return "Escencia";
        } else {
            return "Mentalismo";
        }
    }

}
