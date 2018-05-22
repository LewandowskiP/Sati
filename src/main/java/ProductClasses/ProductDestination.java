/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

/**
 *
 * @author Przemysław
 */
public class ProductDestination {

    private int id;
    private String destination;

    public ProductDestination(int id, String destination) {
        this.id = id;
        this.destination = destination;
    }

    public ProductDestination() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return destination;
    }

}
