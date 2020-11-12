////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 05.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.model.tool.CreateToolLocationPropertiesWSModel;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The request object for putting a tool location.
 */
public class PutToolLocationRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** A tool ID. */
    private String mToolId;

    /** A location. */
    private CreateToolLocationPropertiesWSModel mLocation;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new {@link PutToolLocationRequest} object with a tool ID and a location.
     *
     * @param toolId   The tool ID.
     * @param location The location.
     */
    public PutToolLocationRequest(String toolId, CreateToolLocationPropertiesWSModel location) {
        mToolId = toolId;
        mLocation = location;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolId", mToolId)
            .append("location", mLocation)
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

    public CreateToolLocationPropertiesWSModel getLocation() {
        return mLocation;
    }

    public void setLocation(CreateToolLocationPropertiesWSModel location) {
        mLocation = location;
    }
}