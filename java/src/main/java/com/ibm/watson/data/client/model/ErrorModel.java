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
import java.util.Objects;

/**
 * ErrorModel
 */
public class ErrorModel extends HashMap<String, Object> {

    private String code;
    private ErrorTargetModel target;
    private String message;
    private String moreInfo;

    public ErrorModel code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     * @return code
     **/
    @JsonProperty("code")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public ErrorModel target(ErrorTargetModel target) {
        this.target = target;
        return this;
    }

    /**
     * Get target
     * @return target
     **/
    @javax.annotation.Nullable
    @JsonProperty("target")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public ErrorTargetModel getTarget() { return target; }
    public void setTarget(ErrorTargetModel target) { this.target = target; }

    public ErrorModel message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * @return message
     **/
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public ErrorModel moreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
        return this;
    }

    /**
     * Get moreInfo
     * @return moreInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("more_info")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMoreInfo() { return moreInfo; }
    public void setMoreInfo(String moreInfo) { this.moreInfo = moreInfo; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ErrorModel errorModel = (ErrorModel)o;
        return Objects.equals(this.code, errorModel.code) &&
                Objects.equals(this.target, errorModel.target) &&
                Objects.equals(this.message, errorModel.message) &&
                Objects.equals(this.moreInfo, errorModel.moreInfo) && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, target, message, moreInfo, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ErrorModel {\n");
        sb.append("    ").append(toIndentedString(super.toString())).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
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
