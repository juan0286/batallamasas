/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.Dado;
import instancias.properties.Arma;
import instancias.properties.DatosCombate;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author TiranoJuan
 */
public class ResolverAtaques extends javax.swing.JDialog {

    /**
     * Creates new form ResolverAtaques
     */
    public ResolverAtaques(java.awt.Frame parent, boolean modal, JPanelFormToken_Accion jpa, ArrayList<JPanelFormToken_Accion> blancos, int bo, Arma arma) {
        super(parent, modal);
        initComponents();
        this.blancos = blancos;
        this.jpa = jpa;
        this.boDisponible = bo;
        this.arma = arma;
        DefaultListModel jdlm = (DefaultListModel) jList_blancos.getModel();
        for (JPanelFormToken_Accion jpta : blancos) {
            jdlm.addElement(jpta);
        }
        jList_blancos.setModel(jdlm);
        jList_blancos.setSelectedIndex(0);
        jLabel3.setText(jpa.getToken().getNombre() + " utiliza " + arma.getNombre());
        // si existe solo un enemigo, entonces no necesita modificar la bo
        jSlider_Bo.setEnabled(blancos.size() > 1);
        jButton_siguiente.setEnabled(blancos.size() > 1);
        
        actualizaBo();
    }

    private void calcularResultado() {

        Arma a = jpa.getAccion().getCombate().getArmaUsada();
        int bo = jSlider_Bo.getValue();
        int bd = jSlider_Bd.getValue() * -1;

        int sorp = (jCheckBox_sorpresa.isSelected()) ? 20 : 0;
        int fla = (jCheckBox_flanco.isSelected()) ? 15 : 0;
        int esp = (jCheckBox_spalda.isSelected()) ? 30 : 0;
        int esc = (jCheckBox_usaEscudo.isSelected()) ? blanco().getAccion().getCombate().getEscudo().getBono() * -1 : 0;

        int bonoBd = (Integer) jSpinner_bonoBd.getValue() * -1;

        int modsBd = blanco().getToken().getEstado().getModsDeBD() * -1;

        int bonoArma = a.getBono();

        jTextArea_cuentas.setText(null);
        String cuenta = bo + " Bo\n" + bd + " Bd\n";
        if (sorp > 0) {
            cuenta += sorp + " Por Sorpresa\n";
        }
        if (esp > 0) {
            cuenta += esp + " Por Espalda\n";
        }
        if (esc != 0) {
            cuenta += esc + " Por " + blanco().getAccion().getCombate().getEscudo().getNombre() + "\n";
        }
        if (fla > 0) {
            cuenta += fla + " Por Flanco\n";
        }
        if (bonoBd != 0) {
            cuenta += bonoBd + " Bono\n";
        }
        if (modsBd != 0) {
            cuenta += modsBd + " por Modificadores\n";
        }
        if (bonoArma != 0) {
            cuenta += bonoArma + " por " + a.getNombre() + "\n";
        }

        int arm = blanco().getToken().getArmaduraPuesta();

        int dado = (Integer) jSpinner_dado.getValue();
        cuenta += dado + " en Dados\n";
        jTextArea_cuentas.setText(cuenta);

        int rdo = bo + bd + bonoBd + sorp + esp + fla + modsBd + bonoArma + esc + dado;
        String[] rdotxt = recursos.Recursos.darResultadoGolpe(a.getClase(), rdo ,arm);
        String armtxt = recursos.Recursos.armaduraTxt(arm);
        jTextField_Resultado.setText(rdo + "  en  " + armtxt);
        jTextField_hit.setText(rdotxt[0] + rdotxt[1]);
    }

    private JPanelFormToken_Accion blanco() {
        DefaultListModel jdlm = (DefaultListModel) jList_blancos.getModel();
        return (JPanelFormToken_Accion) jdlm.get(jList_blancos.getSelectedIndex());
    }

    private void actualizaBo() {        
        jSlider_Bo.setMaximum(boDisponible);
        jSlider_Bo.setValue(boDisponible);
    }

