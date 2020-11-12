////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.statusdefinition;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;

/**
 * An operating state model.
 */
public class OperatingStateResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the operating state. */
    private OperatingStatePropertiesWSModel mProperties;

    /** The embedded operating state class. */
    private LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> mOperatingStateClass;

    /** The embedded workplace state. */
    private LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> mWorkplaceState;

    /** The embedded description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mDescription;

    /** The embedded short description. */
    private LinkEmbeddedWSModel<LiteralPropertiesWSModel> mShortDescription;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperatingStatePropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OperatingStatePropertiesWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> getOperatingStateClass() {
        return mOperatingStateClass;
    }

    public void setOperatingStateClass(LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> operatingStateClass) {
        mOperatingStateClass = operatingStateClass;
    }

    public LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> getWorkplaceState() {
        return mWorkplaceState;
    }

    public void setWorkplaceState(LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> workplaceState) {
        mWorkplaceState = workplaceState;
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