/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import GreenCoffeeClasses.CoffeeGreen;
import GreenCoffeeClasses.CoffeeGreenChangeHistory;
import GreenCoffeeClasses.CoffeeType;
import ProductClasses.Aroma;
import ProductClasses.AromaChangeHistory;
import ProductClasses.AromaType;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Przemysław
 */
public class GenerateResourcesSummary extends javax.swing.JPanel {

    /**
     * Creates new form GenerateTotalProductionRaport
     */
    DataBaseConnector dbc;
    String directoryUrl;
    XSSFWorkbook workbook;

    Object[] headerTotal = {"Nr", "Nazwa surowca", "Rozchód", "Dostawy", "Stan",};
    Object[] headerHistory = {"Zmiana", "Komentarz", "Zmienił", "Data"};

    Object[] headerBean = {"Kawa zielona"};
    Object[] headerInstant = {"Kawa instant"};
    Object[] headerAroma = {"Aromaty"};

    private final int padding = 2;
    private final int globalRowOffset = 3;
    private final int historyOffset = 1;
    private final int totalOffset = 0;

    public GenerateResourcesSummary() {
        initComponents();

        dbc = Global.getDataBaseConnector();
        dbc.openSession();

        SimpleDateFormat model = new SimpleDateFormat("MM-yyyy");
        spinnerDate.setEditor(new JSpinner.DateEditor(spinnerDate, model.toPattern()));
        textFieldFileName.setText(model.format((Date) spinnerDate.getValue()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        spinnerDate = new javax.swing.JSpinner();
        textFieldFileName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonChooseSaveCatalog = new javax.swing.JButton();
        buttonGenerate = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        textFieldFullPath = new javax.swing.JTextField();

        jLabel1.setText("Wybierz date ");

        spinnerDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        spinnerDate.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinnerDateStateChanged(evt);
            }
        });

        jLabel2.setText("Nazwa pliku docelowego (domyślnie data)");

