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

import ProductionClasses.Pallete;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.awt.print.PrinterException;
import java.sql.Timestamp;
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
public class BrowseProductsToFinishAdmin extends javax.swing.JPanel {

    /**
     * Creates new form BrowseProductsToExamine
     */
    Employee emp;
    DataBaseConnector dbc;

    private void reload() {
        dbc.openSession();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        ArrayList<ProductionRaportPart> productsToExamine = dbc.getProductsToFinish();
        for (ProductionRaportPart prp : productsToExamine) {
            model.addRow(new Object[]{prp, prp.getProductType(), prp.getBatchInfo(), prp.getTotalPcs(), Global.timestampToStrDDMMYYYY(prp.getRaportDate()), prp.getTotalPallete() + " // " + prp.getPallete().size(), false, false});
        }

    }

    public BrowseProductsToFinishAdmin(Employee e) {
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

            final static int accept_column = 6;
            final static int details_column = 7;

            @Override
            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                DefaultTableModel model = (DefaultTableModel) e.getSource();
                dbc.openSession();
                if (column == accept_column) {
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {
                        ProductionRaportPart prp = (ProductionRaportPart) model.getValueAt(row, 0);
                        if (prp.getLabTestState() > 0) {
                            String options[] = new String[]{"Tak", "Nie"};
                            int result = JOptionPane.showOptionDialog(null, ("Czy na pewno chcesz zaakceptować produkt? " + System.lineSeparator() + prp.toString()), "Uwaga!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

                            if (JOptionPane.OK_OPTION == result) {
                                try {
                                    dbc.startTransation();
                                    for (Pallete p : prp.getPallete()) {
                                        p.setState(Global.PALLETE_MIGRATED);
                                        dbc.updateTransation(p);
                                    }
                                    prp.setLabTestState(Global.PRODUCTION_RAPORT_PART_STORED);
                                    prp.setLabTestDate(new Timestamp(System.currentTimeMillis()));
                                    dbc.updateTransation(prp);
                                    dbc.commitTransation();
                                } catch (Exception ex) {
                                    dbc.rollbackTransation();
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Niemożliwe do zaakceptowania.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                        }
                        model.setValueAt(false, row, column);
                        reload();
                    }
                }
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produkt", "Typ produktu", "Numer partii", "Ilość sztuk", "Data", "Ilość palet", "Zaakceptuj", "Szczegóły"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(0);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(0);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(1);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(1);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 696, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

}
