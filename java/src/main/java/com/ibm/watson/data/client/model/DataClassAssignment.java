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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * DataClassAssignment
 */
public class DataClassAssignment {

    private String name;
    private DataClassAssignmentDetail selectedDataClass;

    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @javax.annotation.Nullable
    @JsonProperty("selected_data_class")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataClassAssignmentDetail getSelectedDataClass() { return selectedDataClass; }
    public void setSelectedDataClass(DataClassAssignmentDetail selectedDataClass) { this.selectedDataClass = selectedDataClass; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataClassAssignment that = (DataClassAssignment) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(selectedDataClass, that.selectedDataClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, selectedDataClass);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataClassAssignment {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    selectedDataClass: ").append(toIndentedString(selectedDataClass)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
