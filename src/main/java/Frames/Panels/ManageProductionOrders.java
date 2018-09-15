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

import ProductClasses.ProductType;
import ProductionClasses.ProductionLine;
import ProductionClasses.ProductionOrder;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemysław
 */
public class ManageProductionOrders extends javax.swing.JPanel {

    /**
     * Creates new form ManageProductionOrders
     */
    DataBaseConnector dbc = Global.getDataBaseConnector();
    ProductionLine selectedProductionLine;
    ProductionOrder selectedProductionOrderValue;
    int selectedProductionOrderIndex;
    ProductType selectedProductType;
    Employee emp;

    private void initProductionLines() {
        ArrayList<ProductionLine> alpl = dbc.getProductionLine();
        comboBoxProductionLine.removeAllItems();
        for (ProductionLine pl : alpl) {
            comboBoxProductionLine.addItem(pl);
        }
        comboBoxProductionLine.setSelectedItem(null);
    }

    private void loadProductionOrders(ProductionLine productionLine) {
        ArrayList<ProductionOrder> alpo = dbc.getProductionOrders(productionLine);
        DefaultTableModel dtm;
        dtm = (DefaultTableModel) tableProductionOrders.getModel();
        dtm.setRowCount(0);
        Collections.sort(alpo);
        for (ProductionOrder po : alpo) {
            dtm.addRow(new Object[]{
                po,
                po.getPositionInQueue(),
                po.getProductType(),
                po.getQuantity(),
                Global.timestampToStrDDMMYYYY(po.getDeadline()),
                po.getOtherInfo(),
                po.isImportant() ? "TAK" : "NIE",
                false,
                false,
                false});
        }
    }

