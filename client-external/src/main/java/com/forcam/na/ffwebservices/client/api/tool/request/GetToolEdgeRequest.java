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
 * Contains a tool ID and a cut edge ID.
 */
public class GetToolEdgeRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** A cut edge ID. */
    private String mId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetToolEdgeRequest} object with a tool ID and a cut edge ID.
     *
     * @param toolId The tool ID.
     * @param edgeId The cut edge ID.
     */
    public GetToolEdgeRequest(String toolId, String edgeId) {
        mToolId = toolId;
        mId = edgeId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
            .append("id", mId)
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

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }
}