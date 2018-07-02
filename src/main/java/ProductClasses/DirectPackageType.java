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

import SatiInterfaces.HaveType;

/**
 *
 * @author Przemysław
 */
public class DirectPackageType implements Comparable, HaveType {

    int id;
    String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DirectPackageType() {
    }

    @Override
    public String toString() {
        return type;
    }

    public int compareTo(Object o) {
        return this.toString().compareToIgnoreCase(o.toString());
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode() + 7;
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
        final DirectPackageType other = (DirectPackageType) obj;
        return other.getId() == this.getId();
    }

}
