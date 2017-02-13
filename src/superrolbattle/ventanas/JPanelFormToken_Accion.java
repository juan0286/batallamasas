/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Accion;
import instancias.Token;
import instancias.properties.Status;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import superrolbattle.Principal;

/**
 *
 * @author TiranoJuan
 */
public class JPanelFormToken_Accion extends javax.swing.JPanel {

    /**
     * Creates new form JPanelFormToken
     */
    public JPanelFormToken_Accion() {
        initComponents();
    }

    public JPanelFormToken_Accion(Token token, Principal principal, int faseAsalto)  {
        this.token = token;
        this.faseDeAsalto = faseAsalto;
        this.principal = principal;       
        initComponents();

        jProgressBar_vida.setMinimum(0);
        jProgressBar_vida.setMaximum(token.getPuntosVida());
        jProgressBar_vida.setValue(0);
        // UIManager.put("jProgressBar_vida.selectionBackground", Color.RED);
        // jProgressBar_vida.setIgnoreRepaint(true);
                 
      update();
        this.repaint();
    }
    
    private Token token;
    private Principal principal;
    private Accion accion;
    private boolean done = false;
    private boolean accionDeOportunidad = false;
    private int faseDeAsalto;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isAccionDeOportunidad() {
        return accionDeOportunidad;
    }

    public void setAccionDeOportunidad(boolean accionDeOportunidad) {
        this.accionDeOportunidad = accionDeOportunidad;
    }

    public int getFaseDeAsalto() {
        return faseDeAsalto;
    }

    public void setFaseDeAsalto(int faseDeAsalto) {
        this.faseDeAsalto = faseDeAsalto;
    }

    public void hecho() {
        if (!done) {
            this.done = true;
            token.updateEstado();
            this.setBackground(Color.GREEN);
            this.repaint();
        }
    }

    public void desHecho() {
        this.done = false;
        this.setBackground(new java.awt.Color(240, 240, 240));
        this.repaint();
    }

    public void esperarOportunidad() {
        if (!done) {
            token.updateEstado();
            this.accionDeOportunidad = true;
            this.setBackground(Color.YELLOW);
            this.repaint();
        }
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }
    
    
    
    public void setTipoAccion(int a){
    this.accion.setTipo(a); 
    }

    public void update() {

        jProgressBar_vida.setValue(token.getEstado().getPtsDeVidaPerdidos());

       
      

        if (token.getEstado().getCuerpo() == Status.FIRME) {
            jProgressBar_vida.setForeground(Color.GREEN);           
        } else if (token.getEstado().getCuerpo() == Status.CANSADO) {
            jProgressBar_vida.setForeground(Color.YELLOW);
        } else if (token.getEstado().getCuerpo() == Status.EXHAUSTO) {
            jProgressBar_vida.setForeground(Color.ORANGE);
        } else if (token.getEstado().getCuerpo() == Status.INCOSCIENTE) {
            jProgressBar_vida.setForeground(Color.RED);
        } else if (token.getEstado().getCuerpo() == Status.MUERTO) {
            jProgressBar_vida.setForeground(Color.BLACK);
            this.setBackground(Color.BLACK);
        }
        jProgressBar_vida.setStringPainted(true);   
        jProgressBar_vida.setString(token.vidatxt());
        jProgressBar_vida.repaint();
        
        
        if (token.getEstado().menteEstado() == Status.MENTE_ATURDIDO) {
            jTextArea_estado.setBackground(Color.YELLOW);
        } else if (token.getEstado().menteEstado() == Status.MENTE_ATURDIDO_Y_SIN_PODER_PARAR) {
            jTextArea_estado.setBackground(Color.red);
        } else if (token.getEstado().menteEstado() == Status.MENTE_OBLIGADO_A_PARAR) {
            jTextArea_estado.setBackground(Color.WHITE);
        } else if (token.getEstado().menteEstado() == Status.MENTE_FIRME) {
            jTextArea_estado.setBackground(new java.awt.Color(204, 255, 204));
        }
        //jProgressBar_vida.setForeground(Color.YELLOW);

        this.jLabel_Nombre.setText("" + token.getNombre());
        this.jTextArea_estado.setText(token.textEstado());

        // tooltip
        String tooltip
                = "<html>"
                + "Nivel: " + token.getNivel() + "<br/>"
                + "Puntos de Vida: " + token.vidatxt() + "<br/>"
                + "Estado Fisico: " + token.getEstado().cuerpoString() + "<br/>"
                + "Estado Mental: " + token.getEstado().menteEstado()+ "<br/>"
                + "Actividad: " + token.getEstado().getActividadActual() + "<br/>"
                + "Bo Actual: " + token.boDisponibleAtaque() + "<br/>"
                + "Bd Actual: " + token.getHabilidades().getAgi() + "<br/>"
                + "Equipo: " + token.getManoDER().getArmaEquipada().getNombre() + "<br/>"
                + "" + token.getManoIZQ().getArmaEquipada().getNombre() + "<br/>"
                + "</html>";
        this.setToolTipText(tooltip);

        this.repaint();
    }

