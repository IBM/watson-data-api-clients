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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * MediaType
 */
public class MediaType {

    private String type;
    private String subtype;
    private Map<String, String> parameters = null;
    private Boolean wildcardType;
    private Boolean wildcardSubtype;

    public MediaType type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public MediaType subtype(String subtype) {
        this.subtype = subtype;
        return this;
    }

    /**
     * Get subtype
     * @return subtype
     **/
    @javax.annotation.Nullable
    @JsonProperty("subtype")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSubtype() { return subtype; }
    public void setSubtype(String subtype) { this.subtype = subtype; }

    public MediaType parameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public MediaType putParametersItem(String key, String parametersItem) {
        if (this.parameters == null) {
            this.parameters = new HashMap<>();
        }
        this.parameters.put(key, parametersItem);
        return this;
    }

    /**
     * Get parameters
     * @return parameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, String> getParameters() { return parameters; }
    public void setParameters(Map<String, String> parameters) { this.parameters = parameters; }

    public MediaType wildcardType(Boolean wildcardType) {
        this.wildcardType = wildcardType;
        return this;
    }

    /**
     * Get wildcardType
     * @return wildcardType
     **/
    @javax.annotation.Nullable
    @JsonProperty("wildcardType")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getWildcardType() { return wildcardType; }
    public void setWildcardType(Boolean wildcardType) { this.wildcardType = wildcardType; }

    public MediaType wildcardSubtype(Boolean wildcardSubtype) {
        this.wildcardSubtype = wildcardSubtype;
        return this;
    }

    /**
     * Get wildcardSubtype
     * @return wildcardSubtype
     **/
    @javax.annotation.Nullable
    @JsonProperty("wildcardSubtype")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getWildcardSubtype() { return wildcardSubtype; }
    public void setWildcardSubtype(Boolean wildcardSubtype) { this.wildcardSubtype = wildcardSubtype; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MediaType mediaType = (MediaType)o;
        return Objects.equals(this.type, mediaType.type) &&
                Objects.equals(this.subtype, mediaType.subtype) &&
                Objects.equals(this.parameters, mediaType.parameters) &&
                Objects.equals(this.wildcardType, mediaType.wildcardType) &&
                Objects.equals(this.wildcardSubtype, mediaType.wildcardSubtype);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, subtype, parameters, wildcardType,
                wildcardSubtype);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MediaType {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    subtype: ").append(toIndentedString(subtype)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
        sb.append("    wildcardType: ").append(toIndentedString(wildcardType)).append("\n");
        sb.append("    wildcardSubtype: ").append(toIndentedString(wildcardSubtype)).append("\n");
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
