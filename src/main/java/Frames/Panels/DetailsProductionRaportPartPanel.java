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

import Listeners.CheckBoxDetailsListener;
import ProductionClasses.Pallete;
import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionCoffeeReturn;
import ProductionClasses.ProductionRaportCoffeeAssignment;
import ProductionClasses.ProductionRaportDirectPackage;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import SatiInterfaces.Details;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemysław
 */
public class DetailsProductionRaportPartPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShowcaseProductionRaportDailyPanel
     *
     * @param prp
     */
    private DataBaseConnector dbc;
    private ProductionRaportPart productionRaportPart;
    
    public DetailsProductionRaportPartPanel(ProductionRaportPart productionRaportPart) {
        initComponents();
        dbc = Global.getDataBaseConnector();
        dbc.openSession();
        this.productionRaportPart = productionRaportPart;
        if (productionRaportPart.isSealing()) {
            textFieldSealing.setText("TAK");
        } else {
            textFieldSealing.setText("NIE");
        }
        
        if (!productionRaportPart.getOtherInfo().equals("")) {
            textFieldOtherInfo.setText(productionRaportPart.getOtherInfo());
        } else {
            textFieldOtherInfo.setText("BRAK");
        }
        textFieldKGTotal.setText(Float.toString(productionRaportPart.getTotalWeight()));
        textFieldPCSTotal.setText(Float.toString(productionRaportPart.getTotalPcs()));
        textFieldOxygenAmmount.setText(Float.toString(productionRaportPart.getOxygen()));
        textFieldProductName.setText(productionRaportPart.getProductType().getProductName());
        textFieldBean.setText(Global.getProductTypeName(productionRaportPart.getType()));
        textFieldStickSize.setText(Float.toString(productionRaportPart.getStickSize()));
        textFieldTotalPalletes.setText(Integer.toString(productionRaportPart.getTotalPallete()));
        textFieldbatchInfo.setText(productionRaportPart.getBatchInfo());
        textFieldCompleteDate.setText(productionRaportPart.getRaportDate().toString());
        textFieldCompletedBy.setText(productionRaportPart.getEmp().toString());
        textFieldExpiryDate.setText(productionRaportPart.getExpiryDate().toString());
        
        DefaultTableModel dtm = (DefaultTableModel) tableDirectPackage.getModel();
        dtm.addTableModelListener(new CheckBoxDetailsListener(1));
        for (ProductionRaportDirectPackage prdp : productionRaportPart.getProductionRaportDirectPackage()) {
            dtm.addRow(new Object[]{prdp.getDirectPackage(), false});
        }
        
        dtm = (DefaultTableModel) tableProductionCoffee.getModel();
        
        for (ProductionRaportCoffeeAssignment prca : productionRaportPart.getProductionRaportCoffeeAssignment()) {
            String prefix = "";
            if (prca.getProductionCoffee().isReturned()) {
                prefix += "ZW ";
            }
            if (prca.getProductionCoffee().isUsed()) {
                prefix += "PP ";
            }
            dtm.addRow(new Object[]{prca.getProductionCoffee(), prefix + prca.getProductionCoffee().getProductType(), prca.getWeight(), false, false});
        }
        
        tableProductionCoffee.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableProductionCoffee.rowAtPoint(evt.getPoint());
                int col = tableProductionCoffee.columnAtPoint(evt.getPoint());
                if (col == 3) {
                    Details o = (Details) dbc.findResourceWithProductionCoffee(tableProductionCoffee.getValueAt(row, 0));
                    o.showDetails();
                    tableProductionCoffee.setValueAt(false, row, col);
                }
                
            }
        }
        );
        
        tableProductionCoffee.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableProductionCoffee.rowAtPoint(evt.getPoint());
                int col = tableProductionCoffee.columnAtPoint(evt.getPoint());
                if (col == 4) {
                    ArrayList<ProductionCoffeeReturn> alpcr = dbc.getProductionCoffeeReturnWithProductionCoffee((ProductionCoffee) tableProductionCoffee.getValueAt(row, 0));
                    if (alpcr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Brak komentarzy");
                    } else {
                        String[] options = new String[]{"OK"};
                        JOptionPane.showOptionDialog(null, new ShowProductionCoffeeReturnHistoryPanel(alpcr), "Komentarze", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    }
                    tableProductionCoffee.setValueAt(false, row, col);
                }
                
            }
        }
        );
        
        dtm = (DefaultTableModel) tablePallete.getModel();
        dtm.addTableModelListener(new CheckBoxDetailsListener(3));
        for (Pallete p : productionRaportPart.getPallete()) {
            dtm.addRow(new Object[]{p, p.getNetto(), p.getQuantity(), false});
        }
        
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        textFieldProductName = new javax.swing.JTextField();
        textFieldKGTotal = new javax.swing.JTextField();
        textFieldPCSTotal = new javax.swing.JTextField();
        textFieldbatchInfo = new javax.swing.JTextField();
        textFieldStickSize = new javax.swing.JTextField();
        textFieldOtherInfo = new javax.swing.JTextField();
        textFieldTotalPalletes = new javax.swing.JTextField();
        textFieldOxygenAmmount = new javax.swing.JTextField();
        textFieldSealing = new javax.swing.JTextField();
        textFieldBean = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductionCoffee = new javax.swing.JTable();
        textFieldCompletedBy = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        textFieldCompleteDate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDirectPackage = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePallete = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        textFieldExpiryDate = new javax.swing.JTextField();

        jLabel1.setText("Nazwa produktu: ");

        jLabel3.setText("Ilość palet: ");

        jLabel4.setText("Ilość kilogramów: ");

        jLabel5.setText("Ilość opakowań: ");

        jLabel6.setText("Nr partii:");

        jLabel11.setText("Wielkość stick: ");

        jLabel12.setText("Inne informacje: ");

        jLabel13.setText("Ilość tlenu: ");

        jLabel14.setText("Szczelność opakowań: ");

        jLabel15.setText("Ziarno/Mielona: ");

        tableProductionCoffee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Nazwa Kawy", "Przypisana ilość", "Szczegóły", "Komentarze"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableProductionCoffee);
        if (tableProductionCoffee.getColumnModel().getColumnCount() > 0) {
            tableProductionCoffee.getColumnModel().getColumn(0).setMinWidth(0);
            tableProductionCoffee.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableProductionCoffee.getColumnModel().getColumn(0).setMaxWidth(0);
            tableProductionCoffee.getColumnModel().getColumn(1).setPreferredWidth(250);
            tableProductionCoffee.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableProductionCoffee.getColumnModel().getColumn(3).setMinWidth(80);
            tableProductionCoffee.getColumnModel().getColumn(3).setPreferredWidth(80);
            tableProductionCoffee.getColumnModel().getColumn(3).setMaxWidth(80);
            tableProductionCoffee.getColumnModel().getColumn(4).setMinWidth(80);
            tableProductionCoffee.getColumnModel().getColumn(4).setPreferredWidth(80);
            tableProductionCoffee.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jLabel17.setText("Wykonał:");

        jLabel18.setText("Data:");

        jButton2.setText("Drukuj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        tableDirectPackage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Surowiec", "Szczegóły"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDirectPackage);
        if (tableDirectPackage.getColumnModel().getColumnCount() > 0) {
            tableDirectPackage.getColumnModel().getColumn(1).setMinWidth(80);
            tableDirectPackage.getColumnModel().getColumn(1).setPreferredWidth(80);
            tableDirectPackage.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        tablePallete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Paleta", "Netto", "Sztuki", "Etykieta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePallete);
        if (tablePallete.getColumnModel().getColumnCount() > 0) {
            tablePallete.getColumnModel().getColumn(3).setMinWidth(80);
            tablePallete.getColumnModel().getColumn(3).setPreferredWidth(80);
            tablePallete.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        jLabel2.setText("Data ważności:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldProductName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel4)
                                                    .addComponent(jLabel6))
                                                .addGap(13, 13, 13)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textFieldbatchInfo)
                                                    .addComponent(textFieldPCSTotal)
                                                    .addComponent(textFieldKGTotal)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel11))
                                                .addGap(20, 20, 20)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(textFieldStickSize)
                                                    .addComponent(textFieldOtherInfo)
                                                    .addComponent(textFieldExpiryDate))))
                                        .addGap(27, 27, 27)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel17)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel18)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldOxygenAmmount)
                            .addComponent(textFieldSealing)
                            .addComponent(textFieldTotalPalletes, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(textFieldBean, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(textFieldCompletedBy)
                            .addComponent(textFieldCompleteDate)))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textFieldProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldKGTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textFieldPCSTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textFieldbatchInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldStickSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(textFieldOtherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textFieldExpiryDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textFieldTotalPalletes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(textFieldOxygenAmmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldSealing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldBean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(textFieldCompletedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(textFieldCompleteDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            
            sb.append("").append(productionRaportPart.toString()).append(System.lineSeparator()).append(System.lineSeparator());
            
            sb.append("    ").append("Typ produktu:  ").append(productionRaportPart.getProductType()).append(System.lineSeparator());
            sb.append("    ").append("Data pakowania:  ").append(Global.timestampToStrDDMMYYYY(productionRaportPart.getRaportDate())).append(System.lineSeparator());
            sb.append("    ").append("Operator:  ").append(productionRaportPart.getEmp()).append(System.lineSeparator());
            sb.append("    ").append("Ilość palet:  ").append(productionRaportPart.getTotalPallete()).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("Wyprodukowano KG:  ").append(productionRaportPart.getTotalWeight()).append(System.lineSeparator());
            sb.append("    ").append("Wyprodukowano SZT:  ").append(productionRaportPart.getTotalPcs()).append(System.lineSeparator());
            sb.append("    ").append("Informacje dodatkowe  ").append(System.lineSeparator());
            
            sb.append("    ").append("Numer parti:  ").append(productionRaportPart.getBatchInfo()).append(System.lineSeparator());
            sb.append("    ").append("Użyte surowce:  ").append(System.lineSeparator());
            
            for (int i = 0; i < tableDirectPackage.getRowCount(); i++) {
                sb.append("      ").append(tableDirectPackage.getValueAt(i, 0).toString()).append(System.lineSeparator());
            }
            
            sb.append("    ").append("Ilość tlenu:  ").append(productionRaportPart.getOxygen()).append(System.lineSeparator());
            
            sb.append("    ").append(Global.getProductTypeName(productionRaportPart.getType())).append(System.lineSeparator());
            
            if (productionRaportPart.isSealing()) {
                sb.append("    ").append("Opakowania szczelne").append(System.lineSeparator());
            } else {
                sb.append("    ").append("Opakowania nieszczelne").append(System.lineSeparator());
            }
            
            sb.append("    ").append("Wielkość stick:  ").append(productionRaportPart.getStickSize()).append(System.lineSeparator());
            sb.append("    ").append("Inne informacje:  ").append(productionRaportPart.getOtherInfo()).append(System.lineSeparator()).append(System.lineSeparator());
            
            sb.append("    ").append("Wyprodukowane palety:  ").append(System.lineSeparator());
            
            for (Pallete p : productionRaportPart.getPallete()) {
                sb.append("      ").append(p.getEan128Num()).append(" ").append(p.getQuantity()).append(" szt. ").append(p.getNetto()).append(" Kg").append(System.lineSeparator());
            }
            
            sb.append("    ").append("Użyte kawy:  ").append(System.lineSeparator());
            
            for (ProductionRaportCoffeeAssignment prca : productionRaportPart.getProductionRaportCoffeeAssignment()) {
                
                sb.append("      ").append(prca.toString()).append(System.lineSeparator());
                
            }
            
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tableDirectPackage;
    private javax.swing.JTable tablePallete;
    private javax.swing.JTable tableProductionCoffee;
    private javax.swing.JTextField textFieldBean;
    private javax.swing.JTextField textFieldCompleteDate;
    private javax.swing.JTextField textFieldCompletedBy;
    private javax.swing.JTextField textFieldExpiryDate;
    private javax.swing.JTextField textFieldKGTotal;
    private javax.swing.JTextField textFieldOtherInfo;
    private javax.swing.JTextField textFieldOxygenAmmount;
    private javax.swing.JTextField textFieldPCSTotal;
    private javax.swing.JTextField textFieldProductName;
    private javax.swing.JTextField textFieldSealing;
    private javax.swing.JTextField textFieldStickSize;
    private javax.swing.JTextField textFieldTotalPalletes;
    private javax.swing.JTextField textFieldbatchInfo;
    // End of variables declaration//GEN-END:variables
}
