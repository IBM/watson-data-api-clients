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
 * DataPlatformConfig
 */
public class DataPlatformConfig {

    private String dataPlatformServerURL;
    private String dataPlatformServerName;
    private String dataPlatformGUID;
    private Connection dataPlatformConnection;
    private String dataPlatformServerOutTopicName;
    private Connection dataPlatformServerOutTopic;

    public DataPlatformConfig dataPlatformServerURL(String dataPlatformServerURL) {
        this.dataPlatformServerURL = dataPlatformServerURL;
        return this;
    }

    /**
     * Get dataPlatformServerURL
     * @return dataPlatformServerURL
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataPlatformServerURL")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDataPlatformServerURL() { return dataPlatformServerURL; }
    public void setDataPlatformServerURL(String dataPlatformServerURL) { this.dataPlatformServerURL = dataPlatformServerURL; }

    public DataPlatformConfig dataPlatformServerName(String dataPlatformServerName) {
        this.dataPlatformServerName = dataPlatformServerName;
        return this;
    }

    /**
     * Get dataPlatformServerName
     * @return dataPlatformServerName
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataPlatformServerName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDataPlatformServerName() { return dataPlatformServerName; }
    public void setDataPlatformServerName(String dataPlatformServerName) { this.dataPlatformServerName = dataPlatformServerName; }

    public DataPlatformConfig dataPlatformGUID(String dataPlatformGUID) {
        this.dataPlatformGUID = dataPlatformGUID;
        return this;
    }

    /**
     * Get dataPlatformGUID
     * @return dataPlatformGUID
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataPlatformGUID")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDataPlatformGUID() { return dataPlatformGUID; }
    public void setDataPlatformGUID(String dataPlatformGUID) { this.dataPlatformGUID = dataPlatformGUID; }

    public DataPlatformConfig dataPlatformConnection(Connection dataPlatformConnection) {
        this.dataPlatformConnection = dataPlatformConnection;
        return this;
    }

    /**
     * Get dataPlatformConnection
     * @return dataPlatformConnection
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataPlatformConnection")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getDataPlatformConnection() { return dataPlatformConnection; }
    public void setDataPlatformConnection(Connection dataPlatformConnection) { this.dataPlatformConnection = dataPlatformConnection; }

    public DataPlatformConfig dataPlatformServerOutTopicName(String dataPlatformServerOutTopicName) {
        this.dataPlatformServerOutTopicName = dataPlatformServerOutTopicName;
        return this;
    }

    /**
     * Get dataPlatformServerOutTopicName
     * @return dataPlatformServerOutTopicName
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataPlatformServerOutTopicName")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getDataPlatformServerOutTopicName() { return dataPlatformServerOutTopicName; }
    public void setDataPlatformServerOutTopicName(String dataPlatformServerOutTopicName) { this.dataPlatformServerOutTopicName = dataPlatformServerOutTopicName; }

    public DataPlatformConfig dataPlatformServerOutTopic(Connection dataPlatformServerOutTopic) {
        this.dataPlatformServerOutTopic = dataPlatformServerOutTopic;
        return this;
    }

    /**
     * Get dataPlatformServerOutTopic
     * @return dataPlatformServerOutTopic
     **/
    @javax.annotation.Nullable
    @JsonProperty("dataPlatformServerOutTopic")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Connection getDataPlatformServerOutTopic() { return dataPlatformServerOutTopic; }
    public void setDataPlatformServerOutTopic(Connection dataPlatformServerOutTopic) { this.dataPlatformServerOutTopic = dataPlatformServerOutTopic; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        DataPlatformConfig dataPlatformConfig = (DataPlatformConfig)o;
        return Objects.equals(this.dataPlatformServerURL, dataPlatformConfig.dataPlatformServerURL) &&
                Objects.equals(this.dataPlatformServerName, dataPlatformConfig.dataPlatformServerName) &&
                Objects.equals(this.dataPlatformGUID, dataPlatformConfig.dataPlatformGUID) &&
                Objects.equals(this.dataPlatformConnection, dataPlatformConfig.dataPlatformConnection) &&
                Objects.equals(this.dataPlatformServerOutTopicName, dataPlatformConfig.dataPlatformServerOutTopicName) &&
                Objects.equals(this.dataPlatformServerOutTopic, dataPlatformConfig.dataPlatformServerOutTopic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataPlatformServerURL, dataPlatformServerName,
                dataPlatformGUID, dataPlatformConnection,
                dataPlatformServerOutTopicName,
                dataPlatformServerOutTopic);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataPlatformConfig {\n");
        sb.append("    dataPlatformServerURL: ").append(toIndentedString(dataPlatformServerURL)).append("\n");
        sb.append("    dataPlatformServerName: ").append(toIndentedString(dataPlatformServerName)).append("\n");
        sb.append("    dataPlatformGUID: ").append(toIndentedString(dataPlatformGUID)).append("\n");
        sb.append("    dataPlatformConnection: ").append(toIndentedString(dataPlatformConnection)).append("\n");
        sb.append("    dataPlatformServerOutTopicName: ").append(toIndentedString(dataPlatformServerOutTopicName)).append("\n");
        sb.append("    dataPlatformServerOutTopic: ").append(toIndentedString(dataPlatformServerOutTopic)).append("\n");
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
