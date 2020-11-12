////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains a tool ID and a tool state ID.
 */
public class SetToolStateRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** A tool state ID. */
    private String mToolStateId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link SetToolStateRequest} object with a tool ID and a tool state ID.
     *
     * @param toolId      The tool ID.
     * @param toolStateId The tool state ID.
     */
    public SetToolStateRequest(String toolId, String toolStateId) {
        mToolId = toolId;
        mToolStateId = toolStateId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
            .append("toolStateId", mToolStateId)
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

    public String getToolStateId() {
        return mToolStateId;
    }

    public void setToolStateId(String toolStateId) {
        mToolStateId = toolStateId;
    }
}