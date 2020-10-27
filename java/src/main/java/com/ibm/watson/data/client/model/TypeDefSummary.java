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
import com.ibm.watson.data.client.model.enums.TypeDefCategory;

import java.util.Objects;

/**
 * TypeDefSummary
 */
public class TypeDefSummary {

    private String guid;
    private String name;
    private Long version;
    private String versionName;
    private TypeDefCategory category;

    public TypeDefSummary guid(String guid) {
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

    public TypeDefSummary name(String name) {
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

    public TypeDefSummary version(Long version) {
        this.version = version;
        return this;
    }

    /**
     * Get version
     * @return version
     **/
    @javax.annotation.Nullable
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }

    public TypeDefSummary versionName(String versionName) {
        this.versionName = versionName;
        return this;
    }

    /**
     * Get versionName
     * @return versionName
     **/
    @javax.annotation.Nullable
    @JsonProperty("versionName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getVersionName() { return versionName; }
    public void setVersionName(String versionName) { this.versionName = versionName; }

    public TypeDefSummary category(TypeDefCategory category) {
        this.category = category;
        return this;
    }

    /**
     * Get category
     * @return category
     **/
    @javax.annotation.Nullable
    @JsonProperty("category")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public TypeDefCategory getCategory() { return category; }
    public void setCategory(TypeDefCategory category) { this.category = category; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TypeDefSummary typeDefSummary = (TypeDefSummary)o;
        return Objects.equals(this.guid, typeDefSummary.guid) &&
                Objects.equals(this.name, typeDefSummary.name) &&
                Objects.equals(this.version, typeDefSummary.version) &&
                Objects.equals(this.versionName, typeDefSummary.versionName) &&
                Objects.equals(this.category, typeDefSummary.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, version, versionName, category);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TypeDefSummary {\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    versionName: ").append(toIndentedString(versionName)).append("\n");
        sb.append("    category: ").append(toIndentedString(category)).append("\n");
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
