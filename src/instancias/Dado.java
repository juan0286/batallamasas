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
    int abiertoArribaCon;
    int abiertoAbajoCon;

    public Dado() {        
        this.caras = 100;
        int naux = caras / 20;
        this.abiertoAbajoCon = naux;
        this.abiertoArribaCon = (caras - naux);
    }

    public Dado(int caras, int abiertoArribaCon, int abiertoAbajoCon) {
        this.caras = caras;        
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
        System.out.println("Lanzo Abierta 1D"+caras + ": "+dado);        
        boolean abierta_arr = dado > abiertoArribaCon;
        boolean abierta_abj = dado <= abiertoAbajoCon;
        int dadoT = dado;
        if (abierta_arr || abierta_abj) {            
            System.out.println("Abierta" + dado);
            dado = lanzarCerrada();
            do {
                dadoT = (abierta_abj) ? dadoT - dado : dadoT + dado;
                dado = lanzarCerrada();
                System.out.println("Lanzo de nuevo: "+dado);
            } while (dado > abiertoArribaCon);
        } 
        System.out.println("Guardo Dados");        
        return dadoT;
    }

    public int lanzarCerrada() {
        return aleatorioEntre(1, caras);
    }

}
