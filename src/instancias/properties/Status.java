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
public class Status {

    static final public int FIRME = 0;
    static final public  int CANSADO = 1;
    static final public  int EXHAUSTO = 3;
    static final public  int INCOSCIENTE = 4;
    static final public  int MUERTO = 5;
    
    private int actividadReducida = 0;
    private int cuerpo = 0;
    private int aturdido = 0;
    private int obligadoparar = 0;
    private int sinpoderparar = 0;
    private int asaltosparamorir = -1;
    private int ptsDeVidaPerdidos = 0;
    

    public Status() {
    }

    public int getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(int cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getAturdido() {
        return aturdido;
    }

    public void setAturdido(int aturdido) {
        this.aturdido = aturdido;
    }

    public int getObligadoParar() {
        return obligadoparar;
    }

    public void setObligadoparar(int obligadoparar) {
        this.obligadoparar = obligadoparar;
    }

    public int getSinpoderparar() {
        return sinpoderparar;
    }

    public void setSinpoderparar(int sinpoderparar) {
        this.sinpoderparar = sinpoderparar;
    }

    public int getAsaltosparamorir() {
        return asaltosparamorir;
    }

    public void setAsaltosparamorir(int asaltosparamorir) {
        this.asaltosparamorir = asaltosparamorir;
    }

    public int getActividadReducida() {
        return actividadReducida;
    }

    public void setActividadReducida(int actividadReducida) {
        this.actividadReducida = actividadReducida;
    }

    public boolean isAturdido() {
        return this.getAturdido()> 0;
    }
    public boolean isSinPoderParar() {
        return this.getSinpoderparar()> 0;
    }
    public boolean isObligadoAParar() {
        return this.getObligadoParar()> 0;
    }
 
   public void update(int asaltos, int puntosVidaActuales){
    
       
    if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales*1.5)
        {
            this.setCuerpo(Status.MUERTO);
        } else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales && this.cuerpo != Status.INCOSCIENTE)
        {
            this.setCuerpo(Status.INCOSCIENTE);            
        }
        else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales -10 && this.cuerpo != Status.EXHAUSTO )
        {
            this.setCuerpo(Status.EXHAUSTO);            
        }
        else if (this.getPtsDeVidaPerdidos() >= puntosVidaActuales/2 && this.cuerpo != Status.CANSADO)
        {
            this.setCuerpo(Status.CANSADO);           
        }   
        
    if (this.getAturdido()> 0){
        this.setAturdido(aturdido - asaltos);
    }
       
    if (this.getObligadoParar()> 0){
        this.setObligadoparar(obligadoparar - asaltos);
    }
    
    if (this.getSinpoderparar()> 0){
        this.setSinpoderparar(sinpoderparar - asaltos);
    }
    
    if (this.getAturdido()> 0){
        this.setAturdido(aturdido - asaltos);
    }
    
   if (this.getAsaltosparamorir() == 0){
            this.setCuerpo(Status.MUERTO);
        }
   }

    public int getPtsDeVidaPerdidos() {
        return ptsDeVidaPerdidos;
    }

    public void setPtsDeVidaPerdidos(int ptsDeVidaPerdidos) {
        this.ptsDeVidaPerdidos = ptsDeVidaPerdidos;
    }

    @Override
    public String toString() {
        return "Status{" + "actividadReducida=" + actividadReducida +", \n cuerpo=" + cuerpo +", \n aturdido=" + aturdido +", \n obligadoparar=" + obligadoparar +", \n sinpoderparar=" + sinpoderparar +", \n asaltosparamorir=" + asaltosparamorir +", \n ptsDeVidaPerdidos=" + ptsDeVidaPerdidos + '}';
    }

    
    

    
    
}
