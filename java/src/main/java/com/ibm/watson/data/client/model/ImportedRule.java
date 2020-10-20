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
import java.util.Objects;

/**
 * Details of successfully imported rule.
 */
public class ImportedRule {

    private String name;
    private Integer index;
    private String guid;
    private String ruleGuidInRequest;

    public ImportedRule name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Rule name, matches with a corresponding one request data
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ImportedRule index(Integer index) {
        this.index = index;
        return this;
    }

    /**
     * Index to the rule specified in request data; 1-based.
     * @return index
     **/
    @JsonProperty("index")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getIndex() { return index; }
    public void setIndex(Integer index) { this.index = index; }

    public ImportedRule guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Rule GUID
     * @return guid
     **/
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public ImportedRule ruleGuidInRequest(String ruleGuidInRequest) {
        this.ruleGuidInRequest = ruleGuidInRequest;
        return this;
    }

    /**
     * Corresponding rule GUID in request data
     * @return ruleGuidInRequest
     **/
    @javax.annotation.Nullable
    @JsonProperty("ruleGuidInRequest")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRuleGuidInRequest() { return ruleGuidInRequest; }
    public void setRuleGuidInRequest(String ruleGuidInRequest) { this.ruleGuidInRequest = ruleGuidInRequest; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ImportedRule imported = (ImportedRule)o;
        return Objects.equals(this.name, imported.name) &&
                Objects.equals(this.index, imported.index) &&
                Objects.equals(this.guid, imported.guid) &&
                Objects.equals(this.ruleGuidInRequest, imported.ruleGuidInRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, index, guid, ruleGuidInRequest);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImportedRule {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    index: ").append(toIndentedString(index)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    ruleGuidInRequest: ").append(toIndentedString(ruleGuidInRequest)).append("\n");
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
