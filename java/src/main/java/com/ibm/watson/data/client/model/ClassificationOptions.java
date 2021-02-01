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

import java.util.*;

/**
 * ClassificationOptions
 */
public class ClassificationOptions {

    private Boolean disabled;
    private Boolean useAllIbmClasses;
    private Boolean useAllCustomClasses;
    private List<Object> ibmClassCodes; // TODO: probably Strings?
    private List<Object> customClassCodes; // TODO: probably Strings?

    @javax.annotation.Nullable
    @JsonProperty("disabled")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getDisabled() { return disabled; }
    public void setDisabled(Boolean disabled) { this.disabled = disabled; }

    @javax.annotation.Nullable
    @JsonProperty("use_all_ibm_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getUseAllIbmClasses() { return useAllIbmClasses; }
    public void setUseAllIbmClasses(Boolean useAllIbmClasses) { this.useAllIbmClasses = useAllIbmClasses; }

    @javax.annotation.Nullable
    @JsonProperty("use_all_custom_classes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getUseAllCustomClasses() { return useAllCustomClasses; }
    public void setUseAllCustomClasses(Boolean useAllCustomClasses) { this.useAllCustomClasses = useAllCustomClasses; }

    @javax.annotation.Nullable
    @JsonProperty("ibm_class_codes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getIbmClassCodes() { return ibmClassCodes; }
    public void setIbmClassCodes(List<Object> ibmClassCodes) { this.ibmClassCodes = ibmClassCodes; }

    @javax.annotation.Nullable
    @JsonProperty("custom_class_codes")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<Object> getCustomClassCodes() { return customClassCodes; }
    public void setCustomClassCodes(List<Object> customClassCodes) { this.customClassCodes = customClassCodes; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ClassificationOptions that = (ClassificationOptions)o;
        return Objects.equals(this.disabled, that.disabled) &&
                Objects.equals(this.useAllIbmClasses, that.useAllIbmClasses) &&
                Objects.equals(this.useAllCustomClasses, that.useAllCustomClasses) &&
                Objects.equals(this.ibmClassCodes, that.ibmClassCodes) &&
                Objects.equals(this.customClassCodes, that.customClassCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(disabled, useAllIbmClasses, useAllCustomClasses, ibmClassCodes, customClassCodes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ClassificationOptions {\n");
        sb.append("    disabled: ").append(toIndentedString(disabled)).append("\n");
        sb.append("    useAllIbmClasses: ").append(toIndentedString(useAllIbmClasses)).append("\n");
        sb.append("    useAllCustomClasses: ").append(toIndentedString(useAllCustomClasses)).append("\n");
        sb.append("    ibmClassCodes: ").append(toIndentedString(ibmClassCodes)).append("\n");
        sb.append("    customClassCodes: ").append(toIndentedString(customClassCodes)).append("\n");
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
