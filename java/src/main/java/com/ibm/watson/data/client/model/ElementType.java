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
import com.ibm.watson.data.client.model.enums.ElementOrigin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ElementType
 */
public class ElementType {

    private String elementTypeId;
    private String elementTypeName;
    private List<String> elementSuperTypeNames = null;
    private Long elementTypeVersion;
    private String elementTypeDescription;
    private String elementSourceServer;
    private ElementOrigin elementOrigin;
    private String elementHomeMetadataCollectionId;
    private String elementHomeMetadataCollectionName;
    private String elementLicense;

    public ElementType elementTypeId(String elementTypeId) {
        this.elementTypeId = elementTypeId;
        return this;
    }

    /**
     * Get elementTypeId
     * @return elementTypeId
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementTypeId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getElementTypeId() { return elementTypeId; }
    public void setElementTypeId(String elementTypeId) { this.elementTypeId = elementTypeId; }

    public ElementType elementTypeName(String elementTypeName) {
        this.elementTypeName = elementTypeName;
        return this;
    }

    /**
     * Get elementTypeName
     * @return elementTypeName
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementTypeName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getElementTypeName() { return elementTypeName; }
    public void setElementTypeName(String elementTypeName) { this.elementTypeName = elementTypeName; }

    public ElementType elementSuperTypeNames(List<String> elementSuperTypeNames) {
        this.elementSuperTypeNames = elementSuperTypeNames;
        return this;
    }

    public ElementType addElementSuperTypeNamesItem(String elementSuperTypeNamesItem) {
        if (this.elementSuperTypeNames == null) {
            this.elementSuperTypeNames = new ArrayList<>();
        }
        this.elementSuperTypeNames.add(elementSuperTypeNamesItem);
        return this;
    }

    /**
     * Get elementSuperTypeNames
     * @return elementSuperTypeNames
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementSuperTypeNames")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getElementSuperTypeNames() { return elementSuperTypeNames; }
    public void setElementSuperTypeNames(List<String> elementSuperTypeNames) { this.elementSuperTypeNames = elementSuperTypeNames; }

    public ElementType elementTypeVersion(Long elementTypeVersion) {
        this.elementTypeVersion = elementTypeVersion;
        return this;
    }

    /**
     * Get elementTypeVersion
     * @return elementTypeVersion
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementTypeVersion")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getElementTypeVersion() { return elementTypeVersion; }
    public void setElementTypeVersion(Long elementTypeVersion) { this.elementTypeVersion = elementTypeVersion; }

    public ElementType elementTypeDescription(String elementTypeDescription) {
        this.elementTypeDescription = elementTypeDescription;
        return this;
    }

    /**
     * Get elementTypeDescription
     * @return elementTypeDescription
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementTypeDescription")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getElementTypeDescription() { return elementTypeDescription; }
    public void setElementTypeDescription(String elementTypeDescription) { this.elementTypeDescription = elementTypeDescription; }

    public ElementType elementSourceServer(String elementSourceServer) {
        this.elementSourceServer = elementSourceServer;
        return this;
    }

    /**
     * Get elementSourceServer
     * @return elementSourceServer
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementSourceServer")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getElementSourceServer() { return elementSourceServer; }
    public void setElementSourceServer(String elementSourceServer) { this.elementSourceServer = elementSourceServer; }

    public ElementType elementOrigin(ElementOrigin elementOrigin) {
        this.elementOrigin = elementOrigin;
        return this;
    }

    /**
     * Get elementOrigin
     * @return elementOrigin
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementOrigin")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ElementOrigin getElementOrigin() { return elementOrigin; }
    public void setElementOrigin(ElementOrigin elementOrigin) { this.elementOrigin = elementOrigin; }

    public ElementType elementHomeMetadataCollectionId(String elementHomeMetadataCollectionId) {
        this.elementHomeMetadataCollectionId = elementHomeMetadataCollectionId;
        return this;
    }

    /**
     * Get elementHomeMetadataCollectionId
     * @return elementHomeMetadataCollectionId
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementHomeMetadataCollectionId")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getElementHomeMetadataCollectionId() { return elementHomeMetadataCollectionId; }
    public void setElementHomeMetadataCollectionId(String elementHomeMetadataCollectionId) { this.elementHomeMetadataCollectionId = elementHomeMetadataCollectionId; }

    public ElementType elementHomeMetadataCollectionName(String elementHomeMetadataCollectionName) {
        this.elementHomeMetadataCollectionName = elementHomeMetadataCollectionName;
        return this;
    }

    /**
     * Get elementHomeMetadataCollectionName
     * @return elementHomeMetadataCollectionName
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementHomeMetadataCollectionName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getElementHomeMetadataCollectionName() { return elementHomeMetadataCollectionName; }
    public void setElementHomeMetadataCollectionName(String elementHomeMetadataCollectionName) { this.elementHomeMetadataCollectionName = elementHomeMetadataCollectionName; }

    public ElementType elementLicense(String elementLicense) {
        this.elementLicense = elementLicense;
        return this;
    }

    /**
     * Get elementLicense
     * @return elementLicense
     **/
    @javax.annotation.Nullable
    @JsonProperty("elementLicense")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getElementLicense() { return elementLicense; }
    public void setElementLicense(String elementLicense) { this.elementLicense = elementLicense; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ElementType elementType = (ElementType)o;
        return Objects.equals(this.elementTypeId, elementType.elementTypeId) &&
                Objects.equals(this.elementTypeName, elementType.elementTypeName) &&
                Objects.equals(this.elementSuperTypeNames, elementType.elementSuperTypeNames) &&
                Objects.equals(this.elementTypeVersion, elementType.elementTypeVersion) &&
                Objects.equals(this.elementTypeDescription, elementType.elementTypeDescription) &&
                Objects.equals(this.elementSourceServer, elementType.elementSourceServer) &&
                Objects.equals(this.elementOrigin, elementType.elementOrigin) &&
                Objects.equals(this.elementHomeMetadataCollectionId, elementType.elementHomeMetadataCollectionId) &&
                Objects.equals(this.elementHomeMetadataCollectionName, elementType.elementHomeMetadataCollectionName) &&
                Objects.equals(this.elementLicense, elementType.elementLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementTypeId, elementTypeName, elementSuperTypeNames,
                elementTypeVersion, elementTypeDescription,
                elementSourceServer, elementOrigin,
                elementHomeMetadataCollectionId,
                elementHomeMetadataCollectionName, elementLicense);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ElementType {\n");
        sb.append("    elementTypeId: ").append(toIndentedString(elementTypeId)).append("\n");
        sb.append("    elementTypeName: ").append(toIndentedString(elementTypeName)).append("\n");
        sb.append("    elementSuperTypeNames: ").append(toIndentedString(elementSuperTypeNames)).append("\n");
        sb.append("    elementTypeVersion: ").append(toIndentedString(elementTypeVersion)).append("\n");
        sb.append("    elementTypeDescription: ").append(toIndentedString(elementTypeDescription)).append("\n");
        sb.append("    elementSourceServer: ").append(toIndentedString(elementSourceServer)).append("\n");
        sb.append("    elementOrigin: ").append(toIndentedString(elementOrigin)).append("\n");
        sb.append("    elementHomeMetadataCollectionId: ").append(toIndentedString(elementHomeMetadataCollectionId)).append("\n");
        sb.append("    elementHomeMetadataCollectionName: ").append(toIndentedString(elementHomeMetadataCollectionName)).append("\n");
        sb.append("    elementLicense: ").append(toIndentedString(elementLicense)).append("\n");
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
