////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.literal;

import com.forcam.na.ffwebservices.client.api.literal.request.GetLiteralsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralResponse;

/**
 * Contains methods for building responses for literals.
 */
public interface ILiteralResponseBuilder {

    /**
     * Transforms a collection model to a literal collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A literal collection response.
     */
    CollectionResponse<LiteralResponse> getLiteralCollectionResponse(GetLiteralsRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a literal model.
     *
     * @param serverModel The server model.
     * @return A literal model.
     */
    LiteralResponse getLiteralResponse(HALWSModel serverModel);
}