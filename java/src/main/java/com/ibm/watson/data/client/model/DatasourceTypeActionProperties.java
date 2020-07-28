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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Definitions of the properties that are supported for a data source type
 * action.
 */
public class DatasourceTypeActionProperties {

    private List<DatasourceTypeProperty> input = null;
    private List<DatasourceTypeProperty> output = null;

    public DatasourceTypeActionProperties input(List<DatasourceTypeProperty> input) {
        this.input = input;
        return this;
    }

    public DatasourceTypeActionProperties addInputItem(DatasourceTypeProperty inputItem) {
        if (this.input == null) {
            this.input = new ArrayList<>();
        }
        this.input.add(inputItem);
        return this;
    }

    /**
     * The input properties.
     * @return input
     **/
    @javax.annotation.Nullable
    @JsonProperty("input")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypeProperty> getInput() { return input; }
    public void setInput(List<DatasourceTypeProperty> input) { this.input = input; }

    public DatasourceTypeActionProperties output(List<DatasourceTypeProperty> output) {
        this.output = output;
        return this;
    }

    public DatasourceTypeActionProperties addOutputItem(DatasourceTypeProperty outputItem) {
        if (this.output == null) {
            this.output = new ArrayList<>();
        }
        this.output.add(outputItem);
        return this;
    }

    /**
     * The properties of the action result.
     * @return output
     **/
    @javax.annotation.Nullable
    @JsonProperty("output")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypeProperty> getOutput() { return output; }
    public void setOutput(List<DatasourceTypeProperty> output) { this.output = output; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypeActionProperties datasourceTypeActionProperties = (DatasourceTypeActionProperties)o;
        return Objects.equals(this.input, datasourceTypeActionProperties.input) &&
                Objects.equals(this.output, datasourceTypeActionProperties.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, output);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypeActionProperties {\n");
        sb.append("    input: ").append(toIndentedString(input)).append("\n");
        sb.append("    output: ").append(toIndentedString(output)).append("\n");
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
