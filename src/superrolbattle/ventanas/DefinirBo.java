/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle.ventanas;

import instancias.properties.Bo;

/**
 *
 * @author TiranoJuan
 */
public class DefinirBo extends javax.swing.JDialog {

    /**
     * Creates new form DefinirBo
     */
    public DefinirBo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField_bonoo = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_tipo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jButton_aceptar = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Bo");

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setText("Bonifiacion");
        jPanel1.add(jLabel1);
        jPanel1.add(jTextField_bonoo);

        jPanel3.add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout(2, 1));

        jLabel2.setText("Tipo");
        jLabel2.setMaximumSize(new java.awt.Dimension(210, 14));
        jLabel2.setMinimumSize(new java.awt.Dimension(20, 14));
        jPanel2.add(jLabel2);

        jComboBox_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PELEA", "FILO", "CONTUNDENTE", "DOS_MANOS", "ARROJADIZA", "PROYECTILES", "ASTA", "BARRIDO_ARTE_MARCIAL", "GOLPE_ARTE_MARCIAL   ", "COMBO_FILO_FILO", "COMBO_ASTA_FILO" }));
        jPanel2.add(jComboBox_tipo);

        jPanel3.add(jPanel2);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jButton_aceptar.setText("Crear");
        jButton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_aceptarActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_aceptar);

        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });
        jPanel4.add(jButton_cancelar);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_aceptarActionPerformed
        int bono = Integer.parseInt(jTextField_bonoo.getText());
        bocreada = new Bo(jComboBox_tipo.getSelectedIndex(),bono);
        this.dispose();
        
    }//GEN-LAST:event_jButton_aceptarActionPerformed

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DefinirBo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DefinirBo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DefinirBo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DefinirBo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DefinirBo dialog = new DefinirBo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public static Bo bocreada;
    public static Bo crearBo(java.awt.Frame parent, boolean modal) {
        bocreada = new Bo();
        DefinirBo db = new DefinirBo(parent, true);
        db.setLocationRelativeTo(null);
        db.setVisible(true);
        return bocreada;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_aceptar;
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JComboBox<String> jComboBox_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField_bonoo;
    // End of variables declaration//GEN-END:variables
}
