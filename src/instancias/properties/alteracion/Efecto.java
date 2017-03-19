/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties.alteracion;

import instancias.properties.Extremidad;
import java.util.ArrayList;
import java.util.HashMap;
import recursos.Recursos;

/**
 *
 * @author TiranoJuan
 */
public class Efecto {

    static final public int TIPO_QUEMADURA = 1;
    static final public int TIPO_CONGELAMIENTO = 2;
    static final public int TIPO_SANGRADO = 3;
    static final public int TIPO_OBLIGADO_A_PARAR = 4;
    static final public int TIPO_ATURDIDO = 5;
    static final public int TIPO_ATURDIDO_SIN_PARAR = 6;
    static final public int TIPO_RESTAR_PV_TOTAL = 7;
    static final public int TIPO_DIVIDIR_PV_TOTAL = 8;
    static final public int TIPO_DORMIDO = 9;
    static final public int TIPO_DIVIDE_LA_ACTIVIDAD = 10;

    static final public int TIPO_CIERRA_SANGRADO = 12;
    static final public int TIPO_DESATURDIR = 13;
    static final public int TIPO_SUMAR_PV = 14;
    static final public int TIPO_MULTIPLICAR_PV = 15;
    static final public int TIPO_SUMAR_PP = 16;
    static final public int TIPO_MULTIPLICAR_PP = 17;
    static final public int TIPO_MULTIPLICAR_PV_DAÑO = 18;
    static final public int TIPO_DIVIDIR_PV_DAÑO = 19;

    static final public int TIPOS_UNO_A_UNO = 21;

    static final public int TIPO_AUMENTA_ACTIVIDAD = 23;
    static final public int TIPO_AUMENTO_DE_MM = 24;
    static final public int TIPO_AUMENTO_DE_TR = 25;
    static final public int TIPO_AUMENTO_DE_BO = 26;
    static final public int TIPO_AUMENTO_DE_BO_FILO = 27;
    static final public int TIPO_AUMENTO_DE_BO_CONTUNDENTE = 28;
    static final public int TIPO_AUMENTO_DE_BO_DOS_MANOS = 29;
    static final public int TIPO_AUMENTO_DE_BO_PROYECTILES = 30;
    static final public int TIPO_AUMENTO_DE_BO_ASTA = 31;
    static final public int TIPO_AUMENTO_DE_BD = 32;

    static final public int TIPO_RESTA_DE_ACTIVIDAD = 34;
    static final public int TIPO_RESTA_DE_MM = 35;
    static final public int TIPO_RESTA_DE_BO = 36;
    static final public int TIPO_RESTA_DE_BD = 37;
    static final public int TIPO_RESTA_DE_TR = 38;
    static final public int TIPO_RESTA_DE_RESISTENCIA_CALOR = 39;
    static final public int TIPO_RESTA_DE_RESISTENCIA_FRIO = 40;
    static final public int TIPO_RESTA_DE_RESISTENCIA_ESCENCIA = 41;
    static final public int TIPO_RESTA_DE_RESISTENCIA_CANALIZACION = 42;
    static final public int TIPO_RESTA_DE_RESISTENCIA_MENTALISMO = 43;

    static final public int TIPOS_CINCO_A_CINCO = 50;

    static final public int TIPO_LEVANTARSE = 51;
    static final public int TIPO_POSTRADO = 52;

    static final public int TIPOS_SOLO_UNO = 60;

    static final public int TIPO_DESACTIVAR_EXTREMIDAD = 61;
    static final public int TIPO_ACTIVAR_EXTREMIDAD = 62;
    static final public int TIPO_ACEL_CURA_EXTREMIDAD = 63;

    static final public int TIPOS_EXTREMIDAD = 70;

    static final public int TIPO_CAMBIO_ARMADURA = 80;

