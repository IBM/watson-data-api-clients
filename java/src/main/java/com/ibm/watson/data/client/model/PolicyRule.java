/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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
import com.ibm.watson.data.client.model.enums.GovernanceType;
import com.ibm.watson.data.client.model.enums.PolicyRuleState;

/**
 * PolicyRule
 */
public class PolicyRule {

    private String guid;
    private Long customFlags;
    private String description;
    private String ruleId;
    private String name;
    private GovernanceType governanceType;
    private Action action;
    private Expression trigger;
    private PolicyRuleState state;
    private String catId;
    private String userOrGroupId;
    private Boolean isUserGroup;
    private Boolean userGroup;
    private String rootGuid;
    private String parentGuid;
    private String tenantId;
    private String hierarchyGuid;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public PolicyRule guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get guid
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }

    public PolicyRule customFlags(Long customFlags) {
        this.customFlags = customFlags;
        return this;
    }

    /**
     * Get customFlags
     * @return customFlags
     **/
    @javax.annotation.Nullable
    @JsonProperty("customFlags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCustomFlags() {
        return customFlags;
    }
    public void setCustomFlags(Long customFlags) {
        this.customFlags = customFlags;
    }

    public PolicyRule description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get ruleId
     * @return ruleId
     **/
    @javax.annotation.Nullable
    @JsonProperty("rule_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRuleId() {
        return ruleId;
    }
    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }

    public PolicyRule name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public PolicyRule governanceType(GovernanceType governanceType) {
        this.governanceType = governanceType;
        return this;
    }

    /**
     * Get governanceType
     * @return governanceType
     **/
    @javax.annotation.Nullable
    @JsonProperty("governance_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public GovernanceType getGovernanceType() {
        return governanceType;
    }
    public void setGovernanceType(GovernanceType governanceType) {
        this.governanceType = governanceType;
    }

    public PolicyRule action(Action action) {
        this.action = action;
        return this;
    }

    /**
     * Get action
     * @return action
     **/
    @javax.annotation.Nullable
    @JsonProperty("action")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Action getAction() {
        return action;
    }
    public void setAction(Action action) {
        this.action = action;
    }

    public PolicyRule trigger(Expression trigger) {
        this.trigger = trigger;
        return this;
    }

    /**
     * Get trigger
     * @return trigger
     **/
    @javax.annotation.Nullable
    @JsonProperty("trigger")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Expression getTrigger() {
        return trigger;
    }
    public void setTrigger(Expression trigger) {
        this.trigger = trigger;
    }

    public PolicyRule state(PolicyRuleState state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PolicyRuleState getState() {
        return state;
    }
    public void setState(PolicyRuleState state) {
        this.state = state;
    }

    public PolicyRule catId(String catId) {
        this.catId = catId;
        return this;
    }

    /**
     * Get catId
     * @return catId
     **/
    @javax.annotation.Nullable
    @JsonProperty("cat_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatId() {
        return catId;
    }
    public void setCatId(String catId) {
        this.catId = catId;
    }

    public PolicyRule userOrGroupId(String userOrGroupId) {
        this.userOrGroupId = userOrGroupId;
        return this;
    }

    /**
     * Get userOrGroupId
     * @return userOrGroupId
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_or_group_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUserOrGroupId() {
        return userOrGroupId;
    }
    public void setUserOrGroupId(String userOrGroupId) {
        this.userOrGroupId = userOrGroupId;
    }

    public PolicyRule isUserGroup(Boolean isUserGroup) {
        this.isUserGroup = isUserGroup;
        return this;
    }

    /**
     * Get isUserGroup
     * @return isUserGroup
     **/
    @javax.annotation.Nullable
    @JsonProperty("userGroup")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getIsUserGroup() {
        return isUserGroup;
    }
    public void setIsUserGroup(Boolean isUserGroup) {
        this.isUserGroup = isUserGroup;
    }

    public PolicyRule userGroup(Boolean userGroup) {
        this.userGroup = userGroup;
        return this;
    }

    /**
     * Get userGroup
     * @return userGroup
     **/
    @javax.annotation.Nullable
    @JsonProperty("user_group")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getUserGroup() {
        return userGroup;
    }
    public void setUserGroup(Boolean userGroup) {
        this.userGroup = userGroup;
    }

    public PolicyRule rootGuid(String rootGuid) {
        this.rootGuid = rootGuid;
        return this;
    }

    /**
     * Get rootGuid
     * @return rootGuid
     **/
    @javax.annotation.Nullable
    @JsonProperty("rootGuid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getRootGuid() {
        return rootGuid;
    }
    public void setRootGuid(String rootGuid) {
        this.rootGuid = rootGuid;
    }

    public PolicyRule parentGuid(String parentGuid) {
        this.parentGuid = parentGuid;
        return this;
    }

    /**
     * Get parentGuid
     * @return parentGuid
     **/
    @javax.annotation.Nullable
    @JsonProperty("parentGuid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentGuid() {
        return parentGuid;
    }
    public void setParentGuid(String parentGuid) {
        this.parentGuid = parentGuid;
    }

    public PolicyRule tenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    /**
     * Get tenantId
     * @return tenantId
     **/
    @javax.annotation.Nullable
    @JsonProperty("tenantId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public PolicyRule hierarchyGuid(String hierarchyGuid) {
        this.hierarchyGuid = hierarchyGuid;
        return this;
    }

    /**
     * Get hierarchyGuid
     * @return hierarchyGuid
     **/
    @javax.annotation.Nullable
    @JsonProperty("hierarchyGuid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHierarchyGuid() {
        return hierarchyGuid;
    }
    public void setHierarchyGuid(String hierarchyGuid) {
        this.hierarchyGuid = hierarchyGuid;
    }

    /**
     * Get createdBy
     * @return createdBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * Get createdDate
     * @return createdDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Get modifiedBy
     * @return modifiedBy
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_by")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getModifiedBy() {
        return modifiedBy;
    }
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    /**
     * Get modifiedDate
     * @return modifiedDate
     **/
    @javax.annotation.Nullable
    @JsonProperty("modified_date")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Date getModifiedDate() {
        return modifiedDate;
    }
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyRule policyRule = (PolicyRule) o;
        return Objects.equals(this.guid, policyRule.guid) &&
                Objects.equals(this.customFlags, policyRule.customFlags) &&
                Objects.equals(this.description, policyRule.description) &&
                Objects.equals(this.ruleId, policyRule.ruleId) &&
                Objects.equals(this.name, policyRule.name) &&
                Objects.equals(this.governanceType, policyRule.governanceType) &&
                Objects.equals(this.action, policyRule.action) &&
                Objects.equals(this.trigger, policyRule.trigger) &&
                Objects.equals(this.state, policyRule.state) &&
                Objects.equals(this.catId, policyRule.catId) &&
                Objects.equals(this.userOrGroupId, policyRule.userOrGroupId) &&
                Objects.equals(this.isUserGroup, policyRule.isUserGroup) &&
                Objects.equals(this.userGroup, policyRule.userGroup) &&
                Objects.equals(this.rootGuid, policyRule.rootGuid) &&
                Objects.equals(this.parentGuid, policyRule.parentGuid) &&
                Objects.equals(this.tenantId, policyRule.tenantId) &&
                Objects.equals(this.hierarchyGuid, policyRule.hierarchyGuid) &&
                Objects.equals(this.createdBy, policyRule.createdBy) &&
                Objects.equals(this.createdDate, policyRule.createdDate) &&
                Objects.equals(this.modifiedBy, policyRule.modifiedBy) &&
                Objects.equals(this.modifiedDate, policyRule.modifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, customFlags, description, ruleId, name, governanceType, action, trigger, state, catId, userOrGroupId, isUserGroup, userGroup, rootGuid, parentGuid, tenantId, hierarchyGuid, createdBy, createdDate, modifiedBy, modifiedDate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyRule {\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    customFlags: ").append(toIndentedString(customFlags)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    ruleId: ").append(toIndentedString(ruleId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    governanceType: ").append(toIndentedString(governanceType)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    trigger: ").append(toIndentedString(trigger)).append("\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    catId: ").append(toIndentedString(catId)).append("\n");
        sb.append("    userOrGroupId: ").append(toIndentedString(userOrGroupId)).append("\n");
        sb.append("    isUserGroup: ").append(toIndentedString(isUserGroup)).append("\n");
        sb.append("    userGroup: ").append(toIndentedString(userGroup)).append("\n");
        sb.append("    rootGuid: ").append(toIndentedString(rootGuid)).append("\n");
        sb.append("    parentGuid: ").append(toIndentedString(parentGuid)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    hierarchyGuid: ").append(toIndentedString(hierarchyGuid)).append("\n");
        sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
        sb.append("    createdDate: ").append(toIndentedString(createdDate)).append("\n");
        sb.append("    modifiedBy: ").append(toIndentedString(modifiedBy)).append("\n");
        sb.append("    modifiedDate: ").append(toIndentedString(modifiedDate)).append("\n");
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
