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

import ProductClasses.AromaChangeHistory;
import ProductClasses.InstantCoffeeMixRaport;
import ProductClasses.RoastRaport;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class CoffeeGreenChangeHistory implements Comparable {

    int id;
    Float weight;
    Float weightAfterChange;
    CoffeeGreen coffeeGreen;
    String comment;
    Timestamp changeTime;
    Employee changedBy;
    RoastRaport roastRaport;
    InstantCoffeeMixRaport instantCoffeeMixRaport;

    public Float getWeightAfterChange() {
        return weightAfterChange;
    }

    public void setWeightAfterChange(Float weightAfterChange) {
        this.weightAfterChange = weightAfterChange;
    }

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

    public CoffeeGreenChangeHistory(Float weight, Float weightAfterChange, CoffeeGreen coffeeGreen, String comment, Employee changedBy, RoastRaport roastRaport) {
        this.weight = weight;
        this.weightAfterChange = weightAfterChange;
        this.coffeeGreen = coffeeGreen;
        this.comment = comment;
        this.changedBy = changedBy;
        this.roastRaport = roastRaport;
        this.changeTime = Global.time();
    }

    public CoffeeGreenChangeHistory(Float weight, Float weightAfterChange, CoffeeGreen coffeeGreen, String comment, Employee changedBy, InstantCoffeeMixRaport instantCoffeeMixRaport) {
        this.weight = weight;
        this.weightAfterChange = weightAfterChange;
        this.coffeeGreen = coffeeGreen;
        this.comment = comment;
        this.changedBy = changedBy;
        this.instantCoffeeMixRaport = instantCoffeeMixRaport;
        this.changeTime = Global.time();
    }

    public CoffeeGreenChangeHistory(Float weight, Float weightAfterChange, CoffeeGreen coffeeGreen, String comment, Employee changedBy) {
        this.weight = weight;
        this.weightAfterChange = weightAfterChange;
        this.coffeeGreen = coffeeGreen;
        this.comment = comment;
        this.changedBy = changedBy;
        this.changeTime = Global.time();
    }

    public int compareTo(Object o) {
        return (this.getChangeTime().before(((CoffeeGreenChangeHistory) o).getChangeTime())) ? 1 : -1;
    }

}
