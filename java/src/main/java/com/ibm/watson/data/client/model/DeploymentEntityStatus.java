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

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibm.watson.data.client.model.enums.DeploymentState;

import java.util.ArrayList;

/**
 * Specifies the current status, additional information about the deployment and any failure messaages in case of deployment failures. 
 */
public class DeploymentEntityStatus {

    private DeploymentState state;
    private DeploymentEntityStatusMessage message;
    private WMLError failure;
    private UrlDetails onlineUrl;
    private List<UrlDetails> virtualDeploymentDownloads = null;

    public DeploymentEntityStatus state(DeploymentState state) {
        this.state = state;
        return this;
    }

    /**
     * Specifies the current state of the deployment.
     * @return state
     **/
    @javax.annotation.Nullable
    @JsonProperty("state")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeploymentState getState() { return state; }
    public void setState(DeploymentState state) { this.state = state; }

    public DeploymentEntityStatus message(DeploymentEntityStatusMessage message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * @return message
     **/
    @javax.annotation.Nullable
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeploymentEntityStatusMessage getMessage() { return message; }
    public void setMessage(DeploymentEntityStatusMessage message) { this.message = message; }

    public DeploymentEntityStatus failure(WMLError failure) {
        this.failure = failure;
        return this;
    }

    /**
     * Get failure
     * @return failure
     **/
    @javax.annotation.Nullable
    @JsonProperty("failure")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public WMLError getFailure() { return failure; }
    public void setFailure(WMLError failure) { this.failure = failure; }

    public DeploymentEntityStatus onlineUrl(UrlDetails onlineUrl) {
        this.onlineUrl = onlineUrl;
        return this;
    }

    /**
     * Get the URL to be used for submitting online prediction API requests to the concerned deployment.
     * @return onlineUrl
     **/
    @javax.annotation.Nullable
    @JsonProperty("online_url")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public UrlDetails getOnlineUrl() { return onlineUrl; }
    public void setOnlineUrl(UrlDetails onlineUrl) { this.onlineUrl = onlineUrl; }

    public DeploymentEntityStatus virtualDeploymentDownloads(List<UrlDetails> virtualDeploymentDownloads) {
        this.virtualDeploymentDownloads = virtualDeploymentDownloads;
        return this;
    }

    public DeploymentEntityStatus addVirtualDeploymentDownloadsItem(UrlDetails virtualDeploymentDownloadsItem) {
        if (this.virtualDeploymentDownloads == null) {
            this.virtualDeploymentDownloads = new ArrayList<>();
        }
        this.virtualDeploymentDownloads.add(virtualDeploymentDownloadsItem);
        return this;
    }

    /**
     * The model download URLs in the context of virtual deployments.
     * @return virtualDeploymentDownloads
     **/
    @javax.annotation.Nullable
    @JsonProperty("virtual_deployment_downloads")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<UrlDetails> getVirtualDeploymentDownloads() { return virtualDeploymentDownloads; }
    public void setVirtualDeploymentDownloads(List<UrlDetails> virtualDeploymentDownloads) { this.virtualDeploymentDownloads = virtualDeploymentDownloads; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentEntityStatus deploymentEntityAllOfStatus = (DeploymentEntityStatus) o;
        return Objects.equals(this.state, deploymentEntityAllOfStatus.state) &&
                Objects.equals(this.message, deploymentEntityAllOfStatus.message) &&
                Objects.equals(this.failure, deploymentEntityAllOfStatus.failure) &&
                Objects.equals(this.onlineUrl, deploymentEntityAllOfStatus.onlineUrl) &&
                Objects.equals(this.virtualDeploymentDownloads, deploymentEntityAllOfStatus.virtualDeploymentDownloads);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, message, failure, onlineUrl, virtualDeploymentDownloads);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentEntityAllOfStatus {\n");
        sb.append("    state: ").append(toIndentedString(state)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    failure: ").append(toIndentedString(failure)).append("\n");
        sb.append("    onlineUrl: ").append(toIndentedString(onlineUrl)).append("\n");
        sb.append("    virtualDeploymentDownloads: ").append(toIndentedString(virtualDeploymentDownloads)).append("\n");
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
