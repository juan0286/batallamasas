/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.properties.alteracion.Alteracion;
import instancias.properties.Status;
import java.awt.Color;
import java.awt.Font;
import recursos.Constantes;
import recursos.Recursos;

/**
 *
 * @author Juan
 */
public class CrearAlteraracion extends javax.swing.JDialog {

    /**
     * Creates new form DañarToken
     */
    public CrearAlteraracion(java.awt.Frame parent, boolean modal, JPanelFormToken_Accion token) {
        super(parent, modal);
        initComponents();
        this.setTitle("Altarar a " + token.getToken().getNombre());
        this.panel_token = token;

        jTextField_Actual_pv.setText(token.getToken().getpv());
//
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_EstadoFisico = new javax.swing.ButtonGroup();
        jPanel10 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jCheckBox_brazo_izq = new javax.swing.JCheckBox();
        jCheckBox_brazo_der = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jPanel3_Status = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jPanel33 = new javax.swing.JPanel();
        jRadioButton_Firme = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jRadioButton_postrado = new javax.swing.JRadioButton();
        jPanel14 = new javax.swing.JPanel();
        jRadioButton_Dormido = new javax.swing.JRadioButton();
        jPanel31 = new javax.swing.JPanel();
        jRadioButton_coma = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jRadioButton_muerto = new javax.swing.JRadioButton();
        jSpinner_asParamoriri = new javax.swing.JSpinner();
        jPanel18 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBox_pv = new javax.swing.JComboBox();
        jTextField_Actual_pv = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSpinner_sangrado = new javax.swing.JSpinner();
        jTextField_Actual_sangrado = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jSpinner_obligado_a_parar = new javax.swing.JSpinner();
        jTextField_Actual_obligadoParar = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jSpinner_Aturdido = new javax.swing.JSpinner();
        jTextField_Actual_aturdido = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jSpinner_AturdidoSinParar = new javax.swing.JSpinner();
        jTextField_Actual_aturdidoSinParar = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jSpinner_mod_Actividad = new javax.swing.JSpinner();
        jTextField_Actual_Actividad = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jSpinner_bonificarBD = new javax.swing.JSpinner();
        jTextField_Actual_Bd = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jSpinner_bonificarBO = new javax.swing.JSpinner();
        jTextField_Actual_bo = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jSpinner3 = new javax.swing.JSpinner();
        jTextField9 = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jSpinner_bonificarMm = new javax.swing.JSpinner();
        jTextField_Actual_MM = new javax.swing.JTextField();
        jPanel_curar_dañar = new javax.swing.JPanel();
        jCheckBox_daño_curacion = new javax.swing.JCheckBox();
        jPanel30 = new javax.swing.JPanel();
        jPanel_descripcion = new javax.swing.JPanel();
        jScrollPane_Resumen = new javax.swing.JScrollPane();
        jTextArea_descp = new javax.swing.JTextArea();
        jPanel15 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jComboBox_dura_hrs = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_dura_mis = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox_dura_As = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox_curacion_progresiva = new javax.swing.JCheckBox();
        jPanel_Aceptar_cancelar = new javax.swing.JPanel();
        jButton_aceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Miembros Inutilizados"));

        jCheckBox_brazo_izq.setText("Brazo Izquierdo");
        jPanel3.add(jCheckBox_brazo_izq);

        jCheckBox_brazo_der.setText("Brazo Derecho");
        jPanel3.add(jCheckBox_brazo_der);

        jCheckBox6.setText("Pierna Izquierda");
        jPanel3.add(jCheckBox6);

        jCheckBox7.setText("Pierna Derecha");
        jPanel3.add(jCheckBox7);

        jPanel10.add(jPanel3);

        jPanel3_Status.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3_Status.setLayout(new javax.swing.BoxLayout(jPanel3_Status, javax.swing.BoxLayout.LINE_AXIS));

        jPanel29.setLayout(new javax.swing.BoxLayout(jPanel29, javax.swing.BoxLayout.LINE_AXIS));

        jPanel33.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_EstadoFisico.add(jRadioButton_Firme);
        jRadioButton_Firme.setSelected(true);
        jRadioButton_Firme.setText("Firme");
        jPanel33.add(jRadioButton_Firme);

        jPanel29.add(jPanel33);

        jPanel13.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_EstadoFisico.add(jRadioButton_postrado);
        jRadioButton_postrado.setText("Postrado");
        jPanel13.add(jRadioButton_postrado);

        jPanel29.add(jPanel13);

        jPanel14.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_EstadoFisico.add(jRadioButton_Dormido);
        jRadioButton_Dormido.setText("Dormido");
        jPanel14.add(jRadioButton_Dormido);

        jPanel29.add(jPanel14);

        jPanel31.setLayout(new java.awt.GridLayout(1, 2));

        buttonGroup_EstadoFisico.add(jRadioButton_coma);
        jRadioButton_coma.setText("Coma");
        jPanel31.add(jRadioButton_coma);

        jPanel29.add(jPanel31);

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        buttonGroup_EstadoFisico.add(jRadioButton_muerto);
        jRadioButton_muerto.setText("Muerto en");
        jPanel9.add(jRadioButton_muerto);

        jSpinner_asParamoriri.setModel(new javax.swing.SpinnerNumberModel(0, 0, 25, 1));
        jSpinner_asParamoriri.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_asParamoriri.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel9.add(jSpinner_asParamoriri);

        jPanel29.add(jPanel9);

        jPanel3_Status.add(jPanel29);

        jPanel10.add(jPanel3_Status);

        jPanel18.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel18.setLayout(new java.awt.BorderLayout());

        jPanel17.setLayout(new java.awt.GridLayout(0, 2));

        jPanel19.setLayout(new java.awt.BorderLayout());

        jLabel2.setText("Puntos de Vida");
        jPanel19.add(jLabel2, java.awt.BorderLayout.WEST);

        jComboBox_pv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75" }));
        jComboBox_pv.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_pv.setMaximumSize(new java.awt.Dimension(50, 20));
        jComboBox_pv.setMinimumSize(new java.awt.Dimension(50, 20));
        jComboBox_pv.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel2.add(jComboBox_pv);

        jTextField_Actual_pv.setEditable(false);
        jTextField_Actual_pv.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_pv.setName(""); // NOI18N
        jTextField_Actual_pv.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel2.add(jTextField_Actual_pv);

        jPanel19.add(jPanel2, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel19);

        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel9.setText("Sangre por asalto");
        jPanel21.add(jLabel9, java.awt.BorderLayout.WEST);

        jSpinner_sangrado.setModel(new javax.swing.SpinnerNumberModel(0, 0, 25, 1));
        jSpinner_sangrado.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_sangrado.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel4.add(jSpinner_sangrado);

        jTextField_Actual_sangrado.setEditable(false);
        jTextField_Actual_sangrado.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_sangrado.setName(""); // NOI18N
        jTextField_Actual_sangrado.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel4.add(jTextField_Actual_sangrado);

        jPanel21.add(jPanel4, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel21);

        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setText("Asaltos Obligado a Parar");
        jPanel7.add(jLabel4, java.awt.BorderLayout.WEST);

        jSpinner_obligado_a_parar.setModel(new javax.swing.SpinnerNumberModel(0, 0, 25, 1));
        jSpinner_obligado_a_parar.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_obligado_a_parar.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel5.add(jSpinner_obligado_a_parar);

        jTextField_Actual_obligadoParar.setEditable(false);
        jTextField_Actual_obligadoParar.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_obligadoParar.setName(""); // NOI18N
        jTextField_Actual_obligadoParar.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel5.add(jTextField_Actual_obligadoParar);

        jPanel7.add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel7);

