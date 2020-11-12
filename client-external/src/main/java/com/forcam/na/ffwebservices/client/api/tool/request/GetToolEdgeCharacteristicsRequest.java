////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 04.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains a tool ID and a cut edge ID.
 */
public class GetToolEdgeCharacteristicsRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** A cut edge ID. */
    private String mEdgeId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetToolEdgeCharacteristicsRequest} object with a tool ID and a cut edge ID.
     *
     * @param toolId The tool ID.
     * @param edgeId The cut edge ID.
     */
    public GetToolEdgeCharacteristicsRequest(String toolId, String edgeId) {
        mToolId = toolId;
        mEdgeId = edgeId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .appendSuper(super.toString())
            .append("toolId", mToolId)
            .append("edgeId", mEdgeId)
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

    public String getEdgeId() {
        return mEdgeId;
    }

    public void setEdgeId(String edgeId) {
        mEdgeId = edgeId;
    }
}