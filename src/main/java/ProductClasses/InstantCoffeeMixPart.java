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

import GreenCoffeeClasses.CoffeeGreen;
import GreenCoffeeClasses.CoffeeType;

/**
 *
 * @author Przemysław
 */
public class InstantCoffeeMixPart implements Comparable {

    int id;

    CoffeeGreen coffeeGreen;
    String cardBoardNumber;
    String serialNumber;
    boolean sealOk;

    float weight;

    InstantCoffeeMixRaport instantCoffeeMixRaport;

    public boolean isSealOk() {
        return sealOk;
    }

    public void setSealOk(boolean sealOk) {
        this.sealOk = sealOk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CoffeeGreen getCoffeeGreen() {
        return coffeeGreen;
    }

    public void setCoffeeGreen(CoffeeGreen coffeeGreen) {
        this.coffeeGreen = coffeeGreen;
    }

    public String getCardBoardNumber() {
        return cardBoardNumber;
    }

    public void setCardBoardNumber(String cardBoardNumber) {
        this.cardBoardNumber = cardBoardNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public InstantCoffeeMixRaport getInstantCoffeeMixRaport() {
        return instantCoffeeMixRaport;
    }

    public void setInstantCoffeeMixRaport(InstantCoffeeMixRaport instantCoffeeMixRaport) {
        this.instantCoffeeMixRaport = instantCoffeeMixRaport;
    }

    @Override
    public String toString() {
        return coffeeGreen + " : " + weight + " Kg";
    }

    public void showDetails() {
        coffeeGreen.showDetails();
    }

    public int compareTo(Object o) {
        return this.getCoffeeGreen().getCoffeeType().getId() - ((InstantCoffeeMixPart) o).getCoffeeGreen().getCoffeeType().getId();
    }

}
