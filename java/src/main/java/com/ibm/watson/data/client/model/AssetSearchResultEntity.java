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
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Objects;

/**
 * AssetSearchResultEntity
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
public class AssetSearchResultEntity extends AbstractSearchResultEntity {

    private String catalogId;
    private List<String> connectionPaths;
    private String resourceKey;
    private List<String> columnTerms;
    private List<String> columnDataClassNames;
    private List<String> columnTermsGlobalIds;
    private List<String> columnNames;
    private List<String> columnTags;
    private List<String> connectionIds;

    @javax.annotation.Nullable
    @JsonProperty("catalog_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCatalogId() { return catalogId; }
    public void setCatalogId(String catalogId) { this.catalogId = catalogId; }

    @javax.annotation.Nullable
    @JsonProperty("connection_paths")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getConnectionPaths() { return connectionPaths; }
    public void setConnectionPaths(List<String> connectionPaths) { this.connectionPaths = connectionPaths; }

    @javax.annotation.Nullable
    @JsonProperty("resource_key")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getResourceKey() { return resourceKey; }
    public void setResourceKey(String resourceKey) { this.resourceKey = resourceKey; }

    @javax.annotation.Nullable
    @JsonProperty("column_terms")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getColumnTerms() { return columnTerms; }
    public void setColumnTerms(List<String> columnTerms) { this.columnTerms = columnTerms; }

    @javax.annotation.Nullable
    @JsonProperty("column_data_class_names")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getColumnDataClassNames() { return columnDataClassNames; }
    public void setColumnDataClassNames(List<String> columnDataClassNames) { this.columnDataClassNames = columnDataClassNames; }

    @javax.annotation.Nullable
    @JsonProperty("column_terms_global_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getColumnTermsGlobalIds() { return columnTermsGlobalIds; }
    public void setColumnTermsGlobalIds(List<String> columnTermsGlobalIds) { this.columnTermsGlobalIds = columnTermsGlobalIds; }

    @javax.annotation.Nullable
    @JsonProperty("column_names")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getColumnNames() { return columnNames; }
    public void setColumnNames(List<String> columnNames) { this.columnNames = columnNames; }

    @javax.annotation.Nullable
    @JsonProperty("column_tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getColumnTags() { return columnTags; }
    public void setColumnTags(List<String> columnTags) { this.columnTags = columnTags; }

    @javax.annotation.Nullable
    @JsonProperty("connection_ids")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getConnectionIds() { return connectionIds; }
    public void setConnectionIds(List<String> connectionIds) { this.connectionIds = connectionIds; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssetSearchResultEntity that = (AssetSearchResultEntity) o;
        return Objects.equals(catalogId, that.catalogId) &&
                Objects.equals(connectionPaths, that.connectionPaths) &&
                Objects.equals(resourceKey, that.resourceKey) &&
                Objects.equals(columnTerms, that.columnTerms) &&
                Objects.equals(columnDataClassNames, that.columnDataClassNames) &&
                Objects.equals(columnTermsGlobalIds, that.columnTermsGlobalIds) &&
                Objects.equals(columnNames, that.columnNames) &&
                Objects.equals(columnTags, that.columnTags) &&
                Objects.equals(connectionIds, that.connectionIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalogId, connectionPaths, resourceKey, columnTerms,
                columnDataClassNames, columnTermsGlobalIds, columnNames, columnTags,
                connectionIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetSearchResultEntity {\n");
        sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
        sb.append("    connectionPaths: ").append(toIndentedString(connectionPaths)).append("\n");
        sb.append("    resourceKey: ").append(toIndentedString(resourceKey)).append("\n");
        sb.append("    columnTerms: ").append(toIndentedString(columnTerms)).append("\n");
        sb.append("    columnDataClassNames: ").append(toIndentedString(columnDataClassNames)).append("\n");
        sb.append("    columnTermsGlobalIds: ").append(toIndentedString(columnTermsGlobalIds)).append("\n");
        sb.append("    columnNames: ").append(toIndentedString(columnNames)).append("\n");
        sb.append("    columnTags: ").append(toIndentedString(columnTags)).append("\n");
        sb.append("    connectionIds: ").append(toIndentedString(connectionIds)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
