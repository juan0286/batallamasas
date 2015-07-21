/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

/**
 *
 * @author Juan
 */
public class Critico {
    
    private String texto;
    private int puntosDaño;
    private int asaltosAturdido;
    private int asaltosAturdidoSinParar;
    private int asaltosObligadoParar;
    private int asaltosYMuere;
    private boolean inconsciente;
    private int masProxAtaque;
    private int reduccionAct;

    public Critico(String texto) {
        this.texto = texto;
        texto = texto.toLowerCase();
        this.inconsciente = texto.contains("inconsciente");
        if (texto.contains("muere")){
            asaltosYMuere = 0;
        }else if(texto.contains("muerto")){
            asaltosYMuere = 0;
        }else if(texto.contains("morir")){
            asaltosYMuere = 0;
        }else if(texto.contains("morira")){
            asaltosYMuere = 0;
        }else if(texto.contains("paralizado")){
            asaltosYMuere = 0;
        }else if(texto.contains("coma")){
            asaltosYMuere = 0;
        }else{
            contabilizar(texto);
        }
            
        }
        
    

    
    private void contabilizar (String txt){
        String resto=txt;
        
        
        String aux = "suma ";
        if (txt.contains(aux)){
            int terminaSuma = txt.indexOf(aux) + aux.length();
            
            String txtSuma = txt.substring(terminaSuma, terminaSuma + 4);
            resto = resto.replace(txtSuma, "");
            String[] val = Recursos.separarNumerosDeLetras(txtSuma);
            this.masProxAtaque = Integer.parseInt(val[0]);            
        }
        
        aux = " de daño";
        if (resto.contains(aux)){
            int comienzaAux = resto.indexOf(aux);
            int auxPlus = comienzaAux;
            while (resto.charAt(auxPlus) != '+' || auxPlus < 0){
                auxPlus--;
            }           
            
            String txtDeDaño = resto.substring(auxPlus, comienzaAux + 8);
            resto = resto.replace(txtDeDaño, "");
            
            String[] val = Recursos.separarNumerosDeLetras(txtDeDaño);
            this.puntosDaño = Integer.parseInt(val[0]);            
        }
        
        aux = "aturdido y sin poder parar durante ";
        if (resto.contains(aux)){
            int terminaAySPP = resto.indexOf(aux) + aux.length();
            String txtAySPP = resto.substring(resto.indexOf(aux), aux.length()+ 4 + " asalto".length());
            resto = resto.replace(txtAySPP, "");
            
            String[] val = Recursos.separarNumerosDeLetras(txtAySPP);
            this.asaltosAturdidoSinParar = Integer.parseInt(val[0]);            
        }
        
        aux = "aturdido durante ";
        if (resto.contains(aux)){
            int terminaAtur = resto.indexOf(aux) + aux.length();
            String txtAtur = resto.substring(resto.indexOf(aux), aux.length()+ 4 + " asalto".length());
            resto = resto.replace(txtAtur, "");
            
            String[] val = Recursos.separarNumerosDeLetras(txtAtur);
            this.asaltosAturdido = Integer.parseInt(val[0]);            
        }
            aux = "-";
        if (resto.contains(aux)){
            int terminaMinus = resto.indexOf(aux) + aux.length()+1;
            String txtMinus = resto.substring(resto.indexOf(aux), aux.length()+ 4 + " asalto".length());
            resto = resto.replace(txtMinus, "");
            
            String[] val = Recursos.separarNumerosDeLetras(txtMinus);
            this.reduccionAct = Integer.parseInt(val[0]);            
        }      
            
        }
        
        
   
    
    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the puntosDaño
     */
    public int getPuntosDaño() {
        return puntosDaño;
    }

    /**
     * @param puntosDaño the puntosDaño to set
     */
    public void setPuntosDaño(int puntosDaño) {
        this.puntosDaño = puntosDaño;
    }

    /**
     * @return the asaltosAturdido
     */
    public int getAsaltosAturdido() {
        return asaltosAturdido;
    }

    /**
     * @param asaltosAturdido the asaltosAturdido to set
     */
    public void setAsaltosAturdido(int asaltosAturdido) {
        this.asaltosAturdido = asaltosAturdido;
    }

    /**
     * @return the asaltosAturdidoSinParar
     */
    public int getAsaltosAturdidoSinParar() {
        return asaltosAturdidoSinParar;
    }

    /**
     * @param asaltosAturdidoSinParar the asaltosAturdidoSinParar to set
     */
    public void setAsaltosAturdidoSinParar(int asaltosAturdidoSinParar) {
        this.asaltosAturdidoSinParar = asaltosAturdidoSinParar;
    }

    /**
     * @return the asaltosObligadoParar
     */
    public int getAsaltosObligadoParar() {
        return asaltosObligadoParar;
    }

    /**
     * @param asaltosObligadoParar the asaltosObligadoParar to set
     */
    public void setAsaltosObligadoParar(int asaltosObligadoParar) {
        this.asaltosObligadoParar = asaltosObligadoParar;
    }

    /**
     * @return the asaltosYMuere
     */
    public int getAsaltosYMuere() {
        return asaltosYMuere;
    }

    /**
     * @param asaltosYMuere the asaltosYMuere to set
     */
    public void setAsaltosYMuere(int asaltosYMuere) {
        this.asaltosYMuere = asaltosYMuere;
    }

    /**
     * @return the inconsciente
     */
    public boolean isInconsciente() {
        return inconsciente;
    }

    /**
     * @param inconsciente the inconsciente to set
     */
    public void setInconsciente(boolean inconsciente) {
        this.inconsciente = inconsciente;
    }

    /**
     * @return the masProxAtaque
     */
    public int getMasProxAtaque() {
        return masProxAtaque;
    }

    /**
     * @param masProxAtaque the masProxAtaque to set
     */
    public void setMasProxAtaque(int masProxAtaque) {
        this.masProxAtaque = masProxAtaque;
    }
    
    
    
    
    
}
