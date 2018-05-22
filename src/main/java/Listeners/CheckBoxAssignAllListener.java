/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Przemysław
 */
public class CheckBoxAssignAllListener implements TableModelListener {

    private int boolean_column;

    public CheckBoxAssignAllListener(int bool_col) {
        super();
        boolean_column = bool_col;
    }

    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        if (column == boolean_column) {
            TableModel model = (TableModel) e.getSource();
            String columnName = model.getColumnName(column);
            Boolean checked = (Boolean) model.getValueAt(row, column);
            if (checked) {
                model.setValueAt(model.getValueAt(row, column - 2), row, column - 1);
                model.setValueAt(false, row, column);
            }
        }
    }
}
