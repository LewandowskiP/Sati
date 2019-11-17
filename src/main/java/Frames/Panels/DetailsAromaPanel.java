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

import ProductClasses.Aroma;
import ProductionManagement.Global;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Przemysław
 */
public class DetailsAromaPanel extends javax.swing.JPanel {

    /**
     * Creates new form GreenCoffeeDetailsPanel
     */
    private final Aroma aroma;

    private void loadData() {
        textFieldArrivalWeight.setText(Float.toString(aroma.getArrivalQuantity()));
        textFieldCurrentWeight.setText(Float.toString(aroma.getQuantity()));
        textFieldCoffeeName.setText(aroma.getAromaType().toString());
        textFieldLabId.setText(aroma.getLabId());
        textFieldProvider.setText(aroma.getProvider().toString());
        textFieldStoreman.setText(aroma.getStoreman().toString());
        textFieldArrivalDate.setText(aroma.getArrivalDate().toString());
    }

    public DetailsAromaPanel(Aroma a) {
        initComponents();
        aroma = a;
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        buttonShowLabTest = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        textFieldCoffeeName = new javax.swing.JTextField();
        textFieldLabId = new javax.swing.JTextField();
        textFieldProvider = new javax.swing.JTextField();
        textFieldArrivalWeight = new javax.swing.JTextField();
        textFieldCurrentWeight = new javax.swing.JTextField();
        textFieldStoreman = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textFieldArrivalDate = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonEdit2 = new javax.swing.JButton();

        jLabel1.setText("Nazwa aromatu");

        jLabel2.setText("Numer zlecenia kontroli");

        jLabel3.setText("Producent");

        jLabel8.setText("Waga przy dostawie");

        jLabel9.setText("Aktualna waga");

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

        textFieldArrivalWeight.setText("jTextField8");

        textFieldCurrentWeight.setText("jTextField9");

        textFieldStoreman.setText("jTextField11");

        jLabel11.setText("Data dostawy");

        textFieldArrivalDate.setText("jTextField1");

        jButton1.setText("Pokaż zmiany");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Drukuj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonEdit2.setText("Edytuj");
        buttonEdit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEdit2ActionPerformed(evt);
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
                        .addComponent(buttonShowLabTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonEdit2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldCoffeeName)
                            .addComponent(textFieldLabId)
                            .addComponent(textFieldProvider)
                            .addComponent(textFieldArrivalWeight)
                            .addComponent(textFieldCurrentWeight)
                            .addComponent(textFieldStoreman, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
                            .addComponent(textFieldArrivalDate))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(textFieldProvider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textFieldArrivalWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textFieldCurrentWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(buttonShowLabTest)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonEdit2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonShowLabTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonShowLabTestActionPerformed
        if (aroma.getLabTest().getLabAssistant() != null) {
            aroma.getLabTest().showDetails();
        }
    }//GEN-LAST:event_buttonShowLabTestActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new ShowResourceAromaChangeHistoryPanel(aroma.getAromaChangeHistory()), "Podgląd zmian.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            StringBuilder sb = new StringBuilder();

            sb.append("Szczegóły aromatu ").append(aroma.toString()).append(System.lineSeparator()).append(System.lineSeparator());

            sb.append("    ").append("Numer zlecenia kontroli:  ").append(aroma.getLabId()).append(System.lineSeparator());
            sb.append("    ").append("Typ aromatu:  ").append(aroma.getAromaType()).append(System.lineSeparator());
            sb.append("    ").append("Data dostawy:  ").append(Global.timestampToStrDDMMYYYY(aroma.getArrivalDate())).append(System.lineSeparator());
            sb.append("    ").append("Zmagazynował(a):  ").append(aroma.getStoreman().toString()).append(System.lineSeparator());
            sb.append("    ").append("Producent:  ").append(aroma.getProvider()).append(System.lineSeparator());
            sb.append("    ").append("Waga podczas dostawy:  ").append(aroma.getArrivalQuantity()).append(System.lineSeparator());
            sb.append("    ").append("Aktualna waga:  ").append(aroma.getQuantity()).append(System.lineSeparator()).append(System.lineSeparator());

            sb.append("    ").append("Dane badania: ").append(System.lineSeparator());
            if (aroma.getLabTest().isAccepted()) {
                sb.append("    ").append("    ").append("Stan: ").append("ZATWIERDZONY").append(System.lineSeparator());
            } else {
                sb.append("    ").append("    ").append("Stan: ").append("ODRZUCONY").append(System.lineSeparator());
            }
            if (aroma.getLabTest().isVermin()) {
                sb.append("    ").append("    ").append("Szkodniki wykryte.").append(System.lineSeparator());
            } else {
                sb.append("    ").append("    ").append("Szkodniki nie wykryte.").append(System.lineSeparator());
            }
            sb.append("    ").append("    ").append("Wynik badania organoleptycznego: ").append(aroma.getLabTest().getOrganoleptic()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wynik badania technicznego: ").append(aroma.getLabTest().getTechnical()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Data badania: ").append((Global.timestampToStrDDMMYYYY(aroma.getLabTest().getExamineDate()))).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Badanie wykonał(a): ").append(aroma.getLabTest().getLabAssistant().toString()).append(System.lineSeparator());
            sb.append(aroma.getLabTest().getDetails());
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonEdit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEdit2ActionPerformed
        if (Global.getEmployee().getJobPosition() == Global.ADMINISTRATOR
                || Global.getEmployee().getJobPosition() == Global.STOREMAN
                || Global.getEmployee().getJobPosition() == Global.OFFICE
                || Global.getEmployee().getJobPosition() == Global.LAB_ASSISTANT) {
            aroma.edit();
        } else {
            JOptionPane.showMessageDialog(null, "Brak uprawnień!", "Uwaga!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonEdit2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEdit2;
    private javax.swing.JButton buttonShowLabTest;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField textFieldArrivalDate;
    private javax.swing.JTextField textFieldArrivalWeight;
    private javax.swing.JTextField textFieldCoffeeName;
    private javax.swing.JTextField textFieldCurrentWeight;
    private javax.swing.JTextField textFieldLabId;
    private javax.swing.JTextField textFieldProvider;
    private javax.swing.JTextField textFieldStoreman;
    // End of variables declaration//GEN-END:variables
}
