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

import GreenCoffeeClasses.CoffeeType;
import ProductionManagement.LabTest;

import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import GreenCoffeeClasses.Provider;
import ProductClasses.Aroma;
import ProductClasses.AromaType;
import ProductClasses.DirectPackage;
import ProductClasses.DirectPackageType;
import ProductClasses.ProductType;
import ProductClasses.ReadyCoffee;
import ProductionManagement.Global;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class AddDirectPackagePanel extends javax.swing.JPanel {

    /**
     * Creates new form AddGreenCoffeeMagazynierPanel
     */
    ArrayList<DirectPackageType> aldpt;
    ArrayList<Provider> alp;
    DataBaseConnector dbc;
    Employee emp;

    public AddDirectPackagePanel(Employee emp) {
        initComponents();
        this.emp = emp;
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();
            dbc.clearSession();

        }
        dbc.openSession();
        aldpt = dbc.getDirectPackageType();
        Object[] o = aldpt.toArray();
        Arrays.sort(o);

        comboBoxDirectPackageType.removeAllItems();
        for (Object ob : o) {
            DirectPackageType dpt = (DirectPackageType) ob;
            comboBoxDirectPackageType.addItem(dpt);
        }
        comboBoxDirectPackageType.setSelectedItem(null);

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
        comboBoxDirectPackageType.setSelectedItem(null);

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
        comboBoxDirectPackageType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        comboBoxProvider = new javax.swing.JComboBox();
        checkBoxVermin = new javax.swing.JCheckBox();
        buttonNewProvider = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spinnerWeight = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();

        labelMain.setText("Rejestrowanie materiału do badania");

        labelWeight.setText("Ilość");

        buttonRegisterToLaboratory.setText("Zarejestruj do badania");
        buttonRegisterToLaboratory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterToLaboratoryActionPerformed(evt);
            }
        });

        labelCoffeOwner1.setText("Typ materiału");

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

        spinnerWeight.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(1.0f)));

        jButton3.setText("+");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMain)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(checkBoxVermin, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(buttonRegisterToLaboratory)
                                    .addGap(44, 44, 44)
                                    .addComponent(jButton1))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(219, 219, 219)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCoffeOwner1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(labelWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBoxProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(buttonNewProvider))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBoxDirectPackageType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(spinnerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCoffeOwner1)
                    .addComponent(comboBoxDirectPackageType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNewProvider))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelWeight)
                        .addComponent(spinnerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(checkBoxVermin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonRegisterToLaboratory)
                    .addComponent(jButton1))
                .addContainerGap(105, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegisterToLaboratoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterToLaboratoryActionPerformed
        // TODO add your handling code here:
        dbc.openSession();
        try {
            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            String str = dbc.getMaxLabIdDirectPackage();
            String newLabIdStr;
            if (str != null) {
                Integer lastLabId = Integer.parseInt(str.substring(1, 7));

                newLabIdStr = String.format("B%06d", lastLabId + 1);
            } else {
                newLabIdStr = String.format("B%06d", 1);
            }

            DirectPackage a = new DirectPackage();

            a.setWeight((Float) spinnerWeight.getValue());
            a.setState(Global.TO_EXAMINE);
            a.setArrivalDate(currentTime);
            a.setStoreman(emp);
            a.setProvider((Provider) comboBoxProvider.getSelectedItem());
            a.setDirectPackageType((DirectPackageType) comboBoxDirectPackageType.getSelectedItem());
            a.setLabId(newLabIdStr);
            LabTest lt = new LabTest();
            lt.setVermin(checkBoxVermin.isSelected());
            dbc.saveObject(lt);
            a.setLabTest(lt);

            dbc.saveObject(a);
            JOptionPane.showMessageDialog(null, "Zarejestrowano do badania", "Informacja", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sprawdź wprowadzone dane", "Błąd", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonRegisterToLaboratoryActionPerformed

    private void buttonNewProviderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewProviderActionPerformed

        String[] option = {"Cofnij"};
        int result = JOptionPane.showOptionDialog(this, new AddProviderPanel(), "Dodaj nowego dostawcę", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

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


    }//GEN-LAST:event_buttonNewProviderActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        resetInput();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String[] option = {"Cofnij"};
        int result = JOptionPane.showOptionDialog(this, new AddDirectPackageTypePanel(), "Dodaj nowy typ aromatu", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
        if (JOptionPane.OK_OPTION == result) {
            dbc.clearSession();
            dbc.openSession();
            aldpt = dbc.getDirectPackageType();
            Object[] o = aldpt.toArray();
            Arrays.sort(o);

            comboBoxDirectPackageType.removeAllItems();
            for (Object ob : o) {
                DirectPackageType dpt = (DirectPackageType) ob;
                comboBoxDirectPackageType.addItem(dpt);
            }
            comboBoxDirectPackageType.setSelectedItem(null);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNewProvider;
    private javax.swing.JButton buttonRegisterToLaboratory;
    private javax.swing.JCheckBox checkBoxVermin;
    private javax.swing.JComboBox comboBoxDirectPackageType;
    private javax.swing.JComboBox comboBoxProvider;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelCoffeOwner1;
    private javax.swing.JLabel labelMain;
    private javax.swing.JLabel labelWeight;
    private javax.swing.JSpinner spinnerWeight;
    // End of variables declaration//GEN-END:variables
}
