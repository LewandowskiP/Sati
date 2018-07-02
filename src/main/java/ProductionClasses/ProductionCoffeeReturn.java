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
