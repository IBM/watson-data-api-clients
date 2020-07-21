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
 * Bucket Credentials
 */
@ApiModel(description = "Bucket Credentials")
@JsonPropertyOrder({
        Credentials.JSON_PROPERTY_ACCESS_KEY_ID,
        Credentials.JSON_PROPERTY_SECRET_ACCESS_KEY
})
public class Credentials {

    public static final String JSON_PROPERTY_ACCESS_KEY_ID = "access_key_id";
    private String accessKeyId;

    public static final String JSON_PROPERTY_SECRET_ACCESS_KEY = "secret_access_key";
    private String secretAccessKey;

    public Credentials accessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    /**
     * Get accessKeyId
     * @return accessKeyId
     **/
    @ApiModelProperty(example = "Access key", required = true, value = "")
    @JsonProperty(JSON_PROPERTY_ACCESS_KEY_ID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public Credentials secretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
        return this;
    }

    /**
     * Get secretAccessKey
     * @return secretAccessKey
     **/
    @ApiModelProperty(example = "Secret key", required = true, value = "")
    @JsonProperty(JSON_PROPERTY_SECRET_ACCESS_KEY)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getSecretAccessKey() {
        return secretAccessKey;
    }

    public void setSecretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Credentials credentials = (Credentials)o;
        return Objects.equals(this.accessKeyId, credentials.accessKeyId) &&
                Objects.equals(this.secretAccessKey, credentials.secretAccessKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessKeyId, secretAccessKey);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Credentials {\n");
        sb.append("    accessKeyId: ")
                .append(toIndentedString(accessKeyId))
                .append("\n");
        sb.append("    secretAccessKey: ")
                .append(toIndentedString(secretAccessKey))
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
