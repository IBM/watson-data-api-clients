/*
 * Copyright 2021 IBM Corp. All Rights Reserved.
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

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * metadata object used in responses returned from policy management related APIs
 */
public class V3PolicyResourceMetadata {

    private String guid;
    private Date createdAt;
    private String creator;
    private Date updatedAt;
    private String modifier;

    public V3PolicyResourceMetadata guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * an unique identifier for the resource
     * @return guid
     **/
    @javax.annotation.Nonnull
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }

    public V3PolicyResourceMetadata createdAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * time when the resource was first created
     * @return createdAt
     **/
    @javax.annotation.Nonnull
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public V3PolicyResourceMetadata creator(String creator) {
        this.creator = creator;
        return this;
    }

    /**
     * an identifier for the creator of the resource
     * @return creator
     **/
    @javax.annotation.Nonnull
    @JsonProperty("creator")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getCreator() {
        return creator;
    }
    public void setCreator(String creator) {
        this.creator = creator;
    }

    public V3PolicyResourceMetadata updatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * time when the resource was last updated
     * @return updatedAt
     **/
    @javax.annotation.Nonnull
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public V3PolicyResourceMetadata modifier(String modifier) {
        this.modifier = modifier;
        return this;
    }

    /**
     * an identifier for  the last modifier of the resource
     * @return modifier
     **/
    @javax.annotation.Nonnull
    @JsonProperty("modifier")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getModifier() {
        return modifier;
    }
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3PolicyResourceMetadata v3PolicyResourceMetadata = (V3PolicyResourceMetadata) o;
        return Objects.equals(this.guid, v3PolicyResourceMetadata.guid) &&
                Objects.equals(this.createdAt, v3PolicyResourceMetadata.createdAt) &&
                Objects.equals(this.creator, v3PolicyResourceMetadata.creator) &&
                Objects.equals(this.updatedAt, v3PolicyResourceMetadata.updatedAt) &&
                Objects.equals(this.modifier, v3PolicyResourceMetadata.modifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, createdAt, creator, updatedAt, modifier);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3PolicyResourceMetadata {\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    creator: ").append(toIndentedString(creator)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
        sb.append("    modifier: ").append(toIndentedString(modifier)).append("\n");
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
