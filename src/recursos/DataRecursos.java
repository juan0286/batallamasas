/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import instancias.ListaDeSortilegios;
import instancias.Sortilegio;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */
@XmlRootElement
public class DataRecursos implements Serializable {

    private HashMap<Integer, Sortilegio> SortilegiosSueltos;
    private HashMap<Integer, ListaDeSortilegios> ListasDeSortilegios;

    public static final String CONFIG_FILE = "config.ini";
    private String url_data;
    private String dir_avatars;
    private String directorio_default;

    public DataRecursos() {

        url_data = "Data\\";
        dir_avatars = "Avatars\\";
        directorio_default = "";
        SortilegiosSueltos = new HashMap<Integer, Sortilegio>();
        ListasDeSortilegios = new HashMap<Integer, ListaDeSortilegios>();
    }

    public HashMap<Integer, Sortilegio> getSortilegiosSueltos() {
        return SortilegiosSueltos;
    }

    public void setSortilegiosSueltos(HashMap<Integer, Sortilegio> SortilegiosSueltos) {
        this.SortilegiosSueltos = SortilegiosSueltos;
    }

    public HashMap<Integer, ListaDeSortilegios> getListasDeSortilegios() {
        return ListasDeSortilegios;
    }

    public void setListasDeSortilegios(HashMap<Integer, ListaDeSortilegios> ListasDeSortilegios) {
        this.ListasDeSortilegios = ListasDeSortilegios;
    }

    public String getUrl_data() {
        return url_data;
    }

    public void setUrl_data(String url_data) {
        this.url_data = url_data;
    }

    public String getDir_avatars() {
        return dir_avatars;
    }

    public void setDir_avatars(String dir_avatars) {
        this.dir_avatars = dir_avatars;
    }

    public String getDirectorio_default() {
        return directorio_default;
    }

    public void setDirectorio_default(String directorio_default) {
        this.directorio_default = directorio_default;
    }

}
