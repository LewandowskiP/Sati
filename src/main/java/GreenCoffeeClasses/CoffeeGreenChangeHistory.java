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
