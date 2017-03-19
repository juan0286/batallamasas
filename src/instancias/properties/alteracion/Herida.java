/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties.alteracion;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author TiranoJuan
 */
@XmlType
public class Herida  extends Alteracion{

    private int pv = 0;
    private int cuerpoEstado = -1;
    private int asaltosparamorir = -1;
    private boolean mortal = false;
    
    /*
    private int aturdido = 0;
    private int obligadoparar = 0;
    private int sinpoderparar = 0;

    // curable
    
    private int sangre = 0;
   
    
    //progresivo
    private int trMod = 0;
    private int mmMod = 0;
    private int boMod = 0;
    private int bdMod = 0;
    private int actividad = 0;
   

    private boolean brazoIzqInUtil = false;
    private boolean brazoDerInUtil = false;
    private boolean piernaIzqInUtil = false;
    private boolean piernaDerInUtil = false;

    private boolean activo = true;
    private boolean curacionProgresiva = false;
    private String descripcion = "";
    private int duracion = -1;
    private int transcurso = -1;
    */
    

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getCuerpoEstado() {
        return cuerpoEstado;
    }

    public void setCuerpoEstado(int cuerpoEstado) {
        this.cuerpoEstado = cuerpoEstado;
    }

    public int getAsaltosparamorir() {
        return asaltosparamorir;
    }

    public void setAsaltosparamorir(int asaltosparamorir) {
        this.asaltosparamorir = asaltosparamorir;
    }

    public boolean isMortal() {
        return mortal;
    }

    public void setMortal(boolean mortal) {
        this.mortal = mortal;
    }
    

    public Herida() {
        super();
    }



    
}
