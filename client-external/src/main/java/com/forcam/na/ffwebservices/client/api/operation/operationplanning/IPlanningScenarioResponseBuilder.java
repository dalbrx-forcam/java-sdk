////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetPlanningScenariosRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.PlanningScenarioWithAssignmentsResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.planningscenarioassignment.PlanningScenarioResponse;

/**
 * Planning scenario response builder.
 */
public interface IPlanningScenarioResponseBuilder {

    /**
     * Transforms a collection model to a planning scenario collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A planning scenario collection response.
     */
    CollectionResponse<PlanningScenarioResponse> getPlanningScenarioCollectionResponse(GetPlanningScenariosRequest request,
                                                                                       HALCollectionWSModel collectionModel);

    /**
     * Transforms a HAL webservice model into a planning scenario response.
     *
     * @param serverModel The HAL webservice model.
     * @return The planning scenario response.
     */
    PlanningScenarioResponse getPlanningScenarioResponse(HALWSModel serverModel);

    /**
     * Transforms a HAL model into a planning scenario with assignments response.
     *
     * @param request     The collection request.
     * @param serverModel The HAL model.
     * @return The planning scenario with assignments response.
     */
    PlanningScenarioWithAssignmentsResponse getPlanningScenarioWithAssignmentsResponse(CollectionRequest request, HALWSModel serverModel);
}
