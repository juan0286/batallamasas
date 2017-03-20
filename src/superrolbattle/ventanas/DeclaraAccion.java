/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Accion;
import instancias.Sortilegio;
import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Bo;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.SingleSelectionModel;
import recursos.Constantes;
import superrolbattle.Principal;

/**
 *
 * @author TiranoJuan
 */
public class DeclaraAccion extends javax.swing.JDialog {

    private JPanelFormToken_Accion token_accion;
    private Principal principal;

    /**
     * Creates new form DeclaraAccion
     */
    public DeclaraAccion(Principal parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    DeclaraAccion(Principal parent, boolean modal, JPanelFormToken_Accion token_accion) {
        super(parent, modal);
        this.token_accion = token_accion;
        this.principal = parent;

        Token token = token_accion.getToken();

        initComponents();
        this.setTitle("Acciones de " + token.getNombre());

        int tipo = token.getLastAction().getTipo();

        jComboBox_sotilegios.setModel(new DefaultComboBoxModel(token.getSortilegios().toArray()));
        jComboBox_sotilegios_Realiza.setModel(new DefaultComboBoxModel(token.getSortilegios().toArray()));
        jComboBoxArmas_Proy.setModel(new DefaultComboBoxModel(token.getArmasProyectiles().toArray()));
        jComboBoxArmas_cac.setModel(new DefaultComboBoxModel(token.getArmasCuerpoACuerpo().toArray()));

        //jComboBoxArmas.addItem(token.getManoIZQ().getArmaEquipada().toString());
        cambiarBo();;
        jSlider_Bo.setToolTipText("bo Maxima = " + token.getHabilidades().getBo_pri());
        // jSlider_Bo.setMajorTickSpacing();

        jTextField_PPActual_carga.setText(token.podertxt());
        jTextField_PPActual_ls_realiza.setText(token.podertxt());

        if (modo == MODO_ATURDIDO) {
            jTabbedPane_SeleccionAccion.setEnabledAt(0, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(2, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(3, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(8, false);
            jTabbedPane_SeleccionAccion.setSelectedIndex(6);
            jTextField_bono_mm.setText("-50");
            jComboBoxEnemigos.setEnabled(false);
            jSlider_Bo.setValue(0);
            jSlider_Bo.setEnabled(false);

        } else if (modo == MODO_FUERA_DE_COMBATE) {
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_SIN_ACCION - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_CARGA_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_CARGA_SORTILEGIO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_DESPLAZAMIENTO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_PARAR_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_DISPARA_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_MOVIMIENTO_ESTATICO - 1, false);
            jTabbedPane_SeleccionAccion.setSelectedIndex(1);
        }
        if (tipo > Constantes.TIPO_ACCION_SIN_ACCION) {

        } else if (modo == MODO_CAMBIO_DE_ACCION) {
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_CARGA_SORTILEGIO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_REALIZA_SORTILEGIO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_DISPARA_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_CARGA_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_PARAR_PROYECTIL - 1, false);
            //jTabbedPane_SeleccionAccion.setEnabledAt(Accion.TIPO_MOVIMIENTO_Y_MANIOBRA-1, false);
            jTextField_bono_mm.setText("" + -30);
            //jTabbedPane_SeleccionAccion.setEnabledAt(Accion.TIPO_ATAQUE_CUERPO_A_CUERPO-1, false);
            jSlider_Bo.setValue(50);
            //jTabbedPane_SeleccionAccion.setEnabledAt(Accion.TIPO_DESPLAZAMIENTO-1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(Constantes.TIPO_ACCION_MOVIMIENTO_ESTATICO - 1, false);
            jTabbedPane_SeleccionAccion.setSelectedIndex(Constantes.TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO - 1);
        }
        if (tipo > Constantes.TIPO_ACCION_SIN_ACCION) {
            jTabbedPane_SeleccionAccion.setSelectedIndex(tipo - 1);
        }
        if (token.getSortilegios().size() > 0) {
            actualizarSortilegioCarga();
            actualizarSortilegioRealiza();
        }

        if (token.isSortiCargado()) {
            Object[] o = (Object[]) token.getSortilegioCargado();
            int cargas = (Integer) o[0];
            Sortilegio s = (Sortilegio) o[1];
            int bono = (Integer) o[2];
            jTextField_sort_cargado.setText(s.getNombre());
            jTextField_sort_cargado1.setText(s.getNombre());
            jTextField_sort_cargado.setBackground(Color.yellow);
            jTextField_sort_cargado1.setBackground(Color.yellow);
            jTextField_sort_num_cargas.setText(cargas + "");
            jTextField_sort_num_cargas1.setText(cargas + "");
            jTextField_sort_bono.setText(bono + "");
            jTextField_sort_bono1.setText(bono + "");
            jComboBox_sotilegios.setSelectedItem(s);
            jComboBox_sotilegios_Realiza.setSelectedItem(s);
        }
        if (token_accion.getTipoDeAccion() > 0) {
            int s = token_accion.getTipoDeAccion() -1;
            jTabbedPane_SeleccionAccion.setSelectedIndex(s);            
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel19 = new javax.swing.JPanel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jTabbedPane_SeleccionAccion = new javax.swing.JTabbedPane();
        jPanel_Carga_Sortilegio_tabPanel1 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jTextField_sort_cargado1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField_sort_num_cargas1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField_sort_bono = new javax.swing.JTextField();
        jPanel_carga_sort_nombre_carga = new javax.swing.JPanel();
        jComboBox_sotilegios = new javax.swing.JComboBox<>();
        jButton_crearSortilegio_Carga = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel_carga_sort_datos_Cargado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_lv_sort_carga = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Dominio_sort_carga = new javax.swing.JTextField();
        jCheckBox_consume_sort_carga = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        jTextField_alcance_sort_carga = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField_PPActual_carga = new javax.swing.JTextField();
        jPanel_Realiza_Sortilegio_tabPanel = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jTextField_sort_cargado = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField_sort_num_cargas = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField_sort_bono1 = new javax.swing.JTextField();
        jPanel_carga_sort_nombre_realiza = new javax.swing.JPanel();
        jComboBox_sotilegios_Realiza = new javax.swing.JComboBox<>();
        jButton_crearSortilegio_Realiza = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jPanel_carga_sort_datos_Realiza = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField_lv_sort_realiza = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField_Dominio_sort_realiza = new javax.swing.JTextField();
        jCheckBox_consume_sort_realiza = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jTextField_alcance_sort_realiza = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField_PPActual_ls_realiza = new javax.swing.JTextField();
        jPanel_Dispara_Proyectil_tabPanel = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEnemigos1 = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxArmas_Proy = new javax.swing.JComboBox();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField_bono_mm = new javax.swing.JTextField();
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxEnemigos = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jComboBoxArmas_cac = new javax.swing.JComboBox();
        jButton3 = new javax.swing.JButton();
        jPanel_distancia = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jRadioButton_brazoD = new javax.swing.JRadioButton();
        jRadioButton_brazoI = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel_distancia = new javax.swing.JLabel();
        jSpinner_distancia = new javax.swing.JSpinner();
        jTextField4 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jTextField_Bo = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jSlider_Bo = new javax.swing.JSlider();
        jPanel_Desplazamiento_tabPanel = new javax.swing.JPanel();
        jPanel_distancia2 = new javax.swing.JPanel();
        jLabel_distancia2 = new javax.swing.JLabel();
        jSpinner_distancia2 = new javax.swing.JSpinner();
        jTextField9 = new javax.swing.JTextField();
        jPanel_Movimiento_Estatico = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jPanel_desc_Accion = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_desc = new javax.swing.JTextArea();

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

        jTabbedPane_SeleccionAccion.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane_SeleccionAccion.setMinimumSize(new java.awt.Dimension(618, 167));
        jTabbedPane_SeleccionAccion.setPreferredSize(new java.awt.Dimension(618, 167));

        jPanel_Carga_Sortilegio_tabPanel1.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setLayout(new javax.swing.BoxLayout(jPanel_Carga_Sortilegio_tabPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField_sort_cargado1.setEditable(false);
        jTextField_sort_cargado1.setText("No hay Sortilegio cargado");
        jTextField_sort_cargado1.setMinimumSize(new java.awt.Dimension(330, 20));
        jTextField_sort_cargado1.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel20.add(jTextField_sort_cargado1);

        jLabel22.setText("Cargas");
        jPanel20.add(jLabel22);

        jTextField_sort_num_cargas1.setEditable(false);
        jTextField_sort_num_cargas1.setText("0");
        jTextField_sort_num_cargas1.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField_sort_num_cargas1.setMinimumSize(new java.awt.Dimension(20, 20));
        jTextField_sort_num_cargas1.setName(""); // NOI18N
        jTextField_sort_num_cargas1.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel20.add(jTextField_sort_num_cargas1);

        jLabel23.setText("Bono");
        jPanel20.add(jLabel23);

        jTextField_sort_bono.setEditable(false);
        jTextField_sort_bono.setText("-30");
        jTextField_sort_bono.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField_sort_bono.setMinimumSize(new java.awt.Dimension(30, 20));
        jTextField_sort_bono.setName(""); // NOI18N
        jTextField_sort_bono.setPreferredSize(new java.awt.Dimension(30, 20));
        jPanel20.add(jTextField_sort_bono);

        jPanel_Carga_Sortilegio_tabPanel1.add(jPanel20);

        jComboBox_sotilegios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_sotilegios.setMinimumSize(new java.awt.Dimension(156, 20));
        jComboBox_sotilegios.setPreferredSize(new java.awt.Dimension(330, 20));
        jComboBox_sotilegios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_sotilegiosItemStateChanged(evt);
            }
        });
        jComboBox_sotilegios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_sotilegiosActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_carga.add(jComboBox_sotilegios);

        jButton_crearSortilegio_Carga.setText("Crear Nuevo");
        jButton_crearSortilegio_Carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearSortilegio_CargaActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_carga.add(jButton_crearSortilegio_Carga);

        jPanel_Carga_Sortilegio_tabPanel1.add(jPanel_carga_sort_nombre_carga);

        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel3.setText("Lv");
        jPanel_carga_sort_datos_Cargado.add(jLabel3);

        jTextField_lv_sort_carga.setEditable(false);
        jTextField_lv_sort_carga.setMinimumSize(new java.awt.Dimension(66, 20));
        jTextField_lv_sort_carga.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel_carga_sort_datos_Cargado.add(jTextField_lv_sort_carga);

        jLabel4.setText("Dominio");
        jPanel_carga_sort_datos_Cargado.add(jLabel4);

        jTextField_Dominio_sort_carga.setEditable(false);
        jTextField_Dominio_sort_carga.setMinimumSize(new java.awt.Dimension(66, 20));
        jTextField_Dominio_sort_carga.setPreferredSize(new java.awt.Dimension(66, 20));
        jPanel_carga_sort_datos_Cargado.add(jTextField_Dominio_sort_carga);

        jCheckBox_consume_sort_carga.setText("Consume PP");
        jCheckBox_consume_sort_carga.setEnabled(false);
        jPanel_carga_sort_datos_Cargado.add(jCheckBox_consume_sort_carga);

        jLabel9.setText("Alcance");
        jPanel_carga_sort_datos_Cargado.add(jLabel9);

        jTextField_alcance_sort_carga.setEditable(false);
        jTextField_alcance_sort_carga.setText(" ");
        jTextField_alcance_sort_carga.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel_carga_sort_datos_Cargado.add(jTextField_alcance_sort_carga);

        jLabel13.setText("PP Actual");
        jPanel_carga_sort_datos_Cargado.add(jLabel13);

        jTextField_PPActual_carga.setEditable(false);
        jTextField_PPActual_carga.setText(" ");
        jTextField_PPActual_carga.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel_carga_sort_datos_Cargado.add(jTextField_PPActual_carga);

        jPanel8.add(jPanel_carga_sort_datos_Cargado);

        jPanel_Carga_Sortilegio_tabPanel1.add(jPanel8);

        jTabbedPane_SeleccionAccion.addTab("Carga Sortilegio", jPanel_Carga_Sortilegio_tabPanel1);

        jPanel_Realiza_Sortilegio_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setLayout(new javax.swing.BoxLayout(jPanel_Realiza_Sortilegio_tabPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField_sort_cargado.setEditable(false);
        jTextField_sort_cargado.setText("No hay Sortilegio cargado");
        jTextField_sort_cargado.setMinimumSize(new java.awt.Dimension(330, 20));
        jTextField_sort_cargado.setPreferredSize(new java.awt.Dimension(330, 20));
        jPanel21.add(jTextField_sort_cargado);

        jLabel26.setText("Cargas");
        jPanel21.add(jLabel26);

        jTextField_sort_num_cargas.setEditable(false);
        jTextField_sort_num_cargas.setText("0");
        jTextField_sort_num_cargas.setMaximumSize(new java.awt.Dimension(20, 20));
        jTextField_sort_num_cargas.setMinimumSize(new java.awt.Dimension(20, 20));
        jTextField_sort_num_cargas.setName(""); // NOI18N
        jTextField_sort_num_cargas.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel21.add(jTextField_sort_num_cargas);

        jLabel27.setText("Bono");
        jPanel21.add(jLabel27);

        jTextField_sort_bono1.setEditable(false);
        jTextField_sort_bono1.setText("-30");
        jTextField_sort_bono1.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField_sort_bono1.setMinimumSize(new java.awt.Dimension(30, 20));
        jTextField_sort_bono1.setName(""); // NOI18N
        jTextField_sort_bono1.setPreferredSize(new java.awt.Dimension(30, 20));
        jPanel21.add(jTextField_sort_bono1);

        jPanel_Realiza_Sortilegio_tabPanel.add(jPanel21);

        jComboBox_sotilegios_Realiza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_sotilegios_Realiza.setMinimumSize(new java.awt.Dimension(156, 20));
        jComboBox_sotilegios_Realiza.setPreferredSize(new java.awt.Dimension(330, 20));
        jComboBox_sotilegios_Realiza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_sotilegios_RealizaItemStateChanged(evt);
            }
        });
        jComboBox_sotilegios_Realiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_sotilegios_RealizaActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_realiza.add(jComboBox_sotilegios_Realiza);

        jButton_crearSortilegio_Realiza.setText("Crear Nuevo");
        jButton_crearSortilegio_Realiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearSortilegio_RealizaActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_realiza.add(jButton_crearSortilegio_Realiza);

        jPanel_Realiza_Sortilegio_tabPanel.add(jPanel_carga_sort_nombre_realiza);

        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel10.setText("Lv");
        jPanel_carga_sort_datos_Realiza.add(jLabel10);

        jTextField_lv_sort_realiza.setEditable(false);
        jTextField_lv_sort_realiza.setMinimumSize(new java.awt.Dimension(66, 20));
        jTextField_lv_sort_realiza.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel_carga_sort_datos_Realiza.add(jTextField_lv_sort_realiza);

        jLabel11.setText("Dominio");
        jPanel_carga_sort_datos_Realiza.add(jLabel11);

        jTextField_Dominio_sort_realiza.setEditable(false);
        jTextField_Dominio_sort_realiza.setMinimumSize(new java.awt.Dimension(66, 20));
        jTextField_Dominio_sort_realiza.setPreferredSize(new java.awt.Dimension(66, 20));
        jPanel_carga_sort_datos_Realiza.add(jTextField_Dominio_sort_realiza);

        jCheckBox_consume_sort_realiza.setText("Consume PP");
        jCheckBox_consume_sort_realiza.setEnabled(false);
        jPanel_carga_sort_datos_Realiza.add(jCheckBox_consume_sort_realiza);

        jLabel12.setText("Alcance");
        jPanel_carga_sort_datos_Realiza.add(jLabel12);

        jTextField_alcance_sort_realiza.setEditable(false);
        jTextField_alcance_sort_realiza.setText(" ");
        jTextField_alcance_sort_realiza.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel_carga_sort_datos_Realiza.add(jTextField_alcance_sort_realiza);

        jLabel14.setText("PP Actual");
        jPanel_carga_sort_datos_Realiza.add(jLabel14);

        jTextField_PPActual_ls_realiza.setEditable(false);
        jTextField_PPActual_ls_realiza.setText(" ");
        jTextField_PPActual_ls_realiza.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel_carga_sort_datos_Realiza.add(jTextField_PPActual_ls_realiza);

        jPanel11.add(jPanel_carga_sort_datos_Realiza);

        jPanel_Realiza_Sortilegio_tabPanel.add(jPanel11);

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

        jComboBoxArmas_Proy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArmas_ProyItemStateChanged(evt);
            }
        });
        jPanel27.add(jComboBoxArmas_Proy);

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

        jLabel2.setText("Bono Extra");
        jPanel2.add(jLabel2);

        jTextField_bono_mm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_bono_mm.setText("0");
        jTextField_bono_mm.setMinimumSize(new java.awt.Dimension(50, 20));
        jTextField_bono_mm.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel2.add(jTextField_bono_mm);

        jPanel_Movimiento_Y_maniobra_tabPanel.add(jPanel2);

        jTabbedPane_SeleccionAccion.addTab("Movimiento Y maniobra", jPanel_Movimiento_Y_maniobra_tabPanel);

        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setLayout(new java.awt.BorderLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setMaximumSize(new java.awt.Dimension(224, 185));
        jPanel15.setLayout(new java.awt.BorderLayout());

        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Blanco"));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jComboBoxEnemigos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBoxEnemigos);

        jPanel9.add(jPanel3);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Arma"));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jComboBoxArmas_cac.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArmas_cacItemStateChanged(evt);
            }
        });
        jPanel5.add(jComboBoxArmas_cac);

        jButton3.setText("+");
        jPanel5.add(jButton3);

        jPanel9.add(jPanel5);

        jPanel15.add(jPanel9, java.awt.BorderLayout.NORTH);

        jPanel_distancia.setLayout(new javax.swing.BoxLayout(jPanel_distancia, javax.swing.BoxLayout.LINE_AXIS));

        jPanel16.setMaximumSize(new java.awt.Dimension(201, 38));
        jPanel16.setPreferredSize(new java.awt.Dimension(201, 38));
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.LINE_AXIS));

        buttonGroup3.add(jRadioButton_brazoD);
        jRadioButton_brazoD.setSelected(true);
        jRadioButton_brazoD.setText("Brazo D");
        jPanel16.add(jRadioButton_brazoD);

        buttonGroup3.add(jRadioButton_brazoI);
        jRadioButton_brazoI.setText("Brazo I (-30)");
        jPanel16.add(jRadioButton_brazoI);

        jPanel_distancia.add(jPanel16);

        jLabel_distancia.setText("  Distancia  ");
        jPanel4.add(jLabel_distancia);

        jSpinner_distancia.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 3));
        jSpinner_distancia.setMinimumSize(new java.awt.Dimension(61, 20));
        jSpinner_distancia.setPreferredSize(new java.awt.Dimension(61, 20));
        jPanel4.add(jSpinner_distancia);

        jTextField4.setEditable(false);
        jTextField4.setText("mts.");
        jTextField4.setMaximumSize(new java.awt.Dimension(36, 28));
        jTextField4.setMinimumSize(new java.awt.Dimension(26, 28));
        jTextField4.setName(""); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(36, 28));
        jTextField4.setRequestFocusEnabled(false);
        jPanel4.add(jTextField4);

        jPanel_distancia.add(jPanel4);

        jPanel15.add(jPanel_distancia, java.awt.BorderLayout.CENTER);

        jPanel17.setMaximumSize(new java.awt.Dimension(32767, 159));
        jPanel17.setMinimumSize(new java.awt.Dimension(133, 100));
        jPanel17.setPreferredSize(new java.awt.Dimension(201, 40));
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        jPanel14.setMaximumSize(new java.awt.Dimension(72, 100));
        jPanel14.setPreferredSize(new java.awt.Dimension(70, 40));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jTextField_Bo.setEditable(false);
        jTextField_Bo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Bo.setText("BO ");
        jTextField_Bo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_BoActionPerformed(evt);
            }
        });
        jPanel14.add(jTextField_Bo);

        jTextField8.setEditable(false);
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("BD");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel14.add(jTextField8);

        jPanel17.add(jPanel14);

        jPanel1.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jSlider_Bo.setForeground(new java.awt.Color(102, 102, 102));
        jSlider_Bo.setMajorTickSpacing(token_accion.getToken().bo_pri().getValue() / 8);
        jSlider_Bo.setPaintLabels(true);
        jSlider_Bo.setPaintTicks(true);
        jSlider_Bo.setPreferredSize(new java.awt.Dimension(200, 35));
        jSlider_Bo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_BoStateChanged(evt);
            }
        });
        jPanel1.add(jSlider_Bo);

        jPanel17.add(jPanel1);

        jPanel15.add(jPanel17, java.awt.BorderLayout.PAGE_END);

        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jTabbedPane_SeleccionAccion.addTab("Ataque Cuerpo a Cuerpo", jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA);

        jPanel_Desplazamiento_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Desplazamiento_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Desplazamiento_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));

        jPanel_distancia2.setLayout(new java.awt.GridLayout(1, 0));

        jLabel_distancia2.setText("  Distancia  ");
        jPanel_distancia2.add(jLabel_distancia2);

        jSpinner_distancia2.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 3));
        jPanel_distancia2.add(jSpinner_distancia2);

        jTextField9.setEditable(false);
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
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
        jTabbedPane_SeleccionAccion.addTab("Movimiento Estatico", jPanel_Movimiento_Estatico);

        getContentPane().add(jTabbedPane_SeleccionAccion, java.awt.BorderLayout.NORTH);

        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel22.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton1);

        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });
        jPanel22.add(jButton_cancelar);

        getContentPane().add(jPanel22, java.awt.BorderLayout.SOUTH);

        jPanel_desc_Accion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion de la Accion"));
        jPanel_desc_Accion.setMaximumSize(new java.awt.Dimension(32779, 100));
        jPanel_desc_Accion.setMinimumSize(new java.awt.Dimension(50, 46));
        jPanel_desc_Accion.setPreferredSize(new java.awt.Dimension(178, 100));
        jPanel_desc_Accion.setLayout(new javax.swing.BoxLayout(jPanel_desc_Accion, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea_desc.setColumns(20);
        jTextArea_desc.setRows(5);
        jScrollPane3.setViewportView(jTextArea_desc);

        jPanel_desc_Accion.add(jScrollPane3);

        getContentPane().add(jPanel_desc_Accion, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        declarar();        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_BoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_BoActionPerformed

    private void jComboBoxArmas_cacItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArmas_cacItemStateChanged
        cambiarBo();
    }//GEN-LAST:event_jComboBoxArmas_cacItemStateChanged

    private void jComboBoxArmas_ProyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArmas_ProyItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxArmas_ProyItemStateChanged

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        accionSeleccionada = null;
        this.dispose();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton_crearSortilegio_CargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearSortilegio_CargaActionPerformed
        nuevoSortilegio(true);
    }//GEN-LAST:event_jButton_crearSortilegio_CargaActionPerformed

    private void jComboBox_sotilegiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_sotilegiosActionPerformed

    }//GEN-LAST:event_jComboBox_sotilegiosActionPerformed

    private void jComboBox_sotilegios_RealizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_sotilegios_RealizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_sotilegios_RealizaActionPerformed

    private void jButton_crearSortilegio_RealizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearSortilegio_RealizaActionPerformed
        nuevoSortilegio(false);
    }//GEN-LAST:event_jButton_crearSortilegio_RealizaActionPerformed

    private void jComboBox_sotilegiosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_sotilegiosItemStateChanged
        actualizarSortilegioCarga();
    }//GEN-LAST:event_jComboBox_sotilegiosItemStateChanged

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jSlider_BoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_BoStateChanged
        moverBo();
    }//GEN-LAST:event_jSlider_BoStateChanged

    private void jComboBox_sotilegios_RealizaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_sotilegios_RealizaItemStateChanged
        actualizarSortilegioRealiza();
    }//GEN-LAST:event_jComboBox_sotilegios_RealizaItemStateChanged

    private void nuevoSortilegio(boolean carga) {
        int sa = token_accion.getToken().getSortilegios().size();
        int s = NuevoSortilegio.Crear(principal, true, token_accion.getToken());

        if (s > -1) {
            token_accion.getToken().aprenderSortilegio(s);
        }

        if (token_accion.getToken().getSortilegios().size() > sa) {
            jComboBox_sotilegios.removeAllItems();
            jComboBox_sotilegios.setModel(new DefaultComboBoxModel(token_accion.getToken().getSortilegios().toArray()));
            jComboBox_sotilegios.setSelectedIndex(token_accion.getToken().getSortilegios().size() - 1);
            jComboBox_sotilegios_Realiza.removeAllItems();
            jComboBox_sotilegios_Realiza.setModel(new DefaultComboBoxModel(token_accion.getToken().getSortilegios().toArray()));
            jComboBox_sotilegios_Realiza.setSelectedIndex(token_accion.getToken().getSortilegios().size() - 1);
            if (carga) {
                actualizarSortilegioCarga();
            } else {
                actualizarSortilegioRealiza();
            }
        }
    }

    private void actualizarSortilegioCarga() {
        if (jComboBox_sotilegios.getItemCount() > 0) {
            Sortilegio s = (Sortilegio) jComboBox_sotilegios.getSelectedItem();

            jTextField_Dominio_sort_carga.setText(s.getDominioStr());
            jTextField_lv_sort_carga.setText(s.getLv() + "");
            jPanel_carga_sort_nombre_carga.setToolTipText(s.getDescp());
            jPanel_carga_sort_datos_Cargado.setToolTipText(s.getDescp());
            jCheckBox_consume_sort_carga.setSelected(s.isConsumePP());
            jTextField_alcance_sort_carga.setText(s.getAlcance_string());

        }
    }

    private void actualizarSortilegioRealiza() {
        if (jComboBox_sotilegios_Realiza.getItemCount() > 0) {
            Sortilegio s = (Sortilegio) jComboBox_sotilegios_Realiza.getSelectedItem();

            jTextField_Dominio_sort_realiza.setText(s.getDominioStr());
            jTextField_lv_sort_realiza.setText(s.getLv() + "");
            jPanel_carga_sort_nombre_realiza.setToolTipText(s.getDescp());
            jPanel_carga_sort_datos_Realiza.setToolTipText(s.getDescp());
            jCheckBox_consume_sort_realiza.setSelected(s.isConsumePP());
            jTextField_alcance_sort_realiza.setText(s.getAlcance_string());
        }
    }

    private void declarar() {

        Token token = token_accion.getToken();
        boolean realizable = true;

        // Busco si tiene sortilegio Cargado
        int sort_anterior = -1;
        String str_carga = "";

        if (token.isSortiCargado()) {
            Object[] o = (Object[]) token.getSortilegioCargado();
            int cargas = (Integer) o[0];
            Sortilegio s = (Sortilegio) o[1];
            sort_anterior = s.getId();
            int bono = (Integer) o[2];
            str_carga = "\nCarga " + cargas + " (" + bono + ")";
        }

        int tipoAcion = this.jTabbedPane_SeleccionAccion.getSelectedIndex() +1;
        Accion acc = null;
        int orden = 1;
        String fullDesc = "";

        switch (tipoAcion) {
            case Constantes.TIPO_ACCION_SIN_ACCION: {

                break;
            }
            case Constantes.TIPO_ACCION_CARGA_SORTILEGIO: {
                Sortilegio sort_intencion = (Sortilegio) jComboBox_sotilegios_Realiza.getSelectedItem();
                if (sort_intencion != null) {

                    if (token.puedeRealizarSortilegio(sort_intencion)) {

                        acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                        acc.setSort_intencion(sort_intencion);
                        //token_accion.intentarSortilegio(sort_intencion);                   

                        fullDesc += acc.getSort_intencion().toString();
                        if (sort_intencion.getId() == sort_anterior) {
                            fullDesc += str_carga + "\n";
                        }
                        fullDesc += jTextArea_desc.getText();
                    } else {                        
                        recursos.Recursos.informar("No puede realizar este Sortilegio");
                    }
                } else {
                    recursos.Recursos.informar("Debe seleccionar un sortilegio");
                }
                break;
            }
            case Constantes.TIPO_ACCION_REALIZA_SORTILEGIO: {
                Sortilegio sort_intencion = (Sortilegio) jComboBox_sotilegios.getSelectedItem();
                if (sort_intencion == null) {
                    recursos.Recursos.informar("Debe seleccionar un sortilegio");
                } else if (token.puedeRealizarSortilegio(sort_intencion)) {
                    acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                    acc.setSort_intencion(sort_intencion);
                    //token_accion.intentarSortilegio(sort_intencion);                    

                    fullDesc += acc.getSort_intencion().toString();
                    if (sort_intencion.getId() == sort_anterior) {
                        fullDesc += str_carga + "\n";
                    }
                    fullDesc += jTextArea_desc.getText();
                } else {                    
                    recursos.Recursos.informar("No puede realizar este Sortilegio");
                }
                break;
            }
            case Constantes.TIPO_ACCION_DISPARA_PROYECTIL: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case Constantes.TIPO_ACCION_CARGA_PROYECTIL: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case Constantes.TIPO_ACCION_PARAR_PROYECTIL: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case Constantes.TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case Constantes.TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                Arma a = (Arma) jComboBoxArmas_cac.getSelectedItem();
                fullDesc += "Ataca con\n" + a.toString();
                fullDesc += "\n" + jTextField_Bo.getText() + " / " + jTextField8.getText();
                fullDesc += "\n" + jTextArea_desc.getText();
                break;
            }
            case Constantes.TIPO_ACCION_DESPLAZAMIENTO: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case Constantes.TIPO_ACCION_MOVIMIENTO_ESTATICO: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += "\n" + jTextArea_desc.getText();
                break;
            }
            default: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
        }
        accionSeleccionada = acc;
        if (accionSeleccionada != null ) {
            acc.setFullDescp(fullDesc);
            acc.setDescp(jTextArea_desc.getText());
            
            token_accion.AccionDefinidaEnEsteAsalto();
            this.dispose();
        }        
    }

    private void moverBo() {
        jTextField_Bo.setText("BO " + jSlider_Bo.getValue());
        int paraLaBd = jSlider_Bo.getMaximum() - jSlider_Bo.getValue();
        jTextField8.setText("BD " + (token_accion.getToken().getHabilidades().getBd() + paraLaBd));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_crearSortilegio_Carga;
    private javax.swing.JButton jButton_crearSortilegio_Realiza;
    private javax.swing.JCheckBox jCheckBox_consume_sort_carga;
    private javax.swing.JCheckBox jCheckBox_consume_sort_realiza;
    private javax.swing.JComboBox jComboBoxArmas_Proy;
    private javax.swing.JComboBox jComboBoxArmas_cac;
    private javax.swing.JComboBox jComboBoxEnemigos;
    private javax.swing.JComboBox jComboBoxEnemigos1;
    private javax.swing.JComboBox<String> jComboBox_sotilegios;
    private javax.swing.JComboBox<String> jComboBox_sotilegios_Realiza;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_distancia;
    private javax.swing.JLabel jLabel_distancia1;
    private javax.swing.JLabel jLabel_distancia2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA;
    private javax.swing.JPanel jPanel_Carga_Proyectil_tabPanel;
    private javax.swing.JPanel jPanel_Carga_Sortilegio_tabPanel1;
    private javax.swing.JPanel jPanel_Desplazamiento_tabPanel;
    private javax.swing.JPanel jPanel_Dispara_Proyectil_tabPanel;
    private javax.swing.JPanel jPanel_Movimiento_Estatico;
    private javax.swing.JPanel jPanel_Movimiento_Y_maniobra_tabPanel;
    private javax.swing.JPanel jPanel_Parar_Proyectil_tabPanel;
    private javax.swing.JPanel jPanel_Realiza_Sortilegio_tabPanel;
    private javax.swing.JPanel jPanel_carga_sort_datos_Cargado;
    private javax.swing.JPanel jPanel_carga_sort_datos_Realiza;
    private javax.swing.JPanel jPanel_carga_sort_nombre_carga;
    private javax.swing.JPanel jPanel_carga_sort_nombre_realiza;
    private javax.swing.JPanel jPanel_desc_Accion;
    private javax.swing.JPanel jPanel_distancia;
    private javax.swing.JPanel jPanel_distancia1;
    private javax.swing.JPanel jPanel_distancia2;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider_Bo;
    private javax.swing.JSpinner jSpinner_distancia;
    private javax.swing.JSpinner jSpinner_distancia1;
    private javax.swing.JSpinner jSpinner_distancia2;
    private javax.swing.JTabbedPane jTabbedPane_SeleccionAccion;
    private javax.swing.JTextArea jTextArea_desc;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField_Bo;
    private javax.swing.JTextField jTextField_Dominio_sort_carga;
    private javax.swing.JTextField jTextField_Dominio_sort_realiza;
    private javax.swing.JTextField jTextField_PPActual_carga;
    private javax.swing.JTextField jTextField_PPActual_ls_realiza;
    private javax.swing.JTextField jTextField_alcance_sort_carga;
    private javax.swing.JTextField jTextField_alcance_sort_realiza;
    private javax.swing.JTextField jTextField_bono_mm;
    private javax.swing.JTextField jTextField_lv_sort_carga;
    private javax.swing.JTextField jTextField_lv_sort_realiza;
    private javax.swing.JTextField jTextField_sort_bono;
    private javax.swing.JTextField jTextField_sort_bono1;
    private javax.swing.JTextField jTextField_sort_cargado;
    private javax.swing.JTextField jTextField_sort_cargado1;
    private javax.swing.JTextField jTextField_sort_num_cargas;
    private javax.swing.JTextField jTextField_sort_num_cargas1;
    // End of variables declaration//GEN-END:variables

    public static final int MODO_NORMAL = 0;
    public static final int MODO_ATURDIDO = 1;
    public static final int MODO_FUERA_DE_COMBATE = 2;
    public static final int MODO_CAMBIO_DE_ACCION = 3;

    private static Accion accionSeleccionada;
    private static int modo = MODO_NORMAL;

    public static Accion DeclararAccion(Principal parent, boolean modal, JPanelFormToken_Accion token_accion, int modo) {
        accionSeleccionada = null;
        DeclaraAccion.modo = 0;
        DeclaraAccion.modo = modo;
        DeclaraAccion da = new DeclaraAccion(parent, true, token_accion);

        da.setLocationRelativeTo(null);
        da.setVisible(true);

        return accionSeleccionada;
    }

    private void cambiarBo() {
        Arma a = (Arma) jComboBoxArmas_cac.getSelectedItem();
        int actual = token_accion.getToken().boDisponible(a.getEstilo());
        //jSlider_Bo.setMaximum(actual);
        if (actual > 16) {
            jSlider_Bo.setMinimum(0);
            jSlider_Bo.setMaximum(actual);
            jSlider_Bo.setMajorTickSpacing(actual / 8);
        } else if (actual < 0) {
            jSlider_Bo.setMajorTickSpacing(1);
            jSlider_Bo.setMinimum(actual);
            jSlider_Bo.setMaximum(actual);
        } else {
            jSlider_Bo.setMajorTickSpacing(1);
            jSlider_Bo.setMinimum(0);
            jSlider_Bo.setMaximum(actual);
        }
    }
}
