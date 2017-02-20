/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.xml.bind.annotation.XmlRootElement;
import superrolbattle.ventanas.JPanelFormToken_Accion;

/**
 *
 * @author Juan
 */
@XmlRootElement
public class CampoDeBatalla implements Serializable {

    public static ArrayList<Asalto> asaltos = new ArrayList<Asalto>();

    private  int nAsalto= 0;
    private JEditorPane cajaDeRegistro;
    private  ArrayList<Token> tokens = new ArrayList<Token>();
    private  ArrayList<Evento> eventos = new ArrayList<Evento>();
    
    public int resolverAsalto() {
         
       // Asalto as = asaltos.get(nAsalto);
       //  as.resolver();
        nAsalto+=1;
        for (int i = 0; i < tokens.size(); i++) {
            tokens.get(i).getLastAction().desHecho();
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

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
        
    }




    public static void setAsaltos(ArrayList<Asalto> asaltos) {
        CampoDeBatalla.asaltos = asaltos;
    }

    public void setnAsalto(int nAsalto) {
        this.nAsalto = nAsalto;
    }

    public int getnAsalto() {
        return this.nAsalto;
    }
    
    

    public void setCajaDeRegistro(JEditorPane cajaDeRegistro) {
        this.cajaDeRegistro = cajaDeRegistro;
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList<Token> tokens) {
        this.tokens = tokens;
    }

    public void guardarEvento(Evento evt){
        eventos.add(evt);
    
    }
    
    
    
    
    
    public void agregarToken(Token token) {
        this.tokens.add(token);
    }


}
