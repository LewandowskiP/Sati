/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionClasses;

import ProductClasses.DirectPackage;

/**
 *
 * @author Przemysław
 */
public class ProductionRaportDirectPackage {

    int id;
    DirectPackage directPackage;
    ProductionRaportPart productionRaportPart;

    public ProductionRaportDirectPackage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DirectPackage getDirectPackage() {
        return directPackage;
    }

    public void setDirectPackage(DirectPackage directPackage) {
        this.directPackage = directPackage;
    }

    public ProductionRaportPart getProductionRaportPart() {
        return productionRaportPart;
    }

    public void setProductionRaportPart(ProductionRaportPart productionRaportPart) {
        this.productionRaportPart = productionRaportPart;
    }
}
