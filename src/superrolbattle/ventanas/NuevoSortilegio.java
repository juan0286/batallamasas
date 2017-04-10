/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.ListaDeSortilegios;
import instancias.Sortilegio;
import instancias.Sortilegios.AlcanceSortilegio;
import instancias.Sortilegios.AreaDeEfectoSortilegio;
import instancias.Sortilegios.DuracionSortilegio;
import instancias.Token;
import instancias.properties.alteracion.Alteracion;
import instancias.properties.alteracion.Efecto;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import superrolbattle.Principal;

/**
 *
 * @author TiranoJuan
 */
public class NuevoSortilegio extends javax.swing.JDialog {

    /**
     * Creates new form NuevoSortilegio
     */
    public NuevoSortilegio(java.awt.Frame parent, boolean modal, Token token) {
        super(parent, modal);
        initComponents();
        this.token = token;
        jComboBox_todosLosSortilegios.setModel(new DefaultComboBoxModel(Principal.getTodosLosSortilegios().toArray()));
        this.setTitle("Nuevo Sortilegio para " + token.getNombre());
    }

    public NuevoSortilegio(java.awt.Frame parent, boolean modal, ListaDeSortilegios list) {
        super(parent, modal);
        initComponents();
        lista = list;
        jComboBox_todosLosSortilegios.setModel(new DefaultComboBoxModel(list.getLista().values().toArray()));
        jComboBox_dominio.setSelectedIndex(list.getDominio());
        jComboBox_dominio.setEnabled(false);
        jCheckBox_consume.setSelected(true);
        jCheckBox_consume.setEnabled(false);
        jButtonAprender.setEnabled(false);
        this.setTitle("Nuevo Sortilegio para " + list.getNombre());
        
        
        jSpinner_lv.setValue(list.maxLvSortilegio() + 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox_todosLosSortilegios = new javax.swing.JComboBox<>();
        jButton_copiar = new javax.swing.JButton();
        jButtonAprender = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSpinner_lv = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox_clase = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox_dominio = new javax.swing.JComboBox<>();
        jCheckBox_consume = new javax.swing.JCheckBox();
        jPanel_cont_area = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSpinner_unidad_area = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jComboBox_multiplicador_area = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField_area_desc = new javax.swing.JTextField();
        jPanel_cont_duracion = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner_unidad_duracion = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jComboBox_tipo_Diracion = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_mult_duracion = new javax.swing.JComboBox<>();
        jPanel_cont_alcance = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jSpinner_unidad_Alcance = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jComboBox_tipo_Alcance = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_mult_Alcance = new javax.swing.JComboBox<>();
        jPanel_Alteracion = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jTextField_efectos = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_desc = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jButton_guardar_sortilegio = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Copiar de"));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jComboBox_todosLosSortilegios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel4.add(jComboBox_todosLosSortilegios);

        jButton_copiar.setText("Copiar");
        jButton_copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_copiarActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_copiar);

        jButtonAprender.setText("Aprender");
        jButtonAprender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAprenderActionPerformed(evt);
            }
        });
        jPanel4.add(jButtonAprender);

        jPanel5.add(jPanel4);

        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1);

        jTextField_Nombre.setMinimumSize(new java.awt.Dimension(6, 130));
        jTextField_Nombre.setPreferredSize(new java.awt.Dimension(230, 20));
        jPanel1.add(jTextField_Nombre);

        jLabel2.setText("Lv");
        jPanel1.add(jLabel2);

        jSpinner_lv.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        jPanel1.add(jSpinner_lv);

        jPanel7.add(jPanel1);

        jLabel3.setText("Clase");
        jPanel2.add(jLabel3);

        jComboBox_clase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elemental", "Elemental Bola", "Elemental Dirigido", "Fuerza", "Pasivo", "Utilidad", "Informacion" }));
        jPanel2.add(jComboBox_clase);

        jLabel4.setText("Dominio");
        jPanel2.add(jLabel4);

        jComboBox_dominio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Canalizacion", "Escencia", "Mentalismo" }));
        jPanel2.add(jComboBox_dominio);

        jCheckBox_consume.setText("Consume PP");
        jPanel2.add(jCheckBox_consume);

        jPanel7.add(jPanel2);

        jPanel_cont_area.setBorder(javax.swing.BorderFactory.createTitledBorder("Area"));

        jLabel11.setText("Unidad");
        jPanel_cont_area.add(jLabel11);

        jSpinner_unidad_area.setModel(new javax.swing.SpinnerNumberModel(0.0f, 0.0f, null, 0.5f));
        jSpinner_unidad_area.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel_cont_area.add(jSpinner_unidad_area);

        jLabel10.setText("Multiplicador");
        jPanel_cont_area.add(jLabel10);

        jComboBox_multiplicador_area.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fijo", "Nivel" }));
        jPanel_cont_area.add(jComboBox_multiplicador_area);

        jLabel9.setText("Descp");
        jPanel_cont_area.add(jLabel9);

        jTextField_area_desc.setMinimumSize(new java.awt.Dimension(56, 20));
        jTextField_area_desc.setPreferredSize(new java.awt.Dimension(56, 20));
        jPanel_cont_area.add(jTextField_area_desc);

        jPanel7.add(jPanel_cont_area);

        jPanel_cont_duracion.setBorder(javax.swing.BorderFactory.createTitledBorder("Duracion"));

        jLabel7.setText("Unidad");
        jPanel_cont_duracion.add(jLabel7);

        jSpinner_unidad_duracion.setEnabled(false);
        jSpinner_unidad_duracion.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel_cont_duracion.add(jSpinner_unidad_duracion);

        jLabel5.setText("Tipo");
        jPanel_cont_duracion.add(jLabel5);

        jComboBox_tipo_Diracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Instantaneo", "Concentrado", "Asaltos", "Minutos", "Horas", "Dias", "Semanas", "Permanente", "Varia" }));
        jComboBox_tipo_Diracion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_tipo_DiracionItemStateChanged(evt);
            }
        });
        jPanel_cont_duracion.add(jComboBox_tipo_Diracion);

        jLabel8.setText("Multiplicador");
        jPanel_cont_duracion.add(jLabel8);

        jComboBox_mult_duracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fijo", "Nivel", "5 de Fallo TR", "10 de Fallo TR" }));
        jComboBox_mult_duracion.setEnabled(false);
        jPanel_cont_duracion.add(jComboBox_mult_duracion);

        jPanel7.add(jPanel_cont_duracion);

        jPanel_cont_alcance.setBorder(javax.swing.BorderFactory.createTitledBorder("Alcance"));

        jLabel13.setText("Unidad");
        jPanel_cont_alcance.add(jLabel13);

        jSpinner_unidad_Alcance.setEnabled(false);
        jSpinner_unidad_Alcance.setPreferredSize(new java.awt.Dimension(45, 20));
        jPanel_cont_alcance.add(jSpinner_unidad_Alcance);

        jLabel6.setText("Tipo");
        jPanel_cont_alcance.add(jLabel6);

        jComboBox_tipo_Alcance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Uno Mismo", "Contacto", "Cm", "Metros", "Varia" }));
        jComboBox_tipo_Alcance.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox_tipo_AlcanceItemStateChanged(evt);
            }
        });
        jPanel_cont_alcance.add(jComboBox_tipo_Alcance);

        jLabel12.setText("Multiplicador");
        jPanel_cont_alcance.add(jLabel12);

        jComboBox_mult_Alcance.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fijo", "Nivel" }));
        jComboBox_mult_Alcance.setEnabled(false);
        jPanel_cont_alcance.add(jComboBox_mult_Alcance);

        jPanel7.add(jPanel_cont_alcance);

        jPanel_Alteracion.setBorder(javax.swing.BorderFactory.createTitledBorder("Alteracion"));

        jButton1.setText("Agregar Efectos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel_Alteracion.add(jButton1);

        jTextField_efectos.setEditable(false);
        jTextField_efectos.setMinimumSize(new java.awt.Dimension(206, 20));
        jTextField_efectos.setPreferredSize(new java.awt.Dimension(246, 20));
        jPanel_Alteracion.add(jTextField_efectos);

        jPanel7.add(jPanel_Alteracion);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripcion"));
        jPanel3.setMaximumSize(new java.awt.Dimension(32779, 86));
        jPanel3.setPreferredSize(new java.awt.Dimension(178, 86));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(32767, 54));

        jTextArea_desc.setColumns(20);
        jTextArea_desc.setLineWrap(true);
        jTextArea_desc.setRows(5);
        jTextArea_desc.setMaximumSize(new java.awt.Dimension(2147483647, 84));
        jTextArea_desc.setName(""); // NOI18N
        jTextArea_desc.setPreferredSize(new java.awt.Dimension(164, 84));
        jScrollPane1.setViewportView(jTextArea_desc);

        jPanel3.add(jScrollPane1);

        jPanel7.add(jPanel3);

        jPanel5.add(jPanel7);

        getContentPane().add(jPanel5);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton_guardar_sortilegio.setText("Guardar Nuevo");
        jButton_guardar_sortilegio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_guardar_sortilegioActionPerformed(evt);
            }
        });
        jPanel6.add(jButton_guardar_sortilegio);

        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });
        jPanel6.add(jButton_cancelar);

        getContentPane().add(jPanel6);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_copiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_copiarActionPerformed
        copiarSortilegio();
    }//GEN-LAST:event_jButton_copiarActionPerformed

    private void jButton_guardar_sortilegioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_guardar_sortilegioActionPerformed

        if (token != null) {
            asignarSortilegioAToken();
        }
        if (lista != null) {
            asignarSortilegioALista();
        }
    }//GEN-LAST:event_jButton_guardar_sortilegioActionPerformed

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        sortilegioNuevo = -1;
        this.dispose();
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButtonAprenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAprenderActionPerformed
        int s = jComboBox_todosLosSortilegios.getSelectedIndex();
        if (!token.conoceSortilegio(s)) {
            sortilegioNuevo = s;
            this.dispose();
        } else {
            recursos.Recursos.informar(token.getNombre() + " ya conoce este Sortilegio");
        }

    }//GEN-LAST:event_jButtonAprenderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        agregarEfecto();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox_tipo_DiracionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_tipo_DiracionItemStateChanged
        int sel = jComboBox_tipo_Diracion.getSelectedIndex();
        if (sel <= DuracionSortilegio.TIPO_DURACION_CONCENTRACION || sel >= DuracionSortilegio.TIPO_DURACION_PERMANENTE) {
            jComboBox_mult_duracion.setEnabled(false);
            jSpinner_unidad_duracion.setEnabled(false);
        } else {
            jComboBox_mult_duracion.setEnabled(true);
            jSpinner_unidad_duracion.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox_tipo_DiracionItemStateChanged

    private void jComboBox_tipo_AlcanceItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox_tipo_AlcanceItemStateChanged
        int sel = jComboBox_tipo_Alcance.getSelectedIndex();
        if (sel <= AlcanceSortilegio.TIPO_ALCANCE_CONTACTO || sel >= DuracionSortilegio.TIPO_DURACION_VARIA) {
            jComboBox_mult_Alcance.setEnabled(false);
            jSpinner_unidad_Alcance.setEnabled(false);
        } else {
            jComboBox_mult_Alcance.setEnabled(true);
            jSpinner_unidad_Alcance.setEnabled(true);
        }
    }//GEN-LAST:event_jComboBox_tipo_AlcanceItemStateChanged

    private void asignarSortilegioAToken() {
        Sortilegio s = new Sortilegio();
        s.setNombre(jTextField_Nombre.getText());
        s.setLv((Integer) jSpinner_lv.getValue());
        s.setClase(jComboBox_clase.getSelectedIndex());
        s.setDominio(jComboBox_dominio.getSelectedIndex());
        AlcanceSortilegio alc = new AlcanceSortilegio();
        alc.setMultiplicador(jComboBox_mult_Alcance.getSelectedIndex());
        alc.setUnidad((Integer) jSpinner_unidad_Alcance.getValue());
        alc.setTipo_alcance(jComboBox_tipo_Alcance.getSelectedIndex());

        DuracionSortilegio dur = new DuracionSortilegio();
        dur.setMultiplicador(jComboBox_mult_duracion.getSelectedIndex());
        dur.setUnidad((Integer) jSpinner_unidad_duracion.getValue());
        dur.setTipo_duracion(jComboBox_tipo_Diracion.getSelectedIndex());

        AreaDeEfectoSortilegio ade = new AreaDeEfectoSortilegio();
        ade.setMultiplicador(jComboBox_multiplicador_area.getSelectedIndex());
        ade.setUnidad((Float) jSpinner_unidad_area.getValue());
        ade.setDescp(jTextField_area_desc.getText());
        s.setDescp(jTextArea_desc.getText());
        s.setConsumePP(jCheckBox_consume.isSelected());

        s.setAlcance(alc);
        s.setDuracion(dur);
        s.setAreaDeEfecto(ade);

        int ind_ns = Principal.crearSortilegioNuevo(s);
        if (token != null) {
            token.aprenderSortilegio(ind_ns);
        }
        this.dispose();

    }

    private void asignarSortilegioALista() {
        Sortilegio s = new Sortilegio();
        s.setNombre(jTextField_Nombre.getText());
        s.setLv((Integer) jSpinner_lv.getValue());
        s.setClase(jComboBox_clase.getSelectedIndex());
        s.setDominio(lista.getDominio());
        AlcanceSortilegio alc = new AlcanceSortilegio();
        alc.setMultiplicador(jComboBox_mult_Alcance.getSelectedIndex());
        alc.setUnidad((Integer) jSpinner_unidad_Alcance.getValue());
        alc.setTipo_alcance(jComboBox_tipo_Alcance.getSelectedIndex());

        DuracionSortilegio dur = new DuracionSortilegio();
        dur.setMultiplicador(jComboBox_mult_duracion.getSelectedIndex());
        dur.setUnidad((Integer) jSpinner_unidad_duracion.getValue());
        dur.setTipo_duracion(jComboBox_tipo_Diracion.getSelectedIndex());

        AreaDeEfectoSortilegio ade = new AreaDeEfectoSortilegio();
        ade.setMultiplicador(jComboBox_multiplicador_area.getSelectedIndex());
        ade.setUnidad((Float) jSpinner_unidad_area.getValue());
        ade.setDescp(jTextField_area_desc.getText());

        s.setAlcance(alc);
        s.setDuracion(dur);
        s.setAreaDeEfecto(ade);

        //s.setAlcance_string(jTextField_alcance.getText());
        s.setDescp(jTextArea_desc.getText());
        s.setConsumePP(jCheckBox_consume.isSelected());
        s.setLista(lista.getId());
        if (lista.contineSortilegiodeLv(s.getLv())) {
            int r = JOptionPane.showConfirmDialog(null, "Esta lista ya contiene el sortilegio " + lista.getLista().get(s.getLv()).getNombre() + " con este Lv. Desea Reemplazarlo?");
            if (r == JOptionPane.OK_OPTION) {
                lista.agregarSortilegio(s);
                sortilegioNuevo = s.getLv();
                this.dispose();
            }
        } else {
            lista.agregarSortilegio(s);
            sortilegioNuevo = s.getLv();
            this.dispose();
        }

    }

    private void copiarSortilegio() {

        Sortilegio s = (Sortilegio) jComboBox_todosLosSortilegios.getSelectedItem();
        jTextArea_desc.setText(s.getDescp());
        jTextField_Nombre.setText(s.getNombre());
        jCheckBox_consume.setSelected(s.isConsumePP());
        jComboBox_dominio.setSelectedIndex(s.getDominio());
        jComboBox_clase.setSelectedIndex(s.getClase());

        jComboBox_mult_Alcance.setSelectedIndex(s.getAlcance().getMultiplicador());
        jSpinner_unidad_Alcance.setValue(s.getAlcance().getUnidad());
        jComboBox_tipo_Alcance.setSelectedIndex(s.getAlcance().getTipo_alcance());

        jComboBox_mult_duracion.setSelectedIndex(s.getDuracion().getMultiplicador());
        jSpinner_unidad_duracion.setValue(s.getDuracion().getUnidad());
        jComboBox_tipo_Diracion.setSelectedIndex(s.getDuracion().getTipo_duracion());

        jComboBox_multiplicador_area.setSelectedIndex(s.getAreaDeEfecto().getMultiplicador());
        jSpinner_unidad_area.setValue(s.getAreaDeEfecto().getUnidad());
        jTextField_area_desc.setText(s.getAreaDeEfecto().getDescp());

        //jSpinner_lv.setValue(s.getLv());
        //jTextField_alcance.setText(s.getAlcance_string());
        if (s.getEfectoMagico() != null) {
            alt = s.getEfectoMagico();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAprender;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_copiar;
    private javax.swing.JButton jButton_guardar_sortilegio;
    private javax.swing.JCheckBox jCheckBox_consume;
    private javax.swing.JComboBox<String> jComboBox_clase;
    private javax.swing.JComboBox<String> jComboBox_dominio;
    private javax.swing.JComboBox<String> jComboBox_mult_Alcance;
    private javax.swing.JComboBox<String> jComboBox_mult_duracion;
    private javax.swing.JComboBox<String> jComboBox_multiplicador_area;
    private javax.swing.JComboBox<String> jComboBox_tipo_Alcance;
    private javax.swing.JComboBox<String> jComboBox_tipo_Diracion;
    private javax.swing.JComboBox<String> jComboBox_todosLosSortilegios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel_Alteracion;
    private javax.swing.JPanel jPanel_cont_alcance;
    private javax.swing.JPanel jPanel_cont_area;
    private javax.swing.JPanel jPanel_cont_duracion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_lv;
    private javax.swing.JSpinner jSpinner_unidad_Alcance;
    private javax.swing.JSpinner jSpinner_unidad_area;
    private javax.swing.JSpinner jSpinner_unidad_duracion;
    private javax.swing.JTextArea jTextArea_desc;
    private javax.swing.JTextField jTextField_Nombre;
    private javax.swing.JTextField jTextField_area_desc;
    private javax.swing.JTextField jTextField_efectos;
    // End of variables declaration//GEN-END:variables

    private Token token;
    private ListaDeSortilegios lista;
    private Alteracion alt = new Alteracion();

    public static int sortilegioNuevo = -1;

    public static int Crear(Principal parent, boolean modal, Token token) {
        NuevoSortilegio ns = new NuevoSortilegio(parent, modal, token);
        ns.setLocationRelativeTo(null);
        ns.setVisible(true);

        return sortilegioNuevo;
    }

    public static int Crear(Principal parent, boolean modal, ListaDeSortilegios list) {
        NuevoSortilegio ns = new NuevoSortilegio(parent, modal, list);
        ns.setLocationRelativeTo(null);
        ns.setVisible(true);
        ns.alt = new Alteracion();
        ns.alt.setActivo(true);
        return sortilegioNuevo;
    }

    private void agregarEfecto() {
        Efecto ef = CrearEfecto.CrearEfecto(null, true);
        if (ef != null) {
            alt.agregarEfecto(ef);
            jTextField_efectos.setText(alt.toString());
        }

    }
}
