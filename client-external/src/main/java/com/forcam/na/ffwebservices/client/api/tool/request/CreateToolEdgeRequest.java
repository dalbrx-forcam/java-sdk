////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 22.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.model.tool.CreateToolEdgePropertiesWSModel;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The request object for creating a new cut edge for a tool.
 */
public class CreateToolEdgeRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** The cut edge that shall be created. */
    private CreateToolEdgePropertiesWSModel mToolEdge;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link CreateToolEdgeRequest} object with a tool ID and a tool cut edge.
     *
     * @param toolId   The tool ID.
     * @param toolEdge The tool cut edge.
     */
    public CreateToolEdgeRequest(String toolId, CreateToolEdgePropertiesWSModel toolEdge) {
        mToolId = toolId;
        mToolEdge = toolEdge;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
            .append("toolEdge", mToolEdge)
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

    public CreateToolEdgePropertiesWSModel getToolEdge() {
        return mToolEdge;
    }

    public void setToolEdge(CreateToolEdgePropertiesWSModel toolEdge) {
        mToolEdge = toolEdge;
    }
}