    private void seleccionarBlanco() {
        DefaultListModel jdlm = (DefaultListModel) jList_blancos.getModel();
        JPanelFormToken_Accion blanco = (JPanelFormToken_Accion) jdlm.get(jList_blancos.getSelectedIndex());
        DatosCombate dc = blanco.getAccion().getCombate();
        jCheckBox_usaEscudo.setEnabled(dc.isPuedeUsarEscudo());
        if (dc.isPuedeUsarEscudo())
            jTextField_bonoEscudo.setText("+" + dc.getEscudo().getBono() + " Bd");
        jSlider_Bd.setValue(dc.getBd_Disponible());
        jSlider_Bd.setMaximum(dc.getBd_Disponible());

    }

    private void cambiarBo() {

        int actual = jpa.getAccion().getCombate().getBo_Disponible();
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
        jSlider_Bo.setValue(actual);

    }

    private void moverBd() {
        jTextField_BdRestante.setText(jSlider_Bd.getValue() + " / " + jSlider_Bd.getMaximum());
    }

    private void moverBo() {
        jTextField_boRestante.setText(jSlider_Bo.getValue() + " / " + jSlider_Bo.getMaximum());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_north = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel_left = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList_blancos = new javax.swing.JList<>();
        jPanel11 = new javax.swing.JPanel();
        jButton_siguiente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jSlider_Bo = new javax.swing.JSlider();
        jTextField_boRestante = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_cuentas = new javax.swing.JTextArea();
        jPanel_right = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_BdRestante = new javax.swing.JTextField();
        jSlider_Bd = new javax.swing.JSlider();
        jPanel7 = new javax.swing.JPanel();
        jCheckBox_usaEscudo = new javax.swing.JCheckBox();
        jTextField_bonoEscudo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jCheckBox_spalda = new javax.swing.JCheckBox();
        jCheckBox_flanco = new javax.swing.JCheckBox();
        jCheckBox_sorpresa = new javax.swing.JCheckBox();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSpinner_bonoBd = new javax.swing.JSpinner();
        jPanel10 = new javax.swing.JPanel();
        jSpinner_dado = new javax.swing.JSpinner();
        jPanel9 = new javax.swing.JPanel();
        jTextField_Resultado = new javax.swing.JTextField();
        jTextField_hit = new javax.swing.JTextField();
        jButton_aplicarDAño = new javax.swing.JButton();
        jButton_aplicarPifia = new javax.swing.JButton();
        jPanel_south = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(369, 438));
        setResizable(false);

        jPanel_north.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel_north.setPreferredSize(new java.awt.Dimension(200, 30));

        jLabel3.setText("NOMBRE del Atacante");
        jPanel_north.add(jLabel3);

        getContentPane().add(jPanel_north, java.awt.BorderLayout.NORTH);

