////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.operation;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationComponentsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationCurrentProductionDataRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationOperatingStateSummaryRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationProductionResourcesAndToolsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOperatingStatesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOperationPhasesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRecordedOutputQuantitiesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationScheduledDatesRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationSpecificationRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationUserFieldsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.GetOperationsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SearchOperationsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SetOperationPhaseRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.SetOperationQualityDetailsRequest;
import com.forcam.na.ffwebservices.client.api.operation.request.UpdateOperationRecordedOperatingStateRequest;
import com.forcam.na.ffwebservices.client.api.operation.response.OperatingQuantitySummaryCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationComponentCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationComponentCollectionResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationManufacturingVariantsResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationOperatingStateSummaryPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationOperatingStateSummaryResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationQuantitySummaryCollectionResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOperationPhasePage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOperationPhasesResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOutputQuantitiesPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationRecordedOutputQuantitiesResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationUserFieldCollectionPage;
import com.forcam.na.ffwebservices.client.api.operation.response.OperationUserFieldCollectionResponse;
import com.forcam.na.ffwebservices.client.api.operation.response.RecordedOperatingStateCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.recordedoperatingstate.IRecordedOperatingStateResponseBuilder;
import com.forcam.na.ffwebservices.client.api.recordedoperatingstate.RecordedOperatingStateCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.IWorkplaceResponseBuilder;
import com.forcam.na.ffwebservices.model.operation.OperationCurrentProductionDataResponse;
import com.forcam.na.ffwebservices.model.operation.OperationResponse;
import com.forcam.na.ffwebservices.model.operation.OperationScheduledDatesResponse;
import com.forcam.na.ffwebservices.model.operation.OperationSpecificationResponse;
import com.forcam.na.ffwebservices.model.operation.ProductionResourceToolResponse;
import com.forcam.na.ffwebservices.model.operation.quantity.OperationQuantitySummaryCollectionWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Searches for operations.
 */
