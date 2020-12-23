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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Details about the attachments that should be uploaded with this model. 
 */
public class ContentLocation {

    private List<ContentInfo> contents = new ArrayList<>();
    private String type;
    private Map<String, String> connection = null;
    private Map<String, String> location = null;

    public ContentLocation contents(List<ContentInfo> contents) {
        this.contents = contents;
        return this;
    }

    public ContentLocation addContentsItem(ContentInfo contentsItem) {
        this.contents.add(contentsItem);
        return this;
    }

    /**
     * The content information to be uploaded.
     * @return contents
     **/
    @JsonProperty("contents")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<ContentInfo> getContents() { return contents; }
    public void setContents(List<ContentInfo> contents) { this.contents = contents; }

    public ContentLocation type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the connection. Currently only &#x60;s3&#x60; is supported on public cloud and only &#x60;fs&#x60; is supported on an IBM Cloud Pak.  For type &#x60;s3&#x60; the fields &#x60;connection&#x60; and &#x60;location&#x60; are required and at least the following fields are expected: &#x60;&#x60;&#x60; \&quot;connection\&quot;: {   \&quot;access_key_id\&quot;: \&quot;...\&quot;,   \&quot;secret_access_key\&quot;: \&quot;...\&quot;,   \&quot;endpoint_url\&quot;: \&quot;...\&quot; }, \&quot;location\&quot;: {   \&quot;bucket\&quot;: \&quot;...\&quot; } &#x60;&#x60;&#x60;   For type &#x60;fs&#x60; the fields &#x60;connection&#x60; and &#x60;location&#x60; are not required.
     * @return type
     **/
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public ContentLocation connection(Map<String, String> connection) {
        this.connection = connection;
        return this;
    }

    public ContentLocation putConnectionItem(String key, String connectionItem) {
        if (this.connection == null) {
            this.connection = new HashMap<>();
        }
        this.connection.put(key, connectionItem);
        return this;
    }

    /**
     * Connection properties (eg. '{"access_key_id": "12df342c7a384dba872af0861a978fbc1", "secret_access_key": "53edcacca4e3ab87cc9e5b3d113a15675a3c23da899907c", "endpoint_url": "https://s3.us-west.cloud-object-storage.appdomain.cloud"}').
     * @return connection
     **/
    @javax.annotation.Nullable
    @JsonProperty("connection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, String> getConnection() { return connection; }
    public void setConnection(Map<String, String> connection) { this.connection = connection; }

    public ContentLocation location(Map<String, String> location) {
        this.location = location;
        return this;
    }

    public ContentLocation putLocationItem(String key, String locationItem) {
        if (this.location == null) {
            this.location = new HashMap<>();
        }
        this.location.put(key, locationItem);
        return this;
    }

    /**
     * Location properties (eg. '{"bucket": "my-training-output"}').
     * @return location
     **/
    @javax.annotation.Nullable
    @JsonProperty("location")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, String> getLocation() { return location; }
    public void setLocation(Map<String, String> location) { this.location = location; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ContentLocation contentLocation = (ContentLocation) o;
        return Objects.equals(this.contents, contentLocation.contents) &&
                Objects.equals(this.type, contentLocation.type) &&
                Objects.equals(this.connection, contentLocation.connection) &&
                Objects.equals(this.location, contentLocation.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contents, type, connection, location);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ContentLocation {\n");
        sb.append("    contents: ").append(toIndentedString(contents)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    connection: ").append(toIndentedString(connection)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
