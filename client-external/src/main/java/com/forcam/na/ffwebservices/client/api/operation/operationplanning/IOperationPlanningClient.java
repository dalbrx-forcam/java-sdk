////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.*;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.*;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningResultBodyWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenariosBodyWSModel;
import com.forcam.na.ffwebservices.model.planningscenarioassignment.PlanningScenarioResponse;

/**
 * Planning scenario client.
 */
public interface IOperationPlanningClient {

    /**
     * Get the planning scenarios.
     *
     * @param request Get planning scenario request.
     * @return Planning scenario collection response.
     * @throws ForceAPIException Exception if fails to get the planning scenarios.
     */
    Page<PlanningScenarioResponse> getPlanningScenarios(GetPlanningScenariosRequest request) throws ForceAPIException;

    /**
     * Gets the operation planning scenario by ID.
     *
     * @param request The get planning scenario request.
     * @return The planing scenario response.
     * @throws ForceAPIException When unable to get planning scenario.
     */
    OperationPlanningScenarioPage getPlanningScenario(GetPlanningScenarioRequest request) throws ForceAPIException;

    /**
     * Saves the planning scenario.
     *
     * @param request The create planning scenario properties for request.
     * @return The saved operation planning scenario response.
     * @throws ForceAPIException When unable to save the planning scenario.
     */
    OperationPlanningScenarioPage setPlanningScenario(OperationPlanningScenariosBodyWSModel request) throws ForceAPIException;

    /**
     * Sends an operation planning result request to the server and gets an operation planning result response.
     *
     * @param request The operation planning result request.
     * @return The operation planning result response.
     * @throws ForceAPIException When unable to get operation planning result.
     */
    OperationPlanningResultResponse getOperationPlanningResult(GetOperationPlanningResultRequest request) throws ForceAPIException;

    /**
     * Sends an operation planning results request to the server and gets an operation assignments page.
     *
     * @param request The operation planning results request.
     * @return The operation assignments page.
     * @throws ForceAPIException When unable to get operation planning results.
     */
    OperationsPlanningResultPage getOperationsPlanningResults(GetOperationsPlanningResultsRequest request) throws ForceAPIException;

    /**
     * Sends an operation planning result body to the server to update the results.
     *
     * @param request The operation planning result body.
     * @throws ForceAPIException When unable to update planning results.
     */
    void updateOperationsPlanningResults(OperationPlanningResultBodyWSModel request) throws ForceAPIException;

    /**
     * Sends a set operation planning result request to the server and gets the saved operation planning result response.
     *
     * @param request The set operation planning result request.
     * @return The saved operation planning result response.
     * @throws ForceAPIException When unable to save the operation planning result.
     */
    OperationPlanningResultResponse saveOperationPlanningResult(SetOperationPlanningResultRequest request) throws ForceAPIException;

    /**
     * Sends the operation ID to the server and deletes the corresponding operation planning result.
     *
     * @param operationId The operation ID.
     * @throws ForceAPIException When unable to delete the operation planning result.
     */
    void deleteOperationPlanningResult(String operationId) throws ForceAPIException;

    /**
     * Sends the operation ID to the server and gets the corresponding operation forecast result.
     *
     * @param operationId The operation ID.
     * @return The operation forecast result response.
     * @throws ForceAPIException When unable to get the operation forecast.
     */
    OperationForecastResultResponse getOperationForecastResult(String operationId) throws ForceAPIException;

    /**
     * Sends the operation forecast results request to the server and gets the operation assignments page.
     *
     * @param request The operation forecast results request.
     * @return The operation assignments page.
     * @throws ForceAPIException When unable to get the forecast results.
     */
    OperationForecastResultPage getOperationsForecastResults(GetOperationsForecastResultsRequest request) throws ForceAPIException;

    /**
     * Sends a set operation forecast result request to the server and gets the saved operation forecast result response.
     *
     * @param request The set operation forecast result request.
     * @return The saved operation forecast result response.
     * @throws ForceAPIException When unable to save the operation forecast.
     */
    OperationForecastResultResponse saveOperationForecastResult(SetOperationForecastResultRequest request) throws ForceAPIException;

    /**
     * Sends an update operation forecast results request to the server and updates the corresponding operation forecast results.
     *
     * @param request The update operation forecast results request.
     * @throws ForceAPIException When unable to update the operation forecasts.
     */
    void updateOperationForecastResults(UpdateOperationForecastResultsRequest request) throws ForceAPIException;

    /**
     * Sends the operation ID to the server and deletes the corresponding operation forecast result.
     *
     * @param operationId The operation ID.
     * @throws ForceAPIException When unable to delete the operation forecast.
     */
    void deleteOperationForecastResult(String operationId) throws ForceAPIException;
}
