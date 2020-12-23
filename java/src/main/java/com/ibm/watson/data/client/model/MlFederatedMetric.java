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

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * The metrics from federated training. 
 */
public class MlFederatedMetric {

    private List<RemoteTrainingSystemMetric> remoteTrainingSystems = null;
    private BigDecimal global;

    public MlFederatedMetric remoteTrainingSystems(List<RemoteTrainingSystemMetric> remoteTrainingSystems) {
        this.remoteTrainingSystems = remoteTrainingSystems;
        return this;
    }

    public MlFederatedMetric addRemoteTrainingSystemsItem(RemoteTrainingSystemMetric remoteTrainingSystemsItem) {
        if (this.remoteTrainingSystems == null) {
            this.remoteTrainingSystems = new ArrayList<>();
        }
        this.remoteTrainingSystems.add(remoteTrainingSystemsItem);
        return this;
    }

    /**
     * Remote training systems.
     * @return remoteTrainingSystems
     **/
    @javax.annotation.Nullable
    @JsonProperty("remote_training_systems")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<RemoteTrainingSystemMetric> getRemoteTrainingSystems() { return remoteTrainingSystems; }
    public void setRemoteTrainingSystems(List<RemoteTrainingSystemMetric> remoteTrainingSystems) { this.remoteTrainingSystems = remoteTrainingSystems; }

    public MlFederatedMetric global(BigDecimal global) {
        this.global = global;
        return this;
    }

    /**
     * Get global
     * @return global
     **/
    @javax.annotation.Nullable
    @JsonProperty("global")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public BigDecimal getGlobal() { return global; }
    public void setGlobal(BigDecimal global) { this.global = global; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        MlFederatedMetric mlFederatedMetric = (MlFederatedMetric) o;
        return Objects.equals(this.remoteTrainingSystems, mlFederatedMetric.remoteTrainingSystems) &&
                Objects.equals(this.global, mlFederatedMetric.global);
    }

    @Override
    public int hashCode() {
        return Objects.hash(remoteTrainingSystems, global);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MlFederatedMetric {\n");
        sb.append("    remoteTrainingSystems: ").append(toIndentedString(remoteTrainingSystems)).append("\n");
        sb.append("    global: ").append(toIndentedString(global)).append("\n");
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
