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
import com.ibm.watson.data.client.model.enums.TargetModelType;

import java.util.Objects;

/**
 * ErrorTargetModel
 */
public class ErrorTargetModel {

    private TargetModelType type;
    private String name;

    public ErrorTargetModel type(TargetModelType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public TargetModelType getType() { return type; }
    public void setType(TargetModelType type) { this.type = type; }

    public ErrorTargetModel name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ErrorTargetModel errorTargetModel = (ErrorTargetModel)o;
        return Objects.equals(this.type, errorTargetModel.type) &&
                Objects.equals(this.name, errorTargetModel.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorTargetModel {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
