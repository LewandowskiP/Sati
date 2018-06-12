/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import GreenCoffeeClasses.Provider;
import ProductClasses.DirectPackage;
import ProductClasses.DirectPackageType;
import ProductionManagement.Global;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class EditDirectPackagePanel extends javax.swing.JPanel {

    /**
     * Creates new form AddGreenCoffeeMagazynierPanel
     */
    ArrayList<DirectPackageType> aldpt;
    ArrayList<Provider> alp;
    DataBaseConnector dbc;
    Employee emp;
    private final DirectPackage directPackage;

    public EditDirectPackagePanel(DirectPackage dp) {
        initComponents();
        this.directPackage = dp;

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
        comboBoxDirectPackageType.setSelectedItem(dp.getDirectPackageType());

        alp = dbc.getProvider();
        o = alp.toArray();
        Arrays.sort(o);

        comboBoxProvider.removeAllItems();
        for (Object ob : o) {
            comboBoxProvider.addItem(ob);
        }
        comboBoxProvider.setSelectedItem(dp.getProvider());

        spinnerWeight.setValue(dp.getWeight());
        spinnerWeight.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLabId = new javax.swing.JLabel();
        labelWeight = new javax.swing.JLabel();
        buttonRegisterToLaboratory = new javax.swing.JButton();
        labelCoffeOwner1 = new javax.swing.JLabel();
        comboBoxDirectPackageType = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        comboBoxProvider = new javax.swing.JComboBox();
        buttonNewProvider = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        spinnerWeight = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();

        labelLabId.setText("DIRECTPACKAGEID");

        labelWeight.setText("Ilość");

        buttonRegisterToLaboratory.setText("Zatwierdź zmiany");
        buttonRegisterToLaboratory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegisterToLaboratoryActionPerformed(evt);
            }
        });

        labelCoffeOwner1.setText("Typ materiału");

        jLabel1.setText("Producent");

        buttonNewProvider.setText("+");
        buttonNewProvider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewProviderActionPerformed(evt);
            }
        });

        spinnerWeight.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(1.0f)));

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
                    .addComponent(labelLabId)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jLabel3)
                                .addGap(219, 219, 219))
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
                                    .addComponent(spinnerWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(buttonRegisterToLaboratory))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLabId)
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
                .addComponent(buttonRegisterToLaboratory)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonRegisterToLaboratoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegisterToLaboratoryActionPerformed
        try {
            dbc.startTransation();
            directPackage.setDirectPackageType((DirectPackageType) comboBoxDirectPackageType.getSelectedItem());
            directPackage.setProvider((Provider) comboBoxProvider.getSelectedItem());
            dbc.updateTransation(directPackage);
            dbc.commitTransation();
        } catch (Exception e) {
            dbc.rollbackTransation();
            JOptionPane.showMessageDialog(null, "Sprawdź wprowadzone dane", "Błąd", JOptionPane.ERROR_MESSAGE);
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
        comboBoxProvider.setSelectedItem(directPackage.getProvider());

    }//GEN-LAST:event_buttonNewProviderActionPerformed

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
            comboBoxDirectPackageType.setSelectedItem(directPackage.getDirectPackageType());

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNewProvider;
    private javax.swing.JButton buttonRegisterToLaboratory;
    private javax.swing.JComboBox comboBoxDirectPackageType;
    private javax.swing.JComboBox comboBoxProvider;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelCoffeOwner1;
    private javax.swing.JLabel labelLabId;
    private javax.swing.JLabel labelWeight;
    private javax.swing.JSpinner spinnerWeight;
    // End of variables declaration//GEN-END:variables
}
