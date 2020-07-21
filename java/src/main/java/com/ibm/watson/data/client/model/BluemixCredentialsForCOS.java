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
 * Bluemix COS  Credentials
 */
@ApiModel(description = "Bluemix COS  Credentials")
@JsonPropertyOrder({
        BluemixCredentialsForCOS.JSON_PROPERTY_VIEWER,
        BluemixCredentialsForCOS.JSON_PROPERTY_EDITOR,
        BluemixCredentialsForCOS.JSON_PROPERTY_ADMIN
})
public class BluemixCredentialsForCOS {

    public static final String JSON_PROPERTY_VIEWER = "viewer";
    private BluemixCOSCredentials viewer;

    public static final String JSON_PROPERTY_EDITOR = "editor";
    private BluemixCOSCredentials editor;

    public static final String JSON_PROPERTY_ADMIN = "admin";
    private BluemixCOSCredentials admin;

    public BluemixCredentialsForCOS viewer(BluemixCOSCredentials viewer) {
        this.viewer = viewer;
        return this;
    }

    /**
     * Get viewer
     * @return viewer
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_VIEWER)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BluemixCOSCredentials getViewer() {
        return viewer;
    }

    public void setViewer(BluemixCOSCredentials viewer) { this.viewer = viewer; }

    public BluemixCredentialsForCOS editor(BluemixCOSCredentials editor) {
        this.editor = editor;
        return this;
    }

    /**
     * Get editor
     * @return editor
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_EDITOR)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BluemixCOSCredentials getEditor() {
        return editor;
    }

    public void setEditor(BluemixCOSCredentials editor) { this.editor = editor; }

    public BluemixCredentialsForCOS admin(BluemixCOSCredentials admin) {
        this.admin = admin;
        return this;
    }

    /**
     * Get admin
     * @return admin
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "")
    @JsonProperty(JSON_PROPERTY_ADMIN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public BluemixCOSCredentials getAdmin() {
        return admin;
    }

    public void setAdmin(BluemixCOSCredentials admin) { this.admin = admin; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BluemixCredentialsForCOS bluemixCredentialsForCOS =
                (BluemixCredentialsForCOS)o;
        return Objects.equals(this.viewer, bluemixCredentialsForCOS.viewer) &&
                Objects.equals(this.editor, bluemixCredentialsForCOS.editor) &&
                Objects.equals(this.admin, bluemixCredentialsForCOS.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viewer, editor, admin);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BluemixCredentialsForCOS {\n");
        sb.append("    viewer: ").append(toIndentedString(viewer)).append("\n");
        sb.append("    editor: ").append(toIndentedString(editor)).append("\n");
        sb.append("    admin: ").append(toIndentedString(admin)).append("\n");
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
