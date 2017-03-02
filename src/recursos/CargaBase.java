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
import instancias.properties.Caracteristicas;
import instancias.properties.Status;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import recursos.Recursos.*;
import recursos.Constantes.*;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;
import static recursos.Recursos.informar;


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
        //cargaSoldados();
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
      
        Arma puños = new Arma("Mano Desnuda", Constantes.CLASE_MANO_DESNUDA, -50, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_PELEA);
        Arma arma1 = new Arma("Espada Ancha", Constantes.CLASE_ESPADA_ANCHA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_FILO);
        Arma arma2 = new Arma("Espada Alfanje", Constantes.CLASE_ALFANJE, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_FILO);
        Arma arma3 = new Arma("Arco Corto", Constantes.CLASE_ARCO_CORTO, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_PROYECTILES);
        Arma arma45 = new Arma("Arco Compuesto", Constantes.CLASE_ARCO_LARGO, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_PROYECTILES);
        Arma arma4 = new Arma("Arco Largo", Constantes.CLASE_ARCO_LARGO, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_PROYECTILES);
        Arma arma5 = new Arma("Baston", Constantes.CLASE_BASTON, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_DOS_MANOS);
        Arma arma6 = new Arma("Espada Cimitarra", Constantes.CLASE_CIMITARRA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_FILO);
        Arma arma7 = new Arma("Daga", Constantes.CLASE_DAGA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_FILO);
        Arma arma8 = new Arma("Espada Corta", Constantes.CLASE_ESPADA_CORTA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_FILO);
        Arma arma9 = new Arma("Espadon", Constantes.CLASE_ESPADON, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_DOS_MANOS);
        Arma arma10 = new Arma("Garrote", Constantes.CLASE_GARROTE, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_CONTUNDENTE);
        Arma arma11 = new Arma("Hacha de mano", Constantes.CLASE_HACHA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_FILO);
        Arma arma115 = new Arma("Hacha de mano(C)", Constantes.CLASE_HACHA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_CONTUNDENTE);
        Arma arma12 = new Arma("Lanza", Constantes.CLASE_LANZA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_ASTA);
        Arma arma13 = new Arma("Maza de Mano", Constantes.CLASE_MAZA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_CONTUNDENTE);
        Arma arma14 = new Arma("Lanza de Caballeria", Constantes.CLASE_LANZA_CABALLERIA, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_ASTA);
        Arma arma15 = new Arma("Rompe Cabezas", Constantes.CLASE_ROMPE_CABEZAS, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_DOS_MANOS);
        Arma arma16 = new Arma("Escudo", Constantes.CLASE_ESCUDO, -50, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_PELEA);
        Arma arma17 = new Arma("Hacha de Combate", Constantes.CLASE_ESPADON, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_DOS_MANOS);
        Arma arma18 = new Arma("Alabarda", Constantes.CLASE_ESCUDO, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_ASTA);
        Arma arma19 = new Arma("Tridente", Constantes.CLASE_LANZA, 0, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_ASTA);
        Arma arma195 = new Arma("Tridente(2m)", Constantes.CLASE_LANZA_CABALLERIA, 0, Constantes.TIPO_ARMA_NORMAL, true,Constantes.ESTILO_ASTA);
        Arma arma20 = new Arma("Florete", Constantes.CLASE_ESPADA_ANCHA, 5, Constantes.TIPO_ARMA_NORMAL, false,Constantes.ESTILO_FILO);

        
        Arma khalel = new Arma("Espada Khal-El", Constantes.CLASE_ESPADA_ANCHA, 30, Constantes.TIPO_ARMA_MAGICA, false, Constantes.ESTILO_FILO);
        Arma hachaOso = new Arma("Hacha Oso", Constantes.CLASE_HACHA, 30, Constantes.TIPO_ARMA_MITRIL, false, Constantes.ESTILO_FILO);
        Arma hachaOsoC = new Arma("Hacha Oso", Constantes.CLASE_HACHA, 30, Constantes.TIPO_ARMA_MITRIL, false, Constantes.ESTILO_CONTUNDENTE);
        Arma hachaOsoDM = new Arma("Hacha Oso", Constantes.CLASE_ESPADON, 35, Constantes.TIPO_ARMA_MITRIL, true, Constantes.ESTILO_DOS_MANOS);
        Arma espDragon = new Arma("Espada Dragon", Constantes.CLASE_ESPADA_ANCHA, 30, Constantes.TIPO_ARMA_MAGICA, false, Constantes.ESTILO_FILO);
        
        Arma EspKyoros = new Arma("Espada Kyoros", Constantes.CLASE_ESPADA_ANCHA, 40, Constantes.TIPO_ARMA_MAGICA, false, Constantes.ESTILO_FILO);
        Arma lanzaFeros = new Arma("Lanza Feroz", Constantes.CLASE_LANZA_CABALLERIA, 30, Constantes.TIPO_ARMA_MAGICA, false, Constantes.ESTILO_ASTA);
        
        
        Arma comboKyoLanzaEspada = new Arma("Combo Kyoros Feroz", Constantes.CLASE_ESPADA_ANCHA, 50, Constantes.TIPO_ARMA_MAGICA, true, Constantes.ESTILO_COMBO_ASTA_FILO);
        Arma comboNeoOsoDragon = new Arma("Combo Oso Dragon", Constantes.CLASE_HACHA, 45, Constantes.TIPO_ARMA_MITRIL, true, Constantes.ESTILO_COMBO_FILO_FILO);
        
        
        
        
        
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
            Caracteristicas hab = new Caracteristicas();
            Brazo izq = new Brazo();
            Brazo der = new Brazo();
            Status est = new Status(hab);

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
                    izq.setArmaEquipada(Recursos.armeria.get(Constantes.CLASE_ESCUDO));
                } else {
                    izq.setArmaEquipada(Recursos.armeria.get(Constantes.CLASE_MANO_DESNUDA));
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
/*
            hab.setBo_pri(35 + nivel * 3 + nivel + bonoBo + Recursos.aleatorioEntre(1, 5));
            int auxBoSec = (35 + nivel * 3 + nivel + bonoBo + Recursos.aleatorioEntre(1, 5));             
            auxBoSec = Recursos.porcentajeDe(Recursos.aleatorioEntre(50,75), auxBoSec);
            
            hab.setBo_pri_tipo(der.getArmaEquipada().getClase());
            hab.setBo_sec(auxBoSec);
            hab.setAgi(5 * Recursos.aleatorioEntre(1, 8));
            
            hab.setBo_sec_tipo(izq.getArmaEquipada().getClase());
  */          
            hab.setArmadura(Recursos.aleatorioEntre(1, 20));

            newToken.setEstilo_de_pelea(Recursos.aleatorioEntre(0, 4));

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