public class OperationClient extends AbstractClient implements IOperationClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The operation endpoint. */
    private final OperationEndpoint mOperationEndpoint;

    /** The operation response builder. */
    private final IOperationResponseBuilder mOperationResponseBuilder;

    /** The scheduled dates response builder. */
    private final IOperationScheduledDatesResponseBuilder mScheduledDatesResponseBuilder;

    /** The specification response builder. */
    private final IOperationSpecificationResponseBuilder mSpecificationResponseBuilder;

    /** The production resource tool response builder. */
    private final IOperationProductionResourceToolResponseBuilder mProductionResourceToolResponseBuilder;

    /** The recorded operating state response builder. */
    private final IRecordedOperatingStateResponseBuilder mRecordedOperatingStateResponseBuilder;

    /** The quantity summary response builder. */
    private final IOperationQuantitySummaryResponseBuilder mQuantitySummaryResponseBuilder;

    /** The workplace response builder. */
    private final IWorkplaceResponseBuilder mWorkplaceResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param recordedOperatingStateResponseBuilder Recorded operating state response builder.
     * @param productionResourceToolResponseBuilder Production resource tool response builder.
     * @param quantitySummaryResponseBuilder        Quantity summary response builder.
     * @param scheduledDatesResponseBuilder         Scheduled dates response builder.
     * @param specificationResponseBuilder          Specification response builder.
     * @param workplaceResponseBuilder              The workplace response builder.
     * @param operationResponseBuilder              Operation response builder.
     * @param operationEndpoint                     Operation endpoint.
     */
    @Inject
    public OperationClient(OperationEndpoint operationEndpoint, IOperationResponseBuilder operationResponseBuilder,
                           IOperationScheduledDatesResponseBuilder scheduledDatesResponseBuilder,
                           IOperationSpecificationResponseBuilder specificationResponseBuilder,
                           IOperationProductionResourceToolResponseBuilder productionResourceToolResponseBuilder,
                           IRecordedOperatingStateResponseBuilder recordedOperatingStateResponseBuilder,
                           IOperationQuantitySummaryResponseBuilder quantitySummaryResponseBuilder, IWorkplaceResponseBuilder workplaceResponseBuilder) {
        mOperationEndpoint = operationEndpoint;
        mOperationResponseBuilder = operationResponseBuilder;
        mScheduledDatesResponseBuilder = scheduledDatesResponseBuilder;
        mSpecificationResponseBuilder = specificationResponseBuilder;
        mProductionResourceToolResponseBuilder = productionResourceToolResponseBuilder;
        mRecordedOperatingStateResponseBuilder = recordedOperatingStateResponseBuilder;
        mQuantitySummaryResponseBuilder = quantitySummaryResponseBuilder;
        mWorkplaceResponseBuilder = workplaceResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<OperationResponse> searchOperations(SearchOperationsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mOperationEndpoint.searchOperations(request.getSearchOperations(),
                                                                                    request.getLimit(),
                                                                                    request.getPaginationDirection(),
                                                                                    request.getPaginationTimestamp(),
                                                                                    request.getPaginationIdentifier(),
                                                                                    request
                                                                                        .embed()
                                                                                        .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<OperationResponse> response = mOperationResponseBuilder.getOperationCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public OperationResponse getOperation(GetOperationRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getOperation(request.getId(),
                                                                      request
                                                                          .embed()
                                                                          .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mOperationResponseBuilder.getOperationResponse(responseModel);
    }

    @Override
    public OperationScheduledDatesResponse getScheduledDates(GetOperationScheduledDatesRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getScheduledDates(request.getOperationId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mScheduledDatesResponseBuilder.getOperationScheduledDatesResponse(responseModel);
    }

    @Override
    public OperationSpecificationResponse getSpecification(GetOperationSpecificationRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getSpecification(request.getOperationId(),
                                                                          request
                                                                              .embed()
                                                                              .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mSpecificationResponseBuilder.getOperationSpecificationResponse(responseModel);
    }

    @Override
    public Page<ProductionResourceToolResponse> getProductionResourcesAndTools(GetOperationProductionResourcesAndToolsRequest request)
        throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mOperationEndpoint.getProductionResourcesAndTools(request.getOperationId(),
                                                                                                  request.getType(),
                                                                                                  request.getGroup(),
                                                                                                  request.getLimit(),
                                                                                                  request.getOffset(),
                                                                                                  request
                                                                                                      .embed()
                                                                                                      .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<ProductionResourceToolResponse> response = mProductionResourceToolResponseBuilder.getOperationProductionResourceToolCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public RecordedOperatingStateCollectionPage getRecordedOperatingStates(GetOperationRecordedOperatingStatesRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getRecordedOperatingStates(request.getOperationId(),
                                                                                    request.getWorkplaceStateId(),
                                                                                    request.getOperatingStateClassId(),
                                                                                    request.getLimit(),
                                                                                    request.getPaginationDirection(),
                                                                                    request.getPaginationTimestamp(),
                                                                                    request.getStartDate(),
                                                                                    request.getEndDate(),
                                                                                    request.getTimeBase(),
                                                                                    request
                                                                                        .embed()
                                                                                        .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final RecordedOperatingStateCollectionResponse response = mRecordedOperatingStateResponseBuilder.getRecordedOperatingStateCollectionResponse(request,
                                                                                                                                                     responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new RecordedOperatingStateCollectionPage(this, m, response);
    }

    @Override
    public Page<OperationResponse> getOperations(GetOperationsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mOperationEndpoint.getOperations(request.getProductionOrderNumber(),
                                                                                 request.getProductionOrderSplit(),
                                                                                 request.getOperationNumber(),
                                                                                 request.getOperationSplit(),
                                                                                 request.getMaterialNumber(),
                                                                                 request.getWorkplaceNumber(),
                                                                                 request.getWorkplaceId(),
                                                                                 request.getStartDate(),
                                                                                 request.getEndDate(),
                                                                                 request.getOperationPhaseId(),
                                                                                 request.getProductionOrderId(),
                                                                                 request.isPlannable(),
                                                                                 request.isDispatched(),
                                                                                 request.isInProgress(),
                                                                                 request.getLimit(),
                                                                                 request.getPaginationDirection(),
                                                                                 request.getPaginationTimestamp(),
                                                                                 request.getPaginationIdentifier(),
                                                                                 request
                                                                                     .embed()
                                                                                     .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<OperationResponse> response = mOperationResponseBuilder.getOperationCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public OperatingQuantitySummaryCollectionPage getQuantitySummary(GetOperationQuantitySummaryRequest request) throws ForceAPIException {
        final Call<OperationQuantitySummaryCollectionWSModel> call = mOperationEndpoint.getQuantitySummary(request.getOperationId(),
                                                                                                           request.getLimit(),
                                                                                                           request.getOffset());
        final OperationQuantitySummaryCollectionWSModel responseModel = this.getResponseModel(request, call);
        final OperationQuantitySummaryCollectionResponse response = mQuantitySummaryResponseBuilder.getOperationQuantitySummaryCollectionResponse(request,
                                                                                                                                                  responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperatingQuantitySummaryCollectionPage(this, m, response);
    }

    @Override
    public void setQualityDetails(SetOperationQualityDetailsRequest request) throws ForceAPIException {
        final Call<Void> call = mOperationEndpoint.setQualityDetails(request.getOperationQualityDetail(), request.getOperationId(), request.isAsync());
        this.executeCall(request, call);
    }

    @Override
    public OperationResponse setOperationPhase(SetOperationPhaseRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.setOperationPhase(request.getOperationPhase(),
                                                                           request.getOperationId(),
                                                                           request.getOperationPhaseId(),
                                                                           request.isAsync());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mOperationResponseBuilder.getOperationResponse(responseModel);
    }

    @Override
    public OperationUserFieldCollectionPage getOperationUserFields(GetOperationUserFieldsRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getOperationUserFields(request.getOperationId(),
                                                                                request.getLimit(),
                                                                                request.getOffset(),
                                                                                request
                                                                                    .embed()
                                                                                    .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final OperationUserFieldCollectionResponse response = mOperationResponseBuilder.getOperationUserFieldCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationUserFieldCollectionPage(this, m, response);

    }

    @Override
    public OperationComponentCollectionPage getOperationComponents(GetOperationComponentsRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getOperationComponents(request.getOperationId(),
                                                                                request.getLimit(),
                                                                                request.getOffset(),
                                                                                request
                                                                                    .embed()
                                                                                    .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final OperationComponentCollectionResponse response = mOperationResponseBuilder.getOperationComponentCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationComponentCollectionPage(this, m, response);
    }

    @Override
    public OperationManufacturingVariantsResponse getOperationManufacturingVariants(String operationId) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getOperationManufacturingVariants(operationId);
        final HALWSModel responseModel = this.getResponseModel(operationId, call);
        return mOperationResponseBuilder.getOperationManufacturingVariantsResponse(responseModel);
    }

    @Override
    public OperationRecordedOperationPhasePage getRecordedOperationPhases(GetOperationRecordedOperationPhasesRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getRecordedOperationPhases(request.getOperationId(),
                                                                                    request.getLimit(),
                                                                                    request.getStartDate(),
                                                                                    request.getEndDate(),
                                                                                    request.getPaginationDirection(),
                                                                                    request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final OperationRecordedOperationPhasesResponse response = mOperationResponseBuilder.getOperationRecordedOperationPhasesResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationRecordedOperationPhasePage(this, m, response);
    }

    @Override
    public OperationOperatingStateSummaryPage getOperatingStateSummary(GetOperationOperatingStateSummaryRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getOperatingStateSummary(request.getOperationId(),
                                                                                  request.getWorkplaceStateId(),
                                                                                  request.getOperatingStateClassId(),
                                                                                  request.getLimit(),
                                                                                  request.getOffset(),
                                                                                  request.getTimeBase());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final OperationOperatingStateSummaryResponse response = mOperationResponseBuilder.getOperationOperatingStateSummaryResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationOperatingStateSummaryPage(this, m, response);

    }

    @Override
    public OperationRecordedOutputQuantitiesPage getRecordedOutputQuantities(GetOperationRecordedOutputQuantitiesRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getRecordedOutputQuantities(request.getOperationId(),
                                                                                     request.getQualityTypeId(),
                                                                                     request.getLimit(),
                                                                                     request.getPaginationDirection(),
                                                                                     request.getPaginationTimestamp(),
                                                                                     request.getStartDate(),
                                                                                     request.getEndDate());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final OperationRecordedOutputQuantitiesResponse response = mOperationResponseBuilder.getOperationRecordedOutputQuantitiesResponse(request,
                                                                                                                                          responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new OperationRecordedOutputQuantitiesPage(this, m, response);
    }

    @Override
    public Page<WorkplaceResponse> getAlternativeWorkplaces(String operationId) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mOperationEndpoint.getAlternativeWorkplaces(operationId);
        final HALCollectionWSModel responseModel = this.getResponseModel(operationId, call);
        final CollectionResponse<WorkplaceResponse> response = mWorkplaceResponseBuilder.getAlternativeWorkplaceCollectionResponse(responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public OperationCurrentProductionDataResponse getCurrentProductionData(GetOperationCurrentProductionDataRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mOperationEndpoint.getCurrentProductionData(request.getOperationId(), request.getAdditionalOperationTime());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mSpecificationResponseBuilder.getOperationCurrentProductionDataResponse(responseModel);
    }

    @Override
    public void updateRecordedOperatingState(UpdateOperationRecordedOperatingStateRequest request) throws ForceAPIException {
        final Call<Void> call = mOperationEndpoint.updateRecordedOperatingState(request.getOperationId(), request.getOperationRecordedOperatingState());
        this.executeCall(request, call);
    }
}
