/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import instancias.Dado;
import instancias.ListaDeSortilegios;
import instancias.Sortilegio;
import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Bo;
import instancias.properties.Brazo;
import instancias.properties.Caracteristicas;
import instancias.properties.Extremidad;
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
import javax.swing.JSpinner;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static recursos.Constantes.*;
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

        spin_mm.put(HABILIDAD_MM_SINARMADURA, jSpinner_crearMMSA);
        spin_mm.put(HABILIDAD_MM_CUERO, jSpinner_crearMMC);
        spin_mm.put(HABILIDAD_MM_CUERO_ENDURECIDO, jSpinner_crearMMCE);
        spin_mm.put(HABILIDAD_MM_COTA_DE_MALLA, jSpinner_crearMMCM);
        spin_mm.put(HABILIDAD_MM_CORAZA, jSpinner_crearMMCO);

        this.jComboBox_crearGrupo.removeAllItems();
        this.jComboBox_crearGrupo.setModel(new DefaultComboBoxModel(Recursos.grupos.toArray()));

        agregarArmaALalista(new Arma("Mano Desnuda", CLASE_MANO_DESNUDA, 0, TIPO_ARMA_NORMAL, false, ESTILO_PELEA));
        for (int i = 0; i <= ESTILO_ASTA; i++) {
            Bo b = new Bo(i, 0);
            //b.setValue(Recursos.nuevaBo(1, i));
            agregarBoALaLista(b);
        }

    }

    private CrearToken(boolean modal, Token token) {
        super(Principal.ventana, modal);
        initComponents();
        this.setLocationRelativeTo(Principal.ventana);

        newToken = token;
        newhabHabilidad = token.getHabilidades();
        this.setTitle("Editar a " + token.getNombre());

        jButton_generaNombreAleatorio.setEnabled(false);
        jTextField_crearnombre.setText(token.getNombre());
        jTextField_crearnombre.setEditable(false);
        jSpinner_crearNIvel.setValue(token.getNivel());
        jSpinner_crearPV.setValue(token.getHabilidades().getPuntosVida());
        jSpinner_crearPP.setValue(token.getHabilidades().getPp());

        for (Arma a : token.getArmas()) {
            agregarArmaALalista(a);
        }
        for (Bo bo : token.getHabilidades().getHm_bos().values()) {
            agregarBoALaLista(bo);
        }
        jComboBox_dom.setSelectedIndex(token.getDominio());
        jSpinner_crearArmadura.setValue(token.getArmaduraPuesta());

        jSpinner_crear_car_fue.setValue(token.getHabilidad(HABILIDAD_CAR_FUE));
        jSpinner_crear_car_agi.setValue(token.getHabilidad(HABILIDAD_CAR_AGI));
        jSpinner_crear_car_con.setValue(token.getHabilidad(HABILIDAD_CAR_CON));
        jSpinner_crear_car_I.setValue(token.getHabilidad(HABILIDAD_CAR_I));
        jSpinner_crear_car_int.setValue(token.getHabilidad(HABILIDAD_CAR_INT));
        jSpinner_crear_car_pre.setValue(token.getHabilidad(HABILIDAD_CAR_PRE));

        jSpinner_crearMMSA.setValue(token.getHabilidad(HABILIDAD_MM_SINARMADURA));
        jSpinner_crearMMC.setValue(token.getHabilidad(HABILIDAD_MM_CUERO));
        jSpinner_crearMMCE.setValue(token.getHabilidad(HABILIDAD_MM_CUERO_ENDURECIDO));
        jSpinner_crearMMCM.setValue(token.getHabilidad(HABILIDAD_MM_COTA_DE_MALLA));
        jSpinner_crearMMCO.setValue(token.getHabilidad(HABILIDAD_MM_CORAZA));

        spin_mm.put(HABILIDAD_MM_SINARMADURA, jSpinner_crearMMSA);
        spin_mm.put(HABILIDAD_MM_CUERO, jSpinner_crearMMC);
        spin_mm.put(HABILIDAD_MM_CUERO_ENDURECIDO, jSpinner_crearMMCE);
        spin_mm.put(HABILIDAD_MM_COTA_DE_MALLA, jSpinner_crearMMCM);
        spin_mm.put(HABILIDAD_MM_CORAZA, jSpinner_crearMMCO);

        this.jComboBox_crearGrupo.removeAllItems();
        this.jComboBox_crearGrupo.setModel(new DefaultComboBoxModel(Recursos.grupos.toArray()));

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
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jButton_cancelar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
        jLabel9 = new javax.swing.JLabel();
        jSpinner_crearArmadura = new javax.swing.JSpinner();
        jTextField_arm = new javax.swing.JTextField();
        jPanel_caract3 = new javax.swing.JPanel();
        jRadioButton_crearEstilo1 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo2 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo4 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo3 = new javax.swing.JRadioButton();
        jRadioButton_crearEstilo5 = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel_caract_fue = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jSpinner_crear_car_fue = new javax.swing.JSpinner();
        jPanel_caract_Agi = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSpinner_crear_car_agi = new javax.swing.JSpinner();
        jPanel_caract_Con = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jSpinner_crear_car_con = new javax.swing.JSpinner();
        jPanel_caract_Int = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jSpinner_crear_car_int = new javax.swing.JSpinner();
        jPanel_caract_i = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jSpinner_crear_car_I = new javax.swing.JSpinner();
        jPanel_caract_pre = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jSpinner_crear_car_pre = new javax.swing.JSpinner();
        jPanel17 = new javax.swing.JPanel();
        jPanel_mmsa = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner_crearMMSA = new javax.swing.JSpinner();
        jPanel_mmsa1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jSpinner_crearMMC = new javax.swing.JSpinner();
        jPanel_mmsa2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSpinner_crearMMCE = new javax.swing.JSpinner();
        jPanel_mmsa3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jSpinner_crearMMCM = new javax.swing.JSpinner();
        jPanel_mmsa4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSpinner_crearMMCO = new javax.swing.JSpinner();
        jPanel18 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(252, 515));
        setPreferredSize(new java.awt.Dimension(381, 404));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setMaximumSize(new java.awt.Dimension(98439, 229491));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel6.setMinimumSize(new java.awt.Dimension(341, 60));
        jPanel6.setPreferredSize(new java.awt.Dimension(335, 60));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
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
            .addGap(0, 25, Short.MAX_VALUE)
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

        jPanel1.add(jPanel6, java.awt.BorderLayout.SOUTH);

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

        jSpinner_crearPP.setModel(new javax.swing.SpinnerNumberModel(0, 0, 600, 1));
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

        jLabel9.setText("   Armadura   ");
        jPanel_caract2.add(jLabel9);

        jSpinner_crearArmadura.setModel(new javax.swing.SpinnerNumberModel(4, 1, 20, 1));
        jSpinner_crearArmadura.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_crearArmaduraStateChanged(evt);
            }
        });
        jPanel_caract2.add(jSpinner_crearArmadura);

        jTextField_arm.setEditable(false);
        jTextField_arm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_arm.setText("SA");
        jTextField_arm.setMaximumSize(new java.awt.Dimension(2147483647, 20));
        jPanel_caract2.add(jTextField_arm);

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

        jTabbedPane1.addTab("Principal", jPanel7);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setMinimumSize(new java.awt.Dimension(250, 64));
        jPanel3.setLayout(new java.awt.GridLayout(0, 2));

        jPanel_caract_fue.setLayout(new java.awt.GridLayout(1, 0));

        jLabel14.setText("FUERZA");
        jPanel_caract_fue.add(jLabel14);

        jSpinner_crear_car_fue.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crear_car_fue.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_caract_fue.add(jSpinner_crear_car_fue);

        jPanel3.add(jPanel_caract_fue);

        jPanel_caract_Agi.setLayout(new java.awt.GridLayout(1, 0));

        jLabel15.setText("AGILIDAD");
        jPanel_caract_Agi.add(jLabel15);

        jSpinner_crear_car_agi.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crear_car_agi.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_caract_Agi.add(jSpinner_crear_car_agi);

        jPanel3.add(jPanel_caract_Agi);

        jPanel_caract_Con.setLayout(new java.awt.GridLayout(1, 0));

        jLabel16.setText("CONSTITUCION");
        jPanel_caract_Con.add(jLabel16);

        jSpinner_crear_car_con.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crear_car_con.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_caract_Con.add(jSpinner_crear_car_con);

        jPanel3.add(jPanel_caract_Con);

        jPanel_caract_Int.setLayout(new java.awt.GridLayout(1, 0));

        jLabel17.setText("INTELIGENCIA");
        jPanel_caract_Int.add(jLabel17);

        jSpinner_crear_car_int.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crear_car_int.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_caract_Int.add(jSpinner_crear_car_int);

        jPanel3.add(jPanel_caract_Int);

        jPanel_caract_i.setLayout(new java.awt.GridLayout(1, 0));

        jLabel18.setText("INTUICION");
        jPanel_caract_i.add(jLabel18);

        jSpinner_crear_car_I.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crear_car_I.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_caract_i.add(jSpinner_crear_car_I);

        jPanel3.add(jPanel_caract_i);

        jPanel_caract_pre.setLayout(new java.awt.GridLayout(1, 0));

        jLabel19.setText("PRESCENCIA");
        jPanel_caract_pre.add(jLabel19);

        jSpinner_crear_car_pre.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crear_car_pre.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_caract_pre.add(jSpinner_crear_car_pre);

        jPanel3.add(jPanel_caract_pre);

        jPanel2.add(jPanel3);

        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel17.setMinimumSize(new java.awt.Dimension(250, 64));
        jPanel17.setLayout(new java.awt.GridLayout(0, 2));

        jPanel_mmsa.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setText("MM Sin Armadura");
        jPanel_mmsa.add(jLabel7);

        jSpinner_crearMMSA.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crearMMSA.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_mmsa.add(jSpinner_crearMMSA);

        jPanel17.add(jPanel_mmsa);

        jPanel_mmsa1.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setText("MM Cuero");
        jPanel_mmsa1.add(jLabel10);

        jSpinner_crearMMC.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crearMMC.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_mmsa1.add(jSpinner_crearMMC);

        jPanel17.add(jPanel_mmsa1);

        jPanel_mmsa2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel11.setText("MM Cuero Endurecido");
        jPanel_mmsa2.add(jLabel11);

        jSpinner_crearMMCE.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crearMMCE.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_mmsa2.add(jSpinner_crearMMCE);

        jPanel17.add(jPanel_mmsa2);

        jPanel_mmsa3.setLayout(new java.awt.GridLayout(1, 0));

        jLabel12.setText("MM Cota de Malla");
        jPanel_mmsa3.add(jLabel12);

        jSpinner_crearMMCM.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crearMMCM.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_mmsa3.add(jSpinner_crearMMCM);

        jPanel17.add(jPanel_mmsa3);

        jPanel_mmsa4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel13.setText("MM Coraza");
        jPanel_mmsa4.add(jLabel13);

        jSpinner_crearMMCO.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_crearMMCO.setPreferredSize(new java.awt.Dimension(49, 20));
        jPanel_mmsa4.add(jSpinner_crearMMCO);

        jPanel17.add(jPanel_mmsa4);

        jPanel2.add(jPanel17);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel18);

        jTabbedPane1.addTab("Detalle", jPanel2);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sortilegios", jPanel9);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 336, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Extremidades", jPanel19);

        jPanel1.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_crearEstilo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_crearEstilo3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_crearEstilo3ActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        if (newToken == null) {
            newToken = new Token();
            // Brazos
            Extremidad bi = new Extremidad(true, true, false, Extremidad.MIEMBRO_SUPERIOR_IZQUIERDO, null);
            newToken.agregarExtremidad(bi);
            Extremidad bd = new Extremidad(true, true, true, Extremidad.MIEMBRO_SUPERIOR_DERECHO, null);
            newToken.agregarExtremidad(bd);
            // Piernas
            Extremidad pi = new Extremidad(true, false, false, Extremidad.MIEMBRO_INFERIOR_DERECHO, null);
            newToken.agregarExtremidad(pi);
            Extremidad pd = new Extremidad(true, false, true, Extremidad.MIEMBRO_INFERIOR_IZQUIERDO, null);
            newToken.agregarExtremidad(pd);
        }

        Caracteristicas hab;

        if (newhabHabilidad == null) {
            hab = new Caracteristicas();
        } else {
            hab = newhabHabilidad;
        }

        hab.getHm_habilidades().put(HABILIDAD_CAR_FUE, (Integer) jSpinner_crear_car_fue.getValue());
        hab.getHm_habilidades().put(HABILIDAD_CAR_AGI, (Integer) jSpinner_crear_car_agi.getValue());
        hab.getHm_habilidades().put(HABILIDAD_CAR_CON, (Integer) jSpinner_crear_car_con.getValue());
        hab.getHm_habilidades().put(HABILIDAD_CAR_I, (Integer) jSpinner_crear_car_I.getValue());
        hab.getHm_habilidades().put(HABILIDAD_CAR_INT, (Integer) jSpinner_crear_car_int.getValue());
        hab.getHm_habilidades().put(HABILIDAD_CAR_PRE, (Integer) jSpinner_crear_car_pre.getValue());

        hab.getHm_habilidades().put(HABILIDAD_MM_SINARMADURA, (Integer) jSpinner_crearMMSA.getValue());
        hab.getHm_habilidades().put(HABILIDAD_MM_CUERO, (Integer) jSpinner_crearMMC.getValue());
        hab.getHm_habilidades().put(HABILIDAD_MM_CUERO_ENDURECIDO, (Integer) jSpinner_crearMMCE.getValue());
        hab.getHm_habilidades().put(HABILIDAD_MM_COTA_DE_MALLA, (Integer) jSpinner_crearMMCM.getValue());
        hab.getHm_habilidades().put(HABILIDAD_MM_CORAZA, (Integer) jSpinner_crearMMCO.getValue());

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

            //hab.setAgi((Integer) this.jSpinner_crearBD.getValue());
            est.setArmadura_puesta(((Integer) this.jSpinner_crearArmadura.getValue()));

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


    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        newToken = null;
        this.dispose();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton_generaNombreAleatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generaNombreAleatorioActionPerformed
        String n = Recursos.nombres.get(Recursos.aleatorioEntre(0, Recursos.nombres.size()));
        jTextField_crearnombre.setText(n);

        int nivel = (Integer) jSpinner_crearNIvel.getValue();

        int fue = recursos.Recursos.generarCaracteristica(25);
        int con = recursos.Recursos.generarCaracteristica(25);
        int agi = recursos.Recursos.generarCaracteristica(25);
        int inte = recursos.Recursos.generarCaracteristica(25);
        jSpinner_crear_car_fue.setValue(fue);
        jSpinner_crear_car_agi.setValue(agi);
        jSpinner_crear_car_con.setValue(con);
        jSpinner_crear_car_int.setValue(inte);
        jSpinner_crear_car_I.setValue(recursos.Recursos.generarCaracteristica(25));
        jSpinner_crear_car_pre.setValue(recursos.Recursos.generarCaracteristica(25));

        // seteo armadura
        int arm = 1;
        if (fue > agi && Recursos.posibilidad(70)) {
            arm = Recursos.aleatorioEntre(13, 20);
        } else {
            arm = Recursos.aleatorioEntre(13, 20);
        }

        jSpinner_crearArmadura.setValue(Recursos.aleatorioEntre(1, 12));

        jSpinner_crearMMSA.setValue(agi);
        jSpinner_crearMMC.setValue(agi - 15);
        jSpinner_crearMMCE.setValue(agi - 30);
        jSpinner_crearMMCM.setValue(fue - 45);
        jSpinner_crearMMCO.setValue(fue - 60);

        int puntos = Recursos.aleatorioEntre(1, 5) * nivel;
        for (int j = 0; j < puntos; j++) {

            if (Recursos.posibilidad(60)) {
                int armaduraAmentar = Recursos.movManParaArmadura(arm);
                int nuevoValor = ((Integer) spin_mm.get(armaduraAmentar).getValue()) + 5;
                spin_mm.get(armaduraAmentar).setValue(nuevoValor);
            } else {
                int armaduraAmentar = Recursos.aleatorioEntre(HABILIDAD_MM_SINARMADURA, HABILIDAD_MM_CORAZA);
                int nuevoValor = ((Integer) spin_mm.get(armaduraAmentar).getValue()) + 5;
                spin_mm.get(armaduraAmentar).setValue(nuevoValor);
            }

        }

        // seteo puntos de vida;
        int pv = 5 + con;
        for (int j = 0; j < nivel; j++) {

            boolean yes = Recursos.posibilidad(90);
            if (yes) {
                pv += Recursos.aleatorioEntre(1, 10);
                pv += Recursos.aleatorioEntre(1, 10);
            } else {
                pv += Recursos.aleatorioEntre(1, 10);
            }

        }
        int pp = Recursos.generarPuntosDePoder(inte, nivel);
        jSpinner_crearPP.setValue(pp);
        jSpinner_crearPV.setValue(pv);

        //jComboBox_crearBDArma.setSelectedIndex(Recursos.aleatorioEntre(0, Recursos.armeria.size() - 1));
        //Arma der = (Arma) jComboBox_crearBDArma.getSelectedItem();
        
        DefaultListModel jdlm = (DefaultListModel) jList_Armas.getModel();
        jdlm.removeAllElements();
        DefaultListModel jdlmo = (DefaultListModel) jList_Bos.getModel();
        jdlmo.removeAllElements();
        bos.clear();

        // Dominio y sortilegios
        Dado d100 = new Dado();
        int pos = d100.lanzarAbierta();
        int dominio = 0;
        if (pos < 49) {
            dominio = 0;
        }
        if (pos > 49) {
            dominio = 1;
        }
        if (pos > 100) {
            dominio = 2;
        }
        if (pos > 150) {
            dominio = 3;
        }
        if (pos > 200) {
            dominio = 4;
        }
        if (pos > 250) {
            dominio = 5;
        }
        if (pos > 300) {
            dominio = 6;
        }
        jComboBox_dom.setSelectedIndex(dominio);

        newhabHabilidad = new Caracteristicas();

        int chance = 25;
        for (int i = 0; i < Recursos.aleatorioEntre(1, 10); i++) {

            if (d100.lanzarCerrada() < chance) {
                ListaDeSortilegios lds = (ListaDeSortilegios) Recursos.aleatorioDe(Principal.getTodasLasListasDeSortilegiosAbiertas(dominio));
                if (lds != null) {
                    newhabHabilidad.aprenderListaDeSortilegio(lds.getId(), 50);
                }

            }
            if (d100.lanzarAbierta() > 150) {
                Sortilegio s = (Sortilegio) Recursos.aleatorioDe(Principal.getTodosLosSortilegios());
                if (dominio == s.getDominio() || dominio > 2) {
                    newhabHabilidad.aprenderSortilegio(s.getId());
                }
            }
            chance -= Recursos.aleatorioEntre(1, 5);
        }

        agregarArmaALalista(Recursos.armeria.get(0));

        int cant_armas = Recursos.aleatorioEntre(1, 3);
        boolean tieneEscudo = false;
        ArrayList<Integer> est_armas = new ArrayList<>();
        for (int i = 0; i < cant_armas; i++) {
            Arma a = Recursos.armeria.get(Recursos.aleatorioEntre(1, 30));                       
                
            if ((a.getClase() == ESTILO_FILO || a.getClase() == ESTILO_CONTUNDENTE) && !tieneEscudo) {
                agregarArmaALalista(Recursos.escudoAlAzar());
                tieneEscudo = true;
            }
            if (a.getClase() != CLASE_ESCUDO) {
                est_armas.add(a.getEstilo());
                agregarArmaALalista(a);
            } else {
             i--;   
            }
        }

        bos.add(new Bo(ESTILO_PELEA, Recursos.aleatorioEntre(0, 4)));
        bos.add(new Bo(ESTILO_FILO, Recursos.aleatorioEntre(0, 4)));
        bos.add(new Bo(ESTILO_CONTUNDENTE, Recursos.aleatorioEntre(0, 4)));
        bos.add(new Bo(ESTILO_DOS_MANOS, Recursos.aleatorioEntre(0, 4)));
        bos.add(new Bo(ESTILO_ARROJADIZA, Recursos.aleatorioEntre(0, 4)));
        bos.add(new Bo(ESTILO_PROYECTILES, Recursos.aleatorioEntre(0, 4)));
        bos.add(new Bo(ESTILO_ASTA, Recursos.aleatorioEntre(0, 3)));

        // verifico que si existe un arma cuyo estilo no tiene una Bo correspondiente cargada, la cargue
        for (Integer est : est_armas) {
            boolean existe = false;
            for (Bo bo : bos) {
                if (bo.getEstilo() == est) {
                    bo.setValue(1);
                    existe = true;
                    break;
                }
            }
            if (!existe) {
                bos.add(new Bo(est, Recursos.aleatorioEntre(1, 3)));
                
            }
        }
        // agrego al menos 1 punto, para que la Bo de su arma no sea negativa
        
        puntos = recursos.Recursos.aleatorioEntre(6, 9) * nivel;
        for (int j = 0; j < puntos; j++) {
            int posi = 50;
            boolean puntodado = false;
            for (Integer est : est_armas) {
                if (Recursos.posibilidad(posi)) {
                    int nuevoValor = boPorEstilo(est).getValue() + Recursos.aleatorioEntre(1, 3);
                    boPorEstilo(est).setValue(nuevoValor);
                    puntodado = true;
                }
            }
            if (!puntodado) {
                int boA = Recursos.aleatorioEntre(ESTILO_FILO, ESTILO_ASTA);
                int nuevoValor = bos.get(boA).getValue() + Recursos.aleatorioEntre(1, 2);
                bos.get(boA).setValue(nuevoValor);
            }
            // pelea se sube aparte como secundaria

            int nuevoValor = bos.get(ESTILO_PELEA).getValue() + Recursos.aleatorioEntre(0, 2);
            bos.get(ESTILO_PELEA).setValue(nuevoValor);
        }

        int bono_prof = nivel * Recursos.aleatorioEntre(1, 3);

