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
 * ExportedDataProtectionRule
 */
public class ExportedDataProtectionRule extends PolicyRuleEntity {

    private String guid;

    public ExportedDataProtectionRule guid(String guid) {
        this.guid = guid;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ExportedDataProtectionRule that = (ExportedDataProtectionRule)o;
        return super.equals(o) &&
                Objects.equals(this.guid, that.guid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), guid);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExportedDataProtectionRule {\n");
        super.toString(sb);
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
