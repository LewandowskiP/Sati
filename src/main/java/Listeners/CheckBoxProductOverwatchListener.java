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
