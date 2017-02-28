/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Accion;
import instancias.Evento;
import instancias.Sortilegio;
import instancias.Token;
import instancias.properties.Status;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import recursos.Constantes;
import superrolbattle.Principal;
import recursos.Recursos;
import recursos.subprocess.UpdaterProgresBar;

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

    public JPanelFormToken_Accion(Token token, Principal principal) {
        this.token = token;
        this.tipoDeAccion = token.getLastAction().getTipo();
        this.accion = token.getLastAction();
        this.principal = principal;
        initComponents();

        jProgressBar_vida.setMinimum(0);
        jProgressBar_vida.setMaximum(token.getPuntosVida());
        jProgressBar_vida.setValue(0);
        // UIManager.put("jProgressBar_vida.selectionBackground", Color.RED);
        // jProgressBar_vida.setIgnoreRepaint(true);

        update_jTokenAction();
        this.repaint();
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public int getTipoDeAccion() {
        return tipoDeAccion;
    }

    public void setTipoDeAccion(int tipoDeAccion) {
        this.tipoDeAccion = tipoDeAccion;
    }

    public void hecho() {
        if (!accion.isDone()) {
            accion.hecho(this.tipoDeAccion);
            // updDone();
            realizarLaAccion();
            token.updateEstado();
            update_jTokenAction();
            Evento evt = new Evento(recursos.Recursos.evtAccion(accion, token));
            principal.publicarEvento(evt);
        }

    }

    private void verComoDone() {
        this.setBackground(Color.GREEN);
        this.repaint();
    }

    public void desHecho() {
        accion.desHecho();
        if (!accion.isAccionDeOportunidad()) {
            this.setBackground(new java.awt.Color(240, 240, 240));
        } else {
            verComoAccOportunidad();
        }
        this.repaint();
    }

    public void esperarOportunidad() {
        if (!accion.isDone()) {
            token.updateEstado();
            accion.esperarOportunidad();
            Evento e = new Evento(Recursos.evtOportunidad(token));
            principal.publicarEvento(e);
            update_jTokenAction();
        }
    }

    private void verComoAccOportunidad() {
        this.setBackground(Color.YELLOW);
        this.repaint();
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public void setTipoAccion(int a) {
        this.accion.setTipo(a);
    }

    public void update_jTokenAction() {

        if (accion.isDone() && token.getEstado().getCuerpo() < Status.INCOSCIENTE) {
            verComoDone();
        }
        if (accion.isAccionDeOportunidad()) {
            verComoAccOportunidad();
        }
        int n = jProgressBar_vida.getValue() - token.getEstado().getPtsDeVidaPerdidos();
        UpdaterProgresBar up = new UpdaterProgresBar(jProgressBar_vida, n);
        up.start();
        jProgressBar_vida.setString(token.vidatxt());
        
        /*
        *   Para version Sin barra Movil usar el siguiente Codigo
        */
        /*
        jProgressBar_vida.setValue(token.getEstado().getPtsDeVidaPerdidos());
        jProgressBar_vida.setStringPainted(true);
        jProgressBar_vida.setString(token.vidatxt());
        jProgressBar_vida.repaint();
*/
        if (token.getEstado().getCuerpo() == Status.FIRME) {
            //jProgressBar_vida.setForeground(Color.GREEN);
        } else if (token.getEstado().getCuerpo() == Status.CANSADO) {
            //jProgressBar_vida.setForeground(Color.YELLOW);
        } else if (token.getEstado().getCuerpo() == Status.EXHAUSTO) {
            //jProgressBar_vida.setForeground(Color.ORANGE);
        } else if (token.getEstado().getCuerpo() == Status.INCOSCIENTE) {
            jProgressBar_vida.setForeground(Color.GRAY);
            dejarFueraDeCombate();
            this.setBackground(Color.GRAY);
        } else if (token.getEstado().getCuerpo() == Status.MUERTO) {
            jProgressBar_vida.setForeground(Color.BLACK);
            dejarFueraDeCombate();
            this.setBackground(Color.BLACK);
        } else if (token.getEstado().getCuerpo() != Status.MUERTO) {
            jTextArea_estado.setBackground(new java.awt.Color(204, 255, 204));
        }
        
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
                + "Estado Mental: " + token.getEstado().menteEstadoTxt() + "<br/>"
                + "Actividad: " + token.getEstado().getActividadActual() + "<br/>"
                + "Bo Actual: " + token.boDisponibleAtaque() + "<br/>"
                + "Bd Actual: " + token.getHabilidades().getBd()+ "<br/>"
                //+ "Equipo: " + token.getManoDER().getArmaEquipada().getNombre() + "<br/>"
                //+ "" + token.getManoIZQ().getArmaEquipada().getNombre() + "<br/>"
                + "</html>";
        this.setToolTipText(tooltip);

        this.repaint();
    }

    

    public void iconar(String path) { 
        ImageIcon icon = new ImageIcon(path);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(81, 65, Image.SCALE_DEFAULT));
        jLabel_icono.setText(null);
        jLabel_icono.setIcon(icono);        
        this.repaint();

    }

    public void realizarLaAccion() {
        switch (accion.getTipo()) {
            case Constantes.TIPO_ACCION_SIN_ACCION: {

                break;
            }
            case Constantes.TIPO_ACCION_CARGA_SORTILEGIO: {
                token.cargarUnSortilegio(accion.getSort_intencion());
                accion.setSortilegio(accion.getSort_intencion());
                break;
            }
            case Constantes.TIPO_ACCION_REALIZA_SORTILEGIO: {
                token.lanzarUnSortilegio(accion.getSort_intencion());
                accion.setSortilegio(accion.getSort_intencion());
                break;
            }
            case Constantes.TIPO_ACCION_DISPARA_PROYECTIL: {

                break;
            }
            case Constantes.TIPO_ACCION_CARGA_PROYECTIL: {

                break;
            }
            case Constantes.TIPO_ACCION_PARAR_PROYECTIL: {

                break;
            }
            case Constantes.TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA: {

                break;
            }
            case Constantes.TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO: {

                break;
            }
            case Constantes.TIPO_ACCION_DESPLAZAMIENTO: {

                break;
            }
            case Constantes.TIPO_ACCION_MOVIMIENTO_ESTATICO: {

                break;
            }
            default: {

                break;
            }
        }
        if (accion.getTipo() != Constantes.TIPO_ACCION_CARGA_SORTILEGIO) {
            token.perderLaCarga();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel_Nombre = new javax.swing.JLabel();
        jProgressBar_vida = new javax.swing.JProgressBar();
        jPanel_general = new javax.swing.JPanel();
        jPanel_estado = new javax.swing.JPanel();
        jTextArea_estado = new javax.swing.JTextArea();
        jPanel_Icono = new javax.swing.JPanel();
        jLabel_icono = new javax.swing.JLabel();
        jPanel_Accion = new javax.swing.JPanel();
        jTextArea_Desc_accion = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setToolTipText("<html>\nEstado: Incosnciente<br/>\nSalud 15 pv  / 230pv<br/>\nBo: 134<br/>\nBd: 20<br/>\nArmadra: Cota de malla 14<br/>\nArma: Espada Doble Filo\n</html>");
        setMaximumSize(new java.awt.Dimension(250, 105));
        setMinimumSize(new java.awt.Dimension(250, 100));
        setPreferredSize(new java.awt.Dimension(250, 105));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(32767, 24));

        jLabel_Nombre.setText("Nombre");
        jPanel1.add(jLabel_Nombre);
        jPanel1.add(jProgressBar_vida);

        add(jPanel1);

        jPanel_general.setBackground(new java.awt.Color(204, 255, 204));
        jPanel_general.setMaximumSize(new java.awt.Dimension(32767, 74));
        jPanel_general.setMinimumSize(new java.awt.Dimension(95, 72));
        jPanel_general.setPreferredSize(new java.awt.Dimension(446, 72));
        jPanel_general.setLayout(new java.awt.GridLayout(1, 2, 1, 1));

        jPanel_estado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_estado.setMaximumSize(new java.awt.Dimension(11111, 74));
        jPanel_estado.setMinimumSize(new java.awt.Dimension(0, 74));
        jPanel_estado.setLayout(new javax.swing.BoxLayout(jPanel_estado, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea_estado.setEditable(false);
        jTextArea_estado.setColumns(20);
        jTextArea_estado.setFont(new java.awt.Font("MS PGothic", 0, 10)); // NOI18N
        jTextArea_estado.setRows(5);
        jPanel_estado.add(jTextArea_estado);

        jPanel_general.add(jPanel_estado);

        jPanel_Icono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_Icono.setMaximumSize(new java.awt.Dimension(11111, 74));
        jPanel_Icono.setMinimumSize(new java.awt.Dimension(0, 74));
        jPanel_Icono.setLayout(new javax.swing.BoxLayout(jPanel_Icono, javax.swing.BoxLayout.LINE_AXIS));

        jLabel_icono.setText("Icono");
        jPanel_Icono.add(jLabel_icono);

        jPanel_general.add(jPanel_Icono);

        jPanel_Accion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_Accion.setMaximumSize(new java.awt.Dimension(11111, 74));
        jPanel_Accion.setMinimumSize(new java.awt.Dimension(0, 74));
        jPanel_Accion.setLayout(new javax.swing.BoxLayout(jPanel_Accion, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea_Desc_accion.setEditable(false);
        jTextArea_Desc_accion.setColumns(20);
        jTextArea_Desc_accion.setFont(new java.awt.Font("MS PGothic", 0, 10)); // NOI18N
        jTextArea_Desc_accion.setRows(5);
        jPanel_Accion.add(jTextArea_Desc_accion);

        jPanel_general.add(jPanel_Accion);

        add(jPanel_general);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        clickAccion(evt.isShiftDown(), evt.isControlDown(), evt.isMetaDown());

    }//GEN-LAST:event_formMouseClicked

    public void intentarSortilegio(Sortilegio s) {
        token.intentarSortilegio(s);
    }

    public void clickAccion(boolean shift, boolean ctrl, boolean clickDerecho) {
        Accion a = null;

        if (principal.faseActual() == principal.BUTTONFASE_CREACION) {
            System.out.println("Fase de Creación");
        } else if (principal.faseActual() == principal.BUTTONFASE_DEFINICION) {
            if (token.getEstado().isAturdido()) {
                a = DeclaraAccion.DeclararAccion(principal, true, this, DeclaraAccion.MODO_ATURDIDO);
            } else {
                a = DeclaraAccion.DeclararAccion(principal, true, this, DeclaraAccion.MODO_NORMAL);
            }
        } else if (principal.faseActual() == principal.BUTTONFASE_DESARROLLO) {

            if (ctrl && tipoDeAccion >= principal.asaltoFase && !accion.isDone()) {
                if (token.getLastAction().isCambioDeAccion()) {
                    recursos.Recursos.informar("Ya se cambio de Accion en este Asalto");
                } else {
                    a = DeclaraAccion.DeclararAccion(principal, true, this, DeclaraAccion.MODO_CAMBIO_DE_ACCION);
                }
                if (a != null) {
                    a.setCambioDeAccion(true);
                    principal.creaEvento(token.getNombre() + " Cambia de Accion");
                }
            } else if (clickDerecho) {
                AlterararToken dt = new AlterararToken(principal, true, this);
                dt.setVisible(true);
                if (token.getEstado().isAturdido() && !accion.isDone()) {
                    a = DeclaraAccion.DeclararAccion(principal, true, this, DeclaraAccion.MODO_ATURDIDO);
                }

            } else if (!accion.isDone() && principal.asaltoFase == this.tipoDeAccion) {
                if (shift) {
                    esperarOportunidad();
                } else {
                    this.hecho();
                }
            } else if (accion.isAccionDeOportunidad()) {
                this.hecho();
            }

        }
        if (a != null) {
            accion = a;
            tipoDeAccion = a.getTipo();
            jTextArea_Desc_accion.setText(a.getFullDescp());
            jTextArea_Desc_accion.setToolTipText(a.getFullDescp());
            
            mover(accion.getTipo());
        }
    }

    public void dejarFueraDeCombate() {
        mover(Constantes.TIPO_ACCION_SIN_ACCION);

    }

    public void mover(int destino) {
        principal.moverAccion(this, destino);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_icono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_Accion;
    private javax.swing.JPanel jPanel_Icono;
    private javax.swing.JPanel jPanel_estado;
    private javax.swing.JPanel jPanel_general;
    private javax.swing.JProgressBar jProgressBar_vida;
    private javax.swing.JTextArea jTextArea_Desc_accion;
    private javax.swing.JTextArea jTextArea_estado;
    // End of variables declaration//GEN-END:variables

    private Token token;
    private Principal principal;
    private Accion accion;
    private int tipoDeAccion;

    /*private boolean done = false;
    private boolean accionDeOportunidad = false;
    

    void AgregarAccion(Accion acc) {

    }
     */
}
