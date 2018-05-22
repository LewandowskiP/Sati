/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames.Panels;

import Frames.Panels.GenerateProductionSummary.MixData;
import Frames.Panels.GenerateProductionSummary.ProductionData;
import Frames.Panels.GenerateProductionSummary.RoastData;
import Frames.Panels.GenerateResourcesSummary.HistoryData;
import Frames.Panels.GenerateResourcesSummary.ResourceData;
import ProductClasses.RoastAromaPart;
import ProductClasses.RoastGreenCoffeePart;
import ProductClasses.RoastPart;
import ProductionManagement.Global;
import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Przemysław
 */
public class XSSFFunctions {

    public static int max(int a, int b) {
        if (b > a) {
            return b;
        } else {
            return a;
        }
    }

    public static Cell nextCell(int num, Row row) {
        Cell r = row.getCell(num, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
        if (r == null) {
            r = row.createCell(num);
        }
        return r;
    }

    public static Row nextRow(int num, XSSFSheet sheet) {
        Row r = sheet.getRow(num);
        if (r == null) {
            r = sheet.createRow(num);
        }
        return r;
    }

    public static void fixHeaderStyle(XSSFSheet sheet, XSSFWorkbook workbook, int columns, int rows, int offsetColumns, int offsetRows) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.index);
        cellStyle.setBorderBottom(BorderStyle.MEDIUM);
        cellStyle.setBorderTop(BorderStyle.MEDIUM);
        cellStyle.setBorderRight(BorderStyle.MEDIUM);
        cellStyle.setBorderLeft(BorderStyle.MEDIUM);

        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial CE");

        cellStyle.setFont(font);

