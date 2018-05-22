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
public class RoastAromaPart {

    private int id;
    private Aroma aroma;
    private float quantity;
    private RoastRaport roastRaport;

    public RoastRaport getRoastRaport() {
        return roastRaport;
    }

    public void setRoastRaport(RoastRaport roastRaport) {
        this.roastRaport = roastRaport;
    }

    public RoastAromaPart(int id, Aroma aroma, float quantity) {
        this.id = id;
        this.aroma = aroma;
        this.quantity = quantity;
    }

    public RoastAromaPart() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aroma getAroma() {
        return aroma;
    }

    public void setAroma(Aroma aroma) {
        this.aroma = aroma;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return this.getAroma().toString() + " : " + this.quantity;
    }

}
