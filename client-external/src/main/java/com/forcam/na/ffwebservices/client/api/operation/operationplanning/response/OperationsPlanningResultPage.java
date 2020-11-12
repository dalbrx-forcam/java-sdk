////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 14.09.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.response;

import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationAssignmentCollectionResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;

import java.lang.reflect.Method;

/**
 * Page containing operation planning results.
 */
public class OperationsPlanningResultPage
    extends SpecificPage<OperationPlanningResultResponse, OperationAssignmentCollectionResponse<OperationPlanningResultResponse>> {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param client       The client.
     * @param clientMethod The client method.
     * @param response     The response.
     */
    public OperationsPlanningResultPage(Object client, Method clientMethod, OperationAssignmentCollectionResponse<OperationPlanningResultResponse> response) {
        super(client, clientMethod, response);
    }

}