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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * PolicyEvaluation
 */
public class PolicyEvaluation {

    private String outcome;
    private List<Action> actions = null;
    private PolicyEvaluationReason reason;
    private String tenantId;
    private String transformedItemId;
    private String transformationConvention;
    private Float transformationCost;
    private List<String> transformLocation = null;
    private List<TransformOperation> transformSpecs = null;
    private List<TransformedColumn> transformedColumns = null;
    private List<byte[]> policyDescriptor = null;
    private String itemId;
    private String operation;
    private String hierarchyId;
    private String parentId;
    private Long level;
    private PolicyEvaluationNotification notification;

    public PolicyEvaluation outcome(String outcome) {
        this.outcome = outcome;
        return this;
    }

    /**
     * Get outcome
     * @return outcome
     **/
    @javax.annotation.Nullable
    @JsonProperty("outcome")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOutcome() {
        return outcome;
    }
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public PolicyEvaluation actions(List<Action> actions) {
        this.actions = actions;
        return this;
    }

    public PolicyEvaluation addActionsItem(Action actionsItem) {
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
    public List<Action> getActions() {
        return actions;
    }
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public PolicyEvaluation reason(PolicyEvaluationReason reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     * @return reason
     **/
    @javax.annotation.Nullable
    @JsonProperty("reason")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PolicyEvaluationReason getReason() {
        return reason;
    }
    public void setReason(PolicyEvaluationReason reason) {
        this.reason = reason;
    }

    public PolicyEvaluation tenantId(String tenantId) {
        this.tenantId = tenantId;
        return this;
    }

    /**
     * Get tenantId
     * @return tenantId
     **/
    @javax.annotation.Nullable
    @JsonProperty("tenant_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTenantId() {
        return tenantId;
    }
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public PolicyEvaluation transformedItemId(String transformedItemId) {
        this.transformedItemId = transformedItemId;
        return this;
    }

    /**
     * Get transformedItemId
     * @return transformedItemId
     **/
    @javax.annotation.Nullable
    @JsonProperty("transformed_item_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTransformedItemId() {
        return transformedItemId;
    }
    public void setTransformedItemId(String transformedItemId) {
        this.transformedItemId = transformedItemId;
    }

    public PolicyEvaluation transformationConvention(String transformationConvention) {
        this.transformationConvention = transformationConvention;
        return this;
    }

    /**
     * Get transformationConvention
     * @return transformationConvention
     **/
    @javax.annotation.Nullable
    @JsonProperty("transformation_convention")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getTransformationConvention() {
        return transformationConvention;
    }
    public void setTransformationConvention(String transformationConvention) {
        this.transformationConvention = transformationConvention;
    }

    public PolicyEvaluation transformationCost(Float transformationCost) {
        this.transformationCost = transformationCost;
        return this;
    }

    /**
     * Get transformationCost
     * @return transformationCost
     **/
    @javax.annotation.Nullable
    @JsonProperty("transformation_cost")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Float getTransformationCost() {
        return transformationCost;
    }
    public void setTransformationCost(Float transformationCost) {
        this.transformationCost = transformationCost;
    }

    public PolicyEvaluation transformLocation(List<String> transformLocation) {
        this.transformLocation = transformLocation;
        return this;
    }

    public PolicyEvaluation addTransformLocationItem(String transformLocationItem) {
        if (this.transformLocation == null) {
            this.transformLocation = new ArrayList<>();
        }
        this.transformLocation.add(transformLocationItem);
        return this;
    }

    /**
     * Get transformLocation
     * @return transformLocation
     **/
    @javax.annotation.Nullable
    @JsonProperty("transformation_location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTransformLocation() {
        return transformLocation;
    }
    public void setTransformLocation(List<String> transformLocation) {
        this.transformLocation = transformLocation;
    }

    public PolicyEvaluation transformSpecs(List<TransformOperation> transformSpecs) {
        this.transformSpecs = transformSpecs;
        return this;
    }

    public PolicyEvaluation addTransformSpecsItem(TransformOperation transformSpecsItem) {
        if (this.transformSpecs == null) {
            this.transformSpecs = new ArrayList<>();
        }
        this.transformSpecs.add(transformSpecsItem);
        return this;
    }

    /**
     * Get transformSpecs
     * @return transformSpecs
     **/
    @javax.annotation.Nullable
    @JsonProperty("transform_specs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<TransformOperation> getTransformSpecs() {
        return transformSpecs;
    }
    public void setTransformSpecs(List<TransformOperation> transformSpecs) {
        this.transformSpecs = transformSpecs;
    }

    public PolicyEvaluation transformedColumns(List<TransformedColumn> transformedColumns) {
        this.transformedColumns = transformedColumns;
        return this;
    }

    public PolicyEvaluation addTransformedColumnsItem(TransformedColumn transformedColumnsItem) {
        if (this.transformedColumns == null) {
            this.transformedColumns = new ArrayList<>();
        }
        this.transformedColumns.add(transformedColumnsItem);
        return this;
    }

    /**
     * Get transformedColumns
     * @return transformedColumns
     **/
    @javax.annotation.Nullable
    @JsonProperty("transformed_columns")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<TransformedColumn> getTransformedColumns() {
        return transformedColumns;
    }
    public void setTransformedColumns(List<TransformedColumn> transformedColumns) {
        this.transformedColumns = transformedColumns;
    }

    public PolicyEvaluation policyDescriptor(List<byte[]> policyDescriptor) {
        this.policyDescriptor = policyDescriptor;
        return this;
    }

    public PolicyEvaluation addPolicyDescriptorItem(byte[] policyDescriptorItem) {
        if (this.policyDescriptor == null) {
            this.policyDescriptor = new ArrayList<>();
        }
        this.policyDescriptor.add(policyDescriptorItem);
        return this;
    }

    /**
     * Get policyDescriptor
     * @return policyDescriptor
     **/
    @javax.annotation.Nullable
    @JsonProperty("policy_descriptor")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<byte[]> getPolicyDescriptor() {
        return policyDescriptor;
    }
    public void setPolicyDescriptor(List<byte[]> policyDescriptor) {
        this.policyDescriptor = policyDescriptor;
    }

    public PolicyEvaluation itemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    /**
     * Get itemId
     * @return itemId
     **/
    @javax.annotation.Nullable
    @JsonProperty("item_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getItemId() {
        return itemId;
    }
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public PolicyEvaluation operation(String operation) {
        this.operation = operation;
        return this;
    }

    /**
     * Get operation
     * @return operation
     **/
    @javax.annotation.Nullable
    @JsonProperty("operation")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }

    public PolicyEvaluation hierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
        return this;
    }

