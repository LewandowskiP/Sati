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

import ProductionClasses.ProductionCoffeeExternalReturn;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.Global;
import ProductionManagement.LabTest;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JTextArea;

/**
 *
 * @author Przemysław
 */
public class DetailsProductionCoffeeExternalReturnPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShowcaseProductionCoffeeExternalReturnPanel
     */
    ProductionCoffeeExternalReturn pcer;
    ProductionRaportPart prp;
    LabTest lt;

    public DetailsProductionCoffeeExternalReturnPanel(ProductionCoffeeExternalReturn pcer) {
        initComponents();
        this.pcer = pcer;
        lt = pcer.getLabTest();
        prp = pcer.getProductionRaportPart();
        if (pcer.getProductionCoffee() == null) {
            textFieldCoffeeName.setText(pcer.getProductionRaportPart().getProductType().toString());
            textFieldCurrentWeight.setText(Float.toString(pcer.getWeight()));
        } else {
            textFieldCoffeeName.setText(pcer.getProductionCoffee().getProductType().toString());
            textFieldCurrentWeight.setText(Float.toString(pcer.getProductionCoffee().getWeight()));
        }
        textFieldLabId.setText(pcer.getLabId());
        textFieldOtherInfo.setText(pcer.getReturnInfo());
        textFieldReturnDate.setText(Global.timestampToStrDDMMYYYY(pcer.getReturnDate()));
        textFieldReturnWeight.setText(Float.toString(pcer.getWeight()));
        textFieldStoreman.setText(pcer.getStoremanId().toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        textFieldCoffeeName = new javax.swing.JTextField();
        textFieldLabId = new javax.swing.JTextField();
        textFieldReturnWeight = new javax.swing.JTextField();
        textFieldCurrentWeight = new javax.swing.JTextField();
        textFieldStoreman = new javax.swing.JTextField();
        textFieldReturnDate = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textFieldOtherInfo = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();

        jButton1.setText("Pokaż raport produkcji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Nazwa kawy");

        jLabel2.setText("Numer zlecenia kontroli");

        jLabel3.setText("Waga przy zwrocie");

        jLabel4.setText("Aktualna waga");

        jLabel5.setText("Zmagazynował");

        jLabel6.setText("Data zwrotu");

        jButton2.setText("Zobacz raport z badania");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel7.setText("Dodatkowe informacje przy zwrocie");

        textFieldCoffeeName.setText("jTextField1");

        textFieldLabId.setText("jTextField1");

        textFieldReturnWeight.setText("jTextField1");

        textFieldCurrentWeight.setText("jTextField1");

        textFieldStoreman.setText("jTextField1");

        textFieldReturnDate.setText("jTextField1");

        textFieldOtherInfo.setColumns(20);
        textFieldOtherInfo.setRows(5);
        jScrollPane1.setViewportView(textFieldOtherInfo);

        jButton3.setText("Drukuj");
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldCoffeeName, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(textFieldLabId)
                            .addComponent(textFieldReturnWeight)
                            .addComponent(textFieldCurrentWeight)
                            .addComponent(textFieldStoreman)
                            .addComponent(textFieldReturnDate)
                            .addComponent(jScrollPane1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
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
                    .addComponent(textFieldReturnWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFieldCurrentWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textFieldStoreman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textFieldReturnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (lt.getLabAssistant() != null) {
            lt.showDetails();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        prp.showDetails();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            StringBuilder sb = new StringBuilder();

            sb.append("Szczegóły kawy zwróconej ").append(pcer.toString()).append(System.lineSeparator()).append(System.lineSeparator());

            sb.append("    ").append("Numer zlecenia kontroli:  ").append(pcer.getLabId()).append(System.lineSeparator());
            sb.append("    ").append("Numer partii pakowania produktu:  ").append(pcer.getProductionRaportPart().getBatchInfo()).append(System.lineSeparator());
            sb.append("    ").append("Nazwa produktu:  ").append(prp.getProductType()).append(System.lineSeparator());

            sb.append("    ").append("Data zwrotu:  ").append(Global.timestampToStrDDMMYYYY(pcer.getReturnDate())).append(System.lineSeparator());
            sb.append("    ").append("Zmagazynował(a):  ").append(pcer.getStoremanId().toString()).append(System.lineSeparator());

            sb.append("    ").append("Waga podczas zwrotu:  ").append(pcer.getWeight()).append(System.lineSeparator());

            sb.append("    ").append("Komentarz zwrotu:  ").append(pcer.getReturnInfo()).append(System.lineSeparator()).append(System.lineSeparator());

            sb.append("    ").append("Dane badania: ").append(System.lineSeparator());
            if (pcer.getLabTest().isAccepted()) {
                sb.append("    ").append("    ").append("Stan: ").append("ZATWIERDZONY").append(System.lineSeparator());
            } else {
                sb.append("    ").append("    ").append("Stan: ").append("ODRZUCONY").append(System.lineSeparator());
            }
            if (pcer.getLabTest().isVermin()) {
                sb.append("    ").append("    ").append("Szkodniki wykryte.").append(System.lineSeparator());
            } else {
                sb.append("    ").append("    ").append("Szkodniki nie wykryte.").append(System.lineSeparator());
            }
            sb.append("    ").append("    ").append("Wynik badania organoleptycznego: ").append(lt.getOrganoleptic()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wynik badania technicznego: ").append(lt.getTechnical()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Data badania: ").append((Global.timestampToStrDDMMYYYY(lt.getExamineDate()))).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Badanie wykonał(a): ").append(lt.getLabAssistant().toString()).append(System.lineSeparator()).append(System.lineSeparator());

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
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textFieldCoffeeName;
    private javax.swing.JTextField textFieldCurrentWeight;
    private javax.swing.JTextField textFieldLabId;
    private javax.swing.JTextArea textFieldOtherInfo;
    private javax.swing.JTextField textFieldReturnDate;
    private javax.swing.JTextField textFieldReturnWeight;
    private javax.swing.JTextField textFieldStoreman;
    // End of variables declaration//GEN-END:variables
}
