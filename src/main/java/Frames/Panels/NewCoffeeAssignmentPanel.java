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
package Frames.Panels;

import Listeners.CheckBoxAssignAllListener;
import ProductionClasses.ProductionCoffeeSeek;
import ProductionClasses.ProductionRaportCoffeeAssignment;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Exceptions.NotEnoughtCoffeeException;
import ProductionManagement.Global;
import java.util.HashSet;

/**
 *
 * @author Przemysław
 */
public class NewCoffeeAssignmentPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddProductionCoffeeToProductionRaportPartPanel
     *
     * @param productionRaportPart
     * @param emp
     */
    DataBaseConnector dbc;
    Employee emp;
    ProductionRaportPart productionRaportPart;
    ArrayList<ProductionCoffeeSeek> alpcs;
    DefaultTableModel dtm;

    public NewCoffeeAssignmentPanel(ProductionRaportPart productionRaportPart, Employee emp) {
        initComponents();
        this.emp = emp;
        this.productionRaportPart = productionRaportPart;

        dbc = Global.getDataBaseConnector();
        dbc.openSession();

        productionRaportPart.setProductionRaportCoffeeAssignment(new HashSet<ProductionRaportCoffeeAssignment>());

        alpcs = dbc.getProductionCoffeeSeekWithEmployee(emp);
        jTable1.getModel().addTableModelListener(new CheckBoxAssignAllListener(3));
        dtm = (DefaultTableModel) jTable1.getModel();
        for (ProductionCoffeeSeek pcs : alpcs) {
            dbc.refresh(pcs);
            dtm.addRow(new Object[]{pcs, pcs.getWeight(), (float) 0, false});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pobrana kawa", "Dostępna ilość", "Ilość do przyporządkowania", "Całość"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void confirmAssignemt() throws NotEnoughtCoffeeException {

        ProductionCoffeeSeek temp;
        Float toAssign;
        for (int i = 0; i < dtm.getRowCount(); i++) {
            temp = (ProductionCoffeeSeek) dtm.getValueAt(i, 0);
            toAssign = Global.round((Float) dtm.getValueAt(i, 2), 2);
            if (toAssign > 0) {
                if (toAssign > Global.round(temp.getWeight(), 2)) {
                    throw new NotEnoughtCoffeeException(temp.toString());
                }
                temp.setWeight(Global.round(temp.getWeight() - toAssign, 2));
                ProductionRaportCoffeeAssignment prca = new ProductionRaportCoffeeAssignment();
                prca.setProductionCoffee(temp.getProductionCoffee());
                prca.setWeight(Global.round(toAssign, 2));
                prca.setProductionRaportPart(productionRaportPart);
                prca.setUsed(temp.getProductionCoffee().isUsed());
                productionRaportPart.getProductionRaportCoffeeAssignment().add(prca);
                dbc.saveTransation(temp);
            }
        }
        JOptionPane.showMessageDialog(this, "Przyporządkowano kawę.");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
