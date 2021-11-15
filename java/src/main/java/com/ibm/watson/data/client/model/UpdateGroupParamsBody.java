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

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UpdateGroupParamsBody
 */
public class UpdateGroupParamsBody {

    private String name;
    private String description;
    private List<String> addRoleIdentifiers = null;
    private List<String> removeRoleIdentifiers = null;

    public UpdateGroupParamsBody name(String name) {
        this.name = name;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public UpdateGroupParamsBody description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Update the description for your user-group. This is optional. But if passed it needs to be a string.
     * @return description
     */
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UpdateGroupParamsBody addRoleIdentifiers(List<String> addRoleIdentifiers) {
        this.addRoleIdentifiers = addRoleIdentifiers;
        return this;
    }

    public UpdateGroupParamsBody addAddRoleIdentifiersItem(String addRoleIdentifiersItem) {
        if (this.addRoleIdentifiers == null) {
            this.addRoleIdentifiers = new ArrayList<>();
        }
        this.addRoleIdentifiers.add(addRoleIdentifiersItem);
        return this;
    }

    /**
     * An array of strings where each item in this array is an identifier for a platform role. Roles in this array will be associated to the group.
     * @return addRoleIdentifiers
     **/
    @javax.annotation.Nullable
    @JsonProperty("add_role_identifiers")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAddRoleIdentifiers() { return addRoleIdentifiers; }
    public void setAddRoleIdentifiers(List<String> addRoleIdentifiers) { this.addRoleIdentifiers = addRoleIdentifiers; }

    public UpdateGroupParamsBody removeRoleIdentifiers(List<String> removeRoleIdentifiers) {
        this.removeRoleIdentifiers = removeRoleIdentifiers;
        return this;
    }

    public UpdateGroupParamsBody addRemoveRoleIdentifiersItem(String removeRoleIdentifiersItem) {
        if (this.removeRoleIdentifiers == null) {
            this.removeRoleIdentifiers = new ArrayList<>();
        }
        this.removeRoleIdentifiers.add(removeRoleIdentifiersItem);
        return this;
    }

    /**
     * An array of strings where each item in this array is an identifier for a platform role. Roles in this array will be removed from the group.
     * @return removeRoleIdentifiers
     **/
    @javax.annotation.Nullable
    @JsonProperty("remove_role_identifiers")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getRemoveRoleIdentifiers() { return removeRoleIdentifiers; }
    public void setRemoveRoleIdentifiers(List<String> removeRoleIdentifiers) { this.removeRoleIdentifiers = removeRoleIdentifiers; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UpdateGroupParamsBody that = (UpdateGroupParamsBody)o;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.addRoleIdentifiers, that.addRoleIdentifiers) &&
                Objects.equals(this.removeRoleIdentifiers, that.removeRoleIdentifiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, addRoleIdentifiers, removeRoleIdentifiers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateGroupParamsBody {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    addRoleIdentifiers: ").append(toIndentedString(addRoleIdentifiers)).append("\n");
        sb.append("    removeRoleIdentifiers: ").append(toIndentedString(removeRoleIdentifiers)).append("\n");
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
