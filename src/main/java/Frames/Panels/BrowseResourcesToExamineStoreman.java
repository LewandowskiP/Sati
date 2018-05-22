/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import GreenCoffeeClasses.CoffeeGreen;
import ProductClasses.Aroma;
import ProductClasses.Cardboard;
import ProductClasses.DirectPackage;

import ProductClasses.ReadyCoffee;
import ProductClasses.Sugar;
import ProductionClasses.ProductionCoffeeExternalReturn;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import javax.swing.ListSelectionModel;

/**
 *
 * @author Przemysław
 */
public class BrowseResourcesToExamineStoreman extends javax.swing.JPanel {

    Employee emp;
    /**
     * Creates new form GreenCoffeeToCheckListPanel
     */
    DataBaseConnector dbc = null;
    JList coffeeGreenList;

    private void reload() {

        DefaultListModel dlm = new DefaultListModel();
        ArrayList<CoffeeGreen> alcg = dbc.getCoffeeGreenToExamine();
        for (CoffeeGreen cg : alcg) {
            dlm.addElement(cg);

        }
        ArrayList<Aroma> ala = dbc.getAromaToExamine();
        for (Aroma a : ala) {
            dlm.addElement(a);
        }

        ArrayList<ProductionCoffeeExternalReturn> alpcer = dbc.getProductionCoffeeExternalReturnToExamine();
        for (ProductionCoffeeExternalReturn pcer : alpcer) {
            dlm.addElement(pcer);
        }

        ArrayList<Sugar> als = dbc.getSugarToExamine();
        for (Sugar s : als) {
            dlm.addElement(s);
        }
        ArrayList<DirectPackage> aldp = dbc.getDirectPackageToExamine();
        for (DirectPackage dp : aldp) {
            dlm.addElement(dp);
        }
        ArrayList<ReadyCoffee> alrc = dbc.getReadyCoffeeToExamine();
        for (ReadyCoffee rc : alrc) {
            dlm.addElement(rc);
        }
        listResources.setModel(dlm);

        jScrollPane1.setViewportView(coffeeGreenList);
    }

    public BrowseResourcesToExamineStoreman(Employee emp) {
        initComponents();
        coffeeGreenList = listResources;
        if (dbc == null) {

            dbc = Global.getDataBaseConnector();
        }
        this.emp = emp;
        dbc.openSession();
        reload();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonDetails = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listResources = new javax.swing.JList();
        jButton2 = new javax.swing.JButton();

        buttonDetails.setText("Pokaż szczegóły");
        buttonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetailsActionPerformed(evt);
            }
        });

        jButton1.setText("Drukuj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listResources.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(listResources);

        jButton2.setText("Wycofaj");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                        .addComponent(buttonDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonDetails)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    @SuppressWarnings("empty-statement")
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            StringBuilder sb = new StringBuilder();
            DefaultListModel dlm = (DefaultListModel) coffeeGreenList.getModel();
            int i = 0;
            for (Object o : dlm.toArray()) {
                if (o instanceof CoffeeGreen) {
                    CoffeeGreen cg = (CoffeeGreen) o;
                    sb.append(cg).append(" ").append(cg.getArrivalWeight()).append(" Kg").append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator());
                };
                if (o instanceof Aroma) {
                    Aroma a = (Aroma) o;
                    sb.append(a).append(" ").append(a.getArrivalQuantity()).append(" Kg").append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator());
                };
                if (o instanceof ProductionCoffeeExternalReturn) {
                    ProductionCoffeeExternalReturn pcer = (ProductionCoffeeExternalReturn) o;
                    sb.append(pcer).append(" ").append(pcer.getWeight()).append(" Kg").append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator());
                };
                if (o instanceof DirectPackage) {
                    DirectPackage dp = (DirectPackage) o;
                    sb.append(dp).append(" ").append(dp.getWeight()).append(" Kg").append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator());
                };
                if (o instanceof Sugar) {
                    Sugar s = (Sugar) o;
                    sb.append(s).append(" ").append(s.getQuantity()).append(" Kg").append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator());
                };

                if (o instanceof ReadyCoffee) {
                    ReadyCoffee rc = (ReadyCoffee) o;
                    sb.append(rc).append(" ").append(rc.getArrivalWeight()).append(" Kg").append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator()).append(System.lineSeparator());
                };

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

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetailsActionPerformed
        Details selected = (Details) coffeeGreenList.getSelectedValue();
        selected.showDetails();
    }//GEN-LAST:event_buttonDetailsActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Object selected = coffeeGreenList.getSelectedValue();
        String options[] = new String[]{"Tak", "Nie"};
        int result = JOptionPane.showOptionDialog(null, ("Czy na pewno chcesz usunąć pozycję: " + System.lineSeparator() + selected.toString()), "Uwaga!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (JOptionPane.OK_OPTION == result) {
            dbc.deleteObject(selected);
            reload();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDetails;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listResources;
    // End of variables declaration//GEN-END:variables
}
