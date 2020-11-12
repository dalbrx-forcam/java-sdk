////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationQuantitySummaryCollectionResponse;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryCollectionWSModel;

/**
 * Contains methods for building responses for the quantity summary of operations.
 */
public interface IOperationQuantitySummaryResponseBuilder {

    /**
     * Transforms a collection model to an operation quantity summary collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return An operation quantity summary collection response.
     */
    OperationQuantitySummaryCollectionResponse getOperationQuantitySummaryCollectionResponse(GetOperationQuantitySummaryRequest request,
                                                                                             OperationQuantitySummaryCollectionWSModel collectionModel);
}