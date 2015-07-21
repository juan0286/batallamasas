/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.util.ArrayList;
import instancias.properties.*;
import java.util.HashMap;
import java.util.Objects;
import recursos.Critico;
import recursos.Recursos;

/**
 *
 * @author Juan
 */
public class Token {

// estilos
    static final public int DEFENSA_TOTAL = 0;  // 0 - 10 %
    static final public int PRECAVIDO = 1;     // 11 - 35 %
    static final public int NORMAL = 2;        // 35 - 65 %
    static final public int ATAQUE = 3;        // 66 - 90 %
    static final public int TODO_O_NADA = 4;   // 91 - 100 %

    private String nombre;
    private int nivel;
    private String grupo;
    private int puntosVida;
    private Brazo manoIZQ;
    private Brazo manoDER;
    private Habilidad habilidades;
    private ArrayList daños;
    private Status estado;
    private int estilo;
    private boolean ladoIzquierdo;
    private int porcentajeAtque = 100;

    public Token(String nombre, int nivel, String grupo, int puntosVida, Brazo manoIZQ, Brazo manoDER, Habilidad habilidades, ArrayList daños, Status estado, int estilo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.grupo = grupo;
        this.puntosVida = puntosVida;
        this.manoIZQ = manoIZQ;
        this.manoDER = manoDER;
        this.habilidades = habilidades;
        this.daños = daños;
        this.estado = estado;
        this.estilo = estilo;
    }

