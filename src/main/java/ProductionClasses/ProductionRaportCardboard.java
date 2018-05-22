/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionClasses;

import ProductClasses.Cardboard;

/**
 *
 * @author Przemysław
 */
public class ProductionRaportCardboard {

    int id;
    Cardboard cardboard;
    ProductionRaportPart productionRaportPart;

    public ProductionRaportCardboard() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cardboard getCardboard() {
        return cardboard;
    }

    public void setCardboard(Cardboard cardboard) {
        this.cardboard = cardboard;
    }

    public ProductionRaportPart getProductionRaportPart() {
        return productionRaportPart;
    }

    public void setProductionRaportPart(ProductionRaportPart productionRaportPart) {
        this.productionRaportPart = productionRaportPart;
    }
}
