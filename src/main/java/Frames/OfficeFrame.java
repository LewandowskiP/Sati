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

import Frames.Panels.AddNewEmployeePanel;
import Frames.Panels.AddProductionLinePanel;
import Frames.Panels.BrowseAllResourcesPanel;
import Frames.Panels.BrowseProductionCoffee;
import Frames.Panels.BrowseProductsToFinishAdmin;
import Frames.Panels.CustomRaportProductionPanel;
import Frames.Panels.GenerateProductionSummary;
import Frames.Panels.GenerateResourcesSummary;
import Frames.Panels.GenerateTotalProductionLinesRaport;
import Frames.Panels.ShowCoffeeUsagePanel;
import Frames.Panels.ShowProductionRaportExtendedPanel;
import ProductClasses.ProductType;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class OfficeFrame extends javax.swing.JFrame {

    Employee emp;
    JFrame magazynierFrame;
    JFrame operatorFrame;
    JFrame roasterFrame;
    JFrame hallManagerFrame;
    JFrame storemanFrame;

    /**
     * Creates new form SzefProdukcjiFrame
     *
     * @param emp
     */
    public OfficeFrame(Employee emp) {
        super.setTitle("Biuro :" + emp);
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

        SzefProdukcjiFrameTools = new javax.swing.JPanel();
        buttonAddProductionLine = new javax.swing.JButton();
        buttonAddEmployee = new javax.swing.JButton();
        buttonTrackCoffee = new javax.swing.JButton();
        buttonTrackProduct = new javax.swing.JButton();
        buttonLabFrame = new javax.swing.JButton();
        buttonOperatorFrame = new javax.swing.JButton();
        buttonStoremanFrame = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        buttonGenerateTotalProductionRaport = new javax.swing.JButton();
        buttonGenerateTotalRoastRaport = new javax.swing.JButton();
        buttonGenerateTotalMixRaport = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        scrollPanelHallManagerFrame = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SzefProdukcjiFrameTools.setBorder(javax.swing.BorderFactory.createTitledBorder("Dostępne Funkcje"));

        buttonAddProductionLine.setText("Dodaj linię produkcjyjną");
        buttonAddProductionLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddProductionLineActionPerformed(evt);
            }
        });

        buttonAddEmployee.setText("Dodaj pracownika");
        buttonAddEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddEmployeeActionPerformed(evt);
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

        buttonLabFrame.setText("Okno laboratorium");
        buttonLabFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLabFrameActionPerformed(evt);
            }
        });

        buttonOperatorFrame.setText("Okno operator lini pakowania");
        buttonOperatorFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOperatorFrameActionPerformed(evt);
            }
        });

        buttonStoremanFrame.setText("Okno magazynier");
        buttonStoremanFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStoremanFrameActionPerformed(evt);
            }
        });

        jButton1.setText("Okno kierownika produkcji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Przeglądaj surowce");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGenerateTotalProductionRaport.setText("Generowanie raportu linii produkcyjnych");
        buttonGenerateTotalProductionRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateTotalProductionRaportActionPerformed(evt);
            }
        });

        buttonGenerateTotalRoastRaport.setText("Generowanie raportu pakowania produktów");
        buttonGenerateTotalRoastRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateTotalRoastRaportActionPerformed(evt);
            }
        });

        buttonGenerateTotalMixRaport.setText("Generowanie stanu magazynu kawy i aromatów");
        buttonGenerateTotalMixRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateTotalMixRaportActionPerformed(evt);
            }
        });

        jButton3.setText("Przeglądaj kawy na produkcji");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Naprawa adresów plików");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Utwórz raport produkcji");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Zakończ stare raporty");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SzefProdukcjiFrameToolsLayout = new javax.swing.GroupLayout(SzefProdukcjiFrameTools);
        SzefProdukcjiFrameTools.setLayout(SzefProdukcjiFrameToolsLayout);
        SzefProdukcjiFrameToolsLayout.setHorizontalGroup(
            SzefProdukcjiFrameToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SzefProdukcjiFrameToolsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SzefProdukcjiFrameToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAddProductionLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAddEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonTrackCoffee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonTrackProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLabFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonOperatorFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonStoremanFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonGenerateTotalProductionRaport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonGenerateTotalRoastRaport, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(buttonGenerateTotalMixRaport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        SzefProdukcjiFrameToolsLayout.setVerticalGroup(
            SzefProdukcjiFrameToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SzefProdukcjiFrameToolsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonAddProductionLine)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddEmployee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTrackCoffee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTrackProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGenerateTotalProductionRaport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGenerateTotalRoastRaport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGenerateTotalMixRaport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLabFrame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonOperatorFrame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStoremanFrame)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SzefProdukcjiFrameTools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanelHallManagerFrame, javax.swing.GroupLayout.DEFAULT_SIZE, 785, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPanelHallManagerFrame)
                    .addComponent(SzefProdukcjiFrameTools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLabFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLabFrameActionPerformed
        magazynierFrame = new LabAssistantFrame(emp);
        magazynierFrame.setVisible(true);
        magazynierFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_buttonLabFrameActionPerformed

    private void buttonAddProductionLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddProductionLineActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new AddProductionLinePanel());
    }//GEN-LAST:event_buttonAddProductionLineActionPerformed

    private void buttonAddEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddEmployeeActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new AddNewEmployeePanel());
    }//GEN-LAST:event_buttonAddEmployeeActionPerformed

    private void buttonTrackCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTrackCoffeeActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new ShowCoffeeUsagePanel());
    }//GEN-LAST:event_buttonTrackCoffeeActionPerformed

    private void buttonTrackProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTrackProductActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new ShowProductionRaportExtendedPanel());
    }//GEN-LAST:event_buttonTrackProductActionPerformed

    private void buttonOperatorFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOperatorFrameActionPerformed
        operatorFrame = new OperatorFrame(emp);
        operatorFrame.setVisible(true);
        operatorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_buttonOperatorFrameActionPerformed

    private void buttonStoremanFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStoremanFrameActionPerformed
        storemanFrame = new StoremanFrame(emp);
        storemanFrame.setVisible(true);
        storemanFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_buttonStoremanFrameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        hallManagerFrame = new HallManagerFrame(emp);
        hallManagerFrame.setVisible(true);
        hallManagerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new BrowseAllResourcesPanel());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonGenerateTotalProductionRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateTotalProductionRaportActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new GenerateTotalProductionLinesRaport());
    }//GEN-LAST:event_buttonGenerateTotalProductionRaportActionPerformed

    private void buttonGenerateTotalRoastRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateTotalRoastRaportActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new GenerateProductionSummary());
    }//GEN-LAST:event_buttonGenerateTotalRoastRaportActionPerformed

    private void buttonGenerateTotalMixRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateTotalMixRaportActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new GenerateResourcesSummary());
    }//GEN-LAST:event_buttonGenerateTotalMixRaportActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new BrowseProductionCoffee());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        try {
            DataBaseConnector dbc = Global.getDataBaseConnector();
            dbc.openSession();
            ArrayList<ProductType> alpt = dbc.getProductType();
            for (ProductType pt : alpt) {
                dbc.startTransation();
                pt.setFileURL(pt.getFileURL().replace("\\\\DBC-SATICAFE\\Public\\", "P:\\"));
                pt.setFileURL(pt.getFileURL().replace("\\\\192.168.17.10\\public\\", "P:\\"));
                if (pt.getFileURLinstant() != null) {
                    pt.setFileURLinstant(pt.getFileURLinstant().replace("\\\\DBC-SATICAFE\\Public\\", "P:\\"));
                    pt.setFileURLinstant(pt.getFileURLinstant().replace("\\\\192.168.17.10\\public\\", "P:\\"));
                }
                dbc.saveTransation(pt);
            }
            dbc.commitTransation();

            JOptionPane.showMessageDialog(null, "Naprawiono adresy plików.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Wystapił bład");
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new CustomRaportProductionPanel(emp));
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        scrollPanelHallManagerFrame.setViewportView(new BrowseProductsToFinishAdmin(emp));
    }//GEN-LAST:event_jButton6ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel SzefProdukcjiFrameTools;
    private javax.swing.JButton buttonAddEmployee;
    private javax.swing.JButton buttonAddProductionLine;
    private javax.swing.JButton buttonGenerateTotalMixRaport;
    private javax.swing.JButton buttonGenerateTotalProductionRaport;
    private javax.swing.JButton buttonGenerateTotalRoastRaport;
    private javax.swing.JButton buttonLabFrame;
    private javax.swing.JButton buttonOperatorFrame;
    private javax.swing.JButton buttonStoremanFrame;
    private javax.swing.JButton buttonTrackCoffee;
    private javax.swing.JButton buttonTrackProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane scrollPanelHallManagerFrame;
    // End of variables declaration//GEN-END:variables
}
