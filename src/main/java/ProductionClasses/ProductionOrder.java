/* 
 * Copyright 2018 Cafe Sati Polska.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ProductionClasses;

import ProductClasses.ProductType;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import java.sql.Timestamp;

/**
 *
 * @author Przemysław
 */
public class ProductionOrder implements Comparable {

    public static final int PRODUCTION_ORDER_ORDERED = 1;
    public static final int PRODUCTION_ORDER_INPROGRESS = 2;
    public static final int PRODUCTION_ORDER_PAUSED = 3;
    public static final int PRODUCTION_ORDER_COMPLETED = 4;

    private int id;
    private int state;
    private int positionInQueue;
    private Integer quantity;
    private String otherInfo;
    private ProductType productType;
    private ProductionLine productionLine;
    private Employee orderedBy;
    private Employee completedBy;
    private boolean important;
    private Timestamp orderTime;
    private Timestamp completeTime;
    private Timestamp deadline;
    private Integer startQuantity;

    public void makeOrder(ProductionLine productionLine,
            boolean important,
            Timestamp deadline,
            ProductType productType,
            Employee orderedBy,
            Integer quantity,
            String otherInfo,
            int positionInQueue) {
        this.important = important;
        this.startQuantity = quantity;
        this.deadline = deadline;
        this.productionLine = productionLine;
        this.productType = productType;
        this.orderedBy = orderedBy;
        this.quantity = quantity;
        this.otherInfo = otherInfo;
        this.state = Global.PRODUCTION_ORDER_ORDERED;
        this.positionInQueue = positionInQueue;
        this.orderTime = new Timestamp(System.currentTimeMillis());
    }

    public void editOrder(
            boolean important,
            Timestamp deadline,
            ProductType productType,
            Integer quantity,
            String otherInfo
    ) {
        this.startQuantity = quantity;
        this.important = important;
        this.deadline = deadline;
        this.productType = productType;
        this.quantity = quantity;
        this.otherInfo = otherInfo;
        this.state = Global.PRODUCTION_ORDER_ORDERED;
    }

    public void upQueue() {
        this.positionInQueue--;
    }

    public void downQueue() {
        this.positionInQueue++;
    }

    public boolean isImportant() {
        return important;
    }

    public Integer getStartQuantity() {
        return startQuantity;
    }

    public void setStartQuantity(Integer startQuantity) {
        this.startQuantity = startQuantity;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }

    public void completeOrder(Employee completedBy) {
        this.completedBy = completedBy;
        this.completeTime = new Timestamp(System.currentTimeMillis());
        this.state = Global.PRODUCTION_ORDER_COMPLETED;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
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

    @Override
    public int compareTo(Object o) {
        ProductionOrder tmp = (ProductionOrder) o;
        if (this.positionInQueue != tmp.getPositionInQueue()) {
            return this.positionInQueue - ((ProductionOrder) o).getPositionInQueue();
        } else {
            return this.getOrderTime().compareTo(tmp.getOrderTime());
        }
    }

    @Override
    public String toString() {
        return positionInQueue + 1 + ". " + productType.getProductName() + " " + quantity + " Kg/Szt. Uwagi:" + otherInfo;
    }

}
