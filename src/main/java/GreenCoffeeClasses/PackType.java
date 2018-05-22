package GreenCoffeeClasses;

import SatiInterfaces.HaveType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Przemysław
 */
public class PackType implements Comparable, HaveType {

    private int id;
    private String type;
    private int size;

    public PackType(int id, String type, int size) {
        this.id = id;
        this.type = type;
        this.size = size;
    }

    public PackType() {
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return type + " " + size + " kg";
    }

    public int compareTo(Object o) {
        return this.getType().compareToIgnoreCase(o.toString());
    }
}
