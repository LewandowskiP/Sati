package GreenCoffeeClasses;

import SatiInterfaces.HaveType;
import java.util.HashSet;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Przemysław
 */
public class CoffeeType implements Comparable, HaveType {

    private int id;
    private String type;
    private Set<CoffeeAttribute> coffeeAttribute = new HashSet<CoffeeAttribute>(0);

    public CoffeeType() {
    }

    public CoffeeType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<CoffeeAttribute> getCoffeeAttribute() {
        return coffeeAttribute;
    }

    public void setCoffeeAttribute(Set<CoffeeAttribute> coffeeAttribute) {
        this.coffeeAttribute = coffeeAttribute;
    }

    public boolean isInstant() {
        for (CoffeeAttribute ca : coffeeAttribute) {
            if ("INSTANT".equals(ca.getAttributeName().toUpperCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(type);

        for (CoffeeAttribute ct : coffeeAttribute) {
            sb.append(" ");
            sb.append(ct.getShortcut());
        }

        return sb.toString();
    }

    public int compareTo(Object o) {
        return this.getType().compareToIgnoreCase((o.toString()));
    }
}
