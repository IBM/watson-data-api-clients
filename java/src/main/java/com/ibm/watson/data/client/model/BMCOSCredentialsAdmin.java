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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * The Bluemix Cloud Object Storage (BMCOS) admin credentials..
 */
@ApiModel(description = "The Bluemix Cloud Object Storage (BMCOS) admin credentials..")
@JsonPropertyOrder({
        BMCOSCredentialsAdmin.JSON_PROPERTY_ACCESS_KEY_ID,
        BMCOSCredentialsAdmin.JSON_PROPERTY_API_KEY,
        BMCOSCredentialsAdmin.JSON_PROPERTY_SECRET_ACCESS_KEY,
        BMCOSCredentialsAdmin.JSON_PROPERTY_SERVICE_ID
})
public class BMCOSCredentialsAdmin {

    public static final String JSON_PROPERTY_ACCESS_KEY_ID = "access_key_id";
    private String accessKeyId;

    public static final String JSON_PROPERTY_API_KEY = "api_key";
    private String apiKey;

    public static final String JSON_PROPERTY_SECRET_ACCESS_KEY = "secret_access_key";
    private String secretAccessKey;

    public static final String JSON_PROPERTY_SERVICE_ID = "service_id";
    private String serviceId;

    public BMCOSCredentialsAdmin accessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    /**
     * HMAC access key ID for associated Cloud Object Storage and specific user
     *role.
     * @return accessKeyId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            example = "abcdefABCDEF0123456789abcdefABCD",
            value = "HMAC access key ID for associated Cloud Object Storage and specific user role.")
    @JsonProperty(JSON_PROPERTY_ACCESS_KEY_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public BMCOSCredentialsAdmin apiKey(String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * API key for specific user role. The key should be 44 characters long and
     *contain only number, letters, underscores and dashes.
     * @return apiKey
     **/
    @ApiModelProperty(
            example = "Nr0aWPAlj---hlfOMxTfPHe_OWrgH8kqAkqFhUUugqN8", required = true,
            value = "API key for specific user role. The key should be 44 characters long and contain only number, letters, underscores and dashes.")
    @JsonProperty(JSON_PROPERTY_API_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) { this.apiKey = apiKey; }

    public BMCOSCredentialsAdmin secretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
        return this;
    }

    /**
     * HMAC secret access key for associated Cloud Object Storage and specific
     *user role.
     * @return secretAccessKey
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            example = "abcdefABCDEF0123456789abcdefABCDEF0123456789abcd",
            value = "HMAC secret access key for associated Cloud Object Storage and specific user role.")
    @JsonProperty(JSON_PROPERTY_SECRET_ACCESS_KEY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    public BMCOSCredentialsAdmin serviceId(String serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    /**
     * IAM Service ID for specific user role. Should be a GUID prefixed with
     *&#39;iam-ServiceId-&#39;.
     * @return serviceId
     **/
    @ApiModelProperty(
            example = "iam-ServiceId-dde7839f-1cca-4626-a499-889398b5d6dd",
            required = true,
            value = "IAM Service ID for specific user role. Should be a GUID prefixed with 'iam-ServiceId-'.")
    @JsonProperty(JSON_PROPERTY_SERVICE_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) { this.serviceId = serviceId; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BMCOSCredentialsAdmin bmCOSCredentialsAdmin = (BMCOSCredentialsAdmin)o;
        return Objects.equals(this.accessKeyId,
                bmCOSCredentialsAdmin.accessKeyId) &&
                Objects.equals(this.apiKey, bmCOSCredentialsAdmin.apiKey) &&
                Objects.equals(this.secretAccessKey,
                        bmCOSCredentialsAdmin.secretAccessKey) &&
                Objects.equals(this.serviceId, bmCOSCredentialsAdmin.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessKeyId, apiKey, secretAccessKey, serviceId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BMCOSCredentialsAdmin {\n");
        sb.append("    accessKeyId: ")
                .append(toIndentedString(accessKeyId))
                .append("\n");
        sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
        sb.append("    secretAccessKey: ")
                .append(toIndentedString(secretAccessKey))
                .append("\n");
        sb.append("    serviceId: ")
                .append(toIndentedString(serviceId))
                .append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
