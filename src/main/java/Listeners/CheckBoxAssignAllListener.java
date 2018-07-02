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
