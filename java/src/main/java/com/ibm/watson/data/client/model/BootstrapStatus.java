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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.watson.data.client.model.enums.BootstrapState;

import java.util.ArrayList;
import java.util.List;

/**
 * BootstrapStatus
 */
public class BootstrapStatus {

    private BootstrapState status;
    private String currentStep;
    private String completionMessage;
    private Integer completedRecords;
    private Integer totalRecords;
    private List<String> errors = null;

    public BootstrapStatus status(BootstrapState status) {
        this.status = status;
        return this;
    }

    /**
     * Current bootstrap status
     * @return status
     **/
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public BootstrapState getStatus() { return status; }
    public void setStatus(BootstrapState status) { this.status = status; }

    public BootstrapStatus currentStep(String currentStep) {
        this.currentStep = currentStep;
        return this;
    }

    /**
     * Current bootstrap activity
     * @return currentStep
     **/
    @javax.annotation.Nullable
    @JsonProperty("current_step")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCurrentStep() { return currentStep; }
    public void setCurrentStep(String currentStep) { this.currentStep = currentStep; }

    public BootstrapStatus completionMessage(String completionMessage) {
        this.completionMessage = completionMessage;
        return this;
    }

    /**
     * Overall outcome of the bootstrap process. Set once bootstrapping is finished.
     * @return completionMessage
     **/
    @javax.annotation.Nullable
    @JsonProperty("completion_message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCompletionMessage() { return completionMessage; }
    public void setCompletionMessage(String completionMessage) { this.completionMessage = completionMessage; }

    public BootstrapStatus completedRecords(Integer completedRecords) {
        this.completedRecords = completedRecords;
        return this;
    }

    /**
     * Number of records already bootstrapped successfully
     * @return completedRecords
     **/
    @javax.annotation.Nullable
    @JsonProperty("completed_records")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getCompletedRecords() { return completedRecords; }
    public void setCompletedRecords(Integer completedRecords) { this.completedRecords = completedRecords; }

    public BootstrapStatus totalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        return this;
    }

    /**
     * Total number of records to be processed by the bootstrap process
     * @return totalRecords
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_records")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalRecords() { return totalRecords; }
    public void setTotalRecords(Integer totalRecords) { this.totalRecords = totalRecords; }

    public BootstrapStatus errors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    public BootstrapStatus addErrorsItem(String errorsItem) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(errorsItem);
        return this;
    }

    /**
     * Bootstrap process errors
     * @return errors
     **/
    @javax.annotation.Nullable
    @JsonProperty("errors")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getErrors() { return errors; }
    public void setErrors(List<String> errors) { this.errors = errors; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BootstrapStatus that = (BootstrapStatus) o;
        return Objects.equals(this.status, that.status) &&
                Objects.equals(this.currentStep, that.currentStep) &&
                Objects.equals(this.completionMessage, that.completionMessage) &&
                Objects.equals(this.completedRecords, that.completedRecords) &&
                Objects.equals(this.totalRecords, that.totalRecords) &&
                Objects.equals(this.errors, that.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, currentStep, completionMessage, completedRecords,
                totalRecords, errors);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BootstrapStatus {\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    currentStep: ").append(toIndentedString(currentStep)).append("\n");
        sb.append("    completionMessage: ").append(toIndentedString(completionMessage)).append("\n");
        sb.append("    completedRecords: ").append(toIndentedString(completedRecords)).append("\n");
        sb.append("    totalRecords: ").append(toIndentedString(totalRecords)).append("\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