    public static HashMap<Integer, String> txt_heridas() {
        
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(TIPO_QUEMADURA, "Quemadura");
        hm.put(TIPO_CONGELAMIENTO, "Congelamiento");
        hm.put(TIPO_SANGRADO, "Sangrado");
        hm.put(TIPO_OBLIGADO_A_PARAR, "Obl. a parar");
        hm.put(TIPO_ATURDIDO, "Aturdido");
        hm.put(TIPO_ATURDIDO_SIN_PARAR, "Aturd. s/p");
        hm.put(TIPO_RESTAR_PV_TOTAL, "Resta de Pv total");
        hm.put(TIPO_DIVIDIR_PV_TOTAL, "Divide los Pv Total");
        hm.put(TIPO_DORMIDO, "Dormido");
        hm.put(TIPO_DIVIDE_LA_ACTIVIDAD, "Dividir Actividad");

        hm.put(TIPO_CIERRA_SANGRADO, "Cerrar Herida");
        hm.put(TIPO_DESATURDIR, "Desaturdir");
        hm.put(TIPO_SUMAR_PV, "Sumar Pv.");
        hm.put(TIPO_MULTIPLICAR_PV, "Multiplicar Pv.");
        hm.put(TIPO_SUMAR_PP, "Sumar PP.");
        hm.put(TIPO_MULTIPLICAR_PP, "Multiplicar PP.");
        hm.put(TIPO_MULTIPLICAR_PV_DAÑO, "Daño multiplicado");
        hm.put(TIPO_DIVIDIR_PV_DAÑO, "Daño Dividido");

        hm.put(TIPO_AUMENTA_ACTIVIDAD, "Aumento Actividad");
        hm.put(TIPO_AUMENTO_DE_MM, "Aumento MM");
        hm.put(TIPO_AUMENTO_DE_TR, "Aumento de TR");
        hm.put(TIPO_AUMENTO_DE_BO, "Aumento de Bo");
        hm.put(TIPO_AUMENTO_DE_BO_FILO, "Aumento de Bo con Filo");
        hm.put(TIPO_AUMENTO_DE_BO_CONTUNDENTE, "Aumento de Bo con Contundente");
        hm.put(TIPO_AUMENTO_DE_BO_DOS_MANOS, "Aumento de Bo con 2 Manos");
        hm.put(TIPO_AUMENTO_DE_BO_PROYECTILES, "Aumento de Bo con Proyectiles");
        hm.put(TIPO_AUMENTO_DE_BO_ASTA, "Aumento de Bo con Asta");
        hm.put(TIPO_AUMENTO_DE_BD, "Aumento de BD");

        hm.put(TIPO_RESTA_DE_ACTIVIDAD, "Resta Actividad");
        hm.put(TIPO_RESTA_DE_MM, "Resta Mov. y Man.");
        hm.put(TIPO_RESTA_DE_BO, "Resta de BO");
        hm.put(TIPO_RESTA_DE_BD, "Resta de BD");
        hm.put(TIPO_RESTA_DE_TR, "Resta de TR");
        hm.put(TIPO_RESTA_DE_RESISTENCIA_CALOR, "Resta de TR a calor");
        hm.put(TIPO_RESTA_DE_RESISTENCIA_FRIO, "Resta de TR a Frìo");
        hm.put(TIPO_RESTA_DE_RESISTENCIA_ESCENCIA, "Resta de TR Escencia");
        hm.put(TIPO_RESTA_DE_RESISTENCIA_CANALIZACION, "Resta de TR Canalizacion");
        hm.put(TIPO_RESTA_DE_RESISTENCIA_MENTALISMO, "Resta de TR Mentalismo");

        hm.put(TIPO_LEVANTARSE, "Levantarse");
        hm.put(TIPO_POSTRADO, "Dejar Postrado");

        hm.put(TIPO_DESACTIVAR_EXTREMIDAD, "Inhabilitar Extremidad");
        hm.put(TIPO_ACTIVAR_EXTREMIDAD, "Habilitar Extremidad");
        hm.put(TIPO_ACEL_CURA_EXTREMIDAD, "Acelerar Curacion Extremidad");

        return hm;
    }

