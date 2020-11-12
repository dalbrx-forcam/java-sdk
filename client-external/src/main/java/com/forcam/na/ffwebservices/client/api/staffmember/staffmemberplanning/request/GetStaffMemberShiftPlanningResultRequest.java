////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 21.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request;

/**
 * Request for getting staff member shift planning result.
 */
public class GetStaffMemberShiftPlanningResultRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member ID. */
    private String mStaffMemberId;

    /** The staff member shift ID. */
    private String mStaffMemberShiftId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberId      The staff member ID.
     * @param staffMemberShiftId The staff member shift ID.
     */
    public GetStaffMemberShiftPlanningResultRequest(String staffMemberId, String staffMemberShiftId) {
        mStaffMemberId = staffMemberId;
        mStaffMemberShiftId = staffMemberShiftId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

    public void setStaffMemberId(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    public String getStaffMemberShiftId() {
        return mStaffMemberShiftId;
    }

    public void setStaffMemberShiftId(String staffMemberShiftId) {
        mStaffMemberShiftId = staffMemberShiftId;
    }
}