    public Token(String nombre, int nivel, String grupo, int puntosVida, Brazo manoIZQ, Brazo manoDER, Habilidad habilidades, ArrayList daños, Status estado, int estilo, Asalto asalto, boolean lado) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.grupo = grupo;
        this.puntosVida = puntosVida;
        this.manoIZQ = manoIZQ;
        this.manoDER = manoDER;
        this.habilidades = habilidades;
        this.daños = daños;
        this.estado = estado;
        this.estilo = estilo;
        this.ladoIzquierdo = lado;
    }

    public Token() {

    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    public Brazo getManoIZQ() {
        return manoIZQ;
    }

    public void setManoIZQ(Brazo manoIZQ) {
        this.manoIZQ = manoIZQ;
    }

    public Brazo getManoDER() {
        return manoDER;
    }

    public void setManoDER(Brazo manoDER) {
        this.manoDER = manoDER;
    }

    public Habilidad getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(Habilidad habilidades) {
        this.habilidades = habilidades;
    }

    public ArrayList getDaños() {
        return daños;
    }

    public void setDaños(ArrayList daños) {
        this.daños = daños;
    }

    public Status getEstado() {
        return estado;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }

    public boolean isLadoIzquierdo() {
        return ladoIzquierdo;
    }

    public void setLadoIzquierdo(boolean ladoIzquierdo) {
        this.ladoIzquierdo = ladoIzquierdo;
    }

    public int getPorcentajeAtque() {
        return porcentajeAtque;
    }

    public void setPorcentajeAtque(int porcentajeAtque) {
        this.porcentajeAtque = porcentajeAtque;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Token other = (Token) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    public void updateEstado() {

        estado.update(1, this.getPuntosVida());
    }

    public void Atacar(Enemigo enemigo, int porcentaje, int bonoArm) {

        //int tactica = definirTactica();
        int boDisponible;
        boDisponible = ((this.habilidades.getBo() - this.estado.getActividadReducida()) > 0) ? (this.habilidades.getBo() - this.estado.getActividadReducida()) : 0;
        int boAtque = boDisponible;
        // for (Enemigo enemigo : this.getAsalto().getDefensores()) {
        int atque
                = (boAtque / 100 * porcentaje)
                + Recursos.dadoAbiertoArriba()
                + this.getManoDER().getArmaEquipada().getBono()
                + bonoArm
                - enemigo.getPorcDefensa();
        String nombreTabla = Recursos.armasTablas.get(this.getManoDER().getArmaEquipada().getTipo());
        String codigoResultado = atque + "" + enemigo.getHabilidades().getArmadura();
        String[] rdo = Recursos.darResultadoGolpe(nombreTabla, codigoResultado);

        // Aplicar el daño
        int pv = enemigo.getPuntosVida();
        enemigo.setPuntosVida(pv - Integer.parseInt(rdo[0]));
        enemigo.updateEstado();
        // Resolver el critico
        int dadoCritico = Recursos.aleatorioEntre(1, 100);
        Critico critic = Recursos.textoCritico(rdo[1], dadoCritico);

        // Aplicar daño del critico
        enemigo.aplicarCritico(critic);
        // }

    }

//        Brazo d = new Brazo();
//        Brazo i = new Brazo();
//        Habilidad hab = new Habilidad();
//        ArrayList da = new ArrayList();
//        Status stad= new Status();
//        Token enem = new Token(("Neo"),9, "capitanes", 100, i, d, hab, da, stad, Token.PRECAVIDO);
//        Enemigo en = (Enemigo) new Token(("Neo"),9, "capitanes", 100, i, d, hab, da, stad, Token.PRECAVIDO);
//        en.setPorcAtencion(30);
    public void aplicarCritico(Critico critic) {

        if (critic.isInconsciente()) {
            this.estado.setCuerpo(Status.INCOSCIENTE);
        } else if (critic.getAsaltosYMuere() == 0) {
            this.estado.setCuerpo(Status.MUERTO);
        } else {
            this.setPuntosVida(this.puntosVida - critic.getPuntosDaño());
            int actRed = estado.getActividadReducida();
            int atur = estado.getAturdido();
            int aturSP = estado.getSinpoderparar();
            int oAPP = estado.getObligadoParar();
            int pvPerd = estado.getPtsDeVidaPerdidos();

            estado.setActividadReducida(actRed + critic.getPuntosDaño());
            estado.setAturdido(atur + critic.getAsaltosAturdido());
            // debo parar, aturdido y sin poder parar y obligado

        }

        this.estado.update(1, this.puntosVida);
    }

    public int definirPorcTactica() {
        // devuelve la cantidad de BO destinada a atacar
        int porcReturn = 50;
        switch (this.estilo) {
            case Token.DEFENSA_TOTAL: {
                porcReturn = Recursos.aleatorioEntre(0, 10);
                break;
            }

            case Token.PRECAVIDO: {
                porcReturn = Recursos.aleatorioEntre(11, 34);
                break;
            }

            case Token.NORMAL: {
                porcReturn = Recursos.aleatorioEntre(35, 64);
                break;
            }

            case Token.ATAQUE: {
                porcReturn = Recursos.aleatorioEntre(66, 90);
                break;
            }

            case Token.TODO_O_NADA: {
                porcReturn = Recursos.aleatorioEntre(91, 100);
                break;
            }

        }
        if (Recursos.imprimirPorConsola) {
            System.out.println("\nDefiniendo tatica de " + this.nombre);
            System.out.println("Estilo: " + this.getEstilo() + "    Porcentaje: " + porcReturn + "%");
        }
        return porcReturn;
    }

    private int definirTactica() {

        // devuelve la cantidad de BO destinada a atacar
        int boReturn = this.habilidades.getBo();
        boReturn = (int) ((float) this.habilidades.getBo() / 100.0 * this.definirPorcTactica());

        return boReturn;
    }

    /**
     * @return the asalto
     */
    /**
     * @param asalto the asalto to set
     */
    @Override
    public String toString() {
        return nombre;
    }

    public int boDisponible() {
        int boDisponible = ((this.habilidades.getBo() - this.estado.getActividadReducida()) > 0) ? (this.habilidades.getBo() - this.estado.getActividadReducida()) : this.habilidades.getBo();
        return boDisponible;
    }

    public int boDisponibleAtaque() {
        int boDisponible = Recursos.porcentajeDe(this.getPorcentajeAtque(), this.boDisponible());
        return boDisponible;

    }

    public int boDisponibleDefensa() {
        int boDisponible = this.boDisponible() - this.boDisponibleAtaque();
        return boDisponible;
    }

    public int bonoEscudo() {

        if (manoDER.isHabilitado() && manoDER.getArmaEquipada().getClase() == Arma.CLASE_ESCUDO) {
            return this.manoDER.getArmaEquipada().getBono();
        } else if (manoIZQ.isHabilitado() && manoIZQ.getArmaEquipada().getClase() == Arma.CLASE_ESCUDO) {
            return this.manoIZQ.getArmaEquipada().getBono();

        } else {
            return 0;
        }
    }

    public final static Token nadie() {
        Token nadie = new Token();
        nadie.setNivel(0);
        nadie.setNombre("NADIE");

        return nadie;
    }
}
