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

/**
 *
 * @author Przemysław
 */
public class RoastGreenCoffeePart implements Comparable {

    private int id;
    private CoffeeGreen coffeeGreen;
    private float weight;
    private RoastRaport roastRaport;

    public RoastGreenCoffeePart(int id, CoffeeGreen coffeeGreen, float weight) {
        this.id = id;
        this.coffeeGreen = coffeeGreen;
        this.weight = weight;
    }

    public RoastGreenCoffeePart() {
    }

    @Override
    public String toString() {
        return coffeeGreen + " : " + weight + " Kg";
    }

    public RoastRaport getRoastRaport() {
        return roastRaport;
    }

    public void setRoastRaport(RoastRaport roastRaport) {
        this.roastRaport = roastRaport;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        return this.getCoffeeGreen().getCoffeeType().getId() - ((RoastGreenCoffeePart) o).getCoffeeGreen().getCoffeeType().getId();
    }

    public void showDetails() {
        coffeeGreen.showDetails();
    }

}