        jPanel_left.setLayout(new javax.swing.BoxLayout(jPanel_left, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel5.setMinimumSize(new java.awt.Dimension(145, 187));
        jPanel5.setPreferredSize(new java.awt.Dimension(145, 187));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        jList_blancos.setModel(new DefaultListModel());
        jList_blancos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList_blancos.setPreferredSize(new java.awt.Dimension(133, 80));
        jList_blancos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_blancosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList_blancos);

        jPanel5.add(jScrollPane1);

        jButton_siguiente.setText("Siguiente Ataque");
        jButton_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_siguienteActionPerformed(evt);
            }
        });
        jPanel11.add(jButton_siguiente);

        jPanel5.add(jPanel11);

        jPanel3.setMinimumSize(new java.awt.Dimension(36, 53));
        jPanel3.setPreferredSize(new java.awt.Dimension(144, 43));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.PAGE_AXIS));

        jSlider_Bo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_BoStateChanged(evt);
            }
        });
        jPanel3.add(jSlider_Bo);

        jTextField_boRestante.setEditable(false);
        jTextField_boRestante.setFont(new java.awt.Font("Tekton Pro Ext", 2, 14)); // NOI18N
        jTextField_boRestante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(jTextField_boRestante);

        jPanel5.add(jPanel3);

        jPanel_left.add(jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(166, 186));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jTextArea_cuentas.setEditable(false);
        jTextArea_cuentas.setColumns(20);
        jTextArea_cuentas.setRows(5);
        jScrollPane2.setViewportView(jTextArea_cuentas);

        jPanel6.add(jScrollPane2);

        jPanel_left.add(jPanel6);

        getContentPane().add(jPanel_left, java.awt.BorderLayout.WEST);

        jPanel_right.setPreferredSize(new java.awt.Dimension(200, 90));
        jPanel_right.setLayout(new javax.swing.BoxLayout(jPanel_right, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel1.setMinimumSize(new java.awt.Dimension(200, 33));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 50));

        jLabel1.setText("BD");
        jPanel1.add(jLabel1);

        jTextField_BdRestante.setEditable(false);
        jTextField_BdRestante.setFont(new java.awt.Font("Tempus Sans ITC", 3, 14)); // NOI18N
        jTextField_BdRestante.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_BdRestante.setPreferredSize(new java.awt.Dimension(106, 20));
        jPanel1.add(jTextField_BdRestante);

        jSlider_Bd.setValue(100);
        jSlider_Bd.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider_BdStateChanged(evt);
            }
        });
        jPanel1.add(jSlider_Bd);

        jPanel7.setMaximumSize(new java.awt.Dimension(2147483647, 27));
        jPanel7.setPreferredSize(new java.awt.Dimension(190, 27));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jCheckBox_usaEscudo.setText("Usa el Escudo");
        jCheckBox_usaEscudo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_usaEscudoItemStateChanged(evt);
            }
        });
        jCheckBox_usaEscudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox_usaEscudoActionPerformed(evt);
            }
        });
        jPanel7.add(jCheckBox_usaEscudo);

        jTextField_bonoEscudo.setEditable(false);
        jTextField_bonoEscudo.setMaximumSize(new java.awt.Dimension(50, 2147483647));
        jPanel7.add(jTextField_bonoEscudo);

        jPanel1.add(jPanel7);

        jPanel_right.add(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Blanco"));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 159));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 130));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel4.setPreferredSize(new java.awt.Dimension(200, 0));
        jPanel4.setLayout(new java.awt.GridLayout(2, 2));

        jCheckBox_spalda.setText("Por la Espalda");
        jCheckBox_spalda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_spaldaItemStateChanged(evt);
            }
        });
        jPanel4.add(jCheckBox_spalda);

        jCheckBox_flanco.setText("Por el Flanco");
        jCheckBox_flanco.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_flancoItemStateChanged(evt);
            }
        });
        jPanel4.add(jCheckBox_flanco);

        jCheckBox_sorpresa.setText("Por Sorpresa");
        jCheckBox_sorpresa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox_sorpresaItemStateChanged(evt);
            }
        });
        jPanel4.add(jCheckBox_sorpresa);

        jPanel8.setPreferredSize(new java.awt.Dimension(87, 34));

        jLabel2.setText("Bono ");
        jPanel8.add(jLabel2);

        jSpinner_bonoBd.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_bonoBd.setMinimumSize(new java.awt.Dimension(45, 20));
        jSpinner_bonoBd.setPreferredSize(new java.awt.Dimension(45, 20));
        jSpinner_bonoBd.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_bonoBdStateChanged(evt);
            }
        });
        jPanel8.add(jSpinner_bonoBd);

        jPanel4.add(jPanel8);

        jPanel2.add(jPanel4);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("DADO"));
        jPanel10.setPreferredSize(new java.awt.Dimension(247, 20));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jSpinner_dado.setFont(new java.awt.Font("Tempus Sans ITC", 1, 14)); // NOI18N
        jSpinner_dado.setModel(new javax.swing.SpinnerNumberModel(0, null, null, 5));
        jSpinner_dado.setPreferredSize(new java.awt.Dimension(69, 35));
        jSpinner_dado.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinner_dadoStateChanged(evt);
            }
        });
        jPanel10.add(jSpinner_dado);

        jPanel2.add(jPanel10);

        jPanel9.setPreferredSize(new java.awt.Dimension(200, 50));

        jTextField_Resultado.setEditable(false);
        jTextField_Resultado.setFont(new java.awt.Font("Tekton Pro Ext", 3, 14)); // NOI18N
        jTextField_Resultado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_Resultado.setText("Resultado");
        jTextField_Resultado.setPreferredSize(new java.awt.Dimension(159, 20));
        jPanel9.add(jTextField_Resultado);

        jTextField_hit.setEditable(false);
        jTextField_hit.setFont(new java.awt.Font("Tekton Pro Ext", 3, 18)); // NOI18N
        jTextField_hit.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField_hit.setText("Daño+Critico");
        jTextField_hit.setPreferredSize(new java.awt.Dimension(159, 40));
        jPanel9.add(jTextField_hit);

        jButton_aplicarDAño.setText("Aplicar DAño");
        jPanel9.add(jButton_aplicarDAño);

        jButton_aplicarPifia.setText("Pifia");
        jPanel9.add(jButton_aplicarPifia);

        jPanel2.add(jPanel9);

        jPanel_right.add(jPanel2);

        getContentPane().add(jPanel_right, java.awt.BorderLayout.CENTER);

        jPanel_south.setPreferredSize(new java.awt.Dimension(200, 30));
        jPanel_south.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton2.setText("Cerrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel_south.add(jButton2);

        getContentPane().add(jPanel_south, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList_blancosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_blancosValueChanged
        seleccionarBlanco();
    }//GEN-LAST:event_jList_blancosValueChanged

    private void jSlider_BdStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_BdStateChanged
        moverBd();
        calcularResultado();
    }//GEN-LAST:event_jSlider_BdStateChanged

    private void jSlider_BoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider_BoStateChanged
        moverBo();
        calcularResultado();
    }//GEN-LAST:event_jSlider_BoStateChanged

    private void jCheckBox_usaEscudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox_usaEscudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox_usaEscudoActionPerformed

    private void jCheckBox_usaEscudoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_usaEscudoItemStateChanged
        calcularResultado();
    }//GEN-LAST:event_jCheckBox_usaEscudoItemStateChanged

    private void jCheckBox_spaldaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_spaldaItemStateChanged
        calcularResultado();
    }//GEN-LAST:event_jCheckBox_spaldaItemStateChanged

    private void jCheckBox_flancoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_flancoItemStateChanged
        calcularResultado();
    }//GEN-LAST:event_jCheckBox_flancoItemStateChanged

    private void jCheckBox_sorpresaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox_sorpresaItemStateChanged
        calcularResultado();
    }//GEN-LAST:event_jCheckBox_sorpresaItemStateChanged

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        if (evt.getClickCount() == 2) {
            Dado d100 = new Dado(100);
            jSpinner_dado.setValue(d100.lanzarAbierta());
        }
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jSpinner_dadoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_dadoStateChanged
        calcularResultado();
    }//GEN-LAST:event_jSpinner_dadoStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jSpinner_bonoBdStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinner_bonoBdStateChanged
       calcularResultado();
    }//GEN-LAST:event_jSpinner_bonoBdStateChanged

    private void jButton_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_siguienteActionPerformed
       
        // arreglar bien
        jButton_siguiente.setEnabled(blancos.size() > 1);
    }//GEN-LAST:event_jButton_siguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_aplicarDAño;
    private javax.swing.JButton jButton_aplicarPifia;
    private javax.swing.JButton jButton_siguiente;
    private javax.swing.JCheckBox jCheckBox_flanco;
    private javax.swing.JCheckBox jCheckBox_sorpresa;
    private javax.swing.JCheckBox jCheckBox_spalda;
    private javax.swing.JCheckBox jCheckBox_usaEscudo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList_blancos;
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
    private javax.swing.JPanel jPanel_left;
    private javax.swing.JPanel jPanel_north;
    private javax.swing.JPanel jPanel_right;
    private javax.swing.JPanel jPanel_south;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider_Bd;
    private javax.swing.JSlider jSlider_Bo;
    private javax.swing.JSpinner jSpinner_bonoBd;
    private javax.swing.JSpinner jSpinner_dado;
    private javax.swing.JTextArea jTextArea_cuentas;
    private javax.swing.JTextField jTextField_BdRestante;
    private javax.swing.JTextField jTextField_Resultado;
    private javax.swing.JTextField jTextField_boRestante;
    private javax.swing.JTextField jTextField_bonoEscudo;
    private javax.swing.JTextField jTextField_hit;
    // End of variables declaration//GEN-END:variables

    JPanelFormToken_Accion jpa;
    ArrayList<JPanelFormToken_Accion> blancos;
    int boDisponible;
    Arma arma;
}
