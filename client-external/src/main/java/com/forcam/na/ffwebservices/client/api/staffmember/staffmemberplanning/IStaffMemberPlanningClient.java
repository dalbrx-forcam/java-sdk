////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 09.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.*;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberPlanningScenarioPage;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberShiftPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMembersPlanningResultsPage;
import com.forcam.na.ffwebservices.model.staffmember.CreateStaffMemberPlanningScenarioPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.EmbeddedStaffMemberPlanningScenarioResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningResultPropertiesWSModel;

/**
 * Client to requests staff member planning actions.
 */
public interface IStaffMemberPlanningClient {

    /**
     * Sends a request to the server and gets a staff member planning scenario by ID.
     *
     * @param request The {@link GetStaffMemberPlanningScenarioRequest} request.
     * @return A {@link StaffMemberPlanningScenarioPage} with the staff member planning scenario and assignments.
     * @throws ForceAPIException When unable to get the staff member planning scenario.
     */
    StaffMemberPlanningScenarioPage getStaffMemberPlanningScenario(GetStaffMemberPlanningScenarioRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a page of all staff member planning scenarios.
     *
     * @param request The {@link GetStaffMemberPlanningScenarioCollectionRequest} request.
     * @return A page of all {@link EmbeddedStaffMemberPlanningScenarioResponse}.
     * @throws ForceAPIException When unable to get all staff member planning scearios.
     */
    Page<EmbeddedStaffMemberPlanningScenarioResponse> getStaffMembersPlanningScenarios(GetStaffMemberPlanningScenarioCollectionRequest request)
        throws ForceAPIException;

    /**
     * Sends a request to the server and creates a staff member planning scenario.
     *
     * @param staffMemberPlanningScenarioProperties The properties of the new staff member planning scenario.
     * @return A {@link StaffMemberPlanningScenarioPage} with the created staff member planning scenario and assignments.
     * @throws ForceAPIException When unable to create the staff member planning scenario.
     */
    StaffMemberPlanningScenarioPage createStaffMemberPlanningScenario(CreateStaffMemberPlanningScenarioPropertiesWSModel staffMemberPlanningScenarioProperties)
        throws ForceAPIException;

    /**
     * Sends a request to the server and gets the staff member shift planning results as response.
     *
     * @param request The request parameters.
     * @return The staff member shift planning results response.
     * @throws ForceAPIException When unable to get the staff member shift planning results.
     */
    StaffMemberShiftPlanningResultResponse getStaffMemberShiftPlanningResult(GetStaffMemberShiftPlanningResultRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and deletes all planning results of a staff member shift.
     *
     * @param request The request parameters.
     * @throws ForceAPIException When unable to delete planning results.
     */
    void deleteStaffMemberShiftPlanningResult(GetStaffMemberShiftPlanningResultRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and creates a new planning result of a staff member shift.
     *
     * @param request The request parameters.
     * @return The created staff member shift planning result response.
     * @throws ForceAPIException When unable to save the planning result.
     */
    StaffMemberShiftPlanningResultResponse saveStaffMemberShiftPlanningResult(CreateStaffMemberShiftPlanningResultRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all planning results of a staff member.
     *
     * @param request The request parameters.
     * @return The page of staff member planning results responses.
     * @throws ForceAPIException When unable to get the planning results.
     */
    Page<StaffMemberShiftPlanningResultResponse> getStaffMemberPlanningResults(GetStaffMemberPlanningResultsRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets all planning results of all staff members.
     *
     * @param request The request parameters.
     * @return The page of staff members planning results responses.
     * @throws ForceAPIException When unable to get the planning results.
     */
    StaffMembersPlanningResultsPage getStaffMembersPlanningResults(CollectionTimestampFilterRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and updates planning results of staff member shifts.
     *
     * @param planningResultAssignments The planning results.
     * @throws ForceAPIException When unable to update the planning results.
     */
    void updateStaffMembersPlanningResult(StaffMemberPlanningResultPropertiesWSModel planningResultAssignments) throws ForceAPIException;
}