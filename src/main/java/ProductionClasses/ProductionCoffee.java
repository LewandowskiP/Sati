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
package ProductionClasses;

import ProductClasses.ProductType;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class ProductionCoffee implements Comparable {

    private int id;
    private int state;
    private Timestamp prodDate;
    private ProductType productType;
    private float weight;
    private boolean used = false;
    private boolean returned = false;
    private boolean halfProduct = false;
    private Employee producedBy;

    public Employee getProducedBy() {
        return producedBy;
    }

    public void setProducedBy(Employee producedBy) {
        this.producedBy = producedBy;
    }

    public boolean isHalfProduct() {
        return halfProduct;
    }

    public void setHalfProduct(boolean halfProduct) {
        this.halfProduct = halfProduct;
    }

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
        String toReturn = productType.getProductName() + " " + Global.timestampToStrDDMMYYYY(prodDate) + " " + weight + " Kg " + producedBy.getEmployeeID();
        if (returned) {
            toReturn = "ZW " + toReturn;
        }
        if (used) {
            toReturn = "PP " + toReturn;
        }
        if (halfProduct) {
            toReturn = "1/2 " + toReturn;
        }
        return toReturn;
    }

    @Override
    public int compareTo(Object o) {
        return this.productType.toString().compareTo(((ProductionCoffee) o).getProductType().toString());
    }

}
