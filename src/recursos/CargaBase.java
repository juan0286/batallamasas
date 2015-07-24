/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import com.csvreader.CsvReader;
import instancias.Asalto;
import instancias.CampoDeBatalla;
import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Brazo;
import instancias.properties.Habilidad;
import instancias.properties.Status;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import static recursos.Recursos.informar;
import static recursos.Recursos.verTabla;

/**
 *
 * @author Juan
 */
public class CargaBase {

    public static void iniciarTodo() {
        cargarTablas("ataques");
        cargarTablasCritico("criticos");
        cargaArmeria();
        cargaGrupos();
        cargarNombres(); // importante, siempre antes de cargaSoldados
        cargaSoldados();
        cargaCampoDeBatalla();

    }

    private static String[] crticsArray = {"A", "B", "C", "D", "E"};

    private static void cargarTablas(String tipo) {
        String sDirectorio = "tablas\\" + tipo;
        File f = new File(sDirectorio);
        if (f.exists()) { // Directorio existe 
            File[] ficheros = f.listFiles();
            for (int x = 0; x < ficheros.length; x++) {

                // creo una tabla, a partir de un archivo
                try {

                    CsvReader valores_import = new CsvReader(ficheros[x].getAbsolutePath());
                    valores_import.readHeaders();

                    int n = 150;
                    HashMap<String, String> tabla = new HashMap();

                    while (valores_import.readRecord()) {
                        int arm = 20;
                        for (int armadura = 0; armadura < 20; armadura++) {
                            String valor = valores_import.get(armadura);
                            tabla.put(n + "-" + arm, valor);
                            arm--;
                        }
                        Recursos.sout(n+"", 2);
                        n--;
                    }
                    String nombreTabla = ficheros[x].getName().replace(".csv", "");

                    Recursos.tablasDaño.put(nombreTabla, tabla);

                    valores_import.close();

                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
            }
        } else { //Directorio no existe }
            informar("no existe esa carpeta");
        }

    }

    private static void cargarTablasCritico(String tipo) {
        String sDirectorio = "tablas\\" + tipo;
        File f = new File(sDirectorio);
        if (f.exists()) { // Directorio existe 
            File[] ficheros = f.listFiles();
            for (int x = 0; x < ficheros.length; x++) {

                // creo una tabla, a partir de un archivo
                try {

                    CsvReader valores_import = new CsvReader(ficheros[x].getAbsolutePath());
                    valores_import.readHeaders();

                    int n = 1;
                    HashMap<String, String> tabla = new HashMap();

                    while (valores_import.readRecord()) {

                        for (int rango = 0; rango < crticsArray.length; rango++) {
                            String valor = valores_import.get(rango);
                            tabla.put(n + "-" + crticsArray[rango], valor);
                        }
                        n++;
                    }
                    String nombreTabla = ficheros[x].getName().replace(".csv", "");

                    Recursos.tablasCritico.put(nombreTabla, tabla);

                    valores_import.close();

                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
            }
        } else { //Directorio no existe }
            informar("no existe esa carpeta");
        }

    }

    private static void cargarNombres() {

        String fichero = "tablas\\nombres.txt";
        try {
            FileReader fr = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                Recursos.nombres.add(linea);
            }

            fr.close();
        } catch (Exception e) {
            System.out.println("Excepcion leyendo fichero " + fichero + ": " + e);
        }
    }

    private String rangoCritico(String codeCrit) {
        String letra = "A";
        for (String CrticsArray1 : crticsArray) {
            if (codeCrit.contains(CrticsArray1)) {
                letra = CrticsArray1;
                break;
            }
        }
        return letra;

    }

    private static void cargaArmeria() {
      
        Arma puños = new Arma("Mano Desnuda", Arma.CLASE_MANO_DESNUDA, -50, Arma.TIPO_NORMAL, false);
        Arma arma1 = new Arma("Espada Ancha", Arma.CLASE_ESPADA_ANCHA, 0, Arma.TIPO_NORMAL, false);
        Arma arma2 = new Arma("Espada Alfanje", Arma.CLASE_ALFANJE, 0, Arma.TIPO_NORMAL, false);
        Arma arma3 = new Arma("Arco Corto", Arma.CLASE_ARCO_CORTO, 0, Arma.TIPO_NORMAL, true);
        Arma arma4 = new Arma("Arco Largo", Arma.CLASE_ARCO_LARGO, 0, Arma.TIPO_NORMAL, true);
        Arma arma5 = new Arma("Baston", Arma.CLASE_BASTON, 0, Arma.TIPO_NORMAL, true);
        Arma arma6 = new Arma("Espada Cimitarra", Arma.CLASE_CIMITARRA, 0, Arma.TIPO_NORMAL, false);
        Arma arma7 = new Arma("Daga", Arma.CLASE_DAGA, 0, Arma.TIPO_NORMAL, false);
        Arma arma8 = new Arma("Espada Corta", Arma.CLASE_ESPADA_CORTA, 0, Arma.TIPO_NORMAL, false);
        Arma arma9 = new Arma("Espadon", Arma.CLASE_ESPADON, 0, Arma.TIPO_NORMAL, true);
        Arma arma10 = new Arma("Garrote", Arma.CLASE_GARROTE, 0, Arma.TIPO_NORMAL, false);
        Arma arma11 = new Arma("Hacha de mano", Arma.CLASE_HACHA, 0, Arma.TIPO_NORMAL, false);
        Arma arma12 = new Arma("Lanza", Arma.CLASE_LANZA, 0, Arma.TIPO_NORMAL, false);
        Arma arma13 = new Arma("Maza de Mano", Arma.CLASE_MAZA, 0, Arma.TIPO_NORMAL, false);
        Arma arma14 = new Arma("Lanza de Caballeria", Arma.CLASE_LANZA_CABALLERIA, 0, Arma.TIPO_NORMAL, true);
        Arma arma15 = new Arma("Rompe Cabezas", Arma.CLASE_ROMPE_CABEZAS, 0, Arma.TIPO_NORMAL, true);
        Arma arma16 = new Arma("Escudo", Arma.CLASE_ESCUDO, -50, Arma.TIPO_NORMAL, false);

        Recursos.armeria.add(puños);
        Recursos.armeria.add(arma1);
        Recursos.armeria.add(arma2);
        Recursos.armeria.add(arma3);
        Recursos.armeria.add(arma4);
        Recursos.armeria.add(arma5);
        Recursos.armeria.add(arma6);
        Recursos.armeria.add(arma7);
        Recursos.armeria.add(arma8);
        Recursos.armeria.add(arma9);
        Recursos.armeria.add(arma10);
        Recursos.armeria.add(arma11);
        Recursos.armeria.add(arma12);
        Recursos.armeria.add(arma13);
        Recursos.armeria.add(arma14);
        Recursos.armeria.add(arma15);
        Recursos.armeria.add(arma16);

    }

    private static void cargaGrupos() {
        String grupo1 = "Malosos de Kyoros";
        String grupo2 = "Los Neositos";
        String grupo3 = "Escorpiones Negros";
        String grupo4 = "Bandidos";
        String grupo5 = "Soldados de Rulini";

        Recursos.grupos.add(grupo1);
        Recursos.grupos.add(grupo2);
        Recursos.grupos.add(grupo3);
        Recursos.grupos.add(grupo4);
        Recursos.grupos.add(grupo5);

    }

    private static void cargaSoldados() {

        for (int i = 0; i < 10; i++) {

            Token newToken = null;
            newToken = new Token();
            Habilidad hab = new Habilidad();
            Brazo izq = new Brazo();
            Brazo der = new Brazo();
            Status est = new Status();

            newToken.setNombre((String) Recursos.aleatorioDe(Recursos.nombres));

            int nivel = Recursos.aleatorioEntre(1, 20);
            newToken.setNivel(nivel);
            newToken.setGrupo(Recursos.grupos.get(Recursos.aleatorioEntre(0, Recursos.grupos.size() - 1)));

            int pv = 30;
            for (int j = 0; j < nivel; j++) {

                boolean yes = Recursos.posibilidad(10);
                if (yes) {
                    pv += Recursos.aleatorioEntre(1, 10);
                    pv += Recursos.aleatorioEntre(1, 10);
                } else {
                    pv += Recursos.aleatorioEntre(1, 10);
                }

            }
            
            hab.setPuntosVida(pv);

            int porcPv = 100;
            newToken.setPuntosVida(pv);

            der.setHabilitado(true);
            der.setArmaEquipada(Recursos.armeria.get(Recursos.aleatorioEntre(0, Recursos.armeria.size() - 1)));

            izq.setHabilitado(true);
            if (der.getArmaEquipada().isdosManos()) {
                izq.setArmaEquipada(der.getArmaEquipada());
            } else {
                if (Recursos.posibilidad(70)) {
                    izq.setArmaEquipada(Recursos.armeria.get(Arma.CLASE_ESCUDO));
                } else {
                    izq.setArmaEquipada(Recursos.armeria.get(Arma.CLASE_MANO_DESNUDA));
                }
            }

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

            hab.setBo(35 + nivel * 3 + nivel + bonoBo + Recursos.aleatorioEntre(1, 5));
            hab.setBd(5 * Recursos.aleatorioEntre(1, 8));
            hab.setArmadura(Recursos.aleatorioEntre(1, 20));

            newToken.setEstilo(Recursos.aleatorioEntre(0, 4));

            newToken.setLadoIzquierdo(Recursos.aleatorioEntre(0, 2) == 0);
            System.out.println(newToken.isLadoIzquierdo());
            newToken.setHabilidades(hab);
            if (Recursos.posibilidad(10)) {
                newToken.setManoDER(izq);
                newToken.setManoIZQ(der);
            } else {
                newToken.setManoDER(der);
                newToken.setManoIZQ(izq);
            }

            newToken.setEstado(est);

            Recursos.soldados.add(newToken);

        }
    }

    private static void cargaCampoDeBatalla() {

        if (CampoDeBatalla.asaltos.size() == 0) {
            CampoDeBatalla.iniciarCampoDeBatalla();
        }

    }
}
