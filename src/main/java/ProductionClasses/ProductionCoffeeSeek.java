/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionClasses;

import ProductionManagement.Employee;

/**
 *
 * @author Przemysław
 */
public class ProductionCoffeeSeek {

    int id;
    ProductionCoffee productionCoffee;
    float weight;
    Employee seekedBy;
    



    public ProductionCoffeeSeek() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductionCoffee getProductionCoffee() {
        return productionCoffee;
    }

    public void setProductionCoffee(ProductionCoffee productionCoffee) {
        this.productionCoffee = productionCoffee;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Employee getSeekedBy() {
        return seekedBy;
    }

    public void setSeekedBy(Employee seekedBy) {
        this.seekedBy = seekedBy;
    }

    @Override
    public String toString() {
        return productionCoffee.getProductType().toString();
    }

}
