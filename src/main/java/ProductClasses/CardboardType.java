/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import SatiInterfaces.HaveType;

/**
 *
 * @author Przemysław
 */
public class CardboardType implements Comparable, HaveType {

    int id;
    String type;

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

    public String toString() {
        return type;
    }

    public int compareTo(Object o) {
        return this.toString().compareToIgnoreCase(o.toString());
    }
}
