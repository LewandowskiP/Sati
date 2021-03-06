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
import Frames.Panels.EditAromaPanel;
import Frames.Panels.EditGreenCoffeePanel;
import GreenCoffeeClasses.CoffeeGreenChangeHistory;

import GreenCoffeeClasses.Provider;
import ProductionManagement.Employee;
import ProductionManagement.Global;
import ProductionManagement.LabTest;

import SatiExtends.Test;
import SatiInterfaces.Details;
import SatiInterfaces.Editable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class Aroma extends Test implements Details, Editable {

    private int id;
    private float quantity;
    private float arrivalQuantity;

    private Timestamp arrivalDate;
    private Employee storeman;

    private Provider provider;
    private AromaType aromaType;

    

    
    
    Set<AromaChangeHistory> aromaChangeHistory;

    public float getArrivalQuantity() {
        return arrivalQuantity;
    }

    public void setArrivalQuantity(float arrivalQuantity) {
        this.arrivalQuantity = arrivalQuantity;
    }

    public Set<AromaChangeHistory> getAromaChangeHistory() {
        return aromaChangeHistory;
    }

    public void setAromaChangeHistory(Set<AromaChangeHistory> aromaChangeHistory) {
        this.aromaChangeHistory = aromaChangeHistory;
    }

    public Employee getStoreman() {
        return storeman;
    }

    public void setStoreman(Employee storeman) {
        this.storeman = storeman;
    }

    public Aroma() {
    }

    public Timestamp getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Timestamp arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public AromaType getAromaType() {
        return aromaType;
    }

    public void setAromaType(AromaType aromaType) {
        this.aromaType = aromaType;
    }

    @Override
    public String toString() {
        return this.getLabId() + " " + aromaType;
    }

    @Override
    public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsAromaPanel(this), "Podgląd aromatu.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

    @Override
    public void edit() {
        String[] option = {"Cofnij"};
        int result = JOptionPane.showOptionDialog(null, new EditAromaPanel(this), "Zmień dane kawy.", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
    }

    public Aroma(float quantity, Employee storeman, Provider provider, AromaType aromaType, LabTest labTest, String labId) {
        super(labTest, labId);
        this.quantity = quantity;
        this.arrivalQuantity = quantity;
        this.storeman = storeman;
        this.provider = provider;
        this.aromaType = aromaType;
        this.aromaChangeHistory = new HashSet<>();
        this.arrivalDate = Global.time();
        addHistory(quantity, "Dostawa - " + labId, storeman);
    }

    public void correction(float changeQuantity, Employee emp, String comment) {
        if ((this.quantity + changeQuantity) <= 0) {
            this.setState(Test.OUT_OF_STORE);
        }
        this.quantity += changeQuantity;
        addHistory(changeQuantity, comment, emp);

    }

    public boolean roast(float changeQuantity, Employee mixedBy, RoastRaport rr) {
        if (this.quantity < changeQuantity) {
            return false;
        } else {
            this.quantity -= changeQuantity;
            addHistoryRoast(changeQuantity, mixedBy, rr);
            if (this.quantity <= 0.5) {
                this.setState(Test.OUT_OF_STORE);
                this.quantity = 0f;
            }
        }
        return true;
    }

    private void addHistoryRoast(Float weight, Employee changedBy, RoastRaport roastRaport) {
        String comment = this.getLabId() + " PALENIE " + roastRaport.getProductType();
        this.aromaChangeHistory.add(new AromaChangeHistory(-1 * weight, this.quantity, this, comment, changedBy, roastRaport));
    }

    private void addHistory(Float weight, String tempComment, Employee changedBy) {
        String comment = this.getLabId() + tempComment;
        this.aromaChangeHistory.add(new AromaChangeHistory(weight, this.quantity, this, comment, changedBy));
    }

}
