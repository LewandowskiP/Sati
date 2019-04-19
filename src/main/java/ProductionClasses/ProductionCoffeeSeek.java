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

import ProductionManagement.Employee;

/**
 *
 * @author Przemysław
 */
public class ProductionCoffeeSeek {

    private int id;
    private ProductionCoffee productionCoffee;
    private float weight;
    private Employee seekedBy;

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



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductionCoffeeSeek other = (ProductionCoffeeSeek) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.id;
        return hash;
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
