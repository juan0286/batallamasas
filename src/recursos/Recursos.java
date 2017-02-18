/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import com.csvreader.CsvReader;
import instancias.Accion;
import instancias.Evento;
import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Status;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

/**
 *
 * @author Juan
 */
public class Recursos {

    public static ArrayList<Token> soldados = new ArrayList<Token>();
    //public static ArrayList<Token> soldadosD = new ArrayList<Token>();

    public static boolean imprimirPorConsola = false;
    private static final String dirAvatars= "avatars\\";
    
    public static HashMap<String, HashMap> tablasDaño = new HashMap();
    public static HashMap<String, HashMap> tablasCritico = new HashMap();

    public static ArrayList<String> grupos = new ArrayList<String>();
    public static ArrayList<Arma> armeria = new ArrayList<Arma>();

    public static ArrayList<String> nombres = new ArrayList<String>();

    private static HashMap<String, String> tabCrticsArray = tabCrticsArray();

    public static HashMap<String, String> tabCrticsArray() {
        HashMap<String, String> tCArray = new HashMap<>();
        tCArray.put("S", "Corte");
        tCArray.put("K", "Aplastamiento");
        tCArray.put("P", "Penetracion");
        tCArray.put("G", "Presa");
        tCArray.put("T", "Diminuto");
        tCArray.put("U", "Desequilibrio");

        return tCArray;
    }

    public static final HashMap<Integer, String> armasTablas = new HashMap<Integer, String>() {
        {
            put(1, "ataqueAlfanje");
            put(2, "ataqueArcoCorto");
            put(3, "ataqueArcoLargo");
            put(4, "ataqueBaston");
            put(5, "ataqueCimitarra");
            put(6, "ataqueDaga");
            put(7, "ataqueEspadaAncha");
            put(8, "ataqueEspadaCorta");
            put(9, "ataqueEspadon");
            put(10, "ataqueGarrote");
            put(11, "ataqueHacha");
            put(12, "ataqueLanza");
            put(13, "ataqueMaza");
            put(14, "ataqueLanzaCaballeria");
            put(15, "ataqueRompeCabezas");
        }
    };

    // ayudas
    public static int dadoAbiertoArriba() {
        int dado = aleatorioEntre(1, 100);
        int dadoT = dado;
        while (dado > 95) {
            dadoT += dado;
            dado = aleatorioEntre(1, 100);
        }
        return dadoT;
    }

    public static int aleatorioEntre(int max, int min) {
        return (int) (Math.random() * (max - min) + min);
    }

    public static Object aleatorioDe(ArrayList lista) {

        return lista.get(aleatorioEntre(0, lista.size() - 1));
    }

    public static boolean posibilidad(int porciento) {
        int numero = aleatorioEntre(1, 100);
        return (porciento >= numero);
    }

    public static int porcentajeDe(int porc, int total) {

        return (int) ((float) total / 100.0 * porc);
    }

