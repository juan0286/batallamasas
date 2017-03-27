/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Dado;
import instancias.ListaDeSortilegios;
import instancias.Sortilegio;
import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Bo;
import instancias.properties.Brazo;
import instancias.properties.Caracteristicas;
import instancias.properties.Extremidad;
import instancias.properties.Habilidad;
import instancias.properties.Status;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import recursos.Constantes;
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
        bos = new ArrayList<Bo>();
        this.setTitle("Crear Nuevo Personaje");

        this.jComboBox_crearGrupo.removeAllItems();
        this.jComboBox_crearGrupo.setModel(new DefaultComboBoxModel(Recursos.grupos.toArray()));

        this.jToggleButton_Panel.setSelected(CrearToken.panelLado);
        this.setearPanel();

        agregarArmaALalista(new Arma("Mano Desnuda", Constantes.CLASE_MANO_DESNUDA, 0, Constantes.TIPO_ARMA_NORMAL, false, Constantes.ESTILO_PELEA));
        for (int i = 0; i < Constantes.ESTILO_ASTA; i++) {
            Bo b = new Bo(i, 0);
            //b.setValue(Recursos.nuevaBo(1, i));
            agregarBoALaLista(b);
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
        jComboBox_crearGrupo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jSpinner_crearPV = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jSpinner_crearPP = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        jSlider_crearPvActuales = new javax.swing.JSlider();
        jPanel16 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jButton_agregarArma = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jButton_agregarBO = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_Armas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_Bos = new javax.swing.JList<>();
        jPanel_caract2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_dom = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jSpinner_crearBD = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jSpinner_crearArmadura = new javax.swing.JSpinner();
        jPanel_caract3 = new javax.swing.JPanel();
        jRadioButton_crearEstilo1 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo2 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo4 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo3 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo5 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton_cancelar = new javax.swing.JButton();

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
        jToggleButton_Panel.setMinimumSize(new java.awt.Dimension(57, 23));
        jToggleButton_Panel.setPreferredSize(new java.awt.Dimension(157, 23));
        jToggleButton_Panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton_PanelActionPerformed(evt);
            }
        });
        jPanel9.add(jToggleButton_Panel);

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
        jPanel5.add(jLabel3);

        jComboBox_crearGrupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(jComboBox_crearGrupo);

        jLabel4.setText("P.V.");
        jPanel5.add(jLabel4);

        jSpinner_crearPV.setModel(new javax.swing.SpinnerNumberModel(30, 30, 600, 5));
        jPanel5.add(jSpinner_crearPV);

        jLabel6.setText("P.P.");
        jPanel5.add(jLabel6);

        jSpinner_crearPP.setModel(new javax.swing.SpinnerNumberModel(30, 30, 600, 5));
        jPanel5.add(jSpinner_crearPP);

        jPanel_caract1.add(jPanel5);

        jPanel8.setPreferredSize(new java.awt.Dimension(327, 30));
        jPanel8.setRequestFocusEnabled(false);
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        jSlider_crearPvActuales.setToolTipText("% de vida");
        jSlider_crearPvActuales.setValue(100);
        jPanel8.add(jSlider_crearPvActuales);

        jPanel_caract1.add(jPanel8);

        jPanel7.add(jPanel_caract1);

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jPanel13.setMinimumSize(new java.awt.Dimension(89, 23));
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jButton_agregarArma.setText("+ Arma");
        jButton_agregarArma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarArmaActionPerformed(evt);
            }
        });
        jPanel13.add(jButton_agregarArma);

        jPanel12.add(jPanel13);

        jPanel15.setMinimumSize(new java.awt.Dimension(89, 23));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.LINE_AXIS));

        jButton_agregarBO.setText("+ Bon Ofe");
        jButton_agregarBO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_agregarBOActionPerformed(evt);
            }
        });
        jPanel15.add(jButton_agregarBO);

        jPanel12.add(jPanel15);

        jPanel16.add(jPanel12);

        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        jList_Armas.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(jList_Armas);

        jPanel14.add(jScrollPane1);

        jList_Bos.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(jList_Bos);

        jPanel14.add(jScrollPane2);

        jPanel16.add(jPanel14);

        jPanel7.add(jPanel16);

        jPanel_caract2.setBorder(javax.swing.BorderFactory.createTitledBorder("Habilidades"));
        jPanel_caract2.setLayout(new javax.swing.BoxLayout(jPanel_caract2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("Dominio");
        jPanel_caract2.add(jLabel5);

        jComboBox_dom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Canalizacion", "Escencia", "Mentalismo", "Hibrido Can Men", "Hibrido Esc Men", "Hibrido Men Can", "Arcano" }));
        jPanel_caract2.add(jComboBox_dom);

        jLabel8.setText("AGI");
        jPanel_caract2.add(jLabel8);

        jSpinner_crearBD.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jPanel_caract2.add(jSpinner_crearBD);

        jLabel9.setText("   Armadura   ");
        jPanel_caract2.add(jLabel9);

        jSpinner_crearArmadura.setModel(new javax.swing.SpinnerNumberModel(4, 1, 20, 1));
        jPanel_caract2.add(jSpinner_crearArmadura);

        jPanel7.add(jPanel_caract2);

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
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel10);

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });
        jPanel6.add(jButtonAceptar);

        jPanel11.setPreferredSize(new java.awt.Dimension(25, 57));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 29, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 54, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel11);

        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });
        jPanel6.add(jButton_cancelar);

        jPanel7.add(jPanel6);

        jPanel1.add(jPanel7, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_crearEstilo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_crearEstilo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_crearEstilo3ActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        newToken = new Token();

        Caracteristicas hab;

        if (newhabHabilidad == null) {
            hab = new Caracteristicas();
        } else {
            hab = newhabHabilidad;
        }

        // Brazos
        Extremidad bi = new Extremidad(true, true, false, Extremidad.MIEMBRO_SUPERIOR_IZQUIERDO, null);
        newToken.agregarExtremidad(bi);
        Extremidad bd = new Extremidad(true, true, true, Extremidad.MIEMBRO_SUPERIOR_IZQUIERDO, null);
        newToken.agregarExtremidad(bd);
        // Piernas
        Extremidad pi = new Extremidad(true, false, false, Extremidad.MIEMBRO_SUPERIOR_IZQUIERDO, null);
        newToken.agregarExtremidad(pi);
        Extremidad pd = new Extremidad(true, false, true, Extremidad.MIEMBRO_SUPERIOR_IZQUIERDO, null);
        newToken.agregarExtremidad(pd);

        Status est = new Status(hab, newToken.getExtremidades());
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
            int pp = (Integer) this.jSpinner_crearPP.getValue();
            hab.setPp(pp);

            int porcPv = this.jSlider_crearPvActuales.getValue();
            hab.setPuntosVida((int) (((float) pv / 100.0) * porcPv));

            ArrayList<Arma> arm = new ArrayList<Arma>();

            DefaultListModel jdlm = (DefaultListModel) jList_Armas.getModel();
            for (int i = 0; i < jdlm.getSize(); i++) {
                arm.add((Arma) jdlm.get(i));
            }
            newToken.setArmas(arm);

            //hab.setBo_pri((Integer) this.jSpinner_crearBo.getValue());
            hab.setBd((Integer) this.jSpinner_crearBD.getValue());

            //hab.setAgi((Integer) this.jSpinner_crearBD.getValue());
            hab.setArmadura((Integer) this.jSpinner_crearArmadura.getValue());

            if (this.jRadioButton_crearEstilo1.isSelected()) {
                newToken.setEstilo_de_pelea(Token.DEFENSA_TOTAL);
            }

            if (this.jRadioButton_crearEstilo2.isSelected()) {
                newToken.setEstilo_de_pelea(Token.PRECAVIDO);
            }

            if (this.jRadioButton_crearEstilo3.isSelected()) {
                newToken.setEstilo_de_pelea(Token.NORMAL);
            }

            if (this.jRadioButton_crearEstilo4.isSelected()) {
                newToken.setEstilo_de_pelea(Token.ATAQUE);
            }

            if (this.jRadioButton_crearEstilo5.isSelected()) {
                newToken.setEstilo_de_pelea(Token.TODO_O_NADA);
            }

            newToken.setHabilidades(hab);
            Comparator<Bo> comparador = Collections.reverseOrder();
            Collections.sort(bos, comparador);
            HashMap<Integer, Bo> hm_bos = new HashMap<Integer, Bo>();
            hab.setBo_pri(bos.get(0).getEstilo());
            for (Iterator<Bo> iterator = bos.iterator(); iterator.hasNext();) {
                Bo b = iterator.next();
                hm_bos.put(b.getEstilo(), b);

            }
            newToken.setDominio(jComboBox_dom.getSelectedIndex());
            newToken.setBos(hm_bos);
            newToken.setEstado(est);
            newToken.setColor(Recursos.getHexaColor(Color.BLUE));

            if (personajeCorrecto(newToken)) {
                this.dispose();
            }
        }


    }//GEN-LAST:event_jButtonAceptarActionPerformed

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

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

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
        int pp = nivel * Recursos.aleatorioEntre(1, 3);
        jSpinner_crearPP.setValue(pp);
        jSpinner_crearPV.setValue(pv);

        //jComboBox_crearBDArma.setSelectedIndex(Recursos.aleatorioEntre(0, Recursos.armeria.size() - 1));
        //Arma der = (Arma) jComboBox_crearBDArma.getSelectedItem();
        int cant_armas = Recursos.aleatorioEntre(1, 3);
        DefaultListModel jdlm = (DefaultListModel) jList_Armas.getModel();
        jdlm.removeAllElements();
        DefaultListModel jdlmo = (DefaultListModel) jList_Bos.getModel();
        jdlmo.removeAllElements();
        bos.clear();

        // Dominio y sortilegios
        Dado d100 = new Dado();
        int pos = d100.lanzarAbierta();
        if (pos < 49) {
            jComboBox_dom.setSelectedIndex(0);
        }
        if (pos > 49) {
            jComboBox_dom.setSelectedIndex(1);
        }
        if (pos > 100) {
            jComboBox_dom.setSelectedIndex(2);
        }
        if (pos > 150) {
            jComboBox_dom.setSelectedIndex(3);
        }
        if (pos > 200) {
            jComboBox_dom.setSelectedIndex(4);
        }
        if (pos > 250) {
            jComboBox_dom.setSelectedIndex(5);
        }
        if (pos > 300) {
            jComboBox_dom.setSelectedIndex(6);
        }
        newhabHabilidad = new Caracteristicas();
        newToken.setHabilidades(newhabHabilidad);
        int chance = 25;
        for (int i = 0; i < Recursos.aleatorioEntre(1, 10); i++) {
            
            if (d100.lanzarCerrada() < chance) {
                ListaDeSortilegios lds = (ListaDeSortilegios) Recursos.aleatorioDe(Principal.getTodasLasListasDeSortilegiosAbiertas(newToken.getDominio()));

                newToken.aprenderListaDeSortilegio(lds.getId(), 50);

            }
            if (d100.lanzarAbierta() > 150) {
                Sortilegio s = (Sortilegio) Recursos.aleatorioDe(Principal.getTodosLosSortilegios());
                if (newToken.getDominio() == s.getDominio() || newToken.getDominio() > 2) {
                    newToken.aprenderSortilegio(s.getId());
                }
            }
            chance -= Recursos.aleatorioEntre(1, 5);
        }

        agregarArmaALalista(new Arma("Mano Desnuda", Constantes.CLASE_MANO_DESNUDA, 0, Constantes.TIPO_ARMA_NORMAL, false, Constantes.ESTILO_PELEA));
        agregarBoALaLista(new Bo(Constantes.ESTILO_PELEA, Recursos.nuevaBo(nivel, Recursos.aleatorioEntre(0, 4))));

        for (int i = 0; i < cant_armas; i++) {
            Arma a = Recursos.armeria.get(Recursos.aleatorioEntre(0, 23));
            agregarArmaALalista(a);
        }
        for (int i = 1; i <= Constantes.ESTILO_ASTA; i++) {
            Bo b = new Bo(i, 0);
            b.setValue(Recursos.nuevaBo(nivel, i));
            agregarBoALaLista(b);
        }

        jSpinner_crearBD.setValue(5 * Recursos.aleatorioEntre(1, 8));
        jSpinner_crearArmadura.setValue(Recursos.aleatorioEntre(1, 20));

    }//GEN-LAST:event_jButton_generaNombreAleatorioActionPerformed

    private void jButton_agregarArmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarArmaActionPerformed
        Arma a = (Arma) JOptionPane.showInputDialog(null,
                "Selecciona Arma", "ShowInputDialog",
                JOptionPane.PLAIN_MESSAGE, null, Recursos.armeria.toArray(), "Seleccion de Arma");
        agregarArmaALalista(a);
    }//GEN-LAST:event_jButton_agregarArmaActionPerformed

    private void jButton_agregarBOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_agregarBOActionPerformed
        Bo bo = DefinirBo.crearBo(null, true);
        agregarBoALaLista(bo);

    }//GEN-LAST:event_jButton_agregarBOActionPerformed

    private void agregarArmaALalista(Arma a) {
        if (a != null) {
            DefaultListModel jdlm = (DefaultListModel) jList_Armas.getModel();

            jdlm.addElement(a);
            jList_Armas.setModel(jdlm);
        }
    }

    private void agregarBoALaLista(Bo bo) {
        if (bo != null) {
            DefaultListModel jdlm = (DefaultListModel) jList_Bos.getModel();

            for (int i = 0; i < jdlm.getSize(); i++) {
                Bo b = (Bo) jdlm.get(i);
                if (b.equals(bo)) {
                    jdlm.remove(i);
                }
            }
            jdlm.addElement(bo);
            jList_Bos.setModel(jdlm);
            bos.add(bo);
        }
    }

    private Object[] listaArmas() {

        return Recursos.armeria.toArray();
    }

    public static Object[] nuevoToken() {
        CrearToken ct = new CrearToken(true);
        ct.setVisible(true);
        return new Object[]{panelLado, newToken};
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButton_agregarArma;
    private javax.swing.JButton jButton_agregarBO;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_generaNombreAleatorio;
    private javax.swing.JComboBox jComboBox_crearGrupo;
    private javax.swing.JComboBox<String> jComboBox_dom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList_Armas;
    private javax.swing.JList<String> jList_Bos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider_crearPvActuales;
    private javax.swing.JSpinner jSpinner_crearArmadura;
    private javax.swing.JSpinner jSpinner_crearBD;
    private javax.swing.JSpinner jSpinner_crearNIvel;
    private javax.swing.JSpinner jSpinner_crearPP;
    private javax.swing.JSpinner jSpinner_crearPV;
    private javax.swing.JTextField jTextField_crearnombre;
    private javax.swing.JToggleButton jToggleButton_Panel;
    private javax.swing.ButtonGroup jbuttonGroup_crearEstilo;
    // End of variables declaration//GEN-END:variables
    private static Token newToken = new Token();
    private static Caracteristicas newhabHabilidad;
    ;
    
    private ArrayList<Bo> bos;
    private static boolean panelLado = true;

    private boolean personajeCorrecto(Token nt) {
        ArrayList<Arma> armas = nt.getArmas();
        for (Arma arma : armas) {
            if (!nt.getHabilidades().getHm_bos().containsKey(arma.getEstilo())) {
                Recursos.informar("Agregar Bo para " + arma.getNombre());
                return false;
            }
        }
        return true;
    }
}
