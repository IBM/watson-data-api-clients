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
 * AssetCommentEntity
 */
public class AssetCommentEntity {

    private String comment;
    private String logStatus;
    private String oldWfStatus;
    private String newWfStatus;
    private String action;
    private List<AssetCommentPropertyModification> modificationDetails = null;

    public AssetCommentEntity comment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Comment by WorkFlow Service
     * @return comment
     **/
    @javax.annotation.Nullable
    @JsonProperty("comment")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public AssetCommentEntity logStatus(String logStatus) {
        this.logStatus = logStatus;
        return this;
    }

    /**
     * The log status
     * @return logStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("log_status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getLogStatus() { return logStatus; }
    public void setLogStatus(String logStatus) { this.logStatus = logStatus; }

    public AssetCommentEntity oldWfStatus(String oldWfStatus) {
        this.oldWfStatus = oldWfStatus;
        return this;
    }

    /**
     * The old WorkFlow status
     * @return oldWfStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("oldWfStatus")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getOldWfStatus() { return oldWfStatus; }
    public void setOldWfStatus(String oldWfStatus) { this.oldWfStatus = oldWfStatus; }

    public AssetCommentEntity newWfStatus(String newWfStatus) {
        this.newWfStatus = newWfStatus;
        return this;
    }

    /**
     * The new WorkFlow status
     * @return newWfStatus
     **/
    @javax.annotation.Nullable
    @JsonProperty("newWfStatus")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getNewWfStatus() { return newWfStatus; }
    public void setNewWfStatus(String newWfStatus) { this.newWfStatus = newWfStatus; }

    public AssetCommentEntity action(String action) {
        this.action = action;
        return this;
    }

    /**
     * The action
     * @return action
     **/
    @javax.annotation.Nullable
    @JsonProperty("action")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public AssetCommentEntity modificationDetails(List<AssetCommentPropertyModification> modificationDetails) {
        this.modificationDetails = modificationDetails;
        return this;
    }

    public AssetCommentEntity addModificationDetailsItem(AssetCommentPropertyModification modificationDetailsItem) {
        if (this.modificationDetails == null) {
            this.modificationDetails = new ArrayList<>();
        }
        this.modificationDetails.add(modificationDetailsItem);
        return this;
    }

    /**
     * The Modifications
     * @return modificationDetails
     **/
    @javax.annotation.Nullable
    @JsonProperty("modification_details")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<AssetCommentPropertyModification> getModificationDetails() { return modificationDetails; }
    public void setModificationDetails(List<AssetCommentPropertyModification> modificationDetails) { this.modificationDetails = modificationDetails; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetCommentEntity assetAggregatedCommentEntity = (AssetCommentEntity)o;
        return Objects.equals(this.comment, assetAggregatedCommentEntity.comment) &&
                Objects.equals(this.logStatus, assetAggregatedCommentEntity.logStatus) &&
                Objects.equals(this.oldWfStatus, assetAggregatedCommentEntity.oldWfStatus) &&
                Objects.equals(this.newWfStatus, assetAggregatedCommentEntity.newWfStatus) &&
                Objects.equals(this.action, assetAggregatedCommentEntity.action) &&
                Objects.equals(this.modificationDetails, assetAggregatedCommentEntity.modificationDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, logStatus, oldWfStatus, newWfStatus, action,
                modificationDetails);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetCommentEntity {\n");
        sb.append("    comment: ").append(toIndentedString(comment)).append("\n");
        sb.append("    logStatus: ").append(toIndentedString(logStatus)).append("\n");
        sb.append("    oldWfStatus: ").append(toIndentedString(oldWfStatus)).append("\n");
        sb.append("    newWfStatus: ").append(toIndentedString(newWfStatus)).append("\n");
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("    modificationDetails: ").append(toIndentedString(modificationDetails)).append("\n");
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
