/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import instancias.properties.alteracion.Alteracion;
import instancias.Sortilegio;
import instancias.properties.alteracion.Curacion;
import instancias.properties.alteracion.Efecto;
import instancias.properties.alteracion.Herida;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import javax.xml.bind.annotation.XmlType;
import recursos.Constantes;

/**
 *
 * @author Juan
 */
@XmlType
public class Status implements Serializable {

    static final public int FIRME = 0;
    static final public int CANSADO = 1;
    static final public int POSTRADO = 2;
    static final public int EXHAUSTO = 3;
    static final public int DORMIDO = 4;
    static final public int COMA = 5;
    static final public int MUERTO = 6;
    static final public int MORIBUNDO = 7;

    static final public int MENTE_FIRME = 0;
    static final public int MENTE_OBLIGADO_A_PARAR = 1;
    static final public int MENTE_ATURDIDO = 2;
    static final public int MENTE_ATURDIDO_Y_SIN_PODER_PARAR = 3;
    static final public int MENTE_DORMIDO = 4;

    private int cuerpo = 0;
    private int mente = 0;

    private boolean postrado = false;

    private int ptsDeVidaPerdidos = 0;
    private int ptsDePoderPerdidos = 0;

    private Caracteristicas c;
    private ArrayList<Extremidad> ext = new ArrayList<Extremidad>();

    private Sortilegio sortilegioCargado;
    private int cargasDelSortilegio;

    private ArrayList<Alteracion> alteraciones = new ArrayList<Alteracion>();

    public Status() {
    }

    public Status(Caracteristicas c, ArrayList<Extremidad> ext) {
        this.c = c;
        this.ext = ext;
    }

