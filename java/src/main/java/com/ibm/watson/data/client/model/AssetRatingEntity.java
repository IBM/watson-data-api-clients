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
 * AssetRatingEntity
 */
public class AssetRatingEntity {

    private Integer rating;
    private String review;

    public AssetRatingEntity rating(Integer rating) {
        this.rating = rating;
        return this;
    }

    /**
     * user&#39;s rating of an asset
     * @return rating
     **/
    @JsonProperty("rating")
    @JsonInclude(value = JsonInclude.Include.ALWAYS)
    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public AssetRatingEntity review(String review) {
        this.review = review;
        return this;
    }

    /**
     * user&#39;s review of an asset
     * @return review
     **/
    @javax.annotation.Nullable
    @JsonProperty("review")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public String getReview() { return review; }
    public void setReview(String review) { this.review = review; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        AssetRatingEntity assetRatingEntity = (AssetRatingEntity)o;
        return Objects.equals(this.rating, assetRatingEntity.rating) &&
                Objects.equals(this.review, assetRatingEntity.review);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rating, review);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AssetRatingEntity {\n");
        sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
        sb.append("    review: ").append(toIndentedString(review)).append("\n");
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
