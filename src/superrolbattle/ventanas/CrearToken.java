/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Brazo;
import instancias.properties.Caracteristicas;
import instancias.properties.Status;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import recursos.Recursos;
import superrolbattle.Principal;

/**
 *
 * @author Juan
 */
public class CrearToken extends javax.swing.JDialog {

    /**
     * Creates new form CrearToken
     */
    public CrearToken(boolean modal) {
        super(Principal.ventana, modal);
        initComponents();
        this.setLocationRelativeTo(Principal.ventana);

        this.setTitle("Crear Nuevo Personaje");

        this.jComboBox_crearBI_Arma.removeAllItems();
        this.jComboBox_crearBDArma.removeAllItems();

        this.jComboBox_crearBI_Arma.setModel(new DefaultComboBoxModel(Recursos.armeria.toArray()));
        this.jComboBox_crearBDArma.setModel(new DefaultComboBoxModel(Recursos.armeria.toArray()));
        this.jComboBox_crearBI_Arma.setSelectedIndex(15);
        this.jComboBox_crearGrupo.removeAllItems();
        this.jComboBox_crearGrupo.setModel(new DefaultComboBoxModel(Recursos.grupos.toArray()));

        this.jToggleButton_Panel.setSelected(CrearToken.panelLado);
        this.setearPanel();

        jComboBox_crearBDArma.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                instancias.properties.Arma arm = Recursos.armeria.get(jComboBox_crearBDArma.getSelectedIndex());
                if (arm.isdosManos()) {
                    jComboBox_crearBI_Arma.setSelectedIndex(jComboBox_crearBDArma.getSelectedIndex());
                    jComboBox_crearBI_Arma.setEnabled(false);
                } else {
                    // Por defecto porngo el escudo que es el 15
                    jComboBox_crearBI_Arma.setSelectedIndex(16);
                    jComboBox_crearBI_Arma.setEnabled(true);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbuttonGroup_crearEstilo = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jToggleButton_Panel = new javax.swing.JToggleButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel_caract1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_crearnombre = new javax.swing.JTextField();
        jButton_generaNombreAleatorio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSpinner_crearNIvel = new javax.swing.JSpinner();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSpinner_crearPV = new javax.swing.JSpinner();
        jComboBox_crearGrupo = new javax.swing.JComboBox();
        jPanel8 = new javax.swing.JPanel();
        jSlider_crearPvActuales = new javax.swing.JSlider();
        jPanel_caract2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jSpinner_crearBo = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jSpinner_crearBD = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jSpinner_crearArmadura = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox_crearBDHabilitado = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_crearBDArma = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jCheckBox_crearBIHabilitado = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_crearBI_Arma = new javax.swing.JComboBox();
        jPanel_caract3 = new javax.swing.JPanel();
        jRadioButton_crearEstilo1 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo2 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo4 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo3 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo5 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(252, 515));
        setPreferredSize(new java.awt.Dimension(381, 404));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(98439, 229491));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jToggleButton_Panel.setText("Panel Derecho");
        jToggleButton_Panel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jToggleButton_Panel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton_Panel.setMaximumSize(new java.awt.Dimension(500, 23));
        jToggleButton_Panel.setPreferredSize(new java.awt.Dimension(707, 23));
        jToggleButton_Panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_PanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jToggleButton_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel_caract1.setLayout(new javax.swing.BoxLayout(jPanel_caract1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        jPanel4.setMinimumSize(new java.awt.Dimension(327, 25));
        jPanel4.setPreferredSize(new java.awt.Dimension(327, 25));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setText("Nombre   ");
        jPanel4.add(jLabel1);

        jTextField_crearnombre.setText(" ");
        jTextField_crearnombre.setMinimumSize(new java.awt.Dimension(6, 25));
        jTextField_crearnombre.setPreferredSize(new java.awt.Dimension(9, 25));
        jPanel4.add(jTextField_crearnombre);

        jButton_generaNombreAleatorio.setText("G");
        jButton_generaNombreAleatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_generaNombreAleatorioActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_generaNombreAleatorio);

        jLabel2.setText("   Nivel   ");
        jPanel4.add(jLabel2);

        jSpinner_crearNIvel.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        jSpinner_crearNIvel.setMinimumSize(new java.awt.Dimension(49, 20));
        jSpinner_crearNIvel.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel4.add(jSpinner_crearNIvel);

        jPanel_caract1.add(jPanel4);

        jPanel5.setPreferredSize(new java.awt.Dimension(327, 30));

        jLabel3.setText("Grupo");

        jLabel4.setText("P.V.");

        jSpinner_crearPV.setModel(new javax.swing.SpinnerNumberModel(30, 30, 600, 5));

        jComboBox_crearGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3)
                    .addGap(10, 10, 10)
                    .addComponent(jComboBox_crearGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(4, 4, 4)
                    .addComponent(jLabel4)
                    .addGap(4, 4, 4)
                    .addComponent(jSpinner_crearPV, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(36, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox_crearGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSpinner_crearPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel_caract1.add(jPanel5);

        jPanel8.setPreferredSize(new java.awt.Dimension(327, 30));
        jPanel8.setRequestFocusEnabled(false);
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jSlider_crearPvActuales.setToolTipText("% de vida");
        jSlider_crearPvActuales.setValue(100);
        jPanel8.add(jSlider_crearPvActuales);

        jPanel_caract1.add(jPanel8);

        jPanel7.add(jPanel_caract1);

        jPanel_caract2.setBorder(javax.swing.BorderFactory.createTitledBorder("Habilidades"));
        jPanel_caract2.setLayout(new javax.swing.BoxLayout(jPanel_caract2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("BO    ");
        jPanel_caract2.add(jLabel5);

        jSpinner_crearBo.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jPanel_caract2.add(jSpinner_crearBo);

        jLabel8.setText("   BD   ");
        jPanel_caract2.add(jLabel8);

        jSpinner_crearBD.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jPanel_caract2.add(jSpinner_crearBD);

        jLabel9.setText("   Armadura   ");
        jPanel_caract2.add(jLabel9);

        jSpinner_crearArmadura.setModel(new javax.swing.SpinnerNumberModel(4, 1, 20, 1));
        jPanel_caract2.add(jSpinner_crearArmadura);

        jPanel7.add(jPanel_caract2);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Brazo Derecho"));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox_crearBDHabilitado.setSelected(true);
        jCheckBox_crearBDHabilitado.setText("Habilitado");
        jCheckBox_crearBDHabilitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_crearBDHabilitadoActionPerformed(evt);
            }
        });
        jPanel3.add(jCheckBox_crearBDHabilitado);

        jLabel7.setText("  Arma   ");
        jPanel3.add(jLabel7);

        jComboBox_crearBDArma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_crearBDArma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_crearBDArmaItemStateChanged(evt);
            }
        });
        jComboBox_crearBDArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_crearBDArmaActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox_crearBDArma);

        jPanel7.add(jPanel3);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Brazo Izquierdo"));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox_crearBIHabilitado.setSelected(true);
        jCheckBox_crearBIHabilitado.setText("Habilitado");
        jCheckBox_crearBIHabilitado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_crearBIHabilitadoActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox_crearBIHabilitado);

        jLabel6.setText("  Arma   ");
        jPanel2.add(jLabel6);

        jComboBox_crearBI_Arma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_crearBI_Arma.setEnabled(false);
        jPanel2.add(jComboBox_crearBI_Arma);

        jPanel7.add(jPanel2);

        jPanel_caract3.setBorder(javax.swing.BorderFactory.createTitledBorder("Estilo"));
        jPanel_caract3.setLayout(new java.awt.GridLayout(2, 3));

        jbuttonGroup_crearEstilo.add(jRadioButton_crearEstilo1);
        jRadioButton_crearEstilo1.setText("DEFENSA TOTAL");
        jPanel_caract3.add(jRadioButton_crearEstilo1);

        jbuttonGroup_crearEstilo.add(jRadioButton_crearEstilo2);
        jRadioButton_crearEstilo2.setText("PRECAVIDO");
        jPanel_caract3.add(jRadioButton_crearEstilo2);

        jbuttonGroup_crearEstilo.add(jRadioButton_crearEstilo4);
        jRadioButton_crearEstilo4.setSelected(true);
        jRadioButton_crearEstilo4.setText("NORMAL");
        jPanel_caract3.add(jRadioButton_crearEstilo4);

        jbuttonGroup_crearEstilo.add(jRadioButton_crearEstilo3);
        jRadioButton_crearEstilo3.setText("ATAQUE");
        jRadioButton_crearEstilo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_crearEstilo3ActionPerformed(evt);
            }
        });
        jPanel_caract3.add(jRadioButton_crearEstilo3);

        jbuttonGroup_crearEstilo.add(jRadioButton_crearEstilo5);
        jRadioButton_crearEstilo5.setText("TODO O NADA");
        jPanel_caract3.add(jRadioButton_crearEstilo5);

        jPanel7.add(jPanel_caract3);

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setMinimumSize(new java.awt.Dimension(341, 60));
        jPanel6.setPreferredSize(new java.awt.Dimension(335, 60));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel10);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);

        jPanel11.setPreferredSize(new java.awt.Dimension(25, 57));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel11);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);

        jPanel7.add(jPanel6);

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox_crearBIHabilitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_crearBIHabilitadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_crearBIHabilitadoActionPerformed

    private void jCheckBox_crearBDHabilitadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_crearBDHabilitadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_crearBDHabilitadoActionPerformed

    private void jRadioButton_crearEstilo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_crearEstilo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_crearEstilo3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        newToken = new Token();
        Caracteristicas hab = new Caracteristicas();
        Brazo izq = new Brazo();
        Brazo der = new Brazo();
        Status est = new Status(hab);
        creacion:
        {
            String n = this.jTextField_crearnombre.getText().trim();

            if (n.length() > 0) {
                newToken.setNombre(this.jTextField_crearnombre.getText());
            } else {
                Recursos.informar("NO se escribio un nombre");
                newToken = null;
                break creacion;
            }

            newToken.setNivel((Integer) this.jSpinner_crearNIvel.getValue());
            newToken.setGrupo(Recursos.grupos.get(this.jComboBox_crearGrupo.getSelectedIndex()));
            int pv = (Integer) this.jSpinner_crearPV.getValue();
            hab.setPuntosVida(pv);

            int porcPv = this.jSlider_crearPvActuales.getValue();
            newToken.setPuntosVida((int) (((float) pv / 100.0) * porcPv));

            izq.setHabilitado(this.jCheckBox_crearBIHabilitado.isSelected());
            izq.setArmaEquipada(Recursos.armeria.get(this.jComboBox_crearBI_Arma.getSelectedIndex()));

            der.setHabilitado(this.jCheckBox_crearBDHabilitado.isSelected());
            der.setArmaEquipada(Recursos.armeria.get(this.jComboBox_crearBDArma.getSelectedIndex()));

            hab.setBo_pri((Integer) this.jSpinner_crearBo.getValue());
            //hab.setAgi((Integer) this.jSpinner_crearBD.getValue());
            hab.setArmadura((Integer) this.jSpinner_crearArmadura.getValue());

            if (this.jRadioButton_crearEstilo1.isSelected()) {
                newToken.setEstilo(Token.DEFENSA_TOTAL);
            }

            if (this.jRadioButton_crearEstilo2.isSelected()) {
                newToken.setEstilo(Token.PRECAVIDO);
            }

            if (this.jRadioButton_crearEstilo3.isSelected()) {
                newToken.setEstilo(Token.NORMAL);
            }

            if (this.jRadioButton_crearEstilo4.isSelected()) {
                newToken.setEstilo(Token.ATAQUE);
            }

            if (this.jRadioButton_crearEstilo5.isSelected()) {
                newToken.setEstilo(Token.TODO_O_NADA);
            }

            newToken.setHabilidades(hab);
            newToken.setManoDER(der);
            newToken.setManoIZQ(izq);
            newToken.setEstado(est);
            newToken.setLadoIzquierdo(jToggleButton_Panel.isSelected());
            newToken.setColor(Recursos.getHexaColor(Color.BLUE));
            this.dispose();
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jToggleButton_PanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton_PanelActionPerformed
        setearPanel();
    }//GEN-LAST:event_jToggleButton_PanelActionPerformed

    private void setearPanel() {
        if (jToggleButton_Panel.isSelected()) {
            jToggleButton_Panel.setText("Panel Izquierdo");

        } else {
            jToggleButton_Panel.setText("Panel Derecho");
        }
        CrearToken.panelLado = jToggleButton_Panel.isSelected();

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox_crearBDArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_crearBDArmaActionPerformed

    }//GEN-LAST:event_jComboBox_crearBDArmaActionPerformed

    private void jComboBox_crearBDArmaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_crearBDArmaItemStateChanged

    }//GEN-LAST:event_jComboBox_crearBDArmaItemStateChanged

    private void jButton_generaNombreAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generaNombreAleatorioActionPerformed
        String n = Recursos.nombres.get(Recursos.aleatorioEntre(0, Recursos.nombres.size()));
        jTextField_crearnombre.setText(n);

        int nivel = (Integer) jSpinner_crearNIvel.getValue();

        int pv = 30;
        for (int j = 0; j < nivel; j++) {

            boolean yes = Recursos.posibilidad(90);
            if (yes) {
                pv += Recursos.aleatorioEntre(1, 10);
                pv += Recursos.aleatorioEntre(1, 10);
            } else {
                pv += Recursos.aleatorioEntre(1, 10);
            }

        }

        jSpinner_crearPV.setValue(pv);

        jComboBox_crearBDArma.setSelectedIndex(Recursos.aleatorioEntre(0, Recursos.armeria.size() - 1));
        Arma der = (Arma) jComboBox_crearBDArma.getSelectedItem();

        jComboBox_crearBI_Arma.setEnabled(true);
        if (der.isdosManos()) {
            jComboBox_crearBI_Arma.setSelectedIndex(jComboBox_crearBDArma.getSelectedIndex());
        } else {
            if (Recursos.posibilidad(70)) {
                jComboBox_crearBI_Arma.setSelectedIndex(Arma.CLASE_ESCUDO);
            } else {
                jComboBox_crearBI_Arma.setSelectedIndex(Arma.CLASE_MANO_DESNUDA);
            }
        }

        int bonoBo = 0;
        for (int j = 0; j < nivel; j++) {
            boolean yes = Recursos.posibilidad(90);
            if (yes) {
                yes = Recursos.posibilidad(10);
                if (yes) {
                    bonoBo += 10;
                } else {
                    bonoBo += 5;
                }
            }
        }

        jSpinner_crearBo.setValue(35 + nivel * 3 + nivel + bonoBo + Recursos.aleatorioEntre(1, 5));
        jSpinner_crearBD.setValue(5 * Recursos.aleatorioEntre(1, 8));
        jSpinner_crearArmadura.setValue(Recursos.aleatorioEntre(1, 20));

    }//GEN-LAST:event_jButton_generaNombreAleatorioActionPerformed

    private Object[] listaArmas() {

        return Recursos.armeria.toArray();
    }

    public static Object[] nuevoToken() {
        CrearToken ct = new CrearToken(true);
        ct.setVisible(true);
        return new Object[]{panelLado, newToken};
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_generaNombreAleatorio;
    private javax.swing.JCheckBox jCheckBox_crearBDHabilitado;
    private javax.swing.JCheckBox jCheckBox_crearBIHabilitado;
    private javax.swing.JComboBox jComboBox_crearBDArma;
    private javax.swing.JComboBox jComboBox_crearBI_Arma;
    private javax.swing.JComboBox jComboBox_crearGrupo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_caract1;
    private javax.swing.JPanel jPanel_caract2;
    private javax.swing.JPanel jPanel_caract3;
    private javax.swing.JRadioButton jRadioButton_crearEstilo1;
    private javax.swing.JRadioButton jRadioButton_crearEstilo2;
    private javax.swing.JRadioButton jRadioButton_crearEstilo3;
    private javax.swing.JRadioButton jRadioButton_crearEstilo4;
    private javax.swing.JRadioButton jRadioButton_crearEstilo5;
    private javax.swing.JSlider jSlider_crearPvActuales;
    private javax.swing.JSpinner jSpinner_crearArmadura;
    private javax.swing.JSpinner jSpinner_crearBD;
    private javax.swing.JSpinner jSpinner_crearBo;
    private javax.swing.JSpinner jSpinner_crearNIvel;
    private javax.swing.JSpinner jSpinner_crearPV;
    private javax.swing.JTextField jTextField_crearnombre;
    private javax.swing.JToggleButton jToggleButton_Panel;
    private javax.swing.ButtonGroup jbuttonGroup_crearEstilo;
    // End of variables declaration//GEN-END:variables
    private static Token newToken;
    private static boolean panelLado = true;
}
