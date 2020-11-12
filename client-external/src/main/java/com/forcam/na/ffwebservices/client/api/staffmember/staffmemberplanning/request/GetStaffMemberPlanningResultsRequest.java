////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 21.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampFilterRequest;
import com.forcam.na.ffwebservices.model.staffmember.PlanningResultCollectionEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Request for getting all planning results of a staff member.
 */
public class GetStaffMemberPlanningResultsRequest extends CollectionTimestampFilterRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member ID. */
    private String mStaffMemberId;

    /** Determines what shall be embedded. */
    private PlanningResultCollectionEmbed mEmbed = new PlanningResultCollectionEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberId The staff member ID.
     */
    public GetStaffMemberPlanningResultsRequest(String staffMemberId) {
        mStaffMemberId = staffMemberId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public PlanningResultCollectionEmbed embed() {
        return mEmbed;
    }

    public void embed(PlanningResultCollectionEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("staffMemberId", mStaffMemberId)
            .append("embed", mEmbed)
            .toString();
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
}