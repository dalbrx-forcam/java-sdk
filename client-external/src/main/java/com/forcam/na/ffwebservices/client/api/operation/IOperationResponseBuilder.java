////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.operation.request.*;
import com.forcam.na.ffwebservices.client.api.operation.response.*;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.model.operation.OperationResponse;

/**
 * Contains methods for building responses for operations.
 */
public interface IOperationResponseBuilder {

    /**
     * Transforms a collection model into an operation collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return An operation collection response.
     */
    CollectionResponse<OperationResponse> getOperationCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL Model into an Operation Model.
     *
     * @param serverModel The model received by the server.
     * @return An operation model.
     */
    OperationResponse getOperationResponse(HALWSModel serverModel);

    /**
     * Gets operation user field collection response model.
     *
     * @param request           The request.
     * @param collectionWSModel The HAL model.
     * @return The operation user field collection response.
     */
    OperationUserFieldCollectionResponse getOperationUserFieldCollectionResponse(GetOperationUserFieldsRequest request, HALWSModel collectionWSModel);

    /**
     * Converts HAL model into an operation component collection response.
     *
     * @param request The request.
     * @param model   The model received by the server.
     * @return The operation component collection response.
     */
    OperationComponentCollectionResponse getOperationComponentCollectionResponse(GetOperationComponentsRequest request, HALWSModel model);

    /**
     * Converts HAL model into operation manufacturing variants response.
     *
     * @param serverModel The HAL model.
     * @return The operation manufacturing variants response.
     */
    OperationManufacturingVariantsResponse getOperationManufacturingVariantsResponse(HALWSModel serverModel);

    /**
     * Converts HAL model into operation operating state summary response.
     *
     * @param request     The request.
     * @param serverModel The HAL model.
     * @return The operation operating state summary response.
     */
    OperationOperatingStateSummaryResponse getOperationOperatingStateSummaryResponse(GetOperationOperatingStateSummaryRequest request, HALWSModel serverModel);

    /**
     * Converts HAL model into operation recorded operation phases response.
     *
     * @param request     The request.
     * @param serverModel The HAL model.
     * @return The operation recorded operation phases response.
     */
    OperationRecordedOperationPhasesResponse getOperationRecordedOperationPhasesResponse(GetOperationRecordedOperationPhasesRequest request,
                                                                                         HALWSModel serverModel);

    /**
     * Converts HAL model into operation recorded output quantities response.
     *
     * @param request     The request.
     * @param serverModel The HAL model.
     * @return The operation recorded output quantities response.
     */
    OperationRecordedOutputQuantitiesResponse getOperationRecordedOutputQuantitiesResponse(GetOperationRecordedOutputQuantitiesRequest request,
                                                                                           HALWSModel serverModel);
}