        jPanel20.setLayout(new java.awt.BorderLayout());

        jLabel8.setText("Aturdimiento");
        jPanel20.add(jLabel8, java.awt.BorderLayout.WEST);

        jSpinner_Aturdido.setModel(new javax.swing.SpinnerNumberModel(0, 0, 25, 1));
        jSpinner_Aturdido.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_Aturdido.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel6.add(jSpinner_Aturdido);

        jTextField_Actual_aturdido.setEditable(false);
        jTextField_Actual_aturdido.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_aturdido.setName(""); // NOI18N
        jTextField_Actual_aturdido.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel6.add(jTextField_Actual_aturdido);

        jPanel20.add(jPanel6, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel20);

        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel5.setText("As. Aturdido y sin parar");
        jPanel8.add(jLabel5, java.awt.BorderLayout.WEST);

        jSpinner_AturdidoSinParar.setModel(new javax.swing.SpinnerNumberModel(0, 0, 25, 1));
        jSpinner_AturdidoSinParar.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_AturdidoSinParar.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel11.add(jSpinner_AturdidoSinParar);

        jTextField_Actual_aturdidoSinParar.setEditable(false);
        jTextField_Actual_aturdidoSinParar.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_aturdidoSinParar.setName(""); // NOI18N
        jTextField_Actual_aturdidoSinParar.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel11.add(jTextField_Actual_aturdidoSinParar);

