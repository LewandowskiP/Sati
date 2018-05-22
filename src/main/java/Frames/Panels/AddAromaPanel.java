/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;


import ProductionManagement.LabTest;

import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import GreenCoffeeClasses.Provider;
import ProductClasses.Aroma;
import ProductClasses.AromaChangeHistory;
import ProductClasses.AromaType;
import ProductionManagement.Global;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class AddAromaPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddGreenCoffeeMagazynierPanel
     */
    ArrayList<AromaType> alat;
    ArrayList<Provider> alp;
    DataBaseConnector dbc;
    Employee emp;

    public AddAromaPanel(Employee emp) {
        initComponents();
        this.emp = emp;
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();

        }
        dbc.clearSession();
        dbc.openSession();
        alat = dbc.getAromaType();
        Object[] o = alat.toArray();
        Arrays.sort(o);

        comboBoxAromaType.removeAllItems();
        for (Object ob : o) {
            AromaType at = (AromaType) ob;
            comboBoxAromaType.addItem(at);
        }
        comboBoxAromaType.setSelectedItem(null);

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
        comboBoxAromaType.setSelectedItem(null);
        spinnerQuantity.setValue(0);
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
        comboBoxAromaType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        comboBoxProvider = new javax.swing.JComboBox();
        checkBoxVermin = new javax.swing.JCheckBox();
        buttonNewAromaType = new javax.swing.JButton();
        buttonNewProvider = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        spinnerQuantity = new javax.swing.JSpinner();

        labelMain.setText("Rejestrowanie aromatu do badania");

        labelWeight.setText("Waga [Kg]");

        buttonRegisterToLaboratory.setText("Zarejestruj do badania");
        buttonRegisterToLaboratory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterToLaboratoryActionPerformed(evt);
            }
        });

        labelCoffeOwner1.setText("Typ Aromatu");

        jLabel1.setText("Producent");

        checkBoxVermin.setText("Szkodniki obecne");

        buttonNewAromaType.setText("+");
        buttonNewAromaType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewAromaTypeActionPerformed(evt);
            }
        });

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

        spinnerQuantity.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(1.0f)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCoffeOwner1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(labelWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboBoxProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonNewProvider))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(comboBoxAromaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(buttonNewAromaType))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonRegisterToLaboratory)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1))
                            .addComponent(checkBoxVermin)))
                    .addComponent(labelMain))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelMain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCoffeOwner1)
                    .addComponent(comboBoxAromaType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNewAromaType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNewProvider))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelWeight)
                    .addComponent(spinnerQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkBoxVermin)
                .addGap(18, 18, 18)
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
            String str = dbc.getMaxLabIdAroma();

            String newLabIdStr;
            if (str != null) {
                Integer lastLabId = Integer.parseInt(str.substring(1, 7));

                newLabIdStr = String.format("A%06d", lastLabId + 1);
            } else {
                newLabIdStr = String.format("A%06d", 1);
            }

            Aroma a = new Aroma();

            a.setQuantity((Float) spinnerQuantity.getValue());
            a.setState(Global.TO_EXAMINE);
            a.setArrivalDate(currentTime);
            a.setArrivalQuantity(a.getQuantity());
            a.setStoreman(emp);
            a.setProvider((Provider) comboBoxProvider.getSelectedItem());
            a.setAromaType((AromaType) comboBoxAromaType.getSelectedItem());
            a.setLabId(newLabIdStr);
            LabTest lt = new LabTest();
            lt.setVermin(checkBoxVermin.isSelected());
            dbc.saveObject(lt);
            a.setLabTest(lt);

            dbc.saveObject(a);

            AromaChangeHistory ach = new AromaChangeHistory();
            ach.setChangeTime(new Timestamp(System.currentTimeMillis()));
            ach.setChangedBy(emp);
            ach.setComment("Dostawa - " + a.getLabId());
            ach.setWeight(Global.round(a.getArrivalQuantity(),2));
            ach.setAroma(a);
            a.setAromaChangeHistory(new HashSet<AromaChangeHistory>());
            a.getAromaChangeHistory().add(ach);

            dbc.saveObject(ach);
            JOptionPane.showMessageDialog(null, "Zarejestrowano do badania", "Informacja", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Sprawdź wprowadzone dane", "Błąd", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();

        }
    }//GEN-LAST:event_buttonRegisterToLaboratoryActionPerformed

    private void buttonNewAromaTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewAromaTypeActionPerformed

        String[] option = {"Cofnij"};
        int result = JOptionPane.showOptionDialog(this, new AddAromaTypePanel(), "Dodaj nowy typ aromatu", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);

        dbc.clearSession();
        dbc.openSession();
        alat = dbc.getAromaType();
        Object[] o = alat.toArray();
        Arrays.sort(o);

        comboBoxAromaType.removeAllItems();
        for (Object ob : o) {
            AromaType at = (AromaType) ob;
            comboBoxAromaType.addItem(at);
        }
        comboBoxAromaType.setSelectedItem(null);

        // resetInput();
    }//GEN-LAST:event_buttonNewAromaTypeActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNewAromaType;
    private javax.swing.JButton buttonNewProvider;
    private javax.swing.JButton buttonRegisterToLaboratory;
    private javax.swing.JCheckBox checkBoxVermin;
    private javax.swing.JComboBox comboBoxAromaType;
    private javax.swing.JComboBox comboBoxProvider;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel labelCoffeOwner1;
    private javax.swing.JLabel labelMain;
    private javax.swing.JLabel labelWeight;
    private javax.swing.JSpinner spinnerQuantity;
    // End of variables declaration//GEN-END:variables
}
