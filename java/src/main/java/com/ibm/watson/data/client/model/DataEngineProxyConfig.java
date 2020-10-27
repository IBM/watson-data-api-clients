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
 * DataEngineProxyConfig
 */
public class DataEngineProxyConfig {

    private String accessServiceRootURL;
    private String accessServiceServerName;
    private Connection dataEngineConnection;
    private Integer pollIntervalInSeconds;

    public DataEngineProxyConfig accessServiceRootURL(String accessServiceRootURL) {
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

    public DataEngineProxyConfig accessServiceServerName(String accessServiceServerName) {
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

    public DataEngineProxyConfig dataEngineConnection(Connection dataEngineConnection) {
        this.dataEngineConnection = dataEngineConnection;
        return this;
    }

    /**
     * Get dataEngineConnection
     * @return dataEngineConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataEngineConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getDataEngineConnection() { return dataEngineConnection; }
    public void setDataEngineConnection(Connection dataEngineConnection) { this.dataEngineConnection = dataEngineConnection; }

    public DataEngineProxyConfig pollIntervalInSeconds(Integer pollIntervalInSeconds) {
        this.pollIntervalInSeconds = pollIntervalInSeconds;
        return this;
    }

    /**
     * Get pollIntervalInSeconds
     * @return pollIntervalInSeconds
     **/
    @javax.annotation.Nullable
    @JsonProperty("pollIntervalInSeconds")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getPollIntervalInSeconds() { return pollIntervalInSeconds; }
    public void setPollIntervalInSeconds(Integer pollIntervalInSeconds) { this.pollIntervalInSeconds = pollIntervalInSeconds; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataEngineProxyConfig dataEngineProxyConfig = (DataEngineProxyConfig)o;
        return Objects.equals(this.accessServiceRootURL, dataEngineProxyConfig.accessServiceRootURL) &&
                Objects.equals(this.accessServiceServerName, dataEngineProxyConfig.accessServiceServerName) &&
                Objects.equals(this.dataEngineConnection, dataEngineProxyConfig.dataEngineConnection) &&
                Objects.equals(this.pollIntervalInSeconds, dataEngineProxyConfig.pollIntervalInSeconds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessServiceRootURL, accessServiceServerName,
                dataEngineConnection, pollIntervalInSeconds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataEngineProxyConfig {\n");
        sb.append("    accessServiceRootURL: ").append(toIndentedString(accessServiceRootURL)).append("\n");
        sb.append("    accessServiceServerName: ").append(toIndentedString(accessServiceServerName)).append("\n");
        sb.append("    dataEngineConnection: ").append(toIndentedString(dataEngineConnection)).append("\n");
        sb.append("    pollIntervalInSeconds: ").append(toIndentedString(pollIntervalInSeconds)).append("\n");
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
