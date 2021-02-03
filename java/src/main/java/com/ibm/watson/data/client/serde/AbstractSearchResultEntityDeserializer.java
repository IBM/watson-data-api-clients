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
package com.ibm.watson.data.client.serde;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ibm.watson.data.client.model.*;

import java.io.IOException;
import java.util.Iterator;

/**
 * Custom deserialization for (Abstract)SearchResultEntity, to handle deserialization
 * across various subtypes based on the properties that actually appear in the JSON being deserialized.
 */
public class AbstractSearchResultEntityDeserializer extends StdDeserializer<AbstractSearchResultEntity> {

    protected AbstractSearchResultEntityDeserializer() {
        super(AbstractSearchResultEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractSearchResultEntity deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String name = p.getCurrentName();
        TreeNode node = p.readValueAsTree();
        Iterator<String> fieldNames = node.fieldNames();
        AbstractSearchResultEntity result = null;
        if (name != null) {
            switch (name) {
                case "assets":
                    result = p.getCodec().treeToValue(node, AssetSearchResultEntity.class);
                    break;
                case "artifacts":
                    result = p.getCodec().treeToValue(node, ArtifactSearchResultEntity.class);
                    break;
                default:
                    System.err.println("Unhandled contextual name '" + name + "' -- returning null!");
                    break;
            }
        } else {
            System.err.println("No contextual name -- returning null!");
        }
        return result;
    }

}
