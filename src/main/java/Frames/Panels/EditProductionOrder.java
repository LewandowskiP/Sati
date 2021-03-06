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
import ProductionClasses.ProductionOrder;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Przemysław
 */
public class EditProductionOrder extends javax.swing.JPanel {

    /**
     * Creates new form NewProductionOrder
     */
    ProductType selectedProductType;
    DataBaseConnector dbc = Global.getDataBaseConnector();
    ProductionOrder productionOrder;

    public ProductType getProductType() {
        return (ProductType) comboBoxProductType.getSelectedItem();
    }

    public Integer getQuantity() {
        return (Integer) jSpinner1.getValue();
    }

    public String getInfo() {
        return (String) jTextField1.getText();
    }

    public Timestamp getDeadline() {
        Timestamp toReturn = new Timestamp(((Date) spinnerDeadline.getValue()).getTime());
        return toReturn;
    }

    public boolean isImportant() {
        return checkBoxImportant.isSelected();
    }

    private void initProductType() {
        ArrayList<ProductType> alpt = dbc.getProductType(Global.PRODUCT_TYPE_PACK);
        comboBoxProductType.removeAllItems();
        Object[] A = alpt.toArray();
        alpt.toArray(A);
        Arrays.sort(A);
        comboBoxProductType.removeAllItems();
        for (Object pt : A) {
            comboBoxProductType.addItem(pt);
        }
        comboBoxProductType.setSelectedItem(productionOrder.getProductType());
    }

    public EditProductionOrder(ProductionOrder productionOrder) {
        this.productionOrder = productionOrder;
        initComponents();
        initProductType();
        jTextField1.setText(productionOrder.getOtherInfo());
        jSpinner1.setValue(productionOrder.getQuantity());
        checkBoxImportant.setSelected(productionOrder.isImportant());
        spinnerDeadline.setValue((Date) productionOrder.getDeadline());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboBoxProductType = new javax.swing.JComboBox();
        buttonOpenFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        spinnerDeadline = new javax.swing.JSpinner();
        checkBoxImportant = new javax.swing.JCheckBox();

        jLabel1.setText("Ilość paleń/palet");

        jLabel10.setText("Wybierz typ produktu");

        comboBoxProductType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonOpenFile.setText("Pokaż kartę produktu");
        buttonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenFileActionPerformed(evt);
            }
        });

        jLabel2.setText("Dodatkowe informacje");

        jLabel3.setText("Termin ostateczny");

        spinnerDeadline.setModel(new javax.swing.SpinnerDateModel());

        checkBoxImportant.setText("Zlecenie ważne");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(checkBoxImportant)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxProductType, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonOpenFile)
                                .addGap(0, 53, Short.MAX_VALUE))
                            .addComponent(spinnerDeadline))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboBoxProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOpenFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerDeadline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxImportant)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenFileActionPerformed
        if (selectedProductType != null) {
            selectedProductType.openFile(Global.FILE_READ_ONLY);
        }
    }//GEN-LAST:event_buttonOpenFileActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOpenFile;
    private javax.swing.JCheckBox checkBoxImportant;
    private javax.swing.JComboBox comboBoxProductType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner spinnerDeadline;
    // End of variables declaration//GEN-END:variables
}
