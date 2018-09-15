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

import GreenCoffeeClasses.CoffeeGreenChangeHistory;
import GreenCoffeeClasses.CoffeeType;
import ProductClasses.Aroma;
import ProductClasses.AromaChangeHistory;
import ProductClasses.AromaType;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemysław
 */
public class BrowseAvailableAromaStoremanPanel extends javax.swing.JPanel {

    AromaType selectedAromaType;
    DataBaseConnector dbc;
    Employee emp;
    Aroma selectedAroma;

    /**
     * Creates new form BrowseAvailableGreenCoffeePanel
     */
    public BrowseAvailableAromaStoremanPanel(Employee e) {
        initComponents();
        emp = e;
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();
        }
        dbc.openSession();
        final DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

        ArrayList<AromaType> alat = dbc.getAromaType();

        Object[] o = alat.toArray();
        Arrays.sort(o);

        comboBoxAromaType.removeAllItems();
        for (Object ob : o) {
            AromaType at = (AromaType) ob;
            comboBoxAromaType.addItem(at);
        }
        comboBoxAromaType.setSelectedItem(null);

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());

                selectedAroma = (Aroma) dtm.getValueAt(row, 0);
            }
        }
        );
        comboBoxAromaType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                float sum = 0;
                dbc.openSession();
                selectedAromaType = (AromaType) comboBoxAromaType.getSelectedItem();
                ArrayList<Aroma> ala = dbc.getAromaWithAromaType(selectedAromaType);

                dtm.setRowCount(0);
                for (Aroma a : ala) {
                    sum += a.getQuantity();
                    dtm.addRow(new Object[]{a, a.getQuantity()});
                }
                labelAromaSum.setText("SUMA ILOŚCI AROMATU: " + sum + " KG");
                jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboBoxAromaType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        buttonReload = new javax.swing.JButton();
        labelAromaSum = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        comboBoxAromaType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Wybierz rodzaj aromatu do sprawdzenia");

        buttonReload.setText("Odśwież");
        buttonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReloadActionPerformed(evt);
            }
        });

        labelAromaSum.setText("SUMA ILOŚCI AROMATU : ");

        jButton1.setText("Zmień stan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Szczegóły");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nazwa", "Stan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setMinWidth(100);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxAromaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelAromaSum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonReload))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxAromaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonReload)
                    .addComponent(labelAromaSum)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReloadActionPerformed
        dbc.clearSession();
        comboBoxAromaType.setSelectedItem(null);
    }//GEN-LAST:event_buttonReloadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            final DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            String s = (String) JOptionPane.showInputDialog(this, "Podaj wartość", "Edycja", JOptionPane.QUESTION_MESSAGE, null, null, null);
            Aroma a = selectedAroma;
            float valueAfterChange = Float.valueOf(s);
            if (valueAfterChange < 0) {
                throw new WeightLessThanZero();
            } else {
                float changeValue = valueAfterChange - a.getQuantity();
                String comment = (String) JOptionPane.showInputDialog(this, "Podaj komentarz do zmiany", "Edycja", JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (comment != null) {
                    if (!comment.isEmpty()) {
                        dbc.openSession();
                        dbc.startTransation();
                        a.correction(changeValue, emp, comment);
                        dbc.updateTransation(a);
                        dbc.commitTransation();

                        Float sum = (float) 0;
                        ArrayList<Aroma> ala = dbc.getAromaWithAromaType(selectedAromaType);
                        dtm.setRowCount(0);
                        for (Aroma ar : ala) {
                            sum += a.getQuantity();
                            dtm.addRow(new Object[]{ar, ar.getQuantity()});
                        }

                        labelAromaSum.setText("SUMA ILOŚCI AROMATU: " + sum + " KG");
                        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                    }
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Zmiana nie wprowadzona, proszę wprowadzić dane prawidłowo.");
        } catch (WeightLessThanZero ex) {
            JOptionPane.showMessageDialog(this, "Próba zmiany ilości aromatu na wartość ujemną.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            selectedAroma.showDetails();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonReload;
    private javax.swing.JComboBox comboBoxAromaType;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelAromaSum;
    // End of variables declaration//GEN-END:variables

    private static class WeightLessThanZero extends Exception {

        public WeightLessThanZero() {
        }
    }
}
