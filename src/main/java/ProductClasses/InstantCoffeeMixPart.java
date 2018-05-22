/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import GreenCoffeeClasses.CoffeeGreen;
import GreenCoffeeClasses.CoffeeType;

/**
 *
 * @author Przemysław
 */
public class InstantCoffeeMixPart implements Comparable {

    int id;

    CoffeeGreen coffeeGreen;
    int cardBoardNumber;
    String serialNumber;
    boolean sealOk;

    float weight;

    InstantCoffeeMixRaport instantCoffeeMixRaport;

    public boolean isSealOk() {
        return sealOk;
    }

    public void setSealOk(boolean sealOk) {
        this.sealOk = sealOk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoffeeGreen getCoffeeGreen() {
        return coffeeGreen;
    }

    public void setCoffeeGreen(CoffeeGreen coffeeGreen) {
        this.coffeeGreen = coffeeGreen;
    }

    public int getCardBoardNumber() {
        return cardBoardNumber;
    }

    public void setCardBoardNumber(int cardBoardNumber) {
        this.cardBoardNumber = cardBoardNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public InstantCoffeeMixRaport getInstantCoffeeMixRaport() {
        return instantCoffeeMixRaport;
    }

    public void setInstantCoffeeMixRaport(InstantCoffeeMixRaport instantCoffeeMixRaport) {
        this.instantCoffeeMixRaport = instantCoffeeMixRaport;
    }

    @Override
    public String toString() {
        return coffeeGreen + " : " + weight + " Kg";
    }

    public void showDetails() {
        coffeeGreen.showDetails();
    }

    public int compareTo(Object o) {
        return this.getCoffeeGreen().getCoffeeType().getId() - ((InstantCoffeeMixPart) o).getCoffeeGreen().getCoffeeType().getId();
    }

}
