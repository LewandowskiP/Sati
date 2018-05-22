/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import GreenCoffeeClasses.CoffeeGreen;
import ProductClasses.Aroma;
import ProductionClasses.ProductionCoffeeExternalReturn;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Przemysław
 */
public class BrowseAllResourcesPanel extends javax.swing.JPanel {

    /**
     * Creates new form BrowseAllAromas
     */
    DataBaseConnector dbc;
    Object selectedObject;

    public BrowseAllResourcesPanel() {
        initComponents();
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();
            dbc.clearSession();

        }
        dbc.openSession();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textFieldLabId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttonFindByDate = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listRaports = new javax.swing.JList();
        buttonDetails = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        spinnerTo = new javax.swing.JSpinner();
        spinnerFrom = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("Wpisz numer zlecenia kontroli");

        jButton1.setText("Wyszukaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonFindByDate.setText("Szukaj");
        buttonFindByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindByDateActionPerformed(evt);
            }
        });

        listRaports.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listRaports.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(listRaports);

        buttonDetails.setText("Pokaż szczegóły wybranej pozycji");
        buttonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetailsActionPerformed(evt);
            }
        });

        jLabel4.setText("do");

        spinnerTo.setModel(new javax.swing.SpinnerDateModel());

        spinnerFrom.setModel(new javax.swing.SpinnerDateModel());

        jLabel3.setText("Od");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(textFieldLabId)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonFindByDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonDetails))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 429, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldLabId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton1)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(spinnerTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonFindByDate)
                    .addComponent(buttonDetails))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Details cg = dbc.findWithLabId(textFieldLabId.getText());
        if (cg != null) {
            cg.showDetails();
        } else {
            JOptionPane.showMessageDialog(this, "Brak surowca o danym numerze zlecenia kontroli");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonFindByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindByDateActionPerformed

        Timestamp from = new Timestamp(((Date) spinnerFrom.getValue()).getTime());
        Timestamp to = new Timestamp(((Date) spinnerTo.getValue()).getTime());
        DefaultListModel dlm = new DefaultListModel();

        for (Object o : dbc.getResourcesFromDateToDate(from, to)) {
            dlm.addElement(o);
        }

        listRaports = new JList(dlm);
        listRaports.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listRaports.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                selectedObject = listRaports.getSelectedValue();
            }
        });
        jScrollPane1.setViewportView(listRaports);

        // dbc.closeSession();
    }//GEN-LAST:event_buttonFindByDateActionPerformed

    private void buttonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetailsActionPerformed
        Details det = (Details) selectedObject;
        det.showDetails();
    }//GEN-LAST:event_buttonDetailsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDetails;
    private javax.swing.JButton buttonFindByDate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listRaports;
    private javax.swing.JSpinner spinnerFrom;
    private javax.swing.JSpinner spinnerTo;
    private javax.swing.JTextField textFieldLabId;
    // End of variables declaration//GEN-END:variables
}
