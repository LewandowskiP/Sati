/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import Frames.Panels.DetailsAromaPanel;
import Frames.Panels.EditAromaPanel;
import Frames.Panels.EditGreenCoffeePanel;

import GreenCoffeeClasses.Provider;
import ProductionManagement.Employee;

import SatiExtends.Test;
import SatiInterfaces.Details;
import SatiInterfaces.Editable;
import java.sql.Timestamp;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class Aroma extends Test implements Details, Editable {

    private int id;
    private float quantity;
    private float arrivalQuantity;

    private Timestamp arrivalDate;
    private Employee storeman;

    private Provider provider;
    private AromaType aromaType;

    Set<AromaChangeHistory> aromaChangeHistory;

    public float getArrivalQuantity() {
        return arrivalQuantity;
    }

    public void setArrivalQuantity(float arrivalQuantity) {
        this.arrivalQuantity = arrivalQuantity;
    }

    public Set<AromaChangeHistory> getAromaChangeHistory() {
        return aromaChangeHistory;
    }

    public void setAromaChangeHistory(Set<AromaChangeHistory> aromaChangeHistory) {
        this.aromaChangeHistory = aromaChangeHistory;
    }

    public Employee getStoreman() {
        return storeman;
    }

    public void setStoreman(Employee storeman) {
        this.storeman = storeman;
    }

    public Aroma() {
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public AromaType getAromaType() {
        return aromaType;
    }

    public void setAromaType(AromaType aromaType) {
        this.aromaType = aromaType;
    }

    @Override
    public String toString() {
        return this.getLabId() + " " + aromaType;
    }

    @Override
    public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsAromaPanel(this), "Podgląd aromatu.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    @Override
    public void edit() {
        String[] option = {"Cofnij"};
        int result = JOptionPane.showOptionDialog(null, new EditAromaPanel(this), "Zmień dane kawy.", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
    }

}
