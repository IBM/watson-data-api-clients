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

import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

/**
 * The data returned when an error is encountered. 
 */
public class WMLError {

    private String trace;
    private List<WMLErrorDetails> errors = new ArrayList<>();

    public WMLError trace(String trace) {
        this.trace = trace;
        return this;
    }

    /**
     * An identifier that can be used to trace the request.
     * @return trace
     **/
    @JsonProperty("trace")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getTrace() { return trace; }
    public void setTrace(String trace) { this.trace = trace; }

    public WMLError errors(List<WMLErrorDetails> errors) {
        this.errors = errors;
        return this;
    }

    public WMLError addErrorsItem(WMLErrorDetails errorsItem) {
        this.errors.add(errorsItem);
        return this;
    }

    /**
     * The list of errors.
     * @return errors
     **/
    @JsonProperty("errors")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public List<WMLErrorDetails> getErrors() { return errors; }
    public void setErrors(List<WMLErrorDetails> errors) { this.errors = errors; }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        WMLError error = (WMLError) o;
        return Objects.equals(this.trace, error.trace) &&
                Objects.equals(this.errors, error.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trace, errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Error {\n");
        sb.append("    trace: ").append(toIndentedString(trace)).append("\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
