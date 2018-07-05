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
package ProductionClasses;

import Frames.Panels.DetailsPalletePanel;
import Frames.Panels.GenerateLabelEan128;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Global;
import SatiInterfaces.Details;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import org.krysalis.barcode4j.impl.code128.EAN128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 *
 * @author Przemysław
 */
public class Pallete implements Details {

    private int id;
    private Timestamp expiryDate;
    private Timestamp prodDate;
    private Float netto;
    private int quantity;
    private String batch;
    private int state;
    private ProductionRaportPart productionRaportPart;

    private String ean128Lot;
    private String ean128Pallete;
    private String ean128Num;

    public ProductionRaportPart getProductionRaportPart() {
        return productionRaportPart;
    }

    public void setProductionRaportPart(ProductionRaportPart productionRaportPart) {
        this.productionRaportPart = productionRaportPart;
    }

    public Pallete() {
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEan128Num() {
        return ean128Num;
    }

    public void setEan128Num(String ean128Num) {
        this.ean128Num = ean128Num;
    }

    public String getEan128Lot() {
        return ean128Lot;
    }

    public void setEan128Lot(String ean128Lot) {
        this.ean128Lot = ean128Lot;
    }

    public String getEan128Pallete() {
        return ean128Pallete;
    }

    public void setEan128Pallete(String ean128Pallete) {
        this.ean128Pallete = ean128Pallete;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Timestamp getProdDate() {
        return prodDate;
    }

    public void setProdDate(Timestamp prodDate) {
        this.prodDate = prodDate;
    }

    public Float getNetto() {
        return netto;
    }

    public void setNetto(Float netto) {
        this.netto = netto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public void showDetails() {
        DataBaseConnector dbc = Global.getDataBaseConnector();
        dbc.openSession();
        String[] options = new String[]{"Zamknij", "Drukuj"};
        int result = JOptionPane.showOptionDialog(null, new DetailsPalletePanel(this), "Podgląd etykiety.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (result == 1) {
            try {
                this.printLabel();
            } catch (IOException ex) {
                Logger.getLogger(Pallete.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void buildLabel(Graphics2D g) throws IOException {

        Font font = new Font("Arial", Font.PLAIN, Global.labelFontSize);
        g.setFont(font);
        g.setBackground(Color.white);
        g.setColor(Color.black);

        BufferedImage imageLot = generateEan(this.getEan128Lot(), Global.ean128TemplateLot);
        BufferedImage imagePallete = generateEan(this.getEan128Pallete(), Global.ean128TemplatePallete);
        BufferedImage imageNum = generateEan(this.getEan128Num(), Global.ean128TemplateNum);

        int xOffset = Global.labelOffset;
        int yOffset = 0;

        yOffset += Global.labelOffset;
        g.drawImage(imageLot.getScaledInstance(imageLot.getWidth(), imageLot.getHeight(), 0), xOffset, yOffset, null);

        yOffset += Global.labelOffset + imageLot.getHeight();

        xOffset += Global.labelOffset;
        String ean13FullText = Global.qtinText + this.productionRaportPart.getProductType().getEan();
        g.drawChars(ean13FullText.toCharArray(), 0, ean13FullText.length(), xOffset, yOffset);

        yOffset += Global.labelOffset;
        String lotFullText = Global.lotText + this.getBatch();
        g.drawChars(lotFullText.toCharArray(), 0, lotFullText.length(), xOffset, yOffset);

        yOffset += Global.labelOffset;
        String expiryDateFullText = Global.expiryDateText + Global.timestampToStrDDMMYYYY(this.getExpiryDate());
        g.drawChars(expiryDateFullText.toCharArray(), 0, expiryDateFullText.length(), xOffset, yOffset);

        yOffset += Global.labelOffset;
        String productTypeFullText = Global.productNameText + this.productionRaportPart.getProductType().getProductName();
        g.drawChars(productTypeFullText.toCharArray(), 0, productTypeFullText.length(), xOffset, yOffset);

        xOffset = Global.labelOffset;
        yOffset += Global.labelOffset;
        g.drawImage(imagePallete.getScaledInstance(imagePallete.getWidth(), imagePallete.getHeight(), 0), xOffset, yOffset, null);

        xOffset += Global.labelOffset;
        yOffset += Global.labelOffset + imagePallete.getHeight();
        String prodDateFullText = Global.prodDateText + Global.timestampToStrDDMMYYYY(this.getProdDate());
        g.drawChars(prodDateFullText.toCharArray(), 0, prodDateFullText.length(), xOffset, yOffset);

        yOffset += Global.labelOffset;
        String quantityFullText = Global.quantityText + this.getQuantity();
        g.drawChars(quantityFullText.toCharArray(), 0, quantityFullText.length(), xOffset, yOffset);

        yOffset += Global.labelOffset;
        String nettoFullText = Global.nettoText + this.getNetto();
        g.drawChars(nettoFullText.toCharArray(), 0, nettoFullText.length(), xOffset, yOffset);

        xOffset = Global.labelOffset;
        yOffset += Global.labelOffset;
        g.drawImage(imageNum.getScaledInstance(imageNum.getWidth(), imageNum.getHeight(), 0), xOffset, yOffset, null);

        xOffset += 300;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("logo.jpg");
        BufferedImage logo = ImageIO.read(is);
        g.drawImage(logo.getScaledInstance(382, 90, 0), xOffset, yOffset, null);
        xOffset -= 300;

        xOffset += Global.labelOffset;
        yOffset += imageNum.getHeight() + Global.labelOffset;
        String palleteNumberFullText = Global.palleteNumberText + this.getId();
        g.drawChars(palleteNumberFullText.toCharArray(), 0, palleteNumberFullText.length(), xOffset, yOffset);
        yOffset += Global.labelOffset;
        String employeeCodeFullText = Global.employeeCodeText + this.productionRaportPart.getEmp().getEmployeeID();
        g.drawChars(employeeCodeFullText.toCharArray(), 0, employeeCodeFullText.length(), xOffset, yOffset);
    }

    private BufferedImage generateEan(String eanContent, String eanTeamplate) throws IOException {
        EAN128Bean bean = new EAN128Bean();
        bean.setTemplate(eanTeamplate);
        bean.setGroupSeparator(Global.eanSeparator);
        bean.setFontSize(2);
        BitmapCanvasProvider canvas = new BitmapCanvasProvider(null, "image/x-png", Global.labelEanDpi, BufferedImage.TYPE_BYTE_BINARY, false, 0);
        bean.generateBarcode(canvas, eanContent);
        canvas.finish();
        return canvas.getBufferedImage();
    }

    public void printLabel() throws IOException {
        final BufferedImage output = new BufferedImage((int) Global.a4CanvasSizeWidth, (int) Global.a4CanvasSizeHeight, BufferedImage.TYPE_INT_RGB);

        Graphics2D g = output.createGraphics();

        g.setColor(Color.white);
        g.fillRect(0, 0, output.getWidth(), output.getHeight());
        this.buildLabel(g);
        g.copyArea(0, 0, output.getWidth() / 2, output.getHeight(), output.getWidth() / 2, 0);
        g.dispose();

        PrinterJob printJob = PrinterJob.getPrinterJob();

        printJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                pageFormat.setOrientation(PageFormat.LANDSCAPE);
                if (pageIndex != 0) {
                    return NO_SUCH_PAGE;
                }

                graphics.drawImage((Image) output, 0, 0, (int) Global.a4xDimPixels, (int) Global.a4yDimPixels, null);
                return PAGE_EXISTS;
            }
        });

        try {
            PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
            aset.add(OrientationRequested.LANDSCAPE);
            aset.add(new MediaPrintableArea(Global.a4PrintOffset, Global.a4PrintOffset, Global.a4yDimInches - Global.a4PrintOffset, Global.a4xDimInches - Global.a4PrintOffset, MediaPrintableArea.INCH));

            printJob.print(aset);

        } catch (PrinterException ex) {
            Logger.getLogger(GenerateLabelEan128.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return this.id + " " + this.getBatch();
    }

}
