////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 14.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationQuantitySummaryCollectionResponse;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryCollectionWSModel;

import javax.inject.Inject;

/**
 * Builds responses for the quantity summary of operations.
 */
public class OperationQuantitySummaryResponseBuilder extends AbstractResponseBuilder implements IOperationQuantitySummaryResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public OperationQuantitySummaryResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public OperationQuantitySummaryCollectionResponse getOperationQuantitySummaryCollectionResponse(GetOperationQuantitySummaryRequest request,
                                                                                                    OperationQuantitySummaryCollectionWSModel collectionModel) {
        final OperationQuantitySummaryCollectionResponse collectionResponse = new OperationQuantitySummaryCollectionResponse(request);
        super.initializeCollectionResponse(collectionModel, collectionResponse);
        collectionResponse.setProperties(collectionModel.getProperties());

        return collectionResponse;
    }
}