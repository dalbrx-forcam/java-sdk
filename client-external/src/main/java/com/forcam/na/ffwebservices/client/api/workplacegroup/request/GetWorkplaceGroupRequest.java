////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplacegroup.request;

import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *  Contains an ID and values that determine what shall be embedded.
 */
public class GetWorkplaceGroupRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A workplace group id. */
    private String mId;

    /** Determines what shall be embedded. */
    private WorkplaceGroupEmbed mEmbed = new WorkplaceGroupEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetWorkplaceGroupRequest} object with a workplace group ID.
     *
     * @param workplaceGroupId The workplace group ID.
     */
    public GetWorkplaceGroupRequest(String workplaceGroupId) {
        mId = workplaceGroupId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public WorkplaceGroupEmbed embed() {
        return mEmbed;
    }

    public void embed(WorkplaceGroupEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("id", mId)
            .append("embed", mEmbed)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}