        Row row = nextRow(offsetRows, sheet);
        for (int j = offsetColumns; j < offsetColumns + columns; j++) {
            nextCell(j, row).setCellStyle(cellStyle);
            sheet.autoSizeColumn(j);
            if (sheet.getColumnWidth(j) < 2000) {
                sheet.setColumnWidth(j, 2000);
            }

        }

    }

    public static void fixCellFormat(XSSFSheet sheet, XSSFWorkbook workbook, int columns, int rows, int offsetColumns, int offsetRows) {

        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);

        DataFormat format = workbook.createDataFormat();
        cellStyle.setDataFormat(format.getFormat("#0.00"));

        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial CE");

        cellStyle.setFont(font);

        for (int i = offsetRows; i < offsetRows + rows; i++) {
            Row row = nextRow(i, sheet);
            for (int j = offsetColumns; j < offsetColumns + columns; j++) {
                nextCell(j, row).setCellStyle(cellStyle);
            }
        }

    }

    public static void fixCellStyle(XSSFSheet sheet, XSSFWorkbook workbook, int columns, int rows, int offsetColumns, int offsetRows) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderTop(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);

        XSSFFont font = workbook.createFont();
        font.setFontHeightInPoints((short) 10);
        font.setFontName("Arial CE");

        cellStyle.setFont(font);

        for (int i = offsetRows; i < offsetRows + rows; i++) {
            Row row = nextRow(i, sheet);
            for (int j = offsetColumns; j < offsetColumns + columns; j++) {
                nextCell(j, row).setCellStyle(cellStyle);
            }
        }
    }

    public static void fillHeader(XSSFSheet sheet, Object[] data, int offsetColumns, int offsetRows) {
        Row row = nextRow(offsetRows, sheet);
        for (int i = 0; i < data.length; i++) {
            nextCell(offsetColumns + i, row).setCellValue((String) data[i]);
        }

    }

    public static void fillData(XSSFSheet sheet, Object[] data, int offsetColumns, int offsetRows) {
        Cell c;
        for (int i = 0; i < data.length; i++) {
            Row row = nextRow(i + offsetRows, sheet);
            if (data[i] instanceof RoastPart) {
                int j = offsetColumns;
                RoastPart rp = (RoastPart) data[i];
                nextCell(j++, row).setCellValue(rp.getSourceWeight());
                nextCell(j++, row).setCellValue(rp.getRoastedWeight());
                if (rp.isTemperature()) {
                    nextCell(j++, row).setCellValue("OK");
                } else {
                    nextCell(j++, row).setCellValue("NIE OK");
                }
                nextCell(j, row).setCellValue(rp.getColour());

                if (i == data.length - 1) {
                    Row rowAdd = nextRow(data.length + offsetRows, sheet);
                    int k = offsetColumns;
                    nextCell(k++, rowAdd).setCellValue(rp.getRoastRaport().getTotalSourceWeight());
                    nextCell(k++, rowAdd).setCellValue(rp.getRoastRaport().getTotalRoastWeight());
                }
            }
            if (data[i] instanceof RoastAromaPart) {
                int j = offsetColumns;
                RoastAromaPart rap = (RoastAromaPart) data[i];
                nextCell(j++, row).setCellValue(rap.getAroma().getAromaType().getType());
                nextCell(j++, row).setCellValue(rap.getQuantity());
            }
            if (data[i] instanceof HistoryData) {
                int j = offsetColumns;
                HistoryData hd = (HistoryData) data[i];
                nextCell(j++, row).setCellValue(hd.change);
                nextCell(j++, row).setCellValue(hd.reason);
                nextCell(j++, row).setCellValue(hd.who);
                nextCell(j++, row).setCellValue(hd.date);
                if (i == data.length - 1) {

                    Row rowAdd = nextRow(0, sheet);
                    int k = offsetColumns;
                    c = nextCell(k, rowAdd);
                    c.setCellType(CellType.STRING);
                    c.setCellValue("SUMA");

                    c = nextCell(k + 1, rowAdd);
                    c.setCellType(CellType.STRING);
                    c.setCellValue("Dostawy");

                    c = nextCell(k + 2, rowAdd);
                    c.setCellType(CellType.STRING);
                    c.setCellValue("Rozchód");

                    rowAdd = nextRow(1, sheet);

                    c = nextCell(k, rowAdd);
                    String columnLetter = CellReference.convertNumToColString(k);
                    c.setCellType(CellType.FORMULA);
                    String formula = "SUM(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + ")";
                    c.setCellFormula(formula);

                    String formula2 = "SUMIF(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + " ,\">0\") ";
                    c = nextCell(k + 1, rowAdd);
                    c.setCellType(CellType.FORMULA);
                    c.setCellFormula(formula2);

                    String formula3 = "SUMIF(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + " ,\"<0\") ";
                    c = nextCell(k + 2, rowAdd);
                    c.setCellType(CellType.FORMULA);
                    c.setCellFormula(formula3);

                }

            }

            if (data[i] instanceof RoastGreenCoffeePart) {
                int j = offsetColumns;
                RoastGreenCoffeePart rgcp = (RoastGreenCoffeePart) data[i];

                nextCell(j++, row).setCellValue(rgcp.getCoffeeGreen().getLabId() + " " + rgcp.getCoffeeGreen().getCoffeeType().toString());
                nextCell(j++, row).setCellValue(rgcp.getWeight());
            }

            if (data[i] instanceof ResourceData) {
                int j = offsetColumns;
                ResourceData rd = (ResourceData) data[i];

                nextCell(j++, row).setCellValue(rd.number);
                c = nextCell(j++, row);
                c.setCellValue(rd.name);
                Hyperlink linkHistory = rd.creationHelper.createHyperlink(HyperlinkType.DOCUMENT);
                linkHistory.setAddress("'" + rd.id + "'!A2");
                c.setHyperlink(linkHistory);

                c = nextCell(j++, row);
                c.setCellType(CellType.FORMULA);
                String formula = "'" + rd.id + "'!D2";
                c.setCellFormula(formula);

                c = nextCell(j++, row);
                c.setCellType(CellType.FORMULA);
                String formula2 = "'" + rd.id + "'!C2";
                c.setCellFormula(formula2);

                nextCell(j++, row).setCellValue(rd.weight);

            }
            if (data[i] instanceof ProductionData) {
                int j = offsetColumns;
                ProductionData pd = (ProductionData) data[i];
                nextCell(j++, row).setCellValue(pd.pt.getProductName());
                nextCell(j++, row).setCellValue(pd.seekKG);
                nextCell(j++, row).setCellValue(pd.producedKG);
                nextCell(j++, row).setCellValue(pd.producedPCS);

                if (i == data.length - 1) {
                    Row rowAdd = nextRow(data.length + offsetRows, sheet);
                    int k = offsetColumns + 1;
                    c = nextCell(k, rowAdd);
                    String columnLetter = CellReference.convertNumToColString(k);
                    c.setCellType(CellType.FORMULA);
                    String formula = "SUM(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + ")";
                    c.setCellFormula(formula);

                    k++;

                    c = nextCell(++k, rowAdd);
                    columnLetter = CellReference.convertNumToColString(k);
                    c.setCellType(CellType.FORMULA);
                    formula = "SUM(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + ")";
                    c.setCellFormula(formula);
                }
            }
            if (data[i] instanceof RoastData) {
                int j = offsetColumns;
                RoastData pd = (RoastData) data[i];
                nextCell(j++, row).setCellValue(Global.timestampToStrDDMMYYYY(pd.date));
                nextCell(j++, row).setCellValue(pd.waste);
                nextCell(j++, row).setCellValue(pd.seekKG);
                nextCell(j++, row).setCellValue(pd.roastKG);
                nextCell(j++, row).setCellValue(pd.pt.getProductName());
                if (i == data.length - 1) {
                    Row rowAdd = nextRow(data.length + offsetRows, sheet);
                    int k = offsetColumns + 1;
                    c = nextCell(k, rowAdd);
                    String columnLetter = CellReference.convertNumToColString(k);
                    c.setCellType(CellType.FORMULA);
                    String formula = "AVERAGE(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + ")";
                    c.setCellFormula(formula);

                    c = nextCell(++k, rowAdd);
                    columnLetter = CellReference.convertNumToColString(k);
                    c.setCellType(CellType.FORMULA);
                    formula = "SUM(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + ")";
                    c.setCellFormula(formula);

                    c = nextCell(++k, rowAdd);
                    columnLetter = CellReference.convertNumToColString(k);
                    c.setCellType(CellType.FORMULA);
                    formula = "SUM(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + ")";
                    c.setCellFormula(formula);
                }
            }
            if (data[i] instanceof MixData) {
                int j = offsetColumns;
                MixData md = (MixData) data[i];
                nextCell(j++, row).setCellValue(Global.timestampToStrDDMMYYYY(md.date));
                nextCell(j++, row).setCellValue(md.weight);
                nextCell(j++, row).setCellValue(md.pt.getProductName());
                if (i == data.length - 1) {
                    Row rowAdd = nextRow(data.length + offsetRows, sheet);
                    int k = offsetColumns + 1;
                    c = nextCell(k, rowAdd);
                    String columnLetter = CellReference.convertNumToColString(k);
                    c.setCellType(CellType.FORMULA);
                    String formula = "SUM(" + columnLetter + (offsetRows + 1) + ":" + columnLetter + "" + (offsetRows + data.length) + ")";
                    c.setCellFormula(formula);
                }
            }
        }
    }

    public static Date trimMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Date trimMonthDown(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 22);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();

    }

    public static Date addMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    public static void putReturnCell(XSSFSheet sheet, Hyperlink link) {

        Cell c;
        Row row = nextRow(0, sheet);
        c = nextCell(0, row);
        c.setCellValue("Powrót");
        c.setHyperlink(link);

    }
}
