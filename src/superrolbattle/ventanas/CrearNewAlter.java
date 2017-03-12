/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Token;
import instancias.properties.alteracion.Alteracion;
import instancias.properties.Status;
import instancias.properties.alteracion.Curacion;
import instancias.properties.alteracion.Efecto;
import instancias.properties.alteracion.Herida;
import instancias.properties.alteracion.Mod;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import recursos.Constantes;
import recursos.Recursos;

/**
 *
 * @author Juan
 */
public class CrearNewAlter extends javax.swing.JDialog {

    /**
     * Creates new form DañarToken
     */
    public CrearNewAlter(java.awt.Frame parent, boolean modal, JPanelFormToken_Accion token_accion) {
        super(parent, modal);
        initComponents();
        this.setTitle("Altarar a " + token_accion.getToken().getNombre());
        this.panel_token = token_accion;

        jTextField_Actual_pv.setText(token_accion.getToken().vidatxt());

        Token t = token_accion.getToken();
        int c = t.getEstado().getCuerpo();

        if (c == Status.FIRME) {
            jRadioButton_Firme.setBackground(Color.blue);
        }
        if (c == Status.POSTRADO) {
            jRadioButton_postrado.setBackground(Color.blue);
        }
        if (c == Status.DORMIDO) {
            jRadioButton_Dormido.setBackground(Color.blue);
        }
        if (c == Status.MUERTO) {
            jRadioButton_muerto.setBackground(Color.blue);
        }
        numerar();
//        int san = token.getToken().getEstado().getSangradoPorAsalto();
//
//        jTextField_Actual_sangrado.setText(String.valueOf(san));
//        if (san > 0) {
//            jTextField_Actual_sangrado.setBackground(Color.red);
//        }
//
//        int at = token.getToken().getEstado().getAturdido();
//        jTextField_Actual_aturdido.setText(String.valueOf(at));
//        if (at > 0) {
//            jTextField_Actual_aturdido.setBackground(Color.yellow);
//        }
//
//        int atuSP = token.getToken().getEstado().getSinpoderparar();
//        jTextField_Actual_aturdidoSinParar.setText(String.valueOf(atuSP));
//        if (atuSP > 0) {
//            jTextField_Actual_aturdidoSinParar.setBackground(Color.red);
//        }
//
//        int hm = token.getToken().getEstado().getAsaltosparamorir();
//        /* jTextField_Actual_HastaMorir.setText(String.valueOf(hm));
//        if (hm > 0){
//            jTextField_Actual_HastaMorir.setBackground(Color.black);
//            jTextField_Actual_HastaMorir.setForeground(Color.white);
//        }
//         */
//        int oap = token.getToken().getEstado().getObligadoParar();
//        jTextField_Actual_obligadoParar.setText(String.valueOf(oap));
//        if (oap > 0) {
//            jTextField_Actual_obligadoParar.setBackground(Color.green);
//        }
//
//        jTextField_Actual_bo.setText(String.valueOf(token.getToken().getEstado().getBoModidificada()));
//        jTextField_Actual_Bd.setText(String.valueOf(token.getToken().getEstado().getBdModificada()));
//        jTextField_Actual_MM.setText(String.valueOf(token.getToken().getEstado().getModsDeMm()));
//
//        jTextField_Actual_Actividad.setText(String.valueOf(token.getToken().getEstado().getActividadActual()));
//
//        jCheckBox_brazo_izq.setSelected(!token.getToken().getManoIZQ().isHabilitado());
//        jCheckBox_brazo_der.setSelected(!token.getToken().getManoDER().isHabilitado());
//        //jCheckBox_brazo_izq.setSelected(!token.getToken().getManoIZQ().isHabilitado());
//        //jCheckBox_brazo_izq.setSelected(!token.getToken().getManoIZQ().isHabilitado());
//
//        jRadioButton_muerto.setSelected(token.getToken().getEstado().getCuerpo() == Status.MUERTO);
//        jRadioButton_Dormido.setSelected(token.getToken().getEstado().getCuerpo() == Status.DORMIDO);
//        jRadioButton_coma.setSelected(token.getToken().getEstado().getCuerpo() == Status.COMA);
//        jRadioButton_postrado.setSelected(token.getToken().getEstado().isPostrado());
        this.setLocationRelativeTo(null);
    }

