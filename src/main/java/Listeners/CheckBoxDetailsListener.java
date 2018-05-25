/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Frames.Panels.SelectCardboardPanel;
import SatiInterfaces.Details;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemyslaw
 */
public class CheckBoxDetailsListener implements TableModelListener {

    private int colNum;

    public CheckBoxDetailsListener(int colNum) {
        super();
        this.colNum = colNum;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        if (column == colNum) {
            DefaultTableModel model = (DefaultTableModel) e.getSource();
            Boolean checked = (Boolean) model.getValueAt(row, column);
            if (checked) {
                Details details = (Details) model.getValueAt(row, 0);
                details.showDetails();
                model.setValueAt(false, row, column);
            }

        }
    }
}
