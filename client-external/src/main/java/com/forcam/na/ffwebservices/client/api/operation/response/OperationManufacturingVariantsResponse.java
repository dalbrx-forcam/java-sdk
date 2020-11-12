////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 15.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.operation.OperationManufacturingVariantsPropertiesWSModel;

/**
 * Operation manufacturing variants response.
 */
public class OperationManufacturingVariantsResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation manufacturing variants properties. */
    private OperationManufacturingVariantsPropertiesWSModel mProperties = new OperationManufacturingVariantsPropertiesWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation manufacturing variants properties.
     *
     * @return The operation manufacturing variants properties WS model.
     */
    public OperationManufacturingVariantsPropertiesWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the The operation manufacturing variants properties.
     *
     * @param properties The operation manufacturing variants properties WS model.
     */
    public void setProperties(OperationManufacturingVariantsPropertiesWSModel properties) {
        mProperties = properties;
    }
}