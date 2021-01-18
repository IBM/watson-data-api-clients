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
 * Bluemix COS  Credentials
 */
public class BluemixCOSCredentials extends Credentials {

    private String apiKey;
    private String serviceId;

    public BluemixCOSCredentials apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Get apiKey
     * @return apiKey
     **/
    @javax.annotation.Nullable
    @JsonProperty("api_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getApiKey() { return apiKey; }
    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public BluemixCOSCredentials serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * Get serviceId
     * @return serviceId
     **/
    @javax.annotation.Nullable
    @JsonProperty("service_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getServiceId() { return serviceId; }
    public void setServiceId(String serviceId) { this.serviceId = serviceId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BluemixCOSCredentials bluemixCOSCredentials = (BluemixCOSCredentials)o;
        return super.equals(o) &&
                Objects.equals(this.apiKey, bluemixCOSCredentials.apiKey) &&
                Objects.equals(this.serviceId, bluemixCOSCredentials.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), apiKey, serviceId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BluemixCOSCredentials {\n");
        super.toString(sb);
        sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
        sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
