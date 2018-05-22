/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import Exceptions.NotEnoughtCoffeeException;
import Exceptions.ZeroInputException;
import Listeners.CheckBoxDirectPackageRaport;
import ProductClasses.ProductType;
import ProductionClasses.Pallete;
import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionCoffeeSeek;
import ProductionClasses.ProductionLine;
import ProductionClasses.ProductionOrder;
import ProductionClasses.ProductionRaportDirectPackage;
import ProductionClasses.ProductionRaportPart;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Przemysław
 */
public class NewRaportProductionPanel extends javax.swing.JPanel {

    DataBaseConnector dbc = null;
    Employee emp;
    ProductionLine selectedProductionLine;
    ProductType selectedProductType;
    ProductionRaportPart productionRaportPart;
    float summaryWeight;
    int summaryPcs;
    int summaryPalletes;

    /**
     * Creates new form NewRaportRoastPanel
     */
    private void resetInput() {
        spinnerOxygen.setValue((float) 0);
        spinnerProductionCoffeeSeek.setValue((float) 0);
        spinnerStickWeight.setValue((float) 0);
        textAreaOtherInfo.setText("");
        textFieldBatchInfo.setText("");
        comboBoxProductionCoffee.setSelectedItem(null);
        comboBoxSeal.setSelectedItem(null);
        comboBoxBean.setSelectedItem(null);
        DefaultTableModel dtm = (DefaultTableModel) tableDirectPackage.getModel();
        dtm.setRowCount(0);
        dtm.setRowCount(1);
        dbc.clearSession();

    }

    private void setControls(boolean state) {
        spinnerOxygen.setEnabled(state);
        spinnerProductionCoffeeSeek.setEnabled(state);
        spinnerStickWeight.setEnabled(state);
        textAreaOtherInfo.setEnabled(state);
        textFieldBatchInfo.setEnabled(state);
        buttonSendRaport.setEnabled(state);
        comboBoxProductionCoffee.setEnabled(state);
        comboBoxSeal.setEnabled(state);
        comboBoxBean.setEnabled(state);
        buttonProductionCoffeeSeek.setEnabled(state);
        buttonConfirmProductionOrder.setEnabled(state);
        buttonSendRaport.setEnabled(state);
        buttonOpenFile.setEnabled(state);
        comboBoxProductType.setEnabled(state);
        tableDirectPackage.setEnabled(state);
    }

    private void initProductionLines() {
        ArrayList<ProductionLine> alpl = dbc.getProductionLine();
        comboBoxProductionLine.removeAllItems();
        for (ProductionLine pl : alpl) {
            if (!pl.isRoast()) {
                comboBoxProductionLine.addItem(pl);
            }
        }
        comboBoxProductionLine.setSelectedItem(null);
    }

    private void initProductionCoffee() {
        ArrayList<ProductionCoffee> alpc = dbc.getProductionCoffeeWithState(Global.PRODUCTION_COFFEE_READY);
        Object[] o = alpc.toArray();
        Arrays.sort(o);

        comboBoxProductionCoffee.removeAllItems();
        for (Object pc : o) {
            comboBoxProductionCoffee.addItem(pc);
        }
        spinnerProductionCoffeeSeek.setValue(0);
        comboBoxProductionCoffee.setSelectedItem(null);
    }

    private void initProductType() {
        ArrayList<ProductType> alpt = dbc.getProductType(Global.PRODUCT_TYPE_PACK);
        comboBoxProductType.removeAllItems();

        Object[] A = alpt.toArray();
        alpt.toArray(A);
        Arrays.sort(A);
        comboBoxProductType.removeAllItems();
        for (Object pt : A) {
            comboBoxProductType.addItem(pt);

        }
        comboBoxProductType.setSelectedItem(null);
    }

