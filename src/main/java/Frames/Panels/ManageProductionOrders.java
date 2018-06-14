/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import ProductClasses.ProductType;
import ProductionClasses.Pallete;
import ProductionClasses.ProductionLine;
import ProductionClasses.ProductionOrder;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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

    DefaultListModel dlm;

    private void initProductionLines() {

        ArrayList<ProductionLine> alpl = dbc.getProductionLine();
        comboBoxProductionLine.removeAllItems();
        for (ProductionLine pl : alpl) {
            if (!pl.isRoast()) {
                comboBoxProductionLine.addItem(pl);
            }
        }
        comboBoxProductionLine.setSelectedItem(null);
    }

    private void loadProductionOrders(ProductionLine productionLine) {
        ArrayList<ProductionOrder> alpo = dbc.getProductionOrders(productionLine);
        dlm = new DefaultListModel();

        dlm.removeAllElements();
        Collections.sort(alpo);
        for (ProductionOrder po : alpo) {
            dlm.addElement(po);
        }
        listOrders.setModel(dlm);
    }

    public ManageProductionOrders(Employee emp) {
        initComponents();
        initProductionLines();
        dlm = new DefaultListModel();
        listOrders.setModel(dlm);
        dlm.removeAllElements();
        this.emp = emp;
        listOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

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

        listOrders.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedProductionOrderValue = (ProductionOrder) listOrders.getSelectedValue();
                selectedProductionOrderIndex = listOrders.getSelectedIndex();

            }
        }
        );
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
        jScrollPane1 = new javax.swing.JScrollPane();
        listOrders = new javax.swing.JList();
        buttonUpQueue = new javax.swing.JButton();
        buttonDownQueue = new javax.swing.JButton();
        buttonDeleteOrder = new javax.swing.JButton();
        buttonNewOrder = new javax.swing.JButton();

        jLabel7.setText("Wybierz linię produkcyjną");

        comboBoxProductionLine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        listOrders.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listOrders);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxProductionLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonUpQueue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDownQueue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDeleteOrder)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonNewOrder)))
                        .addGap(0, 387, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxProductionLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpQueue)
                    .addComponent(buttonDownQueue)
                    .addComponent(buttonDeleteOrder)
                    .addComponent(buttonNewOrder))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonUpQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpQueueActionPerformed
        if (selectedProductionOrderIndex > 0) {
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
        }
    }//GEN-LAST:event_buttonUpQueueActionPerformed

    private void buttonDownQueueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDownQueueActionPerformed
        if (selectedProductionOrderIndex < listOrders.getModel().getSize() - 1) {
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
        }
    }//GEN-LAST:event_buttonDownQueueActionPerformed

    private void buttonDeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteOrderActionPerformed
        try {
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
        }
    }//GEN-LAST:event_buttonDeleteOrderActionPerformed

    private void buttonNewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewOrderActionPerformed

        try {
            String[] options = {"Dodaj", "Cofnij"};
            NewProductionOrder npo = new NewProductionOrder();
            int result = JOptionPane.showOptionDialog(null, npo, "Podaj dane nowego raportu!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (JOptionPane.OK_OPTION == result) {
                ProductionOrder productionOrder = new ProductionOrder();
                productionOrder.makeOrder(selectedProductionLine,
                        npo.getProductType(),
                        emp,
                        npo.getQuantity(),
                        npo.getInfo(),
                        listOrders.getModel().getSize()
                );
                dbc.startTransation();
                dbc.saveTransation(productionOrder);
                dbc.commitTransation();
                loadProductionOrders(selectedProductionLine);
            }
        } catch (HeadlessException e) {
            dbc.rollbackTransation();
        } finally {

        }
    }//GEN-LAST:event_buttonNewOrderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDeleteOrder;
    private javax.swing.JButton buttonDownQueue;
    private javax.swing.JButton buttonNewOrder;
    private javax.swing.JButton buttonUpQueue;
    private javax.swing.JComboBox comboBoxProductionLine;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listOrders;
    // End of variables declaration//GEN-END:variables
}