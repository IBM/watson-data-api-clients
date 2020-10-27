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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/**
 * StatusType
 */
public class StatusType {

    private Integer statusCode;

    /**
     * Gets or Sets family
     */
    public enum FamilyEnum {
        INFORMATIONAL("INFORMATIONAL"),

        SUCCESSFUL("SUCCESSFUL"),

        REDIRECTION("REDIRECTION"),

        CLIENT_ERROR("CLIENT_ERROR"),

        SERVER_ERROR("SERVER_ERROR"),

        OTHER("OTHER");

        private String value;

        FamilyEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static FamilyEnum fromValue(String value) {
            for (FamilyEnum b : FamilyEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    private FamilyEnum family;
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

    public StatusType family(FamilyEnum family) {
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
    public FamilyEnum getFamily() { return family; }
    public void setFamily(FamilyEnum family) { this.family = family; }

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
