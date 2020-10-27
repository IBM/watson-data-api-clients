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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DiscoveryServerConfig
 */
public class DiscoveryServerConfig {

    private String accessServiceRootURL;
    private String accessServiceServerName;
    private List<String> discoveryEngineGUIDs = null;

    public DiscoveryServerConfig accessServiceRootURL(String accessServiceRootURL) {
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

    public DiscoveryServerConfig accessServiceServerName(String accessServiceServerName) {
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

    public DiscoveryServerConfig discoveryEngineGUIDs(List<String> discoveryEngineGUIDs) {
        this.discoveryEngineGUIDs = discoveryEngineGUIDs;
        return this;
    }

    public DiscoveryServerConfig addDiscoveryEngineGUIDsItem(String discoveryEngineGUIDsItem) {
        if (this.discoveryEngineGUIDs == null) {
            this.discoveryEngineGUIDs = new ArrayList<>();
        }
        this.discoveryEngineGUIDs.add(discoveryEngineGUIDsItem);
        return this;
    }

    /**
     * Get discoveryEngineGUIDs
     * @return discoveryEngineGUIDs
     **/
    @javax.annotation.Nullable
    @JsonProperty("discoveryEngineGUIDs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getDiscoveryEngineGUIDs() { return discoveryEngineGUIDs; }
    public void setDiscoveryEngineGUIDs(List<String> discoveryEngineGUIDs) { this.discoveryEngineGUIDs = discoveryEngineGUIDs; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DiscoveryServerConfig discoveryServerConfig = (DiscoveryServerConfig)o;
        return Objects.equals(this.accessServiceRootURL, discoveryServerConfig.accessServiceRootURL) &&
                Objects.equals(this.accessServiceServerName, discoveryServerConfig.accessServiceServerName) &&
                Objects.equals(this.discoveryEngineGUIDs, discoveryServerConfig.discoveryEngineGUIDs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessServiceRootURL, accessServiceServerName,
                discoveryEngineGUIDs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveryServerConfig {\n");
        sb.append("    accessServiceRootURL: ").append(toIndentedString(accessServiceRootURL)).append("\n");
        sb.append("    accessServiceServerName: ").append(toIndentedString(accessServiceServerName)).append("\n");
        sb.append("    discoveryEngineGUIDs: ").append(toIndentedString(discoveryEngineGUIDs)).append("\n");
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
