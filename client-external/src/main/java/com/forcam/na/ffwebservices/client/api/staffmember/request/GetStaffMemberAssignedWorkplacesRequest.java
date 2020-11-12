////////////////////////////////////////////////////////////////////////////////
//
// Created by DAlbrecht on 15.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;

/**
 * Request parameter for assigned workplaces of a staff member.
 */
public class GetStaffMemberAssignedWorkplacesRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    private String mStaffMemberId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberId The staff member ID.
     */
    public GetStaffMemberAssignedWorkplacesRequest(String staffMemberId) {mStaffMemberId = staffMemberId;}

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getStaffMemberId() {
        return mStaffMemberId;
    }

}
