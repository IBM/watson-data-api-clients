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
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * CreateDefaultCatalogRequest
 */
public class CreateDefaultCatalogRequest {

    private CatalogEntity catalog;
    private Map<String, Object> eventBus = null;

    public CreateDefaultCatalogRequest catalog(CatalogEntity catalog) {
        this.catalog = catalog;
        return this;
    }

    /**
     * Get catalog
     * @return catalog
     **/
    @javax.annotation.Nullable
    @JsonProperty("catalog")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public CatalogEntity getCatalog() { return catalog; }
    public void setCatalog(CatalogEntity catalog) { this.catalog = catalog; }

    public CreateDefaultCatalogRequest eventBus(Map<String, Object> eventBus) {
        this.eventBus = eventBus;
        return this;
    }

    public CreateDefaultCatalogRequest putEventBusItem(String key, Object eventBusItem) {
        if (this.eventBus == null) {
            this.eventBus = new HashMap<>();
        }
        this.eventBus.put(key, eventBusItem);
        return this;
    }

    /**
     * Get eventBus
     * @return eventBus
     **/
    @javax.annotation.Nullable
    @JsonProperty("event_bus")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Map<String, Object> getEventBus() { return eventBus; }
    public void setEventBus(Map<String, Object> eventBus) { this.eventBus = eventBus; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CreateDefaultCatalogRequest createDefaultCatalogRequest = (CreateDefaultCatalogRequest)o;
        return Objects.equals(this.catalog, createDefaultCatalogRequest.catalog) &&
                Objects.equals(this.eventBus, createDefaultCatalogRequest.eventBus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(catalog, eventBus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateDefaultCatalogRequest {\n");
        sb.append("    catalog: ").append(toIndentedString(catalog)).append("\n");
        sb.append("    eventBus: ").append(toIndentedString(eventBus)).append("\n");
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
