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

import Exceptions.NotEnoughtCoffeeException;
import Exceptions.NotMatchingCoffeeWeightException;
import Exceptions.ResourceNotFoundException;
import GreenCoffeeClasses.CoffeeGreenChangeHistory;
import Listeners.CheckBoxGreenCoffeeRoastRaport;
import ProductClasses.InstantCoffeeMixRaport;
import ProductClasses.InstantCoffeeMixPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemysław
 */
public class EditRaportMixCoffeeInstantPanel extends javax.swing.JPanel {

    DataBaseConnector dbc;
    InstantCoffeeMixRaport icmr;
    Float startWeight;
    public boolean raportSentWarden = false;

    /**
     * Creates new form NewRaportMixCoffeeInstantPanel
     */
    private void setControls(boolean state) {

        textFieldOtherInfo.setEnabled(state);
        buttonSendRaport.setEnabled(state);
        tableInstantCoffeeMixPart.setEnabled(state);
        buttonCheck.setEnabled(state);
        buttonEdit.setEnabled(state);
    }

    private void initAll() {
        setControls(false);

        buttonCheck.setEnabled(true);
        tableInstantCoffeeMixPart.setEnabled(true);
        textFieldOtherInfo.setText(icmr.getOtherInfo());

    }

    public EditRaportMixCoffeeInstantPanel(InstantCoffeeMixRaport icmr) {

        this.icmr = icmr;
        initComponents();
        initAll();
        startWeight = icmr.getWeight();
        dbc = Global.getDataBaseConnector();
        DefaultTableModel dtm = (DefaultTableModel) tableInstantCoffeeMixPart.getModel();
        dtm.setRowCount(0);

        for (InstantCoffeeMixPart icmp : icmr.getInstantCoffeeMixPart()) {
            dtm.addRow(new Object[]{icmp.getCoffeeGreen().getLabId(), icmp.getCoffeeGreen().getCoffeeType(), icmp.getCardBoardNumber(), icmp.getSerialNumber(), icmp.isSealOk(), icmp.getWeight(), false, false});
        }
        dtm.setRowCount(10);
        tableInstantCoffeeMixPart.getModel().addTableModelListener(new CheckBoxGreenCoffeeRoastRaport(6, 7));

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
        tableInstantCoffeeMixPart = new javax.swing.JTable();
        buttonCheck = new javax.swing.JButton();
        buttonSendRaport = new javax.swing.JButton();
        textFieldOtherInfo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonEdit = new javax.swing.JButton();

        tableInstantCoffeeMixPart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nr Kontr Surowca", "Kawa", "Nr Kartona", "Nr Parti", "Szczel.", "Waga", "+", "-"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Float.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableInstantCoffeeMixPart.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableInstantCoffeeMixPart);
        if (tableInstantCoffeeMixPart.getColumnModel().getColumnCount() > 0) {
            tableInstantCoffeeMixPart.getColumnModel().getColumn(0).setResizable(false);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(0).setPreferredWidth(200);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(1).setResizable(false);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(2).setResizable(false);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(3).setResizable(false);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(4).setResizable(false);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(5).setResizable(false);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(6).setResizable(false);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(6).setPreferredWidth(30);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(7).setResizable(false);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(7).setPreferredWidth(30);
        }

        buttonCheck.setText("Sprawdź");
        buttonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCheckActionPerformed(evt);
            }
        });

        buttonSendRaport.setText("Zatwierdź zmianę");
        buttonSendRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendRaportActionPerformed(evt);
            }
        });

        jLabel4.setText("Uwagi");

        buttonEdit.setText("Przywróc edycję");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(textFieldOtherInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSendRaport)
                        .addGap(0, 317, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldOtherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCheck)
                    .addComponent(buttonEdit)
                    .addComponent(buttonSendRaport))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSendRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendRaportActionPerformed
        try {
            dbc.openSession();
            if (icmr.getInstantCoffeeMixPart() != null) {
                dbc.startTransation();
                for (InstantCoffeeMixPart icmp : icmr.getInstantCoffeeMixPart()) {
                    if (icmp.getCoffeeGreen().getCurrentWeight() == 0) {
                        icmp.getCoffeeGreen().setState(Global.COFFEE_GREEN_OUT_OF_STORE);
                        dbc.saveTransation(icmp.getCoffeeGreen());
                    }
                    dbc.saveTransation(icmp);
                }
                dbc.saveTransation(icmr);
                dbc.commitTransation();
            }
            JOptionPane.showMessageDialog(this, "Raport zmieniony");
            raportSentWarden = true;
        } catch (Exception e) {
            e.printStackTrace();
            dbc.rollbackTransation();
            JOptionPane.showMessageDialog(this, "Wystąpił błąd poczas zmiany raportu.");
        }
    }//GEN-LAST:event_buttonSendRaportActionPerformed

    private void buttonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCheckActionPerformed
        try {
            dbc.openSession();
            icmr.setWeight(0);
            HashSet< InstantCoffeeMixPart> hsicmp = new HashSet<InstantCoffeeMixPart>(0);
            icmr.setInstantCoffeeMixPart(hsicmp);
            for (int i = 0; i < tableInstantCoffeeMixPart.getModel().getRowCount(); i++) {
                if (tableInstantCoffeeMixPart.getModel().getValueAt(i, 0) == null) {
                    break;
                }
                InstantCoffeeMixPart icmp = new InstantCoffeeMixPart();
                icmp.setInstantCoffeeMixRaport(icmr);
                icmp.setWeight((Float) tableInstantCoffeeMixPart.getModel().getValueAt(i, 5));
                icmp.setSealOk((Boolean) tableInstantCoffeeMixPart.getModel().getValueAt(i, 4));
                icmp.setSerialNumber(String.valueOf(tableInstantCoffeeMixPart.getModel().getValueAt(i, 3)));
                icmp.setCardBoardNumber(String.valueOf(tableInstantCoffeeMixPart.getModel().getValueAt(i, 2)));
                icmp.setCoffeeGreen(dbc.getCoffeeGreenWithLabId(tableInstantCoffeeMixPart.getModel().getValueAt(i, 0)));
                if (icmp.getCoffeeGreen() == null) {
                    throw new ResourceNotFoundException((String) tableInstantCoffeeMixPart.getModel().getValueAt(i, 0));
                }
                if (icmp.getCoffeeGreen().getCurrentWeight() - icmp.getWeight() < 0) {
                    throw new NotEnoughtCoffeeException(icmp.getCoffeeGreen().getLabId());
                } else {
                    icmp.getCoffeeGreen().setCurrentWeight(icmp.getCoffeeGreen().getCurrentWeight() - icmp.getWeight());
                    CoffeeGreenChangeHistory cgch = new CoffeeGreenChangeHistory();
                    cgch.setChangeTime(icmr.getMixDate());
                    cgch.setChangedBy(icmr.getMixedBy());
                    cgch.setInstantCoffeeMixRaport(icmr);
                    cgch.setComment("ZASYP " + icmr.getProductType());
                    cgch.setWeight(-1 * icmp.getWeight());
                    cgch.setCoffeeGreen(icmp.getCoffeeGreen());
                    icmp.getCoffeeGreen().getCoffeeGreenChangeHistory().add(cgch);
                    hsicmp.add(icmp);
                }
                icmr.setWeight(icmr.getWeight() + icmp.getWeight());
            }
            if (icmr.getWeight() != startWeight) {
                throw new NotMatchingCoffeeWeightException("Ilość kawy nie zgadza się ze starym stanem. Suma powinna wynosić " + startWeight);
            }

            setControls(false);
            buttonEdit.setEnabled(true);
            buttonSendRaport.setEnabled(true);
        } catch (NotEnoughtCoffeeException e) {
            JOptionPane.showMessageDialog(this, ("Nie wystarczająca ilość kawy lub zabielacza o ID " + e.getMessage()));
            dbc.clearSession();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Wprowadzone dane nie zostały zatwierdzone lub są błędnie wprowadzone.");
            dbc.clearSession();
        } catch (ResourceNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Kawa lub zabielacz o ID " + ex.getMessage() + " nie istnieje.");
            dbc.clearSession();
        } catch (NotMatchingCoffeeWeightException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            dbc.clearSession();
        }
    }//GEN-LAST:event_buttonCheckActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        buttonSendRaport.setEnabled(false);
        buttonCheck.setEnabled(true);
        tableInstantCoffeeMixPart.setEnabled(true);
        textFieldOtherInfo.setEnabled(true);
    }//GEN-LAST:event_buttonEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCheck;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonSendRaport;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableInstantCoffeeMixPart;
    private javax.swing.JTextField textFieldOtherInfo;
    // End of variables declaration//GEN-END:variables
}
