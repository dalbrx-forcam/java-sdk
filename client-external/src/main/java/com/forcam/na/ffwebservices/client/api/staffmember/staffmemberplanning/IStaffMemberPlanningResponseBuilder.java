////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning;

import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningResultsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningScenarioCollectionRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberPlanningScenarioResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberShiftPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMembersPlanningResultsResponse;
import com.forcam.na.ffwebservices.model.staffmember.EmbeddedStaffMemberPlanningScenarioResponse;

/**
 * Staff member planning response builder.
 */
public interface IStaffMemberPlanningResponseBuilder {

    /**
     * Transforms a collection model to a staff member planning scenario collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return An embedded staff member planning scenario collection response.
     */
    CollectionResponse<EmbeddedStaffMemberPlanningScenarioResponse> getStaffMemberPlanningScenarioCollectionResponse(
            GetStaffMemberPlanningScenarioCollectionRequest request, HALCollectionWSModel collectionModel);

    /**
     * Transforms a HAL webservice model into an embedded staff member planning scenario response.
     *
     * @param serverModel The HAL webservice model.
     * @return The embedded staff member planning scenario response.
     */
    EmbeddedStaffMemberPlanningScenarioResponse getEmbeddedStaffMemberPlanningScenarioResponse(HALWSModel serverModel);

    /**
     * Transforms a HAL model into a staff member planning scenario response.
     *
     * @param request     The collection request.
     * @param serverModel The HAL model.
     * @return The staff member planning scenario response.
     */
    StaffMemberPlanningScenarioResponse getStaffMemberPlanningScenarioResponse(CollectionTimestampRequest request, HALWSModel serverModel);

    /**
     * Converts HAL webservice model to staff member shift planning result response.
     *
     * @param serverModel The HAL server model.
     * @return The staff member shift planning result response.
     */
    StaffMemberShiftPlanningResultResponse getStaffMemberShiftPlanningResultResponse(HALWSModel serverModel);

    /**
     * Converts HAL webservice model to staff members planning results response.
     *
     * @param request         The request.
     * @param collectionModel The HAL server model.
     * @return The staff members planning results response.
     */
    StaffMembersPlanningResultsResponse getStaffMembersPlanningResultsResponse(CollectionTimestampRequest request, HALWSModel collectionModel);

    /**
     * Converts a collection model to a staff member shift planning result collection response.
     *
     * @param request         The collection request.
     * @param collectionModel The HAL collection model.
     * @return Collection response of staff member planning result responses.
     */
    CollectionResponse<StaffMemberShiftPlanningResultResponse> getStaffMemberShiftPlanningResultCollection(GetStaffMemberPlanningResultsRequest request,
                                                                                                           HALCollectionWSModel collectionModel);
}