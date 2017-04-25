/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import com.csvreader.CsvReader;
import instancias.Accion;
import instancias.Dado;
import instancias.Evento;
import instancias.Sortilegio;
import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Bo;
import instancias.properties.Status;
import java.awt.Color;
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
import superrolbattle.Principal;
import superrolbattle.ventanas.JPanelFormToken_Accion;
import static recursos.Constantes.*;

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
    public static ArrayList<Arma> escudos = new ArrayList<Arma>();

    public static ArrayList<String> nombres = new ArrayList<String>();

    private static HashMap<String, String> tabCrticsArray = tabCrticsArray();

    public static void iniciarConfig() {
        File f = new File(DataRecursos.CONFIG_FILE);
        if (f.exists()) {
            Object o = AbrirGuardar.cargarXML(f.getAbsolutePath(), "DataRecursos");
            Principal.dataRecursos = (DataRecursos) o;

        } else {
            DataRecursos d = new DataRecursos();
            guardarConfig(d);
            Principal.dataRecursos = d;
        }
    }

    public static void guardarConfig(DataRecursos d) {
        AbrirGuardar.guardarXML(d, DataRecursos.CONFIG_FILE);
    }

    public static int maximo(Integer[] arrayn) {
        int max = arrayn[0];

        for (int i = 0; i < arrayn.length; i++) {
            if (max < arrayn[i]) {
                max = arrayn[i];
            }
        }
        return max;
    }

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

        if (lista.size() == 0) {
            return null;
        }
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
        if (Principal.mostrarInformes) {
            JOptionPane.showMessageDialog(null, mensaje, "IMPORTANTE", JOptionPane.WARNING_MESSAGE);
        }
        System.out.println("Aviso:   " + mensaje);
    }

    public static void informar(String mensaje, String Titulo) {
        if (Principal.mostrarInformes) {
            JOptionPane.showMessageDialog(null, mensaje, Titulo, JOptionPane.WARNING_MESSAGE);
        }
        System.out.println(Titulo + "  " + mensaje);
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

    public static int generarCaracteristica(int minimo) {
        Dado d100 = new Dado(100);
        int car = d100.lanzarCerrada();
        int ret = 0;
        while (car < minimo) {
            car = d100.lanzarCerrada();
        }
        if (car < 25) {
            ret -= 5;
        }
        if (car > 74) {
            ret += 5;
        }
        if (car > 89) {
            ret += 5;
        }
        if (car > 94) {
            ret += 5;
        }
        if (car > 97) {
            ret += 5;
        }
        if (car > 99) {
            ret += 5;
        }
        if (car > 100) {
            ret += 5;
        }
        if (car > 101) {
            ret += 5;
        }

        ret += 5;

        return ret;
    }

    public static int generarPuntosDePoder(int inte, int nivel) {
        int ret = 0;

        if (inte > 5) {
            ret += 1;
        }
        if (inte > 15) {
            ret += 1;
        }
        if (inte > 25) {
            ret += 1;
        }
        if (inte > 30) {
            ret += 1;
        }
        return ret * nivel;
    }

    public static String[] darResultadoGolpe(int clase, int valor, int armadura) {
        String hitUnido = "0";
        String tablaArmaName = tablaPorClaseDeArma(clase);
        valor = (valor < 0) ? 0 : valor;
        valor = (valor > 150) ? 150 : valor;
        HashMap<String, String> tablaActual = tablasDaño.get(tablaArmaName);
        if (tablaActual == null) {
            Recursos.informar("No esta cargada la tabla para el Arma con la que golpea el personaje");
        } else {
            hitUnido = tablaActual.get(valor + "-" + armadura);
        }
        hitUnido = (hitUnido != null) ? hitUnido : "0";
        return separarNumerosDeLetras(hitUnido);
    }

    private static String tablaPorClaseDeArma(int clase) {

        switch (clase) {

            case CLASE_MANO_DESNUDA: {

                return "ataqueKarate";
            }
            case CLASE_ALFANJE: {

                return "ataqueAlfanje";
            }
            case CLASE_ARCO_CORTO: {

                return "ataqueArcoCorto";
            }
            case CLASE_ARCO_LARGO: {

                return "ataqueArcoLargo";
            }
            case CLASE_BASTON: {

                return "ataqueBaston";
            }
            case CLASE_CIMITARRA: {

                return "ataqueCimitarra";
            }
            case CLASE_DAGA: {

                return "ataqueDaga";
            }
            case CLASE_ESPADA_ANCHA: {

                return "ataqueEspadaAncha";
            }
            case CLASE_ESPADA_CORTA: {

                return "ataqueEspadaCorta";
            }
            case CLASE_ESPADON: {

                return "ataqueEspadon";
            }
            case CLASE_GARRAS: {

                return "ataqueGarras";
            }
            case CLASE_GARROTE: {

                return "ataqueGarrote";
            }
            case CLASE_HACHA: {

                return "ataqueHacha";
            }
            case CLASE_KARATE: {

                return "ataqueKarate";
            }
            case CLASE_LANZA: {
                return "ataqueLanza";

            }
            case CLASE_MAZA: {
                return "ataqueMaza";

            }
            case CLASE_MORDISCO: {
                return "ataqueMordisco";

            }
            case CLASE_LANZA_CABALLERIA: {
                return "ataqueLanzaCaballeria";
            }
            case CLASE_ROMPE_CABEZAS: {
                return "ataqueRompecabezas";

            }
            default: {
                return "ataqueKarate";
            }
        }

    }

    public static ArrayList<Arma> todosLosEscudos(){
        ArrayList<Arma> escudos = new ArrayList<>();
        for (Arma arm : armeria) {
            if (arm.getClase() == CLASE_ESCUDO)
                escudos.add(arm);
        }
        return escudos;
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
            case Status.DORMIDO_INCONSCIENTE: {
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
        jpg.setValue(sold.getPuntosVidaActual());
        jpg.setStringPainted(true);
        jpg.setString("" + sold.getPuntosVidaActual());

        obj.add(sold);
        obj.add(sold.getGrupo());
        obj.add(textoEstado(sold.getEstado().getCuerpo()));
        obj.add(jpg);
        obj.add(true);
        obj.add(new JButton("Atacar"));
        return obj;
    }

    public static Arma escudoAlAzar() {
        return (Arma) aleatorioDe(escudos);
    }

    public static Vector objetoSoldadosstatic(boolean lado) {

        Vector obj = new Vector();
        for (int i = 0; i < soldados.size(); i++) {
            Token sold = soldados.get(i);

            JProgressBar jpg = new JProgressBar(0, sold.getHabilidades().getPuntosVida());
            jpg.setValue(sold.getPuntosVidaActual());
            jpg.setStringPainted(true);
            jpg.setString("" + sold.getPuntosVidaActual());
            obj.add(ObjSoldado(sold));

        }
        return obj;
    }

    public static String getHexaColor(Color color) {
        return "#" + Integer.toHexString(color.getRGB()).substring(2);
    }

    public static String evtAsaltoNuevo(int asa) {
        return "<br/><br/><Strong> Asalto " + asa + "</strong><br/><hr/>";
    }

    public static String evtFinDeAsalto() {
        System.out.println("dibuje el fin");
        return "<br/><hr/><Strong>Fin del Asalto</strong><br/><hr/>";
    }

    public static String evtAccion(Accion acc, Token tok) {
        String ret = "<br/><blockquote>";
        ret += "<span color='" + tok.getColor() + "'> " + tok.getNombre() + " <span>";

        switch (acc.getTipo()) {
            case Constantes.TIPO_ACCION_SIN_ACCION: {
                ret += " No realiza Acciones";
                break;
            }
            case Constantes.TIPO_ACCION_CARGA_SORTILEGIO: {
                int carga = (Integer) ((Object[]) tok.getSortilegioCargado())[0];
                Sortilegio sort = (Sortilegio) ((Object[]) tok.getSortilegioCargado())[1];
                ret += " <span> suma " + carga + " Carga(s) del sortilegio " + sort.toString();
                break;
            }
            case Constantes.TIPO_ACCION_REALIZA_SORTILEGIO: {
                ret += " <span> Lanza sortilegio " + acc.get_sortilegio_a_realizar().toString();
                break;
            }
            case Constantes.TIPO_ACCION_DISPARA_PROYECTIL: {
                ret += " <span> Dispara Proyectil ";
                break;
            }
            case Constantes.TIPO_ACCION_CARGA_PROYECTIL: {
                ret += " <span> Carga un Proyectil";
                break;
            }
            case Constantes.TIPO_ACCION_PARAR_PROYECTIL: {
                ret += " <span> Para un proyectil";
                break;
            }
            case Constantes.TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA: {
                ret += " <span> Movimiento y Maniobra  " + acc.getDificultad();
                break;
            }
            case Constantes.TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO: {
                ret += " <span> Ataque Cuerpo a Cuperpo ";
                break;
            }
            case Constantes.TIPO_ACCION_DESPLAZAMIENTO: {
                ret += " <span> Desplazamiento ";
                break;
            }
            case Constantes.TIPO_ACCION_MOVIMIENTO_ESTATICO: {
                ret += " <span> Movimiento Estatico ";
                break;
            }
            default: {
                ret += "";
                break;
            }
        }
        if (acc.getDescp().length() > 0) {
            ret += "<br/>";
            ret += "<p>" + acc.getDescp() + "</p>";
            ret += "<br/>";
        }
        return ret + "</blockquote>";
    }

    public static String evtAlteracion(Token tok) {
        String ret = "<br/><blockquote>";
        ret += "<span color='" + tok.getColor() + "'> " + tok.getNombre() + " <span>";

        return ret + "</blockquote>";
    }

    public static String evtOportunidad(Token tok) {
        String ret = "<br/><blockquote>";
        ret += "<span color='" + tok.getColor() + "'> " + tok.getNombre() + " <span>";
        return ret + " espera una oportunidad para realizar su acción</blockquote>";
    }

    public static int cuadraditosABono(int cantidad) {
        int ret = -25;
        for (int i = 0; i < cantidad; i++) {
            if (i < 10) {
                ret += 5;
            }
            if (i > 10 && i < 20) {
                ret += 2;
            }
            if (i > 20) {
                ret += 1;
            }
        }
        return ret;
    }

    public static File copiarIcono(File origen, String name) {
        boolean res = false;
        File destino = new File(newPathFor(origen, name));

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

        } catch (IOException ex) {
            Logger.getLogger(AbrirGuardar.class.getName()).log(Level.SEVERE, null, ex);
            Recursos.sout("Fallo la copia del icono", 0);
            Recursos.informar("No se pudo cargar el icono en " + origen.toString());

        }
        return (res) ? destino : null;
    }

    private static String newPathFor(File f, String name) {
        return Principal.dataRecursos.getDir_avatars() + name + "." + getFileExtension(f);
    }

    private static String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }

    public static int asaltosParse(int cant, int tiempo) {

        if (tiempo == Constantes.TIEMPO_SEGUNDOS) {
            return (cant / 10);
        }
        if (tiempo == Constantes.TIEMPO_MINUTOS) {
            return (cant / 6);
        }
        if (tiempo == Constantes.TIEMPO_HORAS) {
            return (cant / 360);
        }
        if (tiempo == Constantes.TIEMPO_DIAS) {
            return (cant / 8640);
        }
        if (tiempo == Constantes.TIEMPO_SEMANAS) {
            return (cant / 60480);
        } else {
            return cant;
        }

    }

    public static int tiempoEnAsaltosParse(int cant, int tiempo) {
        if (tiempo == Constantes.TIEMPO_MINUTOS) {
            return (cant * 6);
        }
        if (tiempo == Constantes.TIEMPO_HORAS) {
            return (cant * 6 * 60);
        }
        if (tiempo == Constantes.TIEMPO_DIAS) {
            return (cant * 6 * 60 * 24);
        }
        if (tiempo == Constantes.TIEMPO_SEMANAS) {
            return (cant * 6 * 60 * 24 * 7);
        } else {
            return cant;
        }

    }

    public static String mostrarDuracion(int as) {
        String r = "";
        Double t = (Double) (as / 1.0);
        if (as > 60480) {
            r += asaltosParse(as, Constantes.TIEMPO_SEMANAS) + " Sem.";
        } else if (as > 8640) {
            r += asaltosParse(as, Constantes.TIEMPO_DIAS) + " Dias";
        } else if (as > 360) {
            r += asaltosParse(as, Constantes.TIEMPO_HORAS) + " Hrs.";
        } else if (as > 12) {
            r += asaltosParse(as, Constantes.TIEMPO_MINUTOS) + " Min.";
        } else {
            r += as + " As.";
        }

        return r;
    }

    public static void nuevoSortilegio(Sortilegio s) {
        Principal.dataRecursos.getSortilegiosSueltos().put(s.getId(), s);

    }

    public static int nuevoIndiceSortilegio() {
        return Principal.dataRecursos.getSortilegiosSueltos().size();
    }

    public static int nuevaBo(int nivel, int rango) {

        int bonoBo = 0;
        for (int j = 0; j < nivel; j++) {
            boolean yes = Recursos.posibilidad(90);
            if (yes) {
                yes = Recursos.posibilidad(10);
                if (yes) {
                    bonoBo += 10;
                } else {
                    bonoBo += 5;
                }
            }
        }
        int al = Recursos.aleatorioEntre(15, 25);
        float aux1 = (float) rango * al;
        float factor = (rango == 0) ? 1 : (100 - (aux1)) / 100;
        float aux = (35 + nivel * 3 + nivel + bonoBo + Recursos.aleatorioEntre(1, 5)) * factor;
        return Math.round(aux);
    }

    public static int movManParaArmadura(int armadura_puesta) {
        if (armadura_puesta > 16) {
            return Constantes.HABILIDAD_MM_CORAZA;
        }
        if (armadura_puesta > 12) {
            return Constantes.HABILIDAD_MM_COTA_DE_MALLA;
        }
        if (armadura_puesta > 8) {
            return Constantes.HABILIDAD_MM_CUERO_ENDURECIDO;
        }
        if (armadura_puesta > 4) {
            return Constantes.HABILIDAD_MM_CUERO;
        } else {
            return Constantes.HABILIDAD_MM_SINARMADURA;
        }
    }

    public static String tipoArmadura(int armadura_puesta) {

        int arm = movManParaArmadura(armadura_puesta);
        return armaduraTxt(arm);

    }

    public static String armaduraTxt(int arm) {

        if (arm == Constantes.HABILIDAD_MM_SINARMADURA) {
            return "SA";
        }

        if (arm == Constantes.HABILIDAD_MM_CUERO) {
            return "C";
        }

        if (arm == Constantes.HABILIDAD_MM_CUERO_ENDURECIDO) {
            return "CE";
        }

        if (arm == Constantes.HABILIDAD_MM_COTA_DE_MALLA) {
            return "CM";
        }

        if (arm == Constantes.HABILIDAD_MM_CORAZA) {
            return "CO";
        } else {
            return "SA";
        }

    }

    public static String dificultadTxt(int dif) {

        if (dif == Constantes.DIFICULTAD_RUTINA) {
            return "Rutina";
        }
        if (dif == Constantes.DIFICULTAD_FACIL) {
            return "Facil";
        }
        if (dif == Constantes.DIFICULTAD_MUY_FACIL) {
            return "Muy Facil";
        }
        if (dif == Constantes.DIFICULTAD_MEDIA) {
            return "Media";
        }
        if (dif == Constantes.DIFICULTAD_DIFICIL) {
            return "Dificil";
        }
        if (dif == Constantes.DIFICULTAD_MUY_DIFICIL) {
            return "Muy Dificil";
        }
        if (dif == Constantes.DIFICULTAD_EXT_DIFICIL) {
            return "Extremandamente Dificil";
        }
        if (dif == Constantes.DIFICULTAD_LOCURA) {
            return "Locura";
        }
        if (dif == Constantes.DIFICULTAD_ABSURDO) {
            return "Absurdo";
        } else {
            return "SA";
        }

    }

}
