/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import Listeners.CheckBoxProductionCoffeeErase;
import ProductionClasses.ProductionCoffee;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemysław
 */
public class BrowseProductionCoffee extends javax.swing.JPanel {

    DataBaseConnector dbc;

    /**
     * Creates new form BrowseProductVersions
     */
    ProductionCoffee pc;

    public BrowseProductionCoffee() {

        initComponents();
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();
        }
        dbc.openSession();
        DefaultTableModel dtm = (DefaultTableModel) tableProducts.getModel();
        dtm.setRowCount(0);
        ArrayList<ProductionCoffee> alpc = dbc.getProductionCoffeeWithState(Global.PRODUCTION_COFFEE_READY);

        Object[] o = alpc.toArray();
        Arrays.sort(o);

        for (Object pc : o) {
            ProductionCoffee p = (ProductionCoffee) pc;
            dtm.addRow(new Object[]{pc, p.getProductType(), Global.timestampToStrDDMMYYYY(p.getProdDate()), p.getWeight(), false});
        }
        dtm.addTableModelListener(new CheckBoxProductionCoffeeErase());

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
        jScrollPane2 = new javax.swing.JScrollPane();
        tableProducts = new javax.swing.JTable();

        tableProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Kawa", "Data", "Ilość", "Usuń"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableProducts.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableProducts);
        if (tableProducts.getColumnModel().getColumnCount() > 0) {
            tableProducts.getColumnModel().getColumn(0).setMinWidth(0);
            tableProducts.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableProducts.getColumnModel().getColumn(0).setMaxWidth(0);
            tableProducts.getColumnModel().getColumn(1).setMinWidth(150);
            tableProducts.getColumnModel().getColumn(1).setPreferredWidth(150);
            tableProducts.getColumnModel().getColumn(1).setMaxWidth(1200);
            tableProducts.getColumnModel().getColumn(2).setMinWidth(40);
            tableProducts.getColumnModel().getColumn(2).setPreferredWidth(40);
            tableProducts.getColumnModel().getColumn(2).setMaxWidth(600);
            tableProducts.getColumnModel().getColumn(3).setMinWidth(40);
            tableProducts.getColumnModel().getColumn(3).setPreferredWidth(40);
            tableProducts.getColumnModel().getColumn(3).setMaxWidth(600);
            tableProducts.getColumnModel().getColumn(4).setMinWidth(50);
            tableProducts.getColumnModel().getColumn(4).setPreferredWidth(50);
            tableProducts.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableProducts;
    // End of variables declaration//GEN-END:variables
}
