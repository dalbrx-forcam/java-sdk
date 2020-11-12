////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 13.09.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.device.IDeviceResponseBuilder;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.operation.response.RecordedOperatingStateCollectionPage;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.recordedoperatingstate.IRecordedOperatingStateResponseBuilder;
import com.forcam.na.ffwebservices.client.api.recordedoperatingstate.RecordedOperatingStateCollectionResponse;
import com.forcam.na.ffwebservices.client.api.shift.IWorkplaceShiftResponseBuilder;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftRequest;
import com.forcam.na.ffwebservices.client.api.shift.request.GetWorkplaceShiftsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetOperatingStateSummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceDevicesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacePredictedMalfunctionScenarioRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacePredictedMalfunctionScenariosRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceQuantitySummaryRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRecordedOperatingStatesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRecordedOutputQuantitiesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceTimeRangeRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceUserFieldsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacesRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.UpdateWorkplaceRecordedOperatingStateRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.PredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceOperatingStateSummaryPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceOperatingStateSummaryResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplacePredictedMalfunctionScenarioPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceQuantitySummaryCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceQuantitySummaryCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOperationPhasesPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOperationPhasesResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOutputQuantitiesPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOutputQuantitiesResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledMaintenanceTimesCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledMaintenanceTimesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledOperatingTimesCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledOperatingTimesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceUserFieldCollectionPage;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceUserFieldCollectionResponse;
import com.forcam.na.ffwebservices.model.device.DeviceResponse;
import com.forcam.na.ffwebservices.model.shift.WorkplaceShiftResponse;
import com.forcam.na.ffwebservices.model.workplace.CreateWorkplacePredictedMalfunctionScenarioWSModel;
import com.forcam.na.ffwebservices.model.workplace.EmbeddedPredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import com.forcam.na.ffwebservices.model.workplace.quantity.WorkplaceQuantitySummaryCollectionWSModel;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests workplaces and shifts of workplaces.
 */
