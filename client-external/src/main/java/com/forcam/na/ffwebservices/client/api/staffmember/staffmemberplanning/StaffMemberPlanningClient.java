////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 09.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampFilterRequest;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.*;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.*;
import com.forcam.na.ffwebservices.model.staffmember.CreateStaffMemberPlanningScenarioPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.EmbeddedStaffMemberPlanningScenarioResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningResultPropertiesWSModel;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Client to requests staff member planning actions.
 */
public class StaffMemberPlanningClient extends AbstractClient implements IStaffMemberPlanningClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The staff member planning endpoint. */
    private StaffMemberPlanningEndpoint mStaffMemberPlanningEndpoint;

    /** Staff member planning response builder. */
    private IStaffMemberPlanningResponseBuilder mStaffMemberPlanningResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates new instance.
     *
     * @param staffMemberPlanningEndpoint        The staff member planning endpoint.
     * @param staffMemberPlanningResponseBuilder The staff member planning response builder.
     */
    @Inject
    public StaffMemberPlanningClient(StaffMemberPlanningEndpoint staffMemberPlanningEndpoint,
                                     IStaffMemberPlanningResponseBuilder staffMemberPlanningResponseBuilder) {
        mStaffMemberPlanningEndpoint = staffMemberPlanningEndpoint;
        mStaffMemberPlanningResponseBuilder = staffMemberPlanningResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public StaffMemberPlanningScenarioPage getStaffMemberPlanningScenario(GetStaffMemberPlanningScenarioRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberPlanningEndpoint.getStaffMemberPlanningScenario(request.getStaffMemberPlanningScenarioId(),
                                                                                                  request.getStartDate(),
                                                                                                  request.getEndDate(),
                                                                                                  request.getLimit(),
                                                                                                  request.getPaginationDirection(),
                                                                                                  request.getPaginationTimestamp());

        final HALWSModel responseModel = this.getResponseModel(request, call);
        final StaffMemberPlanningScenarioResponse staffMemberPlanningScenarioResponse = mStaffMemberPlanningResponseBuilder.getStaffMemberPlanningScenarioResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new StaffMemberPlanningScenarioPage(this, m, staffMemberPlanningScenarioResponse);
    }

    @Override
    public Page<EmbeddedStaffMemberPlanningScenarioResponse> getStaffMembersPlanningScenarios(GetStaffMemberPlanningScenarioCollectionRequest request)
        throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStaffMemberPlanningEndpoint.getStaffMembersPlanningScenarios(request.getStartDate(),
                                                                                                              request.getEndDate(),
                                                                                                              request.getLimit(),
                                                                                                              request.getPaginationDirection(),
                                                                                                              request.getPaginationTimestamp());

        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<EmbeddedStaffMemberPlanningScenarioResponse> response = mStaffMemberPlanningResponseBuilder.getStaffMemberPlanningScenarioCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public StaffMemberPlanningScenarioPage createStaffMemberPlanningScenario(
        CreateStaffMemberPlanningScenarioPropertiesWSModel staffMemberPlanningScenarioProperties) throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberPlanningEndpoint.saveStaffMemberPlanningScenario(staffMemberPlanningScenarioProperties);
        final HALWSModel responseModel = this.getResponseModel(staffMemberPlanningScenarioProperties, call);
        final StaffMemberPlanningScenarioResponse staffMemberPlanningScenarioResponse = mStaffMemberPlanningResponseBuilder.getStaffMemberPlanningScenarioResponse(
            new CollectionTimestampRequest(),
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new StaffMemberPlanningScenarioPage(this, m, staffMemberPlanningScenarioResponse);
    }

    @Override
    public StaffMemberShiftPlanningResultResponse getStaffMemberShiftPlanningResult(GetStaffMemberShiftPlanningResultRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberPlanningEndpoint.getStaffMemberShiftPlanningResult(request.getStaffMemberId(),
                                                                                                     request.getStaffMemberShiftId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mStaffMemberPlanningResponseBuilder.getStaffMemberShiftPlanningResultResponse(responseModel);
    }

    @Override
    public void deleteStaffMemberShiftPlanningResult(GetStaffMemberShiftPlanningResultRequest request) throws ForceAPIException {
        final Call<Void> call = mStaffMemberPlanningEndpoint.deleteStaffMemberShiftPlanningResult(request.getStaffMemberId(), request.getStaffMemberShiftId());
        this.executeCall(request, call);
    }

    @Override
    public StaffMemberShiftPlanningResultResponse saveStaffMemberShiftPlanningResult(CreateStaffMemberShiftPlanningResultRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberPlanningEndpoint.saveStaffMemberShiftPlanningResult(request.getStaffMemberId(),
                                                                                                      request.getStaffMemberShiftId(),
                                                                                                      request.getStaffMemberPlanningResultProperties());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mStaffMemberPlanningResponseBuilder.getStaffMemberShiftPlanningResultResponse(responseModel);
    }

    @Override
    public Page<StaffMemberShiftPlanningResultResponse> getStaffMemberPlanningResults(GetStaffMemberPlanningResultsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStaffMemberPlanningEndpoint.getStaffMemberPlanningResults(request.getStaffMemberId(),
                                                                                                           request.getStartDate(),
                                                                                                           request.getEndDate(),
                                                                                                           request.getLimit(),
                                                                                                           request.getPaginationDirection(),
                                                                                                           request.getPaginationTimestamp(),
                                                                                                           request.getPaginationIdentifier(),
                                                                                                           request
                                                                                                               .embed()
                                                                                                               .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<StaffMemberShiftPlanningResultResponse> response = mStaffMemberPlanningResponseBuilder.getStaffMemberShiftPlanningResultCollection(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public StaffMembersPlanningResultsPage getStaffMembersPlanningResults(CollectionTimestampFilterRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStaffMemberPlanningEndpoint.getStaffMembersPlanningResults(request.getStartDate(),
                                                                                                  request.getEndDate(),
                                                                                                  request.getLimit(),
                                                                                                  request.getPaginationDirection(),
                                                                                                  request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final StaffMembersPlanningResultsResponse response = mStaffMemberPlanningResponseBuilder.getStaffMembersPlanningResultsResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new StaffMembersPlanningResultsPage(this, m, response);
    }

    @Override
    public void updateStaffMembersPlanningResult(StaffMemberPlanningResultPropertiesWSModel planningResultAssignments) throws ForceAPIException {
        final Call<Void> call = mStaffMemberPlanningEndpoint.updateStaffMembersPlanningResult(planningResultAssignments);
        this.executeCall(planningResultAssignments, call);
    }
}