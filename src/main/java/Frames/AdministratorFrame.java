/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Frames.Panels.AddAromaPanel;
import Frames.Panels.AddAromaTypePanel;
import Frames.Panels.AddGreenCoffeePanel;
import Frames.Panels.AddPackTypePanel;
import Frames.Panels.AddProductTypePanel;
import Frames.Panels.AddProductionLinePanel;
import Frames.Panels.AddReadyCoffeePanel;
import Frames.Panels.BrowsePalleteGeneral;
import Frames.Panels.BrowseResourcesToExamine;
import Frames.Panels.ManageProductionOrders;
import Frames.Panels.NewRaportProductionPanel;
import GreenCoffeeClasses.CoffeeAttribute;
import GreenCoffeeClasses.CoffeeGreen;
import GreenCoffeeClasses.CoffeeType;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JFrame;

/**
 *
 * @author Przemysław
 */
public class AdministratorFrame extends javax.swing.JFrame {

    Employee emp;

    /**
     * Creates new form AdministratorFrame
     */
    public AdministratorFrame(Employee emp) {
        initComponents();

        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setResizable(true);

        this.emp = emp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonAddEmployee = new javax.swing.JButton();
        buttonAddCoffeeCountry = new javax.swing.JButton();
        buttonAddCoffeeOwner = new javax.swing.JButton();
        buttonAddCoffeeType = new javax.swing.JButton();
        buttonAddAromaType = new javax.swing.JButton();
        buttonAddProduct = new javax.swing.JButton();
        buttonAddCoffeeGreen = new javax.swing.JButton();
        buttonAddCoffeeTest = new javax.swing.JButton();
        buttonAddCoffeeAttribute = new javax.swing.JButton();
        scrollPanelAdministratorFrame = new javax.swing.JScrollPane();
        buttonProductCountry = new javax.swing.JButton();
        buttonProductionPosition = new javax.swing.JButton();
        buttonAddProviderPanel = new javax.swing.JButton();
        buttonPackType = new javax.swing.JButton();
        buttonAddAroma = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonAddEmployee.setText("Pracownik");
        buttonAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddEmployeeActionPerformed(evt);
            }
        });

        buttonAddCoffeeCountry.setText("Czyść typy kawy");
        buttonAddCoffeeCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCoffeeCountryActionPerformed(evt);
            }
        });

        buttonAddCoffeeOwner.setText("Kawa Właściciel");
        buttonAddCoffeeOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCoffeeOwnerActionPerformed(evt);
            }
        });

        buttonAddCoffeeType.setText("production order");
        buttonAddCoffeeType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCoffeeTypeActionPerformed(evt);
            }
        });

        buttonAddAromaType.setText("Aromat Typ");
        buttonAddAromaType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddAromaTypeActionPerformed(evt);
            }
        });

        buttonAddProduct.setText("Produkt Typ - palenie");
        buttonAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProductActionPerformed(evt);
            }
        });

        buttonAddCoffeeGreen.setText("Kawa zielona");
        buttonAddCoffeeGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCoffeeGreenActionPerformed(evt);
            }
        });

        buttonAddCoffeeTest.setText("Kawa Test");
        buttonAddCoffeeTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCoffeeTestActionPerformed(evt);
            }
        });

        buttonAddCoffeeAttribute.setText("Kawa Atrybut");
        buttonAddCoffeeAttribute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCoffeeAttributeActionPerformed(evt);
            }
        });

        buttonProductCountry.setText("Produkt Kraj");
        buttonProductCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductCountryActionPerformed(evt);
            }
        });

        buttonProductionPosition.setText("Produkcja Linia");
        buttonProductionPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductionPositionActionPerformed(evt);
            }
        });

        buttonAddProviderPanel.setText("Dostawca");
        buttonAddProviderPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProviderPanelActionPerformed(evt);
            }
        });

        buttonPackType.setText("Rodzaj Pakowania");
        buttonPackType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPackTypeActionPerformed(evt);
            }
        });

        buttonAddAroma.setText("Aromat ");
        buttonAddAroma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddAromaActionPerformed(evt);
            }
        });

        jButton1.setText("Okno palacza");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Okno magazyniera");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Produckt typ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Product Type all");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Okno laboratorium");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Okno hall manager");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Czyść atrybuty kaw");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("EANproba");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("EANproba");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddAromaType)
                    .addComponent(buttonAddProduct)
                    .addComponent(buttonAddCoffeeGreen)
                    .addComponent(buttonAddCoffeeTest)
                    .addComponent(buttonAddCoffeeAttribute)
                    .addComponent(buttonProductCountry)
                    .addComponent(buttonProductionPosition)
                    .addComponent(buttonAddProviderPanel)
                    .addComponent(buttonPackType)
                    .addComponent(buttonAddAroma)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(buttonAddCoffeeCountry)
                    .addComponent(jButton5)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(buttonAddCoffeeType)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAddCoffeeOwner)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAddEmployee))
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addGap(18, 18, 18)
                .addComponent(scrollPanelAdministratorFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 778, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPanelAdministratorFrame)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonAddCoffeeCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonAddCoffeeOwner)
                            .addComponent(buttonAddEmployee))
                        .addGap(8, 8, 8)
                        .addComponent(buttonAddCoffeeType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddAromaType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddCoffeeGreen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAddCoffeeTest)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAddCoffeeAttribute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonProductCountry)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonProductionPosition)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddProviderPanel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonPackType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAddAroma)
                        .addGap(3, 3, 3)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProductActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new AddProductTypePanel());
    }//GEN-LAST:event_buttonAddProductActionPerformed

    private void buttonAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEmployeeActionPerformed
        JFrame palaczFrame = new CEOFrame(emp);
        palaczFrame.setVisible(true);
    }//GEN-LAST:event_buttonAddEmployeeActionPerformed

    private void buttonAddCoffeeAttributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCoffeeAttributeActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new NewRaportProductionPanel(emp));
    }//GEN-LAST:event_buttonAddCoffeeAttributeActionPerformed

    private void buttonAddAromaTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddAromaTypeActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new AddAromaTypePanel());
    }//GEN-LAST:event_buttonAddAromaTypeActionPerformed

    private void buttonAddCoffeeTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCoffeeTypeActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new ManageProductionOrders(emp));
    }//GEN-LAST:event_buttonAddCoffeeTypeActionPerformed

    private void buttonProductCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductCountryActionPerformed

    }//GEN-LAST:event_buttonProductCountryActionPerformed

    private void buttonProductionPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductionPositionActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new AddProductionLinePanel());
    }//GEN-LAST:event_buttonProductionPositionActionPerformed

    private void buttonAddProviderPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProviderPanelActionPerformed

    }//GEN-LAST:event_buttonAddProviderPanelActionPerformed

    private void buttonAddCoffeeGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCoffeeGreenActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new AddGreenCoffeePanel(emp));
    }//GEN-LAST:event_buttonAddCoffeeGreenActionPerformed

    private void buttonAddCoffeeCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCoffeeCountryActionPerformed
        JFrame palaczFrame = new CEOFrame(emp);
        palaczFrame.setVisible(true);
        DataBaseConnector dbc = new DataBaseConnector();
        dbc.openSession();
        dbc.globalFix();
    }//GEN-LAST:event_buttonAddCoffeeCountryActionPerformed

    private void buttonAddCoffeeOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCoffeeOwnerActionPerformed
        JFrame palaczFrame = new CEOFrame(emp);
        palaczFrame.setVisible(true);
    }//GEN-LAST:event_buttonAddCoffeeOwnerActionPerformed

    private void buttonAddCoffeeTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCoffeeTestActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new BrowseResourcesToExamine(emp));
    }//GEN-LAST:event_buttonAddCoffeeTestActionPerformed

    private void buttonPackTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPackTypeActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new AddPackTypePanel());
    }//GEN-LAST:event_buttonPackTypeActionPerformed

    private void buttonAddAromaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddAromaActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new AddAromaPanel(emp));
    }//GEN-LAST:event_buttonAddAromaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrame palaczFrame = new CEOFrame(emp);
        palaczFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFrame magazynierFrame = new StoremanFrame(emp);
        magazynierFrame.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new AddProductTypePanel());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        JFrame magazynierFrame = new LabAssistantFrame(emp);
        magazynierFrame.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JFrame magazynierFrame = new HallManagerFrame(emp);
        magazynierFrame.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        DataBaseConnector dbc = Global.getDataBaseConnector();
        dbc.openSession();

        ArrayList<CoffeeType> alct = dbc.getCoffeeType();
        for (CoffeeType ct : alct) {
            dbc.startTransation();
            ArrayList<CoffeeGreen> alcg = dbc.getCoffeeGreenWithCoffeeType(ct);
            if (alcg.isEmpty()) {
                HashSet<CoffeeAttribute> clone = new HashSet<CoffeeAttribute>();
                clone.addAll(ct.getCoffeeAttribute());
                for (CoffeeAttribute ca : clone) {
                    ca.getCoffeeType().remove(ct);
                    ct.getCoffeeAttribute().remove(ca);
                    dbc.saveTransation(ca);
                }
                dbc.saveTransation(ct);

            }
            dbc.commitTransation();
        }
        dbc.clearSession();
        dbc.openSession();
        alct = dbc.getCoffeeType();
        for (CoffeeType ct : alct) {
            ArrayList<CoffeeGreen> alcg = dbc.getCoffeeGreenWithCoffeeType(ct);
            if (alcg.isEmpty()) {
                dbc.deleteObject(ct);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        scrollPanelAdministratorFrame.setViewportView(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        scrollPanelAdministratorFrame.setViewportView(new BrowsePalleteGeneral());
    }//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddAroma;
    private javax.swing.JButton buttonAddAromaType;
    private javax.swing.JButton buttonAddCoffeeAttribute;
    private javax.swing.JButton buttonAddCoffeeCountry;
    private javax.swing.JButton buttonAddCoffeeGreen;
    private javax.swing.JButton buttonAddCoffeeOwner;
    private javax.swing.JButton buttonAddCoffeeTest;
    private javax.swing.JButton buttonAddCoffeeType;
    private javax.swing.JButton buttonAddEmployee;
    private javax.swing.JButton buttonAddProduct;
    private javax.swing.JButton buttonAddProviderPanel;
    private javax.swing.JButton buttonPackType;
    private javax.swing.JButton buttonProductCountry;
    private javax.swing.JButton buttonProductionPosition;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane scrollPanelAdministratorFrame;
    // End of variables declaration//GEN-END:variables
}
