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

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.watson.data.client.model.enums.DataSchemaFieldMeasure;
import com.ibm.watson.data.client.model.enums.DataSchemaFieldModelingRole;

/**
 * The definition of a field within the expected schema, see [datarecord-metadata-v2-schema](https://api.dataplatform.cloud.ibm.com/schemas/common-pipeline/datarecord-metadata/datarecord-metadata-v2-schema.json) for the schema definition.
 */
public class DataSchemaFieldMetadata {

    private String description;
    private DataSchemaFieldMeasure measure;
    private DataSchemaFieldModelingRole modelingRole;
    private Integer maxLength;
    private Integer decimalPrecision;
    private Integer decimalScale;
    private List<String> values;
    private DataSchemaFieldRange range;

    public DataSchemaFieldMetadata description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Field description
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public DataSchemaFieldMetadata measure(DataSchemaFieldMeasure measure) {
        this.measure = measure;
        return this;
    }

    /**
     * Field measurement level
     * @return measure
     **/
    @javax.annotation.Nullable
    @JsonProperty("measure")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataSchemaFieldMeasure getMeasure() { return measure; }
    public void setMeasure(DataSchemaFieldMeasure measure) { this.measure = measure; }

    public DataSchemaFieldMetadata modelingRole(DataSchemaFieldModelingRole modelingRole) {
        this.modelingRole = modelingRole;
        return this;
    }

    /**
     * Field role for modeling
     * @return modeling_role
     **/
    @javax.annotation.Nullable
    @JsonProperty("modeling_role")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataSchemaFieldModelingRole getModelingRole() { return modelingRole; }
    public void setModelingRole(DataSchemaFieldModelingRole modelingRole) { this.modelingRole = modelingRole; }

    public DataSchemaFieldMetadata maxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    /**
     * Maximum length for fields. Length is unlimited when not present.
     * @return max_length
     **/
    @javax.annotation.Nullable
    @JsonProperty("max_length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMaxLength() { return maxLength; }
    public void setMaxLength(Integer maxLength) { this.maxLength = maxLength; }

    public DataSchemaFieldMetadata decimalPrecision(Integer decimalPrecision) {
        this.decimalPrecision = decimalPrecision;
        return this;
    }

    /**
     * Precision for decimal types
     * @return decimal_precision
     **/
    @javax.annotation.Nullable
    @JsonProperty("decimal_precision")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getDecimalPrecision() { return decimalPrecision; }
    public void setDecimalPrecision(Integer decimalPrecision) { this.decimalPrecision = decimalPrecision; }

    public DataSchemaFieldMetadata decimalScale(Integer decimalScale) {
        this.decimalScale = decimalScale;
        return this;
    }

    /**
     * Scale for decimal types
     * @return decimal_scale
     **/
    @javax.annotation.Nullable
    @JsonProperty("decimal_scale")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getDecimalScale() { return decimalScale; }
    public void setDecimalScale(Integer decimalScale) { this.decimalScale = decimalScale; }

    public DataSchemaFieldMetadata values(List<String> values) {
        this.values = values;
        return this;
    }

    /**
     * Array of unique categorical values for the column
     * @return values
     **/
    @javax.annotation.Nullable
    @JsonProperty("values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getValues() { return values; }
    public void setValues(List<String> values) { this.values = values; }

    public DataSchemaFieldMetadata range(DataSchemaFieldRange range) {
        this.range = range;
        return this;
    }

    /**
     * Minimum and maximum discovered values for scalar data
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("range")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataSchemaFieldRange getRange() { return range; }
    public void setRange(DataSchemaFieldRange range) { this.range = range; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataSchemaFieldMetadata that = (DataSchemaFieldMetadata) o;
        return Objects.equals(this.description, that.description) &&
                Objects.equals(this.measure, that.measure) &&
                Objects.equals(this.modelingRole, that.modelingRole) &&
                Objects.equals(this.maxLength, that.maxLength) &&
                Objects.equals(this.decimalPrecision, that.decimalPrecision) &&
                Objects.equals(this.decimalScale, that.decimalScale) &&
                Objects.equals(this.values, that.values) &&
                Objects.equals(this.range, that.range);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, measure, modelingRole, maxLength, decimalPrecision, decimalScale, values, range);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataSchemaFieldMetadata {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    measure: ").append(toIndentedString(measure)).append("\n");
        sb.append("    modelingRole: ").append(toIndentedString(modelingRole)).append("\n");
        sb.append("    maxLength: ").append(toIndentedString(maxLength)).append("\n");
        sb.append("    decimalPrecision: ").append(toIndentedString(decimalPrecision)).append("\n");
        sb.append("    decimalScale: ").append(toIndentedString(decimalScale)).append("\n");
        sb.append("    values: ").append(toIndentedString(values)).append("\n");
        sb.append("    range: ").append(toIndentedString(range)).append("\n");
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
