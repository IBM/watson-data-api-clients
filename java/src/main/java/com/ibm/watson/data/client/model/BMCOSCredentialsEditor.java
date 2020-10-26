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
 * The Bluemix Cloud Object Storage (BMCOS) editor credentials..
 */
@ApiModel(description = "The Bluemix Cloud Object Storage (BMCOS) editor credentials..")
@JsonPropertyOrder({
        BMCOSCredentialsEditor.JSON_PROPERTY_ACCESS_KEY_ID,
        BMCOSCredentialsEditor.JSON_PROPERTY_API_KEY,
        BMCOSCredentialsEditor.JSON_PROPERTY_RESOURCE_KEY_CRN,
        BMCOSCredentialsEditor.JSON_PROPERTY_SECRET_ACCESS_KEY,
        BMCOSCredentialsEditor.JSON_PROPERTY_SERVICE_ID
})
public class BMCOSCredentialsEditor {

    public static final String JSON_PROPERTY_ACCESS_KEY_ID = "access_key_id";
    private String accessKeyId;

    public static final String JSON_PROPERTY_API_KEY = "api_key";
    private String apiKey;

    public static final String JSON_PROPERTY_RESOURCE_KEY_CRN = "resource_key_crn";
    private String resourceKeyCrn;

    public static final String JSON_PROPERTY_SECRET_ACCESS_KEY = "secret_access_key";
    private String secretAccessKey;

    public static final String JSON_PROPERTY_SERVICE_ID = "service_id";
    private String serviceId;

    public BMCOSCredentialsEditor accessKeyId(String accessKeyId) {
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

    public BMCOSCredentialsEditor apiKey(String apiKey) {
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

    public BMCOSCredentialsEditor resourceKeyCrn(String resourceKeyCrn) {
        this.resourceKeyCrn = resourceKeyCrn;
        return this;
    }

    /**
     * Resource key CRN. Must be provided with other HMAC credentials for
     *non-admin entries.
     * @return resourceKeyCrn
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            example = "crn:v1:bluemix:public:cloud-object-storage:global:a/b56585fe60e71be0a22e6587f781ed91:dc36b4a5-cf81-6541-b855-f68a6f321cac::",
            value = "Resource key CRN. Must be provided with other HMAC credentials for non-admin entries.")
    @JsonProperty(JSON_PROPERTY_RESOURCE_KEY_CRN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getResourceKeyCrn() {
        return resourceKeyCrn;
    }

    public void setResourceKeyCrn(String resourceKeyCrn) {
        this.resourceKeyCrn = resourceKeyCrn;
    }

    public BMCOSCredentialsEditor secretAccessKey(String secretAccessKey) {
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

    public BMCOSCredentialsEditor serviceId(String serviceId) {
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
        BMCOSCredentialsEditor bmCOSCredentialsEditor = (BMCOSCredentialsEditor)o;
        return Objects.equals(this.accessKeyId,
                bmCOSCredentialsEditor.accessKeyId) &&
                Objects.equals(this.apiKey, bmCOSCredentialsEditor.apiKey) &&
                Objects.equals(this.resourceKeyCrn,
                        bmCOSCredentialsEditor.resourceKeyCrn) &&
                Objects.equals(this.secretAccessKey,
                        bmCOSCredentialsEditor.secretAccessKey) &&
                Objects.equals(this.serviceId, bmCOSCredentialsEditor.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessKeyId, apiKey, resourceKeyCrn, secretAccessKey,
                serviceId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BMCOSCredentialsEditor {\n");
        sb.append("    accessKeyId: ")
                .append(toIndentedString(accessKeyId))
                .append("\n");
        sb.append("    apiKey: ").append(toIndentedString(apiKey)).append("\n");
        sb.append("    resourceKeyCrn: ")
                .append(toIndentedString(resourceKeyCrn))
                .append("\n");
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
