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
package SatiExtends;

import ProductionManagement.LabTest;

/**
 *
 * @author Przemysław
 */
public class Test {

    public static final int TO_EXAMINE = 1;
    public static final int NOT_ACCEPTED = 2;
    public static final int TO_STORE = 3;
    public static final int READY_TO_USE = 4;
    public static final int OUT_OF_STORE = 5;

    LabTest labTest;
    int state;
    String labId;

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public LabTest getLabTest() {
        return labTest;
    }

    public void setLabTest(LabTest labTest) {
        this.labTest = labTest;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Test() {
    }

    public Test(LabTest labTest, String labId) {
        this.labTest = labTest;
        this.labId = labId;
        this.state = TO_EXAMINE;
    }

}
