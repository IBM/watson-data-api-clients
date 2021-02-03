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

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.watson.data.client.model.enums.UserType;

/**
 * RoleAssignment
 */
public class RoleAssignment {

    private String categoryArtifactId;
    private String categoryName;
    private String role;
    private String principalId;
    private String id;
    private String dpsRuleId;
    private UserType userType;
    private Date createTime;

    public RoleAssignment categoryArtifactId(String categoryArtifactId) {
        this.categoryArtifactId = categoryArtifactId;
        return this;
    }

    /**
     * Get categoryArtifactId
     * @return categoryArtifactId
     **/
    @javax.annotation.Nullable
    @JsonProperty("category_artifact_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCategoryArtifactId() { return categoryArtifactId; }
    public void setCategoryArtifactId(String categoryArtifactId) { this.categoryArtifactId = categoryArtifactId; }

    public RoleAssignment categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    /**
     * Get categoryName
     * @return categoryName
     **/
    @javax.annotation.Nullable
    @JsonProperty("category_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public RoleAssignment role(String role) {
        this.role = role;
        return this;
    }

    /**
     * Get role
     * @return role
     **/
    @javax.annotation.Nullable
    @JsonProperty("role")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public RoleAssignment principalId(String principalId) {
        this.principalId = principalId;
        return this;
    }

    /**
     * Get principalId
     * @return principalId
     **/
    @javax.annotation.Nullable
    @JsonProperty("principal_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPrincipalId() { return principalId; }
    public void setPrincipalId(String principalId) { this.principalId = principalId; }

    public RoleAssignment id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public RoleAssignment dpsRuleId(String dpsRuleId) {
        this.dpsRuleId = dpsRuleId;
        return this;
    }

    /**
     * Get dpsRuleId
     * @return dpsRuleId
     **/
    @javax.annotation.Nullable
    @JsonProperty("dps_rule_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDpsRuleId() { return dpsRuleId; }
    public void setDpsRuleId(String dpsRuleId) { this.dpsRuleId = dpsRuleId; }

    public RoleAssignment userType(UserType userType) {
        this.userType = userType;
        return this;
    }

    /**
     * Get userType
     * @return userType
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public UserType getUserType() { return userType; }
    public void setUserType(UserType userType) { this.userType = userType; }

    public RoleAssignment createTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    /**
     * Get createTime
     * @return createTime
     **/
    @javax.annotation.Nullable
    @JsonProperty("create_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreateTime() { return createTime; }
    public void setCreateTime(Date createTime) { this.createTime = createTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RoleAssignment that = (RoleAssignment) o;
        return Objects.equals(this.categoryArtifactId, that.categoryArtifactId) &&
                Objects.equals(this.categoryName, that.categoryName) &&
                Objects.equals(this.role, that.role) &&
                Objects.equals(this.principalId, that.principalId) &&
                Objects.equals(this.id, that.id) &&
                Objects.equals(this.dpsRuleId, that.dpsRuleId) &&
                Objects.equals(this.userType, that.userType) &&
                Objects.equals(this.createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryArtifactId, categoryName, role, principalId,
                id, dpsRuleId, userType, createTime);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RoleAssignment {\n");
        sb.append("    categoryArtifactId: ").append(toIndentedString(categoryArtifactId)).append("\n");
        sb.append("    categoryName: ").append(toIndentedString(categoryName)).append("\n");
        sb.append("    role: ").append(toIndentedString(role)).append("\n");
        sb.append("    principalId: ").append(toIndentedString(principalId)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    dpsRuleId: ").append(toIndentedString(dpsRuleId)).append("\n");
        sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
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
