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
package Frames;

import Frames.Panels.BrowseAllResourcesByTypePanel;
import Frames.Panels.BrowseAllResourcesPanel;
import Frames.Panels.BrowseInstantCoffeeMixRaportHallManagerPanel;
import Frames.Panels.BrowseProductTypePanel;
import Frames.Panels.BrowseProductsToExamine;
import Frames.Panels.BrowseResourcesToExamine;
import Frames.Panels.BrowseResourcesTypesPanel;
import Frames.Panels.BrowseRoastRaportsHallManagerPanel;
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
     *
     * @param emp
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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonTrackCoffee = new javax.swing.JButton();
        buttonTrackProduct = new javax.swing.JButton();
        buttonBrowseGreenCoffee = new javax.swing.JButton();
        buttonBrowseAroma = new javax.swing.JButton();
        buttonGenerateTotalProductionRaport = new javax.swing.JButton();
        buttonEditNames = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        buttonBrowseMyRaports = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LaborantFrameToolsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dostępne Funkcje"));

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

        jButton3.setText("Zlecenia kontroli surowca");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Przeglądaj karty produktów");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonBrowseMyRaports.setText("Sprawdź raporty palenia");
        buttonBrowseMyRaports.setPreferredSize(new java.awt.Dimension(73, 30));
        buttonBrowseMyRaports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBrowseMyRaportsActionPerformed(evt);
            }
        });

        jButton5.setText("Sprawdz raporty mieszania");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton7.setText("Przeglądaj surowce po typie");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LaborantFrameToolsPanelLayout = new javax.swing.GroupLayout(LaborantFrameToolsPanel);
        LaborantFrameToolsPanel.setLayout(LaborantFrameToolsPanelLayout);
        LaborantFrameToolsPanelLayout.setHorizontalGroup(
            LaborantFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonGenerateTotalProductionRaport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LaborantFrameToolsPanelLayout.createSequentialGroup()
                .addGroup(LaborantFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonBrowseGreenCoffee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonBrowseAroma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(buttonTrackCoffee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonTrackProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonEditNames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonBrowseMyRaports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LaborantFrameToolsPanelLayout.setVerticalGroup(
            LaborantFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LaborantFrameToolsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTrackCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTrackProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEditNames, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonBrowseMyRaports, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jScrollPane1.setViewportView(new BrowseResourcesToExamine(emp));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jScrollPane1.setViewportView(new BrowseProductTypePanel());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonBrowseMyRaportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBrowseMyRaportsActionPerformed
        jScrollPane1.setViewportView(new BrowseRoastRaportsHallManagerPanel(emp));
    }//GEN-LAST:event_buttonBrowseMyRaportsActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jScrollPane1.setViewportView(new BrowseInstantCoffeeMixRaportHallManagerPanel(emp));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jScrollPane1.setViewportView(new BrowseAllResourcesByTypePanel());
    }//GEN-LAST:event_jButton7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LaborantFrameToolsPanel;
    private javax.swing.JButton buttonBrowseAroma;
    private javax.swing.JButton buttonBrowseGreenCoffee;
    private javax.swing.JButton buttonBrowseMyRaports;
    private javax.swing.JButton buttonEditNames;
    private javax.swing.JButton buttonGenerateTotalProductionRaport;
    private javax.swing.JButton buttonTrackCoffee;
    private javax.swing.JButton buttonTrackProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
