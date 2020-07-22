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
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UpdateUserParamsBody
 */
@JsonPropertyOrder({
        UpdateUserParamsBody.JSON_PROPERTY_APPROVAL_STATUS,
        UpdateUserParamsBody.JSON_PROPERTY_DISPLAY_NAME,
        UpdateUserParamsBody.JSON_PROPERTY_EMAIL,
        UpdateUserParamsBody.JSON_PROPERTY_USER_ROLES
})
public class UpdateUserParamsBody {

    /**
     * The status of the user&#39;s access to the web client.
     */
    public enum ApprovalStatusEnum {
        PENDING("pending"),

        APPROVED("approved");

        private String value;

        ApprovalStatusEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static ApprovalStatusEnum fromValue(String value) {
            for (ApprovalStatusEnum b : ApprovalStatusEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_APPROVAL_STATUS = "approval_status";
    private ApprovalStatusEnum approvalStatus;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    private String displayName;

    public static final String JSON_PROPERTY_EMAIL = "email";
    private String email;

    public static final String JSON_PROPERTY_USER_ROLES = "user_roles";
    private List<String> userRoles = null;

    public UpdateUserParamsBody approvalStatus(ApprovalStatusEnum approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }

    /**
     * The status of the user&#39;s access to the web client.
     * @return approvalStatus
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            value = "The status of the user's access to the web client.")
    @JsonProperty(JSON_PROPERTY_APPROVAL_STATUS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ApprovalStatusEnum getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(ApprovalStatusEnum approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public UpdateUserParamsBody displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * The name that is displayed for this user.
     * @return displayName
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The name that is displayed for this user.")
    @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UpdateUserParamsBody email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The user&#39;s email address.
     * @return email
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "The user's email address.")
    @JsonProperty(JSON_PROPERTY_EMAIL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

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
    @ApiModelProperty(value = "The roles assigned to the user.")
    @JsonProperty(JSON_PROPERTY_USER_ROLES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<String> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateUserParamsBody updateUserParamsBody = (UpdateUserParamsBody)o;
        return Objects.equals(this.approvalStatus,
                updateUserParamsBody.approvalStatus) &&
                Objects.equals(this.displayName, updateUserParamsBody.displayName) &&
                Objects.equals(this.email, updateUserParamsBody.email) &&
                Objects.equals(this.userRoles, updateUserParamsBody.userRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(approvalStatus, displayName, email, userRoles);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateUserParamsBody {\n");
        sb.append("    approvalStatus: ")
                .append(toIndentedString(approvalStatus))
                .append("\n");
        sb.append("    displayName: ")
                .append(toIndentedString(displayName))
                .append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    userRoles: ")
                .append(toIndentedString(userRoles))
                .append("\n");
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
