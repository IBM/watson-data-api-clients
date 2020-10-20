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
 * DataProtectionRuleExportFile
 */
public class DataProtectionRuleExportFile {

    private String version;
    private String creator;
    private String tenantId;
    private String date;
    private Integer offset;
    private Long totalCount;
    private List<ExportedDataProtectionRule> rules;

    public DataProtectionRuleExportFile version(String version) {
        this.version = version;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public DataProtectionRuleExportFile creator(String creator) {
        this.creator = creator;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("creator")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreator() { return creator; }
    public void setCreator(String creator) { this.creator = creator; }

    public DataProtectionRuleExportFile tenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("tenant_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTenantId() { return tenantId; }
    public void setTenantId(String tenantId) { this.tenantId = tenantId; }

    public DataProtectionRuleExportFile date(String date) {
        this.date = date;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public DataProtectionRuleExportFile offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("offset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public DataProtectionRuleExportFile totalCount(Long totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("totalCount")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getTotalCount() { return totalCount; }
    public void setTotalCount(Long totalCount) { this.totalCount = totalCount; }

    public DataProtectionRuleExportFile rules(List<ExportedDataProtectionRule> rules) {
        this.rules = rules;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("rules")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ExportedDataProtectionRule> getRules() { return rules; }
    public void setRules(List<ExportedDataProtectionRule> rules) { this.rules = rules; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataProtectionRuleExportFile that = (DataProtectionRuleExportFile)o;
        return Objects.equals(this.version, that.version) &&
                Objects.equals(this.creator, that.creator) &&
                Objects.equals(this.tenantId, that.tenantId) &&
                Objects.equals(this.date, that.date) &&
                Objects.equals(this.offset, that.offset) &&
                Objects.equals(this.totalCount, that.totalCount) &&
                Objects.equals(this.rules, that.rules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(version, creator, tenantId, date, offset, totalCount, rules);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataProtectionRuleExportFile {\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    date: ").append(toIndentedString(date)).append("\n");
        sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
        sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
        sb.append("    rules: ").append(toIndentedString(rules)).append("\n");
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
