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
 * NewCustomAttributeDefinitionEntity
 */
public class NewCustomAttributeDefinitionEntity extends CustomAttributeDefinitionEntityHeader {

    private List<CustomAttributeDefElementEntity> elements = null;

    public NewCustomAttributeDefinitionEntity elements(List<CustomAttributeDefElementEntity> elements) {
        this.elements = elements;
        return this;
    }

    public NewCustomAttributeDefinitionEntity addElementsItem(CustomAttributeDefElementEntity elementsItem) {
        if (this.elements == null) {
            this.elements = new ArrayList<>();
        }
        this.elements.add(elementsItem);
        return this;
    }

    /**
     * List of predefined values. Supported only for the type ENUM.
     * @return elements
     **/
    @javax.annotation.Nullable
    @JsonProperty("elements")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    public List<CustomAttributeDefElementEntity> getElements() { return elements; }
    public void setElements(List<CustomAttributeDefElementEntity> elements) { this.elements = elements; }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }
        NewCustomAttributeDefinitionEntity newCustomAttributeDefinitionEntity = (NewCustomAttributeDefinitionEntity)o;
        return super.equals(o) &&
                Objects.equals(this.elements, newCustomAttributeDefinitionEntity.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), elements);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NewCustomAttributeDefinitionEntity {\n");
        super.toString(sb);
        sb.append("    elements: ").append(toIndentedString(elements)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
