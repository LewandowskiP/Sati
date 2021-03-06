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

import Frames.Panels.AddAromaPanel;
import Frames.Panels.AddDirectPackagePanel;
import Frames.Panels.AddGreenCoffeePanel;
import Frames.Panels.AddReadyCoffeePanel;
import Frames.Panels.AddReturnedCoffeePanel;
import Frames.Panels.AddReturnedProductPanel;
import Frames.Panels.AddSugarPanel;
import Frames.Panels.BrowseAllResourcesPanel;
import Frames.Panels.BrowseAvailableAromaStoremanPanel;
import Frames.Panels.BrowseAvailableGreenCoffeeStoremanPanel;
import Frames.Panels.BrowseProductsToExport;
import Frames.Panels.BrowseProductsToStore;
import Frames.Panels.BrowseResourcesToExamineStoreman;
import Frames.Panels.BrowseResourcesToStore;
import Frames.Panels.BrowseResourcesTypesPanel;
import Frames.Panels.GenerateResourcesSummary;
import Frames.Panels.ShowCoffeeUsagePanel;
import Frames.Panels.ShowProductionRaportExtendedPanel;
import ProductionManagement.Employee;
import javax.swing.JFrame;

/**
 *
 * @author Przemysław
 */
public class StoremanJuniorFrame extends javax.swing.JFrame {

    Employee emp;

    /**
     * Creates new form MagazynierFrame
     *
     * @param emp
     */
    public StoremanJuniorFrame(Employee emp) {
        super.setTitle("Magazynier :" + emp);
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

        MagazynierFrameToolsPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MagazynierFrameToolsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dostępne Funkcje"));

        jButton2.setText("Sprawdź palety do zatwierdzenia");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Wyświetl surowce do zmagazynowania");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Wydaj kawę do produkcji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MagazynierFrameToolsPanelLayout = new javax.swing.GroupLayout(MagazynierFrameToolsPanel);
        MagazynierFrameToolsPanel.setLayout(MagazynierFrameToolsPanelLayout);
        MagazynierFrameToolsPanelLayout.setHorizontalGroup(
            MagazynierFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MagazynierFrameToolsPanelLayout.setVerticalGroup(
            MagazynierFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MagazynierFrameToolsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(477, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MagazynierFrameToolsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MagazynierFrameToolsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jScrollPane1.setViewportView(new BrowseProductsToStore(emp));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jScrollPane1.setViewportView(new BrowseResourcesToStore(emp));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jScrollPane1.setViewportView(new AddReturnedProductPanel(emp));
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MagazynierFrameToolsPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
