/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import Frames.Panels.DetailsAromaPanel;
import Frames.Panels.DetailsSugarPanel;
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
public class Sugar extends Test implements Details {

    private int id;
    private int quantity;
    private int arrivalQuantity;
    private Timestamp arrivalDate;
    private Timestamp expiryDate;
    private Employee storeman;

    private Provider provider;
    private SugarType sugarType;

    @Override
    public String toString() {
        return this.getLabId() + " " + sugarType;
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

    public Sugar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public SugarType getSugarType() {
        return sugarType;
    }

    public void setSugarType(SugarType sugarType) {
        this.sugarType = sugarType;
    }

    public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsSugarPanel(this), "Podgląd cukru.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

}
