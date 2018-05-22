/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionCoffeeReturn;
import ProductionClasses.ProductionCoffeeSeek;
import ProductionClasses.ProductionRaportCardboard;
import ProductionClasses.ProductionRaportCoffeeAssignment;
import ProductionClasses.ProductionRaportDirectPackage;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import SatiInterfaces.Details;
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
    private ProductionRaportPart prp;

    public DetailsProductionRaportPartPanel(ProductionRaportPart prp) {
        initComponents();
        dbc = Global.getDataBaseConnector();
        dbc.openSession();
        this.prp = prp;
        if (prp.isSealing()) {
            textFieldSealing.setText("TAK");
        } else {
            textFieldSealing.setText("NIE");
        }
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        for (ProductionRaportDirectPackage prdp : prp.getProductionRaportDirectPackage()) {
            dtm.addRow(new Object[]{prdp.getDirectPackage(), false});
        }

        if (!prp.getOtherInfo().equals("")) {
            textFieldOtherInfo.setText(prp.getOtherInfo());
        } else {
            textFieldOtherInfo.setText("BRAK");
        }
        textFieldKGTotal.setText(Float.toString(prp.getTotalWeight()));
        textFieldKGRest.setText(Float.toString(prp.getRestWeight()));
        textFieldPCSTotal.setText(Float.toString(prp.getTotalPcs()));
        textFieldPCSRest.setText(Float.toString(prp.getRestPcs()));
        textFieldOxygenAmmount.setText(Float.toString(prp.getOxygen()));
        textFieldPalleteSize.setText((Float.toString(prp.getKGperPallete()) + "KG/" + Float.toString(prp.getPCSperPallete()) + "szt"));

        textFieldProductName.setText(prp.getProductType().getProductName());

        textFieldBean.setText(Global.getProductTypeName(prp.getType()));
        textFieldStickSize.setText(Float.toString(prp.getStickSize()));
        textFieldTotalPalletes.setText(Integer.toString(prp.getTotalPallete()));
        textFieldbatchInfo.setText(prp.getBatchInfo());

        textFieldCompleteDate.setText(prp.getRaportDate().toString());
        textFieldCompletedBy.setText(prp.getEmp().toString());

        dtm = (DefaultTableModel) jTable1.getModel();

        for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {
            String prefix = "";
            if (prca.getProductionCoffee().isReturned()) {
                prefix += "ZW ";
            }
            if (prca.getProductionCoffee().isUsed()) {
                prefix += "PP ";
            }

            dtm.addRow(new Object[]{prca.getProductionCoffee(), prefix + prca.getProductionCoffee().getProductType(), prca.getWeight(), false, false});

        }

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());
                int col = jTable1.columnAtPoint(evt.getPoint());
                if (col == 3) {
                    Details o = (Details) dbc.findResourceWithProductionCoffee(jTable1.getValueAt(row, 0));
                    o.showDetails();
                    jTable1.setValueAt(false, row, col);
                }

            }
        }
        );

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable1.rowAtPoint(evt.getPoint());
                int col = jTable1.columnAtPoint(evt.getPoint());
                if (col == 4) {
                    ArrayList<ProductionCoffeeReturn> alpcr = dbc.getProductionCoffeeReturnWithProductionCoffee((ProductionCoffee) jTable1.getValueAt(row, 0));
                    if (alpcr.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Brak komentarzy");
                    } else {
                        String[] options = new String[]{"OK"};
                        JOptionPane.showOptionDialog(null, new ShowProductionCoffeeReturnHistoryPanel(alpcr), "Komentarze", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                    }
                    jTable1.setValueAt(false, row, col);
                }

            }
        }
        );

        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = jTable2.rowAtPoint(evt.getPoint());
                int col = jTable2.columnAtPoint(evt.getPoint());
                if (col == 1) {
                    Details o = (Details) jTable2.getValueAt(row, 0);
                    o.showDetails();
                    jTable2.setValueAt(false, row, col);
                }

            }
        }
        );

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        textFieldPalleteSize = new javax.swing.JTextField();
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
        jTable1 = new javax.swing.JTable();
        textFieldCompletedBy = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        textFieldCompleteDate = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        textFieldKGRest = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        textFieldPCSRest = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jLabel1.setText("Nazwa produktu: ");

        jLabel2.setText("Wielkość palety: ");

        jLabel3.setText("Ilość palet: ");

        jLabel4.setText("Ilość kilogramów: ");

        jLabel5.setText("Ilość opakowań: ");

        jLabel6.setText("Nr partii:");

        jLabel11.setText("Wielkość stick: ");

        jLabel12.setText("Inne informacje: ");

        jLabel13.setText("Ilość tlenu: ");

        jLabel14.setText("Szczelność opakowań: ");

        jLabel15.setText("Ziarno/Mielona: ");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setMinWidth(80);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(80);
            jTable1.getColumnModel().getColumn(4).setMinWidth(80);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(80);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        jLabel17.setText("Wykonał:");

        jLabel18.setText("Data:");

        jButton2.setText("Drukuj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel16.setText("Razem");

        jLabel19.setText("Reszta");

        jLabel20.setText("Razem");

        jLabel21.setText("Reszta");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(1).setMinWidth(80);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(80);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textFieldProductName))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(31, 31, 31)
                                .addComponent(textFieldStickSize))
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel16)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textFieldKGTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel20)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textFieldPCSTotal)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel19))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textFieldKGRest, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                            .addComponent(textFieldPCSRest)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textFieldPalleteSize, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                            .addComponent(textFieldbatchInfo)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(textFieldOtherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldCompletedBy, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(textFieldCompleteDate)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textFieldBean)
                                    .addComponent(textFieldOxygenAmmount)
                                    .addComponent(textFieldSealing)
                                    .addComponent(textFieldTotalPalletes, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                            .addComponent(jLabel2)
                            .addComponent(textFieldPalleteSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textFieldKGTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel19)
                            .addComponent(textFieldKGRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textFieldPCSTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(textFieldPCSRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(textFieldbatchInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGap(26, 26, 26))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(textFieldBean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(textFieldCompletedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textFieldStickSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(textFieldCompleteDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(textFieldOtherInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            StringBuilder sb = new StringBuilder();

            sb.append("").append(prp.toString()).append(System.lineSeparator()).append(System.lineSeparator());

            sb.append("    ").append("Typ produktu:  ").append(prp.getProductType()).append(System.lineSeparator());
            sb.append("    ").append("Data pakowania:  ").append(Global.timestampToStrDDMMYYYY(prp.getRaportDate())).append(System.lineSeparator());
            sb.append("    ").append("Operator:  ").append(prp.getEmp()).append(System.lineSeparator());
            sb.append("    ").append("Wielkość palety:  ").append(prp.getPCSperPallete()).append("szt/").append(prp.getKGperPallete()).append("Kg").append(System.lineSeparator());
            sb.append("    ").append("Ilość palet:  ").append(prp.getTotalPallete()).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("Wyprodukowano KG:  ").append(prp.getTotalWeight()).append(System.lineSeparator());
            sb.append("    ").append("Reszta KG:  ").append(prp.getRestWeight()).append(System.lineSeparator());
            sb.append("    ").append("Wyprodukowano SZT:  ").append(prp.getTotalPcs()).append(System.lineSeparator());
            sb.append("    ").append("Reszta SZT:  ").append(prp.getRestPcs()).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("Informacje dodatkowe  ").append(System.lineSeparator());

            sb.append("    ").append("Numer parti:  ").append(prp.getBatchInfo()).append(System.lineSeparator());
            sb.append("    ").append("Użyte surowce:  ").append(System.lineSeparator());

            for (int i = 0; i < jTable2.getRowCount(); i++) {
                sb.append("      ").append(jTable2.getValueAt(i, 0).toString()).append(System.lineSeparator());
            }

            sb.append("    ").append("Ilość tlenu:  ").append(prp.getOxygen()).append(System.lineSeparator());

            sb.append("    ").append(Global.getProductTypeName(prp.getType())).append(System.lineSeparator());

            if (prp.isSealing()) {
                sb.append("    ").append("Opakowania szczelne").append(System.lineSeparator());
            } else {
                sb.append("    ").append("Opakowania nieszczelne").append(System.lineSeparator());
            }

            sb.append("    ").append("Wielkość stick:  ").append(prp.getStickSize()).append(System.lineSeparator());
            sb.append("    ").append("Inne informacje:  ").append(prp.getOtherInfo()).append(System.lineSeparator()).append(System.lineSeparator());

            sb.append("    ").append("Użyte kawy:  ").append(System.lineSeparator());

            for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {

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
        } catch (Exception e) {
            e.printStackTrace();
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField textFieldBean;
    private javax.swing.JTextField textFieldCompleteDate;
    private javax.swing.JTextField textFieldCompletedBy;
    private javax.swing.JTextField textFieldKGRest;
    private javax.swing.JTextField textFieldKGTotal;
    private javax.swing.JTextField textFieldOtherInfo;
    private javax.swing.JTextField textFieldOxygenAmmount;
    private javax.swing.JTextField textFieldPCSRest;
    private javax.swing.JTextField textFieldPCSTotal;
    private javax.swing.JTextField textFieldPalleteSize;
    private javax.swing.JTextField textFieldProductName;
    private javax.swing.JTextField textFieldSealing;
    private javax.swing.JTextField textFieldStickSize;
    private javax.swing.JTextField textFieldTotalPalletes;
    private javax.swing.JTextField textFieldbatchInfo;
    // End of variables declaration//GEN-END:variables
}
