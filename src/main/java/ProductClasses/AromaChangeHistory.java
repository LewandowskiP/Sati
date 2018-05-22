/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import GreenCoffeeClasses.*;
import ProductionManagement.Employee;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class AromaChangeHistory implements Comparable {

    int id;
    Float weight;
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

    public AromaChangeHistory() {
    }

    public int compareTo(Object o) {
        int ret = (int) (this.getChangeTime().compareTo(((AromaChangeHistory) o).getChangeTime()));
        return ret;
    }
}
