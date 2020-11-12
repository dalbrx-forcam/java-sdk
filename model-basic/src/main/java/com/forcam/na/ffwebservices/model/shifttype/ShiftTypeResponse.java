////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 04.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.shifttype;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

/**
 * A model for shift types.
 */
public class ShiftTypeResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the shift. */
    private ShiftTypePropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded short description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mShortDescription;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public ShiftTypePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(ShiftTypePropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getDescription() {
        return mDescription;
    }

    public void setDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> description) {
        mDescription = description;
    }

    public LinkEmbeddedWSModel<LiteralPropertiesWSModel> getShortDescription() {
        return mShortDescription;
    }

    public void setShortDescription(LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription) {
        mShortDescription = shortDescription;
    }
}