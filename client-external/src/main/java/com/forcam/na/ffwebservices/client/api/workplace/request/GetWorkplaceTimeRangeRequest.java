////////////////////////////////////////////////////////////////////////////////
//
// Created by hiteshgarg on 3/9/2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * Request model to get workplace scheduled operating times.
 */
public class GetWorkplaceTimeRangeRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Workplace id. */
    private String mWorkplaceId;
    /** The starting date to be searched. */
    private Date startDate;
    /** The end date for the filtering. */
    private Date endDate;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public GetWorkplaceTimeRangeRequest(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Getter for {@link GetWorkplaceTimeRangeRequest#mWorkplaceId}.
     *
     * @return Workplace id.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Setter for {@link GetWorkplaceTimeRangeRequest#mWorkplaceId}.
     *
     * @param workplaceId Workplace id.
     * @return The request.
     */
    public GetWorkplaceTimeRangeRequest setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
        return this;
    }

    /**
     * Getter for {@link GetWorkplaceTimeRangeRequest#startDate}.
     *
     * @return The starting date to be searched.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Setter for {@link GetWorkplaceTimeRangeRequest#startDate}.
     *
     * @param startDate The starting date to be searched.
     * @return The request.
     */
    public GetWorkplaceTimeRangeRequest setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Getter for {@link GetWorkplaceTimeRangeRequest#endDate}.
     *
     * @return The end date for the filtering.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Setter for {@link GetWorkplaceTimeRangeRequest#endDate}.
     *
     * @param endDate The end date for the filtering.
     * @return The request.
     */
    public GetWorkplaceTimeRangeRequest setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
