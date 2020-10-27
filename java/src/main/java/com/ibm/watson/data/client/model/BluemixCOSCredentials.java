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
public class BluemixCOSCredentials {

    private String apiKey;
    private String serviceId;
    private String accessKeyId;
    private String secretAccessKey;

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

    public BluemixCOSCredentials accessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    /**
     * Get accessKeyId
     * @return accessKeyId
     **/
    @javax.annotation.Nullable
    @JsonProperty("access_key_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAccessKeyId() { return accessKeyId; }
    public void setAccessKeyId(String accessKeyId) { this.accessKeyId = accessKeyId; }

    public BluemixCOSCredentials secretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
        return this;
    }

    /**
     * Get secretAccessKey
     * @return secretAccessKey
     **/
    @javax.annotation.Nullable
    @JsonProperty("secret_access_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSecretAccessKey() { return secretAccessKey; }
    public void setSecretAccessKey(String secretAccessKey) { this.secretAccessKey = secretAccessKey; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BluemixCOSCredentials bluemixCOSCredentials = (BluemixCOSCredentials)o;
        return Objects.equals(this.apiKey, bluemixCOSCredentials.apiKey) &&
                Objects.equals(this.serviceId, bluemixCOSCredentials.serviceId) &&
                Objects.equals(this.accessKeyId, bluemixCOSCredentials.accessKeyId) &&
                Objects.equals(this.secretAccessKey, bluemixCOSCredentials.secretAccessKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, serviceId, accessKeyId, secretAccessKey);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BluemixCOSCredentials {\n");
        sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
        sb.append("    serviceId: ").append(toIndentedString(serviceId)).append("\n");
        sb.append("    accessKeyId: ").append(toIndentedString(accessKeyId)).append("\n");
        sb.append("    secretAccessKey: ").append(toIndentedString(secretAccessKey)).append("\n");
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
