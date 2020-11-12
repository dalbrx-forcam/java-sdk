////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 01.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.workplace.quantity;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.collection.PaginationPropertiesWSModel;

/**
 * The response object for the quantity summary of a workplace.
 */
public class WorkplaceQuantitySummaryResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The detail properties for the quantity summary of a workplace. */
    private WorkplaceQuantitySummaryDetailPropertiesWSModel mProperties;

    /** The pagination. */
    private PaginationPropertiesWSModel mPagination;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public WorkplaceQuantitySummaryDetailPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(WorkplaceQuantitySummaryDetailPropertiesWSModel properties) {
        mProperties = properties;
    }

    public PaginationPropertiesWSModel getPagination() {
        return mPagination;
    }

    public void setPagination(PaginationPropertiesWSModel pagination) {
        mPagination = pagination;
    }
}