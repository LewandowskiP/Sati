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

    @Override
    public void showDetails() {
        productionRaportPart.showDetails();
    }

    @Override
    public String toString() {
        return productionRaportPart.toString();
    }

}
