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

import ProductClasses.DirectPackage;
import ProductionManagement.Global;
import ProductionManagement.LabTest;
import java.awt.print.PrinterException;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Przemysław
 */
public class DetailsDirectPackagePanel extends javax.swing.JPanel {

    /**
     * Creates new form GreenCoffeeDetailsPanel
     */
    private final DirectPackage directPackage;

    private void loadData() {
        textFieldCoffeeName.setText(directPackage.getDirectPackageType().toString());
        textFieldLabId.setText(directPackage.getLabId());
        textFieldProvider.setText(directPackage.getProvider().toString());
        textFieldStoreman.setText(directPackage.getStoreman().toString());
        textFieldArrivalDate.setText(directPackage.getArrivalDate().toString());
        textFieldWeight.setText(String.valueOf(directPackage.getWeight()));
    }

    public DetailsDirectPackagePanel(DirectPackage dp) {
        initComponents();
        directPackage = dp;
        loadData();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buttonShowLabTest = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        textFieldCoffeeName = new javax.swing.JTextField();
        textFieldLabId = new javax.swing.JTextField();
        textFieldProvider = new javax.swing.JTextField();
        textFieldStoreman = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textFieldArrivalDate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        textFieldWeight = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        buttonEdit = new javax.swing.JButton();

        jLabel1.setText("Nazwa opakowania");

        jLabel2.setText("Numer zlecenia kontroli");

        jLabel3.setText("Producent");

        buttonShowLabTest.setText("Zobacz raport z badania");
        buttonShowLabTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonShowLabTestActionPerformed(evt);
            }
        });

        jLabel10.setText("Zmagazynował");

        textFieldCoffeeName.setText("jTextField1");

        textFieldLabId.setText("jTextField2");

        textFieldProvider.setText("jTextField3");

        textFieldStoreman.setText("jTextField11");

        jLabel11.setText("Data dostawy");

        textFieldArrivalDate.setText("jTextField1");

        jButton2.setText("Drukuj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        textFieldWeight.setText("jTextField1");

        jLabel4.setText("Ilość");

        buttonEdit.setText("Edytuj");
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
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(92, 92, 92))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldCoffeeName, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                            .addComponent(textFieldProvider)
                            .addComponent(textFieldLabId)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(textFieldStoreman, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonShowLabTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldWeight)
                            .addComponent(textFieldArrivalDate, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldCoffeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textFieldLabId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFieldProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textFieldStoreman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textFieldArrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonShowLabTest)
                    .addComponent(jButton2)
                    .addComponent(buttonEdit))
                .addContainerGap(77, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonShowLabTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowLabTestActionPerformed
        if (directPackage.getLabTest().getLabAssistant() != null) {
            directPackage.getLabTest().showDetails();
        }
    }//GEN-LAST:event_buttonShowLabTestActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            StringBuilder sb = new StringBuilder();

            sb.append("Szczegóły opakowania bezpośredniego ").append(directPackage.toString()).append(System.lineSeparator()).append(System.lineSeparator());

            sb.append("    ").append("Numer zlecenia kontroli:  ").append(directPackage.getLabId()).append(System.lineSeparator());
            sb.append("    ").append("Typ opakowania bezpośredniego:  ").append(directPackage.getDirectPackageType()).append(System.lineSeparator());
            sb.append("    ").append("Data dostawy:  ").append(Global.timestampToStrDDMMYYYY(directPackage.getArrivalDate())).append(System.lineSeparator());
            sb.append("    ").append("Zmagazynował(a):  ").append(directPackage.getStoreman().toString()).append(System.lineSeparator());
            sb.append("    ").append("Producent:  ").append(directPackage.getProvider()).append(System.lineSeparator());

            sb.append("    ").append("Dane badania: ").append(System.lineSeparator());
            if (directPackage.getLabTest().isAccepted()) {
                sb.append("    ").append("    ").append("Stan: ").append("ZATWIERDZONY").append(System.lineSeparator());
            } else {
                sb.append("    ").append("    ").append("Stan: ").append("ODRZUCONY").append(System.lineSeparator());
            }
            if (directPackage.getLabTest().isVermin()) {
                sb.append("    ").append("    ").append("Szkodniki wykryte.").append(System.lineSeparator());
            } else {
                sb.append("    ").append("    ").append("Szkodniki nie wykryte.").append(System.lineSeparator());
            }
            sb.append("    ").append("    ").append("Wynik badania organoleptycznego: ").append(directPackage.getLabTest().getOrganoleptic()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wynik badania technicznego: ").append(directPackage.getLabTest().getTechnical()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Data badania: ").append((Global.timestampToStrDDMMYYYY(directPackage.getLabTest().getExamineDate()))).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Badanie wykonał(a): ").append(directPackage.getLabTest().getLabAssistant().toString()).append(System.lineSeparator());

            sb.append(directPackage.getLabTest().getDetails());

            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
            if (services.length != 0) {
                if (defaultService != null) {
                    JTextArea text = new JTextArea(sb.toString());
                    PrintService service = PrintServiceLookup.lookupDefaultPrintService();
                    text.print(null, null, false, service, null, false);
                }
            }
        } catch (PrinterException e) {
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        if (Global.getEmployee().getJobPosition() == Global.ADMINISTRATOR
                || Global.getEmployee().getJobPosition() == Global.STOREMAN
                || Global.getEmployee().getJobPosition() == Global.OFFICE
                || Global.getEmployee().getJobPosition() == Global.LAB_ASSISTANT) {
            directPackage.edit();
        } else {
            JOptionPane.showMessageDialog(null, "Brak uprawnień!", "Uwaga!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonShowLabTest;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField textFieldArrivalDate;
    private javax.swing.JTextField textFieldCoffeeName;
    private javax.swing.JTextField textFieldLabId;
    private javax.swing.JTextField textFieldProvider;
    private javax.swing.JTextField textFieldStoreman;
    private javax.swing.JTextField textFieldWeight;
    // End of variables declaration//GEN-END:variables
}
