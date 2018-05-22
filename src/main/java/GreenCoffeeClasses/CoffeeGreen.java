package GreenCoffeeClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Frames.Panels.DetailsGreenCoffeePanel;
import ProductionManagement.DataBaseConnector;
import ProductionManagement.LabTest;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import SatiExtends.Test;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class CoffeeGreen extends Test implements Details {

    private int id;
    private Timestamp arrivalDate;
    private PackType packType;
    private int numberOfPacks;
    private Float currentWeight;
    private Float arrivalWeight;
    private String contractNumber;
    private Employee storeman;

    private String dossierNumber;

    private CoffeeOwner coffeeOwner;
    private CoffeeType coffeeType;
    private Provider provider;

    Set<CoffeeGreenChangeHistory> coffeeGreenChangeHistory;

    public Set<CoffeeGreenChangeHistory> getCoffeeGreenChangeHistory() {
        return coffeeGreenChangeHistory;
    }

    public void setCoffeeGreenChangeHistory(Set<CoffeeGreenChangeHistory> coffeeGreenChangeHistory) {
        this.coffeeGreenChangeHistory = coffeeGreenChangeHistory;
    }

    public Float getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Float currentWeight) {
        this.currentWeight = currentWeight;
    }

    public Float getArrivalWeight() {
        return arrivalWeight;
    }

    public void setArrivalWeight(Float arrivalWeight) {
        this.arrivalWeight = arrivalWeight;
    }

    public CoffeeGreen() {
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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

    public PackType getPackType() {
        return packType;
    }

    public void setPackType(PackType packType) {
        this.packType = packType;
    }

    public int getNumberOfPacks() {
        return numberOfPacks;
    }

    public void setNumberOfPacks(int numberOfPacks) {
        this.numberOfPacks = numberOfPacks;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Employee getStoreman() {
        return storeman;
    }

    public void setStoreman(Employee storeman) {
        this.storeman = storeman;
    }

    public String getDossierNumber() {
        return dossierNumber;
    }

    public void setDossierNumber(String dossierNumber) {
        this.dossierNumber = dossierNumber;
    }

    public CoffeeOwner getCoffeeOwner() {
        return coffeeOwner;
    }

    public void setCoffeeOwner(CoffeeOwner coffeeOwner) {
        this.coffeeOwner = coffeeOwner;
    }

    public CoffeeType getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    @Override
    public String toString() {
        return this.getLabId() + " " + coffeeType;
    }

    public void showDetails() {

        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsGreenCoffeePanel(this), "Podgląd kawy zielonej.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    }

   

}
