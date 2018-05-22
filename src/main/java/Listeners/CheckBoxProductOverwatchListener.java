/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Listeners;

import Frames.Panels.SelectAromaPanel;
import Frames.Panels.SelectCoffeeGreenPanel;
import ProductClasses.ProductType;
import ProductionManagement.Global;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Przemysław
 */
public class CheckBoxProductOverwatchListener implements TableModelListener {

    public CheckBoxProductOverwatchListener() {
        super();
    }

    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        DefaultTableModel model = (DefaultTableModel) e.getSource();
        if (model.getRowCount() > 0 && row >= 0 && column >= 0) {
            Boolean checked = (Boolean) model.getValueAt(row, column);
            if (checked) {
                ProductType pt = (ProductType) model.getValueAt(row, 0);
                pt.openFile(Global.FILE_WRITEABLE);
                if (pt.isInstant()) {
                    pt.openFileInstant(Global.FILE_WRITEABLE);
                }
                model.setValueAt(false, row, column);

            }
        }
    }

}
