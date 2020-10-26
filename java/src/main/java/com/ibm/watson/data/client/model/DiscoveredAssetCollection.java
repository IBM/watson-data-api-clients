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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * A page from a collection of discovered assets.
 */
public class DiscoveredAssetCollection {

    private String description;
    private String path;
    private String id;
    private Map<String, Object> properties = null;
    private List<DiscoveredAssetType> assetTypes = null;
    private List<DiscoveredAsset> assets = null;
    private List<DiscoveredAssetField> fields = null;
    private Map<String, Object> interactionProperties = null;
    private List<DiscoveredAssetExtendedMetadataProperty> extendedMetadata = null;
    private Object data;
    private Map<String, Object> details = null;
    private HrefModel first;
    private HrefModel prev;
    private HrefModel next;
    private HrefModel last;
    private Integer offset;
    private Integer totalCount;
    private List<DiscoveryLog> logs = null;

    public DiscoveredAssetCollection description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A page from a collection of discovered assets.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public DiscoveredAssetCollection path(String path) {
        this.path = path;
        return this;
    }

    /**
     * The path of the asset.
     * @return path
     **/
    @javax.annotation.Nullable
    @JsonProperty("path")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getPath() { return path; }
    public void setPath(String path) { this.path = path; }

    public DiscoveredAssetCollection id(String id) {
        this.id = id;
        return this;
    }

    /**
     * An ID for the asset.
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public DiscoveredAssetCollection properties(Map<String, Object> properties) {
        this.properties = properties;
        return this;
    }

    public DiscoveredAssetCollection putPropertiesItem(String key, Object propertiesItem) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * Properties defining the returned assets.
     * @return properties
     **/
    @javax.annotation.Nullable
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getProperties() { return properties; }
    public void setProperties(Map<String, Object> properties) { this.properties = properties; }

    public DiscoveredAssetCollection assetTypes(List<DiscoveredAssetType> assetTypes) {
        this.assetTypes = assetTypes;
        return this;
    }

    public DiscoveredAssetCollection addAssetTypesItem(DiscoveredAssetType assetTypesItem) {
        if (this.assetTypes == null) {
            this.assetTypes = new ArrayList<>();
        }
        this.assetTypes.add(assetTypesItem);
        return this;
    }

    /**
     * Discovered types
     * @return assetTypes
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_types")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredAssetType> getAssetTypes() { return assetTypes; }
    public void setAssetTypes(List<DiscoveredAssetType> assetTypes) { this.assetTypes = assetTypes; }

    public DiscoveredAssetCollection assets(List<DiscoveredAsset> assets) {
        this.assets = assets;
        return this;
    }

    public DiscoveredAssetCollection addAssetsItem(DiscoveredAsset assetsItem) {
        if (this.assets == null) {
            this.assets = new ArrayList<>();
        }
        this.assets.add(assetsItem);
        return this;
    }

    /**
     * Discovered assets
     * @return assets
     **/
    @javax.annotation.Nullable
    @JsonProperty("assets")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredAsset> getAssets() { return assets; }
    public void setAssets(List<DiscoveredAsset> assets) { this.assets = assets; }

    public DiscoveredAssetCollection fields(List<DiscoveredAssetField> fields) {
        this.fields = fields;
        return this;
    }

    public DiscoveredAssetCollection addFieldsItem(DiscoveredAssetField fieldsItem) {
        if (this.fields == null) {
            this.fields = new ArrayList<>();
        }
        this.fields.add(fieldsItem);
        return this;
    }

    /**
     * Discovered fields
     * @return fields
     **/
    @javax.annotation.Nullable
    @JsonProperty("fields")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredAssetField> getFields() { return fields; }
    public void setFields(List<DiscoveredAssetField> fields) { this.fields = fields; }

    public DiscoveredAssetCollection interactionProperties(Map<String, Object> interactionProperties) {
        this.interactionProperties = interactionProperties;
        return this;
    }

    public DiscoveredAssetCollection putInteractionPropertiesItem(String key, Object interactionPropertiesItem) {
        if (this.interactionProperties == null) {
            this.interactionProperties = new HashMap<>();
        }
        this.interactionProperties.put(key, interactionPropertiesItem);
        return this;
    }

    /**
     * The interaction properties needed to find the asset.
     * @return interactionProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("interaction_properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getInteractionProperties() { return interactionProperties; }
    public void setInteractionProperties(Map<String, Object> interactionProperties) { this.interactionProperties = interactionProperties; }

    public DiscoveredAssetCollection extendedMetadata(List<DiscoveredAssetExtendedMetadataProperty> extendedMetadata) {
        this.extendedMetadata = extendedMetadata;
        return this;
    }

    public DiscoveredAssetCollection addExtendedMetadataItem(DiscoveredAssetExtendedMetadataProperty extendedMetadataItem) {
        if (this.extendedMetadata == null) {
            this.extendedMetadata = new ArrayList<>();
        }
        this.extendedMetadata.add(extendedMetadataItem);
        return this;
    }

    /**
     * Extended metadata properties
     * @return extendedMetadata
     **/
    @javax.annotation.Nullable
    @JsonProperty("extended_metadata")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveredAssetExtendedMetadataProperty> getExtendedMetadata() { return extendedMetadata; }
    public void setExtendedMetadata(List<DiscoveredAssetExtendedMetadataProperty> extendedMetadata) { this.extendedMetadata = extendedMetadata; }

    public DiscoveredAssetCollection data(Object data) {
        this.data = data;
        return this;
    }

