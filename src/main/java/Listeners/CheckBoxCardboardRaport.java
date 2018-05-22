/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Frames.Panels.SelectAromaPanel;
import Frames.Panels.SelectCardboardPanel;
import Frames.Panels.SelectCoffeeGreenPanel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Przemysław
 */
public class CheckBoxCardboardRaport implements TableModelListener {

    private int add_column;
    private int del_column;

    public CheckBoxCardboardRaport(int add_col, int del_col) {
        super();
        add_column = add_col;
        del_column = del_col;
    }

    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        if (column == add_column) {
            DefaultTableModel model = (DefaultTableModel) e.getSource();
            Boolean checked = (Boolean) model.getValueAt(row, column);
            if (checked) {
                SelectCardboardPanel scp = new SelectCardboardPanel();
                String[] options = {"Wybierz", "Odrzuć"};
                int result = JOptionPane.showOptionDialog(null, scp, "Wybierz karton.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (JOptionPane.OK_OPTION == result) {
                    String s = scp.getSelectedCardboard().getLabId();
                    model.setValueAt(s, row, 0);
                    model.setValueAt(scp.getSelectedCardboard().getCardboardType(), row, 1);
                    model.addRow(new Object[]{null, null, false, false});
                }
                model.setValueAt(false, row, column);
            }
        }

        if (column == del_column) {
            DefaultTableModel model = (DefaultTableModel) e.getSource();
            Boolean checked = (Boolean) model.getValueAt(row, column);
            if (checked) {
                int rowCount = model.getRowCount();
                if (model.getValueAt(row, 0) != null) {
                    rowCount--;
                }
                model.removeRow(row);
                model.setRowCount(rowCount);
            }
        }
    }
}
