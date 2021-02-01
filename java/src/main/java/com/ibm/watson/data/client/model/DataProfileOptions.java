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

import java.util.*;

/**
 * DataProfileOptions
 */
public class DataProfileOptions {

    private Boolean disableProfiling;
    private Double maxRowCount;
    private Double maxDistributionSize;
    private Double maxNumericStatsBins;
    private Double maxColumnsPerTask;
    private Double maxRowsPerBatch;
    private Boolean enableFastClassification;
    private Boolean enableDqa;
    private ClassificationOptions classificationOptions;

    @javax.annotation.Nullable
    @JsonProperty("disable_profiling")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getDisableProfiling() { return disableProfiling; }
    public void setDisableProfiling(Boolean disableProfiling) { this.disableProfiling = disableProfiling; }

    @javax.annotation.Nullable
    @JsonProperty("max_row_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMaxRowCount() { return maxRowCount; }
    public void setMaxRowCount(Double maxRowCount) { this.maxRowCount = maxRowCount; }

    @javax.annotation.Nullable
    @JsonProperty("max_distribution_size")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMaxDistributionSize() { return maxDistributionSize; }
    public void setMaxDistributionSize(Double maxDistributionSize) { this.maxDistributionSize = maxDistributionSize; }

    @javax.annotation.Nullable
    @JsonProperty("max_numeric_stats_bins")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMaxNumericStatsBins() { return maxNumericStatsBins; }
    public void setMaxNumericStatsBins(Double maxNumericStatsBins) { this.maxNumericStatsBins = maxNumericStatsBins; }

    @javax.annotation.Nullable
    @JsonProperty("max_columns_per_task")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMaxColumnsPerTask() { return maxColumnsPerTask; }
    public void setMaxColumnsPerTask(Double maxColumnsPerTask) { this.maxColumnsPerTask = maxColumnsPerTask; }

    @javax.annotation.Nullable
    @JsonProperty("max_rows_per_batch")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getMaxRowsPerBatch() { return maxRowsPerBatch; }
    public void setMaxRowsPerBatch(Double maxRowsPerBatch) { this.maxRowsPerBatch = maxRowsPerBatch; }

    @javax.annotation.Nullable
    @JsonProperty("enable_fast_classification")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getEnableFastClassification() { return enableFastClassification; }
    public void setEnableFastClassification(Boolean enableFastClassification) { this.enableFastClassification = enableFastClassification; }

    @javax.annotation.Nullable
    @JsonProperty("enable_dqa")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getEnableDqa() { return enableDqa; }
    public void setEnableDqa(Boolean enableDqa) { this.enableDqa = enableDqa; }

    @javax.annotation.Nullable
    @JsonProperty("classification_options")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ClassificationOptions getClassificationOptions() { return classificationOptions; }
    public void setClassificationOptions(ClassificationOptions classificationOptions) { this.classificationOptions = classificationOptions; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataProfileOptions that = (DataProfileOptions)o;
        return Objects.equals(this.disableProfiling, that.disableProfiling) &&
                Objects.equals(this.maxRowCount, that.maxRowCount) &&
                Objects.equals(this.maxDistributionSize, that.maxDistributionSize) &&
                Objects.equals(this.maxNumericStatsBins, that.maxNumericStatsBins) &&
                Objects.equals(this.maxColumnsPerTask, that.maxColumnsPerTask) &&
                Objects.equals(this.maxRowsPerBatch, that.maxRowsPerBatch) &&
                Objects.equals(this.enableFastClassification, that.enableFastClassification) &&
                Objects.equals(this.enableDqa, that.enableDqa) &&
                Objects.equals(this.classificationOptions, that.classificationOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disableProfiling, maxRowCount, maxDistributionSize, maxNumericStatsBins, maxColumnsPerTask, maxRowsPerBatch, enableFastClassification, enableDqa, classificationOptions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataProfileOptions {\n");
        sb.append("    disableProfiling: ").append(toIndentedString(disableProfiling)).append("\n");
        sb.append("    maxRowCount: ").append(toIndentedString(maxRowCount)).append("\n");
        sb.append("    maxDistributionSize: ").append(toIndentedString(maxDistributionSize)).append("\n");
        sb.append("    maxNumericStatsBins: ").append(toIndentedString(maxNumericStatsBins)).append("\n");
        sb.append("    maxColumnsPerTask: ").append(toIndentedString(maxColumnsPerTask)).append("\n");
        sb.append("    maxRowsPerBatch: ").append(toIndentedString(maxRowsPerBatch)).append("\n");
        sb.append("    enableFastClassification: ").append(toIndentedString(enableFastClassification)).append("\n");
        sb.append("    enableDqa: ").append(toIndentedString(enableDqa)).append("\n");
        sb.append("    classificationOptions: ").append(toIndentedString(classificationOptions)).append("\n");
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
