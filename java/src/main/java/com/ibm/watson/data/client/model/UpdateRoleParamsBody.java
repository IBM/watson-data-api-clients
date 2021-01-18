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
 * UpdateRoleParamsBody
 */
public class UpdateRoleParamsBody {

    private String description;
    private List<String> permissions = new ArrayList<>();

    public UpdateRoleParamsBody description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the role.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public UpdateRoleParamsBody permissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public UpdateRoleParamsBody addPermissionsItem(String permissionsItem) {
        this.permissions.add(permissionsItem);
        return this;
    }

    /**
     * The permissions associated with the role.
     * @return permissions
     **/
    @JsonProperty("permissions")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<String> getPermissions() { return permissions; }
    public void setPermissions(List<String> permissions) { this.permissions = permissions; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UpdateRoleParamsBody updateRoleParamsBody = (UpdateRoleParamsBody)o;
        return Objects.equals(this.description, updateRoleParamsBody.description) &&
                Objects.equals(this.permissions, updateRoleParamsBody.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, permissions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateRoleParamsBody {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
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
