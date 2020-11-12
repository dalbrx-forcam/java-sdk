////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 01.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.AbstractCollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.workplace.quantity.WorkplaceQuantitySummaryCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.quantity.WorkplaceQuantitySummaryDetailPropertiesWSModel;

import java.util.List;

/**
 * The collection response for workplace quantity summary.
 */
public class WorkplaceQuantitySummaryCollectionResponse extends AbstractCollectionResponse<WorkplaceQuantitySummaryDetailPropertiesWSModel> {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A collection of workplace quantity summary property models. */
    private WorkplaceQuantitySummaryCollectionPropertiesWSModel mProperties = new WorkplaceQuantitySummaryCollectionPropertiesWSModel();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param request The request.
     */
    public WorkplaceQuantitySummaryCollectionResponse(PaginationRequest request) {
        super(request);
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceQuantitySummaryCollectionPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(WorkplaceQuantitySummaryCollectionPropertiesWSModel properties) {
        mProperties = properties;
    }

    @Override
    public List<WorkplaceQuantitySummaryDetailPropertiesWSModel> getElements() {
        return mProperties.getElements();
    }
}