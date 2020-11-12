////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.staffmember;

import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimeFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberAbsencesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberRecordedActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersShiftsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberAbsenceCollectionResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberRecordedLoginPeriodCollectionResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberScheduledWorkingTimesResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMembersScheduledWorkingTimesCollectionResponse;
import com.forcam.na.ffwebservices.model.collection.AbstractCollectionWSModel;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberResponse;

/**
 * Contains methods for building responses for staff members.
 */
public interface IStaffMemberResponseBuilder {

    /**
     * Transforms a collection model to a staff member collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A staff member collection response.
     */
    CollectionResponse<StaffMemberResponse> getStaffMemberCollectionResponse(GetStaffMembersRequest request, AbstractCollectionWSModel collectionModel);

    /**
     * Converts HAL model to a staff member model.
     *
     * @param serverModel The server model.
     * @return A staff member model.
     */
    StaffMemberResponse getStaffMemberResponse(HALWSModel serverModel);

    /**
     * Maps HAL model to person absence collection response.
     *
     * @param request           The request.
     * @param collectionWSModel The HAL model.
     * @return The person absence collection response.
     */
    StaffMemberAbsenceCollectionResponse getStaffMemberAbsenceCollectionResponse(GetStaffMemberAbsencesRequest request, HALWSModel collectionWSModel);

    /**
     * Converts HAL webservice model to staff member recorded activities response.
     *
     * @param request         The request.
     * @param collectionModel The HAL model.
     * @return The staff member recorded activities collection response.
     */
    StaffMemberRecordedLoginPeriodCollectionResponse getStaffMemberRecordedLoginPeriodsResponse(GetStaffMemberRecordedActivitiesRequest request,
                                                                                                HALWSModel collectionModel);

    /**
     * Converts a HAL model to a staff member shift response.
     *
     * @param serverModel The HAL server model.
     * @return The staff member shift response.
     */
    StaffMemberShiftResponse getStaffMemberShiftResponse(HALWSModel serverModel);

    /**
     * Transforms a collection model to a staff member shift collection response.
     *
     * @param request         The request.
     * @param collectionModel A collection model.
     * @return A staff member shift collection response.
     */
    CollectionResponse<StaffMemberShiftResponse> getStaffMemberShiftCollectionResponse(GetStaffMembersShiftsRequest request,
                                                                                       AbstractCollectionWSModel collectionModel);

    /**
     * Converts HAL webservice model to staff members scheduled working times collection response.
     *
     * @param request         The request.
     * @param collectionModel The HAL server model.
     * @return The staff members scheduled working times collection response.
     */
    StaffMembersScheduledWorkingTimesCollectionResponse getStaffMembersScheduledWorkingTimesCollectionResponse(CollectionTimeFilterRequest request,
                                                                                                               HALWSModel collectionModel);

    /**
     * Converts HAL webservice model to staff member scheduled working times response.
     *
     * @param request         The request.
     * @param collectionModel The HAL server model.
     * @return The staff member scheduled working times response.
     */
    StaffMemberScheduledWorkingTimesResponse getStaffMemberScheduledWorkingTimesResponse(CollectionTimestampRequest request, HALWSModel collectionModel);
}