public class WorkplaceClient extends AbstractClient implements IWorkplaceClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The workplace endpoint. */
    private final WorkplaceEndpoint mWorkplaceEndpoint;

    /** The workplace response builder. */
    private final IWorkplaceResponseBuilder mWorkplaceResponseBuilder;

    /** The shift response builder. */
    private final IWorkplaceShiftResponseBuilder mWorkplaceShiftResponseBuilder;

    /** The recorded operating state response builder. */
    private final IRecordedOperatingStateResponseBuilder mRecordedOperatingStateResponseBuilder;

    /** The workplace summary response builder. */
    private final IWorkplaceQuantitySummaryResponseBuilder mQuantitySummaryResponseBuilder;

    /** The workplace operating state summary response builder. */
    private final IWorkplaceOperatingStateSummaryResponseBuilder mWorkplaceOperatingStateSummaryResponseBuilder;

    /** The device response builder. */
    private final IDeviceResponseBuilder mDeviceResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param workplaceResponseBuilder                      Workplace response builder.
     * @param deviceResponseBuilder                         Device response builder.
     * @param quantitySummaryResponseBuilder                Quantity summary response builder.
     * @param recordedOperatingStateResponseBuilder         Recorded operating state response builder.
     * @param workplaceEndpoint                             Workplace endpoint.
     * @param workplaceOperatingStateSummaryResponseBuilder Workplace operating state summary response builder.
     * @param workplaceShiftResponseBuilder                 Workplace shift response builder.
     */
    @Inject
    public WorkplaceClient(WorkplaceEndpoint workplaceEndpoint, IWorkplaceResponseBuilder workplaceResponseBuilder,
                           IWorkplaceShiftResponseBuilder workplaceShiftResponseBuilder,
                           IRecordedOperatingStateResponseBuilder recordedOperatingStateResponseBuilder,
                           IWorkplaceQuantitySummaryResponseBuilder quantitySummaryResponseBuilder,
                           IWorkplaceOperatingStateSummaryResponseBuilder workplaceOperatingStateSummaryResponseBuilder,
                           IDeviceResponseBuilder deviceResponseBuilder) {
        mWorkplaceEndpoint = workplaceEndpoint;
        mWorkplaceResponseBuilder = workplaceResponseBuilder;
        mWorkplaceShiftResponseBuilder = workplaceShiftResponseBuilder;
        mRecordedOperatingStateResponseBuilder = recordedOperatingStateResponseBuilder;
        mQuantitySummaryResponseBuilder = quantitySummaryResponseBuilder;
        mWorkplaceOperatingStateSummaryResponseBuilder = workplaceOperatingStateSummaryResponseBuilder;
        mDeviceResponseBuilder = deviceResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<WorkplaceResponse> getWorkplaces(GetWorkplacesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mWorkplaceEndpoint.getWorkplaces(request.getWorkplaceName(),
                                                                                 request.getErpKeyId(),
                                                                                 request.getWorkplaceGroupNumber(),
                                                                                 request.getWorkplaceGroupId(),
                                                                                 request.getWorkplaceTypeCode(),
                                                                                 request.getLimit(),
                                                                                 request.getOffset(),
                                                                                 request
                                                                                     .embed()
                                                                                     .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<WorkplaceResponse> response = mWorkplaceResponseBuilder.getWorkplaceCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public WorkplaceResponse getWorkplace(GetWorkplaceRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getWorkplace(request.getId(),
                                                                      request
                                                                          .embed()
                                                                          .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceResponseBuilder.getWorkplaceResponse(responseModel);
    }

    @Override
    public Page<WorkplaceShiftResponse> getShifts(GetWorkplaceShiftsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mWorkplaceEndpoint.getShifts(request.getWorkplaceId(),
                                                                             request.getWorkplaceNumber(),
                                                                             request.getWorkplaceGroupNumber(),
                                                                             request.getErpContextId(),
                                                                             request.getStartDate(),
                                                                             request.getEndDate(),
                                                                             request.isWorkingShift(),
                                                                             request.getShiftTypeId(),
                                                                             request.getAssociatedDay(),
                                                                             request.getLimit(),
                                                                             request.getPaginationDirection(),
                                                                             request.getPaginationTimestamp(),
                                                                             request.getPaginationIdentifier(),
                                                                             request
                                                                                 .embed()
                                                                                 .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<WorkplaceShiftResponse> response = mWorkplaceShiftResponseBuilder.getWorkplaceShiftCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public WorkplaceShiftResponse getShift(GetWorkplaceShiftRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getShift(request.getId(),
                                                                  request
                                                                      .embed()
                                                                      .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mWorkplaceShiftResponseBuilder.getWorkplaceShiftResponse(responseModel);
    }

    @Override
    public RecordedOperatingStateCollectionPage getRecordedOperatingStates(GetWorkplaceRecordedOperatingStatesRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getRecordedOperatingStates(request.getWorkplaceId(),
                                                                                    request.getStartDate(),
                                                                                    request.getEndDate(),
                                                                                    request.getTimeBase(),
                                                                                    request.getWorkplaceStateId(),
                                                                                    request.getOperatingStateClassId(),
                                                                                    request.getShiftId(),
                                                                                    request.getLimit(),
                                                                                    request.getPaginationDirection(),
                                                                                    request.getPaginationTimestamp(),
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
    public void updateRecordedOperatingState(UpdateWorkplaceRecordedOperatingStateRequest request) throws ForceAPIException {
        final Call<Void> call = mWorkplaceEndpoint.updateRecordedOperatingState(request.getWorkplaceId(), request.getWorkplaceRecordedOperatingState());
        this.executeCall(request, call);
    }

    @Override
    public WorkplaceQuantitySummaryCollectionPage getQuantitySummary(GetWorkplaceQuantitySummaryRequest request) throws ForceAPIException {
        final Call<WorkplaceQuantitySummaryCollectionWSModel> call = mWorkplaceEndpoint.getQuantitySummary(request.getWorkplaceId(),
                                                                                                           request.getLimit(),
                                                                                                           request.getOffset(),
                                                                                                           request.getStartDate(),
                                                                                                           request.getEndDate(),
                                                                                                           request.getMaterialNumber(),
                                                                                                           request.getShiftId());
        final WorkplaceQuantitySummaryCollectionWSModel responseModel = this.getResponseModel(request, call);
        final WorkplaceQuantitySummaryCollectionResponse response = mQuantitySummaryResponseBuilder.getWorkplaceQuantitySummaryCollectionResponse(request,
                                                                                                                                                  responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplaceQuantitySummaryCollectionPage(this, m, response);
    }

    @Override
    public WorkplaceScheduledOperatingTimesCollectionPage getScheduledOperatingTimes(GetWorkplaceTimeRangeRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getWorkplaceScheduledOperatingTimes(request.getWorkplaceId(),
                                                                                             request.getStartDate(),
                                                                                             request.getEndDate(),
                                                                                             request.getLimit(),
                                                                                             request.getPaginationDirection(),
                                                                                             request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final WorkplaceScheduledOperatingTimesCollectionResponse response = mWorkplaceResponseBuilder.getWorkplaceScheduledOperatingTimesCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplaceScheduledOperatingTimesCollectionPage(this, m, response);
    }

    @Override
    public WorkplaceOperatingStateSummaryPage getOperatingStateSummary(GetOperatingStateSummaryRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getOperatingStateSummary(request.getWorkplaceId(),
                                                                                  request.getStartDate(),
                                                                                  request.getEndDate(),
                                                                                  request.getShiftId(),
                                                                                  request.getWorkplaceStateId(),
                                                                                  request.getOperatingStateClassId(),
                                                                                  request.getTimeBase(),
                                                                                  request.getLimit(),
                                                                                  request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final WorkplaceOperatingStateSummaryResponse response = mWorkplaceOperatingStateSummaryResponseBuilder.getOperatingStateSummaryResponse(request,
                                                                                                                                                responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplaceOperatingStateSummaryPage(this, m, response);
    }

    @Override
    public WorkplaceRecordedOutputQuantitiesPage getWorkplaceRecordedOutputQuantities(GetWorkplaceRecordedOutputQuantitiesRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getWorkplaceRecordedOutputQuantities(request.getWorkplaceId(),
                                                                                              request.getStartDate(),
                                                                                              request.getEndDate(),
                                                                                              request.getShiftId(),
                                                                                              request.getLimit(),
                                                                                              request.getPaginationDirection(),
                                                                                              request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final WorkplaceRecordedOutputQuantitiesResponse response = mWorkplaceOperatingStateSummaryResponseBuilder.getWorkplaceRecordedOutputQuantitiesResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplaceRecordedOutputQuantitiesPage(this, m, response);
    }

    @Override
    public WorkplaceRecordedOperationPhasesPage getWorkplaceRecordedOperationPhases(GetWorkplaceTimeRangeRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getWorkplaceRecordedOperationPhases(request.getWorkplaceId(),
                                                                                             request.getStartDate(),
                                                                                             request.getEndDate(),
                                                                                             request.getLimit(),
                                                                                             request.getPaginationDirection(),
                                                                                             request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final WorkplaceRecordedOperationPhasesResponse response = mWorkplaceResponseBuilder.getWorkplaceRecordedOperationPhasesResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplaceRecordedOperationPhasesPage(this, m, response);
    }

    @Override
    public WorkplaceScheduledMaintenanceTimesCollectionPage getWorkplaceScheduledMaintenanceTimes(GetWorkplaceTimeRangeRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getWorkplaceScheduledMaintenanceTimes(request.getWorkplaceId(),
                                                                                               request.getStartDate(),
                                                                                               request.getEndDate(),
                                                                                               request.getLimit(),
                                                                                               request.getPaginationDirection(),
                                                                                               request.getPaginationTimestamp());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final WorkplaceScheduledMaintenanceTimesCollectionResponse response = mWorkplaceResponseBuilder.getWorkplaceScheduledMaintenanceTimesCollectionResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplaceScheduledMaintenanceTimesCollectionPage(this, m, response);
    }

    @Override
    public Page<DeviceResponse> getWorkplaceDevices(GetWorkplaceDevicesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mWorkplaceEndpoint.getWorkplaceDevices(request.getWorkplaceId(), request.getLimit(), request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<DeviceResponse> response = mDeviceResponseBuilder.getDeviceCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public Page<EmbeddedPredictedMalfunctionScenarioResponse> getPredictedMalfunctionScenarios(GetWorkplacePredictedMalfunctionScenariosRequest request)
        throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mWorkplaceEndpoint.getPredictedMalfunctionScenarios(request.getStartDate(),
                                                                                                    request.getEndDate(),
                                                                                                    request.getLimit(),
                                                                                                    request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<EmbeddedPredictedMalfunctionScenarioResponse> response = mWorkplaceResponseBuilder.getEmbeddedPredictedMalfunctionScenarioResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public WorkplacePredictedMalfunctionScenarioPage getPredictedMalfunctionScenario(GetWorkplacePredictedMalfunctionScenarioRequest request)
        throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getPredictedMalfunctionScenario(request.getPredictedMalfunctionScenarioId(),
                                                                                         request.getLimit(),
                                                                                         request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final PredictedMalfunctionScenarioResponse response = mWorkplaceResponseBuilder.getPredictedMalfunctionScenarioResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplacePredictedMalfunctionScenarioPage(this, m, response);
    }

    @Override
    public WorkplacePredictedMalfunctionScenarioPage savePredictedMalfunctionScenario(
        CreateWorkplacePredictedMalfunctionScenarioWSModel predictedMalfunctionScenario) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.savePredictedMalfunctionScenario(predictedMalfunctionScenario);
        final HALWSModel responseModel = this.getResponseModel(predictedMalfunctionScenario, call);
        final PredictedMalfunctionScenarioResponse response = mWorkplaceResponseBuilder.getPredictedMalfunctionScenarioResponse(new CollectionRequest(),
                                                                                                                                responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplacePredictedMalfunctionScenarioPage(this, m, response);
    }

    @Override
    public WorkplaceUserFieldCollectionPage getWorkplaceUserFields(GetWorkplaceUserFieldsRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mWorkplaceEndpoint.getWorkplaceUserFields(request.getWorkplaceId(), request.getLimit(), request.getOffset());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        final WorkplaceUserFieldCollectionResponse response = mWorkplaceResponseBuilder.getWorkplaceUserFieldCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new WorkplaceUserFieldCollectionPage(this, m, response);
    }

}
