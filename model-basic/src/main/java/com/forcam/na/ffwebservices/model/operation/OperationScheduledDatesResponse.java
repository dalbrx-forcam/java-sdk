////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 12.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.model.operation;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for the scheduled dates of an operation.
 */
public class OperationScheduledDatesResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties for the scheduled dates of an operation. */
    private OperationScheduledDatesPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationScheduledDatesPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OperationScheduledDatesPropertiesWSModel properties) {
        mProperties = properties;
    }
}