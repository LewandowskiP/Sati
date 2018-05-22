/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import java.awt.Desktop;
import java.io.File;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class ProductType implements Comparable {

    private int id;
    private int type;
    private String productName;
    private String fileURL;
    private String fileURLinstant;
    private Timestamp createDate;
    private String ean;
    private boolean hidden;
    int version;
    private boolean instant;

    public void openFile(boolean mode) {
        try {
            File f = new File(fileURL);
            f.setWritable(mode);
            Desktop dt = Desktop.getDesktop();
            dt.open(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void openFileInstant(boolean mode) {
        try {
            File f = new File(fileURLinstant);
            f.setWritable(mode);
            Desktop dt = Desktop.getDesktop();
            dt.open(f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isHidden() {
        return hidden;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFileURLinstant() {
        return fileURLinstant;
    }

    public void setFileURLinstant(String fileURLinstant) {
        this.fileURLinstant = fileURLinstant;
    }

    public boolean isInstant() {
        return instant;
    }

    public void setInstant(boolean instant) {
        this.instant = instant;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public ProductType() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return productName;
    }

    public int compareTo(Object o) {
        return this.getProductName().compareToIgnoreCase(o.toString());
    }
}
