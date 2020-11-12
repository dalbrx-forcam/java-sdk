////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 15.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.request;

import com.forcam.na.ffwebservices.model.operation.OperationManufacturingVariantsPropertiesWSModel;

/**
 * Request parameters to set operation predicted values.
 */
public class SetOperationPredictedValuesRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Operation predicted values properties. */
    private OperationManufacturingVariantsPropertiesWSModel mPredictedValues = new OperationManufacturingVariantsPropertiesWSModel();

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
    public SetOperationPredictedValuesRequest(String operationId) {
        mOperationId = operationId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the operation predicted values properties.
     *
     * @return The operation predicted values properties WS model.
     */
    public OperationManufacturingVariantsPropertiesWSModel getPredictedValues() {
        return mPredictedValues;
    }

    /**
     * Sets the operation predicted values properties.
     *
     * @param predictedValues The operation predicted values properties WS model.
     */
    public void setPredictedValues(OperationManufacturingVariantsPropertiesWSModel predictedValues) {
        mPredictedValues = predictedValues;
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