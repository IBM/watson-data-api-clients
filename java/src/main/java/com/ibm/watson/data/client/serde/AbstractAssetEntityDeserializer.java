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
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.ibm.watson.data.client.model.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Custom deserialization for (Abstract)AssetEntity, to handle deserialization
 * across various subtypes based on the properties that actually appear in the JSON being deserialized.
 */
public class AbstractAssetEntityDeserializer extends StdDeserializer<AbstractAssetEntity> {

    protected AbstractAssetEntityDeserializer() {
        super(AbstractAssetEntity.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AbstractAssetEntity deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String name = p.getCurrentName();
        TreeNode node = p.readValueAsTree();
        Iterator<String> fieldNames = node.fieldNames();
        AbstractAssetEntity result = null;
        if (name != null) {
            switch (name) {
                case "data_asset":
                    result = p.getCodec().treeToValue(node, DataAssetEntity.class);
                    break;
                case "column_info":
                    ColumnInfoEntity cie = new ColumnInfoEntity();
                    Map<String, ColumnInfoDetails> cieMap = new HashMap<>();
                    while (fieldNames.hasNext()) {
                        String fieldName = fieldNames.next();
                        TreeNode value = node.get(fieldName);
                        ColumnInfoDetails details = p.getCodec().treeToValue(value, ColumnInfoDetails.class);
                        cieMap.put(fieldName, details);
                    }
                    cie.setFields(cieMap);
                    result = cie;
                    break;
                case "data_profile":
                    DataProfileEntity dpe = new DataProfileEntity();
                    Map<String, DataProfile> dpeProfiles = new HashMap<>();
                    while (fieldNames.hasNext()) {
                        String fieldName = fieldNames.next();
                        TreeNode value = node.get(fieldName);
                        if (fieldName.equals("attribute_classes")) {
                            dpe.setAttributeClasses(p.getCodec().readValue(value.traverse(), new TypeReference<List<String>>() {}));
                        } else if (fieldName.equals("attribute_classification_manual")) {
                            dpe.setAttributeClassificationManual(p.getCodec().readValue(value.traverse(), new TypeReference<List<AttributeClassificationOverride>>() {}));
                        } else if (fieldName.equals("data_classification_manual")) {
                            dpe.setDataClassificationManual(p.getCodec().readValue(value.traverse(), new TypeReference<List<DataClassificationOverride>>() {}));
                        } else {
                            DataProfile details = p.getCodec().treeToValue(value, DataProfile.class);
                            dpeProfiles.put(fieldName, details);
                        }
                    }
                    dpe.setProfiles(dpeProfiles);
                    result = dpe;
                    break;
                case "asset_terms":
                    result = p.getCodec().treeToValue(node, AssetTermsEntity.class);
                    break;
                default:
                    CustomFieldAssetEntity cfae = new CustomFieldAssetEntity();
                    Map<String, Object> cfaeMap = new HashMap<>();
                    while (fieldNames.hasNext()) {
                        String fieldName = fieldNames.next();
                        TreeNode value = node.get(fieldName);
                        Object details = p.getCodec().treeToValue(value, Object.class);
                        cfaeMap.put(fieldName, details);
                    }
                    cfae.setFields(cfaeMap);
                    result = cfae;
                    break;
            }
        } else {
            System.err.println("No contextual name -- returning null!");
        }
        return result;
    }

}
