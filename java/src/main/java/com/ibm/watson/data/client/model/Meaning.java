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
 * Meaning
 */
public class Meaning {

    private ElementType type;
    private String guid;
    private String url;
    private List<Classification> classifications = null;
    private Map<String, Object> extendedProperties = null;
    private String name;
    private String description;

    public Meaning type(ElementType type) {
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

    public Meaning guid(String guid) {
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

    public Meaning url(String url) {
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

    public Meaning classifications(List<Classification> classifications) {
        this.classifications = classifications;
        return this;
    }

    public Meaning addClassificationsItem(Classification classificationsItem) {
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

    public Meaning extendedProperties(Map<String, Object> extendedProperties) {
        this.extendedProperties = extendedProperties;
        return this;
    }

    public Meaning putExtendedPropertiesItem(String key, Object extendedPropertiesItem) {
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

    public Meaning name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Meaning description(String description) {
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
        Meaning meaning = (Meaning)o;
        return Objects.equals(this.type, meaning.type) &&
                Objects.equals(this.guid, meaning.guid) &&
                Objects.equals(this.url, meaning.url) &&
                Objects.equals(this.classifications, meaning.classifications) &&
                Objects.equals(this.extendedProperties, meaning.extendedProperties) &&
                Objects.equals(this.name, meaning.name) &&
                Objects.equals(this.description, meaning.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, guid, url, classifications, extendedProperties,
                name, description);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Meaning {\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("    classifications: ").append(toIndentedString(classifications)).append("\n");
        sb.append("    extendedProperties: ").append(toIndentedString(extendedProperties)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
