////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.staffmember;

import com.forcam.na.common.webserviceaccess.requestparams.PaginationDirection;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.IPathParts;
import com.forcam.na.ffwebservices.model.IRequestAndQueryParams;
import com.forcam.na.ffwebservices.model.staffmember.IStaffMemberPaths;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.Date;

/**
 * An interface with methods for creating calls that can be sent to the server.
 */
public interface StaffMemberEndpoint {

    @GET(IStaffMemberPaths.STAFF_MEMBERS)
    Call<HALCollectionWSModel> getStaffMembers(
        @Query(IRequestAndQueryParams.STAFF_NUMBER)
            String personnelNumber,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}")
    Call<HALWSModel> getStaffMember(
        @Path(IRequestAndQueryParams.STAFF_MEMBER_ID)
            String staffMemberId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}/" + IStaffMemberPaths.ABSENCE_TIMES)
    Call<HALWSModel> getStaffMemberAbsenceTimes(
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
            Date paginationTimestamp);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}/" + IStaffMemberPaths.RECORDED_LOGIN_PERIODS)
    Call<HALWSModel> getStaffMemberRecordedLoginPeriods(
        @Path(IRequestAndQueryParams.STAFF_MEMBER_ID)
            String staffMemberId,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.WORKPLACE_NUMBER)
            String workplaceNumber,
        @Query(IRequestAndQueryParams.WORKPLACE_ID)
            String workplaceId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.PAGINATION_DIRECTION)
            PaginationDirection paginationDirection,
        @Query(IRequestAndQueryParams.PAGINATION_TIMESTAMP)
            Date paginationTimestamp);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/" + IPathParts.SHIFTS)
    Call<HALCollectionWSModel> getStaffMembersShifts(
        @Query(IRequestAndQueryParams.STAFF_MEMBER_ID)
            String staffMemberId,
        @Query(IRequestAndQueryParams.STAFF_NUMBER)
            String staffNumber,
        @Query(IRequestAndQueryParams.FIRST_NAME)
            String firstName,
        @Query(IRequestAndQueryParams.LAST_NAME)
            String lastName,
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.SHIFT_TYPE_ID)
            String shiftTypeId,
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

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/" + IPathParts.SHIFTS + "/{" + IRequestAndQueryParams.SHIFT_ID + "}")
    Call<HALWSModel> getStaffMemberShift(
        @Path(IRequestAndQueryParams.SHIFT_ID)
            String shiftId,
        @Query(IRequestAndQueryParams.EMBED)
            String embed);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}/" + IStaffMemberPaths.SCHEDULED_WORKING_TIMES)
    Call<HALWSModel> getStaffMemberScheduledWorkingTimes(
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
            Date paginationTimestamp);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/" + IStaffMemberPaths.SCHEDULED_WORKING_TIMES)
    Call<HALWSModel> getStaffMembersScheduledWorkingTimes(
        @Query(IRequestAndQueryParams.START_DATE)
            Date startDate,
        @Query(IRequestAndQueryParams.END_DATE)
            Date endDate,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);

    @GET(IStaffMemberPaths.STAFF_MEMBERS + "/{" + IRequestAndQueryParams.STAFF_MEMBER_ID + "}/" + IStaffMemberPaths.ASSIGNED_WORKPLACES)
    Call<HALCollectionWSModel> getStaffMemberAssignedWorkplaces(
        @Path(IRequestAndQueryParams.STAFF_MEMBER_ID)
            String staffMemberId,
        @Query(IRequestAndQueryParams.LIMIT)
            int limit,
        @Query(IRequestAndQueryParams.OFFSET)
            int offset);
}