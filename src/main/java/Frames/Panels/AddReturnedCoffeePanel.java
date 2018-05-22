/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import ProductionClasses.ProductionCoffeeExternalReturn;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import ProductionManagement.LabTest;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class AddReturnedCoffeePanel extends javax.swing.JPanel {

    ProductionRaportPart selectedProductionRaportPart;
    Employee emp;
    DataBaseConnector dbc;

    /**
     * Creates new form AddReturnedCoffeePanel
     */
    public AddReturnedCoffeePanel(Employee e) {
        initComponents();
        emp = e;
        if (dbc == null) {
            dbc = Global.getDataBaseConnector();
            dbc.clearSession();
        }
    }

    private void resetInput() {
        selectedProductionRaportPart = null;
        labelProductionRaportPart.setText("");
        jTextArea1.setText("");
        checkBoxVermin.setSelected(false);
        jSpinner1.setValue(new Float(0));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonFind = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelProductionRaportPart = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        buttonSendToLab = new javax.swing.JButton();
        checkBoxVermin = new javax.swing.JCheckBox();

        buttonFind.setText("Przeszukaj raporty produkcji");
        buttonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFindActionPerformed(evt);
            }
        });

        jLabel1.setText("Wybrana produkcja, z której wrócił zwort.");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(0.1f)));

        jLabel2.setText("Ilość zwróconej kawy");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel3.setText("Komentarz do zwrotu.");

        buttonSendToLab.setText("Przekaż do badania");
        buttonSendToLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendToLabActionPerformed(evt);
            }
        });

        checkBoxVermin.setText("Szkodniki wykryte");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProductionRaportPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkBoxVermin)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(buttonSendToLab)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(buttonFind)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSpinner1))
                                    .addComponent(jLabel3))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonFind)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(labelProductionRaportPart, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkBoxVermin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSendToLab)
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindActionPerformed
        BrowseProductionRaportPartPanel bprp = new BrowseProductionRaportPartPanel();
        String[] options = {"Zamknij"};
        int result = JOptionPane.showOptionDialog(null, bprp, "Wybierz raport produkcji.", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (JOptionPane.OK_OPTION == result) {
            selectedProductionRaportPart = bprp.getSelectedProductionRaportPart();
            if (selectedProductionRaportPart == null) {
                labelProductionRaportPart.setText("Nie wybrano raportu.");
            } else {
                labelProductionRaportPart.setText(selectedProductionRaportPart.toString());
            }
        }
    }//GEN-LAST:event_buttonFindActionPerformed

    private void buttonSendToLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendToLabActionPerformed
        dbc.openSession();
        try {
            if (selectedProductionRaportPart != null) {
                String str = dbc.getMaxLabIdProductionCoffeeExternalReturn();
                ProductionCoffeeExternalReturn pcer = new ProductionCoffeeExternalReturn();
                pcer.setProductionRaportPart(selectedProductionRaportPart);
                pcer.setReturnDate(new Timestamp(System.currentTimeMillis()));
                pcer.setReturnInfo(jTextArea1.getText());
                pcer.setStoremanId(emp);
                LabTest lt = new LabTest();
                lt.setVermin(checkBoxVermin.isSelected());
                pcer.setLabTest(lt);
                pcer.setWeight(Global.round((Float) jSpinner1.getValue(), 2));
                pcer.setLabId(TOOL_TIP_TEXT_KEY);
                pcer.setState(Global.PRODUCTION_COFFEE_EXTERNAL_TO_EXAMINE);

                String newLabIdStr;
                if (str != null) {
                    Integer lastLabId = Integer.parseInt(str.substring(1, 7));

                    newLabIdStr = String.format("Z%06d", lastLabId + 1);
                } else {
                    newLabIdStr = String.format("Z%06d", 1);
                }
                pcer.setLabId(newLabIdStr);
                dbc.saveObject(lt);
                dbc.saveObject(pcer);

                JOptionPane.showMessageDialog(null, "Zarejestrowano do badania.", "Informacja", JOptionPane.INFORMATION_MESSAGE);
                resetInput();
            } else {
                JOptionPane.showMessageDialog(null, "Proszę wybrać raport produkcji");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Błędnie wprowadzone dane");
        }


    }//GEN-LAST:event_buttonSendToLabActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonFind;
    private javax.swing.JButton buttonSendToLab;
    private javax.swing.JCheckBox checkBoxVermin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelProductionRaportPart;
    // End of variables declaration//GEN-END:variables
}
