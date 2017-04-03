/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import instancias.Token;
import instancias.properties.Status;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import recursos.AbrirGuardar;
import recursos.Constantes;
import recursos.Recursos;
import superrolbattle.Principal;

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

    public JPanelFormToken(Token token, JFrame principal, JPanelFormToken_Accion jpa) {
        this.token = token;
        this.jpa = jpa;
        this.principal = principal;
        initComponents();
        jProgressBar_vida.setMinimum(0);
        jProgressBar_vida.setMaximum(token.getPuntosVidaActual());
        jProgressBar_vida.setValue(0);

        update();
        this.repaint();
    }

    public void update() {

        jProgressBar_vida.setValue(token.getPuntosVidaActual() - token.getEstado().getPtsDeVidaPerdidos());

        jProgressBar_vida.setStringPainted(false);
        jProgressBar_vida.setBackground(Color.YELLOW);

        if (token.getEstado().getCuerpo() == Status.FIRME) {
            jProgressBar_vida.setForeground(Color.GREEN);
        } else if (token.getEstado().getCuerpo() == Status.CANSADO) {
            jProgressBar_vida.setForeground(Color.YELLOW);
        } else if (token.getEstado().getCuerpo() == Status.EXHAUSTO) {
            jProgressBar_vida.setForeground(Color.ORANGE);
        } else if (token.getEstado().getCuerpo() == Status.DORMIDO_INCONSCIENTE) {
            jProgressBar_vida.setForeground(Color.RED);
        } else if (token.getEstado().getCuerpo() == Status.MUERTO) {
            jProgressBar_vida.setForeground(Color.BLACK);
        }
        jProgressBar_vida.setForeground(Color.YELLOW);

        this.jLabel_Nombre.setText("" + token.getNombre());

        setearToolTip();

        if (token.getUrlIcon() != null) {
            iconar(token.getUrlIcon());
        }
    }

    private void setearToolTip() {
        // tooltip
        int arm = token.getArmaduraPuesta();
        String tooltip
                = "<html>"
                + "Nivel: " + token.getNivel() + "<br/>"
                + "Puntos de Vida: " + token.getEstado().getPtsDeVidaPerdidos() + "  /  " + token.getPuntosVidaActual() + "<br/>"
                + "Estado: " + token.getEstado().cuerpoString() + "<br/>"
                + "Actividad: " + token.getEstado().getActividadActual() + "<br/>"
                + "Arm: " + token.getMmActualTxt() + "<br/>"
                + "Puntos de Poder: " + token.podertxt() + "<br/>"
                + "Caract: FUE " + token.getHabilidad(Constantes.HABILIDAD_CAR_FUE)
                + ", AGI " + token.getHabilidad(Constantes.HABILIDAD_CAR_AGI)
                + ", CON " + token.getHabilidad(Constantes.HABILIDAD_CAR_CON)
                + ", I " + token.getHabilidad(Constantes.HABILIDAD_CAR_I)
                + ", INT " + token.getHabilidad(Constantes.HABILIDAD_CAR_INT)
                + ", PRE " + token.getHabilidad(Constantes.HABILIDAD_CAR_PRE) + "<br/>"
                + "MM: ";
        for (int i = Constantes.HABILIDAD_MM_SINARMADURA; i <= Constantes.HABILIDAD_MM_CORAZA; i++) {
            boolean estaarmaduratienepuesta = (Recursos.movManParaArmadura(arm) == i);
            tooltip += (estaarmaduratienepuesta)? "<Strong>" : "";            
            tooltip += (i == Constantes.HABILIDAD_MM_SINARMADURA)? "" : ", ";            
            tooltip +=  Recursos.armaduraTxt(i) + " " + token.getHabilidad(i);
            tooltip += (estaarmaduratienepuesta)? "</strong>" : "";
        }
        tooltip += "</html>";
        this.setToolTipText(tooltip);
    }

    public void iconar(String path) {
        /*
        URL url = this.getClass().getResource(path);
        ImageIcon fot = new ImageIcon(url);
        int w = 90;
        int h = 27;
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(w, h, Image.SCALE_DEFAULT));
        jLabel_avatar.setIcon(icono);
        this.repaint();
         */

        ImageIcon icon = new ImageIcon(path);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(77, 77, Image.SCALE_DEFAULT));
        token.setUrlIcon(path);
        jLabel_avatar.setText(null);
        jLabel_avatar.setIcon(icono);
        jpa.iconar(path);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuEditar = new javax.swing.JMenuItem();
        jMenuItem_cambiarIcono = new javax.swing.JMenuItem();
        jLabel_Nombre = new javax.swing.JLabel();
        jProgressBar_vida = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel_avatar = new javax.swing.JLabel();
        jCheckBox_activo = new javax.swing.JCheckBox();

        jPopupMenu1.setLabel("Editar");

        jMenuEditar.setText("Editar");
        jMenuEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuEditar);

        jMenuItem_cambiarIcono.setText("Cambiar Icono");
        jMenuItem_cambiarIcono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_cambiarIconoActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem_cambiarIcono);

        setBorder(javax.swing.BorderFactory.createEtchedBorder());
        setToolTipText("<html>\nEstado: Incosnciente<br/>\nSalud 15 pv  / 230pv<br/>\nBo: 134<br/>\nBd: 20<br/>\nArmadra: Cota de malla 14<br/>\nArma: Espada Doble Filo\n</html>");
        setComponentPopupMenu(jPopupMenu1);
        setMinimumSize(new java.awt.Dimension(146, 109));
        setPreferredSize(new java.awt.Dimension(146, 109));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        jLabel_Nombre.setText("Nombre");
        jLabel_Nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_NombreMouseClicked(evt);
            }
        });
        add(jLabel_Nombre, java.awt.BorderLayout.PAGE_START);

        jProgressBar_vida.setBackground(new java.awt.Color(0, 255, 0));
        jProgressBar_vida.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar_vida.setStringPainted(true);
        add(jProgressBar_vida, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setLayout(new java.awt.GridLayout(1, 1));

        jLabel_avatar.setText("Icono");
        jLabel_avatar.setPreferredSize(new java.awt.Dimension(127, 74));
        jLabel_avatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_avatarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabel_avatar);

        add(jPanel1, java.awt.BorderLayout.SOUTH);

        jCheckBox_activo.setSelected(true);
        jCheckBox_activo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_activoItemStateChanged(evt);
            }
        });
        add(jCheckBox_activo, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel_avatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_avatarMouseClicked
        if (token.getUrlIcon() == null) {
            cargarArhivo();
        }
    }//GEN-LAST:event_jLabel_avatarMouseClicked

    private void jMenuEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEditarActionPerformed
        Token t = CrearToken.editarToken(true, token);
        if (t != null) {
            token = t;
            setearToolTip();
            //((Principal)principal).agregarToken(t);

        }

    }//GEN-LAST:event_jMenuEditarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        //if (evt.isMetaDown())

    }//GEN-LAST:event_formMouseClicked

    private void jMenuItem_cambiarIconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_cambiarIconoActionPerformed
        cargarArhivo();
    }//GEN-LAST:event_jMenuItem_cambiarIconoActionPerformed

    private void jCheckBox_activoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_activoItemStateChanged
        jpa.setActivo(jCheckBox_activo.isSelected());
        
    }//GEN-LAST:event_jCheckBox_activoItemStateChanged

    private void jLabel_NombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_NombreMouseClicked
        Principal p = (Principal) principal;
        p.cambiarAAsaltopanel(jpa);        
    }//GEN-LAST:event_jLabel_NombreMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox_activo;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_avatar;
    private javax.swing.JMenuItem jMenuEditar;
    private javax.swing.JMenuItem jMenuItem_cambiarIcono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JProgressBar jProgressBar_vida;
    // End of variables declaration//GEN-END:variables
    private Token token;
    private JFrame principal;
    private JPanelFormToken_Accion jpa;

    private void cargarArhivo() {

        File fichero;
        int resultado;
        SeleccionarArchivo ventana = new SeleccionarArchivo(principal, true);
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        ventana.jfchCargarfoto.setFileFilter(filtro);
        resultado = ventana.jfchCargarfoto.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado) {

            fichero = ventana.jfchCargarfoto.getSelectedFile();
            try {
                AbrirGuardar.GuardarDir(fichero.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(JPanelFormToken.class.getName()).log(Level.SEVERE, null, ex);
            }
            File ficheroNew = Recursos.copiarIcono(fichero, token.getNombre());
            if (ficheroNew != null) {
                try {
                    iconar(ficheroNew.toString());
                } catch (Exception ex) {
                    Recursos.informar("Error abriendo laimagen " + ex);
                }

            }

        }
    }

}
