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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CreateGroupParamsBody
 */
public class CreateGroupParamsBody {

    private String name;
    private String description;
    private List<String> roleIdentifiers = new ArrayList<>();

    public CreateGroupParamsBody name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name that is displayed for this group.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CreateGroupParamsBody description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The group's description.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public CreateGroupParamsBody roleIdentifiers(List<String> roleIdentifiers) {
        this.roleIdentifiers = roleIdentifiers;
        return this;
    }

    public CreateGroupParamsBody addRoleIdentifiersItem(String roleIdentifiersItem) {
        this.roleIdentifiers.add(roleIdentifiersItem);
        return this;
    }

    /**
     * The roles assigned to the group.
     * @return roleIdentifiers
     **/
    @JsonProperty("role_identifiers")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getRoleIdentifiers() { return roleIdentifiers; }
    public void setRoleIdentifiers(List<String> roleIdentifiers) { this.roleIdentifiers = roleIdentifiers; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateGroupParamsBody that = (CreateGroupParamsBody)o;
        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.description, that.description) &&
                Objects.equals(this.roleIdentifiers, that.roleIdentifiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, roleIdentifiers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateGroupParamsBody {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    roleIdentifiers: ").append(toIndentedString(roleIdentifiers)).append("\n");
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
