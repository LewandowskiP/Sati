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

import Frames.Panels.DetailsProductionRaportPartPanel;
import ProductClasses.ProductType;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class ProductionRaportPart implements Details {

    private int id;
    private String batchInfo = "";

    private int shift;
    private int type;
    private int totalPallete;
    private float totalWeight;
    private int totalPcs;
    private float stickSize;

    private float oxygen;
    private boolean sealing;

    private String otherInfo;
    private Timestamp raportDate;
    private Timestamp expiryDate;

    private Timestamp labTestDate;
    private int labTestState;

    private ProductType productType;
    private ProductionLine productionLine;
    private Employee emp;

    private Set<ProductionRaportCoffeeAssignment> productionRaportCoffeeAssignment = new HashSet<ProductionRaportCoffeeAssignment>();
    private Set<ProductionRaportDirectPackage> productionRaportDirectPackage = new HashSet<ProductionRaportDirectPackage>();
    private Set<Pallete> pallete = new HashSet<Pallete>();

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Set<Pallete> getPallete() {
        return pallete;
    }

    public void setPallete(Set<Pallete> pallete) {
        this.pallete = pallete;
    }

    public Set<ProductionRaportDirectPackage> getProductionRaportDirectPackage() {
        return productionRaportDirectPackage;
    }

    public void setProductionRaportDirectPackage(Set<ProductionRaportDirectPackage> productionRaportDirectPackage) {
        this.productionRaportDirectPackage = productionRaportDirectPackage;
    }

    public int getLabTestState() {
        return labTestState;
    }

    public void setLabTestState(int labTestState) {
        this.labTestState = labTestState;
    }

    public ProductionRaportPart() {
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTotalPallete() {
        return totalPallete;
    }

    public void setTotalPallete(int totalPallete) {
        this.totalPallete = totalPallete;
    }

    public float getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(float totalWeight) {
        this.totalWeight = totalWeight;
    }

    public int getTotalPcs() {
        return totalPcs;
    }

    public void setTotalPcs(int totalPcs) {
        this.totalPcs = totalPcs;
    }

    public float getStickSize() {
        return stickSize;
    }

    public void setStickSize(float stickSize) {
        this.stickSize = stickSize;
    }

    public float getOxygen() {
        return oxygen;
    }

    public void setOxygen(float oxygen) {
        this.oxygen = oxygen;
    }

    public boolean isSealing() {
        return sealing;
    }

    public void setSealing(boolean sealing) {
        this.sealing = sealing;
    }

    public String getBatchInfo() {
        return batchInfo;
    }

    public void setBatchInfo(String batchInfo) {
        this.batchInfo = batchInfo;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Timestamp getLabTestDate() {
        return labTestDate;
    }

    public void setLabTestDate(Timestamp labTestDate) {
        this.labTestDate = labTestDate;
    }

    public int getShift() {
        return shift;
    }

    public void setShift(int shift) {
        this.shift = shift;
    }

    public Employee getEmp() {
        return emp;
    }

    public void setEmp(Employee emp) {
        this.emp = emp;
    }

    public Timestamp getRaportDate() {
        return raportDate;
    }

    public void setRaportDate(Timestamp raportDate) {
        this.raportDate = raportDate;
    }

    public ProductionLine getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(ProductionLine productionLine) {
        this.productionLine = productionLine;
    }

    public Set<ProductionRaportCoffeeAssignment> getProductionRaportCoffeeAssignment() {
        return productionRaportCoffeeAssignment;
    }

    public void setProductionRaportCoffeeAssignment(Set<ProductionRaportCoffeeAssignment> productionRaportCoffeeAssignment) {
        this.productionRaportCoffeeAssignment = productionRaportCoffeeAssignment;
    }

    @Override
    public String toString() {

        return batchInfo + " " + productType + " " + productionLine + " " + totalWeight + " Kg " + Global.timestampToStrDDMMYYYY(raportDate);

    }

    @Override
    public void showDetails() {
        DataBaseConnector dbc = Global.getDataBaseConnector();
        dbc.openSession();
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsProductionRaportPartPanel(this), "Podgląd raportu.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductionRaportPart other = (ProductionRaportPart) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    private void rollbackCoffee(ProductionRaportCoffeeAssignment prca, ArrayList<ProductionCoffeeSeek> alpcs) {
        for (ProductionCoffeeSeek pcs : alpcs) {
            if (pcs.getProductionCoffee() == prca.getProductionCoffee()) {
                pcs.setWeight(pcs.getWeight() + prca.getWeight());
            }
        }
    }

    public void returnAssignedCoffee(Employee emp) {
        DataBaseConnector dbc = Global.getDataBaseConnector();
        productionRaportCoffeeAssignment.toArray();
        ArrayList<ProductionCoffeeSeek> alpcs = dbc.getProductionCoffeeSeekWithEmployee(emp);
        for (Object prca : productionRaportCoffeeAssignment.toArray()) {
            rollbackCoffee((ProductionRaportCoffeeAssignment) prca, alpcs);
        }

    }

}
