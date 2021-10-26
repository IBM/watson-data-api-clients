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
 * PolicyEvaluationNotification
 */
public class PolicyEvaluationNotification {

    private String assetName;
    private List<String> recipients = null;

    public PolicyEvaluationNotification assetName(String assetName) {
        this.assetName = assetName;
        return this;
    }

    /**
     * Get assetName
     * @return assetName
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAssetName() {
        return assetName;
    }
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public PolicyEvaluationNotification recipients(List<String> recipients) {
        this.recipients = recipients;
        return this;
    }

    public PolicyEvaluationNotification addRecipientsItem(String recipientsItem) {
        if (this.recipients == null) {
            this.recipients = new ArrayList<>();
        }
        this.recipients.add(recipientsItem);
        return this;
    }

    /**
     * Get recipients
     * @return recipients
     **/
    @javax.annotation.Nullable
    @JsonProperty("recipients")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getRecipients() {
        return recipients;
    }
    public void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        PolicyEvaluationNotification policyEvaluationNotification = (PolicyEvaluationNotification) o;
        return Objects.equals(this.assetName, policyEvaluationNotification.assetName) &&
                Objects.equals(this.recipients, policyEvaluationNotification.recipients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assetName, recipients);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PolicyEvaluationNotification {\n");
        sb.append("    assetName: ").append(toIndentedString(assetName)).append("\n");
        sb.append("    recipients: ").append(toIndentedString(recipients)).append("\n");
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
