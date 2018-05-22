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
public class RoastPart {

    private int id;
    private Float sourceWeight;
    private Float roastedWeight;
    private Boolean temperature;
    private String colour;
    private RoastRaport roastRaport;

    public Float getRoastedWeight() {
        return roastedWeight;
    }

    public void setRoastedWeight(Float roastedWeight) {
        this.roastedWeight = roastedWeight;
    }

    public RoastRaport getRoastRaport() {
        return roastRaport;
    }

    public void setRoastRaport(RoastRaport roastRaport) {
        this.roastRaport = roastRaport;
    }

    public RoastPart() {
    }

    public RoastPart(int id, Float sourceWeight, Float roastedWieght, Boolean temperature, String colour) {
        this.id = id;
        this.sourceWeight = sourceWeight;
        this.roastedWeight = roastedWieght;
        this.temperature = temperature;
        this.colour = colour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getSourceWeight() {
        return sourceWeight;
    }

    public void setSourceWeight(Float sourceWeight) {
        this.sourceWeight = sourceWeight;
    }

    public Boolean isTemperature() {
        return temperature;
    }

    public void setTemperature(Boolean temperature) {
        this.temperature = temperature;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

}
