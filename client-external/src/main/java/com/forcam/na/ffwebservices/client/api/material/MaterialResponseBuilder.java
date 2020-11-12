////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.material;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.material.request.GetMaterialsRequest;
import com.forcam.na.ffwebservices.client.api.material.response.MaterialResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.material.MaterialPropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for literals.
 */
public class MaterialResponseBuilder extends AbstractResponseBuilder implements IMaterialResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public MaterialResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<MaterialResponse> getMaterialCollectionResponse(GetMaterialsRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<MaterialResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> literals = embedded.get("materials");

        final List<MaterialResponse> literalModels = literals
            .stream()
            .map(this::getMaterialResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(literalModels);
        return collectionResponse;
    }

    @Override
    public MaterialResponse getMaterialResponse(HALWSModel serverModel) {
        final MaterialResponse literalModel = new MaterialResponse();
        final MaterialPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), MaterialPropertiesWSModel.class);
        literalModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        literalModel.setSelf(selfLink);

        return literalModel;
    }
}