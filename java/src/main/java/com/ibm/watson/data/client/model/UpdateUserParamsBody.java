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
 * UpdateUserParamsBody
 */
public class UpdateUserParamsBody {

    private String username;
    private String password;
    private String displayName;
    private List<String> userRoles = null;

    public UpdateUserParamsBody username(String username) {
        this.username = username;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("username")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public UpdateUserParamsBody password(String password) {
        this.password = password;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("password")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public UpdateUserParamsBody displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name that is displayed for this user.
     * @return displayName
     **/
    @javax.annotation.Nullable
    @JsonProperty("displayName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public UpdateUserParamsBody userRoles(List<String> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public UpdateUserParamsBody addUserRolesItem(String userRolesItem) {
        if (this.userRoles == null) {
            this.userRoles = new ArrayList<>();
        }
        this.userRoles.add(userRolesItem);
        return this;
    }

    /**
     * The roles assigned to the user.
     * @return userRoles
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_roles")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getUserRoles() { return userRoles; }
    public void setUserRoles(List<String> userRoles) { this.userRoles = userRoles; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UpdateUserParamsBody updateUserParamsBody = (UpdateUserParamsBody)o;
        return Objects.equals(this.username, updateUserParamsBody.username) &&
                Objects.equals(this.password, updateUserParamsBody.password) &&
                Objects.equals(this.displayName, updateUserParamsBody.displayName) &&
                Objects.equals(this.userRoles, updateUserParamsBody.userRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, displayName, userRoles);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateUserParamsBody {\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    userRoles: ").append(toIndentedString(userRoles)).append("\n");
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
