/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import GreenCoffeeClasses.CoffeeGreen;

/**
 *
 * @author Przemysław
 */
public class RoastGreenCoffeePart implements Comparable {

    private int id;
    private CoffeeGreen coffeeGreen;
    private float weight;
    private RoastRaport roastRaport;

    public RoastGreenCoffeePart(int id, CoffeeGreen coffeeGreen, float weight) {
        this.id = id;
        this.coffeeGreen = coffeeGreen;
        this.weight = weight;
    }

    public RoastGreenCoffeePart() {
    }

    @Override
    public String toString() {
        return coffeeGreen + " : " + weight + " Kg";
    }

    public RoastRaport getRoastRaport() {
        return roastRaport;
    }

    public void setRoastRaport(RoastRaport roastRaport) {
        this.roastRaport = roastRaport;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int compareTo(Object o) {
        return this.getCoffeeGreen().getCoffeeType().getId() - ((RoastGreenCoffeePart) o).getCoffeeGreen().getCoffeeType().getId();
    }

    public void showDetails() {
        coffeeGreen.showDetails();
    }

}
