/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionClasses;

import ProductClasses.ProductType;
import ProductionManagement.Global;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class ProductionCoffee implements Comparable {

    int id;
    int state;
    Timestamp prodDate;
    ProductType productType;
    float weight;
    boolean used = false;
    boolean returned = false;

    public boolean isUsed() {
        return used;
    }

    public Timestamp getProdDate() {
        return prodDate;
    }

    public void setProdDate(Timestamp prodDate) {
        this.prodDate = prodDate;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ProductionCoffee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        if (!used) {
            if (!returned) {
                return productType.getProductName() + " " + Global.timestampToStrDDMMYYYY(prodDate) + " " + weight + " Kg";
            } else {
                return "ZW " + productType.getProductName() + " " + Global.timestampToStrDDMMYYYY(prodDate) + " " + weight + " Kg";
            }
        } else {
            if (!returned) {
                return "PP " + productType.getProductName() + " " + Global.timestampToStrDDMMYYYY(prodDate) + " " + weight + " Kg";
            } else {
                return "ZW PP " + productType.getProductName() + " " + Global.timestampToStrDDMMYYYY(prodDate) + " " + weight + " Kg";
            }
        }
    }

    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }

}
