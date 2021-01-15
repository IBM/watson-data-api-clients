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

import java.util.Map;
import java.util.Objects;

/**
 * Metadata about an asset, as a result, including entity information
 */
public class MetadataEntityResult extends MetadataAssetResult {

    private Map<String, AbstractAssetEntity> entity;

    public MetadataEntityResult entity(Map<String, AbstractAssetEntity> entity) {
        this.entity = entity;
        return this;
    }

    @javax.annotation.Nullable
    @JsonProperty("entity")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, AbstractAssetEntity> getEntity() { return entity; }
    public void setEntity(Map<String, AbstractAssetEntity> entity) { this.entity = entity; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MetadataEntityResult asset = (MetadataEntityResult)o;
        return super.equals(o) &&
                Objects.equals(this.entity, asset.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), entity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MetadataEntityResult {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    entity: ").append(toIndentedString(entity)).append("\n");
    }

}
