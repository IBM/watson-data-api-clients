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

public class CreateGroupResponse extends GroupInfo {

    public String messageCode;
    public String message;

    public CreateGroupResponse messageCode(String messageCode) {
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

    public CreateGroupResponse message(String message) {
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
        CreateGroupResponse that = (CreateGroupResponse)o;
        return super.equals(that) &&
                Objects.equals(this.messageCode, that.messageCode) &&
                Objects.equals(this.message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), messageCode, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreateGroupResponse {\n");
        toString(sb);
        sb.append("}");
        return sb.toString();
    }

    @Override
    protected void toString(StringBuilder sb) {
        super.toString(sb);
        sb.append("    messageCode: ").append(toIndentedString(messageCode)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
    }

}
