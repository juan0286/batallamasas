/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import superrolbattle.ventanas.JPanelFormToken_Accion;

/**
 *
 * @author Juan
 */
public class CampoDeBatalla implements Serializable {

    public static ArrayList<Asalto> asaltos = new ArrayList<Asalto>();

    public  int nAsalto= 0;
    private JTextArea cajaDeRegistro;
    private  ArrayList<JPanelFormToken_Accion> tokens = new ArrayList<JPanelFormToken_Accion>();
    
    public int resolverAsalto() {
         
       // Asalto as = asaltos.get(nAsalto);
       //  as.resolver();
        nAsalto+=1;
        for (int i = 0; i < tokens.size(); i++) {
            tokens.get(i).desHecho();
        }
       
       return nAsalto;
       
    }

    public boolean puedenComenzarlosAtaques() {
         
        return (true);
    }

    public void terminarAsalto(){
        
    }
    
    public static void iniciarCampoDeBatalla() {
       
        Asalto asa = new Asalto();
        asaltos.add(asa);
    }
    
    public static void agregarAccion(Accion acc) {
        Asalto asa = asaltos.get(asaltos.size()-1);
        asa.agregarAccion(acc);
        
    }

    public static Asalto asaltoNow() {
        if (asaltos.size() > 0) {
            return asaltos.get(asaltos.size()-1);
        } else {
            return null;
        }
    }




    public static void setAsaltos(ArrayList<Asalto> asaltos) {
        CampoDeBatalla.asaltos = asaltos;
    }

    public void setnAsalto(int nAsalto) {
        this.nAsalto = nAsalto;
    }

    public void setCajaDeRegistro(JTextArea cajaDeRegistro) {
        this.cajaDeRegistro = cajaDeRegistro;
    }

    public void setTokens(ArrayList<JPanelFormToken_Accion> tokens) {
        this.tokens = tokens;
    }

    public ArrayList<JPanelFormToken_Accion> getTokens() {
        return tokens;
    }
    
    
    
    
    public void agregarTokens(JPanelFormToken_Accion ventanaAccionToken) {
        this.tokens.add(ventanaAccionToken);
    }

    public void sinAccioneshechos(JPanel jp) {
        for (int i = 0; i < jp.getComponentCount(); i++) {
            JPanelFormToken_Accion jpta = (JPanelFormToken_Accion) jp.getComponent(i);
            jpta.hecho();            
        }
       
    }
    
    
     public boolean todosActuaron(JPanel jp) {
        for (int i = 0; i < jp.getComponentCount(); i++) {
            JPanelFormToken_Accion jpta = (JPanelFormToken_Accion) jp.getComponent(i);
            if (!jpta.isDone()) {
                if (!jpta.isAccionDeOportunidad()) {
                    return false;
                }
            }
        }
        return true;
    }
}
