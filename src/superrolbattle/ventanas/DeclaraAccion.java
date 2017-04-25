/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Accion;
import instancias.ListaDeSortilegios;
import instancias.Sortilegio;
import instancias.Token;
import instancias.properties.Arma;
import instancias.properties.Bo;
import instancias.properties.DatosCombate;
import instancias.properties.Extremidad;
import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.SelectionMode;
import javax.swing.AbstractSpinnerModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SingleSelectionModel;
import javax.swing.SpinnerNumberModel;
import recursos.AccionConfig;
import static recursos.Constantes.*;
import recursos.Recursos;
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

        if (token.getUrlIcon() != null) {
            iconar(token.getUrlIcon());
        }
        jTextField_name.setText(token.getNombre());
        Accion accion = token.getLastAction();
        int tipo = token.getLastAction().getTipo();

        for (Extremidad ext : token.getExtremidades()) {
            hm_extremidades.put(ext, null);
        }
        token.getExtremidades();

        limitardesplazamiento();

        jComboBox_sotilegios.setModel(new DefaultComboBoxModel(token.getSortilegios().toArray()));
        jComboBox_sotilegios_Realiza.setModel(new DefaultComboBoxModel(token.getSortilegios().toArray()));

        jComboBox_Lista_sotilegios.setModel(new DefaultComboBoxModel(token.getListasDeSortilegios().toArray()));
        jComboBox_Lista_sotilegios_realiza.setModel(new DefaultComboBoxModel(token.getListasDeSortilegios().toArray()));

        jComboBoxEnemigos1.setModel(new DefaultComboBoxModel(principal.getTodosLosEnemigos(token).toArray()));

        DefaultListModel jdlm = (DefaultListModel) jList_extremidades.getModel();
        for (Extremidad ext : token.getExtremidadesEquipables()) {
            jdlm.addElement(ext);
        }
        int cantEx = jdlm.getSize();
        jList_extremidades.setModel(jdlm);
        if (cantEx > 0) {
            for (Arma a : token.getArmasCuerpoACuerpo()) {
                if (a.isdosManos() && cantEx < 2) {
                    continue;
                }
                agregarArmaALalista(a);
            }
        }
        for (Arma a : token.getEscudos()) {
            agregarEscudoALalista(a);
        }

        jComboBoxArmas_Proy.setModel(new DefaultComboBoxModel(token.getArmasProyectiles().toArray()));

        // mov y maniobra
        jTextField_mmActual.setText(token.getMmActualTxt());
        jTextField_mmActual_mm.setText(token.getMmActualTxt());

        //jComboBoxArmas.addItem(token.getManoIZQ().getArmaEquipada().toString());
        cambiarBo();
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
            jSlider_Bo.setValue(0);
            jSlider_Bo.setEnabled(false);

        } else if (modo == MODO_FUERA_DE_COMBATE) {
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_SIN_ACCION - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_CARGA_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_CARGA_SORTILEGIO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_DESPLAZAMIENTO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_PARAR_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_DISPARA_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_MOVIMIENTO_ESTATICO - 1, false);
            jTabbedPane_SeleccionAccion.setSelectedIndex(1);
        }
        if (tipo > TIPO_ACCION_SIN_ACCION) {

        } else if (modo == MODO_CAMBIO_DE_ACCION) {
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_CARGA_SORTILEGIO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_REALIZA_SORTILEGIO - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_DISPARA_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_CARGA_PROYECTIL - 1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_PARAR_PROYECTIL - 1, false);
            //jTabbedPane_SeleccionAccion.setEnabledAt(Accion.TIPO_MOVIMIENTO_Y_MANIOBRA-1, false);
            jTextField_bono_mm.setText("" + -30);
            //jTabbedPane_SeleccionAccion.setEnabledAt(Accion.TIPO_ATAQUE_CUERPO_A_CUERPO-1, false);
            jSlider_Bo.setValue(50);
            //jTabbedPane_SeleccionAccion.setEnabledAt(Accion.TIPO_DESPLAZAMIENTO-1, false);
            jTabbedPane_SeleccionAccion.setEnabledAt(TIPO_ACCION_MOVIMIENTO_ESTATICO - 1, false);
            jTabbedPane_SeleccionAccion.setSelectedIndex(TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO - 1);
        }
        if (tipo > TIPO_ACCION_SIN_ACCION) {

            jTabbedPane_SeleccionAccion.setSelectedIndex(tipo - 1);
            AccionConfig ac = this.token_accion.getAccionConfig();
            if (ac != null) {
                if (ac.getBlanco() != null) {
                    jComboBoxEnemigos1.setSelectedItem(ac.getBlanco());
                }
                if (ac.getBoConf() > -1) {
                    jSlider_Bo.setValue(ac.getBoConf());
                    jComboBoxEnemigos1.setSelectedItem(ac.getBlanco());
                }
                if (ac.getBonoExtra() > -1) {
                    jSpinner_bono_mm.setValue(ac.getBonoExtra());
                }
                if (ac.getDesc() != null) {
                    jTextArea_desc.setText(ac.getDesc());
                }
                if (ac.getDificultadManiobra() > -1) {
                    // en construccion
                }
                if (ac.getDistancia() > -1) {
                    jSpinner_distancia1.setValue(ac.getDistancia());
                }
                if (ac.getDistanciaAtaque() > -1) {
                    jSpinner_distanciaCaC.setValue(ac.getDistancia());
                }
            }
            Arma bd = token.getExtremidad(Extremidad.MIEMBRO_SUPERIOR_DERECHO).getArmaEquipada();
            Arma bi = token.getExtremidad(Extremidad.MIEMBRO_SUPERIOR_IZQUIERDO).getArmaEquipada();
            if (bd != null) {
                if (bd.getEstilo() == ESTILO_PROYECTILES) {
                    jComboBoxArmas_Proy1.setSelectedItem(bd);
                } else {

                }
            }

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
            ListaDeSortilegios lds = Principal.getListaDeSortilegioById(s.getLista());

            jComboBox_Lista_sotilegios_realiza.setSelectedItem(lds);
            jComboBox_Lista_sotilegios.setSelectedItem(lds);
            this.repaint();
            jComboBox_sotilegios.setSelectedItem(s);
            jComboBox_sotilegios_Realiza.setSelectedItem(s);
            actualizarSortilegioCarga();
            actualizarSortilegioRealiza();

        }
        if (token_accion.getTipoDeAccion() > 0) {
            int s = token_accion.getTipoDeAccion() - 1;
            jTabbedPane_SeleccionAccion.setSelectedIndex(s);

        }
    }

    private void cambiarArmaDeLista() {

        DefaultListModel jdlm = (DefaultListModel) jList_armas.getModel();
        Arma a = (Arma) jdlm.getElementAt(jList_armas.getSelectedIndex());

        int extremidadesDisponibles = jdlm.getSize();
        jdlm = (DefaultListModel) jList_extremidades.getModel();

        ArrayList<Integer> habiles = new ArrayList<>();
        ArrayList<Integer> malas = new ArrayList<>();
        ArrayList<Integer> selecciones = new ArrayList<>();

        for (int i = 0; i < jdlm.getSize(); i++) {
            Extremidad ext = (Extremidad) jdlm.get(i);
            if (ext.isMiembroHabil()) {
                habiles.add(i);
            } else {
                malas.add(i);
            }
        }

        Token tok = token_accion.getToken();

        int ext_aux = (a.isdosManos()) ? 2 : 1;  // esta variable es cuantos brazos necesita

        if (a.isdosManos()) {
            jList_extremidades.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        } else {
            jList_extremidades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        }

        if (extremidadesDisponibles >= ext_aux) {
            while (ext_aux > 0) {
                for (Integer habil : habiles) {
                    selecciones.add(habil);
                    ((Extremidad) jdlm.get(habil)).setArmaEquipada(a);
                    ext_aux--;
                    extremidadesDisponibles--;
                }
                if (ext_aux > 0) {
                    for (Integer mala : malas) {
                        selecciones.add(mala);
                        ((Extremidad) jdlm.get(mala)).setArmaEquipada(a);
                        ext_aux--;
                        extremidadesDisponibles--;
                    }
                }
            }
        }
        
        int[] c = new int[selecciones.size()];
        for (int i = 0; i < selecciones.size(); i++) {
            c[i] = selecciones.get(i);
        }

        jList_extremidades.setSelectedIndices(c);
        iconarArma(a, jLabel_icono_armas);
        this.repaint();

        // si seleccione todas las extremidades, entonces deshabilito los escudos
        jList_escudos.setEnabled(jList_extremidades.getSelectedIndices().length < jdlm.size());

        // poner escudo automatico
        /*
        jdlm = (DefaultListModel) jList_escudos.getModel();
        if (extremidadesDisponibles > 0 && jdlm.size() > 0) {
            while (ext_aux > 0) {
                for (Integer habil : habiles) {
                    jList_extremidades.setSelectedIndex(habil);
                    ext_aux--;
                    extremidadesDisponibles--;
                }
                if (ext_aux > 0) {
                    for (Integer mala : malas) {
                        jList_extremidades.setSelectedIndex(mala);
                        ext_aux--;
                        extremidadesDisponibles--;
                    }
                }
            }
        }
         */
        cambiarBo();

    }

    private void cambiarEscudoLista() {

        DefaultListModel jdlm = (DefaultListModel) jList_escudos.getModel();
        Arma a = (Arma) jdlm.getElementAt(jList_escudos.getSelectedIndex());

        iconarArma(a, jLabel_icono_escudo);
        this.repaint();
        cambiarBo();
    }

    private void agregarArmaALalista(Arma a) {
        if (a != null) {
            DefaultListModel jdlm = (DefaultListModel) jList_armas.getModel();
            jdlm.addElement(a);
            jList_armas.setModel(jdlm);

        }
    }

    private void agregarEscudoALalista(Arma a) {
        if (a != null) {
            DefaultListModel jdlm = (DefaultListModel) jList_escudos.getModel();
            jdlm.addElement(a);
            jList_escudos.setModel(jdlm);

        }
    }

    public void iconar(String path) {

        ImageIcon icon = new ImageIcon(path);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
        jLabel_avatar.setText(null);
        jLabel_avatar.setIcon(icono);
    }

    public void iconarArma(Arma a, JLabel lab) {

        if (a.getIconoUrl() != null) {
            ImageIcon icon = new ImageIcon(a.getIconoUrl());
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
            lab.setText(null);
            lab.setIcon(icono);
        } else {
            lab.setText(null);
            lab.setIcon(null);
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
        buttonGroup_tipo_desplazamiento = new javax.swing.ButtonGroup();
        jPanel41 = new javax.swing.JPanel();
        jTextField_name = new javax.swing.JTextField();
        jLabel_avatar = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jPanel40 = new javax.swing.JPanel();
        jTabbedPane_SeleccionAccion = new javax.swing.JTabbedPane();
        jPanel_Carga_Sortilegio_tabPanel1 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jTextField_sort_cargado1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField_sort_num_cargas1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTextField_sort_bono = new javax.swing.JTextField();
        jPanel_carga_sort_nombre_carga = new javax.swing.JPanel();
        jComboBox_Lista_sotilegios = new javax.swing.JComboBox<>();
        jButton_crearSortilegio_Carga1 = new javax.swing.JButton();
        jComboBox_sotilegios = new javax.swing.JComboBox<>();
        jButton_crearSortilegio_Carga = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jPanel_carga_sort_datos_Cargado = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_lv_sort_carga = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_Dominio_sort_carga = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jCheckBox_consume_sort_carga = new javax.swing.JCheckBox();
        jPanel18 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField_PPActual_carga = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_alcance_sort_carga = new javax.swing.JTextField();
        jPanel23 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jTextField_duracion_sort_carga = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField_area_sort_carga = new javax.swing.JTextField();
        jPanel_Realiza_Sortilegio_tabPanel = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jTextField_sort_cargado = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextField_sort_num_cargas = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jTextField_sort_bono1 = new javax.swing.JTextField();
        jPanel_carga_sort_nombre_Realiza = new javax.swing.JPanel();
        jComboBox_Lista_sotilegios_realiza = new javax.swing.JComboBox<>();
        jButton_crearSortilegio_Carga2 = new javax.swing.JButton();
        jComboBox_sotilegios_Realiza = new javax.swing.JComboBox<>();
        jButton_crearSortilegio_Carga3 = new javax.swing.JButton();
        jPanel_carga_sort_datos_Realiza = new javax.swing.JPanel();
        jPanel_carga_sort_datos_Cargado1 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_lv_sort_realiza = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Dominio_sort_realiza = new javax.swing.JTextField();
        jPanel29 = new javax.swing.JPanel();
        jCheckBox_consume_sort_realiza = new javax.swing.JCheckBox();
        jPanel30 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField_PPActual_ls_realiza = new javax.swing.JTextField();
        jPanel31 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField_alcance_sort_realiza = new javax.swing.JTextField();
        jPanel32 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField_duracion_sort_realiza = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jTextField_area_sort_realiza = new javax.swing.JTextField();
        jPanel_Dispara_Proyectil_tabPanel = new javax.swing.JPanel();
        jPanel27 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxEnemigos1 = new javax.swing.JComboBox();
        jPanel35 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jComboBoxArmas_Proy = new javax.swing.JComboBox();
        jPanel_distancia1 = new javax.swing.JPanel();
        jLabel_distancia1 = new javax.swing.JLabel();
        jSpinner_distancia1 = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Bono_Distancia = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jPanel_Carga_Proyectil_tabPanel = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jComboBoxArmas_Proy1 = new javax.swing.JComboBox();
        jPanel36 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel_Parar_Proyectil_tabPanel = new javax.swing.JPanel();
        jPanel_Movimiento_Y_maniobra_tabPanel = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jRadioButton_rutina = new javax.swing.JRadioButton();
        jRadioButton_muyFacil = new javax.swing.JRadioButton();
        jRadioButton_facil = new javax.swing.JRadioButton();
        jRadioButton_media = new javax.swing.JRadioButton();
        jRadioButton_dificil = new javax.swing.JRadioButton();
        jRadioButton_muydificil = new javax.swing.JRadioButton();
        jRadioButton_extDificil = new javax.swing.JRadioButton();
        jRadioButton_locura = new javax.swing.JRadioButton();
        jRadioButton_absurdo = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel_distancia4 = new javax.swing.JLabel();
        jTextField_mmActual_mm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField_bono_mm = new javax.swing.JTextField();
        jSpinner_bono_mm = new javax.swing.JSpinner();
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel_brazo_derecho = new javax.swing.JPanel();
        jPanel_armas = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel_icono_armas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_armas = new javax.swing.JList<>();
        jPanel_brazos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList_extremidades = new javax.swing.JList<>();
        jPanel_brazo_izquierdo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList_escudos = new javax.swing.JList<>();
        jPanel44 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel_icono_escudo = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel_distancia = new javax.swing.JPanel();
        jSpinner_distanciaCaC = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jPanel_distancia3 = new javax.swing.JPanel();
        jSpinner_Cambios = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSlider_Bo = new javax.swing.JSlider();
        jPanel14 = new javax.swing.JPanel();
        jTextField_Bo = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jPanel_Desplazamiento_tabPanel = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jRadioButton_caminar = new javax.swing.JRadioButton();
        jRadioButton_correr = new javax.swing.JRadioButton();
        jRadioButton_trotar = new javax.swing.JRadioButton();
        jPanel_distancia2 = new javax.swing.JPanel();
        jLabel_distancia2 = new javax.swing.JLabel();
        jSpinner_distancia_desplazamiento = new javax.swing.JSpinner();
        jTextField9 = new javax.swing.JTextField();
        jLabel_distancia3 = new javax.swing.JLabel();
        jTextField_mmActual = new javax.swing.JTextField();
        jPanel39 = new javax.swing.JPanel();
        jTextField_maximo = new javax.swing.JTextField();
        jPanel_Movimiento_Estatico = new javax.swing.JPanel();
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
        setMinimumSize(new java.awt.Dimension(626, 226));
        setResizable(false);

        jPanel41.setPreferredSize(new java.awt.Dimension(621, 50));
        jPanel41.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 25, 5));

        jTextField_name.setEditable(false);
        jTextField_name.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jTextField_name.setText("Token Name");
        jTextField_name.setPreferredSize(new java.awt.Dimension(365, 35));
        jPanel41.add(jTextField_name);

        jLabel_avatar.setText("Icono");
        jLabel_avatar.setPreferredSize(new java.awt.Dimension(40, 40));
        jPanel41.add(jLabel_avatar);

        getContentPane().add(jPanel41, java.awt.BorderLayout.PAGE_START);

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

        jPanel40.setLayout(new javax.swing.BoxLayout(jPanel40, javax.swing.BoxLayout.PAGE_AXIS));

        jTabbedPane_SeleccionAccion.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane_SeleccionAccion.setMinimumSize(new java.awt.Dimension(618, 167));
        jTabbedPane_SeleccionAccion.setPreferredSize(new java.awt.Dimension(618, 167));

        jPanel_Carga_Sortilegio_tabPanel1.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Carga_Sortilegio_tabPanel1.setLayout(new javax.swing.BoxLayout(jPanel_Carga_Sortilegio_tabPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel20.setMinimumSize(new java.awt.Dimension(472, 14));
        jPanel20.setPreferredSize(new java.awt.Dimension(472, 14));

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

        jPanel_carga_sort_nombre_carga.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

        jComboBox_Lista_sotilegios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Lista_sotilegios.setMinimumSize(new java.awt.Dimension(156, 20));
        jComboBox_Lista_sotilegios.setPreferredSize(new java.awt.Dimension(330, 20));
        jComboBox_Lista_sotilegios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_Lista_sotilegiosItemStateChanged(evt);
            }
        });
        jComboBox_Lista_sotilegios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Lista_sotilegiosActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_carga.add(jComboBox_Lista_sotilegios);

        jButton_crearSortilegio_Carga1.setText("N. Lista Sort");
        jButton_crearSortilegio_Carga1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearSortilegio_Carga1ActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_carga.add(jButton_crearSortilegio_Carga1);

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

        jButton_crearSortilegio_Carga.setText("N. Sortilegio");
        jButton_crearSortilegio_Carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearSortilegio_CargaActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_carga.add(jButton_crearSortilegio_Carga);

        jPanel_Carga_Sortilegio_tabPanel1.add(jPanel_carga_sort_nombre_carga);

        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        jPanel_carga_sort_datos_Cargado.setPreferredSize(new java.awt.Dimension(476, 35));
        jPanel_carga_sort_datos_Cargado.setLayout(new java.awt.GridLayout(2, 0, 3, 3));

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        jLabel3.setText("Lv");
        jPanel7.add(jLabel3);

        jTextField_lv_sort_carga.setEditable(false);
        jTextField_lv_sort_carga.setMinimumSize(new java.awt.Dimension(66, 20));
        jTextField_lv_sort_carga.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel7.add(jTextField_lv_sort_carga);

        jPanel_carga_sort_datos_Cargado.add(jPanel7);

        jPanel10.setLayout(new java.awt.GridLayout(1, 0));

        jLabel4.setText("Dominio");
        jPanel10.add(jLabel4);

        jTextField_Dominio_sort_carga.setEditable(false);
        jTextField_Dominio_sort_carga.setMinimumSize(new java.awt.Dimension(66, 20));
        jTextField_Dominio_sort_carga.setPreferredSize(new java.awt.Dimension(66, 20));
        jPanel10.add(jTextField_Dominio_sort_carga);

        jPanel_carga_sort_datos_Cargado.add(jPanel10);

        jPanel12.setLayout(new java.awt.GridLayout(1, 0));

        jCheckBox_consume_sort_carga.setText("Consume PP");
        jCheckBox_consume_sort_carga.setEnabled(false);
        jPanel12.add(jCheckBox_consume_sort_carga);

        jPanel_carga_sort_datos_Cargado.add(jPanel12);

        jPanel18.setLayout(new java.awt.GridLayout(1, 0));

        jLabel13.setText("PP Actual");
        jPanel18.add(jLabel13);

        jTextField_PPActual_carga.setEditable(false);
        jTextField_PPActual_carga.setText(" ");
        jTextField_PPActual_carga.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel18.add(jTextField_PPActual_carga);

        jPanel_carga_sort_datos_Cargado.add(jPanel18);

        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        jLabel9.setText("Alcance");
        jPanel13.add(jLabel9);

        jTextField_alcance_sort_carga.setEditable(false);
        jTextField_alcance_sort_carga.setText(" ");
        jTextField_alcance_sort_carga.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel13.add(jTextField_alcance_sort_carga);

        jPanel_carga_sort_datos_Cargado.add(jPanel13);

        jPanel23.setLayout(new java.awt.GridLayout(1, 0));

        jLabel15.setText("Duracion");
        jPanel23.add(jLabel15);

        jTextField_duracion_sort_carga.setEditable(false);
        jTextField_duracion_sort_carga.setText(" ");
        jTextField_duracion_sort_carga.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel23.add(jTextField_duracion_sort_carga);

        jPanel_carga_sort_datos_Cargado.add(jPanel23);

        jPanel24.setLayout(new java.awt.GridLayout(1, 0));

        jLabel18.setText("Area Efecto");
        jPanel24.add(jLabel18);

        jTextField_area_sort_carga.setEditable(false);
        jTextField_area_sort_carga.setText(" ");
        jTextField_area_sort_carga.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel24.add(jTextField_area_sort_carga);

        jPanel_carga_sort_datos_Cargado.add(jPanel24);

        jPanel8.add(jPanel_carga_sort_datos_Cargado);

        jPanel_Carga_Sortilegio_tabPanel1.add(jPanel8);

        jTabbedPane_SeleccionAccion.addTab("Carga Sortilegio", jPanel_Carga_Sortilegio_tabPanel1);

        jPanel_Realiza_Sortilegio_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Realiza_Sortilegio_tabPanel.setLayout(new javax.swing.BoxLayout(jPanel_Realiza_Sortilegio_tabPanel, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel21.setPreferredSize(new java.awt.Dimension(472, 14));

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

        jPanel_carga_sort_nombre_Realiza.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 2));

        jComboBox_Lista_sotilegios_realiza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Lista_sotilegios_realiza.setMinimumSize(new java.awt.Dimension(156, 20));
        jComboBox_Lista_sotilegios_realiza.setPreferredSize(new java.awt.Dimension(330, 20));
        jComboBox_Lista_sotilegios_realiza.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_Lista_sotilegios_realizaItemStateChanged(evt);
            }
        });
        jComboBox_Lista_sotilegios_realiza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_Lista_sotilegios_realizaActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_Realiza.add(jComboBox_Lista_sotilegios_realiza);

        jButton_crearSortilegio_Carga2.setText("N. Lista Sort");
        jButton_crearSortilegio_Carga2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearSortilegio_Carga2ActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_Realiza.add(jButton_crearSortilegio_Carga2);

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
        jPanel_carga_sort_nombre_Realiza.add(jComboBox_sotilegios_Realiza);

        jButton_crearSortilegio_Carga3.setText("N. Sortilegio");
        jButton_crearSortilegio_Carga3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_crearSortilegio_Carga3ActionPerformed(evt);
            }
        });
        jPanel_carga_sort_nombre_Realiza.add(jButton_crearSortilegio_Carga3);

        jPanel_Realiza_Sortilegio_tabPanel.add(jPanel_carga_sort_nombre_Realiza);

        jPanel_carga_sort_datos_Realiza.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 15, 5));

        jPanel_carga_sort_datos_Cargado1.setPreferredSize(new java.awt.Dimension(476, 35));
        jPanel_carga_sort_datos_Cargado1.setLayout(new java.awt.GridLayout(2, 0, 3, 3));

        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        jLabel5.setText("Lv");
        jPanel26.add(jLabel5);

        jTextField_lv_sort_realiza.setEditable(false);
        jTextField_lv_sort_realiza.setMinimumSize(new java.awt.Dimension(66, 20));
        jTextField_lv_sort_realiza.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel26.add(jTextField_lv_sort_realiza);

        jPanel_carga_sort_datos_Cargado1.add(jPanel26);

        jPanel28.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setText("Dominio");
        jPanel28.add(jLabel6);

        jTextField_Dominio_sort_realiza.setEditable(false);
        jTextField_Dominio_sort_realiza.setMinimumSize(new java.awt.Dimension(66, 20));
        jTextField_Dominio_sort_realiza.setPreferredSize(new java.awt.Dimension(66, 20));
        jPanel28.add(jTextField_Dominio_sort_realiza);

        jPanel_carga_sort_datos_Cargado1.add(jPanel28);

        jPanel29.setLayout(new java.awt.GridLayout(1, 0));

        jCheckBox_consume_sort_realiza.setText("Consume PP");
        jCheckBox_consume_sort_realiza.setEnabled(false);
        jPanel29.add(jCheckBox_consume_sort_realiza);

        jPanel_carga_sort_datos_Cargado1.add(jPanel29);

        jPanel30.setLayout(new java.awt.GridLayout(1, 0));

        jLabel19.setText("PP Actual");
        jPanel30.add(jLabel19);

        jTextField_PPActual_ls_realiza.setEditable(false);
        jTextField_PPActual_ls_realiza.setText(" ");
        jTextField_PPActual_ls_realiza.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel30.add(jTextField_PPActual_ls_realiza);

        jPanel_carga_sort_datos_Cargado1.add(jPanel30);

        jPanel31.setLayout(new java.awt.GridLayout(1, 0));

        jLabel20.setText("Alcance");
        jPanel31.add(jLabel20);

        jTextField_alcance_sort_realiza.setEditable(false);
        jTextField_alcance_sort_realiza.setText(" ");
        jTextField_alcance_sort_realiza.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel31.add(jTextField_alcance_sort_realiza);

        jPanel_carga_sort_datos_Cargado1.add(jPanel31);

        jPanel32.setLayout(new java.awt.GridLayout(1, 0));

        jLabel21.setText("Duracion");
        jPanel32.add(jLabel21);

        jTextField_duracion_sort_realiza.setEditable(false);
        jTextField_duracion_sort_realiza.setText(" ");
        jTextField_duracion_sort_realiza.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel32.add(jTextField_duracion_sort_realiza);

        jPanel_carga_sort_datos_Cargado1.add(jPanel32);

        jPanel34.setLayout(new java.awt.GridLayout(1, 0));

        jLabel28.setText("Area Efecto");
        jPanel34.add(jLabel28);

        jTextField_area_sort_realiza.setEditable(false);
        jTextField_area_sort_realiza.setText(" ");
        jTextField_area_sort_realiza.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel34.add(jTextField_area_sort_realiza);

        jPanel_carga_sort_datos_Cargado1.add(jPanel34);

        jPanel_carga_sort_datos_Realiza.add(jPanel_carga_sort_datos_Cargado1);

        jPanel_Realiza_Sortilegio_tabPanel.add(jPanel_carga_sort_datos_Realiza);

        jTabbedPane_SeleccionAccion.addTab("Realiza Sortilegio", jPanel_Realiza_Sortilegio_tabPanel);

        jPanel_Dispara_Proyectil_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Dispara_Proyectil_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Dispara_Proyectil_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Dispara_Proyectil_tabPanel.setLayout(new java.awt.BorderLayout());

        jPanel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel27.setMaximumSize(new java.awt.Dimension(224, 185));
        jPanel27.setLayout(new javax.swing.BoxLayout(jPanel27, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel25.setLayout(new javax.swing.BoxLayout(jPanel25, javax.swing.BoxLayout.LINE_AXIS));

        jLabel16.setText("Enemigo");
        jPanel25.add(jLabel16);

        jComboBoxEnemigos1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEnemigos1.setPreferredSize(new java.awt.Dimension(175, 20));
        jPanel25.add(jComboBoxEnemigos1);

        jPanel11.add(jPanel25);

        jPanel35.setLayout(new javax.swing.BoxLayout(jPanel35, javax.swing.BoxLayout.LINE_AXIS));

        jLabel17.setText("Arma");
        jPanel35.add(jLabel17);

        jComboBoxArmas_Proy.setPreferredSize(new java.awt.Dimension(175, 20));
        jComboBoxArmas_Proy.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArmas_ProyItemStateChanged(evt);
            }
        });
        jPanel35.add(jComboBoxArmas_Proy);

        jPanel11.add(jPanel35);

        jPanel27.add(jPanel11);

        jLabel_distancia1.setText("  Distancia  ");
        jPanel_distancia1.add(jLabel_distancia1);

        jSpinner_distancia1.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 3));
        jSpinner_distancia1.setMinimumSize(new java.awt.Dimension(51, 20));
        jSpinner_distancia1.setPreferredSize(new java.awt.Dimension(51, 20));
        jPanel_distancia1.add(jSpinner_distancia1);

        jLabel1.setText("Mts");
        jPanel_distancia1.add(jLabel1);

        jTextField_Bono_Distancia.setEditable(false);
        jTextField_Bono_Distancia.setText("mts.");
        jTextField_Bono_Distancia.setMaximumSize(new java.awt.Dimension(26, 28));
        jTextField_Bono_Distancia.setMinimumSize(new java.awt.Dimension(26, 28));
        jTextField_Bono_Distancia.setName(""); // NOI18N
        jTextField_Bono_Distancia.setPreferredSize(new java.awt.Dimension(76, 28));
        jTextField_Bono_Distancia.setRequestFocusEnabled(false);
        jPanel_distancia1.add(jTextField_Bono_Distancia);

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

        jPanel37.setLayout(new javax.swing.BoxLayout(jPanel37, javax.swing.BoxLayout.LINE_AXIS));

        jLabel31.setText("Arma");
        jPanel37.add(jLabel31);

        jComboBoxArmas_Proy1.setPreferredSize(new java.awt.Dimension(175, 20));
        jComboBoxArmas_Proy1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxArmas_Proy1ItemStateChanged(evt);
            }
        });
        jPanel37.add(jComboBoxArmas_Proy1);

        jPanel_Carga_Proyectil_tabPanel.add(jPanel37);

        jPanel36.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel29.setText("Asaltos Cargados");
        jPanel36.add(jLabel29);

        jTextField21.setEditable(false);
        jTextField21.setText(" ");
        jTextField21.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField21.setMinimumSize(new java.awt.Dimension(75, 20));
        jTextField21.setName(""); // NOI18N
        jTextField21.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel36.add(jTextField21);

        jLabel30.setText("Bono");
        jPanel36.add(jLabel30);

        jTextField22.setEditable(false);
        jTextField22.setText(" ");
        jTextField22.setMaximumSize(new java.awt.Dimension(75, 20));
        jTextField22.setMinimumSize(new java.awt.Dimension(75, 20));
        jTextField22.setName(""); // NOI18N
        jTextField22.setPreferredSize(new java.awt.Dimension(75, 20));
        jPanel36.add(jTextField22);

        jPanel_Carga_Proyectil_tabPanel.add(jPanel36);

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

        buttonGroup2.add(jRadioButton_rutina);
        jRadioButton_rutina.setSelected(true);
        jRadioButton_rutina.setText("Rutinaria");
        jPanel6.add(jRadioButton_rutina);

        buttonGroup2.add(jRadioButton_muyFacil);
        jRadioButton_muyFacil.setText("Muy Facil");
        jPanel6.add(jRadioButton_muyFacil);

        buttonGroup2.add(jRadioButton_facil);
        jRadioButton_facil.setText("Facil");
        jPanel6.add(jRadioButton_facil);

        buttonGroup2.add(jRadioButton_media);
        jRadioButton_media.setText("Media");
        jPanel6.add(jRadioButton_media);

        buttonGroup2.add(jRadioButton_dificil);
        jRadioButton_dificil.setText("Dificil");
        jPanel6.add(jRadioButton_dificil);

        buttonGroup2.add(jRadioButton_muydificil);
        jRadioButton_muydificil.setText("Muy Dificil");
        jPanel6.add(jRadioButton_muydificil);

        buttonGroup2.add(jRadioButton_extDificil);
        jRadioButton_extDificil.setText("Extrem. Dificil");
        jPanel6.add(jRadioButton_extDificil);

        buttonGroup2.add(jRadioButton_locura);
        jRadioButton_locura.setText("Locura");
        jPanel6.add(jRadioButton_locura);

        buttonGroup2.add(jRadioButton_absurdo);
        jRadioButton_absurdo.setText("Absurdo");
        jPanel6.add(jRadioButton_absurdo);

        jPanel_Movimiento_Y_maniobra_tabPanel.add(jPanel6);

        jLabel_distancia4.setText("Mov y Maniobra");
        jPanel2.add(jLabel_distancia4);

        jTextField_mmActual_mm.setEditable(false);
        jTextField_mmActual_mm.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_mmActual_mm.setMaximumSize(new java.awt.Dimension(26, 28));
        jTextField_mmActual_mm.setMinimumSize(new java.awt.Dimension(56, 28));
        jTextField_mmActual_mm.setName(""); // NOI18N
        jTextField_mmActual_mm.setPreferredSize(new java.awt.Dimension(56, 28));
        jTextField_mmActual_mm.setRequestFocusEnabled(false);
        jPanel2.add(jTextField_mmActual_mm);

        jLabel2.setText("Bono Extra");
        jPanel2.add(jLabel2);

        jTextField_bono_mm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_bono_mm.setText("0");
        jTextField_bono_mm.setMinimumSize(new java.awt.Dimension(50, 20));
        jTextField_bono_mm.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel2.add(jTextField_bono_mm);

        jSpinner_bono_mm.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 5));
        jSpinner_bono_mm.setMinimumSize(new java.awt.Dimension(51, 20));
        jSpinner_bono_mm.setPreferredSize(new java.awt.Dimension(51, 20));
        jPanel2.add(jSpinner_bono_mm);

        jPanel_Movimiento_Y_maniobra_tabPanel.add(jPanel2);

        jTabbedPane_SeleccionAccion.addTab("Movimiento Y maniobra", jPanel_Movimiento_Y_maniobra_tabPanel);

        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.setLayout(new java.awt.BorderLayout());

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setMaximumSize(new java.awt.Dimension(224, 185));
        jPanel15.setLayout(new javax.swing.BoxLayout(jPanel15, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel9.setMinimumSize(new java.awt.Dimension(234, 100));
        jPanel9.setPreferredSize(new java.awt.Dimension(513, 110));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        jPanel_brazo_derecho.setBorder(javax.swing.BorderFactory.createTitledBorder("Arma"));
        jPanel_brazo_derecho.setMinimumSize(new java.awt.Dimension(0, 80));
        jPanel_brazo_derecho.setPreferredSize(new java.awt.Dimension(185, 80));
        jPanel_brazo_derecho.setLayout(new javax.swing.BoxLayout(jPanel_brazo_derecho, javax.swing.BoxLayout.LINE_AXIS));

        jPanel_armas.setPreferredSize(new java.awt.Dimension(137, 60));
        jPanel_armas.setLayout(new javax.swing.BoxLayout(jPanel_armas, javax.swing.BoxLayout.LINE_AXIS));

        jPanel45.setLayout(new javax.swing.BoxLayout(jPanel45, javax.swing.BoxLayout.PAGE_AXIS));

        jButton3.setText("+");
        jPanel45.add(jButton3);

        jLabel_icono_armas.setText("Icon");
        jLabel_icono_armas.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel_icono_armas.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel_icono_armas.setName(""); // NOI18N
        jLabel_icono_armas.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabel_icono_armas.setRequestFocusEnabled(false);
        jPanel45.add(jLabel_icono_armas);

        jPanel_armas.add(jPanel45);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(228, 80));

        jList_armas.setModel(new DefaultListModel());
        jList_armas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_armas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_armasValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList_armas);

        jPanel_armas.add(jScrollPane1);

        jPanel_brazo_derecho.add(jPanel_armas);

        jPanel_brazos.setPreferredSize(new java.awt.Dimension(90, 100));
        jPanel_brazos.setLayout(new javax.swing.BoxLayout(jPanel_brazos, javax.swing.BoxLayout.PAGE_AXIS));

        jScrollPane4.setPreferredSize(new java.awt.Dimension(123, 23));

        jList_extremidades.setModel(new DefaultListModel());
        jList_extremidades.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_extremidades.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_extremidadesValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jList_extremidades);

        jPanel_brazos.add(jScrollPane4);

        jPanel_brazo_derecho.add(jPanel_brazos);

        jPanel9.add(jPanel_brazo_derecho);

        jPanel_brazo_izquierdo.setBorder(javax.swing.BorderFactory.createTitledBorder("Escudo"));
        jPanel_brazo_izquierdo.setMinimumSize(new java.awt.Dimension(0, 80));
        jPanel_brazo_izquierdo.setPreferredSize(new java.awt.Dimension(135, 80));
        jPanel_brazo_izquierdo.setLayout(new javax.swing.BoxLayout(jPanel_brazo_izquierdo, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane2.setPreferredSize(new java.awt.Dimension(258, 80));

        jList_escudos.setModel(new DefaultListModel());
        jList_escudos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_escudos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_escudosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList_escudos);

        jPanel_brazo_izquierdo.add(jScrollPane2);

        jPanel44.setLayout(new javax.swing.BoxLayout(jPanel44, javax.swing.BoxLayout.PAGE_AXIS));

        jButton4.setText("+");
        jPanel44.add(jButton4);

        jLabel_icono_escudo.setText("Icon");
        jLabel_icono_escudo.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel_icono_escudo.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel_icono_escudo.setName(""); // NOI18N
        jLabel_icono_escudo.setPreferredSize(new java.awt.Dimension(50, 50));
        jLabel_icono_escudo.setRequestFocusEnabled(false);
        jLabel_icono_escudo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_icono_escudoMouseClicked(evt);
            }
        });
        jPanel44.add(jLabel_icono_escudo);

        jPanel_brazo_izquierdo.add(jPanel44);

        jPanel9.add(jPanel_brazo_izquierdo);

        jPanel15.add(jPanel9);

        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.LINE_AXIS));

        jPanel_distancia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_distancia.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel_distancia.setLayout(new java.awt.GridLayout(1, 0));

        jSpinner_distanciaCaC.setModel(new javax.swing.SpinnerNumberModel(3, 3, null, 3));
        jSpinner_distanciaCaC.setPreferredSize(new java.awt.Dimension(51, 20));
        jSpinner_distanciaCaC.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_distanciaCaCStateChanged(evt);
            }
        });
        jPanel_distancia.add(jSpinner_distanciaCaC);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Mts");
        jPanel_distancia.add(jLabel7);

        jPanel16.add(jPanel_distancia);

        jPanel_distancia3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel_distancia3.setPreferredSize(new java.awt.Dimension(50, 30));
        jPanel_distancia3.setLayout(new javax.swing.BoxLayout(jPanel_distancia3, javax.swing.BoxLayout.LINE_AXIS));

        jSpinner_Cambios.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jSpinner_Cambios.setPreferredSize(new java.awt.Dimension(51, 20));
        jSpinner_Cambios.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_CambiosStateChanged(evt);
            }
        });
        jPanel_distancia3.add(jSpinner_Cambios);

        jLabel8.setText("Cambios");
        jPanel_distancia3.add(jLabel8);

        jPanel16.add(jPanel_distancia3);

        jPanel17.setMaximumSize(new java.awt.Dimension(32767, 159));
        jPanel17.setMinimumSize(new java.awt.Dimension(133, 100));
        jPanel17.setPreferredSize(new java.awt.Dimension(301, 40));
        jPanel17.setLayout(new javax.swing.BoxLayout(jPanel17, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jSlider_Bo.setForeground(new java.awt.Color(102, 102, 102));
        jSlider_Bo.setMajorTickSpacing(token_accion.getToken().bo_pri().getValue() / 8);
        jSlider_Bo.setMaximum(30);
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

        jPanel14.setMaximumSize(new java.awt.Dimension(72, 100));
        jPanel14.setPreferredSize(new java.awt.Dimension(170, 40));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jTextField_Bo.setEditable(false);
        jTextField_Bo.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jTextField_Bo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Bo.setText("BO ");
        jTextField_Bo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_BoActionPerformed(evt);
            }
        });
        jPanel14.add(jTextField_Bo);

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField8.setText("BD");
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel14.add(jTextField8);

        jPanel17.add(jPanel14);

        jPanel16.add(jPanel17);

        jPanel15.add(jPanel16);

        jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jTabbedPane_SeleccionAccion.addTab("Ataque Cuerpo a Cuerpo", jPanel_Ataque_Cuerpo_a_Cuerpo_tabDA);

        jPanel_Desplazamiento_tabPanel.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Desplazamiento_tabPanel.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Desplazamiento_tabPanel.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Desplazamiento_tabPanel.setLayout(new java.awt.BorderLayout());

        jPanel38.setLayout(new javax.swing.BoxLayout(jPanel38, javax.swing.BoxLayout.LINE_AXIS));

        buttonGroup_tipo_desplazamiento.add(jRadioButton_caminar);
        jRadioButton_caminar.setSelected(true);
        jRadioButton_caminar.setText("Caminar");
        jRadioButton_caminar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_caminarItemStateChanged(evt);
            }
        });
        jPanel38.add(jRadioButton_caminar);

        buttonGroup_tipo_desplazamiento.add(jRadioButton_correr);
        jRadioButton_correr.setText("Correr");
        jRadioButton_correr.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_correrItemStateChanged(evt);
            }
        });
        jPanel38.add(jRadioButton_correr);

        buttonGroup_tipo_desplazamiento.add(jRadioButton_trotar);
        jRadioButton_trotar.setText("Trotar");
        jRadioButton_trotar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton_trotarItemStateChanged(evt);
            }
        });
        jPanel38.add(jRadioButton_trotar);

        jPanel_Desplazamiento_tabPanel.add(jPanel38, java.awt.BorderLayout.NORTH);

        jLabel_distancia2.setText("  Distancia  ");
        jPanel_distancia2.add(jLabel_distancia2);

        jSpinner_distancia_desplazamiento.setModel(new javax.swing.SpinnerNumberModel(3, 3, 30, 3));
        jPanel_distancia2.add(jSpinner_distancia_desplazamiento);

        jTextField9.setEditable(false);
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField9.setText("mts.");
        jTextField9.setMaximumSize(new java.awt.Dimension(26, 28));
        jTextField9.setMinimumSize(new java.awt.Dimension(56, 28));
        jTextField9.setName(""); // NOI18N
        jTextField9.setPreferredSize(new java.awt.Dimension(56, 28));
        jTextField9.setRequestFocusEnabled(false);
        jPanel_distancia2.add(jTextField9);

        jLabel_distancia3.setText("Mov y Maniobra");
        jPanel_distancia2.add(jLabel_distancia3);

        jTextField_mmActual.setEditable(false);
        jTextField_mmActual.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField_mmActual.setMaximumSize(new java.awt.Dimension(26, 28));
        jTextField_mmActual.setMinimumSize(new java.awt.Dimension(56, 28));
        jTextField_mmActual.setName(""); // NOI18N
        jTextField_mmActual.setPreferredSize(new java.awt.Dimension(56, 28));
        jTextField_mmActual.setRequestFocusEnabled(false);
        jPanel_distancia2.add(jTextField_mmActual);

        jPanel_Desplazamiento_tabPanel.add(jPanel_distancia2, java.awt.BorderLayout.CENTER);

        jTextField_maximo.setEditable(false);
        jTextField_maximo.setMinimumSize(new java.awt.Dimension(76, 20));
        jTextField_maximo.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel39.add(jTextField_maximo);

        jPanel_Desplazamiento_tabPanel.add(jPanel39, java.awt.BorderLayout.SOUTH);

        jTabbedPane_SeleccionAccion.addTab("Desplazamiento", jPanel_Desplazamiento_tabPanel);

        jPanel_Movimiento_Estatico.setMaximumSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Estatico.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Estatico.setPreferredSize(new java.awt.Dimension(300, 100));
        jPanel_Movimiento_Estatico.setLayout(null);
        jTabbedPane_SeleccionAccion.addTab("Movimiento Estatico", jPanel_Movimiento_Estatico);

        jPanel40.add(jTabbedPane_SeleccionAccion);

        jPanel_desc_Accion.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion de la Accion"));
        jPanel_desc_Accion.setMaximumSize(new java.awt.Dimension(32779, 100));
        jPanel_desc_Accion.setMinimumSize(new java.awt.Dimension(50, 46));
        jPanel_desc_Accion.setPreferredSize(new java.awt.Dimension(178, 100));
        jPanel_desc_Accion.setLayout(new javax.swing.BoxLayout(jPanel_desc_Accion, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea_desc.setColumns(20);
        jTextArea_desc.setRows(5);
        jScrollPane3.setViewportView(jTextArea_desc);

        jPanel_desc_Accion.add(jScrollPane3);

        jPanel40.add(jPanel_desc_Accion);

        getContentPane().add(jPanel40, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        declarar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField_BoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_BoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_BoActionPerformed

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

    private void jComboBox_sotilegiosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_sotilegiosItemStateChanged
        actualizarSortilegioCarga();
    }//GEN-LAST:event_jComboBox_sotilegiosItemStateChanged

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jSlider_BoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_BoStateChanged
        moverBo();
    }//GEN-LAST:event_jSlider_BoStateChanged

    private void jComboBox_Lista_sotilegiosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_Lista_sotilegiosItemStateChanged
        if (jComboBox_Lista_sotilegios.getSelectedIndex() > -1) {
            ListaDeSortilegios lds = (ListaDeSortilegios) jComboBox_Lista_sotilegios.getSelectedItem();
            mostrarLista(lds);
        }
    }//GEN-LAST:event_jComboBox_Lista_sotilegiosItemStateChanged

    private void jComboBox_Lista_sotilegiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Lista_sotilegiosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Lista_sotilegiosActionPerformed

    private void jButton_crearSortilegio_Carga1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearSortilegio_Carga1ActionPerformed
        cargarListaDeSortilegio();
    }//GEN-LAST:event_jButton_crearSortilegio_Carga1ActionPerformed

    private void jComboBox_Lista_sotilegios_realizaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_Lista_sotilegios_realizaItemStateChanged
        if (jComboBox_Lista_sotilegios_realiza.getSelectedIndex() > -1) {
            ListaDeSortilegios lds = (ListaDeSortilegios) jComboBox_Lista_sotilegios_realiza.getSelectedItem();
            mostrarLista(lds);
        }
    }//GEN-LAST:event_jComboBox_Lista_sotilegios_realizaItemStateChanged

    private void jComboBox_Lista_sotilegios_realizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_Lista_sotilegios_realizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_Lista_sotilegios_realizaActionPerformed

    private void jButton_crearSortilegio_Carga2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearSortilegio_Carga2ActionPerformed
        cargarListaDeSortilegio();
    }//GEN-LAST:event_jButton_crearSortilegio_Carga2ActionPerformed

    private void jComboBox_sotilegios_RealizaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_sotilegios_RealizaItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_sotilegios_RealizaItemStateChanged

    private void jComboBox_sotilegios_RealizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_sotilegios_RealizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_sotilegios_RealizaActionPerformed

    private void jButton_crearSortilegio_Carga3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_crearSortilegio_Carga3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_crearSortilegio_Carga3ActionPerformed

    private void jComboBoxArmas_Proy1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxArmas_Proy1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxArmas_Proy1ItemStateChanged

    private void jRadioButton_caminarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_caminarItemStateChanged
        limitardesplazamiento();
    }//GEN-LAST:event_jRadioButton_caminarItemStateChanged

    private void jRadioButton_correrItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_correrItemStateChanged
        limitardesplazamiento();
    }//GEN-LAST:event_jRadioButton_correrItemStateChanged

    private void jRadioButton_trotarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton_trotarItemStateChanged
        limitardesplazamiento();
    }//GEN-LAST:event_jRadioButton_trotarItemStateChanged

    private void jList_armasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_armasValueChanged
        cambiarArmaDeLista();
    }//GEN-LAST:event_jList_armasValueChanged

    private void jLabel_icono_escudoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_icono_escudoMouseClicked

    }//GEN-LAST:event_jLabel_icono_escudoMouseClicked

    private void jList_escudosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_escudosValueChanged
        cambiarEscudoLista();
        moverBo();
    }//GEN-LAST:event_jList_escudosValueChanged

    private void jList_extremidadesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_extremidadesValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jList_extremidadesValueChanged

    private void jSpinner_CambiosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_CambiosStateChanged
        cambiarBo();
    }//GEN-LAST:event_jSpinner_CambiosStateChanged

    private void jSpinner_distanciaCaCStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_distanciaCaCStateChanged
        cambiarBo();
    }//GEN-LAST:event_jSpinner_distanciaCaCStateChanged

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

    private void nuevaListaDeSortilegios(boolean carga) {
        int sa = token_accion.getToken().getListasDeSortilegios().size();
        // int lds = jop  //NuevoSortilegio.Crear(principal, true, token_accion.getToken());
        ListaDeSortilegios lds = (ListaDeSortilegios) JOptionPane.showInputDialog(null,
                "Selecciona Arma", "ShowInputDialog",
                JOptionPane.PLAIN_MESSAGE, null, Principal.dataRecursos.getListasDeSortilegios().values().toArray(), "Seleccion una Lista de Sortilegios");
        if (lds != null) {
            token_accion.getToken().aprenderListaDeSortilegio(sa, sa);
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
            jTextField_alcance_sort_carga.setText(s.getAlcance().toString());
            jTextField_duracion_sort_carga.setText(s.getDuracion().toString());
            jTextField_area_sort_carga.setText(s.getAreaDeEfecto().toString());
        }
    }

    private void actualizarSortilegioRealiza() {
        if (jComboBox_sotilegios_Realiza.getItemCount() > 0) {
            Sortilegio s = (Sortilegio) jComboBox_sotilegios_Realiza.getSelectedItem();

            jTextField_Dominio_sort_realiza.setText(s.getDominioStr());
            jTextField_lv_sort_realiza.setText(s.getLv() + "");
            jPanel_carga_sort_nombre_Realiza.setToolTipText(s.getDescp());
            jPanel_carga_sort_datos_Realiza.setToolTipText(s.getDescp());
            jCheckBox_consume_sort_realiza.setSelected(s.isConsumePP());
            jTextField_alcance_sort_realiza.setText(s.getAlcance().toString());
            jTextField_duracion_sort_realiza.setText(s.getDuracion().toString());
            jTextField_area_sort_realiza.setText(s.getAreaDeEfecto().toString());
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

        int tipoAcion = this.jTabbedPane_SeleccionAccion.getSelectedIndex() + 1;
        Accion acc = null;
        int orden = 1;
        String fullDesc = "";

        DatosCombate combate = new DatosCombate();
        combate.setBd_Disponible(token.getBd());

        switch (tipoAcion) {
            case TIPO_ACCION_SIN_ACCION: {

                break;
            }
            case TIPO_ACCION_CARGA_SORTILEGIO: {
                Sortilegio sort_intencion = (Sortilegio) jComboBox_sotilegios.getSelectedItem();
                if (sort_intencion != null) {

                    if (token.puedeRealizarSortilegio(sort_intencion)) {

                        acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                        acc.setId_sort_intencion(sort_intencion.getId());
                        //token_accion.intentarSortilegio(sort_intencion);                   

                        fullDesc += sort_intencion.toString();
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
            case TIPO_ACCION_REALIZA_SORTILEGIO: {
                Sortilegio sort_intencion = (Sortilegio) jComboBox_sotilegios_Realiza.getSelectedItem();
                if (sort_intencion == null) {
                    recursos.Recursos.informar("Debe seleccionar un sortilegio");
                } else if (token.puedeRealizarSortilegio(sort_intencion)) {
                    acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                    acc.setId_sort_intencion(sort_anterior);
                    //token_accion.intentarSortilegio(sort_intencion);                    

                    fullDesc += sort_intencion.toString();
                    if (sort_intencion.getId() == sort_anterior) {
                        fullDesc += str_carga + "\n";
                    }
                    fullDesc += jTextArea_desc.getText();
                } else {
                    recursos.Recursos.informar("No puede realizar este Sortilegio");
                }
                break;
            }
            case TIPO_ACCION_DISPARA_PROYECTIL: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case TIPO_ACCION_CARGA_PROYECTIL: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case TIPO_ACCION_PARAR_PROYECTIL: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                fullDesc += "Dif. ";
                String txt = "";
                if (jRadioButton_rutina.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_RUTINA);
                }
                if (jRadioButton_muyFacil.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_FACIL);
                }
                if (jRadioButton_facil.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_MUY_FACIL);
                }
                if (jRadioButton_media.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_MEDIA);
                }
                if (jRadioButton_dificil.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_DIFICIL);
                }
                if (jRadioButton_muydificil.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_MUY_DIFICIL);
                }
                if (jRadioButton_extDificil.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_EXT_DIFICIL);
                }
                if (jRadioButton_locura.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_LOCURA);
                }
                if (jRadioButton_absurdo.isSelected()) {
                    txt = Recursos.dificultadTxt(DIFICULTAD_ABSURDO);
                }
                fullDesc += txt;
                acc.setDificultad(txt);
                fullDesc += "\n" + token.getMmActualTxt();
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO: {

                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);
                int bo = jSlider_Bo.getValue() + ((Integer) jSpinner_Cambios.getValue()) * 30;
                combate.setCantidadCambios((Integer) jSpinner_Cambios.getValue());
                combate.setBo_Disponible(bo);
                int bd = token.getBd() + jSlider_Bo.getMaximum() - bo;
                combate.setBd_Disponible(bd);
                combate.setPuedeUsarEscudo(tieneEscudo() != null);
                if (combate.isPuedeUsarEscudo()) {
                    combate.setEscudo(tieneEscudo());
                }
                DefaultListModel jdlm = (DefaultListModel) jList_armas.getModel();
                Arma a = (Arma) jdlm.getElementAt(jList_armas.getSelectedIndex());
                combate.setArmaUsada(a);
                combate.setBo(token.getBo(a.getEstilo()));
                fullDesc += "Ataca con\n" + a.toString();
                fullDesc += "\n" + jTextField_Bo.getText() + " / " + jTextField8.getText();
                fullDesc += "\n" + jTextArea_desc.getText();
                break;
            }
            case TIPO_ACCION_DESPLAZAMIENTO: {
                acc = new Accion(tipoAcion, principal.getAsaltoActual(), orden);

                if (jRadioButton_caminar.isSelected()) {
                    fullDesc += "Camina ";
                }
                if (jRadioButton_trotar.isSelected()) {
                    fullDesc += "Trota ";
                }
                if (jRadioButton_correr.isSelected()) {
                    fullDesc += "Corre ";
                }
                fullDesc += jSpinner_distancia_desplazamiento.getValue() + " mts";
                fullDesc += jTextArea_desc.getText();
                break;
            }
            case TIPO_ACCION_MOVIMIENTO_ESTATICO: {
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
        acc.setCombate(combate);
        accionSeleccionada = acc;
        if (accionSeleccionada != null) {
            acc.setFullDescp(fullDesc);
            acc.setDescp(jTextArea_desc.getText());

            token_accion.AccionDefinidaEnEsteAsalto();
            salvarAccionConfig(tipoAcion);
            this.dispose();
        }
    }

    private void salvarAccionConfig(int tipoAcion) {

        AccionConfig ac = new AccionConfig();
        switch (tipoAcion) {
            case TIPO_ACCION_SIN_ACCION: {

                break;
            }
            case TIPO_ACCION_CARGA_SORTILEGIO: {
                Sortilegio sort_intencion = (Sortilegio) jComboBox_sotilegios.getSelectedItem();

                break;
            }
            case TIPO_ACCION_REALIZA_SORTILEGIO: {

                break;
            }
            case TIPO_ACCION_DISPARA_PROYECTIL: {
                ac.setProySeleccionado((Arma) jComboBoxArmas_Proy.getSelectedItem());
                ac.setBlanco((Token) jComboBoxEnemigos1.getSelectedItem());
                break;
            }
            case TIPO_ACCION_CARGA_PROYECTIL: {
                ac.setProySeleccionado((Arma) jComboBoxArmas_Proy1.getSelectedItem());
                break;
            }
            case TIPO_ACCION_PARAR_PROYECTIL: {

                break;
            }
            case TIPO_ACCION_MOVIMIENTO_Y_MANIOBRA: {

                if (jRadioButton_rutina.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_RUTINA);
                }
                if (jRadioButton_muyFacil.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_FACIL);
                }
                if (jRadioButton_facil.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_MUY_FACIL);
                }
                if (jRadioButton_media.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_MEDIA);
                }
                if (jRadioButton_dificil.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_DIFICIL);
                }
                if (jRadioButton_muydificil.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_MUY_DIFICIL);
                }
                if (jRadioButton_extDificil.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_EXT_DIFICIL);
                }
                if (jRadioButton_locura.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_LOCURA);
                }
                if (jRadioButton_absurdo.isSelected()) {
                    ac.setDificultadManiobra(DIFICULTAD_ABSURDO);
                }
                ac.setBonoExtra((Integer) jSpinner_bono_mm.getValue());
                break;
            }
            case TIPO_ACCION_ATAQUE_CUERPO_A_CUERPO: {

                break;
            }
            case TIPO_ACCION_DESPLAZAMIENTO: {

                if (jRadioButton_caminar.isSelected()) {
                    ac.setRitmo(0);
                }
                if (jRadioButton_trotar.isSelected()) {
                    ac.setRitmo(1);
                }
                if (jRadioButton_correr.isSelected()) {
                    ac.setRitmo(2);
                }
                ac.setDistancia((Integer) jSpinner_distancia_desplazamiento.getValue());
                break;
            }
            case TIPO_ACCION_MOVIMIENTO_ESTATICO: {
                break;
            }

        }
        ac.setDesc(jTextArea_desc.getText());
        token_accion.setAccionConfig(ac);
    }

    private Arma tieneEscudo() {
        Arma esc = null;
        if (!jList_escudos.isSelectionEmpty()) {
            DefaultListModel jdlm = (DefaultListModel) jList_escudos.getModel();
            Arma a = (Arma) jdlm.getElementAt(jList_escudos.getSelectedIndex());
            if (a.getClase() == CLASE_ESCUDO) {
                esc = a;
            }
        }

        return esc;

    }

    private void moverBo() {
        Token tok = token_accion.getToken();
        jTextField_Bo.setText("BO " + jSlider_Bo.getValue());
        int paraLaBd = jSlider_Bo.getMaximum() - jSlider_Bo.getValue();
        Arma esc = tieneEscudo();
        if (esc != null) {
            paraLaBd += esc.getBono();
        }
        /*
        
         */
        jTextField8.setText("BD " + (tok.getHabilidades().getBd() + paraLaBd));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup_tipo_desplazamiento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_crearSortilegio_Carga;
    private javax.swing.JButton jButton_crearSortilegio_Carga1;
    private javax.swing.JButton jButton_crearSortilegio_Carga2;
    private javax.swing.JButton jButton_crearSortilegio_Carga3;
    private javax.swing.JCheckBox jCheckBox_consume_sort_carga;
    private javax.swing.JCheckBox jCheckBox_consume_sort_realiza;
    private javax.swing.JComboBox jComboBoxArmas_Proy;
    private javax.swing.JComboBox jComboBoxArmas_Proy1;
    private javax.swing.JComboBox jComboBoxEnemigos1;
    private javax.swing.JComboBox<String> jComboBox_Lista_sotilegios;
    private javax.swing.JComboBox<String> jComboBox_Lista_sotilegios_realiza;
    private javax.swing.JComboBox<String> jComboBox_sotilegios;
    private javax.swing.JComboBox<String> jComboBox_sotilegios_Realiza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_avatar;
    private javax.swing.JLabel jLabel_distancia1;
    private javax.swing.JLabel jLabel_distancia2;
    private javax.swing.JLabel jLabel_distancia3;
    private javax.swing.JLabel jLabel_distancia4;
    private javax.swing.JLabel jLabel_icono_armas;
    private javax.swing.JLabel jLabel_icono_escudo;
    private javax.swing.JList<String> jList_armas;
    private javax.swing.JList<String> jList_escudos;
    private javax.swing.JList<String> jList_extremidades;
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
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
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
    private javax.swing.JPanel jPanel_armas;
    private javax.swing.JPanel jPanel_brazo_derecho;
    private javax.swing.JPanel jPanel_brazo_izquierdo;
    private javax.swing.JPanel jPanel_brazos;
    private javax.swing.JPanel jPanel_carga_sort_datos_Cargado;
    private javax.swing.JPanel jPanel_carga_sort_datos_Cargado1;
    private javax.swing.JPanel jPanel_carga_sort_datos_Realiza;
    private javax.swing.JPanel jPanel_carga_sort_nombre_Realiza;
    private javax.swing.JPanel jPanel_carga_sort_nombre_carga;
    private javax.swing.JPanel jPanel_desc_Accion;
    private javax.swing.JPanel jPanel_distancia;
    private javax.swing.JPanel jPanel_distancia1;
    private javax.swing.JPanel jPanel_distancia2;
    private javax.swing.JPanel jPanel_distancia3;
    private javax.swing.JRadioButton jRadioButton_absurdo;
    private javax.swing.JRadioButton jRadioButton_caminar;
    private javax.swing.JRadioButton jRadioButton_correr;
    private javax.swing.JRadioButton jRadioButton_dificil;
    private javax.swing.JRadioButton jRadioButton_extDificil;
    private javax.swing.JRadioButton jRadioButton_facil;
    private javax.swing.JRadioButton jRadioButton_locura;
    private javax.swing.JRadioButton jRadioButton_media;
    private javax.swing.JRadioButton jRadioButton_muyFacil;
    private javax.swing.JRadioButton jRadioButton_muydificil;
    private javax.swing.JRadioButton jRadioButton_rutina;
    private javax.swing.JRadioButton jRadioButton_trotar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSlider jSlider_Bo;
    private javax.swing.JSpinner jSpinner_Cambios;
    private javax.swing.JSpinner jSpinner_bono_mm;
    private javax.swing.JSpinner jSpinner_distancia1;
    private javax.swing.JSpinner jSpinner_distanciaCaC;
    private javax.swing.JSpinner jSpinner_distancia_desplazamiento;
    private javax.swing.JTabbedPane jTabbedPane_SeleccionAccion;
    private javax.swing.JTextArea jTextArea_desc;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextField_Bo;
    private javax.swing.JTextField jTextField_Bono_Distancia;
    private javax.swing.JTextField jTextField_Dominio_sort_carga;
    private javax.swing.JTextField jTextField_Dominio_sort_realiza;
    private javax.swing.JTextField jTextField_PPActual_carga;
    private javax.swing.JTextField jTextField_PPActual_ls_realiza;
    private javax.swing.JTextField jTextField_alcance_sort_carga;
    private javax.swing.JTextField jTextField_alcance_sort_realiza;
    private javax.swing.JTextField jTextField_area_sort_carga;
    private javax.swing.JTextField jTextField_area_sort_realiza;
    private javax.swing.JTextField jTextField_bono_mm;
    private javax.swing.JTextField jTextField_duracion_sort_carga;
    private javax.swing.JTextField jTextField_duracion_sort_realiza;
    private javax.swing.JTextField jTextField_lv_sort_carga;
    private javax.swing.JTextField jTextField_lv_sort_realiza;
    private javax.swing.JTextField jTextField_maximo;
    private javax.swing.JTextField jTextField_mmActual;
    private javax.swing.JTextField jTextField_mmActual_mm;
    private javax.swing.JTextField jTextField_name;
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
    private HashMap<Extremidad, Arma> hm_extremidades = new HashMap<>();

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
        DefaultListModel jdlm = (DefaultListModel) jList_armas.getModel();
        int arm_sel = jList_armas.getSelectedIndex();
        if (arm_sel > -1) {

            Arma a = (Arma) jdlm.getElementAt(arm_sel);

            if (a != null) {

                int actual = token_accion.getToken().boDisponible(a.getEstilo());
                //jSlider_Bo.setMaximum(actual);
                int cambios = ((Integer) jSpinner_Cambios.getValue());
                actual = actual + (cambios * -30);
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
                jSlider_Bo.setValue(actual);
            }
        }

    }

    private void mostrarLista(ListaDeSortilegios lds) {
        HashMap<Integer, Sortilegio> li = lds.getLista();
        ArrayList<Sortilegio> listaFinal = new ArrayList<>();
        jComboBox_sotilegios.removeAllItems();
        jComboBox_sotilegios_Realiza.removeAllItems();
        if (lds.getId() != -1) {
            int maxLevel = token_accion.getToken().getHabilidades().getHm_listasDeSortilegios().get(lds.getId());
            for (Map.Entry<Integer, Sortilegio> entry : li.entrySet()) {

                Sortilegio value = entry.getValue();
                if (value.getLv() <= maxLevel) {
                    listaFinal.add(value);
                }
            }
            jComboBox_sotilegios.setModel(new DefaultComboBoxModel(listaFinal.toArray()));
            jComboBox_sotilegios_Realiza.setModel(new DefaultComboBoxModel(listaFinal.toArray()));
        } else {
            jComboBox_sotilegios.removeAllItems();
            jComboBox_sotilegios_Realiza.removeAllItems();
        }
    }

    private void limitardesplazamiento() {

        int mm = token_accion.getToken().getMmActual();
        int maximo = 15;
        int pasos = mm / 5;
        int paso = (mm < 0) ? 1 : -1;
        for (int i = 0; pasos != 0; i++) {
            maximo += (((pasos > 3 || pasos < -3) ? 1 : 3) * (paso * -1));
            pasos += paso;
        }
        if (maximo > 30) {
            maximo = 30;
        }
        if (maximo < 1) {
            maximo = 1;
        }
        if (jRadioButton_trotar.isSelected()) {
            maximo *= 1.5;
        }
        if (jRadioButton_correr.isSelected()) {
            maximo *= 2;
        }
        jSpinner_distancia_desplazamiento.setModel(new SpinnerNumberModel(maximo, 1, maximo, 1));

        jTextField_maximo.setText("max: " + maximo);
    }

    private void cargarListaDeSortilegio() {
        ListaDeSortilegios lds = ElejirListaSortilegio.NuevaListaDeSortilegios(null, true);
        if (lds != null) {
            token_accion.getToken().aprenderListaDeSortilegio(lds.getId(), 50);
            jComboBox_Lista_sotilegios.setModel(new DefaultComboBoxModel(token_accion.getToken().getListasDeSortilegios().toArray()));
            jComboBox_Lista_sotilegios.setSelectedIndex(jComboBox_Lista_sotilegios.getComponentCount() - 1);
            jComboBox_Lista_sotilegios_realiza.setModel(new DefaultComboBoxModel(token_accion.getToken().getListasDeSortilegios().toArray()));
            jComboBox_Lista_sotilegios_realiza.setSelectedIndex(jComboBox_Lista_sotilegios.getComponentCount() - 1);
        }
    }

}
