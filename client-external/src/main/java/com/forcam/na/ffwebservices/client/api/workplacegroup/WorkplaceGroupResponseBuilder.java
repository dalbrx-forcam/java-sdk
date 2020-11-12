////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 28.02.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.workplacegroup;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.erpcontext.ERPContextLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.request.CollectionRequest;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.workplacegroup.request.GetWorkplaceGroupsRequest;
import com.forcam.na.ffwebservices.client.api.workplacegroup.response.WorkplaceGroupSetupTransitionsResponse;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.erpcontext.ErpContextPropertiesWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.SetupTransitionRulePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.SetupTransitionsPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupEmbed;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRulePropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupManufacturingVariantRuleResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupPropertiesWSModel;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupResponse;
import com.forcam.na.ffwebservices.model.workplacegroup.WorkplaceGroupSetupTransitionRuleResponse;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for workplace groups.
 */
public class WorkplaceGroupResponseBuilder extends AbstractResponseBuilder implements IWorkplaceGroupResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder for an ERP context. */
    private final ERPContextLinkModelBuilder mERPContextLinkModelBuilder;

    /**
     * Creates a new instance.
     *
     * @param literalLinkModelBuilder    Literal link model builder.
     * @param erpContextLinkModelBuilder ERP context link model builder.
     */
    @Inject
    public WorkplaceGroupResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder, ERPContextLinkModelBuilder erpContextLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mERPContextLinkModelBuilder = erpContextLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<WorkplaceGroupResponse> getWorkplaceGroupCollectionResponse(GetWorkplaceGroupsRequest request,
                                                                                          HALCollectionWSModel collectionModel) {
        final CollectionResponse<WorkplaceGroupResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> workplaceGroups = embedded.get("workplaceGroups");

        final List<WorkplaceGroupResponse> workplaceGroupModels = workplaceGroups
            .stream()
            .map(this::getWorkplaceGroupResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(workplaceGroupModels);
        return collectionResponse;
    }

    @Override
    public WorkplaceGroupResponse getWorkplaceGroupResponse(HALWSModel serverModel) {
        final WorkplaceGroupResponse workplaceGroupModel = new WorkplaceGroupResponse();
        final WorkplaceGroupPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), WorkplaceGroupPropertiesWSModel.class);
        workplaceGroupModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        workplaceGroupModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, WorkplaceGroupEmbed.DESCRIPTION);
        workplaceGroupModel.setDescription(description);

        final LinkEmbeddedWSModel<ErpContextPropertiesWSModel> erpContext = mERPContextLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       WorkplaceGroupEmbed.ERP_CONTEXT);
        workplaceGroupModel.setErpContext(erpContext);

        /*
        final LinkEmbeddedWSModel<WorkplaceCollectionResponse> workplaces = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel, WorkplaceGroupEmbed.WORKPLACES);
        workplaceGroupModel.setWorkplaces(workplaces);
        */

        return workplaceGroupModel;
    }

    @Override
    public CollectionResponse<WorkplaceGroupSetupTransitionRuleResponse> getWorkplaceGroupSetupTransitionRuleResponseCollectionResponse(
        CollectionRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<WorkplaceGroupSetupTransitionRuleResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> setupTransitionRules = embedded.get("setupTransitionRules");

        final List<WorkplaceGroupSetupTransitionRuleResponse> setupTransitionRuleResponses = setupTransitionRules
            .stream()
            .map(this::getWorkplaceGroupSetupTransitionRuleResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(setupTransitionRuleResponses);
        return collectionResponse;
    }

    @Override
    public WorkplaceGroupSetupTransitionRuleResponse getWorkplaceGroupSetupTransitionRuleResponse(HALWSModel serverModel) {
        final WorkplaceGroupSetupTransitionRuleResponse response = new WorkplaceGroupSetupTransitionRuleResponse();
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), SetupTransitionRulePropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public WorkplaceGroupSetupTransitionsResponse getWorkplaceGroupSetupTransitionsResponse(CollectionRequest request, HALWSModel serverModel) {
        final WorkplaceGroupSetupTransitionsResponse response = new WorkplaceGroupSetupTransitionsResponse(request);
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), SetupTransitionsPropertiesWSModel.class));
        response.setPaginationLinks(serverModel.getLinkModels());
        response.setPagination(serverModel.getPagination());

        return response;
    }

    @Override
    public WorkplaceGroupManufacturingVariantRuleResponse getWorkplaceGroupManufacturingVariantRuleResponse(HALWSModel serverModel) {
        final WorkplaceGroupManufacturingVariantRuleResponse response = new WorkplaceGroupManufacturingVariantRuleResponse();
        response.setProperties(mMapper.convertValue(serverModel.getProperties(), WorkplaceGroupManufacturingVariantRulePropertiesWSModel.class));

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        response.setSelf(selfLink);

        return response;
    }

    @Override
    public CollectionResponse<WorkplaceGroupManufacturingVariantRuleResponse> getWorkplaceGroupManufacturingVariantRuleResponseCollectionResponse(
        CollectionRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<WorkplaceGroupManufacturingVariantRuleResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> manufacturingVariantRules = embedded.get("manufacturingVariantRules");

        final List<WorkplaceGroupManufacturingVariantRuleResponse> manufacturingVariantRuleResponses = manufacturingVariantRules
            .stream()
            .map(this::getWorkplaceGroupManufacturingVariantRuleResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(manufacturingVariantRuleResponses);
        return collectionResponse;
    }
}