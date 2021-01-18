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
import com.ibm.watson.data.client.model.enums.StatusFamily;

import java.util.Objects;

/**
 * StatusType
 */
public class StatusType {

    private Integer statusCode;
    private StatusFamily family;
    private String reasonPhrase;

    public StatusType statusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Get statusCode
     * @return statusCode
     **/
    @javax.annotation.Nullable
    @JsonProperty("statusCode")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getStatusCode() { return statusCode; }
    public void setStatusCode(Integer statusCode) { this.statusCode = statusCode; }

    public StatusType family(StatusFamily family) {
        this.family = family;
        return this;
    }

    /**
     * Get family
     * @return family
     **/
    @javax.annotation.Nullable
    @JsonProperty("family")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public StatusFamily getFamily() { return family; }
    public void setFamily(StatusFamily family) { this.family = family; }

    public StatusType reasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
        return this;
    }

    /**
     * Get reasonPhrase
     * @return reasonPhrase
     **/
    @javax.annotation.Nullable
    @JsonProperty("reasonPhrase")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getReasonPhrase() { return reasonPhrase; }
    public void setReasonPhrase(String reasonPhrase) { this.reasonPhrase = reasonPhrase; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        StatusType statusType = (StatusType)o;
        return Objects.equals(this.statusCode, statusType.statusCode) &&
                Objects.equals(this.family, statusType.family) &&
                Objects.equals(this.reasonPhrase, statusType.reasonPhrase);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, family, reasonPhrase);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StatusType {\n");
        sb.append("    statusCode: ").append(toIndentedString(statusCode)).append("\n");
        sb.append("    family: ").append(toIndentedString(family)).append("\n");
        sb.append("    reasonPhrase: ").append(toIndentedString(reasonPhrase)).append("\n");
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
