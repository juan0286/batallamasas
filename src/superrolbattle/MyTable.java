/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle;

import instancias.Token;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import recursos.Recursos;

/**
 *
 * @author Juan
 */
public class MyTable extends JTable {

    /**
     * Constructor.
     */
    public MyTable(boolean izquierdo) {

        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setRowHeight(30);
        String[] columnNames = new String[]{"Nombre",
            "Estado",
            "Grupo",
            "Vida",
            "Activo",
            "Accion"};

        Vector data2 = Recursos.objetoSoldadosstatic(izquierdo);

        MyTableModel model = new MyTableModel(columnNames, data2);

        // Establecemos el modeloF
        this.setModel(model);

        // Establecemos el renderer y editor que usaremos para el boton
        this.setDefaultRenderer(JButton.class, new ButtonCellRenderer());
        this.setDefaultEditor(JButton.class, new ButtonCellEditor());

        // Editores para cada tipo de objeto, estos nos permitirán darles el comportamiento adecuado
        this.getColumn("Vida").setCellRenderer(new ProgresBarCellRenderer());
        this.getColumn("Vida").setCellEditor(new ProgresBarCellEditor());
        this.setDefaultEditor(JCheckBox.class, new DefaultCellEditor(new JCheckBox()));

    }

    public String getToolTipText(MouseEvent e) {
        String tip = null;
        Token tok = null;
        java.awt.Point p = e.getPoint();
        int rowIndex = rowAtPoint(p);
        int colIndex = columnAtPoint(p);

        try {
            //comment row, exclude heading
            if (rowIndex != 0) {
                tok = (Token) getValueAt(rowIndex, 0);
                if (colIndex == 0) { //Nombre
                    tip = "Nivel = " + tok.getNivel() + "\n"
                            + "Bo = " + tok.getHabilidades().getBo() + "\n"
                            + "Bd = " + tok.getHabilidades().getBd() + "\n"
                            + "Arm = " + tok.getHabilidades().getArmadura() + "\n"
                            + "Brazo Izq = " + ((tok.getManoIZQ().isHabilitado()) ? "Disp" : "N/Disp") + tok.getManoIZQ().getArmaEquipada() + "\n"
                            + "Brazo Der = " + ((tok.getManoDER().isHabilitado()) ? "Disp" : "N/Disp") + tok.getManoDER().getArmaEquipada();

                }
                if (colIndex == 1) {  // Estado
                    tip = tok.getEstado().toString();
                }
                if (colIndex == 2) { // Vida    
                    tip = null;
                }
                if (colIndex == 3) { // Activo
                    tip = null;
                }
                if (colIndex == 4) { // Atacar
                    tip = null;
                }

            }
        } catch (RuntimeException e1) {
            //catch null pointer exception if mouse is over an empty line
        }

        return tip;
    }

}
