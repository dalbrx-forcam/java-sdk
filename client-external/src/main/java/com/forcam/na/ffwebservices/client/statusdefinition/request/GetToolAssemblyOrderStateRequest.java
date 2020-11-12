////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 09.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition.request;

import com.forcam.na.ffwebservices.model.definition.ToolAssemblyOrderState;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Contains an ID and values that determine what shall be embedded.
 */
public class GetToolAssemblyOrderStateRequest extends GetStatusDefinitionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool assembly order state ID. */
    private ToolAssemblyOrderState mId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link GetToolAssemblyOrderStateRequest} object with a tool assembly order state ID.
     *
     * @param toolAssemblyOrderStateId The tool assembly order state ID.
     */
    public GetToolAssemblyOrderStateRequest(ToolAssemblyOrderState toolAssemblyOrderStateId) {
        mId = toolAssemblyOrderStateId;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("id", mId)
            .appendSuper(super.toString())
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ToolAssemblyOrderState getId() {
        return mId;
    }

    public void setId(ToolAssemblyOrderState id) {
        mId = id;
    }
}