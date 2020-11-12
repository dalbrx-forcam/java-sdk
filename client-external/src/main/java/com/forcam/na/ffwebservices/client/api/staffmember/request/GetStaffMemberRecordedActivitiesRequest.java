////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 30.08.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;

import java.util.Date;

/**
 * Request parameter for recorded activities of a staff member.
 */
public class GetStaffMemberRecordedActivitiesRequest extends CollectionTimestampRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member ID. */
    private String mStaffMemberId;

    /** The start date. */
    private Date mStartDate;

    /** The end date. */
    private Date mEndDate;

    /** The workplace number. */
    private String mWorkplaceNumber;

    /** The workplace ID. */
    private String mWorkplaceId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberId The staff member ID.
     */
    public GetStaffMemberRecordedActivitiesRequest(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the staff member ID.
     *
     * @return The staff member ID.
     */
    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    /**
     * Sets the staff member ID.
     *
     * @param staffMemberId The staff member ID.
     */
    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
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

    /**
     * Provides the workplace number.
     *
     * @return The workplace number.
     */
    public String getWorkplaceNumber() {
        return mWorkplaceNumber;
    }

    /**
     * Sets the workplace number.
     *
     * @param workplaceNumber The workplace number.
     */
    public void setWorkplaceNumber(String workplaceNumber) {
        mWorkplaceNumber = workplaceNumber;
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
}