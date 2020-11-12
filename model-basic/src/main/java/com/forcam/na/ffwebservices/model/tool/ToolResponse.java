////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.tool;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

/**
 * The response object for a tool.
 */
public class ToolResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the tool. */
    private ToolPropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded workplace. */
    private LinkEmbeddedWSModel<WorkplacePropertiesWSModel> mWorkplace;

    /** The embedded location. */
    private LinkEmbeddedWSModel<ToolLocationGeneralDefinitionWSModel> mLocation;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ToolPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(ToolPropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public LinkEmbeddedWSModel<WorkplacePropertiesWSModel> getWorkplace() {
        return mWorkplace;
    }

    public void setWorkplace(LinkEmbeddedWSModel<WorkplacePropertiesWSModel> workplace) {
        mWorkplace = workplace;
    }

    public LinkEmbeddedWSModel<ToolLocationGeneralDefinitionWSModel> getLocation() {
        return mLocation;
    }

    public void setLocation(LinkEmbeddedWSModel<ToolLocationGeneralDefinitionWSModel> location) {
        mLocation = location;
    }
}