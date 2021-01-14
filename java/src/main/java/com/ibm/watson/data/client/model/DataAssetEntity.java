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
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.Objects;

/**
 * DataAssetEntity
 */
@JsonDeserialize(using = JsonDeserializer.None.class)
public class DataAssetEntity extends AbstractAssetEntity {

    private String mimeType;
    private Boolean dataset;
    private List<ColumnDetail> columns;
    private List<NameValuePair> properties;

    @javax.annotation.Nullable
    @JsonProperty("mime_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMimeType() { return mimeType; }
    public void setMimeType(String mimeType) { this.mimeType = mimeType; }

    @javax.annotation.Nullable
    @JsonProperty("dataset")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getDataset() { return dataset; }
    public void setDataset(Boolean dataset) { this.dataset = dataset; }

    @javax.annotation.Nullable
    @JsonProperty("columns")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<ColumnDetail> getColumns() { return columns; }
    public void setColumns(List<ColumnDetail> columns) { this.columns = columns; }

    @javax.annotation.Nullable
    @JsonProperty("properties")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<NameValuePair> getProperties() { return properties; }
    public void setProperties(List<NameValuePair> properties) { this.properties = properties; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataAssetEntity that = (DataAssetEntity) o;
        return Objects.equals(mimeType, that.mimeType) &&
                Objects.equals(dataset, that.dataset) &&
                Objects.equals(columns, that.columns) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mimeType, dataset, columns, properties);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataAssetEntity {\n");
        sb.append("    mimeType: ").append(toIndentedString(mimeType)).append("\n");
        sb.append("    dataset: ").append(toIndentedString(dataset)).append("\n");
        sb.append("    columns: ").append(toIndentedString(columns)).append("\n");
        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