    /**
     * The data returned when the fetch parameter contains the value
     * \&quot;data\&quot;.
     * @return data
     **/
    @javax.annotation.Nullable
    @JsonProperty("data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Object getData() { return data; }
    public void setData(Object data) { this.data = data; }

    public DiscoveredAssetCollection details(Map<String, Object> details) {
        this.details = details;
        return this;
    }

    public DiscoveredAssetCollection putDetailsItem(String key, Object detailsItem) {
        if (this.details == null) {
            this.details = new HashMap<>();
        }
        this.details.put(key, detailsItem);
        return this;
    }

    /**
     * Details about a discovered asset.
     * @return details
     **/
    @javax.annotation.Nullable
    @JsonProperty("details")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getDetails() { return details; }
    public void setDetails(Map<String, Object> details) { this.details = details; }

    public DiscoveredAssetCollection first(HrefModel first) {
        this.first = first;
        return this;
    }

    /**
     * Get first
     * @return first
     **/
    @javax.annotation.Nullable
    @JsonProperty("first")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HrefModel getFirst() { return first; }
    public void setFirst(HrefModel first) { this.first = first; }

    public DiscoveredAssetCollection prev(HrefModel prev) {
        this.prev = prev;
        return this;
    }

    /**
     * Get prev
     * @return prev
     **/
    @javax.annotation.Nullable
    @JsonProperty("prev")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HrefModel getPrev() { return prev; }
    public void setPrev(HrefModel prev) { this.prev = prev; }

    public DiscoveredAssetCollection next(HrefModel next) {
        this.next = next;
        return this;
    }

    /**
     * Get next
     * @return next
     **/
    @javax.annotation.Nullable
    @JsonProperty("next")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HrefModel getNext() { return next; }
    public void setNext(HrefModel next) { this.next = next; }

    public DiscoveredAssetCollection last(HrefModel last) {
        this.last = last;
        return this;
    }

    /**
     * Get last
     * @return last
     **/
    @javax.annotation.Nullable
    @JsonProperty("last")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public HrefModel getLast() { return last; }
    public void setLast(HrefModel last) { this.last = last; }

    public DiscoveredAssetCollection offset(Integer offset) {
        this.offset = offset;
        return this;
    }

    /**
     * The number of assets skipped before this page.
     * @return offset
     **/
    @javax.annotation.Nullable
    @JsonProperty("offset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getOffset() { return offset; }
    public void setOffset(Integer offset) { this.offset = offset; }

    public DiscoveredAssetCollection totalCount(Integer totalCount) {
        this.totalCount = totalCount;
        return this;
    }

    /**
     * The total number of assets available.
     * @return totalCount
     **/
    @javax.annotation.Nullable
    @JsonProperty("total_count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }

    public DiscoveredAssetCollection logs(List<DiscoveryLog> logs) {
        this.logs = logs;
        return this;
    }

    public DiscoveredAssetCollection addLogsItem(DiscoveryLog logsItem) {
        if (this.logs == null) {
            this.logs = new ArrayList<>();
        }
        this.logs.add(logsItem);
        return this;
    }

    /**
     * Log events created during the discovery of the assets.
     * @return logs
     **/
    @javax.annotation.Nullable
    @JsonProperty("logs")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DiscoveryLog> getLogs() { return logs; }
    public void setLogs(List<DiscoveryLog> logs) { this.logs = logs; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DiscoveredAssetCollection discoveredAssetCollection = (DiscoveredAssetCollection)o;
        return Objects.equals(this.description, discoveredAssetCollection.description) &&
                Objects.equals(this.path, discoveredAssetCollection.path) &&
                Objects.equals(this.id, discoveredAssetCollection.id) &&
                Objects.equals(this.properties, discoveredAssetCollection.properties) &&
                Objects.equals(this.assetTypes, discoveredAssetCollection.assetTypes) &&
                Objects.equals(this.assets, discoveredAssetCollection.assets) &&
                Objects.equals(this.fields, discoveredAssetCollection.fields) &&
                Objects.equals(this.interactionProperties, discoveredAssetCollection.interactionProperties) &&
                Objects.equals(this.extendedMetadata, discoveredAssetCollection.extendedMetadata) &&
                Objects.equals(this.data, discoveredAssetCollection.data) &&
                Objects.equals(this.details, discoveredAssetCollection.details) &&
                Objects.equals(this.first, discoveredAssetCollection.first) &&
                Objects.equals(this.prev, discoveredAssetCollection.prev) &&
                Objects.equals(this.next, discoveredAssetCollection.next) &&
                Objects.equals(this.last, discoveredAssetCollection.last) &&
                Objects.equals(this.offset, discoveredAssetCollection.offset) &&
                Objects.equals(this.totalCount, discoveredAssetCollection.totalCount) &&
                Objects.equals(this.logs, discoveredAssetCollection.logs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, path, id, properties, assetTypes, assets,
                fields, interactionProperties, extendedMetadata, data,
                details, first, prev, next, last, offset, totalCount,
                logs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DiscoveredAssetCollection {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    path: ").append(toIndentedString(path)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    assetTypes: ").append(toIndentedString(assetTypes)).append("\n");
        sb.append("    assets: ").append(toIndentedString(assets)).append("\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
        sb.append("    interactionProperties: ").append(toIndentedString(interactionProperties)).append("\n");
        sb.append("    extendedMetadata: ").append(toIndentedString(extendedMetadata)).append("\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("    first: ").append(toIndentedString(first)).append("\n");
        sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
        sb.append("    next: ").append(toIndentedString(next)).append("\n");
        sb.append("    last: ").append(toIndentedString(last)).append("\n");
        sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
        sb.append("    totalCount: ").append(toIndentedString(totalCount)).append("\n");
        sb.append("    logs: ").append(toIndentedString(logs)).append("\n");
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
