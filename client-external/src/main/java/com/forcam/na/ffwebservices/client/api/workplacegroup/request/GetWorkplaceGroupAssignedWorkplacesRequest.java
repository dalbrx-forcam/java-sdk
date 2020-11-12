////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetWorkplaceGroupAssignedWorkplacesRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace group ID. */
    private String mWorkplaceGroupId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetWorkplaceGroupAssignedWorkplacesRequest} object with a workplace group ID.
     *
     * @param workplaceGroupId The workplace group ID.
     */
    public GetWorkplaceGroupAssignedWorkplacesRequest(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this).appendSuper(super.toString())
                                                                          .append("workplaceGroupId", mWorkplaceGroupId)
                                                                          .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getWorkplaceGroupId() {
        return mWorkplaceGroupId;
    }

    public void setWorkplaceGroupId(String workplaceGroupId) {
        mWorkplaceGroupId = workplaceGroupId;
    }
}