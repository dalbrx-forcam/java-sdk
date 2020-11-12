////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.recordedoperatingstate;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStatePropertiesWSModel;

/**
 * The response model for recorded operating states.
 */
public class RecordedOperatingStateResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties of the recorded operating states. */
    private OperatingStateRecordWSModel mProperties;

    /** The embedded operating state. */
    private LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> mOperatingState;

    /** The embedded operating state details. */
    private LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> mOperatingStateDetails;

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

    public LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> getOperatingStateDetails() {
        return mOperatingStateDetails;
    }

    public void setOperatingStateDetails(LinkEmbeddedWSModel<OperatingStatePropertiesWSModel> operatingStateDetails) {
        mOperatingStateDetails = operatingStateDetails;
    }
}