    public NewRaportProductionPanel(Employee emp) {
        initComponents();
        setControls(false);
        dbc = Global.getDataBaseConnector();
        resetInput();
        this.emp = emp;

        dbc.openSession();
        initProductionLines();
        initProductType();
        initProductionCoffee();
        tableDirectPackage.getModel().addTableModelListener(new CheckBoxDirectPackageRaport(2, 3));
        comboBoxProductType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                selectedProductType = (ProductType) comboBoxProductType.getSelectedItem();
            }
        });

        tablePallete.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                int row = e.getFirstRow();
                int column = e.getColumn();
                DefaultTableModel model = (DefaultTableModel) e.getSource();
                if (column == 4) {
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {
                        String[] options = {"Tak", "Nie"};
                        int result = JOptionPane.showOptionDialog(null, "Czy na pewno chcesz usunąć tę paletę z raportu?", "Uwaga!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                        if (JOptionPane.OK_OPTION == result) {
                            Pallete p = (Pallete) model.getValueAt(row, 0);
                            summaryWeight -= p.getNetto();
                            summaryPcs -= p.getQuantity();
                            summaryPalletes++;

                            JOptionPane.showMessageDialog(null, "Paleta usunięta.");
                        }
                    }
                } else if (column == 5) {
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {
                        String[] options = {"Tak", "Nie"};
                        int result = JOptionPane.showOptionDialog(null, "Czy na pewno chcesz usunąć tę paletę z raportu?", "Uwaga!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
                        if (JOptionPane.OK_OPTION == result) {
                            Pallete p = (Pallete) model.getValueAt(row, 0);
                            summaryWeight -= p.getNetto();
                            summaryPcs -= p.getQuantity();
                            summaryPalletes++;
                            dbc.deleteObject(p);
                            JOptionPane.showMessageDialog(null, "Paleta usunięta.");
                        }
                    }
                } else if (column == 6) {
                    Boolean checked = (Boolean) model.getValueAt(row, column);
                    if (checked) {
                        Pallete p = (Pallete) model.getValueAt(row, 0);
                        p.showDetails();
                    }
                }

            }

        });

        comboBoxProductionLine.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                selectedProductionLine = (ProductionLine) comboBoxProductionLine.getSelectedItem();
                if (selectedProductionLine != null) {
                    comboBoxProductType.setEnabled(true);
                    setControls(true);

                } else {
                    comboBoxProductType.setEnabled(false);
                    setControls(false);

                }
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

        buttonSendRaport = new javax.swing.JButton();
        comboBoxProductionCoffee = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        spinnerProductionCoffeeSeek = new javax.swing.JSpinner(new SpinnerNumberModel(new Float(0), new Float(0),null,new Float(0.01)));
        buttonProductionCoffeeSeek = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        comboBoxProductionLine = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        buttonOpenFile = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        comboBoxProductType = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        textFieldBatchInfo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBoxSeal = new javax.swing.JComboBox();
        comboBoxBean = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        spinnerOxygen = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        spinnerStickWeight = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaOtherInfo = new javax.swing.JTextArea();
        buttonConfirmProductionOrder = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDirectPackage = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablePallete = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        spinnerExpiry = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();

        buttonSendRaport.setText("Rozlicz zarezerwowaną kawę");
        buttonSendRaport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendRaportActionPerformed(evt);
            }
        });

        comboBoxProductionCoffee.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Wybierz kawę do rezerwacji");

        buttonProductionCoffeeSeek.setText("Zarezerwuj kawę");
        buttonProductionCoffeeSeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductionCoffeeSeekActionPerformed(evt);
            }
        });

        jLabel6.setText("Ilość kawy");

        comboBoxProductionLine.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel7.setText("Wybierz linię produkcyjną");

        buttonOpenFile.setText("Pokaż kartę produktu");
        buttonOpenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOpenFileActionPerformed(evt);
            }
        });

        jLabel10.setText("Wybierz typ produktu");

        comboBoxProductType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Numer partii");

        jLabel3.setText("Szczelność");

        comboBoxSeal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TAK", "NIE" }));

        comboBoxBean.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ziarno", "Mielona", "Instant" }));

        jLabel2.setText("Ziarno/Mielona");

        spinnerOxygen.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(0.1f)));

        jLabel4.setText("Tlen [%]");

        spinnerStickWeight.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), null, Float.valueOf(0.1f)));

        jLabel19.setText("Wielkość Stick [g]");

        textAreaOtherInfo.setColumns(20);
        textAreaOtherInfo.setRows(5);
        jScrollPane2.setViewportView(textAreaOtherInfo);

        buttonConfirmProductionOrder.setText("Zatwierdź wykonanie zlecenia");
        buttonConfirmProductionOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonConfirmProductionOrderActionPerformed(evt);
            }
        });

        jLabel21.setText("Uwagi");

        tableDirectPackage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Nr Zlec Kontr", "Typ", "+", "-"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableDirectPackage);
        if (tableDirectPackage.getColumnModel().getColumnCount() > 0) {
            tableDirectPackage.getColumnModel().getColumn(0).setMinWidth(160);
            tableDirectPackage.getColumnModel().getColumn(0).setPreferredWidth(160);
            tableDirectPackage.getColumnModel().getColumn(0).setMaxWidth(160);
            tableDirectPackage.getColumnModel().getColumn(2).setMinWidth(50);
            tableDirectPackage.getColumnModel().getColumn(2).setPreferredWidth(50);
            tableDirectPackage.getColumnModel().getColumn(2).setMaxWidth(50);
            tableDirectPackage.getColumnModel().getColumn(3).setMinWidth(50);
            tableDirectPackage.getColumnModel().getColumn(3).setPreferredWidth(50);
            tableDirectPackage.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jLabel5.setText("Folie, Kapsle, Bibuły, Aluminium");

        tablePallete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "", "Numer Palety", "Szt", "Kg", "+", "-", "Etykieta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablePallete);
        if (tablePallete.getColumnModel().getColumnCount() > 0) {
            tablePallete.getColumnModel().getColumn(0).setMinWidth(0);
            tablePallete.getColumnModel().getColumn(0).setPreferredWidth(0);
            tablePallete.getColumnModel().getColumn(0).setMaxWidth(0);
            tablePallete.getColumnModel().getColumn(1).setMinWidth(160);
            tablePallete.getColumnModel().getColumn(1).setPreferredWidth(160);
            tablePallete.getColumnModel().getColumn(1).setMaxWidth(160);
            tablePallete.getColumnModel().getColumn(4).setMinWidth(50);
            tablePallete.getColumnModel().getColumn(4).setPreferredWidth(50);
            tablePallete.getColumnModel().getColumn(4).setMaxWidth(50);
            tablePallete.getColumnModel().getColumn(5).setMinWidth(50);
            tablePallete.getColumnModel().getColumn(5).setPreferredWidth(50);
            tablePallete.getColumnModel().getColumn(5).setMaxWidth(50);
            tablePallete.getColumnModel().getColumn(6).setMinWidth(80);
            tablePallete.getColumnModel().getColumn(6).setPreferredWidth(80);
            tablePallete.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        jLabel1.setText("Palety");

        jLabel9.setText("Informacje dodatkowe");

        jButton1.setText("Nadaj");

        spinnerExpiry.setModel(new javax.swing.SpinnerDateModel());

        jLabel12.setText("Data ważność");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonSendRaport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonConfirmProductionOrder))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textFieldBatchInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerStickWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(comboBoxSeal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxBean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spinnerOxygen, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxProductionCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerProductionCoffeeSeek, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonProductionCoffeeSeek, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxProductionLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonOpenFile))
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxProductionLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboBoxProductionCoffee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerProductionCoffeeSeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(buttonProductionCoffeeSeek))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboBoxProductType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonOpenFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(spinnerExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldBatchInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spinnerStickWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboBoxSeal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboBoxBean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinnerOxygen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSendRaport)
                    .addComponent(buttonConfirmProductionOrder))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSendRaportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendRaportActionPerformed
        String[] options = new String[2];
        options[0] = "Zamknij raport ze zmiany";
        options[1] = "Cofnij";
        ManageProductionCoffeeSeek mpcs = new ManageProductionCoffeeSeek(emp);
        int result = JOptionPane.showOptionDialog(this, mpcs, "Rozlicz niezużytą kawę.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (result == JOptionPane.YES_OPTION) {
            if (mpcs.warden == 0) {
                dbc.openSession();
                for (ProductionCoffeeSeek pcs : dbc.getProductionCoffeeSeekWithEmployee(emp)) {
                    pcs.getProductionCoffee().setWeight(Global.round(pcs.getProductionCoffee().getWeight() + pcs.getWeight(), 2));
                    if (pcs.getProductionCoffee().getWeight() > 0) {
                        pcs.getProductionCoffee().setState(Global.PRODUCTION_COFFEE_READY);
                        pcs.getProductionCoffee().setUsed(true);
                    }
                    dbc.updateObject(pcs.getProductionCoffee());
                    dbc.deleteObject(pcs);
                }

                setControls(false);
                initProductionLines();
                initProductionCoffee();
            } else {
                JOptionPane.showMessageDialog(this, "Prosze rozliczyć cała kawę.");
                buttonSendRaportActionPerformed(evt);
            }
        }

    }//GEN-LAST:event_buttonSendRaportActionPerformed

    private void buttonProductionCoffeeSeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductionCoffeeSeekActionPerformed
        try {
            ProductionCoffee pc = (ProductionCoffee) comboBoxProductionCoffee.getSelectedItem();
            Float pcToSeek = Global.round((Float) spinnerProductionCoffeeSeek.getValue(), 2);
            if (pcToSeek == 0) {
                throw new ZeroInputException();
            }
            if (pc.getWeight() - pcToSeek < 0) {
                throw new NotEnoughtCoffeeException(pc.getProductType().getProductName());
            }
            ProductionCoffeeSeek pcs = new ProductionCoffeeSeek();
            pcs.setSeekedBy(emp);
            pcs.setWeight(Global.round(pcToSeek, 2));
            pcs.setProductionCoffee(pc);
            pc.setWeight(Global.round(pc.getWeight() - pcToSeek, 2));
            if (pc.getWeight() == 0) {
                pc.setState(Global.PRODUCTION_COFFEE_OUT_OF_STORE);
            }
            dbc.updateObject(pc);
            dbc.saveObject(pcs);
            initProductionCoffee();
            JOptionPane.showMessageDialog(this, ("Zarezerwowano kawę" + pc.getProductType().getProductName() + " w ilośći " + pcToSeek + "[kg]."));
        } catch (ClassCastException e) {
            JOptionPane.showMessageDialog(this, ("Proszę podać ilośc kawy do rezerwacji."));
        } catch (ZeroInputException e) {
            JOptionPane.showMessageDialog(this, ("Proszę podać ilośc kawy do rezerwacji."));
        } catch (NotEnoughtCoffeeException e) {
            JOptionPane.showMessageDialog(this, ("Nie wystarczająca ilość kawy " + e.getMessage()));
        }
    }//GEN-LAST:event_buttonProductionCoffeeSeekActionPerformed

    private void buttonOpenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOpenFileActionPerformed
        selectedProductType.openFile(Global.FILE_READ_ONLY);
    }//GEN-LAST:event_buttonOpenFileActionPerformed

    private void buttonConfirmProductionOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonConfirmProductionOrderActionPerformed

        try {
            dbc.clearSession();
            dbc.openSession();
            ProductionRaportPart prp = new ProductionRaportPart();
            prp.setEmp(emp);
            prp.setRaportDate(new Timestamp(System.currentTimeMillis()));
            prp.setRaportId(WIDTH);
            prp.setShift(Global.currentShift());
            prp.setProductionLine(selectedProductionLine);
            prp.setBatchInfo(textFieldBatchInfo.getText());
            prp.setOtherInfo(textAreaOtherInfo.getText());
            prp.setStickSize((Float) spinnerStickWeight.getValue());
            prp.setOxygen((Float) spinnerOxygen.getValue());
            prp.setTotalWeight(Global.round((Float) summaryWeight, 2));
            for (int i = 0; i < tableDirectPackage.getRowCount() - 1; i++) {
                ProductionRaportDirectPackage prdp = new ProductionRaportDirectPackage();
                prdp.setProductionRaportPart(prp);
                prdp.setDirectPackage(dbc.findDirectPackageWithLabId((String) tableDirectPackage.getValueAt(i, 0)));
                prp.getProductionRaportDirectPackage().add(prdp);
            }
            prp.setType(comboBoxBean.getSelectedIndex());
            if (comboBoxSeal.getSelectedIndex() == 1) {
                prp.setSealing(false);
            } else {
                prp.setSealing(true);
            }
            prp.setTotalPallete(summaryPalletes);
            prp.setTotalPcs(summaryPcs);
            if (selectedProductType == null) {
                throw new ZeroInputException();
            }

            prp.setProductType(selectedProductType);
            if (prp.getTotalWeight() == 0 || prp.getKGperPallete() == 0 || prp.getPCSperPallete() == 0 || prp.getTotalPcs() == 0 || prp.getBatchInfo().length() < 5) {
                throw new ZeroInputException();
            }
            prp.setLabTestState(Global.PRODUCTION_RAPORT_PART_WAITING);
            String[] options = new String[2];
            options[0] = "Dalej";
            options[1] = "Odrzuć";
            dbc.startTransation();
            int res = JOptionPane.showOptionDialog(this, new NewCoffeeAssignmentPanel(prp, emp), "Przypisz użytą kawę.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (JOptionPane.OK_OPTION == res) {
                int result = JOptionPane.showOptionDialog(this, new DetailsProductionRaportPartPanel(prp), "Sprawdź poprawność raportu.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                if (JOptionPane.OK_OPTION == result) {
                    dbc.saveTransation(prp);
                    dbc.commitTransation();
                    resetInput();
                    System.out.println("OK@");
                } else {
                    dbc.rollbackTransation();
                }
            } else {
                dbc.rollbackTransation();
            }

            dbc.flush();

        } catch (ZeroInputException e) {
            JOptionPane.showMessageDialog(this, ("Proszę uzupełnić wymagane pola w raporcie."));
        } catch (Exception e) {
            e.printStackTrace();
            dbc.rollbackTransation();
        }
    }//GEN-LAST:event_buttonConfirmProductionOrderActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonConfirmProductionOrder;
    private javax.swing.JButton buttonOpenFile;
    private javax.swing.JButton buttonProductionCoffeeSeek;
    private javax.swing.JButton buttonSendRaport;
    private javax.swing.JComboBox comboBoxBean;
    private javax.swing.JComboBox comboBoxProductType;
    private javax.swing.JComboBox comboBoxProductionCoffee;
    private javax.swing.JComboBox comboBoxProductionLine;
    private javax.swing.JComboBox comboBoxSeal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spinnerExpiry;
    private javax.swing.JSpinner spinnerOxygen;
    private javax.swing.JSpinner spinnerProductionCoffeeSeek;
    private javax.swing.JSpinner spinnerStickWeight;
    private javax.swing.JTable tableDirectPackage;
    private javax.swing.JTable tablePallete;
    private javax.swing.JTextArea textAreaOtherInfo;
    private javax.swing.JTextField textFieldBatchInfo;
    // End of variables declaration//GEN-END:variables
}