//        
//        bos.get(ESTILO_PELEA).setValue(Recursos.cuadraditosABono(bos.get(ESTILO_PELEA).getValue()) + fue + bono_prof);
//        bos.get(ESTILO_FILO).setValue(Recursos.cuadraditosABono(bos.get(ESTILO_FILO).getValue()) + fue + bono_prof);
//        bos.get(ESTILO_CONTUNDENTE).setValue(Recursos.cuadraditosABono(bos.get(ESTILO_CONTUNDENTE).getValue()) + fue + bono_prof);
//        bos.get(ESTILO_DOS_MANOS).setValue(Recursos.cuadraditosABono(bos.get(ESTILO_DOS_MANOS).getValue()) + fue + bono_prof);
//        bos.get(ESTILO_ARROJADIZA).setValue(Recursos.cuadraditosABono(bos.get(ESTILO_ARROJADIZA).getValue()) + agi + bono_prof);
//        bos.get(ESTILO_PROYECTILES).setValue(Recursos.cuadraditosABono(bos.get(ESTILO_PROYECTILES).getValue()) + agi + bono_prof);
//        bos.get(ESTILO_ASTA).setValue(Recursos.cuadraditosABono(bos.get(ESTILO_ASTA).getValue()) + fue + bono_prof);
        for (Bo bo : bos) {
            int estilo = bo.getEstilo();
            int sumar = bono_prof + ((estilo == ESTILO_PROYECTILES || estilo == ESTILO_ARROJADIZA) ? agi : fue);
            int bono = Recursos.cuadraditosABono(bo.getValue());
            bo.setValue(sumar + bono);
            agregarBoALaLista(bo);
        }

        /*
        for (int i = 1; i <= ESTILO_ASTA; i++) {
            Bo b = new Bo(i, 0);
            b.setValue(Recursos.nuevaBo(nivel, i));
            agregarBoALaLista(b);
        }
         */

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

    private void jSpinner_crearArmaduraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_crearArmaduraStateChanged
        int arm = (Integer) jSpinner_crearArmadura.getValue();
        jTextField_arm.setText(Recursos.tipoArmadura(arm));

    }//GEN-LAST:event_jSpinner_crearArmaduraStateChanged

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
            if (!bos.contains(bo)) {
                bos.add(bo);
            }
        }
    }

    private Object[] listaArmas() {

        return Recursos.armeria.toArray();
    }

    public static Token nuevoToken() {
        newhabHabilidad = null;
        newToken = null;
        CrearToken ct = new CrearToken(true);
        ct.setVisible(true);
        return newToken;
    }

    private Bo boPorEstilo(int estilo){
        for (Bo bo : bos) {
            if (bo.getEstilo() == estilo)
                return bo;
        }
        return null;
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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
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
    private javax.swing.JPanel jPanel_caract_Agi;
    private javax.swing.JPanel jPanel_caract_Con;
    private javax.swing.JPanel jPanel_caract_Int;
    private javax.swing.JPanel jPanel_caract_fue;
    private javax.swing.JPanel jPanel_caract_i;
    private javax.swing.JPanel jPanel_caract_pre;
    private javax.swing.JPanel jPanel_mmsa;
    private javax.swing.JPanel jPanel_mmsa1;
    private javax.swing.JPanel jPanel_mmsa2;
    private javax.swing.JPanel jPanel_mmsa3;
    private javax.swing.JPanel jPanel_mmsa4;
    private javax.swing.JRadioButton jRadioButton_crearEstilo1;
    private javax.swing.JRadioButton jRadioButton_crearEstilo2;
    private javax.swing.JRadioButton jRadioButton_crearEstilo3;
    private javax.swing.JRadioButton jRadioButton_crearEstilo4;
    private javax.swing.JRadioButton jRadioButton_crearEstilo5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider_crearPvActuales;
    private javax.swing.JSpinner jSpinner_crearArmadura;
    private javax.swing.JSpinner jSpinner_crearMMC;
    private javax.swing.JSpinner jSpinner_crearMMCE;
    private javax.swing.JSpinner jSpinner_crearMMCM;
    private javax.swing.JSpinner jSpinner_crearMMCO;
    private javax.swing.JSpinner jSpinner_crearMMSA;
    private javax.swing.JSpinner jSpinner_crearNIvel;
    private javax.swing.JSpinner jSpinner_crearPP;
    private javax.swing.JSpinner jSpinner_crearPV;
    private javax.swing.JSpinner jSpinner_crear_car_I;
    private javax.swing.JSpinner jSpinner_crear_car_agi;
    private javax.swing.JSpinner jSpinner_crear_car_con;
    private javax.swing.JSpinner jSpinner_crear_car_fue;
    private javax.swing.JSpinner jSpinner_crear_car_int;
    private javax.swing.JSpinner jSpinner_crear_car_pre;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField_arm;
    private javax.swing.JTextField jTextField_crearnombre;
    private javax.swing.ButtonGroup jbuttonGroup_crearEstilo;
    // End of variables declaration//GEN-END:variables
    private static Token newToken;
    private static Caracteristicas newhabHabilidad;
    ;
    // hashmap de MM para ahorrar codigo
    private HashMap<Integer, JSpinner> spin_mm = new HashMap<Integer, JSpinner>();

    private ArrayList<Bo> bos = new ArrayList<>();
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

    public static Token editarToken(boolean modal, Token token) {
        CrearToken ct = new CrearToken(modal, token);
        ct.setLocationRelativeTo(null);
        ct.setVisible(true);
        return newToken;
    }

}
