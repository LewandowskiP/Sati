/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenCoffeeClasses;

import ProductClasses.InstantCoffeeMixRaport;
import ProductClasses.RoastRaport;
import ProductionManagement.Employee;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class CoffeeGreenChangeHistory implements Comparable {

    int id;
    Float weight;
    CoffeeGreen coffeeGreen;
    String comment;
    Timestamp changeTime;
    Employee changedBy;
    RoastRaport roastRaport;
    InstantCoffeeMixRaport instantCoffeeMixRaport;

    public Employee getChangedBy() {
        return changedBy;
    }

    public RoastRaport getRoastRaport() {
        return roastRaport;
    }

    public void setRoastRaport(RoastRaport roastRaport) {
        this.roastRaport = roastRaport;
    }

    public InstantCoffeeMixRaport getInstantCoffeeMixRaport() {
        return instantCoffeeMixRaport;
    }

    public void setInstantCoffeeMixRaport(InstantCoffeeMixRaport instantCoffeeMixRaport) {
        this.instantCoffeeMixRaport = instantCoffeeMixRaport;
    }

    public void setChangedBy(Employee changedBy) {
        this.changedBy = changedBy;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public CoffeeGreen getCoffeeGreen() {
        return coffeeGreen;
    }

    public void setCoffeeGreen(CoffeeGreen coffeeGreen) {
        this.coffeeGreen = coffeeGreen;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CoffeeGreenChangeHistory() {
    }

    public int compareTo(Object o) {

        int ret = (int) (this.getChangeTime().compareTo(((CoffeeGreenChangeHistory) o).getChangeTime()));
        return ret;
    }

}
