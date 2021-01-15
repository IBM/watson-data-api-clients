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
 * BaseEntity
 */
public class BaseEntity {

    private String qualifiedName;
    private ElementType type;
    private String guid;
    private String url;
    private List<Classification> classifications = null;
    private Map<String, String> additionalProperties = null;
    private List<Meaning> meanings = null;
    private Map<String, Object> extendedProperties = null;
    private String displayName;
    private String description;

    public BaseEntity qualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
        return this;
    }

    /**
     * Get qualifiedName
     * @return qualifiedName
     **/
    @javax.annotation.Nullable
    @JsonProperty("qualifiedName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getQualifiedName() { return qualifiedName; }
    public void setQualifiedName(String qualifiedName) { this.qualifiedName = qualifiedName; }

    public BaseEntity type(ElementType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     * @return type
     **/
    @javax.annotation.Nullable
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ElementType getType() { return type; }
    public void setType(ElementType type) { this.type = type; }

    public BaseEntity guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get guid
     * @return guid
     **/
    @javax.annotation.Nullable
    @JsonProperty("guid")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getGuid() { return guid; }
    public void setGuid(String guid) { this.guid = guid; }

    public BaseEntity url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get url
     * @return url
     **/
    @javax.annotation.Nullable
    @JsonProperty("url")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public BaseEntity classifications(List<Classification> classifications) {
        this.classifications = classifications;
        return this;
    }

    public BaseEntity addClassificationsItem(Classification classificationsItem) {
        if (this.classifications == null) {
            this.classifications = new ArrayList<>();
        }
        this.classifications.add(classificationsItem);
        return this;
    }

    /**
     * Get classifications
     * @return classifications
     **/
    @javax.annotation.Nullable
    @JsonProperty("classifications")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Classification> getClassifications() { return classifications; }
    public void setClassifications(List<Classification> classifications) { this.classifications = classifications; }

    public BaseEntity additionalProperties(Map<String, String> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    public BaseEntity putAdditionalPropertiesItem(String key, String additionalPropertiesItem) {
        if (this.additionalProperties == null) {
            this.additionalProperties = new HashMap<>();
        }
        this.additionalProperties.put(key, additionalPropertiesItem);
        return this;
    }

    /**
     * Get additionalProperties
     * @return additionalProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("additionalProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, String> getAdditionalProperties() { return additionalProperties; }
    public void setAdditionalProperties(Map<String, String> additionalProperties) { this.additionalProperties = additionalProperties; }

    public BaseEntity meanings(List<Meaning> meanings) {
        this.meanings = meanings;
        return this;
    }

    public BaseEntity addMeaningsItem(Meaning meaningsItem) {
        if (this.meanings == null) {
            this.meanings = new ArrayList<>();
        }
        this.meanings.add(meaningsItem);
        return this;
    }

    /**
     * Get meanings
     * @return meanings
     **/
    @javax.annotation.Nullable
    @JsonProperty("meanings")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Meaning> getMeanings() { return meanings; }
    public void setMeanings(List<Meaning> meanings) { this.meanings = meanings; }

    public BaseEntity extendedProperties(Map<String, Object> extendedProperties) {
        this.extendedProperties = extendedProperties;
        return this;
    }

    public BaseEntity putExtendedPropertiesItem(String key, Object extendedPropertiesItem) {
        if (this.extendedProperties == null) {
            this.extendedProperties = new HashMap<>();
        }
        this.extendedProperties.put(key, extendedPropertiesItem);
        return this;
    }

    /**
     * Get extendedProperties
     * @return extendedProperties
     **/
    @javax.annotation.Nullable
    @JsonProperty("extendedProperties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getExtendedProperties() { return extendedProperties; }
    public void setExtendedProperties(Map<String, Object> extendedProperties) { this.extendedProperties = extendedProperties; }

    public BaseEntity displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get displayName
     * @return displayName
     **/
    @javax.annotation.Nullable
    @JsonProperty("displayName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }

    public BaseEntity description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BaseEntity that = (BaseEntity)o;
        return Objects.equals(this.qualifiedName, that.qualifiedName) &&
                Objects.equals(this.type, that.type) &&
                Objects.equals(this.guid, that.guid) &&
                Objects.equals(this.url, that.url) &&
                Objects.equals(this.classifications, that.classifications) &&
                Objects.equals(this.additionalProperties, that.additionalProperties) &&
                Objects.equals(this.meanings, that.meanings) &&
                Objects.equals(this.extendedProperties, that.extendedProperties) &&
                Objects.equals(this.displayName, that.displayName) &&
                Objects.equals(this.description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualifiedName, type, guid, url, classifications, additionalProperties, meanings,
                extendedProperties, displayName, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BaseEntity {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    qualifiedName: ").append(toIndentedString(qualifiedName)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    additionalProperties: ").append(toIndentedString(additionalProperties)).append("\n");
        sb.append("    meanings: ").append(toIndentedString(meanings)).append("\n");
        sb.append("    extendedProperties: ").append(toIndentedString(extendedProperties)).append("\n");
        sb.append("    name: ").append(toIndentedString(displayName)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o to indent
     * @return String indented
     */
    protected String toIndentedString(java.lang.Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
