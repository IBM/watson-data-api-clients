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

import java.util.List;
import java.util.Objects;

/**
 * DataProfileSummary
 */
public class DataProfileSummary extends AnalysisSummary {

    private String version;
    private Long rowCount;
    private List<ValueCount> typeDistribution;
    private List<ValueCount> logicalTypeDistribution;
    private List<CodeCount> classDistribution;
    private List<Object> dataprofileClassification;

    @javax.annotation.Nullable
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    @javax.annotation.Nullable
    @JsonProperty("row_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getRowCount() { return rowCount; }
    public void setRowCount(Long rowCount) { this.rowCount = rowCount; }

    @javax.annotation.Nullable
    @JsonProperty("type_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ValueCount> getTypeDistribution() { return typeDistribution; }
    public void setTypeDistribution(List<ValueCount> typeDistribution) { this.typeDistribution = typeDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("logical_type_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ValueCount> getLogicalTypeDistribution() { return logicalTypeDistribution; }
    public void setLogicalTypeDistribution(List<ValueCount> logicalTypeDistribution) { this.logicalTypeDistribution = logicalTypeDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("class_distribution")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CodeCount> getClassDistribution() { return classDistribution; }
    public void setClassDistribution(List<CodeCount> classDistribution) { this.classDistribution = classDistribution; }

    @javax.annotation.Nullable
    @JsonProperty("dataprofile_classification")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getDataprofileClassification() { return dataprofileClassification; }
    public void setDataprofileClassification(List<Object> dataprofileClassification) { this.dataprofileClassification = dataprofileClassification; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataProfileSummary that = (DataProfileSummary) o;
        return super.equals(o) &&
                Objects.equals(version, that.version) &&
                Objects.equals(rowCount, that.rowCount) &&
                Objects.equals(typeDistribution, that.typeDistribution) &&
                Objects.equals(logicalTypeDistribution, that.logicalTypeDistribution) &&
                Objects.equals(classDistribution, that.classDistribution) &&
                Objects.equals(dataprofileClassification, that.dataprofileClassification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), version, rowCount,
                typeDistribution, logicalTypeDistribution, classDistribution, dataprofileClassification);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataProfileSummary {\n");
        super.toString(sb);
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    rowCount: ").append(toIndentedString(rowCount)).append("\n");
        sb.append("    typeDistribution: ").append(toIndentedString(typeDistribution)).append("\n");
        sb.append("    logicalTypeDistribution: ").append(toIndentedString(logicalTypeDistribution)).append("\n");
        sb.append("    classDistribution: ").append(toIndentedString(classDistribution)).append("\n");
        sb.append("    dataprofileClassification: ").append(toIndentedString(dataprofileClassification)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
