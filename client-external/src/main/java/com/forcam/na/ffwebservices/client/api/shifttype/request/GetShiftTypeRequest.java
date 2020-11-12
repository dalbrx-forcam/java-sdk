////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shifttype.request;

import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an id and values that determine what shall be embedded.
 */
public class GetShiftTypeRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A shift type id. */
    private String mId;

    /** Determines what shall be embedded. */
    private ShiftTypeEmbed mEmbed = new ShiftTypeEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetShiftTypeRequest} object with a shift type ID.
     *
     * @param shiftTypeId The shift type ID.
     */
    public GetShiftTypeRequest(String shiftTypeId) {
        mId = shiftTypeId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public ShiftTypeEmbed embed() {
        return mEmbed;
    }

    public void embed(ShiftTypeEmbed embed) {
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