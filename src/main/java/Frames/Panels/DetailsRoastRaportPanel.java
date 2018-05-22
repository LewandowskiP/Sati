/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import GreenCoffeeClasses.CoffeeGreen;
import GreenCoffeeClasses.CoffeeType;
import ProductClasses.Aroma;
import ProductClasses.RoastAromaPart;
import ProductClasses.RoastGreenCoffeePart;
import ProductClasses.RoastPart;
import ProductClasses.RoastRaport;
import ProductionManagement.Global;
import java.util.Arrays;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JTable;

/**
 *
 * @author Przemysław
 */
public class DetailsRoastRaportPanel extends javax.swing.JPanel {

    /**
     * Creates new form RoastRaportShowcase
     *
     * @param rr RoastRaport
     */
    public DetailsRoastRaportPanel(RoastRaport rr) {
        initComponents();

        tableRoastRaportShowcase.setValueAt(Global.timestampToStrDDMMYYYY(rr.getCompleteTime()), 0, 0);
        labelEmployee.setText(rr.getCompletedBy().toString());
        labelProductionLine.setText(rr.getProductionLine().toString());
        textFieldOtherInfo.setText(rr.getOtherInfo());
        Object[] rgcp = rr.getRoastGreenCoffeePart().toArray();
        Arrays.sort(rgcp);

        CoffeeType tmp = null;
        float percentSum = 0;
        int perctPos = 0;
        for (int i = 0; i < rgcp.length; i++) {
            if (tmp == null) {
                tmp = ((RoastGreenCoffeePart) rgcp[i]).getCoffeeGreen().getCoffeeType();
                perctPos = i;
                percentSum = percentSum + 100 * (((RoastGreenCoffeePart) rgcp[i]).getWeight() / (rr.getTotalSourceWeight()));

            } else {
                if (tmp != ((RoastGreenCoffeePart) rgcp[i]).getCoffeeGreen().getCoffeeType()) {
                    tableRoastRaportShowcase.setValueAt(Global.round(percentSum, 2), perctPos, 4);
                    percentSum = 0 + 100 * (((RoastGreenCoffeePart) rgcp[i]).getWeight() / (rr.getTotalSourceWeight()));
                    perctPos = i;
                    tmp = ((RoastGreenCoffeePart) rgcp[i]).getCoffeeGreen().getCoffeeType();
                } else {
                    percentSum = percentSum + 100 * (((RoastGreenCoffeePart) rgcp[i]).getWeight() / (rr.getTotalSourceWeight()));
                }
            }
            tableRoastRaportShowcase.setValueAt(((RoastGreenCoffeePart) rgcp[i]).getCoffeeGreen(), i, 1);
            tableRoastRaportShowcase.setValueAt(((RoastGreenCoffeePart) rgcp[i]).getCoffeeGreen().getDossierNumber(), i, 2);
            tableRoastRaportShowcase.setValueAt(((RoastGreenCoffeePart) rgcp[i]).getWeight(), i, 3);
        }
        tableRoastRaportShowcase.setValueAt(Global.round(percentSum, 2), perctPos, 4);

        Object[] rap = rr.getRoastAromaPart().toArray();

        for (int i = 0; i < rap.length; i++) {
            tableRoastRaportShowcase.setValueAt(((RoastAromaPart) rap[i]).getAroma(), i, 5);
            tableRoastRaportShowcase.setValueAt(((RoastAromaPart) rap[i]).getQuantity(), i, 6);

        }
        tableRoastRaportShowcase.setValueAt(rr.getProductType(), 0, 7);

        Object[] rp = rr.getRoastPart().toArray();

        for (int i = 0; i < rp.length; i++) {
            tableRoastRaportShowcase.setValueAt(((RoastPart) rp[i]).getSourceWeight(), i, 8);
            tableRoastRaportShowcase.setValueAt(((RoastPart) rp[i]).getRoastedWeight(), i, 9);
            if (((RoastPart) rp[i]).isTemperature() == true) {
                tableRoastRaportShowcase.setValueAt("OK", i, 10);
            } else {
                tableRoastRaportShowcase.setValueAt("ZLA", i, 10);
            }

            tableRoastRaportShowcase.setValueAt(((RoastPart) rp[i]).getColour(), i, 11);

        }

        tableRoastRaportShowcase.setValueAt(rr.getCompletedBy(), rp.length + 3, 1);
        tableRoastRaportShowcase.setValueAt(rr.getTotalSourceWeight(), rp.length + 3, 8);
        tableRoastRaportShowcase.setValueAt(rr.getTotalRoastWeight(), rp.length + 3, 9);
        tableRoastRaportShowcase.setValueAt(rr.getProductionLine(), rp.length + 3, 5);

        labelSumGreenCoffee.setText(labelSumGreenCoffee.getText() + " : " + String.valueOf(rr.getTotalSourceWeight()));
        labelSumRoastedCoffee.setText(labelSumRoastedCoffee.getText() + " : " + String.valueOf(rr.getTotalRoastWeight()));

        tableRoastRaportShowcase.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableRoastRaportShowcase.rowAtPoint(evt.getPoint());
                int col = tableRoastRaportShowcase.columnAtPoint(evt.getPoint());
                if (col == 1) {
                    CoffeeGreen cg = (CoffeeGreen) tableRoastRaportShowcase.getValueAt(row, col);
                    cg.showDetails();
                }
                if (col == 5) {
                    Aroma a = (Aroma) tableRoastRaportShowcase.getValueAt(row, col);
                    a.showDetails();
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
        tableRoastRaportShowcase = new javax.swing.JTable();
        labelSumGreenCoffee = new javax.swing.JLabel();
        labelSumRoastedCoffee = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textFieldOtherInfo = new javax.swing.JTextPane();
        labelEmployee = new javax.swing.JLabel();
        labelProductionLine = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N

        tableRoastRaportShowcase.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        tableRoastRaportShowcase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Data", "Kawa", "Nr Dossier", "[Kg]", "[%]", "Aromat", "[Kg]", "Rodzaj wyrobu", "Ziel.", "Pal.", "T", "Kolor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableRoastRaportShowcase);
        if (tableRoastRaportShowcase.getColumnModel().getColumnCount() > 0) {
            tableRoastRaportShowcase.getColumnModel().getColumn(0).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(0).setPreferredWidth(60);
            tableRoastRaportShowcase.getColumnModel().getColumn(1).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableRoastRaportShowcase.getColumnModel().getColumn(2).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(2).setPreferredWidth(60);
            tableRoastRaportShowcase.getColumnModel().getColumn(3).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(3).setPreferredWidth(35);
            tableRoastRaportShowcase.getColumnModel().getColumn(4).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(5).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(5).setPreferredWidth(150);
            tableRoastRaportShowcase.getColumnModel().getColumn(6).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(6).setPreferredWidth(35);
            tableRoastRaportShowcase.getColumnModel().getColumn(7).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(7).setPreferredWidth(150);
            tableRoastRaportShowcase.getColumnModel().getColumn(8).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(8).setPreferredWidth(35);
            tableRoastRaportShowcase.getColumnModel().getColumn(9).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(9).setPreferredWidth(35);
            tableRoastRaportShowcase.getColumnModel().getColumn(10).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(10).setPreferredWidth(20);
            tableRoastRaportShowcase.getColumnModel().getColumn(11).setResizable(false);
            tableRoastRaportShowcase.getColumnModel().getColumn(11).setPreferredWidth(65);
        }

        labelSumGreenCoffee.setText("SUMA K. ZIELONA");

        labelSumRoastedCoffee.setText("SUMA K. PALONA");

        textFieldOtherInfo.setEnabled(false);
        jScrollPane2.setViewportView(textFieldOtherInfo);

        labelEmployee.setText("PRACOWNIK");

        labelProductionLine.setText("LINIA");

        jButton1.setText("DRUKUJ");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelEmployee)
                        .addGap(315, 315, 315)
                        .addComponent(labelProductionLine)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(labelSumGreenCoffee)
                                .addGap(42, 42, 42)
                                .addComponent(labelSumRoastedCoffee))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmployee)
                    .addComponent(labelProductionLine))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSumGreenCoffee)
                        .addComponent(labelSumRoastedCoffee))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
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
                    tableRoastRaportShowcase.print(JTable.PrintMode.FIT_WIDTH, null, null, false, aset, false, service);
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
    private javax.swing.JLabel labelEmployee;
    private javax.swing.JLabel labelProductionLine;
    private javax.swing.JLabel labelSumGreenCoffee;
    private javax.swing.JLabel labelSumRoastedCoffee;
    private javax.swing.JTable tableRoastRaportShowcase;
    private javax.swing.JTextPane textFieldOtherInfo;
    // End of variables declaration//GEN-END:variables
}
