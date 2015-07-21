/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias.properties;

/**
 *
 * @author Juan
 */
public class Arma {

    // CLASE
    static final public int CLASE_MANO_DESNUDA = 0;
    static final public  int CLASE_ALFANJE = 1;
    static final public  int CLASE_ARCO_CORTO = 2;
    static final public  int CLASE_ARCO_LARGO = 3;
    static final public  int CLASE_BASTON = 4;
    static final public  int CLASE_CIMITARRA = 5;
    static final public  int CLASE_DAGA = 6;
    static final public  int CLASE_ESPADA_ANCHA = 7;
    static final public  int CLASE_ESPADA_CORTA = 8;
    static final public  int CLASE_ESPADON = 9;
    static final public  int CLASE_GARROTE = 10;
    static final public  int CLASE_HACHA = 11;
    static final public  int CLASE_LANZA = 12;
    static final public  int CLASE_MAZA = 13;
    static final public  int CLASE_LANZA_CABALLERIA = 14;
    static final public  int CLASE_ROMPE_CABEZAS = 15;
    static final public  int CLASE_ESCUDO = 16;
    
    
   
    //TIPO 
    static final public  int TIPO_NORMAL = 0;
    static final public  int TIPO_MAGICA = 1;
    static final public  int TIPO_MITRIL = 2;
    static final public  int TIPO_SAGRADA = 3;
    static final public  int TIPO_EXTERMINADORA = 4;
    
    // estados
    static final public  int ESTADO_DETERIOROADA = 15;
    static final public  int ESTADO_VIEJA = 15;
    static final public  int ESTADO_COMO_nueva = 15;
    public Arma() {
    }

   

    public Arma(String Nombre, int tipo, int bono, int clase, boolean manos) {
        this.Nombre = Nombre;
        this.tipo = tipo;
        this.bono = bono;
        this.clase = clase;
        this.dosManos = manos;
    }

    
    
    private String Nombre;
    private int tipo;
    private int bono;
    private int clase;
    private boolean dosManos;

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the bono
     */
    public int getBono() {
        return bono;
    }

    /**
     * @param bono the bono to set
     */
    public void setBono(int bono) {
        this.bono = bono;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return  Nombre ;
    }

    public boolean isdosManos() {
        return dosManos;
    }

    public void setManos(boolean manos) {
        this.dosManos = manos;
    }

    

}
