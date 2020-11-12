////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 09.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationAssignmentCollectionResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationForecastResultResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;

/**
 * Operation planning response builder.
 */
public interface IOperationPlanningResponseBuilder {

    /**
     * Converts HAL model into operation planning result response.
     *
     * @param serverModel The HAL model.
     * @return The operation planning result response.
     */
    OperationPlanningResultResponse getOperationPlanningResultResponse(HALWSModel serverModel);

    /**
     * Converts HAL model into operation forecast result response.
     *
     * @param serverModel The HAL model.
     * @return The operation forecast result response.
     */
    OperationForecastResultResponse getOperationForecastResultResponse(HALWSModel serverModel);

    /**
     * Converts HAL collection model into an operation planning result collection response.
     *
     * @param request         The request.
     * @param collectionModel The collection model received by the server.
     * @return The operation planning result collection response.
     */
    OperationAssignmentCollectionResponse<OperationPlanningResultResponse> getOperationPlanningResultCollectionResponse(PaginationRequest request,
                                                                                                                        OperationAssignmentCollectionServerModel collectionModel);

    /**
     * Converts HAL collection model into an operation forecast result collection response.
     *
     * @param request         The request.
     * @param collectionModel The collection model received by the server.
     * @return The operation forecast result collection response.
     */
    OperationAssignmentCollectionResponse<OperationForecastResultResponse> getOperationForecastCollectionResponse(PaginationRequest request,
                                                                                                                  OperationAssignmentCollectionServerModel collectionModel);
}