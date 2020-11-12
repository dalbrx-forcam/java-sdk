////////////////////////////////////////////////////////////////////////////////
//
// Created by NUebele on 12.11.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////

package com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionTimestampRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningResultsRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.request.GetStaffMemberPlanningScenarioCollectionRequest;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberPlanningScenarioResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMemberShiftPlanningResultResponse;
import com.forcam.na.ffwebservices.client.api.staffmember.staffmemberplanning.response.StaffMembersPlanningResultsResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.staffmember.EmbeddedStaffMemberPlanningScenarioResponse;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningResultCollectionProperties;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningResultPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningScenarioPropertiesWSModel;
import com.forcam.na.ffwebservices.model.staffmember.StaffMemberPlanningScenariosPropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Staff member planning response builder.
 */
public class StaffMemberPlanningResponseBuilder extends AbstractResponseBuilder implements IStaffMemberPlanningResponseBuilder {

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    @Inject
    public StaffMemberPlanningResponseBuilder() {
        //empty
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<EmbeddedStaffMemberPlanningScenarioResponse> getStaffMemberPlanningScenarioCollectionResponse(
            GetStaffMemberPlanningScenarioCollectionRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<EmbeddedStaffMemberPlanningScenarioResponse> collectionResponse = new CollectionResponse<>(request);
        super.initializeCollectionResponse(collectionModel, collectionResponse);
        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> planningScenarios = embedded.get("planningScenarios");

        final List<EmbeddedStaffMemberPlanningScenarioResponse> scenarioResponse = planningScenarios
            .stream()
            .map(this::getEmbeddedStaffMemberPlanningScenarioResponse)
            .collect(Collectors.toList());
        collectionResponse.setEmbedded(scenarioResponse);

        return collectionResponse;
    }

    @Override
    public EmbeddedStaffMemberPlanningScenarioResponse getEmbeddedStaffMemberPlanningScenarioResponse(HALWSModel serverModel) {
        final EmbeddedStaffMemberPlanningScenarioResponse response = new EmbeddedStaffMemberPlanningScenarioResponse();
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), StaffMemberPlanningScenariosPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public StaffMemberPlanningScenarioResponse getStaffMemberPlanningScenarioResponse(CollectionTimestampRequest request, HALWSModel serverModel) {
        final StaffMemberPlanningScenarioResponse response = new StaffMemberPlanningScenarioResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), StaffMemberPlanningScenarioPropertiesWSModel.class));
        response.setPagination(serverModel.getPagination());
        response.setPaginationLinks(serverModel.getLinkModels());
        return response;
    }

    @Override
    public StaffMemberShiftPlanningResultResponse getStaffMemberShiftPlanningResultResponse(HALWSModel serverModel) {
        final StaffMemberShiftPlanningResultResponse response = new StaffMemberShiftPlanningResultResponse();
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), StaffMemberPlanningResultPropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public StaffMembersPlanningResultsResponse getStaffMembersPlanningResultsResponse(CollectionTimestampRequest request, HALWSModel collectionModel) {
        final StaffMembersPlanningResultsResponse response = new StaffMembersPlanningResultsResponse(request);
        response.setProperties(mMapper.convertValue(collectionModel.getProperties(), StaffMemberPlanningResultCollectionProperties.class));
        response.setPagination(collectionModel.getPagination());
        response.setPaginationLinks(collectionModel.getLinkModels());

        return response;
    }

    @Override
    public CollectionResponse<StaffMemberShiftPlanningResultResponse> getStaffMemberShiftPlanningResultCollection(GetStaffMemberPlanningResultsRequest request,
                                                                                                                  HALCollectionWSModel collectionModel) {
        final CollectionResponse<StaffMemberShiftPlanningResultResponse> collectionResponse = new CollectionResponse<>(request);
        super.initializeCollectionResponse(collectionModel, collectionResponse);
        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> planningResults = embedded.get("planningResults");

        final List<StaffMemberShiftPlanningResultResponse> planningResultResponses = planningResults
            .stream()
            .map(this::getStaffMemberShiftPlanningResultResponse)
            .collect(Collectors.toList());
        collectionResponse.setEmbedded(planningResultResponses);

        return collectionResponse;
    }
}