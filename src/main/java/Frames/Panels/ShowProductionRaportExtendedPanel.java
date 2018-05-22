/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import ProductClasses.InstantCoffeeMixPart;
import ProductClasses.InstantCoffeeMixRaport;
import ProductClasses.ReadyCoffee;
import ProductClasses.RoastAromaPart;
import ProductClasses.RoastGreenCoffeePart;
import ProductClasses.RoastRaport;
import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionCoffeeExternalReturn;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import SatiInterfaces.Details;
import java.util.ArrayList;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Przemysław
 */
public class ShowProductionRaportExtendedPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShowCoffeeUsagePanel
     */
    DataBaseConnector dbc;
    Object selectedNode;
    ProductionRaportPart selectedProductionRaportPart;
    DefaultMutableTreeNode root;

    void buildTree(DefaultMutableTreeNode node, StringBuilder sb, int depth) {
        for (int j = 0; j < depth; j++) {
            sb.append("----");
        }
        sb.append(node.toString()).append(System.lineSeparator());
        for (int i = 0; i < node.getChildCount(); i++) {
            buildTree((DefaultMutableTreeNode) node.getChildAt(i), sb, depth + 1);
        }
    }

    public ShowProductionRaportExtendedPanel() {
        initComponents();

        dbc = Global.getDataBaseConnector();
        dbc.openSession();
        jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        jTree1.addTreeSelectionListener(new TreeSelectionListener() {

            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
                if (node == null) //Nothing is selected.     
                {
                    return;
                }
                selectedNode = node.getUserObject();
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jButton2 = new javax.swing.JButton();
        buttonFind = new javax.swing.JButton();
        labelProductionRaport = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Wybierz produkt");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree1);

        jButton2.setText("Pokaż szczegóły wybranego węzła");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonFind.setText("Wyszukaj raport produkcji");
        buttonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindActionPerformed(evt);
            }
        });

        labelProductionRaport.setText("Dane raportu");

        jButton3.setText("Drukuj");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelProductionRaport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonFind)
                    .addComponent(labelProductionRaport)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Details d = (Details) selectedNode;
        d.showDetails();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void buttonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindActionPerformed
        BrowseProductionRaportPartPanel bprp = new BrowseProductionRaportPartPanel();
        String[] options = {"Zamknij"};
        int result = JOptionPane.showOptionDialog(null, bprp, "Wybierz raport produkcji.", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (JOptionPane.OK_OPTION == result) {
            selectedProductionRaportPart = bprp.getSelectedProductionRaportPart();
            if (selectedProductionRaportPart == null) {
                labelProductionRaport.setText("Nie wybrano raportu.");
            } else {
                labelProductionRaport.setText(selectedProductionRaportPart.toString());

                try {

                    root = new DefaultMutableTreeNode(selectedProductionRaportPart);
                    ArrayList<ProductionCoffee> alpc = dbc.getProducionCoffeeWithProductionRaportPart(selectedProductionRaportPart);

                    for (ProductionCoffee pc : alpc) {

                        DefaultMutableTreeNode raport = new DefaultMutableTreeNode("Raporty kawy: " + pc.getProductType());

                        InstantCoffeeMixRaport icmr = dbc.getInstantCoffeeMixRaportWithProductionCoffee(pc);
                        if (icmr != null) {
                            DefaultMutableTreeNode mix = new DefaultMutableTreeNode(icmr);
                            for (InstantCoffeeMixPart icmp : icmr.getInstantCoffeeMixPart()) {
                                mix.add(new DefaultMutableTreeNode(icmp));
                            }
                            raport.add(mix);
                        }
                        RoastRaport rr = dbc.getRoastRaportWithProductionCoffee(pc);
                        if (rr != null) {
                            DefaultMutableTreeNode roast = new DefaultMutableTreeNode(rr);
                            for (RoastGreenCoffeePart rgcp : rr.getRoastGreenCoffeePart()) {
                                roast.add(new DefaultMutableTreeNode(rgcp));
                            }
                            for (RoastAromaPart rap : rr.getRoastAromaPart()) {
                                roast.add(new DefaultMutableTreeNode(rap));
                            }
                            raport.add(roast);
                        }
                        ProductionCoffeeExternalReturn pcer = dbc.getProductionCoffeeExternalReturnWithProductionCoffee(pc);
                        if (pcer != null) {
                            DefaultMutableTreeNode coffeeReturn = new DefaultMutableTreeNode(pcer);
                            coffeeReturn.add(new DefaultMutableTreeNode(pcer.getProductionRaportPart()));
                            raport.add(coffeeReturn);
                        }
                        ReadyCoffee rc = dbc.getReadyCoffeeWithProductionCoffee(pc);
                        if (rc != null) {
                            DefaultMutableTreeNode coffeeReturn = new DefaultMutableTreeNode(rc);
                            raport.add(coffeeReturn);
                        }
                        root.add(raport);
                    }

                    DefaultTreeModel model = (DefaultTreeModel) jTree1.getModel();
                    model.setRoot(root);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }//GEN-LAST:event_buttonFindActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            StringBuilder sb = new StringBuilder();
            sb.append("Drzewo pakowania produktu. ").append(System.lineSeparator()).append(System.lineSeparator());
            buildTree(root, sb, 0);
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
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFind;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTree jTree1;
    private javax.swing.JLabel labelProductionRaport;
    // End of variables declaration//GEN-END:variables
}
