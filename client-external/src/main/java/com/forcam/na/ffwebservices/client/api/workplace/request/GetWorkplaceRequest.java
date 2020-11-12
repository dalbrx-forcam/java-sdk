////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.model.workplace.WorkplaceEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an id and values that determine what shall be embedded.
 */
public class GetWorkplaceRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A workplace id. */
    private String mId;

    /** Determines what shall be embedded. */
    private WorkplaceEmbed mEmbed = new WorkplaceEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetWorkplaceRequest} object with a workplace ID.
     *
     * @param workplaceId The workplace ID.
     */
    public GetWorkplaceRequest(String workplaceId) {
        mId = workplaceId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public WorkplaceEmbed embed() {
        return mEmbed;
    }

    public void embed(WorkplaceEmbed embed) {
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