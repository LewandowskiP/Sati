/* 
 * Copyright 2018 Cafe Sati Polska.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Listeners;

import Frames.Panels.SelectAromaPanel;
import Frames.Panels.SelectCoffeeGreenPanel;
import Frames.Panels.SelectDirectPackagePanel;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Przemysław
 */
public class CheckBoxDirectPackageRaport implements TableModelListener {

    private int add_column;
    private int del_column;

    public CheckBoxDirectPackageRaport(int add_col, int del_col) {
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
                SelectDirectPackagePanel sdpp = new SelectDirectPackagePanel();
                String[] options = {"Wybierz", "Odrzuć"};
                int result = JOptionPane.showOptionDialog(null, sdpp, "Wybierz surowiec.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (JOptionPane.OK_OPTION == result) {
                    String s = sdpp.getSelectedDirectPackage().getLabId();
                    model.setValueAt(s, row, 0);
                    model.setValueAt(sdpp.getSelectedDirectPackage().getDirectPackageType(), row, 1);
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
