/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import ProductionClasses.Pallete;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.util.ArrayList;
import java.util.List;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Przemysław
 */
public class BrowsePalleteGeneral extends javax.swing.JPanel {

    /**
     * Creates new form BrowseProductsAfterLabTest
     */
    Employee emp;
    DataBaseConnector dbc;

    private void reload() {
        dbc.openSession();
        ArrayList<Pallete> palleteToAccept = dbc.getPalleteWithState(Global.PALLETE_WAITING);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        for (Pallete p : palleteToAccept) {
            model.addRow(new Object[]{p, p.getProductionRaportPart().getProductType(), p.getBatch(), p.getQuantity(), Global.timestampToStrDDMMYYYY(p.getProdDate()), Global.getPalleteState(p.getState()), false, false});

        }

    }

    public BrowsePalleteGeneral(Employee e) {
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
        sortKeys.add(new RowSorter.SortKey(5, SortOrder.ASCENDING));
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
                if (column == details_column) {
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {
                        Pallete p = (Pallete) model.getValueAt(row, 0);
                        p.showDetails();
                        model.setValueAt(false, row, column);
                    }
                }
                if (column == accept_column) {
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {
                        Pallete p = (Pallete) model.getValueAt(row, 0);
                        p.setState(Global.PALLETE_CHECKED);
                        dbc.updateObject(p);
                        model.setValueAt(false, row, column);
                        reload();
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
                "Paleta", "Typ produktu", "Numer partii", "Ilość sztuk", "Data", "Stan", "Zat.", "Szcz."
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Boolean.class
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
            jTable1.getColumnModel().getColumn(5).setMinWidth(120);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
            jTable1.getColumnModel().getColumn(5).setMaxWidth(120);
            jTable1.getColumnModel().getColumn(6).setMinWidth(40);
            jTable1.getColumnModel().getColumn(6).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(6).setMaxWidth(40);
            jTable1.getColumnModel().getColumn(7).setMinWidth(40);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
