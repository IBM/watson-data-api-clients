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

/**
 * The definition of a range of values for a field within the expected schema, see [datarecord-metadata-v2-schema](https://api.dataplatform.cloud.ibm.com/schemas/common-pipeline/datarecord-metadata/datarecord-metadata-v2-schema.json) for the schema definition.
 */
public class DataSchemaFieldRange {

    private Double min;
    private Double max;

    public DataSchemaFieldRange min(Double min) {
        this.min = min;
        return this;
    }

    /**
     * Lowest value discovered in the data
     * @return min
     **/
    @JsonProperty("min")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Double getMin() { return min; }
    public void setMin(Double min) { this.min = min; }

    public DataSchemaFieldRange max(Double max) {
        this.max = max;
        return this;
    }

    /**
     * Highest value discovered in the data
     * @return max
     **/
    @JsonProperty("max")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Double getMax() { return max; }
    public void setMax(Double max) { this.max = max; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataSchemaFieldRange that = (DataSchemaFieldRange) o;
        return Objects.equals(this.min, that.min) &&
                Objects.equals(this.max, that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataSchemaFieldRange {\n");
        sb.append("    min: ").append(toIndentedString(min)).append("\n");
        sb.append("    max: ").append(toIndentedString(max)).append("\n");
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