    public int getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(int cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getAturdido() {
        //return aturdido;
        return asaltosEnEstado(Efecto.TIPO_ATURDIDO);
    }

    public ArrayList<Alteracion> getAlteraciones() {
        return alteraciones;
    }

    public void setAlteraciones(ArrayList<Alteracion> alteraciones) {
        this.alteraciones = alteraciones;
    }

    public boolean isAturdido() {
        //return menteEstado() >= MENTE_ATURDIDO;
        return isInEstado(Efecto.TIPO_ATURDIDO) || isInEstado(Efecto.TIPO_ATURDIDO_SIN_PARAR);
    }

    public boolean isSinPoderParar() {
        //return this.getSinpoderparar() > 0;
        return isInEstado(Efecto.TIPO_ATURDIDO_SIN_PARAR);
    }

    public boolean isObligadoAParar() {
        //return this.getObligadoParar() > 0;
        return isInEstado(Efecto.TIPO_OBLIGADO_A_PARAR);
    }

    public boolean isSangrando() {
        //return this.getObligadoParar() > 0;
        return isInEstado(Efecto.TIPO_SANGRADO) || isInEstado(Efecto.TIPO_QUEMADURA) || isInEstado(Efecto.TIPO_CONGELAMIENTO);
    }

    public boolean isPostrado() {
        return postrado;
    }

    public void setPostrado(boolean postrado) {
        this.postrado = postrado;
    }

    public void aplicarAsaltoNuevo(String nombre, int asaltos) {
        String mje = "";

        boolean isAtur = false;
        boolean isAturSP = false;
        boolean isObli = false;
        boolean isDor = isInEstado(Efecto.TIPO_DORMIDO);
        if (!isDor) {
            isAtur = isAturdido();
            isAturSP = isSinPoderParar();
            isObli = isObligadoAParar();
            isDor = isObligadoAParar();
        }
        for (Iterator<Alteracion> iterator = alteraciones.iterator(); iterator.hasNext();) {
            Alteracion alt = iterator.next();
            if (alt.isActivo()) {

                if (alt.getClass().getName() == "instancias.properties.alteracion.Herida") {
                    Herida h = (Herida) alt;

                    if (h.isMortal()) {

                        h.setAsaltosparamorir(h.getAsaltosparamorir() - 1);

                        if (h.getAsaltosparamorir() == 0) {
                            mje += "Muere";
                            cuerpo = MUERTO;
                        } else if (h.getAsaltosparamorir() > 0) {
                            cuerpo = MORIBUNDO;
                            mje += "Muere en " + h.getAsaltosparamorir() + "asalto(s)\n";
                        }
                    }
                    ArrayList<Efecto> efectos = h.getEfectos();
                    for (Efecto e : efectos) {

                        if (e.isActivo()) {

                            if (e.getTipo() <= Efecto.TIPO_SANGRADO) {
                                dañarPv(e.getValueActual() * asaltos);
                                mje += "Pierde " + e.getValueActual() + "pv.\n";
                            }

                            // Avanzo Asalto en el evento    
                            e.avanzarAsalto(asaltos);

                        }

                    }

                } else if (alt.getClass().getName() == "instancias.properties.alteracion.Mod") {

                    // aplico mods
                } else if (alt.getClass().getName() == "instancias.properties.alteracion.Curacion") {

                    // aplico Curaciones
                }

            }
        }

        if (!isInconsciente()) {

            TreeMap<Integer, Integer> tm = maxeEstadoMente();

            if (isDor) {
                mje += (tm.get(MENTE_ATURDIDO_Y_SIN_PODER_PARAR) > 0) ? "Dormido por " + recursos.Recursos.mostrarDuracion(tm.get(Efecto.TIPO_ATURDIDO_SIN_PARAR)) : "Ya no esta Dormido";
            } else {
                if (isAturSP) {
                    mje += (tm.get(MENTE_ATURDIDO_Y_SIN_PODER_PARAR) > 0) ? "Aturdido y sin Poder parar por " + tm.get(Efecto.TIPO_ATURDIDO_SIN_PARAR) + " asalto(s)" : "Ya no esta aturdido";
                }
                if (isAtur) {
                    mje += (tm.get(MENTE_ATURDIDO) > 0) ? "Aturdido por " + tm.get(MENTE_ATURDIDO) + " asalto(s)" : "Ya no esta Aturdido";
                }
                if (isObli) {
                    mje += (tm.get(MENTE_OBLIGADO_A_PARAR) > 0) ? "Obligado a parar por " + tm.get(MENTE_OBLIGADO_A_PARAR) + " asalto(s)" : "Ya no esta Obligado a parar";
                }
            }
            if (mje.length() > 0) {
                recursos.Recursos.informar(nombre + "\n" + mje, nombre);
            }
        }
        update();
    }

    private void pvUpdate() {
        int puntosVidaActuales = c.getPuntosVida();
        if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales * 1.5) {
            this.setCuerpo(Status.MUERTO);
        } else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales && this.cuerpo < Status.DORMIDO) {
            this.setCuerpo(Status.DORMIDO);
        } else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales - 10 && this.cuerpo < Status.EXHAUSTO) {
            this.setCuerpo(Status.EXHAUSTO);
        } else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales / 2 && this.cuerpo < Status.CANSADO) {
            this.setCuerpo(Status.CANSADO);
        } else {
            this.setCuerpo(Status.FIRME);
        }

    }

    public void update() {

        pvUpdate();
        menteEstado();
    }

    public String cuerpoString() {
        if (cuerpo == Status.FIRME) {
            return "Firme";
        } else if (cuerpo == Status.CANSADO) {
            return "Cansado";
        } else if (cuerpo == Status.EXHAUSTO) {
            return "Exahusto";
        } else if (cuerpo == Status.DORMIDO) {
            return "Inconsciente";
        } else {
            return "Muerto";
        }

    }

    public void sanarPv(int pv) {
        ptsDeVidaPerdidos -= pv;
        ptsDeVidaPerdidos = (ptsDeVidaPerdidos > 0) ? ptsDeVidaPerdidos : 0;
        pvUpdate();
    }

    public void dañarPv(int pv) {
        ptsDeVidaPerdidos += pv;
        pvUpdate();

    }

    public int getPtsDeVidaPerdidos() {
        return ptsDeVidaPerdidos;
    }

    public void setPtsDeVidaPerdidos(int ptsDeVidaPerdidos) {
        this.ptsDeVidaPerdidos = ptsDeVidaPerdidos;
    }

    public Caracteristicas getC() {
        return c;
    }

    public void setC(Caracteristicas c) {
        this.c = c;
    }

    public int getActividadActual() {

        int act = sumaDeMod(Efecto.TIPO_AUMENTA_ACTIVIDAD);
        act = act - sumaDeMod(Efecto.TIPO_RESTA_DE_ACTIVIDAD);

        if (cuerpo == EXHAUSTO) {
            act += -50;
        }
        if (cuerpo == CANSADO) {
            act += -20;
        }
        return act;
    }

    public int getModsDeMm() {

        int mm = sumaDeMod(Efecto.TIPO_AUMENTO_DE_MM);
        mm = mm - sumaDeMod(Efecto.TIPO_RESTA_DE_MM);
        return mm;
    }

    public int getModsDeTR() {

        int tr = sumaDeMod(Efecto.TIPO_AUMENTO_DE_TR);
        tr = tr - sumaDeMod(Efecto.TIPO_RESTA_DE_MM);
        return tr;
    }

    public int getModsDeBD() {

        int Bd = sumaDeMod(Efecto.TIPO_AUMENTO_DE_BD);
        Bd = Bd - sumaDeMod(Efecto.TIPO_RESTA_DE_BD);
        return Bd;
    }

    public int menteEstado() {
        int resp = MENTE_FIRME;

        if (cuerpo < DORMIDO) {
            if (isSinPoderParar()) {
                resp = MENTE_ATURDIDO_Y_SIN_PODER_PARAR;
            } else if (isAturdido()) {
                resp = MENTE_ATURDIDO;
            } else if (isObligadoAParar()) {
                resp = MENTE_OBLIGADO_A_PARAR;
            }
        }
        mente = resp;
        return resp;
    }

    public String menteEstadoTxt() {
        String resp = "";
        TreeMap<Integer, Integer> hm = maxeEstadoMente();

        if (hm.get(MENTE_DORMIDO) > 0) {
            resp = "Dormido " + recursos.Recursos.mostrarDuracion(hm.get(MENTE_DORMIDO)) + "\n";
        } else {
            if (hm.get(MENTE_ATURDIDO_Y_SIN_PODER_PARAR) > 0) {
                resp = "Aturdido S/P " + hm.get(MENTE_ATURDIDO_Y_SIN_PODER_PARAR) + " As\n";
            }
            if (hm.get(MENTE_ATURDIDO) > 0) {
                resp = "Aturdido " + hm.get(MENTE_ATURDIDO) + " As\n";
            }
            if (hm.get(MENTE_OBLIGADO_A_PARAR) > 0) {
                resp = "Obligado a Parar " + hm.get(MENTE_OBLIGADO_A_PARAR) + " As\n";
            }
        }
        return resp;
    }

    public String getTextEstado() {
        String resp = "";
        resp += cuerpoString();
        resp += "\n" + menteEstadoTxt();
        resp += (isSangrando()) ? "-" + sumaDeMod(Efecto.TIPO_SANGRADO) + "pv/as\n" : "";
        int aa = getActividadActual();
        resp += (aa != 0) ? aa + " a la Actividad\n" : "";
        return resp;

    }

    public void cargarUnSortilegio(Sortilegio s) {
        if (cargasDelSortilegio > 0 && sortilegioCargado.equals(s)) {
            cargasDelSortilegio++;
        } else {
            sortilegioCargado = s;
            cargasDelSortilegio = 1;
        }

        cargasDelSortilegio = (cargasDelSortilegio > 4) ? 4 : cargasDelSortilegio;
    }

    public Object getSortilegioCargado() {
        return new Object[]{cargasDelSortilegio, sortilegioCargado, bonoParaSortilegio()};
    }

    public boolean isSortiCargado() {
        return cargasDelSortilegio > 0;
    }

    private int bonoParaSortilegio() {

        if (cargasDelSortilegio == 0) {
            return -30;
        }
        if (cargasDelSortilegio == 1) {
            return -15;
        }
        if (cargasDelSortilegio == 2) {
            return 0;
        }
        if (cargasDelSortilegio == 3) {
            return 10;
        }
        if (cargasDelSortilegio == 4) {
            return 20;
        } else {
            return 0;
        }
    }

    public void perderLaCarga() {
        sortilegioCargado = null;
        cargasDelSortilegio = 0;

    }

    public int getPtsDePoderPerdidos() {
        return ptsDePoderPerdidos;
    }

    public void setPtsDePoderPerdidos(int ptsDePoderPerdidos) {
        this.ptsDePoderPerdidos = ptsDePoderPerdidos;
    }

    private int asaltosEnEstado(int tipo) {

        int max = 0;
        for (Alteracion alt : alteraciones) {
            if (alt.isActivo()) {
                if (alt.getClass().getName() == "instancias.properties.alteracion.Herida") {
                    Herida h = (Herida) alt;
                    ArrayList<Efecto> efectos = h.getEfectos();
                    for (Efecto e : efectos) {
                        if (e.isActivo()) {
                            if (e.getTipo() == tipo && e.getCuantoMasDura() > max) {
                                max = e.getCuantoMasDura();
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    private int sumaDeMod(int tipo) {

        int suma = 0;
        for (Alteracion alt : alteraciones) {
            if (alt.isActivo()) {

                Herida h = (Herida) alt;
                ArrayList<Efecto> efectos = h.getEfectos();
                for (Efecto e : efectos) {
                    if (e.isActivo()) {
                        if (e.getTipo() == tipo) {
                            suma = e.getValueActual();
                        }
                    }
                }

            }
        }
        return suma;
    }

    public int getModsDeBo(int estilo) {
        TreeMap<Integer, Integer> hm = new TreeMap();
        hm.put(Constantes.ESTILO_FILO, Efecto.TIPO_AUMENTO_DE_BO_FILO);
        hm.put(Constantes.ESTILO_CONTUNDENTE, Efecto.TIPO_AUMENTO_DE_BO_CONTUNDENTE);
        hm.put(Constantes.ESTILO_DOS_MANOS, Efecto.TIPO_AUMENTO_DE_BO_DOS_MANOS);
        hm.put(Constantes.ESTILO_ASTA, Efecto.TIPO_AUMENTO_DE_BO_ASTA);
        hm.put(Constantes.ESTILO_PROYECTILES, Efecto.TIPO_AUMENTO_DE_BO_PROYECTILES);
        

        int suma = 0;
        for (Alteracion alt : alteraciones) {
            if (alt.isActivo()) {

                Herida h = (Herida) alt;
                ArrayList<Efecto> efectos = h.getEfectos();
                for (Efecto e : efectos) {
                    if (e.isActivo()) {
                        if (e.getTipo() == Efecto.TIPO_AUMENTO_DE_BO || e.getTipo() == hm.get(estilo) ) {
                            suma += e.getValueActual();
                        }
                        if (e.getTipo() == Efecto.TIPO_RESTA_DE_BO) {
                            suma -= e.getValueActual();
                        }
                    }
                }

            }
        }
        return suma;
    }

    public boolean isInEstado(int tipo) {

        boolean res = false;
        busqueda:
        for (Alteracion alt : alteraciones) {
            if (alt.isActivo()) {
                if (alt.getClass().getName() == "instancias.properties.alteracion.Herida") {
                    Herida h = (Herida) alt;
                    ArrayList<Efecto> efectos = h.getEfectos();
                    for (Efecto e : efectos) {
                        if (e.isActivo()) {
                            if (e.getTipo() == tipo && e.getCuantoMasDura() > 0) {
                                res = true;
                                break busqueda;
                            }

                        }
                    }
                }
            }
        }
        return res;
    }

    private TreeMap<Integer, Integer> maxeEstadoMente() {

        TreeMap<Integer, Integer> hm = new TreeMap();
        hm.put(MENTE_OBLIGADO_A_PARAR, 0);

        hm.put(MENTE_ATURDIDO, 0);

        hm.put(MENTE_ATURDIDO_Y_SIN_PODER_PARAR, 0);

        hm.put(MENTE_DORMIDO, 0);

        for (Alteracion alt : alteraciones) {
            if (alt.isActivo()) {
                if (alt.getClass().getName() == "instancias.properties.alteracion.Herida") {
                    Herida h = (Herida) alt;
                    ArrayList<Efecto> efectos = h.getEfectos();
                    for (Efecto e : efectos) {
                        if (e.isActivo()) {

                            if (e.getTipo() == Efecto.TIPO_OBLIGADO_A_PARAR && e.getCuantoMasDura() > hm.get(MENTE_OBLIGADO_A_PARAR)) {
                                hm.put(MENTE_OBLIGADO_A_PARAR, e.getCuantoMasDura());
                            }
                            if (e.getTipo() == Efecto.TIPO_ATURDIDO && e.getCuantoMasDura() > hm.get(MENTE_ATURDIDO)) {
                                hm.put(MENTE_ATURDIDO, e.getCuantoMasDura());
                            }
                            if (e.getTipo() == Efecto.TIPO_ATURDIDO_SIN_PARAR && e.getCuantoMasDura() > hm.get(MENTE_ATURDIDO_Y_SIN_PODER_PARAR)) {
                                hm.put(MENTE_ATURDIDO_Y_SIN_PODER_PARAR, e.getCuantoMasDura());
                            }
                            if (e.getTipo() == Efecto.TIPO_DORMIDO && e.getCuantoMasDura() > hm.get(MENTE_DORMIDO)) {
                                hm.put(MENTE_DORMIDO, e.getCuantoMasDura());
                            }

                        }
                    }
                }
            }
        }
        return hm;
    }

    public void aplicarHerida(Herida h) {

        if (h.getPv() > 0) {
            dañarPv(h.getPv());
        }

        if (h.getCuerpoEstado() > -1) {
            cuerpo = h.getCuerpoEstado();
        }

        if (h.isMortal()) {
            int asaltosPararMorir = h.getAsaltosparamorir();
        }

        for (Efecto e : h.getEfectos()) {
            if (e.getTipo() == Efecto.TIPO_POSTRADO) {
                postrado = true;
            }
            if (e.getTipo() == Efecto.TIPO_DESACTIVAR_EXTREMIDAD) {
                desactivarExtremidad(e.getValue());
            }

        }
        alteraciones.add(h);
        update();
    }

    public void aplicarCuracion(Curacion c) {

        if (c.getPvRecuperados() > 0) {
            sanarPv(c.getPvRecuperados());
        }

        if (c.getCuerpoEstado() > -1) {
            cuerpo = c.getCuerpoEstado();
        }

        for (Efecto e : c.getEfectos()) {

            if (e.getTipo() == Efecto.TIPO_LEVANTARSE) {
                postrado = false;
            }
            if (e.getTipo() == Efecto.TIPO_ACTIVAR_EXTREMIDAD) {
                activarExtremidad(e.getValue());
            }

        }
        update();
    }

    private boolean isInconsciente() {
        return (cuerpo >= DORMIDO || isInEstado(Efecto.TIPO_DORMIDO));
    }

    public void desactivarExtremidad(int indice_miembro) {
        ext.get(indice_miembro).setUtil(false);
        /*
        for (Extremidad extremidad : ext) {
            if (extremidad.getTipo_miembro() == tipo_miembro) {
                extremidad.setUtil(false);
                break;
            }

        }
         */
    }

    public void activarExtremidad(int indice_miembro) {
        ext.get(indice_miembro).setUtil(true);

        /*
        for (Extremidad extremidad : ext) {
            if (extremidad.getTipo_miembro() == tipo_miembro) {
                extremidad.setUtil(true);
                break;
            }

        }
         */
    }

}
