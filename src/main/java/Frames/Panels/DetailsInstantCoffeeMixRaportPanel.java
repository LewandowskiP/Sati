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

import GreenCoffeeClasses.CoffeeGreen;
import GreenCoffeeClasses.CoffeeType;
import ProductClasses.InstantCoffeeMixPart;
import ProductClasses.InstantCoffeeMixRaport;
import ProductionManagement.Global;
import java.util.Arrays;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemysław
 */
public class DetailsInstantCoffeeMixRaportPanel extends javax.swing.JPanel {

    private String sealToStr(Boolean a) {
        if (a) {
            return "TAK";
        } else {
            return "NIE";
        }
    }

    /**
     * Creates new form InstantCoffeeMixRaportShowcasePanel
     */
    public DetailsInstantCoffeeMixRaportPanel(InstantCoffeeMixRaport icmr) {
        initComponents();
        labelDate.setText(Global.timestampToStrDDMMYYYY(icmr.getMixDate()));
        labelEmployee.setText(icmr.getMixedBy().toString());
        labelTotalWeight.setText("Suma: " + Float.toString(icmr.getWeight()));
        textPaneOtherInfo.setText(icmr.getOtherInfo());
        DefaultTableModel dtm = (DefaultTableModel) tableInstantCoffeeMixPart.getModel();

        if (icmr.getInstantCoffeeMixPart().size() > 0) {
            Object[] toSort = icmr.getInstantCoffeeMixPart().toArray();
            Arrays.sort(toSort);

            for (Object o : toSort) {
                InstantCoffeeMixPart icmp = (InstantCoffeeMixPart) o;
                dtm.addRow(new Object[]{icmp.getCoffeeGreen(), icmp.getCardBoardNumber(), icmp.getSerialNumber(), sealToStr(icmp.isSealOk()), null, icmp.getWeight()});
            }

            CoffeeType tmp = null;
            float percentSum = 0;
            int perctPos = 0;
            for (int i = 0; i < toSort.length; i++) {
                if (tmp == null) {
                    tmp = ((InstantCoffeeMixPart) toSort[i]).getCoffeeGreen().getCoffeeType();
                    perctPos = i;
                    percentSum = percentSum + 100 * (((InstantCoffeeMixPart) toSort[i]).getWeight() / (icmr.getWeight()));
                } else {
                    if (tmp != ((InstantCoffeeMixPart) toSort[i]).getCoffeeGreen().getCoffeeType()) {
                        tableInstantCoffeeMixPart.setValueAt(Global.round(percentSum, 2), perctPos, 4);
                        percentSum = 0 + 100 * (((InstantCoffeeMixPart) toSort[i]).getWeight() / (icmr.getWeight()));
                        perctPos = i;
                        tmp = ((InstantCoffeeMixPart) toSort[i]).getCoffeeGreen().getCoffeeType();
                    } else {
                        percentSum = percentSum + 100 * (((InstantCoffeeMixPart) toSort[i]).getWeight() / (icmr.getWeight()));
                    }
                }

            }
            tableInstantCoffeeMixPart.setValueAt(Global.round(percentSum, 2), perctPos, 4);
        }

        int range = 11 - dtm.getRowCount();
        for (int i = 0; i < range; i++) {
            dtm.addRow(new Object[]{null, null, null, null, null, null});
        }
        dtm.addRow(new Object[]{icmr.getMixedBy(), Global.timestampToStrDDMMYYYY(icmr.getMixDate()), null, null, null, icmr.getWeight()});
        tableInstantCoffeeMixPart.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableInstantCoffeeMixPart.rowAtPoint(evt.getPoint());
                int col = tableInstantCoffeeMixPart.columnAtPoint(evt.getPoint());
                if (col == 0) {
                    CoffeeGreen cg = (CoffeeGreen) tableInstantCoffeeMixPart.getValueAt(row, col);
                    cg.showDetails();
                }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tableInstantCoffeeMixPart = new javax.swing.JTable();
        labelEmployee = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelTotalWeight = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textPaneOtherInfo = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        tableInstantCoffeeMixPart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kawa", "Nr Kartona", "Nr Parti", "Szczel.", "[%]", "Waga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
            tableInstantCoffeeMixPart.getColumnModel().getColumn(1).setMinWidth(100);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(1).setMaxWidth(100);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(2).setMinWidth(100);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(2).setMaxWidth(100);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(3).setMinWidth(60);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(3).setPreferredWidth(60);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(3).setMaxWidth(60);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(4).setMinWidth(50);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(4).setMaxWidth(50);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(5).setMinWidth(100);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(5).setPreferredWidth(100);
            tableInstantCoffeeMixPart.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        labelEmployee.setText("jLabel1");

        labelDate.setText("jLabel1");

        labelTotalWeight.setText("jLabel1");

        jScrollPane2.setViewportView(textPaneOtherInfo);

        jButton1.setText("Drukuj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelTotalWeight)
                        .addGap(127, 127, 127))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(labelEmployee)
                                    .addGap(108, 108, 108)
                                    .addComponent(labelDate))))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelEmployee)
                            .addComponent(labelDate))
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalWeight)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
            PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
            if (services.length != 0) {
                if (defaultService != null) {
                    PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
                    aset.add(OrientationRequested.LANDSCAPE);
                    PrintService service = PrintServiceLookup.lookupDefaultPrintService();
                    tableInstantCoffeeMixPart.print(JTable.PrintMode.FIT_WIDTH, null, null, false, aset, false, service);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelEmployee;
    private javax.swing.JLabel labelTotalWeight;
    private javax.swing.JTable tableInstantCoffeeMixPart;
    private javax.swing.JTextPane textPaneOtherInfo;
    // End of variables declaration//GEN-END:variables
}
