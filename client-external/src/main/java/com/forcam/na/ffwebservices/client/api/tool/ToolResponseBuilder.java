////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 20.12.2017.
//
// Copyright (c) 2006 - 2017 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.api.tool;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.api.tool.request.GetToolsRequest;
import com.forcam.na.ffwebservices.client.api.workplace.WorkplaceLinkModelBuilder;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolEmbed;
import com.forcam.na.ffwebservices.model.tool.ToolLocationGeneralDefinitionWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolPropertiesWSModel;
import com.forcam.na.ffwebservices.model.tool.ToolResponse;
import com.forcam.na.ffwebservices.model.workplace.WorkplacePropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for tools.
 */
public class ToolResponseBuilder extends AbstractResponseBuilder implements IToolResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    /** The link model builder of the workplace. */
    private final WorkplaceLinkModelBuilder mWorkplaceLinkModelBuilder;

    /** The link model builder for tool locations. */
    private final ToolLocationLinkModelBuilder mToolLocationLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param literalLinkModelBuilder      Literal link model builder.
     * @param workplaceLinkModelBuilder    Workplace link model builder.
     * @param toolLocationLinkModelBuilder The tool location link model builder.
     */
    @Inject
    public ToolResponseBuilder(LiteralLinkModelBuilder literalLinkModelBuilder, WorkplaceLinkModelBuilder workplaceLinkModelBuilder,
                               ToolLocationLinkModelBuilder toolLocationLinkModelBuilder) {
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
        mWorkplaceLinkModelBuilder = workplaceLinkModelBuilder;
        mToolLocationLinkModelBuilder = toolLocationLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<ToolResponse> getToolCollectionResponse(GetToolsRequest request, HALCollectionWSModel collectionModel) {
        final CollectionResponse<ToolResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> tools = embedded.get("tools");

        final List<ToolResponse> toolModels = tools
            .stream()
            .map(this::getToolResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(toolModels);
        return collectionResponse;
    }

    @Override
    public ToolResponse getToolResponse(HALWSModel serverModel) {
        final ToolResponse toolModel = new ToolResponse();
        final ToolPropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), ToolPropertiesWSModel.class);
        toolModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        toolModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> edge = mLiteralLinkModelBuilder.buildLinkModel(serverModel, ToolEmbed.DESCRIPTION);
        toolModel.setDescription(edge);

        final LinkEmbeddedWSModel<WorkplacePropertiesWSModel> workplace = mWorkplaceLinkModelBuilder.buildLinkModel(serverModel, ToolEmbed.WORKPLACE);
        toolModel.setWorkplace(workplace);

        final LinkEmbeddedWSModel<ToolLocationGeneralDefinitionWSModel> toolLocation = mToolLocationLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                    ToolEmbed.LOCATION);
        toolModel.setLocation(toolLocation);

        return toolModel;
    }
}