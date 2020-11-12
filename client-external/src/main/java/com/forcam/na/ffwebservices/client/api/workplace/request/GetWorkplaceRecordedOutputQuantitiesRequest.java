////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 29.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * Request parameter for getting the recorded output quantities of a workplace.
 */
public class GetWorkplaceRecordedOutputQuantitiesRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace ID. */
    private String mWorkplaceId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The workplace shift ID. */
    private String mShiftId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public GetWorkplaceRecordedOutputQuantitiesRequest(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the workplace shift ID.
     *
     * @return The shift ID.
     */
    public String getShiftId() {
        return mShiftId;
    }

    /**
     * Sets the workplace shift ID.
     *
     * @param shiftId The shift ID.
     */
    public void setShiftId(String shiftId) {
        mShiftId = shiftId;
    }

    /**
     * Provides the workplace ID.
     *
     * @return The workplace ID.
     */
    public String getWorkplaceId() {
        return mWorkplaceId;
    }

    /**
     * Sets the workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public void setWorkplaceId(String workplaceId) {
        mWorkplaceId = workplaceId;
    }

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