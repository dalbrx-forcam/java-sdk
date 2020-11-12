////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationRecordedOperatingStateResponse;

/**
 * Contains methods for building responses for recorded operating states of operations.
 */
public interface IOperationRecordedOperatingStateResponseBuilder {

    /**
     * Transforms a collection model into a recorded operating state collection response.
     *
     * @param collectionModel A collection model.
     * @param request         The pagination request.
     * @return A recorded operating state collection response.
     */
    CollectionResponse<OperationRecordedOperatingStateResponse> getOperationRecordedOperatingStateCollectionResponse(PaginationRequest request,
                                                                                                                     HALCollectionWSModel collectionModel);

    /**
     * Converts HAL Model into a recorded operating state response.
     *
     * @param serverModel The model received by the server.
     * @return A recorded operating state response.
     */
    OperationRecordedOperatingStateResponse getOperationRecordedOperatingStateResponse(HALWSModel serverModel);
}