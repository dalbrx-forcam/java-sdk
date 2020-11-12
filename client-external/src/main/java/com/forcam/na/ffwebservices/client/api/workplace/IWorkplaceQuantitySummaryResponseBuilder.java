////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 01.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceQuantitySummaryCollectionResponse;
import com.forcam.na.ffwebservices.model.workplace.quantity.WorkplaceQuantitySummaryCollectionWSModel;

/**
 * Contains methods for building responses for the quantity summary of workplaces.
 */
public interface IWorkplaceQuantitySummaryResponseBuilder {

    /**
     * Transforms a collection model to a workplace quantity summary collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A workplace quantity summary collection response.
     */
    WorkplaceQuantitySummaryCollectionResponse getWorkplaceQuantitySummaryCollectionResponse(GetWorkplaceQuantitySummaryRequest request,
                                                                                             WorkplaceQuantitySummaryCollectionWSModel collectionModel);
}