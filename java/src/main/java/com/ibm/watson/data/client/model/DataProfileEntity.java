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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ibm.watson.data.client.serde.DataProfileEntitySerializer;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * DataProfileEntity
 */
@JsonSerialize(using = DataProfileEntitySerializer.class)
@JsonDeserialize(using = JsonDeserializer.None.class)
public class DataProfileEntity extends AbstractAssetEntity {

    @JsonIgnore
    private Map<String, DataProfile> profiles;

    private List<String> attributeClasses;
    private List<AttributeClassificationOverride> attributeClassificationManual;
    private List<DataClassificationOverride> dataClassificationManual;

    @JsonIgnore
    public Map<String, DataProfile> getProfiles() { return profiles; }
    public void setProfiles(Map<String, DataProfile> profiles) { this.profiles = profiles; }

    @javax.annotation.Nullable
    @JsonProperty("attribute_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getAttributeClasses() { return attributeClasses; }
    public void setAttributeClasses(List<String> attributeClasses) { this.attributeClasses = attributeClasses; }

    @javax.annotation.Nullable
    @JsonProperty("attribute_classification_manual")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<AttributeClassificationOverride> getAttributeClassificationManual() { return attributeClassificationManual; }
    public void setAttributeClassificationManual(List<AttributeClassificationOverride> attributeClassificationManual) { this.attributeClassificationManual = attributeClassificationManual; }

    @javax.annotation.Nullable
    @JsonProperty("data_classification_manual")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<DataClassificationOverride> getDataClassificationManual() { return dataClassificationManual; }
    public void setDataClassificationManual(List<DataClassificationOverride> dataClassificationManual) { this.dataClassificationManual = dataClassificationManual; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataProfileEntity that = (DataProfileEntity) o;
        return Objects.equals(profiles, that.profiles) &&
                Objects.equals(attributeClasses, that.attributeClasses) &&
                Objects.equals(attributeClassificationManual, that.attributeClassificationManual) &&
                Objects.equals(dataClassificationManual, that.dataClassificationManual);
    }

    @Override
    public int hashCode() {
        return Objects.hash(profiles, attributeClasses, attributeClassificationManual, dataClassificationManual);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataProfileEntity {\n");
        sb.append("    profiles: ").append(toIndentedString(profiles)).append("\n");
        sb.append("    attributeClasses: ").append(toIndentedString(attributeClasses)).append("\n");
        sb.append("    attributeClassificationManual: ").append(toIndentedString(attributeClassificationManual)).append("\n");
        sb.append("    dataClassificationManual: ").append(toIndentedString(dataClassificationManual)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
