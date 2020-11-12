////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacePredictedMalfunctionScenariosRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceTimeRangeRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceUserFieldsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.PredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOperationPhasesResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledMaintenanceTimesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledOperatingTimesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceUserFieldCollectionResponse;
import com.forcam.na.ffwebservices.model.workplace.EmbeddedPredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;

/**
 * Contains methods for building responses for workplaces.
 */
public interface IWorkplaceResponseBuilder {

    /**
     * Transforms a collection model to a workplace collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A workplace collection response.
     */
    CollectionResponse<WorkplaceResponse> getWorkplaceCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel);

    /**
     * Transforms a collection model to a workplace collection response without pagination.
     *
     * @param collectionModel The collection model.
     * @return The workplace collection response.
     */
    CollectionResponse<WorkplaceResponse> getAlternativeWorkplaceCollectionResponse(HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a workplace model.
     *
     * @param serverModel The server model.
     * @return A workplace model.
     */
    WorkplaceResponse getWorkplaceResponse(HALWSModel serverModel);

    /**
     * Converts HAL model to a workplace scheduled operating time collection response.
     *
     * @param request     The request.
     * @param serverModel The server model.
     * @return The workplace scheduled operating time collection response.
     */
    WorkplaceScheduledOperatingTimesCollectionResponse getWorkplaceScheduledOperatingTimesCollectionResponse(GetWorkplaceTimeRangeRequest request,
                                                                                                             HALWSModel serverModel);

    /**
     * Converts HAL model to a workplace recorded operation phases response.
     *
     * @param request     The request.
     * @param serverModel The server model.
     * @return The workplace recorded operation phases response.
     */
    WorkplaceRecordedOperationPhasesResponse getWorkplaceRecordedOperationPhasesResponse(GetWorkplaceTimeRangeRequest request, HALWSModel serverModel);

    /**
     * Converts HAL model to a workplace scheduled maintenance time collection response.
     *
     * @param request     The request.
     * @param serverModel The server model.
     * @return The workplace scheduled maintenance time collection response.
     */
    WorkplaceScheduledMaintenanceTimesCollectionResponse getWorkplaceScheduledMaintenanceTimesCollectionResponse(GetWorkplaceTimeRangeRequest request,
                                                                                                                 HALWSModel serverModel);

    /**
     * Converts HAL collection model into a collection response of predicted malfunction scenario responses.
     *
     * @param request         The request parameter.
     * @param collectionModel The HAL collection model.
     * @return The collection response of predicted malfunction scenarios.
     */
    CollectionResponse<EmbeddedPredictedMalfunctionScenarioResponse> getEmbeddedPredictedMalfunctionScenarioResponse(
        GetWorkplacePredictedMalfunctionScenariosRequest request, HALCollectionWSModel collectionModel);

    /**
     * Converts HAL model into a predicted malfunction scenario response.
     *
     * @param request     The collection request parameter.
     * @param serverModel The HAL model.
     * @return The predicted malfunction scenario response.
     */
    PredictedMalfunctionScenarioResponse getPredictedMalfunctionScenarioResponse(CollectionRequest request, HALWSModel serverModel);

    /**
     * Gets workplace user field collection response model.
     *
     * @param request           The request.
     * @param collectionWSModel The HAL model.
     * @return The workplace user field collection response.
     */
    WorkplaceUserFieldCollectionResponse getWorkplaceUserFieldCollectionResponse(GetWorkplaceUserFieldsRequest request, HALWSModel collectionWSModel);
}