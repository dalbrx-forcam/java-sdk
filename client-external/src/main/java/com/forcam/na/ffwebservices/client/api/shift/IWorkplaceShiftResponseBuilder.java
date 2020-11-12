////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shift;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftsRequest;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftResponse;

/**
 * Contains methods for building responses for shift types.
 */
public interface IWorkplaceShiftResponseBuilder {

    /**
     * Transforms a collection model to a shift collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A shift collection response.
     */
    CollectionResponse<WorkplaceShiftResponse> getWorkplaceShiftCollectionResponse(GetWorkplaceShiftsRequest request,
                                                                                   HALCollectionWSModel collectionModel);

    /**
     * Transforms a HAL model into a shift model.
     *
     * @param serverModel The model from the server.
     * @return A shift model.
     */
    WorkplaceShiftResponse getWorkplaceShiftResponse(HALWSModel serverModel);
}