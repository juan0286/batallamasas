/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

import instancias.Sortilegio;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Juan
 */
@XmlType
public class Status implements Serializable {

    static final public int FIRME = 0;
    static final public int CANSADO = 1;
    static final public int EXHAUSTO = 2;
    static final public int INCOSCIENTE = 3;
    static final public int COMA = 4;
    static final public int MUERTO = 5;

    static final public int MENTE_FIRME = 0;
    static final public int MENTE_OBLIGADO_A_PARAR = 1;
    static final public int MENTE_ATURDIDO = 2;
    static final public int MENTE_ATURDIDO_Y_SIN_PODER_PARAR = 3;

    private int cuerpo = 0;

    private boolean postrado = false;
    private int actividad = 0;
    private int sangradoPorAsalto = 0;
    private int aturdido = 0;
    private int obligadoparar = 0;
    private int sinpoderparar = 0;
    private int asaltosparamorir = 0;
    private int ptsDeVidaPerdidos = 0;
    private int trModificada = 0;
    private int mmModificada = 0;
    private int boModidificada = 0;
    private int bdModificada = 0;
    private Caracteristicas c;

    private Sortilegio sortilegioCargado;
    private int cargasDelSortilegio;

    public Status() {
    }

    public Status(Caracteristicas c) {
        this.c = c;
    }