    public void iconar(String path) {

        URL url = this.getClass().getResource(path);
        ImageIcon fot = new ImageIcon(url);
        int w = 90;
        int h = 27;
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        //jTextPane_estado.setIcon(icono);
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
        jPanel_general = new javax.swing.JPanel();
        jPanel_estado = new javax.swing.JPanel();
        jTextArea_estado = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setToolTipText("<html>\nEstado: Incosnciente<br/>\nSalud 15 pv  / 230pv<br/>\nBo: 134<br/>\nBd: 20<br/>\nArmadra: Cota de malla 14<br/>\nArma: Espada Doble Filo\n</html>");
        setMaximumSize(new java.awt.Dimension(136, 96));
        setMinimumSize(new java.awt.Dimension(90, 96));
        setPreferredSize(new java.awt.Dimension(136, 96));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel_Nombre.setText("Nombre");
        add(jLabel_Nombre);
        add(jProgressBar_vida);

        jPanel_general.setBackground(new java.awt.Color(204, 255, 204));
        jPanel_general.setLayout(new java.awt.GridLayout(1, 2, 1, 1));

        jPanel_estado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_estado.setLayout(new javax.swing.BoxLayout(jPanel_estado, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea_estado.setColumns(20);
        jTextArea_estado.setRows(5);
        jPanel_estado.add(jTextArea_estado);

        jPanel_general.add(jPanel_estado);

        add(jPanel_general);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked

        if (principal.faseActual() == principal.BUTTONFASE_CREACION) {
            System.out.println("Fase de Creación");
        } else if (principal.faseActual() == principal.BUTTONFASE_DEFINICION) {
            DeclaraAccion da = new DeclaraAccion(principal, true, this);
            da.setLocationRelativeTo(null);
            da.setVisible(true);
        } else if (principal.faseActual() == principal.BUTTONFASE_DESARROLLO) {

            if (evt.isMetaDown()) {
                AlterararToken dt = new AlterararToken(principal, true, this);
                dt.setVisible(true);
                if (token.getEstado().isAturdido() && !done) {
                    DeclaraAccion da = new DeclaraAccion(principal, true, this);
                    da.setLocationRelativeTo(null);
                    da.setVisible(true);
                }
            } else if (principal.asaltoFaseActual() == this.faseDeAsalto) {
                if (evt.isShiftDown()) {
                    this.esperarOportunidad();
                } else {
                    this.hecho();
                }
            } else if (this.isAccionDeOportunidad()) {
                this.hecho();
            }
        }

    }//GEN-LAST:event_formMouseClicked
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JPanel jPanel_estado;
    private javax.swing.JPanel jPanel_general;
    private javax.swing.JProgressBar jProgressBar_vida;
    private javax.swing.JTextArea jTextArea_estado;
    // End of variables declaration//GEN-END:variables

    void AgregarAccion(Accion acc) {

    }
}