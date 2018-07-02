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

/**
 *
 * @author Przemysław
 */
public class ProductionLine implements Comparable {

    private int id;
    private String line;
    private boolean roast;

    public ProductionLine(int id, String line) {
        this.id = id;
        this.line = line;
    }

    public ProductionLine() {
    }

    public boolean isRoast() {
        return roast;
    }

    public void setRoast(boolean roast) {
        this.roast = roast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return line;
    }

    public int compareTo(Object o) {
        return this.toString().compareTo(o.toString());
    }

}
