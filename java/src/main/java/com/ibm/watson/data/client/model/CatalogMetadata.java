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
 * CatalogMetadata
 */
@JsonPropertyOrder({
        CatalogMetadata.JSON_PROPERTY_GUID,
        CatalogMetadata.JSON_PROPERTY_URL,
        CatalogMetadata.JSON_PROPERTY_CREATOR_ID,
        CatalogMetadata.JSON_PROPERTY_CREATE_TIME
})
public class CatalogMetadata {

    public static final String JSON_PROPERTY_GUID = "guid";
    private String guid;

    public static final String JSON_PROPERTY_URL = "url";
    private String url;

    public static final String JSON_PROPERTY_CREATOR_ID = "creator_id";
    private String creatorId;

    public static final String JSON_PROPERTY_CREATE_TIME = "create_time";
    private String createTime;

    /**
     * GUID of the Catalog instance
     * @return guid
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "GUID of the Catalog instance")
    @JsonProperty(JSON_PROPERTY_GUID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getGuid() {
        return guid;
    }

    /**
     * URL of the Catalog instance
     * @return url
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "URL of the Catalog instance")
    @JsonProperty(JSON_PROPERTY_URL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrl() {
        return url;
    }

    /**
     * ibmid-50h088ud1b
     * @return creatorId
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "ibmid-50h088ud1b")
    @JsonProperty(JSON_PROPERTY_CREATOR_ID)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreatorId() {
        return creatorId;
    }

    /**
     * Created time
     * @return createTime
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "Created time")
    @JsonProperty(JSON_PROPERTY_CREATE_TIME)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCreateTime() {
        return createTime;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CatalogMetadata catalogMetadata = (CatalogMetadata)o;
        return Objects.equals(this.guid, catalogMetadata.guid) &&
                Objects.equals(this.url, catalogMetadata.url) &&
                Objects.equals(this.creatorId, catalogMetadata.creatorId) &&
                Objects.equals(this.createTime, catalogMetadata.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, url, creatorId, createTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CatalogMetadata {\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    creatorId: ")
                .append(toIndentedString(creatorId))
                .append("\n");
        sb.append("    createTime: ")
                .append(toIndentedString(createTime))
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
