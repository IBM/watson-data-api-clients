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
import com.ibm.watson.data.client.model.enums.AssetCategory;
import com.ibm.watson.data.client.model.enums.ConnectionFlag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * The connection definition.
 */
public class ConnectionEntity {

    private String datasourceType;
    private String description;
    private String name;
    private String gatewayId;
    private List<ConnectionFlag> flags = null;
    private String originCountry;
    private String ownerId;
    private BaseRov rov;
    private Map<String, Object> properties = new HashMap<>();
    private ConnectionInteractionProperties interactionProperties;
    private Map<String, Object> sourceSystem = null;
    private AssetCategory assetCategory;
    private List<Map<String, Object>> childSourceSystems = null;
    private List<String> tags = null;

    public ConnectionEntity datasourceType(String datasourceType) {
        this.datasourceType = datasourceType;
        return this;
    }

    /**
     * The id of the data source type to connect to. For example.
     * \&quot;cfdcb449-1204-44ba-baa6-9a8a878e6aa7\&quot;.
     * @return datasourceType
     **/
    @JsonProperty("datasource_type")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getDatasourceType() { return datasourceType; }
    public void setDatasourceType(String datasourceType) { this.datasourceType = datasourceType; }

    public ConnectionEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * The description of the connection.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public ConnectionEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the connection.
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public ConnectionEntity gatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
        return this;
    }

    /**
     * The id of the secure gateway to use with the connection. A Secure Gateway
     * is needed when connecting to an on-premises data source. This is the id of
     * the Secure Gateway created with the SecureGateway Service. Your Secure
     * Gateway Client running on-premises must be connected to the gateway with
     * this Id. For example, \&quot;E9oXGRIhv1e_prod_ng\&quot;.
     * @return gatewayId
     **/
    @javax.annotation.Nullable
    @JsonProperty("gateway_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGatewayId() { return gatewayId; }
    public void setGatewayId(String gatewayId) { this.gatewayId = gatewayId; }

    public ConnectionEntity flags(List<ConnectionFlag> flags) {
        this.flags = flags;
        return this;
    }

    public ConnectionEntity addFlagsItem(ConnectionFlag flagsItem) {
        if (this.flags == null) {
            this.flags = new ArrayList<>();
        }
        this.flags.add(flagsItem);
        return this;
    }

    /**
     * Specifies how a connection is to be treated internally.
     * @return flags
     **/
    @javax.annotation.Nullable
    @JsonProperty("flags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ConnectionFlag> getFlags() { return flags; }
    public void setFlags(List<ConnectionFlag> flags) { this.flags = flags; }

    public ConnectionEntity originCountry(String originCountry) {
        this.originCountry = originCountry;
        return this;
    }

    /**
     * Country which data originated from. - ISO 3166 Country Codes.
     * @return originCountry
     **/
    @javax.annotation.Nullable
    @JsonProperty("origin_country")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOriginCountry() { return originCountry; }
    public void setOriginCountry(String originCountry) { this.originCountry = originCountry; }

    public ConnectionEntity ownerId(String ownerId) {
        this.ownerId = ownerId;
        return this;
    }

    /**
     * Owner or creator of connection.  Provided when a service ID token is used
     * to create connection.
     * @return ownerId
     **/
    @javax.annotation.Nullable
    @JsonProperty("owner_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOwnerId() { return ownerId; }
    public void setOwnerId(String ownerId) { this.ownerId = ownerId; }

    public ConnectionEntity rov(BaseRov rov) {
        this.rov = rov;
        return this;
    }

    /**
     * Get rov
     * @return rov
     **/
    @javax.annotation.Nullable
    @JsonProperty("rov")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BaseRov getRov() { return rov; }
    public void setRov(BaseRov rov) { this.rov = rov; }

    public ConnectionEntity properties(Map<String, Object> properties) {
        this.properties = properties;
        return this;
    }

    public ConnectionEntity putPropertiesItem(String key, Object propertiesItem) {
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * Connection properties.
     * @return properties
     **/
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Map<String, Object> getProperties() { return properties; }
    public void setProperties(Map<String, Object> properties) { this.properties = properties; }

    public ConnectionEntity interactionProperties(ConnectionInteractionProperties interactionProperties) {
        this.interactionProperties = interactionProperties;
        return this;
    }

    /**
     * Get interactionProperties
     * @return interactionProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("interaction_properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ConnectionInteractionProperties getInteractionProperties() { return interactionProperties; }
    public void setInteractionProperties(ConnectionInteractionProperties interactionProperties) { this.interactionProperties = interactionProperties; }

    public ConnectionEntity sourceSystem(Map<String, Object> sourceSystem) {
        this.sourceSystem = sourceSystem;
        return this;
    }

    public ConnectionEntity putSourceSystemItem(String key, Object sourceSystemItem) {
        if (this.sourceSystem == null) {
            this.sourceSystem = new HashMap<>();
        }
        this.sourceSystem.put(key, sourceSystemItem);
        return this;
    }

    /**
     * Custom data to be associated with a given object
     * @return sourceSystem
     **/
    @javax.annotation.Nullable
    @JsonProperty("source_system")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getSourceSystem() { return sourceSystem; }
    public void setSourceSystem(Map<String, Object> sourceSystem) { this.sourceSystem = sourceSystem; }

    public ConnectionEntity assetCategory(AssetCategory assetCategory) {
        this.assetCategory = assetCategory;
        return this;
    }

    /**
     * The asset category
     * @return assetCategory
     **/
    @javax.annotation.Nullable
    @JsonProperty("asset_category")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public AssetCategory getAssetCategory() { return assetCategory; }
    public void setAssetCategory(AssetCategory assetCategory) { this.assetCategory = assetCategory; }

    public ConnectionEntity childSourceSystems(List<Map<String, Object>> childSourceSystems) {
        this.childSourceSystems = childSourceSystems;
        return this;
    }

    public ConnectionEntity addChildSourceSystemsItem(Map<String, Object> childSourceSystemsItem) {
        if (this.childSourceSystems == null) {
            this.childSourceSystems = new ArrayList<>();
        }
        this.childSourceSystems.add(childSourceSystemsItem);
        return this;
    }

    /**
     * Get childSourceSystems
     * @return childSourceSystems
     **/
    @javax.annotation.Nullable
    @JsonProperty("child_source_systems")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Map<String, Object>> getChildSourceSystems() { return childSourceSystems; }
    public void setChildSourceSystems(List<Map<String, Object>> childSourceSystems) { this.childSourceSystems = childSourceSystems; }

    public ConnectionEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public ConnectionEntity addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Get tags
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ConnectionEntity connectionEntity = (ConnectionEntity)o;
        return Objects.equals(this.datasourceType, connectionEntity.datasourceType) &&
                Objects.equals(this.description, connectionEntity.description) &&
                Objects.equals(this.name, connectionEntity.name) &&
                Objects.equals(this.gatewayId, connectionEntity.gatewayId) &&
                Objects.equals(this.flags, connectionEntity.flags) &&
                Objects.equals(this.originCountry, connectionEntity.originCountry) &&
                Objects.equals(this.ownerId, connectionEntity.ownerId) &&
                Objects.equals(this.rov, connectionEntity.rov) &&
                Objects.equals(this.properties, connectionEntity.properties) &&
                Objects.equals(this.interactionProperties, connectionEntity.interactionProperties) &&
                Objects.equals(this.sourceSystem, connectionEntity.sourceSystem) &&
                Objects.equals(this.assetCategory, connectionEntity.assetCategory) &&
                Objects.equals(this.childSourceSystems, connectionEntity.childSourceSystems) &&
                Objects.equals(this.tags, connectionEntity.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasourceType, description, name, gatewayId, flags,
                originCountry, ownerId, rov, properties,
                interactionProperties, sourceSystem, assetCategory,
                childSourceSystems, tags);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ConnectionEntity {\n");
        sb.append("    datasourceType: ").append(toIndentedString(datasourceType)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    gatewayId: ").append(toIndentedString(gatewayId)).append("\n");
        sb.append("    flags: ").append(toIndentedString(flags)).append("\n");
        sb.append("    originCountry: ").append(toIndentedString(originCountry)).append("\n");
        sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
        sb.append("    rov: ").append(toIndentedString(rov)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    interactionProperties: ").append(toIndentedString(interactionProperties)).append("\n");
        sb.append("    sourceSystem: ").append(toIndentedString(sourceSystem)).append("\n");
        sb.append("    assetCategory: ").append(toIndentedString(assetCategory)).append("\n");
        sb.append("    childSourceSystems: ").append(toIndentedString(childSourceSystems)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
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
