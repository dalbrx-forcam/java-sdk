////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.staffmember;

import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimeFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.request.*;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberAbsenceCollectionPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberRecordedLoginPeriodCollectionPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberScheduledWorkingTimesPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMembersScheduledWorkingTimesCollectionPage;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;

/**
 * An interface with methods that request staff members.
 */
public interface IStaffMemberClient {

    /**
     * Sends a request to the server and gets a collection of staff members as response.
     *
     * @param request A collection of parameters.
     * @return The staff member collection response.
     * @throws ForceAPIException When unable to get staff members.
     */
    Page<StaffMemberResponse> getStaffMembers(GetStaffMembersRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets a staff member model as response.
     *
     * @param request A collection of parameters.
     * @return A staff member model.
     * @throws ForceAPIException When unable to get staff member.
     */
    StaffMemberResponse getStaffMember(GetStaffMemberRequest request) throws ForceAPIException;

    /**
     * Gets person absence times for a person.
     *
     * @param request The person absence request.
     * @return The person absence collection response.
     * @throws ForceAPIException When unable to get person absence times.
     */
    StaffMemberAbsenceCollectionPage getStaffMemberAbsenceTimes(GetStaffMemberAbsencesRequest request) throws ForceAPIException;

    /**
     * Gets staff member recorded activities.
     *
     * @param request The request parameter.
     * @return The staff member recorded activities collection response.
     * @throws ForceAPIException When unable to get recorded activities of a staff member.
     */
    StaffMemberRecordedLoginPeriodCollectionPage getStaffMemberRecordedLoginPeriods(GetStaffMemberRecordedActivitiesRequest request) throws ForceAPIException;

    /**
     * Gets a page of staff member shifts.
     *
     * @param request The request parameter.
     * @return Page of staff member shift responses.
     * @throws ForceAPIException When unable to get staff member shifts.
     */
    Page<StaffMemberShiftResponse> getStaffMembersShifts(GetStaffMembersShiftsRequest request) throws ForceAPIException;

    /**
     * Gets a staff member shift.
     *
     * @param request The request parameter.
     * @return The staff member shift response model.
     * @throws ForceAPIException When unable to get staff member shift.
     */
    StaffMemberShiftResponse getStaffMemberShift(GetStaffMemberShiftRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets page of scheduled working times of all staff members as response.
     *
     * @param request The request parameters.
     * @return The staff members scheduled working times collection page.
     * @throws ForceAPIException When unable to get scheduled working times of staff members.
     */
    StaffMembersScheduledWorkingTimesCollectionPage getStaffMembersScheduledWorkingTimes(CollectionTimeFilterRequest request) throws ForceAPIException;

    /**
     * Sends a request to the server and gets page of scheduled working times of a staff member as response.
     *
     * @param request The request parameters.
     * @return The staff member scheduled working times page.
     * @throws ForceAPIException When unable to get scheduled working time of the staff member.
     */
    StaffMemberScheduledWorkingTimesPage getStaffMemberScheduledWorkingTimes(GetStaffMemberScheduledWorkingTimesRequest request) throws ForceAPIException;

    /**
     * Gets the workplaces assigned to a staff member.
     *
     * @param request The request parameters.
     * @return Page of workplaces.
     * @throws ForceAPIException When unable to get workplaces assigned to the staff member.
     */
    Page<WorkplaceResponse> getAssignedWorkplaces(GetStaffMemberAssignedWorkplacesRequest request) throws ForceAPIException;
}