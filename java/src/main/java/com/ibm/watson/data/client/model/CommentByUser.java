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
 * CommentByUser
 */
public class CommentByUser {

    private String comment;
    private Boolean allowEdits;

    public CommentByUser comment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * User comment
     * @return comment
     **/
    @JsonProperty("comment")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public CommentByUser allowEdits(Boolean allowEdits) {
        this.allowEdits = allowEdits;
        return this;
    }

    @JsonProperty("allow_edits")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Boolean getAllowEdits() { return allowEdits; }
    public void setAllowEdits(Boolean allowEdits) { this.allowEdits = allowEdits; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CommentByUser commentByUser = (CommentByUser)o;
        return Objects.equals(this.comment, commentByUser.comment) &&
                Objects.equals(this.allowEdits, commentByUser.allowEdits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, allowEdits);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommentByUser {\n");
        sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
        sb.append("    allowEdits: ").append(toIndentedString(allowEdits)).append("\n");
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
