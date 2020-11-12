////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateCollectionRequest;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateResponse;

/**
 * Contains methods for building responses for operating states.
 */
public interface IOperatingStateResponseBuilder {

    /**
     * Transforms a collection model to an operating state collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return An operating state collection response.
     */
    CollectionResponse<OperatingStateResponse> getOperatingStateCollectionResponse(GetOperatingStateCollectionRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL Model into an operating state model.
     *
     * @param serverModel The model received by the server.
     * @return An operating state model.
     */
    OperatingStateResponse getOperatingStateResponse(HALWSModel serverModel);
}