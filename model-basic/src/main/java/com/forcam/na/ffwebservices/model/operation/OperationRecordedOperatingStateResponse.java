////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.recordedoperatingstate.OperatingStateRecordWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStatePropertiesWSModel;

/**
 * The response model for recorded operating states.
 */
public class OperationRecordedOperatingStateResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the recorded operating states. */
    private OperatingStateRecordWSModel mProperties;

    /** The embedded operating state. */
    private LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> mOperatingState;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperatingStateRecordWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OperatingStateRecordWSModel properties) {
        mProperties = properties;
    }

    public LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> getOperatingState() {
        return mOperatingState;
    }

    public void setOperatingState(LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> operatingState) {
        mOperatingState = operatingState;
    }
}