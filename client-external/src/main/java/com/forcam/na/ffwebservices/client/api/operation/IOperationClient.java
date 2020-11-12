////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationCurrentProductionDataRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationComponentsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationOperatingStateSummaryRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationProductionResourcesAndToolsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOperatingStatesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOperationPhasesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOutputQuantitiesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationScheduledDatesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationSpecificationRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationUserFieldsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SearchOperationsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SetOperationPhaseRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SetOperationQualityDetailsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.UpdateOperationRecordedOperatingStateRequest;
import com.forcam.na.ffwebservices.client.api.operation.response.OperatingQuantitySummaryCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationComponentCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationManufacturingVariantsResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationOperatingStateSummaryPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOperationPhasePage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOutputQuantitiesPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationUserFieldCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.RecordedOperatingStateCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.workplace.request.UpdateWorkplaceRecordedOperatingStateRequest;
import com.forcam.na.ffwebservices.model.operation.OperationCurrentProductionDataResponse;
import com.forcam.na.ffwebservices.model.operation.OperationResponse;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesResponse;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationResponse;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;

/**
 * An interface with methods that search for operations.
 */
public interface IOperationClient {

    /**
     * Sends a request to the server and gets a collection of operations as response.
     *
     * @param request A collection of parameters.
     * @return Operation collection response.
     * @throws ForceAPIException When unable to search for operations.
     */
    Page<OperationResponse> searchOperations(SearchOperationsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets an operation model as response.
     *
     * @param request A collection of parameters.
     * @return Operation server model.
     * @throws ForceAPIException When unable to get operation.
     */
    OperationResponse getOperation(GetOperationRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the scheduled dates of the specified operation as response.
     *
     * @param request A collection of parameters.
     * @return The scheduled dates of the specified operation.
     * @throws ForceAPIException When unable to get scheduled dates.
     */
    OperationScheduledDatesResponse getScheduledDates(GetOperationScheduledDatesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the specification of the specified operation as response.
     *
     * @param request A collection of parameters.
     * @return The specification of the specified operation.
     * @throws ForceAPIException When unable to get specification.
     */
    OperationSpecificationResponse getSpecification(GetOperationSpecificationRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the production resources and tools of an operation as response.
     *
     * @param request A collection of parameters.
     * @return The production resources and tools of the specified operation.
     * @throws ForceAPIException When unable to get production resources and tools.
     */
    Page<ProductionResourceToolResponse> getProductionResourcesAndTools(GetOperationProductionResourcesAndToolsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the recorded operating states of an operation as response.
     *
     * @param request A collection of parameters.
     * @return The recorded operating states of the specified operation.
     * @throws ForceAPIException When unable to get recorded operating states.
     */
    RecordedOperatingStateCollectionPage getRecordedOperatingStates(GetOperationRecordedOperatingStatesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of operations as response.
     *
     * @param request A collection of parameters.
     * @return Operation collection response.
     * @throws ForceAPIException When unable to get operations.
     */
    Page<OperationResponse> getOperations(GetOperationsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the quantity summary of an operation as response.
     *
     * @param request A collection of parameters.
     * @return The quantity summary of the specified operation.
     * @throws ForceAPIException When unable to get quantity summary.
     */
    OperatingQuantitySummaryCollectionPage getQuantitySummary(GetOperationQuantitySummaryRequest request) throws ForceAPIException;

    /**
     * Sends a quality detail request to the server.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to set quality details.
     */
    void setQualityDetails(SetOperationQualityDetailsRequest request) throws ForceAPIException;

    /**
     * Send an operation phase request to the server and gets an operation as response.
     *
     * @param request A collection of parameters.
     * @return Operation server model.
     * @throws ForceAPIException When unable to set operation phase.
     */
    OperationResponse setOperationPhase(SetOperationPhaseRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the operation user field collection as response.
     *
     * @param request The operation user fields request parameters.
     * @return The operation user field collection response.
     * @throws ForceAPIException When unable to get operation user fields.
     */
    OperationUserFieldCollectionPage getOperationUserFields(GetOperationUserFieldsRequest request) throws ForceAPIException;

    /**
     * Sends an operation component collection request to the server and get an operation component collection as response.
     *
     * @param request The operation component collection request.
     * @return The operation component collection response.
     * @throws ForceAPIException When unable to get operation components.
     */
    OperationComponentCollectionPage getOperationComponents(GetOperationComponentsRequest request) throws ForceAPIException;

    /**
     * Sends the operation ID to the server and gets the manufacturing variants for corresponding operation.
     *
     * @param operationId The operation ID.
     * @return The operation manufacturing variants response.
     * @throws ForceAPIException When unable to get the operation manufacturing variants.
     */
    OperationManufacturingVariantsResponse getOperationManufacturingVariants(String operationId) throws ForceAPIException;

    /**
     * Sends a get recorded operation phases request to the server and gets the operation recorded operation phases response.
     *
     * @param request The request parameters.
     * @return The operation recorded operation phases response.
     * @throws ForceAPIException When unable to get the recorded operation phases of an operation.
     */
    OperationRecordedOperationPhasePage getRecordedOperationPhases(GetOperationRecordedOperationPhasesRequest request) throws ForceAPIException;

    /**
     * Sends a get operation operating state summary request to the server and get the operating state summary of an operation.
     *
     * @param request The request parameters.
     * @return The operation operating state summary response.
     * @throws ForceAPIException When unable to get operating state summary of the operation.
     */
    OperationOperatingStateSummaryPage getOperatingStateSummary(GetOperationOperatingStateSummaryRequest request) throws ForceAPIException;

    /**
     * Sends a get operation recorded output quantities request to the server and gets the recorded output quantities of an operation.
     *
     * @param request The request parameters.
     * @return The operation recorded output quantities response.
     * @throws ForceAPIException When unable to get the recorded output quantities of an operation.
     */
    OperationRecordedOutputQuantitiesPage getRecordedOutputQuantities(GetOperationRecordedOutputQuantitiesRequest request) throws ForceAPIException;

    /**
     * Sends the operation ID to the server and gets all alternative workplaces for the operation.
     *
     * @param operationId The operation ID.
     * @return Page of alternative workplaces.
     * @throws ForceAPIException When unable to get the alternative workplaces.
     */
    Page<WorkplaceResponse> getAlternativeWorkplaces(String operationId) throws ForceAPIException;

    /**
     * Sends the operation ID to the server and gets the current production data of the operation.
     *
     * @param request The  request parameters.
     * @return The operation current production data response.
     * @throws ForceAPIException When unable to get the operation for given ID.
     */
    OperationCurrentProductionDataResponse getCurrentProductionData(GetOperationCurrentProductionDataRequest request) throws ForceAPIException;

    /**
     * Sends a recorded operating state request to the server.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to update recorded operating state.
     */
    void updateRecordedOperatingState(UpdateOperationRecordedOperatingStateRequest request) throws ForceAPIException;
}