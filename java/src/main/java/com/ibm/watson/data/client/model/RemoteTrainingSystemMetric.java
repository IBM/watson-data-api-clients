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

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

/**
 * The remote training system metric. 
 */
public class RemoteTrainingSystemMetric {

    private String id;
    private BigDecimal local;
    private BigDecimal fused;

    public RemoteTrainingSystemMetric id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     **/
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public RemoteTrainingSystemMetric local(BigDecimal local) {
        this.local = local;
        return this;
    }

    /**
     * Get local
     * @return local
     **/
    @javax.annotation.Nullable
    @JsonProperty("local")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getLocal() { return local; }
    public void setLocal(BigDecimal local) { this.local = local; }

    public RemoteTrainingSystemMetric fused(BigDecimal fused) {
        this.fused = fused;
        return this;
    }

    /**
     * Get fused
     * @return fused
     **/
    @javax.annotation.Nullable
    @JsonProperty("fused")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getFused() { return fused; }
    public void setFused(BigDecimal fused) { this.fused = fused; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        RemoteTrainingSystemMetric remoteTrainingSystemMetric = (RemoteTrainingSystemMetric) o;
        return Objects.equals(this.id, remoteTrainingSystemMetric.id) &&
                Objects.equals(this.local, remoteTrainingSystemMetric.local) &&
                Objects.equals(this.fused, remoteTrainingSystemMetric.fused);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, local, fused);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RemoteTrainingSystemMetric {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    local: ").append(toIndentedString(local)).append("\n");
        sb.append("    fused: ").append(toIndentedString(fused)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
