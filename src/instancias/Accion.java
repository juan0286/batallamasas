/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import instancias.properties.Arma;
import java.util.Objects;
import recursos.Critico;
import recursos.Recursos;

/**
 *
 * @author Juan
 */
public class Accion {

    public static final int TIPO_COMBATE_1_ARMA = 1;
    public static final int TIPO_COMBATE_2_ARMAS = 2;
    public static final int TIPO_COMBATE_ARCO = 3;
    public static final int TIPO_COMBATE_PUÑO = 4;

    private int tipo;
    private Token emisor;
    private Token destino;
    /*
     [0] Objeto Arma
     [1] Bonos extras
     */
    private Object[] medio;  // creo que es el Arma

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Token getEmisor() {
        return emisor;
    }

    public void setEmisor(Token emisor) {
        this.emisor = emisor;
    }

    public Token getDestino() {
        return destino;
    }

    public void setDestino(Token destino) {
        this.destino = destino;
    }

    public Object[] getMedio() {
        return medio;
    }

    public void setMedio(Object[] medio) {
        this.medio = medio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.medio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Accion other = (Accion) obj;
        if (!Objects.equals(this.emisor, other.emisor)) {
            return false;
        }
        return true;
    }

    public void resolverAtaque() {
        switch (this.getTipo()) {

            case Accion.TIPO_COMBATE_1_ARMA: {
                resolverAtaqueUnArma();
                break;
            }
            case Accion.TIPO_COMBATE_2_ARMAS: {
                resolverAtaqueDosArmas();
                break;
            }
            case Accion.TIPO_COMBATE_ARCO: {
                resolverAtaqueArco();
                break;
            }
            case Accion.TIPO_COMBATE_PUÑO: {
                resolverAtaqueArco();
                break;
            }

        }

    }

    public void resolverAtaqueUnArma() {

        Arma medioArma = (Arma) medio[0];
        //int tactica = definirTactica();
        int bonoArm = (Integer) this.medio[1];
        int boDisponible = emisor.boDisponibleAtaque();
        int boAtque = boDisponible;
        int def = destino.boDisponibleDefensa();
        def += destino.bonoEscudo();
        int dados = Recursos.dadoAbiertoArriba();

        int atque = boAtque
                + dados
                + medioArma.getBono()
                + bonoArm
                - def;

        Recursos.sout("", 0);
        Recursos.sout("Ataque de " + emisor.getNombre() + "   A   " + destino.getNombre(), 1);
        Recursos.sout("Utiliza un " + medioArma.getNombre(), 2);
        Recursos.sout("Ataque BO = " + boAtque, 2);
        Recursos.sout("Defensa BD = " + def, 2);
        Recursos.sout("Dados = " + dados, 2);

        avanzarDaño(atque, medioArma);
    }

    public void resolverAtaqueArco() {

        Arma medioArma = (Arma) medio[0];
        int bonoArm = (Integer) this.medio[1];
        int boDisponible = emisor.boDisponibleAtaque();
        int boAtque = boDisponible;
        int def = destino.boDisponibleDefensa();
        def += destino.bonoEscudo();
        int dados = Recursos.dadoAbiertoArriba();

        int atque = boAtque
                + dados
                + medioArma.getBono()
                + bonoArm
                - def;

        Recursos.sout("", 0);
        Recursos.sout("Ataque de " + emisor.getNombre() + "   A   " + destino.getNombre(), 1);
        Recursos.sout("Utiliza un " + medioArma.getNombre(), 2);
        Recursos.sout("Ataque BO = " + boAtque, 2);
        Recursos.sout("Defensa BD = " + def, 2);
        Recursos.sout("Dados = " + dados, 2);

        avanzarDaño(atque, medioArma);
    }

    public void resolverAtaqueDosArmas() {
        Arma medioArma = (Arma) medio[0];

        int bonoArm = (Integer) this.medio[1];
        int boDisponible = emisor.boDisponibleAtaque();
        int boAtque = boDisponible;
        int def = destino.boDisponibleDefensa();
        def += destino.bonoEscudo();
        int dados = Recursos.dadoAbiertoArriba();

        int atque = boAtque
                + dados
                + medioArma.getBono()
                + bonoArm
                - def;

        Recursos.sout("", 0);
        Recursos.sout("Ataque de " + emisor.getNombre() + "   A   " + destino.getNombre(), 1);
        Recursos.sout("Utiliza un " + medioArma.getNombre(), 2);
        Recursos.sout("Ataque BO = " + boAtque, 2);
        Recursos.sout("Defensa BD = " + def, 2);
        Recursos.sout("Dados = " + dados, 2);

        avanzarDaño(atque, medioArma);
        // }

    }

    public void resolverAtaquePuños() {

        Arma medioArma = (Arma) medio[0];
        //int tactica = definirTactica();
        int bonoArm = 0;
        int boDisponible = emisor.boDisponibleAtaque();
        int boAtque = boDisponible / 2;
        int def = destino.boDisponibleDefensa();
        def += destino.bonoEscudo();

        int atque = boAtque
                + Recursos.dadoAbiertoArriba()
                + medioArma.getBono()
                + bonoArm
                - def;

        avanzarDaño(atque, medioArma);
        // }

    }

    private void avanzarDaño(int atque, Arma medioArma) {

        Recursos.sout("Ataque de ", 0);
        atque = (atque > 150) ? 150 : atque;
        atque = (atque < 150) ? 0 : atque;

        String nombreTabla = Recursos.armasTablas.get(medioArma.getClase());
        String codigoResultado = atque + "-" + destino.getHabilidades().getArmadura();
        String[] rdo = Recursos.darResultadoGolpe(nombreTabla, codigoResultado);

        // Aplicar el daño
        int pv = destino.getPuntosVida();
        destino.setPuntosVida(pv - Integer.parseInt(rdo[0]));
        destino.updateEstado();
        // Resolver el critico
        int dadoCritico = Recursos.aleatorioEntre(1, 100);
        Critico critic = Recursos.textoCritico(rdo[1], dadoCritico);

        // Aplicar daño del critico
        destino.aplicarCritico(critic);

        Recursos.sout("Resultado = " + atque, 2);
        Recursos.sout("Critico = \n" + critic, 1);

    }

    @Override
    public String toString() {
        return "Accion{" + "tipo=" + tipo + ", emisor=" + emisor + ", destino=" + destino + ", medio=" + medio + '}';
    }

}
