////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolEdgeRequest;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains a tool ID.
 */
public class GetToolEdgesRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** A cut edge identifier. */
    private String mIdentifier;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetToolEdgeRequest} object with a tool ID.
     *
     * @param toolId The tool ID.
     */
    public GetToolEdgesRequest(String toolId) {
        mToolId = toolId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
            .append("identifier", mIdentifier)
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

    public String getIdentifier() {
        return mIdentifier;
    }

    public void setIdentifier(String identifier) {
        mIdentifier = identifier;
    }
}