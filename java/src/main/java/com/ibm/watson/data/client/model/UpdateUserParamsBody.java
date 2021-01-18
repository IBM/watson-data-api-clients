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
import com.ibm.watson.data.client.model.enums.ApprovalStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UpdateUserParamsBody
 */
public class UpdateUserParamsBody {

    private ApprovalStatus approvalStatus;
    private String displayName;
    private String email;
    private List<String> userRoles = null;

    public UpdateUserParamsBody approvalStatus(ApprovalStatus approvalStatus) {
        this.approvalStatus = approvalStatus;
        return this;
    }

    /**
     * The status of the user's access to the web client.
     * @return approvalStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("approval_status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ApprovalStatus getApprovalStatus() { return approvalStatus; }
    public void setApprovalStatus(ApprovalStatus approvalStatus) { this.approvalStatus = approvalStatus; }

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

    public UpdateUserParamsBody email(String email) {
        this.email = email;
        return this;
    }

    /**
     * The user's email address.
     * @return email
     **/
    @javax.annotation.Nullable
    @JsonProperty("email")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEmail() { return email; }
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
    @JsonProperty("user_roles")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getUserRoles() { return userRoles; }
    public void setUserRoles(List<String> userRoles) { this.userRoles = userRoles; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UpdateUserParamsBody updateUserParamsBody = (UpdateUserParamsBody)o;
        return Objects.equals(this.approvalStatus, updateUserParamsBody.approvalStatus) &&
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
        sb.append("    approvalStatus: ").append(toIndentedString(approvalStatus)).append("\n");
        sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
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
