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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserInfo
 */
@JsonPropertyOrder({
        UserInfo.JSON_PROPERTY_APPROVAL_STATUS,
        UserInfo.JSON_PROPERTY_AUTHENTICATOR,
        UserInfo.JSON_PROPERTY_CREATED_TIMESTAMP,
        UserInfo.JSON_PROPERTY_CURRENT_ACCOUNT_STATUS,
        UserInfo.JSON_PROPERTY_DISPLAY_NAME,
        UserInfo.JSON_PROPERTY_EMAIL,
        UserInfo.JSON_PROPERTY_LAST_MODIFIED_TIMESTAMP,
        UserInfo.JSON_PROPERTY_PERMISSIONS,
        UserInfo.JSON_PROPERTY_ROLE,
        UserInfo.JSON_PROPERTY_UID,
        UserInfo.JSON_PROPERTY_USER_ROLES,
        UserInfo.JSON_PROPERTY_USERNAME
})
public class UserInfo {

    public static final String JSON_PROPERTY_APPROVAL_STATUS = "approval_status";
    private String approvalStatus;

    public static final String JSON_PROPERTY_AUTHENTICATOR = "authenticator";
    private String authenticator;

    public static final String JSON_PROPERTY_CREATED_TIMESTAMP = "created_timestamp";
    private String createdTimestamp;

    public static final String JSON_PROPERTY_CURRENT_ACCOUNT_STATUS = "current_account_status";
    private String currentAccountStatus;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_EMAIL = "email";
    private String email;

    public static final String JSON_PROPERTY_LAST_MODIFIED_TIMESTAMP = "last_modified_timestamp";
    private String lastModifiedTimestamp;

    public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
    private List<String> permissions = null;

    public static final String JSON_PROPERTY_ROLE = "role";
    private String role;

    public static final String JSON_PROPERTY_UID = "uid";
    private String uid;

    public static final String JSON_PROPERTY_USER_ROLES = "user_roles";
    private List<String> userRoles = null;

    public static final String JSON_PROPERTY_USERNAME = "username";
    private String username;

