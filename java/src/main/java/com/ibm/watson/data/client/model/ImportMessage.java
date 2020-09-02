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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ImportMessage
 */
public class ImportMessage {

    private Long lineNumber;
    private Long recordNumber;
    private String code;
    private String messageTemplate;
    private List<String> parameters = null;

    public ImportMessage lineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
        return this;
    }

    /**
     * Get lineNumber
     * @return lineNumber
     **/
    @javax.annotation.Nullable
    @JsonProperty("lineNumber")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getLineNumber() { return lineNumber; }
    public void setLineNumber(Long lineNumber) { this.lineNumber = lineNumber; }

    public ImportMessage recordNumber(Long recordNumber) {
        this.recordNumber = recordNumber;
        return this;
    }

    /**
     * Get recordNumber
     * @return recordNumber
     **/
    @javax.annotation.Nullable
    @JsonProperty("recordNumber")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getRecordNumber() { return recordNumber; }
    public void setRecordNumber(Long recordNumber) { this.recordNumber = recordNumber; }

    public ImportMessage code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Get code
     * @return code
     **/
    @javax.annotation.Nullable
    @JsonProperty("code")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public ImportMessage messageTemplate(String messageTemplate) {
        this.messageTemplate = messageTemplate;
        return this;
    }

    /**
     * Get messageTemplate
     * @return messageTemplate
     **/
    @javax.annotation.Nullable
    @JsonProperty("messageTemplate")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getMessageTemplate() { return messageTemplate; }
    public void setMessageTemplate(String messageTemplate) { this.messageTemplate = messageTemplate; }

    public ImportMessage parameters(List<String> parameters) {
        this.parameters = parameters;
        return this;
    }

    public ImportMessage addParametersItem(String parametersItem) {
        if (this.parameters == null) {
            this.parameters = new ArrayList<>();
        }
        this.parameters.add(parametersItem);
        return this;
    }

    /**
     * Get parameters
     * @return parameters
     **/
    @javax.annotation.Nullable
    @JsonProperty("parameters")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<String> getParameters() { return parameters; }
    public void setParameters(List<String> parameters) { this.parameters = parameters; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        ImportMessage importMessage = (ImportMessage)o;
        return Objects.equals(this.lineNumber, importMessage.lineNumber) &&
                Objects.equals(this.recordNumber, importMessage.recordNumber) &&
                Objects.equals(this.code, importMessage.code) &&
                Objects.equals(this.messageTemplate, importMessage.messageTemplate) &&
                Objects.equals(this.parameters, importMessage.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineNumber, recordNumber, code, messageTemplate,
                parameters);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ImportMessage {\n");
        sb.append("    lineNumber: ").append(toIndentedString(lineNumber)).append("\n");
        sb.append("    recordNumber: ").append(toIndentedString(recordNumber)).append("\n");
        sb.append("    code: ").append(toIndentedString(code)).append("\n");
        sb.append("    messageTemplate: ").append(toIndentedString(messageTemplate)).append("\n");
        sb.append("    parameters: ").append(toIndentedString(parameters)).append("\n");
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
