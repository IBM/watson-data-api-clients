/*
 * Copyright 2020 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ibm.watson.data.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * Optional details coming from the service and related to the API call or the associated resource. 
 */
public class SystemDetails {

    private List<Warning> warnings = null;

    public SystemDetails warnings(List<Warning> warnings) {
        this.warnings = warnings;
        return this;
    }

    public SystemDetails addWarningsItem(Warning warningsItem) {
        if (this.warnings == null) {
            this.warnings = new ArrayList<>();
        }
        this.warnings.add(warningsItem);
        return this;
    }

    /**
     * Any warnings coming from the system.
     * @return warnings
     **/
    @javax.annotation.Nullable
    @JsonProperty("warnings")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Warning> getWarnings() { return warnings; }
    public void setWarnings(List<Warning> warnings) { this.warnings = warnings; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SystemDetails systemDetails = (SystemDetails) o;
        return Objects.equals(this.warnings, systemDetails.warnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(warnings);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SystemDetails {\n");
        sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
