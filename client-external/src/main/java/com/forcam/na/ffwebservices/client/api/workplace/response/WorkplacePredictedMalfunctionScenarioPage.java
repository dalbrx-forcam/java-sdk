////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 26.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.workplace.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.PredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.model.workplace.ImminentMalfunctionWSModel;

import java.lang.reflect.Method;

/**
 * Response page of workplace predicted malfunction scenario.
 */
public class WorkplacePredictedMalfunctionScenarioPage extends SpecificPage<ImminentMalfunctionWSModel, PredictedMalfunctionScenarioResponse> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client       The client which can be used for requests.
     * @param clientMethod The method of the client which can be used for requests.
     * @param response     The current response.
     */
    public WorkplacePredictedMalfunctionScenarioPage(Object client, Method clientMethod, PredictedMalfunctionScenarioResponse response) {
        super(client, clientMethod, response);
    }
}