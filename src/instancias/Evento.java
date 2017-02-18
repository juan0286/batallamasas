/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instancias;

import java.io.Serializable;

/**
 *
 * @author TiranoJuan
 */
public class Evento implements Serializable{
    
    
    private String desc;
    private int asalto;
    private boolean visible;

    public Evento(String desc, int asalto) {
        this.desc = desc;
        this.asalto = asalto;
    }

    public Evento(String desc) {
        this.desc = desc;
        this.asalto = -1;
    }   

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getAsalto() {
        return asalto;
    }

    public void setAsalto(int asalto) {
        this.asalto = asalto;
    }
    public boolean noTieneAsalto(){
        return this.asalto == -1;
    }
    
    
}
