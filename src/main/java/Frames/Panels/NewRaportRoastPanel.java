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
package Frames.Panels;

import Exceptions.NotEnoughtAromaException;
import Exceptions.NotEnoughtCoffeeException;
import Exceptions.NotMatchingCoffeeWeightException;
import Exceptions.ResourceNotFoundException;
import Listeners.CheckBoxAromaRoastRaport;
import Listeners.CheckBoxGreenCoffeeRoastRaport;
import ProductClasses.ProductType;
import ProductClasses.RoastAromaPart;
import ProductClasses.RoastGreenCoffeePart;
import ProductClasses.RoastPart;
import ProductClasses.RoastRaport;
import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionLine;

import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import javax.swing.DefaultCellEditor;

import javax.swing.JComboBox;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Przemysław
 */
public class NewRaportRoastPanel extends javax.swing.JPanel {

    DataBaseConnector dbc = null;
    Employee emp;
    ProductionLine selectedProductionLine;
    ProductType selectedProductType;

    private final int labIdColumnCoffee = 0;
    private final int weightColumnCoffee = 2;
    private final int labIdColumnAroma = 0;
    private final int weightColumnAroma = 2;

    /**
     * Creates new form NewRaportRoastPanel
     */
    private void setControls(boolean state) {
        tableRoastPart.setEnabled(state);
        tableRoastAromaPart.setEnabled(state);
        tableRoastGreenCoffeePart.setEnabled(state);
        textFieldOtherInfo.setEnabled(state);

        buttonSendRaport.setEnabled(state);
        buttonOpenFile.setEnabled(state);
    }

    private void resetInput() {
        comboBoxProductionLine.setSelectedItem(null);
        DefaultTableModel dtm = (DefaultTableModel) tableRoastAromaPart.getModel();
        dtm.setRowCount(0);
        dtm.setRowCount(10);
        DefaultTableModel dtm2 = (DefaultTableModel) tableRoastPart.getModel();
        dtm2.setRowCount(0);
        dtm2.setRowCount(35);
        DefaultTableModel dtm3 = (DefaultTableModel) tableRoastGreenCoffeePart.getModel();
        dtm3.setRowCount(0);
        dtm3.setRowCount(10);
        textFieldOtherInfo.setText("");

    }