    public int getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(int cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getAturdido() {
        return aturdido;
    }

    public void setAturdido(int aturdido) {
        this.aturdido = aturdido;
    }

    public int getObligadoParar() {
        return obligadoparar;
    }

    public void setObligadoparar(int obligadoparar) {
        this.obligadoparar = obligadoparar;
    }

    public int getSinpoderparar() {
        return sinpoderparar;
    }

    public void setSinpoderparar(int sinpoderparar) {
        this.sinpoderparar = sinpoderparar;
    }

    public int getAsaltosparamorir() {
        return asaltosparamorir;
    }

    public void setAsaltosparamorir(int asaltosparamorir) {
        this.asaltosparamorir = asaltosparamorir;
    }

    public int getActividad() {
        return actividad;
    }

    public void setActividad(int actividad) {
        this.actividad = actividad;
    }

    public boolean isAturdido() {
        return menteEstado() >= MENTE_ATURDIDO;
    }

    public boolean isSinPoderParar() {
        return this.getSinpoderparar() > 0;
    }

    public boolean isObligadoAParar() {
        return this.getObligadoParar() > 0;
    }

    public boolean isPostrado() {
        return postrado;
    }

    public void setPostrado(boolean postrado) {
        this.postrado = postrado;
    }

    public int getTrModificada() {
        return trModificada;
    }

    public void setTrModificada(int trModificada) {
        this.trModificada = trModificada;
    }

    public int getBoModidificada() {
        return boModidificada;
    }

    public void setBoModidificada(int boModidificada) {
        this.boModidificada = boModidificada;
    }

    public int getBdModificada() {
        return bdModificada;
    }

    public void setBdModificada(int bdModificada) {
        this.bdModificada = bdModificada;
    }

    public int getSangradoPorAsalto() {
        return sangradoPorAsalto;
    }

    public void setSangradoPorAsalto(int sangradoPorAsalto) {
        this.sangradoPorAsalto = sangradoPorAsalto;
    }

    public void aplicarAsaltoNuevo( String nombre) {
        String mje = "";
        if (sangradoPorAsalto > 0) {
            perderSAngre();
            mje += "Pierde " + sangradoPorAsalto + "pv.";
        }
        if (aturdido > 0) {
            this.desaturdir(1);
            mje += (aturdido > 0) ? "Aturdido por " + aturdido + "asalto(s)" : "Ya no esta aturdido";
        }
        if (obligadoparar > 0) {
            this.dejarDeparar(1);
            mje += (obligadoparar > 0) ? "Obligado a parar por " + obligadoparar + "asalto(s)" : "Ya no esta Obligado a parar";
        }
        if (sinpoderparar > 0) {
            this.desaturdirYpoderParar(1);
            mje += (sinpoderparar > 0) ? "Aturdido y sin poder parar por " + sinpoderparar + "asalto(s)" : "Ya no esta aturdido y sin poder parar";
        }
        if (asaltosparamorir > 0) {
            acercarseALaMuerte();
            mje += (asaltosparamorir > 0) ? "Muere en " + asaltosparamorir + "asalto(s)" : "Muere";
        }
        if (mje.length() > 0)
            recursos.Recursos.informar(nombre + "\n" + mje,nombre);
        
        update();
    }

    private void pvUpdate() {
        int puntosVidaActuales = c.getPuntosVida();
        if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales * 1.5) {
            this.setCuerpo(Status.MUERTO);
        } else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales && this.cuerpo < Status.INCOSCIENTE) {
            this.setCuerpo(Status.INCOSCIENTE);
        } else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales - 10 && this.cuerpo < Status.EXHAUSTO) {
            this.setCuerpo(Status.EXHAUSTO);
        } else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales / 2 && this.cuerpo < Status.CANSADO) {
            this.setCuerpo(Status.CANSADO);
        }

    }

    public void update() {
        pvUpdate();

    }

    public String cuerpoString() {
        if (cuerpo == Status.FIRME) {
            return "Firme";
        } else if (cuerpo == Status.CANSADO) {
            return "Cansado";
        } else if (cuerpo == Status.EXHAUSTO) {
            return "Exahusto";
        } else if (cuerpo == Status.INCOSCIENTE) {
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

    public void aturdir(int as) {
        aturdido += as;
    }

    public void desaturdir(int as) {
        aturdido -= as;
        aturdido = (aturdido > 0) ? aturdido : 0;
    }

    public void obligarAParar(int as) {
        obligadoparar += as;
    }

    public void dejarDeparar(int as) {
        obligadoparar -= as;
        obligadoparar = (obligadoparar > 0) ? obligadoparar : 0;
    }

    public void aturdirSinParar(int as) {
        sinpoderparar += as;
    }

    public void desaturdirYpoderParar(int as) {
        sinpoderparar -= as;
        sinpoderparar = (sinpoderparar > 0) ? sinpoderparar : 0;
    }

    public void reducirActividad(int act) {
        actividad += act;
    }

    public void recuperarActividad(int act) {
        actividad -= act;
        actividad = (actividad > 0) ? actividad : 0;
    }

    public void morirEn(int as) {
        asaltosparamorir += as;
    }

    public void noMorir() {
        asaltosparamorir -= 1;
    }

    public void sangrarMas(int sangre) {
        sangradoPorAsalto += sangre;
    }

    public void sangrarMenos(int sangre) {
        sangradoPorAsalto -= sangre;
        sangradoPorAsalto = (sangradoPorAsalto > 0) ? sangradoPorAsalto : 0;
    }

    public void perderSAngre() {
        this.setPtsDeVidaPerdidos(ptsDeVidaPerdidos + sangradoPorAsalto);
    }

    public void acercarseALaMuerte() {
        if (asaltosparamorir > 0) {
            asaltosparamorir = asaltosparamorir - 1;
            if (asaltosparamorir == 0) {
                this.cuerpo = MUERTO;
            }
        }
    }

    public void bonificarBo(int bo) {
        boModidificada += bo;
    }

    public void penalizarBo(int bo) {
        boModidificada -= bo;
        boModidificada = (boModidificada > 0) ? boModidificada : 0;
    }

    public void penalizarBd(int bd) {
        bdModificada += bd;
    }

    public void bonificarBd(int bd) {
        bdModificada -= bd;
        bdModificada = (bdModificada > 0) ? bdModificada : 0;
    }

    public void bonificarMm(int mm) {
        mmModificada += mm;
    }

    public void penalizarMm(int mm) {
        mmModificada -= mm;
        mmModificada = (mmModificada > 0) ? mmModificada : 0;
    }

    public void bonificarTR(int tr) {
        trModificada += tr;
    }

    public void penalizarTR(int tr) {
        trModificada -= tr;
        trModificada = (trModificada > 0) ? trModificada : 0;
    }

    public int getPtsDeVidaPerdidos() {
        return ptsDeVidaPerdidos;
    }

    public void setPtsDeVidaPerdidos(int ptsDeVidaPerdidos) {
        this.ptsDeVidaPerdidos = ptsDeVidaPerdidos;
    }

    public int getMmModificada() {
        return mmModificada;
    }

    public void setMmModificada(int mmModificada) {
        this.mmModificada = mmModificada;
    }

    public Caracteristicas getC() {
        return c;
    }

    public void setC(Caracteristicas c) {
        this.c = c;
    }

    public int getActividadActual() {

        int act = actividad;
        if (cuerpo == EXHAUSTO) {
            act += -50;
        }
        if (cuerpo == CANSADO) {
            act += -50;
        }
        return act;
    }

    public int getMmActual() {

        int mmm = mmModificada;

        return mmm;
    }

    @Override
    public String toString() {
        return "Status{" + "actividadReducida=" + actividad + ", \n cuerpo=" + cuerpo + ", \n aturdido=" + aturdido + ", \n obligadoparar=" + obligadoparar + ", \n sinpoderparar=" + sinpoderparar + ", \n asaltosparamorir=" + asaltosparamorir + ", \n ptsDeVidaPerdidos=" + ptsDeVidaPerdidos + '}';
    }

    public int menteEstado() {
        int resp = MENTE_FIRME;
        if (cuerpo < INCOSCIENTE) {
            if (sinpoderparar > 0) {
                resp = MENTE_ATURDIDO_Y_SIN_PODER_PARAR;
            } else if (aturdido > 0) {
                resp = MENTE_ATURDIDO;
            } else if (obligadoparar > 0) {
                resp = MENTE_OBLIGADO_A_PARAR;
            }
        }
        return resp;
    }

    public String menteEstadoTxt() {
        String resp = "";
        if (cuerpo < INCOSCIENTE) {
            if (sinpoderparar > 0) {
                resp = "Aturdido y Sin poder Parar";
            } else if (aturdido > 0) {
                resp = "Aturdido";
            } else if (obligadoparar > 0) {
                resp = "Obligado a Parar";
            }
        }
        return resp;
    }

    public String getTextEstado() {
        String resp = "";
        resp += cuerpoString();
        resp += "\n" + menteEstadoTxt();
        resp += (sangradoPorAsalto > 0) ? "-" + sangradoPorAsalto + "pv/as" : "";
        resp += (actividad != 0) ?  actividad + " a la Actividad " : "";
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

}
