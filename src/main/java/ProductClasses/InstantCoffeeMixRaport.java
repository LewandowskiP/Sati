/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductClasses;

import Frames.Panels.DetailsInstantCoffeeMixRaportPanel;
import ProductionClasses.ProductionCoffee;
import ProductionClasses.ProductionLine;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import SatiInterfaces.Details;
import java.sql.Timestamp;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class InstantCoffeeMixRaport implements Details {

    private int id;

    private ProductType productType;
    private float weight;

    private int swift;

    private String otherInfo;
    private Timestamp mixDate;
    private Employee mixedBy;

    private ProductionLine productionLine;
    private ProductionCoffee productionCoffee;

    private Set<InstantCoffeeMixPart> instantCoffeeMixPart;

    public InstantCoffeeMixRaport() {
    }

    public ProductionLine getProductionLine() {
        return productionLine;
    }

    public void setProductionLine(ProductionLine productionLine) {
        this.productionLine = productionLine;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<InstantCoffeeMixPart> getInstantCoffeeMixPart() {
        return instantCoffeeMixPart;
    }

    public void setInstantCoffeeMixPart(Set<InstantCoffeeMixPart> instantCoffeeMixPart) {
        this.instantCoffeeMixPart = instantCoffeeMixPart;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

    public Timestamp getMixDate() {
        return mixDate;
    }

    public void setMixDate(Timestamp mixDate) {
        this.mixDate = mixDate;
    }

    public int getSwift() {
        return swift;
    }

    public void setSwift(int swift) {
        this.swift = swift;
    }

    public Employee getMixedBy() {
        return mixedBy;
    }

    public void setMixedBy(Employee mixedBy) {
        this.mixedBy = mixedBy;
    }

    public ProductionCoffee getProductionCoffee() {
        return productionCoffee;
    }

    public void setProductionCoffee(ProductionCoffee productionCoffee) {
        this.productionCoffee = productionCoffee;
    }

    @Override
    public String toString() {
        return productionCoffee.getProductType() + " -- Suma kawy zmieszanej: " + weight + "  " + Global.timestampToStrDDMMYYYY(mixDate);
    }

    public void showDetails() {
        String options[] = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsInstantCoffeeMixRaportPanel(this), "Sprawdź raportu.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

    }

}
