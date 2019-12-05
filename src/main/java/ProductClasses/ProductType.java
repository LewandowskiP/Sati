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
package ProductClasses;

import java.awt.Desktop;
import java.io.File;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

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
            JOptionPane.showMessageDialog(null, e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void openFileInstant(boolean mode) {
        try {
            File f = new File(fileURLinstant);
            f.setWritable(mode);
            Desktop dt = Desktop.getDesktop();
            dt.open(f);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
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
