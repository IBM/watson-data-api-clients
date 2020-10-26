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
 * CustomAttributeDefinitionEntity
 */
public class CustomAttributeDefinitionEntity extends CustomAttributeDefinitionEntityHeader {

    private List<CustomAttributeDefElement> elementsList = null;

    public CustomAttributeDefinitionEntity elementsList(List<CustomAttributeDefElement> elementsList) {
        this.elementsList = elementsList;
        return this;
    }

    public CustomAttributeDefinitionEntity addElementsListItem(CustomAttributeDefElement elementsListItem) {
        if (this.elementsList == null) {
            this.elementsList = new ArrayList<>();
        }
        this.elementsList.add(elementsListItem);
        return this;
    }

    /**
     * List of predefined values
     * @return elementsList
     **/
    @javax.annotation.Nullable
    @JsonProperty("elements_list")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CustomAttributeDefElement> getElementsList() { return elementsList; }
    public void setElementsList(List<CustomAttributeDefElement> elementsList) { this.elementsList = elementsList; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        CustomAttributeDefinitionEntity customAttributeDefinitionEntity = (CustomAttributeDefinitionEntity)o;
        return super.equals(o) &&
                Objects.equals(this.elementsList, customAttributeDefinitionEntity.elementsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), elementsList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomAttributeDefinitionEntity {\n");
        super.toString(sb);
        sb.append("    elementsList: ").append(toIndentedString(elementsList)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
