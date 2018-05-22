/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import Frames.Panels.BrowseAllResourcesPanel;
import Frames.Panels.BrowseProductTypePanel;
import Frames.Panels.BrowseProductsToExamine;
import Frames.Panels.BrowseResourcesToExamine;
import Frames.Panels.BrowseResourcesTypesPanel;
import Frames.Panels.GenerateTotalProductionLinesRaport;
import Frames.Panels.ShowCoffeeUsagePanel;
import Frames.Panels.ShowProductionRaportExtendedPanel;
import ProductionManagement.Employee;
import javax.swing.JFrame;

/**
 *
 * @author Przemysław
 */
public class LabAssistantFrame extends javax.swing.JFrame {

    Employee emp;

    /**
     * Creates new form LaborantFrame
     */
    public LabAssistantFrame(Employee emp) {
        super.setTitle("Laborant :" + emp);
        this.emp = emp;

        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LaborantFrameToolsPanel = new javax.swing.JPanel();
        LaborantFrameLoadGreenCoffeeButton = new javax.swing.JButton();
        LaborantFrameLoadProductsButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonTrackCoffee = new javax.swing.JButton();
        buttonTrackProduct = new javax.swing.JButton();
        buttonBrowseGreenCoffee = new javax.swing.JButton();
        buttonBrowseAroma = new javax.swing.JButton();
        buttonGenerateTotalProductionRaport = new javax.swing.JButton();
        buttonEditNames = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LaborantFrameToolsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dostępne Funkcje"));

        LaborantFrameLoadGreenCoffeeButton.setText("Zlecenia kontroli surowca");
        LaborantFrameLoadGreenCoffeeButton.setToolTipText("KAWY, AROMATY, ZWROTY");
        LaborantFrameLoadGreenCoffeeButton.setBorder(null);
        LaborantFrameLoadGreenCoffeeButton.setBorderPainted(false);
        LaborantFrameLoadGreenCoffeeButton.setMaximumSize(new java.awt.Dimension(120, 120));
        LaborantFrameLoadGreenCoffeeButton.setMinimumSize(new java.awt.Dimension(120, 120));
        LaborantFrameLoadGreenCoffeeButton.setPreferredSize(new java.awt.Dimension(120, 120));
        LaborantFrameLoadGreenCoffeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaborantFrameLoadGreenCoffeeButtonActionPerformed(evt);
            }
        });

        LaborantFrameLoadProductsButton.setText("Zarządzanie kartami produktów");
        LaborantFrameLoadProductsButton.setToolTipText("");
        LaborantFrameLoadProductsButton.setBorder(null);
        LaborantFrameLoadProductsButton.setBorderPainted(false);
        LaborantFrameLoadProductsButton.setMaximumSize(new java.awt.Dimension(120, 120));
        LaborantFrameLoadProductsButton.setMinimumSize(new java.awt.Dimension(120, 120));
        LaborantFrameLoadProductsButton.setPreferredSize(new java.awt.Dimension(120, 120));
        LaborantFrameLoadProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaborantFrameLoadProductsButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Zwalnianie produkcji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Przegladanie surowców");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonTrackCoffee.setText("Identyfikacja kawy");
        buttonTrackCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTrackCoffeeActionPerformed(evt);
            }
        });

        buttonTrackProduct.setText("Identyfikacja produktu");
        buttonTrackProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTrackProductActionPerformed(evt);
            }
        });

        buttonBrowseGreenCoffee.setText("Sprawdź stan kawy zielonej");
        buttonBrowseGreenCoffee.setToolTipText("");
        buttonBrowseGreenCoffee.setBorder(null);
        buttonBrowseGreenCoffee.setBorderPainted(false);
        buttonBrowseGreenCoffee.setMaximumSize(new java.awt.Dimension(120, 120));
        buttonBrowseGreenCoffee.setMinimumSize(new java.awt.Dimension(120, 120));
        buttonBrowseGreenCoffee.setPreferredSize(new java.awt.Dimension(120, 120));
        buttonBrowseGreenCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseGreenCoffeeActionPerformed(evt);
            }
        });

        buttonBrowseAroma.setText("Sprawdź stan aromatów");
        buttonBrowseAroma.setToolTipText("");
        buttonBrowseAroma.setBorder(null);
        buttonBrowseAroma.setBorderPainted(false);
        buttonBrowseAroma.setMaximumSize(new java.awt.Dimension(120, 120));
        buttonBrowseAroma.setMinimumSize(new java.awt.Dimension(120, 120));
        buttonBrowseAroma.setPreferredSize(new java.awt.Dimension(120, 120));
        buttonBrowseAroma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseAromaActionPerformed(evt);
            }
        });

        buttonGenerateTotalProductionRaport.setText("Generowanie raportu linii produkcyjnych");
        buttonGenerateTotalProductionRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateTotalProductionRaportActionPerformed(evt);
            }
        });

        buttonEditNames.setText("Edytuj typy");
        buttonEditNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditNamesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LaborantFrameToolsPanelLayout = new javax.swing.GroupLayout(LaborantFrameToolsPanel);
        LaborantFrameToolsPanel.setLayout(LaborantFrameToolsPanelLayout);
        LaborantFrameToolsPanelLayout.setHorizontalGroup(
            LaborantFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LaborantFrameLoadGreenCoffeeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(LaborantFrameLoadProductsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
            .addComponent(buttonTrackCoffee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonTrackProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonBrowseGreenCoffee, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonBrowseAroma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonGenerateTotalProductionRaport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonEditNames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LaborantFrameToolsPanelLayout.setVerticalGroup(
            LaborantFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaborantFrameToolsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LaborantFrameLoadGreenCoffeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LaborantFrameLoadProductsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTrackCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTrackProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEditNames, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonBrowseGreenCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBrowseAroma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGenerateTotalProductionRaport, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LaborantFrameToolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(LaborantFrameToolsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LaborantFrameLoadGreenCoffeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaborantFrameLoadGreenCoffeeButtonActionPerformed
        jScrollPane1.setViewportView(new BrowseResourcesToExamine(emp));
    }//GEN-LAST:event_LaborantFrameLoadGreenCoffeeButtonActionPerformed

    private void LaborantFrameLoadProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaborantFrameLoadProductsButtonActionPerformed
        jScrollPane1.setViewportView(new BrowseProductTypePanel());
    }//GEN-LAST:event_LaborantFrameLoadProductsButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jScrollPane1.setViewportView(new BrowseProductsToExamine(emp));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jScrollPane1.setViewportView(new BrowseAllResourcesPanel());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonTrackCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTrackCoffeeActionPerformed
        jScrollPane1.setViewportView(new ShowCoffeeUsagePanel());
    }//GEN-LAST:event_buttonTrackCoffeeActionPerformed

    private void buttonTrackProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTrackProductActionPerformed
        jScrollPane1.setViewportView(new ShowProductionRaportExtendedPanel());
    }//GEN-LAST:event_buttonTrackProductActionPerformed

    private void buttonBrowseGreenCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseGreenCoffeeActionPerformed
        JFrame browseAvailableGreenCoffeeFrame = new BrowseAvailableGreenCoffeeFrame();
        browseAvailableGreenCoffeeFrame.setVisible(true);
    }//GEN-LAST:event_buttonBrowseGreenCoffeeActionPerformed

    private void buttonBrowseAromaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseAromaActionPerformed
        JFrame browseAvailableAromaFrame = new BrowseAvailableAromaFrame();
        browseAvailableAromaFrame.setVisible(true);
    }//GEN-LAST:event_buttonBrowseAromaActionPerformed

    private void buttonGenerateTotalProductionRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateTotalProductionRaportActionPerformed
        jScrollPane1.setViewportView(new GenerateTotalProductionLinesRaport());
    }//GEN-LAST:event_buttonGenerateTotalProductionRaportActionPerformed

    private void buttonEditNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditNamesActionPerformed
        jScrollPane1.setViewportView(new BrowseResourcesTypesPanel());
    }//GEN-LAST:event_buttonEditNamesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LaborantFrameLoadGreenCoffeeButton;
    private javax.swing.JButton LaborantFrameLoadProductsButton;
    private javax.swing.JPanel LaborantFrameToolsPanel;
    private javax.swing.JButton buttonBrowseAroma;
    private javax.swing.JButton buttonBrowseGreenCoffee;
    private javax.swing.JButton buttonEditNames;
    private javax.swing.JButton buttonGenerateTotalProductionRaport;
    private javax.swing.JButton buttonTrackCoffee;
    private javax.swing.JButton buttonTrackProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
