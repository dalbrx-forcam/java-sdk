////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 08.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.masterdata;

import com.forcam.na.ffwebservices.client.api.AbstractClient;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.exception.ForceAPIException;
import com.forcam.na.ffwebservices.client.api.masterdata.document.builder.IDocumentStateResponseBuilder;
import com.forcam.na.ffwebservices.client.api.masterdata.document.enpoint.DocumentStateEndpoint;
import com.forcam.na.ffwebservices.client.api.masterdata.document.request.GetDocumentStateCollectionRequest;
import com.forcam.na.ffwebservices.client.api.masterdata.document.request.GetDocumentStateRequest;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.response.Page;
import com.forcam.na.ffwebservices.client.api.qualitydetail.IQualityDetailResponseBuilder;
import com.forcam.na.ffwebservices.client.api.qualitydetail.QualityDetailEndpoint;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailRequest;
import com.forcam.na.ffwebservices.client.api.qualitydetail.request.GetQualityDetailsRequest;
import com.forcam.na.ffwebservices.client.api.qualitytype.IQualityTypeResponseBuilder;
import com.forcam.na.ffwebservices.client.api.qualitytype.QualityTypeEndpoint;
import com.forcam.na.ffwebservices.client.api.qualitytype.request.GetQualityTypeRequest;
import com.forcam.na.ffwebservices.client.api.qualitytype.request.GetQualityTypesRequest;
import com.forcam.na.ffwebservices.client.api.shifttype.IShiftTypeResponseBuilder;
import com.forcam.na.ffwebservices.client.api.shifttype.ShiftTypeEndpoint;
import com.forcam.na.ffwebservices.client.api.shifttype.request.GetShiftTypeRequest;
import com.forcam.na.ffwebservices.client.api.shifttype.request.GetShiftTypesRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.CustomerSpecificSettingsEndpoint;
import com.forcam.na.ffwebservices.client.api.specificsettings.ICustomerSpecificSettingsResponseBuilder;
import com.forcam.na.ffwebservices.client.api.specificsettings.request.GetCustomerSpecificSettingCollectionRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.request.GetCustomerSpecificSettingRequest;
import com.forcam.na.ffwebservices.client.api.specificsettings.response.CustomerSpecificSettingResponse;
import com.forcam.na.ffwebservices.client.api.ticket.ITicketMasterDataResponseBuilder;
import com.forcam.na.ffwebservices.client.api.ticket.TicketMasterDataEndpoint;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketActivityStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketClassRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketClassesRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketStateRequest;
import com.forcam.na.ffwebservices.client.api.ticket.request.GetTicketStatesRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.IOperatingStateResponseBuilder;
import com.forcam.na.ffwebservices.client.statusdefinition.IStatusDefinitionResponseBuilder;
import com.forcam.na.ffwebservices.client.statusdefinition.StatusDefinitionEndpoint;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateClassCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateClassRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperationPhaseCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperationPhaseRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetToolAssemblyOrderStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetToolAssemblyOrderStateRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetWorkplaceStateCollectionRequest;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetWorkplaceStateRequest;
import com.forcam.na.ffwebservices.model.qualitydetail.QualityDetailResponse;
import com.forcam.na.ffwebservices.model.qualitytype.QualityTypeResponse;
import com.forcam.na.ffwebservices.model.shifttype.ShiftTypeResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.DocumentStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketActivityStateResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketClassResponse;
import com.forcam.na.ffwebservices.model.ticket.TicketStateResponse;
import retrofit2.Call;

import javax.inject.Inject;
import java.lang.reflect.Method;

/**
 * Requests master data.
 */
public class MasterDataClient extends AbstractClient implements IMasterDataClient {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The status definition endpoint. */
    private final StatusDefinitionEndpoint mStatusDefinitionEndpoint;

    /** The quality detail endpoint. */
    private final QualityDetailEndpoint mQualityDetailEndpoint;

