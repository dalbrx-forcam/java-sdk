////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 19.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.staffmember;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimeFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberAbsencesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberAssignedWorkplacesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberRecordedActivitiesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberScheduledWorkingTimesRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMemberShiftRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.request.GetStaffMembersShiftsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberAbsenceCollectionPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberAbsenceCollectionResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberRecordedLoginPeriodCollectionPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberRecordedLoginPeriodCollectionResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberScheduledWorkingTimesPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMemberScheduledWorkingTimesResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMembersScheduledWorkingTimesCollectionPage;
import com.forcam.na.ffwebservices.client.api.staffmember.response.StaffMembersScheduledWorkingTimesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceResponseBuilder;
import com.forcam.na.ffwebservices.model.shift.StaffMemberShiftResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests staff members.
 */
public class StaffMemberClient extends AbstractClient implements IStaffMemberClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member endpoint. */
    private final StaffMemberEndpoint mStaffMemberEndpoint;

    /** The staff member response builder. */
    private final IStaffMemberResponseBuilder mStaffMemberResponseBuilder;

    private final IWorkplaceResponseBuilder mWorkplaceResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param staffMemberEndpoint        Staff member endpoint.
     * @param staffMemberResponseBuilder Staff member response builder.
     * @param workplaceResponseBuilder   The workplace response builder.
     */
    @Inject
    public StaffMemberClient(StaffMemberEndpoint staffMemberEndpoint, IStaffMemberResponseBuilder staffMemberResponseBuilder,
                             IWorkplaceResponseBuilder workplaceResponseBuilder) {
        mStaffMemberEndpoint = staffMemberEndpoint;
        mStaffMemberResponseBuilder = staffMemberResponseBuilder;
        mWorkplaceResponseBuilder = workplaceResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<StaffMemberResponse> getStaffMembers(GetStaffMembersRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStaffMemberEndpoint.getStaffMembers(request.getPersonnelNumber(),
                                                                                     request.getLimit(),
                                                                                     request.getOffset(),
                                                                                     request
                                                                                         .embed()
                                                                                         .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<StaffMemberResponse> response = mStaffMemberResponseBuilder.getStaffMemberCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public StaffMemberResponse getStaffMember(GetStaffMemberRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberEndpoint.getStaffMember(request.getId(),
                                                                          request
                                                                              .embed()
                                                                              .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mStaffMemberResponseBuilder.getStaffMemberResponse(responseModel);
    }

    @Override
    public StaffMemberAbsenceCollectionPage getStaffMemberAbsenceTimes(GetStaffMemberAbsencesRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberEndpoint.getStaffMemberAbsenceTimes(request.getStaffMemberId(),
                                                                                      request.getStartDate(),
                                                                                      request.getEndDate(),
                                                                                      request.getLimit(),
                                                                                      request.getPaginationDirection(),
                                                                                      request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final StaffMemberAbsenceCollectionResponse response = mStaffMemberResponseBuilder.getStaffMemberAbsenceCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new StaffMemberAbsenceCollectionPage(this, m, response);
    }

    @Override
    public StaffMemberRecordedLoginPeriodCollectionPage getStaffMemberRecordedLoginPeriods(GetStaffMemberRecordedActivitiesRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberEndpoint.getStaffMemberRecordedLoginPeriods(request.getStaffMemberId(),
                                                                                              request.getStartDate(),
                                                                                              request.getEndDate(),
                                                                                              request.getWorkplaceNumber(),
                                                                                              request.getWorkplaceId(),
                                                                                              request.getLimit(),
                                                                                              request.getPaginationDirection(),
                                                                                              request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final StaffMemberRecordedLoginPeriodCollectionResponse response = mStaffMemberResponseBuilder.getStaffMemberRecordedLoginPeriodsResponse(request,
                                                                                                                                                 responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new StaffMemberRecordedLoginPeriodCollectionPage(this, m, response);
    }

    @Override
    public Page<StaffMemberShiftResponse> getStaffMembersShifts(GetStaffMembersShiftsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStaffMemberEndpoint.getStaffMembersShifts(request.getStaffMemberId(),
                                                                                           request.getPersonnelNumber(),
                                                                                           request.getFirstName(),
                                                                                           request.getLastName(),
                                                                                           request.getStartDate(),
                                                                                           request.getEndDate(),
                                                                                           request.getShiftTypeId(),
                                                                                           request.getLimit(),
                                                                                           request.getPaginationDirection(),
                                                                                           request.getPaginationTimestamp(),
                                                                                           request.getPaginationIdentifier(),
                                                                                           request
                                                                                               .embed()
                                                                                               .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<StaffMemberShiftResponse> response = mStaffMemberResponseBuilder.getStaffMemberShiftCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public StaffMemberShiftResponse getStaffMemberShift(GetStaffMemberShiftRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberEndpoint.getStaffMemberShift(request.getShiftId(),
                                                                               request
                                                                                   .embed()
                                                                                   .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mStaffMemberResponseBuilder.getStaffMemberShiftResponse(responseModel);
    }

    @Override
    public StaffMembersScheduledWorkingTimesCollectionPage getStaffMembersScheduledWorkingTimes(CollectionTimeFilterRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberEndpoint.getStaffMembersScheduledWorkingTimes(request.getStartDate(),
                                                                                                request.getEndDate(),
                                                                                                request.getLimit(),
                                                                                                request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final StaffMembersScheduledWorkingTimesCollectionResponse response = mStaffMemberResponseBuilder.getStaffMembersScheduledWorkingTimesCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new StaffMembersScheduledWorkingTimesCollectionPage(this, m, response);
    }

    @Override
    public StaffMemberScheduledWorkingTimesPage getStaffMemberScheduledWorkingTimes(GetStaffMemberScheduledWorkingTimesRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberEndpoint.getStaffMemberScheduledWorkingTimes(request.getStaffMemberId(),
                                                                                               request.getStartDate(),
                                                                                               request.getEndDate(),
                                                                                               request.getLimit(),
                                                                                               request.getPaginationDirection(),
                                                                                               request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final StaffMemberScheduledWorkingTimesResponse response = mStaffMemberResponseBuilder.getStaffMemberScheduledWorkingTimesResponse(request,
                                                                                                                                          responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new StaffMemberScheduledWorkingTimesPage(this, m, response);
    }

    @Override
    public Page<WorkplaceResponse> getAssignedWorkplaces(GetStaffMemberAssignedWorkplacesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStaffMemberEndpoint.getStaffMemberAssignedWorkplaces(request.getStaffMemberId(),
                                                                                                      request.getLimit(),
                                                                                                      request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<WorkplaceResponse> response = mWorkplaceResponseBuilder.getWorkplaceCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }
}