    public ManageProductionOrders(Employee emp) {
        initComponents();
        initProductionLines();
        this.emp = emp;
        DefaultTableModel dtm = (DefaultTableModel) tableProductionOrders.getModel();
        dtm.setRowCount(0);
        comboBoxProductionLine.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                selectedProductionLine = (ProductionLine) comboBoxProductionLine.getSelectedItem();
                if (selectedProductionLine != null) {
                    loadProductionOrders(selectedProductionLine);
                }

            }
        }
        );
        /*
         listOrders.addListSelectionListener(new ListSelectionListener() {
         @Override
         public void valueChanged(ListSelectionEvent e) {
         selectedProductionOrderValue = (ProductionOrder) listOrders.getSelectedValue();
         selectedProductionOrderIndex = listOrders.getSelectedIndex();
         }
         }
         );*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        comboBoxProductionLine = new javax.swing.JComboBox();
        buttonUpQueue = new javax.swing.JButton();
        buttonDownQueue = new javax.swing.JButton();
        buttonDeleteOrder = new javax.swing.JButton();
        buttonNewOrder = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProductionOrders = new javax.swing.JTable();

        jLabel7.setText("Wybierz linię produkcyjną");

        comboBoxProductionLine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonUpQueue.setText("Zwieksz piorytet");
        buttonUpQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpQueueActionPerformed(evt);
            }
        });

        buttonDownQueue.setText("Zmniejsz priorytet");
        buttonDownQueue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDownQueueActionPerformed(evt);
            }
        });

        buttonDeleteOrder.setText("Usuń zlecenie");
        buttonDeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteOrderActionPerformed(evt);
            }
        });

        buttonNewOrder.setText("Dodaj nowe zlecenie");
        buttonNewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewOrderActionPerformed(evt);
            }
        });

        jButton1.setText("Odśwież");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tableProductionOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "obj", "Numer", "Produkt", "Ilość [KG]", "Deadline", "Dodatkowe informacje", "Ważne", "↑", "↓", "-"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProductionOrders.setColumnSelectionAllowed(true);
        tableProductionOrders.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableProductionOrders);
        tableProductionOrders.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (tableProductionOrders.getColumnModel().getColumnCount() > 0) {
            tableProductionOrders.getColumnModel().getColumn(0).setMinWidth(0);
            tableProductionOrders.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableProductionOrders.getColumnModel().getColumn(0).setMaxWidth(0);
            tableProductionOrders.getColumnModel().getColumn(1).setMinWidth(50);
            tableProductionOrders.getColumnModel().getColumn(1).setPreferredWidth(50);
            tableProductionOrders.getColumnModel().getColumn(1).setMaxWidth(50);
            tableProductionOrders.getColumnModel().getColumn(3).setMinWidth(150);
            tableProductionOrders.getColumnModel().getColumn(3).setPreferredWidth(150);
            tableProductionOrders.getColumnModel().getColumn(3).setMaxWidth(150);
            tableProductionOrders.getColumnModel().getColumn(4).setMinWidth(200);
            tableProductionOrders.getColumnModel().getColumn(4).setPreferredWidth(200);
            tableProductionOrders.getColumnModel().getColumn(4).setMaxWidth(200);
            tableProductionOrders.getColumnModel().getColumn(6).setMinWidth(100);
            tableProductionOrders.getColumnModel().getColumn(6).setPreferredWidth(100);
            tableProductionOrders.getColumnModel().getColumn(6).setMaxWidth(100);
            tableProductionOrders.getColumnModel().getColumn(7).setMinWidth(50);
            tableProductionOrders.getColumnModel().getColumn(7).setPreferredWidth(50);
            tableProductionOrders.getColumnModel().getColumn(7).setMaxWidth(50);
            tableProductionOrders.getColumnModel().getColumn(8).setMinWidth(50);
            tableProductionOrders.getColumnModel().getColumn(8).setPreferredWidth(50);
            tableProductionOrders.getColumnModel().getColumn(8).setMaxWidth(50);
            tableProductionOrders.getColumnModel().getColumn(9).setMinWidth(50);
            tableProductionOrders.getColumnModel().getColumn(9).setPreferredWidth(50);
            tableProductionOrders.getColumnModel().getColumn(9).setMaxWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonUpQueue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDownQueue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDeleteOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNewOrder)
                        .addGap(0, 387, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxProductionLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxProductionLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpQueue)
                    .addComponent(buttonDownQueue)
                    .addComponent(buttonDeleteOrder)
                    .addComponent(buttonNewOrder))
                .addGap(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUpQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpQueueActionPerformed
        /*  if (selectedProductionOrderIndex > 0) {
         selectedProductionOrderValue.upQueue();
         ProductionOrder tmp = (ProductionOrder) dlm.get(selectedProductionOrderIndex - 1);
         tmp.downQueue();
         try {
         dbc.startTransation();
         dbc.updateTransation(selectedProductionOrderValue);
         dbc.updateTransation(tmp);
         dbc.commitTransation();
         loadProductionOrders(selectedProductionLine);
         } catch (Exception e) {
         dbc.rollbackTransation();
         }
         }*/
    }//GEN-LAST:event_buttonUpQueueActionPerformed

    private void buttonDownQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDownQueueActionPerformed

        /*if (selectedProductionOrderIndex < listOrders.getModel().getSize() - 1) {
         selectedProductionOrderValue.downQueue();
         ProductionOrder tmp = (ProductionOrder) dlm.get(selectedProductionOrderIndex + 1);
         tmp.upQueue();
         try {
         dbc.startTransation();
         dbc.updateTransation(selectedProductionOrderValue);
         dbc.updateTransation(tmp);
         dbc.commitTransation();
         loadProductionOrders(selectedProductionLine);
         } catch (Exception e) {
         dbc.rollbackTransation();
         }
         }*/
    }//GEN-LAST:event_buttonDownQueueActionPerformed

    private void buttonDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteOrderActionPerformed
        /*   try {
         dbc.startTransation();
         if (selectedProductionOrderIndex != listOrders.getModel().getSize()) {
         for (int i = selectedProductionOrderIndex + 1; i < listOrders.getModel().getSize(); i++) {
         ProductionOrder tmp = (ProductionOrder) dlm.get(i);
         tmp.upQueue();
         dbc.updateTransation(tmp);
         }
         dbc.deleteTransation(selectedProductionOrderValue);
         dbc.commitTransation();
         loadProductionOrders(selectedProductionLine);
         }
         } catch (Exception e) {
         dbc.rollbackTransation();
         }*/
    }//GEN-LAST:event_buttonDeleteOrderActionPerformed

    private void buttonNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewOrderActionPerformed
        try {
            String[] options = {"Dodaj", "Cofnij"};
            NewProductionOrder npo = new NewProductionOrder();
            int result = JOptionPane.showOptionDialog(null, npo, "Podaj dane nowego zlecenia!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (JOptionPane.OK_OPTION == result) {
                ProductionOrder productionOrder = new ProductionOrder();
                productionOrder.makeOrder(selectedProductionLine,
                        npo.isImportant(),
                        npo.getDeadline(),
                        npo.getProductType(),
                        emp,
                        npo.getQuantity(),
                        npo.getInfo(),
                        dbc.getLatestProductionOrderPosition(selectedProductionLine)
                );
                dbc.startTransation();
                dbc.saveTransation(productionOrder);
                dbc.commitTransation();
                loadProductionOrders(selectedProductionLine);
            }
        } catch (HeadlessException e) {
            dbc.rollbackTransation();
        }
    }//GEN-LAST:event_buttonNewOrderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DataBaseConnector dbc = Global.getDataBaseConnector();
        dbc.clearSession();
        dbc.openSession();
        loadProductionOrders(selectedProductionLine);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDeleteOrder;
    private javax.swing.JButton buttonDownQueue;
    private javax.swing.JButton buttonNewOrder;
    private javax.swing.JButton buttonUpQueue;
    private javax.swing.JComboBox comboBoxProductionLine;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableProductionOrders;
    // End of variables declaration//GEN-END:variables
}
