////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 15.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.pagination.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;

import java.util.Date;

/**
 * Collection request with time filter.
 */
public class CollectionTimeFilterRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The start date of requested period. */
    private Date mStartDate;

    /** The end date of requested period. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the start date.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate The start date.
     */
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Provides the end date.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate The end date.
     */
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }
}