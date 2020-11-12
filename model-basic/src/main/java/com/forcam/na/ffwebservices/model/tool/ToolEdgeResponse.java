////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for the cut edge of a tool.
 */
public class ToolEdgeResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties for the cut edge of a tool. */
    private ToolEdgePropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ToolEdgePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(ToolEdgePropertiesWSModel properties) {
        mProperties = properties;
    }
}