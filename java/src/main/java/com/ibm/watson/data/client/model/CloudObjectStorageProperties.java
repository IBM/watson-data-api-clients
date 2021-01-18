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
 * The storage properties for the Bluemix Cloud Object Storage (BMCOS) type.
 */
public class CloudObjectStorageProperties {

    private String bucketName;
    private String bucketRegion;
    private CloudObjectStorageCredentials credentials;
    private String endpointUrl;
    private Boolean keyProtect;

    public CloudObjectStorageProperties bucketName(String bucketName) {
        this.bucketName = bucketName;
        return this;
    }

    /**
     * The bucket name to connect to. The value should be between 3-64 characters
     * and should only contain letters, numbers and dashes.
     * @return bucketName
     **/
    @JsonProperty("bucket_name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getBucketName() { return bucketName; }
    public void setBucketName(String bucketName) { this.bucketName = bucketName; }

    public CloudObjectStorageProperties bucketRegion(String bucketRegion) {
        this.bucketRegion = bucketRegion;
        return this;
    }

    /**
     * A label representing the bucket region that corresponds to the
     * endpoint_url.
     * @return bucketRegion
     **/
    @JsonProperty("bucket_region")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getBucketRegion() { return bucketRegion; }
    public void setBucketRegion(String bucketRegion) { this.bucketRegion = bucketRegion; }

    public CloudObjectStorageProperties credentials(CloudObjectStorageCredentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * Get credentials
     * @return credentials
     **/
    @JsonProperty("credentials")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public CloudObjectStorageCredentials getCredentials() { return credentials; }
    public void setCredentials(CloudObjectStorageCredentials credentials) { this.credentials = credentials; }

    public CloudObjectStorageProperties endpointUrl(String endpointUrl) {
        this.endpointUrl = endpointUrl;
        return this;
    }

    /**
     * The endpoint URL to use for connecting clients to the object store. Clients
     * should dynamically compute the endpoint based on proximity to the
     * application servers accessing the object store to minimize latency. See
     * https://ibm-public-cos.github.io/crs-docs/endpoints.
     * @return endpointUrl
     **/
    @JsonProperty("endpoint_url")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getEndpointUrl() { return endpointUrl; }
    public void setEndpointUrl(String endpointUrl) { this.endpointUrl = endpointUrl; }

    public CloudObjectStorageProperties keyProtect(Boolean keyProtect) {
        this.keyProtect = keyProtect;
        return this;
    }

    /**
     * Used to indicate if the bucket created for the project is encrypted using
     * key protect.
     * @return keyProtect
     **/
    @javax.annotation.Nullable
    @JsonProperty("key_protect")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getKeyProtect() { return keyProtect; }
    public void setKeyProtect(Boolean keyProtect) { this.keyProtect = keyProtect; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CloudObjectStorageProperties cloudObjectStorageProperties = (CloudObjectStorageProperties)o;
        return Objects.equals(this.bucketName, cloudObjectStorageProperties.bucketName) &&
                Objects.equals(this.bucketRegion, cloudObjectStorageProperties.bucketRegion) &&
                Objects.equals(this.credentials, cloudObjectStorageProperties.credentials) &&
                Objects.equals(this.endpointUrl, cloudObjectStorageProperties.endpointUrl) &&
                Objects.equals(this.keyProtect, cloudObjectStorageProperties.keyProtect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bucketName, bucketRegion, credentials, endpointUrl,
                keyProtect);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CloudObjectStorageProperties {\n");
        sb.append("    bucketName: ").append(toIndentedString(bucketName)).append("\n");
        sb.append("    bucketRegion: ").append(toIndentedString(bucketRegion)).append("\n");
        sb.append("    credentials: ").append(toIndentedString(credentials)).append("\n");
        sb.append("    endpointUrl: ").append(toIndentedString(endpointUrl)).append("\n");
        sb.append("    keyProtect: ").append(toIndentedString(keyProtect)).append("\n");
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