        buttonChooseSaveCatalog.setText("Wybierz folder zapisu");
        buttonChooseSaveCatalog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseSaveCatalogActionPerformed(evt);
            }
        });

        buttonGenerate.setText("Generuj");
        buttonGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGenerateActionPerformed(evt);
            }
        });

        jLabel3.setText("Miejsce zapisu wygenerowanego raportu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldFullPath)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(spinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textFieldFileName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(buttonChooseSaveCatalog)
                            .addComponent(jLabel3)
                            .addComponent(buttonGenerate))
                        .addGap(0, 507, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(textFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonChooseSaveCatalog)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldFullPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonGenerate)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChooseSaveCatalogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseSaveCatalogActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        directoryUrl = fileChooser.getSelectedFile().getAbsolutePath();
        if (directoryUrl != null) {
            textFieldFullPath.setText(directoryUrl + "\\KawyAromaty-" + textFieldFileName.getText() + ".xlsx");
        } else {
            JOptionPane.showMessageDialog(this, "Błąd");
        }
    }//GEN-LAST:event_buttonChooseSaveCatalogActionPerformed

    private void buttonGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGenerateActionPerformed

        try {
            Date now = XSSFFunctions.trimMonth((Date) spinnerDate.getValue());
            Date nextMonth = XSSFFunctions.trimMonthDown(XSSFFunctions.addMonth(now));
            now = XSSFFunctions.trimMonthDown(now);
            Timestamp from = new Timestamp(now.getTime());
            Timestamp to = new Timestamp(nextMonth.getTime());

            workbook = new XSSFWorkbook();
            XSSFSheet greenSheet = workbook.createSheet("ZIELONA");
            greenSheet.setZoom(85);
            XSSFSheet instantSheet = workbook.createSheet("INSTANT");
            instantSheet.setZoom(85);
            XSSFSheet aromaSheet = workbook.createSheet("AROMATY");
            aromaSheet.setZoom(85);
            CreationHelper createHelper = workbook.getCreationHelper();

            Hyperlink linkGreen = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
            linkGreen.setAddress("'ZIELONA'!A1");
            Hyperlink linkInstant = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
            linkInstant.setAddress("'INSTANT'!A1");
            Hyperlink linkAroma = createHelper.createHyperlink(HyperlinkType.DOCUMENT);
            linkAroma.setAddress("'AROMATY'!A1");

            ArrayList<ResourceData> greenData = new ArrayList<>();
            ArrayList<ResourceData> instantData = new ArrayList<>();
            ArrayList<ResourceData> aromaData = new ArrayList<>();
            int instantNum = 1;
            int greenNum = 1;
            int aromaNum = 1;

            ArrayList<CoffeeType> alct = dbc.getCoffeeType();
            Object[] coffeeTypes = alct.toArray();
            Arrays.sort(coffeeTypes);

            for (Object o : coffeeTypes) {
                CoffeeType ct = (CoffeeType) o;
                ArrayList<CoffeeGreen> alcg = dbc.getCoffeeGreenWithCoffeeTypeNoState(ct);
                ArrayList<HistoryData> alhd = new ArrayList<>();
                Float currentWeight = new Float(0);
                for (CoffeeGreen cg : alcg) {
                    currentWeight += cg.getCurrentWeight();
                    Object[] his = cg.getCoffeeGreenChangeHistory().toArray();
                    Arrays.sort(his);
                    for (Object ch : his) {
                        CoffeeGreenChangeHistory cgch = (CoffeeGreenChangeHistory) ch;
                        if (cgch.getChangeTime().before(to) && cgch.getChangeTime().after(from)) {
                            alhd.add(new HistoryData(cgch.getWeight(), cgch.getComment(), cgch.getChangedBy().toString(), cgch.getChangeTime()));
                        }
                    }
                }
                XSSFSheet sheet = workbook.createSheet(String.valueOf(ct.getId()));
                sheet.setZoom(85);
                XSSFFunctions.fillHeader(sheet, headerHistory, historyOffset, globalRowOffset);
                XSSFFunctions.fillData(sheet, alhd.toArray(), historyOffset, globalRowOffset + 1);
                XSSFFunctions.fixCellStyle(sheet, workbook, headerHistory.length, alhd.size(), historyOffset, globalRowOffset + 1);
                XSSFFunctions.fixHeaderStyle(sheet, workbook, headerHistory.length, historyOffset, 1, globalRowOffset);
                XSSFFunctions.fixCellFormat(sheet, workbook, 1, alhd.size(), historyOffset, globalRowOffset + 1);

                if (!ct.isInstant()) {
                    greenData.add(new ResourceData(greenNum++, ct.toString(), ct.getId(), currentWeight, createHelper));
                    XSSFFunctions.putReturnCell(sheet, linkGreen);
                } else {
                    instantData.add(new ResourceData(instantNum++, ct.toString(), ct.getId(), currentWeight, createHelper));
                    XSSFFunctions.putReturnCell(sheet, linkInstant);
                }
            }

            ArrayList<AromaType> alat = dbc.getAromaType();
            Object[] aromaTypes = alat.toArray();
            Arrays.sort(aromaTypes);

            for (Object o : aromaTypes) {
                AromaType at = (AromaType) o;
                ArrayList<Aroma> ala = dbc.getAromaWithAromaTypeNoState(at);
                ArrayList<HistoryData> alhd = new ArrayList<>();
                Float currentWeight = new Float(0);
                for (Aroma a : ala) {
                    currentWeight += a.getQuantity();
                    Object[] his = a.getAromaChangeHistory().toArray();
                    Arrays.sort(his);
                    for (Object ch : his) {
                        AromaChangeHistory ach = (AromaChangeHistory) ch;
                        if (ach.getChangeTime().before(to) && ach.getChangeTime().after(from)) {
                            alhd.add(new HistoryData(ach.getWeight(), ach.getComment(), ach.getChangedBy().toString(), ach.getChangeTime()));
                        }
                    }
                }
                XSSFSheet sheet = workbook.createSheet(String.valueOf(at.getId() + 5000));
                sheet.setZoom(85);
                XSSFFunctions.fillHeader(sheet, headerHistory, historyOffset, globalRowOffset);
                XSSFFunctions.fillData(sheet, alhd.toArray(), historyOffset, globalRowOffset + 1);
                XSSFFunctions.fixCellStyle(sheet, workbook, headerHistory.length, alhd.size(), historyOffset, globalRowOffset + 1);
                XSSFFunctions.fixHeaderStyle(sheet, workbook, headerHistory.length, historyOffset, 1, globalRowOffset);
                XSSFFunctions.fixCellFormat(sheet, workbook, 1, alhd.size(), historyOffset, globalRowOffset + 1);

                aromaData.add(new ResourceData(aromaNum++, at.toString(), at.getId() + 5000, currentWeight, createHelper));
                XSSFFunctions.putReturnCell(sheet, linkAroma);

            }

            XSSFFunctions.fillHeader(greenSheet, headerTotal, totalOffset, globalRowOffset);
            XSSFFunctions.fillData(greenSheet, greenData.toArray(), totalOffset, globalRowOffset + 1);
            XSSFFunctions.fixCellStyle(greenSheet, workbook, headerTotal.length, greenData.size(), totalOffset, globalRowOffset + 1);
            XSSFFunctions.fixHeaderStyle(greenSheet, workbook, headerTotal.length, 1, totalOffset, globalRowOffset);
            XSSFFunctions.fixCellFormat(greenSheet, workbook, 3, greenData.size(), totalOffset + 2, globalRowOffset + 1);

            XSSFFunctions.fillHeader(instantSheet, headerTotal, totalOffset, globalRowOffset);
            XSSFFunctions.fillData(instantSheet, instantData.toArray(), totalOffset, globalRowOffset + 1);
            XSSFFunctions.fixCellStyle(instantSheet, workbook, headerTotal.length, instantData.size(), totalOffset, globalRowOffset + 1);
            XSSFFunctions.fixHeaderStyle(instantSheet, workbook, headerTotal.length, 1, totalOffset, globalRowOffset);
            XSSFFunctions.fixCellFormat(instantSheet, workbook, 3, instantData.size(), totalOffset + 2, globalRowOffset + 1);

            XSSFFunctions.fillHeader(aromaSheet, headerTotal, totalOffset, globalRowOffset);
            XSSFFunctions.fillData(aromaSheet, aromaData.toArray(), totalOffset, globalRowOffset + 1);
            XSSFFunctions.fixCellStyle(aromaSheet, workbook, headerTotal.length, aromaData.size(), totalOffset, globalRowOffset + 1);
            XSSFFunctions.fixHeaderStyle(aromaSheet, workbook, headerTotal.length, 1, totalOffset, globalRowOffset);
            XSSFFunctions.fixCellFormat(aromaSheet, workbook, 3, aromaData.size(), totalOffset + 2, globalRowOffset + 1);

            if (textFieldFullPath.getText().length() < 2) {
                JOptionPane.showMessageDialog(this, "Wybierz folder");
            } else {
                File f = new File(textFieldFullPath.getText());
                try {
                    f.createNewFile();
                    try (FileOutputStream outputStream = new FileOutputStream(f)) {
                        workbook.write(outputStream);
                        workbook.close();
                    }
                    JOptionPane.showMessageDialog(this, "Wygenerowano");
                } catch (FileNotFoundException e) {
                } catch (IOException e) {
                }
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void spinnerDateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerDateStateChanged
        SimpleDateFormat model = new SimpleDateFormat("MM-yyyy");
        textFieldFileName.setText(model.format((Date) spinnerDate.getValue()));        // TODO add your handling code here:
    }//GEN-LAST:event_spinnerDateStateChanged

    public class HistoryData {

        public HistoryData(float change, String reason, String who, Timestamp date) {
            this.change = change;
            this.reason = reason;
            this.who = who;
            this.date = Global.timestampToStrDDMMYYYY(date);
        }

        float change;
        String reason;
        String who;
        String date;

    }

    public class ResourceData {

        public ResourceData(int number, String name, int id, float weight, CreationHelper ch) {
            this.number = number;
            this.name = name;
            this.id = id;
            this.weight = weight;
            this.creationHelper = ch;
        }
        int number;
        String name;
        int id;
        float weight;
        CreationHelper creationHelper;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonChooseSaveCatalog;
    private javax.swing.JButton buttonGenerate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSpinner spinnerDate;
    private javax.swing.JTextField textFieldFileName;
    private javax.swing.JTextField textFieldFullPath;
    // End of variables declaration//GEN-END:variables
}
