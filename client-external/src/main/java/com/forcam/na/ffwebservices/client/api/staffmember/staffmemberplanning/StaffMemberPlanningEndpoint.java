////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 09.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.staffmember.CreateStaffMemberPlanningScenarioPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.IStaffMemberPaths;
import com.forcam.na.ffwebservices.model.staffmember.IStaffMemberPlanningPaths;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningResultPropertiesWSModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface StaffMemberPlanningEndpoint {

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/" + IStaffMemberPlanningPaths.PLANNING_SCENARIOS + "/{" + IRequestAndQueryParams.PLANNING_SCENARIO_ID + "}")
    Call<HALWSModel> getStaffMemberPlanningScenario(
        @Path(IRequestAndQueryParams.PLANNING_SCENARIO_ID)
            String planningScenarioId,
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

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/" + IStaffMemberPlanningPaths.PLANNING_SCENARIOS)
    Call<HALCollectionWSModel> getStaffMembersPlanningScenarios(
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

    @POST(IStaffMemberPaths.STAFF_MEMBERS + "/" + IStaffMemberPlanningPaths.PLANNING_SCENARIOS)
    Call<HALWSModel> saveStaffMemberPlanningScenario(
        @Body
            CreateStaffMemberPlanningScenarioPropertiesWSModel planningScenarioProperties);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}/" + IPathParts.SHIFTS + "/{" + IRequestAndQueryParams.SHIFT_ID +
         "}/" + IStaffMemberPlanningPaths.PLANNING_RESULT)
    Call<HALWSModel> getStaffMemberShiftPlanningResult(
        @Path(IRequestAndQueryParams.STAFF_MEMBER_ID)
            String staffMemberId,
        @Path(IRequestAndQueryParams.SHIFT_ID)
            String shiftId);

    @DELETE(
        IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}/" + IPathParts.SHIFTS + "/{" + IRequestAndQueryParams.SHIFT_ID +
        "}/" + IStaffMemberPlanningPaths.PLANNING_RESULT)
    Call<Void> deleteStaffMemberShiftPlanningResult(
        @Path(IRequestAndQueryParams.STAFF_MEMBER_ID)
            String staffMemberId,
        @Path(IRequestAndQueryParams.SHIFT_ID)
            String shiftId);

    @PUT(IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}/" + IPathParts.SHIFTS + "/{" + IRequestAndQueryParams.SHIFT_ID +
         "}/" + IStaffMemberPlanningPaths.PLANNING_RESULT)
    Call<HALWSModel> saveStaffMemberShiftPlanningResult(
        @Path(IRequestAndQueryParams.STAFF_MEMBER_ID)
            String staffMemberId,
        @Path(IRequestAndQueryParams.SHIFT_ID)
            String shiftId,
        @Body
            StaffMemberPlanningResultPropertiesWSModel planningResult);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}/" + IStaffMemberPlanningPaths.PLANNING_RESULTS)
    Call<HALCollectionWSModel> getStaffMemberPlanningResults(
        @Path(IRequestAndQueryParams.STAFF_MEMBER_ID)
            String staffMemberId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
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

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/" + IStaffMemberPlanningPaths.PLANNING_RESULTS)
    Call<HALWSModel> getStaffMembersPlanningResults(
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

    @POST(IStaffMemberPaths.STAFF_MEMBERS + "/" + IStaffMemberPlanningPaths.PLANNING_RESULTS + "/" + IPathParts.UPDATE)
    Call<Void> updateStaffMembersPlanningResult(
        @Body
            StaffMemberPlanningResultPropertiesWSModel planningResultAssignments);
}