////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 22.10.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.request;

import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request parameter for getting a staff member shift by ID.
 */
public class GetStaffMemberShiftRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A staff member shift ID. */
    private String mShiftId;

    /** Determines what shall be embedded. */
    private StaffMemberShiftEmbed mEmbed = new StaffMemberShiftEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetStaffMemberShiftRequest} object with a staff member shift ID.
     *
     * @param staffMemberShiftId The staff member shift ID.
     */
    public GetStaffMemberShiftRequest(String staffMemberShiftId) {
        mShiftId = staffMemberShiftId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public StaffMemberShiftEmbed embed() {
        return mEmbed;
    }

    public void embed(StaffMemberShiftEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("id", mShiftId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getShiftId() {
        return mShiftId;
    }

    public void setShiftId(String staffMemberShiftId) {
        mShiftId = staffMemberShiftId;
    }
}