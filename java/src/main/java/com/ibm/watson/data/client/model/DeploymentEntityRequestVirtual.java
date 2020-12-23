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
import com.ibm.watson.data.client.model.enums.DeploymentExportFormat;

/**
 * Indicates that this is a virtual deployment. 
 */
public class DeploymentEntityRequestVirtual extends DeploymentEntityRequestPhysical {

    private DeploymentExportFormat exportFormat;
    private ObjectLocation notificationSystem;

    public DeploymentEntityRequestVirtual exportFormat(DeploymentExportFormat exportFormat) {
        this.exportFormat = exportFormat;
        return this;
    }

    /**
     * Specify the target format of the model asset.
     * @return exportFormat
     **/
    @javax.annotation.Nullable
    @JsonProperty("export_format")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public DeploymentExportFormat getExportFormat() { return exportFormat; }
    public void setExportFormat(DeploymentExportFormat exportFormat) { this.exportFormat = exportFormat; }

    public DeploymentEntityRequestVirtual notificationSystem(ObjectLocation notificationSystem) {
        this.notificationSystem = notificationSystem;
        return this;
    }

    /**
     * Get notificationSystem
     * @return notificationSystem
     **/
    @javax.annotation.Nullable
    @JsonProperty("notification_system")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ObjectLocation getNotificationSystem() { return notificationSystem; }
    public void setNotificationSystem(ObjectLocation notificationSystem) { this.notificationSystem = notificationSystem; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentEntityRequestVirtual deploymentEntityRequestVirtual = (DeploymentEntityRequestVirtual) o;
        return super.equals(o) &&
                Objects.equals(this.exportFormat, deploymentEntityRequestVirtual.exportFormat) &&
                Objects.equals(this.notificationSystem, deploymentEntityRequestVirtual.notificationSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), exportFormat, notificationSystem);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentEntityRequestVirtual {\n");
        super.toString(sb);
        sb.append("    exportFormat: ").append(toIndentedString(exportFormat)).append("\n");
        sb.append("    notificationSystem: ").append(toIndentedString(notificationSystem)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