        jPanel8.add(jPanel11, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel8);

        jPanel22.setLayout(new java.awt.BorderLayout());

        jLabel10.setText("Actividad");
        jPanel22.add(jLabel10, java.awt.BorderLayout.WEST);

        jSpinner_mod_Actividad.setModel(new javax.swing.SpinnerNumberModel(0, 0, 250, 5));
        jSpinner_mod_Actividad.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_mod_Actividad.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel12.add(jSpinner_mod_Actividad);

        jTextField_Actual_Actividad.setEditable(false);
        jTextField_Actual_Actividad.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_Actividad.setName(""); // NOI18N
        jTextField_Actual_Actividad.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel12.add(jTextField_Actual_Actividad);

        jPanel22.add(jPanel12, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel22);

        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel11.setText("Bono BD");
        jPanel23.add(jLabel11, java.awt.BorderLayout.WEST);

        jSpinner_bonificarBD.setModel(new javax.swing.SpinnerNumberModel(0, 0, 250, 5));
        jSpinner_bonificarBD.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_bonificarBD.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel25.add(jSpinner_bonificarBD);

        jTextField_Actual_Bd.setEditable(false);
        jTextField_Actual_Bd.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_Bd.setName(""); // NOI18N
        jTextField_Actual_Bd.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel25.add(jTextField_Actual_Bd);

        jPanel23.add(jPanel25, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel23);

        jPanel24.setLayout(new java.awt.BorderLayout());

        jLabel12.setText("Bono BO");
        jPanel24.add(jLabel12, java.awt.BorderLayout.WEST);

        jSpinner_bonificarBO.setModel(new javax.swing.SpinnerNumberModel(0, 0, 250, 5));
        jSpinner_bonificarBO.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_bonificarBO.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel27.add(jSpinner_bonificarBO);

        jTextField_Actual_bo.setEditable(false);
        jTextField_Actual_bo.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_bo.setName(""); // NOI18N
        jTextField_Actual_bo.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel27.add(jTextField_Actual_bo);

        jPanel24.add(jPanel27, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel24);

        jPanel26.setLayout(new java.awt.BorderLayout());

        jLabel14.setText("Bono TR");
        jPanel26.add(jLabel14, java.awt.BorderLayout.WEST);

        jSpinner3.setModel(new javax.swing.SpinnerNumberModel(0, 0, 250, 5));
        jSpinner3.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner3.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel28.add(jSpinner3);

        jTextField9.setEditable(false);
        jTextField9.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField9.setName(""); // NOI18N
        jTextField9.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel28.add(jTextField9);

        jPanel26.add(jPanel28, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel26);

        jPanel38.setLayout(new java.awt.BorderLayout());

        jLabel15.setText("Bono MM");
        jPanel38.add(jLabel15, java.awt.BorderLayout.WEST);

        jSpinner_bonificarMm.setModel(new javax.swing.SpinnerNumberModel(0, 0, 250, 5));
        jSpinner_bonificarMm.setMinimumSize(new java.awt.Dimension(50, 20));
        jSpinner_bonificarMm.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel32.add(jSpinner_bonificarMm);

