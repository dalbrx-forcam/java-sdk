////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 05.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

/**
 * The response object for the location of a tool.
 */
public class ToolLocationResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties for the location of a tool. */
    private ToolLocationGeneralDefinitionWSModel mProperties;

    /** The embedded tool. */
    private LinkEmbeddedWSModel<ToolPropertiesWSModel> mTool;

    /** The embedded workplace. */
    private LinkEmbeddedWSModel<WorkplacePropertiesWSModel> mWorkplace;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ToolLocationGeneralDefinitionWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(ToolLocationGeneralDefinitionWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<ToolPropertiesWSModel> getTool() {
        return mTool;
    }

    public void setTool(LinkEmbeddedWSModel<ToolPropertiesWSModel> tool) {
        mTool = tool;
    }

    public LinkEmbeddedWSModel<WorkplacePropertiesWSModel> getWorkplace() {
        return mWorkplace;
    }

    public void setWorkplace(LinkEmbeddedWSModel<WorkplacePropertiesWSModel> workplace) {
        mWorkplace = workplace;
    }
}