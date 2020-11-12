////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 09.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.response;

import com.forcam.na.ffwebservices.model.AbstractResponse;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;

/**
 * Operation forecast result response.
 */
public class OperationForecastResultResponse extends AbstractResponse {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation forecast properties. */
    private OperationAssignmentWSModel mProperties = new OperationAssignmentWSModel();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation forecast properties.
     *
     * @return The operation forecast properties WS model.
     */
    public OperationAssignmentWSModel getProperties() {
        return mProperties;
    }

    /**
     * Sets the The operation forecast properties.
     *
     * @param properties The operation forecast properties WS model.
     */
    public void setProperties(OperationAssignmentWSModel properties) {
        mProperties = properties;
    }
}