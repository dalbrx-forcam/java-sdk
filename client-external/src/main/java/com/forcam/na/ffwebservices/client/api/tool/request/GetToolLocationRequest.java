////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 05.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains a tool ID.
 */
public class GetToolLocationRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetToolLocationRequest} object with a tool ID.
     *
     * @param toolId The tool ID.
     */
    public GetToolLocationRequest(String toolId) {
        mToolId = toolId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public String getToolId() {
        return mToolId;
    }

    public void setToolId(String toolId) {
        mToolId = toolId;
    }
}