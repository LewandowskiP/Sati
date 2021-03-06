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
package ProductionManagement;

import Frames.Panels.DetailsLabTestPanel;
import java.sql.Timestamp;
import javax.swing.JOptionPane;

/**
 *
 * @author Przemysław
 */
public class LabTest {

    private int id;
    private String technical;
    private String organoleptic;
    private Boolean vermin;
    private int sampleSize;
    private Timestamp examineDate;
    private Employee labAssistant;
    private Boolean accepted;

    //General parameters
    private String lawApprovement = "";
    private String specificationApprovement = "";
    private String serialNumber = "";
    private String certificate = "";
    private String expiryDate = "";
    private String otherDocuments = "";
    private String jury = "";

    //Organoleptic parameters
    //Before (general)
    private String color = "";
    private String smell = "";
    private String taste = "";
    private String consistency = "";
    private String intensity = "";
    private String foam = "";
    private String shape = "";

    //After
    private String phAfter = "";
    private String consistencyAfter = "";
    private String colorAfter = "";
    private String smellAfter = "";
    private String tasteAfter = "";
    private String clarityAfter = "";

    //Package parameters
    private String fabric = "";
    private String esthetics = "";
    private String dimensions = "";
    private String colors = "";
    private String textCorrect = "";
    private String structure = "";
    private String layering = "";
    private String resistanceToAbrasion = "";
    private String damaged = "";
    private String marking = "";

    //Technical parameters
    private String weight = "";
    private String humidity = "";
    private String oxygen = "";
    private String granulity = "";
    private String machineTest = "";
    private String solubility = "";
    private String mold = "";
    private String pollution = "";
    private String sealing = "";
    private String purity = "";

    private int type = 999;

    public LabTest() {
    }