    /**
     * Get hierarchyId
     * @return hierarchyId
     **/
    @javax.annotation.Nullable
    @JsonProperty("hierarchy_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getHierarchyId() {
        return hierarchyId;
    }
    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public PolicyEvaluation parentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    /**
     * Get parentId
     * @return parentId
     **/
    @javax.annotation.Nullable
    @JsonProperty("parent_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getParentId() {
        return parentId;
    }
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public PolicyEvaluation level(Long level) {
        this.level = level;
        return this;
    }

    /**
     * Get level
     * @return level
     **/
    @javax.annotation.Nullable
    @JsonProperty("level")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLevel() {
        return level;
    }
    public void setLevel(Long level) {
        this.level = level;
    }

    public PolicyEvaluation notification(PolicyEvaluationNotification notification) {
        this.notification = notification;
        return this;
    }

    /**
     * Get notification
     * @return notification
     **/
    @javax.annotation.Nullable
    @JsonProperty("notification")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public PolicyEvaluationNotification getNotification() {
        return notification;
    }
    public void setNotification(PolicyEvaluationNotification notification) {
        this.notification = notification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyEvaluation policyEvaluation = (PolicyEvaluation) o;
        return Objects.equals(this.outcome, policyEvaluation.outcome) &&
                Objects.equals(this.actions, policyEvaluation.actions) &&
                Objects.equals(this.reason, policyEvaluation.reason) &&
                Objects.equals(this.tenantId, policyEvaluation.tenantId) &&
                Objects.equals(this.transformedItemId, policyEvaluation.transformedItemId) &&
                Objects.equals(this.transformationConvention, policyEvaluation.transformationConvention) &&
                Objects.equals(this.transformationCost, policyEvaluation.transformationCost) &&
                Objects.equals(this.transformLocation, policyEvaluation.transformLocation) &&
                Objects.equals(this.transformSpecs, policyEvaluation.transformSpecs) &&
                Objects.equals(this.transformedColumns, policyEvaluation.transformedColumns) &&
                Objects.equals(this.policyDescriptor, policyEvaluation.policyDescriptor) &&
                Objects.equals(this.itemId, policyEvaluation.itemId) &&
                Objects.equals(this.operation, policyEvaluation.operation) &&
                Objects.equals(this.hierarchyId, policyEvaluation.hierarchyId) &&
                Objects.equals(this.parentId, policyEvaluation.parentId) &&
                Objects.equals(this.level, policyEvaluation.level) &&
                Objects.equals(this.notification, policyEvaluation.notification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outcome, actions, reason, tenantId, transformedItemId, transformationConvention, transformationCost, transformLocation, transformSpecs, transformedColumns, policyDescriptor, itemId, operation, hierarchyId, parentId, level, notification);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyEvaluation {\n");
        sb.append("    outcome: ").append(toIndentedString(outcome)).append("\n");
        sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
        sb.append("    transformedItemId: ").append(toIndentedString(transformedItemId)).append("\n");
        sb.append("    transformationConvention: ").append(toIndentedString(transformationConvention)).append("\n");
        sb.append("    transformationCost: ").append(toIndentedString(transformationCost)).append("\n");
        sb.append("    transformLocation: ").append(toIndentedString(transformLocation)).append("\n");
        sb.append("    transformSpecs: ").append(toIndentedString(transformSpecs)).append("\n");
        sb.append("    transformedColumns: ").append(toIndentedString(transformedColumns)).append("\n");
        sb.append("    policyDescriptor: ").append(toIndentedString(policyDescriptor)).append("\n");
        sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
        sb.append("    operation: ").append(toIndentedString(operation)).append("\n");
        sb.append("    hierarchyId: ").append(toIndentedString(hierarchyId)).append("\n");
        sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
        sb.append("    level: ").append(toIndentedString(level)).append("\n");
        sb.append("    notification: ").append(toIndentedString(notification)).append("\n");
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