    private void numerar() {
        int n = (jRadioButton_sanar.isSelected()) ? 1 : -1;
        jComboBox_pv.removeAllItems();
        for (int i = 0; i < num_max; i++) {
            jComboBox_pv.addItem(i * n);
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

        buttonGroup_EstadoFisico = new javax.swing.ButtonGroup();
        jPanel_Aceptar_cancelar = new javax.swing.JPanel();
        jButton_aceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup_Tipo_Alt = new javax.swing.ButtonGroup();
        jPanel_curacion = new javax.swing.JPanel();
        jPanel3_Status2 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jRadioButton_herir = new javax.swing.JRadioButton();
        jPanel25 = new javax.swing.JPanel();
        jRadioButton_sanar = new javax.swing.JRadioButton();
        jPanel37 = new javax.swing.JPanel();
        jRadioButton_farmear = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox_pv = new javax.swing.JComboBox();
        jTextField_Actual_pv = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_efectos = new javax.swing.JList<>();
        jPanel26 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_efectos1 = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList_efectos2 = new javax.swing.JList<>();
        jPanel29 = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel36 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList_efectos4 = new javax.swing.JList<>();
        jPanel3_Status1 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jRadioButton_Firme = new javax.swing.JRadioButton();
        jPanel17 = new javax.swing.JPanel();
        jRadioButton_postrado = new javax.swing.JRadioButton();
        jPanel20 = new javax.swing.JPanel();
        jRadioButton_Dormido = new javax.swing.JRadioButton();
        jPanel35 = new javax.swing.JPanel();
        jRadioButton_coma = new javax.swing.JRadioButton();
        jPanel12 = new javax.swing.JPanel();
        jRadioButton_muerto = new javax.swing.JRadioButton();
        jSpinner_asParamoriri1 = new javax.swing.JSpinner();
        jPanel30 = new javax.swing.JPanel();
        jPanel_descripcion = new javax.swing.JPanel();
        jScrollPane_Resumen = new javax.swing.JScrollPane();
        jTextArea_descp = new javax.swing.JTextArea();
        jPanel_Aceptar_cancelar1 = new javax.swing.JPanel();
        jButton_aceptar1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jPanel_Aceptar_cancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_Aceptar_cancelar.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton_aceptar.setText("Aceptar");
        jButton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aceptarActionPerformed(evt);
            }
        });
        jPanel_Aceptar_cancelar.add(jButton_aceptar);

        jButton2.setText("Cancelar");
        jPanel_Aceptar_cancelar.add(jButton2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel_curacion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_curacion.setLayout(new javax.swing.BoxLayout(jPanel_curacion, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3_Status2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3_Status2.setLayout(new javax.swing.BoxLayout(jPanel3_Status2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel33.setLayout(new javax.swing.BoxLayout(jPanel33, javax.swing.BoxLayout.LINE_AXIS));

        jPanel18.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_Tipo_Alt.add(jRadioButton_herir);
        jRadioButton_herir.setSelected(true);
        jRadioButton_herir.setText("Herir");
        jRadioButton_herir.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton_herirStateChanged(evt);
            }
        });
        jPanel18.add(jRadioButton_herir);

        jPanel33.add(jPanel18);

        jPanel25.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_Tipo_Alt.add(jRadioButton_sanar);
        jRadioButton_sanar.setText("Sanar");
        jRadioButton_sanar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButton_sanarStateChanged(evt);
            }
        });
        jPanel25.add(jRadioButton_sanar);

        jPanel33.add(jPanel25);

        jPanel37.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_Tipo_Alt.add(jRadioButton_farmear);
        jRadioButton_farmear.setText("Farmear");
        jPanel37.add(jRadioButton_farmear);

        jPanel33.add(jPanel37);

        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));
        jPanel33.add(jPanel13);

        jPanel3_Status2.add(jPanel33);

        jPanel_curacion.add(jPanel3_Status2);

        jPanel23.setLayout(new javax.swing.BoxLayout(jPanel23, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Puntos de vida");
        jPanel6.add(jLabel1);

        jPanel23.add(jPanel6);

        jComboBox_pv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_pv.setMaximumSize(new java.awt.Dimension(50, 20));
        jComboBox_pv.setMinimumSize(new java.awt.Dimension(50, 20));
        jComboBox_pv.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel4.add(jComboBox_pv);

        jTextField_Actual_pv.setEditable(false);
        jTextField_Actual_pv.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_pv.setName(""); // NOI18N
        jTextField_Actual_pv.setPreferredSize(new java.awt.Dimension(65, 20));
        jPanel4.add(jTextField_Actual_pv);

        jPanel23.add(jPanel4);

        jPanel_curacion.add(jPanel23);

        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel21.setLayout(new java.awt.BorderLayout());

        jPanel24.setLayout(new javax.swing.BoxLayout(jPanel24, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.PAGE_AXIS));

        jButton1.setText("Agregar Efecto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);

        jPanel22.add(jPanel1);

        jPanel24.add(jPanel22);

        jList_efectos.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(jList_efectos);

        jPanel24.add(jScrollPane2);

        jPanel21.add(jPanel24, java.awt.BorderLayout.PAGE_END);

        jTabbedPane1.addTab("Nuevos Daños", jPanel21);

        jPanel26.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel26.setLayout(new javax.swing.BoxLayout(jPanel26, javax.swing.BoxLayout.LINE_AXIS));

        jPanel28.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 5));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Heridas"));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(148, 150));

        jList_efectos1.setModel(new DefaultListModel());
        jScrollPane3.setViewportView(jList_efectos1);

        jPanel28.add(jScrollPane3);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder("Efectos"));
        jScrollPane4.setPreferredSize(new java.awt.Dimension(148, 150));

        jList_efectos2.setModel(new DefaultListModel());
        jScrollPane4.setViewportView(jList_efectos2);

        jPanel28.add(jScrollPane4);

        jPanel26.add(jPanel28);

        jTabbedPane1.addTab("Heridas", jPanel26);

        jPanel29.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.PAGE_AXIS));

        jButton3.setText("Agregar Efecto");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jPanel27.add(jPanel2);

        jPanel29.add(jPanel27);

        jPanel36.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 5));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane6.setPreferredSize(new java.awt.Dimension(278, 150));

        jList_efectos4.setModel(new DefaultListModel());
        jScrollPane6.setViewportView(jList_efectos4);

        jPanel36.add(jScrollPane6);

        jPanel29.add(jPanel36);

        jTabbedPane1.addTab("Mods", jPanel29);

        jPanel_curacion.add(jTabbedPane1);

        jPanel3_Status1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel3_Status1.setLayout(new javax.swing.BoxLayout(jPanel3_Status1, javax.swing.BoxLayout.LINE_AXIS));

        jPanel32.setLayout(new javax.swing.BoxLayout(jPanel32, javax.swing.BoxLayout.LINE_AXIS));

        jPanel34.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_EstadoFisico.add(jRadioButton_Firme);
        jRadioButton_Firme.setText("Firme");
        jPanel34.add(jRadioButton_Firme);

        jPanel32.add(jPanel34);

        jPanel17.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_EstadoFisico.add(jRadioButton_postrado);
        jRadioButton_postrado.setText("Postrado");
        jPanel17.add(jRadioButton_postrado);

        jPanel32.add(jPanel17);

        jPanel20.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_EstadoFisico.add(jRadioButton_Dormido);
        jRadioButton_Dormido.setText("Dormido");
        jPanel20.add(jRadioButton_Dormido);

        jPanel32.add(jPanel20);

        jPanel35.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_EstadoFisico.add(jRadioButton_coma);
        jRadioButton_coma.setText("Coma");
        jPanel35.add(jRadioButton_coma);

        jPanel32.add(jPanel35);

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        buttonGroup_EstadoFisico.add(jRadioButton_muerto);
        jRadioButton_muerto.setText("Muerto en");
        jPanel12.add(jRadioButton_muerto);

        jSpinner_asParamoriri1.setModel(new javax.swing.SpinnerNumberModel(0, 0, 25, 1));
        jSpinner_asParamoriri1.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_asParamoriri1.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel12.add(jSpinner_asParamoriri1);

        jPanel32.add(jPanel12);

        jPanel3_Status1.add(jPanel32);

        jPanel_curacion.add(jPanel3_Status1);

        getContentPane().add(jPanel_curacion);

        jPanel30.setLayout(new javax.swing.BoxLayout(jPanel30, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel_descripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));
        jPanel_descripcion.setPreferredSize(new java.awt.Dimension(100, 119));
        jPanel_descripcion.setLayout(new javax.swing.BoxLayout(jPanel_descripcion, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea_descp.setColumns(20);
        jTextArea_descp.setRows(5);
        jScrollPane_Resumen.setViewportView(jTextArea_descp);

        jPanel_descripcion.add(jScrollPane_Resumen);

        jPanel30.add(jPanel_descripcion);

        getContentPane().add(jPanel30);

        jPanel_Aceptar_cancelar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_Aceptar_cancelar1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton_aceptar1.setText("Aceptar");
        jButton_aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aceptar1ActionPerformed(evt);
            }
        });
        jPanel_Aceptar_cancelar1.add(jButton_aceptar1);

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel_Aceptar_cancelar1.add(jButton4);

        getContentPane().add(jPanel_Aceptar_cancelar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aplicarActionPerformed

        aplicar();
        this.dispose();


    }//GEN-LAST:event_jButton_aplicarActionPerformed

    private void jButton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {
        aplicar();
        this.dispose();
    }

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nuevoEfecto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton_herirStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton_herirStateChanged
        numerar();
    }//GEN-LAST:event_jRadioButton_herirStateChanged

    private void jRadioButton_sanarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButton_sanarStateChanged
        numerar();
    }//GEN-LAST:event_jRadioButton_sanarStateChanged

    private void jButton_aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aceptar1ActionPerformed
        aplicar();
        this.dispose();
    }//GEN-LAST:event_jButton_aceptar1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void aplicar() {
        instancias.Token tok = panel_token.getToken();
       

        //int mod = (jCheckBox_daño_curacion.isSelected()) ? -1 : 1;
        if (jRadioButton_herir.isSelected()) {

            Herida h = new Herida();

            h.setPv(jComboBox_pv.getSelectedIndex());
            h.setAbierta(true);
            h.setEfectos(efectosNuevos);
            if (jRadioButton_Firme.isSelected()) {
                h.setCuerpoEstado(Status.FIRME);
            }
            if (jRadioButton_postrado.isSelected()) {
                h.setCuerpoEstado(Status.POSTRADO);
            }
            if (jRadioButton_Dormido.isSelected()) {
                h.setCuerpoEstado(Status.DORMIDO);
            }
            if (jRadioButton_coma.isSelected()) {
                h.setCuerpoEstado(Status.COMA);
            }
            if (jRadioButton_muerto.isSelected()) {
                int as = (Integer) jSpinner_asParamoriri1.getValue();
                if (as > 0) {
                    h.setCuerpoEstado(Status.MORIBUNDO);
                } else {
                    h.setCuerpoEstado(Status.MUERTO);
                }
            }
            h.setDescripcion(jTextArea_descp.getText());
            tok.agregarHerida(h);
            
            

        } else if (jRadioButton_sanar.isSelected()) {

            Curacion c = new Curacion();

            c.setPvRecuperados(jComboBox_pv.getSelectedIndex());

            c.setEfectos(efectosNuevos);
            if (jRadioButton_Firme.isSelected()) {
                c.setCuerpoEstado(Status.FIRME);
            }
            if (jRadioButton_postrado.isSelected()) {
                c.setCuerpoEstado(Status.POSTRADO);
            }
            if (jRadioButton_Dormido.isSelected()) {
                c.setCuerpoEstado(Status.DORMIDO);
            }
            if (jRadioButton_coma.isSelected()) {
                c.setCuerpoEstado(Status.COMA);
            }
            if (jRadioButton_muerto.isSelected()) {
                int as = (Integer) jSpinner_asParamoriri1.getValue();
                if (as > 0) {
                    c.setCuerpoEstado(Status.MORIBUNDO);
                } else {
                    c.setCuerpoEstado(Status.MUERTO);
                }
            }
            c.setDescripcion(jTextArea_descp.getText());
            tok.agregarCuracion(c);

        } else {
            // mod
            Mod m = new Mod();
            m.setEfectos(efectosNuevos);

            m.setDescripcion(jTextArea_descp.getText());
            //tok.ag
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup_EstadoFisico;
    private javax.swing.ButtonGroup buttonGroup_Tipo_Alt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_aceptar;
    private javax.swing.JButton jButton_aceptar1;
    private javax.swing.JComboBox jComboBox_pv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList_efectos;
    private javax.swing.JList<String> jList_efectos1;
    private javax.swing.JList<String> jList_efectos2;
    private javax.swing.JList<String> jList_efectos4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel3_Status1;
    private javax.swing.JPanel jPanel3_Status2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_Aceptar_cancelar;
    private javax.swing.JPanel jPanel_Aceptar_cancelar1;
    private javax.swing.JPanel jPanel_curacion;
    private javax.swing.JPanel jPanel_descripcion;
    private javax.swing.JRadioButton jRadioButton_Dormido;
    private javax.swing.JRadioButton jRadioButton_Firme;
    private javax.swing.JRadioButton jRadioButton_coma;
    private javax.swing.JRadioButton jRadioButton_farmear;
    private javax.swing.JRadioButton jRadioButton_herir;
    private javax.swing.JRadioButton jRadioButton_muerto;
    private javax.swing.JRadioButton jRadioButton_postrado;
    private javax.swing.JRadioButton jRadioButton_sanar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane_Resumen;
    private javax.swing.JSpinner jSpinner_asParamoriri1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea_descp;
    private javax.swing.JTextField jTextField_Actual_pv;
    // End of variables declaration//GEN-END:variables
    private JPanelFormToken_Accion panel_token;
    private final int num_max = 100;
    private ArrayList<Efecto> efectosNuevos = new ArrayList();

    public static void CrearAlteracion(java.awt.Frame parent, boolean modal, JPanelFormToken_Accion token) {
        CrearNewAlter ca = new CrearNewAlter(parent, modal, token);
        ca.setLocationRelativeTo(parent);
        ca.setVisible(true);
    }

    private void nuevoEfecto() {

        Efecto ef = CrearEfecto.CrearEfecto(null, true, panel_token.getToken(), jRadioButton_herir.isSelected());
        if (ef != null) {
            efectosNuevos.add(ef);
        }
        DefaultListModel jdlm = (DefaultListModel) jList_efectos.getModel();
        jdlm.addElement(ef);
        jList_efectos.setModel(jdlm);

    }

}
