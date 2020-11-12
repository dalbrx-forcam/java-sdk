////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shift.request;

import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an id and values that determine what shall be embedded.
 */
public class GetWorkplaceShiftRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A shift id. */
    private String mId;

    /** Determines what shall be embedded. */
    private WorkplaceShiftEmbed mEmbed = new WorkplaceShiftEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetWorkplaceShiftRequest} object with a shift ID.
     *
     * @param shiftId The shift ID.
     */
    public GetWorkplaceShiftRequest(String shiftId) {
        mId = shiftId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public WorkplaceShiftEmbed embed() {
        return mEmbed;
    }

    public void embed(WorkplaceShiftEmbed embed) {
        mEmbed = embed;
    }

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this).append("id", mId).append("embed", mEmbed).toString();
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