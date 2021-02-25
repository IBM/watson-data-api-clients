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
 * DiscoveredClass
 */
public class DiscoveredClass {

    private CodeValue dataClass;
    private Integer priority;

    @javax.annotation.Nullable
    @JsonProperty("class")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public CodeValue getDataClass() { return dataClass; }
    public void setDataClass(CodeValue dataClass) { this.dataClass = dataClass; }

    @javax.annotation.Nullable
    @JsonProperty("priority")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getPriority() { return priority; }
    public void setPriority(Integer priority) { this.priority = priority; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscoveredClass that = (DiscoveredClass) o;
        return Objects.equals(dataClass, that.dataClass) &&
                Objects.equals(priority, that.priority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataClass, priority);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveredClass {\n");
        sb.append("    class: ").append(toIndentedString(dataClass)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
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
