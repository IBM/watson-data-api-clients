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
 * WMLErrorDetails
 */
public class WMLErrorDetails {

    private String code;
    private String message;
    private String moreInfo;

    public WMLErrorDetails code(String code) {
        this.code = code;
        return this;
    }

    /**
     * A simple code that should convey the general sense of the error.
     * @return code
     **/
    @JsonProperty("code")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public WMLErrorDetails message(String message) {
        this.message = message;
        return this;
    }

    /**
     * The message that describes the error.
     * @return message
     **/
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public WMLErrorDetails moreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
        return this;
    }

    /**
     * A reference to a more detailed explanation when available.
     * @return moreInfo
     **/
    @javax.annotation.Nullable
    @JsonProperty("more_info")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMoreInfo() { return moreInfo; }
    public void setMoreInfo(String moreInfo) { this.moreInfo = moreInfo; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        WMLErrorDetails that = (WMLErrorDetails) o;
        return Objects.equals(this.code, that.code) &&
                Objects.equals(this.message, that.message) &&
                Objects.equals(this.moreInfo, that.moreInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message, moreInfo);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WMLErrorDetails {\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    moreInfo: ").append(toIndentedString(moreInfo)).append("\n");
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
