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
import com.ibm.watson.data.client.model.enums.DataShape;
import com.ibm.watson.data.client.model.enums.DatasourceTypeEnum;
import com.ibm.watson.data.client.model.enums.DatasourceTypeStatus;
import com.ibm.watson.data.client.model.enums.SecureGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The definition of a data source type.
 */
public class DatasourceTypeEntity {

    private String name;
    private String label;
    private String description;
    private DatasourceTypeEnum type;
    private Boolean allowedAsSource;
    private Boolean allowedAsTarget;
    private DataShape dataShape;
    private Boolean autoDiscovery;
    private DatasourceTypeDiscovery discovery;
    private SecureGateway secureGateway;
    private DatasourceTypeProperties properties;
    private List<String> tags = null;
    private List<DatasourceTypeAction> actions = null;
    private List<String> supportedEnvironments = null;
    private List<String> supportedPlans = null;
    private List<String> supportedProducts = null;
    private DatasourceTypeStatus status;

    public DatasourceTypeEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A unique name, such as \&quot;dashdb\&quot;.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public DatasourceTypeEntity label(String label) {
        this.label = label;
        return this;
    }

    /**
     * A localized, displayable label such as, \&quot;IBM dashDB\&quot;.
     * @return label
     **/
    @javax.annotation.Nullable
    @JsonProperty("label")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public DatasourceTypeEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A localized, displayable description of the data source.
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public DatasourceTypeEntity type(DatasourceTypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the data source.
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DatasourceTypeEnum getType() { return type; }
    public void setType(DatasourceTypeEnum type) { this.type = type; }

    public DatasourceTypeEntity allowedAsSource(Boolean allowedAsSource) {
        this.allowedAsSource = allowedAsSource;
        return this;
    }

    /**
     * Whether the data source can be accessed as a source of data. That is, data
     *can be read from the data source.
     * @return allowedAsSource
     **/
    @javax.annotation.Nullable
    @JsonProperty("allowed_as_source")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAllowedAsSource() { return allowedAsSource; }
    public void setAllowedAsSource(Boolean allowedAsSource) { this.allowedAsSource = allowedAsSource; }

    public DatasourceTypeEntity allowedAsTarget(Boolean allowedAsTarget) {
        this.allowedAsTarget = allowedAsTarget;
        return this;
    }

    /**
     * Whether the data source can be accessed as a target. That is, data can be
     *written to the data source.
     * @return allowedAsTarget
     **/
    @javax.annotation.Nullable
    @JsonProperty("allowed_as_target")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAllowedAsTarget() { return allowedAsTarget; }
    public void setAllowedAsTarget(Boolean allowedAsTarget) { this.allowedAsTarget = allowedAsTarget; }

    public DatasourceTypeEntity dataShape(DataShape dataShape) {
        this.dataShape = dataShape;
        return this;
    }

    /**
     * The shape of the data.
     * @return dataShape
     **/
    @javax.annotation.Nullable
    @JsonProperty("data_shape")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DataShape getDataShape() { return dataShape; }
    public void setDataShape(DataShape dataShape) { this.dataShape = dataShape; }

    public DatasourceTypeEntity autoDiscovery(Boolean autoDiscovery) {
        this.autoDiscovery = autoDiscovery;
        return this;
    }

    /**
     * Whether the data source supports metadata discovery.
     * @return autoDiscovery
     **/
    @javax.annotation.Nullable
    @JsonProperty("auto_discovery")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAutoDiscovery() { return autoDiscovery; }
    public void setAutoDiscovery(Boolean autoDiscovery) { this.autoDiscovery = autoDiscovery; }

    public DatasourceTypeEntity discovery(DatasourceTypeDiscovery discovery) {
        this.discovery = discovery;
        return this;
    }

    /**
     * Get discovery
     * @return discovery
     **/
    @javax.annotation.Nullable
    @JsonProperty("discovery")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DatasourceTypeDiscovery getDiscovery() { return discovery; }
    public void setDiscovery(DatasourceTypeDiscovery discovery) { this.discovery = discovery; }

    public DatasourceTypeEntity secureGateway(SecureGateway secureGateway) {
        this.secureGateway = secureGateway;
        return this;
    }

    /**
     * Whether a gateway_id is optional, required, or not_applicable.
     * @return secureGateway
     **/
    @javax.annotation.Nullable
    @JsonProperty("secure_gateway")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public SecureGateway getSecureGateway() { return secureGateway; }
    public void setSecureGateway(SecureGateway secureGateway) { this.secureGateway = secureGateway; }

    public DatasourceTypeEntity properties(DatasourceTypeProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get properties
     * @return properties
     **/
    @javax.annotation.Nullable
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DatasourceTypeProperties getProperties() { return properties; }
    public void setProperties(DatasourceTypeProperties properties) { this.properties = properties; }

    public DatasourceTypeEntity tags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    public DatasourceTypeEntity addTagsItem(String tagsItem) {
        if (this.tags == null) {
            this.tags = new ArrayList<>();
        }
        this.tags.add(tagsItem);
        return this;
    }

    /**
     * Tags associated with a data source type.
     * @return tags
     **/
    @javax.annotation.Nullable
    @JsonProperty("tags")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getTags() { return tags; }
    public void setTags(List<String> tags) { this.tags = tags; }

    public DatasourceTypeEntity actions(List<DatasourceTypeAction> actions) {
        this.actions = actions;
        return this;
    }

    public DatasourceTypeEntity addActionsItem(DatasourceTypeAction actionsItem) {
        if (this.actions == null) {
            this.actions = new ArrayList<>();
        }
        this.actions.add(actionsItem);
        return this;
    }

    /**
     * The actions supported for the data source.
     * @return actions
     **/
    @javax.annotation.Nullable
    @JsonProperty("actions")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DatasourceTypeAction> getActions() { return actions; }
    public void setActions(List<DatasourceTypeAction> actions) { this.actions = actions; }

    public DatasourceTypeEntity supportedEnvironments(List<String> supportedEnvironments) {
        this.supportedEnvironments = supportedEnvironments;
        return this;
    }

    public DatasourceTypeEntity addSupportedEnvironmentsItem(String supportedEnvironmentsItem) {
        if (this.supportedEnvironments == null) {
            this.supportedEnvironments = new ArrayList<>();
        }
        this.supportedEnvironments.add(supportedEnvironmentsItem);
        return this;
    }

    /**
     * The list of environments where this data source type may be used.
     * @return supportedEnvironments
     **/
    @javax.annotation.Nullable
    @JsonProperty("supported_environments")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSupportedEnvironments() { return supportedEnvironments; }
    public void setSupportedEnvironments(List<String> supportedEnvironments) { this.supportedEnvironments = supportedEnvironments; }

    public DatasourceTypeEntity supportedPlans(List<String> supportedPlans) {
        this.supportedPlans = supportedPlans;
        return this;
    }

    public DatasourceTypeEntity addSupportedPlansItem(String supportedPlansItem) {
        if (this.supportedPlans == null) {
            this.supportedPlans = new ArrayList<>();
        }
        this.supportedPlans.add(supportedPlansItem);
        return this;
    }

    /**
     * The list of plans for which this data source is supported.
     * @return supportedPlans
     **/
    @javax.annotation.Nullable
    @JsonProperty("supported_plans")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSupportedPlans() { return supportedPlans; }
    public void setSupportedPlans(List<String> supportedPlans) { this.supportedPlans = supportedPlans; }

    public DatasourceTypeEntity supportedProducts(List<String> supportedProducts) {
        this.supportedProducts = supportedProducts;
        return this;
    }

    public DatasourceTypeEntity addSupportedProductsItem(String supportedProductsItem) {
        if (this.supportedProducts == null) {
            this.supportedProducts = new ArrayList<>();
        }
        this.supportedProducts.add(supportedProductsItem);
        return this;
    }

    /**
     * The list of products for which this data source is supported.
     * @return supportedProducts
     **/
    @javax.annotation.Nullable
    @JsonProperty("supported_products")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getSupportedProducts() { return supportedProducts; }
    public void setSupportedProducts(List<String> supportedProducts) { this.supportedProducts = supportedProducts; }

    public DatasourceTypeEntity status(DatasourceTypeStatus status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the data source.
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DatasourceTypeStatus getStatus() {
        return status;
    }
    public void setStatus(DatasourceTypeStatus status) { this.status = status; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DatasourceTypeEntity datasourceTypeEntity = (DatasourceTypeEntity)o;
        return Objects.equals(this.name, datasourceTypeEntity.name) &&
                Objects.equals(this.label, datasourceTypeEntity.label) &&
                Objects.equals(this.description, datasourceTypeEntity.description) &&
                Objects.equals(this.type, datasourceTypeEntity.type) &&
                Objects.equals(this.allowedAsSource, datasourceTypeEntity.allowedAsSource) &&
                Objects.equals(this.allowedAsTarget, datasourceTypeEntity.allowedAsTarget) &&
                Objects.equals(this.dataShape, datasourceTypeEntity.dataShape) &&
                Objects.equals(this.autoDiscovery, datasourceTypeEntity.autoDiscovery) &&
                Objects.equals(this.discovery, datasourceTypeEntity.discovery) &&
                Objects.equals(this.secureGateway, datasourceTypeEntity.secureGateway) &&
                Objects.equals(this.properties, datasourceTypeEntity.properties) &&
                Objects.equals(this.tags, datasourceTypeEntity.tags) &&
                Objects.equals(this.actions, datasourceTypeEntity.actions) &&
                Objects.equals(this.supportedEnvironments, datasourceTypeEntity.supportedEnvironments) &&
                Objects.equals(this.supportedPlans, datasourceTypeEntity.supportedPlans) &&
                Objects.equals(this.supportedProducts, datasourceTypeEntity.supportedProducts) &&
                Objects.equals(this.status, datasourceTypeEntity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, label, description, type, allowedAsSource,
                allowedAsTarget, dataShape, autoDiscovery, discovery,
                secureGateway, properties, tags, actions,
                supportedEnvironments, supportedPlans,
                supportedProducts, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DatasourceTypeEntity {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    allowedAsSource: ").append(toIndentedString(allowedAsSource)).append("\n");
        sb.append("    allowedAsTarget: ").append(toIndentedString(allowedAsTarget)).append("\n");
        sb.append("    dataShape: ").append(toIndentedString(dataShape)).append("\n");
        sb.append("    autoDiscovery: ").append(toIndentedString(autoDiscovery)).append("\n");
        sb.append("    discovery: ").append(toIndentedString(discovery)).append("\n");
        sb.append("    secureGateway: ").append(toIndentedString(secureGateway)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("    tags: ").append(toIndentedString(tags)).append("\n");
        sb.append("    actions: ").append(toIndentedString(actions)).append("\n");
        sb.append("    supportedEnvironments: ").append(toIndentedString(supportedEnvironments)).append("\n");
        sb.append("    supportedPlans: ").append(toIndentedString(supportedPlans)).append("\n");
        sb.append("    supportedProducts: ").append(toIndentedString(supportedProducts)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
