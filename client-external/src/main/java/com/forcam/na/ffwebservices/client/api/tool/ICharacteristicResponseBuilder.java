////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.tool.response.CharacteristicCollectionResponse;

/**
 * Contains methods for building responses for characteristics.
 */
public interface ICharacteristicResponseBuilder {

    /**
     * Transforms a collection model to a characteristic collection response.
     *
     * @param request The request.
     * @param model   A collection model.
     * @return A characteristic collection response.
     */
    CharacteristicCollectionResponse getCharacteristicCollectionResponse(PaginationRequest request, HALWSModel model);
}