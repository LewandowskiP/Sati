/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import GreenCoffeeClasses.CoffeeGreen;
import GreenCoffeeClasses.CoffeeGreenChangeHistory;
import ProductClasses.Aroma;
import ProductClasses.AromaChangeHistory;
import ProductClasses.InstantCoffeeMixPart;
import ProductClasses.RoastAromaPart;
import ProductClasses.RoastGreenCoffeePart;
import ProductClasses.RoastRaport;
import ProductionClasses.ProductionCoffeeReturn;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Przemysław
 */
public class BrowseRoastRaportsHallManagerPanel extends javax.swing.JPanel {
    
    DataBaseConnector dbc;
    Employee e;

    /**
     * Creates new form BrowseMyRaports
     */
    private void reload() {
        dbc.openSession();
        
        Timestamp from = new Timestamp(((Date) spinnerFrom.getValue()).getTime());
        Timestamp to = new Timestamp(((Date) spinnerTo.getValue()).getTime());
        
        DefaultListModel dlm = new DefaultListModel();
        
        for (RoastRaport rr : dbc.getRoastRaportWithFromTo(from, to)) {
            dlm.addElement(rr);
        }
        
        listRaports = new JList(dlm);
        listRaports.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listRaports);
        
    }
    
    private void rollbackCoffeeHistory(Set<CoffeeGreenChangeHistory> scgch, RoastRaport rr) {
        
        Set<CoffeeGreenChangeHistory> clone = new HashSet<CoffeeGreenChangeHistory>();
        clone.addAll(scgch);
        for (CoffeeGreenChangeHistory cgch : clone) {
            if (cgch.getRoastRaport() == rr) {
                CoffeeGreen cg = cgch.getCoffeeGreen();
                
                cg.setCurrentWeight(cg.getCurrentWeight() - cgch.getWeight());
                if (cg.getCurrentWeight() > 0) {
                    cg.setState(Global.COFFEE_GREEN_READY_TO_ROAST);
                }
                cg.getCoffeeGreenChangeHistory().remove(cgch);
                dbc.updateObject(cg);
                dbc.deleteObject(cgch);
            }
        }
        
    }
    
    private void rollbackAromaHistory(Set<AromaChangeHistory> sach, RoastRaport rr) {
        Set<AromaChangeHistory> clone = new HashSet<AromaChangeHistory>();
        clone.addAll(sach);
        
        for (AromaChangeHistory ach : clone) {
            if (ach.getRoastRaport() == rr) {
                Aroma a = ach.getAroma();
                a.setQuantity(a.getQuantity() - ach.getWeight());
                if (a.getQuantity() > 0) {
                    a.setState(Global.COFFEE_GREEN_READY_TO_ROAST);
                }
                a.getAromaChangeHistory().remove(ach);
                dbc.updateObject(a);
                dbc.deleteObject(ach);
            }
        }
        
    }
    
    public BrowseRoastRaportsHallManagerPanel(Employee emp) {
        initComponents();
        e = emp;
        
        dbc = Global.getDataBaseConnector();
        dbc.openSession();
        // ArrayList<RoastRaport> alrr = dbc.getAromaWithAromaType(selectedAromaType);
        listRaports.removeAll();
        jScrollPane2.setViewportView(listRaports);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listRaports = new javax.swing.JList();
        spinnerTo = new javax.swing.JSpinner();
        buttonFindByDate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        spinnerFrom = new javax.swing.JSpinner();
        buttonEdit = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();

        buttonDetails.setText("Pokaż szczegóły");
        buttonDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDetailsActionPerformed(evt);
            }
        });

        listRaports.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(listRaports);

        spinnerTo.setModel(new javax.swing.SpinnerDateModel());

        buttonFindByDate.setText("Szukaj");
        buttonFindByDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindByDateActionPerformed(evt);
            }
        });

        jLabel3.setText("Od");

        jLabel4.setText("do");

        spinnerFrom.setModel(new javax.swing.SpinnerDateModel());

        buttonEdit.setText("Edytuj");
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });

        buttonDelete.setText("Wycofaj");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(buttonDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelete)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spinnerFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(buttonFindByDate))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buttonDetails)
                        .addComponent(buttonEdit)
                        .addComponent(buttonDelete)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDetailsActionPerformed
        try {
            RoastRaport selected = (RoastRaport) listRaports.getSelectedValue();
            String[] options = {"OK"};
            JOptionPane.showOptionDialog(this, new DetailsRoastRaportPanel(selected), "Sprawdź raport", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonDetailsActionPerformed

    private void buttonFindByDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindByDateActionPerformed
        reload();

    }//GEN-LAST:event_buttonFindByDateActionPerformed

    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        try {
            RoastRaport selected = (RoastRaport) listRaports.getSelectedValue();
            String[] options = {"TAK", "NIE"};
            int ret = JOptionPane.showOptionDialog(this, "Czy na pewno chcesz zminić zaznaczony raport z bazy?", "UWAGA!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (ret == JOptionPane.YES_OPTION) {
                
                Set<RoastGreenCoffeePart> srgcp = selected.getRoastGreenCoffeePart();
                Set<RoastGreenCoffeePart> srgcpClone = new HashSet<RoastGreenCoffeePart>(srgcp);
                
                Set<RoastAromaPart> srap = selected.getRoastAromaPart();
                Set<RoastAromaPart> srapClone = new HashSet<RoastAromaPart>(srap);
                
                for (RoastGreenCoffeePart rgcp : srgcp) {
                    rollbackCoffeeHistory((Set<CoffeeGreenChangeHistory>) rgcp.getCoffeeGreen().getCoffeeGreenChangeHistory(), selected);
                }
                for (RoastAromaPart rap : srap) {
                    rollbackAromaHistory((Set<AromaChangeHistory>) rap.getAroma().getAromaChangeHistory(), selected);
                }
                
                String[] options2 = {"Zatwierdź"};
                EditRaportRoastPanel pane = new EditRaportRoastPanel(selected);
                JOptionPane.showOptionDialog(this, pane, "UWAGA!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options2, options2[0]);
                
                if (pane.raportSentWarden == true) {
                    for (RoastGreenCoffeePart rgcp : srgcpClone) {
                        dbc.deleteObject(rgcp);
                    }
                    for (RoastAromaPart rap : srapClone) {
                        dbc.deleteObject(rap);
                    }
                    
                } else {
                    dbc.openSession();
                    selected.setRoastAromaPart(srap);
                    for (RoastAromaPart rap : srapClone) {
                        dbc.startTransation();
                        dbc.refresh(rap.getAroma());
                        AromaChangeHistory ach = new AromaChangeHistory();
                        ach.setChangeTime(selected.getCompleteTime());
                        ach.setChangedBy(selected.getCompletedBy());
                        ach.setAroma(rap.getAroma());
                        ach.setComment("PALENIE " + selected.getProductType().getProductName());
                        ach.setRoastRaport(selected);
                        ach.setWeight(-1 * rap.getQuantity());
                        rap.getAroma().getAromaChangeHistory().add(ach);
                        rap.getAroma().setQuantity(rap.getAroma().getQuantity() + ach.getWeight());
                        if (rap.getAroma().getQuantity() == 0) {
                            rap.getAroma().setState(Global.COFFEE_GREEN_OUT_OF_STORE);
                        }
                        dbc.saveTransation(rap.getAroma());
                        dbc.saveTransation(rap);
                        dbc.commitTransation();
                    }
                    
                    selected.setRoastGreenCoffeePart(srgcpClone);
                    for (RoastGreenCoffeePart rgcp : srgcpClone) {
                        dbc.startTransation();
                        dbc.refresh(rgcp.getCoffeeGreen());
                        CoffeeGreenChangeHistory cgch = new CoffeeGreenChangeHistory();
                        cgch.setChangeTime(selected.getCompleteTime());
                        cgch.setChangedBy(selected.getCompletedBy());
                        cgch.setCoffeeGreen(rgcp.getCoffeeGreen());
                        cgch.setComment("PALENIE " + selected.getProductType().getProductName());
                        cgch.setRoastRaport(selected);
                        cgch.setWeight(-1 * rgcp.getWeight());
                        rgcp.getCoffeeGreen().getCoffeeGreenChangeHistory().add(cgch);
                        rgcp.getCoffeeGreen().setCurrentWeight(rgcp.getCoffeeGreen().getCurrentWeight() + cgch.getWeight());
                        if (rgcp.getCoffeeGreen().getCurrentWeight() == 0) {
                            rgcp.getCoffeeGreen().setState(Global.COFFEE_GREEN_OUT_OF_STORE);
                        }
                        dbc.saveTransation(rgcp.getCoffeeGreen());
                        dbc.saveTransation(rgcp);
                        dbc.commitTransation();
                    }
                }
                dbc.saveObject(selected);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        reload();
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        try {
            RoastRaport selected = (RoastRaport) listRaports.getSelectedValue();
            String[] options = {"TAK", "NIE"};
            int ret = JOptionPane.showOptionDialog(this, "Czy na pewno chcesz usunąć zaznaczony raport z bazy?", "UWAGA!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (ret == JOptionPane.YES_OPTION) {
                if (selected.getProductionCoffee().getWeight() == selected.getTotalRoastWeight()) {
                    Set<RoastGreenCoffeePart> srgcp = selected.getRoastGreenCoffeePart();
                    Set<RoastAromaPart> srap = selected.getRoastAromaPart();
                    for (RoastGreenCoffeePart rgcp : srgcp) {
                        rollbackCoffeeHistory((Set<CoffeeGreenChangeHistory>) rgcp.getCoffeeGreen().getCoffeeGreenChangeHistory(), selected);
                    }
                    for (RoastAromaPart rap : srap) {
                        rollbackAromaHistory((Set<AromaChangeHistory>) rap.getAroma().getAromaChangeHistory(), selected);
                    }
                    ArrayList<ProductionCoffeeReturn> alpcr = dbc.getProductionCoffeeReturnWithProductionCoffee(selected.getProductionCoffee());
                    
                    dbc.startTransation();
                    for (ProductionCoffeeReturn pcr : alpcr) {
                        dbc.deleteTransation(pcr);
                    }
                    dbc.deleteTransation(selected);
                    dbc.deleteTransation(selected.getProductionCoffee());
                    dbc.commitTransation();
                } else {
                    JOptionPane.showMessageDialog(this, "Wyprodukowana kawa już w użyciu.");
                }
            }
            reload();
        } catch (Exception e) {
            e.printStackTrace();
            dbc.rollbackTransation();
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonDetails;
    private javax.swing.JButton buttonEdit;
    private javax.swing.JButton buttonFindByDate;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listRaports;
    private javax.swing.JSpinner spinnerFrom;
    private javax.swing.JSpinner spinnerTo;
    // End of variables declaration//GEN-END:variables
}
