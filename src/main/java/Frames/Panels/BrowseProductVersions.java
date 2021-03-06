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

import Listeners.CheckBoxProductOverwatchListener;
import ProductClasses.ProductType;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Przemysław
 */
public class BrowseProductVersions extends javax.swing.JPanel {

    DataBaseConnector dbc;

    /**
     * Creates new form BrowseProductVersions
     */
    ProductType pt;

    public BrowseProductVersions(ProductType pt) {
        this.pt = pt;
        initComponents();
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();
        }
        dbc.openSession();
        DefaultTableModel dtm = (DefaultTableModel) tableProducts.getModel();
        dtm.setRowCount(0);
        for (ProductType productType : dbc.getProductVersions(pt)) {
            dtm.addRow(new Object[]{productType, Global.timestampToStrDDMMYYYY(productType.getCreateDate()), productType.getVersion(), false});
        }
        dtm.addTableModelListener(new CheckBoxProductOverwatchListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nazwa karty", "Data dodania", "Wersja", "Pokaż kartę"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableProducts);
        if (tableProducts.getColumnModel().getColumnCount() > 0) {
            tableProducts.getColumnModel().getColumn(0).setResizable(false);
            tableProducts.getColumnModel().getColumn(1).setResizable(false);
            tableProducts.getColumnModel().getColumn(2).setResizable(false);
            tableProducts.getColumnModel().getColumn(2).setPreferredWidth(10);
            tableProducts.getColumnModel().getColumn(3).setResizable(false);
            tableProducts.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        jButton1.setText("Zmień nazwę");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Zmień EAN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            String s = (String) JOptionPane.showInputDialog(this, "Podaj nową nazwę", pt.getProductName());
            if (s != null) {
                if (s.length() > 5) {
                    dbc.openSession();
                    dbc.startTransation();
                    for (int i = 0; i < tableProducts.getRowCount(); i++) {
                        ((ProductType) tableProducts.getValueAt(i, 0)).setProductName(s);
                        dbc.updateTransation(tableProducts.getValueAt(i, 0));
                    }
                    dbc.commitTransation();
                    DefaultTableModel dtm = (DefaultTableModel) tableProducts.getModel();
                    dtm.setRowCount(0);

                    for (ProductType productType : dbc.getProductVersions(pt)) {
                        dtm.addRow(new Object[]{productType, Global.timestampToStrDDMMYYYY(productType.getCreateDate()), productType.getVersion(), false});
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Nazwa zbyt krótka.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nie wprowadzono wartości.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Błąd.");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String s = (String) JOptionPane.showInputDialog(null, "Podaj nowy EAN", "Uwaga!", JOptionPane.INFORMATION_MESSAGE);
            if (s != null) {
                if (s.length() == 13 && StringUtils.isNumeric(s)) {
                    dbc.openSession();
                    dbc.startTransation();
                    for (int i = 0; i < tableProducts.getRowCount(); i++) {
                        ((ProductType) tableProducts.getValueAt(i, 0)).setEan(s);
                        dbc.updateTransation(tableProducts.getValueAt(i, 0));
                    }
                    dbc.commitTransation();
                    DefaultTableModel dtm = (DefaultTableModel) tableProducts.getModel();
                    dtm.setRowCount(0);

                    for (ProductType productType : dbc.getProductVersions(pt)) {
                        dtm.addRow(new Object[]{productType, Global.timestampToStrDDMMYYYY(productType.getCreateDate()), productType.getVersion(), false});
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "EAN13 nieprawidłowy.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nie wprowadzono wartości.");
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(this, "Błąd.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableProducts;
    // End of variables declaration//GEN-END:variables
}
