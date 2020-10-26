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
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * CatalogBucket
 */
@JsonPropertyOrder({
        CatalogBucket.JSON_PROPERTY_BUCKET_NAME,
        CatalogBucket.JSON_PROPERTY_BUCKET_LOCATION,
        CatalogBucket.JSON_PROPERTY_ENDPOINT_URL,
        CatalogBucket.JSON_PROPERTY_RESOURCE_INSTANCE_ID,
        CatalogBucket.JSON_PROPERTY_CREDENTIALS_RW,
        CatalogBucket.JSON_PROPERTY_BLUEMIX_COS_CREDENTIALS
})
public class CatalogBucket {

    public static final String JSON_PROPERTY_BUCKET_NAME = "bucket_name";
    private String bucketName;

    public static final String JSON_PROPERTY_BUCKET_LOCATION = "bucket_location";
    private String bucketLocation;

    public static final String JSON_PROPERTY_ENDPOINT_URL = "endpoint_url";
    private String endpointUrl;

    public static final String JSON_PROPERTY_RESOURCE_INSTANCE_ID = "resource_instance_id";
    private String resourceInstanceId;

    public static final String JSON_PROPERTY_CREDENTIALS_RW = "credentials_rw";
    private Credentials credentialsRw;

    public static final String JSON_PROPERTY_BLUEMIX_COS_CREDENTIALS = "bluemix_cos_credentials";
    private BluemixCredentialsForCOS bluemixCosCredentials;

    public CatalogBucket bucketName(String bucketName) {
        this.bucketName = bucketName;
        return this;
    }

    /**
     * Get bucketName
     * @return bucketName
     **/
    @ApiModelProperty(example = "Bucket Name", required = true, value = "")
    @JsonProperty(JSON_PROPERTY_BUCKET_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) { this.bucketName = bucketName; }

    public CatalogBucket bucketLocation(String bucketLocation) {
        this.bucketLocation = bucketLocation;
        return this;
    }

    /**
     * Get bucketLocation
     * @return bucketLocation
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_BUCKET_LOCATION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getBucketLocation() {
        return bucketLocation;
    }

    public void setBucketLocation(String bucketLocation) {
        this.bucketLocation = bucketLocation;
    }

    public CatalogBucket endpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
        return this;
    }

    /**
     * Get endpointUrl
     * @return endpointUrl
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ENDPOINT_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getEndpointUrl() {
        return endpointUrl;
    }

    public void setEndpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
    }

    public CatalogBucket resourceInstanceId(String resourceInstanceId) {
        this.resourceInstanceId = resourceInstanceId;
        return this;
    }

    /**
     * Get resourceInstanceId
     * @return resourceInstanceId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Bluemix COS Resource Instance ID ", value = "")
    @JsonProperty(JSON_PROPERTY_RESOURCE_INSTANCE_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getResourceInstanceId() {
        return resourceInstanceId;
    }

    public void setResourceInstanceId(String resourceInstanceId) {
        this.resourceInstanceId = resourceInstanceId;
    }

    public CatalogBucket credentialsRw(Credentials credentialsRw) {
        this.credentialsRw = credentialsRw;
        return this;
    }

    /**
     * Get credentialsRw
     * @return credentialsRw
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_CREDENTIALS_RW)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Credentials getCredentialsRw() {
        return credentialsRw;
    }

    public void setCredentialsRw(Credentials credentialsRw) {
        this.credentialsRw = credentialsRw;
    }

    public CatalogBucket
    bluemixCosCredentials(BluemixCredentialsForCOS bluemixCosCredentials) {
        this.bluemixCosCredentials = bluemixCosCredentials;
        return this;
    }

    /**
     * Get bluemixCosCredentials
     * @return bluemixCosCredentials
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_BLUEMIX_COS_CREDENTIALS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BluemixCredentialsForCOS getBluemixCosCredentials() {
        return bluemixCosCredentials;
    }

    public void setBluemixCosCredentials(BluemixCredentialsForCOS bluemixCosCredentials) {
        this.bluemixCosCredentials = bluemixCosCredentials;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CatalogBucket catalogBucket = (CatalogBucket)o;
        return Objects.equals(this.bucketName, catalogBucket.bucketName) &&
                Objects.equals(this.bucketLocation, catalogBucket.bucketLocation) &&
                Objects.equals(this.endpointUrl, catalogBucket.endpointUrl) &&
                Objects.equals(this.resourceInstanceId,
                        catalogBucket.resourceInstanceId) &&
                Objects.equals(this.credentialsRw, catalogBucket.credentialsRw) &&
                Objects.equals(this.bluemixCosCredentials,
                        catalogBucket.bluemixCosCredentials);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucketName, bucketLocation, endpointUrl,
                resourceInstanceId, credentialsRw,
                bluemixCosCredentials);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CatalogBucket {\n");
        sb.append("    bucketName: ")
                .append(toIndentedString(bucketName))
                .append("\n");
        sb.append("    bucketLocation: ")
                .append(toIndentedString(bucketLocation))
                .append("\n");
        sb.append("    endpointUrl: ")
                .append(toIndentedString(endpointUrl))
                .append("\n");
        sb.append("    resourceInstanceId: ")
                .append(toIndentedString(resourceInstanceId))
                .append("\n");
        sb.append("    credentialsRw: ")
                .append(toIndentedString(credentialsRw))
                .append("\n");
        sb.append("    bluemixCosCredentials: ")
                .append(toIndentedString(bluemixCosCredentials))
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
