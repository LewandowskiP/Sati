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

import ProductClasses.ReturnedProduct;
import ProductionClasses.Pallete;
import ProductionClasses.ProductionRaportCoffeeAssignment;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.List;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Przemysław
 */
public class BrowseProductsAfterLabTest extends javax.swing.JPanel {

    /**
     * Creates new form BrowseProductsAfterLabTest
     */
    Employee emp;
    DataBaseConnector dbc;
    static int accept_column = 7;

    private void reload() {
        dbc.clearSession();
        dbc.openSession();
        ArrayList<ProductionRaportPart> productsToAccept = dbc.getProductsToAccept();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (ProductionRaportPart prp : productsToAccept) {
            int acceptedPalletes = 0;
            for (Pallete p : prp.getPallete()) {
                if (p.getState() == Global.PALLETE_CHECKED) {
                    acceptedPalletes++;
                }
            }
            model.addRow(new Object[]{prp, prp.getProductType(), prp.getBatchInfo(), prp.getTotalPallete(), acceptedPalletes, prp.getProductionLine() + " zm. " + prp.getShift(), Global.getProductStateState(prp.getLabTestState()), false, false});

        }

        //dbc.closeSession();
    }

    public BrowseProductsAfterLabTest(Employee e) {
        initComponents();
        emp = e;
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();
        }
        reload();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

        List<RowSorter.SortKey> sortKeys;
        sortKeys = new ArrayList(25);
        sortKeys.add(new RowSorter.SortKey(6, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        jTable1.setRowSorter(sorter);
        model.addTableModelListener(new TableModelListener() {

            final static int accept_column = 7;
            final static int details_column = 8;

            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                DefaultTableModel model = (DefaultTableModel) e.getSource();
                dbc.openSession();

                if (column == details_column) {
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {

                        ProductionRaportPart prp = (ProductionRaportPart) model.getValueAt(row, 0);
                        prp.showDetails();
                        model.setValueAt(false, row, column);

                    }
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
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produkt", "Typ produktu", "Numer partii", "Suma palet", "Palety zatw.", "Linia", "Stan", "Zat.", "Szcz."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
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
            jTable1.getColumnModel().getColumn(2).setMinWidth(150);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(3).setMinWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(150);
            jTable1.getColumnModel().getColumn(6).setMinWidth(120);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(7).setMinWidth(40);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(8).setMinWidth(40);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(8).setMaxWidth(40);
        }

        jButton1.setText("Drukuj listę");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Zatwierdź zaznaczone");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Wycofaj");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Odśwież");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int num = 7;
        final TableColumnModel model = jTable1.getColumnModel();
        final List<TableColumn> removed = new ArrayList<>();
        int columnCount = model.getColumnCount();
        for (int i = num; i < columnCount; ++i) {
            TableColumn col = model.getColumn(num);
            removed.add(col);
            model.removeColumn(col);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
                aset.add(OrientationRequested.LANDSCAPE);

                PrintService service = PrintServiceLookup.lookupDefaultPrintService();
                try {
                    jTable1.print(JTable.PrintMode.FIT_WIDTH, null, null, false, aset, false, service);
                } catch (PrinterException e) {
                    e.printStackTrace();
                }
                for (TableColumn col : removed) {
                    model.addColumn(col);
                }
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < dtm.getRowCount(); i++) {
                dbc.startTransation();
                if ((Boolean) dtm.getValueAt(i, accept_column) == true) {
                    ProductionRaportPart prp = (ProductionRaportPart) dtm.getValueAt(i, 0);
                    if (prp.getLabTestState() == 3 && dtm.getValueAt(i, 3).equals(dtm.getValueAt(i, 4))) {
                        prp.setLabTestState(Global.PRODUCTION_RAPORT_PART_STORED);
                        dbc.updateTransation(prp);
                    } else {
                        JOptionPane.showMessageDialog(null, "Wystąpił błąd sprawdź zaznaczone produkty");
                        break;
                    }
                }
            }
            dbc.commitTransation();
            reload();
        } catch (Exception e) {
            e.printStackTrace();
            dbc.rollbackTransation();

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void rollbackRaport(ProductionRaportPart prp) {
        for (ProductionRaportCoffeeAssignment prca : prp.getProductionRaportCoffeeAssignment()) {
            prca.getProductionCoffee().setWeight(prca.getWeight() + prca.getProductionCoffee().getWeight());
            prca.getProductionCoffee().setState(Global.PRODUCTION_COFFEE_READY);
            dbc.updateTransation(prca.getProductionCoffee());
        }
        dbc.deleteTransation(prp);
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            dbc.startTransation();
            ProductionRaportPart selected = (ProductionRaportPart) jTable1.getValueAt(jTable1.getSelectedRow(), 0);
            if (selected.getType() != 3) {
                String options[] = new String[]{"Tak", "Nie"};
                int result = JOptionPane.showOptionDialog(null, ("Czy na pewno chcesz wycofać raport?" + System.lineSeparator() + selected.toString()), "Uwaga!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (result == JOptionPane.YES_OPTION) {
                    rollbackRaport(selected);
                }
            } else {
                String options[] = new String[]{"Tak", "Nie"};
                ReturnedProduct rp = dbc.getReturnedProduct(selected);
                ArrayList<ProductionRaportPart> alprp = dbc.getProductionRaportPartWithProductionCoffee(rp.getProductionCoffee());
                StringBuilder sb = new StringBuilder();
                sb.append("Wybrany raport jest raportem półproduktu!").append(System.lineSeparator());
                sb.append("Wycofanie go spowoduje wycofanie następujących raportów:").append(System.lineSeparator());
                for (ProductionRaportPart prp : alprp) {
                    sb.append(" ").append(prp.getBatchInfo()).append(System.lineSeparator());
                }
                int result = JOptionPane.showOptionDialog(null, sb.toString(), "Uwaga!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (result == JOptionPane.OK_OPTION) {
                    for (ProductionRaportPart prp : alprp) {
                        rollbackRaport(prp);
                    }
                    dbc.deleteTransation(rp);
                    dbc.deleteTransation(rp.getProductionCoffee());
                    rollbackRaport(selected);
                }
            }
            dbc.commitTransation();
            reload();
        } catch (Exception ex) {
            dbc.rollbackTransation();
            JOptionPane.showMessageDialog(null, "Wystąpił błąd podczas wycofywania, lub zaznaczony raport jest półproduktem.");
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        reload();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
