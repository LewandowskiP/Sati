/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Frames.Panels.SelectAromaPanel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Przemysław
 */
public class CheckBoxAromaRoastRaport implements TableModelListener {

    private final int add_column = 3;
    private final int del_column = 4;

    public CheckBoxAromaRoastRaport() {
        super();
    }

    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        if (column == add_column) {
            TableModel model = (TableModel) e.getSource();
            Boolean checked = (Boolean) model.getValueAt(row, column);
            if (checked) {
                SelectAromaPanel sap = new SelectAromaPanel();
                String[] options = {"Wybierz", "Odrzuć"};
                int result = JOptionPane.showOptionDialog(null, sap, "Wybierz aromat", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (JOptionPane.OK_OPTION == result) {
                    String s = sap.getSelectedAroma().getLabId();
                    model.setValueAt(s, row, 0);
                    model.setValueAt(sap.getSelectedAroma().getAromaType(), row, 1);
                    model.setValueAt(false, row, column);
                } else {
                    model.setValueAt(false, row, column);
                }
            }
        }

        if (column == del_column) {
            DefaultTableModel model = (DefaultTableModel) e.getSource();
            Boolean checked = (Boolean) model.getValueAt(row, column);
            if (checked) {
                int rowCount = model.getRowCount();
                model.removeRow(row);
                model.setRowCount(rowCount);
            }
        }
    }
}
