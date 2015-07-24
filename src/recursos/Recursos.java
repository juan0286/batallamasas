/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import com.csvreader.CsvReader;
import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Status;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
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
       // return (total / 100) * porc;
        return (int) ((float) total / 100.0 *porc);
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

    public static void sout(String txt,int extra) {

        if (Recursos.imprimirPorConsola) {
            System.out.println(txt);
        }
        if (extra == 0){
            System.out.println("-------------------------");
        }
        if (extra == 1){
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
                aux = (n % aux == 0) ? (aux + 1) : aux;
                if (num == n) {
                    break;
                }
            }
        }

        String CriticoEn = tipoCritico(cod);
        String tablaCritica = "critico" + CriticoEn;
        String txtCritico = (String) tablasCritico.get(tablaCritica).get(aux + "-" + cod);
        Critico c = new Critico(txtCritico);
    return c;
    }

    public static void dañarConCritico(String txtCritic, Token golpeado) {

    }

    public static String[] darResultadoGolpe(String tablaArmaName, String valor) {

       
        HashMap<String, String> tablaActual = tablasDaño.get(tablaArmaName);
        String dañoUnido = tablaActual.get(valor);

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

}
