////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains a tool ID.
 */
public class DeleteToolRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link DeleteToolRequest} object with a tool ID.
     *
     * @param toolId The tool ID.
     */
    public DeleteToolRequest(String toolId) {
        mId = toolId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("id", mId)
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