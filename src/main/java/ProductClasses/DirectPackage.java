/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import Frames.Panels.DetailsAromaPanel;
import Frames.Panels.DetailsDirectPackagePanel;
import GreenCoffeeClasses.Provider;
import ProductionManagement.Employee;
import ProductionManagement.LabTest;
import SatiExtends.Test;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class DirectPackage extends Test implements Details {

    private int id;
    private int quantity;
    private int arrivalQuantity;
    private float weight;
    private float arrivalWeight;

    private Timestamp arrivalDate;
    private DirectPackageType directPackageType;
    private Employee storeman;

    private Provider provider;

    public DirectPackage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getArrivalQuantity() {
        return arrivalQuantity;
    }

    public void setArrivalQuantity(int arrivalQuantity) {
        this.arrivalQuantity = arrivalQuantity;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
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

    public DirectPackageType getDirectPackageType() {
        return directPackageType;
    }

    public void setDirectPackageType(DirectPackageType directPackageType) {
        this.directPackageType = directPackageType;
    }

    public Employee getStoreman() {
        return storeman;
    }

    public void setStoreman(Employee storeman) {
        this.storeman = storeman;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return this.getLabId() + "  " + directPackageType;
    }

      public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsDirectPackagePanel(this), "Podgląd opakowania bezpośredniego.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

}
