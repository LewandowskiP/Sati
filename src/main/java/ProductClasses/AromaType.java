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

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public int compareTo(Object o) {
        return this.toString().compareToIgnoreCase(o.toString());
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode() + 7;
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

        final AromaType other = (AromaType) obj;
        return other.getId() == this.getId();
    }

}
