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
 * ColumnInfoDetails
 */
public class ColumnInfoDetails {

    private String omrsGuid;
    private List<ColumnTerm> columnTerms;

    @javax.annotation.Nullable
    @JsonProperty("omrs_guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOmrsGuid() { return omrsGuid; }
    public void setOmrsGuid(String omrsGuid) { this.omrsGuid = omrsGuid; }

    @javax.annotation.Nullable
    @JsonProperty("column_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ColumnTerm> getColumnTerms() { return columnTerms; }
    public void setColumnTerms(List<ColumnTerm> columnTerms) { this.columnTerms = columnTerms; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColumnInfoDetails that = (ColumnInfoDetails) o;
        return Objects.equals(omrsGuid, that.omrsGuid) &&
                Objects.equals(columnTerms, that.columnTerms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(omrsGuid, columnTerms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ColumnInfoDetails {\n");
        sb.append("    omrsGuid: ").append(toIndentedString(omrsGuid)).append("\n");
        sb.append("    columnTerms: ").append(toIndentedString(columnTerms)).append("\n");
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
