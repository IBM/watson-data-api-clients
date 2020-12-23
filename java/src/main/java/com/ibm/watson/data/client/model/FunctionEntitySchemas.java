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
 * FunctionEntitySchemas
 */
public class FunctionEntitySchemas {

    private List<DataSchema> input = null;
    private List<DataSchema> output = null;

    public FunctionEntitySchemas input(List<DataSchema> input) {
        this.input = input;
        return this;
    }

    public FunctionEntitySchemas addInputItem(DataSchema inputItem) {
        if (this.input == null) {
            this.input = new ArrayList<>();
        }
        this.input.add(inputItem);
        return this;
    }

    /**
     * The schema of the expected data, see [datarecord-metadata-v2-schema](https://api.dataplatform.cloud.ibm.com/schemas/common-pipeline/datarecord-metadata/datarecord-metadata-v2-schema.json) for the schema definition.
     * @return input
     **/
    @javax.annotation.Nullable
    @JsonProperty("input")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DataSchema> getInput() { return input; }
    public void setInput(List<DataSchema> input) { this.input = input; }

    public FunctionEntitySchemas output(List<DataSchema> output) {
        this.output = output;
        return this;
    }

    public FunctionEntitySchemas addOutputItem(DataSchema outputItem) {
        if (this.output == null) {
            this.output = new ArrayList<>();
        }
        this.output.add(outputItem);
        return this;
    }

    /**
     * The schema of the expected data, see [datarecord-metadata-v2-schema](https://api.dataplatform.cloud.ibm.com/schemas/common-pipeline/datarecord-metadata/datarecord-metadata-v2-schema.json) for the schema definition.
     * @return output
     **/
    @javax.annotation.Nullable
    @JsonProperty("output")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DataSchema> getOutput() { return output; }
    public void setOutput(List<DataSchema> output) { this.output = output; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FunctionEntitySchemas functionEntitySchemas = (FunctionEntitySchemas) o;
        return Objects.equals(this.input, functionEntitySchemas.input) &&
                Objects.equals(this.output, functionEntitySchemas.output);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, output);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FunctionEntitySchemas {\n");
        sb.append("    input: ").append(toIndentedString(input)).append("\n");
        sb.append("    output: ").append(toIndentedString(output)).append("\n");
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
