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
 * ReferenceDataValueEntity
 */
public class ReferenceDataValueEntity {

    private String code;
    private Object value;
    private String description;

    public ReferenceDataValueEntity code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Code
     * @return code
     **/
    @javax.annotation.Nullable
    @JsonProperty("code")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public ReferenceDataValueEntity value(Object value) {
        this.value = value;
        return this;
    }

    /**
     * Value
     * @return value
     **/
    @javax.annotation.Nullable
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getValue() { return value; }
    public void setValue(Object value) { this.value = value; }

    public ReferenceDataValueEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ReferenceDataValueEntity referenceDataValueEntity = (ReferenceDataValueEntity)o;
        return Objects.equals(this.code, referenceDataValueEntity.code) &&
                Objects.equals(this.value, referenceDataValueEntity.value) &&
                Objects.equals(this.description, referenceDataValueEntity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, value, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ResponseReferenceDataValueEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
