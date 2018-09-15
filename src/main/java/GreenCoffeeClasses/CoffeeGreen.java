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
package GreenCoffeeClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Frames.Panels.DetailsGreenCoffeePanel;
import Frames.Panels.EditGreenCoffeePanel;
import ProductClasses.InstantCoffeeMixRaport;
import ProductClasses.RoastRaport;
import ProductionManagement.LabTest;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import SatiExtends.Test;
import SatiInterfaces.Details;
import SatiInterfaces.Editable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class CoffeeGreen extends Test implements Details, Editable {

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

    @Override
    public void showDetails() {

        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsGreenCoffeePanel(this), "Podgląd kawy zielonej.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    }

    @Override
    public void edit() {
        String[] option = {"Cofnij"};
        JOptionPane.showOptionDialog(null, new EditGreenCoffeePanel(this), "Zmień dane kawy.", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
    }

    public CoffeeGreen(CoffeeOwner coffeeOwner, String contractNumber, CoffeeType coffeeType, String dossierNumber, Float weight, Employee storeman, PackType packType, String labId, LabTest labTest, Provider provider, Integer numberOfPacks) {
        super(labTest, labId);
        this.packType = packType;
        this.numberOfPacks = numberOfPacks;
        this.contractNumber = contractNumber;
        this.storeman = storeman;
        this.dossierNumber = dossierNumber;
        this.coffeeOwner = coffeeOwner;
        this.coffeeType = coffeeType;
        this.provider = provider;
        this.coffeeGreenChangeHistory = new HashSet<>();
        this.arrivalDate = Global.time();
        this.arrivalWeight = weight;
        this.currentWeight = weight;
        addHistory(weight, "Dostawa - " + labId, storeman);
    }

    public void correction(float weight, Employee emp, String comment) {
        if ((currentWeight + weight) <= 0.0f) {
            this.setState(Test.OUT_OF_STORE);
        } else {
            currentWeight += weight;
            addHistory(weight, comment, emp);
        }
    }

    public boolean roast(Float weight, Employee mixedBy, RoastRaport rr) {
        if (currentWeight < weight) {
            return false;
        } else {
            currentWeight -= weight;
            addHistoryRoast(weight, mixedBy, rr);
            if (currentWeight <= 0.5) {
                this.setState(Test.OUT_OF_STORE);
                currentWeight = 0f;
            }
        }
        return true;
    }

    public boolean mix(Float weight, Employee mixedBy, InstantCoffeeMixRaport icmr) {
        if (currentWeight < weight) {
            return false;
        } else {
            currentWeight -= weight;
            addHistoryMix(weight, mixedBy, icmr);
            if (currentWeight <= 0.5) {
                this.setState(Test.OUT_OF_STORE);
                currentWeight = 0f;
            }
        }
        return true;
    }

    private void addHistoryRoast(Float weight, Employee changedBy, RoastRaport roastRaport) {
        String comment = this.getLabId() + " PALENIE " + roastRaport.getProductType();
        this.coffeeGreenChangeHistory.add(new CoffeeGreenChangeHistory(-1 * weight, this.currentWeight, this, comment, changedBy, roastRaport));
    }

    private void addHistoryMix(Float weight, Employee changedBy, InstantCoffeeMixRaport icmr) {
        String comment = this.getLabId() + " ZASYP " + icmr.getProductType();
        this.coffeeGreenChangeHistory.add(new CoffeeGreenChangeHistory(-1 * weight, this.currentWeight, this, comment, changedBy, icmr));
    }

    private void addHistory(Float weight, String tempComment, Employee changedBy) {
        String comment = this.getLabId() + " " + tempComment;
        this.coffeeGreenChangeHistory.add(new CoffeeGreenChangeHistory(weight, this.currentWeight, this, comment, changedBy));
    }

}
