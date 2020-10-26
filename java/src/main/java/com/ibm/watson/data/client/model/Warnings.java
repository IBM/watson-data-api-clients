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
 * Warnings
 */
public class Warnings {

    private Long row;
    private List<String> info = null;

    public Warnings row(Long row) {
        this.row = row;
        return this;
    }

    /**
     * Get row number.
     * @return row
     **/
    @javax.annotation.Nullable
    @JsonProperty("row")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getRow() { return row; }
    public void setRow(Long row) { this.row = row; }

    public Warnings info(List<String> info) {
        this.info = info;
        return this;
    }

    public Warnings addInfoItem(String infoItem) {
        if (this.info == null) {
            this.info = new ArrayList<>();
        }
        this.info.add(infoItem);
        return this;
    }

    /**
     * Get information for the row.
     * @return info
     **/
    @javax.annotation.Nullable
    @JsonProperty("info")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getInfo() { return info; }
    public void setInfo(List<String> info) { this.info = info; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Warnings warnings = (Warnings)o;
        return Objects.equals(this.row, warnings.row) &&
                Objects.equals(this.info, warnings.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, info);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Warnings {\n");
        sb.append("    row: ").append(toIndentedString(row)).append("\n");
        sb.append("    info: ").append(toIndentedString(info)).append("\n");
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
