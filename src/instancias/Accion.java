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

        //int tactica = definirTactica();
        int bonoArm = (Integer) this.medio[2];
        int boDisponible = emisor.boDisponibleAtaque();
        int boAtque = boDisponible;
        int def = destino.boDisponibleDefensa();
        def += destino.bonoEscudo();

        int atque = boAtque
                + Recursos.dadoAbiertoArriba()
                + emisor.getManoDER().getArmaEquipada().getBono()
                + bonoArm
                - def;

        String nombreTabla = Recursos.armasTablas.get(emisor.getManoDER().getArmaEquipada().getTipo());
        String codigoResultado = atque + "" + destino.getHabilidades().getArmadura();
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
        // }

    }

    public void resolverAtaqueArco() {
        int bonoArm = (Integer) this.medio[2];
        int boDisponible = emisor.boDisponibleAtaque();
        int boAtque = boDisponible;
        int def = destino.boDisponibleDefensa();
        def += destino.bonoEscudo();

        int atque = boAtque
                + Recursos.dadoAbiertoArriba()
                + emisor.getManoDER().getArmaEquipada().getBono()
                + bonoArm
                - def;

        String nombreTabla = Recursos.armasTablas.get(emisor.getManoDER().getArmaEquipada().getTipo());
        String codigoResultado = atque + "" + destino.getHabilidades().getArmadura();
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
        // }

    }
    
    public void resolverAtaqueDosArmas() {
        int bonoArm = (Integer) this.medio[2];
        int boDisponible = emisor.boDisponibleAtaque();
        int boAtque = boDisponible;
        int def = destino.boDisponibleDefensa();
        def += destino.bonoEscudo();

        int atque = boAtque
                + Recursos.dadoAbiertoArriba()
                + emisor.getManoDER().getArmaEquipada().getBono()
                + bonoArm
                - def;

        String nombreTabla = Recursos.armasTablas.get(emisor.getManoDER().getArmaEquipada().getTipo());
        String codigoResultado = atque + "" + destino.getHabilidades().getArmadura();
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
        // }

    }
    
    public void resolverAtaquePuños() {

        //int tactica = definirTactica();
        int bonoArm = 0;        
        int boDisponible = emisor.boDisponibleAtaque();
        int boAtque = boDisponible /2;
        int def = destino.boDisponibleDefensa();
        def += destino.bonoEscudo();

        int atque = boAtque
                + Recursos.dadoAbiertoArriba()
                + emisor.getManoDER().getArmaEquipada().getBono()
                + bonoArm
                - def;

        String nombreTabla = Recursos.armasTablas.get(emisor.getManoDER().getArmaEquipada().getTipo());
        String codigoResultado = atque + "" + destino.getHabilidades().getArmadura();
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
        // }

    }
    
    
    @Override
    public String toString() {
        return "Accion{" + "tipo=" + tipo + ", emisor=" + emisor + ", destino=" + destino + ", medio=" + medio + '}';
    }

}
