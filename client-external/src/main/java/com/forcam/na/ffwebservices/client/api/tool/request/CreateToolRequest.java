////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 21.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool.request;

import com.forcam.na.ffwebservices.model.tool.CreateToolPropertiesWSModel;
import com.forcam.na.common.webserviceaccess.util.ToStringUtility;;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The request object for creating a new tool.
 */
public class CreateToolRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The data of the tool that shall be created. */
    private CreateToolPropertiesWSModel mToolData = new CreateToolPropertiesWSModel();

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public String toString() {
        return ToStringUtility.newToStringBuilder(this)
            .append("toolData", mToolData)
            .toString();
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public CreateToolPropertiesWSModel getToolData() {
        return mToolData;
    }

    public void setToolData(CreateToolPropertiesWSModel toolData) {
        mToolData = toolData;
    }
}