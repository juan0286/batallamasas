/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superrolbattle;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Juan
 */
public class ProgresBarCellRenderer  implements TableCellRenderer{
    
 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
   int row, int column) {
 
  // Devolvemos el botón tal cual
  if (value instanceof JProgressBar) {
   return (JProgressBar) value;
  }
 
  return null;
 
 }
}
//
//
//  public class ProgresBarCellRenderer extends JProgressBar implements TableCellRenderer {
//
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            int progress = 0;
//            if (value instanceof Float) {
//                progress = Math.round(((Float) value) * 100f);
//            } else if (value instanceof Integer) {
//                progress = (int) value;
//            }
//            setValue(progress);
//            return this;
//        }
//    }