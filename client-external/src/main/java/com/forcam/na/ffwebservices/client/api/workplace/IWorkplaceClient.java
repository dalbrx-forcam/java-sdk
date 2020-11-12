////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.response.RecordedOperatingStateCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftRequest;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetOperatingStateSummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceDevicesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacePredictedMalfunctionScenarioRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacePredictedMalfunctionScenariosRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRecordedOperatingStatesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRecordedOutputQuantitiesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceTimeRangeRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceUserFieldsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.UpdateWorkplaceRecordedOperatingStateRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceOperatingStateSummaryPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplacePredictedMalfunctionScenarioPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceQuantitySummaryCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOperationPhasesPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOutputQuantitiesPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledMaintenanceTimesCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledOperatingTimesCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceUserFieldCollectionPage;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftResponse;
import com.forcam.na.ffwebservices.model.workplace.CreateWorkplacePredictedMalfunctionScenarioWSModel;
import com.forcam.na.ffwebservices.model.workplace.EmbeddedPredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;

/**
 * An interface with methods that request workplaces and shifts of workplaces.
 */
public interface IWorkplaceClient {

    /**
     * Sends a request to the server and gets a collection of workplaces as response.
     *
     * @param request A collection of parameters.
     * @return The workplace collection response.
     * @throws ForceAPIException When unable to get workplaces.
     */
    Page<WorkplaceResponse> getWorkplaces(GetWorkplacesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a workplace model as response.
     *
     * @param request A collection of parameters.
     * @return A workplace model.
     * @throws ForceAPIException When unable to get workplace.
     */
    WorkplaceResponse getWorkplace(GetWorkplaceRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of shifts as response.
     *
     * @param request A collection of parameters.
     * @return The shift collection response.
     * @throws ForceAPIException When unable to get shifts.
     */
    Page<WorkplaceShiftResponse> getShifts(GetWorkplaceShiftsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a shift as response.
     *
     * @param request A collection of parameters.
     * @return A shift model.
     * @throws ForceAPIException When unable to get shift.
     */
    WorkplaceShiftResponse getShift(GetWorkplaceShiftRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a collection of recorded operating states of a workplace as response.
     *
     * @param request A collection of parameters.
     * @return The recorded operating states of the specified workplace.
     * @throws ForceAPIException When unable to get recorded operating states.
     */
    RecordedOperatingStateCollectionPage getRecordedOperatingStates(GetWorkplaceRecordedOperatingStatesRequest request) throws ForceAPIException;

    /**
     * Sends a recorded operating state request to the server.
     *
     * @param request A collection of parameters.
     * @throws ForceAPIException When unable to update recorded operating state.
     */
    void updateRecordedOperatingState(UpdateWorkplaceRecordedOperatingStateRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the quantity summary of a workplace as response.
     *
     * @param request A collection of parameters.
     * @return The quantity summary of the specified workplace.
     * @throws ForceAPIException When unable to get quantity summary.
     */
    WorkplaceQuantitySummaryCollectionPage getQuantitySummary(GetWorkplaceQuantitySummaryRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the scheduled operating times of a workplace as response.
     *
     * @param request A collection of parameters.
     * @return The scheduled operating times of the specified workplace.
     * @throws ForceAPIException When unable to get scheduled operating times for the workplace.
     */
    WorkplaceScheduledOperatingTimesCollectionPage getScheduledOperatingTimes(GetWorkplaceTimeRangeRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the operating state summary of a workplace.
     *
     * @param request The request parameters.
     * @return The workplace operating state summary response.
     * @throws ForceAPIException When unable to get the operating state summary of the workplace.
     */
    WorkplaceOperatingStateSummaryPage getOperatingStateSummary(GetOperatingStateSummaryRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the recorded output quantities of a workplace.
     *
     * @param request The request parameter.
     * @return The workplace recorded output quantities response.
     * @throws ForceAPIException When unable to get the recorded output quantities.
     */
    WorkplaceRecordedOutputQuantitiesPage getWorkplaceRecordedOutputQuantities(GetWorkplaceRecordedOutputQuantitiesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the recorded operationPhases of a workplace.
     *
     * @param request The request parameter.
     * @return The workplace recorded operation phases response.
     * @throws ForceAPIException When unable to get the recorded operation phases.
     */
    WorkplaceRecordedOperationPhasesPage getWorkplaceRecordedOperationPhases(GetWorkplaceTimeRangeRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the scheduled maintenance times of a workplace as response.
     *
     * @param request A collection of parameters.
     * @return The scheduled maintenance times of the specified workplace.
     * @throws ForceAPIException When unable to get scheduled maintenance times for the workplace.
     */
    WorkplaceScheduledMaintenanceTimesCollectionPage getWorkplaceScheduledMaintenanceTimes(GetWorkplaceTimeRangeRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets the workplace devices.
     *
     * @param request The request parameter.
     * @return The device collection response.
     * @throws ForceAPIException When unable to get the devices.
     */
    Page<DeviceResponse> getWorkplaceDevices(GetWorkplaceDevicesRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all predicted malfunction scenarios.
     *
     * @param request The request parameters.
     * @return The page of predicted malfunction scenario responses.
     * @throws ForceAPIException When unable to get the predicted malfunction scenarios.
     */
    Page<EmbeddedPredictedMalfunctionScenarioResponse> getPredictedMalfunctionScenarios(GetWorkplacePredictedMalfunctionScenariosRequest request)
        throws ForceAPIException;

    /**
     * Sends a request to the server and gets a predicted malfunction scenario.
     *
     * @param request The request parameter.
     * @return The workplace predicted malfunction scenario response.
     * @throws ForceAPIException When unable to get the predicted malfunction scneario.
     */
    WorkplacePredictedMalfunctionScenarioPage getPredictedMalfunctionScenario(GetWorkplacePredictedMalfunctionScenarioRequest request) throws ForceAPIException;

    /**
     * Senda a request to the server and saved a predicted malfunction scenario.
     *
     * @param predictedMalfunctionScenario The predicted malfunction scenario.
     * @return The saved predicted malfunction scenario response.
     * @throws ForceAPIException When unable to save the predicted malfunction scenario.
     */
    WorkplacePredictedMalfunctionScenarioPage savePredictedMalfunctionScenario(CreateWorkplacePredictedMalfunctionScenarioWSModel predictedMalfunctionScenario)
        throws ForceAPIException;

    /**
     * Sends a request to the server and gets the workplace user field collection as response.
     *
     * @param request The workplace user fields request parameters.
     * @return The workplace user field collection response.
     * @throws ForceAPIException When unable to get workplace user fields.
     */
    WorkplaceUserFieldCollectionPage getWorkplaceUserFields(GetWorkplaceUserFieldsRequest request) throws ForceAPIException;
}
