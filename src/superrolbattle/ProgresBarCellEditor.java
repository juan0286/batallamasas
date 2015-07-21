/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Juan
 */
public class ProgresBarCellEditor extends AbstractCellEditor implements TableCellEditor {
 
 /** Componente que estamos editando. */
 private Component currentValue;
 
 @Override
 public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row, int column) {
 
     JProgressBar barra = null;
 
  if (value instanceof JProgressBar) {
   barra = (JProgressBar) value;
   // Action que permite "limpiar" los valores de una fila  
  }
  barra.setForeground(Color.green);
  barra.setValue(100);
  currentValue = barra;
 
  return barra;
 }
 
 @Override
 public Object getCellEditorValue() {
  return currentValue;
 }
 
}