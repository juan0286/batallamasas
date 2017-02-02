/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Accion;
import instancias.Ataque;
import instancias.Token;
import javax.swing.JFrame;
import superrolbattle.Principal;

/**
 *
 * @author TiranoJuan
 */
public class DeclaraAccion extends javax.swing.JDialog {

    private JPanelFormToken_Accion token;
    private Principal principal;

    /**
     * Creates new form DeclaraAccion
     */
    public DeclaraAccion(Principal parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    DeclaraAccion(Principal parent, boolean modal, JPanelFormToken_Accion token) {
       super(parent, modal);
       this.token = token;
       this.principal = parent;
       
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel19 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTabbedPane_SeleccionAccion = new javax.swing.JTabbedPane();
        jPanel_Carga_Sortilegio_tabPanel1 = new javax.swing.JPanel();
        jPanel_Carga_Sortilegio_tabPanel_1 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jPanel_Realiza_Sortilegio_tabPanel = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel28 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jPanel_Dispara_Proyectil_tabPanel = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEnemigos1 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxArmas1 = new javax.swing.JComboBox();
        jPanel_distancia1 = new javax.swing.JPanel();
        jLabel_distancia1 = new javax.swing.JLabel();
        jSpinner_distancia1 = new javax.swing.JSpinner();
        jTextField12 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jPanel_Carga_Proyectil_tabPanel = new javax.swing.JPanel();
        jPanel_Parar_Proyectil_tabPanel = new javax.swing.JPanel();
        jPanel_Movimiento_Y_maniobra_tabPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxEnemigos = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jComboBoxArmas = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jRadioButton_brazoD = new javax.swing.JRadioButton();
        jRadioButton_brazoI = new javax.swing.JRadioButton();
        jPanel_distancia = new javax.swing.JPanel();
        jLabel_distancia = new javax.swing.JLabel();
        jSpinner_distancia = new javax.swing.JSpinner();
        jTextField4 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jPanel14 = new javax.swing.JPanel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel_Desplazamiento_tabPanel = new javax.swing.JPanel();
        jPanel_distancia2 = new javax.swing.JPanel();
        jLabel_distancia2 = new javax.swing.JLabel();
        jSpinner_distancia2 = new javax.swing.JSpinner();
        jTextField9 = new javax.swing.JTextField();
        jPanel_Movimiento_Estatico = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel22 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(626, 316));
        setMinimumSize(new java.awt.Dimension(626, 226));
        setPreferredSize(new java.awt.Dimension(626, 316));
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1);
        jPanel1.add(jProgressBar1);

        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3);

        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        jLabel5.setText("Act.");
        jPanel13.add(jLabel5);

        jTextField3.setEditable(false);
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setText("0");
        jPanel13.add(jTextField3);

        jPanel1.add(jPanel13);

        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.LINE_AXIS));

        jLabel11.setText("BD  ");
        jPanel10.add(jLabel11);

        jTextField5.setEditable(false);
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("0");
        jPanel10.add(jTextField5);

        jPanel1.add(jPanel10);

        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.LINE_AXIS));

        jLabel12.setText("BD  ");
        jPanel21.add(jLabel12);

        jTextField6.setEditable(false);
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField6.setText("0");
        jPanel21.add(jTextField6);

        jPanel1.add(jPanel21);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jTabbedPane_SeleccionAccion.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel_Carga_Sortilegio_tabPanel1.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setLayout(new javax.swing.BoxLayout(jPanel_Carga_Sortilegio_tabPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel21.setText("Sortilegio");
        jPanel31.add(jLabel21);

        jTextField16.setText(" ");
        jTextField16.setMaximumSize(new java.awt.Dimension(275, 20));
        jTextField16.setMinimumSize(new java.awt.Dimension(275, 20));
        jTextField16.setName(""); // NOI18N
        jTextField16.setPreferredSize(new java.awt.Dimension(275, 20));
        jPanel31.add(jTextField16);

        jPanel_Carga_Sortilegio_tabPanel_1.add(jPanel31);

        jPanel_Carga_Sortilegio_tabPanel1.add(jPanel_Carga_Sortilegio_tabPanel_1);

        jPanel32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setText("Asaltos Cargados");
        jPanel32.add(jLabel22);

        jTextField17.setEditable(false);
        jTextField17.setText(" ");
        jTextField17.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField17.setMinimumSize(new java.awt.Dimension(75, 20));
        jTextField17.setName(""); // NOI18N
        jTextField17.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel32.add(jTextField17);

        jLabel23.setText("Bono");
        jPanel32.add(jLabel23);

        jTextField18.setEditable(false);
        jTextField18.setText(" ");
        jTextField18.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField18.setMinimumSize(new java.awt.Dimension(75, 20));
        jTextField18.setName(""); // NOI18N
        jTextField18.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel32.add(jTextField18);

        jPanel20.add(jPanel32);

        jPanel_Carga_Sortilegio_tabPanel1.add(jPanel20);

        jTabbedPane_SeleccionAccion.addTab("Carga Sortilegio", jPanel_Carga_Sortilegio_tabPanel1);

        jPanel_Realiza_Sortilegio_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setLayout(new javax.swing.BoxLayout(jPanel_Realiza_Sortilegio_tabPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel23.setLayout(new javax.swing.BoxLayout(jPanel23, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel25.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Sortilegio");
        jPanel25.add(jLabel14);

        jTextField11.setText(" ");
        jTextField11.setMaximumSize(new java.awt.Dimension(275, 20));
        jTextField11.setMinimumSize(new java.awt.Dimension(275, 20));
        jTextField11.setName(""); // NOI18N
        jTextField11.setPreferredSize(new java.awt.Dimension(275, 20));
        jPanel25.add(jTextField11);

        jPanel23.add(jPanel25);

        jLabel15.setText("Nivel");
        jPanel26.add(jLabel15);

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        jPanel26.add(jSpinner1);

        jPanel23.add(jPanel26);

        jPanel28.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setText("Asaltos Cargados");
        jPanel28.add(jLabel19);

        jTextField14.setEditable(false);
        jTextField14.setText(" ");
        jTextField14.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField14.setMinimumSize(new java.awt.Dimension(75, 20));
        jTextField14.setName(""); // NOI18N
        jTextField14.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel28.add(jTextField14);

        jLabel20.setText("Bono");
        jPanel28.add(jLabel20);

        jTextField15.setEditable(false);
        jTextField15.setText(" ");
        jTextField15.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField15.setMinimumSize(new java.awt.Dimension(75, 20));
        jTextField15.setName(""); // NOI18N
        jTextField15.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel28.add(jTextField15);

        jPanel23.add(jPanel28);

        jPanel_Realiza_Sortilegio_tabPanel.add(jPanel23);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 139, Short.MAX_VALUE)
        );

        jPanel_Realiza_Sortilegio_tabPanel.add(jPanel24);

        jTabbedPane_SeleccionAccion.addTab("Realiza Sortilegio", jPanel_Realiza_Sortilegio_tabPanel);

        jPanel_Dispara_Proyectil_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Dispara_Proyectil_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Dispara_Proyectil_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Dispara_Proyectil_tabPanel.setLayout(new java.awt.BorderLayout());

        jPanel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel27.setMaximumSize(new java.awt.Dimension(224, 185));
        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel16.setText("Enemigo");
        jPanel27.add(jLabel16);

        jComboBoxEnemigos1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel27.add(jComboBoxEnemigos1);

        jLabel17.setText("Arma");
        jPanel27.add(jLabel17);

        jComboBoxArmas1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxArmas1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArmas1ItemStateChanged(evt);
            }
        });
        jPanel27.add(jComboBoxArmas1);

        jPanel_distancia1.setLayout(new javax.swing.BoxLayout(jPanel_distancia1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel_distancia1.setText("  Distancia  ");
        jPanel_distancia1.add(jLabel_distancia1);

        jSpinner_distancia1.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 3));
        jPanel_distancia1.add(jSpinner_distancia1);

        jTextField12.setEditable(false);
        jTextField12.setText("mts.");
        jTextField12.setMaximumSize(new java.awt.Dimension(26, 28));
        jTextField12.setMinimumSize(new java.awt.Dimension(26, 28));
        jTextField12.setName(""); // NOI18N
        jTextField12.setPreferredSize(new java.awt.Dimension(26, 28));
        jTextField12.setRequestFocusEnabled(false);
        jPanel_distancia1.add(jTextField12);

        jPanel27.add(jPanel_distancia1);

        jPanel33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel24.setText("Asaltos Cargados");
        jPanel33.add(jLabel24);

        jTextField19.setEditable(false);
        jTextField19.setText(" ");
        jTextField19.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField19.setMinimumSize(new java.awt.Dimension(75, 20));
        jTextField19.setName(""); // NOI18N
        jTextField19.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel33.add(jTextField19);

        jLabel25.setText("Bono");
        jPanel33.add(jLabel25);

        jTextField20.setEditable(false);
        jTextField20.setText(" ");
        jTextField20.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField20.setMinimumSize(new java.awt.Dimension(75, 20));
        jTextField20.setName(""); // NOI18N
        jTextField20.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel33.add(jTextField20);

        jPanel27.add(jPanel33);

        jPanel_Dispara_Proyectil_tabPanel.add(jPanel27, java.awt.BorderLayout.PAGE_START);

        jTabbedPane_SeleccionAccion.addTab("Dispara Proyectil", jPanel_Dispara_Proyectil_tabPanel);

        jPanel_Carga_Proyectil_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Proyectil_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Proyectil_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Proyectil_tabPanel.setLayout(null);
        jTabbedPane_SeleccionAccion.addTab("Carga Proyectil", jPanel_Carga_Proyectil_tabPanel);

        jPanel_Parar_Proyectil_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Parar_Proyectil_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Parar_Proyectil_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Parar_Proyectil_tabPanel.setLayout(null);
        jTabbedPane_SeleccionAccion.addTab("Parar Proyectil", jPanel_Parar_Proyectil_tabPanel);

        jPanel_Movimiento_Y_maniobra_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Y_maniobra_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Y_maniobra_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Y_maniobra_tabPanel.setLayout(new javax.swing.BoxLayout(jPanel_Movimiento_Y_maniobra_tabPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Descripciòn"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel_Movimiento_Y_maniobra_tabPanel.add(jPanel4);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Dificultad"));
        jPanel6.setLayout(new java.awt.GridLayout(3, 3));

        buttonGroup2.add(jRadioButton1);
        jRadioButton1.setText("Rutinaria");
        jPanel6.add(jRadioButton1);

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Muy Facil");
        jPanel6.add(jRadioButton2);

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Facil");
        jPanel6.add(jRadioButton3);

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Media");
        jPanel6.add(jRadioButton4);

        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setText("Dificil");
        jPanel6.add(jRadioButton5);

        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setText("Muy Dificil");
        jPanel6.add(jRadioButton6);

        buttonGroup2.add(jRadioButton7);
        jRadioButton7.setText("Extrem. Dificil");
        jPanel6.add(jRadioButton7);

        buttonGroup2.add(jRadioButton8);
        jRadioButton8.setText("Locura");
        jPanel6.add(jRadioButton8);

        buttonGroup2.add(jRadioButton9);
        jRadioButton9.setText("Absurdo");
        jPanel6.add(jRadioButton9);

        jPanel_Movimiento_Y_maniobra_tabPanel.add(jPanel6);

        jTabbedPane_SeleccionAccion.addTab("Movimiento Y maniobra", jPanel_Movimiento_Y_maniobra_tabPanel);

        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setLayout(new java.awt.BorderLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setMaximumSize(new java.awt.Dimension(224, 185));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel6.setText("Enemigo");
        jPanel15.add(jLabel6);

        jComboBoxEnemigos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel15.add(jComboBoxEnemigos);

        jLabel7.setText("Arma");
        jPanel15.add(jLabel7);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jComboBoxArmas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxArmas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArmasItemStateChanged(evt);
            }
        });
        jPanel5.add(jComboBoxArmas);

        jButton3.setText("+");
        jPanel5.add(jButton3);

        jPanel15.add(jPanel5);

        jPanel16.setMaximumSize(new java.awt.Dimension(201, 38));
        jPanel16.setPreferredSize(new java.awt.Dimension(201, 38));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.LINE_AXIS));

        jRadioButton_brazoD.setSelected(true);
        jRadioButton_brazoD.setText("Brazo D");
        jPanel16.add(jRadioButton_brazoD);

        jRadioButton_brazoI.setText("Brazo I (-30)");
        jPanel16.add(jRadioButton_brazoI);

        jPanel15.add(jPanel16);

        jPanel_distancia.setLayout(new javax.swing.BoxLayout(jPanel_distancia, javax.swing.BoxLayout.LINE_AXIS));

        jLabel_distancia.setText("  Distancia  ");
        jPanel_distancia.add(jLabel_distancia);

        jSpinner_distancia.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 3));
        jPanel_distancia.add(jSpinner_distancia);

        jTextField4.setEditable(false);
        jTextField4.setText("mts.");
        jTextField4.setMaximumSize(new java.awt.Dimension(26, 28));
        jTextField4.setMinimumSize(new java.awt.Dimension(26, 28));
        jTextField4.setName(""); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(26, 28));
        jTextField4.setRequestFocusEnabled(false);
        jPanel_distancia.add(jTextField4);

        jPanel15.add(jPanel_distancia);

        jPanel17.setMaximumSize(new java.awt.Dimension(32767, 159));
        jPanel17.setMinimumSize(new java.awt.Dimension(133, 100));
        jPanel17.setPreferredSize(new java.awt.Dimension(201, 100));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("% de bo para el Ataque");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel17.add(jLabel8);

        jSlider1.setForeground(new java.awt.Color(102, 102, 102));
        jSlider1.setMajorTickSpacing(25);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jPanel17.add(jSlider1);

        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jTextField7.setEditable(false);
        jTextField7.setText("Bo 120");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel14.add(jTextField7);

        jTextField8.setEditable(false);
        jTextField8.setText("Bd 34");
        jPanel14.add(jTextField8);

        jPanel17.add(jPanel14);

        jPanel15.add(jPanel17);

        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jTabbedPane_SeleccionAccion.addTab("Ataque Cuerpo a Cuerpo", jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA);

        jPanel_Desplazamiento_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Desplazamiento_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Desplazamiento_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));

        jPanel_distancia2.setLayout(new javax.swing.BoxLayout(jPanel_distancia2, javax.swing.BoxLayout.LINE_AXIS));

        jLabel_distancia2.setText("  Distancia  ");
        jPanel_distancia2.add(jLabel_distancia2);

        jSpinner_distancia2.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 3));
        jPanel_distancia2.add(jSpinner_distancia2);

        jTextField9.setEditable(false);
        jTextField9.setText("mts.");
        jTextField9.setMaximumSize(new java.awt.Dimension(26, 28));
        jTextField9.setMinimumSize(new java.awt.Dimension(26, 28));
        jTextField9.setName(""); // NOI18N
        jTextField9.setPreferredSize(new java.awt.Dimension(26, 28));
        jTextField9.setRequestFocusEnabled(false);
        jPanel_distancia2.add(jTextField9);

        jPanel_Desplazamiento_tabPanel.add(jPanel_distancia2);

        jTabbedPane_SeleccionAccion.addTab("Desplazamiento", jPanel_Desplazamiento_tabPanel);

        jPanel_Movimiento_Estatico.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Estatico.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Estatico.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Estatico.setLayout(null);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Descripciòn"));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel7.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        jPanel_Movimiento_Estatico.add(jPanel7);
        jPanel7.setBounds(0, 0, 270, 110);

        jTabbedPane_SeleccionAccion.addTab("Movimiento Estatico", jPanel_Movimiento_Estatico);

        getContentPane().add(jTabbedPane_SeleccionAccion, java.awt.BorderLayout.CENTER);

        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton1);

        jButton2.setText("Cancelar");
        jPanel22.add(jButton2);

        getContentPane().add(jPanel22, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxArmasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArmasItemStateChanged
       
    }//GEN-LAST:event_jComboBoxArmasItemStateChanged

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jComboBoxArmas1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArmas1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxArmas1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        declarar();                
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

        
    private void declarar(){
        Accion acc = new Accion(1, 1, 1);
        acc.setTipo(this.jTabbedPane_SeleccionAccion.getSelectedIndex()+1);
        principal.moverAccion(token);
                
      //  token.AgregarAccion(acc);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBoxArmas;
    private javax.swing.JComboBox jComboBoxArmas1;
    private javax.swing.JComboBox jComboBoxEnemigos;
    private javax.swing.JComboBox jComboBoxEnemigos1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_distancia;
    private javax.swing.JLabel jLabel_distancia1;
    private javax.swing.JLabel jLabel_distancia2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA;
    private javax.swing.JPanel jPanel_Carga_Proyectil_tabPanel;
    private javax.swing.JPanel jPanel_Carga_Sortilegio_tabPanel1;
    private javax.swing.JPanel jPanel_Carga_Sortilegio_tabPanel_1;
    private javax.swing.JPanel jPanel_Desplazamiento_tabPanel;
    private javax.swing.JPanel jPanel_Dispara_Proyectil_tabPanel;
    private javax.swing.JPanel jPanel_Movimiento_Estatico;
    private javax.swing.JPanel jPanel_Movimiento_Y_maniobra_tabPanel;
    private javax.swing.JPanel jPanel_Parar_Proyectil_tabPanel;
    private javax.swing.JPanel jPanel_Realiza_Sortilegio_tabPanel;
    private javax.swing.JPanel jPanel_distancia;
    private javax.swing.JPanel jPanel_distancia1;
    private javax.swing.JPanel jPanel_distancia2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton jRadioButton_brazoD;
    private javax.swing.JRadioButton jRadioButton_brazoI;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner_distancia;
    private javax.swing.JSpinner jSpinner_distancia1;
    private javax.swing.JSpinner jSpinner_distancia2;
    private javax.swing.JTabbedPane jTabbedPane_SeleccionAccion;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
