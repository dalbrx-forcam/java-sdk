////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.staffmember.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetStaffMembersRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private StaffMemberEmbed mEmbed = new StaffMemberEmbed();

    /** The personnel number. */
    private String mPersonnelNumber;

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public StaffMemberEmbed embed() {
        return mEmbed;
    }

    public void embed(StaffMemberEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("personnelNumber", mPersonnelNumber)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getPersonnelNumber() {
        return mPersonnelNumber;
    }

    public void setPersonnelNumber(String personnelNumber) {
        mPersonnelNumber = personnelNumber;
    }
}