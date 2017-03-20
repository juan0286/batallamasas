/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.util.HashMap;
import javax.swing.JOptionPane;
import recursos.Constantes;

/**
 *
 * @author TiranoJuan
 */
public class ListaDeSortilegios {

    public static final int TIPO_LISTA_ABIERTA = 0;
    public static final int TIPO_LISTA_CERRADA = 1;
    public static final int TIPO_LISTA_CERRADA_PROFESION = 2;

    private int id;
    private String nombre;
    private int dominio;
    private int tipo_lista;
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

    public void agregarSortilegio(Sortilegio s) {
        if (lista.containsKey(s.getLv())) {
            int r = JOptionPane.showConfirmDialog(null, "Esta lista ya contiene el sortilegio " + lista.get(s.getLv()).getNombre() + " con este Lv. Desea Reemplazarlo?");
            if (r == JOptionPane.OK_OPTION) {
                lista.put(s.getLv(), s);
            }
        } else {
            lista.put(s.getLv(), s);
        }
    }

    public Sortilegio getSortilegio(int lv){
        return lista.get(lv);
    }
    
    @Override
    public String toString() {
        return nombre + "(" + txtTipoLista(tipo_lista) + ')';
    }

    public static String txtTipoLista(int tipo) {

        switch (tipo) {
            case TIPO_LISTA_ABIERTA: {
                return "Abierta";
            }
            case TIPO_LISTA_CERRADA: {
                return "Cerrada";
            }
            case TIPO_LISTA_CERRADA_PROFESION: {
                return "Profesion";
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
