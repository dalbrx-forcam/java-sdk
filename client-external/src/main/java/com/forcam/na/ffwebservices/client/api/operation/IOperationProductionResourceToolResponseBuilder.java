////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationProductionResourcesAndToolsRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolResponse;

/**
 * Contains methods for building responses for production resources and tools of operations.
 */
public interface IOperationProductionResourceToolResponseBuilder {

    /**
     * Transforms a collection model into a production resource tool collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A production resource tool collection response.
     */
    CollectionResponse<ProductionResourceToolResponse> getOperationProductionResourceToolCollectionResponse(
            GetOperationProductionResourcesAndToolsRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL Model into a production resource tool response.
     *
     * @param serverModel The model received by the server.
     * @return A production resource tool response.
     */
    ProductionResourceToolResponse getOperationProductionResourceToolResponse(HALWSModel serverModel);
}