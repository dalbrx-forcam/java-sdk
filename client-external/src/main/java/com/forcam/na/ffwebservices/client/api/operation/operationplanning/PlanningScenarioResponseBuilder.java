////////////////////////////////////////////////////////////////////////////////
//
// Created by abhishekmundewal on 28-May-18.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.operation.operationplanning;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.request.GetPlanningScenariosRequest;
import com.forcam.na.ffwebservices.client.api.operation.operationplanning.response.PlanningScenarioWithAssignmentsResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenarioPropertiesWSModel;
import com.forcam.na.ffwebservices.model.operation.OperationPlanningScenariosPropertiesWSModel;
import com.forcam.na.ffwebservices.model.planningscenarioassignment.PlanningScenarioResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Planning scenario response builder.
 */
public class PlanningScenarioResponseBuilder extends AbstractResponseBuilder implements IPlanningScenarioResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public PlanningScenarioResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<PlanningScenarioResponse> getPlanningScenarioCollectionResponse(GetPlanningScenariosRequest request,
                                                                                              HALCollectionWSModel collectionModel) {
        final CollectionResponse<PlanningScenarioResponse> collectionResponse = new CollectionResponse<>(request);
        super.initializeCollectionResponse(collectionModel, collectionResponse);
        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> planningScenarios = embedded.get("planningScenarios");

        final List<PlanningScenarioResponse> scenarioResponse = planningScenarios
            .stream()
            .map(this::getPlanningScenarioResponse)
            .collect(Collectors.toList());
        collectionResponse.setEmbedded(scenarioResponse);

        return collectionResponse;
    }

    @Override
    public PlanningScenarioResponse getPlanningScenarioResponse(HALWSModel serverModel) {
        final PlanningScenarioResponse response = new PlanningScenarioResponse();
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationPlanningScenariosPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public PlanningScenarioWithAssignmentsResponse getPlanningScenarioWithAssignmentsResponse(CollectionRequest request, HALWSModel serverModel) {
        final PlanningScenarioWithAssignmentsResponse response = new PlanningScenarioWithAssignmentsResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), OperationPlanningScenarioPropertiesWSModel.class));
        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());
        return response;
    }
}
