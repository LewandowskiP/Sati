/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionClasses;

/**
 *
 * @author Przemysław
 */
public class ProductionRaportCoffeeAssignment {

    private int id;
    private float weight;
    private ProductionCoffee productionCoffee;
    private ProductionRaportPart productionRaportPart;
    private boolean used;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString() {
        if (!used) {
            return productionCoffee.getProductType() + " : " + weight + "Kg";
        } else {
            return "PP " + productionCoffee.getProductType() + " : " + weight + "Kg";
        }

    }

    public ProductionRaportCoffeeAssignment() {
    }

    public ProductionRaportPart getProductionRaportPart() {
        return productionRaportPart;
    }

    public void setProductionRaportPart(ProductionRaportPart productionRaportPart) {
        this.productionRaportPart = productionRaportPart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ProductionCoffee getProductionCoffee() {
        return productionCoffee;
    }

    public void setProductionCoffee(ProductionCoffee productionCoffee) {
        this.productionCoffee = productionCoffee;
    }

}
