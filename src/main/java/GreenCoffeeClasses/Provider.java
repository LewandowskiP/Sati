/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GreenCoffeeClasses;

import SatiInterfaces.HaveType;

/**
 *
 * @author Przemysław
 */
public class Provider implements Comparable, HaveType {

    private int id;
    private String type;

    public Provider(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public Provider() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return type;
    }

    public int compareTo(Object o) {

        return this.toString().compareTo(o.toString());
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Provider other = (Provider) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