    public UserInfo approvalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }

    /**
     * The status of the user&#39;s access to the web client.
     * @return approvalStatus
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            example = "approved",
            value = "The status of the user's access to the web client.")
    @JsonProperty(JSON_PROPERTY_APPROVAL_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public UserInfo authenticator(String authenticator) {
        this.authenticator = authenticator;
        return this;
    }

    /**
     * The authenticator for the user.
     * @return authenticator
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "default",
            value = "The authenticator for the user.")
    @JsonProperty(JSON_PROPERTY_AUTHENTICATOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(String authenticator) {
        this.authenticator = authenticator;
    }

    public UserInfo createdTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
        return this;
    }

    /**
     * The date and time that the user account was created.
     * @return createdTimestamp
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            example = "2018-10-08T21:53:14.855Z",
            value = "The date and time that the user account was created.")
    @JsonProperty(JSON_PROPERTY_CREATED_TIMESTAMP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public UserInfo currentAccountStatus(String currentAccountStatus) {
        this.currentAccountStatus = currentAccountStatus;
        return this;
    }

    /**
     * The current status of the user&#39;s account.
     * @return currentAccountStatus
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "enabled",
            value = "The current status of the user's account.")
    @JsonProperty(JSON_PROPERTY_CURRENT_ACCOUNT_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCurrentAccountStatus() {
        return currentAccountStatus;
    }

    public void setCurrentAccountStatus(String currentAccountStatus) {
        this.currentAccountStatus = currentAccountStatus;
    }

    public UserInfo displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name that is displayed for this user.
     * @return displayName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "admin",
            value = "The name that is displayed for this user.")
    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UserInfo email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The user&#39;s email address.
     * @return email
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "approved", value = "The user's email address.")
    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public UserInfo lastModifiedTimestamp(String lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
        return this;
    }

    /**
     * The date and time the account was last modified.
     * @return lastModifiedTimestamp
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "2018-10-08T21:53:14.855Z",
            value = "The date and time the account was last modified.")
    @JsonProperty(JSON_PROPERTY_LAST_MODIFIED_TIMESTAMP)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(String lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public UserInfo permissions(List<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public UserInfo addPermissionsItem(String permissionsItem) {
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
    @ApiModelProperty(value = "The permissions associated with the user.")
    @JsonProperty(JSON_PROPERTY_PERMISSIONS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public UserInfo role(String role) {
        this.role = role;
        return this;
    }

    /**
     * The role assigned to the user.
     * @return role
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "admin", value = "The role assigned to the user.")
    @JsonProperty(JSON_PROPERTY_ROLE)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getRole() {
        return role;
    }

    public void setRole(String role) { this.role = role; }

    public UserInfo uid(String uid) {
        this.uid = uid;
        return this;
    }

    /**
     * The unique identifier for the user.
     * @return uid
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "1001",
            value = "The unique identifier for the user.")
    @JsonProperty(JSON_PROPERTY_UID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) { this.uid = uid; }

    public UserInfo userRoles(List<String> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    public UserInfo addUserRolesItem(String userRolesItem) {
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
    @ApiModelProperty(value = "The roles assigned to the user.")
    @JsonProperty(JSON_PROPERTY_USER_ROLES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }

    public UserInfo username(String username) {
        this.username = username;
        return this;
    }

    /**
     * The user name.
     * @return username
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Admin", value = "The user name.")
    @JsonProperty(JSON_PROPERTY_USERNAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) { this.username = username; }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserInfo
                getAllUsersResponseAllOf1UsersInfoItems =
                (UserInfo)o;
        return Objects.equals(
                this.approvalStatus,
                getAllUsersResponseAllOf1UsersInfoItems.approvalStatus) &&
                Objects.equals(this.authenticator,
                        getAllUsersResponseAllOf1UsersInfoItems.authenticator) &&
                Objects.equals(
                        this.createdTimestamp,
                        getAllUsersResponseAllOf1UsersInfoItems.createdTimestamp) &&
                Objects.equals(
                        this.currentAccountStatus,
                        getAllUsersResponseAllOf1UsersInfoItems.currentAccountStatus) &&
                Objects.equals(this.displayName,
                        getAllUsersResponseAllOf1UsersInfoItems.displayName) &&
                Objects.equals(this.email,
                        getAllUsersResponseAllOf1UsersInfoItems.email) &&
                Objects.equals(
                        this.lastModifiedTimestamp,
                        getAllUsersResponseAllOf1UsersInfoItems.lastModifiedTimestamp) &&
                Objects.equals(this.permissions,
                        getAllUsersResponseAllOf1UsersInfoItems.permissions) &&
                Objects.equals(this.role,
                        getAllUsersResponseAllOf1UsersInfoItems.role) &&
                Objects.equals(this.uid, getAllUsersResponseAllOf1UsersInfoItems.uid) &&
                Objects.equals(this.userRoles,
                        getAllUsersResponseAllOf1UsersInfoItems.userRoles) &&
                Objects.equals(this.username,
                        getAllUsersResponseAllOf1UsersInfoItems.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(approvalStatus, authenticator, createdTimestamp,
                currentAccountStatus, displayName, email,
                lastModifiedTimestamp, permissions, role, uid,
                userRoles, username);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserInfo {\n");
        sb.append("    approvalStatus: ")
                .append(toIndentedString(approvalStatus))
                .append("\n");
        sb.append("    authenticator: ")
                .append(toIndentedString(authenticator))
                .append("\n");
        sb.append("    createdTimestamp: ")
                .append(toIndentedString(createdTimestamp))
                .append("\n");
        sb.append("    currentAccountStatus: ")
                .append(toIndentedString(currentAccountStatus))
                .append("\n");
        sb.append("    displayName: ")
                .append(toIndentedString(displayName))
                .append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    lastModifiedTimestamp: ")
                .append(toIndentedString(lastModifiedTimestamp))
                .append("\n");
        sb.append("    permissions: ")
                .append(toIndentedString(permissions))
                .append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    uid: ").append(toIndentedString(uid)).append("\n");
        sb.append("    userRoles: ")
                .append(toIndentedString(userRoles))
                .append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
