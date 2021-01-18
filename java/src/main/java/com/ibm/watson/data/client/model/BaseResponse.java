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

import java.util.Objects;

/**
 * BaseError
 */
public class BaseResponse {

    private String messageCode;
    private String message;

    public BaseResponse messageCode(String messageCode) {
        this.messageCode = messageCode;
        return this;
    }

    /**
     * The identifier of the response.
     * @return messageCode
     **/
    @javax.annotation.Nullable
    @JsonProperty("_messageCode_")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessageCode() { return messageCode; }
    public void setMessageCode(String messageCode) { this.messageCode = messageCode; }

    public BaseResponse message(String message) {
        this.message = message;
        return this;
    }

    /**
     * The explanation of the "messageCode".
     * @return message
     **/
    @javax.annotation.Nullable
    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        BaseResponse baseError = (BaseResponse)o;
        return Objects.equals(this.messageCode, baseError.messageCode) &&
                Objects.equals(this.message, baseError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(messageCode, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BaseError {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    protected void toString(StringBuilder sb) {
        sb.append("    messageCode: ").append(toIndentedString(messageCode)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    protected String toIndentedString(Object o) {
        if (o == null) { return "null"; }
        return o.toString().replace("\n", "\n    ");
    }

}
