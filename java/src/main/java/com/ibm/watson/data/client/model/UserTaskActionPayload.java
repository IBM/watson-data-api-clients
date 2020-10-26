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
import com.ibm.watson.data.client.model.enums.UserTaskAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UserTaskActionPayload
 */
public class UserTaskActionPayload {

    private UserTaskAction action;
    private String assignee;
    private List<FormPropertyInput> formProperties = null;

    public UserTaskActionPayload action(UserTaskAction action) {
        this.action = action;
        return this;
    }

    /**
     * claim, complete, maybe some more in the future...
     * @return action
     **/
    @JsonProperty("action")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public UserTaskAction getAction() { return action; }
    public void setAction(UserTaskAction action) { this.action = action; }

    public UserTaskActionPayload assignee(String assignee) {
        this.assignee = assignee;
        return this;
    }

    /**
     * optional, only for action claim, if empty or null then task will be
     * unclaimed
     * @return assignee
     **/
    @javax.annotation.Nullable
    @JsonProperty("assignee")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssignee() { return assignee; }
    public void setAssignee(String assignee) { this.assignee = assignee; }

    public UserTaskActionPayload formProperties(List<FormPropertyInput> formProperties) {
        this.formProperties = formProperties;
        return this;
    }

    public UserTaskActionPayload addFormPropertiesItem(FormPropertyInput formPropertiesItem) {
        if (this.formProperties == null) {
            this.formProperties = new ArrayList<>();
        }
        this.formProperties.add(formPropertiesItem);
        return this;
    }

    /**
     * Get formProperties
     * @return formProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("form_properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<FormPropertyInput> getFormProperties() { return formProperties; }
    public void setFormProperties(List<FormPropertyInput> formProperties) { this.formProperties = formProperties; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        UserTaskActionPayload userTaskActionPayload = (UserTaskActionPayload)o;
        return Objects.equals(this.action, userTaskActionPayload.action) &&
                Objects.equals(this.assignee, userTaskActionPayload.assignee) &&
                Objects.equals(this.formProperties,
                        userTaskActionPayload.formProperties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, assignee, formProperties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserTaskActionPayload {\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    assignee: ").append(toIndentedString(assignee)).append("\n");
        sb.append("    formProperties: ").append(toIndentedString(formProperties)).append("\n");
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
