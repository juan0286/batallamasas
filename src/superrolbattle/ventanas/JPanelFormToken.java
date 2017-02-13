/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Token;
import instancias.properties.Status;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

/**
 *
 * @author TiranoJuan
 */
public class JPanelFormToken extends javax.swing.JPanel {

    /**
     * Creates new form JPanelFormToken
     */
    public JPanelFormToken() {
         initComponents();
    }
    public JPanelFormToken(Token token) {
        this.token = token;
         initComponents();
        jProgressBar_vida.setMinimum(0);
        jProgressBar_vida.setMaximum(token.getPuntosVida());
        jProgressBar_vida.setValue(0);
       
        update();
        this.repaint();
    }
    
    private Token token;
    
    public void update(){
         
         
        jProgressBar_vida.setValue(token.getPuntosVida() - token.getEstado().getPtsDeVidaPerdidos());
         
        jProgressBar_vida.setStringPainted(false);
        jProgressBar_vida.setBackground(Color.YELLOW);
        
        if(token.getEstado().getCuerpo() == Status.FIRME)
            jProgressBar_vida.setForeground(Color.GREEN);
        else if (token.getEstado().getCuerpo() == Status.CANSADO)
            jProgressBar_vida.setForeground(Color.YELLOW);
        else if (token.getEstado().getCuerpo() == Status.EXHAUSTO)
            jProgressBar_vida.setForeground(Color.ORANGE);
        else if (token.getEstado().getCuerpo() == Status.INCOSCIENTE)
            jProgressBar_vida.setForeground(Color.RED);
        else if (token.getEstado().getCuerpo() == Status.MUERTO)
            jProgressBar_vida.setForeground(Color.BLACK);
         jProgressBar_vida.setForeground(Color.YELLOW);
        
        this.jLabel_Nombre.setText("" + token.getNombre());  
        
        // tooltip
        String tooltip =
                "<html>"+
                "Nivel: "+  token.getNivel() + "<br/>"+
                "Puntos de Vida: "+ token.getEstado().getPtsDeVidaPerdidos() +"  /  "+ token.getPuntosVida() +"<br/>"+
                "Estado: "+ token.getEstado().cuerpoString() +"<br/>"+
                "Actividad: "+ token.getEstado().getActividadReducida()+"<br/>"+
                
                "Bo Actual: "+ token.boDisponibleAtaque() +"<br/>"+
                "Bd Actual: "+ token.getHabilidades().getBd()+"<br/>"+
                "Equipo: "+ token.getManoDER().getArmaEquipada().getNombre() +"<br/>"+
                ""+ token.getManoIZQ().getArmaEquipada().getNombre() +"<br/>"+
                "</html>";
        this.setToolTipText(tooltip);
        
    }
    
       public void iconar(String path) {

        URL url = this.getClass().getResource(path);
        ImageIcon fot = new ImageIcon(url);
        int w = 90;
        int h = 27;
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        jLabel1.setIcon(icono);
        this.repaint();

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Nombre = new javax.swing.JLabel();
        jProgressBar_vida = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setToolTipText("<html>\nEstado: Incosnciente<br/>\nSalud 15 pv  / 230pv<br/>\nBo: 134<br/>\nBd: 20<br/>\nArmadra: Cota de malla 14<br/>\nArma: Espada Doble Filo\n</html>");
        setMinimumSize(new java.awt.Dimension(146, 109));
        setPreferredSize(new java.awt.Dimension(146, 109));
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

        jLabel_Nombre.setText("Nombre");
        add(jLabel_Nombre);

        jProgressBar_vida.setBackground(new java.awt.Color(0, 255, 0));
        jProgressBar_vida.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar_vida.setStringPainted(true);
        add(jProgressBar_vida);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar_vida;
    // End of variables declaration//GEN-END:variables
}
