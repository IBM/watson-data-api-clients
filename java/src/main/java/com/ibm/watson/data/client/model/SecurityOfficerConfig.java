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
import java.util.Objects;

/**
 * SecurityOfficerConfig
 */
public class SecurityOfficerConfig {

    private String accessServiceRootURL;
    private String accessServiceServerName;
    private String securityOfficerServerInTopicName;
    private Connection securityOfficerServerInTopic;
    private String securityOfficerServerOutTopicName;
    private Connection securityOfficerServerOutTopic;

    public SecurityOfficerConfig accessServiceRootURL(String accessServiceRootURL) {
        this.accessServiceRootURL = accessServiceRootURL;
        return this;
    }

    /**
     * Get accessServiceRootURL
     * @return accessServiceRootURL
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceRootURL")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceRootURL() { return accessServiceRootURL; }
    public void setAccessServiceRootURL(String accessServiceRootURL) { this.accessServiceRootURL = accessServiceRootURL; }

    public SecurityOfficerConfig accessServiceServerName(String accessServiceServerName) {
        this.accessServiceServerName = accessServiceServerName;
        return this;
    }

    /**
     * Get accessServiceServerName
     * @return accessServiceServerName
     **/
    @javax.annotation.Nullable
    @JsonProperty("accessServiceServerName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessServiceServerName() { return accessServiceServerName; }
    public void setAccessServiceServerName(String accessServiceServerName) { this.accessServiceServerName = accessServiceServerName; }

    public SecurityOfficerConfig securityOfficerServerInTopicName(String securityOfficerServerInTopicName) {
        this.securityOfficerServerInTopicName = securityOfficerServerInTopicName;
        return this;
    }

    /**
     * Get securityOfficerServerInTopicName
     * @return securityOfficerServerInTopicName
     **/
    @javax.annotation.Nullable
    @JsonProperty("securityOfficerServerInTopicName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecurityOfficerServerInTopicName() { return securityOfficerServerInTopicName; }
    public void setSecurityOfficerServerInTopicName(String securityOfficerServerInTopicName) { this.securityOfficerServerInTopicName = securityOfficerServerInTopicName; }

    public SecurityOfficerConfig securityOfficerServerInTopic(Connection securityOfficerServerInTopic) {
        this.securityOfficerServerInTopic = securityOfficerServerInTopic;
        return this;
    }

    /**
     * Get securityOfficerServerInTopic
     * @return securityOfficerServerInTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("securityOfficerServerInTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getSecurityOfficerServerInTopic() { return securityOfficerServerInTopic; }
    public void setSecurityOfficerServerInTopic(Connection securityOfficerServerInTopic) { this.securityOfficerServerInTopic = securityOfficerServerInTopic; }

    public SecurityOfficerConfig securityOfficerServerOutTopicName(String securityOfficerServerOutTopicName) {
        this.securityOfficerServerOutTopicName = securityOfficerServerOutTopicName;
        return this;
    }

    /**
     * Get securityOfficerServerOutTopicName
     * @return securityOfficerServerOutTopicName
     **/
    @javax.annotation.Nullable
    @JsonProperty("securityOfficerServerOutTopicName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecurityOfficerServerOutTopicName() { return securityOfficerServerOutTopicName; }
    public void setSecurityOfficerServerOutTopicName(String securityOfficerServerOutTopicName) { this.securityOfficerServerOutTopicName = securityOfficerServerOutTopicName; }

    public SecurityOfficerConfig securityOfficerServerOutTopic(Connection securityOfficerServerOutTopic) {
        this.securityOfficerServerOutTopic = securityOfficerServerOutTopic;
        return this;
    }

    /**
     * Get securityOfficerServerOutTopic
     * @return securityOfficerServerOutTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("securityOfficerServerOutTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getSecurityOfficerServerOutTopic() { return securityOfficerServerOutTopic; }
    public void setSecurityOfficerServerOutTopic(Connection securityOfficerServerOutTopic) { this.securityOfficerServerOutTopic = securityOfficerServerOutTopic; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        SecurityOfficerConfig securityOfficerConfig = (SecurityOfficerConfig)o;
        return Objects.equals(this.accessServiceRootURL, securityOfficerConfig.accessServiceRootURL) &&
                Objects.equals(this.accessServiceServerName, securityOfficerConfig.accessServiceServerName) &&
                Objects.equals(this.securityOfficerServerInTopicName, securityOfficerConfig.securityOfficerServerInTopicName) &&
                Objects.equals(this.securityOfficerServerInTopic, securityOfficerConfig.securityOfficerServerInTopic) &&
                Objects.equals(this.securityOfficerServerOutTopicName, securityOfficerConfig.securityOfficerServerOutTopicName) &&
                Objects.equals(this.securityOfficerServerOutTopic, securityOfficerConfig.securityOfficerServerOutTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                accessServiceRootURL, accessServiceServerName,
                securityOfficerServerInTopicName, securityOfficerServerInTopic,
                securityOfficerServerOutTopicName, securityOfficerServerOutTopic);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SecurityOfficerConfig {\n");
        sb.append("    accessServiceRootURL: ").append(toIndentedString(accessServiceRootURL)).append("\n");
        sb.append("    accessServiceServerName: ").append(toIndentedString(accessServiceServerName)).append("\n");
        sb.append("    securityOfficerServerInTopicName: ").append(toIndentedString(securityOfficerServerInTopicName)).append("\n");
        sb.append("    securityOfficerServerInTopic: ").append(toIndentedString(securityOfficerServerInTopic)).append("\n");
        sb.append("    securityOfficerServerOutTopicName: ").append(toIndentedString(securityOfficerServerOutTopicName)).append("\n");
        sb.append("    securityOfficerServerOutTopic: ").append(toIndentedString(securityOfficerServerOutTopic)).append("\n");
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
