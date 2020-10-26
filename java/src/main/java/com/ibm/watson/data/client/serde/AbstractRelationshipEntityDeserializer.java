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
import com.ibm.watson.data.client.model.AbstractRelationshipEntity;
import com.ibm.watson.data.client.model.ParentRelationshipEntity;
import com.ibm.watson.data.client.model.RelationshipEntity;

import java.io.IOException;

/**
 * Custom deserialization for (Abstract)RelationshipEntity, to handle deserialization
 * across both RelationshipEntity and ParentRelationshipEntity based on the properties
 * that actually appear in the JSON being deserialized.
 */
public class AbstractRelationshipEntityDeserializer extends StdDeserializer<AbstractRelationshipEntity> {

    protected AbstractRelationshipEntityDeserializer() {
        super(AbstractRelationshipEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractRelationshipEntity deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        TreeNode node = p.readValueAsTree();
        if (node.get("parent_id") != null || node.get("child_id") != null) {
            // parent_id or child_id should only appear in the ParentRelationshipEntity
            return p.getCodec().treeToValue(node, ParentRelationshipEntity.class);
        } else {
            // target_id, target_name, target_global_id should only appear in the RelationshipEntity
            // but in any case we should have a fall-back to a definitive class (as defaulting back to
            // the AbstractRelationshipEntity will simply cause an infinite deserialization loop)
            return p.getCodec().treeToValue(node, RelationshipEntity.class);
        }
    }

}
