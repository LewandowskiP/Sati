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

}
