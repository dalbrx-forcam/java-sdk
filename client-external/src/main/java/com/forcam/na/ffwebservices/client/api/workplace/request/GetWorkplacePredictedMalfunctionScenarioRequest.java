////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.request;

import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;

/**
 * Request parameter for getting a predicted malfunction scenario.
 */
public class GetWorkplacePredictedMalfunctionScenarioRequest extends CollectionRequest {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The predicted malfunction scenario ID. */
    private String mPredictedMalfunctionScenarioId;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance with predicted malfunction scenario ID.
     *
     * @param predictedMalfunctionScenarioId The predicted malfunction scenario ID.
     */
    public GetWorkplacePredictedMalfunctionScenarioRequest(String predictedMalfunctionScenarioId) {
        mPredictedMalfunctionScenarioId = predictedMalfunctionScenarioId;
    }

    // ------------------------------------------------------------------------
    // getters/setters
    // ------------------------------------------------------------------------

    /**
     * Provides the predicted malfunction scenario ID.
     *
     * @return The predicted malfunction scenario ID.
     */
    public String getPredictedMalfunctionScenarioId() {
        return mPredictedMalfunctionScenarioId;
    }

    /**
     * Sets the predicted malfunction scenario ID.
     *
     * @param predictedMalfunctionScenarioId The predicted malfunction scenario ID.
     */
    public void setPredictedMalfunctionScenarioId(String predictedMalfunctionScenarioId) {
        mPredictedMalfunctionScenarioId = predictedMalfunctionScenarioId;
    }
}