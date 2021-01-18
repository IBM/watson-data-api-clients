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
 * CatalogMetadata
 */
public class CatalogMetadata {

    private String guid;
    private String url;
    private String creatorId;
    private String createTime;

    /**
     * GUID of the Catalog instance
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    /**
     * URL of the Catalog instance
     * @return url
     **/
    @javax.annotation.Nullable
    @JsonProperty("url")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    /**
     * ibmid-50h088ud1b
     * @return creatorId
     **/
    @javax.annotation.Nullable
    @JsonProperty("creator_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatorId() { return creatorId; }
    public void setCreatorId(String creatorId) { this.creatorId = creatorId; }

    /**
     * Created time
     * @return createTime
     **/
    @javax.annotation.Nullable
    @JsonProperty("create_time")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreateTime() { return createTime; }
    public void setCreateTime(String createTime) { this.createTime = createTime; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
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
        sb.append("    creatorId: ").append(toIndentedString(creatorId)).append("\n");
        sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
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
