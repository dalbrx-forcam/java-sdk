////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.shifttype.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains values that determine what shall be embedded.
 */
public class GetShiftTypesRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Determines what shall be embedded. */
    private ShiftTypeEmbed mEmbed = new ShiftTypeEmbed();

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
            .appendSuper(super.toString())
            .append("embed", mEmbed)
            .toString();
    }
}