    private static boolean isNumeric(char caracter) {
        try {
            Integer.parseInt(String.valueOf(caracter));
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static String[] separarNumerosDeLetras(String daño) {
        String numerosLetras[] = new String[2];
        numerosLetras[0] = "";
        numerosLetras[1] = "";
        for (short indice = 0; indice < daño.length(); indice++) {
            char caracter = daño.charAt(indice);
            if (isNumeric(caracter)) {
                numerosLetras[0] += caracter;
            } else {
                numerosLetras[1] += caracter;
            }
        }
        return numerosLetras;
    }

    public static void sout(String txt, int extra) {

        if (Recursos.imprimirPorConsola) {
            System.out.println(txt);
        }
        if (extra == 0) {
            System.out.println("-------------------------");
        }
        if (extra == 1) {
            System.out.println("\n");
        }
        System.out.println(txt);
    }

    // referido a tablas
    public static void verTabla(HashMap<String, HashMap> tabla) {
        for (Map.Entry<String, HashMap> entrySet : tabla.entrySet()) {
            String tablaName = entrySet.getKey();
            HashMap<String, String> mapValores = entrySet.getValue();
            System.out.println("Tabla: " + tablaName + " -> ");

            for (Map.Entry<String, String> entrySet1 : mapValores.entrySet()) {
                String num = entrySet1.getKey();
                String valor = entrySet1.getValue();
                System.out.println("Numero: " + num + " -> " + valor);
            }

        }
    }

    public static void informar(String mensaje) {

        JOptionPane.showMessageDialog(null, mensaje, "IMPORTANTE", JOptionPane.WARNING_MESSAGE);
        System.out.println("Aviso:   " + mensaje);
    }

    private static String tipoCritico(String codeCrit) {
        String letra = "S";
        for (Map.Entry<String, String> entrySet : tabCrticsArray.entrySet()) {
            String key = entrySet.getKey();
            if (codeCrit.contains(key)) {
                letra = key;
                break;
            }
        }
        return tabCrticsArray.get(letra);

    }

    public static Critico textoCritico(String cod, int num) {
        int aux = 1;
        if (num == 66) {
            aux = 11;
        } else if (num == 100) {
            aux = 18;
        } else {
            for (int n = 1; n < 100; n++) {
                //System.out.println("n es "+n);
                aux = (n % 5 == 0) ? (aux + 1) : aux;
                // System.out.println("aux es "+aux);
                if (num == n) {
                    break;
                }
            }
            System.out.println("Fin");
        }

        String CriticoEn = tipoCritico(cod);
        String tablaCritica = "critico" + CriticoEn;
        HashMap tabla = tablasCritico.get(tablaCritica);
        if (tabla == null) {
            Recursos.informar("No se encontro la tabla de tipo " + tablaCritica);
        }
        String txtCritico = (String) tabla.get(aux + "-" + cod);
        txtCritico = (txtCritico == null) ? "" : txtCritico;
        Critico c = null;
        if (txtCritico != null) {
            c = new Critico(txtCritico);
        } else {
            Recursos.informar("El codigo no existe en la tabla" + tablaCritica);
        }
        return c;
    }

    public static void dañarConCritico(String txtCritic, Token golpeado) {

    }

    public static String[] darResultadoGolpe(String tablaArmaName, String valor) {
        String dañoUnido = "0";
        HashMap<String, String> tablaActual = tablasDaño.get(tablaArmaName);
        if (tablaActual == null) {

            Recursos.informar("No esta cargada la tabla para el Arma con la que golpea el personaje");

        } else {
            dañoUnido = tablaActual.get(valor);
        }

        return separarNumerosDeLetras(dañoUnido);
    }

    private static String textoEstado(int v) {
        String ret = "";
        switch (v) {
            case Status.FIRME: {
                ret = "Firme";
                break;
            }
            case Status.CANSADO: {
                ret = "Cansado";
                break;
            }
            case Status.EXHAUSTO: {
                ret = "Exhasuto";
                break;
            }
            case Status.INCOSCIENTE: {
                ret = "Inconsciente";
                break;
            }
            case Status.MUERTO: {
                ret = "Muerto";
                break;
            }
            default: {
                ret = "Indescripto";
            }

        }
        return ret;
    }

    public static Vector ObjSoldado(Token sold) {
        Vector obj = new Vector();
        JProgressBar jpg = new JProgressBar(0, sold.getHabilidades().getPuntosVida());
        jpg.setValue(sold.getPuntosVida());
        jpg.setStringPainted(true);
        jpg.setString("" + sold.getPuntosVida());

        obj.add(sold);
        obj.add(sold.getGrupo());
        obj.add(textoEstado(sold.getEstado().getCuerpo()));
        obj.add(jpg);
        obj.add(true);
        obj.add(new JButton("Atacar"));
        return obj;
    }

    public static Vector objetoSoldadosstatic(boolean lado) {

        Vector obj = new Vector();
        for (int i = 0; i < soldados.size(); i++) {
            Token sold = soldados.get(i);
            if (sold.isLadoIzquierdo() == lado) {
                JProgressBar jpg = new JProgressBar(0, sold.getHabilidades().getPuntosVida());
                jpg.setValue(sold.getPuntosVida());
                jpg.setStringPainted(true);
                jpg.setString("" + sold.getPuntosVida());
                obj.add(ObjSoldado(sold));
            }
        }
        return obj;
    }

    public static String evtAsaltoNuevo(int asa) {
        return "<br/><br/><Strong> Asalto " + asa + "</strong><br/><hr/>";
    }

    public static String evtFinDeAsalto() {
        return "<br/><hr/><Strong>Fin del Asalto</strong><br/><hr/>";
    }

    public static String evtAccion(Accion acc, Token tok) {
        String ret = "<br/><blockquote>";
        ret += "<span color='"+tok.getHexaColor()+"'> " + tok.getNombre()+" <span>";

        switch (acc.getTipo()) {
            case Accion.TIPO_SIN_ACCION: {
                ret += "";
                break;
            }
            case Accion.TIPO_CARGA_SORTILEGIO: {
                ret += " <span> Carga sortilegio " + acc.getSortilegio();
                break;
            }
            case Accion.TIPO_REALIZA_SORTILEGIO: {
                ret += " <span> Lanza sortilegio " + acc.getSortilegio();
                break;
            }
            case Accion.TIPO_DISPARA_PROYECTIL: {
                ret +=" <span> Dispara Proyectil ";
                break;
            }
            case Accion.TIPO_CARGA_PROYECTIL: {
                ret +=" <span> Carga un Proyectil";
                break;
            }
            case Accion.TIPO_PARAR_PROYECTIL: {
                ret +=" <span> Para un proyectil";
                break;
            }
            case Accion.TIPO_MOVIMIENTO_Y_MANIOBRA: {
                ret += " <span> Movimiento y Maniobra  " + acc.getDificultad();
                break;
            }
            case Accion.TIPO_ATAQUE_CUERPO_A_CUERPO: {
                ret += " <span> Ataque Cuerpo a Cuperpo ";
                break;
            }
            case Accion.TIPO_DESPLAZAMIENTO: {
                ret += " <span> Desplazamiento ";
                break;
            }
            case Accion.TIPO_MOVIMIENTO_ESTATICO: {
                ret += " <span> Movimiento Estatico ";
                break;
            }
            default: {
                ret += "";
                break;
            }
        }
        return ret+"</blockquote>";
    }

    public static String evtOportunidad(Token tok){
        String ret = "<br/><blockquote>";
        ret += "<span color='"+tok.getHexaColor()+"'> " + tok.getNombre()+" <span>";
        return ret + " espera una oportunidad para realizar su acción</blockquote>";
    }
    public static File copiarIcono(File origen, String name)  {
        boolean res = false;
        File destino = new File(newPathFor(origen,name));

        OutputStream out;
        try {
            InputStream in = new FileInputStream(origen);
            out = new FileOutputStream(destino);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            res = true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
            Recursos.sout("Fallo la copia del icono", 0);
            Recursos.informar("No se pudo cargar el icono en " + origen.toString());
            
        } catch (IOException ex){
        Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
            Recursos.sout("Fallo la copia del icono", 0);
            Recursos.informar("No se pudo cargar el icono en " + origen.toString());
           
        }
        return (res) ? destino : null;
    }
    
    private static String newPathFor(File f, String name){
        return dirAvatars + name + "." + getFileExtension(f);
    }
    
    private static String getFileExtension(File file) {
    String name = file.getName();
    try {
        return name.substring(name.lastIndexOf(".") + 1);
    } catch (Exception e) {
        return "";
    }
}
}
