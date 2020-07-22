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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Asset Type URL Model
 */
@ApiModel(description = "Asset Type URL Model")
@JsonPropertyOrder({
        ExternalAssetPreview.JSON_PROPERTY_BASE_CLIENT_URL,
        ExternalAssetPreview.JSON_PROPERTY_URL_PARAMETERS_FROM_ASSET_ATTRIBUTES,
        ExternalAssetPreview.JSON_PROPERTY_URL_PATH_FROM_ASSET_ATTRIBUTES,
        ExternalAssetPreview.JSON_PROPERTY_URL_PARAMETERS_FIXED
})
public class ExternalAssetPreview {

    public static final String JSON_PROPERTY_BASE_CLIENT_URL = "base_client_url";
    private String baseClientUrl;

    public static final String JSON_PROPERTY_URL_PARAMETERS_FROM_ASSET_ATTRIBUTES = "url_parameters_from_asset_attributes";
    private List<String> urlParametersFromAssetAttributes = null;

    public static final String JSON_PROPERTY_URL_PATH_FROM_ASSET_ATTRIBUTES = "url_path_from_asset_attributes";
    private String urlPathFromAssetAttributes;

    public static final String JSON_PROPERTY_URL_PARAMETERS_FIXED = "url_parameters_fixed";
    private String urlParametersFixed;

    public ExternalAssetPreview baseClientUrl(String baseClientUrl) {
        this.baseClientUrl = baseClientUrl;
        return this;
    }

    /**
     * Base client URL
     * @return baseClientUrl
     **/
    @ApiModelProperty(example = "https://ibm.com", required = true,
            value = "Base client URL")
    @JsonProperty(JSON_PROPERTY_BASE_CLIENT_URL)
    @JsonInclude(value = JsonInclude.Include.ALWAYS)

    public String getBaseClientUrl() {
        return baseClientUrl;
    }

    public void setBaseClientUrl(String baseClientUrl) {
        this.baseClientUrl = baseClientUrl;
    }

    public ExternalAssetPreview urlParametersFromAssetAttributes(List<String> urlParametersFromAssetAttributes) {
        this.urlParametersFromAssetAttributes = urlParametersFromAssetAttributes;
        return this;
    }

    public ExternalAssetPreview addUrlParametersFromAssetAttributesItem(String urlParametersFromAssetAttributesItem) {
        if (this.urlParametersFromAssetAttributes == null) {
            this.urlParametersFromAssetAttributes = new ArrayList<>();
        }
        this.urlParametersFromAssetAttributes.add(
                urlParametersFromAssetAttributesItem);
        return this;
    }

    /**
     * URL parameters
     * @return urlParametersFromAssetAttributes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(value = "URL parameters")
    @JsonProperty(JSON_PROPERTY_URL_PARAMETERS_FROM_ASSET_ATTRIBUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public List<String> getUrlParametersFromAssetAttributes() {
        return urlParametersFromAssetAttributes;
    }

    public void setUrlParametersFromAssetAttributes(List<String> urlParametersFromAssetAttributes) {
        this.urlParametersFromAssetAttributes = urlParametersFromAssetAttributes;
    }

    public ExternalAssetPreview urlPathFromAssetAttributes(String urlPathFromAssetAttributes) {
        this.urlPathFromAssetAttributes = urlPathFromAssetAttributes;
        return this;
    }

    /**
     * URL path
     * @return urlPathFromAssetAttributes
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "id", value = "URL path")
    @JsonProperty(JSON_PROPERTY_URL_PATH_FROM_ASSET_ATTRIBUTES)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrlPathFromAssetAttributes() {
        return urlPathFromAssetAttributes;
    }

    public void setUrlPathFromAssetAttributes(String urlPathFromAssetAttributes) {
        this.urlPathFromAssetAttributes = urlPathFromAssetAttributes;
    }

    public ExternalAssetPreview urlParametersFixed(String urlParametersFixed) {
        this.urlParametersFixed = urlParametersFixed;
        return this;
    }

    /**
     * URL parameters fixed
     * @return urlParametersFixed
     **/
    @javax.annotation.Nullable
    @ApiModelProperty(example = "allow_login_screen=true",
            value = "URL parameters fixed")
    @JsonProperty(JSON_PROPERTY_URL_PARAMETERS_FIXED)
    @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

    public String getUrlParametersFixed() {
        return urlParametersFixed;
    }

    public void setUrlParametersFixed(String urlParametersFixed) {
        this.urlParametersFixed = urlParametersFixed;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ExternalAssetPreview externalAssetPreview = (ExternalAssetPreview)o;
        return Objects.equals(this.baseClientUrl,
                externalAssetPreview.baseClientUrl) &&
                Objects.equals(this.urlParametersFromAssetAttributes,
                        externalAssetPreview.urlParametersFromAssetAttributes) &&
                Objects.equals(this.urlPathFromAssetAttributes,
                        externalAssetPreview.urlPathFromAssetAttributes) &&
                Objects.equals(this.urlParametersFixed,
                        externalAssetPreview.urlParametersFixed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseClientUrl, urlParametersFromAssetAttributes,
                urlPathFromAssetAttributes, urlParametersFixed);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExternalAssetPreview {\n");
        sb.append("    baseClientUrl: ")
                .append(toIndentedString(baseClientUrl))
                .append("\n");
        sb.append("    urlParametersFromAssetAttributes: ")
                .append(toIndentedString(urlParametersFromAssetAttributes))
                .append("\n");
        sb.append("    urlPathFromAssetAttributes: ")
                .append(toIndentedString(urlPathFromAssetAttributes))
                .append("\n");
        sb.append("    urlParametersFixed: ")
                .append(toIndentedString(urlParametersFixed))
                .append("\n");
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
