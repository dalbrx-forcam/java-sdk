////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition.request;

import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateEmbed;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an ID and values that determine what shall be embedded.
 */
public class GetOperatingStateRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** An operating state ID. */
    private String mId;

    /** Determines what shall be embedded. */
    private OperatingStateEmbed mEmbed = new OperatingStateEmbed();

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetOperatingStateRequest} object with an operating state ID.
     *
     * @param operatingStateId The operating state ID.
     */
    public GetOperatingStateRequest(String operatingStateId) {
        mId = operatingStateId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    public OperatingStateEmbed embed() {
        return mEmbed;
    }

    public void embed(OperatingStateEmbed embed) {
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