    /** The quality type endpoint. */
    private final QualityTypeEndpoint mQualityTypeEndpoint;

    /** The shift type endpoint. */
    private final ShiftTypeEndpoint mShiftTypeEndpoint;

    /** The ticket master data endpoint. */
    private final TicketMasterDataEndpoint mTicketMasterDataEndpoint;

    /** The customer specific setting endpoint. */
    private final CustomerSpecificSettingsEndpoint mCustomerSpecificSettingsEndpoint;

    /** The document state endpoint. */
    private final DocumentStateEndpoint mDocumentStateEndpoint;

    /** The status definition response builder. */
    private final IStatusDefinitionResponseBuilder mStatusDefinitionResponseBuilder;

    /** The operating state response builder. */
    private final IOperatingStateResponseBuilder mOperatingStateResponseBuilder;

    /** The quality detail response builder. */
    private final IQualityDetailResponseBuilder mQualityDetailResponseBuilder;

    /** The quality type response builder. */
    private final IQualityTypeResponseBuilder mQualityTypeResponseBuilder;

    /** The shift type response builder. */
    private final IShiftTypeResponseBuilder mShiftTypeResponseBuilder;

    /** The ticket master data response builder. */
    private final ITicketMasterDataResponseBuilder mTicketMasterDataResponseBuilder;

    /** The ticket customer specific setting response builder. */
    private final ICustomerSpecificSettingsResponseBuilder mCustomerSpecificSettingsResponseBuilder;

