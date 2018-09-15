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
package ProductClasses;

import GreenCoffeeClasses.*;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class AromaChangeHistory implements Comparable {

    int id;
    Float weight;
    Float weightAfterChange;
    Aroma aroma;
    String comment;
    Timestamp changeTime;
    Employee changedBy;
    RoastRaport roastRaport;

    public RoastRaport getRoastRaport() {
        return roastRaport;
    }

    public void setRoastRaport(RoastRaport roastRaport) {
        this.roastRaport = roastRaport;
    }

    public Employee getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(Employee changedBy) {
        this.changedBy = changedBy;
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

    public Aroma getAroma() {
        return aroma;
    }

    public void setAroma(Aroma aroma) {
        this.aroma = aroma;
    }

    public Timestamp getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Timestamp changeTime) {
        this.changeTime = changeTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getWeightAfterChange() {
        return weightAfterChange;
    }

    public void setWeightAfterChange(Float weightAfterChange) {
        this.weightAfterChange = weightAfterChange;
    }

    public AromaChangeHistory() {
    }

    public AromaChangeHistory(Float weight, Float weightAfterChange, Aroma aroma, String comment, Employee changedBy, RoastRaport roastRaport) {
        this.weight = weight;
        this.weightAfterChange = weightAfterChange;
        this.aroma = aroma;
        this.comment = comment;
        this.changeTime = Global.time();
        this.changedBy = changedBy;
        this.roastRaport = roastRaport;
    }

    public AromaChangeHistory(Float weight, Float weightAfterChange, Aroma aroma, String comment, Employee changedBy) {
        this.weight = weight;
        this.weightAfterChange = weightAfterChange;
        this.aroma = aroma;
        this.comment = comment;
        this.changedBy = changedBy;
        this.changeTime = Global.time();
    }

    public int compareTo(Object o) {
        return (this.getChangeTime().before(((AromaChangeHistory) o).getChangeTime())) ? 1 : -1;
    }
}
