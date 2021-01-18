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
 * Bucket Credentials
 */
public class Credentials {

    private String accessKeyId;
    private String secretAccessKey;

    public Credentials accessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    /**
     * Get accessKeyId
     * @return accessKeyId
     **/
    @JsonProperty("access_key_id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getAccessKeyId() { return accessKeyId; }
    public void setAccessKeyId(String accessKeyId) { this.accessKeyId = accessKeyId; }

    public Credentials secretAccessKey(String secretAccessKey) {
        this.secretAccessKey = secretAccessKey;
        return this;
    }

    /**
     * Get secretAccessKey
     * @return secretAccessKey
     **/
    @JsonProperty("secret_access_key")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getSecretAccessKey() { return secretAccessKey; }
    public void setSecretAccessKey(String secretAccessKey) { this.secretAccessKey = secretAccessKey; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
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
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    accessKeyId: ").append(toIndentedString(accessKeyId)).append("\n");
        sb.append("    secretAccessKey: ").append(toIndentedString(secretAccessKey)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
