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

/**
 * Optional messages related to the deployment. 
 */
public class DeploymentEntityStatusMessage {

    private String level;
    private String text;

    public DeploymentEntityStatusMessage level(String level) {
        this.level = level;
        return this;
    }

    /**
     * The level of the message, normally one of &#x60;debug&#x60;, &#x60;info&#x60; or &#x60;warning&#x60;.
     * @return level
     **/
    @javax.annotation.Nullable
    @JsonProperty("level")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public DeploymentEntityStatusMessage text(String text) {
        this.text = text;
        return this;
    }

    /**
     * The message.
     * @return text
     **/
    @javax.annotation.Nullable
    @JsonProperty("text")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DeploymentEntityStatusMessage deploymentEntityAllOfStatusMessage = (DeploymentEntityStatusMessage) o;
        return Objects.equals(this.level, deploymentEntityAllOfStatusMessage.level) &&
                Objects.equals(this.text, deploymentEntityAllOfStatusMessage.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, text);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeploymentEntityStatusMessage {\n");
        sb.append("    level: ").append(toIndentedString(level)).append("\n");
        sb.append("    text: ").append(toIndentedString(text)).append("\n");
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
