////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 01.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceQuantitySummaryCollectionResponse;
import com.forcam.na.ffwebservices.model.workplace.quantity.WorkplaceQuantitySummaryCollectionWSModel;

import javax.inject.Inject;

/**
 * Builds responses for the quantity summary of workplaces.
 */
public class WorkplaceQuantitySummaryResponseBuilder extends AbstractResponseBuilder implements IWorkplaceQuantitySummaryResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public WorkplaceQuantitySummaryResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public WorkplaceQuantitySummaryCollectionResponse getWorkplaceQuantitySummaryCollectionResponse(GetWorkplaceQuantitySummaryRequest request,
                                                                                                    WorkplaceQuantitySummaryCollectionWSModel collectionModel) {
        final WorkplaceQuantitySummaryCollectionResponse collectionResponse = new WorkplaceQuantitySummaryCollectionResponse(request);
        super.initializeCollectionResponse(collectionModel, collectionResponse);
        collectionResponse.setProperties(collectionModel.getProperties());

        return collectionResponse;
    }
}