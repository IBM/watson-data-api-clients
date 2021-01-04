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
import java.util.Date;
import java.util.Objects;

/**
 * FormPropertyInput
 */
public class FormPropertyInput {

    private Date dateValue;
    private String id;
    private Long longValue;
    private String value;

    public FormPropertyInput dateValue(Date dateValue) {
        this.dateValue = dateValue;
        return this;
    }

    /**
     * date value
     * @return dateValue
     **/
    @javax.annotation.Nullable
    @JsonProperty("date_value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getDateValue() { return dateValue; }
    public void setDateValue(Date dateValue) { this.dateValue = dateValue; }

    public FormPropertyInput id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public FormPropertyInput longValue(Long longValue) {
        this.longValue = longValue;
        return this;
    }

    /**
     * long value
     * @return longValue
     **/
    @javax.annotation.Nullable
    @JsonProperty("long_value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLongValue() { return longValue; }
    public void setLongValue(Long longValue) { this.longValue = longValue; }

    public FormPropertyInput value(String value) {
        this.value = value;
        return this;
    }

    /**
     * string value or enum value
     * @return value
     **/
    @javax.annotation.Nullable
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        FormPropertyInput formPropertyInput = (FormPropertyInput)o;
        return Objects.equals(this.dateValue, formPropertyInput.dateValue) &&
                Objects.equals(this.id, formPropertyInput.id) &&
                Objects.equals(this.longValue, formPropertyInput.longValue) &&
                Objects.equals(this.value, formPropertyInput.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateValue, id, longValue, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FormPropertyInput {\n");
        sb.append("    dateValue: ").append(toIndentedString(dateValue)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    longValue: ").append(toIndentedString(longValue)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
