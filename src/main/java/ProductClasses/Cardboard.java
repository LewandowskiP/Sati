/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import Frames.Panels.DetailsAromaPanel;
import Frames.Panels.DetailsCardboardPanel;
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
public class Cardboard extends Test implements Details {

    private int id;
    private int quantity;
    private int arrivalQuantity;
    private Timestamp arrivalDate;
    private Employee storeman;

    private Provider provider;
    private CardboardType cardboardType;

    @Override
    public String toString() {
        return this.getLabId() + " " + cardboardType;
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

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
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

    public CardboardType getCardboardType() {
        return cardboardType;
    }

    public void setCardboardType(CardboardType cardboardType) {
        this.cardboardType = cardboardType;
    }

    public Cardboard() {
    }

     public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsCardboardPanel(this), "Podgląd kartonu.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

}
