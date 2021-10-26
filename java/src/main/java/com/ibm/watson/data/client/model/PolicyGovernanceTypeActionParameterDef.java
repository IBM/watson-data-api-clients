/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.watson.data.client.model.enums.ActionParameterType;

/**
 * parameter definition within action definition within the /v3/enforcement/governance_types API
 */
public class PolicyGovernanceTypeActionParameterDef {

    private String name;
    private String displayName;
    private String description;
    private ActionParameterType type;
    private String typeQualifier;
    private Boolean multiValue;
    private Boolean required;

    public PolicyGovernanceTypeActionParameterDef name(String name) {
        this.name = name;
        return this;
    }

    /**
     * the name of the parameter, as specified in  rule actions
     * @return name
     **/
    @javax.annotation.Nonnull
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PolicyGovernanceTypeActionParameterDef displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * a displayable name for the parameter.
     * @return displayName
     **/
    @javax.annotation.Nonnull
    @JsonProperty("display_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public PolicyGovernanceTypeActionParameterDef description(String description) {
        this.description = description;
        return this;
    }

    /**
     * a description of the parameter
     * @return description
     **/
    @javax.annotation.Nonnull
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public PolicyGovernanceTypeActionParameterDef type(ActionParameterType type) {
        this.type = type;
        return this;
    }

    /**
     * the type of the parameter.  Three types are current supported: STRING for a string value, ENUM for a value that must come from an enumeration, TERM for a value that must be the name of a term.
     * @return type
     **/
    @javax.annotation.Nonnull
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public ActionParameterType getType() {
        return type;
    }
    public void setType(ActionParameterType type) {
        this.type = type;
    }

    public PolicyGovernanceTypeActionParameterDef typeQualifier(String typeQualifier) {
        this.typeQualifier = typeQualifier;
        return this;
    }

    /**
     * a qualifier for the type of the parameter.  This is used for ENUM and TERM parameters.
     * @return typeQualifier
     **/
    @javax.annotation.Nonnull
    @JsonProperty("type_qualifier")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getTypeQualifier() {
        return typeQualifier;
    }
    public void setTypeQualifier(String typeQualifier) {
        this.typeQualifier = typeQualifier;
    }

    public PolicyGovernanceTypeActionParameterDef multiValue(Boolean multiValue) {
        this.multiValue = multiValue;
        return this;
    }

    /**
     * if true then this parameter can have multiple values, which are represented on rule actions using a list (array)
     * @return multiValue
     **/
    @javax.annotation.Nonnull
    @JsonProperty("multi_value")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Boolean getMultiValue() {
        return multiValue;
    }
    public void setMultiValue(Boolean multiValue) {
        this.multiValue = multiValue;
    }

    public PolicyGovernanceTypeActionParameterDef required(Boolean required) {
        this.required = required;
        return this;
    }

    /**
     * if true then this parameter must be specified on rule actions
     * @return required
     **/
    @javax.annotation.Nonnull
    @JsonProperty("required")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Boolean getRequired() {
        return required;
    }
    public void setRequired(Boolean required) {
        this.required = required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyGovernanceTypeActionParameterDef policyGovernanceTypeActionParameterDef = (PolicyGovernanceTypeActionParameterDef) o;
        return Objects.equals(this.name, policyGovernanceTypeActionParameterDef.name) &&
                Objects.equals(this.displayName, policyGovernanceTypeActionParameterDef.displayName) &&
                Objects.equals(this.description, policyGovernanceTypeActionParameterDef.description) &&
                Objects.equals(this.type, policyGovernanceTypeActionParameterDef.type) &&
                Objects.equals(this.typeQualifier, policyGovernanceTypeActionParameterDef.typeQualifier) &&
                Objects.equals(this.multiValue, policyGovernanceTypeActionParameterDef.multiValue) &&
                Objects.equals(this.required, policyGovernanceTypeActionParameterDef.required);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, displayName, description, type, typeQualifier, multiValue, required);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyGovernanceTypeActionParameterDef {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    typeQualifier: ").append(toIndentedString(typeQualifier)).append("\n");
        sb.append("    multiValue: ").append(toIndentedString(multiValue)).append("\n");
        sb.append("    required: ").append(toIndentedString(required)).append("\n");
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
