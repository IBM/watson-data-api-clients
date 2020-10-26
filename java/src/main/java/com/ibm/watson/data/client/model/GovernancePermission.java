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
import com.ibm.watson.data.client.model.enums.GovernancePermissionAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GovernancePermission
 */
public class GovernancePermission {

    private String permissionId;
    private Condition condition;
    private List<GovernancePermissionAction> actions = null;

    public GovernancePermission permissionId(String permissionId) {
        this.permissionId = permissionId;
        return this;
    }

    /**
     * Get permissionId
     * @return permissionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("permission_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPermissionId() { return permissionId; }
    public void setPermissionId(String permissionId) { this.permissionId = permissionId; }

    public GovernancePermission condition(Condition condition) {
        this.condition = condition;
        return this;
    }

    /**
     * Get condition
     * @return condition
     **/
    @javax.annotation.Nullable
    @JsonProperty("condition")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Condition getCondition() { return condition; }
    public void setCondition(Condition condition) { this.condition = condition; }

    public GovernancePermission actions(List<GovernancePermissionAction> actions) {
        this.actions = actions;
        return this;
    }

    public GovernancePermission addActionsItem(GovernancePermissionAction actionsItem) {
        if (this.actions == null) {
            this.actions = new ArrayList<>();
        }
        this.actions.add(actionsItem);
        return this;
    }

    /**
     * Get actions
     * @return actions
     **/
    @javax.annotation.Nullable
    @JsonProperty("actions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<GovernancePermissionAction> getActions() { return actions; }
    public void setActions(List<GovernancePermissionAction> actions) { this.actions = actions; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        GovernancePermission governancePermissionsForAuthenticatedUser = (GovernancePermission)o;
        return Objects.equals(this.permissionId, governancePermissionsForAuthenticatedUser.permissionId) &&
                Objects.equals(this.condition, governancePermissionsForAuthenticatedUser.condition) &&
                Objects.equals(this.actions, governancePermissionsForAuthenticatedUser.actions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, condition, actions);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GovernancePermission {\n");
        sb.append("    permissionId: ").append(toIndentedString(permissionId)).append("\n");
        sb.append("    condition: ").append(toIndentedString(condition)).append("\n");
        sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
