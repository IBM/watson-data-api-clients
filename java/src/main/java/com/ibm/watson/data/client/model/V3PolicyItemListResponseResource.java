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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * V3PolicyItemListResponseResource
 */
public class V3PolicyItemListResponseResource {

    private V3PolicyResourceMetadata metadata;
    private V3PolicyItemListResponseEntity entity;

    public V3PolicyItemListResponseResource metadata(V3PolicyResourceMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @javax.annotation.Nonnull
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public V3PolicyResourceMetadata getMetadata() {
        return metadata;
    }
    public void setMetadata(V3PolicyResourceMetadata metadata) {
        this.metadata = metadata;
    }

    public V3PolicyItemListResponseResource entity(V3PolicyItemListResponseEntity entity) {
        this.entity = entity;
        return this;
    }

    /**
     * Get entity
     * @return entity
     **/
    @javax.annotation.Nonnull
    @JsonProperty("entity")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public V3PolicyItemListResponseEntity getEntity() {
        return entity;
    }
    public void setEntity(V3PolicyItemListResponseEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        V3PolicyItemListResponseResource v3PolicyItemListResponseResource = (V3PolicyItemListResponseResource) o;
        return Objects.equals(this.metadata, v3PolicyItemListResponseResource.metadata) &&
                Objects.equals(this.entity, v3PolicyItemListResponseResource.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, entity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V3PolicyItemListResponseResource {\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
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
