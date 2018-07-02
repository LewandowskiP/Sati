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
