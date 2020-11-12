////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.machinestatedetail;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

/**
 * A machine state detail model.
 */
public class MachineStateDetailResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the machine state detail. */
    private MachineStateDetailPropertiesWSModel mProperties;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded short description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mShortDescription;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public MachineStateDetailPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(MachineStateDetailPropertiesWSModel properties) {
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