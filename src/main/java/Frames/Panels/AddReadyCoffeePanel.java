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

import ProductionManagement.LabTest;

import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import GreenCoffeeClasses.Provider;
import ProductClasses.ProductType;
import ProductClasses.ReadyCoffee;
import ProductionManagement.Global;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class AddReadyCoffeePanel extends javax.swing.JPanel {

    /**
     * Creates new form AddGreenCoffeeMagazynierPanel
     */
    ArrayList<ProductType> alpt;
    ArrayList<Provider> alp;
    DataBaseConnector dbc;
    Employee emp;

    public AddReadyCoffeePanel(Employee emp) {
        initComponents();
        this.emp = emp;
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();
            dbc.clearSession();
        }
        dbc.openSession();
        alpt = dbc.getProductType(Global.PRODUCT_TYPE_PACK);
        Object[] o = alpt.toArray();
        Arrays.sort(o);

        comboBoxProductType.removeAllItems();
        for (Object ob : o) {
            comboBoxProductType.addItem(ob);
        }
        comboBoxProductType.setSelectedItem(null);

        alp = dbc.getProvider();
        o = alp.toArray();
        Arrays.sort(o);

        comboBoxProvider.removeAllItems();
        for (Object ob : o) {
            comboBoxProvider.addItem(ob);
        }
        comboBoxProvider.setSelectedItem(null);

    }

    private void resetInput() {
        comboBoxProvider.setSelectedItem(null);
        comboBoxProductType.setSelectedItem(null);
        spinnerPcs.setValue(new Integer(0));
        spinnerKgPerPcs.setValue(new Float(0));
        spinnerWeight.setValue(new Float(0));
        checkBoxVermin.setSelected(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelMain = new javax.swing.JLabel();
        labelWeight = new javax.swing.JLabel();
        buttonRegisterToLaboratory = new javax.swing.JButton();
        labelCoffeOwner1 = new javax.swing.JLabel();
        comboBoxProductType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        comboBoxProvider = new javax.swing.JComboBox();
        checkBoxVermin = new javax.swing.JCheckBox();
        buttonNewProvider = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spinnerPcs = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spinnerKgPerPcs = new javax.swing.JSpinner();
        spinnerWeight = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        textFieldOtherInfo = new javax.swing.JTextField();

        labelMain.setText("Rejestrowanie wyrobu gotowego do badania");

        labelWeight.setText("Waga [Kg]");

        buttonRegisterToLaboratory.setText("Zarejestruj do badania");
        buttonRegisterToLaboratory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterToLaboratoryActionPerformed(evt);
            }
        });

        labelCoffeOwner1.setText("Typ wyrobu");

        jLabel1.setText("Producent");

        checkBoxVermin.setText("Szkodniki obecne");

        buttonNewProvider.setText("+");
        buttonNewProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewProviderActionPerformed(evt);
            }
        });

        jButton1.setText("Wyczyść");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Ilość sztuk");

        jLabel4.setText("Waga sztuki [Kg]");

        spinnerKgPerPcs.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(1.0f)));

        spinnerWeight.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(1.0f)));

        jButton2.setText("#");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Informacje dodatkowe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonRegisterToLaboratory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(checkBoxVermin)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelCoffeOwner1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(labelWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(comboBoxProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(buttonNewProvider))
                                                    .addComponent(comboBoxProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(spinnerPcs)
                                                    .addComponent(spinnerKgPerPcs)
                                                    .addComponent(spinnerWeight, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton2))
                                            .addComponent(textFieldOtherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))))
                    .addComponent(labelMain))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCoffeOwner1)
                    .addComponent(comboBoxProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNewProvider))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spinnerPcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(spinnerKgPerPcs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWeight)
                    .addComponent(spinnerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldOtherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxVermin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRegisterToLaboratory)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegisterToLaboratoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterToLaboratoryActionPerformed
        // TODO add your handling code here:
        dbc.openSession();
        try {
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            String str = dbc.getMaxLabIdReadyCoffee();
            String newLabIdStr;
            if (str != null) {
                Integer lastLabId = Integer.parseInt(str.substring(1, 7));
                newLabIdStr = String.format("P%06d", lastLabId + 1);
            } else {
                newLabIdStr = String.format("P%06d", 1);
            }

            ReadyCoffee rc = new ReadyCoffee();

            rc.setState(Global.TO_EXAMINE);
            rc.setArrivalDate(currentTime);
            rc.setArrivalWeight(Global.round((Float) spinnerWeight.getValue(),2));
            rc.setArrivalQuantity((Integer) spinnerPcs.getValue());
            rc.setStoreman(emp);
            rc.setOtherInfo(textFieldOtherInfo.getText());
            rc.setProvider((Provider) comboBoxProvider.getSelectedItem());
            rc.setProductType((ProductType) comboBoxProductType.getSelectedItem());
            rc.setLabId(newLabIdStr);
            LabTest lt = new LabTest();
            lt.setVermin(checkBoxVermin.isSelected());
            dbc.saveObject(lt);
            rc.setLabTest(lt);
            dbc.saveObject(rc);
            JOptionPane.showMessageDialog(null, "Zarejestrowano do badania", "Informacja", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sprawdź wprowadzone dane", "Błąd", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonRegisterToLaboratoryActionPerformed

    private void buttonNewProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewProviderActionPerformed

        String[] option = {"Cofnij"};
        int result = JOptionPane.showOptionDialog(this, new AddProviderPanel(), "Dodaj nowego dostawcę", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
        if (JOptionPane.OK_OPTION == result) {
            dbc.clearSession();
            dbc.openSession();
            alp = dbc.getProvider();
            Object[] o = alp.toArray();
            Arrays.sort(o);

            comboBoxProvider.removeAllItems();
            for (Object ob : o) {
                comboBoxProvider.addItem(ob);
            }
            comboBoxProvider.setSelectedItem(null);

        }

    }//GEN-LAST:event_buttonNewProviderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetInput();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        spinnerWeight.setValue(((Integer) spinnerPcs.getValue()).intValue() * ((Float) spinnerKgPerPcs.getValue()));
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNewProvider;
    private javax.swing.JButton buttonRegisterToLaboratory;
    private javax.swing.JCheckBox checkBoxVermin;
    private javax.swing.JComboBox comboBoxProductType;
    private javax.swing.JComboBox comboBoxProvider;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel labelCoffeOwner1;
    private javax.swing.JLabel labelMain;
    private javax.swing.JLabel labelWeight;
    private javax.swing.JSpinner spinnerKgPerPcs;
    private javax.swing.JSpinner spinnerPcs;
    private javax.swing.JSpinner spinnerWeight;
    private javax.swing.JTextField textFieldOtherInfo;
    // End of variables declaration//GEN-END:variables
}
