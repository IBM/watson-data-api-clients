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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * UpdateType
 */
@JsonPropertyOrder({
        UpdateType.JSON_PROPERTY_DESCRIPTION,
        UpdateType.JSON_PROPERTY_FIELDS,
        UpdateType.JSON_PROPERTY_EXTERNAL_ASSET_PREVIEW,
        UpdateType.JSON_PROPERTY_RELATIONSHIPS,
        UpdateType.JSON_PROPERTY_PROPERTIES
})
public class UpdateType {

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    private String description;

    public static final String JSON_PROPERTY_FIELDS = "fields";
    private List<AssetTypeField> fields = new ArrayList<>();

    public static final String JSON_PROPERTY_EXTERNAL_ASSET_PREVIEW = "external_asset_preview";
    private ExternalAssetPreview externalAssetPreview;

    public static final String JSON_PROPERTY_RELATIONSHIPS = "relationships";
    private List<AssetTypeRelationship> relationships = null;

    public static final String JSON_PROPERTY_PROPERTIES = "properties";
    private Map<String, AssetTypeProperty> properties = null;

    public UpdateType description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Asset type description
     * @return description
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "Connection asset type",
            value = "Asset type description")
    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UpdateType fields(List<AssetTypeField> fields) {
        this.fields = fields;
        return this;
    }

    public UpdateType addFieldsItem(AssetTypeField fieldsItem) {
        this.fields.add(fieldsItem);
        return this;
    }

    /**
     * Asset type fields that will be indexed
     * @return fields
     **/
    @ApiModelProperty(required = true,
            value = "Asset type fields that will be indexed")
    @JsonProperty(JSON_PROPERTY_FIELDS)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public List<AssetTypeField> getFields() {
        return fields;
    }

    public void setFields(List<AssetTypeField> fields) { this.fields = fields; }

    public UpdateType externalAssetPreview(ExternalAssetPreview externalAssetPreview) {
        this.externalAssetPreview = externalAssetPreview;
        return this;
    }

    /**
     * Get externalAssetPreview
     * @return externalAssetPreview
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_EXTERNAL_ASSET_PREVIEW)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public ExternalAssetPreview getExternalAssetPreview() {
        return externalAssetPreview;
    }

    public void setExternalAssetPreview(ExternalAssetPreview externalAssetPreview) {
        this.externalAssetPreview = externalAssetPreview;
    }

    public UpdateType relationships(List<AssetTypeRelationship> relationships) {
        this.relationships = relationships;
        return this;
    }

    public UpdateType addRelationshipsItem(AssetTypeRelationship relationshipsItem) {
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
    @ApiModelProperty(value = "Relationship definitions for this asset type.")
    @JsonProperty(JSON_PROPERTY_RELATIONSHIPS)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<AssetTypeRelationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<AssetTypeRelationship> relationships) {
        this.relationships = relationships;
    }

    public UpdateType properties(Map<String, AssetTypeProperty> properties) {
        this.properties = properties;
        return this;
    }

    public UpdateType putPropertiesItem(String key, AssetTypeProperty propertiesItem) {
        if (this.properties == null) {
            this.properties = new HashMap<>();
        }
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * Descriptions of expected properties for this asset type. Each property can
     *be described by its name and an AssetTypeProperty object
     * @return properties
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            value = "Descriptions of expected properties for this asset type. Each property can be described by its name and an AssetTypeProperty object")
    @JsonProperty(JSON_PROPERTY_PROPERTIES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public Map<String, AssetTypeProperty> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, AssetTypeProperty> properties) {
        this.properties = properties;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateType updateType = (UpdateType)o;
        return Objects.equals(this.description, updateType.description) &&
                Objects.equals(this.fields, updateType.fields) &&
                Objects.equals(this.externalAssetPreview,
                        updateType.externalAssetPreview) &&
                Objects.equals(this.relationships, updateType.relationships) &&
                Objects.equals(this.properties, updateType.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, fields, externalAssetPreview,
                relationships, properties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateType {\n");
        sb.append("    description: ")
                .append(toIndentedString(description))
                .append("\n");
        sb.append("    fields: ").append(toIndentedString(fields)).append("\n");
        sb.append("    externalAssetPreview: ")
                .append(toIndentedString(externalAssetPreview))
                .append("\n");
        sb.append("    relationships: ")
                .append(toIndentedString(relationships))
                .append("\n");
        sb.append("    properties: ")
                .append(toIndentedString(properties))
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
