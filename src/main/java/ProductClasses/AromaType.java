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
public class AromaType implements Comparable, HaveType {

    private int id;
    private String type;

    public AromaType() {
    }

    public AromaType(int id, String type, String code) {
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

    @Override
    public String toString() {
        return type;
    }

    public int compareTo(Object o) {
        return this.toString().compareToIgnoreCase(o.toString());
    }

}
