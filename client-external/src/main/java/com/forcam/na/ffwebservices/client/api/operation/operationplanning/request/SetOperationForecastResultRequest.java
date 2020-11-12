////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 09.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.request;

import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;

/**
 * Set operation forecast result request parameters.
 */
public class SetOperationForecastResultRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation forecast properties. */
    private OperationAssignmentWSModel mForecastResult = new OperationAssignmentWSModel();

    /** The operation ID. */
    private String mOperationId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param operationId The operation ID.
     */
    public SetOperationForecastResultRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation forecast properties.
     *
     * @return The operation forecast properties WS model.
     */
    public OperationAssignmentWSModel getForecastResult() {
        return mForecastResult;
    }

    /**
     * Sets the operation forecast properties.
     *
     * @param forecastResult The operation forecast properties WS model.
     */
    public void setForecastResult(OperationAssignmentWSModel forecastResult) {
        mForecastResult = forecastResult;
    }

    /**
     * Provides the operation ID.
     *
     * @return The operation ID.
     */
    public String getOperationId() {
        return mOperationId;
    }

    /**
     * Sets the operation ID.
     *
     * @param operationId The operation ID.
     */
    public void setOperationId(String operationId) {
        mOperationId = operationId;
    }
}