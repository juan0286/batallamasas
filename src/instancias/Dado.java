/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import static recursos.Recursos.aleatorioEntre;

/**
 *
 * @author TiranoJuan
 */
public class Dado {

    int caras;
    boolean abierto;
    int abiertoArribaCon;
    int abiertoAbajoCon;

    public Dado() {
        this.abierto = true;
        this.caras = 100;
        int naux = caras / 20;
        this.abiertoAbajoCon = naux;
        this.abiertoArribaCon = (caras - naux);
    }

    public Dado(int caras, boolean abierto, int abiertoArribaCon, int abiertoAbajoCon) {
        this.caras = caras;
        this.abierto = abierto;
        this.abiertoArribaCon = abiertoArribaCon;
        this.abiertoAbajoCon = abiertoAbajoCon;
    }

    public Dado(int caras) {
        this.caras = caras;
        int naux = caras / 20;
        this.abiertoAbajoCon = naux;
        this.abiertoArribaCon = (caras - naux);
    }

    public int getCaras() {
        return caras;
    }

    public void setCaras(int caras) {
        this.caras = caras;
    }

    public boolean isAbierto() {
        return abierto;
    }

    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }

    public int getAbiertoArribaCon() {
        return abiertoArribaCon;
    }

    public void setAbiertoArribaCon(int abiertoArribaCon) {
        this.abiertoArribaCon = abiertoArribaCon;
    }

    public int getAbiertoAbajoCon() {
        return abiertoAbajoCon;
    }

    public void setAbiertoAbajoCon(int abiertoAbajoCon) {
        this.abiertoAbajoCon = abiertoAbajoCon;
    }

    public int lanzarAbierta() {
        int dado = lanzarCerrada();
        boolean abierta_arr = dado > abiertoArribaCon;
        boolean abierta_abj = dado <= abiertoAbajoCon;
        int dadoT = dado;
        if (abierta_arr || abierta_abj) {            
            dado = lanzarCerrada();
            do {
                dadoT = (abierta_abj) ? dadoT - dado : dadoT + dado;
                dado = lanzarCerrada();
            } while (dado > abiertoArribaCon);
        } 
        return dadoT;
    }

    public int lanzarCerrada() {
        return aleatorioEntre(1, caras);
    }

}