    public static ArrayList<Efecto> todosLosEfectos() {

        ArrayList<Efecto> efs = new ArrayList<Efecto>();

        efs.add(new Efecto(TIPO_SANGRADO));
        efs.add(new Efecto(TIPO_OBLIGADO_A_PARAR));
        efs.add(new Efecto(TIPO_ATURDIDO));
        efs.add(new Efecto(TIPO_ATURDIDO_SIN_PARAR));
        efs.add(new Efecto(TIPO_RESTAR_PV_TOTAL));
        efs.add(new Efecto(TIPO_DIVIDIR_PV_TOTAL));
        efs.add(new Efecto(TIPO_DORMIDO));
        efs.add(new Efecto(TIPO_DIVIDE_LA_ACTIVIDAD));

        efs.add(new Efecto(TIPO_CIERRA_SANGRADO));
        efs.add(new Efecto(TIPO_DESATURDIR));
        efs.add(new Efecto(TIPO_SUMAR_PV));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PV));
        efs.add(new Efecto(TIPO_SUMAR_PP));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PP));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PV_DAÑO));
        efs.add(new Efecto(TIPO_DIVIDIR_PV_DAÑO));

        efs.add(new Efecto(TIPO_AUMENTA_ACTIVIDAD));
        efs.add(new Efecto(TIPO_AUMENTO_DE_MM));
        efs.add(new Efecto(TIPO_AUMENTO_DE_TR));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_FILO));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_CONTUNDENTE));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_DOS_MANOS));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_PROYECTILES));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_ASTA));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BD));

        efs.add(new Efecto(TIPO_RESTA_DE_ACTIVIDAD));
        efs.add(new Efecto(TIPO_RESTA_DE_MM));
        efs.add(new Efecto(TIPO_RESTA_DE_BO));
        efs.add(new Efecto(TIPO_RESTA_DE_BD));
        efs.add(new Efecto(TIPO_RESTA_DE_TR));

        efs.add(new Efecto(TIPO_LEVANTARSE));
        efs.add(new Efecto(TIPO_POSTRADO));

        efs.add(new Efecto(TIPO_DESACTIVAR_EXTREMIDAD));
        efs.add(new Efecto(TIPO_ACTIVAR_EXTREMIDAD));
        efs.add(new Efecto(TIPO_ACEL_CURA_EXTREMIDAD));

        return efs;
    }

    public static ArrayList<Efecto> todosLosEfectosCurativos() {

        ArrayList<Efecto> efs = new ArrayList<Efecto>();

       // efs.add(new Efecto(TIPO_CIERRA_SANGRADO));
        efs.add(new Efecto(TIPO_DESATURDIR));
        efs.add(new Efecto(TIPO_LEVANTARSE));       
        efs.add(new Efecto(TIPO_ACTIVAR_EXTREMIDAD));
        efs.add(new Efecto(TIPO_ACEL_CURA_EXTREMIDAD));        
        return efs;
    }
    public static ArrayList<Efecto> todosLosEfectosMods() {

        ArrayList<Efecto> efs = new ArrayList<Efecto>();

        efs.add(new Efecto(TIPO_AUMENTA_ACTIVIDAD));
        efs.add(new Efecto(TIPO_AUMENTO_DE_MM));
        efs.add(new Efecto(TIPO_AUMENTO_DE_TR));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_FILO));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_CONTUNDENTE));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_DOS_MANOS));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_PROYECTILES));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BO_ASTA));
        efs.add(new Efecto(TIPO_AUMENTO_DE_BD));
        efs.add(new Efecto(TIPO_SUMAR_PV));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PV));
        efs.add(new Efecto(TIPO_SUMAR_PP));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PP));
        efs.add(new Efecto(TIPO_MULTIPLICAR_PV_DAÑO));
        efs.add(new Efecto(TIPO_DIVIDIR_PV_DAÑO));
        return efs;
    }

    public static ArrayList<Efecto> todosLosEfectosDeHeridas() {

        ArrayList<Efecto> efs = new ArrayList<Efecto>();

        efs.add(new Efecto(TIPO_SANGRADO));
        efs.add(new Efecto(TIPO_OBLIGADO_A_PARAR));
        efs.add(new Efecto(TIPO_ATURDIDO));
        efs.add(new Efecto(TIPO_ATURDIDO_SIN_PARAR));
        efs.add(new Efecto(TIPO_DORMIDO));
        efs.add(new Efecto(TIPO_RESTA_DE_ACTIVIDAD));
        efs.add(new Efecto(TIPO_RESTA_DE_MM));
        efs.add(new Efecto(TIPO_RESTA_DE_BO));
        efs.add(new Efecto(TIPO_RESTA_DE_BD));
        efs.add(new Efecto(TIPO_RESTA_DE_TR));
        efs.add(new Efecto(TIPO_DESACTIVAR_EXTREMIDAD));
        efs.add(new Efecto(TIPO_DIVIDE_LA_ACTIVIDAD));
        efs.add(new Efecto(TIPO_RESTAR_PV_TOTAL));
        efs.add(new Efecto(TIPO_DIVIDIR_PV_TOTAL));
        efs.add(new Efecto(TIPO_POSTRADO));

        return efs;
    }

    public Efecto() {
        activo = true;
    }

    private int tipo;
    private int duracion;
    private int value;
    private boolean activo = true;

    private boolean regeneracion_progresiva = false;
    private int transcurso = 0;

    private Efecto(int tipo) {
        this.tipo = tipo;
    }

    public void avanzarAsalto(int asa) {
        transcurso += asa;
        if (transcurso >= duracion) {
            transcurso = duracion;
            activo = false;
        }

    }

    public int getCuantoMasDura() {
        int res = duracion - transcurso;
        return (res < 0) ? 0 : res;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
        transcurso = 0; // Cuando vuelvo a setear una nueva Duracion, 
    }

    public int getValue() {
        return value;
    }

    public int getValueActual() {
        if (regeneracion_progresiva) {
            return value - (value / duracion) * transcurso;
        } else {
            return value;
        }
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isRegeneracion_progresiva() {
        return regeneracion_progresiva;
    }

    public void setRegeneracion_progresiva(boolean regeneracion_progresiva) {
        this.regeneracion_progresiva = regeneracion_progresiva;
    }

    public int getTranscurso() {
        return transcurso;
    }

    public void setTranscurso(int transcurso) {
        this.transcurso = transcurso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {

        if (tipo == TIPO_SANGRADO || tipo == TIPO_CONGELAMIENTO || tipo == TIPO_QUEMADURA || tipo == TIPO_CIERRA_SANGRADO) {
            return Efecto.txt_heridas().get(this.tipo) + " -" + value + "/as\n";
        }
        if (tipo == TIPO_CIERRA_SANGRADO) {
            return Efecto.txt_heridas().get(this.tipo) + " -" + value + "/as\n";
        } else if (tipo == TIPO_ATURDIDO || tipo == TIPO_ATURDIDO_SIN_PARAR || tipo == TIPO_OBLIGADO_A_PARAR || tipo == TIPO_DORMIDO || tipo == TIPO_DESATURDIR) {
            return Efecto.txt_heridas().get(this.tipo) + " " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_RESTA_DE_BO) {
            return "-" + value + " Bo " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_BO) {
            return "+" + value + " Bo " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_BO_ASTA) {
            return "+" + value + " Bo(Asta) " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_BO_CONTUNDENTE) {
            return "+" + value + " Bo(Contundente) " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_BO_DOS_MANOS) {
            return "+" + value + " Bo(2manos) " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_BO_FILO) {
            return "+" + value + " Bo(Filo) " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_BO_PROYECTILES) {
            return "+" + value + " Bo(Proy) " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTA_ACTIVIDAD) {
            return "+" + value + " Activ. " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_RESTA_DE_ACTIVIDAD) {
            return "-" + value + " Activ. " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_MM) {
            return "+" + value + " Mm " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_RESTA_DE_MM) {
            return "-" + value + " Mm " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_TR) {
            return "+" + value + " Tr " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_RESTA_DE_TR) {
            return "-" + value + " Tr " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_AUMENTO_DE_BD) {
            return "+" + value + " Bd " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_RESTA_DE_BD) {
            return "-" + value + " Bd " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_RESTAR_PV_TOTAL) {
            return "-" + value + " Pv.Total " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_SUMAR_PV) {
            return "+" + value + " Pv.Total " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_MULTIPLICAR_PV) {
            return "x" + value + " Pv.Total " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else if (tipo == TIPO_DIVIDIR_PV_TOTAL) {
            return "/" + value + " Pv.Total " + Recursos.mostrarDuracion(getCuantoMasDura()) + "\n";
        } else {
            return Efecto.txt_heridas().get(this.tipo);
        }
    }

}
