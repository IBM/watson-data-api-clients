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
 * RDVImportInfo
 */
public class RDVImportInfo {

    private String href;
    private String importId;
    private String importState;
    private String importMessage;
    private Long valuesCount;
    private Long valuesProcessed;
    private Long valuesSkipped;
    private Long valuesInserted;
    private List<Long> skippedRowIndex = null;
    private List<Warnings> warnings = null;

    public RDVImportInfo href(String href) {
        this.href = href;
        return this;
    }

    /**
     * Get href
     * @return href
     **/
    @javax.annotation.Nullable
    @JsonProperty("href")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHref() { return href; }
    public void setHref(String href) { this.href = href; }

    public RDVImportInfo importId(String importId) {
        this.importId = importId;
        return this;
    }

    /**
     * import id for the reference data values import process.
     * @return importId
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getImportId() { return importId; }
    public void setImportId(String importId) { this.importId = importId; }

    public RDVImportInfo importState(String importState) {
        this.importState = importState;
        return this;
    }

    /**
     * Current State of the Import.
     * @return importState
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getImportState() { return importState; }
    public void setImportState(String importState) { this.importState = importState; }

    public RDVImportInfo importMessage(String importMessage) {
        this.importMessage = importMessage;
        return this;
    }

    /**
     * Additional message about the current State of the Import.
     * @return importMessage
     **/
    @javax.annotation.Nullable
    @JsonProperty("import_message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getImportMessage() { return importMessage; }
    public void setImportMessage(String importMessage) { this.importMessage = importMessage; }

    public RDVImportInfo valuesCount(Long valuesCount) {
        this.valuesCount = valuesCount;
        return this;
    }

    /**
     * Total count of values.
     * @return valuesCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("values_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getValuesCount() { return valuesCount; }
    public void setValuesCount(Long valuesCount) { this.valuesCount = valuesCount; }

    public RDVImportInfo valuesProcessed(Long valuesProcessed) {
        this.valuesProcessed = valuesProcessed;
        return this;
    }

    /**
     * Total count of values processed.
     * @return valuesProcessed
     **/
    @javax.annotation.Nullable
    @JsonProperty("values_processed")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getValuesProcessed() { return valuesProcessed; }
    public void setValuesProcessed(Long valuesProcessed) { this.valuesProcessed = valuesProcessed; }

    public RDVImportInfo valuesSkipped(Long valuesSkipped) {
        this.valuesSkipped = valuesSkipped;
        return this;
    }

    /**
     * Total count of values skipped.
     * @return valuesSkipped
     **/
    @javax.annotation.Nullable
    @JsonProperty("values_skipped")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getValuesSkipped() { return valuesSkipped; }
    public void setValuesSkipped(Long valuesSkipped) { this.valuesSkipped = valuesSkipped; }

    public RDVImportInfo valuesInserted(Long valuesInserted) {
        this.valuesInserted = valuesInserted;
        return this;
    }

    /**
     * Total count of values inserted.
     * @return valuesInserted
     **/
    @javax.annotation.Nullable
    @JsonProperty("values_inserted")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getValuesInserted() { return valuesInserted; }
    public void setValuesInserted(Long valuesInserted) { this.valuesInserted = valuesInserted; }

    public RDVImportInfo skippedRowIndex(List<Long> skippedRowIndex) {
        this.skippedRowIndex = skippedRowIndex;
        return this;
    }

    public RDVImportInfo addSkippedRowIndexItem(Long skippedRowIndexItem) {
        if (this.skippedRowIndex == null) {
            this.skippedRowIndex = new ArrayList<>();
        }
        this.skippedRowIndex.add(skippedRowIndexItem);
        return this;
    }

    /**
     * Skipped rows indexes.
     * @return skippedRowIndex
     **/
    @javax.annotation.Nullable
    @JsonProperty("skipped_row_index")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Long> getSkippedRowIndex() { return skippedRowIndex; }
    public void setSkippedRowIndex(List<Long> skippedRowIndex) { this.skippedRowIndex = skippedRowIndex; }

    public RDVImportInfo warnings(List<Warnings> warnings) {
        this.warnings = warnings;
        return this;
    }

    public RDVImportInfo addWarningsItem(Warnings warningsItem) {
        if (this.warnings == null) {
            this.warnings = new ArrayList<>();
        }
        this.warnings.add(warningsItem);
        return this;
    }

    /**
     * Warnings.
     * @return warnings
     **/
    @javax.annotation.Nullable
    @JsonProperty("warnings")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Warnings> getWarnings() { return warnings; }
    public void setWarnings(List<Warnings> warnings) { this.warnings = warnings; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RDVImportInfo rdVImportInfo = (RDVImportInfo)o;
        return Objects.equals(this.href, rdVImportInfo.href) &&
                Objects.equals(this.importId, rdVImportInfo.importId) &&
                Objects.equals(this.importState, rdVImportInfo.importState) &&
                Objects.equals(this.importMessage, rdVImportInfo.importMessage) &&
                Objects.equals(this.valuesCount, rdVImportInfo.valuesCount) &&
                Objects.equals(this.valuesProcessed, rdVImportInfo.valuesProcessed) &&
                Objects.equals(this.valuesSkipped, rdVImportInfo.valuesSkipped) &&
                Objects.equals(this.valuesInserted, rdVImportInfo.valuesInserted) &&
                Objects.equals(this.skippedRowIndex, rdVImportInfo.skippedRowIndex) &&
                Objects.equals(this.warnings, rdVImportInfo.warnings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, importId, importState, importMessage, valuesCount,
                valuesProcessed, valuesSkipped, valuesInserted,
                skippedRowIndex, warnings);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RDVImportInfo {\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    importId: ").append(toIndentedString(importId)).append("\n");
        sb.append("    importState: ").append(toIndentedString(importState)).append("\n");
        sb.append("    importMessage: ").append(toIndentedString(importMessage)).append("\n");
        sb.append("    valuesCount: ").append(toIndentedString(valuesCount)).append("\n");
        sb.append("    valuesProcessed: ").append(toIndentedString(valuesProcessed)).append("\n");
        sb.append("    valuesSkipped: ").append(toIndentedString(valuesSkipped)).append("\n");
        sb.append("    valuesInserted: ").append(toIndentedString(valuesInserted)).append("\n");
        sb.append("    skippedRowIndex: ").append(toIndentedString(skippedRowIndex)).append("\n");
        sb.append("    warnings: ").append(toIndentedString(warnings)).append("\n");
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
