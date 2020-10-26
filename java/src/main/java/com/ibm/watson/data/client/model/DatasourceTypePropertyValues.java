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
 * Valid value for an enumerated data source property.
 */
public class DatasourceTypePropertyValues {

    private String value;
    private String label;

    public DatasourceTypePropertyValues value(String value) {
        this.value = value;
        return this;
    }

    /**
     * The value of the property that should be set if this enumeration is chosen.
     * @return value
     **/
    @javax.annotation.Nullable
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public DatasourceTypePropertyValues label(String label) {
        this.label = label;
        return this;
    }

    /**
     * A localized string that is the displayable value for the enumeration. A
     * user interface should display this string rather than the value.
     * @return label
     **/
    @javax.annotation.Nullable
    @JsonProperty("label")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypePropertyValues datasourceTypePropertyValues = (DatasourceTypePropertyValues)o;
        return Objects.equals(this.value, datasourceTypePropertyValues.value) &&
                Objects.equals(this.label, datasourceTypePropertyValues.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, label);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypePropertyValues {\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
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
