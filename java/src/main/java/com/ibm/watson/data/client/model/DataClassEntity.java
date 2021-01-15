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
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DataClassEntity
 */
public class DataClassEntity {

    private String longDescription;
    private GlossaryObjectState state;
    private List<CustomAttribute> customAttributes = null;
    private String classCode;
    private String provider;
    private String dataClassType;
    private String example;
    private Float priority;
    private Integer threshold;
    private Boolean enabled;
    private List<String> dataType = null;
    private Integer minimumDataLength;
    private Integer maximumDataLength;
    private String columnNameMatch;
    private String script;
    private String scope;
    private String language;
    private String properties;
    private String javaClassName;
    private List<String> validValues = null;
    private Boolean caseSensitive;
    private Boolean allowSubstringMatch;
    private Boolean squeezeConsecutiveWhiteSpaces;
    private String validValueReferenceFile;
    private String regularExpression;
    private String applicableFor;
    private String additionalRegularExpression;
    private String additionalApplicableFor;
    private String referenceColumnsMetadata;
    private String expression;

    public DataClassEntity longDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    /**
     * The long description of an artifact.
     * @return longDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("long_description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLongDescription() { return longDescription; }
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public DataClassEntity state(GlossaryObjectState state) {
        this.state = state;
        return this;
    }

    /**
     * The state of an artifact, such as DRAFT, ACTIVE or ARCHIVED.
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public GlossaryObjectState getState() { return state; }
    public void setState(GlossaryObjectState state) { this.state = state; }

    public DataClassEntity customAttributes(List<CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public DataClassEntity addCustomAttributesItem(CustomAttribute customAttributesItem) {
        if (this.customAttributes == null) {
            this.customAttributes = new ArrayList<>();
        }
        this.customAttributes.add(customAttributesItem);
        return this;
    }

    /**
     * List of custom attributes with their values.
     * @return customAttributes
     **/
    @javax.annotation.Nullable
    @JsonProperty("custom_attributes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CustomAttribute> getCustomAttributes() { return customAttributes; }
    public void setCustomAttributes(List<CustomAttribute> customAttributes) { this.customAttributes = customAttributes; }

    public DataClassEntity classCode(String classCode) {
        this.classCode = classCode;
        return this;
    }

    /**
     * Unique class code given to the data class.
     * @return classCode
     **/
    @javax.annotation.Nullable
    @JsonProperty("class_code")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getClassCode() { return classCode; }
    public void setClassCode(String classCode) { this.classCode = classCode; }

    public DataClassEntity provider(String provider) {
        this.provider = provider;
        return this;
    }

    /**
     * The provider of data class
     * @return provider
     **/
    @javax.annotation.Nullable
    @JsonProperty("provider")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public DataClassEntity dataClassType(String dataClassType) {
        this.dataClassType = dataClassType;
        return this;
    }

    /**
     * To specify the type of data class: ColumnSimilarity, Java,
     * ReferenceDataSet, Regex, Script, Undefined, UnstructuredFilter, ValidValues
     * @return dataClassType
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_class_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDataClassType() { return dataClassType; }
    public void setDataClassType(String dataClassType) { this.dataClassType = dataClassType; }

    public DataClassEntity example(String example) {
        this.example = example;
        return this;
    }

    /**
     * Data class example
     * @return example
     **/
    @javax.annotation.Nullable
    @JsonProperty("example")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getExample() { return example; }
    public void setExample(String example) { this.example = example; }

    public DataClassEntity priority(Float priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Data class priority used while profiling.
     * @return priority
     **/
    @javax.annotation.Nullable
    @JsonProperty("priority")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Float getPriority() { return priority; }
    public void setPriority(Float priority) { this.priority = priority; }

    public DataClassEntity threshold(Integer threshold) {
        this.threshold = threshold;
        return this;
    }

    /**
     * The percentage of threshold.
     * @return threshold
     **/
    @javax.annotation.Nullable
    @JsonProperty("threshold")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getThreshold() { return threshold; }
    public void setThreshold(Integer threshold) { this.threshold = threshold; }

    public DataClassEntity enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * This flag indicates whether the data class can be used for data profiling
     * or not.
     * @return enabled
     **/
    @javax.annotation.Nullable
    @JsonProperty("enabled")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }

    public DataClassEntity dataType(List<String> dataType) {
        this.dataType = dataType;
        return this;
    }

    public DataClassEntity addDataTypeItem(String dataTypeItem) {
        if (this.dataType == null) {
            this.dataType = new ArrayList<>();
        }
        this.dataType.add(dataTypeItem);
        return this;
    }

    /**
     * DataType: numeric, string, date, time, timestamp
     * @return dataType
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getDataType() { return dataType; }
    public void setDataType(List<String> dataType) { this.dataType = dataType; }

    public DataClassEntity minimumDataLength(Integer minimumDataLength) {
        this.minimumDataLength = minimumDataLength;
        return this;
    }

    /**
     * To specify minimum data length
     * @return minimumDataLength
     **/
    @javax.annotation.Nullable
    @JsonProperty("minimum_data_length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMinimumDataLength() { return minimumDataLength; }
    public void setMinimumDataLength(Integer minimumDataLength) { this.minimumDataLength = minimumDataLength; }

    public DataClassEntity maximumDataLength(Integer maximumDataLength) {
        this.maximumDataLength = maximumDataLength;
        return this;
    }

    /**
     * To specify maximum data length
     * @return maximumDataLength
     **/
    @javax.annotation.Nullable
    @JsonProperty("maximum_data_length")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMaximumDataLength() { return maximumDataLength; }
    public void setMaximumDataLength(Integer maximumDataLength) { this.maximumDataLength = maximumDataLength; }

    public DataClassEntity columnNameMatch(String columnNameMatch) {
        this.columnNameMatch = columnNameMatch;
        return this;
    }

    /**
     * To specify column name match
     * @return columnNameMatch
     **/
    @javax.annotation.Nullable
    @JsonProperty("column_name_match")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getColumnNameMatch() { return columnNameMatch; }
    public void setColumnNameMatch(String columnNameMatch) { this.columnNameMatch = columnNameMatch; }

    public DataClassEntity script(String script) {
        this.script = script;
        return this;
    }

    /**
     * To specify script name; ( This property is applicable for data class type:
     * Script )
     * @return script
     **/
    @javax.annotation.Nullable
    @JsonProperty("script")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getScript() { return script; }
    public void setScript(String script) { this.script = script; }

    public DataClassEntity scope(String scope) {
        this.scope = scope;
        return this;
    }

    /**
     * To specify scope: value, column, dataset_columns, dataset; ( This property
     * is applicable for data class types: Script &amp; Java )
     * @return scope
     **/
    @javax.annotation.Nullable
    @JsonProperty("scope")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getScope() { return scope; }
    public void setScope(String scope) { this.scope = scope; }

    public DataClassEntity language(String language) {
        this.language = language;
        return this;
    }

    /**
     * To specify language: JavaScript, DataRule; ( This property is applicable
     * for data class type: Script )
     * @return language
     **/
    @javax.annotation.Nullable
    @JsonProperty("language")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    public DataClassEntity properties(String properties) {
        this.properties = properties;
        return this;
    }

    /**
     * To specify properties; ( This property is applicable for data class type:
     * Java )
     * @return properties
     **/
    @javax.annotation.Nullable
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProperties() { return properties; }
    public void setProperties(String properties) { this.properties = properties; }

    public DataClassEntity javaClassName(String javaClassName) {
        this.javaClassName = javaClassName;
        return this;
    }

    /**
     * To specify Java class name; ( This property is applicable for data class
     * type: Java )
     * @return javaClassName
     **/
    @javax.annotation.Nullable
    @JsonProperty("java_class_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getJavaClassName() { return javaClassName; }
    public void setJavaClassName(String javaClassName) { this.javaClassName = javaClassName; }

    public DataClassEntity validValues(List<String> validValues) {
        this.validValues = validValues;
        return this;
    }

    public DataClassEntity addValidValuesItem(String validValuesItem) {
        if (this.validValues == null) {
            this.validValues = new ArrayList<>();
        }
        this.validValues.add(validValuesItem);
        return this;
    }

    /**
     * To specify valid values; ( This property is applicable for data class type:
     * ValidValues )
     * @return validValues
     **/
    @javax.annotation.Nullable
    @JsonProperty("valid_values")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getValidValues() { return validValues; }
    public void setValidValues(List<String> validValues) { this.validValues = validValues; }

    public DataClassEntity caseSensitive(Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }

    /**
     * To specify case sensitive boolean flag; ( This property is applicable for
     * data class type: ValidValues )
     * @return caseSensitive
     **/
    @javax.annotation.Nullable
    @JsonProperty("case_sensitive")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getCaseSensitive() { return caseSensitive; }
    public void setCaseSensitive(Boolean caseSensitive) { this.caseSensitive = caseSensitive; }

    public DataClassEntity allowSubstringMatch(Boolean allowSubstringMatch) {
        this.allowSubstringMatch = allowSubstringMatch;
        return this;
    }

    /**
     * To specify allow substring match boolean flag; ( This property is
     * applicable for data class type: ValidValues )
     * @return allowSubstringMatch
     **/
    @javax.annotation.Nullable
    @JsonProperty("allow_substring_match")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAllowSubstringMatch() { return allowSubstringMatch; }
    public void setAllowSubstringMatch(Boolean allowSubstringMatch) { this.allowSubstringMatch = allowSubstringMatch; }

    public DataClassEntity squeezeConsecutiveWhiteSpaces(Boolean squeezeConsecutiveWhiteSpaces) {
        this.squeezeConsecutiveWhiteSpaces = squeezeConsecutiveWhiteSpaces;
        return this;
    }

    /**
     * To specify squeeze consecutive white spaces boolean flag; ( This property
     * is applicable for data class type: ValidValues )
     * @return squeezeConsecutiveWhiteSpaces
     **/
    @javax.annotation.Nullable
    @JsonProperty("squeeze_consecutive_white_spaces")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getSqueezeConsecutiveWhiteSpaces() { return squeezeConsecutiveWhiteSpaces; }
    public void setSqueezeConsecutiveWhiteSpaces(Boolean squeezeConsecutiveWhiteSpaces) { this.squeezeConsecutiveWhiteSpaces = squeezeConsecutiveWhiteSpaces; }

    public DataClassEntity validValueReferenceFile(String validValueReferenceFile) {
        this.validValueReferenceFile = validValueReferenceFile;
        return this;
    }

    /**
     * To specify valid value reference file path; ( This property is applicable
     * for data class type: ValidValues )
     * @return validValueReferenceFile
     **/
    @javax.annotation.Nullable
    @JsonProperty("valid_value_reference_file")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getValidValueReferenceFile() { return validValueReferenceFile; }
    public void setValidValueReferenceFile(String validValueReferenceFile) { this.validValueReferenceFile = validValueReferenceFile; }

    public DataClassEntity regularExpression(String regularExpression) {
        this.regularExpression = regularExpression;
        return this;
    }

    /**
     * To specify regular expression; ( This property is applicable for data class
     * type: Regex )
     * @return regularExpression
     **/
    @javax.annotation.Nullable
    @JsonProperty("regular_expression")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRegularExpression() { return regularExpression; }
    public void setRegularExpression(String regularExpression) { this.regularExpression = regularExpression; }

    public DataClassEntity applicableFor(String applicableFor) {
        this.applicableFor = applicableFor;
        return this;
    }

    /**
     * To specify applicable for: structured_data_only, unstructured_data_only,
     * all_data; ( This property is applicable for data class type: Regex )
     * @return applicableFor
     **/
    @javax.annotation.Nullable
    @JsonProperty("applicable_for")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getApplicableFor() { return applicableFor; }
    public void setApplicableFor(String applicableFor) { this.applicableFor = applicableFor; }

    public DataClassEntity additionalRegularExpression(String additionalRegularExpression) {
        this.additionalRegularExpression = additionalRegularExpression;
        return this;
    }

    /**
     * To specify additional regular expression; ( This property is applicable for
     * data class type: Regex )
     * @return additionalRegularExpression
     **/
    @javax.annotation.Nullable
    @JsonProperty("additional_regular_expression")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAdditionalRegularExpression() { return additionalRegularExpression; }
    public void setAdditionalRegularExpression(String additionalRegularExpression) { this.additionalRegularExpression = additionalRegularExpression; }

    public DataClassEntity additionalApplicableFor(String additionalApplicableFor) {
        this.additionalApplicableFor = additionalApplicableFor;
        return this;
    }

    /**
     * To specify additional applicable for: structured_data_only,
     * unstructured_data_only, all_data; ( This property is applicable for data
     * class type: Regex )
     * @return additionalApplicableFor
     **/
    @javax.annotation.Nullable
    @JsonProperty("additional_applicable_for")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAdditionalApplicableFor() { return additionalApplicableFor; }
    public void setAdditionalApplicableFor(String additionalApplicableFor) { this.additionalApplicableFor = additionalApplicableFor; }

    public DataClassEntity referenceColumnsMetadata(String referenceColumnsMetadata) {
        this.referenceColumnsMetadata = referenceColumnsMetadata;
        return this;
    }

    /**
     * To specify reference columns metadata; ( This property is applicable for
     *data class type: ColumnSimilarity )
     * @return referenceColumnsMetadata
     **/
    @javax.annotation.Nullable
    @JsonProperty("reference_columns_metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getReferenceColumnsMetadata() { return referenceColumnsMetadata; }
    public void setReferenceColumnsMetadata(String referenceColumnsMetadata) { this.referenceColumnsMetadata = referenceColumnsMetadata; }

    public DataClassEntity expression(String expression) {
        this.expression = expression;
        return this;
    }

    /**
     * To specify expression; ( This property is applicable for data class type:
     * UnstructuredFilter )
     * @return expression
     **/
    @javax.annotation.Nullable
    @JsonProperty("expression")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getExpression() { return expression; }
    public void setExpression(String expression) { this.expression = expression; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataClassEntity that = (DataClassEntity)o;
        return Objects.equals(this.longDescription, that.longDescription) &&
                Objects.equals(this.state, that.state) &&
                Objects.equals(this.customAttributes, that.customAttributes) &&
                Objects.equals(this.classCode, that.classCode) &&
                Objects.equals(this.provider, that.provider) &&
                Objects.equals(this.dataClassType, that.dataClassType) &&
                Objects.equals(this.example, that.example) &&
                Objects.equals(this.priority, that.priority) &&
                Objects.equals(this.threshold, that.threshold) &&
                Objects.equals(this.enabled, that.enabled) &&
                Objects.equals(this.dataType, that.dataType) &&
                Objects.equals(this.minimumDataLength, that.minimumDataLength) &&
                Objects.equals(this.maximumDataLength, that.maximumDataLength) &&
                Objects.equals(this.columnNameMatch, that.columnNameMatch) &&
                Objects.equals(this.script, that.script) &&
                Objects.equals(this.scope, that.scope) &&
                Objects.equals(this.language, that.language) &&
                Objects.equals(this.properties, that.properties) &&
                Objects.equals(this.javaClassName, that.javaClassName) &&
                Objects.equals(this.validValues, that.validValues) &&
                Objects.equals(this.caseSensitive, that.caseSensitive) &&
                Objects.equals(this.allowSubstringMatch, that.allowSubstringMatch) &&
                Objects.equals(this.squeezeConsecutiveWhiteSpaces, that.squeezeConsecutiveWhiteSpaces) &&
                Objects.equals(this.validValueReferenceFile, that.validValueReferenceFile) &&
                Objects.equals(this.regularExpression, that.regularExpression) &&
                Objects.equals(this.applicableFor, that.applicableFor) &&
                Objects.equals(this.additionalRegularExpression, that.additionalRegularExpression) &&
                Objects.equals(this.additionalApplicableFor, that.additionalApplicableFor) &&
                Objects.equals(this.referenceColumnsMetadata, that.referenceColumnsMetadata) &&
                Objects.equals(this.expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                longDescription, state,
                customAttributes, classCode, provider, dataClassType, example, priority,
                threshold, enabled, dataType, minimumDataLength, maximumDataLength,
                columnNameMatch, script, scope, language, properties, javaClassName,
                validValues, caseSensitive, allowSubstringMatch,
                squeezeConsecutiveWhiteSpaces, validValueReferenceFile,
                regularExpression, applicableFor, additionalRegularExpression,
                additionalApplicableFor, referenceColumnsMetadata, expression);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataClassEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    longDescription: ").append(toIndentedString(longDescription)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
        sb.append("    classCode: ").append(toIndentedString(classCode)).append("\n");
        sb.append("    provider: ").append(toIndentedString(provider)).append("\n");
        sb.append("    dataClassType: ").append(toIndentedString(dataClassType)).append("\n");
        sb.append("    example: ").append(toIndentedString(example)).append("\n");
        sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
        sb.append("    threshold: ").append(toIndentedString(threshold)).append("\n");
        sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
        sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
        sb.append("    minimumDataLength: ").append(toIndentedString(minimumDataLength)).append("\n");
        sb.append("    maximumDataLength: ").append(toIndentedString(maximumDataLength)).append("\n");
        sb.append("    columnNameMatch: ").append(toIndentedString(columnNameMatch)).append("\n");
        sb.append("    script: ").append(toIndentedString(script)).append("\n");
        sb.append("    scope: ").append(toIndentedString(scope)).append("\n");
        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    javaClassName: ").append(toIndentedString(javaClassName)).append("\n");
        sb.append("    validValues: ").append(toIndentedString(validValues)).append("\n");
        sb.append("    caseSensitive: ").append(toIndentedString(caseSensitive)).append("\n");
        sb.append("    allowSubstringMatch: ").append(toIndentedString(allowSubstringMatch)).append("\n");
        sb.append("    squeezeConsecutiveWhiteSpaces: ").append(toIndentedString(squeezeConsecutiveWhiteSpaces)).append("\n");
        sb.append("    validValueReferenceFile: ").append(toIndentedString(validValueReferenceFile)).append("\n");
        sb.append("    regularExpression: ").append(toIndentedString(regularExpression)).append("\n");
        sb.append("    applicableFor: ").append(toIndentedString(applicableFor)).append("\n");
        sb.append("    additionalRegularExpression: ").append(toIndentedString(additionalRegularExpression)).append("\n");
        sb.append("    additionalApplicableFor: ").append(toIndentedString(additionalApplicableFor)).append("\n");
        sb.append("    referenceColumnsMetadata: ").append(toIndentedString(referenceColumnsMetadata)).append("\n");
        sb.append("    expression: ").append(toIndentedString(expression)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
