/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionRaportPart;
import SatiInterfaces.Details;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class ReturnedProduct implements Details {

    int id;
    ProductionRaportPart productionRaportPart;
    ProductionCoffee productionCoffee;

    public ReturnedProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductionRaportPart getProductionRaportPart() {
        return productionRaportPart;
    }

    public void setProductionRaportPart(ProductionRaportPart productionRaportPart) {
        this.productionRaportPart = productionRaportPart;
    }

    public ProductionCoffee getProductionCoffee() {
        return productionCoffee;
    }

    public void setProductionCoffee(ProductionCoffee productionCoffee) {
        this.productionCoffee = productionCoffee;
    }

    public void showDetails() {
        productionRaportPart.showDetails();
    }

}
