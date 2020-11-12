////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 22.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.model.tool.ToolEdgePropertiesWSModel;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The request object for updating the cut edge of a tool.
 */
public class UpdateToolEdgeRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** A tool cut edge ID. */
    private String mId;

    /** The updated cut edge. */
    private ToolEdgePropertiesWSModel mToolEdge;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link UpdateToolEdgeRequest} object with a tool ID, a cut edge ID and a tool cut edge.
     *
     * @param toolId   The tool ID.
     * @param edgeId   The cut edge ID.
     * @param toolEdge The tool cut edge.
     */
    public UpdateToolEdgeRequest(String toolId, String edgeId, ToolEdgePropertiesWSModel toolEdge) {
        mToolId = toolId;
        mId = edgeId;
        mToolEdge = toolEdge;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
            .append("id", mId)
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

    public String getId() {
        return mId;
    }

    public void setId(String edgeId) {
        mId = edgeId;
    }

    public ToolEdgePropertiesWSModel getToolEdge() {
        return mToolEdge;
    }

    public void setToolEdge(ToolEdgePropertiesWSModel toolEdge) {
        mToolEdge = toolEdge;
    }
}