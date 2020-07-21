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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;

/**
 * Compute properties for the cloud.
 */
@ApiModel(description = "Compute properties for the cloud.")
@JsonPropertyOrder({
        TransactionalProjectComputeObjectCloud.JSON_PROPERTY_CRN,
        TransactionalProjectComputeObjectCloud.JSON_PROPERTY_GUID,
        TransactionalProjectComputeObjectCloud.JSON_PROPERTY_LABEL,
        TransactionalProjectComputeObjectCloud.JSON_PROPERTY_NAME,
        TransactionalProjectComputeObjectCloud.JSON_PROPERTY_TYPE
})
public class TransactionalProjectComputeObjectCloud {

    public static final String JSON_PROPERTY_CRN = "crn";
    private String crn;

    public static final String JSON_PROPERTY_GUID = "guid";
    private String guid;

    public static final String JSON_PROPERTY_LABEL = "label";
    private String label;

    public static final String JSON_PROPERTY_NAME = "name";
    private String name;

    /**
     * The type of the associated project compute.
     */
    public enum TypeEnum {
        SPARK("spark"),

        MACHINE_LEARNING("machine_learning"),

        AWS_EMR("aws_emr"),

        ANALYTICS_ENGINE("analytics_engine"),

        STREAMING_ANALYTICS("streaming_analytics"),

        WATSON("watson");

        private String value;

        TypeEnum(String value) { this.value = value; }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TypeEnum fromValue(String value) {
            for (TypeEnum b : TypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    public static final String JSON_PROPERTY_TYPE = "type";
    private TypeEnum type = TypeEnum.SPARK;

    public TransactionalProjectComputeObjectCloud crn(String crn) {
        this.crn = crn;
        return this;
    }

    /**
     * The Cloud Resource Name (CRN) for the compute service associated with the
     *project.
     * @return crn
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(
            example = "crn:v1:staging:public:watson-vision-combined:us-south:a/1438bf1daef49e20401d0179818ebef5:6874282b-42d6-40fa-869b-95a3c0f04125::",
            value = "The Cloud Resource Name (CRN) for the compute service associated with the project.")
    @JsonProperty(JSON_PROPERTY_CRN)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getCrn() {
        return crn;
    }

    public void setCrn(String crn) { this.crn = crn; }

    public TransactionalProjectComputeObjectCloud guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Unique guid of the associated project compute (i.e. GUID of Spark or
     *Machine Learning service instance).
     * @return guid
     **/
    @ApiModelProperty(
            example = "eddc2f0c-4401-49d1-b632-dee2ec33dcc0", required = true,
            value = "Unique guid of the associated project compute (i.e. GUID of Spark or Machine Learning service instance).")
    @JsonProperty(JSON_PROPERTY_GUID)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) { this.guid = guid; }

    public TransactionalProjectComputeObjectCloud label(String label) {
        this.label = label;
        return this;
    }

    /**
     * Service label when compute type is &#39;watson&#39;
     * @return label
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "watson_vision_combined", value = "Service label when compute type is 'watson'")
    @JsonProperty(JSON_PROPERTY_LABEL)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) { this.label = label; }

    public TransactionalProjectComputeObjectCloud name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Display name of the compute instance associated with the project.
     * @return name
     **/
    @ApiModelProperty(
            example = "Apache Spark", required = true,
            value = "Display name of the compute instance associated with the project.")
    @JsonProperty(JSON_PROPERTY_NAME)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public TransactionalProjectComputeObjectCloud type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * The type of the associated project compute.
     * @return type
     **/
    @ApiModelProperty(required = true, value = "The type of the associated project compute.")
    @JsonProperty(JSON_PROPERTY_TYPE)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) { this.type = type; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionalProjectComputeObjectCloud
                transactionalProjectComputeObjectCloud =
                (TransactionalProjectComputeObjectCloud)o;
        return Objects.equals(this.crn,
                transactionalProjectComputeObjectCloud.crn) &&
                Objects.equals(this.guid,
                        transactionalProjectComputeObjectCloud.guid) &&
                Objects.equals(this.label,
                        transactionalProjectComputeObjectCloud.label) &&
                Objects.equals(this.name,
                        transactionalProjectComputeObjectCloud.name) &&
                Objects.equals(this.type, transactionalProjectComputeObjectCloud.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crn, guid, label, name, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionalProjectComputeObjectCloud {\n");
        sb.append("    crn: ").append(toIndentedString(crn)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    label: ").append(toIndentedString(label)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
