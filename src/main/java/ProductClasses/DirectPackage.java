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
package ProductClasses;

import Frames.Panels.DetailsAromaPanel;
import Frames.Panels.DetailsDirectPackagePanel;
import Frames.Panels.EditDirectPackagePanel;
import Frames.Panels.EditGreenCoffeePanel;
import GreenCoffeeClasses.Provider;
import ProductionManagement.Employee;
import ProductionManagement.LabTest;
import SatiExtends.Test;
import SatiInterfaces.Details;
import SatiInterfaces.Editable;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class DirectPackage extends Test implements Details, Editable {

    private int id;
    private int quantity;
    private int arrivalQuantity;
    private float weight;
    private float arrivalWeight;

    private Timestamp arrivalDate;
    private DirectPackageType directPackageType;
    private Employee storeman;

    private Provider provider;

    public DirectPackage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getArrivalQuantity() {
        return arrivalQuantity;
    }

    public void setArrivalQuantity(int arrivalQuantity) {
        this.arrivalQuantity = arrivalQuantity;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getArrivalWeight() {
        return arrivalWeight;
    }

    public void setArrivalWeight(float arrivalWeight) {
        this.arrivalWeight = arrivalWeight;
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public DirectPackageType getDirectPackageType() {
        return directPackageType;
    }

    public void setDirectPackageType(DirectPackageType directPackageType) {
        this.directPackageType = directPackageType;
    }

    public Employee getStoreman() {
        return storeman;
    }

    public void setStoreman(Employee storeman) {
        this.storeman = storeman;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return this.getLabId() + "  " + directPackageType;
    }

    @Override
    public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsDirectPackagePanel(this), "Podgląd opakowania bezpośredniego.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    @Override
    public void edit() {

        String[] option = {"Cofnij"};
        int result = JOptionPane.showOptionDialog(null, new EditDirectPackagePanel(this), "Zmień dane kawy.", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DirectPackage other = (DirectPackage) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
}
