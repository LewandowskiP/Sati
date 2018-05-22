/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import ProductionClasses.ProductionCoffee;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemysław
 */
public class CheckBoxProductionCoffeeErase implements TableModelListener {

    private final int erase_column = 4;

    public CheckBoxProductionCoffeeErase() {
        super();
    }

    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        if (column == erase_column) {
            DefaultTableModel model = (DefaultTableModel) e.getSource();
            Boolean checked = (Boolean) model.getValueAt(row, column);
            if (checked) {

                String[] options = {"Tak", "Nie"};
                int result = JOptionPane.showOptionDialog(null, "Czy na pewno chcesz usunąć kawę?", "Uwaga", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (JOptionPane.OK_OPTION == result) {
                    ProductionCoffee pc = (ProductionCoffee) model.getValueAt(row, 0);
                    pc.setState(Global.PRODUCTION_COFFEE_OUT_OF_STORE);
                    DataBaseConnector dbc = Global.getDataBaseConnector();
                    dbc.openSession();
                    dbc.saveObject(pc);
                    int rowCount = model.getRowCount();
                    model.removeRow(row);
                    model.setRowCount(rowCount);
                }
            }

        }

    }
}
