////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 24.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;

import java.lang.reflect.Method;

/**
 *
 */
public class OperationPlanningScenarioPage extends SpecificPage<OperationAssignmentWSModel, PlanningScenarioWithAssignmentsResponse> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client   The client.
     * @param m        The client method.
     * @param response The response.
     */
    public OperationPlanningScenarioPage(Object client, Method m, PlanningScenarioWithAssignmentsResponse response) {super(client, m, response);}

}