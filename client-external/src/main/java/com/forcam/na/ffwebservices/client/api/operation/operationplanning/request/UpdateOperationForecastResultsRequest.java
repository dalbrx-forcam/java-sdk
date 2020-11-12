////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 09.05.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.request;

import com.forcam.na.ffwebservices.model.operation.UpdateOperationForecastRequestBody;

/**
 * Request parameters for updating operation forecast results.
 */
public class UpdateOperationForecastResultsRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** Set of update operation forecast request bodies. */
    private UpdateOperationForecastRequestBody mForecastResults = new UpdateOperationForecastRequestBody();

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the set of update operation forecast request bodies.
     *
     * @return The set of update operation forecast request bodies.
     */
    public UpdateOperationForecastRequestBody getForecastResults() {
        return mForecastResults;
    }

    /**
     * Sets the set of update operation forecast request bodies.
     *
     * @param forecastResults The set of update operation forecast request bodies.
     */
    public void setForecastResults(UpdateOperationForecastRequestBody forecastResults) {
        mForecastResults = forecastResults;
    }
}