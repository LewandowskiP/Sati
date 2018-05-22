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
//This class is about Dossier number
public class CoffeeOwner {

    private int id;
    private String owner;

    public CoffeeOwner(int id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public CoffeeOwner() {
    }

    @Override
    public String toString() {
        return owner;
    }

}
