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
 * GetMeResponseAllOf1UserInfo
 */
public class GetMeResponseAllOf1UserInfo {

    private String displayName;
    private String email;
    private List<String> permissions = null;
    private String role;
    private String uid;
    private String username;

    public GetMeResponseAllOf1UserInfo displayName(String displayName) {
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

    public GetMeResponseAllOf1UserInfo email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The user&#39;s email address.
     * @return email
     **/
    @javax.annotation.Nullable
    @JsonProperty("email")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public GetMeResponseAllOf1UserInfo permissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public GetMeResponseAllOf1UserInfo addPermissionsItem(String permissionsItem) {
        if (this.permissions == null) {
            this.permissions = new ArrayList<>();
        }
        this.permissions.add(permissionsItem);
        return this;
    }

    /**
     * The permissions associated with the user.
     * @return permissions
     **/
    @javax.annotation.Nullable
    @JsonProperty("permissions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getPermissions() { return permissions; }
    public void setPermissions(List<String> permissions) { this.permissions = permissions; }

    public GetMeResponseAllOf1UserInfo role(String role) {
        this.role = role;
        return this;
    }

    /**
     * The role assigned to the user.
     * @return role
     **/
    @javax.annotation.Nullable
    @JsonProperty("role")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public GetMeResponseAllOf1UserInfo uid(String uid) {
        this.uid = uid;
        return this;
    }

    /**
     * The unique identifier for the user.
     * @return uid
     **/
    @javax.annotation.Nullable
    @JsonProperty("uid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public GetMeResponseAllOf1UserInfo username(String username) {
        this.username = username;
        return this;
    }

    /**
     * The user name.
     * @return username
     **/
    @javax.annotation.Nullable
    @JsonProperty("username")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GetMeResponseAllOf1UserInfo getMeResponseAllOf1UserInfo = (GetMeResponseAllOf1UserInfo)o;
        return Objects.equals(this.displayName, getMeResponseAllOf1UserInfo.displayName) &&
                Objects.equals(this.email, getMeResponseAllOf1UserInfo.email) &&
                Objects.equals(this.permissions, getMeResponseAllOf1UserInfo.permissions) &&
                Objects.equals(this.role, getMeResponseAllOf1UserInfo.role) &&
                Objects.equals(this.uid, getMeResponseAllOf1UserInfo.uid) &&
                Objects.equals(this.username, getMeResponseAllOf1UserInfo.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, email, permissions, role, uid, username);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetMeResponseAllOf1UserInfo {\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    permissions: ").append(toIndentedString(permissions)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
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
