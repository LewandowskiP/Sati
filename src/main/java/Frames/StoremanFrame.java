/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
public class StoremanFrame extends javax.swing.JFrame {

    Employee emp;

    /**
     * Creates new form MagazynierFrame
     *
     * @param emp
     */
    public StoremanFrame(Employee emp) {
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
        buttonAddAroma = new javax.swing.JButton();
        buttonAddCoffeeExternalReturn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        buttonAddSugar = new javax.swing.JButton();
        buttonAddDirectPackage = new javax.swing.JButton();
        buttonAddBoughtCoffee = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        buttonGenerateTotalMixRaport = new javax.swing.JButton();
        buttonEditNames = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        buttonTrackCoffee = new javax.swing.JButton();
        buttonTrackProduct = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        buttonAddCoffeeGreen = new javax.swing.JButton();
        buttonAromaStore = new javax.swing.JButton();
        buttonCoffeeStore = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MagazynierFrameToolsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dostępne Funkcje"));

        buttonAddAroma.setText("Wprowadź aromat");
        buttonAddAroma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddAromaActionPerformed(evt);
            }
        });

        buttonAddCoffeeExternalReturn.setText("Wprowadź kawę ze zwrotu");
        buttonAddCoffeeExternalReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCoffeeExternalReturnActionPerformed(evt);
            }
        });

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

        jButton4.setText("Wyświetl surowce zarejestrowane do badania");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        buttonAddSugar.setText("Wprowadź cukier");
        buttonAddSugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddSugarActionPerformed(evt);
            }
        });

        buttonAddDirectPackage.setText("Wprowadź kartony, folie itd.");
        buttonAddDirectPackage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddDirectPackageActionPerformed(evt);
            }
        });

        buttonAddBoughtCoffee.setText("Wprowadź wyrób gotowy");
        buttonAddBoughtCoffee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddBoughtCoffeeActionPerformed(evt);
            }
        });

        jButton1.setText("Wydaj kawę do produkcji");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGenerateTotalMixRaport.setText("Generowanie stanu magazynu kawy i aromatów");
        buttonGenerateTotalMixRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateTotalMixRaportActionPerformed(evt);
            }
        });

        buttonEditNames.setText("Edytuj typy");
        buttonEditNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditNamesActionPerformed(evt);
            }
        });

        jButton5.setText("Przeglądaj surowce");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        jButton6.setText("Wyświetl zmagazynowane palety do eksportu");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        buttonAddCoffeeGreen.setText("Wprowadź kawę");
        buttonAddCoffeeGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddCoffeeGreenActionPerformed(evt);
            }
        });

        buttonAromaStore.setText("Wyświetl stan magazynu aromatów");
        buttonAromaStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAromaStoreActionPerformed(evt);
            }
        });

        buttonCoffeeStore.setText("Wyświetl stan magazynu kawy");
        buttonCoffeeStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCoffeeStoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MagazynierFrameToolsPanelLayout = new javax.swing.GroupLayout(MagazynierFrameToolsPanel);
        MagazynierFrameToolsPanel.setLayout(MagazynierFrameToolsPanelLayout);
        MagazynierFrameToolsPanelLayout.setHorizontalGroup(
            MagazynierFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonAddAroma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonAddCoffeeExternalReturn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonAddSugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonAddDirectPackage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonAddBoughtCoffee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonGenerateTotalMixRaport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonEditNames, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonTrackCoffee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonTrackProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonAddCoffeeGreen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonAromaStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonCoffeeStore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MagazynierFrameToolsPanelLayout.setVerticalGroup(
            MagazynierFrameToolsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MagazynierFrameToolsPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(buttonAddCoffeeGreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddAroma)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddDirectPackage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddBoughtCoffee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddCoffeeExternalReturn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAddSugar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTrackCoffee)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTrackProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCoffeeStore)
                .addGap(7, 7, 7)
                .addComponent(buttonAromaStore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonGenerateTotalMixRaport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonEditNames)
                .addContainerGap())
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

    private void buttonAddAromaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddAromaActionPerformed
        jScrollPane1.setViewportView(new AddAromaPanel(emp));
    }//GEN-LAST:event_buttonAddAromaActionPerformed

    private void buttonAddCoffeeExternalReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCoffeeExternalReturnActionPerformed
        jScrollPane1.setViewportView(new AddReturnedCoffeePanel(emp));
    }//GEN-LAST:event_buttonAddCoffeeExternalReturnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jScrollPane1.setViewportView(new BrowseProductsToStore(emp));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jScrollPane1.setViewportView(new BrowseResourcesToStore(emp));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jScrollPane1.setViewportView(new BrowseResourcesToExamineStoreman(emp));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonAddBoughtCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddBoughtCoffeeActionPerformed
        jScrollPane1.setViewportView(new AddReadyCoffeePanel(emp));
    }//GEN-LAST:event_buttonAddBoughtCoffeeActionPerformed

    private void buttonAddDirectPackageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddDirectPackageActionPerformed
        jScrollPane1.setViewportView(new AddDirectPackagePanel(emp));
    }//GEN-LAST:event_buttonAddDirectPackageActionPerformed

    private void buttonAddSugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddSugarActionPerformed
        jScrollPane1.setViewportView(new AddSugarPanel(emp));
    }//GEN-LAST:event_buttonAddSugarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jScrollPane1.setViewportView(new AddReturnedProductPanel(emp));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonGenerateTotalMixRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateTotalMixRaportActionPerformed
        jScrollPane1.setViewportView(new GenerateResourcesSummary());
    }//GEN-LAST:event_buttonGenerateTotalMixRaportActionPerformed

    private void buttonEditNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditNamesActionPerformed
        jScrollPane1.setViewportView(new BrowseResourcesTypesPanel());
    }//GEN-LAST:event_buttonEditNamesActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jScrollPane1.setViewportView(new BrowseAllResourcesPanel());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void buttonTrackCoffeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTrackCoffeeActionPerformed
        jScrollPane1.setViewportView(new ShowCoffeeUsagePanel());
    }//GEN-LAST:event_buttonTrackCoffeeActionPerformed

    private void buttonTrackProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTrackProductActionPerformed
        jScrollPane1.setViewportView(new ShowProductionRaportExtendedPanel());
    }//GEN-LAST:event_buttonTrackProductActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jScrollPane1.setViewportView(new BrowseResourcesToStore(emp));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void buttonAddCoffeeGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddCoffeeGreenActionPerformed
        jScrollPane1.setViewportView(new AddGreenCoffeePanel(emp));
    }//GEN-LAST:event_buttonAddCoffeeGreenActionPerformed

    private void buttonAromaStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAromaStoreActionPerformed
        jScrollPane1.setViewportView(new BrowseAvailableAromaStoremanPanel(emp));
    }//GEN-LAST:event_buttonAromaStoreActionPerformed

    private void buttonCoffeeStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCoffeeStoreActionPerformed
        jScrollPane1.setViewportView(new BrowseAvailableGreenCoffeeStoremanPanel(emp));
    }//GEN-LAST:event_buttonCoffeeStoreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MagazynierFrameToolsPanel;
    private javax.swing.JButton buttonAddAroma;
    private javax.swing.JButton buttonAddBoughtCoffee;
    private javax.swing.JButton buttonAddCoffeeExternalReturn;
    private javax.swing.JButton buttonAddCoffeeGreen;
    private javax.swing.JButton buttonAddDirectPackage;
    private javax.swing.JButton buttonAddSugar;
    private javax.swing.JButton buttonAromaStore;
    private javax.swing.JButton buttonCoffeeStore;
    private javax.swing.JButton buttonEditNames;
    private javax.swing.JButton buttonGenerateTotalMixRaport;
    private javax.swing.JButton buttonTrackCoffee;
    private javax.swing.JButton buttonTrackProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
