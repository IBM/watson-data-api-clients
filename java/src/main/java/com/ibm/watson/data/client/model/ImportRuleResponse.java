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
 * Response for the /v2/policy_rules/export API and /v3/enforcement/rules/import
 */
public class ImportRuleResponse {

    private List<ImportedRule> importedList = new ArrayList<>();
    private List<FailedRule> failed = new ArrayList<>();

    public ImportRuleResponse importedList(List<ImportedRule> importedList) {
        this.importedList = importedList;
        return this;
    }

    public ImportRuleResponse addImportedListItem(ImportedRule importedListItem) {
        this.importedList.add(importedListItem);
        return this;
    }

    /**
     * List containing details of rules that are successfully imported.
     * @return imported
     **/
    @javax.annotation.Nullable
    @JsonProperty("importedList")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ImportedRule> getImportedList() { return importedList; }
    public void setImportedList(List<ImportedRule> importedList) { this.importedList = importedList; }

    public ImportRuleResponse failed(List<FailedRule> failed) {
        this.failed = failed;
        return this;
    }

    public ImportRuleResponse addFailedItem(FailedRule failedItem) {
        this.failed.add(failedItem);
        return this;
    }

    /**
     * List containing details of rules that are failed to import.
     * @return failed
     **/
    @javax.annotation.Nullable
    @JsonProperty("failed")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<FailedRule> getFailed() { return failed; }
    public void setFailed(List<FailedRule> failed) { this.failed = failed; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ImportRuleResponse importRuleResponse = (ImportRuleResponse)o;
        return Objects.equals(this.importedList, importRuleResponse.importedList) &&
                Objects.equals(this.failed, importRuleResponse.failed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(importedList, failed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImportRuleResponse {\n");
        sb.append("    importedList: ").append(toIndentedString(importedList)).append("\n");
        sb.append("    failed: ").append(toIndentedString(failed)).append("\n");
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