    public String getPurity() {
        return purity;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getOrganoleptic() {
        return organoleptic;
    }

    public void setOrganoleptic(String organoleptic) {
        this.organoleptic = organoleptic;
    }

    public Boolean isVermin() {
        return vermin;
    }

    public void setVermin(Boolean vermin) {
        this.vermin = vermin;
    }

    public int getSampleSize() {
        return sampleSize;
    }

    public void setSampleSize(int sampleSize) {
        this.sampleSize = sampleSize;
    }

    public Timestamp getExamineDate() {
        return examineDate;
    }

    public void setExamineDate(Timestamp examineDate) {
        this.examineDate = examineDate;
    }

    public Employee getLabAssistant() {
        return labAssistant;
    }

    public void setLabAssistant(Employee labAssistant) {
        this.labAssistant = labAssistant;
    }

    public Boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public String getLawApprovement() {
        return lawApprovement;
    }

    public void setLawApprovement(String lawApprovement) {
        this.lawApprovement = lawApprovement;
    }

    public String getSpecificationApprovement() {
        return specificationApprovement;
    }

    public void setSpecificationApprovement(String specificationApprovement) {
        this.specificationApprovement = specificationApprovement;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getOtherDocuments() {
        return otherDocuments;
    }

    public void setOtherDocuments(String otherDocuments) {
        this.otherDocuments = otherDocuments;
    }

    public String getJury() {
        return jury;
    }

    public void setJury(String jury) {
        this.jury = jury;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSmell() {
        return smell;
    }

    public void setSmell(String smell) {
        this.smell = smell;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getConsistency() {
        return consistency;
    }

    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getFoam() {
        return foam;
    }

    public void setFoam(String foam) {
        this.foam = foam;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getPhAfter() {
        return phAfter;
    }

    public void setPhAfter(String phAfter) {
        this.phAfter = phAfter;
    }

    public String getConsistencyAfter() {
        return consistencyAfter;
    }

    public void setConsistencyAfter(String consistencyAfter) {
        this.consistencyAfter = consistencyAfter;
    }

    public String getColorAfter() {
        return colorAfter;
    }

    public void setColorAfter(String colorAfter) {
        this.colorAfter = colorAfter;
    }

    public String getSmellAfter() {
        return smellAfter;
    }

    public void setSmellAfter(String smellAfter) {
        this.smellAfter = smellAfter;
    }

    public String getTasteAfter() {
        return tasteAfter;
    }

    public void setTasteAfter(String tasteAfter) {
        this.tasteAfter = tasteAfter;
    }

    public String getClarityAfter() {
        return clarityAfter;
    }

    public void setClarityAfter(String clarityAfter) {
        this.clarityAfter = clarityAfter;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getEsthetics() {
        return esthetics;
    }

    public void setEsthetics(String esthetics) {
        this.esthetics = esthetics;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getTextCorrect() {
        return textCorrect;
    }

    public void setTextCorrect(String textCorrect) {
        this.textCorrect = textCorrect;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getLayering() {
        return layering;
    }

    public void setLayering(String layering) {
        this.layering = layering;
    }

    public String getResistanceToAbrasion() {
        return resistanceToAbrasion;
    }

    public void setResistanceToAbrasion(String resistanceToAbrasion) {
        this.resistanceToAbrasion = resistanceToAbrasion;
    }

    public String getDamaged() {
        return damaged;
    }

    public void setDamaged(String damaged) {
        this.damaged = damaged;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getOxygen() {
        return oxygen;
    }

    public void setOxygen(String oxygen) {
        this.oxygen = oxygen;
    }

    public String getGranulity() {
        return granulity;
    }

    public void setGranulity(String granulity) {
        this.granulity = granulity;
    }

    public String getMachineTest() {
        return machineTest;
    }

    public void setMachineTest(String machineTest) {
        this.machineTest = machineTest;
    }

    public String getSolubility() {
        return solubility;
    }

    public void setSolubility(String solubility) {
        this.solubility = solubility;
    }

    public String getMold() {
        return mold;
    }

    public void setMold(String mold) {
        this.mold = mold;
    }

    public String getPollution() {
        return pollution;
    }

    public void setPollution(String pollution) {
        this.pollution = pollution;
    }

    public String getSealing() {
        return sealing;
    }

    public void setSealing(String sealing) {
        this.sealing = sealing;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void buildLine(StringBuilder stringBuilder, int lineIncrements, String text, int lineSeparators) {

        while (lineIncrements > 0) {
            lineIncrements--;
            stringBuilder.append("    ");
        }
        stringBuilder.append(text);
        while (lineSeparators > 0) {
            lineSeparators--;
            stringBuilder.append(System.lineSeparator());
        }

    }

    public String getDetails() {

        StringBuilder sb = new StringBuilder();
        if (type == Global.RESOURCE_TYPE_AROMA) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Numer partii: ").append(serialNumber).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(color).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Intensywność: ").append(intensity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smell).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Smak: ").append(taste).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry fizykotechniczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zanieczyszczenia: ").append(pollution).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Materiał: ").append(fabric).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Estetyka: ").append(esthetics).append(System.lineSeparator());
        } else if (type == Global.RESOURCE_TYPE_CARDBOARD) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność z wymogami prawnymi: ").append(lawApprovement);
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement);
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Barwa: ").append(colors).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wymiary: ").append(dimensions).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Materiał: ").append(fabric).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Uszkodzenia: ").append(damaged).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Czystość: ").append(purity).append(System.lineSeparator());

        } else if (type == Global.RESOURCE_TYPE_COFFEE_CAPSULE) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Okres minimalnej trwałości: ").append(expiryDate).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(colors).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smell).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Smak: ").append(taste).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Pianka: ").append(foam).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Moc: ").append(intensity).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry techniczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Waga kapsułki: ").append(weight).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Granulacja: ").append(granulity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Test maszynowy: ").append(machineTest).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wilgotność: ").append(humidity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Tlen: ").append(oxygen).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Estetyka: ").append(esthetics).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Poprawność tekstów: ").append(textCorrect).append(System.lineSeparator());
        } else if (type == Global.RESOURCE_TYPE_COFFEE_GREEN) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(color).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Intensywność: ").append(intensity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smell).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Smak: ").append(taste).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry fizykotechniczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zanieczyszczenia[%]: ").append(pollution).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Obecność pleśni: ").append(mold).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wilgotność kawy[%]: ").append(humidity).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Materiał: ").append(fabric).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Estetyka: ").append(esthetics).append(System.lineSeparator());
        } else if (type == Global.RESOURCE_TYPE_COFFEE_INSTANT) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Okres minimalnej trwałości: ").append(expiryDate).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne przez zaparzeniem").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(color).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Postać: ").append(shape).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smell).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Konsystencja: ").append(consistency).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne po zaparzeniu").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(colorAfter).append(System.lineSeparator());
            sb.append("    ").append("    ").append("PH: ").append(phAfter).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kalrowność: ").append(clarityAfter).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smellAfter).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Konsystencja: ").append(consistencyAfter).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Smak: ").append(tasteAfter).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry fizykotechniczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zanieczyszczenia[%]: ").append(pollution).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Obecność pleśni: ").append(mold).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wilgotność kawy[%]: ").append(humidity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Rozpuszczalość w temp 96-98 stopni : ").append(solubility).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Oznakowanie: ").append(marking).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Estetyka: ").append(esthetics).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Poprawność tekstów: ").append(textCorrect).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Szczelność: ").append(sealing).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Materiał: ").append(fabric).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Czystość: ").append(purity).append(System.lineSeparator());
        } else if (type == Global.RESOURCE_TYPE_COFFEE_OTHER) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement);
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Okres minimalnej trwałości: ").append(expiryDate).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(colors).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smell).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Smak: ").append(taste).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Pianka: ").append(foam).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Moc: ").append(intensity).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry techniczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Waga netto: ").append(weight).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wilgotność: ").append(humidity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Oznakowanie: ").append(marking).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Estetyka: ").append(esthetics).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Szczelność: ").append(sealing).append(System.lineSeparator());
        } else if (type == Global.RESOURCE_TYPE_COFFEE_PADS) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Okres minimalnej trwałości: ").append(expiryDate).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(colors).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smell).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Smak: ").append(taste).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Pianka: ").append(foam).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Moc: ").append(intensity).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry techniczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Waga netto: ").append(weight).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Granulacja: ").append(granulity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Test maszynowy: ").append(machineTest).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wilgotność: ").append(humidity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Tlen: ").append(oxygen).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Estetyka: ").append(esthetics).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wielkość uformowanej kawy: ").append(dimensions).append(System.lineSeparator());
        } else if (type == Global.RESOURCE_TYPE_COFFEE_POWDER) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Okres minimalnej trwałości: ").append(expiryDate).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Dokumenty").append(otherDocuments).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(color).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Smak: ").append(taste).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Postać: ").append(shape).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smell).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Konsystencja: ").append(consistency).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry fizykotechniczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zanieczyszczenia[%]: ").append(pollution).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Obecność pleśni: ").append(mold).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wilgotność kawy[%]: ").append(humidity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Rozpuszczalość w temp 96-98 stopni : ").append(solubility).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Oznakowanie: ").append(marking).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Estetyka: ").append(esthetics).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Czytelność: ").append(textCorrect).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Materiał: ").append(fabric).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Czystość: ").append(purity).append(System.lineSeparator());
        } else if (type == Global.RESOURCE_TYPE_COFFEE_RETURNED) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Okres minimalnej trwałości: ").append(expiryDate).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry organoleptyczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Kolor: ").append(color).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Smak: ").append(taste).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zapach: ").append(smell).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Moc: ").append(intensity).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry fizykotechniczne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zanieczyszczenia[%]: ").append(pollution).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wilgotność kawy[%]: ").append(humidity).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Oznakowanie: ").append(marking).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Estetyka: ").append(esthetics).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Szczelność: ").append(sealing).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Waga netto: ").append(weight).append(System.lineSeparator());
        } else if (type == Global.RESOURCE_TYPE_PACKAGE) {
            sb.append("    ").append("    ").append("Parametry ogólne").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność z wymogami prawnymi: ").append(lawApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Zgodność ze specyfikacją: ").append(specificationApprovement).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Jury: ").append(jury).append(System.lineSeparator()).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Parametry opakowania").append(System.lineSeparator());
            sb.append("    ").append("    ").append("Barwa: ").append(colors).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Wymiary: ").append(dimensions).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Rozwarstwianie: ").append(layering).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Materiał: ").append(fabric).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Odporność na ścieranie: ").append(resistanceToAbrasion).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Struktura: ").append(structure).append(System.lineSeparator());
            sb.append("    ").append("    ").append("Czystość: ").append(purity).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public void showDetails() {
        String[] options = new String[]{"OK"};
        JOptionPane.showOptionDialog(null, new DetailsLabTestPanel(this), "Podgląd karty badania.", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
    }

}
