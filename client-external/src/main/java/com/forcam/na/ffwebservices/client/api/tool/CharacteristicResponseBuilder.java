////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionResponse;
import com.forcam.na.ffwebservices.model.tool.ToolCharacteristicCollectionPropertiesWSModel;

import javax.inject.Inject;

/**
 * Builds responses for characteristics.
 */
public class CharacteristicResponseBuilder extends AbstractResponseBuilder implements ICharacteristicResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public CharacteristicResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CharacteristicCollectionResponse getCharacteristicCollectionResponse(PaginationRequest request, HALWSModel model) {
        final CharacteristicCollectionResponse collectionResponse = new CharacteristicCollectionResponse(request);
        collectionResponse.setProperties(mMapper.convertValue(model.getProperties(), ToolCharacteristicCollectionPropertiesWSModel.class));
        collectionResponse.setPagination(model.getPagination());
        collectionResponse.setPaginationLinks(model.getLinkModels());

        return collectionResponse;
    }
}