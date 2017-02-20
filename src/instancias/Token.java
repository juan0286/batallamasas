/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.util.ArrayList;
import instancias.properties.*;
import java.awt.Color;
import java.io.Serializable;
import java.util.Objects;
import javax.xml.bind.annotation.XmlType;
import recursos.Critico;
import recursos.Recursos;
import superrolbattle.Principal;

/**
 *
 * @author Juan
 */
@XmlType
public class Token implements Serializable {

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
    private Caracteristicas habilidades;
    private ArrayList daños;
    private Status estado;
    private int estilo;
    private boolean ladoIzquierdo;
    private int armaduraPuesta;
    private int porcentajeAtque = 100;
    private boolean visible; // Si los jugadores pueden verlos
    private String color;
    
    private String urlIcon;
    
    private ArrayList<Accion> acciones = new ArrayList<Accion>();
    
    public Token(String nombre, int nivel, String grupo, int puntosVida, Brazo manoIZQ, Brazo manoDER, Caracteristicas habilidades, ArrayList daños, Status estado, int estilo, boolean ladoIzquierdo) {
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
        this.ladoIzquierdo = ladoIzquierdo;        
    }
    
    public Token(String nombre, int nivel, String grupo, int puntosVida, Brazo manoIZQ, Brazo manoDER, Caracteristicas habilidades, ArrayList daños, Status estado, int estilo) {
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
    
    public Token(String nombre, int nivel, String grupo, int puntosVida, Brazo manoIZQ, Brazo manoDER, Caracteristicas habilidades, ArrayList daños, Status estado, int estilo, Asalto asalto, boolean lado) {
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
    
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
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
    
    public Caracteristicas getHabilidades() {
        return habilidades;
    }
    
    public void setHabilidades(Caracteristicas habilidades) {
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
    
    public String getUrlIcon() {
        return urlIcon;
    }
    
    public void setUrlIcon(String urlIcon) {
        this.urlIcon = urlIcon;
    }
    
    public int getArmaduraPuesta() {
        return armaduraPuesta;
    }
    
    public void setArmaduraPuesta(int armaduraPuesta) {
        this.armaduraPuesta = armaduraPuesta;
    }
    
    public boolean isVisible() {
        return visible;
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public String vidatxt() {
        return this.getEstado().getPtsDeVidaPerdidos() + "  /  " + this.getPuntosVida();
    }
    
    public int compareTo(Token o) {
        int resultado = 0;
        if (this.estado.getMmActual() < o.estado.getMmActual()) {
            resultado = -1;
        } else if (this.estado.getMmActual() > o.estado.getMmActual()) {
            resultado = 1;
        } else if (this.getArmaduraPuesta() < o.getArmaduraPuesta()) {
            resultado = 1;
        } else if (this.getArmaduraPuesta() > o.getArmaduraPuesta()) {
            resultado = -1;
        } else {
            resultado = 0;
        }
        return resultado;
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
        
        estado.aplicarAsaltoNuevo();
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
            int actRed = estado.getActividad();
            int atur = estado.getAturdido();
            int aturSP = estado.getSinpoderparar();
            int oAPP = estado.getObligadoParar();
            int pvPerd = estado.getPtsDeVidaPerdidos();
            
            estado.setActividad(actRed + critic.getPuntosDaño());
            estado.setAturdido(atur + critic.getAsaltosAturdido());
            // debo parar, aturdido y sin poder parar y obligado

        }
        
        this.estado.update(1);
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
        int boReturn = this.habilidades.getBo_pri();
        boReturn = (int) ((float) this.habilidades.getBo_pri() / 100.0 * this.definirPorcTactica());
        
        return boReturn;
    }
    
    public ArrayList<Accion> getAcciones() {
        return acciones;
    }
    
    public void setAcciones(ArrayList<Accion> acciones) {
        this.acciones = acciones;
    }
    
    public void AgregarAccion(Accion accion) {
        this.acciones.add(accion);
    }
    
    public Accion ultimaAccion() {
        return this.acciones.get(acciones.size() - 1);
    }
    
    public void formatearAcciones() {
        this.acciones.clear();
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
        int boDisponible = ((this.habilidades.getBo_pri() - this.estado.getActividad()) > 0) ? (this.habilidades.getBo_pri() - this.estado.getActividad()) : this.habilidades.getBo_pri();
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
            return 25;
            
        } else {
            return 0;
        }
    }
    
    public String getpv() {
        return this.estado.getPtsDeVidaPerdidos() + " / " + this.habilidades.getPuntosVida();
    }
    
    public String textEstado() {
        
        return estado.getTextEstado();
    }
    
    public final static Token nadie() {
        Token nadie = new Token();
        nadie.setNivel(0);
        nadie.setNombre("NADIE");
        
        return nadie;
    }
    
    public Accion getLastAction() {
        return (Accion) acciones.get(acciones.size() - 1);
        
    }
    
    public ArrayList<Sortilegio> getSortilegios() {
        ArrayList<Sortilegio> sort = new ArrayList<Sortilegio>();
        for (int i = 0; i < habilidades.getSortilegios().size(); i++) {
            Sortilegio s = Principal.dataRecursos.getListaDeSortilegios().get(habilidades.getSortilegios().get(i));
            sort.add(s);
        }
        return sort;        
    }
    
    public void aprenderSortilegio(int s) {        
        habilidades.aprenderSortilegio(s);
    }
    
    public void cargarUnSortilegio(Sortilegio s) {
        estado.cargarUnSortilegio(s);
    }
    
    public Object getSortilegioCargado(){
        return estado.getSortilegioCargado();
    }
    
    public boolean isSortiCargado(){
        return estado.isSortiCargado();
    }
            
    public void lanzarUnSortilegio(Sortilegio sort_intencion) {
        perderLaCarga();
    }
    
    public boolean conoceSortilegio(int id){
        return habilidades.conoceSortilegio(id);
    }

    public void perderLaCarga() {
        estado.perderLaCarga();
    }

    public void intentarSortilegio(Sortilegio s) {
        getLastAction().setSort_intencion(s);
    }
}
