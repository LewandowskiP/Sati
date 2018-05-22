/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionClasses;

import Frames.Panels.DetailsGreenCoffeePanel;
import Frames.Panels.DetailsProductionCoffeeExternalReturnPanel;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import ProductionManagement.LabTest;
import SatiExtends.Test;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class ProductionCoffeeExternalReturn extends Test implements Details {

    int id;
    ProductionRaportPart productionRaportPart;
    String returnInfo;
    Timestamp returnDate;
    Employee storemanId;

    Float weight;
    ProductionCoffee productionCoffee;

    public ProductionCoffee getProductionCoffee() {
        return productionCoffee;
    }

    public void setProductionCoffee(ProductionCoffee productionCoffee) {
        this.productionCoffee = productionCoffee;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public ProductionRaportPart getProductionRaportPart() {
        return productionRaportPart;
    }

    public void setProductionRaportPart(ProductionRaportPart productionRaportPart) {
        this.productionRaportPart = productionRaportPart;
    }

    public ProductionCoffeeExternalReturn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo;
    }

    public Timestamp getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Timestamp returnDate) {
        this.returnDate = returnDate;
    }

    public Employee getStoremanId() {
        return storemanId;
    }

    public void setStoremanId(Employee storemanId) {
        this.storemanId = storemanId;
    }

    @Override
    public String toString() {
        return this.getLabId() + " " + productionRaportPart.getProductType();
    }

    public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsProductionCoffeeExternalReturnPanel(this), "Podgląd kawy zielonej.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    }

}
