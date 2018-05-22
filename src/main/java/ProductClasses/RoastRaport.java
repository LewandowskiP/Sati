/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import Frames.Panels.DetailsRoastRaportPanel;
import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionLine;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class RoastRaport implements Details {

    private int id;

    private ProductType productType;
    private float totalSourceWeight;
    private float totalRoastWeight;
    private int swift;

    private String otherInfo;
    private Timestamp completeTime;
    private Employee completedBy;

    private ProductionLine productionLine;
    private ProductionCoffee productionCoffee;

    private Set<RoastGreenCoffeePart> roastGreenCoffeePart;
    private Set<RoastAromaPart> roastAromaPart;
    private Set<RoastPart> roastPart;

    public Employee getCompletedBy() {
        return completedBy;
    }

    public void setCompletedBy(Employee completedBy) {
        this.completedBy = completedBy;
    }

    public int getSwift() {
        return swift;
    }

    public void setSwift(int swift) {
        this.swift = swift;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Timestamp getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }

    public ProductionLine getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(ProductionLine productionLine) {
        this.productionLine = productionLine;
    }

    public ProductionCoffee getProductionCoffee() {
        return productionCoffee;
    }

    public void setProductionCoffee(ProductionCoffee productionCoffee) {
        this.productionCoffee = productionCoffee;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public float getTotalSourceWeight() {
        return totalSourceWeight;
    }

    public void setTotalSourceWeight(float totalSourceWeight) {
        this.totalSourceWeight = totalSourceWeight;
    }

    public float getTotalRoastWeight() {
        return totalRoastWeight;
    }

    public void setTotalRoastWeight(float totalRoastWeight) {
        this.totalRoastWeight = totalRoastWeight;
    }

    public RoastRaport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<RoastGreenCoffeePart> getRoastGreenCoffeePart() {
        return roastGreenCoffeePart;
    }

    public void setRoastGreenCoffeePart(Set<RoastGreenCoffeePart> roastGreenCoffeePart) {
        this.roastGreenCoffeePart = roastGreenCoffeePart;
    }

    public Set<RoastAromaPart> getRoastAromaPart() {
        return roastAromaPart;
    }

    public void setRoastAromaPart(Set<RoastAromaPart> roastAromaPart) {
        this.roastAromaPart = roastAromaPart;
    }

    public Set<RoastPart> getRoastPart() {
        return roastPart;
    }

    public void setRoastPart(Set<RoastPart> roastPart) {
        this.roastPart = roastPart;
    }

    @Override
    public String toString() {
        if (productionCoffee != null) {
            return productionCoffee.getProductType() + " -- Suma kawy upalonej: " + totalRoastWeight + "  " + Global.timestampToStrDDMMYYYY(completeTime);
        } else {
            return Global.timestampToStrDDMMYYYY(completeTime) + ": Kawy zielonej: " + totalSourceWeight + " Kawy palonej: " + totalRoastWeight;
        }

    }

    public void showDetails() {
        String options[] = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsRoastRaportPanel(this), "Sprawdź raportu.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    }
}
