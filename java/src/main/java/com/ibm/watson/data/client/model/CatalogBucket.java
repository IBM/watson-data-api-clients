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
 * CatalogBucket
 */
public class CatalogBucket {

    private String bucketName;
    private String bucketLocation;
    private String endpointUrl;
    private String resourceInstanceId;
    private Credentials credentialsRw;
    private BluemixCredentialsForCOS bluemixCosCredentials;

    public CatalogBucket bucketName(String bucketName) {
        this.bucketName = bucketName;
        return this;
    }

    /**
     * Get bucketName
     * @return bucketName
     **/
    @JsonProperty("bucket_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getBucketName() { return bucketName; }
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
    @JsonProperty("bucket_location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getBucketLocation() { return bucketLocation; }
    public void setBucketLocation(String bucketLocation) { this.bucketLocation = bucketLocation; }

    public CatalogBucket endpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
        return this;
    }

    /**
     * Get endpointUrl
     * @return endpointUrl
     **/
    @javax.annotation.Nullable
    @JsonProperty("endpoint_url")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getEndpointUrl() { return endpointUrl; }
    public void setEndpointUrl(String endpointUrl) { this.endpointUrl = endpointUrl; }

    public CatalogBucket resourceInstanceId(String resourceInstanceId) {
        this.resourceInstanceId = resourceInstanceId;
        return this;
    }

    /**
     * Get resourceInstanceId
     * @return resourceInstanceId
     **/
    @javax.annotation.Nullable
    @JsonProperty("resource_instance_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getResourceInstanceId() { return resourceInstanceId; }
    public void setResourceInstanceId(String resourceInstanceId) { this.resourceInstanceId = resourceInstanceId; }

    public CatalogBucket credentialsRw(Credentials credentialsRw) {
        this.credentialsRw = credentialsRw;
        return this;
    }

    /**
     * Get credentialsRw
     * @return credentialsRw
     **/
    @javax.annotation.Nullable
    @JsonProperty("credentials_rw")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Credentials getCredentialsRw() { return credentialsRw; }
    public void setCredentialsRw(Credentials credentialsRw) { this.credentialsRw = credentialsRw; }

    public CatalogBucket bluemixCosCredentials(BluemixCredentialsForCOS bluemixCosCredentials) {
        this.bluemixCosCredentials = bluemixCosCredentials;
        return this;
    }

    /**
     * Get bluemixCosCredentials
     * @return bluemixCosCredentials
     **/
    @javax.annotation.Nullable
    @JsonProperty("bluemix_cos_credentials")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BluemixCredentialsForCOS getBluemixCosCredentials() { return bluemixCosCredentials; }
    public void setBluemixCosCredentials(BluemixCredentialsForCOS bluemixCosCredentials) { this.bluemixCosCredentials = bluemixCosCredentials; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CatalogBucket catalogBucket = (CatalogBucket)o;
        return Objects.equals(this.bucketName, catalogBucket.bucketName) &&
                Objects.equals(this.bucketLocation, catalogBucket.bucketLocation) &&
                Objects.equals(this.endpointUrl, catalogBucket.endpointUrl) &&
                Objects.equals(this.resourceInstanceId, catalogBucket.resourceInstanceId) &&
                Objects.equals(this.credentialsRw, catalogBucket.credentialsRw) &&
                Objects.equals(this.bluemixCosCredentials, catalogBucket.bluemixCosCredentials);
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
        sb.append("    bucketName: ").append(toIndentedString(bucketName)).append("\n");
        sb.append("    bucketLocation: ").append(toIndentedString(bucketLocation)).append("\n");
        sb.append("    endpointUrl: ").append(toIndentedString(endpointUrl)).append("\n");
        sb.append("    resourceInstanceId: ").append(toIndentedString(resourceInstanceId)).append("\n");
        sb.append("    credentialsRw: ").append(toIndentedString(credentialsRw)).append("\n");
        sb.append("    bluemixCosCredentials: ").append(toIndentedString(bluemixCosCredentials)).append("\n");
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
