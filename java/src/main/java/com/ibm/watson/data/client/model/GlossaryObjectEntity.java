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
import com.ibm.watson.data.client.model.enums.GlossaryObjectState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GlossaryObjectEntity
 */
public class GlossaryObjectEntity {

    private String longDescription;
    private GlossaryObjectState state;
    private List<CustomAttribute> customAttributes = null;

    public GlossaryObjectEntity longDescription(String longDescription) {
        this.longDescription = longDescription;
        return this;
    }

    /**
     * The long description of an artifact.
     * @return longDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("long_description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLongDescription() { return longDescription; }
    public void setLongDescription(String longDescription) { this.longDescription = longDescription; }

    public GlossaryObjectEntity state(GlossaryObjectState state) {
        this.state = state;
        return this;
    }

    /**
     * The state of an artifact, such as DRAFT, ACTIVE or ARCHIVED.
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public GlossaryObjectState getState() { return state; }
    public void setState(GlossaryObjectState state) { this.state = state; }

    public GlossaryObjectEntity customAttributes(List<CustomAttribute> customAttributes) {
        this.customAttributes = customAttributes;
        return this;
    }

    public GlossaryObjectEntity addCustomAttributesItem(CustomAttribute customAttributesItem) {
        if (this.customAttributes == null) {
            this.customAttributes = new ArrayList<>();
        }
        this.customAttributes.add(customAttributesItem);
        return this;
    }

    /**
     * List of custom attributes with their values.
     * @return customAttributes
     **/
    @javax.annotation.Nullable
    @JsonProperty("custom_attributes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CustomAttribute> getCustomAttributes() { return customAttributes; }
    public void setCustomAttributes(List<CustomAttribute> customAttributes) { this.customAttributes = customAttributes; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GlossaryObjectEntity that = (GlossaryObjectEntity)o;
        return Objects.equals(this.longDescription, that.longDescription) &&
                Objects.equals(this.state, that.state) &&
                Objects.equals(this.customAttributes, that.customAttributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longDescription, state, customAttributes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GlossaryObjectEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    longDescription: ").append(toIndentedString(longDescription)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    customAttributes: ").append(toIndentedString(customAttributes)).append("\n");
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
