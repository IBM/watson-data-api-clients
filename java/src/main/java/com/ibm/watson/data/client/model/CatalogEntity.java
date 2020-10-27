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
 * CatalogEntity
 */
public class CatalogEntity {

    private String name;
    private String description;
    private String generator;
    private String projectId;
    private String spaceId;
    private String bssAccountId;
    private Long capacityLimit;
    private CatalogBucket bucket;
    private Boolean isGoverned;
    private Boolean autoProfiling;
    private String samlInstanceName;

    public CatalogEntity name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name the Catalog instance
     * @return name
     **/
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public CatalogEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the Catalog instance
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public CatalogEntity generator(String generator) {
        this.generator = generator;
        return this;
    }

    /**
     * Generator of the Catalog instance
     * @return generator
     **/
    @javax.annotation.Nullable
    @JsonProperty("generator")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGenerator() { return generator; }
    public void setGenerator(String generator) { this.generator = generator; }

    public CatalogEntity projectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    /**
     * Project id
     * @return projectId
     **/
    @javax.annotation.Nullable
    @JsonProperty("project_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getProjectId() { return projectId; }
    public void setProjectId(String projectId) { this.projectId = projectId; }

    public CatalogEntity spaceId(String spaceId) {
        this.spaceId = spaceId;
        return this;
    }

    /**
     * Space id
     * @return spaceId
     **/
    @javax.annotation.Nullable
    @JsonProperty("space_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSpaceId() { return spaceId; }
    public void setSpaceId(String spaceId) { this.spaceId = spaceId; }

    public CatalogEntity bssAccountId(String bssAccountId) {
        this.bssAccountId = bssAccountId;
        return this;
    }

    /**
     * Account ID
     * @return bssAccountId
     **/
    @javax.annotation.Nullable
    @JsonProperty("bss_account_id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getBssAccountId() { return bssAccountId; }
    public void setBssAccountId(String bssAccountId) { this.bssAccountId = bssAccountId; }

    public CatalogEntity capacityLimit(Long capacityLimit) {
        this.capacityLimit = capacityLimit;
        return this;
    }

    /**
     * Capacity Limit
     * @return capacityLimit
     **/
    @javax.annotation.Nullable
    @JsonProperty("capacity_limit")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCapacityLimit() { return capacityLimit; }
    public void setCapacityLimit(Long capacityLimit) { this.capacityLimit = capacityLimit; }

    public CatalogEntity bucket(CatalogBucket bucket) {
        this.bucket = bucket;
        return this;
    }

    /**
     * Get bucket
     * @return bucket
     **/
    @javax.annotation.Nullable
    @JsonProperty("bucket")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public CatalogBucket getBucket() { return bucket; }
    public void setBucket(CatalogBucket bucket) { this.bucket = bucket; }

    public CatalogEntity isGoverned(Boolean isGoverned) {
        this.isGoverned = isGoverned;
        return this;
    }

    /**
     * Indicates if the assets in the Catalog are governed. if not specified, it
     * defaults to false. For private catalogs, &#39;false&#39; should be always
     * passed, because private catalogs can not be governed.
     * @return isGoverned
     **/
    @javax.annotation.Nullable
    @JsonProperty("is_governed")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getIsGoverned() { return isGoverned; }
    public void setIsGoverned(Boolean isGoverned) { this.isGoverned = isGoverned; }

    public CatalogEntity autoProfiling(Boolean autoProfiling) {
        this.autoProfiling = autoProfiling;
        return this;
    }

    /**
     * Indicates if the assets in the Catalog are allowed for profiling. if not
     *specified
     * @return autoProfiling
     **/
    @javax.annotation.Nullable
    @JsonProperty("auto_profiling")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAutoProfiling() { return autoProfiling; }
    public void setAutoProfiling(Boolean autoProfiling) { this.autoProfiling = autoProfiling; }

    public CatalogEntity samlInstanceName(String samlInstanceName) {
        this.samlInstanceName = samlInstanceName;
        return this;
    }

    /**
     * SAML instance type
     * @return samlInstanceName
     **/
    @javax.annotation.Nullable
    @JsonProperty("saml_instance_name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getSamlInstanceName() { return samlInstanceName; }
    public void setSamlInstanceName(String samlInstanceName) { this.samlInstanceName = samlInstanceName; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CatalogEntity catalogEntity = (CatalogEntity)o;
        return Objects.equals(this.name, catalogEntity.name) &&
                Objects.equals(this.description, catalogEntity.description) &&
                Objects.equals(this.generator, catalogEntity.generator) &&
                Objects.equals(this.projectId, catalogEntity.projectId) &&
                Objects.equals(this.spaceId, catalogEntity.spaceId) &&
                Objects.equals(this.bssAccountId, catalogEntity.bssAccountId) &&
                Objects.equals(this.capacityLimit, catalogEntity.capacityLimit) &&
                Objects.equals(this.bucket, catalogEntity.bucket) &&
                Objects.equals(this.isGoverned, catalogEntity.isGoverned) &&
                Objects.equals(this.autoProfiling, catalogEntity.autoProfiling) &&
                Objects.equals(this.samlInstanceName, catalogEntity.samlInstanceName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, generator, projectId, spaceId,
                bssAccountId, capacityLimit, bucket, isGoverned,
                autoProfiling, samlInstanceName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CatalogEntity {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    generator: ").append(toIndentedString(generator)).append("\n");
        sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
        sb.append("    spaceId: ").append(toIndentedString(spaceId)).append("\n");
        sb.append("    bssAccountId: ").append(toIndentedString(bssAccountId)).append("\n");
        sb.append("    capacityLimit: ").append(toIndentedString(capacityLimit)).append("\n");
        sb.append("    bucket: ").append(toIndentedString(bucket)).append("\n");
        sb.append("    isGoverned: ").append(toIndentedString(isGoverned)).append("\n");
        sb.append("    autoProfiling: ").append(toIndentedString(autoProfiling)).append("\n");
        sb.append("    samlInstanceName: ").append(toIndentedString(samlInstanceName)).append("\n");
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
