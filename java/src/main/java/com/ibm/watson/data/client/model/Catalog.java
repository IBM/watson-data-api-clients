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
 * Catalog
 */
@JsonPropertyOrder({
        Catalog.JSON_PROPERTY_METADATA,
        Catalog.JSON_PROPERTY_ENTITY,
        Catalog.JSON_PROPERTY_HREF
})
public class Catalog {

    public static final String JSON_PROPERTY_METADATA = "metadata";
    private CatalogMetadata metadata;

    public static final String JSON_PROPERTY_ENTITY = "entity";
    private CatalogEntity entity;

    public static final String JSON_PROPERTY_HREF = "href";
    private String href;

    public Catalog metadata(CatalogMetadata metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get metadata
     * @return metadata
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_METADATA)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public CatalogMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(CatalogMetadata metadata) {
        this.metadata = metadata;
    }

    public Catalog entity(CatalogEntity entity) {
        this.entity = entity;
        return this;
    }

    /**
     * Get entity
     * @return entity
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ENTITY)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public CatalogEntity getEntity() {
        return entity;
    }

    public void setEntity(CatalogEntity entity) { this.entity = entity; }

    /**
     * URL of the Catalog instance
     * @return href
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "URL of the Catalog instance")
    @JsonProperty(JSON_PROPERTY_HREF)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getHref() {
        return href;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Catalog catalog = (Catalog)o;
        return Objects.equals(this.metadata, catalog.metadata) &&
                Objects.equals(this.entity, catalog.entity) &&
                Objects.equals(this.href, catalog.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(metadata, entity, href);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Catalog {\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
        sb.append("    href: ").append(toIndentedString(href)).append("\n");
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
