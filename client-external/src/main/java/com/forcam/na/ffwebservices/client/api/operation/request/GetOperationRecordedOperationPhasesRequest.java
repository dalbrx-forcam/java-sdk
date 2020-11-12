////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 18.07.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * Request parameter for getting the recorded operation phases of an operation.
 */
public class GetOperationRecordedOperationPhasesRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation ID. */
    private String mOperationId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with operation ID.
     *
     * @param operationId The operation ID.
     */
    public GetOperationRecordedOperationPhasesRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation ID.
     *
     * @return The operation ID.
     */
    public String getOperationId() {
        return mOperationId;
    }

    /**
     * Sets the operation ID.
     *
     * @param operationId The operation ID.
     */
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }

    /**
     * Provides the start date of time period.
     *
     * @return The start date.
     */
    public Date getStartDate() {
        return mStartDate;
    }

    /**
     * Sets the start date of time period.
     *
     * @param startDate The start date.
     */
    public void setStartDate(Date startDate) {
        mStartDate = startDate;
    }

    /**
     * Provides the end date of time period.
     *
     * @return The end date.
     */
    public Date getEndDate() {
        return mEndDate;
    }

    /**
     * Sets the end date of time period.
     *
     * @param endDate The end date.
     */
    public void setEndDate(Date endDate) {
        mEndDate = endDate;
    }
}