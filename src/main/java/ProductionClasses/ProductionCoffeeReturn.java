/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionClasses;

import ProductionManagement.Employee;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class ProductionCoffeeReturn {

    int id;
    String info;
    ProductionCoffee productionCoffee;
    Employee returnedBy;
    Timestamp returnedTime;
    Float weight;

    public Timestamp getReturnedTime() {
        return returnedTime;
    }

    public void setReturnedTime(Timestamp returnedTime) {
        this.returnedTime = returnedTime;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public ProductionCoffeeReturn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ProductionCoffee getProductionCoffee() {
        return productionCoffee;
    }

    public void setProductionCoffee(ProductionCoffee productionCoffee) {
        this.productionCoffee = productionCoffee;
    }

    public Employee getReturnedBy() {
        return returnedBy;
    }

    public void setReturnedBy(Employee returnedBy) {
        this.returnedBy = returnedBy;
    }

}
