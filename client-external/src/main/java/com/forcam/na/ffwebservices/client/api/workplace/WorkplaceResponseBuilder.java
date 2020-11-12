////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.10.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplace;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.erpcontext.ERPContextLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.location.LocationLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.machine.MachineLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.operation.OperationLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.StaffMemberLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplacePredictedMalfunctionScenariosRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceTimeRangeRequest;
import com.forcam.na.ffwebservices.client.api.workplace.request.GetWorkplaceUserFieldsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.response.PredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceRecordedOperationPhasesResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledMaintenanceTimesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceScheduledOperatingTimesCollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplace.response.WorkplaceUserFieldCollectionResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.location.LocationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.machine.MachinePropertiesWSModel;
import com.forcam.na.ffwebservices.model.operatingstate.WpOperationPhaseCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.UserFieldCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.EmbeddedPredictedMalfunctionScenarioPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.EmbeddedPredictedMalfunctionScenarioResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceEmbed;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePredictedMalfunctionScenarioPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceScheduledMaintenanceTimesPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplace.WorkplaceScheduledOperatingTimesPropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for workplaces.
 */
public class WorkplaceResponseBuilder extends AbstractResponseBuilder implements IWorkplaceResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the erp context. */
    private final ERPContextLinkModelBuilder mERPContextLinkModelBuilder;

    /** The link model builder of the machine. */
    private final MachineLinkModelBuilder mMachineLinkModelBuilder;

    /** The link model builder for literals. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder for operations. */
    private final OperationLinkModelBuilder mOperationLinkModelBuilder;

    private final StaffMemberLinkModelBuilder mStaffMemberLinkModelBuilder;

    /** The link model builder for workplaces. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    /** The link model builder for locations. */
    private final LocationLinkModelBuilder mLocationLinkModelBuilder;

    /** The embedded workplace user fields. */
    private WorkplaceUserFieldsLinkModelBuilder mWorkplaceUserFieldsLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public WorkplaceResponseBuilder(ERPContextLinkModelBuilder erpContextLinkModelBuilder, MachineLinkModelBuilder machineLinkModelBuilder,
                                    LiteralLinkModelBuilder literalLinkModelBuilder, OperationLinkModelBuilder operationLinkModelBuilder,
                                    StaffMemberLinkModelBuilder staffMemberLinkModelBuilder, WorkplaceLinkModelBuilder workplaceLinkModelBuilder,
                                    LocationLinkModelBuilder locationLinkModelBuilder,
                                    WorkplaceUserFieldsLinkModelBuilder workplaceUserFieldsLinkModelBuilder) {
        mERPContextLinkModelBuilder = erpContextLinkModelBuilder;
        mMachineLinkModelBuilder = machineLinkModelBuilder;
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mOperationLinkModelBuilder = operationLinkModelBuilder;
        mStaffMemberLinkModelBuilder = staffMemberLinkModelBuilder;
        mLocationLinkModelBuilder = locationLinkModelBuilder;
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
        mWorkplaceUserFieldsLinkModelBuilder = workplaceUserFieldsLinkModelBuilder;

    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<WorkplaceResponse> getWorkplaceCollectionResponse(PaginationRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<WorkplaceResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> workplaces = embedded.get("workplaces");

        final List<WorkplaceResponse> workplaceModels = workplaces
            .stream()
            .map(this::getWorkplaceResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(workplaceModels);
        return collectionResponse;
    }

    @Override
    public CollectionResponse<WorkplaceResponse> getAlternativeWorkplaceCollectionResponse(HALCollectionWSModel collectionModel) {
        final CollectionResponse<WorkplaceResponse> collectionResponse = new CollectionResponse<>(null);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> workplaces = embedded.get("alternativeWorkplaces");

        final List<WorkplaceResponse> workplaceModels = workplaces
            .stream()
            .map(this::getWorkplaceResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(workplaceModels);
        return collectionResponse;
    }

    @Override
    public WorkplaceResponse getWorkplaceResponse(HALWSModel serverModel) {
        final WorkplaceResponse workplaceModel = new WorkplaceResponse();
        final WorkplacePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), WorkplacePropertiesWSModel.class);
        workplaceModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        workplaceModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext = mERPContextLinkModelBuilder.buildLinkModel(serverModel, WorkplaceEmbed.ERP_CONTEXT);
        workplaceModel.setErpContext(erpContext);

        final LinkEmbeddedWSModel<MachinePropertiesWSModel> machine = mMachineLinkModelBuilder.buildLinkModel(serverModel, WorkplaceEmbed.MACHINE);
        workplaceModel.setMachine(machine);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, WorkplaceEmbed.DESCRIPTION);
        workplaceModel.setDescription(description);

        final List<LinkEmbeddedWSModel<OperationPropertiesWSModel>> currentOperations = mOperationLinkModelBuilder.buildListOfLinkModels(serverModel,
                                                                                                                                         WorkplaceEmbed.CURRENT_OPERATIONS);
        workplaceModel.setCurrentOperations(currentOperations);

        final List<LinkEmbeddedWSModel<StaffMemberPropertiesWSModel>> currentStaffMembers = mStaffMemberLinkModelBuilder.buildListOfLinkModels(serverModel,
                                                                                                                                               WorkplaceEmbed.CURRENT_STAFF_MEMBERS);
        workplaceModel.setCurrentStaffMembers(currentStaffMembers);

        final LinkEmbeddedWSModel<LocationPropertiesWSModel> location = mLocationLinkModelBuilder.buildLinkModel(serverModel, WorkplaceEmbed.LOCATION);
        workplaceModel.setLocation(location);

        final LinkEmbeddedWSModel<UserFieldCollectionPropertiesWSModel> userFields = mWorkplaceUserFieldsLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                         WorkplaceEmbed.USER_FIELDS);
        workplaceModel.setUserFields(userFields);

        return workplaceModel;
    }

    @Override
    public WorkplaceScheduledOperatingTimesCollectionResponse getWorkplaceScheduledOperatingTimesCollectionResponse(GetWorkplaceTimeRangeRequest request,
                                                                                                                    HALWSModel serverModel) {
        final WorkplaceScheduledOperatingTimesCollectionResponse collectionResponse = new WorkplaceScheduledOperatingTimesCollectionResponse(request);
        final WorkplaceScheduledOperatingTimesPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(),
                                                                                                  WorkplaceScheduledOperatingTimesPropertiesWSModel.class);

        collectionResponse.setProperties(properties);
        collectionResponse.setPagination(serverModel.getPagination());
        collectionResponse.setPaginationLinks(serverModel.getLinkModels());

        return collectionResponse;
    }

    @Override
    public WorkplaceRecordedOperationPhasesResponse getWorkplaceRecordedOperationPhasesResponse(GetWorkplaceTimeRangeRequest request,
                                                                                                HALWSModel serverModel) {
        final WorkplaceRecordedOperationPhasesResponse response = new WorkplaceRecordedOperationPhasesResponse(request);
        final WpOperationPhaseCollectionPropertiesWSModel propertiesWSModel = mMapper.convertValue(serverModel.getProperties(),
                                                                                                   WpOperationPhaseCollectionPropertiesWSModel.class);
        response.setProperties(propertiesWSModel);
        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());

        return response;
    }

    @Override
    public WorkplaceScheduledMaintenanceTimesCollectionResponse getWorkplaceScheduledMaintenanceTimesCollectionResponse(
        GetWorkplaceTimeRangeRequest request, HALWSModel serverModel) {
        final WorkplaceScheduledMaintenanceTimesCollectionResponse response = new WorkplaceScheduledMaintenanceTimesCollectionResponse(request);
        final WorkplaceScheduledMaintenanceTimesPropertiesWSModel propertiesWSModel = mMapper.convertValue(serverModel.getProperties(),
                                                                                                           WorkplaceScheduledMaintenanceTimesPropertiesWSModel.class);
        response.setProperties(propertiesWSModel);
        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());

        return response;
    }

    @Override
    public CollectionResponse<EmbeddedPredictedMalfunctionScenarioResponse> getEmbeddedPredictedMalfunctionScenarioResponse(
        GetWorkplacePredictedMalfunctionScenariosRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<EmbeddedPredictedMalfunctionScenarioResponse> collectionResponse = new CollectionResponse<>(request);
        super.initializeCollectionResponse(collectionModel, collectionResponse);
        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> predictedMalfunctionScenarios = embedded.get("predictedMalfunctionScenarios");

        final List<EmbeddedPredictedMalfunctionScenarioResponse> scenarioResponse = predictedMalfunctionScenarios
            .stream()
            .map(this::getPredictedMalfunctionScenarioResponse)
            .collect(Collectors.toList());
        collectionResponse.setEmbedded(scenarioResponse);

        return collectionResponse;
    }

    @Override
    public PredictedMalfunctionScenarioResponse getPredictedMalfunctionScenarioResponse(CollectionRequest request, HALWSModel serverModel) {
        final PredictedMalfunctionScenarioResponse response = new PredictedMalfunctionScenarioResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), WorkplacePredictedMalfunctionScenarioPropertiesWSModel.class));
        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());
        return response;
    }

    @Override
    public WorkplaceUserFieldCollectionResponse getWorkplaceUserFieldCollectionResponse(GetWorkplaceUserFieldsRequest request, HALWSModel collectionWSModel) {
        final WorkplaceUserFieldCollectionResponse workplaceUserFieldCollectionResponse = new WorkplaceUserFieldCollectionResponse(request);
        workplaceUserFieldCollectionResponse.setWorkplaceId(request.getWorkplaceId());
        workplaceUserFieldCollectionResponse.setProperties(mMapper.convertValue(collectionWSModel.getProperties(), UserFieldCollectionPropertiesWSModel.class));
        workplaceUserFieldCollectionResponse.setPagination(collectionWSModel.getPagination());
        workplaceUserFieldCollectionResponse.setPaginationLinks(collectionWSModel.getLinkModels());
        return workplaceUserFieldCollectionResponse;
    }

    /**
     * Converts a HAL model into an predicted malfunction scenario response.
     *
     * @param serverModel The HAL model.
     * @return The predicted malfunction scenario response.
     */
    private EmbeddedPredictedMalfunctionScenarioResponse getPredictedMalfunctionScenarioResponse(HALWSModel serverModel) {
        final EmbeddedPredictedMalfunctionScenarioResponse response = new EmbeddedPredictedMalfunctionScenarioResponse();
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), EmbeddedPredictedMalfunctionScenarioPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        return response;
    }
}
