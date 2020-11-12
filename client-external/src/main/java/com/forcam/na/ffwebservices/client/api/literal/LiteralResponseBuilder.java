////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.literal;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for literals.
 */
public class LiteralResponseBuilder extends AbstractResponseBuilder implements ILiteralResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public LiteralResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<LiteralResponse> getLiteralCollectionResponse(GetLiteralsRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<LiteralResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> literals = embedded.get("literals");

        final List<LiteralResponse> literalModels = literals
            .stream()
            .map(this::getLiteralResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(literalModels);
        return collectionResponse;
    }

    @Override
    public LiteralResponse getLiteralResponse(HALWSModel serverModel) {
        final LiteralResponse literalModel = new LiteralResponse();
        final LiteralPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), LiteralPropertiesWSModel.class);
        literalModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        literalModel.setSelf(selfLink);

        return literalModel;
    }
}