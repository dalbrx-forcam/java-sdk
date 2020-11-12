////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetOperationPlanningResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetOperationsForecastResultsRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetOperationsPlanningResultsRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetPlanningScenarioRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetPlanningScenariosRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.SetOperationForecastResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.SetOperationPlanningResultRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.UpdateOperationForecastResultsRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationAssignmentCollectionResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationForecastResultPage;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationForecastResultResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningScenarioPage;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationsPlanningResultPage;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.PlanningScenarioWithAssignmentsResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningResultBodyWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenariosBodyWSModel;
import com.forcam.na.ffwebservices.model.planningscenarioassignment.PlanningScenarioResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Planning scenario assignment client.
 */
public class OperationPlanningClient extends AbstractClient implements IOperationPlanningClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The machine endpoint. */
    private final OperationPlanningEndpoint mEndpoint;

    /** The machine response builder. */
    private final IPlanningScenarioResponseBuilder mResponseBuilder;

    /** The operation planning response builder. */
    private final IOperationPlanningResponseBuilder mOperationPlanningResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param operationPlanningEndpoint        Planning scenario endpoint.
     * @param planningScenarioResponseBuilder  Planning scenario response builder.
     * @param operationPlanningResponseBuilder The operation planning response builder.
     */
    @Inject
    public OperationPlanningClient(OperationPlanningEndpoint operationPlanningEndpoint, IPlanningScenarioResponseBuilder planningScenarioResponseBuilder,
                                   OperationPlanningResponseBuilder operationPlanningResponseBuilder) {
        mEndpoint = operationPlanningEndpoint;
        mResponseBuilder = planningScenarioResponseBuilder;
        mOperationPlanningResponseBuilder = operationPlanningResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<PlanningScenarioResponse> getPlanningScenarios(GetPlanningScenariosRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mEndpoint.getPlanningScenarios(request.getStartDate(),
                                                                               request.getEndDate(),
                                                                               request.getLimit(),
                                                                               request.getPaginationDirection(),
                                                                               request.getPaginationTimestamp());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<PlanningScenarioResponse> response = mResponseBuilder.getPlanningScenarioCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public OperationPlanningScenarioPage getPlanningScenario(GetPlanningScenarioRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mEndpoint.getPlanningScenario(request.getPlanningScenarioId(), request.getLimit(), request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final PlanningScenarioWithAssignmentsResponse response = mResponseBuilder.getPlanningScenarioWithAssignmentsResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationPlanningScenarioPage(this, m, response);
    }

    @Override
    public OperationPlanningScenarioPage setPlanningScenario(OperationPlanningScenariosBodyWSModel request) throws ForceAPIException {
        final Call<HALWSModel> call = mEndpoint.setPlanningScenario(request);
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final PlanningScenarioWithAssignmentsResponse response = mResponseBuilder.getPlanningScenarioWithAssignmentsResponse(new CollectionRequest(),
                                                                                                                             responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationPlanningScenarioPage(this, m, response);
    }

    @Override
    public OperationPlanningResultResponse getOperationPlanningResult(GetOperationPlanningResultRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mEndpoint.getOperationPlanningResult(request.getOperationId(),
                                                                           request
                                                                               .embed()
                                                                               .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mOperationPlanningResponseBuilder.getOperationPlanningResultResponse(responseModel);
    }

    @Override
    public OperationsPlanningResultPage getOperationsPlanningResults(GetOperationsPlanningResultsRequest request) throws ForceAPIException {
        final Call<OperationAssignmentCollectionServerModel> call = mEndpoint.getOperationsPlanningResults(request.getStartDate(),
                                                                                                           request.getEndDate(),
                                                                                                           request.getWorkplaceGroupNumber(),
                                                                                                           request.getWorkplaceNumber(),
                                                                                                           request.getErpContextId(),
                                                                                                           request.getWorkplaceGroupId(),
                                                                                                           request.getLimit(),
                                                                                                           request.getOffset());
        final OperationAssignmentCollectionServerModel responseModel = this.getResponseModel(request, call);
        final OperationAssignmentCollectionResponse<OperationPlanningResultResponse> response = mOperationPlanningResponseBuilder.getOperationPlanningResultCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationsPlanningResultPage(this, m, response);
    }

    @Override
    public void updateOperationsPlanningResults(OperationPlanningResultBodyWSModel request) throws ForceAPIException {
        final Call<Void> call = mEndpoint.updateOperationsPlanningResults(request);
        this.executeCall(request, call);
    }

    @Override
    public OperationPlanningResultResponse saveOperationPlanningResult(SetOperationPlanningResultRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mEndpoint.saveOperationPlanningResult(request.getPlanningResult(), request.getOperationId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mOperationPlanningResponseBuilder.getOperationPlanningResultResponse(responseModel);
    }

    @Override
    public void deleteOperationPlanningResult(String operationId) throws ForceAPIException {
        final Call<Void> call = mEndpoint.deleteOperationPlanningResult(operationId);
        this.executeCall(operationId, call);
    }

    @Override
    public OperationForecastResultResponse getOperationForecastResult(String operationId) throws ForceAPIException {
        final Call<HALWSModel> call = mEndpoint.getOperationForecastResult(operationId);
        final HALWSModel responseModel = this.getResponseModel(operationId, call);
        return mOperationPlanningResponseBuilder.getOperationForecastResultResponse(responseModel);
    }

    @Override
    public OperationForecastResultPage getOperationsForecastResults(GetOperationsForecastResultsRequest request) throws ForceAPIException {
        final Call<OperationAssignmentCollectionServerModel> call = mEndpoint.getOperationsForecastResults(request.getStartDate(),
                                                                                                           request.getEndDate(),
                                                                                                           request.getWorkplaceGroupNumber(),
                                                                                                           request.getWorkplaceNumber(),
                                                                                                           request.getErpContextId(),
                                                                                                           request.getWorkplaceGroupId(),
                                                                                                           request.isUseOriginalValues(),
                                                                                                           request.getLimit(),
                                                                                                           request.getOffset());
        final OperationAssignmentCollectionServerModel responseModel = this.getResponseModel(request, call);
        final OperationAssignmentCollectionResponse<OperationForecastResultResponse> response = mOperationPlanningResponseBuilder.getOperationForecastCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationForecastResultPage(this, m, response);
    }

    @Override
    public OperationForecastResultResponse saveOperationForecastResult(SetOperationForecastResultRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mEndpoint.saveOperationForecastResult(request.getForecastResult(), request.getOperationId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mOperationPlanningResponseBuilder.getOperationForecastResultResponse(responseModel);
    }

    @Override
    public void updateOperationForecastResults(UpdateOperationForecastResultsRequest request) throws ForceAPIException {
        final Call<Void> call = mEndpoint.updateOperationForecastResult(request.getForecastResults());
        this.executeCall(request, call);
    }

    @Override
    public void deleteOperationForecastResult(String operationId) throws ForceAPIException {
        final Call<Void> call = mEndpoint.deleteOperationForecastResult(operationId);
        this.executeCall(operationId, call);
    }
}