////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 06.05.2019.
//
// Copyright (c) 2006 - 2019 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.model.operation;

import com.forcam.na.ffwebservices.model.AbstractResponse;

/**
 * The response object for the current production data of an operation.
 */
public class OperationCurrentProductionDataResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The properties for the current production data of an operation. */
    private OperationCurrentProductionDataPropertiesWSModel mProperties;

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    public OperationCurrentProductionDataPropertiesWSModel getProperties() {
        return mProperties;
    }

    public void setProperties(OperationCurrentProductionDataPropertiesWSModel properties) {
        mProperties = properties;
    }
}