    private void initProductionList() {

        dbc.clearSession();
        dbc.openSession();
        setControls(false);
        tableRoastAromaPart.getModel().addTableModelListener(new CheckBoxAromaRoastRaport());
        tableRoastGreenCoffeePart.getModel().addTableModelListener(new CheckBoxGreenCoffeeRoastRaport(3, 4));
        dbc.openSession();
        ArrayList<ProductionLine> alpl = dbc.getProductionLine();
        comboBoxProductionLine.removeAllItems();
        for (ProductionLine pl : alpl) {
            if (pl.isRoast()) {
                comboBoxProductionLine.addItem(pl);

            }
        }
        comboBoxProductionLine.setSelectedItem(null);
        ArrayList<ProductType> alpt = dbc.getProductType(Global.PRODUCT_TYPE_ROAST);
        Object[] A = alpt.toArray();
        alpt.toArray(A);
        Arrays.sort(A);
        comboBoxProductType.removeAllItems();
        for (Object pt : A) {
            comboBoxProductType.addItem(pt);
        }
        comboBoxProductType.setSelectedItem(null);
        comboBoxProductionLine.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                selectedProductionLine = (ProductionLine) comboBoxProductionLine.getSelectedItem();
                if (selectedProductionLine != null) {
                    comboBoxProductType.setEnabled(true);
                } else {
                    comboBoxProductType.setEnabled(false);
                }
            }
        });

        comboBoxProductType.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent arg0) {
                selectedProductType = (ProductType) comboBoxProductType.getSelectedItem();
                if (selectedProductType != null) {
                    setControls(true);
                } else {
                    setControls(false);
                }

            }
        });

    }

    public NewRaportRoastPanel(Employee emp) {
        initComponents();
        if (dbc == null) {

            dbc = Global.getDataBaseConnector();
        }
        dbc.openSession();
        this.emp = emp;
        TableColumn roastRaportTempColumn = tableRoastPart.getColumnModel().getColumn(2);
        JComboBox tempComboBox = new JComboBox();
        tempComboBox.addItem("OK");
        tempComboBox.addItem("ZŁA");
        roastRaportTempColumn.setCellEditor(new DefaultCellEditor(tempComboBox));

        initProductionList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonSendRaport = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableRoastGreenCoffeePart = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableRoastAromaPart = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableRoastPart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        textFieldOtherInfo = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        comboBoxProductionLine = new javax.swing.JComboBox();
        buttonOpenFile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        comboBoxProductType = new javax.swing.JComboBox();

        buttonSendRaport.setText("Wyślij raport");
        buttonSendRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendRaportActionPerformed(evt);
            }
        });

        tableRoastGreenCoffeePart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nr. Zlec. Kontr.", "Kawa", "Ilość [Kg]", "+", "-"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Float.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRoastGreenCoffeePart.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tableRoastGreenCoffeePart);
        if (tableRoastGreenCoffeePart.getColumnModel().getColumnCount() > 0) {
            tableRoastGreenCoffeePart.getColumnModel().getColumn(0).setResizable(false);
            tableRoastGreenCoffeePart.getColumnModel().getColumn(2).setResizable(false);
            tableRoastGreenCoffeePart.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableRoastGreenCoffeePart.getColumnModel().getColumn(3).setResizable(false);
            tableRoastGreenCoffeePart.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableRoastGreenCoffeePart.getColumnModel().getColumn(4).setResizable(false);
            tableRoastGreenCoffeePart.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jLabel3.setText("Wprowadź kolejne palenia");

        jLabel4.setText("Wprowadź użyte aromaty");

        tableRoastAromaPart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nr. Zlec. Kontr.", "Aromat", "Ilość", "+", "-"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Float.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableRoastAromaPart.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableRoastAromaPart);
        if (tableRoastAromaPart.getColumnModel().getColumnCount() > 0) {
            tableRoastAromaPart.getColumnModel().getColumn(0).setResizable(false);
            tableRoastAromaPart.getColumnModel().getColumn(2).setResizable(false);
            tableRoastAromaPart.getColumnModel().getColumn(2).setPreferredWidth(100);
            tableRoastAromaPart.getColumnModel().getColumn(3).setResizable(false);
            tableRoastAromaPart.getColumnModel().getColumn(3).setPreferredWidth(30);
            tableRoastAromaPart.getColumnModel().getColumn(4).setResizable(false);
            tableRoastAromaPart.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        tableRoastPart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Zielona", "Palona", "Temp", "Kolor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Float.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableRoastPart.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tableRoastPart);
        if (tableRoastPart.getColumnModel().getColumnCount() > 0) {
            tableRoastPart.getColumnModel().getColumn(0).setResizable(false);
            tableRoastPart.getColumnModel().getColumn(1).setResizable(false);
            tableRoastPart.getColumnModel().getColumn(2).setResizable(false);
            tableRoastPart.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel5.setText("Wprowadź użyte kawy zielone");

        textFieldOtherInfo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jScrollPane5.setViewportView(textFieldOtherInfo);

        jLabel8.setText("Wybierz linie produkcyjną");

        comboBoxProductionLine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        buttonOpenFile.setText("Otwórz kartę produktu");
        buttonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenFileActionPerformed(evt);
            }
        });

        jLabel2.setText("Wybierz kawę do upalenia ");

        comboBoxProductType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(197, 197, 197))
                                    .addComponent(buttonSendRaport, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxProductType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboBoxProductionLine, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonOpenFile)))
                        .addGap(20, 20, 20))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboBoxProductionLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOpenFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSendRaport)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSendRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendRaportActionPerformed
        try {
            dbc.openSession();
            RoastRaport roastRaport = new RoastRaport();

            Float totalSourceWeight = (float) 0;
            Float totalRoastWeight = (float) 0;
            Float totalSourceWeightFromGreenCoffee = (float) 0;
            HashSet<RoastPart> hsrp = new HashSet<>(0);
            for (int i = 0; i < tableRoastPart.getModel().getRowCount(); i++) {
                if (tableRoastPart.getModel().getValueAt(i, 0) == null) {
                    break;
                }
                RoastPart rp = new RoastPart();
                float toAddGreen = (Float) tableRoastPart.getModel().getValueAt(i, 0);
                rp.setSourceWeight(toAddGreen);
                totalSourceWeight += toAddGreen;

                Float toAddRoast = (Float) tableRoastPart.getModel().getValueAt(i, 1);
                rp.setRoastedWeight(toAddRoast);
                totalRoastWeight += toAddRoast;

                if (toAddGreen < toAddRoast) {
                    throw new NotMatchingCoffeeWeightException("Ilość zasypanej kawy zielonej mniejsza od ilość kawy upalonej.");

                }
                if (tableRoastPart.getModel().getValueAt(i, 2).equals("OK")) {
                    rp.setTemperature(Boolean.TRUE);
                } else {
                    rp.setTemperature(Boolean.FALSE);
                }
                rp.setColour(tableRoastPart.getModel().getValueAt(i, 3).toString());
                hsrp.add(rp);
            }
            totalRoastWeight = Global.round(totalRoastWeight, 1);
            roastRaport.setTotalRoastWeight(totalRoastWeight);
            totalSourceWeight = Global.round(totalSourceWeight, 1);
            roastRaport.setTotalSourceWeight(totalSourceWeight);

            roastRaport.setRoastPart(hsrp);

            HashSet<RoastGreenCoffeePart> hsrgcp = new HashSet<>(0);
            for (int i = 0; i < tableRoastGreenCoffeePart.getModel().getRowCount(); i++) {
                if (tableRoastGreenCoffeePart.getModel().getValueAt(i, 0) == null) {
                    break;
                }
                RoastGreenCoffeePart rgcp = new RoastGreenCoffeePart();
                rgcp.setWeight((Float) tableRoastGreenCoffeePart.getModel().getValueAt(i, weightColumnCoffee));
                rgcp.setCoffeeGreen(dbc.getCoffeeGreenWithLabId(tableRoastGreenCoffeePart.getModel().getValueAt(i, labIdColumnCoffee)));
                if (rgcp.getCoffeeGreen() == null) {
                    throw new ResourceNotFoundException((String) tableRoastGreenCoffeePart.getModel().getValueAt(i, labIdColumnCoffee));
                }
                if (rgcp.getCoffeeGreen().getCurrentWeight() - rgcp.getWeight() < 0) {
                    throw new NotEnoughtCoffeeException(rgcp.getCoffeeGreen().getLabId());
                }
                totalSourceWeightFromGreenCoffee += rgcp.getWeight();
                hsrgcp.add(rgcp);
            }
            roastRaport.setRoastGreenCoffeePart(hsrgcp);

            totalSourceWeightFromGreenCoffee = Global.round(totalSourceWeightFromGreenCoffee, 1);

            if (!totalSourceWeightFromGreenCoffee.equals(totalSourceWeight)) {
                throw new NotMatchingCoffeeWeightException("Ilość kawy pobranej nie zgadza się z ilością kawy w piecu.");
            }
            if (totalSourceWeight == 0) {
                throw new NotMatchingCoffeeWeightException("Ilość kawy równa zero, proszę uzupełnić raport.");
            }

            if (tableRoastAromaPart.getModel().getRowCount() != 0) {

                HashSet<RoastAromaPart> hsrap = new HashSet<>(0);
                for (int i = 0; i < tableRoastAromaPart.getModel().getRowCount(); i++) {

                    if (tableRoastAromaPart.getModel().getValueAt(i, 0) == null) {
                        break;
                    }
                    RoastAromaPart rap = new RoastAromaPart();
                    rap.setQuantity((Float) tableRoastAromaPart.getModel().getValueAt(i, weightColumnAroma));
                    rap.setAroma(dbc.getAromaWithLabId(tableRoastAromaPart.getModel().getValueAt(i, labIdColumnAroma)));
                    if (rap.getAroma() == null) {
                        throw new ResourceNotFoundException((String) tableRoastAromaPart.getModel().getValueAt(i, labIdColumnAroma));
                    }
                    if (rap.getAroma().getQuantity() - rap.getQuantity() < 0) {
                        throw new NotEnoughtAromaException(rap.getAroma().getLabId());
                    }
                    hsrap.add(rap);
                }
                roastRaport.setRoastAromaPart(hsrap);
            }
            roastRaport.setOtherInfo(textFieldOtherInfo.getText());
            roastRaport.setCompletedBy(emp);
            roastRaport.setCompleteTime(new Timestamp(System.currentTimeMillis()));
            roastRaport.setProductType(selectedProductType);
            roastRaport.setProductionLine(selectedProductionLine);
            roastRaport.setSwift(Global.currentShift());
            String[] options = new String[2];
            options[0] = "Zatwierdź";
            options[1] = "Odrzuć";

            int result = JOptionPane.showOptionDialog(this, new DetailsRoastRaportPanel(roastRaport), "Potwierdź raport", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (JOptionPane.OK_OPTION == result) {

                dbc.startTransation();
                for (RoastGreenCoffeePart rgcp : roastRaport.getRoastGreenCoffeePart()) {
                    rgcp.getCoffeeGreen().roast(rgcp.getWeight(), emp, roastRaport);
                    dbc.updateTransation(rgcp.getCoffeeGreen());
                    rgcp.setRoastRaport(roastRaport);
                }
                for (RoastAromaPart rap : roastRaport.getRoastAromaPart()) {
                    rap.getAroma().roast(rap.getQuantity(), emp, roastRaport);
                    dbc.updateTransation(rap.getAroma());
                    rap.setRoastRaport(roastRaport);
                }
                for (RoastPart rp : roastRaport.getRoastPart()) {
                    rp.setRoastRaport(roastRaport);
                }
                ProductionCoffee pc = new ProductionCoffee();
                roastRaport.setProductionCoffee(pc);
                dbc.saveTransation(roastRaport);
                pc.setProductType(roastRaport.getProductType());
                pc.setWeight(totalRoastWeight);
                pc.setState(Global.PRODUCTION_COFFEE_READY);
                pc.setProdDate(roastRaport.getCompleteTime());
                pc.setProducedBy(emp);
                dbc.saveTransation(pc);
                dbc.commitTransation();
                resetInput();
                initProductionList();
            }
        } catch (NotEnoughtCoffeeException e) {
            JOptionPane.showMessageDialog(this, ("Nie wystarczająca ilość kawy o ID " + e.getMessage()));
        } catch (NotEnoughtAromaException e) {
            JOptionPane.showMessageDialog(this, ("Nie wystarczająca ilość aromatu o ID " + e.getMessage()));
        } catch (NotMatchingCoffeeWeightException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Wprowadzone dane nie zostały zatwierdzone lub są błędnie wprowadzone.");
        } catch (ResourceNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Kawa lub aromat o ID " + ex.getMessage() + " nie istnieje.");
        }

    }//GEN-LAST:event_buttonSendRaportActionPerformed

    private void buttonOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenFileActionPerformed
        if (comboBoxProductType.getSelectedItem() != null) {
            ((ProductType) comboBoxProductType.getSelectedItem()).openFile(Global.FILE_READ_ONLY);
        }
    }//GEN-LAST:event_buttonOpenFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonOpenFile;
    private javax.swing.JButton buttonSendRaport;
    private javax.swing.JComboBox comboBoxProductType;
    private javax.swing.JComboBox comboBoxProductionLine;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tableRoastAromaPart;
    private javax.swing.JTable tableRoastGreenCoffeePart;
    private javax.swing.JTable tableRoastPart;
    private javax.swing.JTextPane textFieldOtherInfo;
    // End of variables declaration//GEN-END:variables
}
