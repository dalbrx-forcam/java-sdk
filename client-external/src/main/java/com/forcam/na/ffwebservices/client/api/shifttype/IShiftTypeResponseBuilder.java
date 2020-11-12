////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shifttype;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.shifttype.request.GetShiftTypesRequest;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeResponse;

/**
 * Contains methods for building responses for shift types.
 */
public interface IShiftTypeResponseBuilder {

    /**
     * Transforms a collection Model to a shift type collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A Shift type collection response.
     */
    CollectionResponse<ShiftTypeResponse> getShiftTypeCollectionResponse(GetShiftTypesRequest request, HALCollectionWSModel collectionModel);

    /**
     * Transforms a HAL Model into a Shift Type Model.
     *
     * @param serverModel The model from the server.
     * @return A shift type model.
     */
    ShiftTypeResponse getShiftTypeResponse(HALWSModel serverModel);
}