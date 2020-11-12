////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.recordedoperatingstate;

import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.RecordedOperatingStateResponse;

/**
 * Contains methods for building responses for recorded operating states of operations.
 */
public interface IRecordedOperatingStateResponseBuilder {

    /**
     * Transforms a collection model into a recorded operating state collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A recorded operating state collection response.
     */
    RecordedOperatingStateCollectionResponse getRecordedOperatingStateCollectionResponse(PaginationRequest request, HALWSModel collectionModel);

    /**
     * Converts HAL Model into a recorded operating state response.
     *
     * @param serverModel The model received by the server.
     * @return A recorded operating state response.
     */
    RecordedOperatingStateResponse getRecordedOperatingStateResponse(HALWSModel serverModel);
}