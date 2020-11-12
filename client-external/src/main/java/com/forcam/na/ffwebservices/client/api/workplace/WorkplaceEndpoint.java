////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.definition.TimeBaseFilter;
import com.forcam.na.ffwebservices.model.definition.WorkplaceState;
import com.forcam.na.ffwebservices.model.workplace.CreateWorkplacePredictedMalfunctionScenarioWSModel;
import com.forcam.na.ffwebservices.model.workplace.IWorkplacePaths;
import com.forcam.na.ffwebservices.model.workplace.UpdateWorkplaceRecordedOperatingStateRequestBody;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceType;
import com.forcam.na.ffwebservices.model.workplace.quantity.WorkplaceQuantitySummaryCollectionWSModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface WorkplaceEndpoint {

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES)
    Call<HALCollectionWSModel> getWorkplaces(
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.ERP_CONTEXT_ID)
            String erpContextId,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_ID)
            String workplaceGroupId,
        @Query(IRequestAndQueryParams.WORKPLACE_TYPE)
            WorkplaceType workplaceTypeCode,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}")
    Call<HALWSModel> getWorkplace(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/" + IPathParts.SHIFTS)
    Call<HALCollectionWSModel> getShifts(
        @Query(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_GROUP_NUMBER)
            String workplaceGroupNumber,
        @Query(IRequestAndQueryParams.ERP_CONTEXT_ID)
            String erpContextId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.IS_WORKING_SHIFT)
            Boolean isWorkingShift,
        @Query(IRequestAndQueryParams.SHIFT_TYPE_ID)
            String shiftTypeId,
        @Query(IRequestAndQueryParams.SHIFT_ASSOCIATED_DAY)
            String associatedDay,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.PAGINATION_IDENTIFIER)
            String paginationIdentifier,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/" + IPathParts.SHIFTS + "/{" + IRequestAndQueryParams.SHIFT_ID + "}")
    Call<HALWSModel> getShift(
        @Path(IRequestAndQueryParams.SHIFT_ID)
            String shiftId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IPathParts.RECORDED_OPERATING_STATES)
    Call<HALWSModel> getRecordedOperatingStates(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.TIME_BASE)
            TimeBaseFilter timeBase,
        @Query(IRequestAndQueryParams.WORKPLACE_STATE_ID)
            WorkplaceState workplaceStateId,
        @Query(IRequestAndQueryParams.OPERATING_STATE_CLASS_ID)
            String operatingStateClassId,
        @Query(IRequestAndQueryParams.SHIFT_ID)
            String shiftId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IPathParts.RECORDED_OPERATING_STATES + "/" + IPathParts.UPDATE)
    Call<Void> updateRecordedOperatingState(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Body
            UpdateWorkplaceRecordedOperatingStateRequestBody model);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IPathParts.QUANTITY_SUMMARY)
    Call<WorkplaceQuantitySummaryCollectionWSModel> getQuantitySummary(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.MATERIAL_NUMBER)
            String materialNumber,
        @Query(IRequestAndQueryParams.SHIFT_ID)
            String shiftId);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IPathParts.SCHEDULED_OPERATING_TIMES)
    Call<HALWSModel> getWorkplaceScheduledOperatingTimes(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IPathParts.OPERATING_STATE_SUMMARY)
    Call<HALWSModel> getOperatingStateSummary(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.SHIFT_ID)
            String shiftId,
        @Query(IRequestAndQueryParams.WORKPLACE_STATE_ID)
            WorkplaceState workplaceStateId,
        @Query(IRequestAndQueryParams.OPERATING_STATE_CLASS_ID)
            String operatingStateClassId,
        @Query(IRequestAndQueryParams.TIME_BASE)
            TimeBaseFilter timeBase,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IPathParts.RECORDED_OUTPUT_QUANTITIES)
    Call<HALWSModel> getWorkplaceRecordedOutputQuantities(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.SHIFT_ID)
            String shiftId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IPathParts.RECORDED_OPERATION_PHASES)
    Call<HALWSModel> getWorkplaceRecordedOperationPhases(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IWorkplacePaths.SCHEDULED_MAINTENANCE_TIMES)
    Call<HALWSModel> getWorkplaceScheduledMaintenanceTimes(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IWorkplacePaths.DEVICES)
    Call<HALCollectionWSModel> getWorkplaceDevices(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/" + IWorkplacePaths.PREDICTED_MALFUNCTION_SCENARIOS)
    Call<HALCollectionWSModel> getPredictedMalfunctionScenarios(
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/" + IWorkplacePaths.PREDICTED_MALFUNCTION_SCENARIOS + "/{" + IRequestAndQueryParams.PREDICTED_MALFUNCTION_SCENARIO_ID +
         "}")
    Call<HALWSModel> getPredictedMalfunctionScenario(
        @Path(IRequestAndQueryParams.PREDICTED_MALFUNCTION_SCENARIO_ID)
            String predictedMalfunctionScenarioId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @POST(IWorkplacePaths.WORKPLACES + "/" + IWorkplacePaths.PREDICTED_MALFUNCTION_SCENARIOS)
    Call<HALWSModel> savePredictedMalfunctionScenario(
        @Body
            CreateWorkplacePredictedMalfunctionScenarioWSModel predictedMalfunctionScenario);

    @Headers({"Content-Type: application/json","Accept: application/hal+json"} )
    @GET(IWorkplacePaths.WORKPLACES + "/{" + IRequestAndQueryParams.WORKPLACE_ID + "}/" + IPathParts.USER_FIELDS)
    Call<HALWSModel> getWorkplaceUserFields(
        @Path(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);
}
