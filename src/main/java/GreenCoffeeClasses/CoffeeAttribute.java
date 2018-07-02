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
package GreenCoffeeClasses;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Przemysław
 */
public class CoffeeAttribute implements Comparable {

    private int id;
    private Set<CoffeeType> coffeeType = new HashSet<>(0);
    private String shortcut;
    private String attributeName;

    public CoffeeAttribute() {
    }

    public CoffeeAttribute(int id, String shortcut, String attributeName) {
        this.id = id;
        this.shortcut = shortcut;
        this.attributeName = attributeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public Set<CoffeeType> getCoffeeType() {
        return coffeeType;
    }

    public void setCoffeeType(Set<CoffeeType> coffeeType) {
        this.coffeeType = coffeeType;
    }

    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    @Override
    public String toString() {
        return attributeName;
    }

    @Override
    public int compareTo(Object o) {
        return this.id - (((CoffeeAttribute) o).getId());
    }

}
