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
 * Type
 */
public class Type {

    private String description;
    private List<AssetTypeField> fields = new ArrayList<>();
    private ExternalAssetPreview externalAssetPreview;
    private List<AssetTypeRelationship> relationships = null;
    private Map<String, AssetTypeProperty> properties = null;
    private String name;
    private Double version;

    public Type description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Asset type description
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Type fields(List<AssetTypeField> fields) {
        this.fields = fields;
        return this;
    }

    public Type addFieldsItem(AssetTypeField fieldsItem) {
        this.fields.add(fieldsItem);
        return this;
    }

    /**
     * Asset type fields that will be indexed
     * @return fields
     **/
    @JsonProperty("fields")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<AssetTypeField> getFields() { return fields; }
    public void setFields(List<AssetTypeField> fields) { this.fields = fields; }

    public Type externalAssetPreview(ExternalAssetPreview externalAssetPreview) {
        this.externalAssetPreview = externalAssetPreview;
        return this;
    }

    /**
     * Get externalAssetPreview
     * @return externalAssetPreview
     **/
    @javax.annotation.Nullable
    @JsonProperty("external_asset_preview")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ExternalAssetPreview getExternalAssetPreview() {
        return externalAssetPreview;
    }
    public void setExternalAssetPreview(ExternalAssetPreview externalAssetPreview) { this.externalAssetPreview = externalAssetPreview; }

    public Type relationships(List<AssetTypeRelationship> relationships) {
        this.relationships = relationships;
        return this;
    }

    public Type addRelationshipsItem(AssetTypeRelationship relationshipsItem) {
        if (this.relationships == null) {
            this.relationships = new ArrayList<>();
        }
        this.relationships.add(relationshipsItem);
        return this;
    }

    /**
     * Relationship definitions for this asset type.
     * @return relationships
     **/
    @javax.annotation.Nullable
    @JsonProperty("relationships")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<AssetTypeRelationship> getRelationships() { return relationships; }
    public void setRelationships(List<AssetTypeRelationship> relationships) { this.relationships = relationships; }

    public Type properties(Map<String, AssetTypeProperty> properties) {
        this.properties = properties;
        return this;
    }

    public Type putPropertiesItem(String key, AssetTypeProperty propertiesItem) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * Descriptions of expected properties for this asset type. Each property can
     * be described by its name and an AssetTypeProperty object
     * @return properties
     **/
    @javax.annotation.Nullable
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, AssetTypeProperty> getProperties() { return properties; }
    public void setProperties(Map<String, AssetTypeProperty> properties) { this.properties = properties; }

    public Type name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Asset type name
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Type version(Double version) {
        this.version = version;
        return this;
    }

    /**
     * The version of defined asset type
     * @return version
     **/
    @javax.annotation.Nullable
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Double getVersion() { return version; }
    public void setVersion(Double version) { this.version = version; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        Type type = (Type)o;
        return Objects.equals(this.description, type.description) &&
                Objects.equals(this.fields, type.fields) &&
                Objects.equals(this.externalAssetPreview, type.externalAssetPreview) &&
                Objects.equals(this.relationships, type.relationships) &&
                Objects.equals(this.properties, type.properties) &&
                Objects.equals(this.name, type.name) &&
                Objects.equals(this.version, type.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, fields, externalAssetPreview,
                relationships, properties, name, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Type {\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
        sb.append("    externalAssetPreview: ").append(toIndentedString(externalAssetPreview)).append("\n");
        sb.append("    relationships: ").append(toIndentedString(relationships)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
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
