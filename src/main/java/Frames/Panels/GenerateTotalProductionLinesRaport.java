/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import ProductClasses.RoastRaport;
import ProductionClasses.ProductionLine;
import ProductionClasses.ProductionRaportCoffeeAssignment;
import ProductionClasses.ProductionRaportPart;
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
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Przemysław
 */
public class GenerateTotalProductionLinesRaport extends javax.swing.JPanel {

    /**
     * Creates new form GenerateTotalProductionRaport
     */
    DataBaseConnector dbc;
    String directoryUrl;
    XSSFWorkbook workbook;

    Object[] headerProduction = {"Numer partii", "Data Produkcji", "Maszyna", "Zmiana", "Kod operatora", "Rodzaj wyprodukowanej kawy", "Ilość pobranej kawy", "Ilość palet", "Razem[szt]", "Razem[Kg]", "Uwagi"};
    Object[] headerRoast = {"Data Produkcji", "Maszyna", "Operator", "Typ Kawy", "Ilość Kawy", "Typ składnika", "Ilość składnika", "Typ produktu", "Kawa zasypana", "Kawa Upalona", "Temperatura", "Kolor", "Uwagi"};

    private void transformProduction(ArrayList<ProductionRaportPart> prp) {

        XSSFSheet sheet;
        int rowNum;
        if (prp.size() > 0) {
            sheet = workbook.createSheet(prp.get(0).getProductionLine().getLine());
            sheet.setZoom(85);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.MEDIUM);
            headerStyle.setBorderRight(BorderStyle.MEDIUM);
            headerStyle.setBorderLeft(BorderStyle.MEDIUM);

            rowNum = 0;
            int colNum = 0;
            Row headerRow = XSSFFunctions.nextRow(++rowNum, sheet);
            for (Object o : headerProduction) {
                Cell cell = headerRow.createCell(colNum++);
                cell.setCellValue(o.toString());
                cell.setCellStyle(headerStyle);

            }

            for (ProductionRaportPart p : prp) {
                colNum = 0;
                Row dataRow = XSSFFunctions.nextRow(++rowNum, sheet);

                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getBatchInfo());
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(Global.timestampToStrDDMMYYYY(p.getRaportDate()));
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getProductionLine().toString());
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getShift());
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getEmp().getEmployeeID());
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getProductType().getProductName());
                Float cellValue = new Float(0);
                for (ProductionRaportCoffeeAssignment prca : p.getProductionRaportCoffeeAssignment()) {
                    cellValue += prca.getWeight();
                }
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(cellValue);
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getTotalPallete());
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getTotalPcs());
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getTotalWeight());
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(p.getOtherInfo());

            }
            for (int i = 0; i < headerProduction.length; i++) {
                sheet.autoSizeColumn(i);

            }
            XSSFFunctions.fixCellStyle(sheet, workbook, headerProduction.length, rowNum, 0, 2);

            XSSFFunctions.fixCellFormat(sheet, workbook, 1, rowNum, 6, 2);
            XSSFFunctions.fixCellFormat(sheet, workbook, 1, rowNum, 9, 2);
        }
    }

    private void transformRoast(ArrayList<RoastRaport> rr) {

        XSSFSheet sheet = null;

        int rowNum = 0;
        int offset = 0;
        if (rr.size() > 0) {

            sheet = workbook.createSheet(rr.get(0).getProductionLine().getLine());
            sheet.setZoom(85);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.CENTER);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderTop(BorderStyle.MEDIUM);
            headerStyle.setBorderRight(BorderStyle.MEDIUM);
            headerStyle.setBorderLeft(BorderStyle.MEDIUM);

            rowNum = offset;

            int colNum = 0;
            Row headerRow = XSSFFunctions.nextRow(++rowNum, sheet);
            for (Object o : headerRoast) {
                Cell cell = headerRow.createCell(colNum++);
                cell.setCellValue(o.toString());
                cell.setCellStyle(headerStyle);

            }

            for (RoastRaport r : rr) {
                rowNum = rowNum + offset;
                if (r.getRoastAromaPart() != null) {
                    offset = XSSFFunctions.max(r.getRoastGreenCoffeePart().size(), XSSFFunctions.max(r.getRoastAromaPart().size(), r.getRoastPart().size()));
                } else {
                    offset = XSSFFunctions.max(r.getRoastGreenCoffeePart().size(), r.getRoastPart().size());
                }

                colNum = 0;
                Row dataRow = XSSFFunctions.nextRow(++rowNum, sheet);

                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(Global.timestampToStrDDMMYYYY(r.getCompleteTime()));
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(r.getProductionLine().getLine());
                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(r.getCompletedBy().getEmployeeID());

                Object[] gcp = r.getRoastGreenCoffeePart().toArray();
                XSSFFunctions.fillData(sheet, gcp, colNum, rowNum);
                colNum += 2;

                Object[] ap = r.getRoastAromaPart().toArray();
                XSSFFunctions.fillData(sheet, ap, colNum, rowNum);
                colNum += 2;

                XSSFFunctions.nextCell(colNum++, dataRow).setCellValue(r.getProductType().toString());

                Object[] rp = r.getRoastPart().toArray();
                XSSFFunctions.fillData(sheet, rp, colNum, rowNum);
                colNum += 4;

                XSSFFunctions.nextCell(colNum, dataRow).setCellValue(r.getOtherInfo());
                rowNum += 2;

            }
            for (int i = 0; i < headerRoast.length; i++) {
                sheet.autoSizeColumn(i);
            }
        }
        XSSFFunctions.fixCellStyle(sheet, workbook, headerRoast.length, rowNum + offset, 0, 2);
        XSSFFunctions.fixCellFormat(sheet, workbook, 1, rowNum + offset, 4, 2);
        XSSFFunctions.fixCellFormat(sheet, workbook, 1, rowNum + offset, 6, 2);
        XSSFFunctions.fixCellFormat(sheet, workbook, 2, rowNum + offset, 8, 2);
    }

    public GenerateTotalProductionLinesRaport() {
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
            textFieldFullPath.setText(directoryUrl + "\\RaportyProdukcja-" + textFieldFileName.getText() + ".xlsx");
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

            for (ProductionLine prodLine : dbc.getProductionLine()) {
                if (!prodLine.isRoast()) {
                    transformProduction(dbc.getProductionRaportPartWithFromToAndProductionLine(from, to, prodLine));
                } else {
                    transformRoast(dbc.getRoastRaportWithFromToAndProductionLine(from, to, prodLine));
                }
            }
            if (workbook.getNumberOfSheets() == 0) {
                workbook.createSheet("BRAK DANYCH");
            }
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
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_buttonGenerateActionPerformed

    private void spinnerDateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinnerDateStateChanged
        SimpleDateFormat model = new SimpleDateFormat("MM-yyyy");
        textFieldFileName.setText(model.format((Date) spinnerDate.getValue()));        // TODO add your handling code here:
    }//GEN-LAST:event_spinnerDateStateChanged


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
