////////////////////////////////////////////////////////////////////////////////
//
// Created by MJesser on 10.01.2018.
//
// Copyright (c) 2006 - 2018 FORCAM GmbH. All rights reserved.
////////////////////////////////////////////////////////////////////////////////
package com.forcam.na.ffwebservices.client.statusdefinition;

import com.forcam.na.ffwebservices.client.api.AbstractResponseBuilder;
import com.forcam.na.ffwebservices.client.api.HALCollectionWSModel;
import com.forcam.na.ffwebservices.client.api.HALWSModel;
import com.forcam.na.ffwebservices.client.api.literal.LiteralLinkModelBuilder;
import com.forcam.na.ffwebservices.client.api.pagination.response.CollectionResponse;
import com.forcam.na.ffwebservices.client.statusdefinition.request.GetOperatingStateCollectionRequest;
import com.forcam.na.ffwebservices.model.LinkEmbeddedWSModel;
import com.forcam.na.ffwebservices.model.literal.LiteralPropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateEmbed;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStatePropertiesWSModel;
import com.forcam.na.ffwebservices.model.statusdefinition.OperatingStateResponse;
import com.forcam.na.ffwebservices.model.statusdefinition.StatusDefinitionPropertiesWSModel;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Builds responses for operating states.
 */
public class OperatingStateResponseBuilder extends AbstractResponseBuilder implements IOperatingStateResponseBuilder {

    // ------------------------------------------------------------------------
    // members
    // ------------------------------------------------------------------------

    /** The link model builder of a status definition. */
    private final StatusDefinitionLinkModelBuilder mStatusDefinitionLinkModelBuilder;

    /** The link model builder of a literal. */
    private final LiteralLinkModelBuilder mLiteralLinkModelBuilder;

    // ------------------------------------------------------------------------
    // constructors
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance.
     *
     * @param literalLinkModelBuilder          Literal link model builder.
     * @param statusDefinitionLinkModelBuilder Status definition link model builder.
     */
    @Inject
    public OperatingStateResponseBuilder(StatusDefinitionLinkModelBuilder statusDefinitionLinkModelBuilder, LiteralLinkModelBuilder literalLinkModelBuilder) {
        mStatusDefinitionLinkModelBuilder = statusDefinitionLinkModelBuilder;
        mLiteralLinkModelBuilder = literalLinkModelBuilder;
    }

    // ------------------------------------------------------------------------
    // methods
    // ------------------------------------------------------------------------

    @Override
    public CollectionResponse<OperatingStateResponse> getOperatingStateCollectionResponse(GetOperatingStateCollectionRequest request,
                                                                                          HALCollectionWSModel collectionModel) {
        final CollectionResponse<OperatingStateResponse> collectionResponse = new CollectionResponse<>(request);
        this.initializeCollectionResponse(collectionModel, collectionResponse);

        final Map<String, List<HALWSModel>> embedded = collectionModel.getEmbedded();
        final List<HALWSModel> operatingStates = embedded.get("operatingStates");

        final List<OperatingStateResponse> operatingStateModels = operatingStates
            .stream()
            .map(this::getOperatingStateResponse)
            .collect(Collectors.toList());

        collectionResponse.setEmbedded(operatingStateModels);
        return collectionResponse;
    }

    @Override
    public OperatingStateResponse getOperatingStateResponse(HALWSModel serverModel) {
        final OperatingStateResponse operatingStateModel = new OperatingStateResponse();
        final OperatingStatePropertiesWSModel properties = mMapper.convertValue(serverModel.getProperties(), OperatingStatePropertiesWSModel.class);
        operatingStateModel.setProperties(properties);

        final LinkEmbeddedWSModel<Object> selfLink = this.createSelfLinkModel(serverModel);
        operatingStateModel.setSelf(selfLink);

        final LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> operatingStateClass = mStatusDefinitionLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                            OperatingStateEmbed.OPERATING_STATE_CLASS);
        operatingStateModel.setOperatingStateClass(operatingStateClass);

        final LinkEmbeddedWSModel<StatusDefinitionPropertiesWSModel> workplaceState = mStatusDefinitionLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                                       OperatingStateEmbed.WORKPLACE_STATE);
        operatingStateModel.setWorkplaceState(workplaceState);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> description = mLiteralLinkModelBuilder.buildLinkModel(serverModel, OperatingStateEmbed.DESCRIPTION);
        operatingStateModel.setDescription(description);

        final LinkEmbeddedWSModel<LiteralPropertiesWSModel> shortDescription = mLiteralLinkModelBuilder.buildLinkModel(serverModel,
                                                                                                                       OperatingStateEmbed.SHORT_DESCRIPTION);
        operatingStateModel.setShortDescription(shortDescription);

        return operatingStateModel;
    }
}