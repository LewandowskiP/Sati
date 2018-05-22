/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenCoffeeClasses;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Przemysław
 */
public class CoffeeAttribute {

    private int id;
    private Set<CoffeeType> coffeeType = new HashSet<CoffeeType>(0);
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

}
