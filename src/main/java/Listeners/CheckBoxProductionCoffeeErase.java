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

import ProductionClasses.ProductionCoffee;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import java.util.ArrayList;
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
    ArrayList<ProductionCoffee> alpc;

    public CheckBoxProductionCoffeeErase(ArrayList<ProductionCoffee> alpc) {
        super();
        this.alpc = alpc;
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
                    alpc.remove(pc);
                    int rowCount = model.getRowCount();
                    model.removeRow(row);
                    model.setRowCount(rowCount - 1);
                }
            }

        }

    }
}
