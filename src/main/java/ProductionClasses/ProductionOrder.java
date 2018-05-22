/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductionClasses;

import ProductClasses.InstantCoffeeMixRaport;
import ProductClasses.ProductType;
import ProductClasses.RoastRaport;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Przemysław
 */
public class ProductionOrder {
    
     private int id;
     private int state;
     private int positionInQueue;
     private String quantity;
     private String otherInfo;
     private ProductType productType;
     private ProductionLine productionLine;
     private Employee orderedBy;
     private Employee completedBy;

     private Timestamp orderTime;
     private Timestamp completeTime;

     private RoastRaport roastRaport;
     private ProductionRaportPart productionRaportPart;
     private InstantCoffeeMixRaport instantCoffeeMixRaport;
     
     
/*
     public InstantCoffeeMixRaport getInstantCoffeeMixRaport() {
     return instantCoffeeMixRaport;
     }

     public void setInstantCoffeeMixRaport(InstantCoffeeMixRaport instantCoffeeMixRaport) {
     this.instantCoffeeMixRaport = instantCoffeeMixRaport;
     }

     public void moveUp() {
     this.positionInQueue--;
     }

     public ProductionRaportPart getProductionRaportPart() {
     return productionRaportPart;
     }

     public void setProductionRaportPart(ProductionRaportPart productionRaportPart) {
     this.productionRaportPart = productionRaportPart;
     }

     public ProductionOrder(int id, int state, int positionInQueue, String quantity, String otherInfo, ProductType productType, ProductionLine productionLine, Employee orderedBy, Employee completedBy, Timestamp orderTime, Timestamp completeTime) {
     this.id = id;
     this.state = state;
     this.positionInQueue = positionInQueue;
     this.quantity = quantity;
     this.otherInfo = otherInfo;
     this.productType = productType;
     this.productionLine = productionLine;
     this.orderedBy = orderedBy;
     this.completedBy = completedBy;
     this.orderTime = orderTime;
     this.completeTime = completeTime;
     }

     public RoastRaport getRoastRaport() {
     return roastRaport;
     }

     public void setRoastRaport(RoastRaport roastRaport) {
     this.roastRaport = roastRaport;
     }

     public ProductionOrder() {
     }

     public int getId() {
     return id;
     }

     public void setId(int id) {
     this.id = id;
     }

     public int getState() {
     return state;
     }

     public void setState(int state) {
     this.state = state;
     }

     public int getPositionInQueue() {
     return positionInQueue;
     }

     public void setPositionInQueue(int positionInQueue) {
     this.positionInQueue = positionInQueue;
     }

     public ProductType getProductType() {
     return productType;
     }

     public void setProductType(ProductType productType) {
     this.productType = productType;
     }

     public ProductionLine getProductionLine() {
     return productionLine;
     }

     public void setProductionLine(ProductionLine productionLine) {
     this.productionLine = productionLine;
     }

     public Employee getOrderedBy() {
     return orderedBy;
     }

     public void setOrderedBy(Employee orderedBy) {
     this.orderedBy = orderedBy;
     }

     public Employee getCompletedBy() {
     return completedBy;
     }

     public void setCompletedBy(Employee completedBy) {
     this.completedBy = completedBy;
     }

     public String getQuantity() {
     return quantity;
     }

     public void setQuantity(String quantity) {
     this.quantity = quantity;
     }

     public Timestamp getOrderTime() {
     return orderTime;
     }

     public void setOrderTime(Timestamp orderTime) {
     this.orderTime = orderTime;
     }

     public Timestamp getCompleteTime() {
     return completeTime;
     }

     public void setCompleteTime(Timestamp completeTime) {
     this.completeTime = completeTime;
     }

     public String getOtherInfo() {
     return otherInfo;
     }

     public void setOtherInfo(String otherInfo) {
     this.otherInfo = otherInfo;
     }

     @Override
     public String toString() {
     return productType + " " + quantity + " " + Global.timestampToStrDDMMYYYY(orderTime) + " " + otherInfo;

     }
     */
}
