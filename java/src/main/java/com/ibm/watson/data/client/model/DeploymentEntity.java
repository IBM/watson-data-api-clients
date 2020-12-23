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
import com.ibm.watson.data.client.model.enums.DeployedAssetType;

/**
 * DeploymentEntity
 */
public class DeploymentEntity extends DeploymentEntityRequest {

    private DeployedAssetType deployedAssetType;
    private DeploymentEntityStatus status;

    public DeploymentEntity deployedAssetType(DeployedAssetType deployedAssetType) {
        this.deployedAssetType = deployedAssetType;
        return this;
    }

    /**
     * Specifies the type of the asset on which deployment is created.
     * @return deployedAssetType
     **/
    @javax.annotation.Nullable
    @JsonProperty("deployed_asset_type")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeployedAssetType getDeployedAssetType() { return deployedAssetType; }
    public void setDeployedAssetType(DeployedAssetType deployedAssetType) { this.deployedAssetType = deployedAssetType; }

    public DeploymentEntity status(DeploymentEntityStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeploymentEntityStatus getStatus() { return status; }
    public void setStatus(DeploymentEntityStatus status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentEntity deploymentEntity = (DeploymentEntity) o;
        return super.equals(o) &&
                Objects.equals(this.deployedAssetType, deploymentEntity.deployedAssetType) &&
                Objects.equals(this.status, deploymentEntity.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), deployedAssetType, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentEntity {\n");
        super.toString(sb);
        sb.append("    deployedAssetType: ").append(toIndentedString(deployedAssetType)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
