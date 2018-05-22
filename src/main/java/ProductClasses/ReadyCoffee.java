/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import Frames.Panels.DetailsReadyCoffeePanel;
import GreenCoffeeClasses.Provider;

import ProductionManagement.Employee;
import SatiExtends.Test;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class ReadyCoffee extends Test implements Details {

    private int id;

    private int arrivalQuantity;

    private float arrivalWeight;

    private Timestamp arrivalDate;
    private Timestamp expiryDate;
    private ProductType productType;
    private Employee storeman;
    private Provider provider;
    private String otherInfo;

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrivalQuantity() {
        return arrivalQuantity;
    }

    public void setArrivalQuantity(int arrivalQuantity) {
        this.arrivalQuantity = arrivalQuantity;
    }

    public float getArrivalWeight() {
        return arrivalWeight;
    }

    public void setArrivalWeight(float arrivalWeight) {
        this.arrivalWeight = arrivalWeight;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Timestamp getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Timestamp expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Employee getStoreman() {
        return storeman;
    }

    public void setStoreman(Employee storeman) {
        this.storeman = storeman;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public String toString() {
        return this.getLabId() + "  " + productType;
    }

    public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsReadyCoffeePanel(this), "Podgląd gotowego produktu.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

}