    /** The document state response builder. */
    private final IDocumentStateResponseBuilder mDocumentStateResponseBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param statusDefinitionEndpoint                Status definition endpoint.
     * @param qualityDetailEndpoint                   Quality detail endpoint.
     * @param qualityTypeEndpoint                     Quality type endpoint.
     * @param shiftTypeEndpoint                       Shift type endpoint.
     * @param ticketMasterDataEndpoint                The ticket master data endpoint.
     * @param customerSpecificSettingsEndpoint        Customer specific settings endpoint.
     * @param documentStateEndpoint                   Document state endpoint.
     * @param statusDefinitionResponseBuilder         Status definition response builder.
     * @param operatingStateResponseBuilder           Operating state response builder.
     * @param qualityDetailResponseBuilder            Quality detail response builder.
     * @param qualityTypeResponseBuilder              Quality type response builder.
     * @param shiftTypeResponseBuilder                Shift type response builder.
     * @param ticketMasterDataResponseBuilder         The ticket master data response builder.
     * @param customerSpecificSettingsResponseBuilder Customer specific settings response builder.
     * @param documentStateResponseBuilder            Document state response builder.
     */
    @Inject
    public MasterDataClient(StatusDefinitionEndpoint statusDefinitionEndpoint, QualityDetailEndpoint qualityDetailEndpoint,
                            QualityTypeEndpoint qualityTypeEndpoint, ShiftTypeEndpoint shiftTypeEndpoint, TicketMasterDataEndpoint ticketMasterDataEndpoint,
                            CustomerSpecificSettingsEndpoint customerSpecificSettingsEndpoint, DocumentStateEndpoint documentStateEndpoint,
                            IStatusDefinitionResponseBuilder statusDefinitionResponseBuilder, IOperatingStateResponseBuilder operatingStateResponseBuilder,
                            IQualityDetailResponseBuilder qualityDetailResponseBuilder, IQualityTypeResponseBuilder qualityTypeResponseBuilder,
                            IShiftTypeResponseBuilder shiftTypeResponseBuilder, ITicketMasterDataResponseBuilder ticketMasterDataResponseBuilder,
                            ICustomerSpecificSettingsResponseBuilder customerSpecificSettingsResponseBuilder,
                            IDocumentStateResponseBuilder documentStateResponseBuilder) {
        mStatusDefinitionEndpoint = statusDefinitionEndpoint;
        mQualityDetailEndpoint = qualityDetailEndpoint;
        mQualityTypeEndpoint = qualityTypeEndpoint;
        mShiftTypeEndpoint = shiftTypeEndpoint;
        mTicketMasterDataEndpoint = ticketMasterDataEndpoint;
        mCustomerSpecificSettingsEndpoint = customerSpecificSettingsEndpoint;
        mDocumentStateEndpoint = documentStateEndpoint;
        mStatusDefinitionResponseBuilder = statusDefinitionResponseBuilder;
        mOperatingStateResponseBuilder = operatingStateResponseBuilder;
        mQualityDetailResponseBuilder = qualityDetailResponseBuilder;
        mQualityTypeResponseBuilder = qualityTypeResponseBuilder;
        mShiftTypeResponseBuilder = shiftTypeResponseBuilder;
        mTicketMasterDataResponseBuilder = ticketMasterDataResponseBuilder;
        mCustomerSpecificSettingsResponseBuilder = customerSpecificSettingsResponseBuilder;
        mDocumentStateResponseBuilder = documentStateResponseBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public Page<StatusDefinitionResponse> getOperatingStateClasses(GetOperatingStateClassCollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStatusDefinitionEndpoint.getOperatingStateClasses(request.getLimit(),
                                                                                                   request.getOffset(),
                                                                                                   request
                                                                                                       .embed()
                                                                                                       .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);

        final CollectionResponse<StatusDefinitionResponse> response = mStatusDefinitionResponseBuilder.getStatusDefinitionCollectionResponse(request,
                                                                                                                                             responseModel,
                                                                                                                                             mStatusDefinitionResponseBuilder.OPERATING_STATE_CLASSES_KEY);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public StatusDefinitionResponse getOperatingStateClass(GetOperatingStateClassRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStatusDefinitionEndpoint.getOperatingStateClass(request.getId(),
                                                                                       request
                                                                                           .embed()
                                                                                           .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mStatusDefinitionResponseBuilder.getStatusDefinitionResponse(responseModel);
    }

    @Override
    public Page<OperatingStateResponse> getOperatingStates(GetOperatingStateCollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStatusDefinitionEndpoint.getOperatingStates(request.getLimit(),
                                                                                             request.getOffset(),
                                                                                             request.getTimeBase(),
                                                                                             request.getWorkplaceState(),
                                                                                             request.getOperatingStateClassId(),
                                                                                             request
                                                                                                 .embed()
                                                                                                 .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<OperatingStateResponse> response = mOperatingStateResponseBuilder.getOperatingStateCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public OperatingStateResponse getOperatingState(GetOperatingStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStatusDefinitionEndpoint.getOperatingState(request.getId(),
                                                                                  request
                                                                                      .embed()
                                                                                      .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mOperatingStateResponseBuilder.getOperatingStateResponse(responseModel);
    }

    @Override
    public Page<StatusDefinitionResponse> getOperationPhases(GetOperationPhaseCollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStatusDefinitionEndpoint.getOperationPhases(request.getLimit(),
                                                                                             request.getOffset(),
                                                                                             request
                                                                                                 .embed()
                                                                                                 .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<StatusDefinitionResponse> response = mStatusDefinitionResponseBuilder.getStatusDefinitionCollectionResponse(request,
                                                                                                                                             responseModel,
                                                                                                                                             mStatusDefinitionResponseBuilder.OPERATION_PHASES_KEY);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public StatusDefinitionResponse getOperationPhase(GetOperationPhaseRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStatusDefinitionEndpoint.getOperationPhase(request.getId(),
                                                                                  request
                                                                                      .embed()
                                                                                      .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mStatusDefinitionResponseBuilder.getStatusDefinitionResponse(responseModel);
    }

    @Override
    public Page<QualityDetailResponse> getQualityDetails(GetQualityDetailsRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mQualityDetailEndpoint.getQualityDetails(request.getLimit(),
                                                                                         request.getOffset(),
                                                                                         request.getCode(),
                                                                                         request.getQualityTypeId(),
                                                                                         request
                                                                                             .embed()
                                                                                             .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<QualityDetailResponse> response = mQualityDetailResponseBuilder.getQualityDetailCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public QualityDetailResponse getQualityDetail(GetQualityDetailRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mQualityDetailEndpoint.getQualityDetail(request.getId(),
                                                                              request
                                                                                  .embed()
                                                                                  .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mQualityDetailResponseBuilder.getQualityDetailResponse(responseModel);
    }

    @Override
    public Page<QualityTypeResponse> getQualityTypes(GetQualityTypesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mQualityTypeEndpoint.getQualityTypes(request.getLimit(),
                                                                                     request.getOffset(),
                                                                                     request
                                                                                         .embed()
                                                                                         .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);

        final CollectionResponse<QualityTypeResponse> response = mQualityTypeResponseBuilder.getQualityTypeCollectionResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public QualityTypeResponse getQualityType(GetQualityTypeRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mQualityTypeEndpoint.getQualityType(request
                                                                              .getId()
                                                                              .name(),
                                                                          request
                                                                              .embed()
                                                                              .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mQualityTypeResponseBuilder.getQualityTypeResponse(responseModel);
    }

    @Override
    public Page<ShiftTypeResponse> getShiftTypes(GetShiftTypesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mShiftTypeEndpoint.getShiftTypes(request.getLimit(),
                                                                                 request.getOffset(),
                                                                                 request
                                                                                     .embed()
                                                                                     .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<ShiftTypeResponse> response = mShiftTypeResponseBuilder.getShiftTypeCollectionResponse(request, responseModel);
        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public ShiftTypeResponse getShiftType(GetShiftTypeRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mShiftTypeEndpoint.getShiftType(request.getId(),
                                                                      request
                                                                          .embed()
                                                                          .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mShiftTypeResponseBuilder.getShiftTypeResponse(responseModel);
    }

    @Override
    public Page<StatusDefinitionResponse> getToolAssemblyOrderStates(GetToolAssemblyOrderStateCollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStatusDefinitionEndpoint.getToolAssemblyOrderStates(request.getLimit(),
                                                                                                     request.getOffset(),
                                                                                                     request
                                                                                                         .embed()
                                                                                                         .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<StatusDefinitionResponse> response = mStatusDefinitionResponseBuilder.getStatusDefinitionCollectionResponse(request,
                                                                                                                                             responseModel,
                                                                                                                                             mStatusDefinitionResponseBuilder.TOOL_ASSEMBLY_STATES_KEY);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public StatusDefinitionResponse getToolAssemblyOrderState(GetToolAssemblyOrderStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStatusDefinitionEndpoint.getToolAssemblyOrderState(request.getId(),
                                                                                          request
                                                                                              .embed()
                                                                                              .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mStatusDefinitionResponseBuilder.getStatusDefinitionResponse(responseModel);
    }

    @Override
    public Page<StatusDefinitionResponse> getWorkplaceStates(GetWorkplaceStateCollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mStatusDefinitionEndpoint.getWorkplaceStates(request.getLimit(),
                                                                                             request.getOffset(),
                                                                                             request
                                                                                                 .embed()
                                                                                                 .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<StatusDefinitionResponse> response = mStatusDefinitionResponseBuilder.getStatusDefinitionCollectionResponse(request,
                                                                                                                                             responseModel,
                                                                                                                                             mStatusDefinitionResponseBuilder.WORKPLACE_STATES_KEY);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public StatusDefinitionResponse getWorkplaceState(GetWorkplaceStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mStatusDefinitionEndpoint.getWorkplaceState(request.getId(),
                                                                                  request
                                                                                      .embed()
                                                                                      .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mStatusDefinitionResponseBuilder.getStatusDefinitionResponse(responseModel);
    }

    @Override
    public Page<TicketStateResponse> getTicketStates(GetTicketStatesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mTicketMasterDataEndpoint.getTicketStates(request.getLimit(),
                                                                                          request.getOffset(),
                                                                                          request
                                                                                              .embed()
                                                                                              .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<TicketStateResponse> response = mTicketMasterDataResponseBuilder.getTicketStatesResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public TicketStateResponse getTicketState(GetTicketStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketMasterDataEndpoint.getTicketState(request.getId(),
                                                                               request
                                                                                   .embed()
                                                                                   .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketMasterDataResponseBuilder.getTicketStateResponse(responseModel);
    }

    @Override
    public Page<TicketActivityStateResponse> getTicketActivityStates(CollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mTicketMasterDataEndpoint.getTicketActivityStates(request.getLimit(), request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<TicketActivityStateResponse> response = mTicketMasterDataResponseBuilder.getTicketActivityStatesResponse(request,
                                                                                                                                          responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public TicketActivityStateResponse getTicketActivityState(GetTicketActivityStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketMasterDataEndpoint.getTicketActivityState(request.getId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketMasterDataResponseBuilder.getTicketActivityStateResponse(responseModel);
    }

    @Override
    public Page<TicketClassResponse> getTicketClasses(GetTicketClassesRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mTicketMasterDataEndpoint.getTicketClasses(request.getLimit(),
                                                                                           request.getOffset(),
                                                                                           request
                                                                                               .embed()
                                                                                               .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<TicketClassResponse> response = mTicketMasterDataResponseBuilder.getTicketClassesResponse(request, responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public TicketClassResponse getTicketClass(GetTicketClassRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mTicketMasterDataEndpoint.getTicketClass(request.getId(),
                                                                               request
                                                                                   .embed()
                                                                                   .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mTicketMasterDataResponseBuilder.getTicketClassResponse(responseModel);
    }

    @Override
    public Page<CustomerSpecificSettingResponse> getCustomerSpecificSettings(GetCustomerSpecificSettingCollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mCustomerSpecificSettingsEndpoint.getCustomerSpecificSettings(request.getTopic(),
                                                                                                              request.getLimit(),
                                                                                                              request.getOffset());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<CustomerSpecificSettingResponse> response = mCustomerSpecificSettingsResponseBuilder.getCustomerSpecificSettingsResponse(
            request,
            responseModel);

        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public CustomerSpecificSettingResponse getCustomerSpecificSetting(GetCustomerSpecificSettingRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mCustomerSpecificSettingsEndpoint.getCustomerSpecificSetting(request.getId());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mCustomerSpecificSettingsResponseBuilder.getCustomerSpecificSettingResponse(responseModel);
    }

    @Override
    public Page<DocumentStateResponse> getDocumentStates(GetDocumentStateCollectionRequest request) throws ForceAPIException {
        final Call<HALCollectionWSModel> call = mDocumentStateEndpoint.getDocumentStates(request.getLimit(),
                                                                                         request.getOffset(),
                                                                                         request
                                                                                             .embed()
                                                                                             .toString());
        final HALCollectionWSModel responseModel = this.getResponseModel(request, call);
        final CollectionResponse<DocumentStateResponse> response = mDocumentStateResponseBuilder.getDocumentStateCollectionResponse(request, responseModel);
        final Method m = new Object() {}
            .getClass()
            .getEnclosingMethod();
        return new Page<>(this, m, response);
    }

    @Override
    public DocumentStateResponse getDocumentState(GetDocumentStateRequest request) throws ForceAPIException {
        final Call<HALWSModel> call = mDocumentStateEndpoint.getDocumentState(request.getId(),
                                                                              request
                                                                                  .embed()
                                                                                  .toString());
        final HALWSModel responseModel = this.getResponseModel(request, call);
        return mDocumentStateResponseBuilder.getDocumentStateResponse(responseModel);
    }
}