        jTextField_Actual_MM.setEditable(false);
        jTextField_Actual_MM.setMinimumSize(new java.awt.Dimension(45, 20));
        jTextField_Actual_MM.setName(""); // NOI18N
        jTextField_Actual_MM.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel32.add(jTextField_Actual_MM);

        jPanel38.add(jPanel32, java.awt.BorderLayout.EAST);

        jPanel17.add(jPanel38);

        jPanel18.add(jPanel17, java.awt.BorderLayout.CENTER);

        jCheckBox_daño_curacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/health32.png"))); // NOI18N
        jCheckBox_daño_curacion.setIconTextGap(1);
        jCheckBox_daño_curacion.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jCheckBox_daño_curacion.setMaximumSize(new java.awt.Dimension(36, 32));
        jCheckBox_daño_curacion.setMinimumSize(new java.awt.Dimension(13, 13));
        jCheckBox_daño_curacion.setName(""); // NOI18N
        jCheckBox_daño_curacion.setPreferredSize(new java.awt.Dimension(36, 32));
        jCheckBox_daño_curacion.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/unheal32.png"))); // NOI18N
        jCheckBox_daño_curacion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox_daño_curacionStateChanged(evt);
            }
        });
        jPanel_curar_dañar.add(jCheckBox_daño_curacion);

        jPanel18.add(jPanel_curar_dañar, java.awt.BorderLayout.NORTH);

        jPanel10.add(jPanel18);

        getContentPane().add(jPanel10);

        jPanel30.setLayout(new javax.swing.BoxLayout(jPanel30, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel_descripcion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));
        jPanel_descripcion.setLayout(new javax.swing.BoxLayout(jPanel_descripcion, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea_descp.setColumns(20);
        jTextArea_descp.setRows(5);
        jScrollPane_Resumen.setViewportView(jTextArea_descp);

        jPanel_descripcion.add(jScrollPane_Resumen);

        jPanel15.setMaximumSize(new java.awt.Dimension(124, 93));
        jPanel15.setPreferredSize(new java.awt.Dimension(124, 93));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel34.setLayout(new java.awt.BorderLayout());

        jLabel3.setText("Duracion");
        jPanel34.add(jLabel3, java.awt.BorderLayout.WEST);

        jPanel16.setLayout(new java.awt.GridLayout(0, 2));

        jComboBox_dura_hrs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80" }));
        jComboBox_dura_hrs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_dura_hrs.setMaximumSize(new java.awt.Dimension(40, 20));
        jComboBox_dura_hrs.setMinimumSize(new java.awt.Dimension(35, 20));
        jComboBox_dura_hrs.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel16.add(jComboBox_dura_hrs);

        jLabel1.setText("Hrs.");
        jPanel16.add(jLabel1);

        jComboBox_dura_mis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80" }));
        jComboBox_dura_mis.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_dura_mis.setMaximumSize(new java.awt.Dimension(40, 20));
        jComboBox_dura_mis.setMinimumSize(new java.awt.Dimension(35, 20));
        jComboBox_dura_mis.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel16.add(jComboBox_dura_mis);

        jLabel7.setText("Min.");
        jPanel16.add(jLabel7);

        jComboBox_dura_As.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80" }));
        jComboBox_dura_As.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_dura_As.setMaximumSize(new java.awt.Dimension(40, 20));
        jComboBox_dura_As.setMinimumSize(new java.awt.Dimension(35, 20));
        jComboBox_dura_As.setPreferredSize(new java.awt.Dimension(40, 20));
        jPanel16.add(jComboBox_dura_As);

        jLabel6.setText("As.");
        jPanel16.add(jLabel6);

        jPanel34.add(jPanel16, java.awt.BorderLayout.EAST);

        jPanel15.add(jPanel34, java.awt.BorderLayout.WEST);

        jCheckBox_curacion_progresiva.setText("Curacion Progresiva");
        jPanel15.add(jCheckBox_curacion_progresiva, java.awt.BorderLayout.PAGE_START);

        jPanel_descripcion.add(jPanel15);

        jPanel30.add(jPanel_descripcion);

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

        jPanel30.add(jPanel_Aceptar_cancelar);

        getContentPane().add(jPanel30);

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

    private void jCheckBox_daño_curacionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox_daño_curacionStateChanged
        if (jCheckBox_daño_curacion.isSelected()) {
            // Daño
            jPanel_curar_dañar.setBackground(Color.pink);
            
        } else {
            // Curacion
            jPanel_curar_dañar.setBackground(Color.green);
            
        }
    }//GEN-LAST:event_jCheckBox_daño_curacionStateChanged

    private void aplicar() {
        instancias.Token tok = panel_token.getToken();
        Alteracion alt = new Alteracion();

//        int mod = (jCheckBox_daño_curacion.isSelected()) ? -1 : 1;
//
//        int pv = jComboBox_pv.getSelectedIndex() * mod;
//        alt.setPv(pv);
//
//        int sangre = (Integer) jSpinner_sangrado.getValue() * mod;
//        alt.setSangre(sangre);
//
//        int redAct = (Integer) jSpinner_mod_Actividad.getValue() * mod;
//        alt.setActividad(redAct);
//
//        int morirEn = (Integer) jSpinner_asParamoriri.getValue() * mod;
//        alt.setAsaltosparamorir(morirEn);
//
//        //   tok.getEstado().setActividadReducida(sangre);
//        //  int sangre = (Integer) jSpinner_sangrado.getValue();
//        //  tok.getEstado().setActividadReducida(sangre);
//        if (mod < 0) {
//
//            int oAParar = (Integer) jSpinner_obligado_a_parar.getValue() * mod;;
//            alt.setObligadoparar(oAParar);
//
//            int asAturdido = (Integer) jSpinner_Aturdido.getValue() * mod;;
//            alt.setAturdido(asAturdido);
//
//            int aturSinParar = (Integer) jSpinner_AturdidoSinParar.getValue() * mod;
//            alt.setSinpoderparar(aturSinParar);
//
//        } else {
//            int asAturdido = (Integer) jSpinner_Aturdido.getValue() * mod;;
//            alt.setAturdido(asAturdido);
//            alt.setObligadoparar(asAturdido);
//            alt.setSinpoderparar(asAturdido);
//        }
//
//        int bonoBO = (Integer) jSpinner_bonificarBO.getValue() * mod;
//        alt.setBoMod(bonoBO);
//
//        int bonoBd = (Integer) jSpinner_bonificarBD.getValue() * mod;;
//        alt.setBdMod(bonoBd);
//
//        int bonoMm = (Integer) jSpinner_bonificarMm.getValue() * mod;;
//        alt.setMmMod(bonoMm);
//
//        int bonoTr = (Integer) jSpinner_bonificarMm.getValue() * mod;;
//        alt.setTrMod(bonoTr);
//
//        tok.getManoDER().setHabilitado(!jCheckBox_brazo_der.isSelected());
//        tok.getManoIZQ().setHabilitado(!jCheckBox_brazo_izq.isSelected());
//
//        if (jRadioButton_Dormido.isSelected()) {
//            alt.setCuerpoEstado(Status.DORMIDO);
//        } else if (jRadioButton_Firme.isSelected()) {
//            alt.setCuerpoEstado(Status.FIRME);
//        } else if (jRadioButton_coma.isSelected()) {
//            alt.setCuerpoEstado(Status.COMA);
//        } else if (jRadioButton_postrado.isSelected()) {
//            alt.setCuerpoEstado(Status.POSTRADO);
//        } else if (jRadioButton_muerto.isSelected()) {
//            alt.setAsaltosparamorir(morirEn);
//        }
//        int duracion = 0;
//        int horas = jComboBox_dura_hrs.getSelectedIndex();
//        int minutos = jComboBox_dura_mis.getSelectedIndex();
//        duracion += Recursos.tiempoEnAsaltosParse(horas, Constantes.TIEMPO_DIAS);
//        duracion += Recursos.tiempoEnAsaltosParse(minutos, Constantes.TIEMPO_MINUTOS);
//        duracion += jComboBox_dura_As.getSelectedIndex();
//
//        alt.setCuracionProgresiva(jCheckBox_curacion_progresiva.isSelected());
//
//        alt.setDescripcion(jTextArea_descp.getText());
//
//        alt.setBrazoDerInUtil(jCheckBox_brazo_izq.isSelected());
//        alt.setBrazoIzqInUtil(jCheckBox_brazo_izq.isSelected());
//        alt.setPiernaDerInUtil(jCheckBox_brazo_izq.isSelected());
//        alt.setPiernaIzqInUtil(jCheckBox_brazo_izq.isSelected());
//        
//        if (jRadioButton_Firme.isSelected())
//            alt.setCuerpoEstado(Status.FIRME);
//        if (jRadioButton_Dormido.isSelected())
//            alt.setCuerpoEstado(Status.DORMIDO);
//        if (jRadioButton_coma.isSelected())
//            alt.setCuerpoEstado(Status.COMA);
//        if (jRadioButton_muerto.isSelected())
//            alt.setCuerpoEstado(Status.MUERTO);
//        if (jRadioButton_postrado.isSelected())
//            alt.setCuerpoEstado(Status.POSTRADO);
//        
//        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_EstadoFisico;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_aceptar;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JCheckBox jCheckBox_brazo_der;
    private javax.swing.JCheckBox jCheckBox_brazo_izq;
    private javax.swing.JCheckBox jCheckBox_curacion_progresiva;
    private javax.swing.JCheckBox jCheckBox_daño_curacion;
    private javax.swing.JComboBox jComboBox_dura_As;
    private javax.swing.JComboBox jComboBox_dura_hrs;
    private javax.swing.JComboBox jComboBox_dura_mis;
    private javax.swing.JComboBox jComboBox_pv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel3_Status;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Aceptar_cancelar;
    private javax.swing.JPanel jPanel_curar_dañar;
    private javax.swing.JPanel jPanel_descripcion;
    private javax.swing.JRadioButton jRadioButton_Dormido;
    private javax.swing.JRadioButton jRadioButton_Firme;
    private javax.swing.JRadioButton jRadioButton_coma;
    private javax.swing.JRadioButton jRadioButton_muerto;
    private javax.swing.JRadioButton jRadioButton_postrado;
    private javax.swing.JScrollPane jScrollPane_Resumen;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner_Aturdido;
    private javax.swing.JSpinner jSpinner_AturdidoSinParar;
    private javax.swing.JSpinner jSpinner_asParamoriri;
    private javax.swing.JSpinner jSpinner_bonificarBD;
    private javax.swing.JSpinner jSpinner_bonificarBO;
    private javax.swing.JSpinner jSpinner_bonificarMm;
    private javax.swing.JSpinner jSpinner_mod_Actividad;
    private javax.swing.JSpinner jSpinner_obligado_a_parar;
    private javax.swing.JSpinner jSpinner_sangrado;
    private javax.swing.JTextArea jTextArea_descp;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField_Actual_Actividad;
    private javax.swing.JTextField jTextField_Actual_Bd;
    private javax.swing.JTextField jTextField_Actual_MM;
    private javax.swing.JTextField jTextField_Actual_aturdido;
    private javax.swing.JTextField jTextField_Actual_aturdidoSinParar;
    private javax.swing.JTextField jTextField_Actual_bo;
    private javax.swing.JTextField jTextField_Actual_obligadoParar;
    private javax.swing.JTextField jTextField_Actual_pv;
    private javax.swing.JTextField jTextField_Actual_sangrado;
    // End of variables declaration//GEN-END:variables
    private JPanelFormToken_Accion panel_token;
    private static Alteracion alter;

    public static Alteracion CrearAlteracion(java.awt.Frame parent, boolean modal, JPanelFormToken_Accion token) {
        alter = null;

        CrearAlteraracion ca = new CrearAlteraracion(parent, modal, token);
        ca.setLocationRelativeTo(parent);
        ca.setVisible(true);

        return alter;
    }

}