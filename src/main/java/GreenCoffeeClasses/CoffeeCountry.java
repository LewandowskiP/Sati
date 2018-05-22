package GreenCoffeeClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Przemysław
 */
public class CoffeeCountry {

    private int id;
    private String country;

    public CoffeeCountry() {
    }

    public CoffeeCountry(int id, String name) {
        this.id = id;
        this.country = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String name) {
        this.country = name;
    }

    @Override
    public String toString() {
        return country;
    }

}
