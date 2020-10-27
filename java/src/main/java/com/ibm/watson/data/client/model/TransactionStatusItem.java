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
 * Description of import transactional status API response.
 */
public class TransactionStatusItem {

    private String createdAt;
    private String description;
    private List<TransactionHistory> history = null;
    private String id;
    private String name;
    private String status;
    private String updatedAt;

    public TransactionStatusItem createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * The date and time the status was created in UTC (ISO 8601)
     * @return createdAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public TransactionStatusItem description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Description of the last know transaction status
     * @return description
     **/
    @javax.annotation.Nullable
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public TransactionStatusItem history(List<TransactionHistory> history) {
        this.history = history;
        return this;
    }

    public TransactionStatusItem addHistoryItem(TransactionHistory historyItem) {
        if (this.history == null) {
            this.history = new ArrayList<>();
        }
        this.history.add(historyItem);
        return this;
    }

    /**
     * Description of all last know import status.
     * @return history
     **/
    @javax.annotation.Nullable
    @JsonProperty("history")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<TransactionHistory> getHistory() { return history; }
    public void setHistory(List<TransactionHistory> history) { this.history = history; }

    public TransactionStatusItem id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Project GUID.
     * @return id
     **/
    @javax.annotation.Nullable
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public TransactionStatusItem name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the project.
     * @return name
     **/
    @javax.annotation.Nullable
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public TransactionStatusItem status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Last known status of the transaction
     * @return status
     **/
    @javax.annotation.Nullable
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public TransactionStatusItem updatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * The date and time the status was last updated in UTC (ISO 8601)
     * @return updatedAt
     **/
    @javax.annotation.Nullable
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        TransactionStatusItem transactionStatusItem = (TransactionStatusItem)o;
        return Objects.equals(this.createdAt, transactionStatusItem.createdAt) &&
                Objects.equals(this.description, transactionStatusItem.description) &&
                Objects.equals(this.history, transactionStatusItem.history) &&
                Objects.equals(this.id, transactionStatusItem.id) &&
                Objects.equals(this.name, transactionStatusItem.name) &&
                Objects.equals(this.status, transactionStatusItem.status) &&
                Objects.equals(this.updatedAt, transactionStatusItem.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, description, history, id, name, status,
                updatedAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionStatusItem {\n");
        sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    history: ").append(toIndentedString(history)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
