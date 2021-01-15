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
 * Base Rules of Visibility (mode only).
 *
 * Value can be:
 * - 0: searchable and viewable by everyone with access to the catalog or project
 * - 8: searchable by everyone and cannot be viewed unless the user has proper view permissions
 * - 16: searchable by users with proper view permissions
 */
public class BaseRov {

    private Integer mode;

    public BaseRov mode(Integer mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Get mode
     * @return mode
     **/
    @javax.annotation.Nullable
    @JsonProperty("mode")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getMode() { return mode; }
    public void setMode(Integer mode) { this.mode = mode; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BaseRov that = (BaseRov)o;
        return Objects.equals(this.mode, that.mode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BaseRov {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
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
