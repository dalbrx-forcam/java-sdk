////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 09.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationAssignmentCollectionResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationForecastResultResponse;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.OperationPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.PaginationRequest;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentCollectionPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationAssignmentWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningResultEmbed;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Operation planning response builder.
 */
public class OperationPlanningResponseBuilder extends AbstractResponseBuilder implements IOperationPlanningResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of the workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public OperationPlanningResponseBuilder(WorkplaceLinkModelBuilder workplaceLinkModelBuilder) {
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public OperationPlanningResultResponse getOperationPlanningResultResponse(HALWSModel serverModel) {
        final OperationPlanningResultResponse operationPlanningResultResponse = new OperationPlanningResultResponse();
        operationPlanningResultResponse.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationAssignmentWSModel.class));

        final LinkEmbeddedWSModel<WorkplacePropertiesWSModel> plannedWorkplace = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                           OperationPlanningResultEmbed.PLANNED_WORKPLACE);
        operationPlanningResultResponse.setPlannedWorkplace(plannedWorkplace);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        operationPlanningResultResponse.setSelf(selfLink);

        return operationPlanningResultResponse;
    }

    @Override
    public OperationForecastResultResponse getOperationForecastResultResponse(HALWSModel serverModel) {
        final OperationForecastResultResponse resultResponse = new OperationForecastResultResponse();
        resultResponse.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationAssignmentWSModel.class));
        resultResponse.setSelf(this.createSelfLinkModel(serverModel));

        return resultResponse;
    }

    @Override
    public OperationAssignmentCollectionResponse<OperationPlanningResultResponse> getOperationPlanningResultCollectionResponse(PaginationRequest request,
                                                                                                                               OperationAssignmentCollectionServerModel collectionModel) {
        final OperationAssignmentCollectionResponse<OperationPlanningResultResponse> response = new OperationAssignmentCollectionResponse<>(request);
        response.setProperties(mMapper.convertValue(collectionModel.getProperties(), OperationAssignmentCollectionPropertiesWSModel.class));
        response.setPagination(collectionModel.getPagination());
        response.setPaginationLinks(collectionModel.getLinks());

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> assignments = embedded.get("planningResults");

        final List<OperationPlanningResultResponse> embeddedAssignments = assignments
            .stream()
            .map(this::getOperationPlanningResultResponse)
            .collect(Collectors.toList());

        response.setEmbedded(embeddedAssignments);

        return response;
    }

    @Override
    public OperationAssignmentCollectionResponse<OperationForecastResultResponse> getOperationForecastCollectionResponse(PaginationRequest request,
                                                                                                                         OperationAssignmentCollectionServerModel collectionModel) {
        final OperationAssignmentCollectionResponse<OperationForecastResultResponse> response = new OperationAssignmentCollectionResponse<>(request);
        response.setProperties(mMapper.convertValue(collectionModel.getProperties(), OperationAssignmentCollectionPropertiesWSModel.class));
        response.setPagination(collectionModel.getPagination());
        response.setPaginationLinks(collectionModel.getLinks());

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> assignments = embedded.get("forecastResults");

        final List<OperationForecastResultResponse> embeddedAssignments = assignments
            .stream()
            .map(this::getOperationForecastResultResponse)
            .collect(Collectors.toList());

        response.setEmbedded(embeddedAssignments);

        return response;
    }
}