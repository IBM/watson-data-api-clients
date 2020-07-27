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
 * AssetRatingCount
 */
public class AssetRatingCount {

    private Integer rating;
    private Long count;

    public AssetRatingCount rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    /**
     * rating of an asset
     * @return rating
     **/
    @javax.annotation.Nullable
    @JsonProperty("rating")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public AssetRatingCount count(Long count) {
        this.count = count;
        return this;
    }

    /**
     * number of ratings with rating value
     * @return count
     **/
    @javax.annotation.Nullable
    @JsonProperty("count")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public Long getCount() { return count; }
    public void setCount(Long count) { this.count = count; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetRatingCount assetRatingCount = (AssetRatingCount)o;
        return Objects.equals(this.rating, assetRatingCount.rating) &&
                Objects.equals(this.count, assetRatingCount.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, count);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetRatingCount {\n");
        sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
        sb.append("    count: ").append(toIndentedString(count)).append("\n");
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
