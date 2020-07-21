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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * The Bluemix Cloud Object Storage (BMCOS) credentials.
 */
@ApiModel(description = "The Bluemix Cloud Object Storage (BMCOS) credentials.")
@JsonPropertyOrder({
        CloudObjectStorageCredentials.JSON_PROPERTY_ADMIN,
        CloudObjectStorageCredentials.JSON_PROPERTY_EDITOR,
        CloudObjectStorageCredentials.JSON_PROPERTY_VIEWER
})
public class CloudObjectStorageCredentials {

    public static final String JSON_PROPERTY_ADMIN = "admin";
    private BMCOSCredentialsAdmin admin;

    public static final String JSON_PROPERTY_EDITOR = "editor";
    private BMCOSCredentialsEditor editor;

    public static final String JSON_PROPERTY_VIEWER = "viewer";
    private BMCOSCredentialsEditor viewer;

    public CloudObjectStorageCredentials admin(BMCOSCredentialsAdmin admin) {
        this.admin = admin;
        return this;
    }

    /**
     * Get admin
     * @return admin
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_ADMIN)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public BMCOSCredentialsAdmin getAdmin() {
        return admin;
    }

    public void setAdmin(BMCOSCredentialsAdmin admin) { this.admin = admin; }

    public CloudObjectStorageCredentials editor(BMCOSCredentialsEditor editor) {
        this.editor = editor;
        return this;
    }

    /**
     * Get editor
     * @return editor
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_EDITOR)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public BMCOSCredentialsEditor getEditor() {
        return editor;
    }

    public void setEditor(BMCOSCredentialsEditor editor) { this.editor = editor; }

    public CloudObjectStorageCredentials viewer(BMCOSCredentialsEditor viewer) {
        this.viewer = viewer;
        return this;
    }

    /**
     * Get viewer
     * @return viewer
     **/
    @ApiModelProperty(required = true, value = "")
    @JsonProperty(JSON_PROPERTY_VIEWER)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public BMCOSCredentialsEditor getViewer() {
        return viewer;
    }

    public void setViewer(BMCOSCredentialsEditor viewer) { this.viewer = viewer; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CloudObjectStorageCredentials cloudObjectStorageCredentials =
                (CloudObjectStorageCredentials)o;
        return Objects.equals(this.admin, cloudObjectStorageCredentials.admin) &&
                Objects.equals(this.editor, cloudObjectStorageCredentials.editor) &&
                Objects.equals(this.viewer, cloudObjectStorageCredentials.viewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admin, editor, viewer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CloudObjectStorageCredentials {\n");
        sb.append("    admin: ").append(toIndentedString(admin)).append("\n");
        sb.append("    editor: ").append(toIndentedString(editor)).append("\n");
        sb.append("    viewer: ").append(toIndentedString(viewer)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
