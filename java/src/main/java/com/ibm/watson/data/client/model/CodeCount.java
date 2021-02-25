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
 * CodeCount
 */
public class CodeCount {

    private CodeValue value;
    private Long count;

    @javax.annotation.Nullable
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public CodeValue getValue() { return value; }
    public void setValue(CodeValue value) { this.value = value; }

    @javax.annotation.Nullable
    @JsonProperty("count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeCount codeCount = (CodeCount) o;
        return Objects.equals(value, codeCount.value) &&
                Objects.equals(count, codeCount.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CodeCount {\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
