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
 * StewardshipServicesConfig
 */
public class StewardshipServicesConfig {

    private String accessServiceRootURL;
    private String accessServiceServerName;
    private Connection inboundRequestConnection;

    public StewardshipServicesConfig accessServiceRootURL(String accessServiceRootURL) {
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

    public StewardshipServicesConfig accessServiceServerName(String accessServiceServerName) {
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

    public StewardshipServicesConfig inboundRequestConnection(Connection inboundRequestConnection) {
        this.inboundRequestConnection = inboundRequestConnection;
        return this;
    }

    /**
     * Get inboundRequestConnection
     * @return inboundRequestConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("inboundRequestConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getInboundRequestConnection() { return inboundRequestConnection; }
    public void setInboundRequestConnection(Connection inboundRequestConnection) { this.inboundRequestConnection = inboundRequestConnection; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        StewardshipServicesConfig stewardshipServicesConfig = (StewardshipServicesConfig)o;
        return Objects.equals(this.accessServiceRootURL, stewardshipServicesConfig.accessServiceRootURL) &&
                Objects.equals(this.accessServiceServerName, stewardshipServicesConfig.accessServiceServerName) &&
                Objects.equals(this.inboundRequestConnection, stewardshipServicesConfig.inboundRequestConnection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessServiceRootURL, accessServiceServerName,
                inboundRequestConnection);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StewardshipServicesConfig {\n");
        sb.append("    accessServiceRootURL: ").append(toIndentedString(accessServiceRootURL)).append("\n");
        sb.append("    accessServiceServerName: ").append(toIndentedString(accessServiceServerName)).append("\n");
        sb.append("    inboundRequestConnection: ").append(toIndentedString(inboundRequestConnection)).append("\n");
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
