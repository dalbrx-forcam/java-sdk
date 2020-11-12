////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 15.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampFilterRequest;

/**
 * Request parameters for getting the scheduled working times of a staff member.
 */
public class GetStaffMemberScheduledWorkingTimesRequest extends CollectionTimestampFilterRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member ID. */
    private String mStaffMemberId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberId The staff member ID.
     */
    public GetStaffMemberScheduledWorkingTimesRequest(String staffMemberId) {
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
}