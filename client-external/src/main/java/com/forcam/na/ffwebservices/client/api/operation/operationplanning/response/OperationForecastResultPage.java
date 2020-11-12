////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 27.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning.response;

import com.forcam.na.ffwebservices.client.api.pagination.response.SpecificPage;

import java.lang.reflect.Method;

/**
 * Page containing operation forecast results.
 */
public class OperationForecastResultPage
    extends SpecificPage<OperationForecastResultResponse, OperationAssignmentCollectionResponse<OperationForecastResultResponse>> {

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
    public OperationForecastResultPage(Object client, Method clientMethod, OperationAssignmentCollectionResponse<OperationForecastResultResponse> response) {
        super(client, clientMethod, response);
    }
}